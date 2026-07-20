package sj;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f15090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f15093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ClassLoader f15094e;

    public q(v vVar, String str, boolean z10, f fVar, ClassLoader classLoader) {
        this.f15090a = vVar;
        this.f15091b = str;
        this.f15092c = z10;
        this.f15093d = fVar;
        this.f15094e = classLoader;
    }

    public static q b() {
        return new q(null, null, true, null, null);
    }

    public q a(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("null includer passed to appendIncluder");
        }
        f fVar2 = this.f15093d;
        if (fVar2 == fVar) {
            return this;
        }
        return fVar2 != null ? k(fVar2.e(fVar)) : k(fVar);
    }

    public boolean c() {
        return this.f15092c;
    }

    public ClassLoader d() {
        ClassLoader classLoader = this.f15094e;
        return classLoader == null ? Thread.currentThread().getContextClassLoader() : classLoader;
    }

    public f e() {
        return this.f15093d;
    }

    public String f() {
        return this.f15091b;
    }

    public v g() {
        return this.f15090a;
    }

    public q h(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("null includer passed to prependIncluder");
        }
        f fVar2 = this.f15093d;
        if (fVar2 == fVar) {
            return this;
        }
        return fVar2 != null ? k(fVar.e(fVar2)) : k(fVar);
    }

    public q i(boolean z10) {
        return this.f15092c == z10 ? this : new q(this.f15090a, this.f15091b, z10, this.f15093d, this.f15094e);
    }

    public q j(ClassLoader classLoader) {
        return this.f15094e == classLoader ? this : new q(this.f15090a, this.f15091b, this.f15092c, this.f15093d, classLoader);
    }

    public q k(f fVar) {
        return this.f15093d == fVar ? this : new q(this.f15090a, this.f15091b, this.f15092c, fVar, this.f15094e);
    }

    public q l(String str) {
        String str2 = this.f15091b;
        if (str2 == str) {
            return this;
        }
        return (str2 == null || str == null || !str2.equals(str)) ? new q(this.f15090a, str, this.f15092c, this.f15093d, this.f15094e) : this;
    }

    public q m(v vVar) {
        return this.f15090a == vVar ? this : new q(vVar, this.f15091b, this.f15092c, this.f15093d, this.f15094e);
    }

    public q n(String str) {
        return m(tj.n.l(str));
    }

    public q o(String str) {
        return this.f15091b == null ? l(str) : this;
    }
}
