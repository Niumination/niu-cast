package rj;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14502b = "com.transsion.wm.shell.splitscreen.ITranSplitScreen";

    /* JADX INFO: renamed from: rj.a$a, reason: collision with other inner class name */
    public static class C0353a implements a {
        @Override // rj.a
        public void A(int i10) throws RemoteException {
        }

        @Override // rj.a
        public List<String> G() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // rj.a
        public void r(PendingIntent pendingIntent, Intent intent, int i10, Bundle bundle, Bundle bundle2, int i11, float f10) throws RemoteException {
        }

        @Override // rj.a
        public void u(int i10, Bundle bundle, int i11, Bundle bundle2, int i12, float f10, boolean z10) throws RemoteException {
        }

        @Override // rj.a
        public void x(int i10, Bundle bundle, int i11, float f10) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14503c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14504d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14505e = 3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f14506f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f14507g = 5;

        /* JADX INFO: renamed from: rj.a$b$a, reason: collision with other inner class name */
        public static class C0354a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f14508c;

            public C0354a(IBinder iBinder) {
                this.f14508c = iBinder;
            }

            @Override // rj.a
            public void A(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14502b);
                    parcelObtain.writeInt(i10);
                    this.f14508c.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rj.a
            public List<String> G() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14502b);
                    this.f14508c.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String O() {
                return a.f14502b;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14508c;
            }

            @Override // rj.a
            public void r(PendingIntent pendingIntent, Intent intent, int i10, Bundle bundle, Bundle bundle2, int i11, float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14502b);
                    c.d(parcelObtain, pendingIntent, 0);
                    c.d(parcelObtain, intent, 0);
                    parcelObtain.writeInt(i10);
                    c.d(parcelObtain, bundle, 0);
                    c.d(parcelObtain, bundle2, 0);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeFloat(f10);
                    this.f14508c.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rj.a
            public void u(int i10, Bundle bundle, int i11, Bundle bundle2, int i12, float f10, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14502b);
                    parcelObtain.writeInt(i10);
                    c.d(parcelObtain, bundle, 0);
                    parcelObtain.writeInt(i11);
                    c.d(parcelObtain, bundle2, 0);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeFloat(f10);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.f14508c.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rj.a
            public void x(int i10, Bundle bundle, int i11, float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14502b);
                    parcelObtain.writeInt(i10);
                    c.d(parcelObtain, bundle, 0);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeFloat(f10);
                    this.f14508c.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, a.f14502b);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f14502b);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0354a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(a.f14502b);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(a.f14502b);
                return true;
            }
            if (i10 == 1) {
                A(parcel.readInt());
            } else if (i10 == 2) {
                int i12 = parcel.readInt();
                Parcelable.Creator creator = Bundle.CREATOR;
                u(i12, (Bundle) c.c(parcel, creator), parcel.readInt(), (Bundle) c.c(parcel, creator), parcel.readInt(), parcel.readFloat(), parcel.readInt() != 0);
            } else if (i10 == 3) {
                x(parcel.readInt(), (Bundle) c.c(parcel, Bundle.CREATOR), parcel.readInt(), parcel.readFloat());
            } else if (i10 == 4) {
                PendingIntent pendingIntent = (PendingIntent) c.c(parcel, PendingIntent.CREATOR);
                Intent intent = (Intent) c.c(parcel, Intent.CREATOR);
                int i13 = parcel.readInt();
                Parcelable.Creator creator2 = Bundle.CREATOR;
                r(pendingIntent, intent, i13, (Bundle) c.c(parcel, creator2), (Bundle) c.c(parcel, creator2), parcel.readInt(), parcel.readFloat());
            } else {
                if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                List<String> listG = G();
                parcel2.writeNoException();
                parcel2.writeStringList(listG);
            }
            return true;
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

    void A(int i10) throws RemoteException;

    List<String> G() throws RemoteException;

    void r(PendingIntent pendingIntent, Intent intent, int i10, Bundle bundle, Bundle bundle2, int i11, float f10) throws RemoteException;

    void u(int i10, Bundle bundle, int i11, Bundle bundle2, int i12, float f10, boolean z10) throws RemoteException;

    void x(int i10, Bundle bundle, int i11, float f10) throws RemoteException;
}
