package cl;

import al.n;
import al.p;
import androidx.core.app.NotificationCompat;
import ik.b0;
import ik.l1;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder;
import kn.l0;
import os.l;
import pl.k;
import um.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends n {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public final HttpRequest f1653v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public final a f1654w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @l
    public final b0 f1655x;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(@l dk.b bVar, @l g gVar, @l ChannelHandlerContext channelHandlerContext, @l HttpRequest httpRequest, @l k kVar) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        l0.p(gVar, "coroutineContext");
        l0.p(channelHandlerContext, "context");
        l0.p(httpRequest, "httpRequest");
        l0.p(kVar, "requestBodyChannel");
        String strUri = httpRequest.uri();
        l0.o(strUri, "httpRequest.uri()");
        super(bVar, gVar, channelHandlerContext, kVar, strUri, HttpUtil.isKeepAlive(httpRequest));
        this.f1653v = httpRequest;
        this.f1654w = new a(httpRequest, channelHandlerContext);
        this.f1655x = new p(httpRequest);
    }

    @Override // uk.d
    @l
    public b0 b() {
        return this.f1655x;
    }

    @Override // uk.d
    public l1 g() {
        return this.f1654w;
    }

    @Override // al.n
    @l
    public HttpPostMultipartRequestDecoder p() {
        return new HttpPostMultipartRequestDecoder(this.f1653v);
    }

    @l
    public final HttpRequest r() {
        return this.f1653v;
    }

    @l
    public a s() {
        return this.f1654w;
    }
}
