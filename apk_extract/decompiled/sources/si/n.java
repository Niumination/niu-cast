package si;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10131b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10132c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10133d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f10134a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final j a(j jVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10132c;
        if (atomicIntegerFieldUpdater.get(this) - f10133d.get(this) == 127) {
            return jVar;
        }
        if (jVar.f10124b) {
            e.incrementAndGet(this);
        }
        int i8 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f10134a;
            if (atomicReferenceArray.get(i8) == null) {
                atomicReferenceArray.lazySet(i8, jVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final j b() {
        j jVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10133d;
            int i8 = atomicIntegerFieldUpdater.get(this);
            if (i8 - f10132c.get(this) == 0) {
                return null;
            }
            int i9 = i8 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i8, i8 + 1) && (jVar = (j) this.f10134a.getAndSet(i9, null)) != null) {
                if (jVar.f10124b) {
                    e.decrementAndGet(this);
                }
                return jVar;
            }
        }
    }

    public final j c(int i8, boolean z2) {
        int i9 = i8 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f10134a;
        j jVar = (j) atomicReferenceArray.get(i9);
        if (jVar == null || jVar.f10124b != z2 || !atomicReferenceArray.compareAndSet(i9, jVar, null)) {
            return null;
        }
        if (z2) {
            e.decrementAndGet(this);
        }
        return jVar;
    }
}
