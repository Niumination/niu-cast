package s6;

import android.text.TextUtils;
import android.util.ArrayMap;
import javax.crypto.KeyGenerator;
import k3.dd;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f9539b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f9540c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f9541d = null;
    public static String e = null;
    public static String f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f9542g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f9543h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f9544i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f9545j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f9546k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f9547l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static byte[] f9548m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static byte[] f9549n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static byte[] f9550o = null;
    public static boolean p = false;
    public static String q = "online";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f9551r = 30000;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f9552s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f9553t = true;
    public static boolean u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final JSONObject f9554v = new JSONObject();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final JSONObject f9555w = new JSONObject();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final JSONObject f9556x = new JSONObject();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final JSONObject f9557y = new JSONObject();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final JSONObject f9558z = new JSONObject();
    public static final ArrayMap A = new ArrayMap();
    public static final boolean B = true;

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    public static String a(boolean z2) {
        byte b9;
        String str;
        Boolean bool;
        String str2 = q;
        int iHashCode = str2.hashCode();
        if (iHashCode != -1012222381) {
            if (iHashCode != 99349) {
                if (iHashCode == 3556498 && str2.equals("test")) {
                    b9 = 1;
                } else {
                    b9 = -1;
                }
            } else if (str2.equals("dev")) {
                b9 = 0;
            } else {
                b9 = -1;
            }
        } else if (str2.equals("online")) {
            b9 = 2;
        } else {
            b9 = -1;
        }
        if (b9 == 0) {
            str = f9538a;
        } else if (b9 != 1) {
            str = z2 ? f9541d : e;
        } else {
            str = z2 ? f9539b : f9540c;
        }
        try {
            try {
                Class<?> clsLoadClass = e8.b.f4712i.getClassLoader().loadClass("android.os.SystemProperties");
                bool = (Boolean) clsLoadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(clsLoadClass, "debug.athena.test_mode", Boolean.FALSE);
            } catch (IllegalArgumentException e4) {
                throw e4;
            } catch (Exception unused) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                str = z2 ? f9539b : f9540c;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return h0.a.i("https://", str);
    }

    public static String b(String str) {
        StringBuilder sbS = o.d.s(str);
        sbS.append(f9544i);
        return sbS.toString();
    }

    public static void c(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        f9538a = jSONObject.getString("d");
        f9539b = jSONObject.getString("tu");
        f9540c = jSONObject.getString("tc");
        f9541d = jSONObject.getString("ou");
        e = jSONObject.getString("oc");
        f = jSONObject.getString("c").replace("v6", "v7");
        f9542g = jSONObject.getString("g") + "v2";
        String string = jSONObject.getString("u");
        f9543h = string;
        f9544i = string.replace("v2", "v3");
        f9545j = jSONObject.getString("fc");
        f9546k = jSONObject.getString("fd");
        f9547l = jSONObject.getString("fe");
        f9549n = jSONObject.getString("w").getBytes();
        f9550o = jSONObject.getString("iv").getBytes();
        i1.a aVarA = i1.a.a(e8.b.f4712i);
        try {
            if (aVarA.e("athena_def") != 0) {
                f9548m = f9549n;
                return;
            }
            String strH = aVarA.h();
            if (TextUtils.isEmpty(strH)) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                strH = dd.k(keyGenerator.generateKey().getEncoded());
                aVarA.c(strH);
            }
            f9548m = dd.h(strH);
        } catch (Exception unused) {
            aVarA.b(1, "athena_def");
            f9548m = f9549n;
        }
    }

    public static String d() {
        return a(true) + f9544i;
    }

    public static boolean e() {
        return f9553t;
    }
}
