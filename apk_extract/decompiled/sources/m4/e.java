package m4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.jb;

/* JADX INFO: loaded from: classes.dex */
public final class e extends jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7920d;
    public final AtomicReferenceFieldUpdater e;

    public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f7917a = atomicReferenceFieldUpdater;
        this.f7918b = atomicReferenceFieldUpdater2;
        this.f7919c = atomicReferenceFieldUpdater3;
        this.f7920d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // k3.jb
    public final boolean a(j jVar, d dVar, d dVar2) {
        return this.f7920d.compareAndSet(jVar, dVar, dVar2);
    }

    @Override // k3.jb
    public final boolean b(j jVar, Object obj, Object obj2) {
        return this.e.compareAndSet(jVar, obj, obj2);
    }

    @Override // k3.jb
    public final boolean c(j jVar, i iVar, i iVar2) {
        return this.f7919c.compareAndSet(jVar, iVar, iVar2);
    }

    @Override // k3.jb
    public final d d(j jVar) {
        return (d) this.f7920d.getAndSet(jVar, d.f7913d);
    }

    @Override // k3.jb
    public final i e(j jVar) {
        return (i) this.f7919c.getAndSet(jVar, i.f7925c);
    }

    @Override // k3.jb
    public final void f(i iVar, i iVar2) {
        this.f7918b.lazySet(iVar, iVar2);
    }

    @Override // k3.jb
    public final void g(i iVar, Thread thread) {
        this.f7917a.lazySet(iVar, thread);
    }
}
