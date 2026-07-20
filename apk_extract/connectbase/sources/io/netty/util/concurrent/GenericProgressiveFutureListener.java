package io.netty.util.concurrent;

import io.netty.util.concurrent.ProgressiveFuture;

/* JADX INFO: loaded from: classes3.dex */
public interface GenericProgressiveFutureListener<F extends ProgressiveFuture<?>> extends GenericFutureListener<F> {
    void operationProgressed(F f10, long j10, long j11) throws Exception;
}
