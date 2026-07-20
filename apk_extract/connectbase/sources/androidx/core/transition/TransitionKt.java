package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import b.a;
import jn.l;
import k4.f;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n1#1,86:1\n69#1,16:87\n69#1,16:103\n69#1,16:119\n69#1,16:135\n69#1,16:151\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n31#1:87,16\n39#1:103,16\n47#1:119,16\n55#1:135,16\n63#1:151,16\n*E\n"})
@a({"ClassVerificationFailure"})
public final class TransitionKt {

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$1, reason: invalid class name */
    @r1({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$1\n*L\n1#1,86:1\n*E\n"})
    public static final class AnonymousClass1 extends n0 implements l<Transition, l2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Transition transition) {
            l0.p(transition, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Transition transition) {
            invoke2(transition);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$2, reason: invalid class name */
    @r1({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$2\n*L\n1#1,86:1\n*E\n"})
    public static final class AnonymousClass2 extends n0 implements l<Transition, l2> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Transition transition) {
            l0.p(transition, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Transition transition) {
            invoke2(transition);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$3, reason: invalid class name */
    @r1({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$3\n*L\n1#1,86:1\n*E\n"})
    public static final class AnonymousClass3 extends n0 implements l<Transition, l2> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Transition transition) {
            l0.p(transition, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Transition transition) {
            invoke2(transition);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$4, reason: invalid class name */
    @r1({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$4\n*L\n1#1,86:1\n*E\n"})
    public static final class AnonymousClass4 extends n0 implements l<Transition, l2> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Transition transition) {
            l0.p(transition, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Transition transition) {
            invoke2(transition);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$5, reason: invalid class name */
    @r1({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$5\n*L\n1#1,86:1\n*E\n"})
    public static final class AnonymousClass5 extends n0 implements l<Transition, l2> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Transition transition) {
            l0.p(transition, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Transition transition) {
            invoke2(transition);
            return l2.f10208a;
        }
    }

    @RequiresApi(19)
    @os.l
    public static final Transition.TransitionListener addListener(@os.l Transition transition, @os.l l<? super Transition, l2> lVar, @os.l l<? super Transition, l2> lVar2, @os.l l<? super Transition, l2> lVar3, @os.l l<? super Transition, l2> lVar4, @os.l l<? super Transition, l2> lVar5) {
        l0.p(transition, "<this>");
        l0.p(lVar, "onEnd");
        l0.p(lVar2, "onStart");
        l0.p(lVar3, "onCancel");
        l0.p(lVar4, "onResume");
        l0.p(lVar5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar3, lVar2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            lVar2 = AnonymousClass2.INSTANCE;
        }
        l lVar6 = lVar2;
        if ((i10 & 4) != 0) {
            lVar3 = AnonymousClass3.INSTANCE;
        }
        l lVar7 = lVar3;
        if ((i10 & 8) != 0) {
            lVar4 = AnonymousClass4.INSTANCE;
        }
        if ((i10 & 16) != 0) {
            lVar5 = AnonymousClass5.INSTANCE;
        }
        l0.p(transition, "<this>");
        l0.p(lVar, "onEnd");
        l0.p(lVar6, "onStart");
        l0.p(lVar7, "onCancel");
        l0.p(lVar4, "onResume");
        l0.p(lVar5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar7, lVar6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @os.l
    public static final Transition.TransitionListener doOnCancel(@os.l Transition transition, @os.l final l<? super Transition, l2> lVar) {
        l0.p(transition, "<this>");
        l0.p(lVar, f.f8937e);
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@os.l Transition transition2) {
                l0.p(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @os.l
    public static final Transition.TransitionListener doOnEnd(@os.l Transition transition, @os.l final l<? super Transition, l2> lVar) {
        l0.p(transition, "<this>");
        l0.p(lVar, f.f8937e);
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@os.l Transition transition2) {
                l0.p(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @os.l
    public static final Transition.TransitionListener doOnPause(@os.l Transition transition, @os.l final l<? super Transition, l2> lVar) {
        l0.p(transition, "<this>");
        l0.p(lVar, f.f8937e);
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@os.l Transition transition2) {
                l0.p(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @os.l
    public static final Transition.TransitionListener doOnResume(@os.l Transition transition, @os.l final l<? super Transition, l2> lVar) {
        l0.p(transition, "<this>");
        l0.p(lVar, f.f8937e);
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@os.l Transition transition2) {
                l0.p(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @os.l
    public static final Transition.TransitionListener doOnStart(@os.l Transition transition, @os.l final l<? super Transition, l2> lVar) {
        l0.p(transition, "<this>");
        l0.p(lVar, f.f8937e);
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@os.l Transition transition2) {
                l0.p(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@os.l Transition transition2) {
                l0.p(transition2, "transition");
                lVar.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
