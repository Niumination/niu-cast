package com.transsion.tranradionet;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.transsion.tranradionet.exts.knight.ByteMatrix;
import com.transsion.tranradionet.exts.knight.ITranKnightTelephony;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public class TranPhoneInterfaceManager {
    protected static final String LOG_TAG = "TranPhoneInterfaceManager";
    private static final String PSTN_CALL_SERVICE_CLASS_NAME = "com.android.services.telephony.TelephonyConnectionService";
    private static final String TELEPHONY_PACKAGE_NAME = "com.android.phone";
    private static TranPhoneInterfaceManager mInst;

    private TranPhoneInterfaceManager() {
    }

    public static TranPhoneInterfaceManager getInstance() {
        TranPhoneInterfaceManager tranPhoneInterfaceManager;
        synchronized (TranPhoneInterfaceManager.class) {
            try {
                if (mInst == null) {
                    mInst = new TranPhoneInterfaceManager();
                }
                tranPhoneInterfaceManager = mInst;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tranPhoneInterfaceManager;
    }

    public static int getSubIdForPhoneAccountHandle(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle == null) {
            Log.w(LOG_TAG, "getSubIdForPhoneAccountHandle phoneAccountHandle is null");
            return -1;
        }
        if (!isPstnComponentName(phoneAccountHandle.getComponentName())) {
            return -1;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        PhoneAccount phoneAccount = ((TelecomManager) context.getSystemService("telecom")).getPhoneAccount(phoneAccountHandle);
        if (phoneAccount == null) {
            return -1;
        }
        return telephonyManager.getSubIdForPhoneAccount(phoneAccount);
    }

    public static boolean isPstnComponentName(ComponentName componentName) {
        return new ComponentName(TELEPHONY_PACKAGE_NAME, PSTN_CALL_SERVICE_CLASS_NAME).equals(componentName);
    }

    public int getBlockCallStatus(String str, String str2, int i8, int i9, int i10, long j8, long j10) {
        Log.d(LOG_TAG, "[getBlockCallStatus] ");
        try {
            ITranKnightTelephony iTranTelephony = getITranTelephony();
            if (iTranTelephony != null) {
                return iTranTelephony.getBlockCallStatus(str, str2, i8, i9, i10, j8, j10);
            }
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "[getBlockCallStatus] RemoteException ", e);
        } catch (SecurityException e4) {
            Log.e(LOG_TAG, "Permission error calling ITelephony#getBlockCallStatus", e4);
        }
        return i10;
    }

    public boolean getBlockSmsStatus(byte[][] bArr, String str, int i8, boolean z2) {
        Log.d(LOG_TAG, "[getBlockSmsStatus] ");
        try {
            ITranKnightTelephony iTranTelephony = getITranTelephony();
            if (iTranTelephony != null) {
                return iTranTelephony.getBlockSmsStatus(new ByteMatrix(bArr), str, i8, z2);
            }
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "[getBlockSmsStatus] RemoteException ", e);
        } catch (SecurityException e4) {
            Log.e(LOG_TAG, "Permission error calling ITelephony#getBlockSmsStatus", e4);
        }
        return z2;
    }

    public int getFlashCallVer() {
        Log.d(LOG_TAG, "[getFlashCallVer] ");
        try {
            ITranKnightTelephony iTranTelephony = getITranTelephony();
            if (iTranTelephony != null) {
                return iTranTelephony.getFlashCallVer();
            }
            return 0;
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "[getFlashCallVer] RemoteException ", e);
            return 0;
        } catch (SecurityException e4) {
            Log.e(LOG_TAG, "Permission error calling ITelephony#getFlashCallVer", e4);
            return 0;
        }
    }

    public int[] getFlashMsgTimes() {
        int[] iArr = new int[0];
        try {
            ITranKnightTelephony iTranTelephony = getITranTelephony();
            return iTranTelephony != null ? iTranTelephony.getFlashMsgTimes() : iArr;
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "[getFlashMsgTimes] RemoteException ", e);
            return iArr;
        } catch (SecurityException e4) {
            Log.e(LOG_TAG, "Permission error calling ITelephony#getFlashMsgTimes", e4);
            return iArr;
        }
    }

    public ITranKnightTelephony getITranTelephony() {
        return ITranKnightTelephony.Stub.asInterface(ServiceManager.getService("knightphone"));
    }

    public boolean isVoDataProjectAndCloudSupport() {
        Log.d(LOG_TAG, "[isVoDataProjectAndCloudSupport] ");
        boolean zIsVoDataProjectAndCloudSupport = false;
        try {
            ITranKnightTelephony iTranTelephony = getITranTelephony();
            if (iTranTelephony != null) {
                zIsVoDataProjectAndCloudSupport = iTranTelephony.isVoDataProjectAndCloudSupport();
            }
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "[isVoDataProjectAndCloudSupport] RemoteException ", e);
        } catch (SecurityException e4) {
            Log.e(LOG_TAG, "Permission error calling ITelephony#isVoDataProjectAndCloudSupport", e4);
        }
        Log.i(LOG_TAG, "isVoDataProjectAndCloudSupport: " + zIsVoDataProjectAndCloudSupport);
        return zIsVoDataProjectAndCloudSupport;
    }

    public void processUssdByAi(int i8, int i9, String str, ResultReceiver resultReceiver) {
        StringBuilder sbR = d.r(i8, i9, "[processUssdByAi] queryType ", " phoneId ", " operatorName: ");
        sbR.append(str);
        Log.d(LOG_TAG, sbR.toString());
        try {
            ITranKnightTelephony iTranTelephony = getITranTelephony();
            if (iTranTelephony != null) {
                iTranTelephony.processUssdByAi(i8, i9, str, resultReceiver);
            }
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "processUssdByAi() RemoteException ", e);
        } catch (SecurityException e4) {
            Log.e(LOG_TAG, "Permission error calling ITelephony#processUssdByAi", e4);
        }
    }

    public void triggerPowerMetrics() {
        try {
            ITranKnightTelephony iTranTelephony = getITranTelephony();
            if (iTranTelephony != null) {
                iTranTelephony.triggerPowerMetrics();
            }
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "[triggerPowerMetrics] RemoteException", e);
        } catch (SecurityException e4) {
            Log.e(LOG_TAG, "Permission error calling ITelephony#triggerPowerMetrics", e4);
        }
    }

    public int getBlockCallStatus(Context context, String str, String str2, PhoneAccountHandle phoneAccountHandle, int i8, int i9, long j8, long j10) {
        return getBlockCallStatus(str, str2, getSubIdForPhoneAccountHandle(context, phoneAccountHandle), i8, i9, j8, j10);
    }
}
