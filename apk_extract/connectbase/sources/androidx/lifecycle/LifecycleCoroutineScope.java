package androidx.lifecycle;

import jn.p;
import kn.l0;
import lm.d1;
import lm.k;
import lm.l2;
import nq.s0;
import os.l;
import os.m;
import um.d;
import wm.a;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements s0 {

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends o implements p<s0, d<? super l2>, Object> {
        final /* synthetic */ p<s0, d<? super l2>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p<? super s0, ? super d<? super l2>, ? extends Object> pVar, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            return LifecycleCoroutineScope.this.new AnonymousClass1(this.$block, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p<s0, d<? super l2>, Object> pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_common, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
            return ((AnonymousClass1) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
    public static final class C06241 extends o implements p<s0, d<? super l2>, Object> {
        final /* synthetic */ p<s0, d<? super l2>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06241(p<? super s0, ? super d<? super l2>, ? extends Object> pVar, d<? super C06241> dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            return LifecycleCoroutineScope.this.new C06241(this.$block, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p<s0, d<? super l2>, Object> pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenResumed(lifecycle$lifecycle_common, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
            return ((C06241) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
    public static final class C06251 extends o implements p<s0, d<? super l2>, Object> {
        final /* synthetic */ p<s0, d<? super l2>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06251(p<? super s0, ? super d<? super l2>, ? extends Object> pVar, d<? super C06251> dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            return LifecycleCoroutineScope.this.new C06251(this.$block, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p<s0, d<? super l2>, Object> pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_common, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
            return ((C06251) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @l
    public abstract Lifecycle getLifecycle$lifecycle_common();

    @k(message = "launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    @l
    public final nq.l2 launchWhenCreated(@l p<? super s0, ? super d<? super l2>, ? extends Object> pVar) {
        l0.p(pVar, "block");
        return nq.k.f(this, null, null, new AnonymousClass1(pVar, null), 3, null);
    }

    @k(message = "launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    @l
    public final nq.l2 launchWhenResumed(@l p<? super s0, ? super d<? super l2>, ? extends Object> pVar) {
        l0.p(pVar, "block");
        return nq.k.f(this, null, null, new C06241(pVar, null), 3, null);
    }

    @k(message = "launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    @l
    public final nq.l2 launchWhenStarted(@l p<? super s0, ? super d<? super l2>, ? extends Object> pVar) {
        l0.p(pVar, "block");
        return nq.k.f(this, null, null, new C06251(pVar, null), 3, null);
    }
}
