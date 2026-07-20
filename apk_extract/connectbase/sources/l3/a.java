package l3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.transsion.athena.data.TrackData;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: l3.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0253a extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f9683c = 0;

        /* JADX INFO: renamed from: l3.a$a$a, reason: collision with other inner class name */
        public static class C0254a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f9684c;

            public C0254a(IBinder iBinder) {
                this.f9684c = iBinder;
            }

            @Override // l3.a
            public void N(String str, TrackData trackData, long j10) throws RemoteException {
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
                    parcelObtain.writeLong(j10);
                    if (!this.f9684c.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i10 = AbstractBinderC0253a.f9683c;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9684c;
            }
        }

        public AbstractBinderC0253a() {
            attachInterface(this, "com.transsion.athena.IAthenaTrackInterface");
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.transsion.athena.IAthenaTrackInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0254a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.transsion.athena.IAthenaTrackInterface");
                return true;
            }
            parcel.enforceInterface("com.transsion.athena.IAthenaTrackInterface");
            N(parcel.readString(), parcel.readInt() != 0 ? TrackData.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
            parcel2.writeNoException();
            return true;
        }
    }

    void N(String str, TrackData trackData, long j10) throws RemoteException;
}
