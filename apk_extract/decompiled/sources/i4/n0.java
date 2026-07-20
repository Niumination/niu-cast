package i4;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends v0 {
    final /* synthetic */ o0 this$0;

    public n0(o0 o0Var) {
        this.this$0 = o0Var;
    }

    @Override // i4.v0
    public t0 map() {
        return this.this$0;
    }

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return this.this$0.entryIterator();
    }
}
