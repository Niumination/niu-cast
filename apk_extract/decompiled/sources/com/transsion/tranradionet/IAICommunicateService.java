package com.transsion.tranradionet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IAICommunicateService extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.tranradionet.IAICommunicateService";

    public static class Default implements IAICommunicateService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.tranradionet.IAICommunicateService
        public void cellInfoListNotifyNew(List<Cell_tableBean> list) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.IAICommunicateService
        public void cellInfoSequenceNotify(long[] jArr) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.IAICommunicateService
        public void registerSignalPredictCallback(SignalPredictCallback signalPredictCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAICommunicateService {
        static final int TRANSACTION_cellInfoListNotifyNew = 2;
        static final int TRANSACTION_cellInfoSequenceNotify = 1;
        static final int TRANSACTION_registerSignalPredictCallback = 3;

        public static class Proxy implements IAICommunicateService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.tranradionet.IAICommunicateService
            public void cellInfoListNotifyNew(List<Cell_tableBean> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAICommunicateService.DESCRIPTOR);
                    parcelObtain.writeTypedList(list, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.IAICommunicateService
            public void cellInfoSequenceNotify(long[] jArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAICommunicateService.DESCRIPTOR);
                    parcelObtain.writeLongArray(jArr);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAICommunicateService.DESCRIPTOR;
            }

            @Override // com.transsion.tranradionet.IAICommunicateService
            public void registerSignalPredictCallback(SignalPredictCallback signalPredictCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAICommunicateService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(signalPredictCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAICommunicateService.DESCRIPTOR);
        }

        public static IAICommunicateService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAICommunicateService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAICommunicateService)) ? new Proxy(iBinder) : (IAICommunicateService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(IAICommunicateService.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(IAICommunicateService.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                long[] jArrCreateLongArray = parcel.createLongArray();
                parcel.enforceNoDataAvail();
                cellInfoSequenceNotify(jArrCreateLongArray);
                parcel2.writeNoException();
            } else if (i8 == 2) {
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Cell_tableBean.CREATOR);
                parcel.enforceNoDataAvail();
                cellInfoListNotifyNew(arrayListCreateTypedArrayList);
                parcel2.writeNoException();
            } else {
                if (i8 != 3) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                SignalPredictCallback signalPredictCallbackAsInterface = SignalPredictCallback.Stub.asInterface(parcel.readStrongBinder());
                parcel.enforceNoDataAvail();
                registerSignalPredictCallback(signalPredictCallbackAsInterface);
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void cellInfoListNotifyNew(List<Cell_tableBean> list) throws RemoteException;

    void cellInfoSequenceNotify(long[] jArr) throws RemoteException;

    void registerSignalPredictCallback(SignalPredictCallback signalPredictCallback) throws RemoteException;
}
