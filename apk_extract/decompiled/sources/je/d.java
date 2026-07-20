package je;

import com.transsion.widgetsliquid.view.OSLiquidFootOperationBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSLiquidFootOperationBar f6192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f6193c;

    public /* synthetic */ d(OSLiquidFootOperationBar oSLiquidFootOperationBar, boolean z2, int i8) {
        this.f6191a = i8;
        this.f6192b = oSLiquidFootOperationBar;
        this.f6193c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6191a) {
            case 0:
                OSLiquidFootOperationBar.enterSearchMode$lambda$35(this.f6192b, this.f6193c);
                break;
            default:
                OSLiquidFootOperationBar.exitSearchMode$lambda$36(this.f6192b, this.f6193c);
                break;
        }
    }
}
