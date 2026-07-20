package e7;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends f7.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f4698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f4699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f4700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f4701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f4702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f4703o;
    public final String p;
    public final long q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f4704r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f4705s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String serviceInstanceId, String intentId, String str, String str2, String str3, String str4, long j8, String str5, long j10, long j11, String str6) {
        super(serviceInstanceId, intentId, str, str2, str3, str4, j8, str5);
        Intrinsics.checkNotNullParameter(serviceInstanceId, "serviceInstanceId");
        Intrinsics.checkNotNullParameter(intentId, "intentId");
        this.f4697i = serviceInstanceId;
        this.f4698j = intentId;
        this.f4699k = str;
        this.f4700l = str2;
        this.f4701m = str3;
        this.f4702n = str4;
        this.f4703o = j8;
        this.p = str5;
        this.q = j10;
        this.f4704r = j11;
        this.f4705s = str6;
    }

    @Override // f7.a
    public final String a() {
        return this.f4699k;
    }

    @Override // f7.a
    public final String b() {
        return this.f4701m;
    }

    @Override // f7.a
    public final long c() {
        return this.f4703o;
    }

    @Override // f7.a
    public final String d() {
        return this.f4700l;
    }

    @Override // f7.a
    public final String e() {
        return this.f4698j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f4697i, aVar.f4697i) && Intrinsics.areEqual(this.f4698j, aVar.f4698j) && Intrinsics.areEqual(this.f4699k, aVar.f4699k) && Intrinsics.areEqual(this.f4700l, aVar.f4700l) && Intrinsics.areEqual(this.f4701m, aVar.f4701m) && Intrinsics.areEqual(this.f4702n, aVar.f4702n) && this.f4703o == aVar.f4703o && Intrinsics.areEqual(this.p, aVar.p) && this.q == aVar.q && this.f4704r == aVar.f4704r && Intrinsics.areEqual(this.f4705s, aVar.f4705s);
    }

    @Override // f7.a
    public final String f() {
        return this.p;
    }

    @Override // f7.a
    public final String g() {
        return this.f4702n;
    }

    @Override // f7.a
    public final String h() {
        return this.f4697i;
    }

    public final int hashCode() {
        int iE = a1.a.e(this.f4697i.hashCode() * 31, 31, this.f4698j);
        String str = this.f4699k;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f4700l;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f4701m;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f4702n;
        int iF = a1.a.f(this.f4703o, (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31, 31);
        String str5 = this.p;
        int iF2 = a1.a.f(this.f4704r, a1.a.f(this.q, (iF + (str5 == null ? 0 : str5.hashCode())) * 31, 31), 31);
        String str6 = this.f4705s;
        return iF2 + (str6 != null ? str6.hashCode() : 0);
    }

    @Override // f7.a
    public final JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("serviceInstanceId", this.f4697i);
        jSONObject.put("intentId", this.f4698j);
        jSONObject.put("timestamp", this.q);
        jSONObject.put("tpk_version_code", this.f4704r);
        jSONObject.put("serviceId", this.f4705s);
        jSONObject.put("entry", this.f4700l);
        jSONObject.put("cardSize", this.f4701m);
        jSONObject.put("pageId", this.f4702n);
        jSONObject.put("dataVersion", this.f4703o);
        jSONObject.put("options", this.p);
        return jSONObject;
    }

    @Override // f7.a
    public final String j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("businessData", this.f4699k);
        jSONObject.put("cardData", i().toString());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return string;
    }
}
