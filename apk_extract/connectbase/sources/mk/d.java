package mk;

import fl.t0;
import lm.d1;
import lm.l2;
import nq.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final r0 f10753a = new r0("ws-incoming-processor");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final r0 f10754b = new r0("ws-outgoing-processor");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final mk.a f10755c = new mk.a(mk.a.EnumC0280a.NORMAL, "OK");

    @xm.f(c = "io.ktor.http.cio.websocket.DefaultWebSocketSessionImplKt", f = "DefaultWebSocketSessionImpl.kt", i = {0, 1}, l = {273, 274, 276}, m = "run", n = {"$this$run", "$this$run"}, s = {"L$0", "L$0"})
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
            return d.d(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    @t0
    public static final Object d(@os.l b bVar, @os.l jn.p<? super b, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
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
                    bVar = (b) aVar.L$0;
                    d1.n(obj);
                } else if (i11 == 2) {
                    d1.n(obj);
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            aVar.L$0 = bVar;
            aVar.label = 1;
            if (pVar.invoke(bVar, aVar) == aVar2) {
                return aVar2;
            }
            aVar.L$0 = bVar;
            aVar.label = 2;
            if (f0.c(bVar, null, aVar, 1, null) == aVar2) {
                return aVar2;
            }
        } catch (Throwable th2) {
            aVar.L$0 = null;
            aVar.label = 3;
            if (f0.d(bVar, th2, aVar) == aVar2) {
                return aVar2;
            }
        }
        return l2.f10208a;
    }
}
