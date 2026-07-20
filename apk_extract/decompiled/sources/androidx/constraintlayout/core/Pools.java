package androidx.constraintlayout.core;

/* JADX INFO: loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    public interface Pool<T> {
        T acquire();

        boolean release(T t3);

        void releaseAll(T[] tArr, int i8);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i8) {
            if (i8 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i8];
        }

        private boolean isInPool(T t3) {
            for (int i8 = 0; i8 < this.mPoolSize; i8++) {
                if (this.mPool[i8] == t3) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public T acquire() {
            int i8 = this.mPoolSize;
            if (i8 <= 0) {
                return null;
            }
            int i9 = i8 - 1;
            Object[] objArr = this.mPool;
            T t3 = (T) objArr[i9];
            objArr[i9] = null;
            this.mPoolSize = i8 - 1;
            return t3;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T t3) {
            int i8 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i8 >= objArr.length) {
                return false;
            }
            objArr[i8] = t3;
            this.mPoolSize = i8 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] tArr, int i8) {
            if (i8 > tArr.length) {
                i8 = tArr.length;
            }
            for (int i9 = 0; i9 < i8; i9++) {
                T t3 = tArr[i9];
                int i10 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i10 < objArr.length) {
                    objArr[i10] = t3;
                    this.mPoolSize = i10 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
