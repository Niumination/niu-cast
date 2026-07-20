package qj;

import java.io.IOException;
import k3.qc;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f9183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f9184b;

    public c(y yVar, q qVar) {
        this.f9183a = yVar;
        this.f9184b = qVar;
    }

    @Override // qj.x
    public final b0 b() {
        return this.f9183a;
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        q qVar = this.f9184b;
        y yVar = this.f9183a;
        yVar.h();
        try {
            try {
                qVar.close();
                Unit unit = Unit.INSTANCE;
                if (yVar.i()) {
                    throw yVar.k(null);
                }
            } catch (IOException e) {
                if (!yVar.i()) {
                    throw e;
                }
                throw yVar.k(e);
            }
        } catch (Throwable th2) {
            yVar.i();
            throw th2;
        }
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() throws IOException {
        q qVar = this.f9184b;
        y yVar = this.f9183a;
        yVar.h();
        try {
            try {
                qVar.flush();
                Unit unit = Unit.INSTANCE;
                if (yVar.i()) {
                    throw yVar.k(null);
                }
            } catch (IOException e) {
                if (!yVar.i()) {
                    throw e;
                }
                throw yVar.k(e);
            }
        } catch (Throwable th2) {
            yVar.i();
            throw th2;
        }
    }

    @Override // qj.x
    public final void k0(f source, long j8) {
        Intrinsics.checkNotNullParameter(source, "source");
        qc.b(source.f9195b, 0L, j8);
        while (true) {
            long j10 = 0;
            if (j8 <= 0) {
                return;
            }
            u uVar = source.f9194a;
            Intrinsics.checkNotNull(uVar);
            while (j10 < 65536) {
                j10 += (long) (uVar.f9226c - uVar.f9225b);
                if (j10 >= j8) {
                    j10 = j8;
                    break;
                } else {
                    uVar = uVar.f;
                    Intrinsics.checkNotNull(uVar);
                }
            }
            q qVar = this.f9184b;
            y yVar = this.f9183a;
            yVar.h();
            try {
                try {
                    qVar.k0(source, j10);
                    Unit unit = Unit.INSTANCE;
                    if (yVar.i()) {
                        throw yVar.k(null);
                    }
                    j8 -= j10;
                } catch (IOException e) {
                    if (!yVar.i()) {
                        throw e;
                    }
                    throw yVar.k(e);
                }
            } catch (Throwable th2) {
                yVar.i();
                throw th2;
            }
        }
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.f9184b + ')';
    }
}
