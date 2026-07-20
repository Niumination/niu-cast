package n6;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11413a = "com.transsion.hubcore.connectx.mirror.source.ICastStatusInterface";

    /* JADX INFO: renamed from: n6.a$a, reason: collision with other inner class name */
    public static class C0291a implements a {
        @Override // n6.a
        public void C(int i10, WindowManager.LayoutParams layoutParams) throws RemoteException {
        }

        @Override // n6.a
        public void D(int i10, int i11) throws RemoteException {
        }

        @Override // n6.a
        public void H(int i10, int i11) throws RemoteException {
        }

        @Override // n6.a
        public void I(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // n6.a
        public void t(boolean z10) throws RemoteException {
        }

        @Override // n6.a
        public void v(int i10, String str) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11414c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11415d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f11416e = 3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f11417f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f11418g = 5;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f11419h = 6;

        /* JADX INFO: renamed from: n6.a$b$a, reason: collision with other inner class name */
        public static class C0292a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f11420c;

            public C0292a(IBinder iBinder) {
                this.f11420c = iBinder;
            }

            @Override // n6.a
            public void C(int i10, WindowManager.LayoutParams layoutParams) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f11413a);
                    parcelObtain.writeInt(i10);
                    c.d(parcelObtain, layoutParams, 0);
                    this.f11420c.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // n6.a
            public void D(int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f11413a);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.f11420c.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // n6.a
            public void H(int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f11413a);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.f11420c.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // n6.a
            public void I(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f11413a);
                    parcelObtain.writeString(str);
                    c.d(parcelObtain, bundle, 0);
                    this.f11420c.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String O() {
                return a.f11413a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11420c;
            }

            @Override // n6.a
            public void t(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f11413a);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.f11420c.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // n6.a
            public void v(int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f11413a);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    this.f11420c.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, a.f11413a);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f11413a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0292a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(a.f11413a);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(a.f11413a);
                return true;
            }
            switch (i10) {
                case 1:
                    H(parcel.readInt(), parcel.readInt());
                    return true;
                case 2:
                    v(parcel.readInt(), parcel.readString());
                    return true;
                case 3:
                    C(parcel.readInt(), (WindowManager.LayoutParams) c.c(parcel, WindowManager.LayoutParams.CREATOR));
                    return true;
                case 4:
                    t(parcel.readInt() != 0);
                    return true;
                case 5:
                    D(parcel.readInt(), parcel.readInt());
                    return true;
                case 6:
                    I(parcel.readString(), (Bundle) c.c(parcel, Bundle.CREATOR));
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class c {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void C(int i10, WindowManager.LayoutParams layoutParams) throws RemoteException;

    void D(int i10, int i11) throws RemoteException;

    void H(int i10, int i11) throws RemoteException;

    void I(String str, Bundle bundle) throws RemoteException;

    void t(boolean z10) throws RemoteException;

    void v(int i10, String str) throws RemoteException;
}
