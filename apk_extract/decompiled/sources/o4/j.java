package o4;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8390c;

    public j(int i8, int i9, Class cls) {
        this.f8388a = cls;
        this.f8389b = i8;
        this.f8390c = i9;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f8388a == jVar.f8388a && this.f8389b == jVar.f8389b && this.f8390c == jVar.f8390c;
    }

    public final int hashCode() {
        return this.f8390c ^ ((((this.f8388a.hashCode() ^ 1000003) * 1000003) ^ this.f8389b) * 1000003);
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f8388a);
        sb2.append(", type=");
        int i8 = this.f8389b;
        if (i8 == 1) {
            str = "required";
        } else {
            str = i8 == 0 ? "optional" : "set";
        }
        sb2.append(str);
        sb2.append(", injection=");
        int i9 = this.f8390c;
        if (i9 == 0) {
            str2 = "direct";
        } else if (i9 == 1) {
            str2 = "provider";
        } else {
            if (i9 != 2) {
                throw new AssertionError(a1.a.o(i9, "Unsupported injection: "));
            }
            str2 = "deferred";
        }
        return h0.a.n(sb2, str2, "}");
    }
}
