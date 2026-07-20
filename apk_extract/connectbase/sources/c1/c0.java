package c1;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@t1.f("Use Optional.of(value) or Optional.absent()")
@k
public abstract class c0<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public class a implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f1133a;

        /* JADX INFO: renamed from: c1.c0$a$a, reason: collision with other inner class name */
        public class C0048a extends b<T> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<? extends c0<? extends T>> f1134c;

            public C0048a() {
                Iterator<? extends c0<? extends T>> it = a.this.f1133a.iterator();
                it.getClass();
                this.f1134c = it;
            }

            @Override // c1.b
            @gm.a
            public T a() {
                while (this.f1134c.hasNext()) {
                    c0<? extends T> next = this.f1134c.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                this.f1103a = b.EnumC0047b.DONE;
                return null;
            }
        }

        public a(final Iterable val$optionals) {
            this.f1133a = val$optionals;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0048a();
        }
    }

    public static <T> c0<T> absent() {
        return c1.a.withType();
    }

    public static <T> c0<T> fromNullable(@gm.a T nullableReference) {
        return nullableReference == null ? absent() : new k0(nullableReference);
    }

    public static <T> c0<T> of(T reference) {
        reference.getClass();
        return new k0(reference);
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends c0<? extends T>> optionals) {
        optionals.getClass();
        return new a(optionals);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@gm.a Object object);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract c0<T> or(c0<? extends T> secondChoice);

    public abstract T or(q0<? extends T> supplier);

    public abstract T or(T defaultValue);

    @gm.a
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> c0<V> transform(t<? super T, V> function);
}
