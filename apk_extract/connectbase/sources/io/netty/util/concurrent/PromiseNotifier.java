package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PromiseNotifier.class);
    private final boolean logNotifyFailure;
    private final Promise<? super V>[] promises;

    @SafeVarargs
    public PromiseNotifier(Promise<? super V>... promiseArr) {
        this(true, promiseArr);
    }

    public static <V, F extends Future<V>> F cascade(F f10, Promise<? super V> promise) {
        return (F) cascade(true, f10, promise);
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(F f10) throws Exception {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        int i10 = 0;
        if (f10.isSuccess()) {
            Object obj = f10.get();
            Promise<? super V>[] promiseArr = this.promises;
            int length = promiseArr.length;
            while (i10 < length) {
                PromiseNotificationUtil.trySuccess(promiseArr[i10], obj, internalLogger);
                i10++;
            }
            return;
        }
        if (f10.isCancelled()) {
            Promise<? super V>[] promiseArr2 = this.promises;
            int length2 = promiseArr2.length;
            while (i10 < length2) {
                PromiseNotificationUtil.tryCancel(promiseArr2[i10], internalLogger);
                i10++;
            }
            return;
        }
        Throwable thCause = f10.cause();
        Promise<? super V>[] promiseArr3 = this.promises;
        int length3 = promiseArr3.length;
        while (i10 < length3) {
            PromiseNotificationUtil.tryFailure(promiseArr3[i10], thCause, internalLogger);
            i10++;
        }
    }

    @SafeVarargs
    public PromiseNotifier(boolean z10, Promise<? super V>... promiseArr) {
        ObjectUtil.checkNotNull(promiseArr, "promises");
        for (Promise<? super V> promise : promiseArr) {
            ObjectUtil.checkNotNullWithIAE(promise, "promise");
        }
        this.promises = (Promise[]) promiseArr.clone();
        this.logNotifyFailure = z10;
    }

    public static <V, F extends Future<V>> F cascade(boolean z10, final F f10, final Promise<? super V> promise) {
        promise.addListener((GenericFutureListener<? extends Future<? super Object>>) new FutureListener() { // from class: io.netty.util.concurrent.PromiseNotifier.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future) {
                if (future.isCancelled()) {
                    f10.cancel(false);
                }
            }
        });
        f10.addListener(new PromiseNotifier(z10, new Promise[]{promise}) { // from class: io.netty.util.concurrent.PromiseNotifier.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.netty.util.concurrent.PromiseNotifier, io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future) throws Exception {
                if (promise.isCancelled() && future.isCancelled()) {
                    return;
                }
                super.operationComplete(f10);
            }
        });
        return f10;
    }
}
