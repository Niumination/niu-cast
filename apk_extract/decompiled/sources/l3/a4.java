package l3;

/* JADX INFO: loaded from: classes.dex */
public final class a4 extends m0 implements r1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7204c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a4(int i8, q0 q0Var) {
        super(q0Var);
        this.f7204c = i8;
    }

    @Override // l3.m0
    public /* bridge */ /* synthetic */ q0 d() {
        switch (this.f7204c) {
            case 0:
                return i();
            default:
                return super.d();
        }
    }

    @Override // l3.m0
    public /* bridge */ /* synthetic */ q1 e() {
        switch (this.f7204c) {
            case 0:
                return i();
            default:
                return super.e();
        }
    }

    @Override // l3.m0
    public void h() {
        switch (this.f7204c) {
            case 0:
                super.h();
                q0 q0Var = this.f7270b;
                if (((n0) q0Var).zza != i0.f7249c) {
                    n0 n0Var = (n0) q0Var;
                    n0Var.zza = n0Var.zza.clone();
                }
                break;
            default:
                super.h();
                break;
        }
    }

    public n0 i() {
        if (!((n0) this.f7270b).k()) {
            return (n0) this.f7270b;
        }
        ((n0) this.f7270b).zza.e();
        return (n0) super.d();
    }
}
