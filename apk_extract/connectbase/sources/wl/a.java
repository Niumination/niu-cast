package wl;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lm.d1;
import lm.l2;
import nq.b0;
import nq.r2;
import pl.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19685a = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "suspension");

    @os.l
    private volatile /* synthetic */ Object suspension = null;

    /* JADX INFO: renamed from: wl.a$a, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", i = {0}, l = {28}, m = "sleep", n = {"this"}, s = {"L$0"})
    public static final class C0484a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0484a(um.d<? super C0484a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.d(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", i = {0}, l = {61}, m = "trySuspend", n = {"suspended"}, s = {"I$0"})
    public static final class b extends xm.d {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.e(this);
        }
    }

    public a() {
        e0.a(this);
    }

    public final void b(@os.m Throwable th2) {
        b0 b0Var = (b0) f19685a.getAndSet(this, null);
        if (b0Var == null) {
            return;
        }
        if (th2 != null) {
            b0Var.k(th2);
        } else {
            b0Var.complete();
        }
    }

    public final void c() {
        b0 b0Var = (b0) f19685a.getAndSet(this, null);
        if (b0Var == null) {
            return;
        }
        b0Var.complete();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object d(@os.l um.d<? super l2> dVar) {
        C0484a c0484a;
        if (dVar instanceof C0484a) {
            c0484a = (C0484a) dVar;
            int i10 = c0484a.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0484a.label = i10 - Integer.MIN_VALUE;
            } else {
                c0484a = new C0484a(dVar);
            }
        } else {
            c0484a = new C0484a(dVar);
        }
        Object objE = c0484a.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0484a.label;
        if (i11 == 0) {
            d1.n(objE);
            c0484a.L$0 = this;
            c0484a.label = 1;
            objE = e(c0484a);
            if (objE == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (a) c0484a.L$0;
            d1.n(objE);
        }
        if (((Boolean) objE).booleanValue()) {
            return l2.f10208a;
        }
        this.c();
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(um.d<? super Boolean> dVar) {
        b bVar;
        int i10;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i11 = bVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                bVar.label = i11 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object obj = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = bVar.label;
        if (i12 == 0) {
            d1.n(obj);
            b0 b0VarC = r2.c(null, 1, null);
            if (j.d.a(f19685a, this, null, b0VarC)) {
                bVar.I$0 = 1;
                bVar.label = 1;
                if (b0VarC.t(bVar) == aVar) {
                    return aVar;
                }
                i10 = 1;
            } else {
                i10 = 0;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = bVar.I$0;
            d1.n(obj);
        }
        return Boolean.valueOf(i10 != 0);
    }
}
