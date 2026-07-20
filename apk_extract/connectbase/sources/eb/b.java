package eb;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // eb.b
        public void K(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // eb.b
        public void L(int i10, String str) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* JADX INFO: renamed from: eb.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0098b extends Binder implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f4172c = "com.transsion.hubsdk.api.resmonitor.ITranResmonitorAsyncCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4173d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f4174e = 2;

        /* JADX INFO: renamed from: eb.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static b f4175d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f4176c;

            public a(IBinder iBinder) {
                this.f4176c = iBinder;
            }

            @Override // eb.b
            public void K(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0098b.f4172c);
                    parcelObtain.writeInt(i10);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f4176c.transact(2, parcelObtain, null, 1) || AbstractBinderC0098b.P() == null) {
                        return;
                    }
                    f4175d.K(i10, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // eb.b
            public void L(int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0098b.f4172c);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    if (this.f4176c.transact(1, parcelObtain, null, 1) || AbstractBinderC0098b.P() == null) {
                        return;
                    }
                    f4175d.L(i10, str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String O() {
                return AbstractBinderC0098b.f4172c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4176c;
            }
        }

        public AbstractBinderC0098b() {
            attachInterface(this, f4172c);
        }

        public static b O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f4172c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b P() {
            return a.f4175d;
        }

        public static boolean Q(b bVar) {
            if (a.f4175d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.f4175d = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f4172c);
                L(parcel.readInt(), parcel.readString());
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f4172c);
                K(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f4172c);
            return true;
        }
    }

    void K(int i10, Bundle bundle) throws RemoteException;

    void L(int i10, String str) throws RemoteException;
}
