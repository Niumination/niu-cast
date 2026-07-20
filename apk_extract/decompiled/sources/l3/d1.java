package l3;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class d1 extends r implements RandomAccess, e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7231b;

    static {
        new d1();
    }

    public d1(int i8) {
        ArrayList arrayList = new ArrayList(i8);
        super(true);
        this.f7231b = arrayList;
    }

    @Override // l3.e1
    public final e1 a() {
        return this.f7286a ? new s2(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i8, Object obj) {
        e();
        this.f7231b.add(i8, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // l3.r, java.util.AbstractList, java.util.List
    public final boolean addAll(int i8, Collection collection) {
        e();
        if (collection instanceof e1) {
            collection = ((e1) collection).c();
        }
        boolean zAddAll = this.f7231b.addAll(i8, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // l3.y0
    public final y0 b(int i8) {
        List list = this.f7231b;
        if (i8 < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i8);
        arrayList.addAll(list);
        return new d1(arrayList);
    }

    @Override // l3.e1
    public final List c() {
        return Collections.unmodifiableList(this.f7231b);
    }

    @Override // l3.r, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        this.f7231b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // l3.e1
    public final Object d(int i8) {
        return this.f7231b.get(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String get(int i8) {
        List list = this.f7231b;
        Object obj = list.get(i8);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            String strZzt = b0Var.zzt(z0.f7328a);
            if (b0Var.zzn()) {
                list.set(i8, strZzt);
            }
            return strZzt;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, z0.f7328a);
        c cVar = z2.f7333a;
        int length = bArr.length;
        z2.f7333a.getClass();
        if (c.a(0, bArr, 0, length) == 0) {
            list.set(i8, str);
        }
        return str;
    }

    @Override // l3.r, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        e();
        Object objRemove = this.f7231b.remove(i8);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        return objRemove instanceof b0 ? ((b0) objRemove).zzt(z0.f7328a) : new String((byte[]) objRemove, z0.f7328a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        e();
        Object obj2 = this.f7231b.set(i8, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        return obj2 instanceof b0 ? ((b0) obj2).zzt(z0.f7328a) : new String((byte[]) obj2, z0.f7328a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7231b.size();
    }

    public d1(ArrayList arrayList) {
        super(true);
        this.f7231b = arrayList;
    }

    public d1() {
        super(false);
        this.f7231b = Collections.emptyList();
    }

    @Override // l3.r, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f7231b.size(), collection);
    }
}
