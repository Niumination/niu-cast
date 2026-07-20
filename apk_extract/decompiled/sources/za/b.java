package za;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableLiveData f11268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData f11269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData f11270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData f11271d;
    public static final MutableLiveData e;
    public static final MutableLiveData f;

    static {
        MutableLiveData mutableLiveData = new MutableLiveData();
        f11268a = mutableLiveData;
        f11269b = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        f11270c = mutableLiveData2;
        f11271d = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        e = mutableLiveData3;
        f = mutableLiveData3;
    }

    public static void a(boolean z2) {
        lb.a.e("airCopy", z2);
        MutableLiveData mutableLiveData = f11270c;
        if (!Intrinsics.areEqual(mutableLiveData.getValue(), Boolean.valueOf(z2))) {
            mutableLiveData.setValue(Boolean.valueOf(z2));
        }
        String strO = d.o("<saveAirCopySwitchState>:switchOn ", z2, "GlobalSettingManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GlobalSettingManager"), strO);
        }
    }

    public static void b(boolean z2) {
        lb.a.e("airTransfer", z2);
        e.setValue(Boolean.valueOf(z2));
        String log = "<saveAirTransferSwitchState>:switchOn " + z2;
        Intrinsics.checkNotNullParameter("GlobalSettingManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GlobalSettingManager"), log);
        }
    }

    public static void c(boolean z2) {
        lb.a.e("mirrorGesture", z2);
        f11268a.setValue(Boolean.valueOf(z2));
        String log = "<saveMirrorGestureSwitchState> :switchOn " + z2;
        Intrinsics.checkNotNullParameter("GlobalSettingManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GlobalSettingManager"), log);
        }
    }
}
