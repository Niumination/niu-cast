package i4;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import k3.f9;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object[] f5622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f5623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f5624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f5625d;
    public transient int[] e;
    public transient long[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient float f5626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f5627h;

    public final void a(int i8) {
        if (i8 > this.f.length) {
            i(i8);
        }
        if (i8 >= this.f5627h) {
            j(Math.max(2, Integer.highestOneBit(i8 - 1) << 1));
        }
    }

    public final int b(Object obj) {
        int iD = d(obj);
        if (iD == -1) {
            return 0;
        }
        return this.f5623b[iD];
    }

    public final int c(int i8) {
        v8.h(i8, this.f5624c);
        return this.f5623b[i8];
    }

    public final int d(Object obj) {
        int iB = f9.b(obj);
        int[] iArr = this.e;
        int i8 = iArr[(iArr.length - 1) & iB];
        while (i8 != -1) {
            long j8 = this.f[i8];
            if (((int) (j8 >>> 32)) == iB && u8.a(obj, this.f5622a[i8])) {
                return i8;
            }
            i8 = (int) j8;
        }
        return -1;
    }

    public final void e(int i8) {
        v8.c("Initial capacity must be non-negative", i8 >= 0);
        int iMax = Math.max(i8, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax > ((int) (((double) 1.0f) * ((double) iHighestOneBit)))) {
            int i9 = iHighestOneBit << 1;
            if (i9 <= 0) {
                i9 = BasicMeasure.EXACTLY;
            }
            iHighestOneBit = i9;
        }
        int[] iArr = new int[iHighestOneBit];
        Arrays.fill(iArr, -1);
        this.e = iArr;
        this.f5626g = 1.0f;
        this.f5622a = new Object[i8];
        this.f5623b = new int[i8];
        long[] jArr = new long[i8];
        Arrays.fill(jArr, -1L);
        this.f = jArr;
        this.f5627h = Math.max(1, (int) (iHighestOneBit * 1.0f));
    }

    public final int f(int i8, Object obj) {
        if (i8 <= 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "count must be positive but was: "));
        }
        long[] jArr = this.f;
        Object[] objArr = this.f5622a;
        int[] iArr = this.f5623b;
        int iB = f9.b(obj);
        int[] iArr2 = this.e;
        int length = (iArr2.length - 1) & iB;
        int i9 = this.f5624c;
        int i10 = iArr2[length];
        if (i10 == -1) {
            iArr2[length] = i9;
        } else {
            while (true) {
                long j8 = jArr[i10];
                if (((int) (j8 >>> 32)) == iB && u8.a(obj, objArr[i10])) {
                    int i11 = iArr[i10];
                    iArr[i10] = i8;
                    return i11;
                }
                int i12 = (int) j8;
                if (i12 == -1) {
                    jArr[i10] = ((-4294967296L) & j8) | (((long) i9) & 4294967295L);
                    break;
                }
                i10 = i12;
            }
        }
        if (i9 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i13 = i9 + 1;
        int length2 = this.f.length;
        if (i13 > length2) {
            int iMax = Math.max(1, length2 >>> 1) + length2;
            int i14 = iMax >= 0 ? iMax : Integer.MAX_VALUE;
            if (i14 != length2) {
                i(i14);
            }
        }
        this.f[i9] = (((long) iB) << 32) | 4294967295L;
        this.f5622a[i9] = obj;
        this.f5623b[i9] = i8;
        this.f5624c = i13;
        if (i9 >= this.f5627h) {
            j(this.e.length * 2);
        }
        this.f5625d++;
        return 0;
    }

    public final int g(Object obj, int i8) {
        long[] jArr;
        long j8;
        int[] iArr = this.e;
        int length = (iArr.length - 1) & i8;
        int i9 = iArr[length];
        if (i9 == -1) {
            return 0;
        }
        int i10 = -1;
        while (true) {
            if (((int) (this.f[i9] >>> 32)) == i8 && u8.a(obj, this.f5622a[i9])) {
                int[] iArr2 = this.f5623b;
                int i11 = iArr2[i9];
                if (i10 == -1) {
                    this.e[length] = (int) this.f[i9];
                } else {
                    long[] jArr2 = this.f;
                    jArr2[i10] = (((long) ((int) jArr2[i9])) & 4294967295L) | (jArr2[i10] & (-4294967296L));
                }
                int i12 = this.f5624c - 1;
                if (i9 < i12) {
                    Object[] objArr = this.f5622a;
                    objArr[i9] = objArr[i12];
                    iArr2[i9] = iArr2[i12];
                    objArr[i12] = null;
                    iArr2[i12] = 0;
                    long[] jArr3 = this.f;
                    long j10 = jArr3[i12];
                    jArr3[i9] = j10;
                    jArr3[i12] = -1;
                    int[] iArr3 = this.e;
                    int length2 = ((int) (j10 >>> 32)) & (iArr3.length - 1);
                    int i13 = iArr3[length2];
                    if (i13 == i12) {
                        iArr3[length2] = i9;
                    } else {
                        while (true) {
                            jArr = this.f;
                            j8 = jArr[i13];
                            int i14 = (int) j8;
                            if (i14 == i12) {
                                break;
                            }
                            i13 = i14;
                        }
                        jArr[i13] = (j8 & (-4294967296L)) | (((long) i9) & 4294967295L);
                    }
                } else {
                    this.f5622a[i9] = null;
                    iArr2[i9] = 0;
                    this.f[i9] = -1;
                }
                this.f5624c--;
                this.f5625d++;
                return i11;
            }
            int i15 = (int) this.f[i9];
            if (i15 == -1) {
                return 0;
            }
            i10 = i9;
            i9 = i15;
        }
    }

    public final int h(int i8) {
        return g(this.f5622a[i8], (int) (this.f[i8] >>> 32));
    }

    public final void i(int i8) {
        this.f5622a = Arrays.copyOf(this.f5622a, i8);
        this.f5623b = Arrays.copyOf(this.f5623b, i8);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i8);
        if (i8 > length) {
            Arrays.fill(jArrCopyOf, length, i8, -1L);
        }
        this.f = jArrCopyOf;
    }

    public final void j(int i8) {
        if (this.e.length >= 1073741824) {
            this.f5627h = Integer.MAX_VALUE;
            return;
        }
        int i9 = ((int) (i8 * this.f5626g)) + 1;
        int[] iArr = new int[i8];
        Arrays.fill(iArr, -1);
        long[] jArr = this.f;
        int i10 = i8 - 1;
        for (int i11 = 0; i11 < this.f5624c; i11++) {
            int i12 = (int) (jArr[i11] >>> 32);
            int i13 = i12 & i10;
            int i14 = iArr[i13];
            iArr[i13] = i11;
            jArr[i11] = (((long) i12) << 32) | (((long) i14) & 4294967295L);
        }
        this.f5627h = i9;
        this.e = iArr;
    }
}
