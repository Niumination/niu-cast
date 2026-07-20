package xk;

import androidx.constraintlayout.widget.ConstraintLayout;
import fl.t0;
import ik.r0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import jn.p;
import jn.q;
import kk.n;
import kn.l0;
import lk.j;
import lm.d1;
import lm.l2;
import nq.s0;
import nq.y;
import os.l;
import os.m;
import pl.k;
import pq.f0;
import pq.t;
import tl.v;
import um.g;
import xm.d;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final v f20285a;

    @f(c = "io.ktor.server.cio.backend.ServerPipelineKt", f = "ServerPipeline.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {ra.a.f14314x, 198}, m = "pipelineWriterLoop", n = {RtspHeaders.Values.TIMEOUT, "connection", "receiveChildOrNull", RtspHeaders.Values.TIMEOUT, "connection", "receiveChildOrNull", "child"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class a extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.d(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: xk.b$b, reason: collision with other inner class name */
    @f(c = "io.ktor.server.cio.backend.ServerPipelineKt$pipelineWriterLoop$receiveChildOrNull$1", f = "ServerPipeline.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0517b extends o implements p<s0, um.d<? super k>, Object> {
        final /* synthetic */ f0<k> $channel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0517b(f0<? extends k> f0Var, um.d<? super C0517b> dVar) {
            super(2, dVar);
            this.$channel = f0Var;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new C0517b(this.$channel, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                f0<k> f0Var = this.$channel;
                this.label = 1;
                obj = t.i(f0Var, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return obj;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super k> dVar) {
            return ((C0517b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @f(c = "io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1", f = "ServerPipeline.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 64, 84, y5.a.f20716e0, 148, 150, 159, 168}, m = "invokeSuspend", n = {"$this$launch", "outputsActor", "requestContext", "$this$launch", "outputsActor", "bc", "$this$launch", "outputsActor", "requestContext", "request", "response", "transferEncoding", "upgrade", "contentType", "http11", "$this$launch", "outputsActor", "response", "$this$launch", "outputsActor", "requestContext", "response", "transferEncoding", "connectionOptions", "requestBody", "http11", "contentLength", "expectedHttpBody", "$this$launch", "outputsActor", "$this$launch", "outputsActor", "requestContext", "response", "connectionOptions", "requestBody", "http11", "$this$launch", "outputsActor", "response", "requestBody"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "J$0", "Z$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3"})
    public static final class c extends o implements p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ xk.a $connection;
        final /* synthetic */ q<xk.c, n, um.d<? super l2>, Object> $handler;
        final /* synthetic */ j $timeout;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;

        @f(c = "io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1$1", f = "ServerPipeline.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends o implements p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ xk.a $connection;
            final /* synthetic */ q<xk.c, n, um.d<? super l2>, Object> $handler;
            final /* synthetic */ n $request;
            final /* synthetic */ k $requestBody;
            final /* synthetic */ pl.c $response;
            final /* synthetic */ y<Boolean> $upgraded;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(k kVar, pl.c cVar, xk.a aVar, y<Boolean> yVar, q<? super xk.c, ? super n, ? super um.d<? super l2>, ? extends Object> qVar, n nVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$requestBody = kVar;
                this.$response = cVar;
                this.$connection = aVar;
                this.$upgraded = yVar;
                this.$handler = qVar;
                this.$request = nVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                a aVar = new a(this.$requestBody, this.$response, this.$connection, this.$upgraded, this.$handler, this.$request, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, xk.b$c$a] */
            /* JADX WARN: Type inference failed for: r10v1, types: [xk.b$c$a] */
            /* JADX WARN: Type inference failed for: r10v5, types: [nq.y] */
            /* JADX WARN: Type inference failed for: r10v6, types: [nq.y<java.lang.Boolean>] */
            /* JADX WARN: Type inference failed for: r10v8 */
            /* JADX WARN: Type inference failed for: r10v9 */
            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                ?? r10;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        d1.n(obj);
                        g coroutineContext = ((s0) this.L$0).getCoroutineContext();
                        k kVar = this.$requestBody;
                        pl.c cVar = this.$response;
                        xk.a aVar2 = this.$connection;
                        xk.c cVar2 = new xk.c(coroutineContext, kVar, cVar, aVar2.f20283c, aVar2.f20284d, this.$upgraded);
                        q<xk.c, n, um.d<? super l2>, Object> qVar = this.$handler;
                        n nVar = this.$request;
                        this.label = 1;
                        if (qVar.invoke(cVar2, nVar, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    pl.o.a(this.$response);
                    this = this.$upgraded;
                    r10 = this;
                    if (this != 0) {
                        r10.l0(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    try {
                        this.$response.f(th2);
                        y<Boolean> yVar = this.$upgraded;
                        if (yVar != null) {
                            yVar.k(th2);
                        }
                        pl.o.a(this.$response);
                        y<Boolean> yVar2 = this.$upgraded;
                        r10 = yVar2;
                        if (yVar2 != null) {
                        }
                    } catch (Throwable th3) {
                        pl.o.a(this.$response);
                        y<Boolean> yVar3 = this.$upgraded;
                        if (yVar3 != null) {
                            yVar3.l0(Boolean.FALSE);
                        }
                        throw th3;
                    }
                }
                return l2.f10208a;
            }

            @Override // jn.p
            @m
            public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX INFO: renamed from: xk.b$c$b, reason: collision with other inner class name */
        @f(c = "io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1$outputsActor$1", f = "ServerPipeline.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0518b extends o implements p<pq.c<k>, um.d<? super l2>, Object> {
            final /* synthetic */ xk.a $connection;
            final /* synthetic */ j $timeout;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0518b(j jVar, xk.a aVar, um.d<? super C0518b> dVar) {
                super(2, dVar);
                this.$timeout = jVar;
                this.$connection = aVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                C0518b c0518b = new C0518b(this.$timeout, this.$connection, dVar);
                c0518b.L$0 = obj;
                return c0518b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v8, types: [xk.a] */
            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                xk.a aVar;
                wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        d1.n(obj);
                        pq.l lVarA = ((pq.c) this.L$0).a();
                        j jVar = this.$timeout;
                        xk.a aVar3 = this.$connection;
                        this.label = 1;
                        if (b.d(lVarA, jVar, aVar3, this) == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    this = this.$connection;
                    aVar = this;
                } catch (Throwable th2) {
                    try {
                        this.$connection.f20282b.f(th2);
                        aVar = this.$connection;
                    } finally {
                        pl.o.a(this.$connection.f20282b);
                    }
                }
                pl.n nVar = aVar.f20282b;
                return l2.f10208a;
            }

            @Override // jn.p
            @m
            public final Object invoke(@l pq.c<k> cVar, @m um.d<? super l2> dVar) {
                return ((C0518b) create(cVar, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(xk.a aVar, j jVar, q<? super xk.c, ? super n, ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$connection = aVar;
            this.$timeout = jVar;
            this.$handler = qVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            c cVar = new c(this.$connection, this.$timeout, this.$handler, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x02ca A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:102:0x02cb  */
        /* JADX WARN: Code duplicated, block: B:108:0x02d8  */
        /* JADX WARN: Code duplicated, block: B:109:0x02da A[Catch: all -> 0x02d0, IOException -> 0x02d5, TryCatch #26 {IOException -> 0x02d5, all -> 0x02d0, blocks: (B:97:0x0298, B:99:0x02a0, B:109:0x02da, B:111:0x02de), top: B:207:0x0298 }] */
        /* JADX WARN: Code duplicated, block: B:115:0x02f3  */
        /* JADX WARN: Code duplicated, block: B:121:0x0328 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:122:0x0329  */
        /* JADX WARN: Code duplicated, block: B:142:0x0396  */
        /* JADX WARN: Code duplicated, block: B:145:0x039f  */
        /* JADX WARN: Code duplicated, block: B:146:0x03a0  */
        /* JADX WARN: Code duplicated, block: B:149:0x03cb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:150:0x03cc  */
        /* JADX WARN: Code duplicated, block: B:199:0x0302 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:209:0x02fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x0177 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:54:0x017d  */
        /* JADX WARN: Code duplicated, block: B:55:0x0182  */
        /* JADX WARN: Code duplicated, block: B:59:0x01c2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:63:0x01e3 A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:61:0x01ca, B:63:0x01e3, B:69:0x0205, B:71:0x0215, B:66:0x01fa, B:67:0x0201), top: B:188:0x01ca }] */
        /* JADX WARN: Code duplicated, block: B:66:0x01fa A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:61:0x01ca, B:63:0x01e3, B:69:0x0205, B:71:0x0215, B:66:0x01fa, B:67:0x0201), top: B:188:0x01ca }] */
        /* JADX WARN: Code duplicated, block: B:68:0x0202  */
        /* JADX WARN: Code duplicated, block: B:71:0x0215 A[Catch: all -> 0x03a6, TRY_LEAVE, TryCatch #2 {all -> 0x03a6, blocks: (B:61:0x01ca, B:63:0x01e3, B:69:0x0205, B:71:0x0215, B:66:0x01fa, B:67:0x0201), top: B:188:0x01ca }] */
        /* JADX WARN: Code duplicated, block: B:74:0x021f  */
        /* JADX WARN: Code duplicated, block: B:76:0x0222 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:84:0x0236 A[Catch: IOException -> 0x0232, all -> 0x02f0, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x0232, blocks: (B:143:0x0399, B:56:0x0183, B:78:0x0225, B:87:0x023d, B:90:0x0243, B:92:0x0267, B:84:0x0236, B:147:0x03a6, B:151:0x03cd), top: B:190:0x0399 }] */
        /* JADX WARN: Code duplicated, block: B:86:0x023c  */
        /* JADX WARN: Code duplicated, block: B:89:0x0242  */
        /* JADX WARN: Code duplicated, block: B:92:0x0267 A[Catch: IOException -> 0x0232, all -> 0x02f0, TRY_LEAVE, TryCatch #5 {IOException -> 0x0232, blocks: (B:143:0x0399, B:56:0x0183, B:78:0x0225, B:87:0x023d, B:90:0x0243, B:92:0x0267, B:84:0x0236, B:147:0x03a6, B:151:0x03cd), top: B:190:0x0399 }] */
        /* JADX WARN: Code duplicated, block: B:95:0x028c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:96:0x028d  */
        /* JADX WARN: Code duplicated, block: B:99:0x02a0 A[Catch: all -> 0x02d0, IOException -> 0x02d5, TryCatch #26 {IOException -> 0x02d5, all -> 0x02d0, blocks: (B:97:0x0298, B:99:0x02a0, B:109:0x02da, B:111:0x02de), top: B:207:0x0298 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b8: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x00b8 */
        /* JADX WARN: Not initialized variable reg: 2, insn: 0x02f1: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:114:0x02f1 */
        /* JADX WARN: Not initialized variable reg: 2, insn: 0x0384: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:136:0x0384 */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0385: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:136:0x0384 */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v11, types: [nq.s0] */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v28 */
        /* JADX WARN: Type inference failed for: r0v32 */
        /* JADX WARN: Type inference failed for: r0v34 */
        /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v41 */
        /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v46 */
        /* JADX WARN: Type inference failed for: r0v48, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v49, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v57 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v60 */
        /* JADX WARN: Type inference failed for: r0v62 */
        /* JADX WARN: Type inference failed for: r0v63 */
        /* JADX WARN: Type inference failed for: r0v64 */
        /* JADX WARN: Type inference failed for: r0v66 */
        /* JADX WARN: Type inference failed for: r0v68 */
        /* JADX WARN: Type inference failed for: r0v71 */
        /* JADX WARN: Type inference failed for: r0v73 */
        /* JADX WARN: Type inference failed for: r0v82 */
        /* JADX WARN: Type inference failed for: r0v83 */
        /* JADX WARN: Type inference failed for: r0v84 */
        /* JADX WARN: Type inference failed for: r0v85 */
        /* JADX WARN: Type inference failed for: r0v86 */
        /* JADX WARN: Type inference failed for: r12v13 */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r13v12, types: [kk.f] */
        /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v8 */
        /* JADX WARN: Type inference failed for: r17v1 */
        /* JADX WARN: Type inference failed for: r17v10 */
        /* JADX WARN: Type inference failed for: r17v11 */
        /* JADX WARN: Type inference failed for: r17v12 */
        /* JADX WARN: Type inference failed for: r17v2 */
        /* JADX WARN: Type inference failed for: r17v3 */
        /* JADX WARN: Type inference failed for: r17v5 */
        /* JADX WARN: Type inference failed for: r17v6 */
        /* JADX WARN: Type inference failed for: r17v7 */
        /* JADX WARN: Type inference failed for: r17v8 */
        /* JADX WARN: Type inference failed for: r17v9 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10, types: [pq.g0] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v48 */
        /* JADX WARN: Type inference failed for: r1v49 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v54, types: [java.lang.Object, nq.s0] */
        /* JADX WARN: Type inference failed for: r1v57 */
        /* JADX WARN: Type inference failed for: r1v58, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v60 */
        /* JADX WARN: Type inference failed for: r1v61, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v65 */
        /* JADX WARN: Type inference failed for: r1v67 */
        /* JADX WARN: Type inference failed for: r1v68 */
        /* JADX WARN: Type inference failed for: r1v69 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v74 */
        /* JADX WARN: Type inference failed for: r1v78 */
        /* JADX WARN: Type inference failed for: r1v79 */
        /* JADX WARN: Type inference failed for: r1v8, types: [pq.g0] */
        /* JADX WARN: Type inference failed for: r1v81 */
        /* JADX WARN: Type inference failed for: r1v82 */
        /* JADX WARN: Type inference failed for: r1v83 */
        /* JADX WARN: Type inference failed for: r1v84 */
        /* JADX WARN: Type inference failed for: r1v85 */
        /* JADX WARN: Type inference failed for: r1v86 */
        /* JADX WARN: Type inference failed for: r1v87 */
        /* JADX WARN: Type inference failed for: r1v88 */
        /* JADX WARN: Type inference failed for: r1v89 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r1v90 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v43 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v63 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v33 */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v42 */
        /* JADX WARN: Type inference failed for: r3v53 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x0329 -> B:205:0x032f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r35) {
            /*
                Method dump skipped, instruction units count: 1116
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xk.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    static {
        kk.o oVar = new kk.o();
        r0.f8158c.getClass();
        oVar.j("HTTP/1.0", r0.f8182x.f8185a, "Bad Request");
        oVar.f("Connection", "close");
        oVar.e();
        f20285a = oVar.f9241a.z2();
    }

    public static final boolean c(boolean z10, @m kk.d dVar) {
        if (dVar == null) {
            if (!z10) {
                return true;
            }
        } else if (!dVar.f9210b && dVar.f9209a) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0075 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x0080  */
    /* JADX WARN: Code duplicated, block: B:32:0x0096 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0097  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0097 -> B:44:0x009d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(pq.f0<? extends pl.k> r9, lk.j r10, xk.a r11, um.d<? super lm.l2> r12) {
        /*
            boolean r0 = r12 instanceof xk.b.a
            if (r0 == 0) goto L13
            r0 = r12
            xk.b$a r0 = (xk.b.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            xk.b$a r0 = new xk.b$a
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5d
            if (r2 == r5) goto L4d
            if (r2 != r4) goto L45
            java.lang.Object r9 = r0.L$3
            pl.k r9 = (pl.k) r9
            java.lang.Object r10 = r0.L$2
            jn.p r10 = (jn.p) r10
            java.lang.Object r11 = r0.L$1
            xk.a r11 = (xk.a) r11
            java.lang.Object r2 = r0.L$0
            lk.j r2 = (lk.j) r2
            lm.d1.n(r12)     // Catch: java.lang.Throwable -> L3e
            r12 = r10
            r10 = r2
            goto L9d
        L3e:
            r12 = move-exception
            r7 = r0
            r0 = r10
            r10 = r2
        L42:
            r2 = r7
            goto Lb1
        L45:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L4d:
            java.lang.Object r9 = r0.L$2
            jn.p r9 = (jn.p) r9
            java.lang.Object r10 = r0.L$1
            xk.a r10 = (xk.a) r10
            java.lang.Object r11 = r0.L$0
            lk.j r11 = (lk.j) r11
            lm.d1.n(r12)
            goto L7c
        L5d:
            lm.d1.n(r12)
            xk.b$b r12 = new xk.b$b
            r12.<init>(r9, r3)
        L65:
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r3
            r0.label = r5
            java.lang.Object r9 = r10.h(r12, r0)
            if (r9 != r1) goto L76
            return r1
        L76:
            r7 = r12
            r12 = r9
            r9 = r7
            r8 = r11
            r11 = r10
            r10 = r8
        L7c:
            pl.k r12 = (pl.k) r12
            if (r12 != 0) goto L83
            lm.l2 r9 = lm.l2.f10208a
            return r9
        L83:
            pl.n r2 = r10.f20282b     // Catch: java.lang.Throwable -> La8
            r0.L$0 = r11     // Catch: java.lang.Throwable -> La8
            r0.L$1 = r10     // Catch: java.lang.Throwable -> La8
            r0.L$2 = r9     // Catch: java.lang.Throwable -> La8
            r0.L$3 = r12     // Catch: java.lang.Throwable -> La8
            r0.label = r4     // Catch: java.lang.Throwable -> La8
            r6 = 0
            java.lang.Object r2 = pl.l.e(r12, r2, r6, r0)     // Catch: java.lang.Throwable -> La8
            if (r2 != r1) goto L97
            return r1
        L97:
            r7 = r12
            r12 = r9
            r9 = r7
            r8 = r11
            r11 = r10
            r10 = r8
        L9d:
            pl.n r2 = r11.f20282b     // Catch: java.lang.Throwable -> La3
            r2.flush()     // Catch: java.lang.Throwable -> La3
            goto L65
        La3:
            r2 = move-exception
            r7 = r0
            r0 = r12
            r12 = r2
            goto L42
        La8:
            r2 = move-exception
            r7 = r0
            r0 = r9
            r9 = r12
            r12 = r2
            r2 = r7
            r8 = r11
            r11 = r10
            r10 = r8
        Lb1:
            boolean r6 = r9 instanceof pl.n
            if (r6 == 0) goto Lba
            pl.n r9 = (pl.n) r9
            r9.f(r12)
        Lba:
            r12 = r0
            r0 = r2
            goto L65
        */
        throw new UnsupportedOperationException("Method not decompiled: xk.b.d(pq.f0, lk.j, xk.a, um.d):java.lang.Object");
    }

    @t0
    @l
    public static final nq.l2 e(@l s0 s0Var, @l xk.a aVar, @l j jVar, @l q<? super xk.c, ? super n, ? super um.d<? super l2>, ? extends Object> qVar) {
        l0.p(s0Var, "<this>");
        l0.p(aVar, "connection");
        l0.p(jVar, RtspHeaders.Values.TIMEOUT);
        l0.p(qVar, "handler");
        return nq.k.f(s0Var, kk.m.a(), null, new c(aVar, jVar, qVar, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <S, R> p<S, um.d<? super R>, Object> f(p<? super S, ? super um.d<? super R>, ? extends Object> pVar) {
        return pVar;
    }
}
