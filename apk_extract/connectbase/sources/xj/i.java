package xj;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import jn.p;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.k;
import nq.r2;
import nq.s0;
import nq.t0;
import os.l;
import os.m;
import pq.g0;
import sq.i0;
import vj.a3;
import vj.k2;
import vj.m2;
import vj.q2;
import vj.v1;
import vj.w1;
import vj.y2;
import vj.z2;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final i f20264a = new i();

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    public static final class a<RequestT, ResponseT> extends n0 implements jn.l<sq.i<? extends RequestT>, sq.i<? extends ResponseT>> {
        final /* synthetic */ p<sq.i<? extends RequestT>, um.d<? super ResponseT>, Object> $implementation;

        /* JADX INFO: renamed from: xj.i$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.grpc.kotlin.ServerCalls$clientStreamingServerMethodDefinition$2$1", f = "ServerCalls.kt", i = {0}, l = {109, 110}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
        public static final class C0511a extends o implements p<sq.j<? super ResponseT>, um.d<? super l2>, Object> {
            final /* synthetic */ p<sq.i<? extends RequestT>, um.d<? super ResponseT>, Object> $implementation;
            final /* synthetic */ sq.i<RequestT> $requests;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0511a(p<? super sq.i<? extends RequestT>, ? super um.d<? super ResponseT>, ? extends Object> pVar, sq.i<? extends RequestT> iVar, um.d<? super C0511a> dVar) {
                super(2, dVar);
                this.$implementation = pVar;
                this.$requests = iVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                C0511a c0511a = new C0511a(this.$implementation, this.$requests, dVar);
                c0511a.L$0 = obj;
                return c0511a;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to xj.i$a$a for r5v4 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r6) {
                /*
                    r5 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r5.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L20
                    if (r1 == r3) goto L18
                    if (r1 != r2) goto L10
                    lm.d1.n(r6)
                    goto L43
                L10:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L18:
                    java.lang.Object r1 = r5.L$0
                    sq.j r1 = (sq.j) r1
                    lm.d1.n(r6)
                    goto L37
                L20:
                    lm.d1.n(r6)
                    java.lang.Object r6 = r5.L$0
                    r1 = r6
                    sq.j r1 = (sq.j) r1
                    jn.p<sq.i<? extends RequestT>, um.d<? super ResponseT>, java.lang.Object> r6 = r5.$implementation
                    sq.i<RequestT> r4 = r5.$requests
                    r5.L$0 = r1
                    r5.label = r3
                    java.lang.Object r6 = r6.invoke(r4, r5)
                    if (r6 != r0) goto L37
                    return r0
                L37:
                    r3 = 0
                    r5.L$0 = r3
                    r5.label = r2
                    java.lang.Object r5 = r1.emit(r6, r5)
                    if (r5 != r0) goto L43
                    return r0
                L43:
                    lm.l2 r5 = lm.l2.f10208a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: xj.i.a.C0511a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.p
            @m
            public final Object invoke(@l sq.j<? super ResponseT> jVar, @m um.d<? super l2> dVar) {
                return ((C0511a) create(jVar, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(p<? super sq.i<? extends RequestT>, ? super um.d<? super ResponseT>, ? extends Object> pVar) {
            super(1);
            this.$implementation = pVar;
        }

        @Override // jn.l
        @l
        public final sq.i<ResponseT> invoke(@l sq.i<? extends RequestT> iVar) {
            l0.p(iVar, "requests");
            return new i0(new C0511a(this.$implementation, iVar, null));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT] */
    @r1({"SMAP\nServerCalls.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$serverCallListener$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,308:1\n530#2,5:309\n*S KotlinDebug\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$serverCallListener$1\n*L\n282#1:309,5\n*E\n"})
    public static final class b<RequestT> extends k2.a<RequestT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20265a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ nq.l2 f20266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pq.l<RequestT> f20267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k2<RequestT, ResponseT> f20268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ xj.g f20269e;

        public b(nq.l2 l2Var, pq.l<RequestT> lVar, k2<RequestT, ResponseT> k2Var, xj.g gVar) {
            this.f20266b = l2Var;
            this.f20267c = lVar;
            this.f20268d = k2Var;
            this.f20269e = gVar;
        }

        @Override // vj.k2.a
        public void a() {
            r2.i(this.f20266b, "Cancellation received from client", null, 2, null);
        }

        @Override // vj.k2.a
        public void c() {
            g0.a.a(this.f20267c, null, 1, null);
        }

        @Override // vj.k2.a
        public void d(RequestT requestt) throws z2 {
            if (this.f20265a) {
                Object objW = this.f20267c.w(requestt);
                this.f20265a = pq.p.m(objW);
                if (objW instanceof pq.p.c) {
                    Throwable thF = pq.p.f(objW);
                    if (!(thF instanceof CancellationException)) {
                        y2 y2VarT = y2.f17562s.u("onMessage should never be called when requestsChannel is unready").t(thF);
                        y2VarT.getClass();
                        z2 z2Var = new z2(y2VarT);
                        l0.o(z2Var, "INTERNAL\n               …           .asException()");
                        throw z2Var;
                    }
                }
            }
            if (this.f20265a) {
                return;
            }
            this.f20268d.h(1);
        }

        @Override // vj.k2.a
        public void e() {
            this.f20269e.a();
        }

        public final boolean f() {
            return this.f20265a;
        }

        public final void g(boolean z10) {
            this.f20265a = z10;
        }
    }

    public static final class c extends n0 implements jn.a<Boolean> {
        final /* synthetic */ k2<RequestT, ResponseT> $call;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k2<RequestT, ResponseT> k2Var) {
            super(0);
            this.$call = k2Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final Boolean invoke() {
            return Boolean.valueOf(this.$call.g());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT] */
    @xm.f(c = "io.grpc.kotlin.ServerCalls$serverCallListener$requests$1", f = "ServerCalls.kt", i = {0, 1}, l = {226, 227}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    public static final class d<RequestT> extends o implements p<sq.j<? super RequestT>, um.d<? super l2>, Object> {
        final /* synthetic */ k2<RequestT, ResponseT> $call;
        final /* synthetic */ pq.l<RequestT> $requestsChannel;
        final /* synthetic */ AtomicBoolean $requestsStarted;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AtomicBoolean atomicBoolean, k2<RequestT, ResponseT> k2Var, pq.l<RequestT> lVar, um.d<? super d> dVar) {
            super(2, dVar);
            this.$requestsStarted = atomicBoolean;
            this.$call = k2Var;
            this.$requestsChannel = lVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            d dVar2 = new d(this.$requestsStarted, this.$call, this.$requestsChannel, dVar);
            dVar2.L$0 = obj;
            return dVar2;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0056 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0057  */
        /* JADX WARN: Code duplicated, block: B:26:0x0062 A[Catch: Exception -> 0x0019, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0014, B:29:0x0073, B:20:0x004a, B:24:0x005a, B:26:0x0062, B:14:0x002b, B:19:0x0044), top: B:37:0x0006 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x0072 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x0079  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0070 -> B:8:0x0017). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
            /*
                r6 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r6.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r6.L$0
                sq.j r4 = (sq.j) r4
                lm.d1.n(r7)     // Catch: java.lang.Exception -> L19
            L17:
                r7 = r4
                goto L73
            L19:
                r7 = move-exception
                goto L7c
            L1b:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L23:
                java.lang.Object r1 = r6.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r6.L$0
                sq.j r4 = (sq.j) r4
                lm.d1.n(r7)     // Catch: java.lang.Exception -> L19
                goto L5a
            L2f:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                sq.j r7 = (sq.j) r7
                java.util.concurrent.atomic.AtomicBoolean r1 = r6.$requestsStarted
                r4 = 0
                boolean r1 = r1.compareAndSet(r4, r3)
                if (r1 == 0) goto L8d
                vj.k2<RequestT, ResponseT> r1 = r6.$call
                r1.h(r3)
                pq.l<RequestT> r1 = r6.$requestsChannel     // Catch: java.lang.Exception -> L19
                pq.n r1 = r1.iterator()     // Catch: java.lang.Exception -> L19
            L4a:
                r6.L$0 = r7     // Catch: java.lang.Exception -> L19
                r6.L$1 = r1     // Catch: java.lang.Exception -> L19
                r6.label = r3     // Catch: java.lang.Exception -> L19
                java.lang.Object r4 = r1.b(r6)     // Catch: java.lang.Exception -> L19
                if (r4 != r0) goto L57
                return r0
            L57:
                r5 = r4
                r4 = r7
                r7 = r5
            L5a:
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> L19
                boolean r7 = r7.booleanValue()     // Catch: java.lang.Exception -> L19
                if (r7 == 0) goto L79
                java.lang.Object r7 = r1.next()     // Catch: java.lang.Exception -> L19
                r6.L$0 = r4     // Catch: java.lang.Exception -> L19
                r6.L$1 = r1     // Catch: java.lang.Exception -> L19
                r6.label = r2     // Catch: java.lang.Exception -> L19
                java.lang.Object r7 = r4.emit(r7, r6)     // Catch: java.lang.Exception -> L19
                if (r7 != r0) goto L17
                return r0
            L73:
                vj.k2<RequestT, ResponseT> r4 = r6.$call     // Catch: java.lang.Exception -> L19
                r4.h(r3)     // Catch: java.lang.Exception -> L19
                goto L4a
            L79:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            L7c:
                pq.l<RequestT> r0 = r6.$requestsChannel
                java.lang.String r1 = "Exception thrown while collecting requests"
                java.util.concurrent.CancellationException r1 = nq.w1.a(r1, r7)
                r0.b(r1)
                vj.k2<RequestT, ResponseT> r6 = r6.$call
                r6.h(r3)
                throw r7
            L8d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "requests flow can only be collected once"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: xj.i.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l sq.j<? super RequestT> jVar, @m um.d<? super l2> dVar) {
            return ((d) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nServerCalls.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$serverCallListener$rpcJob$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n120#2,10:309\n120#2,10:320\n1#3:319\n*S KotlinDebug\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$serverCallListener$rpcJob$1\n*L\n257#1:309,10\n268#1:320,10\n*E\n"})
    @xm.f(c = "io.grpc.kotlin.ServerCalls$serverCallListener$rpcJob$1", f = "ServerCalls.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {243, 314, 325}, m = "invokeSuspend", n = {"mutex", "headersSent", "mutex", "failure", "$this$withLock_u24default$iv", "closeStatus", "trailers", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class e extends o implements p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ k2<RequestT, ResponseT> $call;
        final /* synthetic */ jn.l<sq.i<? extends RequestT>, sq.i<ResponseT>> $implementation;
        final /* synthetic */ xj.g $readiness;
        final /* synthetic */ sq.i<RequestT> $requests;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        @r1({"SMAP\nServerCalls.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$serverCallListener$rpcJob$1$failure$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,308:1\n120#2,10:309\n120#2,10:319\n*S KotlinDebug\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$serverCallListener$rpcJob$1$failure$1$1\n*L\n246#1:309,10\n251#1:319,10\n*E\n"})
        public static final class a<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f20270a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ar.a f20271b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ xj.g f20272c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ k2<RequestT, ResponseT> f20273d;

            /* JADX INFO: renamed from: xj.i$e$a$a, reason: collision with other inner class name */
            @xm.f(c = "io.grpc.kotlin.ServerCalls$serverCallListener$rpcJob$1$failure$1$1", f = "ServerCalls.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {314, 250, 324}, m = "emit", n = {"this", "it", "$this$withLock_u24default$iv", "this", "it", "it", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
            public static final class C0512a extends xm.d {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0512a(a<? super T> aVar, um.d<? super C0512a> dVar) {
                    super(dVar);
                    this.this$0 = aVar;
                }

                @Override // xm.a
                @m
                public final Object invokeSuspend(@l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            public a(AtomicBoolean atomicBoolean, ar.a aVar, xj.g gVar, k2<RequestT, ResponseT> k2Var) {
                this.f20270a = atomicBoolean;
                this.f20271b = aVar;
                this.f20272c = gVar;
                this.f20273d = k2Var;
            }

            /* JADX WARN: Code duplicated, block: B:31:0x00a9 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
            /* JADX WARN: Code duplicated, block: B:35:0x00bf A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @m
            public final Object emit(ResponseT responset, @l um.d<? super l2> dVar) {
                C0512a c0512a;
                a<T> aVar;
                k2 k2Var;
                Object obj;
                ar.a aVar2;
                Object obj2;
                xj.g gVar;
                a<T> aVar3;
                Object obj3;
                ar.a aVar4;
                k2 k2Var2;
                Object obj4;
                k2 k2Var3;
                ar.a aVar5;
                if (dVar instanceof C0512a) {
                    c0512a = (C0512a) dVar;
                    int i10 = c0512a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0512a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0512a = new C0512a(this, dVar);
                    }
                } else {
                    c0512a = new C0512a(this, dVar);
                }
                Object obj5 = c0512a.result;
                wm.a aVar6 = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0512a.label;
                try {
                    if (i11 != 0) {
                        if (i11 == 1) {
                            k2Var = (k2) c0512a.L$3;
                            aVar2 = (ar.a) c0512a.L$2;
                            Object obj6 = c0512a.L$1;
                            aVar = (a) c0512a.L$0;
                            d1.n(obj5);
                            obj = obj6;
                        } else if (i11 == 2) {
                            Object obj7 = c0512a.L$1;
                            aVar3 = (a) c0512a.L$0;
                            d1.n(obj5);
                            obj3 = obj7;
                            aVar4 = aVar3.f20271b;
                            k2Var2 = aVar3.f20273d;
                            c0512a.L$0 = obj3;
                            c0512a.L$1 = aVar4;
                            c0512a.L$2 = k2Var2;
                            c0512a.label = 3;
                            if (aVar4.h(null, c0512a) == aVar6) {
                                return aVar6;
                            }
                            obj4 = obj3;
                            k2Var3 = k2Var2;
                            aVar5 = aVar4;
                        } else {
                            if (i11 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            k2Var3 = (k2) c0512a.L$2;
                            aVar5 = (ar.a) c0512a.L$1;
                            Object obj8 = c0512a.L$0;
                            d1.n(obj5);
                            obj4 = obj8;
                        }
                        try {
                            k2Var3.j(obj4);
                            return l2.f10208a;
                        } finally {
                            aVar5.f(null);
                        }
                    }
                    d1.n(obj5);
                    if (this.f20270a.compareAndSet(false, true)) {
                        ar.a aVar7 = this.f20271b;
                        k2 k2Var4 = this.f20273d;
                        c0512a.L$0 = this;
                        c0512a.L$1 = responset;
                        c0512a.L$2 = aVar7;
                        c0512a.L$3 = k2Var4;
                        c0512a.label = 1;
                        if (aVar7.h(null, c0512a) == aVar6) {
                            obj2 = responset;
                            return aVar6;
                        }
                        obj2 = responset;
                        aVar = this;
                        k2Var = k2Var4;
                        obj = responset;
                        aVar2 = aVar7;
                    }
                    obj2 = responset;
                    gVar = this.f20272c;
                    c0512a.L$0 = this;
                    c0512a.L$1 = obj2;
                    c0512a.L$2 = null;
                    c0512a.L$3 = null;
                    c0512a.label = 2;
                    if (gVar.b(c0512a) == aVar6) {
                        return aVar6;
                    }
                    Object obj9 = obj2;
                    aVar3 = this;
                    obj3 = obj9;
                    aVar4 = aVar3.f20271b;
                    k2Var2 = aVar3.f20273d;
                    c0512a.L$0 = obj3;
                    c0512a.L$1 = aVar4;
                    c0512a.L$2 = k2Var2;
                    c0512a.label = 3;
                    if (aVar4.h(null, c0512a) == aVar6) {
                        return aVar6;
                    }
                    obj4 = obj3;
                    k2Var3 = k2Var2;
                    aVar5 = aVar4;
                    k2Var3.j(obj4);
                    return l2.f10208a;
                    k2Var.i(new v1());
                    l2 l2Var = l2.f10208a;
                    aVar2.f(null);
                    obj2 = obj;
                    this = aVar;
                    obj2 = responset;
                    gVar = this.f20272c;
                    c0512a.L$0 = this;
                    c0512a.L$1 = obj2;
                    c0512a.L$2 = null;
                    c0512a.L$3 = null;
                    c0512a.label = 2;
                    if (gVar.b(c0512a) == aVar6) {
                        return aVar6;
                    }
                    Object obj10 = obj2;
                    aVar3 = this;
                    obj3 = obj10;
                    aVar4 = aVar3.f20271b;
                    k2Var2 = aVar3.f20273d;
                    c0512a.L$0 = obj3;
                    c0512a.L$1 = aVar4;
                    c0512a.L$2 = k2Var2;
                    c0512a.label = 3;
                    if (aVar4.h(null, c0512a) == aVar6) {
                        return aVar6;
                    }
                    obj4 = obj3;
                    k2Var3 = k2Var2;
                    aVar5 = aVar4;
                    k2Var3.j(obj4);
                    return l2.f10208a;
                } catch (Throwable th2) {
                    aVar2.f(null);
                    throw th2;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(jn.l<? super sq.i<? extends RequestT>, ? extends sq.i<? extends ResponseT>> lVar, sq.i<? extends RequestT> iVar, xj.g gVar, k2<RequestT, ResponseT> k2Var, um.d<? super e> dVar) {
            super(2, dVar);
            this.$implementation = lVar;
            this.$requests = iVar;
            this.$readiness = gVar;
            this.$call = k2Var;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            e eVar = new e(this.$implementation, this.$requests, this.$readiness, this.$call, dVar);
            eVar.L$0 = obj;
            return eVar;
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:39:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:41:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:42:0x00da  */
        /* JADX WARN: Code duplicated, block: B:45:0x00df  */
        /* JADX WARN: Code duplicated, block: B:47:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:48:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:52:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:55:0x010f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x0110  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.concurrent.atomic.AtomicBoolean] */
        /* JADX WARN: Type inference failed for: r1v9 */
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
        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            Object objM59constructorimpl;
            ?? r10;
            Throwable thM62exceptionOrNullimpl;
            k2 k2Var;
            Throwable th2;
            ar.a aVar;
            ar.a aVarB;
            ar.a aVar2;
            y2 y2VarT;
            v1 v1Var;
            k2 k2Var2;
            v1 v1Var2;
            y2 y2Var;
            k2 k2Var3;
            wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
            ?? r11 = this.label;
            try {
                if (r11 != 0) {
                    if (r11 == 1) {
                        AtomicBoolean atomicBoolean = (AtomicBoolean) this.L$1;
                        aVarB = (ar.a) this.L$0;
                        d1.n(obj);
                        r11 = atomicBoolean;
                    } else if (r11 == 2) {
                        k2Var = (k2) this.L$3;
                        aVar = (ar.a) this.L$2;
                        th2 = (Throwable) this.L$1;
                        aVarB = (ar.a) this.L$0;
                        d1.n(obj);
                        try {
                            k2Var.i(new v1());
                            l2 l2Var = l2.f10208a;
                            aVar.f(null);
                            thM62exceptionOrNullimpl = th2;
                            aVar2 = aVarB;
                            if (thM62exceptionOrNullimpl == null) {
                                y2VarT = y2.f17548e;
                            } else if (thM62exceptionOrNullimpl instanceof CancellationException) {
                                y2VarT = y2.f17549f.t(thM62exceptionOrNullimpl);
                            } else {
                                if (thM62exceptionOrNullimpl instanceof z2 ? true : thM62exceptionOrNullimpl instanceof a3) {
                                    y2VarT = y2.n(thM62exceptionOrNullimpl);
                                } else {
                                    y2VarT = y2.n(thM62exceptionOrNullimpl).t(thM62exceptionOrNullimpl);
                                }
                            }
                            if (thM62exceptionOrNullimpl != null || (v1Var = y2.s(thM62exceptionOrNullimpl)) == null) {
                                v1Var = new v1();
                            }
                            k2Var2 = this.$call;
                            this.L$0 = y2VarT;
                            this.L$1 = v1Var;
                            this.L$2 = aVar2;
                            this.L$3 = k2Var2;
                            this.label = 3;
                            if (aVar2.h(null, this) == aVar3) {
                                return aVar3;
                            }
                            v1Var2 = v1Var;
                            y2Var = y2VarT;
                            k2Var3 = k2Var2;
                        } catch (Throwable th3) {
                            aVar.f(null);
                            throw th3;
                        }
                    } else {
                        if (r11 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k2Var3 = (k2) this.L$3;
                        aVar2 = (ar.a) this.L$2;
                        v1Var2 = (v1) this.L$1;
                        y2Var = (y2) this.L$0;
                        d1.n(obj);
                    }
                    try {
                        k2Var3.a(y2Var, v1Var2);
                        return l2.f10208a;
                    } finally {
                        aVar2.f(null);
                    }
                }
                d1.n(obj);
                aVarB = ar.c.b(false, 1, null);
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                jn.l lVar = this.$implementation;
                Object obj2 = this.$requests;
                xj.g gVar = this.$readiness;
                k2 k2Var4 = this.$call;
                c1.a aVar4 = c1.Companion;
                sq.i iVar = (sq.i) lVar.invoke(obj2);
                a aVar5 = new a(atomicBoolean2, aVarB, gVar, k2Var4);
                this.L$0 = aVarB;
                this.L$1 = atomicBoolean2;
                this.label = 1;
                r11 = atomicBoolean2;
                if (iVar.a(aVar5, this) == aVar3) {
                    return aVar3;
                }
                objM59constructorimpl = c1.m59constructorimpl(l2.f10208a);
                r10 = r11;
            } catch (Throwable th4) {
                c1.a aVar6 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th4));
                r10 = r11;
            }
            thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(objM59constructorimpl);
            if (thM62exceptionOrNullimpl == null && r10.compareAndSet(false, true)) {
                k2Var = this.$call;
                this.L$0 = aVarB;
                this.L$1 = thM62exceptionOrNullimpl;
                this.L$2 = aVarB;
                this.L$3 = k2Var;
                this.label = 2;
                if (aVarB.h(null, this) == aVar3) {
                    return aVar3;
                }
                th2 = thM62exceptionOrNullimpl;
                aVar = aVarB;
                k2Var.i(new v1());
                l2 l2Var2 = l2.f10208a;
                aVar.f(null);
                thM62exceptionOrNullimpl = th2;
            }
            aVar2 = aVarB;
            if (thM62exceptionOrNullimpl == null) {
                y2VarT = y2.f17548e;
            } else if (thM62exceptionOrNullimpl instanceof CancellationException) {
                y2VarT = y2.f17549f.t(thM62exceptionOrNullimpl);
            } else {
                if (thM62exceptionOrNullimpl instanceof z2 ? true : thM62exceptionOrNullimpl instanceof a3) {
                    y2VarT = y2.n(thM62exceptionOrNullimpl);
                } else {
                    y2VarT = y2.n(thM62exceptionOrNullimpl).t(thM62exceptionOrNullimpl);
                }
            }
            if (thM62exceptionOrNullimpl != null) {
                v1Var = new v1();
            } else {
                v1Var = new v1();
            }
            k2Var2 = this.$call;
            this.L$0 = y2VarT;
            this.L$1 = v1Var;
            this.L$2 = aVar2;
            this.L$3 = k2Var2;
            this.label = 3;
            if (aVar2.h(null, this) == aVar3) {
                return aVar3;
            }
            v1Var2 = v1Var;
            y2Var = y2VarT;
            k2Var3 = k2Var2;
            k2Var3.a(y2Var, v1Var2);
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((e) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    public static final class f<RequestT, ResponseT> extends n0 implements jn.l<sq.i<? extends RequestT>, sq.i<? extends ResponseT>> {
        final /* synthetic */ w1<RequestT, ResponseT> $descriptor;
        final /* synthetic */ jn.l<RequestT, sq.i<ResponseT>> $implementation;

        @xm.f(c = "io.grpc.kotlin.ServerCalls$serverStreamingServerMethodDefinition$2$1", f = "ServerCalls.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends o implements p<sq.j<? super ResponseT>, um.d<? super l2>, Object> {
            final /* synthetic */ w1<RequestT, ResponseT> $descriptor;
            final /* synthetic */ jn.l<RequestT, sq.i<ResponseT>> $implementation;
            final /* synthetic */ sq.i<RequestT> $requests;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: xj.i$f$a$a, reason: collision with other inner class name */
            public static final class C0513a<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ jn.l<RequestT, sq.i<ResponseT>> f20274a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ sq.j<ResponseT> f20275b;

                /* JADX INFO: renamed from: xj.i$f$a$a$a, reason: collision with other inner class name */
                public static final class C0514a<T> implements sq.j {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ sq.j<ResponseT> f20276a;

                    /* JADX WARN: Multi-variable type inference failed */
                    public C0514a(sq.j<? super ResponseT> jVar) {
                        this.f20276a = jVar;
                    }

                    @Override // sq.j
                    @m
                    public final Object emit(ResponseT responset, @l um.d<? super l2> dVar) {
                        Object objEmit = this.f20276a.emit(responset, dVar);
                        return objEmit == wm.a.COROUTINE_SUSPENDED ? objEmit : l2.f10208a;
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                public C0513a(jn.l<? super RequestT, ? extends sq.i<? extends ResponseT>> lVar, sq.j<? super ResponseT> jVar) {
                    this.f20274a = lVar;
                    this.f20275b = jVar;
                }

                @Override // sq.j
                @m
                public final Object emit(RequestT requestt, @l um.d<? super l2> dVar) {
                    Object objA = this.f20274a.invoke(requestt).a(new C0514a(this.f20275b), dVar);
                    return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(sq.i<? extends RequestT> iVar, w1<RequestT, ResponseT> w1Var, jn.l<? super RequestT, ? extends sq.i<? extends ResponseT>> lVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$requests = iVar;
                this.$descriptor = w1Var;
                this.$implementation = lVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                a aVar = new a(this.$requests, this.$descriptor, this.$implementation, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j jVar = (sq.j) this.L$0;
                    sq.i iVarE = xj.f.e(this.$requests, "request", this.$descriptor);
                    C0513a c0513a = new C0513a(this.$implementation, jVar);
                    this.label = 1;
                    if (iVarE.a(c0513a, this) == aVar) {
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

            @Override // jn.p
            @m
            public final Object invoke(@l sq.j<? super ResponseT> jVar, @m um.d<? super l2> dVar) {
                return ((a) create(jVar, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(w1<RequestT, ResponseT> w1Var, jn.l<? super RequestT, ? extends sq.i<? extends ResponseT>> lVar) {
            super(1);
            this.$descriptor = w1Var;
            this.$implementation = lVar;
        }

        @Override // jn.l
        @l
        public final sq.i<ResponseT> invoke(@l sq.i<? extends RequestT> iVar) {
            l0.p(iVar, "requests");
            return new i0(new a(iVar, this.$descriptor, this.$implementation, null));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    @r1({"SMAP\nServerCalls.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$unaryServerMethodDefinition$2\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,308:1\n53#2:309\n55#2:313\n50#3:310\n55#3:312\n107#4:311\n*S KotlinDebug\n*F\n+ 1 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$unaryServerMethodDefinition$2\n*L\n79#1:309\n79#1:313\n79#1:310\n79#1:312\n79#1:311\n*E\n"})
    public static final class g<RequestT, ResponseT> extends n0 implements jn.l<sq.i<? extends RequestT>, sq.i<? extends ResponseT>> {
        final /* synthetic */ w1<RequestT, ResponseT> $descriptor;
        final /* synthetic */ p<RequestT, um.d<? super ResponseT>, Object> $implementation;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
        public static final class a implements sq.i<ResponseT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.i f20277a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f20278b;

            /* JADX INFO: renamed from: xj.i$g$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ServerCalls.kt\nio/grpc/kotlin/ServerCalls$unaryServerMethodDefinition$2\n*L\n1#1,222:1\n54#2:223\n79#3:224\n*E\n"})
            public static final class C0515a<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ sq.j f20279a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ p f20280b;

                /* JADX INFO: renamed from: xj.i$g$a$a$a, reason: collision with other inner class name */
                @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                @xm.f(c = "io.grpc.kotlin.ServerCalls$unaryServerMethodDefinition$2$invoke$$inlined$map$1$2", f = "ServerCalls.kt", i = {}, l = {224, 223}, m = "emit", n = {}, s = {})
                public static final class C0516a extends xm.d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public C0516a(um.d dVar) {
                        super(dVar);
                    }

                    @Override // xm.a
                    @m
                    public final Object invokeSuspend(@l Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C0515a.this.emit(null, this);
                    }
                }

                public C0515a(sq.j jVar, p pVar) {
                    this.f20279a = jVar;
                    this.f20280b = pVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // sq.j
                @m
                public final Object emit(Object obj, @l um.d dVar) {
                    C0516a c0516a;
                    sq.j jVar;
                    if (dVar instanceof C0516a) {
                        c0516a = (C0516a) dVar;
                        int i10 = c0516a.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0516a.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0516a = new C0516a(dVar);
                        }
                    } else {
                        c0516a = new C0516a(dVar);
                    }
                    Object obj2 = c0516a.result;
                    Object obj3 = wm.a.COROUTINE_SUSPENDED;
                    int i11 = c0516a.label;
                    if (i11 != 0) {
                        if (i11 == 1) {
                            sq.j jVar2 = (sq.j) c0516a.L$0;
                            d1.n(obj2);
                            jVar = jVar2;
                        } else {
                            if (i11 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d1.n(obj2);
                        }
                        return l2.f10208a;
                    }
                    d1.n(obj2);
                    sq.j jVar3 = this.f20279a;
                    p pVar = this.f20280b;
                    c0516a.L$0 = jVar3;
                    c0516a.label = 1;
                    Object objInvoke = pVar.invoke(obj, c0516a);
                    if (objInvoke == obj3) {
                        return obj3;
                    }
                    obj2 = objInvoke;
                    jVar = jVar3;
                    c0516a.L$0 = null;
                    c0516a.label = 2;
                    if (jVar.emit(obj2, c0516a) == obj3) {
                        return obj3;
                    }
                    return l2.f10208a;
                }
            }

            public a(sq.i iVar, p pVar) {
                this.f20277a = iVar;
                this.f20278b = pVar;
            }

            @Override // sq.i
            @m
            public Object a(@l sq.j jVar, @l um.d dVar) {
                Object objA = this.f20277a.a(new C0515a(jVar, this.f20278b), dVar);
                return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(w1<RequestT, ResponseT> w1Var, p<? super RequestT, ? super um.d<? super ResponseT>, ? extends Object> pVar) {
            super(1);
            this.$descriptor = w1Var;
            this.$implementation = pVar;
        }

        @Override // jn.l
        @l
        public final sq.i<ResponseT> invoke(@l sq.i<? extends RequestT> iVar) {
            l0.p(iVar, "requests");
            return new a(xj.f.e(iVar, "request", this.$descriptor), this.$implementation);
        }
    }

    public static final k2.a e(um.g gVar, jn.l lVar, k2 k2Var, v1 v1Var) {
        l0.p(gVar, "$context");
        l0.p(lVar, "$implementation");
        i iVar = f20264a;
        xj.d.f20252a.getClass();
        Object objA = xj.d.f20253b.a();
        l0.o(objA, "CoroutineContextServerIn…ROUTINE_CONTEXT_KEY.get()");
        um.g gVarPlus = gVar.plus((um.g) objA).plus(xj.e.f20254b.a());
        l0.o(k2Var, NotificationCompat.CATEGORY_CALL);
        return iVar.f(gVarPlus, k2Var, lVar);
    }

    @l
    public final <RequestT, ResponseT> q2<RequestT, ResponseT> b(@l um.g gVar, @l w1<RequestT, ResponseT> w1Var, @l jn.l<? super sq.i<? extends RequestT>, ? extends sq.i<? extends ResponseT>> lVar) {
        l0.p(gVar, "context");
        l0.p(w1Var, "descriptor");
        l0.p(lVar, "implementation");
        if (w1Var.f17480a == w1.d.BIDI_STREAMING) {
            return g(gVar, w1Var, lVar);
        }
        throw new IllegalArgumentException(("Expected a bidi streaming method descriptor but got " + w1Var).toString());
    }

    @l
    public final <RequestT, ResponseT> q2<RequestT, ResponseT> c(@l um.g gVar, @l w1<RequestT, ResponseT> w1Var, @l p<? super sq.i<? extends RequestT>, ? super um.d<? super ResponseT>, ? extends Object> pVar) {
        l0.p(gVar, "context");
        l0.p(w1Var, "descriptor");
        l0.p(pVar, "implementation");
        if (w1Var.f17480a == w1.d.CLIENT_STREAMING) {
            return g(gVar, w1Var, new a(pVar));
        }
        throw new IllegalArgumentException(("Expected a client streaming method descriptor but got " + w1Var).toString());
    }

    public final <RequestT, ResponseT> m2<RequestT, ResponseT> d(um.g gVar, jn.l<? super sq.i<? extends RequestT>, ? extends sq.i<? extends ResponseT>> lVar) {
        return new h(gVar, lVar);
    }

    public final <RequestT, ResponseT> k2.a<RequestT> f(um.g gVar, k2<RequestT, ResponseT> k2Var, jn.l<? super sq.i<? extends RequestT>, ? extends sq.i<? extends ResponseT>> lVar) {
        xj.g gVar2 = new xj.g(new c(k2Var));
        pq.l lVarD = pq.o.d(1, null, null, 6, null);
        return new b(k.f(t0.a(gVar), null, null, new e(lVar, new i0(new d(new AtomicBoolean(false), k2Var, lVarD, null)), gVar2, k2Var, null), 3, null), lVarD, k2Var, gVar2);
    }

    public final <RequestT, ResponseT> q2<RequestT, ResponseT> g(um.g gVar, w1<RequestT, ResponseT> w1Var, jn.l<? super sq.i<? extends RequestT>, ? extends sq.i<? extends ResponseT>> lVar) {
        q2<RequestT, ResponseT> q2Var = new q2<>(w1Var, new h(gVar, lVar));
        l0.o(q2Var, "create(\n      descriptor…xt, implementation)\n    )");
        return q2Var;
    }

    @l
    public final <RequestT, ResponseT> q2<RequestT, ResponseT> h(@l um.g gVar, @l w1<RequestT, ResponseT> w1Var, @l jn.l<? super RequestT, ? extends sq.i<? extends ResponseT>> lVar) {
        l0.p(gVar, "context");
        l0.p(w1Var, "descriptor");
        l0.p(lVar, "implementation");
        if (w1Var.f17480a == w1.d.SERVER_STREAMING) {
            return g(gVar, w1Var, new f(w1Var, lVar));
        }
        throw new IllegalArgumentException(("Expected a server streaming method descriptor but got " + w1Var).toString());
    }

    @l
    public final <RequestT, ResponseT> q2<RequestT, ResponseT> i(@l um.g gVar, @l w1<RequestT, ResponseT> w1Var, @l p<? super RequestT, ? super um.d<? super ResponseT>, ? extends Object> pVar) {
        l0.p(gVar, "context");
        l0.p(w1Var, "descriptor");
        l0.p(pVar, "implementation");
        if (w1Var.f17480a == w1.d.UNARY) {
            return g(gVar, w1Var, new g(w1Var, pVar));
        }
        throw new IllegalArgumentException(("Expected a unary method descriptor but got " + w1Var).toString());
    }
}
