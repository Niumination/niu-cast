package k3;

import android.content.Context;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class be {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static e0 f6380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g0 f6381l = g0.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xd f6384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p5.i f6385d;
    public final q3.k e;
    public final q3.k f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f6388i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap f6389j = new HashMap();

    public be(Context context, p5.i iVar, xd xdVar, String str) {
        this.f6382a = context.getPackageName();
        this.f6383b = p5.c.a(context);
        this.f6385d = iVar;
        this.f6384c = xdVar;
        fe.b();
        this.f6386g = str;
        p5.e eVarA = p5.e.a();
        j3.t tVar = new j3.t(this, 1);
        eVarA.getClass();
        this.e = p5.e.b(tVar);
        p5.e eVarA2 = p5.e.a();
        iVar.getClass();
        j3.u uVar = new j3.u(iVar, 1);
        eVarA2.getClass();
        this.f = p5.e.b(uVar);
        g0 g0Var = f6381l;
        this.f6387h = g0Var.containsKey(str) ? g3.e.d(context, (String) g0Var.get(str), false) : -1;
    }

    public static long a(ArrayList arrayList, double d7) {
        return ((Long) arrayList.get(Math.max(((int) Math.ceil((d7 / 100.0d) * ((double) arrayList.size()))) - 1, 0))).longValue();
    }

    public final void b(ae aeVar, la laVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (d(laVar, jElapsedRealtime)) {
            this.f6388i.put(laVar, Long.valueOf(jElapsedRealtime));
            p5.l.INSTANCE.execute(new yd(this, aeVar.zza(), laVar, c(), 0));
        }
    }

    public final String c() {
        q3.k kVar = this.e;
        return kVar.d() ? (String) kVar.b() : u2.d.f10329c.a(this.f6386g);
    }

    public final boolean d(la laVar, long j8) {
        HashMap map = this.f6388i;
        return map.get(laVar) == null || j8 - ((Long) map.get(laVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }
}
