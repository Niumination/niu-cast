package cf;

import af.f6;
import af.g6;
import af.k2;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a8.a f1557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a8.a f1559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f1560d;
    public final k2 e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SSLSocketFactory f1561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final df.c f1562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f1564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final af.j f1565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f1566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f1567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1568o;
    public boolean p;

    public j(a8.a aVar, a8.a aVar2, SSLSocketFactory sSLSocketFactory, df.c cVar, int i8, boolean z2, long j8, long j10, int i9, int i10, k2 k2Var) {
        this.f1557a = aVar;
        this.f1558b = (Executor) g6.a((f6) aVar.f44b);
        this.f1559c = aVar2;
        this.f1560d = (ScheduledExecutorService) g6.a((f6) aVar2.f44b);
        this.f1561h = sSLSocketFactory;
        this.f1562i = cVar;
        this.f1563j = i8;
        this.f1564k = z2;
        this.f1565l = new af.j(j8);
        this.f1566m = j10;
        this.f1567n = i9;
        this.f1568o = i10;
        v8.i(k2Var, "transportTracerFactory");
        this.e = k2Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.f1557a.n(this.f1558b);
        this.f1559c.n(this.f1560d);
    }
}
