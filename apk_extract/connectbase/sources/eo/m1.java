package eo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f4623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4624b;

    public m1(@os.l String str, boolean z10) {
        kn.l0.p(str, "name");
        this.f4623a = str;
        this.f4624b = z10;
    }

    @os.m
    public Integer a(@os.l m1 m1Var) {
        kn.l0.p(m1Var, "visibility");
        return l1.f4610a.a(this, m1Var);
    }

    @os.l
    public String b() {
        return this.f4623a;
    }

    public final boolean c() {
        return this.f4624b;
    }

    @os.l
    public m1 d() {
        return this;
    }

    @os.l
    public final String toString() {
        return b();
    }
}
