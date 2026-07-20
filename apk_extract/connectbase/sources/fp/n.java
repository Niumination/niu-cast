package fp;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public class n extends AbstractList<String> implements RandomAccess, o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f6268b = new x(new n());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f6269a;

    public n() {
        this.f6269a = new ArrayList();
    }

    public static d b(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        return obj instanceof String ? d.g((String) obj) : d.e((byte[]) obj);
    }

    public static String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof d ? ((d) obj).w() : j.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        this.f6269a.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f6269a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f6269a.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String strW = dVar.w();
            if (dVar.m()) {
                this.f6269a.set(i10, strW);
            }
            return strW;
        }
        byte[] bArr = (byte[]) obj;
        String strB = j.b(bArr);
        if (y.f(bArr, 0, bArr.length)) {
            this.f6269a.set(i10, strB);
        }
        return strB;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        Object objRemove = this.f6269a.remove(i10);
        ((AbstractList) this).modCount++;
        return c(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        return c(this.f6269a.set(i10, str));
    }

    @Override // fp.o
    public d getByteString(int i10) {
        Object obj = this.f6269a.get(i10);
        d dVarB = b(obj);
        if (dVarB != obj) {
            this.f6269a.set(i10, dVarB);
        }
        return dVarB;
    }

    @Override // fp.o
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f6269a);
    }

    @Override // fp.o
    public o getUnmodifiableView() {
        return new x(this);
    }

    @Override // fp.o
    public void h(d dVar) {
        this.f6269a.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6269a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        if (collection instanceof o) {
            collection = ((o) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f6269a.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public n(o oVar) {
        this.f6269a = new ArrayList(oVar.size());
        addAll(oVar);
    }
}
