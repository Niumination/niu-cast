package f2;

import kn.l0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final C0136a f5649p = new C0136a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public static final String f5650q = "AnimPlayer.AnimConfig";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5659i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5662l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.m
    public i2.b f5664n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.m
    public JSONObject f5665o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5651a = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public a0 f5660j = new a0(0, 0, 0, 0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public a0 f5661k = new a0(0, 0, 0, 0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5663m = 1;

    /* JADX INFO: renamed from: f2.a$a, reason: collision with other inner class name */
    public static final class C0136a {
        public C0136a() {
        }

        public C0136a(kn.w wVar) {
        }
    }

    public final void A(int i10) {
        this.f5652b = i10;
    }

    public final void B(int i10) {
        this.f5656f = i10;
    }

    public final void C(int i10) {
        this.f5655e = i10;
    }

    public final void D(int i10) {
        this.f5653c = i10;
    }

    @os.l
    public final a0 a() {
        return this.f5660j;
    }

    public final int b() {
        return this.f5663m;
    }

    public final int c() {
        return this.f5658h;
    }

    public final int d() {
        return this.f5654d;
    }

    @os.m
    public final JSONObject e() {
        return this.f5665o;
    }

    @os.m
    public final i2.b f() {
        return this.f5664n;
    }

    public final int g() {
        return this.f5657g;
    }

    @os.l
    public final a0 h() {
        return this.f5661k;
    }

    public final int i() {
        return this.f5652b;
    }

    public final int j() {
        return this.f5651a;
    }

    public final int k() {
        return this.f5656f;
    }

    public final int l() {
        return this.f5655e;
    }

    public final int m() {
        return this.f5653c;
    }

    public final boolean n() {
        return this.f5662l;
    }

    public final boolean o() {
        return this.f5659i;
    }

    public final boolean p(@os.l JSONObject jSONObject) {
        l0.p(jSONObject, "json");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("info");
            int i10 = jSONObject2.getInt("v");
            if (this.f5651a != i10) {
                l2.a.f9640a.b(f5650q, "current version=" + this.f5651a + " target=" + i10);
                return false;
            }
            this.f5652b = jSONObject2.getInt("f");
            this.f5653c = jSONObject2.getInt(p6.w.f13020a);
            this.f5654d = jSONObject2.getInt("h");
            this.f5655e = jSONObject2.getInt("videoW");
            this.f5656f = jSONObject2.getInt("videoH");
            this.f5657g = jSONObject2.getInt("orien");
            this.f5658h = jSONObject2.getInt("fps");
            this.f5659i = jSONObject2.getInt("isVapx") == 1;
            JSONArray jSONArray = jSONObject2.getJSONArray("aFrame");
            if (jSONArray == null) {
                return false;
            }
            q(new a0(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3)));
            JSONArray jSONArray2 = jSONObject2.getJSONArray("rgbFrame");
            if (jSONArray2 == null) {
                return false;
            }
            z(new a0(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(2), jSONArray2.getInt(3)));
            return true;
        } catch (JSONException e10) {
            l2.a.f9640a.c(f5650q, l0.C("json parse fail ", e10), e10);
            return false;
        }
    }

    public final void q(@os.l a0 a0Var) {
        l0.p(a0Var, "<set-?>");
        this.f5660j = a0Var;
    }

    public final void r(boolean z10) {
        this.f5662l = z10;
    }

    public final void s(int i10) {
        this.f5663m = i10;
    }

    public final void t(int i10) {
        this.f5658h = i10;
    }

    @os.l
    public String toString() {
        return "AnimConfig(version=" + this.f5651a + ", totalFrames=" + this.f5652b + ", width=" + this.f5653c + ", height=" + this.f5654d + ", videoWidth=" + this.f5655e + ", videoHeight=" + this.f5656f + ", orien=" + this.f5657g + ", fps=" + this.f5658h + ", isMix=" + this.f5659i + ", alphaPointRect=" + this.f5660j + ", rgbPointRect=" + this.f5661k + ", isDefaultConfig=" + this.f5662l + ')';
    }

    public final void u(int i10) {
        this.f5654d = i10;
    }

    public final void v(@os.m JSONObject jSONObject) {
        this.f5665o = jSONObject;
    }

    public final void w(@os.m i2.b bVar) {
        this.f5664n = bVar;
    }

    public final void x(boolean z10) {
        this.f5659i = z10;
    }

    public final void y(int i10) {
        this.f5657g = i10;
    }

    public final void z(@os.l a0 a0Var) {
        l0.p(a0Var, "<set-?>");
        this.f5661k = a0Var;
    }
}
