package ge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.transsion.widgetslib.widget.tablayout.a f5175b;

    public i(com.transsion.widgetslib.widget.tablayout.a aVar, int i8) {
        this.f5175b = aVar;
        this.f5174a = i8;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i8 = this.f5174a;
        com.transsion.widgetslib.widget.tablayout.a aVar = this.f5175b;
        aVar.f3720d = i8;
        aVar.e = 0.0f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f5175b.f3720d = this.f5174a;
    }
}
