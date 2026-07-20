package lm;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "TuplesKt")
public final class p1 {
    @os.l
    public static final <A, B> t0<A, B> a(A a10, B b10) {
        return new t0<>(a10, b10);
    }

    @os.l
    public static final <T> List<T> b(@os.l t0<? extends T, ? extends T> t0Var) {
        kn.l0.p(t0Var, "<this>");
        return nm.y.O(t0Var.getFirst(), t0Var.getSecond());
    }

    @os.l
    public static final <T> List<T> c(@os.l o1<? extends T, ? extends T, ? extends T> o1Var) {
        kn.l0.p(o1Var, "<this>");
        return nm.y.O(o1Var.getFirst(), o1Var.getSecond(), o1Var.getThird());
    }
}
