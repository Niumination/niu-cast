package i2;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2.a f5530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f5531b;

    public b(l2.a aVar, HashMap map) {
        this.f5530a = aVar;
        this.f5531b = map;
    }

    public final long a(a2.c cVar, long j8, int i8) {
        long jA = j8 - this.f5530a.a();
        c cVar2 = (c) this.f5531b.get(cVar);
        long j10 = cVar2.f5532a;
        int i9 = i8 - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i9) * j10 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j10 > 1 ? j10 : 2L) * ((long) i9)))), jA), cVar2.f5533b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5530a.equals(bVar.f5530a) && this.f5531b.equals(bVar.f5531b);
    }

    public final int hashCode() {
        return this.f5531b.hashCode() ^ ((this.f5530a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f5530a + ", values=" + this.f5531b + "}";
    }
}
