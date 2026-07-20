package tj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class e<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a[] f15580c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f15581d = {2, 5, 11, 17, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, y5.a.Z, 109, y5.a.f20718f0, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, TypedValues.AttributesType.TYPE_EASING, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, TypedValues.CycleType.TYPE_CURVE_FIT, 409, 419, TypedValues.CycleType.TYPE_WAVE_SHAPE, 431, 433, 439, wj.v0.f19368n, 449, 457, 461, 463, 467, 479, 487, 491, 499, TypedValues.PositionType.TYPE_PERCENT_WIDTH, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, TypedValues.MotionType.TYPE_PATHMOTION_ARC, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, TypedValues.TransitionType.TYPE_FROM, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, PointerIconCompat.TYPE_VERTICAL_TEXT, 2053, 3079, 4057, 7103, 10949, 16069, 32609, 65867, 104729};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a[] f15583b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f15585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f15586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f15587d;

        public a(int i10, Object obj, Object obj2, a aVar) {
            this.f15584a = i10;
            this.f15585b = obj;
            this.f15586c = obj2;
            this.f15587d = aVar;
        }

        public Object a(Object obj) {
            if (this.f15585b.equals(obj)) {
                return this.f15586c;
            }
            a aVar = this.f15587d;
            if (aVar != null) {
                return aVar.a(obj);
            }
            return null;
        }
    }

    public e() {
        this(0, f15580c);
    }

    public static int c(int i10) {
        for (int i11 : f15581d) {
            if (i11 > i10) {
                return i11;
            }
        }
        int[] iArr = f15581d;
        return iArr[iArr.length - 1];
    }

    public static void d(a[] aVarArr, a[] aVarArr2) {
        for (a aVar : aVarArr) {
            for (; aVar != null; aVar = aVar.f15587d) {
                f(aVarArr2, aVar);
            }
        }
    }

    public static <K, V> void e(a[] aVarArr, int i10, K k10, V v10) {
        int length = i10 % aVarArr.length;
        aVarArr[length] = new a(i10, k10, v10, aVarArr[length]);
    }

    public static void f(a[] aVarArr, a aVar) {
        int i10 = aVar.f15584a;
        int length = i10 % aVarArr.length;
        a aVar2 = aVarArr[length];
        if (aVar2 == null && aVar.f15587d == null) {
            aVarArr[length] = aVar;
        } else {
            aVarArr[length] = new a(i10, aVar.f15585b, aVar.f15586c, aVar2);
        }
    }

    public e<K, V> a(K k10, V v10) {
        int i10 = this.f15582a + 1;
        a[] aVarArr = this.f15583b;
        a[] aVarArr2 = i10 > aVarArr.length ? new a[c((i10 * 2) - 1)] : new a[aVarArr.length];
        int length = aVarArr2.length;
        a[] aVarArr3 = this.f15583b;
        if (length == aVarArr3.length) {
            System.arraycopy(aVarArr3, 0, aVarArr2, 0, aVarArr3.length);
        } else {
            d(aVarArr3, aVarArr2);
        }
        e(aVarArr2, Math.abs(k10.hashCode()), k10, v10);
        return new e<>(i10, aVarArr2);
    }

    public V b(K k10) {
        if (this.f15583b.length == 0) {
            return null;
        }
        int iAbs = Math.abs(k10.hashCode());
        a[] aVarArr = this.f15583b;
        a aVar = aVarArr[iAbs % aVarArr.length];
        if (aVar == null) {
            return null;
        }
        return (V) aVar.a(k10);
    }

    public e(int i10, a[] aVarArr) {
        this.f15582a = i10;
        this.f15583b = aVarArr;
    }
}
