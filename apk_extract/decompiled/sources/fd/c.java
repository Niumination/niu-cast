package fd;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import ee.f;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AnimatorSet f5021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PathInterpolator f5022b = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);

    static {
        new PathInterpolator(0.25f, 0.0f, 0.0f, 1.0f);
        f5021a = new AnimatorSet();
    }

    public static final void a(WeakReference weakReference, int i8, a aVar) {
        if (((View) weakReference.get()) == null) {
            return;
        }
        View view = (View) weakReference.get();
        if (i8 == 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            if (view != null) {
                view.setAlpha(1.0f);
            }
        } else if (i8 != 2) {
            if (i8 != 3) {
                if (i8 != 4) {
                    if (i8 == 5 && view != null) {
                        view.setScaleY(1.0f);
                    }
                } else if (view != null) {
                    view.setScaleX(1.0f);
                }
            } else if (view != null) {
                view.setTranslationY(0.0f);
            }
        } else if (view != null) {
            view.setTranslationX(0.0f);
        }
        if (aVar != null) {
            aVar.d();
        }
    }

    public static ObjectAnimator b(OSPageView oSPageView) {
        WeakReference weakReference = new WeakReference(oSPageView);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(oSPageView, PropertyValuesHolder.ofFloat("alpha", 0.0f));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(\n…at(\"alpha\", 0f)\n        )");
        objectAnimatorOfPropertyValuesHolder.setDuration(100L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(f5022b);
        objectAnimatorOfPropertyValuesHolder.addListener(new f(weakReference, 1));
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static ObjectAnimator c(OSPageView oSPageView, a aVar) {
        WeakReference weakReference = new WeakReference(oSPageView);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(oSPageView, PropertyValuesHolder.ofFloat("alpha", 1.0f));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(\n…at(\"alpha\", 1f)\n        )");
        objectAnimatorOfPropertyValuesHolder.setDuration(100L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(f5022b);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(0L);
        objectAnimatorOfPropertyValuesHolder.addListener(new b(oSPageView, weakReference, aVar));
        return objectAnimatorOfPropertyValuesHolder;
    }
}
