package af;

import java.io.InputStream;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f638c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f639d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(a0 a0Var, ze.f0 f0Var) {
        super(a0Var.f, 0);
        this.e = a0Var;
        this.f639d = f0Var;
    }

    @Override // af.l0
    public final void b() {
        switch (this.f638c) {
            case 0:
                ((ze.f0) this.f639d).f(ze.i.s(((a0) this.e).f), new ze.p1());
                return;
            case 1:
                qf.c cVar = (qf.c) this.e;
                ph.b.d();
                try {
                    ph.c cVar2 = ((a0) cVar.f9049d).f125b;
                    ph.b.a();
                    ph.b.f8887a.getClass();
                    if (((ze.q2) cVar.f9048c) == null) {
                        try {
                            ((ze.f0) cVar.f9047b).h((ze.p1) this.f639d);
                        } catch (Throwable th2) {
                            ze.q2 q2VarH = ze.q2.f.g(th2).h("Failed to read headers");
                            cVar.f9048c = q2VarH;
                            ((a0) cVar.f9049d).f131j.h(q2VarH);
                        }
                        break;
                    }
                    ph.b.f8887a.getClass();
                    return;
                } catch (Throwable th3) {
                    try {
                        ph.b.f8887a.getClass();
                        break;
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            case 2:
                ph.b.d();
                try {
                    ph.c cVar3 = ((a0) ((qf.c) this.e).f9049d).f125b;
                    ph.b.a();
                    ph.a aVar = ph.b.f8887a;
                    aVar.getClass();
                    c();
                    aVar.getClass();
                    return;
                } catch (Throwable th5) {
                    try {
                        ph.b.f8887a.getClass();
                        break;
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            case 3:
                r5 r5Var = (r5) this.e;
                ph.b.d();
                try {
                    r5Var.getClass();
                    ph.b.a();
                    ph.a aVar2 = ph.b.f8887a;
                    aVar2.getClass();
                    z5 z5Var = (z5) r5Var.f560h;
                    if (z5Var == null) {
                        throw new IllegalStateException("listener unset");
                    }
                    z5Var.p((ze.q2) this.f639d);
                    aVar2.getClass();
                    return;
                } catch (Throwable th7) {
                    try {
                        ph.b.f8887a.getClass();
                        break;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                    }
                    throw th7;
                }
            default:
                r5 r5Var2 = (r5) this.e;
                try {
                    ph.b.d();
                    try {
                        r5Var2.getClass();
                        ph.b.a();
                        ph.a aVar3 = ph.b.f8887a;
                        aVar3.getClass();
                        z5 z5Var2 = (z5) r5Var2.f560h;
                        if (z5Var2 == null) {
                            throw new IllegalStateException("listener unset");
                        }
                        z5Var2.j((a8.a) this.f639d);
                        aVar3.getClass();
                        return;
                    } catch (Throwable th9) {
                        try {
                            ph.b.f8887a.getClass();
                            break;
                        } catch (Throwable th10) {
                            th9.addSuppressed(th10);
                        }
                        throw th9;
                    }
                } catch (Throwable th11) {
                    r5.h(r5Var2, th11);
                    throw th11;
                }
        }
    }

    public void c() {
        qf.c cVar = (qf.c) this.e;
        ze.q2 q2Var = (ze.q2) cVar.f9048c;
        a0 a0Var = (a0) cVar.f9049d;
        a8.a aVar = (a8.a) this.f639d;
        if (q2Var != null) {
            Logger logger = l1.f410a;
            while (true) {
                InputStream inputStreamF = aVar.f();
                if (inputStreamF == null) {
                    return;
                } else {
                    l1.b(inputStreamF);
                }
            }
        } else {
            while (true) {
                try {
                    InputStream inputStreamF2 = aVar.f();
                    if (inputStreamF2 == null) {
                        return;
                    }
                    try {
                        ((ze.f0) cVar.f9047b).i(a0Var.f124a.e.a(inputStreamF2));
                        inputStreamF2.close();
                    } catch (Throwable th2) {
                        l1.b(inputStreamF2);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    Logger logger2 = l1.f410a;
                    while (true) {
                        InputStream inputStreamF3 = aVar.f();
                        if (inputStreamF3 == null) {
                            ze.q2 q2VarH = ze.q2.f.g(th3).h("Failed to read message.");
                            cVar.f9048c = q2VarH;
                            a0Var.f131j.h(q2VarH);
                            return;
                        }
                        l1.b(inputStreamF3);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(qf.c cVar, ze.p1 p1Var) {
        super(((a0) cVar.f9049d).f, 0);
        this.e = cVar;
        this.f639d = p1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(qf.c cVar, a8.a aVar) {
        super(((a0) cVar.f9049d).f, 0);
        this.e = cVar;
        this.f639d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r5 r5Var, a8.a aVar) {
        super((ze.s) r5Var.f559d, 0);
        this.e = r5Var;
        this.f639d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r5 r5Var, ze.q2 q2Var) {
        super((ze.s) r5Var.f559d, 0);
        this.e = r5Var;
        this.f639d = q2Var;
    }
}
