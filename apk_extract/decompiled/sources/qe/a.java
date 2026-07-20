package qe;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8993b;

    public a(int i8, int i9) {
        this.f8992a = i8;
        this.f8993b = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8992a == aVar.f8992a && this.f8993b == aVar.f8993b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8993b) + (Integer.hashCode(this.f8992a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BloodOxygen(veinBloodOxygen=");
        sb2.append(this.f8992a);
        sb2.append(", arteryBloodOxygen=");
        return h0.a.m(sb2, ")", this.f8993b);
    }
}
