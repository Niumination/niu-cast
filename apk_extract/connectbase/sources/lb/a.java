package lb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: lb.a$a, reason: collision with other inner class name */
    public static class C0256a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // lb.a
        public void o(String str, boolean z10, String str2) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f9755c = "com.transsion.hubsdk.api.trancare.ITranCloudEngineCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f9756d = 1;

        /* JADX INFO: renamed from: lb.a$b$a, reason: collision with other inner class name */
        public static class C0257a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f9757d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f9758c;

            public C0257a(IBinder iBinder) {
                this.f9758c = iBinder;
            }

            public String O() {
                return b.f9755c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9758c;
            }

            @Override // lb.a
            public void o(String str, boolean z10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f9755c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    if (this.f9758c.transact(1, parcelObtain, null, 1) || b.P() == null) {
                        return;
                    }
                    f9757d.o(str, z10, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f9755c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f9755c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0257a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0257a.f9757d;
        }

        public static boolean Q(a aVar) {
            if (C0257a.f9757d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0257a.f9757d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f9755c);
                o(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f9755c);
            return true;
        }
    }

    void o(String str, boolean z10, String str2) throws RemoteException;
}
