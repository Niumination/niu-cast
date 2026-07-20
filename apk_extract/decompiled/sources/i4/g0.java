package i4;

import java.util.Iterator;
import java.util.ListIterator;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends h0 {
    final transient int length;
    final transient int offset;
    final /* synthetic */ h0 this$0;

    public g0(h0 h0Var, int i8, int i9) {
        this.this$0 = h0Var;
        this.offset = i8;
        this.length = i9;
    }

    @Override // java.util.List
    public Object get(int i8) {
        v8.h(i8, this.length);
        return this.this$0.get(i8 + this.offset);
    }

    @Override // i4.a0
    public Object[] internalArray() {
        return this.this$0.internalArray();
    }

    @Override // i4.a0
    public int internalArrayEnd() {
        return this.this$0.internalArrayStart() + this.offset + this.length;
    }

    @Override // i4.a0
    public int internalArrayStart() {
        return this.this$0.internalArrayStart() + this.offset;
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // i4.h0, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // i4.h0, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.length;
    }

    @Override // i4.h0, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i8) {
        return super.listIterator(i8);
    }

    @Override // i4.h0, java.util.List
    public h0 subList(int i8, int i9) {
        v8.k(i8, i9, this.length);
        h0 h0Var = this.this$0;
        int i10 = this.offset;
        return h0Var.subList(i8 + i10, i9 + i10);
    }
}
