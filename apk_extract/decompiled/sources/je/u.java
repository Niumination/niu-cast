package je;

import com.transsion.widgetsliquid.view.OSLiquidToolBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSLiquidToolBar f6248b;

    public /* synthetic */ u(OSLiquidToolBar oSLiquidToolBar, int i8) {
        this.f6247a = i8;
        this.f6248b = oSLiquidToolBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f6247a;
        OSLiquidToolBar oSLiquidToolBar = this.f6248b;
        switch (i8) {
            case 0:
                OSLiquidToolBar.hideOriginalMenuView$lambda$5(oSLiquidToolBar);
                break;
            default:
                OSLiquidToolBar.setRightTextIcon$lambda$13(oSLiquidToolBar);
                break;
        }
    }
}
