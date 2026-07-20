package re;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.api.view.TranBrightnessInfo;
import com.transsion.hubsdk.view.ITranDisplay;

/* JADX INFO: loaded from: classes2.dex */
public class b implements lh.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14464b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranDisplay f14465a = ITranDisplay.Stub.asInterface(TranServiceManager.getServiceIBinder("tran_display"));

    @Override // lh.a
    public TranBrightnessInfo a() {
        com.transsion.hubsdk.view.TranBrightnessInfo tranBrightnessInfo = (com.transsion.hubsdk.view.TranBrightnessInfo) new zb.f().c(new zb.f.b() { // from class: re.a
            @Override // zb.f.b
            public final Object run() {
                return this.f14463a.c();
            }
        }, "tran_display");
        dc.e.f(f14464b, "getBrightnessInfo mTranBrightnessInfo:" + tranBrightnessInfo);
        if (tranBrightnessInfo == null) {
            return null;
        }
        TranBrightnessInfo tranBrightnessInfo2 = new TranBrightnessInfo();
        tranBrightnessInfo2.f2260a = tranBrightnessInfo.brightness;
        tranBrightnessInfo2.f2261b = tranBrightnessInfo.adjustedBrightness;
        tranBrightnessInfo2.f2262c = tranBrightnessInfo.brightnessMinimum;
        tranBrightnessInfo2.f2263d = tranBrightnessInfo.brightnessMaximum;
        tranBrightnessInfo2.f2264e = tranBrightnessInfo.highBrightnessTransitionPoint;
        tranBrightnessInfo2.f2265f = tranBrightnessInfo.highBrightnessMode;
        tranBrightnessInfo2.f2266g = tranBrightnessInfo.brightnessMaxReason;
        return tranBrightnessInfo2;
    }

    public final /* synthetic */ Object c() throws RemoteException {
        ITranDisplay iTranDisplay = this.f14465a;
        if (iTranDisplay != null) {
            return iTranDisplay.getBrightnessInfo();
        }
        return null;
    }

    @VisibleForTesting
    public void d(ITranDisplay iTranDisplay) {
        this.f14465a = iTranDisplay;
    }
}
