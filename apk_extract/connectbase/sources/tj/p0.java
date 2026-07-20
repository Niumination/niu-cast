package tj;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f15727b;

    public p0(String str, p0 p0Var) {
        this.f15726a = str;
        this.f15727b = p0Var;
    }

    public static boolean c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '-' && cCharAt != '_') {
                return true;
            }
        }
        return false;
    }

    public static p0 f(String str) {
        return new p0(str, null);
    }

    public static p0 g(String str) {
        return r0.d(str);
    }

    public final void a(StringBuilder sb2) {
        if (c(this.f15726a) || this.f15726a.isEmpty()) {
            sb2.append(n.i(this.f15726a));
        } else {
            sb2.append(this.f15726a);
        }
        if (this.f15727b != null) {
            sb2.append(".");
            this.f15727b.a(sb2);
        }
    }

    public String b() {
        return this.f15726a;
    }

    public String d() {
        while (true) {
            p0 p0Var = this.f15727b;
            if (p0Var == null) {
                return this.f15726a;
            }
            this = p0Var;
        }
    }

    public int e() {
        int i10 = 1;
        for (p0 p0Var = this.f15727b; p0Var != null; p0Var = p0Var.f15727b) {
            i10++;
        }
        return i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return this.f15726a.equals(p0Var.f15726a) && n.b(this.f15727b, p0Var.f15727b);
    }

    public p0 h() {
        if (this.f15727b == null) {
            return null;
        }
        q0 q0Var = new q0();
        while (this.f15727b != null) {
            q0Var.a(this.f15726a);
            this = this.f15727b;
        }
        return q0Var.d();
    }

    public int hashCode() {
        int iA = s0.b.a(this.f15726a, 41, 41);
        p0 p0Var = this.f15727b;
        return iA + (p0Var == null ? 0 : p0Var.hashCode());
    }

    public p0 i(p0 p0Var) {
        q0 q0Var = new q0();
        q0Var.b(p0Var);
        q0Var.b(this);
        return q0Var.d();
    }

    public p0 j() {
        return this.f15727b;
    }

    public String k() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }

    public boolean l(p0 p0Var) {
        if (p0Var.e() > e()) {
            return false;
        }
        while (p0Var != null) {
            if (!p0Var.f15726a.equals(this.f15726a)) {
                return false;
            }
            this = this.f15727b;
            p0Var = p0Var.f15727b;
        }
        return true;
    }

    public p0 m(int i10) {
        while (this != null && i10 > 0) {
            i10--;
            this = this.f15727b;
        }
        return this;
    }

    public p0 n(int i10, int i11) {
        if (i11 < i10) {
            throw new sj.c.d("bad call to subPath");
        }
        p0 p0VarM = m(i10);
        q0 q0Var = new q0();
        int i12 = i11 - i10;
        while (i12 > 0) {
            i12--;
            q0Var.a(p0VarM.f15726a);
            p0VarM = p0VarM.f15727b;
            if (p0VarM == null) {
                throw new sj.c.d(h.a.a("subPath lastIndex out of range ", i11));
            }
        }
        return q0Var.d();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Path(");
        a(sb2);
        sb2.append(")");
        return sb2.toString();
    }

    public p0(String... strArr) {
        if (strArr.length != 0) {
            this.f15726a = strArr[0];
            if (strArr.length > 1) {
                q0 q0Var = new q0();
                for (int i10 = 1; i10 < strArr.length; i10++) {
                    q0Var.a(strArr[i10]);
                }
                this.f15727b = q0Var.d();
                return;
            }
            this.f15727b = null;
            return;
        }
        throw new sj.c.d("empty path");
    }

    public p0(List<p0> list) {
        this(list.iterator());
    }

    public p0(Iterator<p0> it) {
        if (it.hasNext()) {
            p0 next = it.next();
            this.f15726a = next.f15726a;
            q0 q0Var = new q0();
            p0 p0Var = next.f15727b;
            if (p0Var != null) {
                q0Var.b(p0Var);
            }
            while (it.hasNext()) {
                q0Var.b(it.next());
            }
            this.f15727b = q0Var.d();
            return;
        }
        throw new sj.c.d("empty path");
    }
}
