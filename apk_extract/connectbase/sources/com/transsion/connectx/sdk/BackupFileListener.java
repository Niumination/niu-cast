package com.transsion.connectx.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface BackupFileListener extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.BackupFileListener";

    public static class Default implements BackupFileListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.BackupFileListener
        public void onCancel(long j10, boolean z10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.BackupFileListener
        public void onFail(long j10, int i10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.BackupFileListener
        public void onFinish(long j10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.BackupFileListener
        public void onProgress(long j10, double d10, int i10, int i11) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.BackupFileListener
        public void onStart(long j10, int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements BackupFileListener {
        static final int TRANSACTION_onCancel = 4;
        static final int TRANSACTION_onFail = 5;
        static final int TRANSACTION_onFinish = 3;
        static final int TRANSACTION_onProgress = 2;
        static final int TRANSACTION_onStart = 1;

        public static class Proxy implements BackupFileListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return BackupFileListener.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.BackupFileListener
            public void onCancel(long j10, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(BackupFileListener.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.BackupFileListener
            public void onFail(long j10, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(BackupFileListener.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.BackupFileListener
            public void onFinish(long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(BackupFileListener.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.BackupFileListener
            public void onProgress(long j10, double d10, int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(BackupFileListener.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeDouble(d10);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.BackupFileListener
            public void onStart(long j10, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(BackupFileListener.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, BackupFileListener.DESCRIPTOR);
        }

        public static BackupFileListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(BackupFileListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof BackupFileListener)) ? new Proxy(iBinder) : (BackupFileListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(BackupFileListener.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(BackupFileListener.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onStart(parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
            } else if (i10 == 2) {
                onProgress(parcel.readLong(), parcel.readDouble(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
            } else if (i10 == 3) {
                onFinish(parcel.readLong());
                parcel2.writeNoException();
            } else if (i10 == 4) {
                onCancel(parcel.readLong(), parcel.readInt() != 0);
                parcel2.writeNoException();
            } else {
                if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onFail(parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onCancel(long j10, boolean z10) throws RemoteException;

    void onFail(long j10, int i10) throws RemoteException;

    void onFinish(long j10) throws RemoteException;

    void onProgress(long j10, double d10, int i10, int i11) throws RemoteException;

    void onStart(long j10, int i10) throws RemoteException;
}
