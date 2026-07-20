package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DelegatingSslContext extends SslContext {
    private final SslContext ctx;

    public DelegatingSslContext(SslContext sslContext) {
        this.ctx = (SslContext) ObjectUtil.checkNotNull(sslContext, "ctx");
    }

    @Override // io.netty.handler.ssl.SslContext
    public final ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.ctx.applicationProtocolNegotiator();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.ctx.cipherSuites();
    }

    public abstract void initEngine(SSLEngine sSLEngine);

    public void initHandler(SslHandler sslHandler) {
        initEngine(sslHandler.engine());
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.ctx.isClient();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        SSLEngine sSLEngineNewEngine = this.ctx.newEngine(byteBufAllocator);
        initEngine(sSLEngineNewEngine);
        return sSLEngineNewEngine;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z10) {
        SslHandler sslHandlerNewHandler = this.ctx.newHandler(byteBufAllocator, z10);
        initHandler(sslHandlerNewHandler);
        return sslHandlerNewHandler;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionCacheSize() {
        return this.ctx.sessionCacheSize();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLSessionContext sessionContext() {
        return this.ctx.sessionContext();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionTimeout() {
        return this.ctx.sessionTimeout();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i10) {
        SSLEngine sSLEngineNewEngine = this.ctx.newEngine(byteBufAllocator, str, i10);
        initEngine(sSLEngineNewEngine);
        return sSLEngineNewEngine;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10) {
        SslHandler sslHandlerNewHandler = this.ctx.newHandler(byteBufAllocator, str, i10, z10);
        initHandler(sslHandlerNewHandler);
        return sslHandlerNewHandler;
    }

    @Override // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z10, Executor executor) {
        SslHandler sslHandlerNewHandler = this.ctx.newHandler(byteBufAllocator, z10, executor);
        initHandler(sslHandlerNewHandler);
        return sslHandlerNewHandler;
    }

    @Override // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10, Executor executor) {
        SslHandler sslHandlerNewHandler = this.ctx.newHandler(byteBufAllocator, str, i10, z10, executor);
        initHandler(sslHandlerNewHandler);
        return sslHandlerNewHandler;
    }
}
