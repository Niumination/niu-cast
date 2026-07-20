package je;

import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSLiquidWidgetToolBar f6253b;

    public /* synthetic */ w(OSLiquidWidgetToolBar oSLiquidWidgetToolBar, int i8) {
        this.f6252a = i8;
        this.f6253b = oSLiquidWidgetToolBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f6252a;
        OSLiquidWidgetToolBar oSLiquidWidgetToolBar = this.f6253b;
        switch (i8) {
            case 0:
                OSLiquidWidgetToolBar.setRightTextIcon$lambda$13(oSLiquidWidgetToolBar);
                break;
            default:
                OSLiquidWidgetToolBar.hideOriginalMenuView$lambda$5(oSLiquidWidgetToolBar);
                break;
        }
    }
}
