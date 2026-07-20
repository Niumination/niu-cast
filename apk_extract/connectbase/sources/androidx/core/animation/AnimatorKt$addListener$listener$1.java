package androidx.core.animation;

import android.animation.Animator;
import dc.d;
import jn.l;
import kn.l0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n*L\n1#1,136:1\n*E\n"})
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ l<Animator, l2> $onCancel;
    final /* synthetic */ l<Animator, l2> $onEnd;
    final /* synthetic */ l<Animator, l2> $onRepeat;
    final /* synthetic */ l<Animator, l2> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(l<? super Animator, l2> lVar, l<? super Animator, l2> lVar2, l<? super Animator, l2> lVar3, l<? super Animator, l2> lVar4) {
        this.$onRepeat = lVar;
        this.$onEnd = lVar2;
        this.$onCancel = lVar3;
        this.$onStart = lVar4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@os.l Animator animator) {
        l0.p(animator, d.f3684o);
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@os.l Animator animator) {
        l0.p(animator, d.f3684o);
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@os.l Animator animator) {
        l0.p(animator, d.f3684o);
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@os.l Animator animator) {
        l0.p(animator, d.f3684o);
        this.$onStart.invoke(animator);
    }
}
