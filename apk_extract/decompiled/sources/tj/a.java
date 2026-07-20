package tj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Binder implements IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f10237b;

    public a(c cVar) {
        this.f10237b = cVar;
        attachInterface(this, "org.appspot.transsion.aiot.aidl.IProximityServiceConnect");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 >= 1 && i8 <= 16777215) {
            parcel.enforceInterface("org.appspot.transsion.aiot.aidl.IProximityServiceConnect");
        }
        if (i8 == 1598968902) {
            parcel2.writeString("org.appspot.transsion.aiot.aidl.IProximityServiceConnect");
            return true;
        }
        if (i8 != 1) {
            return super.onTransact(i8, parcel, parcel2, i9);
        }
        boolean z2 = parcel.readInt() != 0;
        Log.i("AIotSDK", "service Conect");
        this.f10237b.f10244g = z2;
        c.a(this.f10237b, z2);
        parcel2.writeNoException();
        return true;
    }
}
