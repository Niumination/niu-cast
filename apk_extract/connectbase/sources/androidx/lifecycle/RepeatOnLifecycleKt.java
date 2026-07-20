package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import jn.p;
import kn.k1;
import kn.l0;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.k;
import nq.q;
import nq.s0;
import nq.t0;
import nq.x2;
import os.l;
import os.m;
import um.d;
import wm.a;
import wm.c;
import xm.f;
import xm.h;
import xm.o;

/* JADX INFO: loaded from: classes.dex */
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends o implements p<s0, d<? super l2>, Object> {
        final /* synthetic */ p<s0, d<? super l2>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        @r1({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
        @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
        public static final class AnonymousClass1 extends o implements p<s0, d<? super l2>, Object> {
            final /* synthetic */ s0 $$this$coroutineScope;
            final /* synthetic */ p<s0, d<? super l2>, Object> $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, s0 s0Var, p<? super s0, ? super d<? super l2>, ? extends Object> pVar, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = s0Var;
                this.$block = pVar;
            }

            @Override // xm.a
            @l
            public final d<l2> create(@m Object obj, @l d<?> dVar) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, dVar);
            }

            /* JADX WARN: Code duplicated, block: B:28:0x00b1  */
            /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
            /* JADX WARN: Code duplicated, block: B:36:0x00c9  */
            /* JADX WARN: Code duplicated, block: B:39:0x00d3  */
            /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) throws Throwable {
                k1.h hVar;
                k1.h hVar2;
                nq.l2 l2Var;
                LifecycleEventObserver lifecycleEventObserver;
                nq.l2 l2Var2;
                LifecycleEventObserver lifecycleEventObserver2;
                a aVar = a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    hVar2 = (k1.h) this.L$1;
                    hVar = (k1.h) this.L$0;
                    try {
                        d1.n(obj);
                        l2Var2 = (nq.l2) hVar.element;
                        if (l2Var2 != null) {
                            nq.l2.a.b(l2Var2, null, 1, null);
                        }
                        lifecycleEventObserver2 = (LifecycleEventObserver) hVar2.element;
                        if (lifecycleEventObserver2 != null) {
                            this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver2);
                        }
                        return l2.f10208a;
                    } catch (Throwable th2) {
                        th = th2;
                        l2Var = (nq.l2) hVar.element;
                        if (l2Var != null) {
                            nq.l2.a.b(l2Var, null, 1, null);
                        }
                        lifecycleEventObserver = (LifecycleEventObserver) hVar2.element;
                        if (lifecycleEventObserver != null) {
                            this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver);
                        }
                        throw th;
                    }
                }
                d1.n(obj);
                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    return l2.f10208a;
                }
                final k1.h hVar3 = new k1.h();
                k1.h hVar4 = new k1.h();
                try {
                    Lifecycle.State state = this.$state;
                    Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                    final s0 s0Var = this.$$this$coroutineScope;
                    final p<s0, d<? super l2>, Object> pVar = this.$block;
                    this.L$0 = hVar3;
                    this.L$1 = hVar4;
                    this.L$2 = state;
                    this.L$3 = lifecycle;
                    this.L$4 = s0Var;
                    this.L$5 = pVar;
                    this.label = 1;
                    final q qVar = new q(c.e(this), 1);
                    qVar.F();
                    Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                    final Lifecycle.Event eventUpTo = companion.upTo(state);
                    final Lifecycle.Event eventDownFrom = companion.downFrom(state);
                    final ar.a aVarB = ar.c.b(false, 1, null);
                    ?? r10 = new LifecycleEventObserver() { // from class: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1

                        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
                        @r1({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,165:1\n107#2,10:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1\n*L\n109#1:166,10\n*E\n"})
                        @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {0, 1}, l = {171, 110}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
                        public static final class AnonymousClass1 extends o implements p<s0, d<? super l2>, Object> {
                            final /* synthetic */ p<s0, d<? super l2>, Object> $block;
                            final /* synthetic */ ar.a $mutex;
                            Object L$0;
                            Object L$1;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            public AnonymousClass1(ar.a aVar, p<? super s0, ? super d<? super l2>, ? extends Object> pVar, d<? super AnonymousClass1> dVar) {
                                super(2, dVar);
                                this.$mutex = aVar;
                                this.$block = pVar;
                            }

                            @Override // xm.a
                            @l
                            public final d<l2> create(@m Object obj, @l d<?> dVar) {
                                return new AnonymousClass1(this.$mutex, this.$block, dVar);
                            }

                            @Override // xm.a
                            @m
                            public final Object invokeSuspend(@l Object obj) throws Throwable {
                                ar.a aVar;
                                p<s0, d<? super l2>, Object> pVar;
                                Throwable th2;
                                ar.a aVar2;
                                a aVar3 = a.COROUTINE_SUSPENDED;
                                int i10 = this.label;
                                try {
                                    if (i10 == 0) {
                                        d1.n(obj);
                                        aVar = this.$mutex;
                                        pVar = this.$block;
                                        this.L$0 = aVar;
                                        this.L$1 = pVar;
                                        this.label = 1;
                                        if (aVar.h(null, this) == aVar3) {
                                            return aVar3;
                                        }
                                    } else {
                                        if (i10 != 1) {
                                            if (i10 != 2) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            aVar2 = (ar.a) this.L$0;
                                            try {
                                                d1.n(obj);
                                                l2 l2Var = l2.f10208a;
                                                aVar2.f(null);
                                                return l2Var;
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                aVar2.f(null);
                                                throw th2;
                                            }
                                        }
                                        pVar = (p) this.L$1;
                                        ar.a aVar4 = (ar.a) this.L$0;
                                        d1.n(obj);
                                        aVar = aVar4;
                                    }
                                    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(pVar, null);
                                    this.L$0 = aVar;
                                    this.L$1 = null;
                                    this.label = 2;
                                    if (t0.g(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == aVar3) {
                                        return aVar3;
                                    }
                                    aVar2 = aVar;
                                    l2 l2Var2 = l2.f10208a;
                                    aVar2.f(null);
                                    return l2Var2;
                                } catch (Throwable th4) {
                                    ar.a aVar5 = aVar;
                                    th2 = th4;
                                    aVar2 = aVar5;
                                    aVar2.f(null);
                                    throw th2;
                                }
                            }

                            @Override // jn.p
                            @m
                            public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
                                return ((AnonymousClass1) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
                            }
                        }

                        /* JADX WARN: Type inference failed for: r7v3, types: [T, nq.l2] */
                        @Override // androidx.lifecycle.LifecycleEventObserver
                        public final void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event) {
                            l0.p(lifecycleOwner, "<anonymous parameter 0>");
                            l0.p(event, NotificationCompat.CATEGORY_EVENT);
                            if (event == eventUpTo) {
                                hVar3.element = k.f(s0Var, null, null, new AnonymousClass1(aVarB, pVar, null), 3, null);
                                return;
                            }
                            if (event == eventDownFrom) {
                                nq.l2 l2Var3 = hVar3.element;
                                if (l2Var3 != null) {
                                    nq.l2.a.b(l2Var3, null, 1, null);
                                }
                                hVar3.element = null;
                            }
                            if (event == Lifecycle.Event.ON_DESTROY) {
                                nq.p<l2> pVar2 = qVar;
                                c1.a aVar2 = c1.Companion;
                                pVar2.resumeWith(c1.m59constructorimpl(l2.f10208a));
                            }
                        }
                    };
                    hVar4.element = r10;
                    l0.n(r10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
                    lifecycle.addObserver((LifecycleEventObserver) r10);
                    Object objZ = qVar.z();
                    if (objZ == aVar) {
                        h.c(this);
                    }
                    if (objZ == aVar) {
                        return aVar;
                    }
                    hVar = hVar3;
                    hVar2 = hVar4;
                    l2Var2 = (nq.l2) hVar.element;
                    if (l2Var2 != null) {
                        nq.l2.a.b(l2Var2, null, 1, null);
                    }
                    lifecycleEventObserver2 = (LifecycleEventObserver) hVar2.element;
                    if (lifecycleEventObserver2 != null) {
                        this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver2);
                    }
                    return l2.f10208a;
                } catch (Throwable th3) {
                    th = th3;
                    hVar = hVar3;
                    hVar2 = hVar4;
                    l2Var = (nq.l2) hVar.element;
                    if (l2Var != null) {
                        nq.l2.a.b(l2Var, null, 1, null);
                    }
                    lifecycleEventObserver = (LifecycleEventObserver) hVar2.element;
                    if (lifecycleEventObserver != null) {
                        this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver);
                    }
                    throw th;
                }
            }

            @Override // jn.p
            @m
            public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
                return ((AnonymousClass1) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, p<? super s0, ? super d<? super l2>, ? extends Object> pVar, d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = pVar;
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                s0 s0Var = (s0) this.L$0;
                x2 x2VarF0 = nq.k1.e().f0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, s0Var, this.$block, null);
                this.label = 1;
                if (k.g(x2VarF0, anonymousClass1, this) == aVar) {
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
            return ((AnonymousClass3) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @m
    public static final Object repeatOnLifecycle(@l Lifecycle lifecycle, @l Lifecycle.State state, @l p<? super s0, ? super d<? super l2>, ? extends Object> pVar, @l d<? super l2> dVar) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return l2.f10208a;
        }
        Object objG = t0.g(new AnonymousClass3(lifecycle, state, pVar, null), dVar);
        return objG == a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    @m
    public static final Object repeatOnLifecycle(@l LifecycleOwner lifecycleOwner, @l Lifecycle.State state, @l p<? super s0, ? super d<? super l2>, ? extends Object> pVar, @l d<? super l2> dVar) {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, dVar);
        return objRepeatOnLifecycle == a.COROUTINE_SUSPENDED ? objRepeatOnLifecycle : l2.f10208a;
    }
}
