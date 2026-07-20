package p6;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.transsion.athena.data.TrackData;
import k6.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Binder implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f8700b = 0;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // k6.b
    public final void f(String str, TrackData trackData, long j8) {
        z6.a.b("AthenaTrackService receive appId : %d, eventName : %s", Long.valueOf(j8), str);
        e8.b.n(j8).o(str, trackData, j8);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 != 1) {
            if (i8 != 1598968902) {
                return super.onTransact(i8, parcel, parcel2, i9);
            }
            parcel2.writeString("com.transsion.athena.IAthenaTrackInterface");
            return true;
        }
        parcel.enforceInterface("com.transsion.athena.IAthenaTrackInterface");
        f(parcel.readString(), parcel.readInt() != 0 ? TrackData.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
        parcel2.writeNoException();
        return true;
    }
}
