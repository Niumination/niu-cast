package nm;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\n_Sets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n857#2,2:140\n847#2,2:142\n1#3:144\n*S KotlinDebug\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n*L\n28#1:140,2\n52#1:142,2\n*E\n"})
public class p1 extends o1 {
    @os.l
    public static final <T> Set<T> A(@os.l Set<? extends T> set, @os.l T[] tArr) {
        kn.l0.p(set, "<this>");
        kn.l0.p(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.K0(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @an.f
    public static final <T> Set<T> B(Set<? extends T> set, T t10) {
        kn.l0.p(set, "<this>");
        return z(set, t10);
    }

    @os.l
    public static final <T> Set<T> C(@os.l Set<? extends T> set, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(set, "<this>");
        kn.l0.p(mVar, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(c1.j(set.size() * 2));
        linkedHashSet.addAll(set);
        d0.q0(linkedHashSet, mVar);
        return linkedHashSet;
    }

    @os.l
    public static <T> Set<T> D(@os.l Set<? extends T> set, @os.l Iterable<? extends T> iterable) {
        int size;
        kn.l0.p(set, "<this>");
        kn.l0.p(iterable, "elements");
        Integer numC0 = z.c0(iterable);
        if (numC0 != null) {
            size = set.size() + numC0.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(c1.j(size));
        linkedHashSet.addAll(set);
        d0.r0(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @os.l
    public static <T> Set<T> E(@os.l Set<? extends T> set, T t10) {
        kn.l0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(c1.j(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }

    @os.l
    public static final <T> Set<T> F(@os.l Set<? extends T> set, @os.l T[] tArr) {
        kn.l0.p(set, "<this>");
        kn.l0.p(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(c1.j(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        d0.s0(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @an.f
    public static final <T> Set<T> G(Set<? extends T> set, T t10) {
        kn.l0.p(set, "<this>");
        return E(set, t10);
    }

    @os.l
    public static final <T> Set<T> x(@os.l Set<? extends T> set, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(set, "<this>");
        kn.l0.p(mVar, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.H0(linkedHashSet, mVar);
        return linkedHashSet;
    }

    @os.l
    public static <T> Set<T> y(@os.l Set<? extends T> set, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(set, "<this>");
        kn.l0.p(iterable, "elements");
        Collection<?> collectionT0 = d0.t0(iterable);
        if (collectionT0.isEmpty()) {
            return h0.a6(set);
        }
        if (!(collectionT0 instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionT0);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t10 : set) {
            if (!collectionT0.contains(t10)) {
                linkedHashSet2.add(t10);
            }
        }
        return linkedHashSet2;
    }

    @os.l
    public static <T> Set<T> z(@os.l Set<? extends T> set, T t10) {
        kn.l0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(c1.j(set.size()));
        boolean z10 = false;
        for (T t11 : set) {
            boolean z11 = true;
            if (!z10 && kn.l0.g(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(t11);
            }
        }
        return linkedHashSet;
    }
}
