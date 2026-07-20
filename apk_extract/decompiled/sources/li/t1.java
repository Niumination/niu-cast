package li;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t1 extends qi.m implements x0, l1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x1 f7492d;

    @Override // li.l1
    public final boolean a() {
        return true;
    }

    @Override // li.l1
    public final b2 b() {
        return null;
    }

    @Override // li.x0
    public final void dispose() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        Object obj2;
        qi.m mVar;
        qi.t tVar;
        x1 x1VarI = i();
        x1VarI.getClass();
        do {
            atomicReferenceFieldUpdater = x1.f7509a;
            obj = atomicReferenceFieldUpdater.get(x1VarI);
            if (!(obj instanceof t1)) {
                if (!(obj instanceof l1) || ((l1) obj).b() == null) {
                    return;
                }
                do {
                    atomicReferenceFieldUpdater2 = qi.m.f9153a;
                    obj2 = atomicReferenceFieldUpdater2.get(this);
                    if (obj2 instanceof qi.t) {
                        qi.m mVar2 = ((qi.t) obj2).f9167a;
                        return;
                    }
                    if (obj2 == this) {
                        return;
                    }
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                    mVar = (qi.m) obj2;
                    mVar.getClass();
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = qi.m.f9155c;
                    tVar = (qi.t) atomicReferenceFieldUpdater3.get(mVar);
                    if (tVar == null) {
                        tVar = new qi.t(mVar);
                        atomicReferenceFieldUpdater3.set(mVar, tVar);
                    }
                } while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, tVar));
                mVar.d();
                return;
            }
            if (obj != this) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(x1VarI, obj, l0.f7475j));
    }

    public p1 getParent() {
        return i();
    }

    public final x1 i() {
        x1 x1Var = this.f7492d;
        if (x1Var != null) {
            return x1Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    public abstract boolean j();

    public abstract void k(Throwable th2);

    @Override // qi.m
    public final String toString() {
        return getClass().getSimpleName() + '@' + l0.j(this) + "[job@" + l0.j(i()) + ']';
    }
}
