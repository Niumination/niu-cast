package yj;

import io.netty.channel.ChannelHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.util.AsciiString;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    public final class a implements y.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f21305a;

        public a(y0 y0Var) {
            this.f21305a = y0Var;
        }

        @Override // yj.y0
        public ChannelHandler a(l lVar) {
            return this.f21305a.a(lVar);
        }

        @Override // yj.y0
        public void close() {
            this.f21305a.close();
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return this.f21305a.scheme();
        }
    }

    public final class b implements y.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f21306a;

        public b(y0 y0Var) {
            this.f21306a = y0Var;
        }

        @Override // yj.y0
        public ChannelHandler a(l lVar) {
            return this.f21306a.a(lVar);
        }

        @Override // yj.y0
        public void close() {
            this.f21306a.close();
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return this.f21306a.scheme();
        }
    }

    public final class c implements y.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f21307a;

        public c(y0 y0Var) {
            this.f21307a = y0Var;
        }

        @Override // yj.y0
        public ChannelHandler a(l lVar) {
            return this.f21307a.a(lVar);
        }

        @Override // yj.y0
        public void close() {
            this.f21307a.close();
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return this.f21307a.scheme();
        }
    }

    public final class d implements y.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f21308a;

        public d(y0 y0Var) {
            this.f21308a = y0Var;
        }

        @Override // yj.y0
        public ChannelHandler a(l lVar) {
            return this.f21308a.a(lVar);
        }

        @Override // yj.y0
        public void close() {
            this.f21308a.close();
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return this.f21308a.scheme();
        }
    }

    public static class e extends z0.q {
        public e(ChannelHandler channelHandler, String str, vj.h hVar) {
            super(channelHandler, str, hVar);
        }

        public e(ChannelHandler channelHandler, vj.h hVar) {
            super(channelHandler, hVar);
        }
    }

    public static ChannelHandler a(ChannelHandler channelHandler, SslContext sslContext, String str, vj.h hVar) {
        return new z0.d(channelHandler, sslContext, str, null, hVar);
    }

    public static ChannelHandler b(l lVar) {
        return new z0.i(lVar);
    }

    public static y.b c() {
        return new a(z0.h());
    }

    public static y.b d() {
        return new b(z0.l());
    }

    public static y.b e(SslContext sslContext) {
        return new c(z0.n(sslContext));
    }

    public static y.b f(SslContext sslContext) {
        return new d(z0.q(sslContext));
    }

    public static ChannelHandler g(ChannelHandler channelHandler, vj.h hVar) {
        return new z0.v(channelHandler, hVar);
    }
}
