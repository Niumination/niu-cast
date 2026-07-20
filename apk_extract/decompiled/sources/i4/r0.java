package i4;

/* JADX INFO: loaded from: classes.dex */
public final class r0 extends o0 {
    final /* synthetic */ t0 this$0;

    public r0(t0 t0Var, k0 k0Var) {
        this.this$0 = t0Var;
    }

    @Override // i4.t0, java.util.Map
    public boolean containsKey(Object obj) {
        return this.this$0.containsKey(obj);
    }

    @Override // i4.o0, i4.t0
    public s1 createKeySet() {
        return this.this$0.keySet();
    }

    @Override // i4.o0
    public h5 entryIterator() {
        return new q0(this.this$0.entrySet().iterator());
    }

    @Override // i4.t0, java.util.Map
    public int hashCode() {
        return this.this$0.hashCode();
    }

    @Override // i4.t0
    public boolean isHashCodeFast() {
        return this.this$0.isHashCodeFast();
    }

    @Override // i4.t0
    public boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    @Override // java.util.Map
    public int size() {
        return this.this$0.size();
    }

    @Override // i4.t0, java.util.Map
    public s1 get(Object obj) {
        Object obj2 = this.this$0.get(obj);
        if (obj2 == null) {
            return null;
        }
        return s1.of(obj2);
    }
}
