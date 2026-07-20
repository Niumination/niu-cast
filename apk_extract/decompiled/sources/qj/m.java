package qj;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f9199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f9200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f9201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f9202d;
    public final CRC32 e;

    public m(z source) {
        Intrinsics.checkNotNullParameter(source, "source");
        t tVar = new t(source);
        this.f9200b = tVar;
        Inflater inflater = new Inflater(true);
        this.f9201c = inflater;
        this.f9202d = new n(tVar, inflater);
        this.e = new CRC32();
    }

    public static void a(int i8, int i9, String str) throws IOException {
        if (i9 != i8) {
            throw new IOException(o.d.q(new Object[]{str, Integer.valueOf(i9), Integer.valueOf(i8)}, 3, "%s: actual 0x%08x != expected 0x%08x", "format(this, *args)"));
        }
    }

    @Override // qj.z
    public final long W(f sink, long j8) throws IOException {
        f fVar;
        long j10;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        if (j8 == 0) {
            return 0L;
        }
        byte b9 = this.f9199a;
        CRC32 crc32 = this.e;
        t tVar = this.f9200b;
        if (b9 == 0) {
            tVar.K(10L);
            f fVar2 = tVar.f9222b;
            byte bK = fVar2.k(3L);
            boolean z2 = ((bK >> 1) & 1) == 1;
            if (z2) {
                c(fVar2, 0L, 10L);
            }
            a(8075, tVar.k(), "ID1ID2");
            tVar.m(8L);
            if (((bK >> 2) & 1) == 1) {
                tVar.K(2L);
                if (z2) {
                    c(fVar2, 0L, 2L);
                }
                short s2 = fVar2.s();
                long j11 = ((short) (((s2 & 255) << 8) | ((s2 & 65280) >>> 8))) & UShort.MAX_VALUE;
                tVar.K(j11);
                if (z2) {
                    c(fVar2, 0L, j11);
                    j10 = j11;
                } else {
                    j10 = j11;
                }
                tVar.m(j10);
            }
            if (((bK >> 3) & 1) == 1) {
                fVar = fVar2;
                long jA = tVar.a((byte) 0, 0L, Long.MAX_VALUE);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    c(fVar, 0L, jA + 1);
                }
                r4.m(jA + 1);
            } else {
                fVar = fVar2;
            }
            if (((bK >> 4) & 1) == 1) {
                long jA2 = tVar.a((byte) 0, 0L, Long.MAX_VALUE);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    c(fVar, 0L, jA2 + 1);
                }
                tVar.m(jA2 + 1);
            }
            if (z2) {
                tVar.K(2L);
                short s3 = fVar.s();
                a((short) (((s3 & 255) << 8) | ((s3 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            this.f9199a = (byte) 1;
        } else {
            tVar = tVar;
        }
        if (this.f9199a == 1) {
            long j12 = sink.f9195b;
            long jW = this.f9202d.W(sink, j8);
            if (jW != -1) {
                c(sink, j12, jW);
                return jW;
            }
            this.f9199a = (byte) 2;
        }
        if (this.f9199a != 2) {
            return -1L;
        }
        a(tVar.i(), (int) crc32.getValue(), "CRC");
        a(tVar.i(), (int) this.f9201c.getBytesWritten(), "ISIZE");
        this.f9199a = (byte) 3;
        if (tVar.T()) {
            return -1L;
        }
        throw new IOException("gzip finished without exhausting source");
    }

    @Override // qj.z
    public final b0 b() {
        return this.f9200b.f9221a.b();
    }

    public final void c(f fVar, long j8, long j10) {
        u uVar = fVar.f9194a;
        Intrinsics.checkNotNull(uVar);
        while (true) {
            int i8 = uVar.f9226c;
            int i9 = uVar.f9225b;
            if (j8 < i8 - i9) {
                break;
            }
            j8 -= (long) (i8 - i9);
            uVar = uVar.f;
            Intrinsics.checkNotNull(uVar);
        }
        while (j10 > 0) {
            int i10 = (int) (((long) uVar.f9225b) + j8);
            int iMin = (int) Math.min(uVar.f9226c - i10, j10);
            this.e.update(uVar.f9224a, i10, iMin);
            j10 -= (long) iMin;
            uVar = uVar.f;
            Intrinsics.checkNotNull(uVar);
            j8 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9202d.close();
    }
}
