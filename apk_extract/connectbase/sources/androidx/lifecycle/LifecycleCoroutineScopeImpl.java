package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import jn.p;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.k;
import nq.k1;
import nq.r2;
import nq.s0;
import os.l;
import os.m;
import um.d;
import um.g;
import wm.a;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    @l
    private final g coroutineContext;

    @l
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends o implements p<s0, d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            AnonymousClass1 anonymousClass1 = LifecycleCoroutineScopeImpl.this.new AnonymousClass1(dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            s0 s0Var = (s0) this.L$0;
            if (LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().addObserver(LifecycleCoroutineScopeImpl.this);
            } else {
                r2.j(s0Var.getCoroutineContext(), null, 1, null);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
            return ((AnonymousClass1) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public LifecycleCoroutineScopeImpl(@l Lifecycle lifecycle, @l g gVar) {
        l0.p(lifecycle, "lifecycle");
        l0.p(gVar, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = gVar;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            r2.j(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    @l
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event) {
        l0.p(lifecycleOwner, "source");
        l0.p(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            r2.j(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        k.f(this, k1.e().f0(), null, new AnonymousClass1(null), 2, null);
    }
}
