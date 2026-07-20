package ue;

import android.view.WindowManager;
import android.widget.Toast;
import com.transsion.hubsdk.widget.TranToast;

/* JADX INFO: loaded from: classes2.dex */
public class b implements oh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranToast f16257a = new TranToast();

    @Override // oh.b
    public WindowManager.LayoutParams a(Toast toast) {
        TranToast tranToast = this.f16257a;
        if (tranToast != null) {
            return tranToast.getWindowParams(toast);
        }
        return null;
    }
}
