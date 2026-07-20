package xq;

import in.x;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import nq.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends x1 implements l, Executor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f20504g = AtomicIntegerFieldUpdater.newUpdater(g.class, "inFlightTasks");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final e f20505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final String f20507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final ConcurrentLinkedQueue<Runnable> f20509f = new ConcurrentLinkedQueue<>();

    @x
    private volatile int inFlightTasks;

    public g(@os.l e eVar, int i10, @os.m String str, int i11) {
        this.f20505b = eVar;
        this.f20506c = i10;
        this.f20507d = str;
        this.f20508e = i11;
    }

    @Override // nq.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher");
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        j0(runnable, false);
    }

    @Override // nq.n0
    public void dispatchYield(@os.l um.g gVar, @os.l Runnable runnable) {
        j0(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@os.l Runnable runnable) {
        j0(runnable, false);
    }

    @Override // nq.x1
    @os.l
    public Executor f0() {
        return this;
    }

    @Override // xq.l
    public void h() {
        Runnable runnablePoll = this.f20509f.poll();
        if (runnablePoll != null) {
            this.f20505b.w0(runnablePoll, this, true);
            return;
        }
        f20504g.decrementAndGet(this);
        Runnable runnablePoll2 = this.f20509f.poll();
        if (runnablePoll2 == null) {
            return;
        }
        j0(runnablePoll2, true);
    }

    public final void j0(Runnable runnable, boolean z10) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20504g;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f20506c) {
                this.f20505b.w0(runnable, this, z10);
                return;
            }
            this.f20509f.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f20506c) {
                return;
            } else {
                runnable = this.f20509f.poll();
            }
        } while (runnable != null);
    }

    @Override // xq.l
    public int q() {
        return this.f20508e;
    }

    @Override // nq.n0
    @os.l
    public String toString() {
        String str = this.f20507d;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f20505b + ']';
    }
}
