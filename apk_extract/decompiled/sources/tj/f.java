package tj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends Binder implements g {
    public static g asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("org.appspot.transsion.aiot.aidl.IAppListener");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof g)) {
            return (g) iInterfaceQueryLocalInterface;
        }
        e eVar = new e();
        eVar.f10249b = iBinder;
        return eVar;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        if (i8 != 1598968902) {
            return super.onTransact(i8, parcel, parcel2, i9);
        }
        parcel2.writeString("org.appspot.transsion.aiot.aidl.IAppListener");
        return true;
    }
}
