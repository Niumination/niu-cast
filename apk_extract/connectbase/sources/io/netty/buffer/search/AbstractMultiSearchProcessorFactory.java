package io.netty.buffer.search;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMultiSearchProcessorFactory implements MultiSearchProcessorFactory {
    public static AhoCorasicSearchProcessorFactory newAhoCorasicSearchProcessorFactory(byte[]... bArr) {
        return new AhoCorasicSearchProcessorFactory(bArr);
    }
}
