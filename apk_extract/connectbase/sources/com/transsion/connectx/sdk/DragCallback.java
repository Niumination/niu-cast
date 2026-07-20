package com.transsion.connectx.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface DragCallback extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.DragCallback";

    public static class Default implements DragCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.DragCallback
        public void requestFilePath(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements DragCallback {
        static final int TRANSACTION_requestFilePath = 1;

        public static class Proxy implements DragCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DragCallback.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.DragCallback
            public void requestFilePath(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DragCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DragCallback.DESCRIPTOR);
        }

        public static DragCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DragCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof DragCallback)) ? new Proxy(iBinder) : (DragCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(DragCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(DragCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            requestFilePath(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void requestFilePath(String str) throws RemoteException;
}
