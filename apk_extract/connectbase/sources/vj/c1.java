package vj;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class c1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f17060d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.j
    public final String f17062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17063c;

    public c1(String str, String str2, long j10) {
        c1.h0.F(str, "typeName");
        c1.h0.e(!str.isEmpty(), "empty type");
        this.f17061a = str;
        this.f17062b = str2;
        this.f17063c = j10;
    }

    public static c1 a(Class<?> cls, @gm.j String str) {
        return b(c(cls), str);
    }

    public static c1 b(String str, @gm.j String str2) {
        return new c1(str, str2, f17060d.incrementAndGet());
    }

    public static String c(Class<?> cls) {
        String simpleName = ((Class) c1.h0.F(cls, ik.y0.a.f8215h)).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long f() {
        return f17060d.incrementAndGet();
    }

    @gm.j
    public String d() {
        return this.f17062b;
    }

    public long e() {
        return this.f17063c;
    }

    public String g() {
        return this.f17061a;
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f17061a);
        sb2.append("<");
        return k.d.a(sb2, this.f17063c, ">");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(h());
        if (this.f17062b != null) {
            sb2.append(": (");
            sb2.append(this.f17062b);
            sb2.append(')');
        }
        return sb2.toString();
    }
}
