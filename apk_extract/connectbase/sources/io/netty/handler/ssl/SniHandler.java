package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.util.AsyncMapping;
import io.netty.util.DomainNameMapping;
import io.netty.util.Mapping;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import m.a;

/* JADX INFO: loaded from: classes3.dex */
public class SniHandler extends AbstractSniHandler<SslContext> {
    private static final Selection EMPTY_SELECTION = new Selection(null, null);
    protected final AsyncMapping<String, SslContext> mapping;
    private volatile Selection selection;

    public static final class AsyncMappingAdapter implements AsyncMapping<String, SslContext> {
        private final Mapping<? super String, ? extends SslContext> mapping;

        private AsyncMappingAdapter(Mapping<? super String, ? extends SslContext> mapping) {
            this.mapping = (Mapping) ObjectUtil.checkNotNull(mapping, "mapping");
        }

        @Override // io.netty.util.AsyncMapping
        public Future<SslContext> map(String str, Promise<SslContext> promise) {
            try {
                return promise.setSuccess(this.mapping.map(str));
            } catch (Throwable th2) {
                return promise.setFailure(th2);
            }
        }
    }

    public static final class Selection {
        final SslContext context;
        final String hostname;

        public Selection(SslContext sslContext, String str) {
            this.context = sslContext;
            this.hostname = str;
        }
    }

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping) {
        this(new AsyncMappingAdapter(mapping));
    }

    public String hostname() {
        return this.selection.hostname;
    }

    @Override // io.netty.handler.ssl.AbstractSniHandler
    public Future<SslContext> lookup(ChannelHandlerContext channelHandlerContext, String str) throws Exception {
        return this.mapping.map(str, channelHandlerContext.executor().newPromise());
    }

    public SslHandler newSslHandler(SslContext sslContext, ByteBufAllocator byteBufAllocator) {
        SslHandler sslHandlerNewHandler = sslContext.newHandler(byteBufAllocator);
        sslHandlerNewHandler.setHandshakeTimeoutMillis(this.handshakeTimeoutMillis);
        return sslHandlerNewHandler;
    }

    @Override // io.netty.handler.ssl.AbstractSniHandler
    public final void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<SslContext> future) throws Exception {
        if (!future.isSuccess()) {
            Throwable thCause = future.cause();
            if (!(thCause instanceof Error)) {
                throw new DecoderException(a.a("failed to get the SslContext for ", str), thCause);
            }
            throw ((Error) thCause);
        }
        SslContext now = future.getNow();
        this.selection = new Selection(now, str);
        try {
            replaceHandler(channelHandlerContext, str, now);
        } catch (Throwable th2) {
            this.selection = EMPTY_SELECTION;
            PlatformDependent.throwException(th2);
        }
    }

    public void replaceHandler(ChannelHandlerContext channelHandlerContext, String str, SslContext sslContext) throws Exception {
        SslHandler sslHandlerNewSslHandler = null;
        try {
            sslHandlerNewSslHandler = newSslHandler(sslContext, channelHandlerContext.alloc());
            channelHandlerContext.pipeline().replace(this, SslHandler.class.getName(), sslHandlerNewSslHandler);
        } catch (Throwable th2) {
            if (sslHandlerNewSslHandler != null) {
                ReferenceCountUtil.safeRelease(sslHandlerNewSslHandler.engine());
            }
            throw th2;
        }
    }

    public SslContext sslContext() {
        return this.selection.context;
    }

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping, int i10, long j10) {
        this(new AsyncMappingAdapter(mapping), i10, j10);
    }

    public SniHandler(DomainNameMapping<? extends SslContext> domainNameMapping) {
        this((Mapping<? super String, ? extends SslContext>) domainNameMapping);
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> asyncMapping) {
        this(asyncMapping, 0, 0L);
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> asyncMapping, int i10, long j10) {
        super(i10, j10);
        this.selection = EMPTY_SELECTION;
        this.mapping = (AsyncMapping) ObjectUtil.checkNotNull(asyncMapping, "mapping");
    }

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping, long j10) {
        this(new AsyncMappingAdapter(mapping), j10);
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> asyncMapping, long j10) {
        this(asyncMapping, 0, j10);
    }
}
