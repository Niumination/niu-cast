package sj;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f15099d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f15102c;

    public static class a implements u {
        @Override // sj.u
        public x a(String str) {
            return null;
        }

        @Override // sj.u
        public u b(u uVar) {
            return uVar;
        }
    }

    public t(boolean z10, boolean z11, u uVar) {
        this.f15100a = z10;
        this.f15101b = z11;
        this.f15102c = uVar;
    }

    public static t b() {
        return new t(true, false, f15099d);
    }

    public static t f() {
        return b().h(false);
    }

    public t a(u uVar) {
        if (uVar == null) {
            throw new c.d("null resolver passed to appendResolver");
        }
        u uVar2 = this.f15102c;
        return uVar == uVar2 ? this : new t(this.f15100a, this.f15101b, uVar2.b(uVar));
    }

    public boolean c() {
        return this.f15101b;
    }

    public u d() {
        return this.f15102c;
    }

    public boolean e() {
        return this.f15100a;
    }

    public t g(boolean z10) {
        return new t(this.f15100a, z10, this.f15102c);
    }

    public t h(boolean z10) {
        return new t(z10, this.f15101b, this.f15102c);
    }
}
