package wi;

import java.io.EOFException;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements k, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f10762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f10763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10764c;

    @Override // wi.k
    public final long D(j sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j8 = this.f10764c;
        if (j8 > 0) {
            ((a) sink).m(this, j8);
        }
        return j8;
    }

    @Override // wi.k
    public final void G(j sink, long j8) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j8 + ") < 0").toString());
        }
        long j10 = this.f10764c;
        if (j10 >= j8) {
            ((a) sink).m(this, j8);
            return;
        }
        ((a) sink).m(this, j10);
        StringBuilder sb2 = new StringBuilder("Buffer exhausted before writing ");
        sb2.append(j8);
        sb2.append(" bytes. Only ");
        throw new EOFException(o.d.p(sb2, this.f10764c, " bytes were written."));
    }

    @Override // wi.k
    public final void K(long j8) throws EOFException {
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount: ", j8).toString());
        }
        if (this.f10764c >= j8) {
            return;
        }
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + this.f10764c + ", required: " + j8 + ')');
    }

    @Override // wi.k
    public final boolean T() {
        return this.f10764c == 0;
    }

    @Override // wi.k
    public final int U(byte[] dst, int i8, int i9) {
        Intrinsics.checkNotNullParameter(dst, "sink");
        q.a(dst.length, i8, i9);
        h hVar = this.f10762a;
        if (hVar == null) {
            return -1;
        }
        int iMin = Math.min(i9 - i8, hVar.b());
        Intrinsics.checkNotNullParameter(dst, "dst");
        int i10 = (i8 + iMin) - i8;
        int i11 = hVar.f10777b;
        ArraysKt.copyInto(hVar.f10776a, dst, i8, i11, i11 + i10);
        hVar.f10777b += i10;
        this.f10764c -= (long) iMin;
        if (q.d(hVar)) {
            c();
        }
        return iMin;
    }

    public final short a() throws EOFException {
        h hVar = this.f10762a;
        if (hVar == null) {
            i(2L);
            throw null;
        }
        int iB = hVar.b();
        if (iB < 2) {
            K(2L);
            if (iB == 0) {
                c();
                return a();
            }
            return (short) ((readByte() & UByte.MAX_VALUE) | ((readByte() & UByte.MAX_VALUE) << 8));
        }
        int i8 = hVar.f10777b;
        byte[] bArr = hVar.f10776a;
        short s2 = (short) ((bArr[i8 + 1] & UByte.MAX_VALUE) | ((bArr[i8] & UByte.MAX_VALUE) << 8));
        hVar.f10777b = i8 + 2;
        this.f10764c -= 2;
        if (iB == 2) {
            c();
        }
        return s2;
    }

    public final void c() {
        h hVar = this.f10762a;
        Intrinsics.checkNotNull(hVar);
        h hVar2 = hVar.f;
        this.f10762a = hVar2;
        if (hVar2 == null) {
            this.f10763b = null;
        } else {
            hVar2.f10780g = null;
        }
        hVar.f = null;
        i.a(hVar);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }

    @Override // wi.e
    public final long d0(a sink, long j8) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j8 + ") < 0").toString());
        }
        long j10 = this.f10764c;
        if (j10 == 0) {
            return -1L;
        }
        if (j8 > j10) {
            j8 = j10;
        }
        sink.m(this, j8);
        return j8;
    }

    @Override // java.io.Flushable
    public final void flush() {
    }

    public final /* synthetic */ void g() {
        h hVar = this.f10763b;
        Intrinsics.checkNotNull(hVar);
        h hVar2 = hVar.f10780g;
        this.f10763b = hVar2;
        if (hVar2 == null) {
            this.f10762a = null;
        } else {
            hVar2.f = null;
        }
        hVar.f10780g = null;
        i.a(hVar);
    }

    @Override // wi.k
    public final a getBuffer() {
        return this;
    }

    public final void h(long j8) throws EOFException {
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j8 + ") < 0").toString());
        }
        long j10 = j8;
        while (j10 > 0) {
            h hVar = this.f10762a;
            if (hVar == null) {
                throw new EOFException("Buffer exhausted before skipping " + j8 + " bytes.");
            }
            int iMin = (int) Math.min(j10, hVar.f10778c - hVar.f10777b);
            long j11 = iMin;
            this.f10764c -= j11;
            j10 -= j11;
            int i8 = hVar.f10777b + iMin;
            hVar.f10777b = i8;
            if (i8 == hVar.f10778c) {
                c();
            }
        }
    }

    public final void i(long j8) throws EOFException {
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + this.f10764c + ", required: " + j8 + ')');
    }

    public final long k(e source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j8 = 0;
        while (true) {
            long jD0 = source.d0(this, 8192L);
            if (jD0 == -1) {
                return j8;
            }
            j8 += jD0;
        }
    }

    public final /* synthetic */ h l(int i8) {
        if (i8 < 1 || i8 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        h hVar = this.f10763b;
        if (hVar == null) {
            h hVarB = i.b();
            this.f10762a = hVarB;
            this.f10763b = hVarB;
            return hVarB;
        }
        Intrinsics.checkNotNull(hVar);
        if (hVar.f10778c + i8 <= 8192 && hVar.e) {
            return hVar;
        }
        h hVarB2 = i.b();
        hVar.d(hVarB2);
        this.f10763b = hVarB2;
        return hVarB2;
    }

    public final void m(a source, long j8) {
        h hVarB;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        q.b(source.f10764c, 0L, j8);
        while (j8 > 0) {
            h hVar = source.f10762a;
            Intrinsics.checkNotNull(hVar);
            int i8 = 0;
            if (j8 < hVar.b()) {
                h hVar2 = this.f10763b;
                if (hVar2 != null && hVar2.e) {
                    long j10 = ((long) hVar2.f10778c) + j8;
                    q qVar = hVar2.f10779d;
                    if (j10 - ((long) ((qVar == null || ((g) qVar).f10775b <= 0) ? hVar2.f10777b : 0)) <= 8192) {
                        h hVar3 = source.f10762a;
                        Intrinsics.checkNotNull(hVar3);
                        hVar3.f(hVar2, (int) j8);
                        source.f10764c -= j8;
                        this.f10764c += j8;
                        return;
                    }
                }
                h hVar4 = source.f10762a;
                Intrinsics.checkNotNull(hVar4);
                int i9 = (int) j8;
                if (i9 <= 0) {
                    hVar4.getClass();
                } else if (i9 <= hVar4.f10778c - hVar4.f10777b) {
                    if (i9 >= 1024) {
                        hVarB = hVar4.e();
                    } else {
                        hVarB = i.b();
                        int i10 = hVar4.f10777b;
                        ArraysKt___ArraysJvmKt.copyInto$default(hVar4.f10776a, hVarB.f10776a, 0, i10, i10 + i9, 2, (Object) null);
                    }
                    hVarB.f10778c = hVarB.f10777b + i9;
                    hVar4.f10777b += i9;
                    h hVar5 = hVar4.f10780g;
                    if (hVar5 != null) {
                        Intrinsics.checkNotNull(hVar5);
                        hVar5.d(hVarB);
                    } else {
                        hVarB.f = hVar4;
                        hVar4.f10780g = hVarB;
                    }
                    source.f10762a = hVarB;
                }
                throw new IllegalArgumentException("byteCount out of range");
            }
            h hVar6 = source.f10762a;
            Intrinsics.checkNotNull(hVar6);
            long jB = hVar6.b();
            h hVarC = hVar6.c();
            source.f10762a = hVarC;
            if (hVarC == null) {
                source.f10763b = null;
            }
            if (this.f10762a == null) {
                this.f10762a = hVar6;
                this.f10763b = hVar6;
            } else {
                h hVar7 = this.f10763b;
                Intrinsics.checkNotNull(hVar7);
                hVar7.d(hVar6);
                h hVar8 = hVar6.f10780g;
                if (hVar8 == null) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.checkNotNull(hVar8);
                if (hVar8.e) {
                    int i11 = hVar6.f10778c - hVar6.f10777b;
                    h hVar9 = hVar6.f10780g;
                    Intrinsics.checkNotNull(hVar9);
                    int i12 = 8192 - hVar9.f10778c;
                    h hVar10 = hVar6.f10780g;
                    Intrinsics.checkNotNull(hVar10);
                    q qVar2 = hVar10.f10779d;
                    if (qVar2 == null || ((g) qVar2).f10775b <= 0) {
                        h hVar11 = hVar6.f10780g;
                        Intrinsics.checkNotNull(hVar11);
                        i8 = hVar11.f10777b;
                    }
                    if (i11 <= i12 + i8) {
                        h hVar12 = hVar6.f10780g;
                        Intrinsics.checkNotNull(hVar12);
                        hVar6.f(hVar12, i11);
                        if (hVar6.c() != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        i.a(hVar6);
                        hVar6 = hVar12;
                    }
                }
                this.f10763b = hVar6;
                Intrinsics.checkNotNull(hVar6);
                if (hVar6.f10780g == null) {
                    this.f10762a = this.f10763b;
                }
            }
            source.f10764c -= jB;
            this.f10764c += jB;
            j8 -= jB;
        }
    }

    public final void o(byte[] src, int i8, int i9) {
        Intrinsics.checkNotNullParameter(src, "source");
        q.a(src.length, i8, i9);
        int i10 = i8;
        while (i10 < i9) {
            h hVarL = l(1);
            int iMin = Math.min(i9 - i10, hVarL.a()) + i10;
            Intrinsics.checkNotNullParameter(src, "src");
            ArraysKt.copyInto(src, hVarL.f10776a, hVarL.f10778c, i10, iMin);
            hVarL.f10778c = (iMin - i10) + hVarL.f10778c;
            i10 = iMin;
        }
        this.f10764c += (long) (i9 - i8);
    }

    @Override // wi.k
    public final f peek() {
        d dVar = new d(this);
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        return new f(dVar);
    }

    @Override // wi.k
    public final byte readByte() throws EOFException {
        h hVar = this.f10762a;
        if (hVar == null) {
            i(1L);
            throw null;
        }
        int iB = hVar.b();
        if (iB == 0) {
            c();
            return readByte();
        }
        int i8 = hVar.f10777b;
        hVar.f10777b = i8 + 1;
        byte b9 = hVar.f10776a[i8];
        this.f10764c--;
        if (iB == 1) {
            c();
        }
        return b9;
    }

    @Override // wi.k
    public final int readInt() throws EOFException {
        h hVar = this.f10762a;
        if (hVar == null) {
            i(4L);
            throw null;
        }
        int iB = hVar.b();
        if (iB < 4) {
            K(4L);
            if (iB == 0) {
                c();
                return readInt();
            }
            return (a() & UShort.MAX_VALUE) | (a() << 16);
        }
        int i8 = hVar.f10777b;
        byte[] bArr = hVar.f10776a;
        int i9 = ((bArr[i8 + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i8] & UByte.MAX_VALUE) << 24) | ((bArr[i8 + 2] & UByte.MAX_VALUE) << 8) | (bArr[i8 + 3] & UByte.MAX_VALUE);
        hVar.f10777b = i8 + 4;
        this.f10764c -= 4;
        if (iB == 4) {
            c();
        }
        return i9;
    }

    @Override // wi.k
    public final long readLong() throws EOFException {
        h hVar = this.f10762a;
        if (hVar == null) {
            i(8L);
            throw null;
        }
        int iB = hVar.b();
        if (iB < 8) {
            K(8L);
            if (iB != 0) {
                return (((long) readInt()) << 32) | (((long) readInt()) & 4294967295L);
            }
            c();
            return readLong();
        }
        int i8 = hVar.f10777b;
        byte[] bArr = hVar.f10776a;
        long j8 = ((((long) bArr[i8 + 1]) & 255) << 48) | ((((long) bArr[i8]) & 255) << 56) | ((((long) bArr[i8 + 2]) & 255) << 40) | ((((long) bArr[i8 + 3]) & 255) << 32) | ((((long) bArr[i8 + 4]) & 255) << 24) | ((((long) bArr[i8 + 5]) & 255) << 16) | ((((long) bArr[i8 + 6]) & 255) << 8) | (((long) bArr[i8 + 7]) & 255);
        hVar.f10777b = i8 + 8;
        this.f10764c -= 8;
        if (iB == 8) {
            c();
        }
        return j8;
    }

    @Override // wi.k
    public final boolean request(long j8) {
        if (j8 >= 0) {
            return this.f10764c >= j8;
        }
        throw new IllegalArgumentException(("byteCount: " + j8 + " < 0").toString());
    }

    public final void s(byte b9) {
        h hVarL = l(1);
        int i8 = hVarL.f10778c;
        hVarL.f10778c = i8 + 1;
        hVarL.f10776a[i8] = b9;
        this.f10764c++;
    }

    public final void t(short s2) {
        h hVarL = l(2);
        int i8 = hVarL.f10778c;
        byte[] bArr = hVarL.f10776a;
        bArr[i8] = (byte) ((s2 >>> 8) & 255);
        bArr[i8 + 1] = (byte) (s2 & 255);
        hVarL.f10778c = i8 + 2;
        this.f10764c += 2;
    }

    public final String toString() {
        long j8 = this.f10764c;
        if (j8 == 0) {
            return "Buffer(size=0)";
        }
        long j10 = 64;
        int iMin = (int) Math.min(j10, j8);
        StringBuilder sb2 = new StringBuilder((iMin * 2) + (this.f10764c > j10 ? 1 : 0));
        int i8 = 0;
        for (h segment = this.f10762a; segment != null; segment = segment.f) {
            int i9 = 0;
            while (i8 < iMin && i9 < segment.b()) {
                int i10 = i9 + 1;
                Intrinsics.checkNotNullParameter(segment, "segment");
                byte b9 = segment.f10776a[segment.f10777b + i9];
                i8++;
                char[] cArr = q.f10788a;
                sb2.append(cArr[(b9 >> 4) & 15]);
                sb2.append(cArr[b9 & 15]);
                i9 = i10;
            }
        }
        if (this.f10764c > j10) {
            sb2.append(Typography.ellipsis);
        }
        return "Buffer(size=" + this.f10764c + " hex=" + ((Object) sb2) + ')';
    }
}
