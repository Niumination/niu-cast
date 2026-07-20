package tj;

import android.os.IBinder;
import android.os.Parcel;
import com.transsion.iotcardsdk.TCHelper$initCard$1$3;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f10253b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10253b;
    }

    public final void e(String str, String str2, TCHelper$initCard$1$3 tCHelper$initCard$1$3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.IMulCooperateCommonInterface");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeStrongInterface(tCHelper$initCard$1$3);
            this.f10253b.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
