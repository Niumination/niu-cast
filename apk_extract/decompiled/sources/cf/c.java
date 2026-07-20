package cf;

import af.o5;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.transsion.core.pool.TranssionPoolExecutor;
import java.io.IOException;
import java.net.Socket;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements qj.x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o5 f1493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f1494d;
    public final int e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public qj.c f1498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Socket f1499l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1500m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1501n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1502o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1491a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qj.f f1492b = new qj.f();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1495h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1496i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1497j = false;

    public c(o5 o5Var, d dVar) {
        v8.i(o5Var, "executor");
        this.f1493c = o5Var;
        this.f1494d = dVar;
        this.e = ModuleDescriptor.MODULE_VERSION;
    }

    public final void a(qj.c cVar, Socket socket) {
        v8.n(this.f1498k == null, "AsyncSink's becomeConnected should only be called once.");
        this.f1498k = cVar;
        v8.i(socket, "socket");
        this.f1499l = socket;
    }

    @Override // qj.x
    public final qj.b0 b() {
        return qj.b0.f9179d;
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f1497j) {
            return;
        }
        this.f1497j = true;
        this.f1493c.execute(new af.f(this, 12));
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() throws IOException {
        if (this.f1497j) {
            throw new IOException("closed");
        }
        ph.b.d();
        try {
            synchronized (this.f1491a) {
                if (this.f1496i) {
                    ph.b.f8887a.getClass();
                    return;
                }
                this.f1496i = true;
                this.f1493c.execute(new a(this, 1));
                ph.b.f8887a.getClass();
            }
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // qj.x
    public final void k0(qj.f fVar, long j8) throws IOException {
        v8.i(fVar, TranssionPoolExecutor.DEFAULT_SOURCE_EXECUTOR_NAME);
        if (this.f1497j) {
            throw new IOException("closed");
        }
        ph.b.d();
        try {
            synchronized (this.f1491a) {
                try {
                    this.f1492b.k0(fVar, j8);
                    int i8 = this.f1502o + this.f1501n;
                    this.f1502o = i8;
                    boolean z2 = false;
                    this.f1501n = 0;
                    if (this.f1500m || i8 <= this.e) {
                        if (!this.f1495h && !this.f1496i && this.f1492b.h() > 0) {
                            this.f1495h = true;
                        }
                        ph.b.f8887a.getClass();
                        return;
                    }
                    this.f1500m = true;
                    z2 = true;
                    if (!z2) {
                        this.f1493c.execute(new a(this, 0));
                        ph.b.f8887a.getClass();
                    } else {
                        try {
                            this.f1499l.close();
                        } catch (IOException e) {
                            this.f1494d.b(e);
                        }
                        ph.b.f8887a.getClass();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }
}
