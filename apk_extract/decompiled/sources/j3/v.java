package j3;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f6087b = g.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6088a;

    public v(Context context, p5.i iVar) {
        new HashMap();
        new HashMap();
        context.getPackageName();
        p5.c.a(context);
        synchronized (z.class) {
            if (z.f6092a == null) {
                z.f6092a = new z();
            }
        }
        this.f6088a = "common";
        p5.e eVarA = p5.e.a();
        t tVar = new t(this, 0);
        eVarA.getClass();
        p5.e.b(tVar);
        p5.e eVarA2 = p5.e.a();
        iVar.getClass();
        u uVar = new u(iVar, 0);
        eVarA2.getClass();
        p5.e.b(uVar);
        g gVar = f6087b;
        if (gVar.containsKey("common")) {
            g3.e.d(context, (String) gVar.get("common"), false);
        }
    }
}
