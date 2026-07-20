package l3;

import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class o2 {
    public static final o2 f = new o2(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f7280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f7281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7282d = -1;
    public boolean e;

    public o2(int i8, int[] iArr, Object[] objArr, boolean z2) {
        this.f7279a = i8;
        this.f7280b = iArr;
        this.f7281c = objArr;
        this.e = z2;
    }

    public static o2 b() {
        return new o2(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int i8 = this.f7282d;
        if (i8 != -1) {
            return i8;
        }
        int iB = 0;
        for (int i9 = 0; i9 < this.f7279a; i9++) {
            int i10 = this.f7280b[i9];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                iB = h0.a.b(i11 << 3, c0.r(((Long) this.f7281c[i9]).longValue()), iB);
            } else if (i12 == 1) {
                ((Long) this.f7281c[i9]).getClass();
                iB = h0.a.b(i11 << 3, 8, iB);
            } else if (i12 == 2) {
                b0 b0Var = (b0) this.f7281c[i9];
                Logger logger = c0.e;
                int iZzd = b0Var.zzd();
                iB = h0.a.b(i11 << 3, c0.q(iZzd) + iZzd, iB);
            } else if (i12 == 3) {
                int i13 = i11 << 3;
                Logger logger2 = c0.e;
                int iA = ((o2) this.f7281c[i9]).a();
                int iQ = c0.q(i13);
                iB = iQ + iQ + iA + iB;
            } else {
                if (i12 != 5) {
                    throw new IllegalStateException(b1.zza());
                }
                ((Integer) this.f7281c[i9]).getClass();
                iB = h0.a.b(i11 << 3, 4, iB);
            }
        }
        this.f7282d = iB;
        return iB;
    }

    public final void c(int i8, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        e(this.f7279a + 1);
        int[] iArr = this.f7280b;
        int i9 = this.f7279a;
        iArr[i9] = i8;
        this.f7281c[i9] = obj;
        this.f7279a = i9 + 1;
    }

    public final void d(l1 l1Var) {
        if (this.f7279a != 0) {
            for (int i8 = 0; i8 < this.f7279a; i8++) {
                int i9 = this.f7280b[i8];
                Object obj = this.f7281c[i8];
                int i10 = i9 & 7;
                int i11 = i9 >>> 3;
                if (i10 == 0) {
                    l1Var.o(i11, ((Long) obj).longValue());
                } else if (i10 == 1) {
                    l1Var.k(i11, ((Long) obj).longValue());
                } else if (i10 == 2) {
                    l1Var.g(i11, (b0) obj);
                } else if (i10 == 3) {
                    ((c0) l1Var.f7264a).i(i11, 3);
                    ((o2) obj).d(l1Var);
                    ((c0) l1Var.f7264a).i(i11, 4);
                } else {
                    if (i10 != 5) {
                        throw new RuntimeException(b1.zza());
                    }
                    l1Var.j(i11, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void e(int i8) {
        int[] iArr = this.f7280b;
        if (i8 > iArr.length) {
            int i9 = this.f7279a;
            int i10 = (i9 / 2) + i9;
            if (i10 >= i8) {
                i8 = i10;
            }
            if (i8 < 8) {
                i8 = 8;
            }
            this.f7280b = Arrays.copyOf(iArr, i8);
            this.f7281c = Arrays.copyOf(this.f7281c, i8);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        int i8 = this.f7279a;
        if (i8 == o2Var.f7279a) {
            int[] iArr = this.f7280b;
            int[] iArr2 = o2Var.f7280b;
            for (int i9 = 0; i9 < i8; i9++) {
                if (iArr[i9] == iArr2[i9]) {
                }
            }
            Object[] objArr = this.f7281c;
            Object[] objArr2 = o2Var.f7281c;
            int i10 = this.f7279a;
            for (int i11 = 0; i11 < i10; i11++) {
                if (objArr[i11].equals(objArr2[i11])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i8 = this.f7279a;
        int i9 = i8 + 527;
        int[] iArr = this.f7280b;
        int iHashCode = 17;
        int i10 = 17;
        for (int i11 = 0; i11 < i8; i11++) {
            i10 = (i10 * 31) + iArr[i11];
        }
        int i12 = (i9 * 31) + i10;
        Object[] objArr = this.f7281c;
        int i13 = this.f7279a;
        for (int i14 = 0; i14 < i13; i14++) {
            iHashCode = (iHashCode * 31) + objArr[i14].hashCode();
        }
        return (i12 * 31) + iHashCode;
    }
}
