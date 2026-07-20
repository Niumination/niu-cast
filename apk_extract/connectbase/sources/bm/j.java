package bm;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j<T> implements h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f982a = AtomicIntegerFieldUpdater.newUpdater(j.class, "borrowed");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f983b = AtomicIntegerFieldUpdater.newUpdater(j.class, "disposed");

    @l
    private volatile /* synthetic */ int borrowed = 0;

    @l
    private volatile /* synthetic */ int disposed = 0;

    @l
    private volatile /* synthetic */ Object instance = null;

    @Override // bm.h
    public final int Q1() {
        return 1;
    }

    @Override // bm.h
    @l
    public final T W0() {
        int i10;
        do {
            i10 = this.borrowed;
            if (i10 != 0) {
                throw new IllegalStateException("Instance is already consumed");
            }
        } while (!f982a.compareAndSet(this, i10, 1));
        T tC = c();
        this.instance = tC;
        return tC;
    }

    public abstract void b(@l T t10);

    @l
    public abstract T c();

    @Override // bm.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bm.h
    public final void dispose() {
        Object obj;
        if (!f983b.compareAndSet(this, 0, 1) || (obj = this.instance) == null) {
            return;
        }
        this.instance = null;
        b(obj);
    }

    @Override // bm.h
    public final void recycle(@l T t10) {
        l0.p(t10, "instance");
        if (this.instance != t10) {
            if (this.instance == null && this.borrowed != 0) {
                throw new IllegalStateException("Already recycled or an irrelevant instance tried to be recycled");
            }
            throw new IllegalStateException("Unable to recycle irrelevant instance");
        }
        this.instance = null;
        if (!f983b.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException("An instance is already disposed");
        }
        b(t10);
    }
}
