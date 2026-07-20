package a4;

import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.transsion.widgetslib.widget.OSMaskImageView;
import com.transsion.widgetslib.widget.seekbar.OSSectionSeekbar;
import j1.d;
import j1.x;
import k3.z8;
import kotlin.jvm.internal.Intrinsics;
import s1.e;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f30a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable.Callback f31b;

    public /* synthetic */ a(Drawable.Callback callback, int i8) {
        this.f30a = i8;
        this.f31b = callback;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator animation) {
        float fB;
        Drawable.Callback callback = this.f31b;
        switch (this.f30a) {
            case 0:
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0((DrawerLayout) callback, animation);
                break;
            case 1:
                int i8 = OSSectionSeekbar.p0;
                OSSectionSeekbar this$0 = (OSSectionSeekbar) callback;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue).floatValue();
                float f = this$0.f3550b0;
                float fB2 = a1.a.b(this$0.c0, f, fFloatValue, f);
                this$0.F = fB2;
                boolean z2 = this$0.f0;
                if (z2) {
                    float f4 = this$0.f3555h0;
                    fB = a1.a.b(1, f4, fFloatValue, f4);
                } else {
                    float f10 = this$0.f3555h0;
                    fB = f10 - (fFloatValue * f10);
                }
                this$0.g0 = fB;
                if (z2) {
                    float f11 = this$0.d0;
                    this$0.f3553e0 = f11 - ((f11 - this$0.f3558j) * fFloatValue);
                } else {
                    float f12 = this$0.d0;
                    this$0.f3553e0 = a1.a.b(this$0.f3557i0, f12, fFloatValue, f12);
                }
                this$0.progressFloat = this$0.c(fB2);
                z8.b(this$0.f3549b, "mCurrentSourceTrackWidth = " + this$0.f3553e0 + " mFromTrackWidth = " + this$0.d0 + " mTrackWidthMax = " + this$0.f3557i0 + " mFromUpEvent = " + this$0.f0 + " curValue = " + fFloatValue);
                this$0.invalidate();
                break;
            case 2:
                x xVar = (x) callback;
                j1.a aVar = xVar.M;
                if (aVar == null) {
                    aVar = d.f5945a;
                }
                if (aVar != j1.a.ENABLED) {
                    e eVar = xVar.f6023r;
                    if (eVar != null) {
                        eVar.q(xVar.f6012b.a());
                    }
                } else {
                    xVar.invalidateSelf();
                }
                break;
            case 3:
                MaterialMainContainerBackHelper.lambda$createCornerAnimator$0((ClippableRoundedCornerLayout) callback, animation);
                break;
            default:
                int i9 = OSMaskImageView.f3396h;
                OSMaskImageView this$1 = (OSMaskImageView) callback;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                Intrinsics.checkNotNullParameter(animation, "animator");
                Object animatedValue2 = animation.getAnimatedValue();
                RectF rectF = null;
                if (!(animatedValue2 instanceof Float)) {
                    animatedValue2 = null;
                }
                if (animatedValue2 != null) {
                    float fFloatValue2 = ((Float) animatedValue2).floatValue();
                    Path path = this$1.f3398b;
                    if (path == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPath");
                        path = null;
                    }
                    path.reset();
                    Path path2 = this$1.f3398b;
                    if (path2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPath");
                        path2 = null;
                    }
                    RectF rectF2 = this$1.f3397a;
                    if (rectF2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRectF");
                        rectF2 = null;
                    }
                    float fCenterX = rectF2.centerX();
                    RectF rectF3 = this$1.f3397a;
                    if (rectF3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRectF");
                    } else {
                        rectF = rectF3;
                    }
                    path2.addCircle(fCenterX, rectF.height(), fFloatValue2, Path.Direction.CCW);
                    this$1.invalidate();
                }
                break;
        }
    }
}
