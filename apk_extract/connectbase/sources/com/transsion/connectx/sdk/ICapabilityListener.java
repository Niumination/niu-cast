package com.transsion.connectx.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ICapabilityListener extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.ICapabilityListener";

    public static class Default implements ICapabilityListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.ICapabilityListener
        public boolean isSupportCapability(String str) throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ICapabilityListener
        public String onAction(String str, String str2) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityListener {
        static final int TRANSACTION_isSupportCapability = 1;
        static final int TRANSACTION_onAction = 2;

        public static class Proxy implements ICapabilityListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICapabilityListener.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.ICapabilityListener
            public boolean isSupportCapability(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICapabilityListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ICapabilityListener
            public String onAction(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICapabilityListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICapabilityListener.DESCRIPTOR);
        }

        public static ICapabilityListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICapabilityListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICapabilityListener)) ? new Proxy(iBinder) : (ICapabilityListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ICapabilityListener.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ICapabilityListener.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                boolean zIsSupportCapability = isSupportCapability(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zIsSupportCapability ? 1 : 0);
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                String strOnAction = onAction(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strOnAction);
            }
            return true;
        }
    }

    boolean isSupportCapability(String str) throws RemoteException;

    String onAction(String str, String str2) throws RemoteException;
}
