package io.netty.handler.ssl;

/* JADX INFO: loaded from: classes3.dex */
interface OpenSslEngineMap {
    void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine);

    ReferenceCountedOpenSslEngine get(long j10);

    ReferenceCountedOpenSslEngine remove(long j10);
}
