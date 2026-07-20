package ar;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kn.r1;
import os.l;
import os.m;
import q1.w2;
import vq.r0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n371#1,2:398\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n384#1:398,2\n*E\n"})
public final class g extends r0<g> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final AtomicReferenceArray f710e;

    public g(long j10, @m g gVar, int i10) {
        super(j10, gVar, i10);
        this.f710e = new AtomicReferenceArray(f.f709f);
    }

    @Override // vq.r0
    public int p() {
        return f.f709f;
    }

    @Override // vq.r0
    public void q(int i10, @m Throwable th2, @l um.g gVar) {
        this.f710e.set(i10, f.f708e);
        r();
    }

    public final boolean t(int i10, @m Object obj, @m Object obj2) {
        return w2.a(this.f710e, i10, obj, obj2);
    }

    @l
    public String toString() {
        return "SemaphoreSegment[id=" + this.f17877c + ", hashCode=" + hashCode() + ']';
    }

    @m
    public final Object u(int i10) {
        return this.f710e.get(i10);
    }

    @l
    public final AtomicReferenceArray v() {
        return this.f710e;
    }

    @m
    public final Object w(int i10, @m Object obj) {
        return this.f710e.getAndSet(i10, obj);
    }

    public final void x(int i10, @m Object obj) {
        this.f710e.set(i10, obj);
    }
}
