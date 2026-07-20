package oh;

import k3.c2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends Exception implements li.x {
    private final String violation;

    public f0(String violation) {
        Intrinsics.checkNotNullParameter(violation, "violation");
        this.violation = violation;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Received illegal frame: " + this.violation;
    }

    public final String getViolation() {
        return this.violation;
    }

    @Override // li.x
    public f0 createCopy() {
        f0 f0Var = new f0(this.violation);
        c2.a(f0Var, this);
        return f0Var;
    }
}
