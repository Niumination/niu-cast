package bl;

import al.u;
import fl.t0;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final a f963a = new a();

        @Override // bl.e
        @m
        public Object a(boolean z10) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }

        @Override // bl.e
        @l
        public Object c(@l ByteBuf byteBuf, boolean z10) {
            l0.p(byteBuf, "buf");
            return new DefaultHttpContent(byteBuf);
        }

        @Override // bl.e
        public void d(@l ChannelHandlerContext channelHandlerContext) {
            l0.p(channelHandlerContext, "dst");
            channelHandlerContext.pipeline().replace(HttpServerCodec.class, "direct-encoder", new u());
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final b f964a = new b();

        @Override // bl.e
        @m
        public Object a(boolean z10) {
            if (z10) {
                return null;
            }
            return new DefaultHttp2DataFrame(true);
        }

        @Override // bl.e
        public boolean b() {
            return false;
        }

        @Override // bl.e
        @l
        public Object c(@l ByteBuf byteBuf, boolean z10) {
            l0.p(byteBuf, "buf");
            return new DefaultHttp2DataFrame(byteBuf, z10);
        }

        @Override // bl.e
        public void d(@l ChannelHandlerContext channelHandlerContext) {
            l0.p(channelHandlerContext, "dst");
            throw new IllegalStateException("HTTP/2 doesn't support upgrade");
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final c f965a = new c();

        @Override // bl.e
        @m
        public Object a(boolean z10) {
            return null;
        }

        @Override // bl.e
        public boolean b() {
            return false;
        }

        @Override // bl.e
        @l
        public Object c(@l ByteBuf byteBuf, boolean z10) {
            l0.p(byteBuf, "buf");
            return byteBuf;
        }

        @Override // bl.e
        public void d(@l ChannelHandlerContext channelHandlerContext) {
            l0.p(channelHandlerContext, "dst");
            throw new IllegalStateException("Already upgraded");
        }
    }

    public e() {
    }

    @m
    public abstract Object a(boolean z10);

    public boolean b() {
        return true;
    }

    @l
    public abstract Object c(@l ByteBuf byteBuf, boolean z10);

    public abstract void d(@l ChannelHandlerContext channelHandlerContext);

    public e(w wVar) {
    }
}
