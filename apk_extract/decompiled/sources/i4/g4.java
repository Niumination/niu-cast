package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class g4 extends o4 implements Serializable {
    static final g4 INSTANCE = new g4();
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient o4 f5598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient o4 f5599b;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // i4.o4
    public <S extends Comparable<?>> o4 nullsFirst() {
        o4 o4Var = this.f5598a;
        if (o4Var != null) {
            return o4Var;
        }
        o4 o4VarNullsFirst = super.nullsFirst();
        this.f5598a = o4VarNullsFirst;
        return o4VarNullsFirst;
    }

    @Override // i4.o4
    public <S extends Comparable<?>> o4 nullsLast() {
        o4 o4Var = this.f5599b;
        if (o4Var != null) {
            return o4Var;
        }
        o4 o4VarNullsLast = super.nullsLast();
        this.f5599b = o4VarNullsLast;
        return o4VarNullsLast;
    }

    @Override // i4.o4
    public <S extends Comparable<?>> o4 reverse() {
        return b5.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    @Override // java.util.Comparator
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }
}
