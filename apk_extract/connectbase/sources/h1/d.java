package h1;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@e
public abstract class d {

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6930a = new b();

        @Override // h1.d
        public void a(Object event, Iterator<j> subscribers) {
            event.getClass();
            while (subscribers.hasNext()) {
                subscribers.next().d(event);
            }
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue<a> f6931a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f6932a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final j f6933b;

            public a(Object event, j subscriber) {
                this.f6932a = event;
                this.f6933b = subscriber;
            }
        }

        public c() {
            this.f6931a = new ConcurrentLinkedQueue<>();
        }

        @Override // h1.d
        public void a(Object event, Iterator<j> subscribers) {
            event.getClass();
            while (subscribers.hasNext()) {
                this.f6931a.add(new a(event, subscribers.next()));
            }
            while (true) {
                a aVarPoll = this.f6931a.poll();
                if (aVarPoll == null) {
                    return;
                } else {
                    aVarPoll.f6933b.d(aVarPoll.f6932a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: h1.d$d, reason: collision with other inner class name */
    public static final class C0188d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadLocal<Queue<c>> f6934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ThreadLocal<Boolean> f6935b;

        /* JADX INFO: renamed from: h1.d$d$a */
        public class a extends ThreadLocal<Queue<c>> {
            public a(final C0188d this$0) {
            }

            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Queue<c> initialValue() {
                return new ArrayDeque();
            }
        }

        /* JADX INFO: renamed from: h1.d$d$b */
        public class b extends ThreadLocal<Boolean> {
            public b(final C0188d this$0) {
            }

            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean initialValue() {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: renamed from: h1.d$d$c */
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f6936a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Iterator<j> f6937b;

            public c(Object event, Iterator<j> subscribers) {
                this.f6936a = event;
                this.f6937b = subscribers;
            }
        }

        public C0188d() {
            this.f6934a = new a();
            this.f6935b = new b();
        }

        @Override // h1.d
        public void a(Object event, Iterator<j> subscribers) {
            event.getClass();
            subscribers.getClass();
            Queue<c> queue = this.f6934a.get();
            queue.offer(new c(event, subscribers));
            if (this.f6935b.get().booleanValue()) {
                return;
            }
            this.f6935b.set(Boolean.TRUE);
            while (true) {
                try {
                    c cVarPoll = queue.poll();
                    if (cVarPoll == null) {
                        this.f6935b.remove();
                        this.f6934a.remove();
                        return;
                    } else {
                        while (cVarPoll.f6937b.hasNext()) {
                            cVarPoll.f6937b.next().d(cVarPoll.f6936a);
                        }
                    }
                } catch (Throwable th2) {
                    this.f6935b.remove();
                    this.f6934a.remove();
                    throw th2;
                }
            }
        }
    }

    public static d b() {
        return b.f6930a;
    }

    public static d c() {
        return new c();
    }

    public static d d() {
        return new C0188d();
    }

    public abstract void a(Object event, Iterator<j> subscribers);
}
