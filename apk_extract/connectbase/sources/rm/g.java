package rm;

import java.util.Comparator;
import jn.p;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, Comparable<?>> f14567a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.l<? super T, ? extends Comparable<?>> lVar) {
            this.f14567a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            jn.l<T, Comparable<?>> lVar = this.f14567a;
            return g.l(lVar.invoke(t10), lVar.invoke(t11));
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$3\n*L\n1#1,328:1\n*E\n"})
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f14568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, K> f14569b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Comparator<? super K> comparator, jn.l<? super T, ? extends K> lVar) {
            this.f14568a = comparator;
            this.f14569b = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Comparator<? super K> comparator = this.f14568a;
            jn.l<T, K> lVar = this.f14569b;
            return comparator.compare((Object) lVar.invoke(t10), (Object) lVar.invoke(t11));
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, Comparable<?>> f14570a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(jn.l<? super T, ? extends Comparable<?>> lVar) {
            this.f14570a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            jn.l<T, Comparable<?>> lVar = this.f14570a;
            return g.l(lVar.invoke(t11), lVar.invoke(t10));
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$2\n*L\n1#1,328:1\n*E\n"})
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f14571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, K> f14572b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Comparator<? super K> comparator, jn.l<? super T, ? extends K> lVar) {
            this.f14571a = comparator;
            this.f14572b = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Comparator<? super K> comparator = this.f14571a;
            jn.l<T, K> lVar = this.f14572b;
            return comparator.compare((Object) lVar.invoke(t11), (Object) lVar.invoke(t10));
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1\n*L\n1#1,328:1\n*E\n"})
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f14573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, Comparable<?>> f14574b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Comparator<T> comparator, jn.l<? super T, ? extends Comparable<?>> lVar) {
            this.f14573a = comparator;
            this.f14574b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f14573a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            jn.l<T, Comparable<?>> lVar = this.f14574b;
            return g.l(lVar.invoke(t10), lVar.invoke(t11));
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f14575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f14576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, K> f14577c;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Comparator<T> comparator, Comparator<? super K> comparator2, jn.l<? super T, ? extends K> lVar) {
            this.f14575a = comparator;
            this.f14576b = comparator2;
            this.f14577c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f14575a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            Comparator<? super K> comparator = this.f14576b;
            jn.l<T, K> lVar = this.f14577c;
            return comparator.compare((Object) lVar.invoke(t10), (Object) lVar.invoke(t11));
        }
    }

    /* JADX INFO: renamed from: rm.g$g, reason: collision with other inner class name */
    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class C0357g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f14578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, Comparable<?>> f14579b;

        /* JADX WARN: Multi-variable type inference failed */
        public C0357g(Comparator<T> comparator, jn.l<? super T, ? extends Comparable<?>> lVar) {
            this.f14578a = comparator;
            this.f14579b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f14578a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            jn.l<T, Comparable<?>> lVar = this.f14579b;
            return g.l(lVar.invoke(t11), lVar.invoke(t10));
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$2\n*L\n1#1,328:1\n*E\n"})
    public static final class h<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f14580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f14581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, K> f14582c;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Comparator<T> comparator, Comparator<? super K> comparator2, jn.l<? super T, ? extends K> lVar) {
            this.f14580a = comparator;
            this.f14581b = comparator2;
            this.f14582c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f14580a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            Comparator<? super K> comparator = this.f14581b;
            jn.l<T, K> lVar = this.f14582c;
            return comparator.compare((Object) lVar.invoke(t11), (Object) lVar.invoke(t10));
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenComparator$1\n*L\n1#1,328:1\n*E\n"})
    public static final class i<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f14583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p<T, T, Integer> f14584b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
            this.f14583a = comparator;
            this.f14584b = pVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f14583a.compare(t10, t11);
            return iCompare != 0 ? iCompare : this.f14584b.invoke(t10, t11).intValue();
        }
    }

    public static final int A(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        l0.p(comparator, "$this_then");
        l0.p(comparator2, "$comparator");
        int iCompare = comparator.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator2.compare(obj, obj2);
    }

    @an.f
    public static final <T, K> Comparator<T> B(Comparator<T> comparator, Comparator<? super K> comparator2, jn.l<? super T, ? extends K> lVar) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        l0.p(lVar, "selector");
        return new f(comparator, comparator2, lVar);
    }

    @an.f
    public static final <T> Comparator<T> C(Comparator<T> comparator, jn.l<? super T, ? extends Comparable<?>> lVar) {
        l0.p(comparator, "<this>");
        l0.p(lVar, "selector");
        return new e(comparator, lVar);
    }

    @an.f
    public static final <T, K> Comparator<T> D(Comparator<T> comparator, Comparator<? super K> comparator2, jn.l<? super T, ? extends K> lVar) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        l0.p(lVar, "selector");
        return new h(comparator, comparator2, lVar);
    }

    @an.f
    public static final <T> Comparator<T> E(Comparator<T> comparator, jn.l<? super T, ? extends Comparable<?>> lVar) {
        l0.p(comparator, "<this>");
        l0.p(lVar, "selector");
        return new C0357g(comparator, lVar);
    }

    @an.f
    public static final <T> Comparator<T> F(Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
        l0.p(comparator, "<this>");
        l0.p(pVar, "comparison");
        return new i(comparator, pVar);
    }

    @os.l
    public static final <T> Comparator<T> G(@os.l final Comparator<T> comparator, @os.l final Comparator<? super T> comparator2) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        return new Comparator() { // from class: rm.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.H(comparator, comparator2, obj, obj2);
            }
        };
    }

    public static final int H(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        l0.p(comparator, "$this_thenDescending");
        l0.p(comparator2, "$comparator");
        int iCompare = comparator.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator2.compare(obj2, obj);
    }

    @an.f
    public static final <T, K> Comparator<T> f(Comparator<? super K> comparator, jn.l<? super T, ? extends K> lVar) {
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        return new b(comparator, lVar);
    }

    @an.f
    public static final <T> Comparator<T> g(jn.l<? super T, ? extends Comparable<?>> lVar) {
        l0.p(lVar, "selector");
        return new a(lVar);
    }

    @os.l
    public static <T> Comparator<T> h(@os.l final jn.l<? super T, ? extends Comparable<?>>... lVarArr) {
        l0.p(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return new Comparator() { // from class: rm.e
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return g.i(lVarArr, obj, obj2);
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final int i(jn.l[] lVarArr, Object obj, Object obj2) {
        l0.p(lVarArr, "$selectors");
        return p(obj, obj2, lVarArr);
    }

    @an.f
    public static final <T, K> Comparator<T> j(Comparator<? super K> comparator, jn.l<? super T, ? extends K> lVar) {
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        return new d(comparator, lVar);
    }

    @an.f
    public static final <T> Comparator<T> k(jn.l<? super T, ? extends Comparable<?>> lVar) {
        l0.p(lVar, "selector");
        return new c(lVar);
    }

    public static <T extends Comparable<?>> int l(@os.m T t10, @os.m T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }

    @an.f
    public static final <T, K> int m(T t10, T t11, Comparator<? super K> comparator, jn.l<? super T, ? extends K> lVar) {
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        return comparator.compare(lVar.invoke(t10), lVar.invoke(t11));
    }

    @an.f
    public static final <T> int n(T t10, T t11, jn.l<? super T, ? extends Comparable<?>> lVar) {
        l0.p(lVar, "selector");
        return l(lVar.invoke(t10), lVar.invoke(t11));
    }

    public static final <T> int o(T t10, T t11, @os.l jn.l<? super T, ? extends Comparable<?>>... lVarArr) {
        l0.p(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return p(t10, t11, lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final <T> int p(T t10, T t11, jn.l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (jn.l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int iL = l(lVar.invoke(t10), lVar.invoke(t11));
            if (iL != 0) {
                return iL;
            }
        }
        return 0;
    }

    @os.l
    public static final <T extends Comparable<? super T>> Comparator<T> q() {
        j jVar = j.f14585a;
        l0.n(jVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return jVar;
    }

    @an.f
    public static final <T extends Comparable<? super T>> Comparator<T> r() {
        return s(q());
    }

    @os.l
    public static final <T> Comparator<T> s(@os.l final Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return new Comparator() { // from class: rm.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.t(comparator, obj, obj2);
            }
        };
    }

    public static final int t(Comparator comparator, Object obj, Object obj2) {
        l0.p(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    @an.f
    public static final <T extends Comparable<? super T>> Comparator<T> u() {
        return v(q());
    }

    @os.l
    public static final <T> Comparator<T> v(@os.l final Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return new Comparator() { // from class: rm.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.w(comparator, obj, obj2);
            }
        };
    }

    public static final int w(Comparator comparator, Object obj, Object obj2) {
        l0.p(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    @os.l
    public static <T extends Comparable<? super T>> Comparator<T> x() {
        k kVar = k.f14586a;
        l0.n(kVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return kVar;
    }

    @os.l
    public static final <T> Comparator<T> y(@os.l Comparator<T> comparator) {
        l0.p(comparator, "<this>");
        if (comparator instanceof l) {
            return ((l) comparator).f14587a;
        }
        Comparator<T> lVar = j.f14585a;
        if (l0.g(comparator, lVar)) {
            k kVar = k.f14586a;
            l0.n(kVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
            return kVar;
        }
        if (l0.g(comparator, k.f14586a)) {
            l0.n(lVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        } else {
            lVar = new l<>(comparator);
        }
        return lVar;
    }

    @os.l
    public static final <T> Comparator<T> z(@os.l final Comparator<T> comparator, @os.l final Comparator<? super T> comparator2) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        return new Comparator() { // from class: rm.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.A(comparator, comparator2, obj, obj2);
            }
        };
    }
}
