package io.netty.util.internal.shaded.org.jctools.queues;

import h.a;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class MessagePassingQueueUtil {
    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, int i10) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException(a.a("limit is negative: ", i10));
        }
        int i11 = 0;
        if (i10 == 0) {
            return 0;
        }
        while (i11 < i10) {
            E eRelaxedPoll = messagePassingQueue.relaxedPoll();
            if (eRelaxedPoll == null) {
                break;
            }
            consumer.accept(eRelaxedPoll);
            i11++;
        }
        return i11;
    }

    public static <E> void fill(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (waitStrategy == null) {
            throw new IllegalArgumentException("waiter is null");
        }
        if (exitCondition == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
        while (true) {
            int iIdle = 0;
            while (exitCondition.keepRunning()) {
                if (messagePassingQueue.fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                    iIdle = waitStrategy.idle(iIdle);
                }
            }
            return;
        }
    }

    public static <E> int fillBounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, messagePassingQueue.capacity());
    }

    public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, int i10, int i11) {
        long j10 = 0;
        do {
            int iFill = messagePassingQueue.fill(supplier, i10);
            if (iFill == 0) {
                return (int) j10;
            }
            j10 += (long) iFill;
        } while (j10 <= i11);
        return (int) j10;
    }

    public static <E> int fillUnbounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
    }

    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        }
        int i10 = 0;
        while (true) {
            E eRelaxedPoll = messagePassingQueue.relaxedPoll();
            if (eRelaxedPoll == null) {
                return i10;
            }
            i10++;
            consumer.accept(eRelaxedPoll);
        }
    }

    public static <E> void drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        }
        if (waitStrategy == null) {
            throw new IllegalArgumentException("wait is null");
        }
        if (exitCondition == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
        while (true) {
            int iIdle = 0;
            while (exitCondition.keepRunning()) {
                E eRelaxedPoll = messagePassingQueue.relaxedPoll();
                if (eRelaxedPoll == null) {
                    iIdle = waitStrategy.idle(iIdle);
                } else {
                    consumer.accept(eRelaxedPoll);
                }
            }
            return;
        }
    }
}
