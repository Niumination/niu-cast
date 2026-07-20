package io.netty.channel;

import io.netty.util.IntSupplier;

/* JADX INFO: loaded from: classes2.dex */
final class DefaultSelectStrategy implements SelectStrategy {
    static final SelectStrategy INSTANCE = new DefaultSelectStrategy();

    private DefaultSelectStrategy() {
    }

    @Override // io.netty.channel.SelectStrategy
    public int calculateStrategy(IntSupplier intSupplier, boolean z10) throws Exception {
        if (z10) {
            return intSupplier.get();
        }
        return -1;
    }
}
