package ze;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 {
    public static final x0 e = new x0(null, null, q2.e, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f11466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p001if.p f11467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q2 f11468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11469d;

    public x0(i iVar, p001if.p pVar, q2 q2Var, boolean z2) {
        this.f11466a = iVar;
        this.f11467b = pVar;
        v8.i(q2Var, NotificationCompat.CATEGORY_STATUS);
        this.f11468c = q2Var;
        this.f11469d = z2;
    }

    public static x0 a(q2 q2Var) {
        v8.c("error status shouldn't be OK", !q2Var.e());
        return new x0(null, null, q2Var, false);
    }

    public static x0 b(i iVar, p001if.p pVar) {
        v8.i(iVar, "subchannel");
        return new x0(iVar, pVar, q2.e, false);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return u8.a(this.f11466a, x0Var.f11466a) && u8.a(this.f11468c, x0Var.f11468c) && u8.a(this.f11467b, x0Var.f11467b) && this.f11469d == x0Var.f11469d;
    }

    public final int hashCode() {
        Boolean boolValueOf = Boolean.valueOf(this.f11469d);
        return Arrays.hashCode(new Object[]{this.f11466a, this.f11468c, this.f11467b, boolValueOf});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11466a, "subchannel");
        aVarA.d(this.f11467b, "streamTracerFactory");
        aVarA.d(this.f11468c, NotificationCompat.CATEGORY_STATUS);
        aVarA.f("drop", this.f11469d);
        return aVarA.toString();
    }
}
