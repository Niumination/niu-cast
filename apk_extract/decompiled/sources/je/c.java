package je;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.transsion.widgetsliquid.view.OSLiquidFootOperationBar;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f6190b;

    public /* synthetic */ c(int i8, View view) {
        this.f6189a = i8;
        this.f6190b = view;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        int i8 = this.f6189a;
        View view = this.f6190b;
        switch (i8) {
            case 0:
                OSLiquidFootOperationBar.stopPressAnimation$lambda$31$lambda$30(view, dynamicAnimation, f, f4);
                break;
            case 1:
                OSLiquidFootOperationBar.startPressAnimation$lambda$28$lambda$27(view, dynamicAnimation, f, f4);
                break;
            case 2:
                OSLiquidToolBar.stopPressAnimation$lambda$25$lambda$24(view, dynamicAnimation, f, f4);
                break;
            case 3:
                OSLiquidToolBar.startPressAnimation$lambda$22$lambda$21(view, dynamicAnimation, f, f4);
                break;
            case 4:
                OSLiquidWidgetToolBar.startPressAnimation$lambda$22$lambda$21(view, dynamicAnimation, f, f4);
                break;
            default:
                OSLiquidWidgetToolBar.stopPressAnimation$lambda$25$lambda$24(view, dynamicAnimation, f, f4);
                break;
        }
    }
}
