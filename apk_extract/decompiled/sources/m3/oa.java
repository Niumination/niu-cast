package m3;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class oa {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static va f7819j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final xa f7820k = xa.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final na f7823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p5.i f7824d;
    public final q3.k e;
    public final q3.k f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f7827i = new HashMap();

    public oa(Context context, p5.i iVar, na naVar) {
        new HashMap();
        this.f7821a = context.getPackageName();
        this.f7822b = p5.c.a(context);
        this.f7824d = iVar;
        this.f7823c = naVar;
        sa.b();
        this.f7825g = "vision-common";
        p5.e eVarA = p5.e.a();
        j3.t tVar = new j3.t(this, 2);
        eVarA.getClass();
        this.e = p5.e.b(tVar);
        p5.e eVarA2 = p5.e.a();
        iVar.getClass();
        j3.u uVar = new j3.u(iVar, 2);
        eVarA2.getClass();
        this.f = p5.e.b(uVar);
        xa xaVar = f7820k;
        this.f7826h = xaVar.containsKey("vision-common") ? g3.e.d(context, (String) xaVar.get("vision-common"), false) : -1;
    }
}
