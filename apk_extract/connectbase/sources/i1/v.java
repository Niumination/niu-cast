package i1;

import f1.l5;
import f1.t4;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.j
public final class v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public final Comparator<T> f7655b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7656a;

        static {
            int[] iArr = new int[b.values().length];
            f7656a = iArr;
            try {
                iArr[b.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7656a[b.INSERTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7656a[b.STABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7656a[b.SORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        UNORDERED,
        STABLE,
        INSERTION,
        SORTED
    }

    public v(b type, @gm.a Comparator<T> comparator) {
        type.getClass();
        this.f7654a = type;
        this.f7655b = comparator;
        c1.h0.g0((type == b.SORTED) == (comparator != null));
    }

    public static <S> v<S> d() {
        return new v<>(b.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> v<S> e() {
        return new v<>(b.SORTED, l5.natural());
    }

    public static <S> v<S> f(Comparator<S> comparator) {
        b bVar = b.SORTED;
        comparator.getClass();
        return new v<>(bVar, comparator);
    }

    public static <S> v<S> g() {
        return new v<>(b.STABLE, null);
    }

    public static <S> v<S> i() {
        return new v<>(b.UNORDERED, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T1 extends T> v<T1> a() {
        return this;
    }

    public Comparator<T> b() {
        Comparator<T> comparator = this.f7655b;
        if (comparator != null) {
            return comparator;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public <K extends T, V> Map<K, V> c(int expectedSize) {
        int i10 = a.f7656a[this.f7654a.ordinal()];
        if (i10 == 1) {
            return t4.a0(expectedSize);
        }
        if (i10 == 2 || i10 == 3) {
            return t4.e0(expectedSize);
        }
        if (i10 == 4) {
            return new TreeMap(b());
        }
        throw new AssertionError();
    }

    public boolean equals(@gm.a Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f7654a == vVar.f7654a && c1.b0.a(this.f7655b, vVar.f7655b);
    }

    public b h() {
        return this.f7654a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7654a, this.f7655b});
    }

    public String toString() {
        c1.z.b bVarJ = c1.z.c(this).j(ik.y0.a.f8215h, this.f7654a);
        Comparator<T> comparator = this.f7655b;
        if (comparator != null) {
            bVarJ.j("comparator", comparator);
        }
        return bVarJ.toString();
    }
}
