package nq;

/* JADX INFO: loaded from: classes3.dex */
@g2
public abstract class a<T> extends t2 implements l2, um.d<T>, s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final um.g f11822c;

    public a(@os.l um.g gVar, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            Y0((l2) gVar.get(l2.f11882k));
        }
        this.f11822c = gVar.plus(this);
    }

    public static /* synthetic */ void P1() {
    }

    public void O1(@os.m Object obj) {
        X(obj);
    }

    public void Q1(@os.l Throwable th2, boolean z10) {
    }

    public void T1(T t10) {
    }

    public final <R> void U1(@os.l u0 u0Var, R r10, @os.l jn.p<? super R, ? super um.d<? super T>, ? extends Object> pVar) {
        u0Var.invoke(pVar, r10, this);
    }

    @Override // nq.t2
    public final void X0(@os.l Throwable th2) {
        p0.b(this.f11822c, th2);
    }

    @Override // um.d
    @os.l
    public final um.g getContext() {
        return this.f11822c;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f11822c;
    }

    @Override // nq.t2, nq.l2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // nq.t2
    @os.l
    public String l1() {
        return x0.a(this);
    }

    @Override // nq.t2
    @os.l
    public String m0() {
        return x0.a(this) + " was cancelled";
    }

    @Override // um.d
    public final void resumeWith(@os.l Object obj) {
        Object objJ1 = j1(j0.d(obj, null, 1, null));
        if (objJ1 == u2.f11950b) {
            return;
        }
        O1(objJ1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nq.t2
    public final void t1(@os.m Object obj) {
        if (!(obj instanceof d0)) {
            T1(obj);
        } else {
            d0 d0Var = (d0) obj;
            Q1(d0Var.f11836a, d0Var.a());
        }
    }
}
