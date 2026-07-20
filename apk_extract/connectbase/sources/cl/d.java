package cl;

import al.i;
import al.q;
import al.t;
import al.v;
import androidx.core.app.NotificationCompat;
import ik.r0;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kn.l0;
import kn.n0;
import lm.d1;
import lm.l2;
import nk.s;
import nm.k0;
import nm.r;
import nm.z;
import os.l;
import os.m;
import pl.k;
import pl.o;
import vk.g;
import xm.f;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends q {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public final HttpVersion f1656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @l
    public HttpResponseStatus f1657q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @l
    public final DefaultHttpHeaders f1658r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @l
    public final g f1659s;

    public static final class a extends g {
        public a() {
        }

        @Override // vk.g
        public void e(@l String str, @l String str2) {
            l0.p(str, "name");
            l0.p(str2, "value");
            if (!d.this.G()) {
                d.this.f1658r.add(str, (Object) str2);
            } else {
                if (!d.this.f385k.isCancelled()) {
                    throw new UnsupportedOperationException("Headers can no longer be set because response was already completed");
                }
                throw new CancellationException("Call execution has been cancelled");
            }
        }

        @Override // vk.g
        @m
        public String f(@l String str) {
            l0.p(str, "name");
            return d.this.f1658r.get(str);
        }

        @Override // vk.g
        @l
        public List<String> g() {
            DefaultHttpHeaders defaultHttpHeaders = d.this.f1658r;
            ArrayList arrayList = new ArrayList(z.b0(defaultHttpHeaders, 10));
            Iterator<Map.Entry<String, String>> it = defaultHttpHeaders.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getKey());
            }
            return arrayList;
        }

        @Override // vk.g
        @l
        public List<String> h(@l String str) {
            l0.p(str, "name");
            List<String> all = d.this.f1658r.getAll(str);
            return all == null ? k0.INSTANCE : all;
        }
    }

    @f(c = "io.ktor.server.netty.http1.NettyHttp1ApplicationResponse", f = "NettyHttp1ApplicationResponse.kt", i = {0, 0, 0, 0, 1, 1, 2}, l = {100, 108, 109}, m = "respondUpgrade", n = {"this", "bodyHandler", "upgradedReadChannel", "upgradedWriteChannel", "this", "job", "this"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0"})
    public static final class b extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.t(null, this);
        }
    }

    public static final class c extends n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ bl.d $bodyHandler;
        final /* synthetic */ k $upgradedReadChannel;
        final /* synthetic */ pl.c $upgradedWriteChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(pl.c cVar, bl.d dVar, k kVar) {
            super(1);
            this.$upgradedWriteChannel = cVar;
            this.$bodyHandler = dVar;
            this.$upgradedReadChannel = kVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Throwable th2) {
            o.a(this.$upgradedWriteChannel);
            this.$bodyHandler.close();
            pl.m.a(this.$upgradedReadChannel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@l i iVar, @l ChannelHandlerContext channelHandlerContext, @l um.g gVar, @l um.g gVar2, @l HttpVersion httpVersion) {
        super(iVar, channelHandlerContext, gVar, gVar2);
        l0.p(iVar, NotificationCompat.CATEGORY_CALL);
        l0.p(channelHandlerContext, "context");
        l0.p(gVar, "engineContext");
        l0.p(gVar2, "userContext");
        l0.p(httpVersion, "protocol");
        this.f1656p = httpVersion;
        HttpResponseStatus httpResponseStatus = HttpResponseStatus.OK;
        l0.o(httpResponseStatus, "OK");
        this.f1657q = httpResponseStatus;
        this.f1658r = new DefaultHttpHeaders();
        this.f1659s = new a();
    }

    @Override // al.q
    @l
    public Object M(boolean z10, boolean z11) {
        DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(this.f1656p, this.f1657q, this.f1658r);
        if (z10) {
            V(defaultHttpResponse);
        }
        return defaultHttpResponse;
    }

    @Override // al.q
    @l
    public Object N(boolean z10, @l byte[] bArr) {
        l0.p(bArr, "data");
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(this.f1656p, this.f1657q, Unpooled.wrappedBuffer(bArr), this.f1658r, EmptyHttpHeaders.INSTANCE);
        if (z10) {
            V(defaultFullHttpResponse);
        }
        return defaultFullHttpResponse;
    }

    @l
    public final HttpVersion U() {
        return this.f1656p;
    }

    public final void V(HttpResponse httpResponse) {
        int iCode = httpResponse.status().code();
        r0.f8158c.getClass();
        if (iCode != r0.f8162e.f8185a) {
            HttpUtil.setTransferEncodingChunked(httpResponse, true);
        }
    }

    @Override // vk.a
    @l
    public g b() {
        return this.f1659s;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00f7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // yk.l
    @m
    public Object t(@l s.c cVar, @l um.d<? super l2> dVar) {
        b bVar;
        k kVarU0;
        pl.c cVar2;
        bl.d dVar2;
        d dVar3;
        nq.l2 l2Var;
        d dVar4;
        d dVar5 = this;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = dVar5.new b(dVar);
            }
        } else {
            bVar = dVar5.new b(dVar);
        }
        Object obj = bVar.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                pl.c cVar3 = (pl.c) bVar.L$3;
                k kVar = (k) bVar.L$2;
                dVar2 = (bl.d) bVar.L$1;
                d dVar6 = (d) bVar.L$0;
                d1.n(obj);
                kVarU0 = kVar;
                cVar2 = cVar3;
                dVar5 = dVar6;
            } else if (i11 == 2) {
                l2Var = (nq.l2) bVar.L$1;
                dVar3 = (d) bVar.L$0;
                d1.n(obj);
                bVar.L$0 = dVar3;
                bVar.L$1 = null;
                bVar.label = 3;
                if (l2Var.t(bVar) == obj2) {
                    return obj2;
                }
                dVar4 = dVar3;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                dVar4 = (d) bVar.L$0;
                d1.n(obj);
            }
            dVar4.f382h.channel().close();
            return l2.f10208a;
        }
        d1.n(obj);
        ChannelHandlerContext channelHandlerContext = dVar5.f382h;
        Channel channel = channelHandlerContext.channel();
        um.g gVarPlus = dVar5.f384j.plus(new v.a(channelHandlerContext));
        bl.d dVar7 = (bl.d) channelHandlerContext.pipeline().get(bl.d.class);
        kVarU0 = dVar7.u0();
        pl.c cVarC = pl.e.c(false, 1, null);
        dVar5.O(false, cVarC);
        ChannelPipeline channelPipelinePipeline = channel.pipeline();
        if (channelPipelinePipeline.get(e.class) == null) {
            z();
            CancellationException cancellationException = new CancellationException("HTTP upgrade has been cancelled");
            cVarC.c(cancellationException);
            dVar7.close();
            throw cancellationException;
        }
        channelPipelinePipeline.remove(e.class);
        channelPipelinePipeline.addFirst(new t());
        um.g gVar = dVar5.f383i;
        bVar.L$0 = dVar5;
        bVar.L$1 = dVar7;
        bVar.L$2 = kVarU0;
        bVar.L$3 = cVarC;
        bVar.label = 1;
        cVar2 = cVarC;
        Object objJ = cVar.j(kVarU0, cVarC, gVar, gVarPlus, bVar);
        if (objJ == obj2) {
            return obj2;
        }
        dVar2 = dVar7;
        obj = objJ;
        nq.l2 l2Var2 = (nq.l2) obj;
        l2Var2.k0(new c(cVar2, dVar2, kVarU0));
        nq.l2 l2Var3 = ((i) dVar5.f21422a).f342e;
        bVar.L$0 = dVar5;
        bVar.L$1 = l2Var2;
        bVar.L$2 = null;
        bVar.L$3 = null;
        bVar.label = 2;
        if (l2Var3.t(bVar) == obj2) {
            return obj2;
        }
        dVar3 = dVar5;
        l2Var = l2Var2;
        bVar.L$0 = dVar3;
        bVar.L$1 = null;
        bVar.label = 3;
        if (l2Var.t(bVar) == obj2) {
            return obj2;
        }
        dVar4 = dVar3;
        dVar4.f382h.channel().close();
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    @Override // yk.l
    public void x(@l r0 r0Var) {
        HttpResponseStatus httpResponseStatus;
        l0.p(r0Var, "statusCode");
        int i10 = r0Var.f8185a;
        HttpResponseStatus httpResponseStatus2 = null;
        if (1 <= i10) {
            q.a aVar = q.f379m;
            aVar.getClass();
            if (i10 <= r.we(q.f381o)) {
                aVar.getClass();
                httpResponseStatus = q.f381o[i10];
            } else {
                httpResponseStatus = null;
            }
        } else {
            httpResponseStatus = null;
        }
        if (httpResponseStatus != null && l0.g(httpResponseStatus.reasonPhrase(), r0Var.f8186b)) {
            httpResponseStatus2 = httpResponseStatus;
        }
        if (httpResponseStatus2 == null) {
            httpResponseStatus2 = new HttpResponseStatus(r0Var.f8185a, r0Var.f8186b);
        }
        this.f1657q = httpResponseStatus2;
    }
}
