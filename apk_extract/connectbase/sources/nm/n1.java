package nm;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class n1 {
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <E> Set<E> a(@os.l Set<E> set) {
        kn.l0.p(set, "builder");
        return ((om.j) set).build();
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final <E> Set<E> b(int i10, jn.l<? super Set<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.j jVar = new om.j(i10);
        lVar.invoke(jVar);
        return a(jVar);
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final <E> Set<E> c(jn.l<? super Set<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.j jVar = new om.j();
        lVar.invoke(jVar);
        return a(jVar);
    }

    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static final <E> Set<E> d() {
        return new om.j();
    }

    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <E> Set<E> e(int i10) {
        return new om.j(i10);
    }

    @os.l
    public static <T> Set<T> f(T t10) {
        Set<T> setSingleton = Collections.singleton(t10);
        kn.l0.o(setSingleton, "singleton(...)");
        return setSingleton;
    }

    @os.l
    public static final <T> TreeSet<T> g(@os.l Comparator<? super T> comparator, @os.l T... tArr) {
        kn.l0.p(comparator, "comparator");
        kn.l0.p(tArr, "elements");
        return (TreeSet) r.py(tArr, new TreeSet(comparator));
    }

    @os.l
    public static final <T> TreeSet<T> h(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return (TreeSet) r.py(tArr, new TreeSet());
    }
}
