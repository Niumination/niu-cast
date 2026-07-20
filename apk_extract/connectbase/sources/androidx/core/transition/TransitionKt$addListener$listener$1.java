package androidx.core.transition;

import android.transition.Transition;
import jn.l;
import kn.l0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n*L\n1#1,86:1\n*E\n"})
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ l<Transition, l2> $onCancel;
    final /* synthetic */ l<Transition, l2> $onEnd;
    final /* synthetic */ l<Transition, l2> $onPause;
    final /* synthetic */ l<Transition, l2> $onResume;
    final /* synthetic */ l<Transition, l2> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(l<? super Transition, l2> lVar, l<? super Transition, l2> lVar2, l<? super Transition, l2> lVar3, l<? super Transition, l2> lVar4, l<? super Transition, l2> lVar5) {
        this.$onEnd = lVar;
        this.$onResume = lVar2;
        this.$onPause = lVar3;
        this.$onCancel = lVar4;
        this.$onStart = lVar5;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(@os.l Transition transition) {
        l0.p(transition, "transition");
        this.$onCancel.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(@os.l Transition transition) {
        l0.p(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(@os.l Transition transition) {
        l0.p(transition, "transition");
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(@os.l Transition transition) {
        l0.p(transition, "transition");
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(@os.l Transition transition) {
        l0.p(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
