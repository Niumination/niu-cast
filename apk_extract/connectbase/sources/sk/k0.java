package sk;

import java.net.SocketAddress;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements k<k0, e0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final rk.j f15132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public e0 f15133b;

    public static final class a extends kn.n0 implements jn.l<e0.a, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0.a aVar) {
            kn.l0.p(aVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }
    }

    public static final class b extends kn.n0 implements jn.l<e0.a, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0.a aVar) {
            kn.l0.p(aVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }
    }

    public static final class c extends kn.n0 implements jn.l<e0.e, l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0.e eVar) {
            kn.l0.p(eVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0.e eVar) {
            invoke2(eVar);
            return l2.f10208a;
        }
    }

    public static final class d extends kn.n0 implements jn.l<e0.e, l2> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0.e eVar) {
            kn.l0.p(eVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0.e eVar) {
            invoke2(eVar);
            return l2.f10208a;
        }
    }

    public k0(@os.l rk.j jVar, @os.l e0 e0Var) {
        kn.l0.p(jVar, "selector");
        kn.l0.p(e0Var, "options");
        this.f15132a = jVar;
        this.f15133b = e0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ z e(k0 k0Var, String str, int i10, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "0.0.0.0";
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            lVar = a.INSTANCE;
        }
        return k0Var.c(str, i10, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ z f(k0 k0Var, SocketAddress socketAddress, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            socketAddress = null;
        }
        if ((i10 & 2) != 0) {
            lVar = b.INSTANCE;
        }
        return k0Var.d(socketAddress, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object j(k0 k0Var, String str, int i10, jn.l lVar, um.d dVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            lVar = c.INSTANCE;
        }
        return k0Var.h(str, i10, lVar, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object k(k0 k0Var, SocketAddress socketAddress, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = d.INSTANCE;
        }
        return k0Var.i(socketAddress, lVar, dVar);
    }

    @Override // sk.k
    public k a(jn.l lVar) {
        return (k0) k.a.a(this, lVar);
    }

    @Override // sk.k
    public void b(@os.l e0 e0Var) {
        kn.l0.p(e0Var, "<set-?>");
        this.f15133b = e0Var;
    }

    @os.l
    public final z c(@os.l String str, int i10, @os.l jn.l<? super e0.a, l2> lVar) {
        kn.l0.p(str, "hostname");
        kn.l0.p(lVar, "configure");
        return d(ml.a.a(str, i10), lVar);
    }

    @os.l
    public final z d(@os.m SocketAddress socketAddress, @os.l jn.l<? super e0.a, l2> lVar) {
        kn.l0.p(lVar, "configure");
        rk.j jVar = this.f15132a;
        e0.a aVarA = this.f15133b.h().a();
        lVar.invoke(aVarA);
        return l.a(jVar, socketAddress, aVarA);
    }

    @os.l
    public k0 g(@os.l jn.l<? super e0, l2> lVar) {
        return (k0) k.a.a(this, lVar);
    }

    @Override // sk.k
    @os.l
    public e0 getOptions() {
        return this.f15133b;
    }

    @os.m
    public final Object h(@os.l String str, int i10, @os.l jn.l<? super e0.e, l2> lVar, @os.l um.d<? super b0> dVar) {
        return i(ml.a.a(str, i10), lVar, dVar);
    }

    @os.m
    public final Object i(@os.l SocketAddress socketAddress, @os.l jn.l<? super e0.e, l2> lVar, @os.l um.d<? super b0> dVar) {
        rk.j jVar = this.f15132a;
        e0.e eVarQ = this.f15133b.h().q();
        lVar.invoke(eVarQ);
        return l.b(jVar, socketAddress, eVarQ, dVar);
    }
}
