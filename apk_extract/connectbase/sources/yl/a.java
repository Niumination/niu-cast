package yl;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import kn.n0;
import kn.w;
import lm.c1;
import lm.d1;
import lm.i0;
import nq.l2;
import nq.n1;
import nq.u1;
import os.l;
import os.m;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f21437f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public final l2 f21438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final um.d<lm.l2> f21439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final n1 f21440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21442e;

    @l
    volatile /* synthetic */ int result;

    @l
    volatile /* synthetic */ Object state;

    /* JADX INFO: renamed from: yl.a$a, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.utils.io.jvm.javaio.BlockingAdapter$block$1", f = "Blocking.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0548a extends o implements jn.l<um.d<? super lm.l2>, Object> {
        int label;

        public C0548a(um.d<? super C0548a> dVar) {
            super(1, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<lm.l2> create(@l um.d<?> dVar) {
            return a.this.new C0548a(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                a aVar2 = a.this;
                this.label = 1;
                if (aVar2.i(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return lm.l2.f10208a;
        }

        @Override // jn.l
        @m
        public final Object invoke(@m um.d<? super lm.l2> dVar) {
            return ((C0548a) create(dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    public static final class b extends n0 implements jn.l<Throwable, lm.l2> {
        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
            invoke2(th2);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Throwable th2) {
            if (th2 != null) {
                um.d dVar = a.this.f21439b;
                c1.a aVar = c1.Companion;
                w.a.a(th2, dVar);
            }
        }
    }

    public static final class c implements um.d<lm.l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final um.g f21443a;

        public c() {
            l2 l2Var = a.this.f21438a;
            this.f21443a = l2Var != null ? j.f21461a.plus(l2Var) : j.f21461a;
        }

        @Override // um.d
        @l
        public um.g getContext() {
            return this.f21443a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // um.d
        public void resumeWith(@l Object obj) {
            Object obj2;
            boolean z10;
            Throwable thM62exceptionOrNullimpl;
            l2 l2Var;
            Object objM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
            if (objM62exceptionOrNullimpl == null) {
                objM62exceptionOrNullimpl = lm.l2.f10208a;
            }
            a aVar = a.this;
            do {
                obj2 = aVar.state;
                z10 = obj2 instanceof Thread;
                if (!(z10 ? true : obj2 instanceof um.d ? true : l0.g(obj2, this))) {
                    return;
                }
            } while (!j.d.a(a.f21437f, aVar, obj2, objM62exceptionOrNullimpl));
            if (z10) {
                g.a().c(obj2);
            } else if ((obj2 instanceof um.d) && (thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj)) != null) {
                c1.a aVar2 = c1.Companion;
                w.a.a(thM62exceptionOrNullimpl, (um.d) obj2);
            }
            if (c1.m64isFailureimpl(obj) && !(c1.m62exceptionOrNullimpl(obj) instanceof CancellationException) && (l2Var = a.this.f21438a) != null) {
                l2.a.b(l2Var, null, 1, null);
            }
            n1 n1Var = a.this.f21440c;
            if (n1Var == null) {
                return;
            }
            n1Var.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void h() {
    }

    public final void d(int i10) {
        this.result = i10;
    }

    public final int e() {
        return this.f21442e;
    }

    public final int f() {
        return this.f21441d;
    }

    @m
    public final l2 g() {
        return this.f21438a;
    }

    @m
    public abstract Object i(@l um.d<? super lm.l2> dVar);

    public final void j(Thread thread) {
        if (this.state != thread) {
            return;
        }
        while (true) {
            long jD = u1.d();
            if (this.state != thread) {
                return;
            }
            if (jD > 0) {
                g.a().a(jD);
            }
        }
    }

    @m
    public final Object k(int i10, @l um.d<Object> dVar) {
        this.result = i10;
        Object objL = l(dVar);
        if (objL == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object l(um.d<Object> dVar) {
        Object obj;
        um.d dVarE;
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                dVarE = wm.c.e(dVar);
                obj = obj3;
            } else {
                if (!l0.g(obj3, this)) {
                    throw new IllegalStateException("Already suspended or in finished state");
                }
                obj = obj2;
                dVarE = wm.c.e(dVar);
            }
            if (j.d.a(f21437f, this, obj3, dVarE)) {
                if (obj != null) {
                    g.a().c(obj);
                }
                return wm.a.COROUTINE_SUSPENDED;
            }
            obj2 = obj;
        }
    }

    public final Object m(int i10, um.d<Object> dVar) {
        this.result = i10;
        Object objL = l(dVar);
        if (objL == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objL;
    }

    public final void n() {
        n1 n1Var = this.f21440c;
        if (n1Var != null) {
            n1Var.dispose();
        }
        um.d<lm.l2> dVar = this.f21439b;
        c1.a aVar = c1.Companion;
        dVar.resumeWith(c1.m59constructorimpl(d1.a(new CancellationException("Stream closed"))));
    }

    public final int o(@l Object obj) throws Throwable {
        Object obj2;
        Object i0Var;
        l0.p(obj, "jobToken");
        Thread threadCurrentThread = Thread.currentThread();
        um.d dVar = null;
        do {
            obj2 = this.state;
            if (obj2 instanceof um.d) {
                dVar = (um.d) obj2;
                i0Var = threadCurrentThread;
            } else {
                if (obj2 instanceof lm.l2) {
                    return this.result;
                }
                if (obj2 instanceof Throwable) {
                    throw ((Throwable) obj2);
                }
                if (obj2 instanceof Thread) {
                    throw new IllegalStateException("There is already thread owning adapter");
                }
                if (l0.g(obj2, this)) {
                    throw new IllegalStateException("Not yet started");
                }
                i0Var = new i0();
            }
            l0.o(i0Var, "when (value) {\n         …Exception()\n            }");
        } while (!j.d.a(f21437f, this, obj2, i0Var));
        l0.m(dVar);
        c1.a aVar = c1.Companion;
        dVar.resumeWith(c1.m59constructorimpl(obj));
        l0.o(threadCurrentThread, "thread");
        j(threadCurrentThread);
        Object obj3 = this.state;
        if (obj3 instanceof Throwable) {
            throw ((Throwable) obj3);
        }
        return this.result;
    }

    public final int p(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "buffer");
        this.f21441d = i10;
        this.f21442e = i11;
        return o(bArr);
    }

    public a(@m l2 l2Var) {
        this.f21438a = l2Var;
        c cVar = new c();
        this.f21439b = cVar;
        this.state = this;
        this.result = 0;
        this.f21440c = l2Var == null ? null : l2Var.k0(new b());
        ((jn.l) kn.u1.q(new C0548a(null), 1)).invoke(cVar);
        if (this.state == this) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public /* synthetic */ a(l2 l2Var, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : l2Var);
    }
}
