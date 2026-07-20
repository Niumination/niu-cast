package com.transsion.core.deviceinfo;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import com.transsion.core.CoreUtil;
import com.transsion.core.log.LogUtils;
import com.transsion.core.utils.EncoderUtil;
import com.transsion.core.utils.PermissionUtil;
import com.transsion.widgetsliquid.utils.Utils;
import java.lang.reflect.Method;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceInfo {
    private static String mAndroidId = "";
    private static String mGAId = "";
    private static String mImei = "";
    private static String osVersion = "";

    private static void appendNumber(StringBuilder sb2, int i8, int i9) {
        String string = Integer.toString(i9);
        for (int i10 = 0; i10 < i8 - string.length(); i10++) {
            sb2.append('0');
        }
        sb2.append(string);
    }

    private static String createGmtOffsetString(boolean z2, boolean z3, int i8) {
        char c9;
        int i9 = i8 / 60000;
        if (i9 < 0) {
            i9 = -i9;
            c9 = '-';
        } else {
            c9 = '+';
        }
        StringBuilder sb2 = new StringBuilder(9);
        if (z2) {
            sb2.append("GMT");
        }
        sb2.append(c9);
        appendNumber(sb2, 2, i9 / 60);
        if (z3) {
            sb2.append(':');
        }
        appendNumber(sb2, 2, i9 % 60);
        return sb2.toString();
    }

    public static String getAndroidID() {
        if (!TextUtils.isEmpty(mAndroidId)) {
            return mAndroidId;
        }
        String string = Settings.Secure.getString(CoreUtil.getContext().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim();
        }
        String strEncoderByAlgorithm = TextUtils.isEmpty(string) ? "" : EncoderUtil.EncoderByAlgorithm(string);
        mAndroidId = strEncoderByAlgorithm;
        return strEncoderByAlgorithm;
    }

    public static String getBTMAC() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return (PermissionUtil.lacksPermission("android.permission.BLUETOOTH") || defaultAdapter == null) ? "" : defaultAdapter.getAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getBatteryCapacity(Context context) {
        double dDoubleValue;
        try {
            dDoubleValue = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), null)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            dDoubleValue = 0.0d;
        }
        return String.valueOf(dDoubleValue + " mAh");
    }

    public static String getGAId() {
        String str = mGAId;
        if (str == null || str.length() == 0) {
            new Thread(new Runnable() { // from class: com.transsion.core.deviceinfo.DeviceInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String unused = DeviceInfo.mGAId = AdvertisingIdClient.getAdvertisingIdInfo(CoreUtil.getContext()).getId();
                        LogUtils.i("advertisingId is " + DeviceInfo.mGAId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return mGAId;
    }

    public static String getGAIdInThread() {
        if (isCurrentMainThread()) {
            return getGAId();
        }
        String str = mGAId;
        if (str != null && str.length() != 0) {
            return mGAId;
        }
        try {
            mGAId = AdvertisingIdClient.getAdvertisingIdInfo(CoreUtil.getContext()).getId();
            LogUtils.i("advertisingId is " + mGAId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mGAId;
    }

    public static String getIMEI() {
        if (!TextUtils.isEmpty(mImei)) {
            return mImei;
        }
        String str = "";
        String str2 = SysProp.get("prop.sim1.imei", "");
        if (str2 == null || str2.length() == 0 || str2.length() != 15) {
            try {
                return ((TelephonyManager) CoreUtil.getContext().getSystemService("phone")).getImei();
            } catch (SecurityException unused) {
            }
        } else {
            str = str2;
        }
        if (TextUtils.isEmpty(str) || str.length() < 15) {
            mImei = str;
        } else {
            mImei = EncoderUtil.EncoderByAlgorithm(str);
        }
        return mImei;
    }

    public static String getIMSI() {
        try {
            Context context = CoreUtil.getContext();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getApplicationContext().getPackageName()) != 0) {
                return getSimOperator();
            }
            String subscriberId = telephonyManager != null ? telephonyManager.getSubscriberId() : null;
            return (subscriberId != null && subscriberId.length() >= 8) ? subscriberId.substring(0, 8) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getOSVersion() {
        if (TextUtils.isEmpty(osVersion)) {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
                String str = (String) method.invoke(null, Utils.OS_TRANS_VERSION, "");
                osVersion = str;
                if (TextUtils.isEmpty(str)) {
                    osVersion = (String) method.invoke(null, "ro.os_product.version", "");
                }
            } catch (Exception unused) {
            }
        }
        return osVersion;
    }

    public static String getSerialNumber() {
        String serial;
        try {
            serial = Build.getSerial();
        } catch (Exception unused) {
            serial = "";
        }
        try {
            if (TextUtils.isEmpty(serial) || EnvironmentCompat.MEDIA_UNKNOWN.equals(serial)) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                serial = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            }
        } catch (Exception unused2) {
        }
        return TextUtils.isEmpty(serial) ? "" : EncoderUtil.EncoderByAlgorithm(serial);
    }

    public static String getSimOperator() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) CoreUtil.getContext().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getTimeZone() {
        try {
            return createGmtOffsetString(true, true, TimeZone.getDefault().getRawOffset());
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static long getTotalRAM(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(AtomicIntentType.ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long getTotalROM(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static boolean isCurrentMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean isPad() {
        Context context = CoreUtil.getContext();
        return context.getResources() != null && (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String getIMSI(int i8) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) CoreUtil.getContext().getApplicationContext().getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i8));
            if (!TextUtils.isEmpty(str)) {
                return EncoderUtil.EncoderByAlgorithm(str);
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMEI(int i8) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) CoreUtil.getContext().getApplicationContext().getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            Class cls2 = Integer.TYPE;
            String str = (String) cls.getMethod("getImei", cls2).invoke(telephonyManager, Integer.valueOf(i8));
            if (TextUtils.isEmpty(str)) {
                str = (String) telephonyManager.getClass().getMethod("getDeviceId", cls2).invoke(telephonyManager, Integer.valueOf(i8));
            }
            return (TextUtils.isEmpty(str) || str.length() < 15) ? str : EncoderUtil.EncoderByAlgorithm(str);
        } catch (Exception unused) {
            return "";
        }
    }
}
