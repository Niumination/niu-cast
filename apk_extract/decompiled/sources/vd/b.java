package vd;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.transsion.widgetslib.view.letter.LetterSelectorLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LetterSelectorLayout f10550b;

    public /* synthetic */ b(LetterSelectorLayout letterSelectorLayout, int i8) {
        this.f10549a = i8;
        this.f10550b = letterSelectorLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f10549a) {
            case 0:
                LetterSelectorLayout letterSelectorLayout = this.f10550b;
                letterSelectorLayout.f3304j = true;
                letterSelectorLayout.f3303i = false;
                break;
            default:
                this.f10550b.f3303i = false;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        switch (this.f10549a) {
            case 0:
                LetterSelectorLayout letterSelectorLayout = this.f10550b;
                if (!letterSelectorLayout.f3304j && letterSelectorLayout.f3303i && (valueAnimator = letterSelectorLayout.f3297b) != null && !valueAnimator.isRunning() && (valueAnimator2 = letterSelectorLayout.f3299c) != null && !valueAnimator2.isRunning()) {
                    letterSelectorLayout.a();
                    if (letterSelectorLayout.getHandler() != null && letterSelectorLayout.f3303i) {
                        letterSelectorLayout.getHandler().postDelayed(letterSelectorLayout.f3300d, letterSelectorLayout.f3296a0);
                        break;
                    }
                }
                break;
            default:
                LetterSelectorLayout letterSelectorLayout2 = this.f10550b;
                letterSelectorLayout2.f3303i = false;
                letterSelectorLayout2.invalidate();
                break;
        }
    }
}
