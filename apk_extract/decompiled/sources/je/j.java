package je;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.transsion.widgetsliquid.view.OSLiquidSearchBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSLiquidSearchBar f6211b;

    public /* synthetic */ j(OSLiquidSearchBar oSLiquidSearchBar, int i8) {
        this.f6210a = i8;
        this.f6211b = oSLiquidSearchBar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        int i8 = this.f6210a;
        OSLiquidSearchBar oSLiquidSearchBar = this.f6211b;
        switch (i8) {
            case 0:
                OSLiquidSearchBar.scaleButtonMode$lambda$33$lambda$32(oSLiquidSearchBar, dynamicAnimation, z2, f, f4);
                break;
            case 1:
                OSLiquidSearchBar.exitSearchStateCompose$lambda$27$lambda$26(oSLiquidSearchBar, dynamicAnimation, z2, f, f4);
                break;
            case 2:
                OSLiquidSearchBar.goSearchStateForCompose$lambda$22$lambda$21(oSLiquidSearchBar, dynamicAnimation, z2, f, f4);
                break;
            case 3:
                OSLiquidSearchBar.goSearchState$lambda$40$lambda$39(oSLiquidSearchBar, dynamicAnimation, z2, f, f4);
                break;
            default:
                OSLiquidSearchBar.exitSearchState$lambda$45$lambda$44(oSLiquidSearchBar, dynamicAnimation, z2, f, f4);
                break;
        }
    }
}
