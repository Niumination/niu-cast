package c1;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class a<T> extends c0<T> {
    static final a<Object> INSTANCE = new a<>();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> c0<T> withType() {
        return INSTANCE;
    }

    @Override // c1.c0
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // c1.c0
    public boolean equals(@gm.a Object object) {
        return object == this;
    }

    @Override // c1.c0
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // c1.c0
    public int hashCode() {
        return 2040732332;
    }

    @Override // c1.c0
    public boolean isPresent() {
        return false;
    }

    @Override // c1.c0
    public T or(T t10) {
        return (T) h0.F(t10, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // c1.c0
    @gm.a
    public T orNull() {
        return null;
    }

    @Override // c1.c0
    public String toString() {
        return "Optional.absent()";
    }

    @Override // c1.c0
    public <V> c0<V> transform(t<? super T, V> function) {
        function.getClass();
        return c0.absent();
    }

    @Override // c1.c0
    public T or(q0<? extends T> q0Var) {
        return (T) h0.F(q0Var.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c1.c0
    public c0<T> or(c0<? extends T> secondChoice) {
        secondChoice.getClass();
        return secondChoice;
    }
}
