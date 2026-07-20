package i2;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f5534c;

    public c(long j8, long j10, Set set) {
        this.f5532a = j8;
        this.f5533b = j10;
        this.f5534c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5532a == cVar.f5532a && this.f5533b == cVar.f5533b && this.f5534c.equals(cVar.f5534c);
    }

    public final int hashCode() {
        long j8 = this.f5532a;
        int i8 = (((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003;
        long j10 = this.f5533b;
        return this.f5534c.hashCode() ^ ((i8 ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003);
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f5532a + ", maxAllowedDelay=" + this.f5533b + ", flags=" + this.f5534c + "}";
    }
}
