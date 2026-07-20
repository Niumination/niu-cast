package tj;

/* JADX INFO: loaded from: classes2.dex */
public class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f15641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sj.o f15643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15644d;

    public k1(l1 l1Var, sj.o oVar) {
        this(l1Var, oVar, null, null);
    }

    public static k1 c(l1 l1Var, String str, String str2) {
        return new k1(l1Var, null, str2, str);
    }

    public boolean a(Object obj) {
        return obj instanceof k1;
    }

    public final int b() {
        sj.o oVar = this.f15643c;
        if (oVar != null) {
            return oVar.b();
        }
        return -1;
    }

    public final sj.o d() {
        sj.o oVar = this.f15643c;
        if (oVar != null) {
            return oVar;
        }
        throw new sj.c.d("tried to get origin from token that doesn't have one: " + this);
    }

    public String e() {
        return this.f15644d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k1) && a(obj) && this.f15641a == ((k1) obj).f15641a;
    }

    public final l1 f() {
        return this.f15641a;
    }

    public int hashCode() {
        return this.f15641a.hashCode();
    }

    public String toString() {
        String str = this.f15642b;
        return str != null ? str : this.f15641a.name();
    }

    public k1(l1 l1Var, sj.o oVar, String str) {
        this(l1Var, oVar, str, null);
    }

    public k1(l1 l1Var, sj.o oVar, String str, String str2) {
        this.f15641a = l1Var;
        this.f15643c = oVar;
        this.f15642b = str2;
        this.f15644d = str;
    }
}
