package j2;

import java.util.ArrayList;
import java.util.Comparator;
import kn.l0;
import nm.c0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final ArrayList<j2.a> f8481b;

    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Integer.valueOf(((j2.a) t10).f8475c), Integer.valueOf(((j2.a) t11).f8475c));
        }
    }

    public c(@l JSONObject jSONObject) throws JSONException {
        l0.p(jSONObject, "json");
        this.f8481b = new ArrayList<>();
        this.f8480a = jSONObject.getInt(b9.i.f771b);
        JSONArray jSONArray = jSONObject.getJSONArray("obj");
        int i10 = 0;
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length > 0) {
            while (true) {
                int i11 = i10 + 1;
                JSONObject jSONObject2 = jSONArray == null ? null : jSONArray.getJSONObject(i10);
                if (jSONObject2 != null) {
                    this.f8481b.add(new j2.a(this.f8480a, jSONObject2));
                }
                if (i11 >= length) {
                    break;
                } else {
                    i10 = i11;
                }
            }
        }
        ArrayList<j2.a> arrayList = this.f8481b;
        if (arrayList.size() > 1) {
            c0.p0(arrayList, new a());
        }
    }

    public final int a() {
        return this.f8480a;
    }

    @l
    public final ArrayList<j2.a> b() {
        return this.f8481b;
    }

    public final void c(int i10) {
        this.f8480a = i10;
    }
}
