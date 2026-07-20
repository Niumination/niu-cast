package tn;

import kn.l0;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public class t {
    public static final void a(boolean z10, @os.l Number number) {
        l0.p(number, "step");
        if (z10) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + n1.e.f11183c);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ltn/g<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @f1(version = "1.3")
    @an.f
    public static final boolean b(g gVar, Object obj) {
        l0.p(gVar, "<this>");
        return obj != null && gVar.contains((Comparable) obj);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ltn/r<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @f1(version = "1.9")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final boolean c(r rVar, Object obj) {
        l0.p(rVar, "<this>");
        return obj != null && rVar.contains((Comparable) obj);
    }

    @f1(version = "1.1")
    @os.l
    public static final f<Double> d(double d10, double d11) {
        return new d(d10, d11);
    }

    @f1(version = "1.1")
    @os.l
    public static final f<Float> e(float f10, float f11) {
        return new e(f10, f11);
    }

    @os.l
    public static final <T extends Comparable<? super T>> g<T> f(@os.l T t10, @os.l T t11) {
        l0.p(t10, "<this>");
        l0.p(t11, "that");
        return new i(t10, t11);
    }

    @f1(version = "1.9")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final r<Double> g(double d10, double d11) {
        return new p(d10, d11);
    }

    @f1(version = "1.9")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final r<Float> h(float f10, float f11) {
        return new q(f10, f11);
    }

    @f1(version = "1.9")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T extends Comparable<? super T>> r<T> i(@os.l T t10, @os.l T t11) {
        l0.p(t10, "<this>");
        l0.p(t11, "that");
        return new h(t10, t11);
    }
}
