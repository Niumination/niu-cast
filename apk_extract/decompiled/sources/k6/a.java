package k6;

import android.os.IBinder;
import android.os.Parcel;
import com.transsion.athena.data.TrackData;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f6779b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f6779b;
    }

    @Override // k6.b
    public final void f(String str, TrackData trackData, long j8) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.athena.IAthenaTrackInterface");
            parcelObtain.writeString(str);
            if (trackData != null) {
                parcelObtain.writeInt(1);
                trackData.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeLong(j8);
            if (!this.f6779b.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i8 = p6.a.f8700b;
            }
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
