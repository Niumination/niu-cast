package al;

import io.netty.channel.ChannelHandlerContext;
import kn.l0;
import nq.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final v f403a = new v();

    public static final class a extends um.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ChannelHandlerContext f404a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l ChannelHandlerContext channelHandlerContext) {
            super(b.f405a);
            l0.p(channelHandlerContext, "context");
            this.f404a = channelHandlerContext;
        }

        @os.l
        public final ChannelHandlerContext f0() {
            return this.f404a;
        }
    }

    public static final class b implements um.g.c<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final b f405a = new b();
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        l0.p(gVar, "context");
        l0.p(runnable, "block");
        um.g.b bVar = gVar.get(b.f405a);
        l0.m(bVar);
        ((a) bVar).f404a.executor().execute(runnable);
    }

    @Override // nq.n0
    public boolean isDispatchNeeded(@os.l um.g gVar) {
        l0.p(gVar, "context");
        um.g.b bVar = gVar.get(b.f405a);
        l0.m(bVar);
        return !((a) bVar).f404a.executor().inEventLoop();
    }
}
