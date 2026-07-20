package yj;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import vj.v1;
import vj.w1;
import vj.y2;
import wj.i3;
import wj.q3;
import wj.r3;

/* JADX INFO: loaded from: classes2.dex */
public class i0 extends wj.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final vj.g1 f20975o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f20976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f20977i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k1 f20978j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final w1<?, ?> f20979k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AsciiString f20980l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AsciiString f20981m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AsciiString f20982n;

    public class b implements wj.a.b {

        public class a implements ChannelFutureListener {
            public a() {
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    return;
                }
                y2 y2VarG0 = i0.this.C().B.q2().f20892e;
                if (y2VarG0 == null) {
                    y2VarG0 = i0.this.C().g0(channelFuture);
                }
                if (i0.this.C().c0()) {
                    i0.this.C().Q(y2VarG0, wj.t.a.MISCARRIED, true, new v1());
                } else {
                    i0.this.C().Q(y2VarG0, wj.t.a.PROCESSED, true, new v1());
                }
            }
        }

        /* JADX INFO: renamed from: yj.i0$b$b, reason: collision with other inner class name */
        public class C0540b implements ChannelFutureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f20985a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f20986b;

            public C0540b(int i10, int i11) {
                this.f20985a = i10;
                this.f20986b = i11;
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (!channelFuture.isSuccess() || i0.this.C().b0() == null) {
                    return;
                }
                i0.this.C().s(this.f20985a);
                i0.this.F().f(this.f20986b);
            }
        }

        public b() {
        }

        @Override // wj.a.b
        public void a(y2 y2Var) {
            fm.f fVarZ = fm.c.z("NettyClientStream$Sink.cancel");
            try {
                i0.this.f20978j.c(new yj.c(i0.this.C(), y2Var), true);
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

        @Override // wj.a.b
        public void b(v1 v1Var, byte[] bArr) {
            fm.f fVarZ = fm.c.z("NettyClientStream$Sink.writeHeaders");
            try {
                e(v1Var, bArr);
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

        @Override // wj.a.b
        public void c(r3 r3Var, boolean z10, boolean z11, int i10) {
            fm.f fVarZ = fm.c.z("NettyClientStream$Sink.writeFrame");
            try {
                d(r3Var, z10, z11, i10);
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

        public final void d(r3 r3Var, boolean z10, boolean z11, int i10) {
            c1.h0.d(i10 >= 0);
            ByteBuf byteBuf = r3Var == null ? Unpooled.EMPTY_BUFFER : ((v0) r3Var).c().touch();
            int i11 = byteBuf.readableBytes();
            if (i11 <= 0) {
                i0.this.f20978j.c(new a1(i0.this.C(), byteBuf, z10), z11);
                return;
            }
            i0.this.B(i11);
            i0 i0Var = i0.this;
            i0Var.f20978j.c(new a1(i0Var.C(), byteBuf, z10), z11).addListener((GenericFutureListener<? extends Future<? super Void>>) new C0540b(i11, i10));
        }

        public final void e(v1 v1Var, byte[] bArr) {
            AsciiString asciiString;
            AsciiString asciiString2;
            AsciiString asciiString3 = (AsciiString) i0.f20975o.a(i0.this.f20979k);
            if (asciiString3 == null) {
                asciiString3 = new AsciiString("/" + i0.this.f20979k.f17481b);
                i0.f20975o.b(i0.this.f20979k, asciiString3);
            }
            boolean z10 = bArr != null;
            if (z10) {
                AsciiString asciiString4 = new AsciiString(((Object) asciiString3) + "?" + l1.b.d().l(bArr));
                asciiString = i1.f20991d;
                asciiString2 = asciiString4;
            } else {
                asciiString = i1.f20990c;
                asciiString2 = asciiString3;
            }
            i0 i0Var = i0.this;
            Http2Headers http2HeadersD = i1.d(v1Var, i0Var.f20981m, asciiString2, i0Var.f20980l, asciiString, i0Var.f20982n);
            a aVar = new a();
            i0 i0Var2 = i0.this;
            i0Var2.f20978j.c(new f(http2HeadersD, i0Var2.C(), i0.this.f18292c, z10), !i0.this.f20979k.f17480a.clientSendsOneMessage() || z10).addListener((GenericFutureListener<? extends Future<? super Void>>) aVar);
        }
    }

    public static abstract class c extends wj.y0 implements d1 {
        public static final int G = -1;
        public final String A;
        public final h0 B;
        public final EventLoop C;
        public int D;
        public Http2Stream E;
        public fm.e F;

        public c(h0 h0Var, EventLoop eventLoop, int i10, i3 i3Var, q3 q3Var, String str, vj.e eVar) {
            super(i10, i3Var, q3Var, eVar);
            this.A = (String) c1.h0.F(str, "methodName");
            this.B = (h0) c1.h0.F(h0Var, "handler");
            this.C = (EventLoop) c1.h0.F(eventLoop, "eventLoop");
            this.F = fm.c.h(str);
        }

        @Override // wj.y0
        public void T(y2 y2Var, boolean z10, v1 v1Var) {
            R(y2Var, z10, v1Var);
            this.B.s2().c(new yj.c(this, y2Var), true);
        }

        @Override // wj.t1.b
        public void b(int i10) {
            this.B.C2(this.E, i10);
            this.B.s2().f();
        }

        @gm.j
        public Http2Stream b0() {
            return this.E;
        }

        @Override // wj.t1.b
        public void c(Throwable th2) {
            T(y2.n(th2), true, new v1());
        }

        public boolean c0() {
            int i10 = this.D;
            return i10 == -1 || i10 == 0;
        }

        @Override // yj.d1
        public final fm.e d() {
            return this.F;
        }

        public void d0(Http2Stream http2Stream) {
            c1.h0.F(http2Stream, "http2Stream");
            c1.h0.h0(this.E == null, "Can only set http2Stream once");
            this.E = http2Stream;
            t();
            n().d();
        }

        public void e0(int i10) {
            c1.h0.k(i10 > 0, "id must be positive %s", i10);
            int i11 = this.D;
            c1.h0.n0(i11 == 0, "id has been previously set: %s", i11);
            this.D = i10;
            this.F = fm.c.i(this.A, i10);
        }

        @Override // wj.g.d
        public void f(Runnable runnable) {
            if (this.C.inEventLoop()) {
                runnable.run();
            } else {
                this.C.execute(runnable);
            }
        }

        public void f0() {
            int i10 = this.D;
            c1.h0.n0(i10 == 0, "Id has been previously set: %s", i10);
            this.D = -1;
        }

        public abstract y2 g0(ChannelFuture channelFuture);

        public void h0(ByteBuf byteBuf, boolean z10) {
            W(new k0(byteBuf.retain()), z10);
        }

        public void i0(Http2Headers http2Headers, boolean z10) {
            if (!z10) {
                X(i1.e(http2Headers));
                return;
            }
            if (!this.f18308r) {
                this.B.s2().c(new yj.c(this, null), true);
            }
            Y(i1.i(http2Headers));
        }

        @Override // yj.d1
        public int id() {
            return this.D;
        }
    }

    static {
        f20975o = new vj.g1(j0.class.getName().contains("grpc.netty.shaded") ? vj.b1.NETTY_SHADED : vj.b1.NETTY);
    }

    public i0(c cVar, w1<?, ?> w1Var, v1 v1Var, Channel channel, AsciiString asciiString, AsciiString asciiString2, AsciiString asciiString3, i3 i3Var, q3 q3Var, vj.e eVar, boolean z10) {
        super(new w0(channel.alloc()), i3Var, q3Var, v1Var, eVar, z10 && w1Var.f17487h);
        this.f20976h = new b();
        this.f20977i = (c) c1.h0.F(cVar, "transportState");
        this.f20978j = cVar.B.s2();
        this.f20979k = (w1) c1.h0.F(w1Var, "method");
        this.f20980l = (AsciiString) c1.h0.F(asciiString, "authority");
        this.f20981m = (AsciiString) c1.h0.F(asciiString2, "scheme");
        this.f20982n = asciiString3;
    }

    @Override // wj.a
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public b D() {
        return this.f20976h;
    }

    @Override // wj.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public c C() {
        return this.f20977i;
    }

    @Override // wj.s
    public vj.a c() {
        return this.f20977i.B.p2();
    }

    @Override // wj.s
    public void t(String str) {
        this.f20980l = AsciiString.of((CharSequence) c1.h0.F(str, "authority"));
    }
}
