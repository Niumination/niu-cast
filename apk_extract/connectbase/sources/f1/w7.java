package f1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@b1.a
@x0
@Deprecated
public abstract class w7<T> {

    public class a extends w7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1.t f5548a;

        public a(final c1.t val$nodeToChildrenFunction) {
            this.f5548a = val$nodeToChildrenFunction;
        }

        @Override // f1.w7
        public Iterable<T> b(T root) {
            return (Iterable) this.f5548a.apply(root);
        }
    }

    public class b extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f5549b;

        public b(final Object val$root) {
            this.f5549b = val$root;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public x7<T> iterator() {
            return w7.this.e(this.f5549b);
        }
    }

    public class c extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f5551b;

        public c(final Object val$root) {
            this.f5551b = val$root;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public x7<T> iterator() {
            return w7.this.c(this.f5551b);
        }
    }

    public class d extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f5553b;

        public d(final Object val$root) {
            this.f5553b = val$root;
        }

        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public x7<T> iterator() {
            return new e(this.f5553b);
        }
    }

    public final class e extends x7<T> implements n5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<T> f5555a;

        public e(T root) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f5555a = arrayDeque;
            arrayDeque.add(root);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f5555a.isEmpty();
        }

        @Override // java.util.Iterator, f1.n5
        public T next() {
            T tRemove = this.f5555a.remove();
            g4.a(this.f5555a, w7.this.b(tRemove));
            return tRemove;
        }

        @Override // f1.n5
        public T peek() {
            return this.f5555a.element();
        }
    }

    public final class f extends f1.c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayDeque<g<T>> f5557c;

        public f(T root) {
            ArrayDeque<g<T>> arrayDeque = new ArrayDeque<>();
            this.f5557c = arrayDeque;
            arrayDeque.addLast(d(root));
        }

        @Override // f1.c
        @gm.a
        public T a() {
            while (!this.f5557c.isEmpty()) {
                g<T> last = this.f5557c.getLast();
                if (!last.f5560b.hasNext()) {
                    this.f5557c.removeLast();
                    return last.f5559a;
                }
                this.f5557c.addLast(d(last.f5560b.next()));
            }
            this.f4711a = f1.c.b.DONE;
            return null;
        }

        public final g<T> d(T t10) {
            return new g<>(t10, w7.this.b(t10).iterator());
        }
    }

    public static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f5559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<T> f5560b;

        public g(T root, Iterator<T> childIterator) {
            root.getClass();
            this.f5559a = root;
            childIterator.getClass();
            this.f5560b = childIterator;
        }
    }

    public final class h extends x7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Deque<Iterator<T>> f5561a;

        public h(T root) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f5561a = arrayDeque;
            root.getClass();
            arrayDeque.addLast(new h4.k(root));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f5561a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.f5561a.getLast();
            T next = last.next();
            next.getClass();
            if (!last.hasNext()) {
                this.f5561a.removeLast();
            }
            Iterator<T> it = w7.this.b(next).iterator();
            if (it.hasNext()) {
                this.f5561a.addLast(it);
            }
            return next;
        }
    }

    @Deprecated
    public static <T> w7<T> g(final c1.t<T, ? extends Iterable<T>> nodeToChildrenFunction) {
        nodeToChildrenFunction.getClass();
        return new a(nodeToChildrenFunction);
    }

    @Deprecated
    public final p1<T> a(final T root) {
        root.getClass();
        return new d(root);
    }

    public abstract Iterable<T> b(T root);

    public x7<T> c(T root) {
        return new f(root);
    }

    @Deprecated
    public final p1<T> d(final T root) {
        root.getClass();
        return new c(root);
    }

    public x7<T> e(T root) {
        return new h(root);
    }

    @Deprecated
    public final p1<T> f(final T root) {
        root.getClass();
        return new b(root);
    }
}
