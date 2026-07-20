package nq;

/* JADX INFO: loaded from: classes3.dex */
@lm.z0
public class o2 extends t2 implements b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11890c;

    public o2(@os.m l2 l2Var) {
        super(true);
        Y0(l2Var);
        this.f11890c = O1();
    }

    @Override // nq.t2
    public boolean H0() {
        return this.f11890c;
    }

    @Override // nq.t2
    public boolean L0() {
        return true;
    }

    public final boolean O1() {
        t2 t2VarC;
        v vVarR0 = R0();
        w wVar = vVarR0 instanceof w ? (w) vVarR0 : null;
        if (wVar != null && (t2VarC = wVar.C()) != null) {
            while (!t2VarC.H0()) {
                v vVarR1 = t2VarC.R0();
                w wVar2 = vVarR1 instanceof w ? (w) vVarR1 : null;
                if (wVar2 == null || (t2VarC = wVar2.C()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // nq.b0
    public boolean complete() {
        return i1(lm.l2.f10208a);
    }

    @Override // nq.b0
    public boolean k(@os.l Throwable th2) {
        return i1(new d0(th2, false, 2, null));
    }
}
