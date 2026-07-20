package rc;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f9392b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9392b;
    }

    public final IBinder e(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.kolun.IKolunCore");
            parcelObtain.writeString(str);
            parcelObtain.writeString("BleScanAssistor");
            if (!this.f9392b.transact(3, parcelObtain, parcelObtain2, 0)) {
                int i8 = b.f9393b;
            }
            parcelObtain2.readException();
            return parcelObtain2.readStrongBinder();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
