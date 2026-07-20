package nm;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public class o1 extends n1 {
    @lm.f1(version = "1.6")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <E> Set<E> i(int i10, @lm.b jn.l<? super Set<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.j jVar = new om.j(i10);
        lVar.invoke(jVar);
        return n1.a(jVar);
    }

    @lm.f1(version = "1.6")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <E> Set<E> j(@lm.b jn.l<? super Set<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.j jVar = new om.j();
        lVar.invoke(jVar);
        return n1.a(jVar);
    }

    @os.l
    public static <T> Set<T> k() {
        return m0.INSTANCE;
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <T> HashSet<T> l() {
        return new HashSet<>();
    }

    @os.l
    public static final <T> HashSet<T> m(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return (HashSet) r.py(tArr, new HashSet(c1.j(tArr.length)));
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <T> LinkedHashSet<T> n() {
        return new LinkedHashSet<>();
    }

    @os.l
    public static <T> LinkedHashSet<T> o(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return (LinkedHashSet) r.py(tArr, new LinkedHashSet(c1.j(tArr.length)));
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <T> Set<T> p() {
        return new LinkedHashSet();
    }

    @os.l
    public static final <T> Set<T> q(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return (Set) r.py(tArr, new LinkedHashSet(c1.j(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> Set<T> r(@os.l Set<? extends T> set) {
        kn.l0.p(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : n1.f(set.iterator().next());
        }
        return m0.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <T> Set<T> s(Set<? extends T> set) {
        return set == 0 ? m0.INSTANCE : set;
    }

    @an.f
    public static final <T> Set<T> t() {
        return m0.INSTANCE;
    }

    @os.l
    public static <T> Set<T> u(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return tArr.length > 0 ? r.mz(tArr) : m0.INSTANCE;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <T> Set<T> v(@os.m T t10) {
        return t10 != null ? n1.f(t10) : m0.INSTANCE;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <T> Set<T> w(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return (Set) r.Ua(tArr, new LinkedHashSet());
    }
}
