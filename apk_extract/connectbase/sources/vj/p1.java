package vj;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1771")
public abstract class p1 extends o1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1.c f17224a = x1.c.a(new a());

    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public x1.c e(Map<String, ?> map) {
        return f17224a;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return c1.z.c(this).j("policy", b()).d("priority", c()).g("available", d()).toString();
    }
}
