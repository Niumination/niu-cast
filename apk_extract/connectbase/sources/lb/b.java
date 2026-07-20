package lb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // lb.b
        public void c() throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: lb.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0258b extends Binder implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f9759c = "com.transsion.hubsdk.api.trancare.ITranTrancareCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f9760d = 1;

        /* JADX INFO: renamed from: lb.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static b f9761d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f9762c;

            public a(IBinder iBinder) {
                this.f9762c = iBinder;
            }

            public String O() {
                return AbstractBinderC0258b.f9759c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9762c;
            }

            @Override // lb.b
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0258b.f9759c);
                    if (this.f9762c.transact(1, parcelObtain, null, 1) || AbstractBinderC0258b.P() == null) {
                        return;
                    }
                    f9761d.c();
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0258b() {
            attachInterface(this, f9759c);
        }

        public static b O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f9759c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b P() {
            return a.f9761d;
        }

        public static boolean Q(b bVar) {
            if (a.f9761d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.f9761d = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f9759c);
                c();
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f9759c);
            return true;
        }
    }

    void c() throws RemoteException;
}
