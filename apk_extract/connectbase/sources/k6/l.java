package k6;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.os.Process;
import android.util.Log;
import com.transsion.athena.data.TrackData;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile l f9150b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9151a;

    public l(Context context) {
        this.f9151a = context;
    }

    public static l a() {
        return f9150b;
    }

    public static void b(Context context) {
        if (f9150b == null) {
            synchronized (l.class) {
                try {
                    if (f9150b == null) {
                        f9150b = new l(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void c(i iVar) {
        String stackTraceString;
        long usableSpace;
        int iD = t3.d.d();
        if (iD == 0 || iVar == null) {
            y3.b.b("trackException tid not configure or e is null");
            return;
        }
        String strA = iVar.a();
        if (strA.contains("addJSON") || strA.contains("updateEvents") || strA.contains("cleanupEvents")) {
            return;
        }
        TrackData trackDataJ = new TrackData().f("count", 1, 1).m("eid", strA).f("pid", Process.myPid(), 2).j("extra", iVar.b(), 2);
        Throwable cause = iVar.getCause();
        if (cause == null) {
            stackTraceString = null;
        } else if (cause instanceof SQLiteFullException) {
            stackTraceString = cause.getClass().getName();
        } else {
            stackTraceString = cause.getCause() != null ? Log.getStackTraceString(cause.getCause()) : Log.getStackTraceString(cause);
            if (stackTraceString.length() > 2048) {
                stackTraceString = stackTraceString.substring(0, 2048);
            }
        }
        TrackData trackDataM = trackDataJ.m("stackTrace", stackTraceString);
        if (strA.contains("sql")) {
            try {
                usableSpace = this.f9151a.getFilesDir().getUsableSpace();
            } catch (Exception e10) {
                e10.printStackTrace();
                usableSpace = 0;
            }
            trackDataM.g("usableSpace", usableSpace);
        }
        g.i0(iD).c1("ev_athena", trackDataM, iD);
    }
}
