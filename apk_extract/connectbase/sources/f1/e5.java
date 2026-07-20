package f1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class e5 extends l5<Comparable<?>> implements Serializable {
    static final e5 INSTANCE = new e5();
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient l5<Comparable<?>> f4856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient l5<Comparable<?>> f4857b;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // f1.l5
    public <S extends Comparable<?>> l5<S> nullsFirst() {
        l5<S> l5Var = (l5<S>) this.f4856a;
        if (l5Var != null) {
            return l5Var;
        }
        l5<S> l5VarNullsFirst = super.nullsFirst();
        this.f4856a = l5VarNullsFirst;
        return l5VarNullsFirst;
    }

    @Override // f1.l5
    public <S extends Comparable<?>> l5<S> nullsLast() {
        l5<S> l5Var = (l5<S>) this.f4857b;
        if (l5Var != null) {
            return l5Var;
        }
        l5<S> l5VarNullsLast = super.nullsLast();
        this.f4857b = l5VarNullsLast;
        return l5VarNullsLast;
    }

    @Override // f1.l5
    public <S extends Comparable<?>> l5<S> reverse() {
        return f6.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(Comparable<?> left, Comparable<?> right) {
        left.getClass();
        right.getClass();
        return left.compareTo(right);
    }
}
