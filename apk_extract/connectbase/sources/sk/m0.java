package sk;

import java.net.SocketAddress;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements k<m0, e0.f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f15141c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final rk.j f15142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public e0.f f15143b;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends kn.n0 implements jn.l<e0.f, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0.f fVar) {
            kn.l0.p(fVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0.f fVar) {
            invoke2(fVar);
            return l2.f10208a;
        }
    }

    public static final class c extends kn.n0 implements jn.l<e0.f, l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0.f fVar) {
            kn.l0.p(fVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0.f fVar) {
            invoke2(fVar);
            return l2.f10208a;
        }
    }

    public m0(@os.l rk.j jVar, @os.l e0.f fVar) {
        kn.l0.p(jVar, "selector");
        kn.l0.p(fVar, "options");
        this.f15142a = jVar;
        this.f15143b = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g d(m0 m0Var, SocketAddress socketAddress, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            socketAddress = null;
        }
        if ((i10 & 2) != 0) {
            lVar = b.INSTANCE;
        }
        return m0Var.c(socketAddress, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ m g(m0 m0Var, SocketAddress socketAddress, SocketAddress socketAddress2, jn.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            socketAddress2 = null;
        }
        if ((i10 & 4) != 0) {
            lVar = c.INSTANCE;
        }
        return m0Var.f(socketAddress, socketAddress2, lVar);
    }

    @Override // sk.k
    public k a(jn.l lVar) {
        return (m0) k.a.a(this, lVar);
    }

    @os.l
    public final g c(@os.m SocketAddress socketAddress, @os.l jn.l<? super e0.f, l2> lVar) {
        kn.l0.p(lVar, "configure");
        a aVar = f15141c;
        rk.j jVar = this.f15142a;
        e0.f fVarR = this.f15143b.r();
        lVar.invoke(fVarR);
        return n0.a(aVar, jVar, socketAddress, fVarR);
    }

    @os.l
    public m0 e(@os.l jn.l<? super e0.f, l2> lVar) {
        return (m0) k.a.a(this, lVar);
    }

    @os.l
    public final m f(@os.l SocketAddress socketAddress, @os.m SocketAddress socketAddress2, @os.l jn.l<? super e0.f, l2> lVar) {
        kn.l0.p(socketAddress, "remoteAddress");
        kn.l0.p(lVar, "configure");
        a aVar = f15141c;
        rk.j jVar = this.f15142a;
        e0.f fVarR = this.f15143b.r();
        lVar.invoke(fVarR);
        return n0.b(aVar, jVar, socketAddress, socketAddress2, fVarR);
    }

    @Override // sk.k
    public e0 getOptions() {
        return this.f15143b;
    }

    @os.l
    public e0.f h() {
        return this.f15143b;
    }

    @Override // sk.k
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(@os.l e0.f fVar) {
        kn.l0.p(fVar, "<set-?>");
        this.f15143b = fVar;
    }
}
