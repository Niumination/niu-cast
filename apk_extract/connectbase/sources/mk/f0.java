package mk;

import fl.t0;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kn.l0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketSessionKt", f = "WebSocketSession.kt", i = {0}, l = {106, y5.a.Z}, m = "close", n = {"$this$close"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f0.b(null, null, this);
        }
    }

    @os.m
    @lm.k(message = "Close with reason or terminate instead.")
    public static final Object a(@os.l e0 e0Var, @os.m Throwable th2, @os.l um.d<? super l2> dVar) {
        if (th2 == null) {
            Object objC = c(e0Var, null, dVar, 1, null);
            return objC == wm.a.COROUTINE_SUSPENDED ? objC : l2.f10208a;
        }
        Object objD = d(e0Var, th2, dVar);
        return objD == wm.a.COROUTINE_SUSPENDED ? objD : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object b(@os.l e0 e0Var, @os.l mk.a aVar, @os.l um.d<? super l2> dVar) {
        a aVar2;
        if (dVar instanceof a) {
            aVar2 = (a) dVar;
            int i10 = aVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(dVar);
            }
        } else {
            aVar2 = new a(dVar);
        }
        Object obj = aVar2.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar2.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    e0Var = (e0) aVar2.L$0;
                    d1.n(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            g.b bVar = new g.b(aVar);
            aVar2.L$0 = e0Var;
            aVar2.label = 1;
            if (e0Var.U0(bVar, aVar2) == aVar3) {
                return aVar3;
            }
            aVar2.L$0 = null;
            aVar2.label = 2;
            if (e0Var.p0(aVar2) == aVar3) {
                return aVar3;
            }
        } catch (Throwable unused) {
        }
        return l2.f10208a;
    }

    public static /* synthetic */ Object c(e0 e0Var, mk.a aVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = new mk.a(mk.a.EnumC0280a.NORMAL, "");
        }
        return b(e0Var, aVar, dVar);
    }

    @os.m
    @t0
    public static final Object d(@os.l e0 e0Var, @os.l Throwable th2, @os.l um.d<? super l2> dVar) {
        Object objB = b(e0Var, th2 instanceof CancellationException ? new mk.a(mk.a.EnumC0280a.NORMAL, "") : new mk.a(mk.a.EnumC0280a.INTERNAL_ERROR, th2.toString()), dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
    }

    @f
    @os.l
    public static final <T extends w<?>> T e(@os.l e0 e0Var, @os.l x<?, T> xVar) {
        l0.p(e0Var, "<this>");
        l0.p(xVar, "extension");
        T t10 = (T) f(e0Var, xVar);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException(("Extension " + xVar + " not found.").toString());
    }

    @os.m
    @f
    public static final <T extends w<?>> T f(@os.l e0 e0Var, @os.l x<?, T> xVar) {
        Object next;
        l0.p(e0Var, "<this>");
        l0.p(xVar, "extension");
        Iterator<T> it = e0Var.f0().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((w) next).a().getKey() != xVar.getKey());
        if (next instanceof w) {
            return (T) next;
        }
        return null;
    }

    @os.m
    public static final Object g(@os.l e0 e0Var, @os.l String str, @os.l um.d<? super l2> dVar) {
        Object objU0 = e0Var.U0(new g.f(str), dVar);
        return objU0 == wm.a.COROUTINE_SUSPENDED ? objU0 : l2.f10208a;
    }

    @os.m
    public static final Object h(@os.l e0 e0Var, @os.l byte[] bArr, @os.l um.d<? super l2> dVar) {
        Object objU0 = e0Var.U0(new g.a(true, bArr), dVar);
        return objU0 == wm.a.COROUTINE_SUSPENDED ? objU0 : l2.f10208a;
    }
}
