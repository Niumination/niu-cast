package f1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class p5 {
    @b1.c
    @t1.a
    @b1.d
    public static <E> int a(BlockingQueue<E> q10, Collection<? super E> buffer, int numElements, long timeout, TimeUnit unit) throws InterruptedException {
        buffer.getClass();
        long nanos = unit.toNanos(timeout) + System.nanoTime();
        int iDrainTo = 0;
        while (iDrainTo < numElements) {
            iDrainTo += q10.drainTo(buffer, numElements - iDrainTo);
            if (iDrainTo < numElements) {
                E ePoll = q10.poll(nanos - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (ePoll == null) {
                    break;
                }
                buffer.add(ePoll);
                iDrainTo++;
            }
        }
        return iDrainTo;
    }

    @b1.c
    @t1.a
    @b1.d
    public static <E> int b(BlockingQueue<E> q10, Collection<? super E> buffer, int numElements, long timeout, TimeUnit unit) {
        E ePoll;
        buffer.getClass();
        long nanos = unit.toNanos(timeout) + System.nanoTime();
        int iDrainTo = 0;
        boolean z10 = false;
        while (iDrainTo < numElements) {
            try {
                iDrainTo += q10.drainTo(buffer, numElements - iDrainTo);
                if (iDrainTo < numElements) {
                    while (true) {
                        try {
                            ePoll = q10.poll(nanos - System.nanoTime(), TimeUnit.NANOSECONDS);
                            break;
                        } catch (InterruptedException unused) {
                            z10 = true;
                        }
                    }
                    if (ePoll == null) {
                        break;
                    }
                    buffer.add(ePoll);
                    iDrainTo++;
                }
            } finally {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return iDrainTo;
    }

    @b1.c
    @b1.d
    public static <E> ArrayBlockingQueue<E> c(int capacity) {
        return new ArrayBlockingQueue<>(capacity);
    }

    public static <E> ArrayDeque<E> d() {
        return new ArrayDeque<>();
    }

    public static <E> ArrayDeque<E> e(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new ArrayDeque<>((Collection) elements);
        }
        ArrayDeque<E> arrayDeque = new ArrayDeque<>();
        g4.a(arrayDeque, elements);
        return arrayDeque;
    }

    @b1.c
    @b1.d
    public static <E> ConcurrentLinkedQueue<E> f() {
        return new ConcurrentLinkedQueue<>();
    }

    @b1.c
    @b1.d
    public static <E> ConcurrentLinkedQueue<E> g(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new ConcurrentLinkedQueue<>((Collection) elements);
        }
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        g4.a(concurrentLinkedQueue, elements);
        return concurrentLinkedQueue;
    }

    @b1.c
    @b1.d
    public static <E> LinkedBlockingDeque<E> h() {
        return new LinkedBlockingDeque<>();
    }

    @b1.c
    @b1.d
    public static <E> LinkedBlockingDeque<E> i(int capacity) {
        return new LinkedBlockingDeque<>(capacity);
    }

    @b1.c
    @b1.d
    public static <E> LinkedBlockingDeque<E> j(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new LinkedBlockingDeque<>((Collection) elements);
        }
        LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque<>();
        g4.a(linkedBlockingDeque, elements);
        return linkedBlockingDeque;
    }

    @b1.c
    @b1.d
    public static <E> LinkedBlockingQueue<E> k() {
        return new LinkedBlockingQueue<>();
    }

    @b1.c
    @b1.d
    public static <E> LinkedBlockingQueue<E> l(int capacity) {
        return new LinkedBlockingQueue<>(capacity);
    }

    @b1.c
    @b1.d
    public static <E> LinkedBlockingQueue<E> m(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new LinkedBlockingQueue<>((Collection) elements);
        }
        LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue<>();
        g4.a(linkedBlockingQueue, elements);
        return linkedBlockingQueue;
    }

    @b1.c
    @b1.d
    public static <E extends Comparable> PriorityBlockingQueue<E> n() {
        return new PriorityBlockingQueue<>();
    }

    @b1.c
    @b1.d
    public static <E extends Comparable> PriorityBlockingQueue<E> o(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new PriorityBlockingQueue<>((Collection) elements);
        }
        PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue<>();
        g4.a(priorityBlockingQueue, elements);
        return priorityBlockingQueue;
    }

    public static <E extends Comparable> PriorityQueue<E> p() {
        return new PriorityQueue<>();
    }

    public static <E extends Comparable> PriorityQueue<E> q(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new PriorityQueue<>((Collection) elements);
        }
        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        g4.a(priorityQueue, elements);
        return priorityQueue;
    }

    @b1.c
    @b1.d
    public static <E> SynchronousQueue<E> r() {
        return new SynchronousQueue<>();
    }

    public static <E> Deque<E> s(Deque<E> deque) {
        return new y6.g(deque, null);
    }

    public static <E> Queue<E> t(Queue<E> queue) {
        return y6.t(queue, null);
    }
}
