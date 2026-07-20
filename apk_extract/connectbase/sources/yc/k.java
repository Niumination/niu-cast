package yc;

import android.view.Display;
import com.transsion.hubsdk.hardware.display.TranDisplayManagerGlobal;

/* JADX INFO: loaded from: classes2.dex */
public class k implements rf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranDisplayManagerGlobal f20818a = new TranDisplayManagerGlobal();

    @Override // rf.c
    public Display a(int i10) {
        TranDisplayManagerGlobal tranDisplayManagerGlobal = this.f20818a;
        if (tranDisplayManagerGlobal != null) {
            return tranDisplayManagerGlobal.getRealDisplay(i10);
        }
        return null;
    }
}
