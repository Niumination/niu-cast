package com.transsion.tranradionet.tce;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ITceService extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.tranradionet.tce.ITceService";

    public static class Default implements ITceService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean clearSensorTestData() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean clearTestData() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public String getCurrentMemoryInfo(int i8) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public int getCurrentPid() throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public String getDebugInfo() throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public int getDetectorStatus(int i8) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public String getTsnProcessMemoryInfo() throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public int injectLocations(String[] strArr, Location[] locationArr) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean injectTestLocation(String str, Location location) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean injectTestSensorData(int i8, float[] fArr, int i9, long j8) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean injectTestSensorDataSimple(int i8, float[] fArr) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean injectTestSensorDataWithAccuracy(int i8, float[] fArr, int i9) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean injectTestTceEvent(TceEvent tceEvent) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public int injectTestTceEvents(TceEvent[] tceEventArr) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean isDetectorAvailable(int i8) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean isLocationTestEnable() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean isSensorTestModeEnabled() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean isTestModeEnabled() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean queryChargeGeofence(Messenger messenger) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean registerForSensor(ITceCallback iTceCallback, int i8, int i9) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public int registerTceCallback(ITceCallback iTceCallback, int[] iArr, Bundle bundle, String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean setLocationInjectionEnabled(boolean z2) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean setSensorTestModeEnabled(boolean z2) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean setTestModeEnabled(boolean z2) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public boolean unregisterForSensor(ITceCallback iTceCallback, int i8) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.tce.ITceService
        public int unregisterTceCallback(ITceCallback iTceCallback, int[] iArr) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ITceService {
        static final int TRANSACTION_clearSensorTestData = 15;
        static final int TRANSACTION_clearTestData = 14;
        static final int TRANSACTION_getCurrentMemoryInfo = 21;
        static final int TRANSACTION_getCurrentPid = 20;
        static final int TRANSACTION_getDebugInfo = 1;
        static final int TRANSACTION_getDetectorStatus = 18;
        static final int TRANSACTION_getTsnProcessMemoryInfo = 22;
        static final int TRANSACTION_injectLocations = 25;
        static final int TRANSACTION_injectTestLocation = 23;
        static final int TRANSACTION_injectTestSensorData = 8;
        static final int TRANSACTION_injectTestSensorDataSimple = 10;
        static final int TRANSACTION_injectTestSensorDataWithAccuracy = 9;
        static final int TRANSACTION_injectTestTceEvent = 6;
        static final int TRANSACTION_injectTestTceEvents = 7;
        static final int TRANSACTION_isDetectorAvailable = 17;
        static final int TRANSACTION_isLocationTestEnable = 26;
        static final int TRANSACTION_isSensorTestModeEnabled = 13;
        static final int TRANSACTION_isTestModeEnabled = 16;
        static final int TRANSACTION_queryChargeGeofence = 19;
        static final int TRANSACTION_registerForSensor = 4;
        static final int TRANSACTION_registerTceCallback = 2;
        static final int TRANSACTION_setLocationInjectionEnabled = 24;
        static final int TRANSACTION_setSensorTestModeEnabled = 12;
        static final int TRANSACTION_setTestModeEnabled = 11;
        static final int TRANSACTION_unregisterForSensor = 5;
        static final int TRANSACTION_unregisterTceCallback = 3;

        public static class Proxy implements ITceService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean clearSensorTestData() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean clearTestData() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public String getCurrentMemoryInfo(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public int getCurrentPid() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public String getDebugInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public int getDetectorStatus(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITceService.DESCRIPTOR;
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public String getTsnProcessMemoryInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public int injectLocations(String[] strArr, Location[] locationArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeTypedArray(locationArr, 0);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean injectTestLocation(String str, Location location) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeTypedObject(location, 0);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean injectTestSensorData(int i8, float[] fArr, int i9, long j8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeFloatArray(fArr);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeLong(j8);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean injectTestSensorDataSimple(int i8, float[] fArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeFloatArray(fArr);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean injectTestSensorDataWithAccuracy(int i8, float[] fArr, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeFloatArray(fArr);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean injectTestTceEvent(TceEvent tceEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeTypedObject(tceEvent, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public int injectTestTceEvents(TceEvent[] tceEventArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeTypedArray(tceEventArr, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean isDetectorAvailable(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean isLocationTestEnable() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean isSensorTestModeEnabled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean isTestModeEnabled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean queryChargeGeofence(Messenger messenger) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeTypedObject(messenger, 0);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean registerForSensor(ITceCallback iTceCallback, int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTceCallback);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public int registerTceCallback(ITceCallback iTceCallback, int[] iArr, Bundle bundle, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTceCallback);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeTypedObject(bundle, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean setLocationInjectionEnabled(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean setSensorTestModeEnabled(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean setTestModeEnabled(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public boolean unregisterForSensor(ITceCallback iTceCallback, int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTceCallback);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.tce.ITceService
            public int unregisterTceCallback(ITceCallback iTceCallback, int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITceService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTceCallback);
                    parcelObtain.writeIntArray(iArr);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITceService.DESCRIPTOR);
        }

        public static ITceService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITceService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITceService)) ? new Proxy(iBinder) : (ITceService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(ITceService.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(ITceService.DESCRIPTOR);
                return true;
            }
            switch (i8) {
                case 1:
                    String debugInfo = getDebugInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(debugInfo);
                    return true;
                case 2:
                    ITceCallback iTceCallbackAsInterface = ITceCallback.Stub.asInterface(parcel.readStrongBinder());
                    int[] iArrCreateIntArray = parcel.createIntArray();
                    Bundle bundle = (Bundle) parcel.readTypedObject(Bundle.CREATOR);
                    String string = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iRegisterTceCallback = registerTceCallback(iTceCallbackAsInterface, iArrCreateIntArray, bundle, string);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRegisterTceCallback);
                    return true;
                case 3:
                    ITceCallback iTceCallbackAsInterface2 = ITceCallback.Stub.asInterface(parcel.readStrongBinder());
                    int[] iArrCreateIntArray2 = parcel.createIntArray();
                    parcel.enforceNoDataAvail();
                    int iUnregisterTceCallback = unregisterTceCallback(iTceCallbackAsInterface2, iArrCreateIntArray2);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUnregisterTceCallback);
                    return true;
                case 4:
                    ITceCallback iTceCallbackAsInterface3 = ITceCallback.Stub.asInterface(parcel.readStrongBinder());
                    int i10 = parcel.readInt();
                    int i11 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean zRegisterForSensor = registerForSensor(iTceCallbackAsInterface3, i10, i11);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zRegisterForSensor);
                    return true;
                case 5:
                    ITceCallback iTceCallbackAsInterface4 = ITceCallback.Stub.asInterface(parcel.readStrongBinder());
                    int i12 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean zUnregisterForSensor = unregisterForSensor(iTceCallbackAsInterface4, i12);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zUnregisterForSensor);
                    return true;
                case 6:
                    TceEvent tceEvent = (TceEvent) parcel.readTypedObject(TceEvent.CREATOR);
                    parcel.enforceNoDataAvail();
                    boolean zInjectTestTceEvent = injectTestTceEvent(tceEvent);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zInjectTestTceEvent);
                    return true;
                case 7:
                    TceEvent[] tceEventArr = (TceEvent[]) parcel.createTypedArray(TceEvent.CREATOR);
                    parcel.enforceNoDataAvail();
                    int iInjectTestTceEvents = injectTestTceEvents(tceEventArr);
                    parcel2.writeNoException();
                    parcel2.writeInt(iInjectTestTceEvents);
                    return true;
                case 8:
                    int i13 = parcel.readInt();
                    float[] fArrCreateFloatArray = parcel.createFloatArray();
                    int i14 = parcel.readInt();
                    long j8 = parcel.readLong();
                    parcel.enforceNoDataAvail();
                    boolean zInjectTestSensorData = injectTestSensorData(i13, fArrCreateFloatArray, i14, j8);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zInjectTestSensorData);
                    return true;
                case 9:
                    int i15 = parcel.readInt();
                    float[] fArrCreateFloatArray2 = parcel.createFloatArray();
                    int i16 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean zInjectTestSensorDataWithAccuracy = injectTestSensorDataWithAccuracy(i15, fArrCreateFloatArray2, i16);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zInjectTestSensorDataWithAccuracy);
                    return true;
                case 10:
                    int i17 = parcel.readInt();
                    float[] fArrCreateFloatArray3 = parcel.createFloatArray();
                    parcel.enforceNoDataAvail();
                    boolean zInjectTestSensorDataSimple = injectTestSensorDataSimple(i17, fArrCreateFloatArray3);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zInjectTestSensorDataSimple);
                    return true;
                case 11:
                    boolean z2 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean testModeEnabled = setTestModeEnabled(z2);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(testModeEnabled);
                    return true;
                case 12:
                    boolean z3 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean sensorTestModeEnabled = setSensorTestModeEnabled(z3);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(sensorTestModeEnabled);
                    return true;
                case 13:
                    boolean zIsSensorTestModeEnabled = isSensorTestModeEnabled();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsSensorTestModeEnabled);
                    return true;
                case 14:
                    boolean zClearTestData = clearTestData();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zClearTestData);
                    return true;
                case 15:
                    boolean zClearSensorTestData = clearSensorTestData();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zClearSensorTestData);
                    return true;
                case 16:
                    boolean zIsTestModeEnabled = isTestModeEnabled();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsTestModeEnabled);
                    return true;
                case 17:
                    int i18 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean zIsDetectorAvailable = isDetectorAvailable(i18);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsDetectorAvailable);
                    return true;
                case 18:
                    int i19 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int detectorStatus = getDetectorStatus(i19);
                    parcel2.writeNoException();
                    parcel2.writeInt(detectorStatus);
                    return true;
                case 19:
                    Messenger messenger = (Messenger) parcel.readTypedObject(Messenger.CREATOR);
                    parcel.enforceNoDataAvail();
                    boolean zQueryChargeGeofence = queryChargeGeofence(messenger);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zQueryChargeGeofence);
                    return true;
                case 20:
                    int currentPid = getCurrentPid();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentPid);
                    return true;
                case 21:
                    int i20 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    String currentMemoryInfo = getCurrentMemoryInfo(i20);
                    parcel2.writeNoException();
                    parcel2.writeString(currentMemoryInfo);
                    return true;
                case 22:
                    String tsnProcessMemoryInfo = getTsnProcessMemoryInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(tsnProcessMemoryInfo);
                    return true;
                case 23:
                    String string2 = parcel.readString();
                    Location location = (Location) parcel.readTypedObject(Location.CREATOR);
                    parcel.enforceNoDataAvail();
                    boolean zInjectTestLocation = injectTestLocation(string2, location);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zInjectTestLocation);
                    return true;
                case 24:
                    boolean z5 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean locationInjectionEnabled = setLocationInjectionEnabled(z5);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(locationInjectionEnabled);
                    return true;
                case 25:
                    String[] strArrCreateStringArray = parcel.createStringArray();
                    Location[] locationArr = (Location[]) parcel.createTypedArray(Location.CREATOR);
                    parcel.enforceNoDataAvail();
                    int iInjectLocations = injectLocations(strArrCreateStringArray, locationArr);
                    parcel2.writeNoException();
                    parcel2.writeInt(iInjectLocations);
                    return true;
                case 26:
                    boolean zIsLocationTestEnable = isLocationTestEnable();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsLocationTestEnable);
                    return true;
                default:
                    return super.onTransact(i8, parcel, parcel2, i9);
            }
        }
    }

    boolean clearSensorTestData() throws RemoteException;

    boolean clearTestData() throws RemoteException;

    String getCurrentMemoryInfo(int i8) throws RemoteException;

    int getCurrentPid() throws RemoteException;

    String getDebugInfo() throws RemoteException;

    int getDetectorStatus(int i8) throws RemoteException;

    String getTsnProcessMemoryInfo() throws RemoteException;

    int injectLocations(String[] strArr, Location[] locationArr) throws RemoteException;

    boolean injectTestLocation(String str, Location location) throws RemoteException;

    boolean injectTestSensorData(int i8, float[] fArr, int i9, long j8) throws RemoteException;

    boolean injectTestSensorDataSimple(int i8, float[] fArr) throws RemoteException;

    boolean injectTestSensorDataWithAccuracy(int i8, float[] fArr, int i9) throws RemoteException;

    boolean injectTestTceEvent(TceEvent tceEvent) throws RemoteException;

    int injectTestTceEvents(TceEvent[] tceEventArr) throws RemoteException;

    boolean isDetectorAvailable(int i8) throws RemoteException;

    boolean isLocationTestEnable() throws RemoteException;

    boolean isSensorTestModeEnabled() throws RemoteException;

    boolean isTestModeEnabled() throws RemoteException;

    boolean queryChargeGeofence(Messenger messenger) throws RemoteException;

    boolean registerForSensor(ITceCallback iTceCallback, int i8, int i9) throws RemoteException;

    int registerTceCallback(ITceCallback iTceCallback, int[] iArr, Bundle bundle, String str) throws RemoteException;

    boolean setLocationInjectionEnabled(boolean z2) throws RemoteException;

    boolean setSensorTestModeEnabled(boolean z2) throws RemoteException;

    boolean setTestModeEnabled(boolean z2) throws RemoteException;

    boolean unregisterForSensor(ITceCallback iTceCallback, int i8) throws RemoteException;

    int unregisterTceCallback(ITceCallback iTceCallback, int[] iArr) throws RemoteException;
}
