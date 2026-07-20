package je;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.transsion.widgetsliquid.view.OSLiquidFobItemContainer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSLiquidFobItemContainer f6188b;

    public /* synthetic */ b(OSLiquidFobItemContainer oSLiquidFobItemContainer, int i8) {
        this.f6187a = i8;
        this.f6188b = oSLiquidFobItemContainer;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        int i8 = this.f6187a;
        OSLiquidFobItemContainer oSLiquidFobItemContainer = this.f6188b;
        switch (i8) {
            case 0:
                OSLiquidFobItemContainer.animateToFinalPositionInternal$lambda$6$lambda$5(oSLiquidFobItemContainer, dynamicAnimation, f, f4);
                break;
            default:
                OSLiquidFobItemContainer.animateBackgroundToTarget$lambda$3$lambda$2(oSLiquidFobItemContainer, dynamicAnimation, f, f4);
                break;
        }
    }
}
