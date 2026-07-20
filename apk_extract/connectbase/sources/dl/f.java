package dl;

import al.i;
import al.q;
import androidx.core.app.NotificationCompat;
import fl.t1;
import ik.r0;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import io.netty.handler.codec.http2.Http2Exception;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import kn.l0;
import lm.l2;
import nk.s;
import nm.z;
import os.l;
import os.m;
import vk.j;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends q {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public final h f3736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @l
    public final DefaultHttp2Headers f3737q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @l
    public final vk.g f3738r;

    public static final class a extends vk.g {
        public a() {
        }

        @Override // vk.g
        public void e(@l String str, @l String str2) {
            l0.p(str, "name");
            l0.p(str2, "value");
            f.this.f3737q.add(t1.e(str), str2);
        }

        @Override // vk.g
        @m
        public String f(@l String str) {
            l0.p(str, "name");
            CharSequence charSequence = f.this.f3737q.get(str);
            if (charSequence == null) {
                return null;
            }
            return charSequence.toString();
        }

        @Override // vk.g
        @l
        public List<String> g() {
            Set<CharSequence> setNames = f.this.f3737q.names();
            l0.o(setNames, "responseHeaders.names()");
            ArrayList arrayList = new ArrayList(z.b0(setNames, 10));
            Iterator<T> it = setNames.iterator();
            while (it.hasNext()) {
                arrayList.add(((CharSequence) it.next()).toString());
            }
            return arrayList;
        }

        @Override // vk.g
        @l
        public List<String> h(@l String str) {
            l0.p(str, "name");
            List<CharSequence> all = f.this.f3737q.getAll(str);
            l0.o(all, "responseHeaders.getAll(name)");
            List<CharSequence> list = all;
            ArrayList arrayList = new ArrayList(z.b0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CharSequence) it.next()).toString());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@l i iVar, @l h hVar, @l ChannelHandlerContext channelHandlerContext, @l um.g gVar, @l um.g gVar2) {
        super(iVar, channelHandlerContext, gVar, gVar2);
        l0.p(iVar, NotificationCompat.CATEGORY_CALL);
        l0.p(hVar, "handler");
        l0.p(channelHandlerContext, "context");
        l0.p(gVar, "engineContext");
        l0.p(gVar2, "userContext");
        this.f3736p = hVar;
        DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers();
        r0.f8158c.getClass();
        defaultHttp2Headers.status(String.valueOf(r0.f8165g.f8185a));
        this.f3737q = defaultHttp2Headers;
        this.f3738r = new a();
    }

    public static final void V(f fVar, vk.h hVar) throws ExecutionException, IllegalAccessException, InterruptedException, Http2Exception {
        l0.p(fVar, "this$0");
        l0.p(hVar, "$builder");
        fVar.f3736p.A(fVar.f382h, hVar);
    }

    @Override // al.q
    @l
    public Object M(boolean z10, boolean z11) {
        this.f3737q.remove("transfer-encoding");
        return new DefaultHttp2HeadersFrame(this.f3737q, z11);
    }

    @Override // al.q
    @l
    public Object N(boolean z10, @l byte[] bArr) {
        l0.p(bArr, "data");
        return M(false, bArr.length == 0);
    }

    @l
    public final h U() {
        return this.f3736p;
    }

    @Override // vk.a
    @l
    public vk.g b() {
        return this.f3738r;
    }

    @Override // yk.l, vk.a
    @j
    public void d(@l final vk.h hVar) {
        l0.p(hVar, "builder");
        this.f382h.executor().execute(new Runnable() { // from class: dl.e
            @Override // java.lang.Runnable
            public final void run() throws ExecutionException, IllegalAccessException, InterruptedException, Http2Exception {
                f.V(this.f3734a, hVar);
            }
        });
    }

    @Override // yk.l
    @m
    public Object t(@l s.c cVar, @l um.d<? super l2> dVar) {
        throw new UnsupportedOperationException("HTTP/2 doesn't support upgrade");
    }

    @Override // yk.l
    public void x(@l r0 r0Var) {
        l0.p(r0Var, "statusCode");
        this.f3737q.status(String.valueOf(r0Var.f8185a));
    }
}
