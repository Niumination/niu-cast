package hj;

import androidx.core.app.NotificationCompat;
import dj.b0;
import dj.e0;
import dj.j0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f5443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f5444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f5445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f5446d;
    public e e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f5447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public dj.m f5448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f5452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile dj.m f5453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile m f5454o;
    public final b0 p;
    public final e0 q;

    public i(b0 client, e0 originalRequest) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.p = client;
        this.q = originalRequest;
        this.f5443a = (n) client.f4496b.f10262b;
        client.e.getClass();
        Intrinsics.checkNotNullParameter(this, "it");
        h hVar = new h(this);
        hVar.g(client.f4512x, TimeUnit.MILLISECONDS);
        Unit unit = Unit.INSTANCE;
        this.f5444b = hVar;
        this.f5445c = new AtomicBoolean();
        this.f5451l = true;
    }

    public static final String a(i iVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(iVar.f5452m ? "canceled " : "");
        sb2.append(NotificationCompat.CATEGORY_CALL);
        sb2.append(" to ");
        sb2.append(iVar.q.f4528b.g());
        return sb2.toString();
    }

    public final void b(m connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        byte[] bArr = ej.b.f4964a;
        if (this.f5447h != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.f5447h = connection;
        connection.f5466o.add(new g(this, this.f5446d));
    }

    public final IOException c(IOException iOException) {
        IOException ioe;
        Socket socketJ;
        byte[] bArr = ej.b.f4964a;
        m connection = this.f5447h;
        if (connection != null) {
            synchronized (connection) {
                socketJ = j();
            }
            if (this.f5447h == null) {
                if (socketJ != null) {
                    ej.b.e(socketJ);
                }
                Intrinsics.checkNotNullParameter(this, "call");
                Intrinsics.checkNotNullParameter(connection, "connection");
            } else if (socketJ != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (this.f5444b.i()) {
            ioe = new InterruptedIOException("timeout");
            if (iOException != null) {
                ioe.initCause(iOException);
            }
        } else {
            ioe = iOException;
        }
        if (iOException != null) {
            Intrinsics.checkNotNull(ioe);
            Intrinsics.checkNotNullParameter(this, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
        } else {
            Intrinsics.checkNotNullParameter(this, "call");
        }
        return ioe;
    }

    public final void cancel() {
        Socket socket;
        if (this.f5452m) {
            return;
        }
        this.f5452m = true;
        dj.m mVar = this.f5453n;
        if (mVar != null) {
            ((ij.d) mVar.f4612d).cancel();
        }
        m mVar2 = this.f5454o;
        if (mVar2 != null && (socket = mVar2.f5455b) != null) {
            ej.b.e(socket);
        }
        Intrinsics.checkNotNullParameter(this, "call");
    }

    public final Object clone() {
        return new i(this.p, this.q);
    }

    public final void d() {
        lj.m mVar = lj.m.f7532a;
        lj.m.f7532a.getClass();
        Intrinsics.checkNotNullParameter("response.body().close()", "closer");
        this.f5446d = lj.m.f7533b.isLoggable(Level.FINE) ? new Throwable("response.body().close()") : null;
        Intrinsics.checkNotNullParameter(this, "call");
    }

    public final void e(boolean z2) {
        dj.m mVar;
        synchronized (this) {
            if (!this.f5451l) {
                throw new IllegalStateException("released");
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z2 && (mVar = this.f5453n) != null) {
            ((ij.d) mVar.f4612d).cancel();
            ((i) mVar.f4610b).h(mVar, true, true, null);
        }
        this.f5448i = null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008f  */
    public final j0 f() throws Throwable {
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.p.f4497c);
        arrayList.add(new ij.a(this.p));
        arrayList.add(new ij.a(this.p.f4503l));
        this.p.getClass();
        arrayList.add(new fj.b());
        arrayList.add(a.f5416a);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.p.f4498d);
        arrayList.add(new ij.b());
        e0 e0Var = this.q;
        b0 b0Var = this.p;
        boolean z2 = false;
        try {
            j0 j0VarB = new ij.f(this, arrayList, 0, null, e0Var, b0Var.f4513y, b0Var.f4514z, b0Var.A).b(this.q);
            if (this.f5452m) {
                ej.b.d(j0VarB);
                throw new IOException("Canceled");
            }
            i(null);
            return j0VarB;
        } catch (IOException e) {
            try {
                IOException iOExceptionI = i(e);
                if (iOExceptionI == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw iOExceptionI;
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
                if (!z2) {
                    i(null);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (!z2) {
                i(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0020 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0022 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:8:0x0013, B:17:0x0022, B:19:0x0026, B:20:0x0028, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001c), top: B:54:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0026 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:8:0x0013, B:17:0x0022, B:19:0x0026, B:20:0x0028, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001c), top: B:54:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final IOException h(dj.m exchange, boolean z2, boolean z3, IOException iOException) {
        boolean z5;
        boolean z10;
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (!Intrinsics.areEqual(exchange, this.f5453n)) {
            return iOException;
        }
        synchronized (this) {
            z5 = false;
            if (z2) {
                try {
                    if (this.f5449j) {
                        if (z2) {
                            this.f5449j = false;
                        }
                        if (z3) {
                            this.f5450k = false;
                        }
                        z11 = this.f5449j;
                        if (z11) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (!z11) {
                            z5 = true;
                        }
                        z10 = z5;
                        z5 = z12;
                    } else if (z3 || !this.f5450k) {
                        z10 = false;
                    } else {
                        if (z2) {
                            this.f5449j = false;
                        }
                        if (z3) {
                            this.f5450k = false;
                        }
                        z11 = this.f5449j;
                        if (z11 || this.f5450k) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        if (!z11 && !this.f5450k && !this.f5451l) {
                            z5 = true;
                        }
                        z10 = z5;
                        z5 = z12;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                if (z3) {
                }
                z10 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z5) {
            this.f5453n = null;
            m mVar = this.f5447h;
            if (mVar != null) {
                synchronized (mVar) {
                    mVar.f5463l++;
                }
            }
        }
        return z10 ? c(iOException) : iOException;
    }

    public final IOException i(IOException iOException) {
        boolean z2;
        synchronized (this) {
            try {
                z2 = false;
                if (this.f5451l) {
                    this.f5451l = false;
                    if (!this.f5449j && !this.f5450k) {
                        z2 = true;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z2 ? c(iOException) : iOException;
    }

    public final Socket j() {
        m connection = this.f5447h;
        Intrinsics.checkNotNull(connection);
        byte[] bArr = ej.b.f4964a;
        ArrayList arrayList = connection.f5466o;
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (true) {
            if (!it.hasNext()) {
                i8 = -1;
                break;
            }
            if (Intrinsics.areEqual((i) ((Reference) it.next()).get(), this)) {
                break;
            }
            i8++;
        }
        if (i8 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i8);
        this.f5447h = null;
        if (arrayList.isEmpty()) {
            connection.p = System.nanoTime();
            n nVar = this.f5443a;
            nVar.getClass();
            Intrinsics.checkNotNullParameter(connection, "connection");
            byte[] bArr2 = ej.b.f4964a;
            boolean z2 = connection.f5460i;
            gj.c cVar = nVar.f5468b;
            if (z2 || nVar.e == 0) {
                connection.f5460i = true;
                ConcurrentLinkedQueue concurrentLinkedQueue = nVar.f5470d;
                concurrentLinkedQueue.remove(connection);
                if (concurrentLinkedQueue.isEmpty()) {
                    cVar.a();
                }
                Socket socket = connection.f5456c;
                Intrinsics.checkNotNull(socket);
                return socket;
            }
            cVar.c(nVar.f5469c, 0L);
        }
        return null;
    }
}
