package ze;

import java.util.concurrent.atomic.AtomicLong;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f11418d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11421c;

    public r0(String str, String str2, long j8) {
        v8.i(str, "typeName");
        v8.c("empty type", !str.isEmpty());
        this.f11419a = str;
        this.f11420b = str2;
        this.f11421c = j8;
    }

    public static r0 a(Class cls, String str) {
        String simpleName = cls.getSimpleName();
        if (simpleName.isEmpty()) {
            simpleName = cls.getName().substring(cls.getPackage().getName().length() + 1);
        }
        return new r0(simpleName, str, f11418d.incrementAndGet());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f11419a + "<" + this.f11421c + ">");
        String str = this.f11420b;
        if (str != null) {
            sb2.append(": (");
            sb2.append(str);
            sb2.append(')');
        }
        return sb2.toString();
    }
}
