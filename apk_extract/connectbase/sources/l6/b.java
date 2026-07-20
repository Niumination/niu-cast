package l6;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile b f9696m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9697n = "blank";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9701d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f9709l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9698a = "gslb_";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9703f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9704g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9705h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9706i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f9707j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f9708k = "&";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f9699b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<d> f9700c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9702e = 86400000;

    public b() {
        this.f9698a += g.d(c.f9711b);
        this.f9709l = c.f9711b.getFilesDir().getPath() + File.separator + this.f9698a;
        n();
        if (this.f9699b.size() == 0) {
            this.f9699b.put("dsu.shalltry.com", f9697n);
            this.f9699b.put("dsc.shalltry.com", f9697n);
            this.f9699b.put("api.twibida.com", f9697n);
        }
        c();
    }

    public static b h() {
        if (f9696m == null) {
            synchronized (b.class) {
                try {
                    if (f9696m == null) {
                        f9696m = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f9696m;
    }

    public void a(d dVar) {
        c.d dVar2;
        c.a aVar;
        c.InterfaceC0255c interfaceC0255c;
        c.b bVar;
        c.InterfaceC0255c interfaceC0255c2;
        c.b bVar2;
        if (dVar.f9715a == null) {
            String str = dVar.f9717c;
            if (str == null || dVar.f9718d == null) {
                return;
            }
            String strE = g.e(str);
            String str2 = this.f9699b.get(strE);
            if (!j(str2)) {
                this.f9700c.add(dVar);
                return;
            }
            boolean z10 = dVar.f9722h;
            if (z10 && (aVar = dVar.f9720f) != null) {
                aVar.a(dVar.f9717c.replace(strE, str2));
                return;
            } else {
                if (z10 || (dVar2 = dVar.f9718d) == null) {
                    return;
                }
                dVar2.a(dVar.f9717c.replace(strE, str2));
                return;
            }
        }
        boolean z11 = true;
        int i10 = 0;
        boolean z12 = false;
        boolean z13 = false;
        while (true) {
            String[] strArr = dVar.f9715a;
            if (i10 >= strArr.length) {
                break;
            }
            strArr[i10] = g.e(strArr[i10]);
            if (!TextUtils.isEmpty(dVar.f9715a[i10])) {
                String str3 = this.f9699b.get(dVar.f9715a[i10]);
                if (str3 == null) {
                    this.f9699b.put(dVar.f9715a[i10], f9697n);
                    z12 = true;
                } else if (!j(str3)) {
                    z13 = true;
                }
                z11 = false;
            }
            i10++;
        }
        if (z11) {
            boolean z14 = dVar.f9721g;
            if (z14 && (bVar2 = dVar.f9719e) != null) {
                bVar2.b("all domains are empty");
            } else if (!z14 && (interfaceC0255c2 = dVar.f9716b) != null) {
                interfaceC0255c2.b();
            }
        } else if (z12) {
            u();
        } else if (!z13 && !TextUtils.isEmpty(f())) {
            boolean z15 = dVar.f9721g;
            if (z15 && (bVar = dVar.f9719e) != null) {
                bVar.a(new HashMap(this.f9699b));
                return;
            } else {
                if (z15 || (interfaceC0255c = dVar.f9716b) == null) {
                    return;
                }
                interfaceC0255c.a(new HashMap(this.f9699b));
                return;
            }
        }
        this.f9700c.add(dVar);
    }

    public void b() {
        for (d dVar : this.f9700c) {
            if (dVar.f9715a != null) {
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    String[] strArr = dVar.f9715a;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    if (this.f9699b.containsKey(strArr[i10]) && !j(this.f9699b.get(dVar.f9715a[i10]))) {
                        z10 = true;
                        break;
                    }
                    i10++;
                }
                c.InterfaceC0255c interfaceC0255c = dVar.f9716b;
                if (interfaceC0255c != null) {
                    if (z10) {
                        interfaceC0255c.b();
                    } else {
                        interfaceC0255c.a(new HashMap(this.f9699b));
                    }
                }
            } else {
                String str = dVar.f9717c;
                if (str != null && dVar.f9718d != null) {
                    String strE = g.e(str);
                    String str2 = this.f9699b.get(strE);
                    if (j(str2)) {
                        dVar.f9718d.a(dVar.f9717c.replace(strE, str2));
                    } else {
                        dVar.f9718d.b();
                    }
                }
            }
        }
        this.f9700c.clear();
    }

    public final void c() {
        h hVar;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(this.f9705h - jCurrentTimeMillis) > 86400000) {
            this.f9706i = 0L;
        }
        long j10 = this.f9701d;
        if (j10 <= 0 || Math.abs(jCurrentTimeMillis - j10) <= this.f9702e) {
            return;
        }
        long j11 = this.f9706i;
        if (j11 == 0) {
            this.f9705h = jCurrentTimeMillis;
        }
        if (j11 < 4 && (hVar = c.f9710a) != null) {
            hVar.i();
        }
        this.f9706i++;
    }

    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = this.f9699b.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public List<String> e() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.f9699b.entrySet()) {
            if (!j(entry.getValue())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public String f() {
        return this.f9704g;
    }

    public String g(String str) {
        String str2 = this.f9699b.get(str);
        c();
        return str2;
    }

    public String i() {
        return this.f9703f;
    }

    public final boolean j(String str) {
        return (TextUtils.isEmpty(str) || str.equals(f9697n)) ? false : true;
    }

    public void k(Map<String, String> map, boolean z10) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!j(this.f9699b.get(entry.getKey())) || z10) {
                this.f9699b.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void l() {
        c.a aVar;
        c.d dVar;
        c.b bVar;
        c.InterfaceC0255c interfaceC0255c;
        try {
            for (d dVar2 : this.f9700c) {
                boolean z10 = dVar2.f9721g;
                int i10 = 0;
                if (!z10 && dVar2.f9716b != null) {
                    String[] strArr = dVar2.f9715a;
                    int length = strArr.length;
                    boolean z11 = false;
                    while (i10 < length) {
                        String str = strArr[i10];
                        if (!TextUtils.isEmpty(str) && !j(this.f9699b.get(str))) {
                            z11 = true;
                        }
                        i10++;
                    }
                    if (z11) {
                        dVar2.f9716b.b();
                    } else if (!TextUtils.isEmpty(f())) {
                        dVar2.f9716b.a(new HashMap(this.f9699b));
                    }
                } else if (!z10 || dVar2.f9719e == null) {
                    String str2 = dVar2.f9717c;
                    if (str2 != null && !dVar2.f9722h && dVar2.f9718d != null) {
                        String strE = g.e(str2);
                        String str3 = this.f9699b.get(strE);
                        if (j(str3)) {
                            dVar2.f9718d.a(dVar2.f9717c.replace(strE, str3));
                        } else {
                            dVar2.f9718d.b();
                        }
                    } else if (str2 != null && dVar2.f9722h && dVar2.f9720f != null) {
                        String strE2 = g.e(str2);
                        String str4 = this.f9699b.get(strE2);
                        if (j(str4)) {
                            dVar2.f9720f.a(dVar2.f9717c.replace(strE2, str4));
                        } else {
                            dVar2.f9720f.b("the mapping result is empty for " + strE2);
                        }
                    }
                } else {
                    String[] strArr2 = dVar2.f9715a;
                    int length2 = strArr2.length;
                    String str5 = "";
                    boolean z12 = false;
                    while (i10 < length2) {
                        String str6 = strArr2[i10];
                        if (!TextUtils.isEmpty(str6) && !j(this.f9699b.get(str6))) {
                            z12 = true;
                            str5 = str6;
                        }
                        i10++;
                    }
                    if (z12) {
                        dVar2.f9719e.b("domain map not found for " + str5);
                    } else if (!TextUtils.isEmpty(f())) {
                        dVar2.f9719e.a(new HashMap(this.f9699b));
                    }
                }
            }
            this.f9700c.clear();
        } catch (Exception e10) {
            e10.printStackTrace();
            for (d dVar3 : this.f9700c) {
                boolean z13 = dVar3.f9721g;
                if (!z13 && (interfaceC0255c = dVar3.f9716b) != null) {
                    interfaceC0255c.b();
                } else if (!z13 || (bVar = dVar3.f9719e) == null) {
                    String str7 = dVar3.f9717c;
                    if (str7 != null && !dVar3.f9722h && (dVar = dVar3.f9718d) != null) {
                        dVar.b();
                    } else if (str7 != null && dVar3.f9722h && (aVar = dVar3.f9720f) != null) {
                        aVar.b("get domain exception " + e10.toString());
                    }
                } else {
                    bVar.b("get domain exception " + e10.toString());
                }
            }
            this.f9700c.clear();
        }
    }

    public void m() {
        c.a aVar;
        c.d dVar;
        c.b bVar;
        c.InterfaceC0255c interfaceC0255c;
        c.a aVar2;
        c.d dVar2;
        try {
            ArrayList arrayList = new ArrayList();
            for (d dVar3 : this.f9700c) {
                boolean z10 = dVar3.f9721g;
                if (!z10 && dVar3.f9716b != null) {
                    arrayList.add(dVar3);
                } else if (!z10 || dVar3.f9719e == null) {
                    String str = dVar3.f9717c;
                    if (str != null && !dVar3.f9722h && (dVar2 = dVar3.f9718d) != null) {
                        dVar2.b();
                    } else if (str != null && dVar3.f9722h && (aVar2 = dVar3.f9720f) != null) {
                        aVar2.b("no network");
                    }
                } else {
                    arrayList.add(dVar3);
                }
            }
            this.f9700c.clear();
            this.f9700c.addAll(arrayList);
        } catch (Exception e10) {
            e10.printStackTrace();
            for (d dVar4 : this.f9700c) {
                boolean z11 = dVar4.f9721g;
                if (!z11 && (interfaceC0255c = dVar4.f9716b) != null) {
                    interfaceC0255c.b();
                } else if (!z11 || (bVar = dVar4.f9719e) == null) {
                    String str2 = dVar4.f9717c;
                    if (str2 != null && !dVar4.f9722h && (dVar = dVar4.f9718d) != null) {
                        dVar.b();
                    } else if (str2 != null && dVar4.f9722h && (aVar = dVar4.f9720f) != null) {
                        aVar.b("get domain exception " + e10.toString());
                    }
                } else {
                    bVar.b("get domain exception " + e10.toString());
                }
            }
            this.f9700c.clear();
        }
    }

    public final void n() {
        String[] strArrSplit = g.a(new File(this.f9709l)).split("&");
        if (strArrSplit.length < 4) {
            return;
        }
        try {
            this.f9699b = g.i(strArrSplit[0]);
            this.f9703f = strArrSplit[1];
            this.f9702e = Long.parseLong(strArrSplit[2]);
            this.f9701d = Long.parseLong(strArrSplit[3]);
            this.f9704g = strArrSplit[4];
        } catch (Throwable unused) {
        }
    }

    public void o() {
        this.f9699b.clear();
        this.f9699b.put("dsu.shalltry.com", f9697n);
        this.f9699b.put("dsc.shalltry.com", f9697n);
        this.f9699b.put("api.twibida.com", f9697n);
    }

    public boolean p(String str) {
        try {
            this.f9699b.remove(str);
            return true;
        } catch (Exception e10) {
            g.f9730a.m("reset exception" + e10.toString());
            return false;
        }
    }

    public void q(String str) {
        this.f9704g = str;
    }

    public void r(String str) {
        this.f9703f = str;
    }

    public void s(long j10) {
        this.f9702e = j10;
        if (j10 < 86400000) {
            this.f9702e = 86400000L;
        }
        this.f9701d = System.currentTimeMillis();
    }

    public boolean t(String str, String str2) {
        boolean z10;
        String string;
        r(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt("code");
            String string2 = jSONObject.getString("message");
            if (i10 != 200) {
                g.f9730a.m("error message is " + string2);
                return false;
            }
            HashMap map = new HashMap(4);
            long j10 = 86400000;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                JSONObject jSONObject3 = jSONObject2.getJSONObject("domainPairs");
                z10 = jSONObject2.getBoolean("overrideFlag");
                try {
                    j10 = jSONObject2.getInt("expireTime");
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String strValueOf = String.valueOf(itKeys.next());
                        map.put(strValueOf, jSONObject3.getString(strValueOf));
                    }
                    string = jSONObject2.getString("country");
                } catch (Exception e10) {
                    e = e10;
                    g.f9730a.m(Log.getStackTraceString(e));
                    string = "";
                }
            } catch (Exception e11) {
                e = e11;
                z10 = false;
            }
            k(map, z10);
            s(j10);
            q(string);
            u();
            return true;
        } catch (JSONException e12) {
            e12.printStackTrace();
            return false;
        }
    }

    public final void u() {
        g.b(this.f9709l, g.h(this.f9699b) + "&" + this.f9703f + "&" + this.f9702e + "&" + this.f9701d + "&" + this.f9704g);
    }
}
