package m6;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.transsion.iotcardsdk.bean.DeviceType;
import i1.b;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.dd;
import org.json.JSONObject;
import s6.c;
import s6.d;
import s6.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f7946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SecureRandom f7947d = new SecureRandom();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n6.a f7948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f7949b;

    public a() {
        if (o6.a.f == null) {
            synchronized (o6.a.class) {
                try {
                    if (o6.a.f == null) {
                        o6.a.f = new o6.a(0);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        o6.a aVar = o6.a.f;
        if (n6.a.f8120d == null) {
            synchronized (n6.a.class) {
                try {
                    if (n6.a.f8120d == null) {
                        n6.a aVar2 = new n6.a(0);
                        aVar2.f8123c = new b(5);
                        aVar2.f8122b = aVar;
                        n6.a.f8120d = aVar2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        this.f7948a = n6.a.f8120d;
    }

    public static boolean d(float f) {
        boolean z2 = true;
        if (f != 1.0f) {
            int i8 = (int) (10000.0f * f);
            int iAbs = Math.abs(f7947d.nextInt()) % ModuleDescriptor.MODULE_VERSION;
            z2 = iAbs < i8;
            z6.a.b("checkSamplingRate false, samplingRate : %f, samplingRateInTenThousand : %d, randomHash : %d", Float.valueOf(f), Integer.valueOf(i8), Integer.valueOf(iAbs));
        }
        return z2;
    }

    public static a f() {
        if (f7946c == null) {
            synchronized (a.class) {
                try {
                    if (f7946c == null) {
                        f7946c = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f7946c;
    }

    public final int a(int i8, String str, float f) {
        s6.a aVar;
        if (!this.f7949b) {
            z6.a.a("isTidEnable init not completed");
            return 101;
        }
        if (!d.f9553t) {
            z6.a.a("isTidEnable sdk disable");
            return 100;
        }
        b bVar = (b) this.f7948a.f8123c;
        e eVar = (e) bVar.f5527a;
        c cVarC = bVar.c(i8);
        if (dd.g(eVar.f9568l) || cVarC == null || dd.g(cVarC.f)) {
            if ("location#page_view#athena_anr_full#athena_crash_full".contains(str)) {
                return 102;
            }
            if (d(f)) {
                return 0;
            }
            return DeviceType.INFRARED_AIR_CONDITION;
        }
        Iterator it = cVarC.f.iterator();
        do {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = (s6.a) it.next();
        } while (!TextUtils.equals(aVar.f9514b, str));
        if (aVar != null) {
            if (!aVar.a()) {
                z6.a.a("isTidEnable device is not in sampling range");
                return DeviceType.INFRARED_AIR_CONDITION;
            }
            s6.b bVar2 = aVar.f9515c;
            if (bVar2 != null && bVar2.b() >= 0) {
                return 0;
            }
            z6.a.a("isTidEnable tid config is closed");
            return 104;
        }
        try {
            String str2 = z6.b.f11259a;
            if (!(d.p || TextUtils.equals(d.q, "test"))) {
                return DeviceType.INFRARED_TV_BOX;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", i8);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            z6.a.d("invalid or not registered:%s", jSONObject.toString());
            return DeviceType.INFRARED_TV_BOX;
        } catch (Exception e) {
            z6.a.d("checkTidEnable exception:%s", e.getMessage());
            return DeviceType.INFRARED_TV_BOX;
        }
    }

    public final int b(long j8, float f) {
        s6.a aVar;
        if (!this.f7949b) {
            z6.a.a("isTidEnable init not completed");
            return 101;
        }
        if (!d.f9553t) {
            z6.a.a("isTidEnable sdk disable");
            return 100;
        }
        b bVar = (b) this.f7948a.f8123c;
        e eVar = (e) bVar.f5527a;
        c cVarC = bVar.c(z6.b.a(j8));
        if (dd.g(eVar.f9568l) || cVarC == null || dd.g(cVarC.f)) {
            if (d(f)) {
                return 0;
            }
            return DeviceType.INFRARED_AIR_CONDITION;
        }
        Iterator it = cVarC.f.iterator();
        do {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = (s6.a) it.next();
        } while (aVar.f9513a != j8);
        if (aVar == null) {
            z6.a.a("isTidEnable tid config is null");
            return DeviceType.INFRARED_TV_BOX;
        }
        if (!aVar.a()) {
            z6.a.a("isTidEnable tid " + aVar.f9513a + " is not in sampling range");
            return DeviceType.INFRARED_AIR_CONDITION;
        }
        s6.b bVar2 = aVar.f9515c;
        if (bVar2 != null && bVar2.b() >= 0) {
            return 0;
        }
        z6.a.a("isTidEnable tid config is closed");
        return 104;
    }

    public final a7.a c(long j8) {
        String strA;
        a7.a aVar = new a7.a();
        n6.a aVar2 = this.f7948a;
        e eVar = (e) ((b) aVar2.f8123c).f5527a;
        eVar.getClass();
        String strValueOf = String.valueOf(j8);
        JSONObject jSONObject = eVar.e;
        if (jSONObject == null || !jSONObject.has(strValueOf)) {
            strA = null;
        } else {
            try {
                strA = eVar.e.getString(strValueOf);
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
                strA = null;
            }
        }
        if (TextUtils.isEmpty(strA)) {
            strA = eVar.f9562d;
        }
        if (TextUtils.isEmpty(strA)) {
            strA = d.a(true);
        }
        StringBuilder sbS = o.d.s(strA);
        sbS.append(d.f9543h);
        aVar.f40a = sbS.toString();
        aVar.f42c = aVar2.i();
        aVar.f41b = ((e) ((b) aVar2.f8123c).f5527a).f9560b;
        return aVar;
    }

    public final s6.a e(long j8) {
        b bVar = (b) this.f7948a.f8123c;
        bVar.getClass();
        c cVarC = bVar.c(z6.b.a(j8));
        if (cVarC == null) {
            return null;
        }
        for (s6.a aVar : cVarC.f) {
            if (aVar.f9513a == j8) {
                return aVar;
            }
        }
        return null;
    }

    public final void g() {
        n6.a aVar = this.f7948a;
        b bVar = (b) aVar.f8123c;
        for (c cVar : (CopyOnWriteArrayList) bVar.f5528b) {
            cVar.f9532d = 0L;
            cVar.c(-1L);
        }
        e eVar = (e) bVar.f5527a;
        eVar.f = 0L;
        eVar.f9563g = -1L;
        ((o6.a) aVar.f8122b).h(((b) aVar.f8123c).d());
    }
}
