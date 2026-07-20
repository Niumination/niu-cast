package nd;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.widgetslib.flipper.FlipperLayout;
import k3.z8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f8177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8179d;

    public /* synthetic */ g(View view, Object obj, Object obj2, int i8) {
        this.f8176a = i8;
        this.f8177b = view;
        this.f8178c = obj;
        this.f8179d = obj2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        switch (this.f8176a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                FlipperLayout flipperLayout = (FlipperLayout) this.f8177b;
                ViewPager2 viewPager2 = flipperLayout.f3052a;
                ViewPager2 viewPager3 = null;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                viewPager2.endFakeDrag();
                ViewPager2 viewPager4 = flipperLayout.f3052a;
                if (viewPager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager4 = null;
                }
                viewPager4.setUserInputEnabled(true);
                ViewPager2 viewPager5 = flipperLayout.f3052a;
                if (viewPager5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager3 = viewPager5;
                }
                l.a(viewPager3, flipperLayout.f3056h + 1, true);
                ValueAnimator valueAnimator = (ValueAnimator) this.f8178c;
                valueAnimator.removeListener(this);
                valueAnimator.removeUpdateListener((c) this.f8179d);
                z8.b("FlipperLayout", "onAnimationEnd, isVisible: " + flipperLayout.f3065s);
                flipperLayout.g();
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                View view = (View) this.f8179d;
                view.setTranslationX(0.0f);
                view.setAlpha(1.0f);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animation) {
        switch (this.f8176a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                FlipperLayout flipperLayout = (FlipperLayout) this.f8177b;
                ViewPager2 viewPager2 = flipperLayout.f3052a;
                ViewPager2 viewPager3 = null;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                viewPager2.beginFakeDrag();
                ViewPager2 viewPager4 = flipperLayout.f3052a;
                if (viewPager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager3 = viewPager4;
                }
                viewPager3.setUserInputEnabled(false);
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                float x2 = ((View) this.f8178c).getX();
                View view = this.f8177b;
                view.setTranslationX(x2 - view.getX());
                break;
        }
    }
}
