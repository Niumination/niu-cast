package k3;

/* JADX INFO: loaded from: classes.dex */
public final class vd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6687c;

    public vd(int i8, String str, boolean z2) {
        this.f6685a = str;
        this.f6686b = z2;
        this.f6687c = i8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof vd) {
            vd vdVar = (vd) obj;
            if (this.f6685a.equals(vdVar.f6685a) && this.f6686b == vdVar.f6686b && this.f6687c == vdVar.f6687c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f6685a.hashCode() ^ 1000003;
        return this.f6687c ^ (((iHashCode * 1000003) ^ (true != this.f6686b ? 1237 : 1231)) * 1000003);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MLKitLoggingOptions{libraryName=");
        sb2.append(this.f6685a);
        sb2.append(", enableFirelog=");
        sb2.append(this.f6686b);
        sb2.append(", firelogEventType=");
        return h0.a.m(sb2, "}", this.f6687c);
    }
}
