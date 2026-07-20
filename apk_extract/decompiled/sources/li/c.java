package li;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends t1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7435j = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;
    public final l e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x0 f7436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f7437i;

    public c(e eVar, l lVar) {
        this.f7437i = eVar;
        this.e = lVar;
    }

    @Override // li.t1
    public final boolean j() {
        return false;
    }

    @Override // li.t1
    public final void k(Throwable th2) {
        l lVar = this.e;
        if (th2 != null) {
            lVar.getClass();
            a8.a aVarE = lVar.E(new u(false, th2), null);
            if (aVarE != null) {
                lVar.u(aVarE);
                d dVar = (d) f7435j.get(this);
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e.f7444b;
        e eVar = this.f7437i;
        if (atomicIntegerFieldUpdater.decrementAndGet(eVar) == 0) {
            o0[] o0VarArr = eVar.f7445a;
            ArrayList arrayList = new ArrayList(o0VarArr.length);
            for (o0 o0Var : o0VarArr) {
                arrayList.add(o0Var.m());
            }
            lVar.resumeWith(Result.m159constructorimpl(arrayList));
        }
    }
}
