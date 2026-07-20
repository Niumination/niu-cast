package com.transsion.connectx.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ReceiveFileTransferListener extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.ReceiveFileTransferListener";

    public static class Default implements ReceiveFileTransferListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
        public void onCancelTransfer(int i10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
        public void onConfirmReceiveFile(List<String> list, long j10, String str, String str2, int i10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
        public void onFailed(String str, int i10, String str2, int i11) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
        public void onProgress(String str, int i10, String str2, int i11) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
        public void onSuccess(String str, String str2, int i10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
        public void onTransferFinish() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ReceiveFileTransferListener {
        static final int TRANSACTION_onCancelTransfer = 6;
        static final int TRANSACTION_onConfirmReceiveFile = 5;
        static final int TRANSACTION_onFailed = 3;
        static final int TRANSACTION_onProgress = 1;
        static final int TRANSACTION_onSuccess = 2;
        static final int TRANSACTION_onTransferFinish = 4;

        public static class Proxy implements ReceiveFileTransferListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ReceiveFileTransferListener.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
            public void onCancelTransfer(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiveFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
            public void onConfirmReceiveFile(List<String> list, long j10, String str, String str2, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiveFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
            public void onFailed(String str, int i10, String str2, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiveFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
            public void onProgress(String str, int i10, String str2, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiveFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
            public void onSuccess(String str, String str2, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiveFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
            public void onTransferFinish() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ReceiveFileTransferListener.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ReceiveFileTransferListener.DESCRIPTOR);
        }

        public static ReceiveFileTransferListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ReceiveFileTransferListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ReceiveFileTransferListener)) ? new Proxy(iBinder) : (ReceiveFileTransferListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ReceiveFileTransferListener.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ReceiveFileTransferListener.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    onProgress(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    onSuccess(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    onFailed(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    onTransferFinish();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    onConfirmReceiveFile(parcel.createStringArrayList(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onCancelTransfer(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void onCancelTransfer(int i10) throws RemoteException;

    void onConfirmReceiveFile(List<String> list, long j10, String str, String str2, int i10) throws RemoteException;

    void onFailed(String str, int i10, String str2, int i11) throws RemoteException;

    void onProgress(String str, int i10, String str2, int i11) throws RemoteException;

    void onSuccess(String str, String str2, int i10) throws RemoteException;

    void onTransferFinish() throws RemoteException;
}
