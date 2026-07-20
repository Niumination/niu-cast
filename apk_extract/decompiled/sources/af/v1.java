package af;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 extends s1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ze.q0 f631d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v1(ze.q0 q0Var, int i8) {
        super((byte) 0, 0);
        this.f630c = i8;
        this.f631d = q0Var;
    }

    @Override // af.s1
    public final void j() {
        switch (this.f630c) {
            case 0:
                f2 f2Var = (f2) this.f631d;
                ((i3) f2Var.f263d.f447c).f332m.Z.l(f2Var, true);
                break;
            case 1:
                ((j3) this.f631d).m();
                break;
            default:
                ((cf.q) this.f631d).f1616h.h(true);
                break;
        }
    }

    @Override // af.s1
    public final void k() {
        switch (this.f630c) {
            case 0:
                f2 f2Var = (f2) this.f631d;
                ((i3) f2Var.f263d.f447c).f332m.Z.l(f2Var, false);
                break;
            case 1:
                j3 j3Var = (j3) this.f631d;
                if (!j3Var.F.get()) {
                    j3Var.o();
                    break;
                }
                break;
            default:
                ((cf.q) this.f631d).f1616h.h(false);
                break;
        }
    }
}
