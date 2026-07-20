package zd;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f11294b;

    public /* synthetic */ m(n nVar, int i8) {
        this.f11293a = i8;
        this.f11294b = nVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animation) {
        switch (this.f11293a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                n nVar = this.f11294b;
                nVar.f11296a = false;
                nVar.setAnimationStyle(0);
                super/*android.widget.PopupWindow*/.dismiss();
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f11294b.f11302i = false;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        switch (this.f11293a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                n nVar = this.f11294b;
                nVar.f11296a = false;
                nVar.setAnimationStyle(0);
                super/*android.widget.PopupWindow*/.dismiss();
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f11294b.f11302i = false;
                break;
        }
    }
}
