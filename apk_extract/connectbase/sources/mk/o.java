package mk;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import fl.t0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    @xm.f(c = "io.ktor.http.cio.websocket.RawWebSocketKt", f = "RawWebSocket.kt", i = {0, 1}, l = {90, ms.a.T}, m = FloatingWindow.f2048b0, n = {"$this$start", "$this$start"}, s = {"L$0", "L$0"})
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
            return o.a(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    @t0
    public static final Object a(@os.l n nVar, @os.l jn.p<? super e0, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    nVar = (n) aVar.L$0;
                    d1.n(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    nVar = (n) aVar.L$0;
                    d1.n(obj);
                }
                nq.t0.f(nVar, null, 1, null);
                return l2.f10208a;
            }
            d1.n(obj);
            aVar.L$0 = nVar;
            aVar.label = 1;
            if (pVar.invoke(nVar, aVar) == aVar2) {
                return aVar2;
            }
            g0 g0Var = nVar.f10812f;
            aVar.L$0 = nVar;
            aVar.label = 2;
            if (g0Var.p0(aVar) == aVar2) {
                return aVar2;
            }
            nq.t0.f(nVar, null, 1, null);
            return l2.f10208a;
        } catch (Throwable th2) {
            nq.t0.f(nVar, null, 1, null);
            throw th2;
        }
    }
}
