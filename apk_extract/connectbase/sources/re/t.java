package re;

import android.os.IBinder;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.view.TranWindowManagerGlobal;

/* JADX INFO: loaded from: classes2.dex */
public class t implements lh.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14492b = "t";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranWindowManagerGlobal f14493a = new TranWindowManagerGlobal();

    @Override // lh.q
    public void a(IBinder iBinder, String str, String str2) {
        TranWindowManagerGlobal tranWindowManagerGlobal = this.f14493a;
        if (tranWindowManagerGlobal != null) {
            try {
                tranWindowManagerGlobal.closeAll(iBinder, str, str2);
            } catch (RuntimeException e10) {
                dc.e.c(f14492b, "captureDisplayAsBitmap: e = " + e10);
            }
        }
    }

    @VisibleForTesting
    public void b(TranWindowManagerGlobal tranWindowManagerGlobal) {
        this.f14493a = tranWindowManagerGlobal;
    }
}
