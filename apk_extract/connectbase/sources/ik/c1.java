package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends fl.p1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public z1 f7945d;

    /* JADX WARN: Multi-variable type inference failed */
    public c1() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @os.l
    public final z1 A() {
        return this.f7945d;
    }

    public final void B(@os.l z1 z1Var) {
        kn.l0.p(z1Var, "<set-?>");
        this.f7945d = z1Var;
    }

    @Override // fl.p1
    @os.l
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public b1 f() {
        if (this.f6089c) {
            throw new IllegalArgumentException("ParametersBuilder can only build a single Parameters instance");
        }
        this.f6089c = true;
        return new d1(this.f6088b, this.f7945d);
    }

    public /* synthetic */ c1(int i10, z1 z1Var, int i11, kn.w wVar) {
        this((i11 & 1) != 0 ? 8 : i10, (i11 & 2) != 0 ? z1.DEFAULT : z1Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(int i10, @os.l z1 z1Var) {
        super(true, i10);
        kn.l0.p(z1Var, "urlEncodingOption");
        this.f7945d = z1Var;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public /* synthetic */ c1(int i10) {
        this(i10, z1.DEFAULT);
    }

    public /* synthetic */ c1(int i10, int i11, kn.w wVar) {
        this((i11 & 1) != 0 ? 8 : i10);
    }
}
