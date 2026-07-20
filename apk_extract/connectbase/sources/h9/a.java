package h9;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: h9.a$a, reason: collision with other inner class name */
    public static class C0195a implements a {
        @Override // h9.a
        public boolean E(String str) throws RemoteException {
            return false;
        }

        @Override // h9.a
        public boolean F(String str, int i10, String str2, String str3, long j10, String str4) throws RemoteException {
            return false;
        }

        @Override // h9.a
        public int J(String str) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // h9.a
        public int s(String str, int i10, String str2) throws RemoteException {
            return 0;
        }

        @Override // h9.a
        public int w(String str, int i10, String str2) throws RemoteException {
            return 0;
        }

        @Override // h9.a
        public boolean y(Intent intent, String str) throws RemoteException {
            return false;
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f6999c = "com.transsion.hubsdk.api.app.ITranActivityController";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f7000d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f7001e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f7002f = 3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f7003g = 4;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f7004h = 5;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f7005i = 6;

        /* JADX INFO: renamed from: h9.a$b$a, reason: collision with other inner class name */
        public static class C0196a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f7006d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f7007c;

            public C0196a(IBinder iBinder) {
                this.f7007c = iBinder;
            }

            @Override // h9.a
            public boolean E(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6999c);
                    parcelObtain.writeString(str);
                    if (!this.f7007c.transact(2, parcelObtain, parcelObtain2, 0) && b.P() != null) {
                        return f7006d.E(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.a
            public boolean F(String str, int i10, String str2, String str3, long j10, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6999c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeString(str4);
                    if (!this.f7007c.transact(3, parcelObtain, parcelObtain2, 0) && b.P() != null) {
                        return f7006d.F(str, i10, str2, str3, j10, str4);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.a
            public int J(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6999c);
                    parcelObtain.writeString(str);
                    if (!this.f7007c.transact(6, parcelObtain, parcelObtain2, 0) && b.P() != null) {
                        return f7006d.J(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String O() {
                return b.f6999c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7007c;
            }

            @Override // h9.a
            public int s(String str, int i10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6999c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    if (!this.f7007c.transact(5, parcelObtain, parcelObtain2, 0) && b.P() != null) {
                        return f7006d.s(str, i10, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.a
            public int w(String str, int i10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6999c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    if (!this.f7007c.transact(4, parcelObtain, parcelObtain2, 0) && b.P() != null) {
                        return f7006d.w(str, i10, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.a
            public boolean y(Intent intent, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f6999c);
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.f7007c.transact(1, parcelObtain, parcelObtain2, 0) && b.P() != null) {
                        return f7006d.y(intent, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f6999c);
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f6999c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0196a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0196a.f7006d;
        }

        public static boolean Q(a aVar) {
            if (C0196a.f7006d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0196a.f7006d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f6999c);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f6999c);
                    boolean zY = y(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zY ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(f6999c);
                    boolean zE = E(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(f6999c);
                    boolean zF = F(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zF ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f6999c);
                    int iW = w(parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iW);
                    return true;
                case 5:
                    parcel.enforceInterface(f6999c);
                    int iS = s(parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iS);
                    return true;
                case 6:
                    parcel.enforceInterface(f6999c);
                    int iJ = J(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iJ);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    boolean E(String str) throws RemoteException;

    boolean F(String str, int i10, String str2, String str3, long j10, String str4) throws RemoteException;

    int J(String str) throws RemoteException;

    int s(String str, int i10, String str2) throws RemoteException;

    int w(String str, int i10, String str2) throws RemoteException;

    boolean y(Intent intent, String str) throws RemoteException;
}
