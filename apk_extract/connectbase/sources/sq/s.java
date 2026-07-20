package sq;

import kn.u1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final jn.l<Object, Object> f15330a = b.INSTANCE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final jn.p<Object, Object, Boolean> f15331b = a.INSTANCE;

    public static final class a extends kn.n0 implements jn.p<Object, Object, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.m Object obj, @os.m Object obj2) {
            return Boolean.valueOf(kn.l0.g(obj, obj2));
        }
    }

    public static final class b extends kn.n0 implements jn.l<Object, Object> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final Object invoke(@os.m Object obj) {
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> i<T> a(@os.l i<? extends T> iVar) {
        return iVar instanceof u0 ? iVar : d(iVar, f15330a, f15331b);
    }

    @os.l
    public static final <T> i<T> b(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super T, Boolean> pVar) {
        jn.l<Object, Object> lVar = f15330a;
        kn.l0.n(pVar, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return d(iVar, lVar, (jn.p) u1.q(pVar, 2));
    }

    @os.l
    public static final <T, K> i<T> c(@os.l i<? extends T> iVar, @os.l jn.l<? super T, ? extends K> lVar) {
        return d(iVar, lVar, f15331b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> i<T> d(i<? extends T> iVar, jn.l<? super T, ? extends Object> lVar, jn.p<Object, Object, Boolean> pVar) {
        if (iVar instanceof g) {
            g gVar = (g) iVar;
            if (gVar.f15271b == lVar && gVar.f15272c == pVar) {
                return iVar;
            }
        }
        return new g(iVar, lVar, pVar);
    }
}
