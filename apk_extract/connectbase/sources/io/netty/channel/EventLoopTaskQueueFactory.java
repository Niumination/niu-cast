package io.netty.channel;

import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public interface EventLoopTaskQueueFactory {
    Queue<Runnable> newTaskQueue(int i10);
}
