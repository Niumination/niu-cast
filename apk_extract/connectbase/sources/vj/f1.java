package vj;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @t0
    public static final Charset f17136a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @t0
    public static final l1.b f17137b = v1.f17428g;

    @t0
    public interface a<T> extends v1.m<T> {
    }

    @t0
    public static int a(v1 v1Var) {
        return v1Var.f17431b;
    }

    @t0
    public static <T> v1.i<T> b(String str, a<T> aVar) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return v1.i.i(str, z10, aVar);
    }

    @t0
    public static <T> v1.i<T> c(String str, v1.d<T> dVar) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return v1.i.h(str, z10, dVar);
    }

    @t0
    public static v1 d(int i10, byte[]... bArr) {
        return new v1(i10, (Object[]) bArr);
    }

    @t0
    public static v1 e(byte[]... bArr) {
        return new v1(bArr);
    }

    @t0
    public static v1 f(int i10, Object[] objArr) {
        return new v1(i10, objArr);
    }

    @t0
    public static <T> Object g(v1.g<T> gVar, T t10) {
        return new v1.k(gVar, t10);
    }

    @t0
    public static byte[][] h(v1 v1Var) {
        return v1Var.z();
    }

    @t0
    public static Object[] i(v1 v1Var) {
        return v1Var.A();
    }
}
