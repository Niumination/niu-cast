package com.transsion.iotcardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IControlsSubscription extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.iotcardsdk.IControlsSubscription";

    public static class Default implements IControlsSubscription {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscription
        public void cancel() throws RemoteException {
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscription
        public void request(long j8) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IControlsSubscription {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_request = 1;

        public static class Proxy implements IControlsSubscription {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.iotcardsdk.IControlsSubscription
            public void cancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsSubscription.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IControlsSubscription.DESCRIPTOR;
            }

            @Override // com.transsion.iotcardsdk.IControlsSubscription
            public void request(long j8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsSubscription.DESCRIPTOR);
                    parcelObtain.writeLong(j8);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IControlsSubscription.DESCRIPTOR);
        }

        public static IControlsSubscription asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IControlsSubscription.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IControlsSubscription)) ? new Proxy(iBinder) : (IControlsSubscription) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(IControlsSubscription.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(IControlsSubscription.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                request(parcel.readLong());
            } else {
                if (i8 != 2) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                cancel();
            }
            return true;
        }
    }

    void cancel() throws RemoteException;

    void request(long j8) throws RemoteException;
}
