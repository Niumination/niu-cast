package e2;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l2.a f4663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l2.a f4664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4665d;

    public b(Context context, l2.a aVar, l2.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f4662a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f4663b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f4664c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f4665d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f4662a.equals(((b) dVar).f4662a)) {
            b bVar = (b) dVar;
            if (this.f4663b.equals(bVar.f4663b) && this.f4664c.equals(bVar.f4664c) && this.f4665d.equals(bVar.f4665d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4665d.hashCode() ^ ((((((this.f4662a.hashCode() ^ 1000003) * 1000003) ^ this.f4663b.hashCode()) * 1000003) ^ this.f4664c.hashCode()) * 1000003);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CreationContext{applicationContext=");
        sb2.append(this.f4662a);
        sb2.append(", wallClock=");
        sb2.append(this.f4663b);
        sb2.append(", monotonicClock=");
        sb2.append(this.f4664c);
        sb2.append(", backendName=");
        return h0.a.n(sb2, this.f4665d, "}");
    }
}
