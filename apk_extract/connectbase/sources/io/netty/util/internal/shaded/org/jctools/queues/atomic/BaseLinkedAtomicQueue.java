package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import h.a;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseLinkedAtomicQueue<E> extends BaseLinkedAtomicQueuePad2<E> {
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i10) {
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
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLpConsumerNode = lpConsumerNode();
        while (i11 < i10) {
            LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvNext = linkedQueueAtomicNodeLpConsumerNode.lvNext();
            if (linkedQueueAtomicNodeLvNext == null) {
                return i11;
            }
            consumer.accept(getSingleConsumerNodeValue(linkedQueueAtomicNodeLpConsumerNode, linkedQueueAtomicNodeLvNext));
            i11++;
            linkedQueueAtomicNodeLpConsumerNode = linkedQueueAtomicNodeLvNext;
        }
        return i10;
    }

    public E getSingleConsumerNodeValue(LinkedQueueAtomicNode<E> linkedQueueAtomicNode, LinkedQueueAtomicNode<E> linkedQueueAtomicNode2) {
        E andNullValue = linkedQueueAtomicNode2.getAndNullValue();
        linkedQueueAtomicNode.soNext(linkedQueueAtomicNode);
        spConsumerNode(linkedQueueAtomicNode2);
        return andNullValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final LinkedQueueAtomicNode<E> newNode() {
        return new LinkedQueueAtomicNode<>();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvNext = linkedQueueAtomicNodeLpConsumerNode.lvNext();
        if (linkedQueueAtomicNodeLvNext != null) {
            return linkedQueueAtomicNodeLvNext.lpValue();
        }
        if (linkedQueueAtomicNodeLpConsumerNode != lvProducerNode()) {
            return spinWaitForNextNode(linkedQueueAtomicNodeLpConsumerNode).lpValue();
        }
        return null;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvNext = linkedQueueAtomicNodeLpConsumerNode.lvNext();
        if (linkedQueueAtomicNodeLvNext != null) {
            return getSingleConsumerNodeValue(linkedQueueAtomicNodeLpConsumerNode, linkedQueueAtomicNodeLvNext);
        }
        if (linkedQueueAtomicNodeLpConsumerNode != lvProducerNode()) {
            return getSingleConsumerNodeValue(linkedQueueAtomicNodeLpConsumerNode, spinWaitForNextNode(linkedQueueAtomicNodeLpConsumerNode));
        }
        return null;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e10) {
        return offer(e10);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvNext = lpConsumerNode().lvNext();
        if (linkedQueueAtomicNodeLvNext != null) {
            return linkedQueueAtomicNodeLvNext.lpValue();
        }
        return null;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvNext = linkedQueueAtomicNodeLpConsumerNode.lvNext();
        if (linkedQueueAtomicNodeLvNext != null) {
            return getSingleConsumerNodeValue(linkedQueueAtomicNodeLpConsumerNode, linkedQueueAtomicNodeLvNext);
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvConsumerNode = lvConsumerNode();
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvProducerNode = lvProducerNode();
        int i10 = 0;
        while (linkedQueueAtomicNodeLvConsumerNode != linkedQueueAtomicNodeLvProducerNode && linkedQueueAtomicNodeLvConsumerNode != null && i10 < Integer.MAX_VALUE) {
            LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvNext = linkedQueueAtomicNodeLvConsumerNode.lvNext();
            if (linkedQueueAtomicNodeLvNext == linkedQueueAtomicNodeLvConsumerNode) {
                return i10;
            }
            i10++;
            linkedQueueAtomicNodeLvConsumerNode = linkedQueueAtomicNodeLvNext;
        }
        return i10;
    }

    public LinkedQueueAtomicNode<E> spinWaitForNextNode(LinkedQueueAtomicNode<E> linkedQueueAtomicNode) {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNodeLvNext;
        do {
            linkedQueueAtomicNodeLvNext = linkedQueueAtomicNode.lvNext();
        } while (linkedQueueAtomicNodeLvNext == null);
        return linkedQueueAtomicNodeLvNext;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    public final LinkedQueueAtomicNode<E> newNode(E e10) {
        return new LinkedQueueAtomicNode<>(e10);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return MessagePassingQueueUtil.drain(this, consumer);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }
}
