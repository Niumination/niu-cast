package je;

import com.transsion.widgetsliquid.view.OSLiquidFootOperationBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSLiquidFootOperationBar f6197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Boolean f6199d;

    public /* synthetic */ f(OSLiquidFootOperationBar oSLiquidFootOperationBar, int i8, Boolean bool, int i9) {
        this.f6196a = i9;
        this.f6197b = oSLiquidFootOperationBar;
        this.f6198c = i8;
        this.f6199d = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6196a) {
            case 0:
                OSLiquidFootOperationBar.selectTab$lambda$16(this.f6197b, this.f6198c, this.f6199d);
                break;
            default:
                OSLiquidFootOperationBar.selectTabWithoutNotify$lambda$17(this.f6197b, this.f6198c, this.f6199d);
                break;
        }
    }
}
