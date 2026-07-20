package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f8637c = new f("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f8639b;

    public f(String... strArr) {
        this.f8638a = Arrays.asList(strArr);
    }

    public final boolean a(int i8, String str) {
        List list = this.f8638a;
        if (i8 >= list.size()) {
            return false;
        }
        boolean z2 = i8 == list.size() - 1;
        String str2 = (String) list.get(i8);
        if (!str2.equals("**")) {
            return (z2 || (i8 == list.size() + (-2) && ((String) a1.a.j(1, list)).equals("**"))) && (str2.equals(str) || str2.equals(vj.e.ANY_MARKER));
        }
        if (!z2 && ((String) list.get(i8 + 1)).equals(str)) {
            return i8 == list.size() + (-2) || (i8 == list.size() + (-3) && ((String) a1.a.j(1, list)).equals("**"));
        }
        if (z2) {
            return true;
        }
        int i9 = i8 + 1;
        if (i9 < list.size() - 1) {
            return false;
        }
        return ((String) list.get(i9)).equals(str);
    }

    public final int b(int i8, String str) {
        if ("__container".equals(str)) {
            return 0;
        }
        List list = this.f8638a;
        if (((String) list.get(i8)).equals("**")) {
            return (i8 != list.size() - 1 && ((String) list.get(i8 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean c(int i8, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f8638a;
        if (i8 >= list.size()) {
            return false;
        }
        return ((String) list.get(i8)).equals(str) || ((String) list.get(i8)).equals("**") || ((String) list.get(i8)).equals(vj.e.ANY_MARKER);
    }

    public final boolean d(int i8, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f8638a;
        return i8 < list.size() - 1 || ((String) list.get(i8)).equals("**");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.f8638a.equals(fVar.f8638a)) {
            return false;
        }
        g gVar = this.f8639b;
        if (gVar != null) {
            return gVar.equals(fVar.f8639b);
        }
        return fVar.f8639b == null;
    }

    public final int hashCode() {
        int iHashCode = this.f8638a.hashCode() * 31;
        g gVar = this.f8639b;
        return iHashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("KeyPath{keys=");
        sb2.append(this.f8638a);
        sb2.append(",resolved=");
        sb2.append(this.f8639b != null);
        sb2.append('}');
        return sb2.toString();
    }

    public f(f fVar) {
        this.f8638a = new ArrayList(fVar.f8638a);
        this.f8639b = fVar.f8639b;
    }
}
