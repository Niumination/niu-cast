package kj;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6878d;
    public final ArrayDeque e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f6879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f6880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z f6881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z f6882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f6883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IOException f6884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f6885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s f6886n;

    public a0(int i8, s connection, boolean z2, boolean z3, dj.s sVar) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.f6885m = i8;
        this.f6886n = connection;
        this.f6878d = connection.f6949s.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        this.f6879g = new y(this, connection.f6948r.a(), z3);
        this.f6880h = new x(this, z2);
        this.f6881i = new z(this);
        this.f6882j = new z(this);
        if (sVar == null) {
            if (!h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (h()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(sVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001b  */
    public final void a() {
        boolean z2;
        boolean zI;
        byte[] bArr = ej.b.f4964a;
        synchronized (this) {
            try {
                y yVar = this.f6879g;
                if (yVar.e || !yVar.f6977c) {
                    z2 = false;
                } else {
                    x xVar = this.f6880h;
                    if (xVar.f6973c || xVar.f6972b) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                zI = i();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z2) {
            c(c.CANCEL, null);
        } else {
            if (zI) {
                return;
            }
            this.f6886n.h(this.f6885m);
        }
    }

    public final void b() throws IOException {
        x xVar = this.f6880h;
        if (xVar.f6972b) {
            throw new IOException("stream closed");
        }
        if (xVar.f6973c) {
            throw new IOException("stream finished");
        }
        if (this.f6883k != null) {
            IOException iOException = this.f6884l;
            if (iOException != null) {
                throw iOException;
            }
            c cVar = this.f6883k;
            Intrinsics.checkNotNull(cVar);
            throw new f0(cVar);
        }
    }

    public final void c(c statusCode, IOException iOException) {
        Intrinsics.checkNotNullParameter(statusCode, "rstStatusCode");
        if (d(statusCode, iOException)) {
            s sVar = this.f6886n;
            sVar.getClass();
            Intrinsics.checkNotNullParameter(statusCode, "statusCode");
            sVar.f6954y.i(this.f6885m, statusCode);
        }
    }

    public final boolean d(c cVar, IOException iOException) {
        byte[] bArr = ej.b.f4964a;
        synchronized (this) {
            if (this.f6883k != null) {
                return false;
            }
            if (this.f6879g.e && this.f6880h.f6973c) {
                return false;
            }
            this.f6883k = cVar;
            this.f6884l = iOException;
            notifyAll();
            Unit unit = Unit.INSTANCE;
            this.f6886n.h(this.f6885m);
            return true;
        }
    }

    public final void e(c errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (d(errorCode, null)) {
            this.f6886n.m(this.f6885m, errorCode);
        }
    }

    public final synchronized c f() {
        return this.f6883k;
    }

    public final x g() {
        synchronized (this) {
            try {
                if (!this.f && !h()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f6880h;
    }

    public final boolean h() {
        boolean z2 = (this.f6885m & 1) == 1;
        this.f6886n.getClass();
        return true == z2;
    }

    public final synchronized boolean i() {
        if (this.f6883k != null) {
            return false;
        }
        y yVar = this.f6879g;
        if (yVar.e || yVar.f6977c) {
            x xVar = this.f6880h;
            if ((xVar.f6973c || xVar.f6972b) && this.f) {
                return false;
            }
        }
        return true;
    }

    public final void j(dj.s headers, boolean z2) {
        boolean zI;
        Intrinsics.checkNotNullParameter(headers, "headers");
        byte[] bArr = ej.b.f4964a;
        synchronized (this) {
            try {
                if (this.f && z2) {
                    this.f6879g.getClass();
                } else {
                    this.f = true;
                    this.e.add(headers);
                }
                if (z2) {
                    this.f6879g.e = true;
                }
                zI = i();
                notifyAll();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zI) {
            return;
        }
        this.f6886n.h(this.f6885m);
    }

    public final synchronized void k(c errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.f6883k == null) {
            this.f6883k = errorCode;
            notifyAll();
        }
    }

    public final void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
