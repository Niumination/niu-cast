package rd;

import android.animation.ValueAnimator;
import com.transsion.widgetslib.view.damping.DampingLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DampingLayout f9399b;

    public /* synthetic */ c(DampingLayout dampingLayout, int i8) {
        this.f9398a = i8;
        this.f9399b = dampingLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f9398a) {
            case 0:
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Float) {
                    float fFloatValue = ((Float) animatedValue).floatValue();
                    DampingLayout dampingLayout = this.f9399b;
                    dampingLayout.mLayoutContent.setTranslationY(fFloatValue);
                    dampingLayout.refreshTitleLayout(fFloatValue);
                }
                break;
            case 1:
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                if (animatedValue2 instanceof Float) {
                    float fFloatValue2 = ((Float) animatedValue2).floatValue();
                    DampingLayout dampingLayout2 = this.f9399b;
                    dampingLayout2.mLayoutContent.setTranslationY(fFloatValue2);
                    dampingLayout2.refreshTitleLayout(fFloatValue2);
                }
                break;
            default:
                DampingLayout dampingLayout3 = this.f9399b;
                if (dampingLayout3.mViewScrollBar != null) {
                    Object animatedValue3 = valueAnimator.getAnimatedValue();
                    if (animatedValue3 instanceof Float) {
                        dampingLayout3.mViewScrollBar.setAlpha(((Float) animatedValue3).floatValue());
                    }
                    break;
                }
                break;
        }
    }
}
