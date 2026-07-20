package je;

import com.transsion.widgetsliquid.view.OSLiquidFootOperationBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSLiquidFootOperationBar f6195b;

    public /* synthetic */ e(OSLiquidFootOperationBar oSLiquidFootOperationBar, int i8) {
        this.f6194a = i8;
        this.f6195b = oSLiquidFootOperationBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f6194a;
        OSLiquidFootOperationBar oSLiquidFootOperationBar = this.f6195b;
        switch (i8) {
            case 0:
                OSLiquidFootOperationBar.updateTab$lambda$32(oSLiquidFootOperationBar);
                break;
            case 1:
                OSLiquidFootOperationBar.onVisibilityAggregated$lambda$34(oSLiquidFootOperationBar);
                break;
            case 2:
                OSLiquidFootOperationBar.addAllTabs$lambda$6(oSLiquidFootOperationBar);
                break;
            case 3:
                OSLiquidFootOperationBar.removeTab$lambda$33(oSLiquidFootOperationBar);
                break;
            default:
                OSLiquidFootOperationBar.addTab$lambda$7(oSLiquidFootOperationBar);
                break;
        }
    }
}
