package o3;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k6.i;
import org.json.JSONArray;
import org.json.JSONObject;
import p6.s;
import s3.c;
import s3.d;
import s3.e;
import s3.f;
import s3.g;
import s3.h;
import w3.j;
import y3.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f12071c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p3.a f12072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f12073b = new d();

    public a(p3.a aVar) {
        this.f12072a = aVar;
    }

    public static a b(p3.a aVar) {
        if (f12071c == null) {
            synchronized (a.class) {
                try {
                    if (f12071c == null) {
                        f12071c = new a(aVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f12071c;
    }

    public List<f> a() {
        return this.f12073b.b();
    }

    public c c(long j10) {
        c cVar = new c();
        String strA = this.f12073b.a(j10);
        if (TextUtils.isEmpty(strA)) {
            strA = g.c(true);
        }
        StringBuilder sbA = k.a.a(strA);
        sbA.append(g.f14975h);
        cVar.f14952a = sbA.toString();
        cVar.f14953b = m();
        cVar.f14954c = this.f12073b.f().v();
        return cVar;
    }

    public void d(int i10) {
        List<f> listB = this.f12073b.b();
        Iterator<f> it = listB.iterator();
        while (it.hasNext()) {
            if (it.next().g() == i10) {
                return;
            }
        }
        f fVar = new f();
        fVar.f14957a = i10;
        listB.add(fVar);
    }

    public void e(Handler handler, n3.a aVar) {
        if (g.O()) {
            h hVarF = this.f12073b.f();
            if (hVarF.h(32)) {
                j.d().e(new w3.f(handler, hVarF, aVar));
            }
            for (f fVar : this.f12073b.b()) {
                int iR = fVar.r();
                long jI = iR > 0 ? ((long) iR) * 3600000 : hVarF.i();
                if (fVar.f(jI, 32)) {
                    j.d().e(new w3.g(fVar, jI, aVar));
                }
            }
        }
    }

    @WorkerThread
    public void f(@NonNull String str) {
        try {
            h hVarF = this.f12073b.f();
            JSONObject jSONObject = new JSONObject(str);
            hVarF.u(jSONObject.getLong("cv") * 3600000);
            hVarF.w(jSONObject.getLong("threshold"));
            hVarF.n(jSONObject.getInt("once") == 1);
            if (jSONObject.has("networks")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("networks");
                hVarF.r(jSONObject2.getString(RtspHeaders.Values.URL));
                hVarF.m(jSONObject2.getJSONObject("tids"));
            }
            if (jSONObject.has("p")) {
                hVarF.f(jSONObject.getJSONArray("p"));
            }
            if (jSONObject.has("ver")) {
                hVarF.y(jSONObject.getLong("ver"));
            }
            if (jSONObject.has("delays")) {
                String[] strArrSplit = jSONObject.getString("delays").split(ks.g.f9491d);
                hVarF.d(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
            }
            if (jSONObject.has("tz")) {
                hVarF.l(jSONObject.getString("tz"));
            }
            if (jSONObject.has("dlt")) {
                hVarF.t(jSONObject.getInt("dlt"));
            }
            hVarF.j(jSONObject.optInt("geo", 6));
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            i.a("updateGlobalConfig", e10);
        }
    }

    public void g(List<f> list) {
        this.f12073b.e(list);
    }

    public void h(@NonNull f fVar, @NonNull String str) {
        f fVar2 = fVar;
        String str2 = "cfg";
        String str3 = "iw";
        String str4 = "gpct";
        String str5 = "upct";
        String str6 = "pr";
        String str7 = "stats";
        String str8 = "cv";
        String str9 = "frq";
        try {
            String str10 = "ur";
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ver")) {
                fVar2.m(jSONObject.getLong("ver"));
            }
            if (jSONObject.has(RtspHeaders.Values.URL)) {
                fVar2.t(jSONObject.getString(RtspHeaders.Values.URL));
            }
            if (jSONObject.has("interval")) {
                fVar2.l(jSONObject.getInt("interval"));
            }
            if (jSONObject.has("offline")) {
                fVar2.p(jSONObject.getInt("offline"));
            }
            if (jSONObject.has("url_config")) {
                fVar2.n(jSONObject.getString("url_config"));
            }
            if (jSONObject.has("data")) {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                if (jSONArray.length() > 0) {
                    int i10 = 0;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0).getJSONObject("cfg");
                    int i11 = 0;
                    while (i11 < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i11).getJSONObject(str2);
                        JSONArray jSONArray2 = jSONArray.getJSONObject(i11).getJSONArray("tids");
                        int i12 = i10;
                        while (i12 < jSONArray2.length()) {
                            JSONObject jSONObject4 = jSONObject2;
                            long j10 = jSONArray2.getLong(i12);
                            s3.a aVarA = fVar2.a(j10);
                            if (aVarA == null) {
                                s3.a aVar = new s3.a();
                                aVar.f14934a = j10;
                                fVar2.d(aVar);
                                aVarA = aVar;
                            }
                            int iOptInt = jSONObject4.optInt(str8, 0);
                            if (jSONObject3.has(str8)) {
                                iOptInt = jSONObject3.getInt(str8);
                            }
                            s3.b bVarF = aVarA.f();
                            String str11 = str8;
                            JSONObject jSONObject5 = jSONObject;
                            long j11 = iOptInt;
                            if (iOptInt > 0) {
                                j11 *= 60000;
                            }
                            bVarF.h(j11);
                            int iOptInt2 = jSONObject4.optInt("gmin", 0);
                            if (jSONObject3.has("gmin")) {
                                iOptInt2 = jSONObject3.getInt("gmin");
                            }
                            aVarA.f().j(iOptInt2);
                            int iOptInt3 = jSONObject4.optInt("gmax", 100);
                            if (jSONObject3.has("gmax")) {
                                iOptInt3 = jSONObject3.getInt("gmax");
                            }
                            aVarA.f().g(iOptInt3);
                            int iOptInt4 = jSONObject4.optInt("num", 0);
                            if (jSONObject3.has("num")) {
                                iOptInt4 = jSONObject3.getInt("num");
                            }
                            aVarA.f().p(iOptInt4);
                            int iOptInt5 = jSONObject4.optInt(s.f13016a, 10);
                            if (jSONObject3.has(s.f13016a)) {
                                iOptInt5 = jSONObject3.getInt(s.f13016a);
                            }
                            aVarA.f().n(((long) iOptInt5) * 60000);
                            String str12 = str3;
                            int iOptInt6 = jSONObject4.optInt(str12, 0);
                            if (jSONObject3.has(str12)) {
                                iOptInt6 = jSONObject3.getInt(str12);
                            }
                            aVarA.f().r(iOptInt6);
                            String str13 = str10;
                            int iOptInt7 = jSONObject4.optInt(str13, 100);
                            if (jSONObject3.has(str13)) {
                                iOptInt7 = jSONObject3.getInt(str13);
                            }
                            aVarA.f().z(iOptInt7);
                            String str14 = str9;
                            int iOptInt8 = jSONObject4.optInt(str14, 0);
                            if (jSONObject3.has(str14)) {
                                iOptInt8 = jSONObject3.getInt(str14);
                            }
                            str3 = str12;
                            aVarA.f().d(((long) (iOptInt8 * 60)) * 1000);
                            String str15 = str7;
                            int iOptInt9 = jSONObject4.optInt(str15, 0);
                            if (jSONObject3.has(str15)) {
                                iOptInt9 = jSONObject3.getInt(str15);
                            }
                            aVarA.f().v(iOptInt9);
                            String str16 = str6;
                            int iOptInt10 = jSONObject4.optInt(str16, 0);
                            if (jSONObject3.has(str16)) {
                                iOptInt10 = jSONObject3.getInt(str16);
                            }
                            str7 = str15;
                            aVarA.f().t(iOptInt10);
                            String str17 = str5;
                            int iOptInt11 = jSONObject4.optInt(str17, 1);
                            if (jSONObject3.has(str17)) {
                                iOptInt11 = jSONObject3.getInt(str17);
                            }
                            aVarA.f().x(iOptInt11);
                            String str18 = str4;
                            int iOptInt12 = jSONObject4.optInt(str18, 1);
                            if (jSONObject3.has(str18)) {
                                iOptInt12 = jSONObject3.getInt(str18);
                            }
                            str4 = str18;
                            aVarA.f().m(iOptInt12);
                            i12++;
                            fVar2 = fVar;
                            str9 = str14;
                            str10 = str13;
                            str8 = str11;
                            str6 = str16;
                            str2 = str2;
                            jSONObject2 = jSONObject4;
                            str5 = str17;
                            jSONObject = jSONObject5;
                        }
                        i11++;
                        fVar2 = fVar;
                        str8 = str8;
                        jSONObject2 = jSONObject2;
                        str5 = str5;
                        jSONObject = jSONObject;
                        i10 = 0;
                    }
                }
            }
            JSONObject jSONObject6 = jSONObject;
            if (jSONObject6.has("table")) {
                JSONObject jSONObject7 = jSONObject6.getJSONObject("table");
                for (s3.a aVar2 : fVar.y()) {
                    String strOptString = jSONObject7.optString(String.valueOf(aVar2.e()), "");
                    if (strOptString.length() > 0) {
                        aVar2.j(strOptString);
                    }
                }
            }
            f fVarD = this.f12073b.d(t3.d.d());
            if (fVarD == null) {
                return;
            }
            g.f(fVarD.x());
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            i.a("updateAppConfig", e10);
        }
    }

    public List<s3.a> i(int i10) {
        if (i10 == -1) {
            return this.f12073b.g();
        }
        f fVarD = this.f12073b.d(i10);
        return fVarD != null ? fVarD.y() : Collections.emptyList();
    }

    public d j() {
        return this.f12073b;
    }

    public final void k() {
        String str;
        try {
            this.f12072a.getClass();
            byte[] bArrK = e.k("63D4BEBEBC7ABCA4BC6A796B6AB06B766A6C7D706B6B756F70B07B6F71A4A5AEBCB2D4BEBEBC6A69BCA4BC7A6B69B16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6A7BBCA4BC7A6B7BB16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F69BCA4BC7A6B69B06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F7BBCA4BC7A6B7BB06B767D72726A6C65B07B6F71BCB2D4BEBEBC7BBCA4BCAF726F777B6F7078AF68A8AF696E726F7D7A7B6F7078BCB2D4BEBEBC77BCA4BCAF726F777B6F7078AF68ADAF6B797B6C796ABCB2D4BEBEBC69BCA4BCAF7D6A7679707DAF7B76797B736E6F75706AAF68ACAF696E726F7D7ABCB2D4BEBEBC787BBCA4BC68AEAC7BBCB2D4BEBEBC787ABCA4BC68AEAC7ABCB2D4BEBEBC7879BCA4BC68AEAC79BCB2D4BEBEBC7568BCA4BC7D7C7B7A79787776757473AD71706F6EBCB2D4BEBEBC67BCA4BCABA7ADA899A99B9CAD9CA5A6AC9BAEABA9AEADAB99A9ACADA8A79D9D98A9AA9DBCD461D4D4");
            if (bArrK == null) {
                str = "";
            } else {
                for (int i10 = 0; i10 < bArrK.length; i10++) {
                    bArrK[i10] = (byte) (222 - ((char) bArrK[i10]));
                }
                str = new String(bArrK);
            }
            g.r(str);
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            i.a("initSDKConfig", e10);
        } finally {
            this.f12072a.a(g.f14977j);
            this.f12072a.b(g.f14980m);
        }
    }

    @WorkerThread
    public void l() {
        try {
            k();
            d dVarC = d.c(this.f12072a.f());
            if (dVarC == null) {
                this.f12072a.e(this.f12073b.i());
            } else {
                this.f12073b = dVarC;
            }
            f fVarD = this.f12073b.d(t3.d.d());
            if (fVarD == null) {
                return;
            }
            g.f(fVarD.x());
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
    }

    @NonNull
    public Pair<Integer, byte[]> m() {
        List<byte[]> listB = this.f12073b.f().b();
        if (!e.m(listB)) {
            return new Pair<>(0, g.f14981n);
        }
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() % ((long) listB.size()));
        return new Pair<>(Integer.valueOf(iCurrentTimeMillis), listB.get(iCurrentTimeMillis));
    }

    public void n() {
        this.f12073b.h();
        this.f12072a.e(this.f12073b.i());
    }

    public void o() {
        h hVarF = this.f12073b.f();
        hVarF.e(y3.e.v(k6.g.h0()));
        hVarF.g(true);
        this.f12072a.e(this.f12073b.i());
    }

    public void p() {
        p3.a aVar = this.f12072a;
        if (aVar != null) {
            aVar.e(this.f12073b.i());
        }
    }
}
