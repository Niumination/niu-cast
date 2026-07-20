package zg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Set, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f11593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f11594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1 f11595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11596d;

    public m(Set delegate, Function1 convertTo, Function1 convert) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(convertTo, "convertTo");
        Intrinsics.checkNotNullParameter(convert, "convert");
        this.f11593a = delegate;
        this.f11594b = convertTo;
        this.f11595c = convert;
        this.f11596d = delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f11593a.add(this.f11595c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f11593a.addAll(e(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f11593a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f11593a.contains(this.f11595c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f11593a.containsAll(e(elements));
    }

    public final ArrayList e(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(collection2));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f11595c.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        ArrayList arrayListF = f(this.f11593a);
        return ((Set) obj).containsAll(arrayListF) && arrayListF.containsAll((Collection) obj);
    }

    public final ArrayList f(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(collection2));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f11594b.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f11593a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f11593a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new l(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f11593a.remove(this.f11595c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f11593a.removeAll(CollectionsKt.toSet(e(elements)));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f11593a.retainAll(CollectionsKt.toSet(e(elements)));
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f11596d;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final String toString() {
        return f(this.f11593a).toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }
}
