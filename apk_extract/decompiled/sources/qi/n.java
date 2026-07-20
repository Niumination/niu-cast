package qi;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9156a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new p(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9156a;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            int iA = pVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                atomicReferenceFieldUpdater.compareAndSet(this, pVar, pVar.c());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final int b() {
        p pVar = (p) f9156a.get(this);
        pVar.getClass();
        long j8 = p.f.get(pVar);
        return 1073741823 & (((int) ((j8 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j8)));
    }

    public final Object c() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9156a;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            Object objD = pVar.d();
            if (objD != p.f9158g) {
                return objD;
            }
            atomicReferenceFieldUpdater.compareAndSet(this, pVar, pVar.c());
        }
    }
}
