package v1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends k implements Iterable<k> {
    private final ArrayList<k> elements;

    public h() {
        this.elements = new ArrayList<>();
    }

    private k getAsSingleElement() {
        int size = this.elements.size();
        if (size == 1) {
            return this.elements.get(0);
        }
        throw new IllegalStateException(h.a.a("Array must have size 1, but has size ", size));
    }

    public void add(Boolean bool) {
        this.elements.add(bool == null ? m.INSTANCE : new q(bool));
    }

    public void addAll(h hVar) {
        this.elements.addAll(hVar.elements);
    }

    public List<k> asList() {
        return new x1.j(this.elements);
    }

    public boolean contains(k kVar) {
        return this.elements.contains(kVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).elements.equals(this.elements));
    }

    public k get(int i10) {
        return this.elements.get(i10);
    }

    @Override // v1.k
    public BigDecimal getAsBigDecimal() {
        return getAsSingleElement().getAsBigDecimal();
    }

    @Override // v1.k
    public BigInteger getAsBigInteger() {
        return getAsSingleElement().getAsBigInteger();
    }

    @Override // v1.k
    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    @Override // v1.k
    public byte getAsByte() {
        return getAsSingleElement().getAsByte();
    }

    @Override // v1.k
    @Deprecated
    public char getAsCharacter() {
        return getAsSingleElement().getAsCharacter();
    }

    @Override // v1.k
    public double getAsDouble() {
        return getAsSingleElement().getAsDouble();
    }

    @Override // v1.k
    public float getAsFloat() {
        return getAsSingleElement().getAsFloat();
    }

    @Override // v1.k
    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    @Override // v1.k
    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    @Override // v1.k
    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    @Override // v1.k
    public short getAsShort() {
        return getAsSingleElement().getAsShort();
    }

    @Override // v1.k
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
    public Iterator<k> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(k kVar) {
        return this.elements.remove(kVar);
    }

    public k set(int i10, k kVar) {
        ArrayList<k> arrayList = this.elements;
        if (kVar == null) {
            kVar = m.INSTANCE;
        }
        return arrayList.set(i10, kVar);
    }

    public int size() {
        return this.elements.size();
    }

    public void add(Character ch2) {
        this.elements.add(ch2 == null ? m.INSTANCE : new q(ch2));
    }

    @Override // v1.k
    public h deepCopy() {
        if (this.elements.isEmpty()) {
            return new h();
        }
        h hVar = new h(this.elements.size());
        Iterator<k> it = this.elements.iterator();
        while (it.hasNext()) {
            hVar.add(it.next().deepCopy());
        }
        return hVar;
    }

    public k remove(int i10) {
        return this.elements.remove(i10);
    }

    public h(int i10) {
        this.elements = new ArrayList<>(i10);
    }

    public void add(Number number) {
        this.elements.add(number == null ? m.INSTANCE : new q(number));
    }

    public void add(String str) {
        this.elements.add(str == null ? m.INSTANCE : new q(str));
    }

    public void add(k kVar) {
        if (kVar == null) {
            kVar = m.INSTANCE;
        }
        this.elements.add(kVar);
    }
}
