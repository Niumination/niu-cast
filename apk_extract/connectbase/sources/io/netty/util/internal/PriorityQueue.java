package io.netty.util.internal;

import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public interface PriorityQueue<T> extends Queue<T> {
    void clearIgnoringIndexes();

    boolean containsTyped(T t10);

    void priorityChanged(T t10);

    boolean removeTyped(T t10);
}
