package f1;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class z<E> extends AbstractList<List<E>> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient i3<List<E>> f5640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int[] f5641b;

    public class a extends i3<E> {
        final /* synthetic */ int val$index;

        public a(final int val$index) {
            this.val$index = val$index;
        }

        @Override // java.util.List
        public E get(int i10) {
            c1.h0.C(i10, size());
            return (E) ((List) z.this.f5640a.get(i10)).get(z.this.f(this.val$index, i10));
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return z.this.f5640a.size();
        }
    }

    public z(i3<List<E>> axes) {
        this.f5640a = axes;
        int[] iArr = new int[axes.size() + 1];
        iArr[axes.size()] = 1;
        try {
            for (int size = axes.size() - 1; size >= 0; size--) {
                iArr[size] = m1.f.d(iArr[size + 1], axes.get(size).size());
            }
            this.f5641b = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    public static <E> List<List<E>> c(List<? extends List<? extends E>> lists) {
        i3.a aVar = new i3.a(lists.size());
        Iterator<? extends List<? extends E>> it = lists.iterator();
        while (it.hasNext()) {
            i3 i3VarCopyOf = i3.copyOf((Collection) it.next());
            if (i3VarCopyOf.isEmpty()) {
                return i3.of();
            }
            aVar.j(i3VarCopyOf);
        }
        return new z(aVar.e());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@gm.a Object object) {
        if (!(object instanceof List)) {
            return false;
        }
        List list = (List) object;
        if (list.size() != this.f5640a.size()) {
            return false;
        }
        Iterator<E> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!this.f5640a.get(i10).contains(it.next())) {
                return false;
            }
            i10++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public i3<E> get(int index) {
        c1.h0.C(index, this.f5641b[0]);
        return new a(index);
    }

    public final int f(int index, int axis) {
        return (index / this.f5641b[axis + 1]) % this.f5640a.get(axis).size();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(@gm.a Object o10) {
        if (!(o10 instanceof List)) {
            return -1;
        }
        List list = (List) o10;
        if (list.size() != this.f5640a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i10 = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iIndexOf = this.f5640a.get(iNextIndex).indexOf(listIterator.next());
            if (iIndexOf == -1) {
                return -1;
            }
            i10 += iIndexOf * this.f5641b[iNextIndex + 1];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(@gm.a Object o10) {
        if (!(o10 instanceof List)) {
            return -1;
        }
        List list = (List) o10;
        if (list.size() != this.f5640a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i10 = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iLastIndexOf = this.f5640a.get(iNextIndex).lastIndexOf(listIterator.next());
            if (iLastIndexOf == -1) {
                return -1;
            }
            i10 += iLastIndexOf * this.f5641b[iNextIndex + 1];
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f5641b[0];
    }
}
