package zd;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f11313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f11314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference f11315d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f11312a) {
            case 0:
                super.onAnimationEnd(animator);
                WeakReference weakReference = this.f11313b;
                if (weakReference != null && weakReference.get() != null) {
                    ((View) weakReference.get()).setClickable(true);
                }
                WeakReference weakReference2 = this.f11314c;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((View) weakReference2.get()).setVisibility(8);
                }
                WeakReference weakReference3 = this.f11315d;
                if (weakReference3 != null && weakReference3.get() != null) {
                    ((View) weakReference3.get()).setVisibility(0);
                }
                if (weakReference != null && weakReference.get() != null) {
                    ((View) weakReference.get()).setAlpha(1.0f);
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                WeakReference weakReference4 = this.f11313b;
                if (weakReference4 != null && weakReference4.get() != null) {
                    ((View) weakReference4.get()).setVisibility(0);
                }
                WeakReference weakReference5 = this.f11314c;
                if (weakReference5 != null && weakReference5.get() != null) {
                    ((View) weakReference5.get()).setVisibility(0);
                }
                WeakReference weakReference6 = this.f11315d;
                if (weakReference6 != null && weakReference6.get() != null) {
                    ((View) weakReference6.get()).setVisibility(8);
                    ((View) weakReference6.get()).setEnabled(true);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f11312a) {
            case 0:
                super.onAnimationStart(animator);
                WeakReference weakReference = this.f11313b;
                if (weakReference != null && weakReference.get() != null) {
                    ((View) weakReference.get()).setAlpha(0.0f);
                    ((View) weakReference.get()).setVisibility(0);
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
