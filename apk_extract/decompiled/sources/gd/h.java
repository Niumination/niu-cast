package gd;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5144b;

    public /* synthetic */ h(ViewGroup viewGroup, int i8) {
        this.f5143a = i8;
        this.f5144b = viewGroup;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        ViewGroup viewGroup = this.f5144b;
        switch (this.f5143a) {
            case 0:
                PathInterpolator pathInterpolator = OSBottomSheetPanel.K;
                OSBottomSheetPanel this$0 = (OSBottomSheetPanel) viewGroup;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                View view = this$0.f3001j;
                if (view != null) {
                    view.setAlpha(this$0.b(f));
                    break;
                }
                break;
            default:
                OSLiquidSearchBar.scaleButtonMode$lambda$33$lambda$31((OSLiquidSearchBar) viewGroup, dynamicAnimation, f, f4);
                break;
        }
    }
}
