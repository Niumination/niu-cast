package i4;

import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class w4 extends c2 {
    final /* synthetic */ y4 this$0;

    public w4(y4 y4Var, v4 v4Var) {
        this.this$0 = y4Var;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.this$0.contains(obj);
    }

    @Override // i4.c2
    public Object get(int i8) {
        k4 k4Var = this.this$0.contents;
        v8.h(i8, k4Var.f5624c);
        return k4Var.f5622a[i8];
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.this$0.contents.f5624c;
    }
}
