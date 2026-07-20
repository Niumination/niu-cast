package yc;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.display.ITranColorDisplayManager;
import com.transsion.hubsdk.hardware.display.TranColorDisplayBridge;

/* JADX INFO: loaded from: classes2.dex */
public class a implements rf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20778b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranColorDisplayManager f20779a = ITranColorDisplayManager.Stub.asInterface(TranServiceManager.getServiceIBinder("color_display"));

    @Override // rf.a
    public void a(String str, int i10, boolean z10, int i11, int i12, Bundle bundle) {
        ITranColorDisplayManager iTranColorDisplayManager = this.f20779a;
        if (iTranColorDisplayManager == null) {
            return;
        }
        try {
            iTranColorDisplayManager.setEyeCareEnabled(str, i10, z10, i11, i12, bundle);
        } catch (RemoteException e10) {
            j7.b.a("setEyeCareEnabled:", e10, f20778b);
        }
    }

    @Override // rf.a
    public int b(Context context) {
        return TranColorDisplayBridge.getMaximumColorTemperature(context);
    }

    @Override // rf.a
    public boolean c(Context context) {
        return TranColorDisplayBridge.isNightDisplayAvailable(context);
    }

    @Override // rf.a
    public boolean d(boolean z10) {
        ITranColorDisplayManager iTranColorDisplayManager = this.f20779a;
        if (iTranColorDisplayManager == null) {
            return false;
        }
        try {
            return iTranColorDisplayManager.setNightDisplayActivated(z10);
        } catch (RemoteException e10) {
            j7.b.a("setNightDisplayActivated:", e10, f20778b);
            return false;
        }
    }

    @Override // rf.a
    public boolean e() {
        ITranColorDisplayManager iTranColorDisplayManager = this.f20779a;
        if (iTranColorDisplayManager == null) {
            return false;
        }
        try {
            return iTranColorDisplayManager.isNightDisplayActivated();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // rf.a
    public int f(Context context) {
        return TranColorDisplayBridge.getMinimumColorTemperature(context);
    }

    @Override // rf.a
    public int g() {
        ITranColorDisplayManager iTranColorDisplayManager = this.f20779a;
        if (iTranColorDisplayManager == null) {
            return 0;
        }
        try {
            return iTranColorDisplayManager.getNightDisplayColorTemperature();
        } catch (RemoteException e10) {
            j7.b.a("getNightDisplayColorTemperature:", e10, f20778b);
            return 0;
        }
    }

    @Override // rf.a
    public boolean h(int i10) {
        ITranColorDisplayManager iTranColorDisplayManager = this.f20779a;
        if (iTranColorDisplayManager == null) {
            return false;
        }
        try {
            return iTranColorDisplayManager.setNightDisplayColorTemperature(i10);
        } catch (RemoteException e10) {
            j7.b.a("setNightDisplayColorTemperature:", e10, f20778b);
            return false;
        }
    }

    @VisibleForTesting
    public void i(ITranColorDisplayManager iTranColorDisplayManager) {
        this.f20779a = iTranColorDisplayManager;
    }
}
