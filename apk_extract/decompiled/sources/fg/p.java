package fg;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceArray f5047c;
    public static final k f = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5044d = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(p.class, "_state");

    public p(int i8) {
        this.f5045a = i8;
        int i9 = i8 - 1;
        this.f5046b = i9;
        this.f5047c = new AtomicReferenceArray(i8);
        if (i9 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i8 & i9) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(s element) {
        long j8;
        int i8;
        Intrinsics.checkNotNullParameter(element, "element");
        do {
            j8 = this._state;
            if ((3458764513820540928L & j8) != 0) {
                return (2305843009213693952L & j8) != 0 ? 2 : 1;
            }
            int i9 = (int) (1073741823 & j8);
            i8 = (int) ((1152921503533105152L & j8) >> 30);
            int i10 = this.f5046b;
            if (((i8 + 2) & i10) == (i9 & i10)) {
                return 1;
            }
        } while (!e.compareAndSet(this, j8, ((-1152921503533105153L) & j8) | (((long) ((i8 + 1) & 1073741823)) << 30)));
        this.f5047c.set(this.f5046b & i8, element);
        while ((this._state & 1152921504606846976L) != 0) {
            this = this.d();
            AtomicReferenceArray atomicReferenceArray = this.f5047c;
            int i11 = this.f5046b & i8;
            Object obj = atomicReferenceArray.get(i11);
            if ((obj instanceof o) && ((o) obj).f5043a == i8) {
                atomicReferenceArray.set(i11, element);
            } else {
                this = null;
            }
            if (this == null) {
                return 0;
            }
        }
        return 0;
    }

    public final boolean b() {
        long j8;
        do {
            j8 = this._state;
            if ((j8 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j8) != 0) {
                return false;
            }
        } while (!e.compareAndSet(this, j8, j8 | 2305843009213693952L));
        return true;
    }

    public final boolean c() {
        long j8 = this._state;
        return ((int) (1073741823 & j8)) == ((int) ((j8 & 1152921503533105152L) >> 30));
    }

    public final p d() {
        long j8;
        while (true) {
            j8 = this._state;
            if ((j8 & 1152921504606846976L) != 0) {
                break;
            }
            long j10 = j8 | 1152921504606846976L;
            if (e.compareAndSet(this, j8, j10)) {
                j8 = j10;
                break;
            }
        }
        while (true) {
            p pVar = (p) this._next;
            if (pVar != null) {
                return pVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5044d;
            p pVar2 = new p(this.f5045a * 2);
            int i8 = (int) (1073741823 & j8);
            int i9 = (int) ((1152921503533105152L & j8) >> 30);
            while (true) {
                int i10 = this.f5046b;
                int i11 = i8 & i10;
                if (i11 != (i10 & i9)) {
                    AtomicReferenceArray atomicReferenceArray = pVar2.f5047c;
                    int i12 = pVar2.f5046b & i8;
                    Object oVar = this.f5047c.get(i11);
                    if (oVar == null) {
                        oVar = new o(i8);
                    }
                    atomicReferenceArray.set(i12, oVar);
                    i8++;
                }
            }
            pVar2._state = (-1152921504606846977L) & j8;
            atomicReferenceFieldUpdater.compareAndSet(this, null, pVar2);
        }
    }

    public final Object e() {
        Object obj;
        p pVarD = this;
        long j8 = pVarD._state;
        if ((j8 & 1152921504606846976L) != 0) {
            return f;
        }
        int i8 = (int) (j8 & 1073741823);
        int i9 = pVarD.f5046b;
        int i10 = ((int) ((1152921503533105152L & j8) >> 30)) & i9;
        int i11 = i9 & i8;
        if (i10 == i11 || (obj = pVarD.f5047c.get(i11)) == null || (obj instanceof o)) {
            return null;
        }
        long j10 = (i8 + 1) & 1073741823;
        if (e.compareAndSet(this, j8, (j8 & (-1073741824)) | j10)) {
            pVarD.f5047c.set(pVarD.f5046b & i8, null);
            return obj;
        }
        while (true) {
            long j11 = pVarD._state;
            int i12 = (int) (j11 & 1073741823);
            if (i12 != i8) {
                throw new IllegalStateException("This queue can have only one consumer");
            }
            if ((j11 & 1152921504606846976L) != 0) {
                pVarD = pVarD.d();
            } else if (e.compareAndSet(pVarD, j11, (j11 & (-1073741824)) | j10)) {
                pVarD.f5047c.set(pVarD.f5046b & i12, null);
                pVarD = null;
            } else {
                continue;
            }
            if (pVarD == null) {
                return obj;
            }
        }
    }
}
