package u2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f implements q2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f10335b = new f(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10336a;

    public /* synthetic */ f(String str) {
        this.f10336a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return l.h(this.f10336a, ((f) obj).f10336a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10336a});
    }
}
