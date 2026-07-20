package c2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1404a;

    public i(ArrayList arrayList) {
        this.f1404a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        return this.f1404a.equals(((i) ((p) obj)).f1404a);
    }

    public final int hashCode() {
        return this.f1404a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f1404a + "}";
    }
}
