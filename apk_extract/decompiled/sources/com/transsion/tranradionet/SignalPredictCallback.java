package com.transsion.tranradionet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface SignalPredictCallback extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.tranradionet.SignalPredictCallback";

    public static class Default implements SignalPredictCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.tranradionet.SignalPredictCallback
        public void frequentRouteTimeLine(int i8, long[] jArr) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.SignalPredictCallback
        public void predictEvent(int i8, int i9, int i10) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.SignalPredictCallback
        public void setCellInfoRptRequirementForEventPredict(int i8, int i9, int i10) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.SignalPredictCallback
        public void setCellInfoRptRequirementForFrequentRoute(List<TranCellInfo> list, int i8, int i9, int i10) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.SignalPredictCallback
        public void setDbRequirement(int i8, int i9, int i10, int i11) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.SignalPredictCallback
        public void stopReportEvent() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements SignalPredictCallback {
        static final int TRANSACTION_frequentRouteTimeLine = 6;
        static final int TRANSACTION_predictEvent = 4;
        static final int TRANSACTION_setCellInfoRptRequirementForEventPredict = 3;
        static final int TRANSACTION_setCellInfoRptRequirementForFrequentRoute = 2;
        static final int TRANSACTION_setDbRequirement = 1;
        static final int TRANSACTION_stopReportEvent = 5;

        public static class Proxy implements SignalPredictCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.tranradionet.SignalPredictCallback
            public void frequentRouteTimeLine(int i8, long[] jArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SignalPredictCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeLongArray(jArr);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return SignalPredictCallback.DESCRIPTOR;
            }

            @Override // com.transsion.tranradionet.SignalPredictCallback
            public void predictEvent(int i8, int i9, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SignalPredictCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.SignalPredictCallback
            public void setCellInfoRptRequirementForEventPredict(int i8, int i9, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SignalPredictCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.SignalPredictCallback
            public void setCellInfoRptRequirementForFrequentRoute(List<TranCellInfo> list, int i8, int i9, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SignalPredictCallback.DESCRIPTOR);
                    parcelObtain.writeTypedList(list, 0);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.SignalPredictCallback
            public void setDbRequirement(int i8, int i9, int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SignalPredictCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.SignalPredictCallback
            public void stopReportEvent() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SignalPredictCallback.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, SignalPredictCallback.DESCRIPTOR);
        }

        public static SignalPredictCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(SignalPredictCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof SignalPredictCallback)) ? new Proxy(iBinder) : (SignalPredictCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(SignalPredictCallback.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(SignalPredictCallback.DESCRIPTOR);
                return true;
            }
            switch (i8) {
                case 1:
                    int i10 = parcel.readInt();
                    int i11 = parcel.readInt();
                    int i12 = parcel.readInt();
                    int i13 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    setDbRequirement(i10, i11, i12, i13);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(TranCellInfo.CREATOR);
                    int i14 = parcel.readInt();
                    int i15 = parcel.readInt();
                    int i16 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    setCellInfoRptRequirementForFrequentRoute(arrayListCreateTypedArrayList, i14, i15, i16);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int i17 = parcel.readInt();
                    int i18 = parcel.readInt();
                    int i19 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    setCellInfoRptRequirementForEventPredict(i17, i18, i19);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int i20 = parcel.readInt();
                    int i21 = parcel.readInt();
                    int i22 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    predictEvent(i20, i21, i22);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    stopReportEvent();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    int i23 = parcel.readInt();
                    long[] jArrCreateLongArray = parcel.createLongArray();
                    parcel.enforceNoDataAvail();
                    frequentRouteTimeLine(i23, jArrCreateLongArray);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i8, parcel, parcel2, i9);
            }
        }
    }

    void frequentRouteTimeLine(int i8, long[] jArr) throws RemoteException;

    void predictEvent(int i8, int i9, int i10) throws RemoteException;

    void setCellInfoRptRequirementForEventPredict(int i8, int i9, int i10) throws RemoteException;

    void setCellInfoRptRequirementForFrequentRoute(List<TranCellInfo> list, int i8, int i9, int i10) throws RemoteException;

    void setDbRequirement(int i8, int i9, int i10, int i11) throws RemoteException;

    void stopReportEvent() throws RemoteException;
}
