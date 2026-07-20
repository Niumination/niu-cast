package e8;

import af.r5;
import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.os.Process;
import android.util.Log;
import com.transsion.athena.data.TrackData;
import dj.m;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f4735b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4736a;

    public void a(d dVar) {
        String stackTraceString;
        long usableSpace;
        int i8 = t6.d.f10184a;
        if (i8 == 0) {
            z6.a.a("trackException tid not configure or e is null");
            return;
        }
        String strA = dVar.a();
        if (strA.contains("addJSON") || strA.contains("updateEvents") || strA.contains("cleanupEvents")) {
            return;
        }
        TrackData trackData = new TrackData();
        trackData.b(1, 1, "count");
        trackData.e(0, "eid", strA);
        trackData.b(Process.myPid(), 2, "pid");
        trackData.d(2, "extra", dVar.b());
        Throwable cause = dVar.getCause();
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
        trackData.g("stackTrace", stackTraceString);
        if (strA.contains("sql")) {
            try {
                usableSpace = this.f4736a.getFilesDir().getUsableSpace();
            } catch (Exception e) {
                e.printStackTrace();
                usableSpace = 0;
            }
            trackData.f("usableSpace", usableSpace);
        }
        long j8 = i8;
        b.n(j8).o("ev_athena", trackData, j8);
    }

    public d2.e b() {
        Context context = this.f4736a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        d2.e eVar = new d2.e();
        eVar.f4272a = f2.a.a(d2.g.f4278a);
        w wVar = new w(context, 7);
        eVar.f4273b = wVar;
        eVar.f4274c = f2.a.a(new y6.g(wVar, new a8.a(wVar, 5)));
        yh.a aVarA = f2.a.a(new o5.c(new se.e(eVar.f4273b, 12)));
        eVar.f4275d = aVarA;
        se.g gVar = new se.g(2);
        w wVar2 = eVar.f4273b;
        u6.a aVar = new u6.a(wVar2, 6, aVarA, gVar);
        yh.a aVar2 = eVar.f4272a;
        yh.a aVar3 = eVar.f4274c;
        r5 r5Var = new r5(aVar2, aVar3, aVar, aVarA, aVarA, 2);
        d2.a aVar4 = new d2.a();
        aVar4.f4257a = wVar2;
        aVar4.f4258b = aVar3;
        aVar4.f4259c = aVarA;
        aVar4.f4260d = aVar;
        aVar4.e = aVar2;
        aVar4.f4261h = aVarA;
        eVar.e = f2.a.a(new u6.a(r5Var, 4, aVar4, new m(aVar2, aVarA, aVar, aVarA)));
        return eVar;
    }
}
