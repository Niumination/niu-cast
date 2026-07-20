package yc;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.transsion.pcconnect.invoke.bridge.Device;
import com.transsion.pcconnect.invoke.bridge.IntegratedActionService;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Binder implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f11117b = 0;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // yc.c
    public final void h(Device device, String action, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(action, "action");
        StringBuilder sbP = h0.a.p("Received AIDL call: device=", device.f2948b, ", action=", action, ", enable=");
        sbP.append(z2);
        sbP.append(", params=");
        sbP.append(str);
        Log.d("IntegratedActionService", sbP.toString());
        IntegratedActionService.f2951b.getClass();
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(action, "action");
        o.d.B("Handling received message: action=", action, "ActionCommunicator");
        f.b(device, action, z2);
        Iterator it = f.f.iterator();
        while (it.hasNext()) {
            try {
                ((cb.a) it.next()).getClass();
                cb.a.a(device, action, z2, str);
            } catch (Exception e) {
                Log.e("ActionCommunicator", "Failed to notify listener", e);
            }
        }
        Log.d("IntegratedActionService", "Process message through communication manager");
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 >= 1 && i8 <= 16777215) {
            parcel.enforceInterface("com.transsion.pcconnect.invoke.bridge.IActionService");
        }
        if (i8 == 1598968902) {
            parcel2.writeString("com.transsion.pcconnect.invoke.bridge.IActionService");
            return true;
        }
        if (i8 != 1) {
            return super.onTransact(i8, parcel, parcel2, i9);
        }
        h((Device) (parcel.readInt() != 0 ? Device.CREATOR.createFromParcel(parcel) : null), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
