package nd;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.transsion.widgetslib.flipper.FlipperLayout;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8175c;

    public /* synthetic */ c(int i8, Object obj, Object obj2) {
        this.f8173a = i8;
        this.f8174b = obj;
        this.f8175c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f8173a) {
            case 0:
                FlipperLayout.b((FlipperLayout) this.f8174b, (Ref.IntRef) this.f8175c, valueAnimator);
                break;
            case 1:
                ((ViewPropertyAnimatorUpdateListener) this.f8174b).onAnimationUpdate((View) this.f8175c);
                break;
            case 2:
                ((AppBarLayout) this.f8174b).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) this.f8175c, valueAnimator);
                break;
            default:
                ((ExpandCollapseAnimationHelper) this.f8174b).lambda$getExpandCollapseAnimator$0((Rect) this.f8175c, valueAnimator);
                break;
        }
    }
}
