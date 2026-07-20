package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j1.g;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class Http2ConnectionHandler extends ByteToMessageDecoder implements Http2LifecycleManager, ChannelOutboundHandler {
    private BaseDecoder byteDecoder;
    private ChannelFutureListener closeListener;
    private final Http2ConnectionDecoder decoder;
    private final boolean decoupleCloseAndGoAway;
    private final Http2ConnectionEncoder encoder;
    private final boolean flushPreface;
    private long gracefulShutdownTimeoutMillis;
    private final Http2Settings initialSettings;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2ConnectionHandler.class);
    private static final Http2Headers HEADERS_TOO_LARGE_HEADERS = ReadOnlyHttp2Headers.serverHeaders(false, HttpResponseStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.codeAsText(), new AsciiString[0]);
    private static final ByteBuf HTTP_1_X_BUF = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[]{72, 84, 84, 80, 47, 49, 46})).asReadOnly();

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.Http2ConnectionHandler$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract class BaseDecoder {
        private BaseDecoder() {
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            Http2ConnectionHandler.this.encoder().close();
            Http2ConnectionHandler.this.decoder().close();
            Http2ConnectionHandler.this.connection().close(channelHandlerContext.voidPromise());
        }

        public abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        public boolean prefaceSent() {
            return true;
        }
    }

    public static final class ClosingChannelFutureListener implements ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean closed;
        private final ChannelHandlerContext ctx;
        private final ChannelPromise promise;
        private final Future<?> timeoutTask;

        public ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doClose() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ChannelPromise channelPromise = this.promise;
            if (channelPromise == null) {
                this.ctx.close();
            } else {
                this.ctx.close(channelPromise);
            }
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            Future<?> future = this.timeoutTask;
            if (future != null) {
                future.cancel(false);
            }
            doClose();
        }

        public ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, long j10, TimeUnit timeUnit) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.ClosingChannelFutureListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ClosingChannelFutureListener.this.doClose();
                }
            }, j10, timeUnit);
        }
    }

    public final class FrameDecoder extends BaseDecoder {
        private FrameDecoder() {
            super();
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                Http2ConnectionHandler.this.decoder.decodeFrame(channelHandlerContext, byteBuf, list);
            } catch (Throwable th2) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, false, th2);
            }
        }
    }

    public final class PrefaceDecoder extends BaseDecoder {
        private ByteBuf clientPrefaceString;
        private boolean prefaceSent;

        public PrefaceDecoder(ChannelHandlerContext channelHandlerContext) throws Exception {
            super();
            this.clientPrefaceString = Http2ConnectionHandler.clientPrefaceString(Http2ConnectionHandler.this.encoder.connection());
            sendPreface(channelHandlerContext);
        }

        private void cleanup() {
            ByteBuf byteBuf = this.clientPrefaceString;
            if (byteBuf != null) {
                byteBuf.release();
                this.clientPrefaceString = null;
            }
        }

        private boolean readClientPrefaceString(ByteBuf byteBuf) throws Http2Exception {
            ByteBuf byteBuf2 = this.clientPrefaceString;
            if (byteBuf2 == null) {
                return true;
            }
            int iMin = Math.min(byteBuf.readableBytes(), byteBuf2.readableBytes());
            if (iMin != 0) {
                int i10 = byteBuf.readerIndex();
                ByteBuf byteBuf3 = this.clientPrefaceString;
                if (ByteBufUtil.equals(byteBuf, i10, byteBuf3, byteBuf3.readerIndex(), iMin)) {
                    byteBuf.skipBytes(iMin);
                    this.clientPrefaceString.skipBytes(iMin);
                    if (this.clientPrefaceString.isReadable()) {
                        return false;
                    }
                    this.clientPrefaceString.release();
                    this.clientPrefaceString = null;
                    return true;
                }
            }
            int iIndexOf = ByteBufUtil.indexOf(Http2ConnectionHandler.HTTP_1_X_BUF, byteBuf.slice(byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), 1024)));
            if (iIndexOf != -1) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Unexpected HTTP/1.x request: %s", byteBuf.toString(byteBuf.readerIndex(), iIndexOf - byteBuf.readerIndex(), CharsetUtil.US_ASCII));
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP/2 client preface string missing or corrupt. Hex dump for received bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), this.clientPrefaceString.readableBytes())));
        }

        private void sendPreface(ChannelHandlerContext channelHandlerContext) throws Exception {
            if (this.prefaceSent || !channelHandlerContext.channel().isActive()) {
                return;
            }
            this.prefaceSent = true;
            boolean zIsServer = Http2ConnectionHandler.this.connection().isServer();
            if (!zIsServer) {
                channelHandlerContext.write(Http2CodecUtil.connectionPrefaceBuf()).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            }
            Http2ConnectionHandler.this.encoder.writeSettings(channelHandlerContext, Http2ConnectionHandler.this.initialSettings, channelHandlerContext.newPromise()).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            if (zIsServer) {
                return;
            }
            Http2ConnectionHandler.this.userEventTriggered(channelHandlerContext, Http2ConnectionPrefaceAndSettingsFrameWrittenEvent.INSTANCE);
        }

        private boolean verifyFirstFrameIsSettings(ByteBuf byteBuf) throws Http2Exception {
            if (byteBuf.readableBytes() < 5) {
                return false;
            }
            short unsignedByte = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 3);
            short unsignedByte2 = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 4);
            if (unsignedByte == 4 && (unsignedByte2 & 1) == 0) {
                return true;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "First received frame was not SETTINGS. Hex dump for first 5 bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), 5));
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            sendPreface(channelHandlerContext);
            if (Http2ConnectionHandler.this.flushPreface) {
                channelHandlerContext.flush();
            }
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
            super.channelInactive(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                if (channelHandlerContext.channel().isActive() && readClientPrefaceString(byteBuf) && verifyFirstFrameIsSettings(byteBuf)) {
                    Http2ConnectionHandler http2ConnectionHandler = Http2ConnectionHandler.this;
                    http2ConnectionHandler.byteDecoder = new FrameDecoder();
                    Http2ConnectionHandler.this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
                }
            } catch (Throwable th2) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, false, th2);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public boolean prefaceSent() {
            return this.prefaceSent;
        }
    }

    public Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, false);
    }

    private void checkCloseConnection(ChannelFuture channelFuture) {
        if (this.closeListener == null || !isGracefulShutdownComplete()) {
            return;
        }
        ChannelFutureListener channelFutureListener = this.closeListener;
        this.closeListener = null;
        try {
            channelFutureListener.operationComplete(channelFuture);
        } catch (Exception e10) {
            throw new IllegalStateException("Close listener threw an unexpected exception", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteBuf clientPrefaceString(Http2Connection http2Connection) {
        if (http2Connection.isServer()) {
            return Http2CodecUtil.connectionPrefaceBuf();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeConnectionOnError(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            return;
        }
        onConnectionError(channelHandlerContext, true, channelFuture.cause(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCloseStream(Http2Stream http2Stream, ChannelFuture channelFuture) {
        http2Stream.close();
        checkCloseConnection(channelFuture);
    }

    private void doGracefulShutdown(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, ChannelPromise channelPromise) {
        final ChannelFutureListener channelFutureListenerNewClosingChannelFutureListener = newClosingChannelFutureListener(channelHandlerContext, channelPromise);
        if (isGracefulShutdownComplete()) {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) channelFutureListenerNewClosingChannelFutureListener);
            return;
        }
        final ChannelFutureListener channelFutureListener = this.closeListener;
        if (channelFutureListener == null) {
            this.closeListener = channelFutureListenerNewClosingChannelFutureListener;
        } else if (channelPromise != null) {
            this.closeListener = new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    try {
                        channelFutureListener.operationComplete(channelFuture2);
                    } finally {
                        channelFutureListenerNewClosingChannelFutureListener.operationComplete(channelFuture2);
                    }
                }
            };
        }
    }

    private ChannelFutureListener newClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        long j10 = this.gracefulShutdownTimeoutMillis;
        return j10 < 0 ? new ClosingChannelFutureListener(channelHandlerContext, channelPromise) : new ClosingChannelFutureListener(channelHandlerContext, channelPromise, j10, TimeUnit.MILLISECONDS);
    }

    private boolean prefaceSent() {
        BaseDecoder baseDecoder = this.byteDecoder;
        return baseDecoder != null && baseDecoder.prefaceSent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processGoAwayWriteResult(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf, ChannelFuture channelFuture) {
        try {
            if (!channelFuture.isSuccess()) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("{} Sending GOAWAY failed: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i10), Long.valueOf(j10), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                }
                channelHandlerContext.close();
            } else if (j10 != Http2Error.NO_ERROR.code()) {
                InternalLogger internalLogger2 = logger;
                if (internalLogger2.isDebugEnabled()) {
                    internalLogger2.debug("{} Sent GOAWAY: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i10), Long.valueOf(j10), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                }
                channelHandlerContext.close();
            }
        } finally {
            byteBuf.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRstStreamWriteResult(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            closeStream(http2Stream, channelFuture);
        } else {
            onConnectionError(channelHandlerContext, true, channelFuture.cause(), null);
        }
    }

    private ChannelFuture resetUnknownStream(final ChannelHandlerContext channelHandlerContext, int i10, long j10, ChannelPromise channelPromise) {
        ChannelFuture channelFutureWriteRstStream = frameWriter().writeRstStream(channelHandlerContext, i10, j10, channelPromise);
        if (channelFutureWriteRstStream.isDone()) {
            closeConnectionOnError(channelHandlerContext, channelFutureWriteRstStream);
        } else {
            channelFutureWriteRstStream.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.3
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Http2ConnectionHandler.this.closeConnectionOnError(channelHandlerContext, channelFuture);
                }
            });
        }
        return channelFutureWriteRstStream;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.byteDecoder == null) {
            this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
        }
        this.byteDecoder.channelActive(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.channelInactive(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            channelReadComplete0(channelHandlerContext);
        } finally {
            flush(channelHandlerContext);
        }
    }

    public final void channelReadComplete0(ChannelHandlerContext channelHandlerContext) {
        discardSomeReadBytes();
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            if (channelHandlerContext.channel().isWritable()) {
                flush(channelHandlerContext);
            }
            this.encoder.flowController().channelWritabilityChanged();
        } finally {
            super.channelWritabilityChanged(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        if (this.decoupleCloseAndGoAway) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        ChannelPromise channelPromiseUnvoid = channelPromise.unvoid();
        if (!channelHandlerContext.channel().isActive() || !prefaceSent()) {
            channelHandlerContext.close(channelPromiseUnvoid);
            return;
        }
        ChannelFuture channelFutureWrite = connection().goAwaySent() ? channelHandlerContext.write(Unpooled.EMPTY_BUFFER) : goAway(channelHandlerContext, null, channelHandlerContext.newPromise());
        channelHandlerContext.flush();
        doGracefulShutdown(channelHandlerContext, channelFutureWrite, channelPromiseUnvoid);
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStream(final Http2Stream http2Stream, ChannelFuture channelFuture) {
        if (channelFuture.isDone()) {
            doCloseStream(http2Stream, channelFuture);
        } else {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) {
                    Http2ConnectionHandler.this.doCloseStream(http2Stream, channelFuture2);
                }
            });
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStreamLocal(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i10 = AnonymousClass6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i10 == 1 || i10 == 2) {
            http2Stream.closeLocalSide();
        } else {
            closeStream(http2Stream, channelFuture);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStreamRemote(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i10 = AnonymousClass6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i10 == 2 || i10 == 3) {
            http2Stream.closeRemoteSide();
        } else {
            closeStream(http2Stream, channelFuture);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    public Http2Connection connection() {
        return this.encoder.connection();
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
    }

    public Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    public Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        if (Http2CodecUtil.getEmbeddedHttp2Exception(th2) != null) {
            onError(channelHandlerContext, false, th2);
        } else {
            super.exceptionCaught(channelHandlerContext, th2);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        try {
            this.encoder.flowController().writePendingBytes();
            channelHandlerContext.flush();
        } catch (Http2Exception e10) {
            onError(channelHandlerContext, true, e10);
        } catch (Throwable th2) {
            onError(channelHandlerContext, true, Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "Error flushing", new Object[0]));
        }
    }

    public Http2FrameWriter frameWriter() {
        return encoder().frameWriter();
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public ChannelFuture goAway(final ChannelHandlerContext channelHandlerContext, final int i10, final long j10, final ByteBuf byteBuf, ChannelPromise channelPromise) {
        ChannelPromise channelPromiseUnvoid = channelPromise.unvoid();
        try {
            if (!connection().goAwaySent(i10, j10, byteBuf)) {
                byteBuf.release();
                channelPromiseUnvoid.trySuccess();
                return channelPromiseUnvoid;
            }
            byteBuf.retain();
            ChannelFuture channelFutureWriteGoAway = frameWriter().writeGoAway(channelHandlerContext, i10, j10, byteBuf, channelPromiseUnvoid);
            if (channelFutureWriteGoAway.isDone()) {
                processGoAwayWriteResult(channelHandlerContext, i10, j10, byteBuf, channelFutureWriteGoAway);
            } else {
                channelFutureWriteGoAway.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.5
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        Http2ConnectionHandler.processGoAwayWriteResult(channelHandlerContext, i10, j10, byteBuf, channelFuture);
                    }
                });
            }
            return channelFutureWriteGoAway;
        } catch (Throwable th2) {
            byteBuf.release();
            channelPromiseUnvoid.tryFailure(th2);
            return channelPromiseUnvoid;
        }
    }

    public long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    public void handleServerHeaderDecodeSizeError(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream) {
        encoder().writeHeaders(channelHandlerContext, http2Stream.id(), HEADERS_TOO_LARGE_HEADERS, 0, true, channelHandlerContext.newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.lifecycleManager(this);
        this.decoder.lifecycleManager(this);
        this.encoder.flowController().channelHandlerContext(channelHandlerContext);
        this.decoder.flowController().channelHandlerContext(channelHandlerContext);
        this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.handlerRemoved(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    public boolean isGracefulShutdownComplete() {
        return connection().numActiveStreams() == 0;
    }

    public void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z10, Throwable th2, Http2Exception http2Exception) {
        if (http2Exception == null) {
            http2Exception = new Http2Exception(Http2Error.INTERNAL_ERROR, th2.getMessage(), th2);
        }
        ChannelPromise channelPromiseNewPromise = channelHandlerContext.newPromise();
        ChannelFuture channelFutureGoAway = goAway(channelHandlerContext, http2Exception, channelHandlerContext.newPromise());
        if (http2Exception.shutdownHint() == Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN) {
            doGracefulShutdown(channelHandlerContext, channelFutureGoAway, channelPromiseNewPromise);
        } else {
            channelFutureGoAway.addListener((GenericFutureListener<? extends Future<? super Void>>) newClosingChannelFutureListener(channelHandlerContext, channelPromiseNewPromise));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void onError(ChannelHandlerContext channelHandlerContext, boolean z10, Throwable th2) {
        Http2Exception embeddedHttp2Exception = Http2CodecUtil.getEmbeddedHttp2Exception(th2);
        if (Http2Exception.isStreamError(embeddedHttp2Exception)) {
            onStreamError(channelHandlerContext, z10, th2, (Http2Exception.StreamException) embeddedHttp2Exception);
        } else if (embeddedHttp2Exception instanceof Http2Exception.CompositeStreamException) {
            Iterator<Http2Exception.StreamException> it = ((Http2Exception.CompositeStreamException) embeddedHttp2Exception).iterator();
            while (it.hasNext()) {
                onStreamError(channelHandlerContext, z10, th2, it.next());
            }
        } else {
            onConnectionError(channelHandlerContext, z10, th2, embeddedHttp2Exception);
        }
        channelHandlerContext.flush();
    }

    public void onHttpClientUpgrade() throws Http2Exception {
        if (connection().isServer()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client-side HTTP upgrade requested for a server", new Object[0]);
        }
        if (!prefaceSent()) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
        }
        if (this.decoder.prefaceReceived()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
        }
        connection().local().createStream(1, true);
    }

    public void onHttpServerUpgrade(Http2Settings http2Settings) throws Http2Exception {
        if (!connection().isServer()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server-side HTTP upgrade requested for a client", new Object[0]);
        }
        if (!prefaceSent()) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
        }
        if (this.decoder.prefaceReceived()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
        }
        this.encoder.remoteSettings(http2Settings);
        connection().remote().createStream(1, true);
    }

    public void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z10, Throwable th2, Http2Exception.StreamException streamException) {
        int iStreamId = streamException.streamId();
        Http2Stream http2StreamStream = connection().stream(iStreamId);
        if ((streamException instanceof Http2Exception.HeaderListSizeException) && ((Http2Exception.HeaderListSizeException) streamException).duringDecode() && connection().isServer()) {
            if (http2StreamStream == null) {
                try {
                    http2StreamStream = this.encoder.connection().remote().createStream(iStreamId, true);
                } catch (Http2Exception unused) {
                    resetUnknownStream(channelHandlerContext, iStreamId, streamException.error().code(), channelHandlerContext.newPromise());
                    return;
                }
            }
            if (http2StreamStream != null && !http2StreamStream.isHeadersSent()) {
                try {
                    handleServerHeaderDecodeSizeError(channelHandlerContext, http2StreamStream);
                } catch (Throwable th3) {
                    onError(channelHandlerContext, z10, Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th3, "Error DecodeSizeError", new Object[0]));
                }
            }
        }
        Http2Stream http2Stream = http2StreamStream;
        if (http2Stream != null) {
            resetStream(channelHandlerContext, http2Stream, streamException.error().code(), channelHandlerContext.newPromise());
        } else if (!z10 || connection().local().mayHaveCreatedStream(iStreamId)) {
            resetUnknownStream(channelHandlerContext, iStreamId, streamException.error().code(), channelHandlerContext.newPromise());
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public ChannelFuture resetStream(ChannelHandlerContext channelHandlerContext, int i10, long j10, ChannelPromise channelPromise) {
        Http2Stream http2StreamStream = connection().stream(i10);
        return http2StreamStream == null ? resetUnknownStream(channelHandlerContext, i10, j10, channelPromise.unvoid()) : resetStream(channelHandlerContext, http2StreamStream, j10, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.write(obj, channelPromise);
    }

    public Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z10) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z10, true);
    }

    public void gracefulShutdownTimeoutMillis(long j10) {
        if (j10 < -1) {
            throw new IllegalArgumentException(g.a("gracefulShutdownTimeoutMillis: ", j10, " (expected: -1 for indefinite or >= 0)"));
        }
        this.gracefulShutdownTimeoutMillis = j10;
    }

    public Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z10, boolean z11) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "initialSettings");
        this.decoder = (Http2ConnectionDecoder) ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.decoupleCloseAndGoAway = z10;
        this.flushPreface = z11;
        if (http2ConnectionEncoder.connection() != http2ConnectionDecoder.connection()) {
            throw new IllegalArgumentException("Encoder and Decoder do not share the same connection object");
        }
    }

    private ChannelFuture resetStream(final ChannelHandlerContext channelHandlerContext, final Http2Stream http2Stream, long j10, ChannelPromise channelPromise) {
        ChannelFuture success;
        ChannelPromise channelPromiseUnvoid = channelPromise.unvoid();
        if (http2Stream.isResetSent()) {
            return channelPromiseUnvoid.setSuccess();
        }
        http2Stream.resetSent();
        if (http2Stream.state() != Http2Stream.State.IDLE && (!connection().local().created(http2Stream) || http2Stream.isHeadersSent() || http2Stream.isPushPromiseSent())) {
            success = frameWriter().writeRstStream(channelHandlerContext, http2Stream.id(), j10, channelPromiseUnvoid);
        } else {
            success = channelPromiseUnvoid.setSuccess();
        }
        if (success.isDone()) {
            processRstStreamWriteResult(channelHandlerContext, http2Stream, success);
        } else {
            success.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.4
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Http2ConnectionHandler.this.processRstStreamWriteResult(channelHandlerContext, http2Stream, channelFuture);
                }
            });
        }
        return success;
    }

    private ChannelFuture goAway(ChannelHandlerContext channelHandlerContext, Http2Exception http2Exception, ChannelPromise channelPromise) {
        return goAway(channelHandlerContext, (http2Exception == null || http2Exception.shutdownHint() != Http2Exception.ShutdownHint.HARD_SHUTDOWN) ? connection().remote().lastStreamCreated() : Integer.MAX_VALUE, (http2Exception != null ? http2Exception.error() : Http2Error.NO_ERROR).code(), Http2CodecUtil.toByteBuf(channelHandlerContext, http2Exception), channelPromise);
    }
}
