package com.transsion.tranradionet.tce;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ITceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.tranradionet.tce.ITceCallback";

    public static class Default implements ITceCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.tranradionet.tce.ITceCallback
        public void onSensorChanged(int i8, float[] fArr, int i9, long j8) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.tce.ITceCallback
        public void onTceEvent(TceEvent tceEvent) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITceCallback {
        static final int TRANSACTION_onSensorChanged = 1;
        static final int TRANSACTION_onTceEvent = 2;

        public static class Proxy implements ITceCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITceCallback.DESCRIPTOR;
            }

            @Override // com.transsion.tranradionet.tce.ITceCallback
            public void onSensorChanged(int i8, float[] fArr, int i9, long j8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeFloatArray(fArr);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeLong(j8);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceCallback
            public void onTceEvent(TceEvent tceEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceCallback.DESCRIPTOR);
                    parcelObtain.writeTypedObject(tceEvent, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITceCallback.DESCRIPTOR);
        }

        public static ITceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITceCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITceCallback)) ? new Proxy(iBinder) : (ITceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(ITceCallback.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(ITceCallback.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                int i10 = parcel.readInt();
                float[] fArrCreateFloatArray = parcel.createFloatArray();
                int i11 = parcel.readInt();
                long j8 = parcel.readLong();
                parcel.enforceNoDataAvail();
                onSensorChanged(i10, fArrCreateFloatArray, i11, j8);
                parcel2.writeNoException();
            } else {
                if (i8 != 2) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                TceEvent tceEvent = (TceEvent) parcel.readTypedObject(TceEvent.CREATOR);
                parcel.enforceNoDataAvail();
                onTceEvent(tceEvent);
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onSensorChanged(int i8, float[] fArr, int i9, long j8) throws RemoteException;

    void onTceEvent(TceEvent tceEvent) throws RemoteException;
}
