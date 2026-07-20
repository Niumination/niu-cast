package al;

import androidx.core.app.NotificationCompat;
import fl.t0;
import ik.b1;
import ik.z1;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import lm.l2;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class n extends yk.k implements s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final um.g f366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final ChannelHandlerContext f367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final pl.k f368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final String f369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f370g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final b1 f371i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final uk.h f372n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final d0<w> f373p;

    public static final class a extends n0 implements jn.a<w> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final w invoke() throws IOException {
            if (!uk.e.t(n.this)) {
                throw new IOException("The request content is not multipart encoded");
            }
            HttpPostMultipartRequestDecoder httpPostMultipartRequestDecoderP = n.this.p();
            ByteBufAllocator byteBufAllocatorAlloc = n.this.f367d.alloc();
            l0.o(byteBufAllocatorAlloc, "context.alloc()");
            return new w(httpPostMultipartRequestDecoderP, byteBufAllocatorAlloc, n.this.f368e);
        }
    }

    public static final class b implements b1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final QueryStringDecoder f374d;

        public b() {
            this.f374d = new QueryStringDecoder(n.this.f369f, HttpConstants.DEFAULT_CHARSET, true, 1024, true);
        }

        @Override // fl.o1
        public boolean a() {
            return true;
        }

        @Override // fl.o1
        @os.m
        public List<String> b(@os.l String str) {
            l0.p(str, "name");
            return this.f374d.parameters().get(str);
        }

        @Override // ik.b1
        @os.l
        public z1 c() {
            return b1.b.e(this);
        }

        @Override // fl.o1
        public boolean contains(@os.l String str) {
            return b1.b.a(this, str);
        }

        @Override // fl.o1
        public boolean d(@os.l String str, @os.l String str2) {
            return b1.b.b(this, str, str2);
        }

        @Override // fl.o1
        public void e(@os.l jn.p<? super String, ? super List<String>, l2> pVar) {
            b1.b.c(this, pVar);
        }

        @Override // fl.o1
        @os.l
        public Set<Map.Entry<String, List<String>>> entries() {
            return this.f374d.parameters().entrySet();
        }

        @Override // fl.o1
        @os.m
        public String get(@os.l String str) {
            return b1.b.d(this, str);
        }

        @Override // fl.o1
        public boolean isEmpty() {
            return this.f374d.parameters().isEmpty();
        }

        @Override // fl.o1
        @os.l
        public Set<String> names() {
            return this.f374d.parameters().keySet();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@os.l dk.b bVar, @os.l um.g gVar, @os.l ChannelHandlerContext channelHandlerContext, @os.l pl.k kVar, @os.l String str, boolean z10) {
        super(bVar);
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        l0.p(gVar, "coroutineContext");
        l0.p(channelHandlerContext, "context");
        l0.p(kVar, "requestBodyChannel");
        l0.p(str, "uri");
        this.f366c = gVar;
        this.f367d = channelHandlerContext;
        this.f368e = kVar;
        this.f369f = str;
        this.f370g = z10;
        this.f371i = new b();
        this.f372n = new o(this);
        this.f373p = f0.b(new a());
    }

    @Override // uk.d
    @os.l
    public uk.h e() {
        return this.f372n;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f366c;
    }

    @Override // uk.d
    @os.l
    public pl.k i() {
        return this.f368e;
    }

    @Override // uk.d
    @os.l
    public final b1 j() {
        return this.f371i;
    }

    public final void l() {
        if (this.f373p.isInitialized()) {
            this.f373p.getValue().f();
        }
    }

    @os.l
    public final ChannelHandlerContext m() {
        return this.f367d;
    }

    public final boolean n() {
        return this.f370g;
    }

    @os.l
    public final String o() {
        return this.f369f;
    }

    @os.l
    public abstract HttpPostMultipartRequestDecoder p();
}
