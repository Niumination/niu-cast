package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AddressResolverGroup<T extends SocketAddress> implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AddressResolverGroup.class);
    private final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap();
    private final Map<EventExecutor, GenericFutureListener<Future<Object>>> executorTerminationListeners = new IdentityHashMap();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i10;
        AddressResolver[] addressResolverArr;
        Map.Entry[] entryArr;
        synchronized (this.resolvers) {
            addressResolverArr = (AddressResolver[]) this.resolvers.values().toArray(new AddressResolver[0]);
            this.resolvers.clear();
            entryArr = (Map.Entry[]) this.executorTerminationListeners.entrySet().toArray(new Map.Entry[0]);
            this.executorTerminationListeners.clear();
        }
        for (Map.Entry entry : entryArr) {
            ((EventExecutor) entry.getKey()).terminationFuture().removeListener((GenericFutureListener) entry.getValue());
        }
        for (AddressResolver addressResolver : addressResolverArr) {
            try {
                addressResolver.close();
            } catch (Throwable th2) {
                logger.warn("Failed to close a resolver:", th2);
            }
        }
    }

    public AddressResolver<T> getResolver(final EventExecutor eventExecutor) {
        final AddressResolver<T> addressResolverNewResolver;
        ObjectUtil.checkNotNull(eventExecutor, "executor");
        if (eventExecutor.isShuttingDown()) {
            throw new IllegalStateException("executor not accepting a task");
        }
        synchronized (this.resolvers) {
            try {
                addressResolverNewResolver = this.resolvers.get(eventExecutor);
                if (addressResolverNewResolver == null) {
                    try {
                        addressResolverNewResolver = newResolver(eventExecutor);
                        this.resolvers.put(eventExecutor, addressResolverNewResolver);
                        FutureListener<Object> futureListener = new FutureListener<Object>() { // from class: io.netty.resolver.AddressResolverGroup.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(Future<Object> future) {
                                synchronized (AddressResolverGroup.this.resolvers) {
                                    AddressResolverGroup.this.resolvers.remove(eventExecutor);
                                    AddressResolverGroup.this.executorTerminationListeners.remove(eventExecutor);
                                }
                                addressResolverNewResolver.close();
                            }
                        };
                        this.executorTerminationListeners.put(eventExecutor, futureListener);
                        eventExecutor.terminationFuture().addListener(futureListener);
                    } catch (Exception e10) {
                        throw new IllegalStateException("failed to create a new resolver", e10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return addressResolverNewResolver;
    }

    public abstract AddressResolver<T> newResolver(EventExecutor eventExecutor) throws Exception;
}
