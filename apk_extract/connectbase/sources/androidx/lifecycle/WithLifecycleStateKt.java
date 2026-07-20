package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import jn.a;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.z0;
import nq.k1;
import nq.q;
import nq.x2;
import os.l;
import os.m;
import um.d;
import um.i;
import wm.c;
import xm.h;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,206:1\n154#1,8:207\n154#1,8:215\n154#1,8:223\n154#1,8:231\n43#1,5:239\n154#1,8:244\n43#1,5:252\n154#1,8:257\n154#1,8:265\n154#1,8:273\n154#1,8:281\n314#2,11:289\n*S KotlinDebug\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n*L\n47#1:207,8\n58#1:215,8\n71#1:223,8\n84#1:231,8\n98#1:239,5\n98#1:244,8\n98#1:252,5\n98#1:257,8\n111#1:265,8\n124#1:273,8\n137#1:281,8\n177#1:289,11\n*E\n"})
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    @r1({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt$withStateAtLeastUnchecked$2\n*L\n1#1,206:1\n*E\n"})
    public static final class AnonymousClass2<R> extends n0 implements a<R> {
        final /* synthetic */ a<R> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(a<? extends R> aVar) {
            super(0);
            this.$block = aVar;
        }

        @Override // jn.a
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    @m
    @z0
    public static final <R> Object suspendWithStateAtLeastUnchecked(@l final Lifecycle lifecycle, @l final Lifecycle.State state, boolean z10, @l nq.n0 n0Var, @l final a<? extends R> aVar, @l d<? super R> dVar) {
        final q qVar = new q(c.e(dVar), 1);
        qVar.F();
        final ?? r10 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event) {
                Object objM59constructorimpl;
                l0.p(lifecycleOwner, "source");
                l0.p(event, NotificationCompat.CATEGORY_EVENT);
                if (event != Lifecycle.Event.Companion.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        d dVar2 = qVar;
                        c1.a aVar2 = c1.Companion;
                        dVar2.resumeWith(c1.m59constructorimpl(d1.a(new LifecycleDestroyedException())));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                d dVar3 = qVar;
                a<R> aVar3 = aVar;
                try {
                    c1.a aVar4 = c1.Companion;
                    objM59constructorimpl = c1.m59constructorimpl(aVar3.invoke());
                } catch (Throwable th2) {
                    c1.a aVar5 = c1.Companion;
                    objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
                }
                dVar3.resumeWith(objM59constructorimpl);
            }
        };
        if (z10) {
            n0Var.dispatch(i.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r10);
                }
            });
        } else {
            lifecycle.addObserver(r10);
        }
        qVar.H(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(n0Var, lifecycle, r10));
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            h.c(dVar);
        }
        return objZ;
    }

    @m
    public static final <R> Object withCreated(@l Lifecycle lifecycle, @l a<? extends R> aVar, @l d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, a<? extends R> aVar, d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        k1.e().f0();
        throw null;
    }

    @m
    public static final <R> Object withResumed(@l Lifecycle lifecycle, @l a<? extends R> aVar, @l d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, a<? extends R> aVar, d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        k1.e().f0();
        throw null;
    }

    @m
    public static final <R> Object withStarted(@l Lifecycle lifecycle, @l a<? extends R> aVar, @l d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, a<? extends R> aVar, d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        k1.e().f0();
        throw null;
    }

    @m
    public static final <R> Object withStateAtLeast(@l Lifecycle lifecycle, @l Lifecycle.State state, @l a<? extends R> aVar, @l d<? super R> dVar) {
        if (state.compareTo(Lifecycle.State.CREATED) < 0) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, a<? extends R> aVar, d<? super R> dVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            k1.e().f0();
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @m
    @z0
    public static final <R> Object withStateAtLeastUnchecked(@l Lifecycle lifecycle, @l Lifecycle.State state, @l a<? extends R> aVar, @l d<? super R> dVar) {
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    @z0
    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, a<? extends R> aVar, d<? super R> dVar) {
        k1.e().f0();
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, a<? extends R> aVar, d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        k1.e().f0();
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, a<? extends R> aVar, d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        k1.e().f0();
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, a<? extends R> aVar, d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        k1.e().f0();
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, a<? extends R> aVar, d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            k1.e().f0();
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @m
    public static final <R> Object withCreated(@l LifecycleOwner lifecycleOwner, @l a<? extends R> aVar, @l d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    @m
    public static final <R> Object withResumed(@l LifecycleOwner lifecycleOwner, @l a<? extends R> aVar, @l d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    @m
    public static final <R> Object withStarted(@l LifecycleOwner lifecycleOwner, @l a<? extends R> aVar, @l d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        x2 x2VarF0 = k1.e().f0();
        boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
    }

    @m
    public static final <R> Object withStateAtLeast(@l LifecycleOwner lifecycleOwner, @l Lifecycle.State state, @l a<? extends R> aVar, @l d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            x2 x2VarF0 = k1.e().f0();
            boolean zIsDispatchNeeded = x2VarF0.isDispatchNeeded(dVar.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, x2VarF0, new AnonymousClass2(aVar), dVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
