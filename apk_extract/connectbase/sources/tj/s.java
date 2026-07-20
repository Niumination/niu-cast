package tj;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends b0 {
    public s(k1 k1Var) {
        super(k1Var);
        if (!n1.j(this.f15573a)) {
            throw new sj.c.d("Tried to create a ConfigNodeComment from a non-comment token");
        }
    }

    public String c() {
        return n1.a(this.f15573a);
    }
}
