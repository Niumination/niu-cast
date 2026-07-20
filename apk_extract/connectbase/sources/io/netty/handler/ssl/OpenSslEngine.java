package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

/* JADX INFO: loaded from: classes3.dex */
public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    public OpenSslEngine(OpenSslContext openSslContext, ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10) {
        super(openSslContext, byteBufAllocator, str, i10, z10, false);
    }

    public void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
