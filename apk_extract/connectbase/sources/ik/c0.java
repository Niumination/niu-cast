package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends fl.p1 {
    public c0() {
        this(0, 1, null);
    }

    @Override // fl.p1
    public void x(@os.l String str) {
        kn.l0.p(str, "name");
        super.x(str);
        j0.f8048a.a(str);
    }

    @Override // fl.p1
    public void y(@os.l String str) {
        kn.l0.p(str, "value");
        super.y(str);
        j0.f8048a.b(str);
    }

    @Override // fl.p1
    @os.l
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public b0 f() {
        if (this.f6089c) {
            throw new IllegalArgumentException("HeadersBuilder can only build a single Headers instance");
        }
        this.f6089c = true;
        return new d0(this.f6088b);
    }

    public c0(int i10) {
        super(true, i10);
    }

    public c0(int i10, int i11, kn.w wVar) {
        super(true, (i11 & 1) != 0 ? 8 : i10);
    }
}
