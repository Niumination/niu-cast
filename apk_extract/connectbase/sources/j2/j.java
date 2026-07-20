package j2;

import android.graphics.Bitmap;
import android.graphics.Color;
import kn.l0;
import kn.w;
import org.json.JSONException;
import org.json.JSONObject;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @l
    public static final a f8531o = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public static final String f8532p = "AnimPlayer.Src";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public String f8533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public d f8538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public c f8539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public String f8540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public String f8541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public e f8542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public b f8544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8545m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @m
    public Bitmap f8546n;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public enum b {
        FIT_XY("fitXY"),
        CENTER_FULL("centerFull");


        @l
        private final String type;

        b(String str) {
            this.type = str;
        }

        @l
        public final String getType() {
            return this.type;
        }
    }

    public enum c {
        UNKNOWN("unknown"),
        NET("net"),
        LOCAL("local");


        @l
        private final String type;

        c(String str) {
            this.type = str;
        }

        @l
        public final String getType() {
            return this.type;
        }
    }

    public enum d {
        UNKNOWN("unknown"),
        IMG("img"),
        TXT("txt");


        @l
        private final String type;

        d(String str) {
            this.type = str;
        }

        @l
        public final String getType() {
            return this.type;
        }
    }

    public enum e {
        DEFAULT(ks.c.f9460f),
        BOLD("b");


        @l
        private final String style;

        e(String str) {
            this.style = str;
        }

        @l
        public final String getStyle() {
            return this.style;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x009c A[PHI: r5
      0x009c: PHI (r5v17 j2.j$c) = (r5v14 j2.j$c), (r5v15 j2.j$c) binds: [B:13:0x009a, B:16:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x0079 A[PHI: r7
      0x0079: PHI (r7v8 j2.j$d) = (r7v3 j2.j$d), (r7v4 j2.j$d) binds: [B:7:0x0077, B:10:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    public j(@l JSONObject jSONObject) throws JSONException {
        l0.p(jSONObject, "json");
        this.f8533a = "";
        d dVar = d.UNKNOWN;
        this.f8538f = dVar;
        c cVar = c.UNKNOWN;
        this.f8539g = cVar;
        this.f8540h = "";
        this.f8541i = "";
        e eVar = e.DEFAULT;
        this.f8542j = eVar;
        b bVar = b.FIT_XY;
        this.f8544l = bVar;
        String string = jSONObject.getString("srcId");
        l0.o(string, "json.getString(\"srcId\")");
        this.f8533a = string;
        this.f8534b = jSONObject.getInt(p6.w.f13020a);
        this.f8535c = jSONObject.getInt("h");
        String strOptString = jSONObject.optString("color", "#000000");
        l0.o(strOptString, "colorStr");
        String str = strOptString.length() != 0 ? strOptString : "#000000";
        this.f8543k = Color.parseColor(str);
        String string2 = jSONObject.getString("srcTag");
        l0.o(string2, "json.getString(\"srcTag\")");
        this.f8540h = string2;
        this.f8541i = string2;
        String string3 = jSONObject.getString("srcType");
        d dVar2 = d.IMG;
        if (!l0.g(string3, dVar2.getType())) {
            dVar2 = d.TXT;
            dVar = l0.g(string3, dVar2.getType()) ? dVar2 : dVar;
        }
        this.f8538f = dVar;
        String string4 = jSONObject.getString("loadType");
        c cVar2 = c.NET;
        if (!l0.g(string4, cVar2.getType())) {
            cVar2 = c.LOCAL;
            cVar = l0.g(string4, cVar2.getType()) ? cVar2 : cVar;
        }
        this.f8539g = cVar;
        String string5 = jSONObject.getString("fitType");
        b bVar2 = b.CENTER_FULL;
        this.f8544l = l0.g(string5, bVar2.getType()) ? bVar2 : bVar;
        String strOptString2 = jSONObject.optString(dc.d.f3682m, "");
        e eVar2 = e.BOLD;
        this.f8542j = l0.g(strOptString2, eVar2.getStyle()) ? eVar2 : eVar;
        l2.a.f9640a.e(f8532p, this + " color=" + ((Object) str));
    }

    public final void A(@l e eVar) {
        l0.p(eVar, "<set-?>");
        this.f8542j = eVar;
    }

    public final void B(@l String str) {
        l0.p(str, "<set-?>");
        this.f8541i = str;
    }

    public final void C(int i10) {
        this.f8534b = i10;
    }

    public final void a(Bitmap bitmap) {
        int i10;
        int i11;
        Integer numValueOf = bitmap == null ? null : Integer.valueOf(bitmap.getWidth());
        int iIntValue = numValueOf == null ? this.f8534b : numValueOf.intValue();
        Integer numValueOf2 = bitmap != null ? Integer.valueOf(bitmap.getHeight()) : null;
        int iIntValue2 = numValueOf2 == null ? this.f8535c : numValueOf2.intValue();
        this.f8536d = iIntValue;
        this.f8537e = iIntValue2;
        if (this.f8544l != b.CENTER_FULL || (i10 = this.f8534b) == 0 || (i11 = this.f8535c) == 0) {
            return;
        }
        float f10 = iIntValue / iIntValue2;
        if (f10 >= i10 / i11) {
            this.f8537e = i11;
            this.f8536d = (int) (i11 * f10);
        } else {
            this.f8536d = i10;
            this.f8537e = (int) (i10 / f10);
        }
    }

    @m
    public final Bitmap b() {
        return this.f8546n;
    }

    public final int c() {
        return this.f8543k;
    }

    public final int d() {
        return this.f8537e;
    }

    public final int e() {
        return this.f8536d;
    }

    @l
    public final b f() {
        return this.f8544l;
    }

    public final int g() {
        return this.f8535c;
    }

    @l
    public final c h() {
        return this.f8539g;
    }

    @l
    public final String i() {
        return this.f8533a;
    }

    @l
    public final String j() {
        return this.f8540h;
    }

    public final int k() {
        return this.f8545m;
    }

    @l
    public final d l() {
        return this.f8538f;
    }

    @l
    public final e m() {
        return this.f8542j;
    }

    @l
    public final String n() {
        return this.f8541i;
    }

    public final int o() {
        return this.f8534b;
    }

    public final void p(@m Bitmap bitmap) {
        this.f8546n = bitmap;
        a(bitmap);
    }

    public final void q(int i10) {
        this.f8543k = i10;
    }

    public final void r(int i10) {
        this.f8537e = i10;
    }

    public final void s(int i10) {
        this.f8536d = i10;
    }

    public final void t(@l b bVar) {
        l0.p(bVar, "<set-?>");
        this.f8544l = bVar;
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Src(srcId='");
        sb2.append(this.f8533a);
        sb2.append("', srcType=");
        sb2.append(this.f8538f);
        sb2.append(", loadType=");
        sb2.append(this.f8539g);
        sb2.append(", srcTag='");
        sb2.append(this.f8540h);
        sb2.append("', bitmap=");
        sb2.append(this.f8546n);
        sb2.append(", txt='");
        return j.c.a(sb2, this.f8541i, "')");
    }

    public final void u(int i10) {
        this.f8535c = i10;
    }

    public final void v(@l c cVar) {
        l0.p(cVar, "<set-?>");
        this.f8539g = cVar;
    }

    public final void w(@l String str) {
        l0.p(str, "<set-?>");
        this.f8533a = str;
    }

    public final void x(@l String str) {
        l0.p(str, "<set-?>");
        this.f8540h = str;
    }

    public final void y(int i10) {
        this.f8545m = i10;
    }

    public final void z(@l d dVar) {
        l0.p(dVar, "<set-?>");
        this.f8538f = dVar;
    }
}
