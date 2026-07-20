package n3;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import java.security.SecureRandom;
import java.util.List;
import org.json.JSONObject;
import s3.c;
import s3.e;
import s3.f;
import s3.g;
import s3.h;
import y3.d;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f11341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static SecureRandom f11342d = new SecureRandom();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o3.a f11343a = o3.a.b(p3.a.d());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f11344b;

    public static b l() {
        if (f11341c == null) {
            synchronized (b.class) {
                try {
                    if (f11341c == null) {
                        f11341c = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f11341c;
    }

    public int a(int i10, String str, float f10) {
        if (!this.f11344b) {
            y3.b.b("isTidEnable init not completed");
            return 101;
        }
        if (!g.O()) {
            y3.b.b("isTidEnable sdk disable");
            return 100;
        }
        h hVarF = this.f11343a.j().f();
        f fVarD = this.f11343a.j().d(i10);
        if (e.j(hVarF.b()) || fVarD == null || fVarD.A()) {
            if (!g.f14989v || "location#page_view#athena_anr_full#athena_crash_full".contains(str)) {
                return 102;
            }
            return k(f10) ? 0 : 105;
        }
        s3.a aVarH = fVarD.h(str);
        if (aVarH != null) {
            if (!aVarH.g()) {
                y3.b.b("isTidEnable device is not in sampling range");
                return 105;
            }
            if (aVarH.i()) {
                return 0;
            }
            y3.b.b("isTidEnable tid config is closed");
            return 104;
        }
        try {
            if (!d.g()) {
                return 103;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", i10);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            y3.b.e("invalid or not registered:%s", jSONObject.toString());
            return 103;
        } catch (Exception e10) {
            y3.b.e("checkTidEnable exception:%s", e10.getMessage());
            return 103;
        }
    }

    public int b(long j10, float f10) {
        if (!this.f11344b) {
            y3.b.b("isTidEnable init not completed");
            return 101;
        }
        if (!g.O()) {
            y3.b.b("isTidEnable sdk disable");
            return 100;
        }
        h hVarF = this.f11343a.j().f();
        s3.d dVarJ = this.f11343a.j();
        dVarJ.getClass();
        f fVarD = dVarJ.d(d.a(j10));
        if (e.j(hVarF.b()) || fVarD == null || fVarD.A()) {
            if (g.f14989v) {
                return k(f10) ? 0 : 105;
            }
            return 102;
        }
        s3.a aVarA = fVarD.a(j10);
        if (aVarA == null) {
            y3.b.b("isTidEnable tid config is null");
            return 103;
        }
        if (aVarA.g()) {
            if (aVarA.i()) {
                return 0;
            }
            y3.b.b("isTidEnable tid config is closed");
            return 104;
        }
        y3.b.b("isTidEnable tid " + aVarA.e() + " is not in sampling range");
        return 105;
    }

    public List<f> c() {
        return this.f11343a.a();
    }

    public s3.a d(int i10, String str) {
        f fVarD = this.f11343a.j().d(i10);
        if (fVarD != null) {
            return fVarD.h(str);
        }
        return null;
    }

    public c e(long j10) {
        return this.f11343a.c(j10);
    }

    public void f(int i10) {
        this.f11343a.d(i10);
    }

    public void g(Handler handler, a aVar) {
        this.f11343a.e(handler, aVar);
    }

    public void h(String str) {
        this.f11343a.f(str);
    }

    public void i(List<f> list) {
        this.f11343a.g(list);
    }

    public void j(f fVar, String str) {
        this.f11343a.h(fVar, str);
    }

    public final boolean k(float f10) {
        boolean z10 = true;
        if (f10 != 1.0f) {
            int i10 = (int) (10000.0f * f10);
            int iAbs = Math.abs(f11342d.nextInt()) % 10000;
            z10 = iAbs < i10;
            y3.b.c("checkSamplingRate false, samplingRate : %f, samplingRateInTenThousand : %d, randomHash : %d", Float.valueOf(f10), Integer.valueOf(i10), Integer.valueOf(iAbs));
        }
        return z10;
    }

    public s3.a m(long j10) {
        s3.d dVarJ = this.f11343a.j();
        dVarJ.getClass();
        f fVarD = dVarJ.d(d.a(j10));
        if (fVarD == null) {
            return null;
        }
        for (s3.a aVar : fVarD.y()) {
            if (aVar.e() == j10) {
                return aVar;
            }
        }
        return null;
    }

    public f n(int i10) {
        return this.f11343a.j().d(i10);
    }

    public List<byte[]> o() {
        return this.f11343a.j().f().b();
    }

    public List<s3.a> p(int i10) {
        return this.f11343a.i(i10);
    }

    public int q() {
        return this.f11343a.j().f().s();
    }

    public String r() {
        return this.f11343a.j().f().x();
    }

    public int s() {
        return this.f11343a.j().f().z();
    }

    @WorkerThread
    public void t() {
        this.f11343a.l();
        this.f11344b = true;
    }

    public Pair<Integer, byte[]> u() {
        return this.f11343a.m();
    }

    public void v() {
        this.f11343a.n();
    }

    public void w() {
        this.f11343a.o();
    }

    public void x() {
        this.f11343a.p();
    }
}
