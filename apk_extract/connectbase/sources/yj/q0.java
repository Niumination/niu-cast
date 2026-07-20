package yj;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import vj.v1;
import vj.y2;
import wj.i2;
import wj.i3;
import wj.q3;
import wj.r3;

/* JADX INFO: loaded from: classes2.dex */
public class q0 extends wj.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Logger f21240m = Logger.getLogger(q0.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f21241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f21242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k1 f21243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vj.a f21244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f21245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q3 f21246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f21247l;

    public class b implements wj.c.a {

        public class a implements ChannelFutureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f21249a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f21250b;

            public a(int i10, int i11) {
                this.f21249a = i10;
                this.f21250b = i11;
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                q0.this.C().s(this.f21249a);
                if (channelFuture.isSuccess()) {
                    q0.this.f21246k.f(this.f21250b);
                }
            }
        }

        public b() {
        }

        @Override // wj.c.a
        public void a(y2 y2Var) {
            fm.f fVarZ = fm.c.z("NettyServerStream$Sink.cancel");
            try {
                q0.this.f21243h.c(new d(q0.this.C(), y2Var), true);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        public final void b(r3 r3Var, boolean z10, int i10) {
            c1.h0.d(i10 >= 0);
            ByteBuf byteBuf = ((v0) r3Var).c().touch();
            int i11 = byteBuf.readableBytes();
            q0.this.B(i11);
            q0 q0Var = q0.this;
            q0Var.f21243h.c(new a1(q0Var.C(), byteBuf, false), z10).addListener((GenericFutureListener<? extends Future<? super Void>>) new a(i11, i10));
        }

        @Override // wj.c.a
        public void d(v1 v1Var, boolean z10) {
            fm.f fVarZ = fm.c.z("NettyServerStream$Sink.writeHeaders");
            try {
                q0.this.f21243h.c(c1.d(q0.this.C(), i1.g(v1Var)), z10);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        @Override // wj.c.a
        public void e(v1 v1Var, boolean z10, y2 y2Var) {
            fm.f fVarZ = fm.c.z("NettyServerStream$Sink.writeTrailers");
            try {
                q0.this.f21243h.c(c1.e(q0.this.C(), i1.h(v1Var, z10), y2Var), true);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        @Override // wj.c.a
        public void f(r3 r3Var, boolean z10, int i10) {
            fm.f fVarZ = fm.c.z("NettyServerStream$Sink.writeFrame");
            try {
                b(r3Var, z10, i10);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static class c extends wj.c.b implements d1 {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Http2Stream f21252s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final o0 f21253t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final EventLoop f21254u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final fm.e f21255v;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ fm.b f21256a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Runnable f21257b;

            public a(fm.b bVar, Runnable runnable) {
                this.f21256a = bVar;
                this.f21257b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                fm.f fVarZ = fm.c.z("NettyServerStream$TransportState.runOnTransportThread");
                try {
                    fm.c.a(c.this.f21255v);
                    fm.c.n(this.f21256a);
                    this.f21257b.run();
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } catch (Throwable th2) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        public c(o0 o0Var, EventLoop eventLoop, Http2Stream http2Stream, int i10, i3 i3Var, q3 q3Var, String str) {
            super(i10, i3Var, q3Var);
            this.f21252s = (Http2Stream) c1.h0.F(http2Stream, "http2Stream");
            this.f21253t = (o0) c1.h0.F(o0Var, "handler");
            this.f21254u = eventLoop;
            this.f21255v = fm.c.i(str, http2Stream.id());
        }

        @Override // wj.c.b
        public /* bridge */ /* synthetic */ void F() {
            super.F();
        }

        @Override // wj.c.b
        public /* bridge */ /* synthetic */ void G(i2 i2Var, boolean z10) {
            super.G(i2Var, z10);
        }

        public void N(ByteBuf byteBuf, boolean z10) {
            super.G(new k0(byteBuf.retain()), z10);
        }

        @Override // wj.t1.b
        public void b(int i10) {
            this.f21253t.C2(this.f21252s, i10);
            this.f21253t.s2().f();
        }

        @Override // wj.t1.b
        public void c(Throwable th2) {
            q0.f21240m.log(Level.WARNING, "Exception processing message", th2);
            y2 y2VarN = y2.n(th2);
            K(y2VarN);
            this.f21253t.s2().c(new d(this, y2VarN), true);
        }

        @Override // yj.d1
        public fm.e d() {
            return this.f21255v;
        }

        @Override // wj.c.b, wj.t1.b
        public /* bridge */ /* synthetic */ void e(boolean z10) {
            super.e(z10);
        }

        @Override // wj.g.d
        public void f(Runnable runnable) {
            if (this.f21254u.inEventLoop()) {
                runnable.run();
            } else {
                this.f21254u.execute(new a(fm.c.o(), runnable));
            }
        }

        @Override // yj.d1
        public int id() {
            return this.f21252s.id();
        }
    }

    public q0(Channel channel, c cVar, vj.a aVar, String str, i3 i3Var, q3 q3Var) {
        super(new w0(channel.alloc()), i3Var);
        this.f21241f = new b();
        this.f21242g = (c) c1.h0.F(cVar, "transportState");
        this.f21243h = cVar.f21253t.s2();
        aVar.getClass();
        this.f21244i = aVar;
        this.f21245j = str;
        this.f21246k = (q3) c1.h0.F(q3Var, "transportTracer");
        this.f21247l = C().id();
    }

    @Override // wj.c
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public b D() {
        return this.f21241f;
    }

    @Override // wj.c
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public c C() {
        return this.f21242g;
    }

    @Override // wj.c, wj.z2
    public vj.a c() {
        return this.f21244i;
    }

    @Override // wj.c, wj.z2
    public String q() {
        return this.f21245j;
    }

    @Override // wj.z2
    public int streamId() {
        return this.f21247l;
    }
}
