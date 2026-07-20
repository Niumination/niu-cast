package gk;

import kn.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final fl.b<e<?>> f6597a = new fl.b<>("LastReceiveRequest");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final e.a f6598b = new e.a(l1.A(Object.class), new uk.g());

    public static final void j(e<?> eVar) throws z0 {
        if (eVar == f6598b) {
            throw new uk.g();
        }
        if (eVar instanceof e.a) {
            throw new z0(((e.a) eVar).f6587b);
        }
    }

    public static final void k(uk.c cVar, un.s sVar) throws k {
        if (cVar.f16295b instanceof e.b) {
            throw new uk.g();
        }
        if (!wn.d.b(sVar).r(cVar.f16295b)) {
            throw new k(sVar);
        }
    }

    public static final e<?> l(fl.c cVar) {
        return (e) cVar.b(f6597a);
    }

    public static /* synthetic */ void m() {
    }

    public static final boolean n(e<?> eVar) {
        return (eVar instanceof e.b) && (((e.b) eVar).f6588b instanceof byte[]);
    }

    public static final boolean o(e<?> eVar) {
        return eVar == null || !(eVar instanceof e.b);
    }

    public static final void p(fl.c cVar, e<?> eVar) {
        cVar.g(f6597a, eVar);
    }

    public static final void q(fl.c cVar, un.s sVar, Throwable th2) {
        p(cVar, new e.a(sVar, th2));
    }

    public static final <T> void r(fl.c cVar, un.s sVar, T t10) {
        p(cVar, new e.b(sVar, t10));
    }
}
