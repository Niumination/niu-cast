package vd;

import android.animation.ValueAnimator;
import com.transsion.widgetslib.view.letter.LetterSelectorLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LetterSelectorLayout f10548b;

    public /* synthetic */ a(LetterSelectorLayout letterSelectorLayout, int i8) {
        this.f10547a = i8;
        this.f10548b = letterSelectorLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f10547a) {
            case 0:
                int iFloatValue = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() / 200.0f) * 255.0f);
                LetterSelectorLayout letterSelectorLayout = this.f10548b;
                letterSelectorLayout.f3302h = iFloatValue;
                letterSelectorLayout.invalidate();
                break;
            case 1:
                ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LetterSelectorLayout letterSelectorLayout2 = this.f10548b;
                letterSelectorLayout2.getClass();
                letterSelectorLayout2.invalidate();
                break;
            default:
                this.f10548b.f3302h = (int) (255.0f - ((((Float) valueAnimator.getAnimatedValue()).floatValue() / 100.0f) * 255.0f));
                break;
        }
    }
}
