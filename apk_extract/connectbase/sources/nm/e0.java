package nm;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e0 extends d0 {
    public static final int Y0(List list, int i10) {
        return y.J(list) - i10;
    }

    @os.l
    public static <T> List<T> a1(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        return new k1(list);
    }

    @in.i(name = "asReversedMutable")
    @os.l
    public static <T> List<T> b1(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        return new j1(list);
    }

    public static final int c1(List<?> list, int i10) {
        if (new tn.l(0, y.J(list), 1).l(i10)) {
            return y.J(list) - i10;
        }
        StringBuilder sbA = h.b.a("Element index ", i10, " must be in range [");
        sbA.append(new tn.l(0, y.J(list), 1));
        sbA.append("].");
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public static final int d1(List<?> list, int i10) {
        return y.J(list) - i10;
    }

    public static final int e1(List<?> list, int i10) {
        if (new tn.l(0, list.size(), 1).l(i10)) {
            return list.size() - i10;
        }
        StringBuilder sbA = h.b.a("Position index ", i10, " must be in range [");
        sbA.append(new tn.l(0, list.size(), 1));
        sbA.append("].");
        throw new IndexOutOfBoundsException(sbA.toString());
    }
}
