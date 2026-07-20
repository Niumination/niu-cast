package c1;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class k0<T> extends c0<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public k0(T reference) {
        this.reference = reference;
    }

    @Override // c1.c0
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // c1.c0
    public boolean equals(@gm.a Object object) {
        if (object instanceof k0) {
            return this.reference.equals(((k0) object).reference);
        }
        return false;
    }

    @Override // c1.c0
    public T get() {
        return this.reference;
    }

    @Override // c1.c0
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // c1.c0
    public boolean isPresent() {
        return true;
    }

    @Override // c1.c0
    public T or(T defaultValue) {
        h0.F(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // c1.c0
    public T orNull() {
        return this.reference;
    }

    @Override // c1.c0
    public String toString() {
        return j.e.a(new StringBuilder("Optional.of("), this.reference, ")");
    }

    @Override // c1.c0
    public <V> c0<V> transform(t<? super T, V> tVar) {
        return new k0(h0.F(tVar.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // c1.c0
    public c0<T> or(c0<? extends T> secondChoice) {
        secondChoice.getClass();
        return this;
    }

    @Override // c1.c0
    public T or(q0<? extends T> supplier) {
        supplier.getClass();
        return this.reference;
    }
}
