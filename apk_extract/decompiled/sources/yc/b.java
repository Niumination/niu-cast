package yc;

import android.os.IBinder;
import android.os.Parcel;
import com.transsion.pcconnect.invoke.bridge.Device;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f11116b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f11116b;
    }

    @Override // yc.c
    public final void h(Device device, String str, boolean z2, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.pcconnect.invoke.bridge.IActionService");
            if (device != null) {
                parcelObtain.writeInt(1);
                device.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeString(str);
            parcelObtain.writeInt(z2 ? 1 : 0);
            parcelObtain.writeString(str2);
            this.f11116b.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
