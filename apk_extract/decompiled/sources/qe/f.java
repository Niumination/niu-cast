package qe;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f9013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9016d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f9013a == fVar.f9013a && this.f9014b == fVar.f9014b && this.f9015c == fVar.f9015c && this.f9016d == fVar.f9016d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9016d) + a1.a.c(this.f9015c, a1.a.g(this.f9014b, Byte.hashCode(this.f9013a) * 31, 31), 31);
    }

    public final String toString() {
        byte b9 = this.f9013a;
        return "HugeDataModel(funcCode=" + ((int) b9) + ", isRemoteReceivedSuccess=" + this.f9014b + ", dataPackageIndex=" + this.f9015c + ", dataSendOffset=" + this.f9016d + ")";
    }
}
