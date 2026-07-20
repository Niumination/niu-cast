package d2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2.b f4276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4277b;

    public f(a2.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f4276a = bVar;
        this.f4277b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f4276a.equals(fVar.f4276a)) {
            return Arrays.equals(this.f4277b, fVar.f4277b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4277b) ^ ((this.f4276a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f4276a + ", bytes=[...]}";
    }
}
