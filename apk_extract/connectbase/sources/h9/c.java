package h9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static class a implements c {
        @Override // h9.c
        public void a(String str, boolean z10, String str2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // h9.c
        public void d(String str, boolean z10) throws RemoteException {
        }

        @Override // h9.c
        public void h(String str, boolean z10) throws RemoteException {
        }

        @Override // h9.c
        public void j(String str, boolean z10) throws RemoteException {
        }

        @Override // h9.c
        public void k(String str, String str2, boolean z10, String str3) throws RemoteException {
        }

        @Override // h9.c
        public void l(String str, boolean z10, String str2) throws RemoteException {
        }

        @Override // h9.c
        public void n(String str) throws RemoteException {
        }

        @Override // h9.c
        public void p(String str, boolean z10, String str2) throws RemoteException {
        }

        @Override // h9.c
        public void q(String str, String str2, boolean z10) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7008c = "com.transsion.hubsdk.api.app.ITranStatusBar";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f7009d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f7010e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f7011f = 3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f7012g = 4;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f7013h = 5;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f7014i = 6;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f7015j = 7;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f7016k = 8;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f7017l = 9;

        public static class a implements c {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static c f7018d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f7019c;

            public a(IBinder iBinder) {
                this.f7019c = iBinder;
            }

            public String O() {
                return b.f7008c;
            }

            @Override // h9.c
            public void a(String str, boolean z10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    if (this.f7019c.transact(4, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.a(str, z10, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7019c;
            }

            @Override // h9.c
            public void d(String str, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f7019c.transact(1, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.d(str, z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void h(String str, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f7019c.transact(5, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.h(str, z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void j(String str, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f7019c.transact(6, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.j(str, z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void k(String str, String str2, boolean z10, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str3);
                    if (this.f7019c.transact(8, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.k(str, str2, z10, str3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void l(String str, boolean z10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    if (this.f7019c.transact(3, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.l(str, z10, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void n(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    if (this.f7019c.transact(7, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.n(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void p(String str, boolean z10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    if (this.f7019c.transact(2, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.p(str, z10, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void q(String str, String str2, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7008c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f7019c.transact(9, parcelObtain, parcelObtain2, 0) || b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f7018d.q(str, str2, z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f7008c);
        }

        public static c O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f7008c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public static c P() {
            return a.f7018d;
        }

        public static boolean Q(c cVar) {
            if (a.f7018d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (cVar == null) {
                return false;
            }
            a.f7018d = cVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f7008c);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f7008c);
                    d(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(f7008c);
                    p(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(f7008c);
                    l(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(f7008c);
                    a(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(f7008c);
                    h(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(f7008c);
                    j(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(f7008c);
                    n(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(f7008c);
                    k(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(f7008c);
                    q(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void a(String str, boolean z10, String str2) throws RemoteException;

    void d(String str, boolean z10) throws RemoteException;

    void h(String str, boolean z10) throws RemoteException;

    void j(String str, boolean z10) throws RemoteException;

    void k(String str, String str2, boolean z10, String str3) throws RemoteException;

    void l(String str, boolean z10, String str2) throws RemoteException;

    void n(String str) throws RemoteException;

    void p(String str, boolean z10, String str2) throws RemoteException;

    void q(String str, String str2, boolean z10) throws RemoteException;
}
