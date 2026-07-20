package s0;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f14910c = new f("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f14911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public g f14912b;

    public f(String... strArr) {
        this.f14911a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f a(String str) {
        f fVar = new f(this);
        fVar.f14911a.add(str);
        return fVar;
    }

    public final boolean b() {
        List<String> list = this.f14911a;
        return list.get(list.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i10) {
        if (i10 >= this.f14911a.size()) {
            return false;
        }
        boolean z10 = i10 == this.f14911a.size() - 1;
        String str2 = this.f14911a.get(i10);
        if (!str2.equals("**")) {
            return (z10 || (i10 == this.f14911a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z10 && this.f14911a.get(i10 + 1).equals(str)) {
            return i10 == this.f14911a.size() + (-2) || (i10 == this.f14911a.size() + (-3) && b());
        }
        if (z10) {
            return true;
        }
        int i11 = i10 + 1;
        if (i11 < this.f14911a.size() - 1) {
            return false;
        }
        return this.f14911a.get(i11).equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g d() {
        return this.f14912b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i10) {
        if ("__container".equals(str)) {
            return 0;
        }
        if (this.f14911a.get(i10).equals("**")) {
            return (i10 != this.f14911a.size() - 1 && this.f14911a.get(i10 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    public String g() {
        return this.f14911a.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i10) {
        if ("__container".equals(str)) {
            return true;
        }
        if (i10 >= this.f14911a.size()) {
            return false;
        }
        return this.f14911a.get(i10).equals(str) || this.f14911a.get(i10).equals("**") || this.f14911a.get(i10).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean i(String str, int i10) {
        return "__container".equals(str) || i10 < this.f14911a.size() - 1 || this.f14911a.get(i10).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f j(g gVar) {
        f fVar = new f(this);
        fVar.f14912b = gVar;
        return fVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("KeyPath{keys=");
        sb2.append(this.f14911a);
        sb2.append(",resolved=");
        sb2.append(this.f14912b != null);
        sb2.append(rs.f.f14860b);
        return sb2.toString();
    }

    public f(f fVar) {
        this.f14911a = new ArrayList(fVar.f14911a);
        this.f14912b = fVar.f14912b;
    }
}
