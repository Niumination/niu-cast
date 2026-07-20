package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OpenSslContext extends ReferenceCountedOpenSslContext {
    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, int i10, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z10, boolean z11, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        super(iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), i10, certificateArr, clientAuth, strArr, z10, z11, false, entryArr);
    }

    public final void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public final SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10) {
        return new OpenSslEngine(this, byteBufAllocator, str, i10, z10);
    }

    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, int i10, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z10, boolean z11, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, i10, certificateArr, clientAuth, strArr, z10, z11, false, entryArr);
    }
}
