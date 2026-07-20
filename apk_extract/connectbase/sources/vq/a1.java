package vq;

import nq.n3;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public static final u0 f17796a = new u0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final jn.p<Object, um.g.b, Object> f17797b = a.INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final jn.p<n3<?>, um.g.b, n3<?>> f17798c = b.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final jn.p<g1, um.g.b, g1> f17799d = c.INSTANCE;

    public static final class a extends kn.n0 implements jn.p<Object, um.g.b, Object> {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.m Object obj, @os.l um.g.b bVar) {
            if (!(bVar instanceof n3)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    public static final class b extends kn.n0 implements jn.p<n3<?>, um.g.b, n3<?>> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // jn.p
        @os.m
        public final n3<?> invoke(@os.m n3<?> n3Var, @os.l um.g.b bVar) {
            if (n3Var != null) {
                return n3Var;
            }
            if (bVar instanceof n3) {
                return (n3) bVar;
            }
            return null;
        }
    }

    public static final class c extends kn.n0 implements jn.p<g1, um.g.b, g1> {
        public static final c INSTANCE = new c();

        public c() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final g1 invoke(@os.l g1 g1Var, @os.l um.g.b bVar) {
            if (bVar instanceof n3) {
                n3<?> n3Var = (n3) bVar;
                g1Var.a(n3Var, n3Var.u0(g1Var.f17844a));
            }
            return g1Var;
        }
    }

    public static final void a(@os.l um.g gVar, @os.m Object obj) {
        if (obj == f17796a) {
            return;
        }
        if (obj instanceof g1) {
            ((g1) obj).b(gVar);
            return;
        }
        Object objFold = gVar.fold(null, f17798c);
        kn.l0.n(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((n3) objFold).D1(gVar, obj);
    }

    @os.l
    public static final Object b(@os.l um.g gVar) {
        Object objFold = gVar.fold(0, f17797b);
        kn.l0.m(objFold);
        return objFold;
    }

    @os.m
    public static final Object c(@os.l um.g gVar, @os.m Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return f17796a;
        }
        if (obj instanceof Integer) {
            return gVar.fold(new g1(gVar, ((Number) obj).intValue()), f17799d);
        }
        kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((n3) obj).u0(gVar);
    }
}
