package r2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u6.c f9313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q2.b f9314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9315d;

    public a(u6.c cVar, q2.b bVar, String str) {
        this.f9313b = cVar;
        this.f9314c = bVar;
        this.f9315d = str;
        this.f9312a = Arrays.hashCode(new Object[]{cVar, bVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return u2.l.h(this.f9313b, aVar.f9313b) && u2.l.h(this.f9314c, aVar.f9314c) && u2.l.h(this.f9315d, aVar.f9315d);
    }

    public final int hashCode() {
        return this.f9312a;
    }
}
