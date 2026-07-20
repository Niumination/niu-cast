package s3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k6.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f14955a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<f> f14956b = new CopyOnWriteArrayList();

    @Nullable
    public static d c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            h hVarC = h.c(jSONObject.getJSONObject("global_config"));
            if (hVarC != null) {
                dVar.f14955a = hVarC;
            }
            return dVar;
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            i.a("fromJSON", e10);
            return null;
        }
    }

    public String a(long j10) {
        return this.f14955a.a(j10);
    }

    public List<f> b() {
        return this.f14956b;
    }

    public f d(int i10) {
        if (!e.m(this.f14956b)) {
            return null;
        }
        for (f fVar : this.f14956b) {
            if (fVar.g() == i10) {
                return fVar;
            }
        }
        return null;
    }

    public void e(List<f> list) {
        this.f14956b.clear();
        this.f14956b.addAll(list);
    }

    public h f() {
        return this.f14955a;
    }

    public List<a> g() {
        ArrayList arrayList = new ArrayList();
        Iterator<f> it = this.f14956b.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().y());
        }
        return arrayList;
    }

    public void h() {
        for (f fVar : this.f14956b) {
            fVar.m(0L);
            fVar.j(-1L);
        }
        this.f14955a.y(0L);
        this.f14955a.q(-1L);
    }

    public String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("global_config", this.f14955a.B());
            return jSONObject.toString();
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            i.a("toJSON", e10);
            return "";
        }
    }
}
