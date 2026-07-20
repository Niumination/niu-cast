package ef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import qj.s;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f4940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qj.f f4942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f4943d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4944h;

    public l(s sVar, boolean z2) {
        this.f4940a = sVar;
        this.f4941b = z2;
        qj.f fVar = new qj.f();
        this.f4942c = fVar;
        this.f4943d = new g(fVar);
        this.e = 16384;
    }

    @Override // ef.c
    public final int J() {
        return this.e;
    }

    @Override // ef.c
    public final synchronized void O(ArrayList arrayList, int i8, boolean z2) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        c(arrayList, i8, z2);
    }

    @Override // ef.c
    public final synchronized void Q(boolean z2, int i8, ArrayList arrayList) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        c(arrayList, i8, z2);
    }

    @Override // ef.c
    public final synchronized void Z(o oVar) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        int i8 = this.e;
        if ((oVar.f4951a & 32) != 0) {
            i8 = ((int[]) oVar.f4952b)[5];
        }
        this.e = i8;
        a(0, 0, (byte) 4, (byte) 1);
        this.f4940a.flush();
    }

    public final void a(int i8, int i9, byte b9, byte b10) {
        Logger logger = m.f4945a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(j.a(false, i8, i9, b9, b10));
        }
        int i10 = this.e;
        if (i9 > i10) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(o.d.f(i10, i9, "FRAME_SIZE_ERROR length > ", ": "));
        }
        if ((Integer.MIN_VALUE & i8) != 0) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException(a1.a.o(i8, "reserved bit set: "));
        }
        s sVar = this.f4940a;
        sVar.c((i9 >>> 16) & 255);
        sVar.c((i9 >>> 8) & 255);
        sVar.c(i9 & 255);
        sVar.c(b9 & UByte.MAX_VALUE);
        sVar.c(b10 & UByte.MAX_VALUE);
        sVar.g(i8 & Integer.MAX_VALUE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    public final void c(ArrayList arrayList, int i8, boolean z2) throws IOException {
        int length;
        int length2;
        if (this.f4944h) {
            throw new IOException("closed");
        }
        g gVar = this.f4943d;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            d dVar = (d) arrayList.get(i9);
            qj.j asciiLowercase = dVar.f4912a.toAsciiLowercase();
            Integer num = (Integer) h.f4927c.get(asciiLowercase);
            qj.j jVar = dVar.f4913b;
            if (num != null) {
                int iIntValue = num.intValue();
                length2 = iIntValue + 1;
                if (length2 < 2 || length2 > 7) {
                    length = length2;
                    length2 = -1;
                } else {
                    d[] dVarArr = h.f4926b;
                    if (dVarArr[iIntValue].f4913b.equals(jVar)) {
                        length = length2;
                    } else if (dVarArr[length2].f4913b.equals(jVar)) {
                        length2 = iIntValue + 2;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                }
            } else {
                length = -1;
                length2 = -1;
            }
            if (length2 == -1) {
                int i10 = gVar.f4922b + 1;
                while (true) {
                    d[] dVarArr2 = (d[]) gVar.e;
                    if (i10 >= dVarArr2.length) {
                        break;
                    }
                    if (dVarArr2[i10].f4912a.equals(asciiLowercase)) {
                        if (((d[]) gVar.e)[i10].f4913b.equals(jVar)) {
                            length2 = (i10 - gVar.f4922b) + h.f4926b.length;
                            break;
                        } else if (length == -1) {
                            length = (i10 - gVar.f4922b) + h.f4926b.length;
                        }
                    }
                    i10++;
                }
            }
            if (length2 != -1) {
                gVar.e(length2, 127, 128);
            } else if (length == -1) {
                ((qj.f) gVar.f4924d).S(64);
                gVar.d(asciiLowercase);
                gVar.d(jVar);
                gVar.a(dVar);
            } else if (!asciiLowercase.startsWith(h.f4925a) || d.f4911h.equals(asciiLowercase)) {
                gVar.e(length, 63, 64);
                gVar.d(jVar);
                gVar.a(dVar);
            } else {
                gVar.e(length, 15, 0);
                gVar.d(jVar);
            }
        }
        qj.f fVar = this.f4942c;
        long j8 = fVar.f9195b;
        int iMin = (int) Math.min(this.e, j8);
        long j10 = iMin;
        byte b9 = j8 == j10 ? (byte) 4 : (byte) 0;
        if (z2) {
            b9 = (byte) (b9 | 1);
        }
        a(i8, iMin, (byte) 1, b9);
        s sVar = this.f4940a;
        sVar.k0(fVar, j10);
        if (j8 > j10) {
            long j11 = j8 - j10;
            while (j11 > 0) {
                int iMin2 = (int) Math.min(this.e, j11);
                long j12 = iMin2;
                j11 -= j12;
                a(i8, iMin2, (byte) 9, j11 == 0 ? (byte) 4 : (byte) 0);
                sVar.k0(fVar, j12);
            }
        }
    }

    @Override // ef.c
    public final synchronized void c0(int i8, a aVar, byte[] bArr) {
        try {
            if (this.f4944h) {
                throw new IOException("closed");
            }
            if (aVar.httpCode == -1) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f4940a.g(i8);
            this.f4940a.g(aVar.httpCode);
            if (bArr.length > 0) {
                this.f4940a.F(bArr);
            }
            this.f4940a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f4944h = true;
        this.f4940a.close();
    }

    @Override // ef.c
    public final synchronized void d(int i8, long j8) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        if (j8 == 0 || j8 > 2147483647L) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j8);
        }
        a(i8, 4, (byte) 8, (byte) 0);
        this.f4940a.g((int) j8);
        this.f4940a.flush();
    }

    @Override // ef.c
    public final synchronized void e(o oVar) {
        int i8;
        try {
            if (this.f4944h) {
                throw new IOException("closed");
            }
            int i9 = 0;
            a(0, Integer.bitCount(oVar.f4951a) * 6, (byte) 4, (byte) 0);
            while (i9 < 10) {
                if (oVar.b(i9)) {
                    if (i9 == 4) {
                        i8 = 3;
                    } else {
                        i8 = i9 == 7 ? 4 : i9;
                    }
                    this.f4940a.h(i8);
                    this.f4940a.g(((int[]) oVar.f4952b)[i9]);
                }
                i9++;
            }
            this.f4940a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // ef.c
    public final synchronized void e0(boolean z2, int i8, qj.f fVar, int i9) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        a(i8, i9, (byte) 0, z2 ? (byte) 1 : (byte) 0);
        if (i9 > 0) {
            this.f4940a.k0(fVar, i9);
        }
    }

    @Override // ef.c
    public final synchronized void f(int i8, a aVar) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        if (aVar.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        a(i8, 4, (byte) 3, (byte) 0);
        this.f4940a.g(aVar.httpCode);
        this.f4940a.flush();
    }

    @Override // ef.c
    public final synchronized void f0(int i8, ArrayList arrayList) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        c(arrayList, i8, false);
    }

    @Override // ef.c
    public final synchronized void flush() {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        this.f4940a.flush();
    }

    @Override // ef.c
    public final synchronized void j(boolean z2, int i8, int i9) {
        if (this.f4944h) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z2 ? (byte) 1 : (byte) 0);
        this.f4940a.g(i8);
        this.f4940a.g(i9);
        this.f4940a.flush();
    }

    @Override // ef.c
    public final synchronized void r() {
        try {
            if (this.f4944h) {
                throw new IOException("closed");
            }
            if (this.f4941b) {
                Logger logger = m.f4945a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(">> CONNECTION " + m.f4946b.hex());
                }
                this.f4940a.F(m.f4946b.toByteArray());
                this.f4940a.flush();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
