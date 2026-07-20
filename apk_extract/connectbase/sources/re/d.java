package re;

import android.view.DisplayCutout;
import com.transsion.hubsdk.view.TranDisplayCutout;

/* JADX INFO: loaded from: classes2.dex */
public class d implements lh.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranDisplayCutout f14467a = new TranDisplayCutout();

    @Override // lh.c
    public boolean a(DisplayCutout displayCutout) {
        TranDisplayCutout tranDisplayCutout = this.f14467a;
        if (tranDisplayCutout != null) {
            return tranDisplayCutout.isBoundsEmpty(displayCutout);
        }
        return false;
    }
}
