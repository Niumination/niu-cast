package io.netty.util.concurrent;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class DefaultFutureListeners {
    private GenericFutureListener<? extends Future<?>>[] listeners;
    private int progressiveSize;
    private int size = 2;

    public DefaultFutureListeners(GenericFutureListener<? extends Future<?>> genericFutureListener, GenericFutureListener<? extends Future<?>> genericFutureListener2) {
        this.listeners = new GenericFutureListener[]{genericFutureListener, genericFutureListener2};
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
        if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }

    public void add(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i10 = this.size;
        if (i10 == genericFutureListenerArr.length) {
            genericFutureListenerArr = (GenericFutureListener[]) Arrays.copyOf(genericFutureListenerArr, i10 << 1);
            this.listeners = genericFutureListenerArr;
        }
        genericFutureListenerArr[i10] = genericFutureListener;
        this.size = i10 + 1;
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }

    public GenericFutureListener<? extends Future<?>>[] listeners() {
        return this.listeners;
    }

    public int progressiveSize() {
        return this.progressiveSize;
    }

    public void remove(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (genericFutureListenerArr[i11] == genericFutureListener) {
                int i12 = (i10 - i11) - 1;
                if (i12 > 0) {
                    System.arraycopy(genericFutureListenerArr, i11 + 1, genericFutureListenerArr, i11, i12);
                }
                int i13 = i10 - 1;
                genericFutureListenerArr[i13] = null;
                this.size = i13;
                if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                    this.progressiveSize--;
                    return;
                }
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }
}
