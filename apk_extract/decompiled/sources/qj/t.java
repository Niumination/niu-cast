package qj;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f9221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f9222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9223c;

    public t(z source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f9221a = source;
        this.f9222b = new f();
    }

    @Override // qj.h
    public final long C(f sink) {
        f fVar;
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j8 = 0;
        while (true) {
            fVar = this.f9222b;
            if (this.f9221a.W(fVar, 8192L) == -1) {
                break;
            }
            long jH = fVar.h();
            if (jH > 0) {
                j8 += jH;
                sink.k0(fVar, jH);
            }
        }
        long j10 = fVar.f9195b;
        if (j10 <= 0) {
            return j8;
        }
        long j11 = j8 + j10;
        sink.k0(fVar, j10);
        return j11;
    }

    public final void K(long j8) throws EOFException {
        if (!request(j8)) {
            throw new EOFException();
        }
    }

    public final boolean T() {
        if (this.f9223c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f9222b;
        return fVar.T() && this.f9221a.W(fVar, 8192L) == -1;
    }

    @Override // qj.z
    public final long W(f sink, long j8) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        if (this.f9223c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f9222b;
        if (fVar.f9195b == 0 && this.f9221a.W(fVar, 8192L) == -1) {
            return -1L;
        }
        return fVar.W(sink, Math.min(j8, fVar.f9195b));
    }

    public final long a(byte b9, long j8, long j10) {
        if (this.f9223c) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        if (0 > j10) {
            throw new IllegalArgumentException(o.d.j("fromIndex=0 toIndex=", j10).toString());
        }
        while (jMax < j10) {
            f fVar = this.f9222b;
            long jL = fVar.l(b9, jMax, j10);
            if (jL != -1) {
                return jL;
            }
            long j11 = fVar.f9195b;
            if (j11 >= j10 || this.f9221a.W(fVar, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j11);
        }
        return -1L;
    }

    @Override // qj.z
    public final b0 b() {
        return this.f9221a.b();
    }

    public final long c(j targetBytes) {
        int i8;
        int i9;
        long j8;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (this.f9223c) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            f fVar = this.f9222b;
            fVar.getClass();
            Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
            long j10 = 0;
            if (jMax < 0) {
                throw new IllegalArgumentException(o.d.j("fromIndex < 0: ", jMax).toString());
            }
            u uVar = fVar.f9194a;
            if (uVar == null) {
                j8 = -1;
            } else {
                long j11 = fVar.f9195b;
                int i12 = 0;
                if (j11 - jMax < jMax) {
                    while (j11 > jMax) {
                        uVar = uVar.f9228g;
                        Intrinsics.checkNotNull(uVar);
                        j11 -= (long) (uVar.f9226c - uVar.f9225b);
                    }
                    if (targetBytes.size() == 2) {
                        byte b9 = targetBytes.getByte(0);
                        byte b10 = targetBytes.getByte(1);
                        long j12 = jMax;
                        while (true) {
                            if (j11 < fVar.f9195b) {
                                byte[] bArr = uVar.f9224a;
                                i10 = (int) ((((long) uVar.f9225b) + j12) - j11);
                                int i13 = uVar.f9226c;
                                while (true) {
                                    if (i10 >= i13) {
                                        j12 = j11 + ((long) (uVar.f9226c - uVar.f9225b));
                                        uVar = uVar.f;
                                        Intrinsics.checkNotNull(uVar);
                                        j11 = j12;
                                    } else {
                                        byte b11 = bArr[i10];
                                        if (b11 == b9 || b11 == b10) {
                                            i11 = uVar.f9225b;
                                            j8 = ((long) (i10 - i11)) + j11;
                                        } else {
                                            i10++;
                                        }
                                    }
                                }
                            } else {
                                j8 = -1;
                            }
                        }
                    } else {
                        byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
                        long j13 = jMax;
                        while (true) {
                            if (j11 < fVar.f9195b) {
                                byte[] bArr2 = uVar.f9224a;
                                i10 = (int) ((((long) uVar.f9225b) + j13) - j11);
                                int i14 = uVar.f9226c;
                                while (true) {
                                    if (i10 < i14) {
                                        byte b12 = bArr2[i10];
                                        int length = bArrInternalArray$okio.length;
                                        int i15 = i12;
                                        while (true) {
                                            if (i15 >= length) {
                                                i10++;
                                                i12 = 0;
                                            } else if (b12 == bArrInternalArray$okio[i15]) {
                                                i11 = uVar.f9225b;
                                                j8 = ((long) (i10 - i11)) + j11;
                                            } else {
                                                i15++;
                                            }
                                        }
                                    } else {
                                        j13 = ((long) (uVar.f9226c - uVar.f9225b)) + j11;
                                        uVar = uVar.f;
                                        Intrinsics.checkNotNull(uVar);
                                        j11 = j13;
                                        i12 = 0;
                                    }
                                }
                            } else {
                                j8 = -1;
                            }
                        }
                    }
                } else {
                    while (true) {
                        long j14 = ((long) (uVar.f9226c - uVar.f9225b)) + j10;
                        if (j14 > jMax) {
                            break;
                        }
                        uVar = uVar.f;
                        Intrinsics.checkNotNull(uVar);
                        j10 = j14;
                    }
                    if (targetBytes.size() == 2) {
                        byte b13 = targetBytes.getByte(0);
                        byte b14 = targetBytes.getByte(1);
                        long j15 = jMax;
                        while (true) {
                            if (j10 < fVar.f9195b) {
                                byte[] bArr3 = uVar.f9224a;
                                i8 = (int) ((((long) uVar.f9225b) + j15) - j10);
                                int i16 = uVar.f9226c;
                                while (true) {
                                    if (i8 >= i16) {
                                        j15 = ((long) (uVar.f9226c - uVar.f9225b)) + j10;
                                        uVar = uVar.f;
                                        Intrinsics.checkNotNull(uVar);
                                        j10 = j15;
                                    } else {
                                        byte b15 = bArr3[i8];
                                        if (b15 == b13 || b15 == b14) {
                                            i9 = uVar.f9225b;
                                            j8 = ((long) (i8 - i9)) + j10;
                                        } else {
                                            i8++;
                                        }
                                    }
                                }
                            } else {
                                j8 = -1;
                            }
                        }
                    } else {
                        int i17 = 0;
                        byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
                        long j16 = jMax;
                        while (true) {
                            if (j10 < fVar.f9195b) {
                                byte[] bArr4 = uVar.f9224a;
                                i8 = (int) ((((long) uVar.f9225b) + j16) - j10);
                                int i18 = uVar.f9226c;
                                while (true) {
                                    if (i8 < i18) {
                                        byte b16 = bArr4[i8];
                                        int length2 = bArrInternalArray$okio2.length;
                                        int i19 = i17;
                                        while (true) {
                                            if (i19 >= length2) {
                                                i8++;
                                                i17 = 0;
                                            } else if (b16 == bArrInternalArray$okio2[i19]) {
                                                i9 = uVar.f9225b;
                                                j8 = ((long) (i8 - i9)) + j10;
                                            } else {
                                                i19++;
                                            }
                                        }
                                    } else {
                                        j16 = ((long) (uVar.f9226c - uVar.f9225b)) + j10;
                                        uVar = uVar.f;
                                        Intrinsics.checkNotNull(uVar);
                                        j10 = j16;
                                        i17 = 0;
                                    }
                                }
                            } else {
                                j8 = -1;
                            }
                        }
                    }
                }
            }
            if (j8 != -1) {
                return j8;
            }
            long j17 = fVar.f9195b;
            if (this.f9221a.W(fVar, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j17);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f9223c) {
            return;
        }
        this.f9223c = true;
        this.f9221a.close();
        this.f9222b.a();
    }

    public final j g(long j8) throws EOFException {
        K(j8);
        return this.f9222b.o(j8);
    }

    @Override // qj.h, qj.g
    public final f getBuffer() {
        return this.f9222b;
    }

    public final long h() throws EOFException {
        f fVar;
        long j8;
        int i8;
        byte b9 = 70;
        byte b10 = 65;
        byte b11 = 102;
        K(1L);
        int i9 = 0;
        while (true) {
            int i10 = i9 + 1;
            boolean zRequest = request(i10);
            fVar = this.f9222b;
            if (!zRequest) {
                break;
            }
            byte bK = fVar.k(i9);
            if ((bK < 48 || bK > 57) && ((bK < 97 || bK > 102) && (bK < 65 || bK > 70))) {
                if (i9 != 0) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bK, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                sb2.append(string);
                throw new NumberFormatException(sb2.toString());
            }
            i9 = i10;
        }
        if (fVar.f9195b == 0) {
            throw new EOFException();
        }
        long j10 = 0;
        int i11 = 0;
        boolean z2 = false;
        while (true) {
            u uVar = fVar.f9194a;
            Intrinsics.checkNotNull(uVar);
            byte[] bArr = uVar.f9224a;
            int i12 = uVar.f9225b;
            int i13 = uVar.f9226c;
            while (true) {
                if (i12 >= i13) {
                    j8 = 0;
                    break;
                }
                byte b12 = bArr[i12];
                if (b12 >= 48 && b12 <= 57) {
                    i8 = b12 - 48;
                } else if (b12 >= 97 && b12 <= b11) {
                    i8 = b12 - 87;
                } else {
                    if (b12 < b10 || b12 > b9) {
                        j8 = 0;
                        if (i11 != 0) {
                            z2 = true;
                            break;
                        }
                        StringBuilder sb3 = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
                        char[] cArr = rj.b.f9441a;
                        sb3.append(StringsKt.concatToString(new char[]{cArr[(b12 >> 4) & 15], cArr[b12 & 15]}));
                        throw new NumberFormatException(sb3.toString());
                    }
                    i8 = b12 - 55;
                }
                int i14 = i8;
                if ((j10 & (-1152921504606846976L)) != 0) {
                    f fVar2 = new f();
                    fVar2.a0(j10);
                    fVar2.S(b12);
                    throw new NumberFormatException("Number too large: ".concat(fVar2.w()));
                }
                j10 = (j10 << 4) | ((long) i14);
                i12++;
                i11++;
                b9 = 70;
                b10 = 65;
                b11 = 102;
            }
            if (i12 == i13) {
                fVar.f9194a = uVar.a();
                v.a(uVar);
            } else {
                uVar.f9225b = i12;
            }
            if (z2 || fVar.f9194a == null) {
                fVar.f9195b -= (long) i11;
                return j10;
            }
            b9 = 70;
            b10 = 65;
            b11 = 102;
        }
    }

    public final int i() throws EOFException {
        K(4L);
        int i8 = this.f9222b.readInt();
        return ((i8 & 255) << 24) | (((-16777216) & i8) >>> 24) | ((16711680 & i8) >>> 8) | ((65280 & i8) << 8);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f9223c;
    }

    @Override // qj.h
    public final InputStream j0() {
        return new mh.b(this, 3);
    }

    public final short k() throws EOFException {
        K(2L);
        return this.f9222b.s();
    }

    public final String l(long j8) throws EOFException {
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("limit < 0: ", j8).toString());
        }
        long j10 = j8 == Long.MAX_VALUE ? Long.MAX_VALUE : j8 + 1;
        long jA = a((byte) 10, 0L, j10);
        f fVar = this.f9222b;
        if (jA != -1) {
            return rj.a.a(fVar, jA);
        }
        if (j10 < Long.MAX_VALUE && request(j10) && fVar.k(j10 - 1) == 13 && request(1 + j10) && fVar.k(j10) == 10) {
            return rj.a.a(fVar, j10);
        }
        f fVar2 = new f();
        fVar.i(fVar2, 0L, Math.min(32, fVar.f9195b));
        throw new EOFException("\\n not found: limit=" + Math.min(fVar.f9195b, j8) + " content=" + fVar2.o(fVar2.f9195b).hex() + Typography.ellipsis);
    }

    public final void m(long j8) throws EOFException {
        if (this.f9223c) {
            throw new IllegalStateException("closed");
        }
        while (j8 > 0) {
            f fVar = this.f9222b;
            if (fVar.f9195b == 0 && this.f9221a.W(fVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j8, fVar.f9195b);
            fVar.A(jMin);
            j8 -= jMin;
        }
    }

    @Override // qj.h
    public final f n() {
        return this.f9222b;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        f fVar = this.f9222b;
        if (fVar.f9195b == 0 && this.f9221a.W(fVar, 8192L) == -1) {
            return -1;
        }
        return fVar.read(sink);
    }

    public final byte readByte() throws EOFException {
        K(1L);
        return this.f9222b.readByte();
    }

    public final int readInt() throws EOFException {
        K(4L);
        return this.f9222b.readInt();
    }

    @Override // qj.h
    public final boolean request(long j8) {
        f fVar;
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        if (this.f9223c) {
            throw new IllegalStateException("closed");
        }
        do {
            fVar = this.f9222b;
            if (fVar.f9195b >= j8) {
                return true;
            }
        } while (this.f9221a.W(fVar, 8192L) != -1);
        return false;
    }

    public final String toString() {
        return "buffer(" + this.f9221a + ')';
    }

    @Override // qj.h
    public final int x(p options) throws EOFException {
        f fVar;
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.f9223c) {
            throw new IllegalStateException("closed");
        }
        do {
            fVar = this.f9222b;
            int iB = rj.a.b(fVar, options, true);
            if (iB != -2) {
                if (iB == -1) {
                    break;
                }
                fVar.A(options.f9209a[iB].size());
                return iB;
            }
        } while (this.f9221a.W(fVar, 8192L) != -1);
        return -1;
    }
}
