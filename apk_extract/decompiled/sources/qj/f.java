package qj;

import androidx.work.WorkRequest;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import k3.qc;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements h, g, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f9194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9195b;

    public final void A(long j8) throws EOFException {
        while (j8 > 0) {
            u uVar = this.f9194a;
            if (uVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j8, uVar.f9226c - uVar.f9225b);
            long j10 = iMin;
            this.f9195b -= j10;
            j8 -= j10;
            int i8 = uVar.f9225b + iMin;
            uVar.f9225b = i8;
            if (i8 == uVar.f9226c) {
                this.f9194a = uVar.a();
                v.a(uVar);
            }
        }
    }

    public final j B() {
        long j8 = this.f9195b;
        if (j8 <= 2147483647L) {
            return E((int) j8);
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f9195b).toString());
    }

    @Override // qj.h
    public final long C(f sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j8 = this.f9195b;
        if (j8 > 0) {
            sink.k0(this, j8);
        }
        return j8;
    }

    public final j E(int i8) {
        if (i8 == 0) {
            return j.EMPTY;
        }
        qc.b(this.f9195b, 0L, i8);
        u uVar = this.f9194a;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            Intrinsics.checkNotNull(uVar);
            int i12 = uVar.f9226c;
            int i13 = uVar.f9225b;
            if (i12 == i13) {
                throw new AssertionError("s.limit == s.pos");
            }
            i10 += i12 - i13;
            i11++;
            uVar = uVar.f;
        }
        byte[][] bArr = new byte[i11][];
        int[] iArr = new int[i11 * 2];
        u uVar2 = this.f9194a;
        int i14 = 0;
        while (i9 < i8) {
            Intrinsics.checkNotNull(uVar2);
            bArr[i14] = uVar2.f9224a;
            i9 += uVar2.f9226c - uVar2.f9225b;
            iArr[i14] = Math.min(i9, i8);
            iArr[i14 + i11] = uVar2.f9225b;
            uVar2.f9227d = true;
            i14++;
            uVar2 = uVar2.f;
        }
        return new w(bArr, iArr);
    }

    @Override // qj.g
    public final g F(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        L(source, 0, source.length);
        return this;
    }

    public final u H(int i8) {
        if (i8 < 1 || i8 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        u uVar = this.f9194a;
        if (uVar == null) {
            u uVarB = v.b();
            this.f9194a = uVarB;
            uVarB.f9228g = uVarB;
            uVarB.f = uVarB;
            return uVarB;
        }
        Intrinsics.checkNotNull(uVar);
        u uVar2 = uVar.f9228g;
        Intrinsics.checkNotNull(uVar2);
        if (uVar2.f9226c + i8 <= 8192 && uVar2.e) {
            return uVar2;
        }
        u uVarB2 = v.b();
        uVar2.b(uVarB2);
        return uVarB2;
    }

    public final void I(j byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
    }

    public final void L(byte[] source, int i8, int i9) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j8 = i9;
        qc.b(source.length, i8, j8);
        int i10 = i9 + i8;
        while (i8 < i10) {
            u uVarH = H(1);
            int iMin = Math.min(i10 - i8, 8192 - uVarH.f9226c);
            int i11 = i8 + iMin;
            ArraysKt.copyInto(source, uVarH.f9224a, uVarH.f9226c, i8, i11);
            uVarH.f9226c += iMin;
            i8 = i11;
        }
        this.f9195b += j8;
    }

    @Override // qj.g
    public final /* bridge */ /* synthetic */ g M(long j8) {
        X(j8);
        return this;
    }

    public final void N(z source) {
        Intrinsics.checkNotNullParameter(source, "source");
        while (source.W(this, 8192L) != -1) {
        }
    }

    public final void S(int i8) {
        u uVarH = H(1);
        int i9 = uVarH.f9226c;
        uVarH.f9226c = i9 + 1;
        uVarH.f9224a[i9] = (byte) i8;
        this.f9195b++;
    }

    public final boolean T() {
        return this.f9195b == 0;
    }

    @Override // qj.z
    public final long W(f sink, long j8) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        long j10 = this.f9195b;
        if (j10 == 0) {
            return -1L;
        }
        if (j8 > j10) {
            j8 = j10;
        }
        sink.k0(this, j8);
        return j8;
    }

    public final void X(long j8) {
        boolean z2;
        byte[] bArr;
        if (j8 == 0) {
            S(48);
            return;
        }
        int i8 = 1;
        if (j8 < 0) {
            j8 = -j8;
            if (j8 < 0) {
                m0("-9223372036854775808");
                return;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (j8 < 100000000) {
            if (j8 < WorkRequest.MIN_BACKOFF_MILLIS) {
                if (j8 >= 100) {
                    i8 = j8 < 1000 ? 3 : 4;
                } else if (j8 >= 10) {
                    i8 = 2;
                }
            } else if (j8 < 1000000) {
                i8 = j8 < 100000 ? 5 : 6;
            } else {
                i8 = j8 < 10000000 ? 7 : 8;
            }
        } else if (j8 < 1000000000000L) {
            if (j8 < 10000000000L) {
                i8 = j8 < 1000000000 ? 9 : 10;
            } else {
                i8 = j8 < 100000000000L ? 11 : 12;
            }
        } else if (j8 < 1000000000000000L) {
            if (j8 < 10000000000000L) {
                i8 = 13;
            } else {
                i8 = j8 < 100000000000000L ? 14 : 15;
            }
        } else if (j8 < 100000000000000000L) {
            i8 = j8 < 10000000000000000L ? 16 : 17;
        } else {
            i8 = j8 < 1000000000000000000L ? 18 : 19;
        }
        if (z2) {
            i8++;
        }
        u uVarH = H(i8);
        int i9 = uVarH.f9226c + i8;
        while (true) {
            bArr = uVarH.f9224a;
            if (j8 == 0) {
                break;
            }
            long j10 = 10;
            i9--;
            bArr[i9] = rj.a.f9440a[(int) (j8 % j10)];
            j8 /= j10;
        }
        if (z2) {
            bArr[i9 - 1] = 45;
        }
        uVarH.f9226c += i8;
        this.f9195b += (long) i8;
    }

    @Override // qj.g
    public final /* bridge */ /* synthetic */ g Y(byte[] bArr, int i8, int i9) {
        L(bArr, i8, i9);
        return this;
    }

    public final void a() throws EOFException {
        A(this.f9195b);
    }

    public final void a0(long j8) {
        if (j8 == 0) {
            S(48);
            return;
        }
        long j10 = (j8 >>> 1) | j8;
        long j11 = j10 | (j10 >>> 2);
        long j12 = j11 | (j11 >>> 4);
        long j13 = j12 | (j12 >>> 8);
        long j14 = j13 | (j13 >>> 16);
        long j15 = j14 | (j14 >>> 32);
        long j16 = j15 - ((j15 >>> 1) & 6148914691236517205L);
        long j17 = ((j16 >>> 2) & 3689348814741910323L) + (j16 & 3689348814741910323L);
        long j18 = ((j17 >>> 4) + j17) & 1085102592571150095L;
        long j19 = j18 + (j18 >>> 8);
        long j20 = j19 + (j19 >>> 16);
        int i8 = (int) ((((j20 & 63) + ((j20 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        u uVarH = H(i8);
        int i9 = uVarH.f9226c;
        for (int i10 = (i9 + i8) - 1; i10 >= i9; i10--) {
            uVarH.f9224a[i10] = rj.a.f9440a[(int) (15 & j8)];
            j8 >>>= 4;
        }
        uVarH.f9226c += i8;
        this.f9195b += (long) i8;
    }

    @Override // qj.z
    public final b0 b() {
        return b0.f9179d;
    }

    public final void b0(int i8) {
        u uVarH = H(4);
        int i9 = uVarH.f9226c;
        byte[] bArr = uVarH.f9224a;
        bArr[i9] = (byte) ((i8 >>> 24) & 255);
        bArr[i9 + 1] = (byte) ((i8 >>> 16) & 255);
        bArr[i9 + 2] = (byte) ((i8 >>> 8) & 255);
        bArr[i9 + 3] = (byte) (i8 & 255);
        uVarH.f9226c = i9 + 4;
        this.f9195b += 4;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final f clone() {
        f fVar = new f();
        if (this.f9195b != 0) {
            u uVar = this.f9194a;
            Intrinsics.checkNotNull(uVar);
            u uVarC = uVar.c();
            fVar.f9194a = uVarC;
            uVarC.f9228g = uVarC;
            uVarC.f = uVarC;
            for (u uVar2 = uVar.f; uVar2 != uVar; uVar2 = uVar2.f) {
                u uVar3 = uVarC.f9228g;
                Intrinsics.checkNotNull(uVar3);
                Intrinsics.checkNotNull(uVar2);
                uVar3.b(uVar2.c());
            }
            fVar.f9195b = this.f9195b;
        }
        return fVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, qj.x
    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                long j8 = this.f9195b;
                f fVar = (f) obj;
                if (j8 == fVar.f9195b) {
                    if (j8 != 0) {
                        u uVar = this.f9194a;
                        Intrinsics.checkNotNull(uVar);
                        u uVar2 = fVar.f9194a;
                        Intrinsics.checkNotNull(uVar2);
                        int i8 = uVar.f9225b;
                        int i9 = uVar2.f9225b;
                        long j10 = 0;
                        while (j10 < this.f9195b) {
                            long jMin = Math.min(uVar.f9226c - i8, uVar2.f9226c - i9);
                            long j11 = 0;
                            while (j11 < jMin) {
                                int i10 = i8 + 1;
                                byte b9 = uVar.f9224a[i8];
                                int i11 = i9 + 1;
                                if (b9 == uVar2.f9224a[i9]) {
                                    j11++;
                                    i9 = i11;
                                    i8 = i10;
                                }
                            }
                            if (i8 == uVar.f9226c) {
                                u uVar3 = uVar.f;
                                Intrinsics.checkNotNull(uVar3);
                                i8 = uVar3.f9225b;
                                uVar = uVar3;
                            }
                            if (i9 == uVar2.f9226c) {
                                uVar2 = uVar2.f;
                                Intrinsics.checkNotNull(uVar2);
                                i9 = uVar2.f9225b;
                            }
                            j10 += jMin;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() {
    }

    @Override // qj.h, qj.g
    public final f getBuffer() {
        return this;
    }

    public final long h() {
        long j8 = this.f9195b;
        if (j8 == 0) {
            return 0L;
        }
        u uVar = this.f9194a;
        Intrinsics.checkNotNull(uVar);
        u uVar2 = uVar.f9228g;
        Intrinsics.checkNotNull(uVar2);
        int i8 = uVar2.f9226c;
        if (i8 < 8192 && uVar2.e) {
            j8 -= (long) (i8 - uVar2.f9225b);
        }
        return j8;
    }

    public final int hashCode() {
        u uVar = this.f9194a;
        if (uVar == null) {
            return 0;
        }
        int i8 = 1;
        do {
            int i9 = uVar.f9226c;
            for (int i10 = uVar.f9225b; i10 < i9; i10++) {
                i8 = (i8 * 31) + uVar.f9224a[i10];
            }
            uVar = uVar.f;
            Intrinsics.checkNotNull(uVar);
        } while (uVar != this.f9194a);
        return i8;
    }

    public final void i(f out, long j8, long j10) {
        Intrinsics.checkNotNullParameter(out, "out");
        qc.b(this.f9195b, j8, j10);
        if (j10 == 0) {
            return;
        }
        out.f9195b += j10;
        u uVar = this.f9194a;
        while (true) {
            Intrinsics.checkNotNull(uVar);
            long j11 = uVar.f9226c - uVar.f9225b;
            if (j8 < j11) {
                break;
            }
            j8 -= j11;
            uVar = uVar.f;
        }
        while (j10 > 0) {
            Intrinsics.checkNotNull(uVar);
            u uVarC = uVar.c();
            int i8 = uVarC.f9225b + ((int) j8);
            uVarC.f9225b = i8;
            uVarC.f9226c = Math.min(i8 + ((int) j10), uVarC.f9226c);
            u uVar2 = out.f9194a;
            if (uVar2 == null) {
                uVarC.f9228g = uVarC;
                uVarC.f = uVarC;
                out.f9194a = uVarC;
            } else {
                Intrinsics.checkNotNull(uVar2);
                u uVar3 = uVar2.f9228g;
                Intrinsics.checkNotNull(uVar3);
                uVar3.b(uVarC);
            }
            j10 -= (long) (uVarC.f9226c - uVarC.f9225b);
            uVar = uVar.f;
            j8 = 0;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // qj.h
    public final InputStream j0() {
        return new mh.b(this, 2);
    }

    public final byte k(long j8) {
        qc.b(this.f9195b, j8, 1L);
        u uVar = this.f9194a;
        if (uVar == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        long j10 = this.f9195b;
        if (j10 - j8 < j8) {
            while (j10 > j8) {
                uVar = uVar.f9228g;
                Intrinsics.checkNotNull(uVar);
                j10 -= (long) (uVar.f9226c - uVar.f9225b);
            }
            Intrinsics.checkNotNull(uVar);
            return uVar.f9224a[(int) ((((long) uVar.f9225b) + j8) - j10)];
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (uVar.f9226c - uVar.f9225b)) + j11;
            if (j12 > j8) {
                Intrinsics.checkNotNull(uVar);
                return uVar.f9224a[(int) ((((long) uVar.f9225b) + j8) - j11)];
            }
            uVar = uVar.f;
            Intrinsics.checkNotNull(uVar);
            j11 = j12;
        }
    }

    @Override // qj.x
    public final void k0(f source, long j8) {
        u uVar;
        u uVarB;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        qc.b(source.f9195b, 0L, j8);
        while (j8 > 0) {
            u uVar2 = source.f9194a;
            Intrinsics.checkNotNull(uVar2);
            int i8 = uVar2.f9226c;
            u uVar3 = source.f9194a;
            Intrinsics.checkNotNull(uVar3);
            long j10 = i8 - uVar3.f9225b;
            int i9 = 0;
            if (j8 < j10) {
                u uVar4 = this.f9194a;
                if (uVar4 != null) {
                    Intrinsics.checkNotNull(uVar4);
                    uVar = uVar4.f9228g;
                } else {
                    uVar = null;
                }
                if (uVar != null && uVar.e) {
                    if ((((long) uVar.f9226c) + j8) - ((long) (uVar.f9227d ? 0 : uVar.f9225b)) <= 8192) {
                        u uVar5 = source.f9194a;
                        Intrinsics.checkNotNull(uVar5);
                        uVar5.d(uVar, (int) j8);
                        source.f9195b -= j8;
                        this.f9195b += j8;
                        return;
                    }
                }
                u uVar6 = source.f9194a;
                Intrinsics.checkNotNull(uVar6);
                int i10 = (int) j8;
                if (i10 <= 0) {
                    uVar6.getClass();
                } else if (i10 <= uVar6.f9226c - uVar6.f9225b) {
                    if (i10 >= 1024) {
                        uVarB = uVar6.c();
                    } else {
                        uVarB = v.b();
                        int i11 = uVar6.f9225b;
                        ArraysKt___ArraysJvmKt.copyInto$default(uVar6.f9224a, uVarB.f9224a, 0, i11, i11 + i10, 2, (Object) null);
                    }
                    uVarB.f9226c = uVarB.f9225b + i10;
                    uVar6.f9225b += i10;
                    u uVar7 = uVar6.f9228g;
                    Intrinsics.checkNotNull(uVar7);
                    uVar7.b(uVarB);
                    source.f9194a = uVarB;
                }
                throw new IllegalArgumentException("byteCount out of range");
            }
            u uVar8 = source.f9194a;
            Intrinsics.checkNotNull(uVar8);
            long j11 = uVar8.f9226c - uVar8.f9225b;
            source.f9194a = uVar8.a();
            u uVar9 = this.f9194a;
            if (uVar9 == null) {
                this.f9194a = uVar8;
                uVar8.f9228g = uVar8;
                uVar8.f = uVar8;
            } else {
                Intrinsics.checkNotNull(uVar9);
                u uVar10 = uVar9.f9228g;
                Intrinsics.checkNotNull(uVar10);
                uVar10.b(uVar8);
                u uVar11 = uVar8.f9228g;
                if (uVar11 == uVar8) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.checkNotNull(uVar11);
                if (uVar11.e) {
                    int i12 = uVar8.f9226c - uVar8.f9225b;
                    u uVar12 = uVar8.f9228g;
                    Intrinsics.checkNotNull(uVar12);
                    int i13 = 8192 - uVar12.f9226c;
                    u uVar13 = uVar8.f9228g;
                    Intrinsics.checkNotNull(uVar13);
                    if (!uVar13.f9227d) {
                        u uVar14 = uVar8.f9228g;
                        Intrinsics.checkNotNull(uVar14);
                        i9 = uVar14.f9225b;
                    }
                    if (i12 <= i13 + i9) {
                        u uVar15 = uVar8.f9228g;
                        Intrinsics.checkNotNull(uVar15);
                        uVar8.d(uVar15, i12);
                        uVar8.a();
                        v.a(uVar8);
                    }
                }
            }
            source.f9195b -= j11;
            this.f9195b += j11;
            j8 -= j11;
        }
    }

    public final long l(byte b9, long j8, long j10) {
        u uVar;
        long j11 = j8;
        long j12 = j10;
        long j13 = 0;
        if (0 > j11 || j11 > j12) {
            throw new IllegalArgumentException(("size=" + this.f9195b + " fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        long j14 = this.f9195b;
        if (j12 > j14) {
            j12 = j14;
        }
        if (j11 != j12 && (uVar = this.f9194a) != null) {
            if (j14 - j11 < j11) {
                while (j14 > j11) {
                    uVar = uVar.f9228g;
                    Intrinsics.checkNotNull(uVar);
                    j14 -= (long) (uVar.f9226c - uVar.f9225b);
                }
                while (j14 < j12) {
                    byte[] bArr = uVar.f9224a;
                    int iMin = (int) Math.min(uVar.f9226c, (((long) uVar.f9225b) + j12) - j14);
                    for (int i8 = (int) ((((long) uVar.f9225b) + j11) - j14); i8 < iMin; i8++) {
                        if (bArr[i8] == b9) {
                            return ((long) (i8 - uVar.f9225b)) + j14;
                        }
                    }
                    j14 += (long) (uVar.f9226c - uVar.f9225b);
                    uVar = uVar.f;
                    Intrinsics.checkNotNull(uVar);
                    j11 = j14;
                }
            } else {
                while (true) {
                    long j15 = ((long) (uVar.f9226c - uVar.f9225b)) + j13;
                    if (j15 > j11) {
                        break;
                    }
                    uVar = uVar.f;
                    Intrinsics.checkNotNull(uVar);
                    j13 = j15;
                }
                while (j13 < j12) {
                    byte[] bArr2 = uVar.f9224a;
                    int iMin2 = (int) Math.min(uVar.f9226c, (((long) uVar.f9225b) + j12) - j13);
                    for (int i9 = (int) ((((long) uVar.f9225b) + j11) - j13); i9 < iMin2; i9++) {
                        if (bArr2[i9] == b9) {
                            return ((long) (i9 - uVar.f9225b)) + j13;
                        }
                    }
                    j13 += (long) (uVar.f9226c - uVar.f9225b);
                    uVar = uVar.f;
                    Intrinsics.checkNotNull(uVar);
                    j11 = j13;
                }
            }
        }
        return -1L;
    }

    public final void l0(int i8, int i9, String string) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(string, "string");
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "beginIndex < 0: ").toString());
        }
        if (i9 < i8) {
            throw new IllegalArgumentException(o.d.f(i9, i8, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i9 > string.length()) {
            StringBuilder sbU = a1.a.u(i9, "endIndex > string.length: ", " > ");
            sbU.append(string.length());
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        while (i8 < i9) {
            char cCharAt2 = string.charAt(i8);
            if (cCharAt2 < 128) {
                u uVarH = H(1);
                int i10 = uVarH.f9226c - i8;
                int iMin = Math.min(i9, 8192 - i10);
                int i11 = i8 + 1;
                byte[] bArr = uVarH.f9224a;
                bArr[i8 + i10] = (byte) cCharAt2;
                while (true) {
                    i8 = i11;
                    if (i8 >= iMin || (cCharAt = string.charAt(i8)) >= 128) {
                        break;
                    }
                    i11 = i8 + 1;
                    bArr[i8 + i10] = (byte) cCharAt;
                }
                int i12 = uVarH.f9226c;
                int i13 = (i10 + i8) - i12;
                uVarH.f9226c = i12 + i13;
                this.f9195b += (long) i13;
            } else {
                if (cCharAt2 < 2048) {
                    u uVarH2 = H(2);
                    int i14 = uVarH2.f9226c;
                    byte[] bArr2 = uVarH2.f9224a;
                    bArr2[i14] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    uVarH2.f9226c = i14 + 2;
                    this.f9195b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    u uVarH3 = H(3);
                    int i15 = uVarH3.f9226c;
                    byte[] bArr3 = uVarH3.f9224a;
                    bArr3[i15] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    uVarH3.f9226c = i15 + 3;
                    this.f9195b += 3;
                } else {
                    int i16 = i8 + 1;
                    char cCharAt3 = i16 < i9 ? string.charAt(i16) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        S(63);
                        i8 = i16;
                    } else {
                        int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        u uVarH4 = H(4);
                        int i18 = uVarH4.f9226c;
                        byte[] bArr4 = uVarH4.f9224a;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        uVarH4.f9226c = i18 + 4;
                        this.f9195b += 4;
                        i8 += 2;
                    }
                }
                i8++;
            }
        }
    }

    public final byte[] m(long j8) throws EOFException {
        if (j8 < 0 || j8 > 2147483647L) {
            throw new IllegalArgumentException(o.d.j("byteCount: ", j8).toString());
        }
        if (this.f9195b < j8) {
            throw new EOFException();
        }
        int i8 = (int) j8;
        byte[] sink = new byte[i8];
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i9 = 0;
        while (i9 < i8) {
            int i10 = read(sink, i9, i8 - i9);
            if (i10 == -1) {
                throw new EOFException();
            }
            i9 += i10;
        }
        return sink;
    }

    public final void m0(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        l0(0, string.length(), string);
    }

    @Override // qj.h
    public final f n() {
        return this;
    }

    public final void n0(int i8) {
        String strConcatToString;
        int i9 = 0;
        if (i8 < 128) {
            S(i8);
            return;
        }
        if (i8 < 2048) {
            u uVarH = H(2);
            int i10 = uVarH.f9226c;
            byte[] bArr = uVarH.f9224a;
            bArr[i10] = (byte) ((i8 >> 6) | 192);
            bArr[1 + i10] = (byte) ((i8 & 63) | 128);
            uVarH.f9226c = i10 + 2;
            this.f9195b += 2;
            return;
        }
        if (55296 <= i8 && i8 < 57344) {
            S(63);
            return;
        }
        if (i8 < 65536) {
            u uVarH2 = H(3);
            int i11 = uVarH2.f9226c;
            byte[] bArr2 = uVarH2.f9224a;
            bArr2[i11] = (byte) ((i8 >> 12) | 224);
            bArr2[1 + i11] = (byte) (((i8 >> 6) & 63) | 128);
            bArr2[2 + i11] = (byte) ((i8 & 63) | 128);
            uVarH2.f9226c = i11 + 3;
            this.f9195b += 3;
            return;
        }
        if (i8 <= 1114111) {
            u uVarH3 = H(4);
            int i12 = uVarH3.f9226c;
            byte[] bArr3 = uVarH3.f9224a;
            bArr3[i12] = (byte) ((i8 >> 18) | 240);
            bArr3[1 + i12] = (byte) (((i8 >> 12) & 63) | 128);
            bArr3[2 + i12] = (byte) (((i8 >> 6) & 63) | 128);
            bArr3[3 + i12] = (byte) ((i8 & 63) | 128);
            uVarH3.f9226c = i12 + 4;
            this.f9195b += 4;
            return;
        }
        StringBuilder sb2 = new StringBuilder("Unexpected code point: 0x");
        if (i8 != 0) {
            char[] cArr = rj.b.f9441a;
            char[] cArr2 = {cArr[(i8 >> 28) & 15], cArr[(i8 >> 24) & 15], cArr[(i8 >> 20) & 15], cArr[(i8 >> 16) & 15], cArr[(i8 >> 12) & 15], cArr[(i8 >> 8) & 15], cArr[(i8 >> 4) & 15], cArr[i8 & 15]};
            while (i9 < 8 && cArr2[i9] == '0') {
                i9++;
            }
            strConcatToString = StringsKt.concatToString(cArr2, i9, 8);
        } else {
            strConcatToString = "0";
        }
        sb2.append(strConcatToString);
        throw new IllegalArgumentException(sb2.toString());
    }

    public final j o(long j8) throws EOFException {
        if (j8 < 0 || j8 > 2147483647L) {
            throw new IllegalArgumentException(o.d.j("byteCount: ", j8).toString());
        }
        if (this.f9195b < j8) {
            throw new EOFException();
        }
        if (j8 < 4096) {
            return new j(m(j8));
        }
        j jVarE = E((int) j8);
        A(j8);
        return jVarE;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        u uVar = this.f9194a;
        if (uVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), uVar.f9226c - uVar.f9225b);
        sink.put(uVar.f9224a, uVar.f9225b, iMin);
        int i8 = uVar.f9225b + iMin;
        uVar.f9225b = i8;
        this.f9195b -= (long) iMin;
        if (i8 == uVar.f9226c) {
            this.f9194a = uVar.a();
            v.a(uVar);
        }
        return iMin;
    }

    public final byte readByte() throws EOFException {
        if (this.f9195b == 0) {
            throw new EOFException();
        }
        u uVar = this.f9194a;
        Intrinsics.checkNotNull(uVar);
        int i8 = uVar.f9225b;
        int i9 = uVar.f9226c;
        int i10 = i8 + 1;
        byte b9 = uVar.f9224a[i8];
        this.f9195b--;
        if (i10 == i9) {
            this.f9194a = uVar.a();
            v.a(uVar);
        } else {
            uVar.f9225b = i10;
        }
        return b9;
    }

    public final int readInt() throws EOFException {
        if (this.f9195b < 4) {
            throw new EOFException();
        }
        u uVar = this.f9194a;
        Intrinsics.checkNotNull(uVar);
        int i8 = uVar.f9225b;
        int i9 = uVar.f9226c;
        if (i9 - i8 < 4) {
            return (readByte() & UByte.MAX_VALUE) | ((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16) | ((readByte() & UByte.MAX_VALUE) << 8);
        }
        byte[] bArr = uVar.f9224a;
        int i10 = i8 + 3;
        int i11 = ((bArr[i8 + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i8] & UByte.MAX_VALUE) << 24) | ((bArr[i8 + 2] & UByte.MAX_VALUE) << 8);
        int i12 = i8 + 4;
        int i13 = i11 | (bArr[i10] & UByte.MAX_VALUE);
        this.f9195b -= 4;
        if (i12 == i9) {
            this.f9194a = uVar.a();
            v.a(uVar);
        } else {
            uVar.f9225b = i12;
        }
        return i13;
    }

    @Override // qj.h
    public final boolean request(long j8) {
        return this.f9195b >= j8;
    }

    public final short s() throws EOFException {
        if (this.f9195b < 2) {
            throw new EOFException();
        }
        u uVar = this.f9194a;
        Intrinsics.checkNotNull(uVar);
        int i8 = uVar.f9225b;
        int i9 = uVar.f9226c;
        if (i9 - i8 < 2) {
            return (short) ((readByte() & UByte.MAX_VALUE) | ((readByte() & UByte.MAX_VALUE) << 8));
        }
        int i10 = i8 + 1;
        byte[] bArr = uVar.f9224a;
        int i11 = (bArr[i8] & UByte.MAX_VALUE) << 8;
        int i12 = i8 + 2;
        int i13 = (bArr[i10] & UByte.MAX_VALUE) | i11;
        this.f9195b -= 2;
        if (i12 == i9) {
            this.f9194a = uVar.a();
            v.a(uVar);
        } else {
            uVar.f9225b = i12;
        }
        return (short) i13;
    }

    public final String t(long j8, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j8 < 0 || j8 > 2147483647L) {
            throw new IllegalArgumentException(o.d.j("byteCount: ", j8).toString());
        }
        if (this.f9195b < j8) {
            throw new EOFException();
        }
        if (j8 == 0) {
            return "";
        }
        u uVar = this.f9194a;
        Intrinsics.checkNotNull(uVar);
        int i8 = uVar.f9225b;
        if (((long) i8) + j8 > uVar.f9226c) {
            return new String(m(j8), charset);
        }
        int i9 = (int) j8;
        String str = new String(uVar.f9224a, i8, i9, charset);
        int i10 = uVar.f9225b + i9;
        uVar.f9225b = i10;
        this.f9195b -= j8;
        if (i10 == uVar.f9226c) {
            this.f9194a = uVar.a();
            v.a(uVar);
        }
        return str;
    }

    public final String toString() {
        return B().toString();
    }

    @Override // qj.g
    public final /* bridge */ /* synthetic */ g v(String str) {
        m0(str);
        return this;
    }

    public final String w() {
        return t(this.f9195b, Charsets.UTF_8);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i8 = iRemaining;
        while (i8 > 0) {
            u uVarH = H(1);
            int iMin = Math.min(i8, 8192 - uVarH.f9226c);
            source.get(uVarH.f9224a, uVarH.f9226c, iMin);
            i8 -= iMin;
            uVarH.f9226c += iMin;
        }
        this.f9195b += (long) iRemaining;
        return iRemaining;
    }

    @Override // qj.h
    public final int x(p options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        int iB = rj.a.b(this, options, false);
        if (iB == -1) {
            return -1;
        }
        A(options.f9209a[iB].size());
        return iB;
    }

    @Override // qj.g
    public final /* bridge */ /* synthetic */ g z(j jVar) {
        I(jVar);
        return this;
    }

    public final int read(byte[] sink, int i8, int i9) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        qc.b(sink.length, i8, i9);
        u uVar = this.f9194a;
        if (uVar == null) {
            return -1;
        }
        int iMin = Math.min(i9, uVar.f9226c - uVar.f9225b);
        int i10 = uVar.f9225b;
        ArraysKt.copyInto(uVar.f9224a, sink, i8, i10, i10 + iMin);
        int i11 = uVar.f9225b + iMin;
        uVar.f9225b = i11;
        this.f9195b -= (long) iMin;
        if (i11 == uVar.f9226c) {
            this.f9194a = uVar.a();
            v.a(uVar);
        }
        return iMin;
    }
}
