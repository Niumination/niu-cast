package com.transsion.tranradionet;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import java.util.Map;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public class TranRadioNetManager {
    private static final int RET_FAILED = 1;
    private static final int RET_SUCCESS = 0;
    private static final String SVC_NAME = "com.transsion.tranradionet.TranRadioNetService";
    private static final String SVC_PKG_NAME = "com.transsion.tranradionet";
    private static final String TAG = "TranRadioNetManager";
    private static final int TRAN_RADIO_NET_ERROR = 1;
    private static final int TRAN_RADIO_NET_UNSUPPORT = 2;
    public static final String VER_INFO = "1.0";
    private static final byte WRITE_FILE_BY_NAME_VEC_FAILED = -1;
    private static TranRadioNetManager mInst;
    private Handler mCallbackHandler;
    private Context mContext;
    private volatile ITranRadioNetService mService;
    private int mServiceConnId;
    private ServiceConnection mServiceConnection;

    public TranRadioNetManager(Context context) {
        this.mContext = null;
        this.mCallbackHandler = null;
        this.mService = null;
        this.mServiceConnId = -1;
        this.mServiceConnection = new ServiceConnection() { // from class: com.transsion.tranradionet.TranRadioNetManager.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (TranRadioNetManager.class) {
                    TranRadioNetManager tranRadioNetManager = TranRadioNetManager.this;
                    tranRadioNetManager.mService = tranRadioNetManager.getServiceInstance(iBinder);
                    TranRadioNetManager.this.mCallbackHandler.sendMessage(Message.obtain(TranRadioNetManager.this.mCallbackHandler, TranRadioNetManager.this.mServiceConnId, Boolean.TRUE));
                    TranRadioNetManager.logi("onServiceConnected with mServiceConnId = " + TranRadioNetManager.this.mServiceConnId);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (TranRadioNetManager.class) {
                    TranRadioNetManager.this.mCallbackHandler.sendMessage(Message.obtain(TranRadioNetManager.this.mCallbackHandler, TranRadioNetManager.this.mServiceConnId, Boolean.FALSE));
                    TranRadioNetManager.logi("onServiceDisconnected with mServiceConnId = " + TranRadioNetManager.this.mServiceConnId);
                    TranRadioNetManager.this.mServiceConnId = -1;
                    TranRadioNetManager.this.mService = null;
                }
            }
        };
        this.mContext = context;
    }

    private void checkPermission(Context context) {
        int callingUid = Binder.getCallingUid();
        if (context == null || this.mContext.checkSelfPermission("com.transsion.tranradionet.START_RADIO_NET_SERVICE") != 0) {
            throw new SecurityException(a1.a.o(callingUid, "No permission to access tranradionet by callingUid = "));
        }
    }

    public static TranRadioNetManager getInstance() {
        TranRadioNetManager tranRadioNetManager;
        synchronized (TranRadioNetManager.class) {
            try {
                if (mInst == null) {
                    mInst = new TranRadioNetManager();
                }
                tranRadioNetManager = mInst;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tranRadioNetManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITranRadioNetService getServiceInstance(IBinder iBinder) {
        if (this.mService == null) {
            synchronized (TranRadioNetManager.class) {
                try {
                    if (this.mService == null) {
                        this.mService = ITranRadioNetService.Stub.asInterface(iBinder);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.mService;
    }

    private boolean isValidLong(long j8) {
        return true;
    }

    private static void loge(String str) {
        Log.e(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logi(String str) {
        Log.i(TAG, str);
    }

    public void addErrorInfoToDfx(String str, String str2) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.addErrorInfoToDfx(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int barCell(int i8, int i9, int i10, int i11, int i12, int i13) {
        if (this.mService == null || i8 < 0 || i9 < 4 || i9 > 5 || i13 < 0 || i13 > 65535) {
            return 1;
        }
        try {
            return this.mService.barCell(i8, i9, i10, i11, i12, i13);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public void clearFtaiCount(int i8) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.clearFtaiCount(i8);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clearFtalList(int i8) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.clearFtalList(i8);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean connectService(Handler handler, int i8) {
        Intent intent = new Intent(SVC_NAME);
        intent.setComponent(new ComponentName(SVC_PKG_NAME, SVC_NAME));
        this.mCallbackHandler = handler;
        if (handler == null) {
            loge("mCallbackHandler is null");
            return false;
        }
        this.mServiceConnId = i8;
        Context context = this.mContext;
        if (context == null) {
            loge("connectService fail with mServiceConnId = " + this.mServiceConnId);
            Handler handler2 = this.mCallbackHandler;
            handler2.sendMessage(Message.obtain(handler2, this.mServiceConnId, Boolean.FALSE));
            this.mServiceConnId = -1;
            this.mCallbackHandler = null;
            return false;
        }
        try {
            checkPermission(context);
            return this.mContext.bindService(intent, this.mServiceConnection, 1);
        } catch (SecurityException unused) {
            loge("connectService exception with mServiceConnId = " + this.mServiceConnId);
            Handler handler3 = this.mCallbackHandler;
            handler3.sendMessage(Message.obtain(handler3, this.mServiceConnId, Boolean.FALSE));
            this.mServiceConnId = -1;
            this.mCallbackHandler = null;
            return false;
        }
    }

    public Intent creatDualSimSwitchSettingsActivityIntent() {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.creatDualSimSwitchSettingsActivityIntent();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public int deregisterCallback(TranRadioNetManagerCallback tranRadioNetManagerCallback) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return 1;
                }
                if (tranRadioNetManagerCallback == null) {
                    Log.e(TAG, "deregisterCallback callback is null");
                    return 1;
                }
                try {
                    return this.mService.deregisterCallback(tranRadioNetManagerCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 1;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void disconnectService() {
        ServiceConnection serviceConnection = this.mServiceConnection;
        if (serviceConnection != null) {
            this.mContext.unbindService(serviceConnection);
            this.mServiceConnection = null;
        }
    }

    public int dispatchNetCmd(String str) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return 1;
                }
                if (TextUtils.isEmpty(str)) {
                    Log.e(TAG, "dispatchNetCmd cmd is empty");
                    return 1;
                }
                try {
                    return this.mService.dispatchNetCmd(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 1;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int dispatchRilCmd(int i8, int i9, String str) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return 1;
                }
                if (i8 >= 0 && i9 >= 0 && !TextUtils.isEmpty(str)) {
                    try {
                        return this.mService.dispatchRilCmd(i8, i9, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return 1;
                    }
                }
                Log.e(TAG, "dispatchRilCmd token = " + i8 + "slotId = " + i9 + "data = " + str);
                return 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int enableDrdsda(boolean z2) {
        if (this.mService == null) {
            return 1;
        }
        try {
            return this.mService.enableDrdsda(z2);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int enableDsda(boolean z2) {
        if (this.mService == null) {
            return 1;
        }
        try {
            return this.mService.enableDsda(z2);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int enableEndc(int i8, boolean z2) {
        if (this.mService == null || i8 < 0) {
            return 1;
        }
        try {
            return this.mService.enableEndc(i8, z2);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int enableEvs(int i8, boolean z2) {
        if (this.mService == null || i8 < 0) {
            return 1;
        }
        try {
            return this.mService.enableEvs(i8, z2);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int enableRadio(boolean z2) {
        if (this.mService == null) {
            return 1;
        }
        try {
            return this.mService.enableRadio(z2);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int enableRatStallSelfHeal(boolean z2) {
        if (this.mService == null) {
            return 1;
        }
        try {
            return this.mService.enableRatStallSelfHeal(z2);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int executeStrategy(int i8, int i9) {
        if (this.mService == null || i8 < 0 || i9 < 0) {
            return 1;
        }
        try {
            return this.mService.executeStrategy(i8, i9);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public String getHardwareInfo() {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return "";
            }
            try {
                return this.mService.getHardwareInfo();
            } catch (RemoteException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public Map<String, String> getOverUsePkgAndBytes() {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return null;
            }
            try {
                return this.mService.getOverUsePkgAndBytes();
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public String getProcSysNet(int i8, int i9, String str, String str2) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return "";
                }
                if (i8 >= 0 && i9 >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        return this.mService.getProcSysNet(i8, i9, str, str2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return "";
                    }
                }
                Log.e(TAG, "getProcSysNet parameter is invalid ipversion: " + i8 + ", which: " + i9 + ", ifname: " + str + "parameter: " + str2);
                return "";
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean isAcceleratedEnabled(String str) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return false;
            }
            try {
                return this.mService.isAcceleratedEnabled(str);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public boolean isAppNetWorkAccelerated() {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return false;
            }
            try {
                return this.mService.isAppNetWorkAccelerated();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public boolean isDualSimSwitchEnabled() {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService != null) {
                    try {
                        return this.mService.isDualSimSwitchEnabled();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean isForbiddenViceCardWhenGameEnabled() {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.isForbiddenViceCardWhenGameEnabled();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean isServiceConnected() {
        synchronized (TranRadioNetManager.class) {
            try {
                return this.mService != null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int mqttFileChanged(String str, String str2, String str3, String str4, long j8) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return 1;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && isValidLong(j8)) {
                    try {
                        Log.e(TAG, "deviceId: " + str2);
                        return this.mService.mqttFileChanged(str, str2, str3, str4, j8);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return 1;
                    }
                }
                Log.e(TAG, "mqttFileChanged parameter is invalid messageId: " + str + ", deviceId: " + str2 + ", radioConfig: " + str3 + "url: " + str4 + "sendTime: " + j8);
                return 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int notifyBinderMultiLinkNwType(int i8, int i9, int i10) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return 1;
            }
            if (i8 >= 0 && i9 >= 0 && i10 >= 0) {
                try {
                    this.mService.notifyBinderMultiLinkNwType(i8, i9, i10);
                    return 0;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 1;
                }
            }
            Log.e(TAG, "notifyBinderMultiLinkNwType parameter is invalid type: " + i8 + ", uid: " + i9 + ", pid: " + i10);
            return 1;
        }
    }

    public void notifyGameSceneType(String str, int i8, int i9) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.notifyGameSceneType(str, i8, i9);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<String> psAttach(int i8) {
        if (this.mService == null || i8 < 0) {
            return null;
        }
        try {
            return this.mService.psAttach(i8);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public List<String> psDeAttach(int i8) {
        if (this.mService == null || i8 < 0) {
            return null;
        }
        try {
            return this.mService.psDeAttach(i8);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public List<String> queryBarCell(int i8, int i9) {
        if (this.mService != null && i8 >= 0 && i9 >= 4 && i9 <= 5) {
            try {
                return this.mService.queryBarCell(i8, i9);
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public String queryCurrentBands(int i8, int i9) {
        Log.d(TAG, "queryCurrentBands: slotId：" + i8 + ", type：" + i9);
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return null;
                }
                try {
                    return this.mService.queryCurrentBands(i8, i9);
                } catch (RemoteException e) {
                    Log.e(TAG, "queryCurrentBands: RemoteException:", e);
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String queryEsimEid(int i8) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return null;
                }
                try {
                    return this.mService.queryEsimEid(i8);
                } catch (RemoteException unused) {
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int[] queryEsimStatus(int i8) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return null;
                }
                try {
                    return this.mService.queryEsimStatus(i8);
                } catch (RemoteException unused) {
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String querySupportBands(int i8, int i9) {
        Log.d(TAG, "querySupportBands: slotId：" + i8 + ", type：" + i9);
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return null;
                }
                try {
                    return this.mService.querySupportBands(i8, i9);
                } catch (RemoteException e) {
                    Log.e(TAG, "querySupportBands: RemoteException:", e);
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String readFileByName(String str, int i8, int i9) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return "";
                }
                if (TextUtils.isEmpty(str)) {
                    Log.e(TAG, "readFileByName fileName is empty");
                    return "";
                }
                try {
                    return this.mService.readFileByName(str, i8, i9);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return "";
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int registerCallback(TranRadioNetManagerCallback tranRadioNetManagerCallback) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return 1;
                }
                if (tranRadioNetManagerCallback == null) {
                    Log.e(TAG, "registerCallback callback is null");
                    return 1;
                }
                try {
                    return this.mService.registerCallback(tranRadioNetManagerCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 1;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void registerForCommGameEngine(Messenger messenger) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.registerForCommGameEngine(messenger);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int registerMultiLinkCallback(Messenger messenger, int i8, int i9) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return 1;
            }
            if (messenger != null && i8 >= 0 && i9 >= 0) {
                try {
                    this.mService.registerMultiLinkCallback(messenger, i8, i9);
                    return 0;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 1;
                }
            }
            Log.e(TAG, "registerMultiLinkCallback parameter is invalid messenger: " + messenger + ", uid: " + i8 + ", pid: " + i9);
            return 1;
        }
    }

    public void resetFtaiTimer(int i8) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.resetFtaiTimer(i8);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int retLte(int i8, String str) {
        Log.d(TAG, "retLte: slotId：" + i8 + ", cmdStr：" + str);
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return -1;
                }
                try {
                    return this.mService.retLte(i8, str);
                } catch (RemoteException e) {
                    Log.e(TAG, "retLte: RemoteException:", e);
                    return -1;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public List<String> sendAtCmd(int i8, String str) {
        if (this.mService == null || i8 < 0) {
            return null;
        }
        try {
            return this.mService.sendAtCmd(i8, str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public int sendImsRemainedTime(int i8, int i9) {
        Log.i(TAG, "sendImsRemainedTime slotId: " + i8 + ", remainedTime: " + i9);
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                Log.i(TAG, "services is null");
                return 1;
            }
            if (i8 >= 0 && i9 >= 0) {
                try {
                    this.mService.sendImsRemainedTime(i8, i9);
                    return 0;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 1;
                }
            }
            Log.e(TAG, "sendImsRemainedTime parameter is invalid slotId: " + i8 + ", remainedTime: " + i9);
            return 1;
        }
    }

    public void sendSWTPTxPowerRequest(boolean z2) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return;
            }
            try {
                this.mService.sendSWTPTxPowerRequest(z2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean setAcceleratedEnabledByPhone(boolean z2) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return false;
            }
            try {
                return this.mService.setAcceleratedEnabledByPhone(z2);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public int setCurrentBands(int i8, int i9, String str) {
        StringBuilder sbR = d.r(i8, i9, "setCurrentBands: slotId：", ", type：", ", cmdStr：");
        sbR.append(str);
        Log.d(TAG, sbR.toString());
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return -1;
                }
                try {
                    return this.mService.setCurrentBands(i8, i9, str);
                } catch (RemoteException e) {
                    Log.e(TAG, "setCurrentBands: RemoteException:", e);
                    return -1;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setDefaultDualSimSwitchDataLimit() {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.setDefaultDualSimSwitchDataLimit();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int setDualSimSwitchEnabled(boolean z2) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService != null) {
                    try {
                        return this.mService.setDualSimSwitchEnabled(z2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                return 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setForbiddenViceCardWhenGameEnabled(boolean z2) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.setForbiddenViceCardWhenGameEnabled(z2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int setImsCfg(int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        if (this.mService == null || i8 < 0) {
            return 1;
        }
        try {
            return this.mService.setImsCfg(i8, i9, i10, i11, i12, i13, i14);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int setL2nrSelection(int i8) {
        d.x(i8, "setL2nrSelection: slotId：", TAG);
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return -1;
                }
                try {
                    return this.mService.setL2nrSelection(i8);
                } catch (RemoteException e) {
                    Log.e(TAG, "setL2nrSelection: RemoteException:", e);
                    return -1;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setProcSysNet(int i8, int i9, String str, String str2, String str3) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return;
                }
                if (i8 >= 0 && i9 >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    try {
                        this.mService.setProcSysNet(i8, i9, str, str2, str3);
                        return;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                Log.e(TAG, "setProcSysNet parameter is invalid ipversion: " + i8 + ", which: " + i9 + ", ifname: " + str + "parameter: " + str2 + ", value: " + str3);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setThreshold(long j8, long j10) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return;
            }
            try {
                this.mService.setThreshold(j8, j10);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean switchAppNetWorkAccelerated(boolean z2, String str) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService == null) {
                return false;
            }
            try {
                return this.mService.switchAppNetWorkAccelerated(z2, str);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public void switchEsimPsim(int i8, int i9) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.switchEsimPsim(i8, i9);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public int unbarCell(int i8, int i9, int i10, int i11, int i12, int i13) {
        if (this.mService == null || i8 < 0 || i9 < 4 || i9 > 5 || i13 < 0 || i13 > 65535) {
            return 1;
        }
        try {
            return this.mService.unbarCell(i8, i9, i10, i11, i12, i13);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int undoSelRatBarCells(int i8, int i9) {
        if (this.mService == null || i8 < 0 || i9 < 4 || i9 > 5) {
            return 1;
        }
        try {
            return this.mService.undoSelRatBarCells(i8, i9);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public void unregisterForCommGameEngine(Messenger messenger) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.unregisterForCommGameEngine(messenger);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int unregisterMultiLinkCallback() {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService != null) {
                    try {
                        this.mService.unregisterMultiLinkCallback();
                        return 0;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                return 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int updateAntennaTxPower(String str) {
        if (this.mService == null || TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            return this.mService.updateAntennaTxPower(str);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public void updateFtaiTimer(int i8, String str, int i9) {
        synchronized (TranRadioNetManager.class) {
            if (this.mService != null) {
                try {
                    this.mService.updateFtaiTimer(i8, str, i9);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int updateGWLmaxTxpower(String str) {
        if (this.mService == null || TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            return this.mService.updateGWLmaxTxpower(str);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int updateMaxTxPowerRfPara(String str) {
        if (this.mService == null || TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            return this.mService.updateMaxTxPowerRfPara(str);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int updateTxState(String str) {
        if (this.mService == null || TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            return this.mService.updateTxState(str);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public int verifySimLockCode(String str) {
        if (this.mService == null || TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            return this.mService.verifySimLockCode(str);
        } catch (RemoteException unused) {
            return 2;
        }
    }

    public byte writeFileByNamevec(String str, int i8, int i9, byte[] bArr) {
        synchronized (TranRadioNetManager.class) {
            try {
                if (this.mService == null) {
                    return (byte) -1;
                }
                if (TextUtils.isEmpty(str)) {
                    Log.e(TAG, "writeFileByNamevec fileName is empty");
                    return (byte) -1;
                }
                if (bArr == null) {
                    Log.e(TAG, "writeFileByNamevec data is null");
                    return (byte) -1;
                }
                try {
                    return this.mService.writeFileByNamevec(str, i8, i9, bArr);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return (byte) -1;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static TranRadioNetManager getInstance(Context context) {
        TranRadioNetManager tranRadioNetManager;
        synchronized (TranRadioNetManager.class) {
            try {
                if (mInst == null) {
                    mInst = new TranRadioNetManager(context);
                }
                tranRadioNetManager = mInst;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tranRadioNetManager;
    }

    public TranRadioNetManager() {
        this.mContext = null;
        this.mCallbackHandler = null;
        this.mService = null;
        this.mServiceConnId = -1;
        this.mServiceConnection = new ServiceConnection() { // from class: com.transsion.tranradionet.TranRadioNetManager.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (TranRadioNetManager.class) {
                    TranRadioNetManager tranRadioNetManager = TranRadioNetManager.this;
                    tranRadioNetManager.mService = tranRadioNetManager.getServiceInstance(iBinder);
                    TranRadioNetManager.this.mCallbackHandler.sendMessage(Message.obtain(TranRadioNetManager.this.mCallbackHandler, TranRadioNetManager.this.mServiceConnId, Boolean.TRUE));
                    TranRadioNetManager.logi("onServiceConnected with mServiceConnId = " + TranRadioNetManager.this.mServiceConnId);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (TranRadioNetManager.class) {
                    TranRadioNetManager.this.mCallbackHandler.sendMessage(Message.obtain(TranRadioNetManager.this.mCallbackHandler, TranRadioNetManager.this.mServiceConnId, Boolean.FALSE));
                    TranRadioNetManager.logi("onServiceDisconnected with mServiceConnId = " + TranRadioNetManager.this.mServiceConnId);
                    TranRadioNetManager.this.mServiceConnId = -1;
                    TranRadioNetManager.this.mService = null;
                }
            }
        };
    }
}
