package io.netty.channel.pool;

import cb.b;
import io.netty.channel.pool.ChannelPool;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractChannelPoolMap<K, P extends ChannelPool> implements ChannelPoolMap<K, P>, Iterable<Map.Entry<K, P>>, Closeable {
    private final ConcurrentMap<K, P> map = PlatformDependent.newConcurrentHashMap();

    private static Future<Void> poolCloseAsyncIfSupported(ChannelPool channelPool) {
        if (channelPool instanceof SimpleChannelPool) {
            return ((SimpleChannelPool) channelPool).closeAsync();
        }
        try {
            channelPool.close();
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
        } catch (Exception e10) {
            return GlobalEventExecutor.INSTANCE.newFailedFuture(e10);
        }
    }

    private Future<Boolean> removeAsyncIfSupported(K k10) {
        P pRemove = this.map.remove(ObjectUtil.checkNotNull(k10, b.c.f1408o));
        if (pRemove == null) {
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(Boolean.FALSE);
        }
        final Promise promiseNewPromise = GlobalEventExecutor.INSTANCE.newPromise();
        poolCloseAsyncIfSupported(pRemove).addListener(new GenericFutureListener<Future<? super Void>>() { // from class: io.netty.channel.pool.AbstractChannelPoolMap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    promiseNewPromise.setSuccess(Boolean.TRUE);
                } else {
                    promiseNewPromise.setFailure(future.cause());
                }
            }
        });
        return promiseNewPromise;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Iterator<K> it = this.map.keySet().iterator();
        while (it.hasNext()) {
            removeAsyncIfSupported(it.next()).syncUninterruptibly();
        }
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final boolean contains(K k10) {
        return this.map.containsKey(ObjectUtil.checkNotNull(k10, b.c.f1408o));
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final P get(K k10) {
        P p10 = this.map.get(ObjectUtil.checkNotNull(k10, b.c.f1408o));
        if (p10 != null) {
            return p10;
        }
        P p11 = (P) newPool(k10);
        P pPutIfAbsent = this.map.putIfAbsent(k10, p11);
        if (pPutIfAbsent == null) {
            return p11;
        }
        poolCloseAsyncIfSupported(p11);
        return pPutIfAbsent;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, P>> iterator() {
        return new ReadOnlyIterator(this.map.entrySet().iterator());
    }

    public abstract P newPool(K k10);

    public final boolean remove(K k10) {
        P pRemove = this.map.remove(ObjectUtil.checkNotNull(k10, b.c.f1408o));
        if (pRemove == null) {
            return false;
        }
        poolCloseAsyncIfSupported(pRemove);
        return true;
    }

    public final int size() {
        return this.map.size();
    }
}
