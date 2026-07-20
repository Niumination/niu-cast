package eb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: eb.a$a, reason: collision with other inner class name */
    public static class C0096a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // eb.a
        public void f(int i10, String str) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f4168c = "com.transsion.hubsdk.api.resmonitor.ITranResMonitorCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4169d = 1;

        /* JADX INFO: renamed from: eb.a$b$a, reason: collision with other inner class name */
        public static class C0097a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f4170d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f4171c;

            public C0097a(IBinder iBinder) {
                this.f4171c = iBinder;
            }

            public String O() {
                return b.f4168c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4171c;
            }

            @Override // eb.a
            public void f(int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f4168c);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    if (this.f4171c.transact(1, parcelObtain, null, 1) || b.P() == null) {
                        return;
                    }
                    f4170d.f(i10, str);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f4168c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f4168c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0097a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0097a.f4170d;
        }

        public static boolean Q(a aVar) {
            if (C0097a.f4170d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0097a.f4170d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f4168c);
                f(parcel.readInt(), parcel.readString());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f4168c);
            return true;
        }
    }

    void f(int i10, String str) throws RemoteException;
}
