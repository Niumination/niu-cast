package nc;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f8167a = new LinkedList();

    public final void a() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return this.f8167a.equals(((f) obj).f8167a);
    }

    public final int hashCode() {
        return this.f8167a.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[ ");
        boolean z2 = false;
        for (String str : this.f8167a) {
            if (z2) {
                sb2.append(".");
            }
            sb2.append(str);
            z2 = true;
        }
        sb2.append(" ]");
        return sb2.toString();
    }
}
