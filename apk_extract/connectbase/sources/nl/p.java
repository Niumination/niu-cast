package nl;

import java.util.ArrayList;
import java.util.List;
import jn.q;
import kn.l0;
import kn.u1;
import lm.c1;
import lm.d1;
import lm.l2;
import lm.y;
import nm.h0;
import nq.s0;
import pl.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class p<TSubject, TContext> implements f<TSubject, TContext>, h<TSubject>, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final TContext f11600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> f11601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final um.d<l2> f11603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public TSubject f11604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public Object f11605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11606g;

    public static final class a implements um.d<l2>, xm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p<TSubject, TContext> f11607a;

        public a(p<TSubject, TContext> pVar) {
            this.f11607a = pVar;
        }

        public static /* synthetic */ void a() {
        }

        public final um.d<?> b() {
            Object obj;
            p<TSubject, TContext> pVar = this.f11607a;
            int i10 = pVar.f11602c;
            if (i10 < 0 || (obj = pVar.f11605f) == null) {
                return null;
            }
            if (obj instanceof um.d) {
                pVar.f11602c = i10 - 1;
                return (um.d) obj;
            }
            if (obj instanceof ArrayList) {
                return ((ArrayList) obj).isEmpty() ? o.f11599a : d((List) obj);
            }
            return null;
        }

        public final um.d<?> d(List<? extends um.d<?>> list) {
            try {
                int i10 = this.f11607a.f11602c;
                um.d<?> dVar = (um.d) h0.W2(list, i10);
                if (dVar == null) {
                    return o.f11599a;
                }
                this.f11607a.f11602c = i10 - 1;
                return dVar;
            } catch (Throwable unused) {
                return o.f11599a;
            }
        }

        @Override // xm.e
        @os.m
        public xm.e getCallerFrame() {
            um.d<?> dVarB = b();
            if (dVarB instanceof xm.e) {
                return (xm.e) dVarB;
            }
            return null;
        }

        @Override // um.d
        @os.l
        public um.g getContext() {
            Object obj = this.f11607a.f11605f;
            if (obj == null) {
                throw new IllegalStateException("Not started");
            }
            if (obj instanceof um.d) {
                return ((um.d) obj).getContext();
            }
            if (obj instanceof List) {
                return ((um.d) h0.p3((List) obj)).getContext();
            }
            throw new IllegalStateException("Unexpected rootContinuation value");
        }

        @Override // xm.e
        @os.m
        public StackTraceElement getStackTraceElement() {
            return null;
        }

        @Override // um.d
        public void resumeWith(@os.l Object obj) {
            if (!c1.m64isFailureimpl(obj)) {
                this.f11607a.l(false);
                return;
            }
            p<TSubject, TContext> pVar = this.f11607a;
            c1.a aVar = c1.Companion;
            Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
            l0.m(thM62exceptionOrNullimpl);
            pVar.m(c1.m59constructorimpl(d1.a(thM62exceptionOrNullimpl)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(@os.l TSubject tsubject, @os.l TContext tcontext, @os.l List<? extends q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list) {
        l0.p(tsubject, "initial");
        l0.p(tcontext, "context");
        l0.p(list, "blocks");
        this.f11600a = tcontext;
        this.f11601b = list;
        this.f11602c = -1;
        this.f11603d = new a(this);
        this.f11604e = tsubject;
        e0.b(this);
    }

    @Override // nl.f
    @os.l
    public TSubject E() {
        return this.f11604e;
    }

    @Override // nl.f
    @os.m
    public Object J0(@os.l um.d<? super TSubject> dVar) {
        Object obj;
        if (this.f11606g == this.f11601b.size()) {
            obj = this.f11604e;
        } else {
            j(dVar);
            if (l(true)) {
                k();
                obj = this.f11604e;
            } else {
                obj = wm.a.COROUTINE_SUSPENDED;
            }
        }
        if (obj == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return obj;
    }

    @Override // nl.h
    @os.m
    public Object b(@os.l TSubject tsubject, @os.l um.d<? super TSubject> dVar) {
        this.f11606g = 0;
        if (this.f11601b.size() == 0) {
            return tsubject;
        }
        this.f11604e = tsubject;
        if (this.f11605f == null) {
            return J0(dVar);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // nl.f
    public void finish() {
        this.f11606g = this.f11601b.size();
    }

    @Override // nl.f
    @os.l
    public TContext getContext() {
        return this.f11600a;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f11603d.getContext();
    }

    public final void j(um.d<? super TSubject> dVar) {
        Object obj = this.f11605f;
        if (obj == null) {
            this.f11602c = 0;
            this.f11605f = dVar;
            return;
        }
        if (obj instanceof um.d) {
            ArrayList arrayList = new ArrayList(this.f11601b.size());
            arrayList.add(obj);
            arrayList.add(dVar);
            this.f11602c = 1;
            this.f11605f = arrayList;
            return;
        }
        if (!(obj instanceof ArrayList)) {
            n(obj);
            throw new y();
        }
        ((ArrayList) obj).add(dVar);
        this.f11602c = nm.y.J((List) obj);
    }

    public final void k() {
        Object obj = this.f11605f;
        if (obj == null) {
            throw new IllegalStateException("No more continuations to resume");
        }
        if (obj instanceof um.d) {
            this.f11602c = -1;
            this.f11605f = null;
        } else {
            if (!(obj instanceof ArrayList)) {
                n(obj);
                throw new y();
            }
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No more continuations to resume");
            }
            List list = (List) obj;
            arrayList.remove(nm.y.J(list));
            this.f11602c = nm.y.J(list);
        }
    }

    public final boolean l(boolean z10) {
        q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object> qVar;
        do {
            int i10 = this.f11606g;
            if (i10 == this.f11601b.size()) {
                if (z10) {
                    return true;
                }
                c1.a aVar = c1.Companion;
                m(c1.m59constructorimpl(this.f11604e));
                return false;
            }
            this.f11606g = i10 + 1;
            qVar = this.f11601b.get(i10);
            try {
            } catch (Throwable th2) {
                c1.a aVar2 = c1.Companion;
                m(c1.m59constructorimpl(d1.a(th2)));
                return false;
            }
        } while (((q) u1.q(qVar, 3)).invoke(this, this.f11604e, this.f11603d) != wm.a.COROUTINE_SUSPENDED);
        return false;
    }

    public final void m(Object obj) {
        Object objRemove = this.f11605f;
        if (objRemove == null) {
            throw new IllegalStateException("No more continuations to resume");
        }
        if (objRemove instanceof um.d) {
            this.f11605f = null;
            this.f11602c = -1;
        } else {
            if (!(objRemove instanceof ArrayList)) {
                n(objRemove);
                throw new y();
            }
            ArrayList arrayList = (ArrayList) objRemove;
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No more continuations to resume");
            }
            List list = (List) objRemove;
            this.f11602c = nm.y.J(list) - 1;
            objRemove = arrayList.remove(nm.y.J(list));
        }
        if (objRemove == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<TSubject of io.ktor.util.pipeline.SuspendFunctionGun>");
        }
        um.d dVar = (um.d) objRemove;
        if (!c1.m64isFailureimpl(obj)) {
            dVar.resumeWith(obj);
            return;
        }
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
        l0.m(thM62exceptionOrNullimpl);
        Throwable thA = m.a(thM62exceptionOrNullimpl, dVar);
        c1.a aVar = c1.Companion;
        w.a.a(thA, dVar);
    }

    public final Void n(Object obj) {
        throw new IllegalStateException(l0.C("Unexpected rootContinuation content: ", obj));
    }

    @Override // nl.f
    @os.m
    public Object v0(@os.l TSubject tsubject, @os.l um.d<? super TSubject> dVar) {
        this.f11604e = tsubject;
        return J0(dVar);
    }
}
