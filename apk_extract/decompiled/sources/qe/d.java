package qe;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9011b;

    public d(int i8, int i9) {
        this.f9010a = i8;
        this.f9011b = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f9010a == dVar.f9010a && this.f9011b == dVar.f9011b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9011b) + (Integer.hashCode(this.f9010a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BloodPressure(diastolicPressure=");
        sb2.append(this.f9010a);
        sb2.append(", systolicPressure=");
        return h0.a.m(sb2, ")", this.f9011b);
    }
}
