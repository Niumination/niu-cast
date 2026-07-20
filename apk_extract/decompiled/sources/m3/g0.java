package m3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.transsion.athena.AthenaConfig;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.utils.EncoderUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference f7680b;

    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    public static int a(Activity activity) {
        Intent intent;
        ResolveInfo resolveInfoResolveActivity;
        ActivityInfo activityInfo;
        PackageManager packageManager;
        Uri referrer;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        if (intent.getBooleanExtra(AthenaConfig.ATHENA_PUSH_CALL, false)) {
            return 3;
        }
        String callingPackage = activity.getCallingPackage();
        String str = "";
        List<ResolveInfo> listQueryIntentActivities = null;
        if (TextUtils.isEmpty(callingPackage)) {
            Intent intent2 = activity.getIntent();
            if (intent2 == null) {
                referrer = null;
            } else {
                referrer = (Uri) intent2.getParcelableExtra("android.intent.extra.REFERRER");
                if (referrer == null) {
                    String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                    referrer = !TextUtils.isEmpty(stringExtra) ? Uri.parse(stringExtra) : activity.getReferrer();
                }
            }
            if (referrer != null) {
                callingPackage = referrer.getHost();
                if (TextUtils.isEmpty(callingPackage)) {
                    callingPackage = "";
                }
            } else {
                callingPackage = "";
            }
        }
        String packageName = activity.getPackageName();
        if (TextUtils.isEmpty(callingPackage) || callingPackage.equals(packageName)) {
            return 1;
        }
        Intent intent3 = new Intent("android.intent.action.MAIN");
        intent3.addCategory("android.intent.category.HOME");
        PackageManager packageManager2 = activity.getPackageManager();
        if (packageManager2 != null) {
            try {
                resolveInfoResolveActivity = packageManager2.resolveActivity(intent3, 0);
            } catch (Exception e) {
                z6.a.c(e.getMessage());
                resolveInfoResolveActivity = null;
            }
            if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                String str2 = activityInfo.packageName;
                if (!"android".equals(str2) && !TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return !callingPackage.equals(str) ? 2 : 1;
        }
        if (!TextUtils.isEmpty(callingPackage) && (packageManager = activity.getPackageManager()) != null) {
            Intent intent4 = new Intent("android.intent.action.MAIN");
            intent4.addCategory("android.intent.category.HOME");
            try {
                listQueryIntentActivities = packageManager.queryIntentActivities(intent4, 65536);
            } catch (Exception e4) {
                z6.a.c(e4.getMessage());
            }
            if (listQueryIntentActivities != null) {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo2 = it.next().activityInfo;
                    if (activityInfo2 != null && callingPackage.equals(activityInfo2.packageName)) {
                        return 1;
                    }
                }
            }
        }
        return 2;
    }

    public static g8.a b(Context context) throws PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        g8.b bVar = new g8.b(2);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                try {
                    IBinder iBinderA = bVar.a();
                    if (iBinderA != null) {
                        g8.c cVar = new g8.c(2);
                        cVar.f5120c = iBinderA;
                        String strE = cVar.e();
                        cVar.g();
                        g8.a aVar = new g8.a(strE);
                        context.unbindService(bVar);
                        return aVar;
                    }
                    context.unbindService(bVar);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th2) {
                context.unbindService(bVar);
                throw th2;
            }
            context.unbindService(bVar);
            throw th2;
        }
        throw new IOException("Google Play connection failed");
    }

    public static String c(Context context, int i8) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            Class cls2 = Integer.TYPE;
            String str = (String) cls.getMethod("getImei", cls2).invoke(telephonyManager, Integer.valueOf(i8));
            if (TextUtils.isEmpty(str)) {
                str = (String) telephonyManager.getClass().getMethod("getDeviceId", cls2).invoke(telephonyManager, Integer.valueOf(i8));
            }
            return !TextUtils.isEmpty(str) ? EncoderUtil.EncoderByAlgorithm(str) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void d(Context context, File file) {
        if (file.exists() && file.isDirectory() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    j(context, file2);
                } else if (file2.isDirectory()) {
                    d(context, file2);
                }
            }
        }
    }

    public static void e(Context context, String str) {
        File file = new File(str);
        d(context, file);
        if (file.isDirectory()) {
            if (file.listFiles() == null || file.listFiles().length == 0) {
                file.delete();
            }
        }
    }

    public static void f(String str, ArrayList arrayList, String str2) {
        File[] fileArrListFiles;
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                f(file2.getAbsolutePath(), arrayList, str2);
            } else if (str2 == null) {
                arrayList.add(file2);
            } else if (file2.getName().contains(str2)) {
                arrayList.add(file2);
            }
        }
    }

    public static String g() {
        char c9;
        try {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
            if (rawOffset < 0) {
                rawOffset = -rawOffset;
                c9 = '-';
            } else {
                c9 = '+';
            }
            StringBuilder sb2 = new StringBuilder(9);
            sb2.append("GMT");
            sb2.append(c9);
            String string = Integer.toString(rawOffset / 60);
            for (int i8 = 0; i8 < 2 - string.length(); i8++) {
                sb2.append('0');
            }
            sb2.append(string);
            sb2.append(':');
            String string2 = Integer.toString(rawOffset % 60);
            for (int i9 = 0; i9 < 2 - string2.length(); i9++) {
                sb2.append('0');
            }
            sb2.append(string2);
            return sb2.toString();
        } catch (Throwable th2) {
            z6.a.c(Log.getStackTraceString(th2));
            return "";
        }
    }

    public static String h(Context context) {
        if (!TextUtils.isEmpty(f7679a)) {
            return f7679a;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                String strTrim = string.trim();
                String strEncoderByAlgorithm = TextUtils.isEmpty(strTrim) ? "" : EncoderUtil.EncoderByAlgorithm(strTrim);
                f7679a = strEncoderByAlgorithm;
                return strEncoderByAlgorithm;
            }
        } catch (Exception e) {
            z6.a.c(e.getMessage());
        }
        return "";
    }

    public static String i(Context context, int i8) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i8));
            return !TextUtils.isEmpty(str) ? EncoderUtil.EncoderByAlgorithm(str) : "";
        } catch (Exception e) {
            z6.a.c(e.getMessage());
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    public static boolean j(Context context, File file) {
        Throwable th2;
        ?? r7;
        RandomAccessFile randomAccessFile;
        ?? r10;
        FileLock fileLock;
        FileLock fileLock2;
        if (file.getParent().contains(context.getFilesDir().getPath())) {
            File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis());
            file.renameTo(file2);
            return file2.delete();
        }
        FileLock fileLockLock = null;
        try {
            randomAccessFile = new RandomAccessFile(file.getPath(), "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    fileLockLock = channel.lock();
                    File file3 = new File(file.getParent() + File.separator + System.currentTimeMillis());
                    file.renameTo(file3);
                    boolean zDelete = file3.delete();
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        channel.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                    return zDelete;
                } catch (Exception unused4) {
                    fileLock2 = fileLockLock;
                    fileLockLock = channel;
                    FileLock fileLock3 = fileLock2;
                    r10 = fileLockLock;
                    fileLockLock = fileLock3;
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused5) {
                        }
                    }
                    if (r10 != 0) {
                        try {
                            r10.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (IOException unused7) {
                        return false;
                    }
                } catch (Throwable th3) {
                    fileLock = fileLockLock;
                    fileLockLock = channel;
                    th2 = th3;
                    FileLock fileLock4 = fileLock;
                    r7 = fileLockLock;
                    fileLockLock = fileLock4;
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused8) {
                        }
                    }
                    if (r7 != 0) {
                        try {
                            r7.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th2;
                    }
                    try {
                        randomAccessFile.close();
                        throw th2;
                    } catch (IOException unused10) {
                        throw th2;
                    }
                }
            } catch (Exception unused11) {
                fileLock2 = null;
            } catch (Throwable th4) {
                th2 = th4;
                fileLock = null;
            }
        } catch (Exception unused12) {
            r10 = 0;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th2 = th5;
            r7 = 0;
            randomAccessFile = null;
        }
    }

    public static String k() {
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
        } catch (Exception e) {
            z6.a.c(e.getMessage());
        }
        return TextUtils.isEmpty(serial) ? "" : EncoderUtil.EncoderByAlgorithm(serial);
    }

    public static String l(Context context) {
        try {
            return context.getPackageManager().getInstallerPackageName(o(context));
        } catch (Exception e) {
            z6.a.c(e.getMessage());
            return "";
        }
    }

    public static String m(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            simOperator = telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
        }
        return (TextUtils.isEmpty(simOperator) || simOperator.length() < 3) ? "" : simOperator.substring(0, 3);
    }

    public static String n(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            simOperator = telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
        }
        return (TextUtils.isEmpty(simOperator) || simOperator.length() < 3) ? "" : simOperator.substring(3);
    }

    public static String o(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = z6.a.f11258a;
            z6.a.c(Log.getStackTraceString(e));
            return "";
        }
    }

    public static int p(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(o(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            z6.a.c(Log.getStackTraceString(e));
            return 0;
        }
    }

    public static String q(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(o(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            ObjectLogUtils objectLogUtils = z6.a.f11258a;
            z6.a.c(Log.getStackTraceString(e));
            return "";
        }
    }
}
