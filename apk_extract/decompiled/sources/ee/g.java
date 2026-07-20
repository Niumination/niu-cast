package ee;

import android.animation.ValueAnimator;
import com.transsion.widgetslib.widget.seekbar.OSSeekbar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSSeekbar f4875b;

    public /* synthetic */ g(OSSeekbar oSSeekbar, int i8) {
        this.f4874a = i8;
        this.f4875b = oSSeekbar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator animation) {
        float fB;
        float fB2;
        OSSeekbar this$0 = this.f4875b;
        switch (this.f4874a) {
            case 0:
                int i8 = OSSeekbar.D0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                this$0.A = ((Float) animatedValue).floatValue();
                this$0.invalidate();
                break;
            case 1:
                int i9 = OSSeekbar.D0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue2 = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue2).floatValue();
                this$0.B = fFloatValue;
                float f = this$0.D;
                if (f != 0.0f) {
                    float f4 = 1;
                    this$0.C = (((f4 - this$0.H) * fFloatValue) / f) + f4;
                }
                this$0.invalidate();
                break;
            default:
                int i10 = OSSeekbar.D0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue3 = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue2 = ((Float) animatedValue3).floatValue();
                float f10 = this$0.I;
                float fB3 = a1.a.b(this$0.J, f10, fFloatValue2, f10);
                this$0.f3591m = fB3;
                if (this$0.O) {
                    float f11 = this$0.G;
                    fB = a1.a.b(1, f11, fFloatValue2, f11);
                } else {
                    float f12 = this$0.G;
                    fB = f12 - (fFloatValue2 * f12);
                }
                this$0.F = fB;
                this$0.f3581d = this$0.b(fB3);
                if (this$0.O) {
                    float f13 = this$0.N;
                    fB2 = f13 - ((f13 - this$0.e) * fFloatValue2);
                } else {
                    float f14 = this$0.N;
                    fB2 = a1.a.b(this$0.f3588k, f14, fFloatValue2, f14);
                }
                this$0.f3585i = fB2;
                this$0.f3587j = fB2;
                this$0.invalidate();
                break;
        }
    }
}
