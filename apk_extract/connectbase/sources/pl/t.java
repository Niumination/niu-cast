package pl;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lm.c1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f13212b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater<t, um.d<l2>> f13213c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.a<Boolean> f13214a;

    @os.m
    private volatile um.d<? super l2> cond;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ void a() {
        }

        public a(kn.w wVar) {
        }
    }

    static {
        AtomicReferenceFieldUpdater<t, um.d<l2>> atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(t.class, um.d.class, "cond");
        if (atomicReferenceFieldUpdaterNewUpdater == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.atomic.AtomicReferenceFieldUpdater<io.ktor.utils.io.Condition, kotlin.coroutines.Continuation<kotlin.Unit>?>");
        }
        f13213c = atomicReferenceFieldUpdaterNewUpdater;
    }

    public t(@os.l jn.a<Boolean> aVar) {
        kn.l0.p(aVar, "predicate");
        this.f13214a = aVar;
    }

    @os.m
    public final Object b(@os.l jn.a<l2> aVar, @os.l um.d<? super l2> dVar) {
        Object obj;
        if (this.f13214a.invoke().booleanValue()) {
            return l2.f10208a;
        }
        AtomicReferenceFieldUpdater<t, um.d<l2>> atomicReferenceFieldUpdater = f13213c;
        if (!j.d.a(atomicReferenceFieldUpdater, this, null, dVar)) {
            throw new IllegalStateException();
        }
        if (this.f13214a.invoke().booleanValue() && j.d.a(atomicReferenceFieldUpdater, this, dVar, null)) {
            obj = l2.f10208a;
        } else {
            aVar.invoke();
            obj = wm.a.COROUTINE_SUSPENDED;
        }
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        if (obj == aVar2) {
            xm.h.c(dVar);
        }
        return obj == aVar2 ? obj : l2.f10208a;
    }

    @os.m
    public final Object c(@os.l um.d<? super l2> dVar) {
        if (this.f13214a.invoke().booleanValue()) {
            return l2.f10208a;
        }
        AtomicReferenceFieldUpdater<t, um.d<l2>> atomicReferenceFieldUpdater = f13213c;
        if (!j.d.a(atomicReferenceFieldUpdater, this, null, dVar)) {
            throw new IllegalStateException();
        }
        Object obj = (this.f13214a.invoke().booleanValue() && j.d.a(atomicReferenceFieldUpdater, this, dVar, null)) ? l2.f10208a : wm.a.COROUTINE_SUSPENDED;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (obj == aVar) {
            xm.h.c(dVar);
        }
        return obj == aVar ? obj : l2.f10208a;
    }

    public final Object d(jn.a<l2> aVar, um.d<? super l2> dVar) {
        Object obj;
        if (this.f13214a.invoke().booleanValue()) {
            return l2.f10208a;
        }
        AtomicReferenceFieldUpdater<t, um.d<l2>> atomicReferenceFieldUpdater = f13213c;
        if (!j.d.a(atomicReferenceFieldUpdater, this, null, dVar)) {
            throw new IllegalStateException();
        }
        if (this.f13214a.invoke().booleanValue() && j.d.a(atomicReferenceFieldUpdater, this, dVar, null)) {
            obj = l2.f10208a;
        } else {
            aVar.invoke();
            obj = wm.a.COROUTINE_SUSPENDED;
        }
        if (obj == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return l2.f10208a;
    }

    public final Object e(um.d<? super l2> dVar) {
        if (this.f13214a.invoke().booleanValue()) {
            return l2.f10208a;
        }
        AtomicReferenceFieldUpdater<t, um.d<l2>> atomicReferenceFieldUpdater = f13213c;
        if (!j.d.a(atomicReferenceFieldUpdater, this, null, dVar)) {
            throw new IllegalStateException();
        }
        if (((this.f13214a.invoke().booleanValue() && j.d.a(atomicReferenceFieldUpdater, this, dVar, null)) ? l2.f10208a : wm.a.COROUTINE_SUSPENDED) == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return l2.f10208a;
    }

    public final boolean f() {
        return this.f13214a.invoke().booleanValue();
    }

    @os.l
    public final jn.a<Boolean> g() {
        return this.f13214a;
    }

    public final void h() {
        um.d<? super l2> dVar = this.cond;
        if (dVar != null && this.f13214a.invoke().booleanValue() && j.d.a(f13213c, this, dVar, null)) {
            um.d dVarE = wm.c.e(dVar);
            c1.a aVar = c1.Companion;
            dVarE.resumeWith(c1.m59constructorimpl(l2.f10208a));
        }
    }

    @os.l
    public String toString() {
        return "Condition(cond=" + this.cond + ')';
    }
}
