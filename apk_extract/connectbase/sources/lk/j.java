package lk;

import fl.t0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jn.p;
import kn.l0;
import kn.n0;
import kn.u1;
import kn.w;
import lm.k;
import lm.l2;
import nq.g2;
import nq.n1;
import nq.o2;
import nq.r2;
import nq.s0;
import nq.v;
import nq.x;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final jn.a<Long> f10129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final ll.c f10130c;
    private volatile boolean cancelled;

    public static final class a extends n0 implements jn.a<Long> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    public static abstract class b extends ll.e implements d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f10131d;

        public b(long j10) {
            this.f10131d = j10;
        }

        public abstract void N();

        public final long O() {
            return this.f10131d;
        }

        public boolean P() {
            return !(v() instanceof ll.g);
        }

        @Override // nq.n1
        public void dispose() {
            G();
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        @Override // lk.j.d
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@m Throwable th2) {
            d.a.a(this, th2);
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @l
        public final nq.l2 f10132e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j10, @l nq.l2 l2Var) {
            super(j10);
            l0.p(l2Var, "job");
            this.f10132e = l2Var;
        }

        @Override // lk.j.b
        public void N() {
            nq.l2.a.b(this.f10132e, null, 1, null);
        }

        @Override // lk.j.b
        public boolean P() {
            return super.P() && this.f10132e.isActive();
        }
    }

    public interface d extends jn.l<Throwable, l2>, n1 {

        public static final class a {
            public static void a(@l d dVar, @m Throwable th2) {
                l0.p(dVar, "this");
                dVar.dispose();
            }
        }

        void invoke(@m Throwable th2);
    }

    public j(long j10, @l jn.a<Long> aVar) {
        l0.p(aVar, RtspHeaders.Values.CLOCK);
        this.f10128a = j10;
        this.f10129b = aVar;
        this.f10130c = new ll.c();
    }

    public final void a() {
        this.cancelled = true;
        e();
    }

    public final <T> void b(um.d<? super T> dVar) {
        nq.l2 l2Var = (nq.l2) dVar.getContext().get(nq.l2.f11882k);
        if (l2Var != null && l2Var.isCancelled()) {
            throw l2Var.O();
        }
    }

    public final int c() {
        ll.c cVar = this.f10130c;
        int i10 = 0;
        for (ll.e eVarX = (ll.e) cVar.v(); !l0.g(eVarX, cVar); eVarX = eVarX.x()) {
            if (eVarX instanceof b) {
                i10++;
            }
        }
        return i10;
    }

    public final long d() {
        return this.f10128a;
    }

    public final void e() {
        f(this.f10129b.invoke().longValue(), this.f10130c, this.cancelled);
    }

    public final void f(long j10, ll.c cVar, boolean z10) {
        while (true) {
            Object objV = cVar.v();
            b bVar = objV instanceof b ? (b) objV : null;
            if (bVar == null) {
                return;
            }
            if (!z10 && bVar.f10131d > j10) {
                return;
            }
            if (bVar.P() && bVar.G()) {
                bVar.N();
            }
        }
    }

    @l
    public final d g(@l nq.l2 l2Var) {
        l0.p(l2Var, "job");
        long jLongValue = this.f10129b.invoke().longValue();
        ll.c cVar = this.f10130c;
        if (this.cancelled) {
            throw new CancellationException();
        }
        c cVar2 = new c(this.f10128a + jLongValue, l2Var);
        cVar.f(cVar2);
        f(jLongValue, cVar, this.cancelled);
        if (!this.cancelled) {
            return cVar2;
        }
        cVar2.N();
        throw new CancellationException();
    }

    @m
    public final <T> Object h(@l p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, @l um.d<? super T> dVar) {
        Object objInvoke;
        if (!r2.A(dVar.getContext())) {
            b(dVar);
        }
        um.d dVarE = wm.c.e(dVar);
        e eVar = new e(dVarE.getContext(), dVarE, null, 4, null);
        d dVarG = g(eVar);
        eVar.k0(dVarG);
        try {
            if (eVar.f10134a.isCancelled()) {
                throw eVar.f10134a.O();
            }
            objInvoke = ((p) u1.q(pVar, 2)).invoke(eVar, eVar);
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (objInvoke != aVar && eVar.f()) {
                dVarG.dispose();
            }
            if (objInvoke == aVar) {
                xm.h.c(dVar);
            }
            return objInvoke;
        } catch (Throwable th2) {
            if (eVar.f()) {
                dVarG.dispose();
                throw th2;
            }
            objInvoke = wm.a.COROUTINE_SUSPENDED;
        }
    }

    public static final class e<T> implements um.d<T>, nq.l2, s0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f10133c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "state");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final nq.l2 f10134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final um.g f10135b;

        @l
        private volatile /* synthetic */ Object state;

        public e(@l um.g gVar, @l um.d<? super T> dVar, @l nq.l2 l2Var) {
            l0.p(gVar, "context");
            l0.p(dVar, "delegate");
            l0.p(l2Var, "job");
            this.f10134a = l2Var;
            this.f10135b = gVar.plus(l2Var);
            this.state = dVar;
        }

        @Override // nq.l2
        @l
        public yq.e J1() {
            return this.f10134a.J1();
        }

        @Override // nq.l2
        @g2
        @l
        public CancellationException O() {
            return this.f10134a.O();
        }

        @Override // nq.l2
        @g2
        @l
        public n1 S1(boolean z10, boolean z11, @l jn.l<? super Throwable, l2> lVar) {
            l0.p(lVar, "handler");
            return this.f10134a.S1(z10, z11, lVar);
        }

        @Override // nq.l2
        public void b(@m CancellationException cancellationException) {
            this.f10134a.b(cancellationException);
        }

        @Override // nq.l2
        @k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public /* synthetic */ boolean c(Throwable th2) {
            return this.f10134a.c(th2);
        }

        @Override // nq.l2
        @k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public /* synthetic */ void cancel() {
            this.f10134a.cancel();
        }

        public final boolean f() {
            Object obj;
            do {
                obj = this.state;
                if (((um.d) obj) == null) {
                    return false;
                }
            } while (!j.d.a(f10133c, this, obj, null));
            nq.l2.a.b(this.f10134a, null, 1, null);
            return true;
        }

        @Override // um.g.b, um.g
        public <R> R fold(R r10, @l p<? super R, ? super um.g.b, ? extends R> pVar) {
            l0.p(pVar, "operation");
            return (R) this.f10134a.fold(r10, pVar);
        }

        @Override // um.g.b, um.g
        @m
        public <E extends um.g.b> E get(@l um.g.c<E> cVar) {
            l0.p(cVar, cb.b.c.f1408o);
            return (E) this.f10134a.get(cVar);
        }

        @Override // um.d
        @l
        public um.g getContext() {
            return this.f10135b;
        }

        @Override // nq.s0
        @l
        public um.g getCoroutineContext() {
            return this.f10135b;
        }

        @Override // um.g.b
        @l
        public um.g.c<?> getKey() {
            return this.f10134a.getKey();
        }

        @Override // nq.l2
        public boolean isActive() {
            return this.f10134a.isActive();
        }

        @Override // nq.l2
        public boolean isCancelled() {
            return this.f10134a.isCancelled();
        }

        @Override // nq.l2
        public boolean isCompleted() {
            return this.f10134a.isCompleted();
        }

        @Override // nq.l2
        @l
        public n1 k0(@l jn.l<? super Throwable, l2> lVar) {
            l0.p(lVar, "handler");
            return this.f10134a.k0(lVar);
        }

        @Override // um.g.b, um.g
        @l
        public um.g minusKey(@l um.g.c<?> cVar) {
            l0.p(cVar, cb.b.c.f1408o);
            return this.f10134a.minusKey(cVar);
        }

        @Override // nq.l2
        @g2
        @l
        public v o(@l x xVar) {
            l0.p(xVar, "child");
            return this.f10134a.o(xVar);
        }

        @Override // um.g
        @l
        public um.g plus(@l um.g gVar) {
            l0.p(gVar, "context");
            return this.f10134a.plus(gVar);
        }

        @Override // um.d
        public void resumeWith(@l Object obj) {
            Object obj2;
            um.d dVar;
            do {
                obj2 = this.state;
                dVar = (um.d) obj2;
                if (dVar == null) {
                    return;
                }
            } while (!j.d.a(f10133c, this, obj2, null));
            if (dVar == null) {
                return;
            }
            dVar.resumeWith(obj);
            nq.l2.a.b(this.f10134a, null, 1, null);
        }

        @Override // nq.l2
        public boolean start() {
            return this.f10134a.start();
        }

        @Override // nq.l2
        @m
        public Object t(@l um.d<? super l2> dVar) {
            return this.f10134a.t(dVar);
        }

        @Override // nq.l2
        @l
        public gq.m<nq.l2> y() {
            return this.f10134a.y();
        }

        @Override // nq.l2
        @k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @l
        public nq.l2 y0(@l nq.l2 l2Var) {
            l0.p(l2Var, "other");
            return this.f10134a.y0(l2Var);
        }

        public e(um.g gVar, um.d dVar, nq.l2 l2Var, int i10, w wVar) {
            this(gVar, dVar, (i10 & 4) != 0 ? new o2((nq.l2) gVar.get(nq.l2.f11882k)) : l2Var);
        }
    }

    public /* synthetic */ j(long j10, jn.a aVar, int i10, w wVar) {
        this(j10, (i10 & 2) != 0 ? a.INSTANCE : aVar);
    }
}
