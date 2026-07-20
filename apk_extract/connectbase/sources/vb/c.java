package vb;

import android.os.Parcel;
import android.view.SurfaceControl;
import android.window.TransitionInfo;
import com.transsion.hubsdk.window.TranTransitionInfo;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16883b = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranTransitionInfo f16884a;

    public SurfaceControl a(TransitionInfo.Change change) {
        if (change == null) {
            throw new IllegalArgumentException("name or parent should not be null");
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            change.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return b().getChangeLeash(parcelObtain);
        } catch (Exception e10) {
            e.d(f16883b, "getChangeLeash error", e10);
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public TranTransitionInfo b() {
        if (this.f16884a == null) {
            this.f16884a = new TranTransitionInfo();
        }
        return this.f16884a;
    }
}
