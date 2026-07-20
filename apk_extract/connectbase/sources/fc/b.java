package fc;

import android.os.Build;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5977a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5978b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5979c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f5980d = 33;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5981a = c.a.a(new StringBuilder(), b.f5980d, "101");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f5982b = c.a.a(new StringBuilder(), b.f5980d, "111");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f5983c = c.a.a(new StringBuilder(), b.f5980d, "121");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f5984d = c.a.a(new StringBuilder(), b.f5980d, "131");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f5985e = c.a.a(new StringBuilder(), b.f5980d, "141");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f5986f = c.a.a(new StringBuilder(), b.f5980d, "151");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f5987g = c.a.a(new StringBuilder(), b.f5980d, "161");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f5988h = c.a.a(new StringBuilder(), b.f5980d, "171");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f5989i = c.a.a(new StringBuilder(), b.f5980d, "181");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f5990j = c.a.a(new StringBuilder(), b.f5980d, "182");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f5991k = c.a.a(new StringBuilder(), b.f5980d, "201");

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f5992l = c.a.a(new StringBuilder(), b.f5980d, "211");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f5993m = c.a.a(new StringBuilder(), b.f5980d, "221");

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f5994n = c.a.a(new StringBuilder(), b.f5980d, "231");

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f5995o = c.a.a(new StringBuilder(), b.f5980d, "241");

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f5996p = c.a.a(new StringBuilder(), b.f5980d, "251");

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f5997q = c.a.a(new StringBuilder(), b.f5980d, "261");

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f5998r = c.a.a(new StringBuilder(), b.f5980d, "271");

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f5999s = c.a.a(new StringBuilder(), b.f5980d, "281");

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final String f6000t = c.a.a(new StringBuilder(), b.f5980d, "301");

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final String f6001u = c.a.a(new StringBuilder(), b.f5980d, "311");

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final String f6002v = c.a.a(new StringBuilder(), b.f5980d, "321");

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final String f6003w = c.a.a(new StringBuilder(), b.f5980d, "331");

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f6004x = c.a.a(new StringBuilder(), b.f5980d, "341");

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String f6005y = c.a.a(new StringBuilder(), b.f5980d, "351");

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final String f6006z = c.a.a(new StringBuilder(), b.f5980d, "361");
        public static final String A = c.a.a(new StringBuilder(), b.f5980d, "371");
        public static final String B = c.a.a(new StringBuilder(), b.f5980d, "381");
        public static final String C = c.a.a(new StringBuilder(), b.f5980d, "391");
        public static final String D = c.a.a(new StringBuilder(), b.f5980d, "401");
        public static final String E = c.a.a(new StringBuilder(), b.f5980d, "411");
        public static final String F = c.a.a(new StringBuilder(), b.f5980d, "421");
        public static final String G = c.a.a(new StringBuilder(), b.f5980d, "431");
        public static final String H = c.a.a(new StringBuilder(), b.f5980d, "441");
    }

    static {
        String simpleName = b.class.getSimpleName();
        try {
            String strE = cc.a.e("com.transsion.hubsdk.os.TranBuild", "THUBCORE_VERSION", hi.b.f7118g);
            f5978b = Integer.parseInt(strE.replace(".", ""));
            e.f(simpleName, "initializer: version = " + strE + ", THUBCORE_VERSION = " + f5978b);
            f5980d = Build.VERSION.SDK_INT;
            StringBuilder sb2 = new StringBuilder("ro.build.version.sdk = ");
            sb2.append(f5980d);
            e.f(simpleName, sb2.toString());
        } catch (Throwable th2) {
            e.c(f5977a, "static initializer: e = " + th2.getMessage());
        }
    }

    public static String a(Throwable th2, int i10) {
        try {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StringBuilder sb2 = new StringBuilder(th2.toString());
            int i11 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb2.append("\n#" + stackTraceElement.getClassName());
                sb2.append(".");
                sb2.append(stackTraceElement.getMethodName());
                sb2.append("[" + stackTraceElement.getLineNumber() + "]");
                i11++;
                if (i11 >= i10) {
                    break;
                }
            }
            return sb2.toString();
        } catch (Exception e10) {
            e.n(f5977a, "getStackTrace Exception" + e10);
            return "";
        }
    }

    public static boolean b(String str) {
        try {
            if (f5978b >= Integer.parseInt(str) && Integer.parseInt(str) >= Integer.parseInt(a.f5981a)) {
                return true;
            }
        } catch (Exception e10) {
            p6.b.a("supportThubCore: e = ", e10, f5977a);
        }
        String str2 = f5977a;
        StringBuilder sbA = e.a.a("THUBCore No support Call!!! method version = ", str, ", >>> ThubCore vserion = ");
        sbA.append(f5978b);
        sbA.append("\n mthod version must <= ThubCore version.\n ---");
        sbA.append(a(new Throwable(), 4));
        e.n(str2, sbA.toString());
        return false;
    }
}
