package k9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: k9.a$a, reason: collision with other inner class name */
    public static class C0237a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // k9.a
        public void i(String str, String str2) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f9157c = "com.transsion.hubsdk.api.appm.ITranAppmCallbackWrapper";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f9158d = 1;

        /* JADX INFO: renamed from: k9.a$b$a, reason: collision with other inner class name */
        public static class C0238a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f9159d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f9160c;

            public C0238a(IBinder iBinder) {
                this.f9160c = iBinder;
            }

            public String O() {
                return b.f9157c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9160c;
            }

            @Override // k9.a
            public void i(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f9157c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.f9160c.transact(1, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f9159d.i(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f9157c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f9157c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0238a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0238a.f9159d;
        }

        public static boolean Q(a aVar) {
            if (C0238a.f9159d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0238a.f9159d = aVar;
            return true;
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
                parcel2.writeString(f9157c);
                return true;
            }
            parcel.enforceInterface(f9157c);
            i(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void i(String str, String str2) throws RemoteException;
}
