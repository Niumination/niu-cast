package tj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import org.appspot.transsion.aiot.aidl.Message;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends Binder implements m {
    static final int TRANSACTION_onConnectionLost = 2;
    static final int TRANSACTION_onMessageReceived = 1;

    public l() {
        attachInterface(this, "org.appspot.transsion.aiot.aidl.IMessageCallback");
    }

    public static m asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("org.appspot.transsion.aiot.aidl.IMessageCallback");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof m)) {
            return (m) iInterfaceQueryLocalInterface;
        }
        k kVar = new k();
        kVar.f10252b = iBinder;
        return kVar;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        if (i8 >= 1 && i8 <= 16777215) {
            parcel.enforceInterface("org.appspot.transsion.aiot.aidl.IMessageCallback");
        }
        if (i8 == 1598968902) {
            parcel2.writeString("org.appspot.transsion.aiot.aidl.IMessageCallback");
            return true;
        }
        if (i8 == 1) {
            onMessageReceived(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
        } else {
            if (i8 != 2) {
                return super.onTransact(i8, parcel, parcel2, i9);
            }
            onConnectionLost(parcel.readString());
            parcel2.writeNoException();
        }
        return true;
    }
}
