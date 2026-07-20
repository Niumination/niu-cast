package tl;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends bm.d<o0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15816i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final ql.a f15817n;

    public d0() {
        this(0, 0, null, 7, null);
    }

    @Override // bm.d
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void h(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "instance");
        this.f15817n.a(o0Var.f15820a);
        super.h(o0Var);
        o0Var.n2();
    }

    @Override // bm.d
    @os.l
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public o0 n() {
        return new o0(this.f15817n.c(this.f15816i), (ul.b) null, this);
    }

    @Override // bm.d
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void t(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "instance");
        super.t(o0Var);
        o0.c cVar = o0.H;
        cVar.getClass();
        if (o0Var == o0.L) {
            throw new IllegalStateException("IoBuffer.Empty couldn't be recycled");
        }
        cVar.getClass();
        if (o0Var == o0.L) {
            throw new IllegalStateException("Empty instance couldn't be recycled");
        }
        if (o0Var == e.f15818d.a()) {
            throw new IllegalStateException("Empty instance couldn't be recycled");
        }
        if (o0Var == ul.b.f16311i.a()) {
            throw new IllegalStateException("Empty instance couldn't be recycled");
        }
        if (o0Var.i2() != 0) {
            throw new IllegalStateException("Unable to clear buffer: it is still in use.");
        }
        if (o0Var.f2() != null) {
            throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.");
        }
        if (o0Var.g2() != null) {
            throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.");
        }
    }

    @Override // bm.d
    @os.l
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public o0 d(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "instance");
        kn.l0.p(o0Var, "instance");
        o0Var.o2();
        o0Var.reset();
        return o0Var;
    }

    public /* synthetic */ d0(int i10, int i11, ql.a aVar, int i12, kn.w wVar) {
        this((i12 & 1) != 0 ? 4096 : i10, (i12 & 2) != 0 ? 1000 : i11, (i12 & 4) != 0 ? ql.e.f14042a : aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(int i10, int i11, @os.l ql.a aVar) {
        super(i11);
        kn.l0.p(aVar, "allocator");
        this.f15816i = i10;
        this.f15817n = aVar;
    }
}
