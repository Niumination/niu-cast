package b2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import c2.e;
import c2.f;
import c2.h;
import c2.i;
import c2.j;
import c2.l;
import c2.m;
import c2.o;
import c2.p;
import c2.r;
import c2.s;
import c2.t;
import c2.u;
import c2.v;
import c2.w;
import e2.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import tj.x;

/* JADX INFO: loaded from: classes.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f1189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f1190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f1191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f1192d;
    public final l2.a e;
    public final l2.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1193g;

    public d(Context context, l2.a aVar, l2.a aVar2) {
        s4.d dVar = new s4.d();
        c2.c cVar = c2.c.f1374a;
        dVar.d(p.class, cVar);
        dVar.d(i.class, cVar);
        f fVar = f.f1385a;
        dVar.d(t.class, fVar);
        dVar.d(m.class, fVar);
        c2.d dVar2 = c2.d.f1376a;
        dVar.d(r.class, dVar2);
        dVar.d(j.class, dVar2);
        c2.b bVar = c2.b.f1363a;
        dVar.d(c2.a.class, bVar);
        dVar.d(h.class, bVar);
        e eVar = e.f1379a;
        dVar.d(s.class, eVar);
        dVar.d(l.class, eVar);
        c2.g gVar = c2.g.f1391a;
        dVar.d(w.class, gVar);
        dVar.d(o.class, gVar);
        dVar.f9505d = true;
        this.f1189a = new x(dVar);
        this.f1191c = context;
        this.f1190b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f1192d = b(a.f1179c);
        this.e = aVar2;
        this.f = aVar;
        this.f1193g = 40000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(h0.a.i("Invalid url: ", str), e);
        }
    }

    public final d2.b a(d2.b bVar) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f1190b.getActiveNetworkInfo();
        d2.a aVarC = bVar.c();
        int i8 = Build.VERSION.SDK_INT;
        HashMap map = (HashMap) aVarC.f4261h;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put("sdk-version", String.valueOf(i8));
        aVarC.a("model", Build.MODEL);
        aVarC.a("hardware", Build.HARDWARE);
        aVarC.a("device", Build.DEVICE);
        aVarC.a("product", Build.PRODUCT);
        aVarC.a("os-uild", Build.ID);
        aVarC.a("manufacturer", Build.MANUFACTURER);
        aVarC.a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        HashMap map2 = (HashMap) aVarC.f4261h;
        if (map2 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map2.put("tz-offset", String.valueOf(offset));
        int value = activeNetworkInfo == null ? v.NONE.getValue() : activeNetworkInfo.getType();
        HashMap map3 = (HashMap) aVarC.f4261h;
        if (map3 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map3.put("net-type", String.valueOf(value));
        int i9 = -1;
        if (activeNetworkInfo == null) {
            subtype = u.UNKNOWN_MOBILE_SUBTYPE.getValue();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = u.COMBINED.getValue();
            } else if (u.forNumber(subtype) == null) {
                subtype = 0;
            }
        }
        HashMap map4 = (HashMap) aVarC.f4261h;
        if (map4 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map4.put("mobile-subtype", String.valueOf(subtype));
        aVarC.a("country", Locale.getDefault().getCountry());
        aVarC.a("locale", Locale.getDefault().getLanguage());
        Context context = this.f1191c;
        aVarC.a("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
        try {
            i9 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Unable to find version code for package", e);
        }
        aVarC.a("application_build", Integer.toString(i9));
        return aVarC.b();
    }
}
