package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class m1 extends c2 {
    private static final long serialVersionUID = 0;
    final /* synthetic */ o1 this$0;

    public m1(o1 o1Var, k1 k1Var) {
        this.this$0 = o1Var;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof b4)) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return b4Var.getCount() > 0 && this.this$0.count(b4Var.getElement()) == b4Var.getCount();
    }

    @Override // i4.s1, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.this$0.hashCode();
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.this$0.elementSet().size();
    }

    @Override // i4.s1, i4.a0
    public Object writeReplace() {
        return new n1(this.this$0);
    }

    @Override // i4.c2
    public b4 get(int i8) {
        return this.this$0.getEntry(i8);
    }
}
