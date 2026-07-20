package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends z implements g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final a f15884f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final v f15885g;

    public static final class a {
        public a() {
        }

        @ul.d
        public static /* synthetic */ void c() {
        }

        @os.l
        public final v a() {
            return v.f15885g;
        }

        public final int b() {
            return 8;
        }

        public a(kn.w wVar) {
        }
    }

    static {
        ul.b.e eVar = ul.b.f16311i;
        ul.b bVarA = eVar.a();
        eVar.getClass();
        f15885g = new v(bVarA, 0L, ul.b.f16316x);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@os.l ul.b bVar, long j10, @os.l bm.h<ul.b> hVar) {
        super(bVar, j10, hVar);
        kn.l0.p(bVar, "head");
        kn.l0.p(hVar, "pool");
        S1();
    }

    @os.l
    public final v N2() {
        return new v(n.c(p0()), S0(), this.f15789a);
    }

    @Override // tl.a
    @os.m
    public final ul.b e0() {
        return null;
    }

    @Override // tl.a
    public final int f0(@os.l ByteBuffer byteBuffer, int i10, int i11) {
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        return 0;
    }

    @Override // tl.a
    public final void n() {
    }

    @os.l
    public String toString() {
        return "ByteReadPacket(" + S0() + " bytes remaining)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(@os.l ul.b bVar, @os.l bm.h<ul.b> hVar) {
        this(bVar, n.o(bVar), hVar);
        kn.l0.p(bVar, "head");
        kn.l0.p(hVar, "pool");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ v(o0 o0Var, bm.h hVar) {
        this(o0Var, n.o(o0Var), hVar);
        kn.l0.p(o0Var, "head");
        kn.l0.p(hVar, "pool");
    }
}
