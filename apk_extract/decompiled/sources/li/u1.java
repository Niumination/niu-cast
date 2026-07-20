package li;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 extends l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x1 f7495k;

    public u1(Continuation continuation, x1 x1Var) {
        super(1, continuation);
        this.f7495k = x1Var;
    }

    @Override // li.l
    public final Throwable q(x1 x1Var) {
        Throwable thD;
        x1 x1Var2 = this.f7495k;
        x1Var2.getClass();
        Object obj = x1.f7509a.get(x1Var2);
        if (!(obj instanceof w1) || (thD = ((w1) obj).d()) == null) {
            return obj instanceof u ? ((u) obj).f7494a : x1Var.t();
        }
        return thD;
    }

    @Override // li.l
    public final String z() {
        return "AwaitContinuation";
    }
}
