package tj;

import android.os.IBinder;
import android.os.Parcel;
import org.appspot.transsion.aiot.aidl.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f10250b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10250b;
    }

    public final boolean e(Message message) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.ICellularShareService");
            parcelObtain.writeInt(1);
            message.writeToParcel(parcelObtain, 0);
            this.f10250b.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final boolean g(String str, m mVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.ICellularShareService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongInterface(mVar);
            this.f10250b.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final boolean i() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.ICellularShareService");
            parcelObtain.writeString("CALL_FORWARD");
            this.f10250b.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
