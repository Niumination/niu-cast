package re;

import android.view.Display;
import com.transsion.hubsdk.view.TranDisplayAddress;

/* JADX INFO: loaded from: classes2.dex */
public class c implements lh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranDisplayAddress f14466a = new TranDisplayAddress();

    @Override // lh.b
    public long a(Display display) {
        TranDisplayAddress tranDisplayAddress = this.f14466a;
        if (tranDisplayAddress != null) {
            return tranDisplayAddress.getPhysicalDisplayId(display);
        }
        return 0L;
    }
}
