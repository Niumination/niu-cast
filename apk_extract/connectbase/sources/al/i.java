package al;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.l0;
import lm.d1;
import nq.l2;
import nq.r2;

/* JADX INFO: loaded from: classes2.dex */
@yk.v
public abstract class i extends yk.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f339f = AtomicIntegerFieldUpdater.newUpdater(i.class, "messageReleased");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ChannelHandlerContext f340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Object f341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final l2 f342e;

    @os.l
    private volatile /* synthetic */ int messageReleased;

    @xm.f(c = "io.ktor.server.netty.NettyApplicationCall", f = "NettyApplicationCall.kt", i = {0}, l = {47}, m = "finishSuspend", n = {"this"}, s = {"L$0"})
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
            return i.this.m(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@os.l dk.a aVar, @os.l ChannelHandlerContext channelHandlerContext, @os.l Object obj) {
        super(aVar);
        l0.p(aVar, n1.i.f11236l);
        l0.p(channelHandlerContext, "context");
        l0.p(obj, "requestMessage");
        this.f340c = channelHandlerContext;
        this.f341d = obj;
        this.f342e = r2.c(null, 1, null);
        this.messageReleased = 0;
    }

    public final void j() {
        p().A();
        o().l();
        r();
    }

    @os.m
    public final Object k(@os.l um.d<? super lm.l2> dVar) {
        try {
            p().B();
            if (this.f342e.isCompleted()) {
                l();
                return lm.l2.f10208a;
            }
            Object objM = m(dVar);
            return objM == wm.a.COROUTINE_SUSPENDED ? objM : lm.l2.f10208a;
        } catch (Throwable th2) {
            l();
            throw th2;
        }
    }

    public final void l() {
        l2.a.b(this.f342e, null, 1, null);
        o().l();
        r();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [al.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [al.i] */
    /* JADX WARN: Type inference failed for: r4v2, types: [al.i] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, lm.l2] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public final Object m(um.d<? super lm.l2> dVar) {
        a aVar;
        ?? r10;
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
            if (i11 == 0) {
                d1.n(obj);
                l2 l2Var = this.f342e;
                aVar.L$0 = this;
                aVar.label = 1;
                this = this;
                if (l2Var.t(aVar) == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i iVar = (i) aVar.L$0;
                d1.n(obj);
                r10 = iVar;
            }
            r10.l();
            this = lm.l2.f10208a;
            return this;
        } catch (Throwable th2) {
            this.l();
            throw th2;
        }
    }

    @os.l
    public final ChannelHandlerContext n() {
        return this.f340c;
    }

    @os.l
    public abstract n o();

    @os.l
    public abstract q p();

    @os.l
    public final l2 q() {
        return this.f342e;
    }

    public final void r() {
        if (f339f.compareAndSet(this, 0, 1)) {
            ReferenceCountUtil.release(this.f341d);
        }
    }
}
