package k3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ka f6452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f6453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final td f6454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0 f6455d;
    public final e0 e;

    public /* synthetic */ g1(af.r5 r5Var) {
        this.f6452a = (ka) r5Var.f557b;
        this.f6453b = (Boolean) r5Var.f558c;
        this.f6454c = (td) r5Var.f559d;
        this.f6455d = (e0) r5Var.e;
        this.e = (e0) r5Var.f560h;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return u2.l.h(this.f6452a, g1Var.f6452a) && u2.l.h(null, null) && u2.l.h(this.f6453b, g1Var.f6453b) && u2.l.h(null, null) && u2.l.h(this.f6454c, g1Var.f6454c) && u2.l.h(this.f6455d, g1Var.f6455d) && u2.l.h(this.e, g1Var.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6452a, null, this.f6453b, null, this.f6454c, this.f6455d, this.e});
    }
}
