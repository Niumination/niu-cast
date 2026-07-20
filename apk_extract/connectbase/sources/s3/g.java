package s3;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import org.json.JSONException;
import org.json.JSONObject;
import p6.u;
import p6.w;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static String A = "";
    public static boolean B = false;
    public static boolean C = false;
    public static boolean D = false;
    public static boolean E = false;
    public static boolean F = false;
    public static boolean G = true;
    public static boolean H = true;
    public static boolean I = true;
    public static boolean J = true;
    public static boolean K = false;
    public static JSONObject L = new JSONObject();
    public static JSONObject M = new JSONObject();
    public static JSONObject N = new JSONObject();
    public static JSONObject O = new JSONObject();
    public static JSONObject P = new JSONObject();
    public static final ArrayMap<Integer, String> Q = new ArrayMap<>();
    public static boolean R = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f14969b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f14970c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f14971d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f14972e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f14973f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f14974g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f14975h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f14976i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f14977j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f14978k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f14979l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static byte[] f14980m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static byte[] f14981n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static byte[] f14982o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f14983p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f14984q = "online";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f14985r = 30000;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f14986s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f14987t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f14988u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f14989v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f14990w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f14991x = 10485760;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f14992y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static short f14993z;

    public static void A(boolean z10) {
        B = z10;
    }

    public static JSONObject B() {
        return O;
    }

    public static void C(boolean z10) {
        f14984q = z10 ? "test" : "online";
    }

    public static String D() {
        return f14986s;
    }

    public static synchronized JSONObject E() {
        return L;
    }

    public static String F() {
        return c(false) + f14974g;
    }

    public static int G() {
        return f14992y;
    }

    public static int H() {
        return f14991x;
    }

    public static JSONObject I() {
        return N;
    }

    public static String J() {
        return f14987t;
    }

    public static long K() {
        return f14985r;
    }

    public static String L() {
        return c(true) + f14976i;
    }

    public static boolean M() {
        return f14989v;
    }

    public static boolean N() {
        return f14983p;
    }

    public static boolean O() {
        return f14988u;
    }

    public static boolean P() {
        return B;
    }

    public static boolean Q() {
        return TextUtils.equals(f14984q, "online");
    }

    public static boolean R() {
        return f14990w;
    }

    public static boolean S() {
        return TextUtils.equals(f14984q, "test");
    }

    public static String a(int i10) {
        ArrayMap<Integer, String> arrayMap = Q;
        return arrayMap.containsKey(Integer.valueOf(i10)) ? arrayMap.get(Integer.valueOf(i10)) : "";
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbA = k.a.a(str);
            sbA.append(f14973f);
            return sbA.toString();
        }
        return c(false) + f14973f;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0036  */
    @NonNull
    public static String c(boolean z10) {
        byte b10;
        String str;
        String str2 = f14984q;
        int iHashCode = str2.hashCode();
        if (iHashCode != -1012222381) {
            if (iHashCode != 99349) {
                if (iHashCode == 3556498 && str2.equals("test")) {
                    b10 = 1;
                } else {
                    b10 = -1;
                }
            } else if (str2.equals("dev")) {
                b10 = 0;
            } else {
                b10 = -1;
            }
        } else if (str2.equals("online")) {
            b10 = 2;
        } else {
            b10 = -1;
        }
        if (b10 == 0) {
            str = f14968a;
        } else if (b10 != 1) {
            str = z10 ? f14971d : f14972e;
        } else {
            str = z10 ? f14969b : f14970c;
        }
        try {
            if (e.b(k6.g.h0(), "debug.athena.test_mode", false).booleanValue()) {
                str = z10 ? f14969b : f14970c;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return m.a.a("https://", str);
    }

    public static void d() {
        f14990w = true;
    }

    public static void e(int i10, String str) {
        Q.put(Integer.valueOf(i10), str);
    }

    public static void f(long j10) {
        if (j10 < 30000) {
            j10 = 30000;
        }
        f14985r = j10;
    }

    public static void g(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (j(obj)) {
                M.put(str, obj);
            }
        } catch (JSONException e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public static void h(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(f14986s) || z10) {
            f14986s = str;
        }
    }

    public static void i(short s10, String str) {
        f14993z = s10;
        A = str;
    }

    public static boolean j(Object obj) {
        int length = obj.toString().getBytes(StandardCharsets.UTF_8).length;
        if (length <= 2000) {
            return true;
        }
        y3.b.d(String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length)));
        return false;
    }

    public static String k() {
        return A;
    }

    public static String l(String str) {
        StringBuilder sbA = k.a.a(str);
        sbA.append(f14976i);
        return sbA.toString();
    }

    public static void m(int i10) {
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 > 200) {
            i10 = 200;
        }
        f14992y = i10;
    }

    public static void n(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (j(obj)) {
                P.put(str, obj);
            }
        } catch (JSONException e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public static void o(boolean z10) {
        f14989v = z10;
    }

    public static short p() {
        return f14993z;
    }

    public static void q(int i10) {
        if (i10 < 2097152) {
            f14991x = 2097152;
        }
        f14991x = i10;
    }

    public static void r(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        f14968a = jSONObject.getString("d");
        f14969b = jSONObject.getString("tu");
        f14970c = jSONObject.getString("tc");
        f14971d = jSONObject.getString("ou");
        f14972e = jSONObject.getString("oc");
        f14973f = jSONObject.getString("c").replace("v6", "v7");
        f14974g = jSONObject.getString("g") + "v2";
        String string = jSONObject.getString(u.f13018b);
        f14975h = string;
        f14976i = string.replace("v2", "v3");
        f14977j = jSONObject.getString("fc");
        f14978k = jSONObject.getString("fd");
        f14979l = jSONObject.getString("fe");
        f14981n = jSONObject.getString(w.f13020a).getBytes();
        f14982o = jSONObject.getString("iv").getBytes();
        m0.a aVarA = m0.a.a(k6.g.h0());
        try {
            if (aVarA.e("athena_def") != 0) {
                f14980m = f14981n;
                return;
            }
            String strH = aVarA.h("athena_ea");
            if (TextUtils.isEmpty(strH)) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                strH = e.o(keyGenerator.generateKey().getEncoded());
                aVarA.c("athena_ea", strH);
            }
            f14980m = e.k(strH);
        } catch (Exception unused) {
            aVarA.b("athena_def", 1);
            f14980m = f14981n;
        }
    }

    public static void s(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (j(obj)) {
                O.put(str, obj);
            }
        } catch (JSONException e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public static void t(boolean z10) {
        f14983p = z10;
    }

    public static JSONObject u() {
        return M;
    }

    public static void v(String str) {
        f14987t = str;
    }

    public static synchronized void w(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (j(obj)) {
                    L.put(str, obj);
                }
            } catch (JSONException e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
    }

    public static void x(boolean z10) {
        y3.b.f("setEnable isEnable = " + z10);
        f14988u = z10;
    }

    public static JSONObject y() {
        return P;
    }

    public static void z(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (j(obj)) {
                N.put(str, obj);
            }
        } catch (JSONException e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }
}
