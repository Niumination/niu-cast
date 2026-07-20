package f1;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class n7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparator<? super T> f5153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T[] f5154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    public T f5156e;

    public n7(Comparator<? super T> comparator, int i10) {
        this.f5153b = (Comparator) c1.h0.F(comparator, "comparator");
        this.f5152a = i10;
        c1.h0.k(i10 >= 0, "k (%s) must be >= 0", i10);
        c1.h0.k(i10 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i10);
        this.f5154c = (T[]) new Object[m1.f.d(i10, 2)];
        this.f5155d = 0;
        this.f5156e = null;
    }

    public static <T extends Comparable<? super T>> n7<T> a(int k10) {
        return b(k10, l5.natural());
    }

    public static <T> n7<T> b(int k10, Comparator<? super T> comparator) {
        return new n7<>(l5.from(comparator).reverse(), k10);
    }

    public static <T extends Comparable<? super T>> n7<T> c(int k10) {
        return new n7<>(l5.natural(), k10);
    }

    public static <T> n7<T> d(int k10, Comparator<? super T> comparator) {
        return new n7<>(comparator, k10);
    }

    public void e(@m5 T t10) {
        int i10 = this.f5152a;
        if (i10 == 0) {
            return;
        }
        int i11 = this.f5155d;
        if (i11 == 0) {
            this.f5154c[0] = t10;
            this.f5156e = t10;
            this.f5155d = 1;
            return;
        }
        if (i11 < i10) {
            T[] tArr = this.f5154c;
            this.f5155d = i11 + 1;
            tArr[i11] = t10;
            if (this.f5153b.compare(t10, this.f5156e) > 0) {
                this.f5156e = t10;
                return;
            }
            return;
        }
        if (this.f5153b.compare(t10, this.f5156e) < 0) {
            T[] tArr2 = this.f5154c;
            int i12 = this.f5155d;
            int i13 = i12 + 1;
            this.f5155d = i13;
            tArr2[i12] = t10;
            if (i13 == this.f5152a * 2) {
                k();
            }
        }
    }

    public void f(Iterable<? extends T> elements) {
        g(elements.iterator());
    }

    public void g(Iterator<? extends T> elements) {
        while (elements.hasNext()) {
            e(elements.next());
        }
    }

    public final int h(int i10, int i11, int i12) {
        T[] tArr = this.f5154c;
        T t10 = tArr[i12];
        tArr[i12] = tArr[i11];
        int i13 = i10;
        while (i10 < i11) {
            if (this.f5153b.compare(this.f5154c[i10], t10) < 0) {
                i(i13, i10);
                i13++;
            }
            i10++;
        }
        T[] tArr2 = this.f5154c;
        tArr2[i11] = tArr2[i13];
        tArr2[i13] = t10;
        return i13;
    }

    public final void i(int i10, int j10) {
        T[] tArr = this.f5154c;
        T t10 = tArr[i10];
        tArr[i10] = tArr[j10];
        tArr[j10] = t10;
    }

    public List<T> j() {
        T[] tArr = this.f5154c;
        Arrays.sort(tArr, 0, this.f5155d, this.f5153b);
        int i10 = this.f5155d;
        int i11 = this.f5152a;
        if (i10 > i11) {
            T[] tArr2 = this.f5154c;
            Arrays.fill(tArr2, i11, tArr2.length, (Object) null);
            int i12 = this.f5152a;
            this.f5155d = i12;
            this.f5156e = this.f5154c[i12 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(tArr, this.f5155d)));
    }

    public final void k() {
        int i10 = (this.f5152a * 2) - 1;
        int iP = m1.f.p(i10, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i11 = 0;
        int i12 = 0;
        while (iMax < i10) {
            int iH = h(iMax, i10, ((iMax + i10) + 1) >>> 1);
            int i13 = this.f5152a;
            if (iH <= i13) {
                if (iH >= i13) {
                    break;
                }
                iMax = Math.max(iH, iMax + 1);
                i12 = iH;
            } else {
                i10 = iH - 1;
            }
            i11++;
            if (i11 >= iP) {
                Arrays.sort(this.f5154c, iMax, i10 + 1, this.f5153b);
                break;
            }
        }
        this.f5155d = this.f5152a;
        this.f5156e = this.f5154c[i12];
        while (true) {
            i12++;
            if (i12 >= this.f5152a) {
                return;
            }
            if (this.f5153b.compare(this.f5154c[i12], this.f5156e) > 0) {
                this.f5156e = this.f5154c[i12];
            }
        }
    }
}
