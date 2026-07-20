package cl;

import al.i;
import al.n;
import al.q;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpVersion;
import kn.l0;
import os.l;
import pl.k;
import um.g;
import yk.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final c f1651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public final d f1652h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@l dk.a aVar, @l ChannelHandlerContext channelHandlerContext, @l HttpRequest httpRequest, @l k kVar, @l g gVar, @l g gVar2) {
        super(aVar, channelHandlerContext, httpRequest);
        l0.p(aVar, n1.i.f11236l);
        l0.p(channelHandlerContext, "context");
        l0.p(httpRequest, "httpRequest");
        l0.p(kVar, "requestBodyChannel");
        l0.p(gVar, "engineContext");
        l0.p(gVar2, "userContext");
        this.f1651g = new c(this, gVar, channelHandlerContext, httpRequest, kVar);
        HttpVersion httpVersionProtocolVersion = httpRequest.protocolVersion();
        l0.o(httpVersionProtocolVersion, "httpRequest.protocolVersion()");
        this.f1652h = new d(this, channelHandlerContext, gVar, gVar2, httpVersionProtocolVersion);
        h.h(this, null, 1, null);
    }

    @Override // yk.h
    public yk.k b() {
        return this.f1651g;
    }

    @Override // dk.b
    public uk.d d() {
        return this.f1651g;
    }

    @Override // dk.b
    public vk.a e() {
        return this.f1652h;
    }

    @Override // yk.h
    public yk.l f() {
        return this.f1652h;
    }

    @Override // al.i
    public n o() {
        return this.f1651g;
    }

    @Override // al.i
    public q p() {
        return this.f1652h;
    }

    @l
    public c s() {
        return this.f1651g;
    }

    @l
    public d t() {
        return this.f1652h;
    }
}
