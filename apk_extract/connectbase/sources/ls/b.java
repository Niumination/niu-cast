package ls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10279a = "x86";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10280b = "x86_64";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10281c = "ia64_32";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10282d = "ia64";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10283e = "ppc";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10284f = "ppc64";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10285g = "arm64";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap<String, String> f10286h;

    static {
        HashMap<String, String> map = new HashMap<>();
        f10286h = map;
        map.put(f10279a, f10279a);
        map.put("i386", f10279a);
        map.put("i486", f10279a);
        map.put("i586", f10279a);
        map.put("i686", f10279a);
        map.put("pentium", f10279a);
        map.put(f10280b, f10280b);
        map.put("amd64", f10280b);
        map.put("em64t", f10280b);
        map.put("universal", f10280b);
        map.put(f10282d, f10282d);
        map.put("ia64w", f10282d);
        map.put(f10281c, f10281c);
        map.put("ia64n", f10281c);
        map.put(f10283e, f10283e);
        map.put("power", f10283e);
        map.put("powerpc", f10283e);
        map.put("power_pc", f10283e);
        map.put("power_rs", f10283e);
        map.put(f10284f, f10284f);
        map.put("power64", f10284f);
        map.put("powerpc64", f10284f);
        map.put("power_pc64", f10284f);
        map.put("power_rs64", f10284f);
        map.put("aarch64", f10285g);
    }

    public static String a() {
        String property = System.getProperty("os.arch");
        if (f()) {
            return "android-arm";
        }
        if (property.startsWith("arm")) {
            property = i();
        } else {
            String lowerCase = property.toLowerCase(Locale.US);
            HashMap<String, String> map = f10286h;
            if (map.containsKey(lowerCase)) {
                return map.get(lowerCase);
            }
        }
        return j(property);
    }

    public static String b() {
        try {
            Process processExec = Runtime.getRuntime().exec("uname -m");
            processExec.waitFor();
            InputStream inputStream = processExec.getInputStream();
            try {
                return h(inputStream);
            } finally {
                inputStream.close();
            }
        } catch (Throwable th2) {
            System.err.println("Error while running uname -m: " + th2.getMessage());
            return "unknown";
        }
    }

    public static String c() {
        return d() + "/" + a();
    }

    public static String d() {
        return k(System.getProperty("os.name"));
    }

    public static boolean e() {
        try {
            Process processExec = Runtime.getRuntime().exec("cat /etc/os-release | grep ^ID");
            processExec.waitFor();
            InputStream inputStream = processExec.getInputStream();
            try {
                return h(inputStream).toLowerCase().contains("alpine");
            } finally {
                inputStream.close();
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f() {
        return System.getProperty("java.runtime.name", "").toLowerCase().contains("android");
    }

    public static void g(String[] strArr) {
        if (strArr.length >= 1) {
            if ("--os".equals(strArr[0])) {
                System.out.print(d());
                return;
            } else if ("--arch".equals(strArr[0])) {
                System.out.print(a());
                return;
            }
        }
        System.out.print(c());
    }

    public static String h(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[32];
        while (true) {
            int i10 = inputStream.read(bArr, 0, 32);
            if (i10 < 0) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    public static String i() {
        if (System.getProperty("os.name").contains("Linux")) {
            String strB = b();
            if (strB.startsWith("armv6")) {
                return "armv6";
            }
            if (strB.startsWith("armv7")) {
                return "armv7";
            }
            if (strB.startsWith("armv5")) {
                return "arm";
            }
            if (strB.equals("aarch64")) {
                return f10285g;
            }
            String property = System.getProperty("sun.arch.abi");
            if (property != null && property.startsWith("gnueabihf")) {
                return "armv7";
            }
        }
        return "arm";
    }

    public static String j(String str) {
        return str.replaceAll("\\W", "");
    }

    public static String k(String str) {
        if (str.contains("Windows")) {
            return "Windows";
        }
        if (str.contains("Mac") || str.contains("Darwin")) {
            return "Mac";
        }
        if (str.contains("Linux")) {
            return "Linux";
        }
        return str.contains("AIX") ? "AIX" : str.replaceAll("\\W", "");
    }
}
