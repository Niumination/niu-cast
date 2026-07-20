package j1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f5943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f5944b;

    public c0(j jVar) {
        this.f5943a = jVar;
        this.f5944b = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        j jVar = this.f5943a;
        if (jVar != null && jVar.equals(c0Var.f5943a)) {
            return true;
        }
        Throwable th2 = this.f5944b;
        if (th2 == null || c0Var.f5944b == null) {
            return false;
        }
        return th2.toString().equals(th2.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5943a, this.f5944b});
    }

    public c0(Throwable th2) {
        this.f5944b = th2;
        this.f5943a = null;
    }
}
