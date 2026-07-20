package com.transsion.tranradionet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ITranRadioNetServiceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.tranradionet.ITranRadioNetServiceCallback";

    public static class Default implements ITranRadioNetServiceCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetServiceCallback
        public void dispatchRilCmdResponse(int i8, int i9, int i10, String str) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetServiceCallback
        public void onEvent(int i8, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITranRadioNetServiceCallback {
        static final int TRANSACTION_dispatchRilCmdResponse = 2;
        static final int TRANSACTION_onEvent = 1;

        public static class Proxy implements ITranRadioNetServiceCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.tranradionet.ITranRadioNetServiceCallback
            public void dispatchRilCmdResponse(int i8, int i9, int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITranRadioNetServiceCallback.DESCRIPTOR;
            }

            @Override // com.transsion.tranradionet.ITranRadioNetServiceCallback
            public void onEvent(int i8, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
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
            attachInterface(this, ITranRadioNetServiceCallback.DESCRIPTOR);
        }

        public static ITranRadioNetServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITranRadioNetServiceCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITranRadioNetServiceCallback)) ? new Proxy(iBinder) : (ITranRadioNetServiceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(ITranRadioNetServiceCallback.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(ITranRadioNetServiceCallback.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                int i10 = parcel.readInt();
                String string = parcel.readString();
                parcel.enforceNoDataAvail();
                onEvent(i10, string);
                parcel2.writeNoException();
            } else {
                if (i8 != 2) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                int i11 = parcel.readInt();
                int i12 = parcel.readInt();
                int i13 = parcel.readInt();
                String string2 = parcel.readString();
                parcel.enforceNoDataAvail();
                dispatchRilCmdResponse(i11, i12, i13, string2);
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void dispatchRilCmdResponse(int i8, int i9, int i10, String str) throws RemoteException;

    void onEvent(int i8, String str) throws RemoteException;
}
