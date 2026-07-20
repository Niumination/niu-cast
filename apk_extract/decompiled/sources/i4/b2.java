package i4;

/* JADX INFO: loaded from: classes.dex */
public final class b2 extends h0 {
    final /* synthetic */ c2 this$0;

    public b2(c2 c2Var) {
        this.this$0 = c2Var;
    }

    @Override // java.util.List
    public Object get(int i8) {
        return this.this$0.get(i8);
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.this$0.size();
    }
}
