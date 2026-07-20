package no;

import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends g0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final f f11736n = new f();

    public static final class a extends n0 implements jn.l<eo.b, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            return Boolean.valueOf(f.f11736n.j(bVar));
        }
    }

    public static final class b extends n0 implements jn.l<eo.b, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            return Boolean.valueOf((bVar instanceof eo.y) && f.f11736n.j(bVar));
        }
    }

    @os.m
    @in.n
    public static final eo.y k(@os.l eo.y yVar) {
        l0.p(yVar, "functionDescriptor");
        f fVar = f11736n;
        dp.f name = yVar.getName();
        l0.o(name, "functionDescriptor.name");
        if (fVar.l(name)) {
            return (eo.y) lp.a.d(yVar, false, a.INSTANCE, 1, null);
        }
        return null;
    }

    @os.m
    @in.n
    public static final g0.b m(@os.l eo.b bVar) {
        l0.p(bVar, "<this>");
        g0.a aVar = g0.f11742a;
        aVar.getClass();
        if (!g0.f11748g.contains(bVar.getName())) {
            return null;
        }
        eo.b bVarD = lp.a.d(bVar, false, b.INSTANCE, 1, null);
        String strD = bVarD == null ? null : wo.u.d(bVarD);
        if (strD == null) {
            return null;
        }
        return aVar.l(strD);
    }

    public final boolean j(eo.b bVar) {
        g0.f11742a.getClass();
        return nm.h0.W1(g0.f11749h, wo.u.d(bVar));
    }

    public final boolean l(@os.l dp.f fVar) {
        l0.p(fVar, "<this>");
        g0.f11742a.getClass();
        return g0.f11748g.contains(fVar);
    }
}
