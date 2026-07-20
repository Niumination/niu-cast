package com.transsion.connectx.sdk;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ITCCPSourceApi extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.connectx.sdk.ITCCPSourceApi";

    public static class Default implements ITCCPSourceApi {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void cancelBackup(long j10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void cancelFileTransfer() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean castActivity(String str, int i10) throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean castActivityByImplicitStart(Intent intent, VideoConfig videoConfig) throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean castActivityInNewDisplay(String str, VideoConfig videoConfig) throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean castAudio() throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean castExtendScreen() throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean castMainScreen() throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public List<String> checkServicePermission() throws RemoteException {
            return null;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void closeExtendScreen() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean closeMainScreen() throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void confirmReceiveFile(List<String> list, String str, boolean z10, String str2, String str3) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void connectTccpServer(String str, int i10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void disconnectTccpServer() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void enableFeature(String str, boolean z10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void enableFeatures(List<String> list, boolean z10) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void executeAction(String str, String str2) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public int getTCCPStatus() throws RemoteException {
            return 0;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean isMotionControlByPc(long j10) throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void recordPeerDeviceMac(String str) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerAudioListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerBackupAuthListener(BackupAuthListener backupAuthListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerBackupFileListener(BackupFileListener backupFileListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerCapabilityLinstner(ICapabilityListener iCapabilityListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerCastExtendListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerExtendScreenListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerReceiveFileListener(String str, ReceiveFileTransferListener receiveFileTransferListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerSendFileListener(String str, SendFileTransferListener sendFileTransferListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerTCCPListener(String str, TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void registerVideoListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void responseAuth(boolean z10, boolean z11) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void sendFile(List<String> list, int i10, String str, String str2) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void setConnectDeviceInfo(DeviceInfo deviceInfo) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void startExtendScreen() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public int startTCCPServer(int i10) throws RemoteException {
            return 0;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void stopAllCastAudio() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void stopAllCastVideo() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void stopTCCPServer() throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void syncClipText(String str) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public boolean syncFileInfoRequest(FileInfoSyncRequest fileInfoSyncRequest) throws RemoteException {
            return false;
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterAudioListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterBackupAuthListener(BackupAuthListener backupAuthListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterBackupFileListener(BackupFileListener backupFileListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterCastExtendListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterExtendScreenListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterReceiveFileListener(ReceiveFileTransferListener receiveFileTransferListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterSendFileListener(SendFileTransferListener sendFileTransferListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterTCCPListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void unregisterVideoListener(TCCPListener tCCPListener) throws RemoteException {
        }

        @Override // com.transsion.connectx.sdk.ITCCPSourceApi
        public void updateMirrorWindowPoint(int i10, int i11) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITCCPSourceApi {
        static final int TRANSACTION_cancelBackup = 44;
        static final int TRANSACTION_cancelFileTransfer = 25;
        static final int TRANSACTION_castActivity = 13;
        static final int TRANSACTION_castActivityByImplicitStart = 16;
        static final int TRANSACTION_castActivityInNewDisplay = 12;
        static final int TRANSACTION_castAudio = 9;
        static final int TRANSACTION_castExtendScreen = 7;
        static final int TRANSACTION_castMainScreen = 5;
        static final int TRANSACTION_checkServicePermission = 17;
        static final int TRANSACTION_closeExtendScreen = 28;
        static final int TRANSACTION_closeMainScreen = 6;
        static final int TRANSACTION_confirmReceiveFile = 23;
        static final int TRANSACTION_connectTccpServer = 47;
        static final int TRANSACTION_disconnectTccpServer = 8;
        static final int TRANSACTION_enableFeature = 10;
        static final int TRANSACTION_enableFeatures = 11;
        static final int TRANSACTION_executeAction = 50;
        static final int TRANSACTION_getTCCPStatus = 4;
        static final int TRANSACTION_isMotionControlByPc = 24;
        static final int TRANSACTION_recordPeerDeviceMac = 46;
        static final int TRANSACTION_registerAudioListener = 39;
        static final int TRANSACTION_registerBackupAuthListener = 42;
        static final int TRANSACTION_registerBackupFileListener = 40;
        static final int TRANSACTION_registerCapabilityLinstner = 49;
        static final int TRANSACTION_registerCastExtendListener = 35;
        static final int TRANSACTION_registerExtendScreenListener = 37;
        static final int TRANSACTION_registerReceiveFileListener = 19;
        static final int TRANSACTION_registerSendFileListener = 21;
        static final int TRANSACTION_registerTCCPListener = 14;
        static final int TRANSACTION_registerVideoListener = 34;
        static final int TRANSACTION_responseAuth = 45;
        static final int TRANSACTION_sendFile = 18;
        static final int TRANSACTION_setConnectDeviceInfo = 26;
        static final int TRANSACTION_startExtendScreen = 27;
        static final int TRANSACTION_startTCCPServer = 1;
        static final int TRANSACTION_stopAllCastAudio = 30;
        static final int TRANSACTION_stopAllCastVideo = 29;
        static final int TRANSACTION_stopTCCPServer = 2;
        static final int TRANSACTION_syncClipText = 31;
        static final int TRANSACTION_syncFileInfoRequest = 3;
        static final int TRANSACTION_unregisterAudioListener = 33;
        static final int TRANSACTION_unregisterBackupAuthListener = 43;
        static final int TRANSACTION_unregisterBackupFileListener = 41;
        static final int TRANSACTION_unregisterCastExtendListener = 36;
        static final int TRANSACTION_unregisterExtendScreenListener = 38;
        static final int TRANSACTION_unregisterReceiveFileListener = 20;
        static final int TRANSACTION_unregisterSendFileListener = 22;
        static final int TRANSACTION_unregisterTCCPListener = 15;
        static final int TRANSACTION_unregisterVideoListener = 32;
        static final int TRANSACTION_updateMirrorWindowPoint = 48;

        public static class Proxy implements ITCCPSourceApi {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void cancelBackup(long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(44, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void cancelFileTransfer() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean castActivity(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean castActivityByImplicitStart(Intent intent, VideoConfig videoConfig) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, intent, 0);
                    _Parcel.writeTypedObject(parcelObtain, videoConfig, 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean castActivityInNewDisplay(String str, VideoConfig videoConfig) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, videoConfig, 0);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean castAudio() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean castExtendScreen() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean castMainScreen() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public List<String> checkServicePermission() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void closeExtendScreen() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean closeMainScreen() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void confirmReceiveFile(List<String> list, String str, boolean z10, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void connectTccpServer(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(47, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void disconnectTccpServer() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void enableFeature(String str, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void enableFeatures(List<String> list, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void executeAction(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(50, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITCCPSourceApi.DESCRIPTOR;
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public int getTCCPStatus() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean isMotionControlByPc(long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void recordPeerDeviceMac(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(46, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerAudioListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerBackupAuthListener(BackupAuthListener backupAuthListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(backupAuthListener);
                    this.mRemote.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerBackupFileListener(BackupFileListener backupFileListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(backupFileListener);
                    this.mRemote.transact(40, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerCapabilityLinstner(ICapabilityListener iCapabilityListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iCapabilityListener);
                    this.mRemote.transact(49, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerCastExtendListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerExtendScreenListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerReceiveFileListener(String str, ReceiveFileTransferListener receiveFileTransferListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(receiveFileTransferListener);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerSendFileListener(String str, SendFileTransferListener sendFileTransferListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(sendFileTransferListener);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerTCCPListener(String str, TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void registerVideoListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void responseAuth(boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(45, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void sendFile(List<String> list, int i10, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void setConnectDeviceInfo(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, deviceInfo, 0);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void startExtendScreen() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public int startTCCPServer(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void stopAllCastAudio() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void stopAllCastVideo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void stopTCCPServer() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void syncClipText(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public boolean syncFileInfoRequest(FileInfoSyncRequest fileInfoSyncRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, fileInfoSyncRequest, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterAudioListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterBackupAuthListener(BackupAuthListener backupAuthListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(backupAuthListener);
                    this.mRemote.transact(43, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterBackupFileListener(BackupFileListener backupFileListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(backupFileListener);
                    this.mRemote.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterCastExtendListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterExtendScreenListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterReceiveFileListener(ReceiveFileTransferListener receiveFileTransferListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(receiveFileTransferListener);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterSendFileListener(SendFileTransferListener sendFileTransferListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(sendFileTransferListener);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterTCCPListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void unregisterVideoListener(TCCPListener tCCPListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(tCCPListener);
                    this.mRemote.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.connectx.sdk.ITCCPSourceApi
            public void updateMirrorWindowPoint(int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITCCPSourceApi.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(48, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITCCPSourceApi.DESCRIPTOR);
        }

        public static ITCCPSourceApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITCCPSourceApi.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITCCPSourceApi)) ? new Proxy(iBinder) : (ITCCPSourceApi) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ITCCPSourceApi.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ITCCPSourceApi.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    int iStartTCCPServer = startTCCPServer(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iStartTCCPServer);
                    return true;
                case 2:
                    stopTCCPServer();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    boolean zSyncFileInfoRequest = syncFileInfoRequest((FileInfoSyncRequest) _Parcel.readTypedObject(parcel, FileInfoSyncRequest.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zSyncFileInfoRequest ? 1 : 0);
                    return true;
                case 4:
                    int tCCPStatus = getTCCPStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(tCCPStatus);
                    return true;
                case 5:
                    boolean zCastMainScreen = castMainScreen();
                    parcel2.writeNoException();
                    parcel2.writeInt(zCastMainScreen ? 1 : 0);
                    return true;
                case 6:
                    boolean zCloseMainScreen = closeMainScreen();
                    parcel2.writeNoException();
                    parcel2.writeInt(zCloseMainScreen ? 1 : 0);
                    return true;
                case 7:
                    boolean zCastExtendScreen = castExtendScreen();
                    parcel2.writeNoException();
                    parcel2.writeInt(zCastExtendScreen ? 1 : 0);
                    return true;
                case 8:
                    disconnectTccpServer();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    boolean zCastAudio = castAudio();
                    parcel2.writeNoException();
                    parcel2.writeInt(zCastAudio ? 1 : 0);
                    return true;
                case 10:
                    enableFeature(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    enableFeatures(parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    boolean zCastActivityInNewDisplay = castActivityInNewDisplay(parcel.readString(), (VideoConfig) _Parcel.readTypedObject(parcel, VideoConfig.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zCastActivityInNewDisplay ? 1 : 0);
                    return true;
                case 13:
                    boolean zCastActivity = castActivity(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCastActivity ? 1 : 0);
                    return true;
                case 14:
                    registerTCCPListener(parcel.readString(), TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    unregisterTCCPListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    boolean zCastActivityByImplicitStart = castActivityByImplicitStart((Intent) _Parcel.readTypedObject(parcel, Intent.CREATOR), (VideoConfig) _Parcel.readTypedObject(parcel, VideoConfig.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zCastActivityByImplicitStart ? 1 : 0);
                    return true;
                case 17:
                    List<String> listCheckServicePermission = checkServicePermission();
                    parcel2.writeNoException();
                    parcel2.writeStringList(listCheckServicePermission);
                    return true;
                case 18:
                    sendFile(parcel.createStringArrayList(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    registerReceiveFileListener(parcel.readString(), ReceiveFileTransferListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    unregisterReceiveFileListener(ReceiveFileTransferListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    registerSendFileListener(parcel.readString(), SendFileTransferListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    unregisterSendFileListener(SendFileTransferListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    confirmReceiveFile(parcel.createStringArrayList(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean zIsMotionControlByPc = isMotionControlByPc(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsMotionControlByPc ? 1 : 0);
                    return true;
                case 25:
                    cancelFileTransfer();
                    parcel2.writeNoException();
                    return true;
                case 26:
                    setConnectDeviceInfo((DeviceInfo) _Parcel.readTypedObject(parcel, DeviceInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    startExtendScreen();
                    parcel2.writeNoException();
                    return true;
                case 28:
                    closeExtendScreen();
                    parcel2.writeNoException();
                    return true;
                case 29:
                    stopAllCastVideo();
                    parcel2.writeNoException();
                    return true;
                case 30:
                    stopAllCastAudio();
                    parcel2.writeNoException();
                    return true;
                case 31:
                    syncClipText(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    unregisterVideoListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    unregisterAudioListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    registerVideoListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    registerCastExtendListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    unregisterCastExtendListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    registerExtendScreenListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    unregisterExtendScreenListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 39:
                    registerAudioListener(TCCPListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    registerBackupFileListener(BackupFileListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    unregisterBackupFileListener(BackupFileListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    registerBackupAuthListener(BackupAuthListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    unregisterBackupAuthListener(BackupAuthListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    cancelBackup(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    responseAuth(parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 46:
                    recordPeerDeviceMac(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 47:
                    connectTccpServer(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 48:
                    updateMirrorWindowPoint(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 49:
                    registerCapabilityLinstner(ICapabilityListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    executeAction(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void cancelBackup(long j10) throws RemoteException;

    void cancelFileTransfer() throws RemoteException;

    boolean castActivity(String str, int i10) throws RemoteException;

    boolean castActivityByImplicitStart(Intent intent, VideoConfig videoConfig) throws RemoteException;

    boolean castActivityInNewDisplay(String str, VideoConfig videoConfig) throws RemoteException;

    boolean castAudio() throws RemoteException;

    boolean castExtendScreen() throws RemoteException;

    boolean castMainScreen() throws RemoteException;

    List<String> checkServicePermission() throws RemoteException;

    void closeExtendScreen() throws RemoteException;

    boolean closeMainScreen() throws RemoteException;

    void confirmReceiveFile(List<String> list, String str, boolean z10, String str2, String str3) throws RemoteException;

    void connectTccpServer(String str, int i10) throws RemoteException;

    void disconnectTccpServer() throws RemoteException;

    void enableFeature(String str, boolean z10) throws RemoteException;

    void enableFeatures(List<String> list, boolean z10) throws RemoteException;

    void executeAction(String str, String str2) throws RemoteException;

    int getTCCPStatus() throws RemoteException;

    boolean isMotionControlByPc(long j10) throws RemoteException;

    void recordPeerDeviceMac(String str) throws RemoteException;

    void registerAudioListener(TCCPListener tCCPListener) throws RemoteException;

    void registerBackupAuthListener(BackupAuthListener backupAuthListener) throws RemoteException;

    void registerBackupFileListener(BackupFileListener backupFileListener) throws RemoteException;

    void registerCapabilityLinstner(ICapabilityListener iCapabilityListener) throws RemoteException;

    void registerCastExtendListener(TCCPListener tCCPListener) throws RemoteException;

    void registerExtendScreenListener(TCCPListener tCCPListener) throws RemoteException;

    void registerReceiveFileListener(String str, ReceiveFileTransferListener receiveFileTransferListener) throws RemoteException;

    void registerSendFileListener(String str, SendFileTransferListener sendFileTransferListener) throws RemoteException;

    void registerTCCPListener(String str, TCCPListener tCCPListener) throws RemoteException;

    void registerVideoListener(TCCPListener tCCPListener) throws RemoteException;

    void responseAuth(boolean z10, boolean z11) throws RemoteException;

    void sendFile(List<String> list, int i10, String str, String str2) throws RemoteException;

    void setConnectDeviceInfo(DeviceInfo deviceInfo) throws RemoteException;

    void startExtendScreen() throws RemoteException;

    int startTCCPServer(int i10) throws RemoteException;

    void stopAllCastAudio() throws RemoteException;

    void stopAllCastVideo() throws RemoteException;

    void stopTCCPServer() throws RemoteException;

    void syncClipText(String str) throws RemoteException;

    boolean syncFileInfoRequest(FileInfoSyncRequest fileInfoSyncRequest) throws RemoteException;

    void unregisterAudioListener(TCCPListener tCCPListener) throws RemoteException;

    void unregisterBackupAuthListener(BackupAuthListener backupAuthListener) throws RemoteException;

    void unregisterBackupFileListener(BackupFileListener backupFileListener) throws RemoteException;

    void unregisterCastExtendListener(TCCPListener tCCPListener) throws RemoteException;

    void unregisterExtendScreenListener(TCCPListener tCCPListener) throws RemoteException;

    void unregisterReceiveFileListener(ReceiveFileTransferListener receiveFileTransferListener) throws RemoteException;

    void unregisterSendFileListener(SendFileTransferListener sendFileTransferListener) throws RemoteException;

    void unregisterTCCPListener(TCCPListener tCCPListener) throws RemoteException;

    void unregisterVideoListener(TCCPListener tCCPListener) throws RemoteException;

    void updateMirrorWindowPoint(int i10, int i11) throws RemoteException;
}
