package fi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: fi.a$a, reason: collision with other inner class name */
    public static class C0143a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // fi.a
        public void c() throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f6010c = "com.transsion.log.ITranLogCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6011d = 1;

        /* JADX INFO: renamed from: fi.a$b$a, reason: collision with other inner class name */
        public static class C0144a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f6012d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f6013c;

            public C0144a(IBinder iBinder) {
                this.f6013c = iBinder;
            }

            public String O() {
                return b.f6010c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6013c;
            }

            @Override // fi.a
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6010c);
                    if (this.f6013c.transact(1, parcelObtain, null, 1) || b.P() == null) {
                        return;
                    }
                    f6012d.c();
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f6010c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f6010c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0144a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0144a.f6012d;
        }

        public static boolean Q(a aVar) {
            if (C0144a.f6012d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0144a.f6012d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f6010c);
                c();
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f6010c);
            return true;
        }
    }

    void c() throws RemoteException;
}
