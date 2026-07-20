package wi;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    /* JADX WARN: Code duplicated, block: B:9:0x0042  */
    public static long a(k kVar, byte b9) {
        h hVar;
        long j8;
        long j10;
        long j11;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        long j12 = 0;
        while (j12 < Long.MAX_VALUE && kVar.request(1 + j12)) {
            a buffer = kVar.getBuffer();
            long jMin = Math.min(Long.MAX_VALUE, kVar.getBuffer().f10764c);
            Intrinsics.checkNotNullParameter(buffer, "<this>");
            long jMin2 = Math.min(jMin, buffer.f10764c);
            q.a(buffer.f10764c, j12, jMin2);
            if (j12 == jMin2 || (hVar = buffer.f10762a) == null) {
                j10 = -1;
                j11 = -1;
            } else {
                long jB = buffer.f10764c;
                if (jB - j12 < j12) {
                    h hVar2 = buffer.f10763b;
                    while (hVar2 != null && jB > j12) {
                        jB -= (long) (hVar2.f10778c - hVar2.f10777b);
                        if (jB <= j12) {
                            break;
                        }
                        hVar2 = hVar2.f10780g;
                    }
                    if (jB == -1) {
                        j10 = -1;
                        j11 = -1;
                    } else {
                        while (true) {
                            if (jMin2 <= jB) {
                                throw new IllegalStateException("Check failed.");
                            }
                            Intrinsics.checkNotNull(hVar2);
                            int iC = q.c(hVar2, b9, Math.max((int) (j12 - jB), 0), Math.min(hVar2.b(), (int) (jMin2 - jB)));
                            if (iC != -1) {
                                j8 = iC;
                                j10 = j8 + jB;
                            } else {
                                jB += (long) hVar2.b();
                                hVar2 = hVar2.f;
                                if (hVar2 == null || jB >= jMin2) {
                                    j10 = -1;
                                }
                            }
                        }
                    }
                } else {
                    jB = 0;
                    while (hVar != null) {
                        long j13 = ((long) (hVar.f10778c - hVar.f10777b)) + jB;
                        if (j13 > j12) {
                            break;
                        }
                        hVar = hVar.f;
                        jB = j13;
                    }
                    if (jB != -1) {
                        while (true) {
                            if (jMin2 <= jB) {
                                throw new IllegalStateException("Check failed.");
                            }
                            Intrinsics.checkNotNull(hVar);
                            int iC2 = q.c(hVar, b9, Math.max((int) (j12 - jB), 0), Math.min(hVar.b(), (int) (jMin2 - jB)));
                            if (iC2 != -1) {
                                j8 = iC2;
                                j10 = j8 + jB;
                            } else {
                                jB += (long) hVar.b();
                                hVar = hVar.f;
                                if (hVar == null || jB >= jMin2) {
                                }
                            }
                        }
                    }
                    j10 = -1;
                }
                j11 = -1;
            }
            if (j10 != j11) {
                return j10;
            }
            j12 = kVar.getBuffer().f10764c;
        }
        return -1L;
    }

    public static final byte[] b(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        return d(kVar, -1);
    }

    public static final byte[] c(k kVar, int i8) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        long j8 = i8;
        if (j8 >= 0) {
            return d(kVar, i8);
        }
        throw new IllegalArgumentException(("byteCount (" + j8 + ") < 0").toString());
    }

    public static final byte[] d(k kVar, int i8) throws EOFException {
        if (i8 == -1) {
            for (long j8 = 2147483647L; kVar.getBuffer().f10764c < 2147483647L && kVar.request(j8); j8 *= (long) 2) {
            }
            if (kVar.getBuffer().f10764c >= 2147483647L) {
                throw new IllegalStateException(("Can't create an array of size " + kVar.getBuffer().f10764c).toString());
            }
            i8 = (int) kVar.getBuffer().f10764c;
        } else {
            kVar.K(i8);
        }
        byte[] bArr = new byte[i8];
        e(kVar.getBuffer(), bArr, 0, i8);
        return bArr;
    }

    public static final void e(a aVar, byte[] sink, int i8, int i9) throws EOFException {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        q.a(sink.length, i8, i9);
        int i10 = i8;
        while (i10 < i9) {
            int iU = aVar.U(sink, i10, i9);
            if (iU == -1) {
                throw new EOFException("Source exhausted before reading " + (i9 - i8) + " bytes. Only " + iU + " bytes were read.");
            }
            i10 += iU;
        }
    }
}
