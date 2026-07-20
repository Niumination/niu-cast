package li;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 extends t1 {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f7511h;

    public /* synthetic */ y0(Object obj, int i8) {
        this.e = i8;
        this.f7511h = obj;
    }

    @Override // li.t1
    public final boolean j() {
        switch (this.e) {
        }
        return false;
    }

    @Override // li.t1
    public final void k(Throwable th2) {
        Object obj = this.f7511h;
        switch (this.e) {
            case 0:
                ((x0) obj).dispose();
                break;
            case 1:
                ((Function1) obj).invoke(th2);
                break;
            default:
                x1 x1VarI = i();
                x1VarI.getClass();
                Object obj2 = x1.f7509a.get(x1VarI);
                u1 u1Var = (u1) obj;
                if (!(obj2 instanceof u)) {
                    Result.Companion companion = Result.INSTANCE;
                    u1Var.resumeWith(Result.m159constructorimpl(l0.t(obj2)));
                } else {
                    Result.Companion companion2 = Result.INSTANCE;
                    u1Var.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(((u) obj2).f7494a)));
                }
                break;
        }
    }
}
