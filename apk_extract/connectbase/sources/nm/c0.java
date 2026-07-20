package nm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class c0 extends b0 {
    @lm.f1(version = "1.2")
    @an.f
    public static final <T> void j0(List<T> list, T t10) {
        kn.l0.p(list, "<this>");
        Collections.fill(list, t10);
    }

    @lm.f1(version = "1.2")
    @an.f
    public static final <T> void k0(List<T> list) {
        kn.l0.p(list, "<this>");
        Collections.shuffle(list);
    }

    @lm.f1(version = "1.2")
    @an.f
    public static final <T> void l0(List<T> list, Random random) {
        kn.l0.p(list, "<this>");
        kn.l0.p(random, "random");
        Collections.shuffle(list, random);
    }

    public static <T extends Comparable<? super T>> void m0(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @an.f
    @lm.k(level = lm.m.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @lm.a1(expression = "this.sortWith(comparator)", imports = {}))
    public static final <T> void n0(List<T> list, Comparator<? super T> comparator) {
        kn.l0.p(list, "<this>");
        kn.l0.p(comparator, "comparator");
        throw new lm.j0(null, 1, null);
    }

    @an.f
    @lm.k(level = lm.m.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @lm.a1(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    public static final <T> void o0(List<T> list, jn.p<? super T, ? super T, Integer> pVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(pVar, "comparison");
        throw new lm.j0(null, 1, null);
    }

    public static <T> void p0(@os.l List<T> list, @os.l Comparator<? super T> comparator) {
        kn.l0.p(list, "<this>");
        kn.l0.p(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
