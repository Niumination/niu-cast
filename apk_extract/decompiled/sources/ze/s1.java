package ze;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f11433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11434b;

    public s1(Object obj) {
        this.f11434b = obj;
        this.f11433a = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s1.class != obj.getClass()) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return u8.a(this.f11433a, s1Var.f11433a) && u8.a(this.f11434b, s1Var.f11434b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11433a, this.f11434b});
    }

    public final String toString() {
        Object obj = this.f11434b;
        if (obj != null) {
            o6.a aVarA = t8.a(this);
            aVarA.d(obj, "config");
            return aVarA.toString();
        }
        o6.a aVarA2 = t8.a(this);
        aVarA2.d(this.f11433a, "error");
        return aVarA2.toString();
    }

    public s1(q2 q2Var) {
        this.f11434b = null;
        v8.i(q2Var, NotificationCompat.CATEGORY_STATUS);
        this.f11433a = q2Var;
        v8.d("cannot use OK status: %s", !q2Var.e(), q2Var);
    }
}
