package bi;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<String> f897a = new LinkedList<>();

    public s a(String str) {
        this.f897a.add(str);
        return this;
    }

    public List<String> b() {
        return this.f897a;
    }

    public int c() {
        return this.f897a.size();
    }

    public String d() {
        return this.f897a.removeLast();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        return this.f897a.equals(((s) obj).f897a);
    }

    public int hashCode() {
        return this.f897a.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[ ");
        boolean z10 = false;
        for (String str : this.f897a) {
            if (z10) {
                sb2.append(".");
            }
            sb2.append(str);
            z10 = true;
        }
        sb2.append(" ]");
        return sb2.toString();
    }
}
