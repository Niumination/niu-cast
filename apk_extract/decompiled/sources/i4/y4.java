package i4;

import k3.cb;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class y4 extends o1 {
    static final y4 EMPTY;
    final transient k4 contents;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f5711d;
    public transient w4 e;

    static {
        k4 k4Var = new k4();
        k4Var.e(3);
        EMPTY = new y4(k4Var);
    }

    public y4(k4 k4Var) {
        this.contents = k4Var;
        long jC = 0;
        for (int i8 = 0; i8 < k4Var.f5624c; i8++) {
            jC += (long) k4Var.c(i8);
        }
        this.f5711d = cb.b(jC);
    }

    @Override // i4.o1, i4.c4
    public int count(Object obj) {
        return this.contents.b(obj);
    }

    @Override // i4.o1
    public b4 getEntry(int i8) {
        k4 k4Var = this.contents;
        v8.h(i8, k4Var.f5624c);
        return new j4(k4Var, i8);
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f5711d;
    }

    @Override // i4.o1, i4.a0
    public Object writeReplace() {
        return new x4(this);
    }

    @Override // i4.o1, i4.c4
    public s1 elementSet() {
        w4 w4Var = this.e;
        if (w4Var != null) {
            return w4Var;
        }
        w4 w4Var2 = new w4(this, null);
        this.e = w4Var2;
        return w4Var2;
    }
}
