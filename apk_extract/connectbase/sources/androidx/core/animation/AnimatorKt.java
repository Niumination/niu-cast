package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import dc.d;
import jn.l;
import k4.f;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,136:1\n95#1,14:137\n95#1,14:151\n95#1,14:165\n95#1,14:179\n*S KotlinDebug\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n32#1:137,14\n43#1:151,14\n54#1:165,14\n64#1:179,14\n*E\n"})
public final class AnimatorKt {

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$1, reason: invalid class name */
    @r1({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n*L\n1#1,136:1\n*E\n"})
    public static final class AnonymousClass1 extends n0 implements l<Animator, l2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Animator animator) {
            l0.p(animator, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Animator animator) {
            invoke2(animator);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$2, reason: invalid class name */
    @r1({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n*E\n"})
    public static final class AnonymousClass2 extends n0 implements l<Animator, l2> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Animator animator) {
            l0.p(animator, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Animator animator) {
            invoke2(animator);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$3, reason: invalid class name */
    @r1({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n*L\n1#1,136:1\n*E\n"})
    public static final class AnonymousClass3 extends n0 implements l<Animator, l2> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Animator animator) {
            l0.p(animator, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Animator animator) {
            invoke2(animator);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$4, reason: invalid class name */
    @r1({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n*L\n1#1,136:1\n*E\n"})
    public static final class AnonymousClass4 extends n0 implements l<Animator, l2> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Animator animator) {
            l0.p(animator, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Animator animator) {
            invoke2(animator);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06131 extends n0 implements l<Animator, l2> {
        public static final C06131 INSTANCE = new C06131();

        public C06131() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Animator animator) {
            l0.p(animator, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Animator animator) {
            invoke2(animator);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06142 extends n0 implements l<Animator, l2> {
        public static final C06142 INSTANCE = new C06142();

        public C06142() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Animator animator) {
            l0.p(animator, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Animator animator) {
            invoke2(animator);
            return l2.f10208a;
        }
    }

    @os.l
    public static final Animator.AnimatorListener addListener(@os.l Animator animator, @os.l l<? super Animator, l2> lVar, @os.l l<? super Animator, l2> lVar2, @os.l l<? super Animator, l2> lVar3, @os.l l<? super Animator, l2> lVar4) {
        l0.p(animator, "<this>");
        l0.p(lVar, "onEnd");
        l0.p(lVar2, "onStart");
        l0.p(lVar3, "onCancel");
        l0.p(lVar4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, l lVar, l lVar2, l lVar3, l lVar4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            lVar2 = AnonymousClass2.INSTANCE;
        }
        if ((i10 & 4) != 0) {
            lVar3 = AnonymousClass3.INSTANCE;
        }
        if ((i10 & 8) != 0) {
            lVar4 = AnonymousClass4.INSTANCE;
        }
        l0.p(animator, "<this>");
        l0.p(lVar, "onEnd");
        l0.p(lVar2, "onStart");
        l0.p(lVar3, "onCancel");
        l0.p(lVar4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @os.l
    public static final Animator.AnimatorPauseListener addPauseListener(@os.l Animator animator, @os.l final l<? super Animator, l2> lVar, @os.l final l<? super Animator, l2> lVar2) {
        l0.p(animator, "<this>");
        l0.p(lVar, "onResume");
        l0.p(lVar2, "onPause");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$listener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
                lVar2.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
                lVar.invoke(animator2);
            }
        };
        Api19Impl.addPauseListener(animator, animatorPauseListener);
        return animatorPauseListener;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = C06131.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            lVar2 = C06142.INSTANCE;
        }
        return addPauseListener(animator, lVar, lVar2);
    }

    @os.l
    public static final Animator.AnimatorListener doOnCancel(@os.l Animator animator, @os.l final l<? super Animator, l2> lVar) {
        l0.p(animator, "<this>");
        l0.p(lVar, f.f8937e);
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
                lVar.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @os.l
    public static final Animator.AnimatorListener doOnEnd(@os.l Animator animator, @os.l final l<? super Animator, l2> lVar) {
        l0.p(animator, "<this>");
        l0.p(lVar, f.f8937e);
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
                lVar.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @os.l
    public static final Animator.AnimatorPauseListener doOnPause(@os.l Animator animator, @os.l l<? super Animator, l2> lVar) {
        l0.p(animator, "<this>");
        l0.p(lVar, f.f8937e);
        return addPauseListener$default(animator, null, lVar, 1, null);
    }

    @os.l
    public static final Animator.AnimatorListener doOnRepeat(@os.l Animator animator, @os.l final l<? super Animator, l2> lVar) {
        l0.p(animator, "<this>");
        l0.p(lVar, f.f8937e);
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
                lVar.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @os.l
    public static final Animator.AnimatorPauseListener doOnResume(@os.l Animator animator, @os.l l<? super Animator, l2> lVar) {
        l0.p(animator, "<this>");
        l0.p(lVar, f.f8937e);
        return addPauseListener$default(animator, lVar, null, 2, null);
    }

    @os.l
    public static final Animator.AnimatorListener doOnStart(@os.l Animator animator, @os.l final l<? super Animator, l2> lVar) {
        l0.p(animator, "<this>");
        l0.p(lVar, f.f8937e);
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@os.l Animator animator2) {
                l0.p(animator2, d.f3684o);
                lVar.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
