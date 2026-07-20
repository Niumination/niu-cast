package dl;

import al.i;
import al.n;
import al.q;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Headers;
import kn.l0;
import os.l;
import yk.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final Http2Headers f3726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public final d f3727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final f f3728i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@l dk.a aVar, @l ChannelHandlerContext channelHandlerContext, @l Http2Headers http2Headers, @l h hVar, @l um.g gVar, @l um.g gVar2) {
        super(aVar, channelHandlerContext, http2Headers);
        l0.p(aVar, n1.i.f11236l);
        l0.p(channelHandlerContext, "context");
        l0.p(http2Headers, "headers");
        l0.p(hVar, "handler");
        l0.p(gVar, "engineContext");
        l0.p(gVar2, "userContext");
        this.f3726g = http2Headers;
        this.f3727h = new d(this, gVar, channelHandlerContext, http2Headers, null, 16, null);
        this.f3728i = new f(this, hVar, channelHandlerContext, gVar, gVar2);
        yk.h.h(this, null, 1, null);
    }

    @Override // yk.h
    public k b() {
        return this.f3727h;
    }

    @Override // dk.b
    public uk.d d() {
        return this.f3727h;
    }

    @Override // dk.b
    public vk.a e() {
        return this.f3728i;
    }

    @Override // yk.h
    public yk.l f() {
        return this.f3728i;
    }

    @Override // al.i
    public n o() {
        return this.f3727h;
    }

    @Override // al.i
    public q p() {
        return this.f3728i;
    }

    @l
    public final Http2Headers s() {
        return this.f3726g;
    }

    @l
    public d t() {
        return this.f3727h;
    }

    @l
    public f u() {
        return this.f3728i;
    }
}
