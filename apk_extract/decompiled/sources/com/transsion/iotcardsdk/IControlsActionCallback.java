package com.transsion.iotcardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IControlsActionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.iotcardsdk.IControlsActionCallback";

    public static class Default implements IControlsActionCallback {
        @Override // com.transsion.iotcardsdk.IControlsActionCallback
        public void accept(IBinder iBinder, String str, int i8) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IControlsActionCallback {
        static final int TRANSACTION_accept = 1;

        public static class Proxy implements IControlsActionCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.transsion.iotcardsdk.IControlsActionCallback
            public void accept(IBinder iBinder, String str, int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsActionCallback.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IControlsActionCallback.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IControlsActionCallback.DESCRIPTOR);
        }

        public static IControlsActionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IControlsActionCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IControlsActionCallback)) ? new Proxy(iBinder) : (IControlsActionCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(IControlsActionCallback.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(IControlsActionCallback.DESCRIPTOR);
                return true;
            }
            if (i8 != 1) {
                return super.onTransact(i8, parcel, parcel2, i9);
            }
            accept(parcel.readStrongBinder(), parcel.readString(), parcel.readInt());
            return true;
        }
    }

    void accept(IBinder iBinder, String str, int i8) throws RemoteException;
}
