package af;

import java.util.Arrays;
import k3.u8;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ze.b f255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ze.i0 f256c;

    public final boolean equals(Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f254a.equals(f0Var.f254a) && this.f255b.equals(f0Var.f255b) && u8.a(null, null) && u8.a(this.f256c, f0Var.f256c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f254a, this.f255b, null, this.f256c});
    }
}
