package hk;

import ik.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends ck.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f5502d;
    public static final h e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f5503b;

    static {
        int iIntValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iIntValue <= 0 || iIntValue > iAvailableProcessors) {
            iIntValue = iAvailableProcessors;
        }
        f5501c = iIntValue;
        i iVar = new i(u.NONE);
        f5502d = iVar;
        iVar.unsubscribe();
        e = new h(null, 0);
    }

    public j(u uVar) {
        h hVar = e;
        AtomicReference atomicReference = new AtomicReference(hVar);
        this.f5503b = atomicReference;
        h hVar2 = new h(uVar, f5501c);
        if (atomicReference.compareAndSet(hVar, hVar2)) {
            return;
        }
        for (i iVar : hVar2.f5499b) {
            iVar.unsubscribe();
        }
    }

    @Override // ck.h
    public final ck.g a() {
        i iVar;
        h hVar = (h) this.f5503b.get();
        int i8 = hVar.f5498a;
        if (i8 == 0) {
            iVar = f5502d;
        } else {
            long j8 = hVar.f5500c;
            hVar.f5500c = 1 + j8;
            iVar = hVar.f5499b[(int) (j8 % ((long) i8))];
        }
        return new g(iVar);
    }
}
