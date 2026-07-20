package al;

import androidx.core.app.NotificationCompat;
import ik.j0;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.DecoderResult;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.r0;
import nq.s0;
import nq.u0;
import yk.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends ChannelInboundHandlerAdapter implements s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f343c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final r0 f344d = new r0("call-handler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a0 f345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final um.g f346b;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    @xm.f(c = "io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1", f = "NettyApplicationCallHandler.kt", i = {}, l = {46, 123, 52}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ dk.b $call;
        int label;
        final /* synthetic */ j this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dk.b bVar, j jVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$call = bVar;
            this.this$0 = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new b(this.$call, this.this$0, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v9 */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            d1.n(obj);
                            this = this;
                        } else if (i10 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    d1.n(obj);
                } else {
                    d1.n(obj);
                    dk.b bVar = this.$call;
                    if (!(bVar instanceof cl.b) || k.c(((cl.b) bVar).f1651g.f1653v)) {
                        a0 a0Var = this.this$0.f345a;
                        dk.b bVar2 = this.$call;
                        l2 l2Var = l2.f10208a;
                        this.label = 2;
                        Object objG = a0Var.g(bVar2, l2Var, this);
                        this = objG;
                        if (objG == aVar) {
                            return aVar;
                        }
                    } else {
                        j jVar = this.this$0;
                        cl.b bVar3 = (cl.b) this.$call;
                        this.label = 1;
                        if (jVar.o(bVar3, this) == aVar) {
                            return aVar;
                        }
                    }
                }
            } catch (Exception e10) {
                dk.b bVar4 = this.$call;
                this.label = 3;
                if (yk.r.e(bVar4, e10, this) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public j(@os.l um.g gVar, @os.l a0 a0Var, @os.l ps.a aVar) {
        l0.p(gVar, "userCoroutineContext");
        l0.p(a0Var, "enginePipeline");
        l0.p(aVar, "logger");
        this.f345a = a0Var;
        this.f346b = gVar.plus(f344d).plus(new yk.t(aVar));
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(@os.l ChannelHandlerContext channelHandlerContext, @os.l Object obj) {
        l0.p(channelHandlerContext, "ctx");
        l0.p(obj, NotificationCompat.CATEGORY_MESSAGE);
        if (obj instanceof dk.b) {
            k(channelHandlerContext, (dk.b) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f346b;
    }

    public final void k(ChannelHandlerContext channelHandlerContext, dk.b bVar) {
        nq.k.e(this, f344d.plus(new v.a(channelHandlerContext)), u0.UNDISPATCHED, new b(bVar, this, null));
    }

    public final void n(cl.b bVar) {
        if (dk.j.a(bVar.f21403a).isTraceEnabled()) {
            DecoderResult decoderResult = bVar.f1651g.f1653v.decoderResult();
            Throwable thCause = decoderResult == null ? null : decoderResult.cause();
            if (thCause == null) {
                return;
            }
            dk.j.a(bVar.f21403a).trace("Failed to decode request", thCause);
        }
    }

    public final Object o(cl.b bVar, um.d<? super l2> dVar) {
        n(bVar);
        cl.d dVar2 = bVar.f1652h;
        ik.r0.f8158c.getClass();
        dVar2.a(ik.r0.f8182x);
        vk.g gVar = bVar.f1652h.f1659s;
        j0 j0Var = j0.f8048a;
        j0Var.getClass();
        gVar.b(j0.f8080q, hi.b.f7118g, false);
        vk.g gVar2 = bVar.f1652h.f1659s;
        j0Var.getClass();
        gVar2.b(j0.f8072m, "close", false);
        bVar.f1652h.O(false, pl.k.f13204a.a());
        Object objK = bVar.k(dVar);
        return objK == wm.a.COROUTINE_SUSPENDED ? objK : l2.f10208a;
    }
}
