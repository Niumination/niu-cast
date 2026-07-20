package xq;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kn.r1;
import kn.w;
import lm.z0;
import nq.n0;
import nq.x1;
import nq.y0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
@z0
public class e extends x1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f20501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final String f20502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public a f20503f;

    public e(int i10, int i11, long j10, @os.l String str) {
        this.f20499b = i10;
        this.f20500c = i11;
        this.f20501d = j10;
        this.f20502e = str;
        this.f20503f = v0();
    }

    public static /* synthetic */ n0 p0(e eVar, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
        }
        if ((i11 & 1) != 0) {
            i10 = 16;
        }
        return eVar.j0(i10);
    }

    @os.l
    public final n0 F0(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(h.a.a("Expected positive parallelism level, but have ", i10).toString());
        }
        if (i10 <= this.f20499b) {
            return new g(this, i10, null, 0);
        }
        throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f20499b + "), but have " + i10).toString());
    }

    @Override // nq.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        this.f20503f.close();
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        try {
            a.A(this.f20503f, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            y0.f11985g.k2(runnable);
        }
    }

    @Override // nq.n0
    public void dispatchYield(@os.l um.g gVar, @os.l Runnable runnable) {
        try {
            a.A(this.f20503f, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            y0.f11985g.dispatchYield(gVar, runnable);
        }
    }

    @Override // nq.x1
    @os.l
    public Executor f0() {
        return this.f20503f;
    }

    @os.l
    public final n0 j0(int i10) {
        if (i10 > 0) {
            return new g(this, i10, null, 1);
        }
        throw new IllegalArgumentException(h.a.a("Expected positive parallelism level, but have ", i10).toString());
    }

    @Override // nq.n0
    @os.l
    public String toString() {
        return super.toString() + "[scheduler = " + this.f20503f + ']';
    }

    public final a v0() {
        return new a(this.f20499b, this.f20500c, this.f20501d, this.f20502e);
    }

    public final void w0(@os.l Runnable runnable, @os.l l lVar, boolean z10) {
        try {
            this.f20503f.y(runnable, lVar, z10);
        } catch (RejectedExecutionException unused) {
            y0.f11985g.k2(this.f20503f.n(runnable, lVar));
        }
    }

    public /* synthetic */ e(int i10, int i11, long j10, String str, int i12, w wVar) {
        this(i10, i11, j10, (i12 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public /* synthetic */ e(int i10, int i11, String str, int i12, w wVar) {
        this((i12 & 1) != 0 ? o.f20522c : i10, (i12 & 2) != 0 ? o.f20523d : i11, (i12 & 4) != 0 ? o.f20520a : str);
    }

    public e(int i10, int i11, @os.l String str) {
        this(i10, i11, o.f20524e, str);
    }

    public /* synthetic */ e(int i10, int i11, int i12, w wVar) {
        this((i12 & 1) != 0 ? o.f20522c : i10, (i12 & 2) != 0 ? o.f20523d : i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ e(int i10, int i11) {
        this(i10, i11, o.f20524e, null, 8, null);
    }
}
