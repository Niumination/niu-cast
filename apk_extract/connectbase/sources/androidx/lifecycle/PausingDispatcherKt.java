package androidx.lifecycle;

import jn.p;
import lm.d1;
import lm.l2;
import nq.k;
import nq.k1;
import nq.s0;
import os.l;
import os.m;
import um.d;
import wm.a;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcherKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    @f(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
    public static final class AnonymousClass2<T> extends o implements p<s0, d<? super T>, Object> {
        final /* synthetic */ p<s0, d<? super T>, Object> $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, p<? super s0, ? super d<? super T>, ? extends Object> pVar, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = pVar;
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws Throwable {
            LifecycleController lifecycleController;
            a aVar = a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    d1.n(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    lifecycleController.finish();
                    throw th;
                }
            }
            d1.n(obj);
            nq.l2 l2Var = (nq.l2) ((s0) this.L$0).getCoroutineContext().get(nq.l2.f11882k);
            if (l2Var == null) {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, l2Var);
            try {
                p<s0, d<? super T>, Object> pVar = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = k.g(pausingDispatcher, pVar, this);
                if (obj == aVar) {
                    return aVar;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th3) {
                th = th3;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m d<? super T> dVar) {
            return ((AnonymousClass2) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @m
    @lm.k(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenCreated(@l LifecycleOwner lifecycleOwner, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, dVar);
    }

    @m
    @lm.k(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenResumed(@l LifecycleOwner lifecycleOwner, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, dVar);
    }

    @m
    @lm.k(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStarted(@l LifecycleOwner lifecycleOwner, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, dVar);
    }

    @m
    @lm.k(message = "whenStateAtLeast has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStateAtLeast for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStateAtLeast(@l Lifecycle lifecycle, @l Lifecycle.State state, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return k.g(k1.e().f0(), new AnonymousClass2(lifecycle, state, pVar, null), dVar);
    }

    @m
    @lm.k(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenCreated(@l Lifecycle lifecycle, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, dVar);
    }

    @m
    @lm.k(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenResumed(@l Lifecycle lifecycle, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, dVar);
    }

    @m
    @lm.k(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStarted(@l Lifecycle lifecycle, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, dVar);
    }
}
