package k3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: k3.a$a, reason: collision with other inner class name */
    public static class C0234a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // k3.a
        public void i(String str, String str2) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f8915c = "com.transsion.appm.ITranAppmCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f8916d = 1;

        /* JADX INFO: renamed from: k3.a$b$a, reason: collision with other inner class name */
        public static class C0235a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f8917d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f8918c;

            public C0235a(IBinder iBinder) {
                this.f8918c = iBinder;
            }

            public String O() {
                return b.f8915c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8918c;
            }

            @Override // k3.a
            public void i(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f8915c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.f8918c.transact(1, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f8917d.i(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f8915c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f8915c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0235a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0235a.f8917d;
        }

        public static boolean Q(a aVar) {
            if (C0235a.f8917d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0235a.f8917d = aVar;
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
                parcel2.writeString(f8915c);
                return true;
            }
            parcel.enforceInterface(f8915c);
            i(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void i(String str, String str2) throws RemoteException;
}
