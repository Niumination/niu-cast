package kj;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Logger f6887h = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj.f f6888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f6891d;
    public final qj.s e;

    public b0(qj.s sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.e = sink;
        qj.f fVar = new qj.f();
        this.f6888a = fVar;
        this.f6889b = 16384;
        this.f6891d = new f(fVar);
    }

    public final synchronized void a(e0 peerSettings) {
        try {
            Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
            if (this.f6890c) {
                throw new IOException("closed");
            }
            int i8 = this.f6889b;
            int i9 = peerSettings.f6908a;
            if ((i9 & 32) != 0) {
                i8 = peerSettings.f6909b[5];
            }
            this.f6889b = i8;
            if (((i9 & 2) != 0 ? peerSettings.f6909b[1] : -1) != -1) {
                f fVar = this.f6891d;
                int i10 = (i9 & 2) != 0 ? peerSettings.f6909b[1] : -1;
                fVar.getClass();
                int iMin = Math.min(i10, 16384);
                int i11 = fVar.f6912c;
                if (i11 != iMin) {
                    if (iMin < i11) {
                        fVar.f6910a = Math.min(fVar.f6910a, iMin);
                    }
                    fVar.f6911b = true;
                    fVar.f6912c = iMin;
                    int i12 = fVar.f6914g;
                    if (iMin < i12) {
                        if (iMin == 0) {
                            ArraysKt___ArraysJvmKt.fill$default(fVar.f6913d, (Object) null, 0, 0, 6, (Object) null);
                            fVar.e = fVar.f6913d.length - 1;
                            fVar.f = 0;
                            fVar.f6914g = 0;
                        } else {
                            fVar.a(i12 - iMin);
                        }
                    }
                }
            }
            c(0, 0, 4, 1);
            this.e.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c(int i8, int i9, int i10, int i11) {
        Level level = Level.FINE;
        Logger logger = f6887h;
        if (logger.isLoggable(level)) {
            logger.fine(h.a(false, i8, i9, i10, i11));
        }
        if (i9 > this.f6889b) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f6889b + ": " + i9).toString());
        }
        if ((((int) 2147483648L) & i8) != 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "reserved bit set: ").toString());
        }
        byte[] bArr = ej.b.f4964a;
        qj.s writeMedium = this.e;
        Intrinsics.checkNotNullParameter(writeMedium, "$this$writeMedium");
        writeMedium.c((i9 >>> 16) & 255);
        writeMedium.c((i9 >>> 8) & 255);
        writeMedium.c(i9 & 255);
        writeMedium.c(i10 & 255);
        writeMedium.c(i11 & 255);
        writeMedium.g(i8 & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f6890c = true;
        this.e.close();
    }

    public final synchronized void d(int i8, long j8) {
        if (this.f6890c) {
            throw new IOException("closed");
        }
        if (j8 == 0 || j8 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j8).toString());
        }
        c(i8, 4, 8, 0);
        this.e.g((int) j8);
        this.e.flush();
    }

    public final synchronized void e0(boolean z2, int i8, qj.f fVar, int i9) {
        if (this.f6890c) {
            throw new IOException("closed");
        }
        c(i8, i9, 0, z2 ? 1 : 0);
        if (i9 > 0) {
            Intrinsics.checkNotNull(fVar);
            this.e.k0(fVar, i9);
        }
    }

    public final synchronized void flush() {
        if (this.f6890c) {
            throw new IOException("closed");
        }
        this.e.flush();
    }

    public final synchronized void g(int i8, c errorCode, byte[] debugData) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        if (this.f6890c) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        c(0, debugData.length + 8, 7, 0);
        this.e.g(i8);
        this.e.g(errorCode.getHttpCode());
        if (debugData.length != 0) {
            this.e.F(debugData);
        }
        this.e.flush();
    }

    public final synchronized void h(ArrayList headerBlock, int i8, boolean z2) {
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (this.f6890c) {
            throw new IOException("closed");
        }
        this.f6891d.d(headerBlock);
        long j8 = this.f6888a.f9195b;
        long jMin = Math.min(this.f6889b, j8);
        int i9 = j8 == jMin ? 4 : 0;
        if (z2) {
            i9 |= 1;
        }
        c(i8, (int) jMin, 1, i9);
        this.e.k0(this.f6888a, jMin);
        if (j8 > jMin) {
            long j10 = j8 - jMin;
            while (j10 > 0) {
                long jMin2 = Math.min(this.f6889b, j10);
                j10 -= jMin2;
                c(i8, (int) jMin2, 9, j10 == 0 ? 4 : 0);
                this.e.k0(this.f6888a, jMin2);
            }
        }
    }

    public final synchronized void i(int i8, c errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.f6890c) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        c(i8, 4, 3, 0);
        this.e.g(errorCode.getHttpCode());
        this.e.flush();
    }

    public final synchronized void j(boolean z2, int i8, int i9) {
        if (this.f6890c) {
            throw new IOException("closed");
        }
        c(0, 8, 6, z2 ? 1 : 0);
        this.e.g(i8);
        this.e.g(i9);
        this.e.flush();
    }
}
