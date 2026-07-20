package gi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: gi.a$a, reason: collision with other inner class name */
    public static class C0156a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // gi.a
        public void o(String str, boolean z10, String str2) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f6474c = "com.transsion.log.cloudengine.ICloudEngineCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6475d = 1;

        /* JADX INFO: renamed from: gi.a$b$a, reason: collision with other inner class name */
        public static class C0157a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f6476d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f6477c;

            public C0157a(IBinder iBinder) {
                this.f6477c = iBinder;
            }

            public String O() {
                return b.f6474c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6477c;
            }

            @Override // gi.a
            public void o(String str, boolean z10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6474c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    if (this.f6477c.transact(1, parcelObtain, null, 1) || b.P() == null) {
                        return;
                    }
                    f6476d.o(str, z10, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f6474c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f6474c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0157a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0157a.f6476d;
        }

        public static boolean Q(a aVar) {
            if (C0157a.f6476d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0157a.f6476d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f6474c);
                o(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f6474c);
            return true;
        }
    }

    void o(String str, boolean z10, String str2) throws RemoteException;
}
