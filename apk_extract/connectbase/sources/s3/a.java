package s3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14926e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14927f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14928g = 101;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14929h = 102;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f14930i = 103;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14931j = 104;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f14932k = 105;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f14933l = 106;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f14936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14937d;

    public a() {
        this.f14936c = new b();
    }

    @Nullable
    public static a c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.f14934a = jSONObject.getLong("tid");
            aVar.f14936c = b.b(jSONObject.getJSONObject("tidConfig"));
            return aVar;
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public boolean a(long j10) {
        if (this.f14936c.f() == 0) {
            return true;
        }
        return j10 >= this.f14936c.f() + this.f14937d;
    }

    public boolean b(long j10) {
        long jY = this.f14936c.y();
        long jW = this.f14936c.w();
        if (jY == -1 || jW == -1) {
            return false;
        }
        boolean z10 = Math.abs(j10 - jY) >= jW;
        boolean z11 = this.f14936c.q() > 0 && this.f14936c.q() <= this.f14936c.a();
        int iS = this.f14936c.s();
        if (iS == 0 || (iS == 1 && y3.f.f(k6.g.h0()))) {
            return z10 || z11;
        }
        return false;
    }

    public String d() {
        return this.f14935b;
    }

    public long e() {
        return this.f14934a;
    }

    public b f() {
        return this.f14936c;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    public boolean g() {
        boolean z10;
        int iL = this.f14936c.l();
        int i10 = this.f14936c.i();
        int iO = this.f14936c.o();
        int iC = this.f14936c.C();
        int iB = this.f14936c.B();
        if (iC == 100 && iL == 0 && i10 == 100 && iO == 1 && iB == 1) {
            return true;
        }
        String strB = !TextUtils.isEmpty(y3.d.b()) ? y3.d.b() : y3.e.k(k6.g.h0());
        if (TextUtils.isEmpty(strB)) {
            z10 = true;
        } else {
            int iAbs = Math.abs(strB.hashCode()) % (iO * 100);
            if (iAbs < iL || iAbs > i10) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        boolean z11 = Math.abs(n3.b.f11342d.nextInt()) % (iB * 100) < iC;
        if (y3.d.g()) {
            y3.b.f("gaidHashHit: " + z10 + " eventHashHit: " + z11 + " gmin = " + iL + " gmax = " + i10);
        }
        return z10 && z11;
    }

    public boolean h() {
        return this.f14936c.u() == 0;
    }

    public boolean i() {
        b bVar = this.f14936c;
        return bVar != null && bVar.w() >= 0;
    }

    public void j(String str) {
        this.f14935b = str;
    }

    public void k(long j10) {
        this.f14937d = j10;
    }

    public void l(long j10) {
        this.f14934a = j10;
    }

    public void m(b bVar) {
        this.f14936c = bVar;
    }

    public JSONObject n() {
        try {
            return new JSONObject().put("tid", e()).put("tidConfig", this.f14936c.D());
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public a(long j10, String str, b bVar) {
        new b();
        this.f14934a = j10;
        this.f14935b = str;
        this.f14936c = bVar;
    }
}
