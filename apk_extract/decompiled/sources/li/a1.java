package li;

import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 extends c1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f7430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e1 f7431d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(e1 e1Var, long j8, l lVar) {
        super(j8);
        this.f7431d = e1Var;
        this.f7430c = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7430c.C(this.f7431d, Unit.INSTANCE);
    }

    @Override // li.c1
    public final String toString() {
        return super.toString() + this.f7430c;
    }
}
