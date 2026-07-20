package io.netty.util.internal;

import io.netty.util.Recycler;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ObjectPool<T> {

    public interface Handle<T> {
        void recycle(T t10);
    }

    public interface ObjectCreator<T> {
        T newObject(Handle<T> handle);
    }

    public static final class RecyclerObjectPool<T> extends ObjectPool<T> {
        private final Recycler<T> recycler;

        public RecyclerObjectPool(final ObjectCreator<T> objectCreator) {
            this.recycler = new Recycler<T>() { // from class: io.netty.util.internal.ObjectPool.RecyclerObjectPool.1
                @Override // io.netty.util.Recycler
                public T newObject(Recycler.Handle<T> handle) {
                    return (T) objectCreator.newObject(handle);
                }
            };
        }

        @Override // io.netty.util.internal.ObjectPool
        public T get() {
            return this.recycler.get();
        }
    }

    public static <T> ObjectPool<T> newPool(ObjectCreator<T> objectCreator) {
        return new RecyclerObjectPool((ObjectCreator) ObjectUtil.checkNotNull(objectCreator, "creator"));
    }

    public abstract T get();
}
