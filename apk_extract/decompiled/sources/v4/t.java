package v4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t extends u implements Iterable {
    private final ArrayList<u> elements;

    public t() {
        this.elements = new ArrayList<>();
    }

    private u getAsSingleElement() {
        int size = this.elements.size();
        if (size == 1) {
            return this.elements.get(0);
        }
        throw new IllegalStateException(a1.a.o(size, "Array must have size 1, but has size "));
    }

    public void add(Boolean bool) {
        this.elements.add(bool == null ? w.INSTANCE : new z(bool));
    }

    public void addAll(t tVar) {
        this.elements.addAll(tVar.elements);
    }

    public List<u> asList() {
        return new x4.r(this.elements);
    }

    public boolean contains(u uVar) {
        return this.elements.contains(uVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof t) && ((t) obj).elements.equals(this.elements));
    }

    public u get(int i8) {
        return this.elements.get(i8);
    }

    @Override // v4.u
    public BigDecimal getAsBigDecimal() {
        return getAsSingleElement().getAsBigDecimal();
    }

    @Override // v4.u
    public BigInteger getAsBigInteger() {
        return getAsSingleElement().getAsBigInteger();
    }

    @Override // v4.u
    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    @Override // v4.u
    public byte getAsByte() {
        return getAsSingleElement().getAsByte();
    }

    @Override // v4.u
    @Deprecated
    public char getAsCharacter() {
        return getAsSingleElement().getAsCharacter();
    }

    @Override // v4.u
    public double getAsDouble() {
        return getAsSingleElement().getAsDouble();
    }

    @Override // v4.u
    public float getAsFloat() {
        return getAsSingleElement().getAsFloat();
    }

    @Override // v4.u
    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    @Override // v4.u
    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    @Override // v4.u
    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    @Override // v4.u
    public short getAsShort() {
        return getAsSingleElement().getAsShort();
    }

    @Override // v4.u
    public String getAsString() {
        return getAsSingleElement().getAsString();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<u> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(u uVar) {
        return this.elements.remove(uVar);
    }

    public u set(int i8, u uVar) {
        ArrayList<u> arrayList = this.elements;
        if (uVar == null) {
            uVar = w.INSTANCE;
        }
        return arrayList.set(i8, uVar);
    }

    public int size() {
        return this.elements.size();
    }

    public void add(Character ch2) {
        this.elements.add(ch2 == null ? w.INSTANCE : new z(ch2));
    }

    @Override // v4.u
    public t deepCopy() {
        if (this.elements.isEmpty()) {
            return new t();
        }
        t tVar = new t(this.elements.size());
        Iterator<u> it = this.elements.iterator();
        while (it.hasNext()) {
            tVar.add(it.next().deepCopy());
        }
        return tVar;
    }

    public u remove(int i8) {
        return this.elements.remove(i8);
    }

    public t(int i8) {
        this.elements = new ArrayList<>(i8);
    }

    public void add(Number number) {
        this.elements.add(number == null ? w.INSTANCE : new z(number));
    }

    public void add(String str) {
        this.elements.add(str == null ? w.INSTANCE : new z(str));
    }

    public void add(u uVar) {
        if (uVar == null) {
            uVar = w.INSTANCE;
        }
        this.elements.add(uVar);
    }
}
