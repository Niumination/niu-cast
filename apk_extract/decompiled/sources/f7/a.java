package f7;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4989d;
    public final String e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4991h;

    public a(String serviceInstanceId, String intentId, String str, String str2, String str3, String str4, long j8, String str5) {
        Intrinsics.checkNotNullParameter(serviceInstanceId, "serviceInstanceId");
        Intrinsics.checkNotNullParameter(intentId, "intentId");
        this.f4986a = serviceInstanceId;
        this.f4987b = intentId;
        this.f4988c = str;
        this.f4989d = str2;
        this.e = str3;
        this.f = str4;
        this.f4990g = j8;
        this.f4991h = str5;
    }

    public String a() {
        return this.f4988c;
    }

    public String b() {
        return this.e;
    }

    public long c() {
        return this.f4990g;
    }

    public String d() {
        return this.f4989d;
    }

    public String e() {
        return this.f4987b;
    }

    public String f() {
        return this.f4991h;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.f4986a;
    }

    public JSONObject i() throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("serviceInstanceId", h());
        jSONObject2.put("intentId", e());
        jSONObject2.put("dataVersion", c());
        String strD = d();
        if (strD != null) {
            jSONObject2.put("entry", strD);
        }
        String strB = b();
        if (strB != null) {
            jSONObject2.put("cardSize", strB);
        }
        String strG = g();
        if (strG != null) {
            jSONObject2.put("pageId", strG);
        }
        try {
            String strF = f();
            jSONObject = strF != null ? new JSONObject(strF) : new JSONObject();
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("updateTime", System.currentTimeMillis());
        jSONObject2.put("options", jSONObject.toString());
        return jSONObject2;
    }

    public String j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strA = a();
        if (strA != null) {
            jSONObject.put("businessData", strA);
        }
        jSONObject.put("cardData", i().toString());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return string;
    }

    public String toString() {
        String strE = e();
        String strA = a();
        return h0.a.n(h0.a.p("AtomicCoreObject(", strE, ", ", strA != null ? StringsKt.take(strA, 30) : null, ", "), f(), ")");
    }
}
