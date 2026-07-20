package rb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: rb.a$a, reason: collision with other inner class name */
    public static class C0347a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // rb.a
        public void dispose() throws RemoteException {
        }

        @Override // rb.a
        public void z() throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f14364c = "com.transsion.hubsdk.api.view.ITranInputMonitor";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14365d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14366e = 2;

        /* JADX INFO: renamed from: rb.a$b$a, reason: collision with other inner class name */
        public static class C0348a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f14367d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f14368c;

            public C0348a(IBinder iBinder) {
                this.f14368c = iBinder;
            }

            public String O() {
                return b.f14364c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14368c;
            }

            @Override // rb.a
            public void dispose() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f14364c);
                    if (this.f14368c.transact(1, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f14367d.dispose();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rb.a
            public void z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f14364c);
                    if (this.f14368c.transact(2, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f14367d.z();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f14364c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f14364c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0348a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0348a.f14367d;
        }

        public static boolean Q(a aVar) {
            if (C0348a.f14367d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0348a.f14367d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f14364c);
                dispose();
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f14364c);
                return true;
            }
            parcel.enforceInterface(f14364c);
            z();
            parcel2.writeNoException();
            return true;
        }
    }

    void dispose() throws RemoteException;

    void z() throws RemoteException;
}
