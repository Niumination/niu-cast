package com.transsion.iotcardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface InitService extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.iotcardsdk.InitService";

    public static class Default implements InitService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.iotcardsdk.InitService
        public void init() throws RemoteException {
        }

        @Override // com.transsion.iotcardsdk.InitService
        public void unbind() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements InitService {
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_unbind = 2;

        public static class Proxy implements InitService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return InitService.DESCRIPTOR;
            }

            @Override // com.transsion.iotcardsdk.InitService
            public void init() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(InitService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.iotcardsdk.InitService
            public void unbind() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(InitService.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, InitService.DESCRIPTOR);
        }

        public static InitService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InitService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InitService)) ? new Proxy(iBinder) : (InitService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(InitService.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(InitService.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                init();
            } else {
                if (i8 != 2) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                unbind();
            }
            return true;
        }
    }

    void init() throws RemoteException;

    void unbind() throws RemoteException;
}
