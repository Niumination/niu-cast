package y3;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.AthenaConfig;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Activity> f20695b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20696a;

        public a(String str, boolean z10) {
            this.f20696a = str;
        }

        public String a() {
            return this.f20696a;
        }
    }

    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f20698b;

        public b() {
            this.f20697a = false;
            this.f20698b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f20697a) {
                throw new IllegalStateException();
            }
            this.f20697a = true;
            return this.f20698b.poll(10L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (this.f20698b.isEmpty()) {
                    this.f20698b.put(iBinder);
                }
            } catch (InterruptedException e10) {
                e10.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class d implements IInterface {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IBinder f20699c;

        public d(IBinder iBinder) {
            this.f20699c = iBinder;
        }

        public String O() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f20699c.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean P(boolean z10) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z10 ? 1 : 0);
                this.f20699c.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f20699c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    public static int a(Activity activity) {
        Intent intent;
        ActivityInfo activityInfo;
        Uri referrer;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        if (intent.getBooleanExtra(AthenaConfig.ATHENA_PUSH_CALL, false)) {
            return 3;
        }
        String callingPackage = activity.getCallingPackage();
        ResolveInfo resolveInfoResolveActivity = null;
        String str = "";
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
        if (!TextUtils.isEmpty(callingPackage) && !callingPackage.equals(packageName)) {
            Intent intent3 = new Intent("android.intent.action.MAIN");
            intent3.addCategory("android.intent.category.HOME");
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager != null) {
                try {
                    resolveInfoResolveActivity = packageManager.resolveActivity(intent3, 0);
                } catch (Exception e10) {
                    y3.b.d(e10.getMessage());
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
            if (!n(activity, callingPackage)) {
                return 2;
            }
        }
        return 1;
    }

    public static List<File> b(String str) {
        List<File> listD = d(str, new ArrayList(), null);
        if (listD != null && listD.size() > 0) {
            try {
                Collections.sort(listD, new h());
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
        return listD;
    }

    public static List<File> c(String str, long j10) {
        List<File> listD = d(str, new ArrayList(), String.valueOf(j10));
        if (listD != null && listD.size() > 0) {
            Collections.sort(listD, new y3.c());
        }
        return listD;
    }

    public static List<File> d(String str, List<File> list, String str2) {
        File[] fileArrListFiles;
        if (str == null) {
            return list;
        }
        File file = new File(str);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return list;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                d(file2.getAbsolutePath(), list, str2);
            } else if (str2 == null) {
                list.add(file2);
            } else if (file2.getName().contains(str2)) {
                list.add(file2);
            }
        }
        return list;
    }

    public static a e(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                try {
                    IBinder iBinderA = bVar.a();
                    if (iBinderA != null) {
                        d dVar = new d(iBinderA);
                        a aVar = new a(dVar.O(), dVar.P(true));
                        context.unbindService(bVar);
                        return aVar;
                    }
                    context.unbindService(bVar);
                } catch (Exception e10) {
                    throw e10;
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

    public static void f() {
        WeakReference<Activity> weakReference = f20695b;
        if (weakReference != null) {
            weakReference.clear();
            f20695b = null;
        }
    }

    public static void g(Context context, File file) throws Throwable {
        if (file.exists() && file.isDirectory() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    m(context, file2);
                } else if (file2.isDirectory()) {
                    g(context, file2);
                }
            }
        }
    }

    public static void h(Context context, String str) throws Throwable {
        File file = new File(str);
        g(context, file);
        if (file.isDirectory()) {
            if (file.listFiles() == null || file.listFiles().length == 0) {
                file.delete();
            }
        }
    }

    public static void i(StringBuilder sb2, int i10) {
        String string = Integer.toString(i10);
        for (int i11 = 0; i11 < 2 - string.length(); i11++) {
            sb2.append('0');
        }
        sb2.append(string);
    }

    public static String j() {
        char c10;
        try {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
            if (rawOffset < 0) {
                rawOffset = -rawOffset;
                c10 = '-';
            } else {
                c10 = '+';
            }
            StringBuilder sb2 = new StringBuilder(9);
            sb2.append("GMT");
            sb2.append(c10);
            i(sb2, rawOffset / 60);
            sb2.append(n1.e.f11184d);
            i(sb2, rawOffset % 60);
            return sb2.toString();
        } catch (Throwable th2) {
            y3.b.d(Log.getStackTraceString(th2));
            return "";
        }
    }

    @b.a({"HardwareIds"})
    public static String k(Context context) {
        if (!TextUtils.isEmpty(f20694a)) {
            return f20694a;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                String strTrim = string.trim();
                String strB = TextUtils.isEmpty(strTrim) ? "" : f6.c.b(strTrim, "SHA-256");
                f20694a = strB;
                return strB;
            }
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
        }
        return "";
    }

    public static void l(Activity activity) {
        f20695b = new WeakReference<>(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    public static boolean m(Context context, File file) throws Throwable {
        Throwable th2;
        ?? r10;
        RandomAccessFile randomAccessFile;
        ?? r11;
        FileLock fileLock;
        FileLock fileLock2;
        if (file == null) {
            return true;
        }
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
                    r11 = fileLockLock;
                    fileLockLock = fileLock3;
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused5) {
                        }
                    }
                    if (r11 != 0) {
                        try {
                            r11.close();
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
                    r10 = fileLockLock;
                    fileLockLock = fileLock4;
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused8) {
                        }
                    }
                    if (r10 != 0) {
                        try {
                            r10.close();
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
            r11 = 0;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th2 = th5;
            r10 = 0;
            randomAccessFile = null;
        }
    }

    public static boolean n(Context context, String str) {
        PackageManager packageManager;
        List<ResolveInfo> listQueryIntentActivities;
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && str.equals(activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    public static Activity o() {
        WeakReference<Activity> weakReference = f20695b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return f20695b.get();
    }

    public static String p(Context context) {
        try {
            return Application.getProcessName();
        } catch (Exception e10) {
            d6.b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public static String q(Context context) {
        try {
            return context.getPackageManager().getInstallerPackageName(t(context));
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
            return "";
        }
    }

    public static String r(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            simOperator = telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
        }
        return (TextUtils.isEmpty(simOperator) || simOperator.length() < 3) ? "" : simOperator.substring(0, 3);
    }

    public static String s(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            simOperator = telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
        }
        return (TextUtils.isEmpty(simOperator) || simOperator.length() < 3) ? "" : simOperator.substring(3);
    }

    public static String t(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e10) {
            d6.b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
            return "";
        }
    }

    public static int u(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(t(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return 0;
        }
    }

    public static String v(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(t(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            d6.b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
            return "";
        }
    }
}
