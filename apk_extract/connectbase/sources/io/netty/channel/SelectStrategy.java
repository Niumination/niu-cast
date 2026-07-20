package io.netty.channel;

import io.netty.util.IntSupplier;

/* JADX INFO: loaded from: classes2.dex */
public interface SelectStrategy {
    public static final int BUSY_WAIT = -3;
    public static final int CONTINUE = -2;
    public static final int SELECT = -1;

    int calculateStrategy(IntSupplier intSupplier, boolean z10) throws Exception;
}
