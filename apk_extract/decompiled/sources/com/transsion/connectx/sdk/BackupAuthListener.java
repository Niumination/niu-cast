package com.transsion.connectx.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface BackupAuthListener extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.BackupAuthListener";

    public static class Default implements BackupAuthListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.BackupAuthListener
        public void onRequest(String str, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements BackupAuthListener {
        static final int TRANSACTION_onRequest = 1;

        public static class Proxy implements BackupAuthListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return BackupAuthListener.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.BackupAuthListener
            public void onRequest(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(BackupAuthListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, BackupAuthListener.DESCRIPTOR);
        }

        public static BackupAuthListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(BackupAuthListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof BackupAuthListener)) ? new Proxy(iBinder) : (BackupAuthListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(BackupAuthListener.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(BackupAuthListener.DESCRIPTOR);
                return true;
            }
            if (i8 != 1) {
                return super.onTransact(i8, parcel, parcel2, i9);
            }
            onRequest(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onRequest(String str, String str2) throws RemoteException;
}
