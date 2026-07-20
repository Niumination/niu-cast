package wl;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import lm.y;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f19724b = AtomicIntegerFieldUpdater.newUpdater(j.class, "_availableForRead$internal");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f19725c = AtomicIntegerFieldUpdater.newUpdater(j.class, "_availableForWrite$internal");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f19726d = AtomicIntegerFieldUpdater.newUpdater(j.class, "_pendingToFlush");

    @os.l
    public volatile /* synthetic */ int _availableForWrite$internal;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19727a;

    @os.l
    public volatile /* synthetic */ int _availableForRead$internal = 0;

    @os.l
    volatile /* synthetic */ int _pendingToFlush = 0;

    public j(int i10) {
        this.f19727a = i10;
        this._availableForWrite$internal = i10;
    }

    public final void a(int i10) {
        int i11;
        int i12;
        do {
            i11 = this._availableForWrite$internal;
            i12 = i11 + i10;
            if (i12 > this.f19727a) {
                b(i11, i12, i10);
                throw new y();
            }
        } while (!f19725c.compareAndSet(this, i11, i12));
    }

    public final Void b(int i10, int i11, int i12) {
        StringBuilder sbA = i0.a.a("Completed read overflow: ", i10, " + ", i12, " = ");
        sbA.append(i11);
        sbA.append(" > ");
        sbA.append(this.f19727a);
        throw new IllegalArgumentException(sbA.toString());
    }

    public final void c(int i10) {
        int i11;
        int i12;
        do {
            i11 = this._pendingToFlush;
            i12 = i11 + i10;
            if (i12 > this.f19727a) {
                d(i11, i10);
                throw new y();
            }
        } while (!f19726d.compareAndSet(this, i11, i12));
    }

    public final Void d(int i10, int i11) {
        StringBuilder sbA = i0.a.a("Complete write overflow: ", i10, " + ", i11, " > ");
        sbA.append(this.f19727a);
        throw new IllegalArgumentException(sbA.toString());
    }

    public final boolean e() {
        int andSet = f19726d.getAndSet(this, 0);
        if (andSet == 0) {
            return this._availableForRead$internal > 0;
        }
        return f19724b.addAndGet(this, andSet) > 0;
    }

    public final void f() {
        f19725c.getAndSet(this, 0);
    }

    public final int g() {
        return this._availableForRead$internal;
    }

    public final int h() {
        return this._availableForWrite$internal;
    }

    public final int i() {
        return this._pendingToFlush;
    }

    public final boolean j() {
        return this._availableForWrite$internal == this.f19727a;
    }

    public final boolean k() {
        return this._availableForWrite$internal == 0;
    }

    public final void l() {
        this._availableForRead$internal = this.f19727a;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final void m() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.f19727a;
    }

    public final void n(int i10) {
        this._availableForRead$internal = i10;
    }

    public final void o(int i10) {
        this._availableForWrite$internal = i10;
    }

    public final void p(int i10) {
        this._pendingToFlush = i10;
    }

    public final boolean q() {
        int i10;
        do {
            i10 = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || i10 != this.f19727a) {
                return false;
            }
        } while (!f19725c.compareAndSet(this, i10, 0));
        return true;
    }

    public final int r(int i10) {
        int i11;
        do {
            i11 = this._availableForRead$internal;
            if (i11 < i10) {
                return 0;
            }
        } while (!f19724b.compareAndSet(this, i11, 0));
        return i11;
    }

    public final int s(int i10) {
        int i11;
        int iMin;
        do {
            i11 = this._availableForRead$internal;
            iMin = Math.min(i10, i11);
            if (iMin == 0) {
                return 0;
            }
        } while (!f19724b.compareAndSet(this, i11, i11 - iMin));
        return Math.min(i10, i11);
    }

    public final boolean t(int i10) {
        int i11;
        do {
            i11 = this._availableForRead$internal;
            if (i11 < i10) {
                return false;
            }
        } while (!f19724b.compareAndSet(this, i11, i11 - i10));
        return true;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("RingBufferCapacity[read: ");
        sb2.append(this._availableForRead$internal);
        sb2.append(", write: ");
        sb2.append(this._availableForWrite$internal);
        sb2.append(", flush: ");
        sb2.append(this._pendingToFlush);
        sb2.append(", capacity: ");
        return u.a.a(sb2, this.f19727a, ']');
    }

    public final int u(int i10) {
        int i11;
        do {
            i11 = this._availableForWrite$internal;
            if (i11 < i10) {
                return 0;
            }
        } while (!f19725c.compareAndSet(this, i11, 0));
        return i11;
    }

    public final int v(int i10) {
        int i11;
        int iMin;
        do {
            i11 = this._availableForWrite$internal;
            iMin = Math.min(i10, i11);
            if (iMin == 0) {
                return 0;
            }
        } while (!f19725c.compareAndSet(this, i11, i11 - iMin));
        return Math.min(i10, i11);
    }

    public final boolean w(int i10) {
        int i11;
        do {
            i11 = this._availableForWrite$internal;
            if (i11 < i10) {
                return false;
            }
        } while (!f19725c.compareAndSet(this, i11, i11 - i10));
        return true;
    }
}
