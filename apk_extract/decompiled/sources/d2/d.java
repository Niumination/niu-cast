package d2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a2.c f4271c;

    public d(String str, byte[] bArr, a2.c cVar) {
        this.f4269a = str;
        this.f4270b = bArr;
        this.f4271c = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f4269a.equals(((d) jVar).f4269a)) {
            if (Arrays.equals(this.f4270b, (jVar instanceof d ? (d) jVar : (d) jVar).f4270b) && this.f4271c.equals(((d) jVar).f4271c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4271c.hashCode() ^ ((((this.f4269a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4270b)) * 1000003);
    }
}
