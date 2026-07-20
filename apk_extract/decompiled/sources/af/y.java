package af;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f707c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f708d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(e3 e3Var, ze.y yVar) {
        super(yVar, 0);
        this.f708d = e3Var;
    }

    @Override // af.l0
    public final void b() {
        List list;
        switch (this.f707c) {
            case 0:
                qf.c cVar = (qf.c) this.f708d;
                ph.b.d();
                try {
                    ph.c cVar2 = ((a0) cVar.f9049d).f125b;
                    ph.b.a();
                    ph.b.f8887a.getClass();
                    if (((ze.q2) cVar.f9048c) == null) {
                        try {
                            ((ze.f0) cVar.f9047b).j();
                        } catch (Throwable th2) {
                            ze.q2 q2VarH = ze.q2.f.g(th2).h("Failed to call onReady.");
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
            case 1:
                ((e3) this.f708d).i();
                return;
            default:
                q0 q0Var = (q0) this.f708d;
                q0Var.getClass();
                List arrayList = new ArrayList();
                while (true) {
                    synchronized (q0Var) {
                        try {
                            if (q0Var.f524c.isEmpty()) {
                                q0Var.f524c = null;
                                q0Var.f523b = true;
                                return;
                            } else {
                                list = q0Var.f524c;
                                q0Var.f524c = arrayList;
                            }
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    list.clear();
                    arrayList = list;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(e3 e3Var, q0 q0Var) {
        super(e3Var.f233c, 0);
        this.f708d = q0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(qf.c cVar) {
        super(((a0) cVar.f9049d).f, 0);
        this.f708d = cVar;
    }
}
