package je;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.transsion.widgetsliquid.view.OSLiquidSpringFloatingOvalButton;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements jd.h, jd.f, jd.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSLiquidSpringFloatingOvalButton f6234a;

    public /* synthetic */ p(OSLiquidSpringFloatingOvalButton oSLiquidSpringFloatingOvalButton) {
        this.f6234a = oSLiquidSpringFloatingOvalButton;
    }

    @Override // jd.f
    public void a(boolean z2, DynamicAnimation dynamicAnimation, boolean z3, boolean z5, float f, float f4) {
        OSLiquidSpringFloatingOvalButton._init_$lambda$4(this.f6234a, z2, dynamicAnimation, z3, z5, f, f4);
    }

    @Override // jd.h
    public void b(View view, boolean z2) {
        OSLiquidSpringFloatingOvalButton._init_$lambda$2(this.f6234a, view, z2);
    }

    @Override // jd.g
    public void c(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        OSLiquidSpringFloatingOvalButton._init_$lambda$5(this.f6234a, z2, dynamicAnimation, f, f4);
    }
}
