package io.netty.handler.codec.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HttpServerUpgradeHandler extends HttpObjectAggregator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean handlingUpgrade;
    private final SourceCodec sourceCodec;
    private final UpgradeCodecFactory upgradeCodecFactory;
    private final boolean validateHeaders;

    public interface SourceCodec {
        void upgradeFrom(ChannelHandlerContext channelHandlerContext);
    }

    public interface UpgradeCodec {
        boolean prepareUpgradeResponse(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders);

        Collection<CharSequence> requiredUpgradeHeaders();

        void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest);
    }

    public interface UpgradeCodecFactory {
        UpgradeCodec newUpgradeCodec(CharSequence charSequence);
    }

    public static final class UpgradeEvent implements ReferenceCounted {
        private final CharSequence protocol;
        private final FullHttpRequest upgradeRequest;

        public UpgradeEvent(CharSequence charSequence, FullHttpRequest fullHttpRequest) {
            this.protocol = charSequence;
            this.upgradeRequest = fullHttpRequest;
        }

        public CharSequence protocol() {
            return this.protocol;
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.upgradeRequest.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.upgradeRequest.release();
        }

        public String toString() {
            return "UpgradeEvent [protocol=" + ((Object) this.protocol) + ", upgradeRequest=" + this.upgradeRequest + ']';
        }

        public FullHttpRequest upgradeRequest() {
            return this.upgradeRequest;
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release(int i10) {
            return this.upgradeRequest.release(i10);
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent retain() {
            this.upgradeRequest.retain();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent touch() {
            this.upgradeRequest.touch();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent retain(int i10) {
            this.upgradeRequest.retain(i10);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent touch(Object obj) {
            this.upgradeRequest.touch(obj);
            return this;
        }
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec, UpgradeCodecFactory upgradeCodecFactory) {
        this(sourceCodec, upgradeCodecFactory, 0);
    }

    private FullHttpResponse createUpgradeResponse(CharSequence charSequence) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, Unpooled.EMPTY_BUFFER, this.validateHeaders);
        defaultFullHttpResponse.headers().add(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE);
        defaultFullHttpResponse.headers().add(HttpHeaderNames.UPGRADE, charSequence);
        return defaultFullHttpResponse;
    }

    private static List<CharSequence> splitHeader(CharSequence charSequence) {
        StringBuilder sb2 = new StringBuilder(charSequence.length());
        ArrayList arrayList = new ArrayList(4);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (!Character.isWhitespace(cCharAt)) {
                if (cCharAt == ',') {
                    arrayList.add(sb2.toString());
                    sb2.setLength(0);
                } else {
                    sb2.append(cCharAt);
                }
            }
        }
        if (sb2.length() > 0) {
            arrayList.add(sb2.toString());
        }
        return arrayList;
    }

    private boolean upgrade(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        CharSequence charSequence;
        UpgradeCodec upgradeCodecNewUpgradeCodec;
        List<String> all;
        List<CharSequence> listSplitHeader = splitHeader(fullHttpRequest.headers().get(HttpHeaderNames.UPGRADE));
        int size = listSplitHeader.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                charSequence = null;
                upgradeCodecNewUpgradeCodec = null;
                break;
            }
            charSequence = listSplitHeader.get(i10);
            upgradeCodecNewUpgradeCodec = this.upgradeCodecFactory.newUpgradeCodec(charSequence);
            if (upgradeCodecNewUpgradeCodec != null) {
                break;
            }
            i10++;
        }
        if (upgradeCodecNewUpgradeCodec != null && (all = fullHttpRequest.headers().getAll(HttpHeaderNames.CONNECTION)) != null && !all.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(all.size() * 10);
            Iterator<String> it = all.iterator();
            while (it.hasNext()) {
                sb2.append((CharSequence) it.next());
                sb2.append(StringUtil.COMMA);
            }
            sb2.setLength(sb2.length() - 1);
            Collection<CharSequence> collectionRequiredUpgradeHeaders = upgradeCodecNewUpgradeCodec.requiredUpgradeHeaders();
            List<CharSequence> listSplitHeader2 = splitHeader(sb2);
            if (AsciiString.containsContentEqualsIgnoreCase(listSplitHeader2, HttpHeaderNames.UPGRADE) && AsciiString.containsAllContentEqualsIgnoreCase(listSplitHeader2, collectionRequiredUpgradeHeaders)) {
                Iterator<CharSequence> it2 = collectionRequiredUpgradeHeaders.iterator();
                while (it2.hasNext()) {
                    if (!fullHttpRequest.headers().contains(it2.next())) {
                        return false;
                    }
                }
                FullHttpResponse fullHttpResponseCreateUpgradeResponse = createUpgradeResponse(charSequence);
                if (!upgradeCodecNewUpgradeCodec.prepareUpgradeResponse(channelHandlerContext, fullHttpRequest, fullHttpResponseCreateUpgradeResponse.headers())) {
                    return false;
                }
                UpgradeEvent upgradeEvent = new UpgradeEvent(charSequence, fullHttpRequest);
                try {
                    ChannelFuture channelFutureWriteAndFlush = channelHandlerContext.writeAndFlush(fullHttpResponseCreateUpgradeResponse);
                    this.sourceCodec.upgradeFrom(channelHandlerContext);
                    upgradeCodecNewUpgradeCodec.upgradeTo(channelHandlerContext, fullHttpRequest);
                    channelHandlerContext.pipeline().remove(this);
                    channelHandlerContext.fireUserEventTriggered((Object) upgradeEvent.retain());
                    channelFutureWriteAndFlush.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
                    return true;
                } finally {
                    upgradeEvent.release();
                }
            }
        }
        return false;
    }

    @Override // io.netty.handler.codec.MessageAggregator, io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, Object obj, List list) throws Exception {
        decode(channelHandlerContext, (HttpObject) obj, (List<Object>) list);
    }

    public boolean shouldHandleUpgradeRequest(HttpRequest httpRequest) {
        return true;
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec, UpgradeCodecFactory upgradeCodecFactory, int i10) {
        this(sourceCodec, upgradeCodecFactory, i10, true);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        FullHttpRequest fullHttpRequest;
        if (!this.handlingUpgrade) {
            if (!(httpObject instanceof HttpRequest)) {
                ReferenceCountUtil.retain(httpObject);
                channelHandlerContext.fireChannelRead((Object) httpObject);
                return;
            }
            HttpRequest httpRequest = (HttpRequest) httpObject;
            if (!httpRequest.headers().contains(HttpHeaderNames.UPGRADE) || !shouldHandleUpgradeRequest(httpRequest)) {
                ReferenceCountUtil.retain(httpObject);
                channelHandlerContext.fireChannelRead((Object) httpObject);
                return;
            }
            this.handlingUpgrade = true;
        }
        if (httpObject instanceof FullHttpRequest) {
            fullHttpRequest = (FullHttpRequest) httpObject;
            ReferenceCountUtil.retain(httpObject);
            list.add(httpObject);
        } else {
            super.decode(channelHandlerContext, httpObject, list);
            if (list.isEmpty()) {
                return;
            }
            this.handlingUpgrade = false;
            fullHttpRequest = (FullHttpRequest) list.get(0);
        }
        if (upgrade(channelHandlerContext, fullHttpRequest)) {
            list.clear();
        }
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec, UpgradeCodecFactory upgradeCodecFactory, int i10, boolean z10) {
        super(i10);
        this.sourceCodec = (SourceCodec) ObjectUtil.checkNotNull(sourceCodec, "sourceCodec");
        this.upgradeCodecFactory = (UpgradeCodecFactory) ObjectUtil.checkNotNull(upgradeCodecFactory, "upgradeCodecFactory");
        this.validateHeaders = z10;
    }
}
