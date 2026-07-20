package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g1 extends o1 {
    final /* synthetic */ j1 this$0;

    public g1(j1 j1Var) {
        this.this$0 = j1Var;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use KeysSerializedForm");
    }

    @Override // i4.o1, i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.this$0.containsKey(obj);
    }

    @Override // i4.o1, i4.c4
    public int count(Object obj) {
        Collection collection = (Collection) this.this$0.map.get(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override // i4.o1
    public b4 getEntry(int i8) {
        Map.Entry entry = (Map.Entry) this.this$0.map.entrySet().asList().get(i8);
        return new e4(entry.getKey(), ((Collection) entry.getValue()).size());
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.this$0.size();
    }

    @Override // i4.o1, i4.a0
    public Object writeReplace() {
        return new h1(this.this$0);
    }

    @Override // i4.o1, i4.c4
    public s1 elementSet() {
        return this.this$0.m149keySet();
    }
}
