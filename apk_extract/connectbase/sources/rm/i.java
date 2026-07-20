package rm;

import java.util.Comparator;
import kn.l0;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public class i extends h {
    @f1(version = "1.4")
    public static final <T> T A0(T t10, @os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        l0.p(tArr, "other");
        l0.p(comparator, "comparator");
        for (T t11 : tArr) {
            if (comparator.compare(t10, t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @f1(version = "1.1")
    public static final <T> T B0(T t10, T t11, T t12, @os.l Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return (T) C0(t10, C0(t11, t12, comparator), comparator);
    }

    @f1(version = "1.1")
    public static final <T> T C0(T t10, T t11, @os.l Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return comparator.compare(t10, t11) <= 0 ? t10 : t11;
    }

    @f1(version = "1.4")
    public static final <T> T D0(T t10, @os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        l0.p(tArr, "other");
        l0.p(comparator, "comparator");
        for (T t11 : tArr) {
            if (comparator.compare(t10, t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @f1(version = "1.1")
    public static final <T> T y0(T t10, T t11, T t12, @os.l Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return (T) z0(t10, z0(t11, t12, comparator), comparator);
    }

    @f1(version = "1.1")
    public static final <T> T z0(T t10, T t11, @os.l Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return comparator.compare(t10, t11) >= 0 ? t10 : t11;
    }
}
