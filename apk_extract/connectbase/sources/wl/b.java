package wl;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> implements um.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19686a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19687b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "jobCancellationHandler");

    @os.l
    private volatile /* synthetic */ Object state = null;

    @os.l
    private volatile /* synthetic */ Object jobCancellationHandler = null;

    public final class a implements jn.l<Throwable, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final nq.l2 f19688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public n1 f19689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b<T> f19690c;

        public a(@os.l b bVar, nq.l2 l2Var) {
            l0.p(bVar, "this$0");
            l0.p(l2Var, "job");
            this.f19690c = bVar;
            this.f19688a = l2Var;
            n1 n1VarG = nq.l2.a.g(l2Var, true, false, this, 2, null);
            if (l2Var.isActive()) {
                this.f19689b = n1VarG;
            }
        }

        public final void a() {
            n1 n1Var = this.f19689b;
            if (n1Var == null) {
                return;
            }
            this.f19689b = null;
            n1Var.dispose();
        }

        @os.l
        public final nq.l2 b() {
            return this.f19688a;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@os.m Throwable th2) {
            this.f19690c.i(this);
            a();
            if (th2 != null) {
                this.f19690c.m(this.f19688a, th2);
            }
        }
    }

    public final void d(@os.l T t10) {
        l0.p(t10, "value");
        c1.a aVar = c1.Companion;
        resumeWith(c1.m59constructorimpl(t10));
        a aVar2 = (a) f19687b.getAndSet(this, null);
        if (aVar2 == null) {
            return;
        }
        aVar2.a();
    }

    public final void f(@os.l Throwable th2) {
        l0.p(th2, "cause");
        c1.a aVar = c1.Companion;
        resumeWith(c1.m59constructorimpl(d1.a(th2)));
        a aVar2 = (a) f19687b.getAndSet(this, null);
        if (aVar2 == null) {
            return;
        }
        aVar2.a();
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        Object obj = this.state;
        um.d dVar = obj instanceof um.d ? (um.d) obj : null;
        um.g context = dVar != null ? dVar.getContext() : null;
        return context == null ? um.i.INSTANCE : context;
    }

    @os.l
    public final Object h(@os.l um.d<? super T> dVar) throws Throwable {
        l0.p(dVar, "actual");
        while (true) {
            Object obj = this.state;
            if (obj == null) {
                if (j.d.a(f19686a, this, null, dVar)) {
                    k(dVar.getContext());
                    return wm.a.COROUTINE_SUSPENDED;
                }
            } else if (j.d.a(f19686a, this, obj, null)) {
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                return obj;
            }
        }
    }

    public final void i(b<T>.a aVar) {
        j.d.a(f19687b, this, aVar, null);
    }

    public final void k(um.g gVar) {
        Object obj;
        a aVar;
        nq.l2 l2Var = (nq.l2) gVar.get(nq.l2.f11882k);
        a aVar2 = (a) this.jobCancellationHandler;
        if ((aVar2 == null ? null : aVar2.f19688a) == l2Var) {
            return;
        }
        if (l2Var == null) {
            a aVar3 = (a) f19687b.getAndSet(this, null);
            if (aVar3 == null) {
                return;
            }
            aVar3.a();
            return;
        }
        a aVar4 = new a(this, l2Var);
        do {
            obj = this.jobCancellationHandler;
            aVar = (a) obj;
            if (aVar != null && aVar.f19688a == l2Var) {
                aVar4.a();
                return;
            }
        } while (!j.d.a(f19687b, this, obj, aVar4));
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public final void m(nq.l2 l2Var, Throwable th2) {
        Object obj;
        um.d dVar;
        do {
            obj = this.state;
            if (!(obj instanceof um.d)) {
                return;
            }
            dVar = (um.d) obj;
            if (dVar.getContext().get(nq.l2.f11882k) != l2Var) {
                return;
            }
        } while (!j.d.a(f19686a, this, obj, null));
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
        }
        c1.a aVar = c1.Companion;
        w.a.a(th2, dVar);
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        Object obj2;
        Object objM62exceptionOrNullimpl;
        do {
            obj2 = this.state;
            if (obj2 == null) {
                objM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
                if (objM62exceptionOrNullimpl == null) {
                    d1.n(obj);
                    objM62exceptionOrNullimpl = obj;
                }
            } else if (!(obj2 instanceof um.d)) {
                return;
            } else {
                objM62exceptionOrNullimpl = null;
            }
        } while (!j.d.a(f19686a, this, obj2, objM62exceptionOrNullimpl));
        if (obj2 instanceof um.d) {
            ((um.d) obj2).resumeWith(obj);
        }
    }
}
