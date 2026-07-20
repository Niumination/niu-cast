package kk;

import io.netty.handler.codec.rtsp.RtspHeaders;
import jn.t;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.r0;
import nq.s0;
import nq.y;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final r0 f9235a = new r0("http-pipeline");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final r0 f9236b = new r0("http-pipeline-writer");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final r0 f9237c = new r0("request-handler");

    @xm.f(c = "io.ktor.http.cio.PipelineKt$startConnectionPipeline$1", f = "Pipeline.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.q<xk.c, n, um.d<? super l2>, Object> {
        final /* synthetic */ t<s0, n, pl.k, pl.n, y<Boolean>, um.d<? super l2>, Object> $handler;
        final /* synthetic */ pl.k $input;
        final /* synthetic */ pl.n $output;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(t<? super s0, ? super n, ? super pl.k, ? super pl.n, ? super y<Boolean>, ? super um.d<? super l2>, ? extends Object> tVar, pl.k kVar, pl.n nVar, um.d<? super a> dVar) {
            super(3, dVar);
            this.$handler = tVar;
            this.$input = kVar;
            this.$output = nVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                xk.c cVar = (xk.c) this.L$0;
                n nVar = (n) this.L$1;
                t<s0, n, pl.k, pl.n, y<Boolean>, um.d<? super l2>, Object> tVar = this.$handler;
                pl.k kVar = this.$input;
                pl.n nVar2 = this.$output;
                y<Boolean> yVar = cVar.f20291f;
                this.L$0 = null;
                this.label = 1;
                if (tVar.invoke(cVar, nVar, kVar, nVar2, yVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l xk.c cVar, @os.l n nVar, @os.m um.d<? super l2> dVar) {
            a aVar = new a(this.$handler, this.$input, this.$output, dVar);
            aVar.L$0 = cVar;
            aVar.L$1 = nVar;
            return aVar.invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final r0 a() {
        return f9235a;
    }

    @lm.k(message = "This is an implementation detail and will become internal in future releases.")
    public static /* synthetic */ void b() {
    }

    @os.l
    public static final r0 c() {
        return f9236b;
    }

    @lm.k(message = "This is an implementation detail and will become internal in future releases.")
    public static /* synthetic */ void d() {
    }

    @os.l
    public static final r0 e() {
        return f9237c;
    }

    @lm.k(message = "This is an implementation detail and will become internal in future releases.")
    public static /* synthetic */ void f() {
    }

    @lm.k(message = "This is going to become internal. Start ktor server or raw cio server from ktor-server-cio module instead of constructing server from parts.")
    @os.l
    public static final nq.l2 h(@os.l s0 s0Var, @os.l pl.k kVar, @os.l pl.n nVar, @os.l lk.j jVar, @os.l t<? super s0, ? super n, ? super pl.k, ? super pl.n, ? super y<Boolean>, ? super um.d<? super l2>, ? extends Object> tVar) {
        l0.p(s0Var, "<this>");
        l0.p(kVar, "input");
        l0.p(nVar, "output");
        l0.p(jVar, RtspHeaders.Values.TIMEOUT);
        l0.p(tVar, "handler");
        return xk.b.e(s0Var, new xk.a(kVar, nVar, null, null), jVar, new a(tVar, kVar, nVar, null));
    }
}
