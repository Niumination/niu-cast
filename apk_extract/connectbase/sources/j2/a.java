package j2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import f2.a0;
import kn.l0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public String f8474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public a0 f8476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public a0 f8477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8478f;

    public a(int i10, @l JSONObject jSONObject) throws JSONException {
        l0.p(jSONObject, "json");
        this.f8473a = i10;
        this.f8474b = "";
        String string = jSONObject.getString("srcId");
        l0.o(string, "json.getString(\"srcId\")");
        this.f8474b = string;
        this.f8475c = jSONObject.getInt("z");
        JSONArray jSONArray = jSONObject.getJSONArray(TypedValues.AttributesType.S_FRAME);
        this.f8476d = new a0(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
        JSONArray jSONArray2 = jSONObject.getJSONArray("mFrame");
        this.f8477e = new a0(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(2), jSONArray2.getInt(3));
        this.f8478f = jSONObject.getInt("mt");
    }

    @l
    public final a0 a() {
        return this.f8476d;
    }

    public final int b() {
        return this.f8473a;
    }

    @l
    public final a0 c() {
        return this.f8477e;
    }

    public final int d() {
        return this.f8478f;
    }

    @l
    public final String e() {
        return this.f8474b;
    }

    public final int f() {
        return this.f8475c;
    }

    public final void g(@l a0 a0Var) {
        l0.p(a0Var, "<set-?>");
        this.f8476d = a0Var;
    }

    public final void h(@l a0 a0Var) {
        l0.p(a0Var, "<set-?>");
        this.f8477e = a0Var;
    }

    public final void i(int i10) {
        this.f8478f = i10;
    }

    public final void j(@l String str) {
        l0.p(str, "<set-?>");
        this.f8474b = str;
    }

    public final void k(int i10) {
        this.f8475c = i10;
    }
}
