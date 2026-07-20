package k3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class td {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f6657a;

    public /* synthetic */ td(a8.a aVar) {
        this.f6657a = (e0) aVar.f44b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof td) {
            return u2.l.h(this.f6657a, ((td) obj).f6657a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6657a});
    }
}
