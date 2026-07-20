package i4;

/* JADX INFO: loaded from: classes.dex */
public abstract class c2 extends s1 {
    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        return asList().copyIntoArray(objArr, i8);
    }

    @Override // i4.s1
    public h0 createAsList() {
        return new b2(this);
    }

    public abstract Object get(int i8);

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return asList().iterator();
    }
}
