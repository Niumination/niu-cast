package k3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // k3.b
        public void B(k3.a aVar) throws RemoteException {
        }

        @Override // k3.b
        public void M(k3.a aVar) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // k3.b
        public void b(String str, String str2) throws RemoteException {
        }

        @Override // k3.b
        public void e(String str, String str2) throws RemoteException {
        }

        @Override // k3.b
        public String g(String str) throws RemoteException {
            return null;
        }
    }

    /* JADX INFO: renamed from: k3.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0236b extends Binder implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f8919c = "com.transsion.appm.ITranAppmManager";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f8920d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f8921e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f8922f = 3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f8923g = 4;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f8924h = 5;

        /* JADX INFO: renamed from: k3.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static b f8925d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f8926c;

            public a(IBinder iBinder) {
                this.f8926c = iBinder;
            }

            @Override // k3.b
            public void B(k3.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0236b.f8919c);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f8926c.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC0236b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f8925d.B(aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // k3.b
            public void M(k3.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0236b.f8919c);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f8926c.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0236b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f8925d.M(aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String O() {
                return AbstractBinderC0236b.f8919c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8926c;
            }

            @Override // k3.b
            public void b(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0236b.f8919c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.f8926c.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0236b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f8925d.b(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // k3.b
            public void e(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0236b.f8919c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.f8926c.transact(5, parcelObtain, parcelObtain2, 0) || AbstractBinderC0236b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f8925d.e(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // k3.b
            public String g(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0236b.f8919c);
                    parcelObtain.writeString(str);
                    if (!this.f8926c.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0236b.P() != null) {
                        return f8925d.g(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0236b() {
            attachInterface(this, f8919c);
        }

        public static b O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f8919c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b P() {
            return a.f8925d;
        }

        public static boolean Q(b bVar) {
            if (a.f8925d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.f8925d = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f8919c);
                b(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f8919c);
                M(k3.a.b.O(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface(f8919c);
                B(k3.a.b.O(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 4) {
                parcel.enforceInterface(f8919c);
                String strG = g(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strG);
                return true;
            }
            if (i10 != 5) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f8919c);
                return true;
            }
            parcel.enforceInterface(f8919c);
            e(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void B(k3.a aVar) throws RemoteException;

    void M(k3.a aVar) throws RemoteException;

    void b(String str, String str2) throws RemoteException;

    void e(String str, String str2) throws RemoteException;

    String g(String str) throws RemoteException;
}
