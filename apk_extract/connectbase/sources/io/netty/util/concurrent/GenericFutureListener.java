package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import java.util.EventListener;

/* JADX INFO: loaded from: classes3.dex */
public interface GenericFutureListener<F extends Future<?>> extends EventListener {
    void operationComplete(F f10) throws Exception;
}
