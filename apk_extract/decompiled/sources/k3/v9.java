package k3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9 f6682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f6683b;

    public /* synthetic */ v9(tc.d dVar) {
        this.f6682a = (u9) dVar.f10209a;
        this.f6683b = (Integer) dVar.f10210b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v9)) {
            return false;
        }
        v9 v9Var = (v9) obj;
        return u2.l.h(this.f6682a, v9Var.f6682a) && u2.l.h(this.f6683b, v9Var.f6683b) && u2.l.h(null, null) && u2.l.h(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6682a, this.f6683b, null, null});
    }
}
