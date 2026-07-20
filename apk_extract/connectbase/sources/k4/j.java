package k4;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8960b = "GsonUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1.e f8961a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f8962a = new j();
    }

    public static j e() {
        return a.f8962a;
    }

    @os.m
    public <T> T a(String str, Class<T> cls) {
        try {
            return (T) this.f8961a.fromJson(str, (Class) cls);
        } catch (v1.u e10) {
            m.d(f8960b, e10);
            return null;
        }
    }

    public <T> T b(String str, Type type) {
        try {
            return (T) this.f8961a.fromJson(str, type);
        } catch (v1.u e10) {
            m.d(f8960b, e10);
            return null;
        }
    }

    public <T> T c(v1.k kVar, Class<T> cls) {
        try {
            return (T) this.f8961a.fromJson(kVar, (Class) cls);
        } catch (v1.u unused) {
            return null;
        }
    }

    public v1.e d() {
        return this.f8961a;
    }

    public String f(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return v1.p.parseString(str).getAsJsonObject().get(str2).toString();
        } catch (IllegalStateException e10) {
            m.d(f8960b, e10);
            return null;
        }
    }

    public String g(Object obj) {
        return this.f8961a.toJson(obj);
    }

    public <T> List<T> h(String str, Class<T[]> cls) {
        return Arrays.asList((Object[]) this.f8961a.fromJson(str, (Class) cls));
    }

    public j() {
        this.f8961a = new v1.e();
    }
}
