package com.transsion.tranradionet;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import com.transsion.tranradionet.ITranRadioNetService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes2.dex */
public interface ITranRadioNetService extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.tranradionet.ITranRadioNetService";

    public static class Default implements ITranRadioNetService {
        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void addErrorInfoToDfx(String str, String str2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int barCell(int i8, int i9, int i10, int i11, int i12, int i13) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void clearFtaiCount(int i8) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void clearFtalList(int i8) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public Intent creatDualSimSwitchSettingsActivityIntent() throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int deregisterCallback(ITranRadioNetServiceCallback iTranRadioNetServiceCallback) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int dispatchNetCmd(String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int dispatchRilCmd(int i8, int i9, String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int enableDrdsda(boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int enableDsda(boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int enableEndc(int i8, boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int enableEvs(int i8, boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int enableRadio(boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int enableRatStallSelfHeal(boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int executeStrategy(int i8, int i9) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public String getHardwareInfo() throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public Map<String, String> getOverUsePkgAndBytes() throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public String getProcSysNet(int i8, int i9, String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public boolean isAcceleratedEnabled(String str) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public boolean isAppNetWorkAccelerated() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public boolean isDualSimSwitchEnabled() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public boolean isForbiddenViceCardWhenGameEnabled() throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int mqttFileChanged(String str, String str2, String str3, String str4, long j8) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int notifyBinderMultiLinkNwType(int i8, int i9, int i10) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void notifyGameSceneType(String str, int i8, int i9) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public List<String> psAttach(int i8) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public List<String> psDeAttach(int i8) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public List<String> queryBarCell(int i8, int i9) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public String queryCurrentBands(int i8, int i9) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public String queryEsimEid(int i8) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int[] queryEsimStatus(int i8) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public String querySupportBands(int i8, int i9) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public String readFileByName(String str, int i8, int i9) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int registerCallback(ITranRadioNetServiceCallback iTranRadioNetServiceCallback) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void registerForCommGameEngine(Messenger messenger) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int registerMultiLinkCallback(Messenger messenger, int i8, int i9) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void resetFtaiTimer(int i8) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int retLte(int i8, String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public List<String> sendAtCmd(int i8, String str) throws RemoteException {
            return null;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void sendImsRemainedTime(int i8, int i9) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void sendSWTPTxPowerRequest(boolean z2) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public boolean setAcceleratedEnabledByPhone(boolean z2) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int setCurrentBands(int i8, int i9, String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void setDefaultDualSimSwitchDataLimit() throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int setDualSimSwitchEnabled(boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void setForbiddenViceCardWhenGameEnabled(boolean z2) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int setImsCfg(int i8, int i9, int i10, int i11, int i12, int i13, int i14) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int setL2nrSelection(int i8) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void setProcSysNet(int i8, int i9, String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void setThreshold(long j8, long j10) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public boolean switchAppNetWorkAccelerated(boolean z2, String str) throws RemoteException {
            return false;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void switchEsimPsim(int i8, int i9) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int unbarCell(int i8, int i9, int i10, int i11, int i12, int i13) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int undoSelRatBarCells(int i8, int i9) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void unregisterForCommGameEngine(Messenger messenger) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int unregisterMultiLinkCallback() throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int updateAntennaTxPower(String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public void updateFtaiTimer(int i8, String str, int i9) throws RemoteException {
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int updateGWLmaxTxpower(String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int updateMaxTxPowerRfPara(String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int updateTxState(String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public int verifySimLockCode(String str) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.tranradionet.ITranRadioNetService
        public byte writeFileByNamevec(String str, int i8, int i9, byte[] bArr) throws RemoteException {
            return (byte) 0;
        }
    }

    public static abstract class Stub extends Binder implements ITranRadioNetService {
        static final int TRANSACTION_addErrorInfoToDfx = 42;
        static final int TRANSACTION_barCell = 15;
        static final int TRANSACTION_clearFtaiCount = 53;
        static final int TRANSACTION_clearFtalList = 54;
        static final int TRANSACTION_creatDualSimSwitchSettingsActivityIntent = 38;
        static final int TRANSACTION_deregisterCallback = 2;
        static final int TRANSACTION_dispatchNetCmd = 4;
        static final int TRANSACTION_dispatchRilCmd = 3;
        static final int TRANSACTION_enableDrdsda = 30;
        static final int TRANSACTION_enableDsda = 29;
        static final int TRANSACTION_enableEndc = 28;
        static final int TRANSACTION_enableEvs = 27;
        static final int TRANSACTION_enableRadio = 32;
        static final int TRANSACTION_enableRatStallSelfHeal = 31;
        static final int TRANSACTION_executeStrategy = 20;
        static final int TRANSACTION_getHardwareInfo = 7;
        static final int TRANSACTION_getOverUsePkgAndBytes = 48;
        static final int TRANSACTION_getProcSysNet = 9;
        static final int TRANSACTION_isAcceleratedEnabled = 45;
        static final int TRANSACTION_isAppNetWorkAccelerated = 43;
        static final int TRANSACTION_isDualSimSwitchEnabled = 35;
        static final int TRANSACTION_isForbiddenViceCardWhenGameEnabled = 39;
        static final int TRANSACTION_mqttFileChanged = 8;
        static final int TRANSACTION_notifyBinderMultiLinkNwType = 13;
        static final int TRANSACTION_notifyGameSceneType = 41;
        static final int TRANSACTION_psAttach = 26;
        static final int TRANSACTION_psDeAttach = 25;
        static final int TRANSACTION_queryBarCell = 17;
        static final int TRANSACTION_queryCurrentBands = 60;
        static final int TRANSACTION_queryEsimEid = 56;
        static final int TRANSACTION_queryEsimStatus = 55;
        static final int TRANSACTION_querySupportBands = 59;
        static final int TRANSACTION_readFileByName = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerForCommGameEngine = 33;
        static final int TRANSACTION_registerMultiLinkCallback = 11;
        static final int TRANSACTION_resetFtaiTimer = 52;
        static final int TRANSACTION_retLte = 62;
        static final int TRANSACTION_sendAtCmd = 50;
        static final int TRANSACTION_sendImsRemainedTime = 14;
        static final int TRANSACTION_sendSWTPTxPowerRequest = 58;
        static final int TRANSACTION_setAcceleratedEnabledByPhone = 46;
        static final int TRANSACTION_setCurrentBands = 61;
        static final int TRANSACTION_setDefaultDualSimSwitchDataLimit = 37;
        static final int TRANSACTION_setDualSimSwitchEnabled = 36;
        static final int TRANSACTION_setForbiddenViceCardWhenGameEnabled = 40;
        static final int TRANSACTION_setImsCfg = 19;
        static final int TRANSACTION_setL2nrSelection = 63;
        static final int TRANSACTION_setProcSysNet = 10;
        static final int TRANSACTION_setThreshold = 49;
        static final int TRANSACTION_switchAppNetWorkAccelerated = 44;
        static final int TRANSACTION_switchEsimPsim = 57;
        static final int TRANSACTION_unbarCell = 16;
        static final int TRANSACTION_undoSelRatBarCells = 18;
        static final int TRANSACTION_unregisterForCommGameEngine = 34;
        static final int TRANSACTION_unregisterMultiLinkCallback = 12;
        static final int TRANSACTION_updateAntennaTxPower = 21;
        static final int TRANSACTION_updateFtaiTimer = 51;
        static final int TRANSACTION_updateGWLmaxTxpower = 22;
        static final int TRANSACTION_updateMaxTxPowerRfPara = 23;
        static final int TRANSACTION_updateTxState = 24;
        static final int TRANSACTION_verifySimLockCode = 47;
        static final int TRANSACTION_writeFileByNamevec = 6;

        public static class Proxy implements ITranRadioNetService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getOverUsePkgAndBytes$0(Parcel parcel, Map map, int i8) {
                map.put(parcel.readString(), parcel.readString());
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void addErrorInfoToDfx(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int barCell(int i8, int i9, int i10, int i11, int i12, int i13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeInt(i13);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void clearFtaiCount(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(53, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void clearFtalList(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(54, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public Intent creatDualSimSwitchSettingsActivityIntent() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Intent) parcelObtain2.readTypedObject(Intent.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int deregisterCallback(ITranRadioNetServiceCallback iTranRadioNetServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTranRadioNetServiceCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int dispatchNetCmd(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int dispatchRilCmd(int i8, int i9, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int enableDrdsda(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int enableDsda(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int enableEndc(int i8, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int enableEvs(int i8, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int enableRadio(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int enableRatStallSelfHeal(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int executeStrategy(int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public String getHardwareInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITranRadioNetService.DESCRIPTOR;
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public Map<String, String> getOverUsePkgAndBytes() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                final Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(48, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i8 = parcelObtain2.readInt();
                    final HashMap map = i8 < 0 ? null : new HashMap();
                    IntStream.range(0, i8).forEach(new IntConsumer() { // from class: com.transsion.tranradionet.a
                        @Override // java.util.function.IntConsumer
                        public final void accept(int i9) {
                            ITranRadioNetService.Stub.Proxy.lambda$getOverUsePkgAndBytes$0(parcelObtain2, map, i9);
                        }
                    });
                    return map;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public String getProcSysNet(int i8, int i9, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public boolean isAcceleratedEnabled(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(45, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public boolean isAppNetWorkAccelerated() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(43, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public boolean isDualSimSwitchEnabled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public boolean isForbiddenViceCardWhenGameEnabled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int mqttFileChanged(String str, String str2, String str3, String str4, long j8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeLong(j8);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int notifyBinderMultiLinkNwType(int i8, int i9, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void notifyGameSceneType(String str, int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public List<String> psAttach(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public List<String> psDeAttach(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public List<String> queryBarCell(int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public String queryCurrentBands(int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(Stub.TRANSACTION_queryCurrentBands, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public String queryEsimEid(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(Stub.TRANSACTION_queryEsimEid, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int[] queryEsimStatus(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(55, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public String querySupportBands(int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(Stub.TRANSACTION_querySupportBands, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public String readFileByName(String str, int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int registerCallback(ITranRadioNetServiceCallback iTranRadioNetServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTranRadioNetServiceCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void registerForCommGameEngine(Messenger messenger) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeTypedObject(messenger, 0);
                    this.mRemote.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int registerMultiLinkCallback(Messenger messenger, int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeTypedObject(messenger, 0);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void resetFtaiTimer(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(52, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int retLte(int i8, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_retLte, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public List<String> sendAtCmd(int i8, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(50, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void sendImsRemainedTime(int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void sendSWTPTxPowerRequest(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(Stub.TRANSACTION_sendSWTPTxPowerRequest, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public boolean setAcceleratedEnabledByPhone(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(46, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int setCurrentBands(int i8, int i9, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_setCurrentBands, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void setDefaultDualSimSwitchDataLimit() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int setDualSimSwitchEnabled(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void setForbiddenViceCardWhenGameEnabled(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    this.mRemote.transact(40, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int setImsCfg(int i8, int i9, int i10, int i11, int i12, int i13, int i14) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeInt(i13);
                    parcelObtain.writeInt(i14);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int setL2nrSelection(int i8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    this.mRemote.transact(63, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void setProcSysNet(int i8, int i9, String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void setThreshold(long j8, long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeLong(j8);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(49, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public boolean switchAppNetWorkAccelerated(boolean z2, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeBoolean(z2);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(44, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void switchEsimPsim(int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(Stub.TRANSACTION_switchEsimPsim, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int unbarCell(int i8, int i9, int i10, int i11, int i12, int i13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeInt(i13);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int undoSelRatBarCells(int i8, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void unregisterForCommGameEngine(Messenger messenger) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeTypedObject(messenger, 0);
                    this.mRemote.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int unregisterMultiLinkCallback() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int updateAntennaTxPower(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public void updateFtaiTimer(int i8, String str, int i9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i9);
                    this.mRemote.transact(51, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int updateGWLmaxTxpower(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int updateMaxTxPowerRfPara(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int updateTxState(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public int verifySimLockCode(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(47, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.tranradionet.ITranRadioNetService
            public byte writeFileByNamevec(String str, int i8, int i9, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITranRadioNetService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeByteArray(bArr);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readByte();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITranRadioNetService.DESCRIPTOR);
        }

        public static ITranRadioNetService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITranRadioNetService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITranRadioNetService)) ? new Proxy(iBinder) : (ITranRadioNetService) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$0(Parcel parcel, String str, String str2) {
            parcel.writeString(str);
            parcel.writeString(str2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, final Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(ITranRadioNetService.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(ITranRadioNetService.DESCRIPTOR);
                return true;
            }
            switch (i8) {
                case 1:
                    ITranRadioNetServiceCallback iTranRadioNetServiceCallbackAsInterface = ITranRadioNetServiceCallback.Stub.asInterface(parcel.readStrongBinder());
                    parcel.enforceNoDataAvail();
                    int iRegisterCallback = registerCallback(iTranRadioNetServiceCallbackAsInterface);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRegisterCallback);
                    return true;
                case 2:
                    ITranRadioNetServiceCallback iTranRadioNetServiceCallbackAsInterface2 = ITranRadioNetServiceCallback.Stub.asInterface(parcel.readStrongBinder());
                    parcel.enforceNoDataAvail();
                    int iDeregisterCallback = deregisterCallback(iTranRadioNetServiceCallbackAsInterface2);
                    parcel2.writeNoException();
                    parcel2.writeInt(iDeregisterCallback);
                    return true;
                case 3:
                    int i10 = parcel.readInt();
                    int i11 = parcel.readInt();
                    String string = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iDispatchRilCmd = dispatchRilCmd(i10, i11, string);
                    parcel2.writeNoException();
                    parcel2.writeInt(iDispatchRilCmd);
                    return true;
                case 4:
                    String string2 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iDispatchNetCmd = dispatchNetCmd(string2);
                    parcel2.writeNoException();
                    parcel2.writeInt(iDispatchNetCmd);
                    return true;
                case 5:
                    String string3 = parcel.readString();
                    int i12 = parcel.readInt();
                    int i13 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    String fileByName = readFileByName(string3, i12, i13);
                    parcel2.writeNoException();
                    parcel2.writeString(fileByName);
                    return true;
                case 6:
                    String string4 = parcel.readString();
                    int i14 = parcel.readInt();
                    int i15 = parcel.readInt();
                    byte[] bArrCreateByteArray = parcel.createByteArray();
                    parcel.enforceNoDataAvail();
                    byte bWriteFileByNamevec = writeFileByNamevec(string4, i14, i15, bArrCreateByteArray);
                    parcel2.writeNoException();
                    parcel2.writeByte(bWriteFileByNamevec);
                    return true;
                case 7:
                    String hardwareInfo = getHardwareInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(hardwareInfo);
                    return true;
                case 8:
                    String string5 = parcel.readString();
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    String string8 = parcel.readString();
                    long j8 = parcel.readLong();
                    parcel.enforceNoDataAvail();
                    int iMqttFileChanged = mqttFileChanged(string5, string6, string7, string8, j8);
                    parcel2.writeNoException();
                    parcel2.writeInt(iMqttFileChanged);
                    return true;
                case 9:
                    int i16 = parcel.readInt();
                    int i17 = parcel.readInt();
                    String string9 = parcel.readString();
                    String string10 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    String procSysNet = getProcSysNet(i16, i17, string9, string10);
                    parcel2.writeNoException();
                    parcel2.writeString(procSysNet);
                    return true;
                case 10:
                    int i18 = parcel.readInt();
                    int i19 = parcel.readInt();
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    String string13 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    setProcSysNet(i18, i19, string11, string12, string13);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    Messenger messenger = (Messenger) parcel.readTypedObject(Messenger.CREATOR);
                    int i20 = parcel.readInt();
                    int i21 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int iRegisterMultiLinkCallback = registerMultiLinkCallback(messenger, i20, i21);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRegisterMultiLinkCallback);
                    return true;
                case 12:
                    int iUnregisterMultiLinkCallback = unregisterMultiLinkCallback();
                    parcel2.writeNoException();
                    parcel2.writeInt(iUnregisterMultiLinkCallback);
                    return true;
                case 13:
                    int i22 = parcel.readInt();
                    int i23 = parcel.readInt();
                    int i24 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int iNotifyBinderMultiLinkNwType = notifyBinderMultiLinkNwType(i22, i23, i24);
                    parcel2.writeNoException();
                    parcel2.writeInt(iNotifyBinderMultiLinkNwType);
                    return true;
                case 14:
                    int i25 = parcel.readInt();
                    int i26 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    sendImsRemainedTime(i25, i26);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    int i27 = parcel.readInt();
                    int i28 = parcel.readInt();
                    int i29 = parcel.readInt();
                    int i30 = parcel.readInt();
                    int i31 = parcel.readInt();
                    int i32 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int iBarCell = barCell(i27, i28, i29, i30, i31, i32);
                    parcel2.writeNoException();
                    parcel2.writeInt(iBarCell);
                    return true;
                case 16:
                    int i33 = parcel.readInt();
                    int i34 = parcel.readInt();
                    int i35 = parcel.readInt();
                    int i36 = parcel.readInt();
                    int i37 = parcel.readInt();
                    int i38 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int iUnbarCell = unbarCell(i33, i34, i35, i36, i37, i38);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUnbarCell);
                    return true;
                case 17:
                    int i39 = parcel.readInt();
                    int i40 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    List<String> listQueryBarCell = queryBarCell(i39, i40);
                    parcel2.writeNoException();
                    parcel2.writeStringList(listQueryBarCell);
                    return true;
                case 18:
                    int i41 = parcel.readInt();
                    int i42 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int iUndoSelRatBarCells = undoSelRatBarCells(i41, i42);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUndoSelRatBarCells);
                    return true;
                case 19:
                    int i43 = parcel.readInt();
                    int i44 = parcel.readInt();
                    int i45 = parcel.readInt();
                    int i46 = parcel.readInt();
                    int i47 = parcel.readInt();
                    int i48 = parcel.readInt();
                    int i49 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int imsCfg = setImsCfg(i43, i44, i45, i46, i47, i48, i49);
                    parcel2.writeNoException();
                    parcel2.writeInt(imsCfg);
                    return true;
                case 20:
                    int i50 = parcel.readInt();
                    int i51 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int iExecuteStrategy = executeStrategy(i50, i51);
                    parcel2.writeNoException();
                    parcel2.writeInt(iExecuteStrategy);
                    return true;
                case 21:
                    String string14 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iUpdateAntennaTxPower = updateAntennaTxPower(string14);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdateAntennaTxPower);
                    return true;
                case 22:
                    String string15 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iUpdateGWLmaxTxpower = updateGWLmaxTxpower(string15);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdateGWLmaxTxpower);
                    return true;
                case 23:
                    String string16 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iUpdateMaxTxPowerRfPara = updateMaxTxPowerRfPara(string16);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdateMaxTxPowerRfPara);
                    return true;
                case 24:
                    String string17 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iUpdateTxState = updateTxState(string17);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdateTxState);
                    return true;
                case 25:
                    int i52 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    List<String> listPsDeAttach = psDeAttach(i52);
                    parcel2.writeNoException();
                    parcel2.writeStringList(listPsDeAttach);
                    return true;
                case 26:
                    int i53 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    List<String> listPsAttach = psAttach(i53);
                    parcel2.writeNoException();
                    parcel2.writeStringList(listPsAttach);
                    return true;
                case 27:
                    int i54 = parcel.readInt();
                    boolean z2 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    int iEnableEvs = enableEvs(i54, z2);
                    parcel2.writeNoException();
                    parcel2.writeInt(iEnableEvs);
                    return true;
                case 28:
                    int i55 = parcel.readInt();
                    boolean z3 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    int iEnableEndc = enableEndc(i55, z3);
                    parcel2.writeNoException();
                    parcel2.writeInt(iEnableEndc);
                    return true;
                case 29:
                    boolean z5 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    int iEnableDsda = enableDsda(z5);
                    parcel2.writeNoException();
                    parcel2.writeInt(iEnableDsda);
                    return true;
                case 30:
                    boolean z10 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    int iEnableDrdsda = enableDrdsda(z10);
                    parcel2.writeNoException();
                    parcel2.writeInt(iEnableDrdsda);
                    return true;
                case 31:
                    boolean z11 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    int iEnableRatStallSelfHeal = enableRatStallSelfHeal(z11);
                    parcel2.writeNoException();
                    parcel2.writeInt(iEnableRatStallSelfHeal);
                    return true;
                case 32:
                    boolean z12 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    int iEnableRadio = enableRadio(z12);
                    parcel2.writeNoException();
                    parcel2.writeInt(iEnableRadio);
                    return true;
                case 33:
                    Messenger messenger2 = (Messenger) parcel.readTypedObject(Messenger.CREATOR);
                    parcel.enforceNoDataAvail();
                    registerForCommGameEngine(messenger2);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    Messenger messenger3 = (Messenger) parcel.readTypedObject(Messenger.CREATOR);
                    parcel.enforceNoDataAvail();
                    unregisterForCommGameEngine(messenger3);
                    parcel2.writeNoException();
                    return true;
                case 35:
                    boolean zIsDualSimSwitchEnabled = isDualSimSwitchEnabled();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsDualSimSwitchEnabled);
                    return true;
                case 36:
                    boolean z13 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    int dualSimSwitchEnabled = setDualSimSwitchEnabled(z13);
                    parcel2.writeNoException();
                    parcel2.writeInt(dualSimSwitchEnabled);
                    return true;
                case 37:
                    setDefaultDualSimSwitchDataLimit();
                    parcel2.writeNoException();
                    return true;
                case 38:
                    Intent intentCreatDualSimSwitchSettingsActivityIntent = creatDualSimSwitchSettingsActivityIntent();
                    parcel2.writeNoException();
                    parcel2.writeTypedObject(intentCreatDualSimSwitchSettingsActivityIntent, 1);
                    return true;
                case 39:
                    boolean zIsForbiddenViceCardWhenGameEnabled = isForbiddenViceCardWhenGameEnabled();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsForbiddenViceCardWhenGameEnabled);
                    return true;
                case 40:
                    boolean z14 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    setForbiddenViceCardWhenGameEnabled(z14);
                    parcel2.writeNoException();
                    return true;
                case 41:
                    String string18 = parcel.readString();
                    int i56 = parcel.readInt();
                    int i57 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    notifyGameSceneType(string18, i56, i57);
                    parcel2.writeNoException();
                    return true;
                case 42:
                    String string19 = parcel.readString();
                    String string20 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    addErrorInfoToDfx(string19, string20);
                    parcel2.writeNoException();
                    return true;
                case 43:
                    boolean zIsAppNetWorkAccelerated = isAppNetWorkAccelerated();
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsAppNetWorkAccelerated);
                    return true;
                case 44:
                    boolean z15 = parcel.readBoolean();
                    String string21 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    boolean zSwitchAppNetWorkAccelerated = switchAppNetWorkAccelerated(z15, string21);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zSwitchAppNetWorkAccelerated);
                    return true;
                case 45:
                    String string22 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    boolean zIsAcceleratedEnabled = isAcceleratedEnabled(string22);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(zIsAcceleratedEnabled);
                    return true;
                case 46:
                    boolean z16 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean acceleratedEnabledByPhone = setAcceleratedEnabledByPhone(z16);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(acceleratedEnabledByPhone);
                    return true;
                case 47:
                    String string23 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iVerifySimLockCode = verifySimLockCode(string23);
                    parcel2.writeNoException();
                    parcel2.writeInt(iVerifySimLockCode);
                    return true;
                case 48:
                    Map<String, String> overUsePkgAndBytes = getOverUsePkgAndBytes();
                    parcel2.writeNoException();
                    if (overUsePkgAndBytes == null) {
                        parcel2.writeInt(-1);
                    } else {
                        parcel2.writeInt(overUsePkgAndBytes.size());
                        overUsePkgAndBytes.forEach(new BiConsumer() { // from class: cd.a
                            @Override // java.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                ITranRadioNetService.Stub.lambda$onTransact$0(parcel2, (String) obj, (String) obj2);
                            }
                        });
                    }
                    return true;
                case 49:
                    long j10 = parcel.readLong();
                    long j11 = parcel.readLong();
                    parcel.enforceNoDataAvail();
                    setThreshold(j10, j11);
                    parcel2.writeNoException();
                    return true;
                case 50:
                    int i58 = parcel.readInt();
                    String string24 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    List<String> listSendAtCmd = sendAtCmd(i58, string24);
                    parcel2.writeNoException();
                    parcel2.writeStringList(listSendAtCmd);
                    return true;
                case 51:
                    int i59 = parcel.readInt();
                    String string25 = parcel.readString();
                    int i60 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    updateFtaiTimer(i59, string25, i60);
                    parcel2.writeNoException();
                    return true;
                case 52:
                    int i61 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    resetFtaiTimer(i61);
                    parcel2.writeNoException();
                    return true;
                case 53:
                    int i62 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    clearFtaiCount(i62);
                    parcel2.writeNoException();
                    return true;
                case 54:
                    int i63 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    clearFtalList(i63);
                    parcel2.writeNoException();
                    return true;
                case 55:
                    int i64 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int[] iArrQueryEsimStatus = queryEsimStatus(i64);
                    parcel2.writeNoException();
                    parcel2.writeIntArray(iArrQueryEsimStatus);
                    return true;
                case TRANSACTION_queryEsimEid /* 56 */:
                    int i65 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    String strQueryEsimEid = queryEsimEid(i65);
                    parcel2.writeNoException();
                    parcel2.writeString(strQueryEsimEid);
                    return true;
                case TRANSACTION_switchEsimPsim /* 57 */:
                    int i66 = parcel.readInt();
                    int i67 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    switchEsimPsim(i66, i67);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_sendSWTPTxPowerRequest /* 58 */:
                    boolean z17 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    sendSWTPTxPowerRequest(z17);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_querySupportBands /* 59 */:
                    int i68 = parcel.readInt();
                    int i69 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    String strQuerySupportBands = querySupportBands(i68, i69);
                    parcel2.writeNoException();
                    parcel2.writeString(strQuerySupportBands);
                    return true;
                case TRANSACTION_queryCurrentBands /* 60 */:
                    int i70 = parcel.readInt();
                    int i71 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    String strQueryCurrentBands = queryCurrentBands(i70, i71);
                    parcel2.writeNoException();
                    parcel2.writeString(strQueryCurrentBands);
                    return true;
                case TRANSACTION_setCurrentBands /* 61 */:
                    int i72 = parcel.readInt();
                    int i73 = parcel.readInt();
                    String string26 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int currentBands = setCurrentBands(i72, i73, string26);
                    parcel2.writeNoException();
                    parcel2.writeInt(currentBands);
                    return true;
                case TRANSACTION_retLte /* 62 */:
                    int i74 = parcel.readInt();
                    String string27 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    int iRetLte = retLte(i74, string27);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRetLte);
                    return true;
                case 63:
                    int i75 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    int l2nrSelection = setL2nrSelection(i75);
                    parcel2.writeNoException();
                    parcel2.writeInt(l2nrSelection);
                    return true;
                default:
                    return super.onTransact(i8, parcel, parcel2, i9);
            }
        }
    }

    void addErrorInfoToDfx(String str, String str2) throws RemoteException;

    int barCell(int i8, int i9, int i10, int i11, int i12, int i13) throws RemoteException;

    void clearFtaiCount(int i8) throws RemoteException;

    void clearFtalList(int i8) throws RemoteException;

    Intent creatDualSimSwitchSettingsActivityIntent() throws RemoteException;

    int deregisterCallback(ITranRadioNetServiceCallback iTranRadioNetServiceCallback) throws RemoteException;

    int dispatchNetCmd(String str) throws RemoteException;

    int dispatchRilCmd(int i8, int i9, String str) throws RemoteException;

    int enableDrdsda(boolean z2) throws RemoteException;

    int enableDsda(boolean z2) throws RemoteException;

    int enableEndc(int i8, boolean z2) throws RemoteException;

    int enableEvs(int i8, boolean z2) throws RemoteException;

    int enableRadio(boolean z2) throws RemoteException;

    int enableRatStallSelfHeal(boolean z2) throws RemoteException;

    int executeStrategy(int i8, int i9) throws RemoteException;

    String getHardwareInfo() throws RemoteException;

    Map<String, String> getOverUsePkgAndBytes() throws RemoteException;

    String getProcSysNet(int i8, int i9, String str, String str2) throws RemoteException;

    boolean isAcceleratedEnabled(String str) throws RemoteException;

    boolean isAppNetWorkAccelerated() throws RemoteException;

    boolean isDualSimSwitchEnabled() throws RemoteException;

    boolean isForbiddenViceCardWhenGameEnabled() throws RemoteException;

    int mqttFileChanged(String str, String str2, String str3, String str4, long j8) throws RemoteException;

    int notifyBinderMultiLinkNwType(int i8, int i9, int i10) throws RemoteException;

    void notifyGameSceneType(String str, int i8, int i9) throws RemoteException;

    List<String> psAttach(int i8) throws RemoteException;

    List<String> psDeAttach(int i8) throws RemoteException;

    List<String> queryBarCell(int i8, int i9) throws RemoteException;

    String queryCurrentBands(int i8, int i9) throws RemoteException;

    String queryEsimEid(int i8) throws RemoteException;

    int[] queryEsimStatus(int i8) throws RemoteException;

    String querySupportBands(int i8, int i9) throws RemoteException;

    String readFileByName(String str, int i8, int i9) throws RemoteException;

    int registerCallback(ITranRadioNetServiceCallback iTranRadioNetServiceCallback) throws RemoteException;

    void registerForCommGameEngine(Messenger messenger) throws RemoteException;

    int registerMultiLinkCallback(Messenger messenger, int i8, int i9) throws RemoteException;

    void resetFtaiTimer(int i8) throws RemoteException;

    int retLte(int i8, String str) throws RemoteException;

    List<String> sendAtCmd(int i8, String str) throws RemoteException;

    void sendImsRemainedTime(int i8, int i9) throws RemoteException;

    void sendSWTPTxPowerRequest(boolean z2) throws RemoteException;

    boolean setAcceleratedEnabledByPhone(boolean z2) throws RemoteException;

    int setCurrentBands(int i8, int i9, String str) throws RemoteException;

    void setDefaultDualSimSwitchDataLimit() throws RemoteException;

    int setDualSimSwitchEnabled(boolean z2) throws RemoteException;

    void setForbiddenViceCardWhenGameEnabled(boolean z2) throws RemoteException;

    int setImsCfg(int i8, int i9, int i10, int i11, int i12, int i13, int i14) throws RemoteException;

    int setL2nrSelection(int i8) throws RemoteException;

    void setProcSysNet(int i8, int i9, String str, String str2, String str3) throws RemoteException;

    void setThreshold(long j8, long j10) throws RemoteException;

    boolean switchAppNetWorkAccelerated(boolean z2, String str) throws RemoteException;

    void switchEsimPsim(int i8, int i9) throws RemoteException;

    int unbarCell(int i8, int i9, int i10, int i11, int i12, int i13) throws RemoteException;

    int undoSelRatBarCells(int i8, int i9) throws RemoteException;

    void unregisterForCommGameEngine(Messenger messenger) throws RemoteException;

    int unregisterMultiLinkCallback() throws RemoteException;

    int updateAntennaTxPower(String str) throws RemoteException;

    void updateFtaiTimer(int i8, String str, int i9) throws RemoteException;

    int updateGWLmaxTxpower(String str) throws RemoteException;

    int updateMaxTxPowerRfPara(String str) throws RemoteException;

    int updateTxState(String str) throws RemoteException;

    int verifySimLockCode(String str) throws RemoteException;

    byte writeFileByNamevec(String str, int i8, int i9, byte[] bArr) throws RemoteException;
}
