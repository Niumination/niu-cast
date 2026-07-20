package g9;

import a0.e;
import android.os.Bundle;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.bp.ITranThubBp;
import com.transsion.hubsdk.trancare.trancare.TranTrancareManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import l9.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ITranThubBp f5121a = ITranThubBp.Stub.asInterface(TranServiceManager.getServiceIBinder("thub_bp"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f5122b = Executors.newCachedThreadPool();

    public static /* synthetic */ void a(String str, RemoteException remoteException) {
        boolean zRecordExcp;
        j9.a.a("a", "Catch Thub-sdk Exception form ".concat(str));
        try {
            zRecordExcp = f5121a.recordExcp(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            zRecordExcp = false;
        }
        j9.a.a("a", "recordException.catchEnable=" + zRecordExcp);
        if (zRecordExcp) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strValueOf = String.valueOf(360406001);
            String strValueOf2 = String.valueOf(b.f7353a);
            String strC = c(str, remoteException);
            j9.a.a("a", strC.length() + " eStr=" + strC);
            f(strValueOf2, strValueOf, strC, jCurrentTimeMillis);
        }
    }

    public static /* synthetic */ void b(String str, TimeoutException timeoutException) {
        boolean zRecordTimeout;
        j9.a.a("a", "Thub-sdk Timeout form ".concat(str));
        try {
            zRecordTimeout = f5121a.recordTimeout(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            zRecordTimeout = false;
        }
        j9.a.a("a", "recordTimeout.catchEnable=" + zRecordTimeout);
        if (zRecordTimeout) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strValueOf = String.valueOf(360406001);
            String strValueOf2 = String.valueOf(b.f7353a);
            String strC = c(str, timeoutException);
            if (strC.length() > 2000) {
                strC = strC.substring(0, 2000);
            }
            f(strValueOf2, strValueOf, strC, jCurrentTimeMillis);
        }
    }

    public static String c(String str, Exception exc) {
        StringBuilder sb2 = new StringBuilder();
        String str2 = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        StringBuffer buffer = stringWriter.getBuffer();
        printWriter.close();
        String string = buffer.toString();
        sb2.append(str2);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(string);
        sb2.append("  \r\n");
        return sb2.length() > 2000 ? sb2.substring(0, 2000) : sb2.toString();
    }

    public static void d(String str, RemoteException remoteException) {
        if (!b.a(l9.a.f7342a)) {
            j9.a.b("a", "recordException fail, incompatible version");
        } else if (!TranTrancareManager.isEnabled(933860000022L)) {
            j9.a.a("a", "Thub-sdk thub_excpc(933860000022) is not enable!");
        } else {
            f5122b.submit(new e(11, str, remoteException));
        }
    }

    public static void e(String str, long j8) {
        if (!b.a(l9.a.f7342a)) {
            j9.a.b("a", "recordException fail, incompatible version");
            return;
        }
        if (!TranTrancareManager.isEnabled(933860000022L)) {
            j9.a.a("a", "Thub-sdk thub_excpc(933860000022) is not enable!");
            return;
        }
        f5122b.submit(new e(10, str, new TimeoutException("timeout: " + j8 + "ms")));
    }

    public static void f(String str, String str2, String str3, long j8) {
        Bundle bundle = new Bundle();
        bundle.putString("c_v", str);
        bundle.putString("s_v", str2);
        bundle.putLong("s_t", j8);
        bundle.putString("t_i", str3);
        TranTrancareManager.serverLog(933861000041L, "thub_excp_info", 1, bundle);
    }
}
