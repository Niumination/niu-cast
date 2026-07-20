package com.transsion.connectx.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface TCCPListener extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.TCCPListener";

    public static class Default implements TCCPListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.TCCPListener
        public void onEnd() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.TCCPListener
        public void onError(int i8) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.TCCPListener
        public void onStart() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements TCCPListener {
        static final int TRANSACTION_onEnd = 3;
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onStart = 1;

        public static class Proxy implements TCCPListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return TCCPListener.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.TCCPListener
            public void onEnd() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(TCCPListener.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.TCCPListener
            public void onError(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(TCCPListener.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.TCCPListener
            public void onStart() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(TCCPListener.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, TCCPListener.DESCRIPTOR);
        }

        public static TCCPListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(TCCPListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof TCCPListener)) ? new Proxy(iBinder) : (TCCPListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(TCCPListener.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(TCCPListener.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                onStart();
                parcel2.writeNoException();
            } else if (i8 == 2) {
                onError(parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i8 != 3) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                onEnd();
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onEnd() throws RemoteException;

    void onError(int i8) throws RemoteException;

    void onStart() throws RemoteException;
}
