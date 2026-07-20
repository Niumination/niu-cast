package com.transsion.tranradionet.exts.knight;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes2.dex */
public interface ITranKnightTelephony extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.tranradionet.exts.knight.ITranKnightTelephony";

    public static class Default implements ITranKnightTelephony {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public String callExtractCallInfoPurpose(String str) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public int getBlockCallStatus(String str, String str2, int i8, int i9, int i10, long j8, long j10) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public boolean getBlockSmsStatus(ByteMatrix byteMatrix, String str, int i8, boolean z2) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public int getFlashCallVer() throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public int[] getFlashMsgTimes() throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public boolean isVoDataProjectAndCloudSupport() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public void processUssdByAi(int i8, int i9, String str, ResultReceiver resultReceiver) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
        public void triggerPowerMetrics() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITranKnightTelephony {
        static final int TRANSACTION_callExtractCallInfoPurpose = 8;
        static final int TRANSACTION_getBlockCallStatus = 2;
        static final int TRANSACTION_getBlockSmsStatus = 1;
        static final int TRANSACTION_getFlashCallVer = 4;
        static final int TRANSACTION_getFlashMsgTimes = 7;
        static final int TRANSACTION_isVoDataProjectAndCloudSupport = 5;
        static final int TRANSACTION_processUssdByAi = 3;
        static final int TRANSACTION_triggerPowerMetrics = 6;

        public static class Proxy implements ITranKnightTelephony {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public String callExtractCallInfoPurpose(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public int getBlockCallStatus(String str, String str2, int i8, int i9, int i10, long j8, long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeLong(j8);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public boolean getBlockSmsStatus(ByteMatrix byteMatrix, String str, int i8, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    parcelObtain.writeTypedObject(byteMatrix, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public int getFlashCallVer() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public int[] getFlashMsgTimes() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITranKnightTelephony.DESCRIPTOR;
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public boolean isVoDataProjectAndCloudSupport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public void processUssdByAi(int i8, int i9, String str, ResultReceiver resultReceiver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str);
                    parcelObtain.writeTypedObject(resultReceiver, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.exts.knight.ITranKnightTelephony
            public void triggerPowerMetrics() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranKnightTelephony.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITranKnightTelephony.DESCRIPTOR);
        }

        public static ITranKnightTelephony asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITranKnightTelephony.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITranKnightTelephony)) ? new Proxy(iBinder) : (ITranKnightTelephony) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(ITranKnightTelephony.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(ITranKnightTelephony.DESCRIPTOR);
                return true;
            }
            switch (i8) {
                case 1:
                    ByteMatrix byteMatrix = (ByteMatrix) parcel.readTypedObject(ByteMatrix.CREATOR);
                    String string = parcel.readString();
                    int i10 = parcel.readInt();
                    boolean z2 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean blockSmsStatus = getBlockSmsStatus(byteMatrix, string, i10, z2);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(blockSmsStatus);
                    return true;
                case 2:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    int i11 = parcel.readInt();
                    int i12 = parcel.readInt();
                    int i13 = parcel.readInt();
                    long j8 = parcel.readLong();
                    long j10 = parcel.readLong();
                    parcel.enforceNoDataAvail();
                    int blockCallStatus = getBlockCallStatus(string2, string3, i11, i12, i13, j8, j10);
                    parcel2.writeNoException();
                    parcel2.writeInt(blockCallStatus);
                    return true;
                case 3:
                    int i14 = parcel.readInt();
                    int i15 = parcel.readInt();
                    String string4 = parcel.readString();
                    ResultReceiver resultReceiver = (ResultReceiver) parcel.readTypedObject(ResultReceiver.CREATOR);
                    parcel.enforceNoDataAvail();
                    processUssdByAi(i14, i15, string4, resultReceiver);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int flashCallVer = getFlashCallVer();
                    parcel2.writeNoException();
                    parcel2.writeInt(flashCallVer);
                    return true;
                case 5:
                    boolean zIsVoDataProjectAndCloudSupport = isVoDataProjectAndCloudSupport();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsVoDataProjectAndCloudSupport);
                    return true;
                case 6:
                    triggerPowerMetrics();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    int[] flashMsgTimes = getFlashMsgTimes();
                    parcel2.writeNoException();
                    parcel2.writeIntArray(flashMsgTimes);
                    return true;
                case 8:
                    String string5 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    String strCallExtractCallInfoPurpose = callExtractCallInfoPurpose(string5);
                    parcel2.writeNoException();
                    parcel2.writeString(strCallExtractCallInfoPurpose);
                    return true;
                default:
                    return super.onTransact(i8, parcel, parcel2, i9);
            }
        }
    }

    String callExtractCallInfoPurpose(String str) throws RemoteException;

    int getBlockCallStatus(String str, String str2, int i8, int i9, int i10, long j8, long j10) throws RemoteException;

    boolean getBlockSmsStatus(ByteMatrix byteMatrix, String str, int i8, boolean z2) throws RemoteException;

    int getFlashCallVer() throws RemoteException;

    int[] getFlashMsgTimes() throws RemoteException;

    boolean isVoDataProjectAndCloudSupport() throws RemoteException;

    void processUssdByAi(int i8, int i9, String str, ResultReceiver resultReceiver) throws RemoteException;

    void triggerPowerMetrics() throws RemoteException;
}
