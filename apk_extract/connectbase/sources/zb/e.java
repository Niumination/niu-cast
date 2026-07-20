package zb;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranActivityManager;
import com.transsion.hubsdk.bp.ITranThubBp;
import com.transsion.hubsdk.trancare.trancare.TranTrancareManager;
import j1.g;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21890a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f21891b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f21893d = 933860000022L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f21894e = 933861000041L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f21895f = "thub_excp_info";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f21896g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f21897h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21898i = 2000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f21899j = "c_v";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f21900k = "s_v";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f21901l = "s_t";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f21902m = "t_i";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ITranThubBp f21892c = ITranThubBp.Stub.asInterface(TranServiceManager.getServiceIBinder("thub_bp"));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ExecutorService f21903n = Executors.newCachedThreadPool();

    public e(Context context) {
        f21891b = context;
    }

    public static String e(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        StringBuffer buffer = stringWriter.getBuffer();
        printWriter.close();
        return buffer.toString();
    }

    public static String f(Throwable th2, int i10) {
        try {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StringBuilder sb2 = new StringBuilder(th2.toString());
            int i11 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb2.append("\n#" + stackTraceElement.getClassName());
                sb2.append(".");
                sb2.append(stackTraceElement.getMethodName());
                sb2.append("[" + stackTraceElement.getLineNumber() + "]");
                i11++;
                if (i11 >= i10) {
                    break;
                }
            }
            return sb2.toString();
        } catch (Exception e10) {
            dc.e.n(f21890a, "getStackTrace Exception" + e10);
            return "";
        }
    }

    public static /* synthetic */ void g(String str, Throwable th2) {
        boolean zRecordExcp;
        dc.e.a(f21890a, "Catch Thub-sdk Exception form " + str);
        try {
            zRecordExcp = f21892c.recordExcp(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            zRecordExcp = false;
        }
        String str2 = f21890a;
        dc.e.a(str2, "recordException.catchEnable=" + zRecordExcp);
        if (zRecordExcp) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strValueOf = String.valueOf(xb.a.f20138d);
            String strValueOf2 = String.valueOf(fc.b.f5978b);
            String strK = k(th2, str);
            dc.e.a(str2, strK.length() + " eStr=" + strK);
            q(strValueOf2, strValueOf, jCurrentTimeMillis, strK);
        }
        p();
    }

    public static /* synthetic */ void h(String str, Throwable th2) {
        boolean zRecordExcp;
        dc.e.a(f21890a, "Catch Thub-sdk Exception form " + str);
        try {
            zRecordExcp = f21892c.recordExcp(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            zRecordExcp = false;
        }
        String str2 = f21890a;
        dc.e.a(str2, "recordException.catchEnable=" + zRecordExcp);
        if (zRecordExcp) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strValueOf = String.valueOf(xb.a.f20138d);
            String strValueOf2 = String.valueOf(fc.b.f5978b);
            String strK = k(th2, str);
            dc.e.a(str2, strK.length() + " eStr=" + strK);
            q(strValueOf2, strValueOf, jCurrentTimeMillis, strK);
        }
    }

    public static /* synthetic */ void i(String str, TimeoutException timeoutException) {
        boolean zRecordTimeout;
        dc.e.a(f21890a, "Thub-sdk Timeout from " + str);
        try {
            zRecordTimeout = f21892c.recordTimeout(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            zRecordTimeout = false;
        }
        dc.e.a(f21890a, "recordTimeout.catchEnable=" + zRecordTimeout);
        if (zRecordTimeout) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strValueOf = String.valueOf(xb.a.f20138d);
            String strValueOf2 = String.valueOf(fc.b.f5978b);
            String strK = k(timeoutException, str);
            if (strK.length() > 2000) {
                strK = strK.substring(0, 2000);
            }
            q(strValueOf2, strValueOf, jCurrentTimeMillis, strK);
        }
        p();
    }

    public static /* synthetic */ void j(String str, TimeoutException timeoutException) {
        boolean zRecordTimeout;
        dc.e.a(f21890a, "Thub-sdk Timeout form " + str);
        try {
            zRecordTimeout = f21892c.recordTimeout(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            zRecordTimeout = false;
        }
        dc.e.a(f21890a, "recordTimeout.catchEnable=" + zRecordTimeout);
        if (zRecordTimeout) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strValueOf = String.valueOf(xb.a.f20138d);
            String strValueOf2 = String.valueOf(fc.b.f5978b);
            String strK = k(timeoutException, str);
            if (strK.length() > 2000) {
                strK = strK.substring(0, 2000);
            }
            q(strValueOf2, strValueOf, jCurrentTimeMillis, strK);
        }
    }

    public static String k(Throwable th2, String str) {
        StringBuilder sb2 = new StringBuilder();
        String str2 = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        String strE = e(th2);
        sb2.append(str2);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(strE);
        sb2.append("  \r\n");
        return sb2.length() > 2000 ? sb2.substring(0, 2000) : sb2.toString();
    }

    public static void l(Context context, final String str, final Throwable th2) {
        if (!fc.b.b(fc.b.a.f5981a)) {
            dc.e.c(f21890a, "recordException fail, incompatible version");
        } else if (TranTrancareManager.isEnabled(f21893d)) {
            f21903n.submit(new Runnable() { // from class: zb.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(str, th2);
                }
            });
        } else {
            dc.e.a(f21890a, "Thub-sdk thub_excpc(933860000022) is not enable!");
        }
    }

    public static void m(final String str, final Throwable th2) {
        if (!fc.b.b(fc.b.a.f5981a)) {
            dc.e.c(f21890a, "recordException fail, incompatible version");
        } else if (TranTrancareManager.isEnabled(f21893d)) {
            f21903n.submit(new Runnable() { // from class: zb.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.h(str, th2);
                }
            });
        } else {
            dc.e.a(f21890a, "Thub-sdk thub_excpc(933860000022) is not enable!");
        }
    }

    public static void n(Context context, final String str, long j10) {
        if (!fc.b.b(fc.b.a.f5981a)) {
            dc.e.c(f21890a, "recordException fail, incompatible version");
        } else if (!TranTrancareManager.isEnabled(f21893d)) {
            dc.e.a(f21890a, "Thub-sdk thub_excpc(933860000022) is not enable!");
        } else {
            final TimeoutException timeoutException = new TimeoutException(g.a("timeout: ", j10, "ms"));
            f21903n.submit(new Runnable() { // from class: zb.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.i(str, timeoutException);
                }
            });
        }
    }

    public static void o(final String str, long j10) {
        if (!fc.b.b(fc.b.a.f5981a)) {
            dc.e.c(f21890a, "recordException fail, incompatible version");
        } else if (!TranTrancareManager.isEnabled(f21893d)) {
            dc.e.a(f21890a, "Thub-sdk thub_excpc(933860000022) is not enable!");
        } else {
            final TimeoutException timeoutException = new TimeoutException(g.a("timeout: ", j10, "ms"));
            f21903n.submit(new Runnable() { // from class: zb.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.j(str, timeoutException);
                }
            });
        }
    }

    public static void p() {
        ITranActivityManager iTranActivityManagerAsInterface;
        if (!fc.b.b(fc.b.a.f5981a) || (iTranActivityManagerAsInterface = ITranActivityManager.Stub.asInterface(TranServiceManager.getServiceIBinder("activity"))) == null) {
            return;
        }
        try {
            iTranActivityManagerAsInterface.startTNE("0x01010001", 512L, Binder.getCallingPid(), "");
        } catch (RemoteException e10) {
            j7.b.a("startTNE fail:", e10, f21890a);
        }
    }

    public static void q(String str, String str2, long j10, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(f21899j, str);
        bundle.putString(f21900k, str2);
        bundle.putLong(f21901l, j10);
        bundle.putString(f21902m, str3);
        TranTrancareManager.serverLog(Long.valueOf(f21894e), f21895f, 1, bundle);
    }
}
