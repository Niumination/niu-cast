package li;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public class r1 extends x1 implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7485c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(p1 p1Var) {
        x1 x1VarI;
        super(true);
        boolean z2 = true;
        Y(p1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = x1.f7510b;
        o oVar = (o) atomicReferenceFieldUpdater.get(this);
        p pVar = oVar instanceof p ? (p) oVar : null;
        if (pVar == null || (x1VarI = pVar.i()) == null) {
            z2 = false;
            break;
        }
        while (!x1VarI.Q()) {
            o oVar2 = (o) atomicReferenceFieldUpdater.get(x1VarI);
            p pVar2 = oVar2 instanceof p ? (p) oVar2 : null;
            if (pVar2 == null || (x1VarI = pVar2.i()) == null) {
                z2 = false;
                break;
            }
        }
        this.f7485c = z2;
    }

    @Override // li.x1
    public final boolean Q() {
        return this.f7485c;
    }

    @Override // li.x1
    public final boolean R() {
        return true;
    }

    public final boolean r0() {
        return d0(Unit.INSTANCE);
    }

    public final boolean s0(Throwable th2) {
        return d0(new u(false, th2));
    }
}
