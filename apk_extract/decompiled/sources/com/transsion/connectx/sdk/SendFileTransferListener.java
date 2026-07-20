package com.transsion.connectx.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface SendFileTransferListener extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.SendFileTransferListener";

    public static class Default implements SendFileTransferListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.SendFileTransferListener
        public void onCancelTransfer(int i8) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.SendFileTransferListener
        public void onConfirmRequestFile(List<String> list, String str, int i8) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.SendFileTransferListener
        public void onFailed(String str, int i8, String str2, int i9) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.SendFileTransferListener
        public void onFileTaskConfirmResult(int i8, String str, List<String> list) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.SendFileTransferListener
        public void onProgress(String str, int i8, String str2, int i9) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.SendFileTransferListener
        public void onSuccess(String str, String str2, int i8) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.SendFileTransferListener
        public void onTransferFinish() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements SendFileTransferListener {
        static final int TRANSACTION_onCancelTransfer = 6;
        static final int TRANSACTION_onConfirmRequestFile = 5;
        static final int TRANSACTION_onFailed = 3;
        static final int TRANSACTION_onFileTaskConfirmResult = 7;
        static final int TRANSACTION_onProgress = 1;
        static final int TRANSACTION_onSuccess = 2;
        static final int TRANSACTION_onTransferFinish = 4;

        public static class Proxy implements SendFileTransferListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return SendFileTransferListener.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.SendFileTransferListener
            public void onCancelTransfer(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SendFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.SendFileTransferListener
            public void onConfirmRequestFile(List<String> list, String str, int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SendFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.SendFileTransferListener
            public void onFailed(String str, int i8, String str2, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SendFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.SendFileTransferListener
            public void onFileTaskConfirmResult(int i8, String str, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SendFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.SendFileTransferListener
            public void onProgress(String str, int i8, String str2, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SendFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.SendFileTransferListener
            public void onSuccess(String str, String str2, int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SendFileTransferListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.SendFileTransferListener
            public void onTransferFinish() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SendFileTransferListener.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, SendFileTransferListener.DESCRIPTOR);
        }

        public static SendFileTransferListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(SendFileTransferListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof SendFileTransferListener)) ? new Proxy(iBinder) : (SendFileTransferListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(SendFileTransferListener.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(SendFileTransferListener.DESCRIPTOR);
                return true;
            }
            switch (i8) {
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
                    onConfirmRequestFile(parcel.createStringArrayList(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onCancelTransfer(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    onFileTaskConfirmResult(parcel.readInt(), parcel.readString(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i8, parcel, parcel2, i9);
            }
        }
    }

    void onCancelTransfer(int i8) throws RemoteException;

    void onConfirmRequestFile(List<String> list, String str, int i8) throws RemoteException;

    void onFailed(String str, int i8, String str2, int i9) throws RemoteException;

    void onFileTaskConfirmResult(int i8, String str, List<String> list) throws RemoteException;

    void onProgress(String str, int i8, String str2, int i9) throws RemoteException;

    void onSuccess(String str, String str2, int i8) throws RemoteException;

    void onTransferFinish() throws RemoteException;
}
