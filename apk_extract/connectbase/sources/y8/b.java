package y8;

import dc.e;
import java.io.File;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements hh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20767a = "TranAospConfigs";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class f20768b = cc.a.a("com.transsion.hubsdk.tranthubutils.TranConfigs");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f20769c;

    @Override // hh.b
    public File a(String str) {
        Class cls = f20768b;
        if (cls == null) {
            return null;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (File) cc.a.j(cc.a.g(f20768b, "getConfigs", String.class), f20769c, str);
    }

    @Override // hh.b
    public void b(String str) {
        Class cls = f20768b;
        if (cls == null) {
            return;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        cc.a.j(cc.a.g(f20768b, "initialize", String.class), f20769c, str);
    }

    @Override // hh.b
    public File c(String str, boolean z10) {
        Class cls = f20768b;
        if (cls == null) {
            return null;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (File) cc.a.j(cc.a.g(f20768b, "getNativeLibrary", String.class, Boolean.TYPE), f20769c, str, Boolean.valueOf(z10));
    }

    @Override // hh.b
    public File d(String str, String str2) {
        Class cls = f20768b;
        if (cls == null) {
            return null;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (File) cc.a.j(cc.a.g(f20768b, "getAsset", String.class, String.class), f20769c, str, str2);
    }

    @Override // hh.b
    public File e(String str) {
        Class cls = f20768b;
        if (cls == null) {
            return null;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (File) cc.a.j(cc.a.g(f20768b, "getLibrary", String.class), f20769c, str);
    }

    @Override // hh.b
    public List<File> f(String str) {
        Class cls = f20768b;
        if (cls == null) {
            return Collections.emptyList();
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (List) cc.a.j(cc.a.g(f20768b, "getConfigsList", String.class), f20769c, str);
    }

    @Override // hh.b
    public File g(String str, String str2) {
        Class cls = f20768b;
        if (cls == null) {
            return null;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (File) cc.a.j(cc.a.g(f20768b, "getConfigs", String.class, String.class), f20769c, str, str2);
    }

    @Override // hh.b
    public File h(String str) {
        Class cls = f20768b;
        if (cls == null) {
            return null;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (File) cc.a.j(cc.a.g(f20768b, "getMedia", String.class), f20769c, str);
    }

    @Override // hh.b
    public File i(String str) {
        Class cls = f20768b;
        if (cls == null) {
            return null;
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (File) cc.a.j(cc.a.g(f20768b, "getAsset", String.class), f20769c, str);
    }

    @Override // hh.b
    public List<File> j(String str, String str2) {
        Class cls = f20768b;
        if (cls == null) {
            return Collections.emptyList();
        }
        try {
            f20769c = cls.newInstance();
        } catch (Exception unused) {
            e.c(f20767a, "TranConfigs instance failed: " + f20769c);
        }
        return (List) cc.a.j(cc.a.g(f20768b, "getConfigsList", String.class, String.class), f20769c, str, str2);
    }
}
