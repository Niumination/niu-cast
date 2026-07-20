package com.transsion.connectx.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TCCPSourceApi implements ITCCPSourceApi {
    public static final String ACTION_SERVICE = "com_transsion_connectx_source_api";
    public static final int CONNECT_TYPE_P2P = 2;
    public static final int CONNECT_TYPE_USB = 1;
    public static final int CONNECT_TYPE_WIFI = 3;
    public static final String KEY_FEATURE_INPUT_METHOD = "input_method";
    public static final String KEY_FEATURE_UIBC = "uibc";
    private static final int MAX_CONNECT_RETRY = 3;
    private static final String PACKAGE_SERVICE = "com.transsion.connectx.mirror.source";
    private static final int RETRY_CONNECT_DELAY = 300;
    public static final int SEND_FILE_MODE_SPEED = 0;
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_EXTEND_SCREEN = 5;
    public static final int STATE_MIRROR_CASTING = 4;
    public static final int STATE_STOP = 3;
    public static final int STATE_WAITING = 2;
    private static final String TAG = "CastSourceApi";
    private static volatile TCCPSourceApi sInstance;
    private final WeakReference<Context> mContextRef;

    @Nullable
    private ServiceConnection mOuterScHolder;
    private ITCCPSourceApi mRemoteInterface;
    private boolean mServiceConnected = false;
    private int connectFailedCount = 0;
    private boolean isDisconnected = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.transsion.connectx.sdk.TCCPSourceApi.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (TCCPSourceApi.this.mRemoteInterface != null) {
                TCCPSourceApi.this.mRemoteInterface.asBinder().unlinkToDeath(this, 0);
                TCCPSourceApi.this.mRemoteInterface = null;
                TCCPSourceApi.this.mServiceConnected = false;
            }
            Log.d(TCCPSourceApi.TAG, "binderDied()");
        }
    };
    private final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.transsion.connectx.sdk.TCCPSourceApi.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TCCPSourceApi.this.mServiceConnected = true;
            Log.i(TCCPSourceApi.TAG, "onServiceConnected: ");
            TCCPSourceApi.this.mRemoteInterface = ITCCPSourceApi.Stub.asInterface(iBinder);
            try {
                TCCPSourceApi.this.mRemoteInterface.asBinder().linkToDeath(TCCPSourceApi.this.mDeathRecipient, 0);
            } catch (RemoteException e10) {
                Log.e(TCCPSourceApi.TAG, e10.getMessage(), e10);
            }
            if (TCCPSourceApi.this.mOuterScHolder != null) {
                TCCPSourceApi.this.mOuterScHolder.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            TCCPSourceApi.this.mServiceConnected = false;
            TCCPSourceApi.this.mRemoteInterface = null;
            Log.i(TCCPSourceApi.TAG, "onServiceDisconnected: ");
            if (TCCPSourceApi.this.mOuterScHolder != null) {
                TCCPSourceApi.this.mOuterScHolder.onServiceDisconnected(componentName);
            }
        }
    };

    public class ConnectServiceRunnable implements Runnable {
        private final Context context;

        public ConnectServiceRunnable(Context context) {
            this.context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(TCCPSourceApi.TAG, "ConnectServiceRunnable ->" + TCCPSourceApi.this.mServiceConnected + "  isDisconnected:" + TCCPSourceApi.this.isDisconnected + "  connectFailedCount:" + TCCPSourceApi.this.connectFailedCount);
            if (TCCPSourceApi.this.mServiceConnected || TCCPSourceApi.this.isDisconnected) {
                return;
            }
            TCCPSourceApi.this.connectFailedCount++;
            if (TCCPSourceApi.this.connectFailedCount < 3) {
                Log.i(TCCPSourceApi.TAG, "ConnectServiceRunnable -> reconnect");
                TCCPSourceApi.this.connectService(this.context);
            }
        }
    }

    private TCCPSourceApi(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    @WorkerThread
    public static TCCPSourceApi getInstance(Context context) {
        if (sInstance == null) {
            synchronized (TCCPSourceApi.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new TCCPSourceApi(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sInstance;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void cancelBackup(long j10) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "cancelBackup: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.cancelBackup(j10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void cancelFileTransfer() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "sendFile: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.cancelFileTransfer();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castActivity(String str, int i10) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "castActivity: failed,service not available");
            return false;
        }
        try {
            return this.mRemoteInterface.castActivity(str, i10);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castActivityByImplicitStart(Intent intent, VideoConfig videoConfig) {
        if (!isServiceAvailable()) {
            return false;
        }
        try {
            return this.mRemoteInterface.castActivityByImplicitStart(intent, videoConfig);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castActivityInNewDisplay(String str, VideoConfig videoConfig) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "castActivityInNewDisplay: failed,service not available");
            return false;
        }
        try {
            return this.mRemoteInterface.castActivityInNewDisplay(str, videoConfig);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castAudio() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "castAudio: failed,service not available");
            return false;
        }
        try {
            return this.mRemoteInterface.castAudio();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castExtendScreen() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "castExtendScreen: failed,service not available");
            return false;
        }
        try {
            return this.mRemoteInterface.castExtendScreen();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castMainScreen() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "castMainScreen: failed,service not available");
            return false;
        }
        try {
            return this.mRemoteInterface.castMainScreen();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public List<String> checkServicePermission() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerSourceListener: failed,service not available");
            return Collections.emptyList();
        }
        try {
            return this.mRemoteInterface.checkServicePermission();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void closeExtendScreen() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "closeExtendScreen:failed,service not available");
        }
        try {
            this.mRemoteInterface.closeExtendScreen();
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean closeMainScreen() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "closeMainScreen: failed,service not available");
            return false;
        }
        try {
            return this.mRemoteInterface.closeMainScreen();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void confirmReceiveFile(List<String> list, String str, boolean z10, String str2, String str3) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "downloadFile: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.confirmReceiveFile(list, str, z10, str2, str3);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    public boolean connectService(Context context, @Nullable ServiceConnection serviceConnection) {
        this.mOuterScHolder = serviceConnection;
        if (this.mServiceConnected) {
            return true;
        }
        this.isDisconnected = false;
        this.connectFailedCount = 0;
        connectService(context);
        return false;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void connectTccpServer(String str, int i10) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "connectTccpServer: fail");
            return;
        }
        try {
            this.mRemoteInterface.connectTccpServer(str, i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public void disconnectService(Context context) {
        Log.i(TAG, "disconnectService");
        this.isDisconnected = true;
        try {
            context.getApplicationContext().unbindService(this.mServiceConnection);
        } catch (Exception e10) {
            Log.e(TAG, "disconnectService exception", e10);
        }
        this.mServiceConnected = false;
        this.mRemoteInterface = null;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void disconnectTccpServer() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "disconnect: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.disconnectTccpServer();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void enableFeature(String str, boolean z10) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "enableUIBC: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.enableFeature(str, z10);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void enableFeatures(List<String> list, boolean z10) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "enableUIBC: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.enableFeatures(list, z10);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void executeAction(String str, String str2) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "executeAction: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.executeAction(str, str2);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public int getTCCPStatus() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "getCastStatus: failed,service not available");
            return 3;
        }
        try {
            return this.mRemoteInterface.getTCCPStatus();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return 3;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean isMotionControlByPc(long j10) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "isControlByPc: failed,service not available");
            return false;
        }
        try {
            return this.mRemoteInterface.isMotionControlByPc(j10);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    public boolean isServiceAvailable() {
        return this.mServiceConnected && this.mRemoteInterface != null;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void recordPeerDeviceMac(String str) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "recordPeerDeviceMac: fail");
            return;
        }
        try {
            this.mRemoteInterface.recordPeerDeviceMac(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerAudioListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerAudioListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerAudioListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerBackupAuthListener(BackupAuthListener backupAuthListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerBackupAuthListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerBackupAuthListener(backupAuthListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerBackupFileListener(BackupFileListener backupFileListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerBackupFileListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerBackupFileListener(backupFileListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerCapabilityLinstner(ICapabilityListener iCapabilityListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerCapabilityLinstner: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerCapabilityLinstner(iCapabilityListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerCastExtendListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerCastExtendListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerCastExtendListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerExtendScreenListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerExtendScreenListener:failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerExtendScreenListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerReceiveFileListener(String str, ReceiveFileTransferListener receiveFileTransferListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerReceiveFileListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerReceiveFileListener(str, receiveFileTransferListener);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerSendFileListener(String str, SendFileTransferListener sendFileTransferListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerSendFileListener:service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerSendFileListener(str, sendFileTransferListener);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerTCCPListener(String str, TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerSourceListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerTCCPListener(str, tCCPListener);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerVideoListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "registerVideoListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.registerVideoListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void responseAuth(boolean z10, boolean z11) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "responseAuth: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.responseAuth(z10, z11);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void sendFile(List<String> list, int i10, String str, String str2) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "sendFile: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.sendFile(list, i10, str, str2);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void setConnectDeviceInfo(DeviceInfo deviceInfo) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "setConnectDeviceInfo: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.setConnectDeviceInfo(deviceInfo);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void startExtendScreen() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "startExtendScreen:failed,service not available");
        }
        try {
            this.mRemoteInterface.startExtendScreen();
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public int startTCCPServer(int i10) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "startCastServer: failed,service not available");
            return -1;
        }
        try {
            return this.mRemoteInterface.startTCCPServer(i10);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return -1;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void stopAllCastAudio() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "stopAllCastAudio:failed,service not available");
        }
        try {
            this.mRemoteInterface.stopAllCastAudio();
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void stopAllCastVideo() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "stopAllCastVideo:failed,service not available");
        }
        try {
            this.mRemoteInterface.stopAllCastVideo();
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void stopTCCPServer() {
        if (!isServiceAvailable()) {
            Log.e(TAG, "stopCastServer: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.stopTCCPServer();
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void syncClipText(String str) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterExtendScreenListener:failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.syncClipText(str);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean syncFileInfoRequest(FileInfoSyncRequest fileInfoSyncRequest) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "syncFileInfoRequest: failed,service not available");
            return false;
        }
        try {
            this.mRemoteInterface.syncFileInfoRequest(fileInfoSyncRequest);
            return true;
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterAudioListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterAudioListener:failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterAudioListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterBackupAuthListener(BackupAuthListener backupAuthListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterBackupAuthListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterBackupAuthListener(backupAuthListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterBackupFileListener(BackupFileListener backupFileListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterBackupFileListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterBackupFileListener(backupFileListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterCastExtendListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterCastExtendListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterCastExtendListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterExtendScreenListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterExtendScreenListener:failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterExtendScreenListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterReceiveFileListener(ReceiveFileTransferListener receiveFileTransferListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterReceiveFileListener:service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterReceiveFileListener(receiveFileTransferListener);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterSendFileListener(SendFileTransferListener sendFileTransferListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterSendFileListener:service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterSendFileListener(sendFileTransferListener);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterTCCPListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterSourceListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterTCCPListener(tCCPListener);
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterVideoListener(TCCPListener tCCPListener) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "unregisterVideoListener: failed,service not available");
            return;
        }
        try {
            this.mRemoteInterface.unregisterVideoListener(tCCPListener);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void updateMirrorWindowPoint(int i10, int i11) {
        if (!isServiceAvailable()) {
            Log.e(TAG, "updateMirrorWindowPoint: fail");
            return;
        }
        try {
            this.mRemoteInterface.updateMirrorWindowPoint(i10, i11);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectService(Context context) {
        Intent intent = new Intent(ACTION_SERVICE);
        intent.setPackage("com.transsion.connectx.mirror.source");
        context.getApplicationContext().bindService(intent, this.mServiceConnection, 1);
        this.mHandler.postDelayed(new ConnectServiceRunnable(context), 300L);
    }
}
