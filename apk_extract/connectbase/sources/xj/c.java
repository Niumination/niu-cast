package xj;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.CancellationException;
import jn.p;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.d1;
import lm.l2;
import nq.s0;
import nq.t0;
import os.l;
import os.m;
import sq.i0;
import vj.k;
import vj.v1;
import vj.w1;
import vj.y2;
import vj.z2;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final c f20243a = new c();

    public static abstract class a<RequestT> {

        /* JADX INFO: renamed from: xj.c$a$a, reason: collision with other inner class name */
        public static final class C0504a<RequestT> extends a<RequestT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @l
            public final sq.i<RequestT> f20244a;

            /* JADX INFO: renamed from: xj.c$a$a$a, reason: collision with other inner class name */
            @xm.f(c = "io.grpc.kotlin.ClientCalls$Request$Flowing", f = "ClientCalls.kt", i = {0, 0, 0}, l = {247, 248}, m = "sendTo", n = {"this", "clientCall", "readiness"}, s = {"L$0", "L$1", "L$2"})
            public static final class C0505a extends xm.d {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ C0504a<RequestT> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0505a(C0504a<RequestT> c0504a, um.d<? super C0505a> dVar) {
                    super(dVar);
                    this.this$0 = c0504a;
                }

                @Override // xm.a
                @m
                public final Object invokeSuspend(@l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.a(null, null, this);
                }
            }

            /* JADX INFO: renamed from: xj.c$a$a$b */
            public static final class b<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ k<RequestT, ?> f20245a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ xj.g f20246b;

                public b(k<RequestT, ?> kVar, xj.g gVar) {
                    this.f20245a = kVar;
                    this.f20246b = gVar;
                }

                @Override // sq.j
                @m
                public final Object emit(RequestT requestt, @l um.d<? super l2> dVar) {
                    this.f20245a.f(requestt);
                    Object objB = this.f20246b.b(dVar);
                    return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0504a(@l sq.i<? extends RequestT> iVar) {
                l0.p(iVar, "requestFlow");
                this.f20244a = iVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // xj.c.a
            @m
            public Object a(@l k<RequestT, ?> kVar, @l xj.g gVar, @l um.d<? super l2> dVar) {
                C0505a c0505a;
                if (dVar instanceof C0505a) {
                    c0505a = (C0505a) dVar;
                    int i10 = c0505a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0505a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0505a = new C0505a(this, dVar);
                    }
                } else {
                    c0505a = new C0505a(this, dVar);
                }
                Object obj = c0505a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0505a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        gVar = (xj.g) c0505a.L$2;
                        kVar = (k) c0505a.L$1;
                        this = (C0504a) c0505a.L$0;
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
                c0505a.L$0 = this;
                c0505a.L$1 = kVar;
                c0505a.L$2 = gVar;
                c0505a.label = 1;
                if (gVar.b(c0505a) == aVar) {
                    return aVar;
                }
                sq.i<RequestT> iVar = this.f20244a;
                b bVar = new b(kVar, gVar);
                c0505a.L$0 = null;
                c0505a.L$1 = null;
                c0505a.L$2 = null;
                c0505a.label = 2;
                if (iVar.a(bVar, c0505a) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }
        }

        public static final class b<RequestT> extends a<RequestT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final RequestT f20247a;

            public b(RequestT requestt) {
                this.f20247a = requestt;
            }

            @Override // xj.c.a
            @m
            public Object a(@l k<RequestT, ?> kVar, @l xj.g gVar, @l um.d<? super l2> dVar) {
                kVar.f(this.f20247a);
                return l2.f10208a;
            }
        }

        public a() {
        }

        @m
        public abstract Object a(@l k<RequestT, ?> kVar, @l xj.g gVar, @l um.d<? super l2> dVar);

        public a(w wVar) {
        }
    }

    @xm.f(c = "io.grpc.kotlin.ClientCalls$bidiStreamingRpcFunction$1", f = "ClientCalls.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends o implements jn.l<um.d<? super v1>, Object> {
        int label;

        public b(um.d<? super b> dVar) {
            super(1, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@l um.d<?> dVar) {
            return new b(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return new v1();
        }

        @Override // jn.l
        @m
        public final Object invoke(@m um.d<? super v1> dVar) {
            return ((b) create(dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    /* JADX INFO: renamed from: xj.c$c, reason: collision with other inner class name */
    public static final class C0506c<RequestT, ResponseT> extends n0 implements jn.l<sq.i<? extends RequestT>, sq.i<? extends ResponseT>> {
        final /* synthetic */ vj.e $callOptions;
        final /* synthetic */ vj.f $channel;
        final /* synthetic */ jn.l<um.d<? super v1>, Object> $headers;
        final /* synthetic */ w1<RequestT, ResponseT> $method;

        /* JADX INFO: renamed from: xj.c$c$a */
        @xm.f(c = "io.grpc.kotlin.ClientCalls$bidiStreamingRpcFunction$2$1", f = "ClientCalls.kt", i = {0}, l = {215, 216}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
        public static final class a extends o implements p<sq.j<? super ResponseT>, um.d<? super l2>, Object> {
            final /* synthetic */ vj.e $callOptions;
            final /* synthetic */ vj.f $channel;
            final /* synthetic */ jn.l<um.d<? super v1>, Object> $headers;
            final /* synthetic */ sq.i<RequestT> $it;
            final /* synthetic */ w1<RequestT, ResponseT> $method;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX INFO: renamed from: xj.c$c$a$a, reason: collision with other inner class name */
            public static final class C0507a<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ sq.j<ResponseT> f20248a;

                /* JADX WARN: Multi-variable type inference failed */
                public C0507a(sq.j<? super ResponseT> jVar) {
                    this.f20248a = jVar;
                }

                @Override // sq.j
                @m
                public final Object emit(ResponseT responset, @l um.d<? super l2> dVar) {
                    Object objEmit = this.f20248a.emit(responset, dVar);
                    return objEmit == wm.a.COROUTINE_SUSPENDED ? objEmit : l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(vj.f fVar, w1<RequestT, ResponseT> w1Var, sq.i<? extends RequestT> iVar, vj.e eVar, jn.l<? super um.d<? super v1>, ? extends Object> lVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$channel = fVar;
                this.$method = w1Var;
                this.$it = iVar;
                this.$callOptions = eVar;
                this.$headers = lVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                a aVar = new a(this.$channel, this.$method, this.$it, this.$callOptions, this.$headers, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                vj.f fVar;
                w1<RequestT, ResponseT> w1Var;
                sq.i<RequestT> iVar;
                c cVar;
                vj.e eVar;
                sq.j jVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        vj.e eVar2 = (vj.e) this.L$5;
                        sq.i<RequestT> iVar2 = (sq.i) this.L$4;
                        w1Var = (w1) this.L$3;
                        fVar = (vj.f) this.L$2;
                        c cVar2 = (c) this.L$1;
                        sq.j jVar2 = (sq.j) this.L$0;
                        d1.n(obj);
                        eVar = eVar2;
                        jVar = jVar2;
                        iVar = iVar2;
                        cVar = cVar2;
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
                sq.j jVar3 = (sq.j) this.L$0;
                c cVar3 = c.f20243a;
                fVar = this.$channel;
                w1Var = this.$method;
                sq.i<RequestT> iVar3 = this.$it;
                vj.e eVar3 = this.$callOptions;
                jn.l<um.d<? super v1>, Object> lVar = this.$headers;
                this.L$0 = jVar3;
                this.L$1 = cVar3;
                this.L$2 = fVar;
                this.L$3 = w1Var;
                this.L$4 = iVar3;
                this.L$5 = eVar3;
                this.label = 1;
                Object objInvoke = lVar.invoke(this);
                if (objInvoke == aVar) {
                    return aVar;
                }
                iVar = iVar3;
                obj = objInvoke;
                cVar = cVar3;
                eVar = eVar3;
                jVar = jVar3;
                sq.i<ResponseT> iVarB = cVar.b(fVar, w1Var, iVar, eVar, (v1) obj);
                C0507a c0507a = new C0507a(jVar);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.label = 2;
                if (iVarB.a(c0507a, this) == aVar) {
                    return aVar;
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
        public C0506c(vj.f fVar, w1<RequestT, ResponseT> w1Var, vj.e eVar, jn.l<? super um.d<? super v1>, ? extends Object> lVar) {
            super(1);
            this.$channel = fVar;
            this.$method = w1Var;
            this.$callOptions = eVar;
            this.$headers = lVar;
        }

        @Override // jn.l
        @l
        public final sq.i<ResponseT> invoke(@l sq.i<? extends RequestT> iVar) {
            l0.p(iVar, "it");
            return new i0(new a(this.$channel, this.$method, iVar, this.$callOptions, this.$headers, null));
        }
    }

    @xm.f(c = "io.grpc.kotlin.ClientCalls$clientStreamingRpcFunction$1", f = "ClientCalls.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends o implements jn.l<um.d<? super v1>, Object> {
        int label;

        public d(um.d<? super d> dVar) {
            super(1, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@l um.d<?> dVar) {
            return new d(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return new v1();
        }

        @Override // jn.l
        @m
        public final Object invoke(@m um.d<? super v1> dVar) {
            return ((d) create(dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    @xm.f(c = "io.grpc.kotlin.ClientCalls$clientStreamingRpcFunction$2", f = "ClientCalls.kt", i = {}, l = {165, 160}, m = "invokeSuspend", n = {}, s = {})
    public static final class e<RequestT, ResponseT> extends o implements p<sq.i<? extends RequestT>, um.d<? super ResponseT>, Object> {
        final /* synthetic */ vj.e $callOptions;
        final /* synthetic */ vj.f $channel;
        final /* synthetic */ jn.l<um.d<? super v1>, Object> $headers;
        final /* synthetic */ w1<RequestT, ResponseT> $method;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(vj.f fVar, w1<RequestT, ResponseT> w1Var, vj.e eVar, jn.l<? super um.d<? super v1>, ? extends Object> lVar, um.d<? super e> dVar) {
            super(2, dVar);
            this.$channel = fVar;
            this.$method = w1Var;
            this.$callOptions = eVar;
            this.$headers = lVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            e eVar = new e(this.$channel, this.$method, this.$callOptions, this.$headers, dVar);
            eVar.L$0 = obj;
            return eVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            vj.f fVar;
            w1<RequestT, ResponseT> w1Var;
            vj.e eVar;
            c cVar;
            sq.i<? extends RequestT> iVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    vj.e eVar2 = (vj.e) this.L$4;
                    sq.i<? extends RequestT> iVar2 = (sq.i) this.L$3;
                    w1Var = (w1) this.L$2;
                    fVar = (vj.f) this.L$1;
                    c cVar2 = (c) this.L$0;
                    d1.n(obj);
                    eVar = eVar2;
                    cVar = cVar2;
                    iVar = iVar2;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
            }
            d1.n(obj);
            sq.i<? extends RequestT> iVar3 = (sq.i) this.L$0;
            c cVar3 = c.f20243a;
            fVar = this.$channel;
            w1Var = this.$method;
            vj.e eVar3 = this.$callOptions;
            jn.l<um.d<? super v1>, Object> lVar = this.$headers;
            this.L$0 = cVar3;
            this.L$1 = fVar;
            this.L$2 = w1Var;
            this.L$3 = iVar3;
            this.L$4 = eVar3;
            this.label = 1;
            Object objInvoke = lVar.invoke(this);
            if (objInvoke == aVar) {
                return aVar;
            }
            eVar = eVar3;
            cVar = cVar3;
            iVar = iVar3;
            obj = objInvoke;
            c cVar4 = cVar;
            vj.f fVar2 = fVar;
            w1<RequestT, ResponseT> w1Var2 = w1Var;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 2;
            obj = cVar4.f(fVar2, w1Var2, iVar, eVar, (v1) obj, this);
            return obj == aVar ? aVar : obj;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l sq.i<? extends RequestT> iVar, @m um.d<? super ResponseT> dVar) {
            return ((e) create(iVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ResponseT] */
    @xm.f(c = "io.grpc.kotlin.ClientCalls$rpcImpl$1", f = "ClientCalls.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
    public static final class f<ResponseT> extends o implements p<sq.j<? super ResponseT>, um.d<? super l2>, Object> {
        final /* synthetic */ vj.e $callOptions;
        final /* synthetic */ vj.f $channel;
        final /* synthetic */ v1 $headers;
        final /* synthetic */ w1<RequestT, ResponseT> $method;
        final /* synthetic */ a<RequestT> $request;
        private /* synthetic */ Object L$0;
        int label;

        @xm.f(c = "io.grpc.kotlin.ClientCalls$rpcImpl$1$1", f = "ClientCalls.kt", i = {0, 0, 1, 1, 2}, l = {324, 325, 329}, m = "invokeSuspend", n = {"clientCall", "sender", "clientCall", "sender", "e"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
        public static final class a extends o implements p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ sq.j<ResponseT> $$this$flow;
            final /* synthetic */ vj.e $callOptions;
            final /* synthetic */ vj.f $channel;
            final /* synthetic */ v1 $headers;
            final /* synthetic */ w1<RequestT, ResponseT> $method;
            final /* synthetic */ a<RequestT> $request;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX INFO: renamed from: xj.c$f$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nClientCalls.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientCalls.kt\nio/grpc/kotlin/ClientCalls$rpcImpl$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,343:1\n530#2,5:344\n*S KotlinDebug\n*F\n+ 1 ClientCalls.kt\nio/grpc/kotlin/ClientCalls$rpcImpl$1$1$1\n*L\n290#1:344,5\n*E\n"})
            public static final class C0508a extends k.a<ResponseT> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ pq.l<ResponseT> f20249a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ xj.g f20250b;

                public C0508a(pq.l<ResponseT> lVar, xj.g gVar) {
                    this.f20249a = lVar;
                    this.f20250b = gVar;
                }

                @Override // vj.k.a
                public void a(@l y2 y2Var, @l v1 v1Var) {
                    Throwable th2;
                    l0.p(y2Var, NotificationCompat.CATEGORY_STATUS);
                    l0.p(v1Var, "trailersMetadata");
                    if (y2Var.r()) {
                        th2 = null;
                    } else {
                        Throwable z2Var = y2Var.f17570c;
                        if (!(z2Var instanceof CancellationException)) {
                            z2Var = new z2(y2Var, v1Var);
                        }
                        th2 = z2Var;
                    }
                    this.f20249a.f(th2);
                }

                @Override // vj.k.a
                public void c(ResponseT responset) throws Throwable {
                    Object objW = this.f20249a.w(responset);
                    if (objW instanceof pq.p.c) {
                        Throwable thF = pq.p.f(objW);
                        if (thF != null) {
                            throw thF;
                        }
                        throw new AssertionError("onMessage should never be called until responses is ready");
                    }
                }

                @Override // vj.k.a
                public void d() {
                    this.f20250b.a();
                }
            }

            @xm.f(c = "io.grpc.kotlin.ClientCalls$rpcImpl$1$1$2", f = "ClientCalls.kt", i = {}, l = {330}, m = "invokeSuspend", n = {}, s = {})
            public static final class b extends o implements p<s0, um.d<? super l2>, Object> {
                final /* synthetic */ k<RequestT, ResponseT> $clientCall;
                final /* synthetic */ Exception $e;
                final /* synthetic */ nq.l2 $sender;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(nq.l2 l2Var, Exception exc, k<RequestT, ResponseT> kVar, um.d<? super b> dVar) {
                    super(2, dVar);
                    this.$sender = l2Var;
                    this.$e = exc;
                    this.$clientCall = kVar;
                }

                @Override // xm.a
                @l
                public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                    return new b(this.$sender, this.$e, this.$clientCall, dVar);
                }

                @Override // xm.a
                @m
                public final Object invokeSuspend(@l Object obj) {
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i10 = this.label;
                    if (i10 == 0) {
                        d1.n(obj);
                        nq.l2 l2Var = this.$sender;
                        Exception exc = this.$e;
                        this.label = 1;
                        if (xj.f.a(l2Var, "Collection of responses completed exceptionally", exc, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    this.$clientCall.a("Collection of responses completed exceptionally", this.$e);
                    return l2.f10208a;
                }

                @Override // jn.p
                @m
                public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
                    return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
                }
            }

            /* JADX INFO: renamed from: xj.c$f$a$c, reason: collision with other inner class name */
            public static final class C0509c extends n0 implements jn.a<Boolean> {
                final /* synthetic */ k<RequestT, ResponseT> $clientCall;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0509c(k<RequestT, ResponseT> kVar) {
                    super(0);
                    this.$clientCall = kVar;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // jn.a
                @l
                public final Boolean invoke() {
                    return Boolean.valueOf(this.$clientCall.d());
                }
            }

            @xm.f(c = "io.grpc.kotlin.ClientCalls$rpcImpl$1$1$sender$1", f = "ClientCalls.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
            public static final class d extends o implements p<s0, um.d<? super l2>, Object> {
                final /* synthetic */ k<RequestT, ResponseT> $clientCall;
                final /* synthetic */ xj.g $readiness;
                final /* synthetic */ a<RequestT> $request;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public d(a<RequestT> aVar, k<RequestT, ResponseT> kVar, xj.g gVar, um.d<? super d> dVar) {
                    super(2, dVar);
                    this.$request = aVar;
                    this.$clientCall = kVar;
                    this.$readiness = gVar;
                }

                @Override // xm.a
                @l
                public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                    return new d(this.$request, this.$clientCall, this.$readiness, dVar);
                }

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
                public final Object invokeSuspend(@l Object obj) throws Exception {
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i10 = this.label;
                    try {
                        if (i10 == 0) {
                            d1.n(obj);
                            a<RequestT> aVar2 = this.$request;
                            Object obj2 = this.$clientCall;
                            xj.g gVar = this.$readiness;
                            this.label = 1;
                            if (aVar2.a(obj2, gVar, this) == aVar) {
                                return aVar;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d1.n(obj);
                        }
                        this.$clientCall.c();
                        return l2.f10208a;
                    } catch (Exception e10) {
                        this.$clientCall.a("Collection of requests completed exceptionally", e10);
                        throw e10;
                    }
                }

                @Override // jn.p
                @m
                public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
                    return ((d) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(vj.f fVar, w1<RequestT, ResponseT> w1Var, vj.e eVar, v1 v1Var, sq.j<? super ResponseT> jVar, a<RequestT> aVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$channel = fVar;
                this.$method = w1Var;
                this.$callOptions = eVar;
                this.$headers = v1Var;
                this.$$this$flow = jVar;
                this.$request = aVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                a aVar = new a(this.$channel, this.$method, this.$callOptions, this.$headers, this.$$this$flow, this.$request, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d6 -> B:29:0x00d9). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to xj.c$f$a for r13v9 'this'  um.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r14) {
                /*
                    Method dump skipped, instruction units count: 262
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: xj.c.f.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.p
            @m
            public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(vj.f fVar, w1<RequestT, ResponseT> w1Var, vj.e eVar, v1 v1Var, a<RequestT> aVar, um.d<? super f> dVar) {
            super(2, dVar);
            this.$channel = fVar;
            this.$method = w1Var;
            this.$callOptions = eVar;
            this.$headers = v1Var;
            this.$request = aVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            f fVar = new f(this.$channel, this.$method, this.$callOptions, this.$headers, this.$request, dVar);
            fVar.L$0 = obj;
            return fVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                a aVar2 = new a(this.$channel, this.$method, this.$callOptions, this.$headers, (sq.j) this.L$0, this.$request, null);
                this.label = 1;
                if (t0.g(aVar2, this) == aVar) {
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
            return ((f) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.grpc.kotlin.ClientCalls$serverStreamingRpcFunction$1", f = "ClientCalls.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends o implements jn.l<um.d<? super v1>, Object> {
        int label;

        public g(um.d<? super g> dVar) {
            super(1, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@l um.d<?> dVar) {
            return new g(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return new v1();
        }

        @Override // jn.l
        @m
        public final Object invoke(@m um.d<? super v1> dVar) {
            return ((g) create(dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    public static final class h<RequestT, ResponseT> extends n0 implements jn.l<RequestT, sq.i<? extends ResponseT>> {
        final /* synthetic */ vj.e $callOptions;
        final /* synthetic */ vj.f $channel;
        final /* synthetic */ jn.l<um.d<? super v1>, Object> $headers;
        final /* synthetic */ w1<RequestT, ResponseT> $method;

        @xm.f(c = "io.grpc.kotlin.ClientCalls$serverStreamingRpcFunction$2$1", f = "ClientCalls.kt", i = {0}, l = {y5.a.f20730l0, 120}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
        public static final class a extends o implements p<sq.j<? super ResponseT>, um.d<? super l2>, Object> {
            final /* synthetic */ vj.e $callOptions;
            final /* synthetic */ vj.f $channel;
            final /* synthetic */ jn.l<um.d<? super v1>, Object> $headers;
            final /* synthetic */ RequestT $it;
            final /* synthetic */ w1<RequestT, ResponseT> $method;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX INFO: renamed from: xj.c$h$a$a, reason: collision with other inner class name */
            public static final class C0510a<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ sq.j<ResponseT> f20251a;

                /* JADX WARN: Multi-variable type inference failed */
                public C0510a(sq.j<? super ResponseT> jVar) {
                    this.f20251a = jVar;
                }

                @Override // sq.j
                @m
                public final Object emit(ResponseT responset, @l um.d<? super l2> dVar) {
                    Object objEmit = this.f20251a.emit(responset, dVar);
                    return objEmit == wm.a.COROUTINE_SUSPENDED ? objEmit : l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(vj.f fVar, w1<RequestT, ResponseT> w1Var, RequestT requestt, vj.e eVar, jn.l<? super um.d<? super v1>, ? extends Object> lVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$channel = fVar;
                this.$method = w1Var;
                this.$it = requestt;
                this.$callOptions = eVar;
                this.$headers = lVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                a aVar = new a(this.$channel, this.$method, this.$it, this.$callOptions, this.$headers, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                vj.f fVar;
                w1<RequestT, ResponseT> w1Var;
                Object obj2;
                c cVar;
                vj.e eVar;
                sq.j jVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        vj.e eVar2 = (vj.e) this.L$5;
                        Object obj3 = this.L$4;
                        w1Var = (w1) this.L$3;
                        fVar = (vj.f) this.L$2;
                        c cVar2 = (c) this.L$1;
                        sq.j jVar2 = (sq.j) this.L$0;
                        d1.n(obj);
                        eVar = eVar2;
                        jVar = jVar2;
                        obj2 = obj3;
                        cVar = cVar2;
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
                sq.j jVar3 = (sq.j) this.L$0;
                c cVar3 = c.f20243a;
                fVar = this.$channel;
                w1Var = this.$method;
                RequestT requestt = this.$it;
                vj.e eVar3 = this.$callOptions;
                jn.l<um.d<? super v1>, Object> lVar = this.$headers;
                this.L$0 = jVar3;
                this.L$1 = cVar3;
                this.L$2 = fVar;
                this.L$3 = w1Var;
                this.L$4 = requestt;
                this.L$5 = eVar3;
                this.label = 1;
                Object objInvoke = lVar.invoke(this);
                if (objInvoke == aVar) {
                    return aVar;
                }
                obj2 = requestt;
                obj = objInvoke;
                cVar = cVar3;
                eVar = eVar3;
                jVar = jVar3;
                sq.i iVarL = cVar.l(fVar, w1Var, obj2, eVar, (v1) obj);
                C0510a c0510a = new C0510a(jVar);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.label = 2;
                if (iVarL.a(c0510a, this) == aVar) {
                    return aVar;
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
        public h(vj.f fVar, w1<RequestT, ResponseT> w1Var, vj.e eVar, jn.l<? super um.d<? super v1>, ? extends Object> lVar) {
            super(1);
            this.$channel = fVar;
            this.$method = w1Var;
            this.$callOptions = eVar;
            this.$headers = lVar;
        }

        @Override // jn.l
        @l
        public final sq.i<ResponseT> invoke(RequestT requestt) {
            return new i0(new a(this.$channel, this.$method, requestt, this.$callOptions, this.$headers, null));
        }
    }

    @xm.f(c = "io.grpc.kotlin.ClientCalls$unaryRpcFunction$1", f = "ClientCalls.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends o implements jn.l<um.d<? super v1>, Object> {
        int label;

        public i(um.d<? super i> dVar) {
            super(1, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@l um.d<?> dVar) {
            return new i(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return new v1();
        }

        @Override // jn.l
        @m
        public final Object invoke(@m um.d<? super v1> dVar) {
            return ((i) create(dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    @xm.f(c = "io.grpc.kotlin.ClientCalls$unaryRpcFunction$2", f = "ClientCalls.kt", i = {}, l = {77, 77}, m = "invokeSuspend", n = {}, s = {})
    public static final class j<RequestT, ResponseT> extends o implements p<RequestT, um.d<? super ResponseT>, Object> {
        final /* synthetic */ vj.e $callOptions;
        final /* synthetic */ vj.f $channel;
        final /* synthetic */ jn.l<um.d<? super v1>, Object> $headers;
        final /* synthetic */ w1<RequestT, ResponseT> $method;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(vj.f fVar, w1<RequestT, ResponseT> w1Var, vj.e eVar, jn.l<? super um.d<? super v1>, ? extends Object> lVar, um.d<? super j> dVar) {
            super(2, dVar);
            this.$channel = fVar;
            this.$method = w1Var;
            this.$callOptions = eVar;
            this.$headers = lVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            j jVar = new j(this.$channel, this.$method, this.$callOptions, this.$headers, dVar);
            jVar.L$0 = obj;
            return jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            vj.f fVar;
            w1<RequestT, ResponseT> w1Var;
            vj.e eVar;
            c cVar;
            Object obj2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    vj.e eVar2 = (vj.e) this.L$4;
                    Object obj3 = this.L$3;
                    w1Var = (w1) this.L$2;
                    fVar = (vj.f) this.L$1;
                    c cVar2 = (c) this.L$0;
                    d1.n(obj);
                    eVar = eVar2;
                    cVar = cVar2;
                    obj2 = obj3;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
            }
            d1.n(obj);
            Object obj4 = this.L$0;
            c cVar3 = c.f20243a;
            fVar = this.$channel;
            w1Var = this.$method;
            vj.e eVar3 = this.$callOptions;
            jn.l<um.d<? super v1>, Object> lVar = this.$headers;
            this.L$0 = cVar3;
            this.L$1 = fVar;
            this.L$2 = w1Var;
            this.L$3 = obj4;
            this.L$4 = eVar3;
            this.label = 1;
            Object objInvoke = lVar.invoke(this);
            if (objInvoke == aVar) {
                return aVar;
            }
            eVar = eVar3;
            cVar = cVar3;
            obj2 = obj4;
            obj = objInvoke;
            c cVar4 = cVar;
            vj.f fVar2 = fVar;
            w1<RequestT, ResponseT> w1Var2 = w1Var;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 2;
            obj = cVar4.p(fVar2, w1Var2, obj2, eVar, (v1) obj, this);
            return obj == aVar ? aVar : obj;
        }

        @Override // jn.p
        @m
        public final Object invoke(RequestT requestt, @m um.d<? super ResponseT> dVar) {
            return ((j) create(requestt, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static sq.i c(c cVar, vj.f fVar, w1 w1Var, sq.i iVar, vj.e eVar, v1 v1Var, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        vj.e eVar2 = eVar;
        if ((i10 & 16) != 0) {
            v1Var = new v1();
        }
        return cVar.b(fVar, w1Var, iVar, eVar2, v1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ jn.l e(c cVar, vj.f fVar, w1 w1Var, vj.e eVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        if ((i10 & 8) != 0) {
            lVar = new b(null);
        }
        return cVar.d(fVar, w1Var, eVar, lVar);
    }

    public static Object g(c cVar, vj.f fVar, w1 w1Var, sq.i iVar, vj.e eVar, v1 v1Var, um.d dVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        vj.e eVar2 = eVar;
        if ((i10 & 16) != 0) {
            v1Var = new v1();
        }
        return cVar.f(fVar, w1Var, iVar, eVar2, v1Var, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ p i(c cVar, vj.f fVar, w1 w1Var, vj.e eVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        if ((i10 & 8) != 0) {
            lVar = new d(null);
        }
        return cVar.h(fVar, w1Var, eVar, lVar);
    }

    public static sq.i m(c cVar, vj.f fVar, w1 w1Var, Object obj, vj.e eVar, v1 v1Var, int i10, Object obj2) {
        if ((i10 & 8) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        vj.e eVar2 = eVar;
        if ((i10 & 16) != 0) {
            v1Var = new v1();
        }
        return cVar.l(fVar, w1Var, obj, eVar2, v1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ jn.l o(c cVar, vj.f fVar, w1 w1Var, vj.e eVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        if ((i10 & 8) != 0) {
            lVar = new g(null);
        }
        return cVar.n(fVar, w1Var, eVar, lVar);
    }

    public static Object q(c cVar, vj.f fVar, w1 w1Var, Object obj, vj.e eVar, v1 v1Var, um.d dVar, int i10, Object obj2) {
        if ((i10 & 8) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        vj.e eVar2 = eVar;
        if ((i10 & 16) != 0) {
            v1Var = new v1();
        }
        return cVar.p(fVar, w1Var, obj, eVar2, v1Var, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ p s(c cVar, vj.f fVar, w1 w1Var, vj.e eVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        if ((i10 & 8) != 0) {
            lVar = new i(null);
        }
        return cVar.r(fVar, w1Var, eVar, lVar);
    }

    @l
    public final <RequestT, ResponseT> sq.i<ResponseT> b(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, @l sq.i<? extends RequestT> iVar, @l vj.e eVar, @l v1 v1Var) {
        l0.p(fVar, "channel");
        l0.p(w1Var, "method");
        l0.p(iVar, "requests");
        l0.p(eVar, "callOptions");
        l0.p(v1Var, "headers");
        if (w1Var.f17480a == w1.d.BIDI_STREAMING) {
            return k(fVar, w1Var, eVar, v1Var, new a.C0504a(iVar));
        }
        throw new IllegalStateException(("Expected a bidi streaming method, but got " + w1Var).toString());
    }

    @l
    public final <RequestT, ResponseT> jn.l<sq.i<? extends RequestT>, sq.i<ResponseT>> d(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, @l vj.e eVar, @l jn.l<? super um.d<? super v1>, ? extends Object> lVar) {
        l0.p(fVar, "channel");
        l0.p(w1Var, "method");
        l0.p(eVar, "callOptions");
        l0.p(lVar, "headers");
        return new C0506c(fVar, w1Var, eVar, lVar);
    }

    @m
    public final <RequestT, ResponseT> Object f(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, @l sq.i<? extends RequestT> iVar, @l vj.e eVar, @l v1 v1Var, @l um.d<? super ResponseT> dVar) {
        if (w1Var.f17480a == w1.d.CLIENT_STREAMING) {
            return xj.f.d(k(fVar, w1Var, eVar, v1Var, new a.C0504a(iVar)), "response", w1Var, dVar);
        }
        throw new IllegalArgumentException(("Expected a server streaming RPC method, but got " + w1Var).toString());
    }

    @l
    public final <RequestT, ResponseT> p<sq.i<? extends RequestT>, um.d<? super ResponseT>, Object> h(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, @l vj.e eVar, @l jn.l<? super um.d<? super v1>, ? extends Object> lVar) {
        l0.p(fVar, "channel");
        l0.p(w1Var, "method");
        l0.p(eVar, "callOptions");
        l0.p(lVar, "headers");
        return new e(fVar, w1Var, eVar, lVar, null);
    }

    public final v1 j(v1 v1Var) {
        v1 v1Var2 = new v1();
        v1Var2.s(v1Var);
        return v1Var2;
    }

    public final <RequestT, ResponseT> sq.i<ResponseT> k(vj.f fVar, w1<RequestT, ResponseT> w1Var, vj.e eVar, v1 v1Var, a<RequestT> aVar) {
        return new i0(new f(fVar, w1Var, eVar, v1Var, aVar, null));
    }

    @l
    public final <RequestT, ResponseT> sq.i<ResponseT> l(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, RequestT requestt, @l vj.e eVar, @l v1 v1Var) {
        l0.p(fVar, "channel");
        l0.p(w1Var, "method");
        l0.p(eVar, "callOptions");
        l0.p(v1Var, "headers");
        if (w1Var.f17480a == w1.d.SERVER_STREAMING) {
            return k(fVar, w1Var, eVar, v1Var, new a.b(requestt));
        }
        throw new IllegalArgumentException(("Expected a server streaming RPC method, but got " + w1Var).toString());
    }

    @l
    public final <RequestT, ResponseT> jn.l<RequestT, sq.i<ResponseT>> n(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, @l vj.e eVar, @l jn.l<? super um.d<? super v1>, ? extends Object> lVar) {
        l0.p(fVar, "channel");
        l0.p(w1Var, "method");
        l0.p(eVar, "callOptions");
        l0.p(lVar, "headers");
        return new h(fVar, w1Var, eVar, lVar);
    }

    @m
    public final <RequestT, ResponseT> Object p(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, RequestT requestt, @l vj.e eVar, @l v1 v1Var, @l um.d<? super ResponseT> dVar) {
        if (w1Var.f17480a == w1.d.UNARY) {
            return xj.f.d(k(fVar, w1Var, eVar, v1Var, new a.b(requestt)), "request", w1Var, dVar);
        }
        throw new IllegalArgumentException(("Expected a unary RPC method, but got " + w1Var).toString());
    }

    @l
    public final <RequestT, ResponseT> p<RequestT, um.d<? super ResponseT>, Object> r(@l vj.f fVar, @l w1<RequestT, ResponseT> w1Var, @l vj.e eVar, @l jn.l<? super um.d<? super v1>, ? extends Object> lVar) {
        l0.p(fVar, "channel");
        l0.p(w1Var, "method");
        l0.p(eVar, "callOptions");
        l0.p(lVar, "headers");
        return new j(fVar, w1Var, eVar, lVar, null);
    }
}
