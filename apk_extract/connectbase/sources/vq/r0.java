package vq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.r1;
import nq.b3;
import vq.r0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n1#1,269:1\n252#2,4:270\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n*L\n225#1:270,4\n*E\n"})
public abstract class r0<S extends r0<S>> extends g<S> implements b3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f17876d = AtomicIntegerFieldUpdater.newUpdater(r0.class, "cleanedAndPointers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    public final long f17877c;

    @in.x
    private volatile int cleanedAndPointers;

    public r0(long j10, @os.m S s10, int i10) {
        super(s10);
        this.f17877c = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    @Override // vq.g
    public boolean h() {
        return f17876d.get(this) == p() && !i();
    }

    public final boolean o() {
        return f17876d.addAndGet(this, -65536) == p() && !i();
    }

    public abstract int p();

    public abstract void q(int i10, @os.m Throwable th2, @os.l um.g gVar);

    public final void r() {
        if (f17876d.incrementAndGet(this) == p()) {
            l();
        }
    }

    public final boolean s() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17876d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == p() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
