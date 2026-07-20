package vi;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import li.l;
import li.s2;
import qi.w;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements li.j, s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f10592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f10594c;

    public b(c cVar, l lVar, Object obj) {
        this.f10594c = cVar;
        this.f10592a = lVar;
        this.f10593b = obj;
    }

    @Override // li.j
    public final boolean a() {
        return this.f10592a.a();
    }

    @Override // li.j
    public final boolean b(Throwable th2) {
        return this.f10592a.b(th2);
    }

    @Override // li.s2
    public final void c(w wVar, int i8) {
        this.f10592a.c(wVar, i8);
    }

    @Override // li.j
    public final a8.a d(Object obj, Function3 function3) {
        c cVar = this.f10594c;
        ni.d dVar = new ni.d(1, cVar, this);
        a8.a aVarE = this.f10592a.E((Unit) obj, dVar);
        if (aVarE != null) {
            c.f10595h.set(cVar, this.f10593b);
        }
        return aVarE;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext */
    public final CoroutineContext get$context() {
        return this.f10592a.e;
    }

    @Override // li.j
    public final void p(Object obj, Function3 function3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f10595h;
        c cVar = this.f10594c;
        atomicReferenceFieldUpdater.set(cVar, this.f10593b);
        gi.a aVar = new gi.a(12, cVar, this);
        l lVar = this.f10592a;
        lVar.B((Unit) obj, lVar.f7491c, new li.k(aVar, 0));
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f10592a.resumeWith(obj);
    }

    @Override // li.j
    public final void u(Object obj) {
        this.f10592a.u(obj);
    }
}
