package qi;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(p.class, "_state$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a8.a f9158g = new a8.a("REMOVE_FROZEN", 15);
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f9162d;

    public p(int i8, boolean z2) {
        this.f9159a = i8;
        this.f9160b = z2;
        int i9 = i8 - 1;
        this.f9161c = i9;
        this.f9162d = new AtomicReferenceArray(i8);
        if (i9 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i8 & i9) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j8 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j8) != 0) {
                return (2305843009213693952L & j8) != 0 ? 2 : 1;
            }
            int i8 = (int) (1073741823 & j8);
            int i9 = (int) ((1152921503533105152L & j8) >> 30);
            int i10 = this.f9161c;
            if (((i9 + 2) & i10) == (i8 & i10)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f9162d;
            if (!this.f9160b && atomicReferenceArray.get(i9 & i10) != null) {
                int i11 = this.f9159a;
                if (i11 < 1024 || ((i9 - i8) & 1073741823) > (i11 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j8, ((-1152921503533105153L) & j8) | (((long) ((i9 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i9 & i10, runnable);
                while ((atomicLongFieldUpdater.get(this) & 1152921504606846976L) != 0) {
                    this = this.c();
                    AtomicReferenceArray atomicReferenceArray2 = this.f9162d;
                    int i12 = this.f9161c & i9;
                    Object obj = atomicReferenceArray2.get(i12);
                    if ((obj instanceof o) && ((o) obj).f9157a == i9) {
                        atomicReferenceArray2.set(i12, runnable);
                    } else {
                        this = null;
                    }
                    if (this == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j8;
        do {
            atomicLongFieldUpdater = f;
            j8 = atomicLongFieldUpdater.get(this);
            if ((j8 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j8) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j8, 2305843009213693952L | j8));
        return true;
    }

    public final p c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j8;
        while (true) {
            atomicLongFieldUpdater = f;
            j8 = atomicLongFieldUpdater.get(this);
            if ((j8 & 1152921504606846976L) != 0) {
                break;
            }
            long j10 = j8 | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j8, j10)) {
                j8 = j10;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p(this.f9159a * 2, this.f9160b);
            int i8 = (int) (1073741823 & j8);
            int i9 = (int) ((1152921503533105152L & j8) >> 30);
            while (true) {
                int i10 = this.f9161c;
                int i11 = i8 & i10;
                if (i11 != (i10 & i9)) {
                    Object oVar = this.f9162d.get(i11);
                    if (oVar == null) {
                        oVar = new o(i8);
                    }
                    pVar2.f9162d.set(pVar2.f9161c & i8, oVar);
                    i8++;
                }
            }
            atomicLongFieldUpdater.set(pVar2, (-1152921504606846977L) & j8);
            atomicReferenceFieldUpdater.compareAndSet(this, null, pVar2);
        }
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j8 = atomicLongFieldUpdater.get(this);
            if ((j8 & 1152921504606846976L) != 0) {
                return f9158g;
            }
            int i8 = (int) (j8 & 1073741823);
            int i9 = this.f9161c;
            int i10 = i8 & i9;
            if ((((int) ((1152921503533105152L & j8) >> 30)) & i9) == i10) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f9162d;
            Object obj = atomicReferenceArray.get(i10);
            boolean z2 = this.f9160b;
            if (obj == null) {
                if (z2) {
                    return null;
                }
            } else {
                if (obj instanceof o) {
                    return null;
                }
                long j10 = (i8 + 1) & 1073741823;
                if (atomicLongFieldUpdater.compareAndSet(this, j8, (j8 & (-1073741824)) | j10)) {
                    atomicReferenceArray.set(i10, null);
                    return obj;
                }
                if (z2) {
                    p pVarC = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f;
                        long j11 = atomicLongFieldUpdater2.get(pVarC);
                        int i11 = (int) (j11 & 1073741823);
                        if ((j11 & 1152921504606846976L) != 0) {
                            pVarC = pVarC.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(pVarC, j11, (j11 & (-1073741824)) | j10)) {
                                pVarC.f9162d.set(pVarC.f9161c & i11, null);
                                pVarC = null;
                            } else {
                                continue;
                            }
                        }
                        if (pVarC == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
