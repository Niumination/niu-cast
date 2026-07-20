package xq;

import java.util.concurrent.Executor;
import kn.w;
import nq.x1;

/* JADX INFO: loaded from: classes3.dex */
public class i extends x1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f20513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final String f20514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public a f20515f;

    public i() {
        this(0, 0, 0L, null, 15, null);
    }

    private final a j0() {
        return new a(this.f20511b, this.f20512c, this.f20513d, this.f20514e);
    }

    public final synchronized void F0() {
        this.f20515f.u0(1000L);
        this.f20515f = j0();
    }

    @Override // nq.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        this.f20515f.close();
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        a.A(this.f20515f, runnable, null, false, 6, null);
    }

    @Override // nq.n0
    public void dispatchYield(@os.l um.g gVar, @os.l Runnable runnable) {
        a.A(this.f20515f, runnable, null, true, 2, null);
    }

    @Override // nq.x1
    @os.l
    public Executor f0() {
        return this.f20515f;
    }

    public final void p0(@os.l Runnable runnable, @os.l l lVar, boolean z10) {
        this.f20515f.y(runnable, lVar, z10);
    }

    public final void v0() {
        F0();
    }

    public final synchronized void w0(long j10) {
        this.f20515f.u0(j10);
    }

    public i(int i10, int i11, long j10, @os.l String str) {
        this.f20511b = i10;
        this.f20512c = i11;
        this.f20513d = j10;
        this.f20514e = str;
        this.f20515f = j0();
    }

    public /* synthetic */ i(int i10, int i11, long j10, String str, int i12, w wVar) {
        this((i12 & 1) != 0 ? o.f20522c : i10, (i12 & 2) != 0 ? o.f20523d : i11, (i12 & 4) != 0 ? o.f20524e : j10, (i12 & 8) != 0 ? "CoroutineScheduler" : str);
    }
}
