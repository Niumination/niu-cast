package f1;

import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class p4 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class a<E> extends g<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @b1.d
        public static final long f5188b = 0;

        public a(List backingList) {
            super(backingList);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int index) {
            return this.f5190a.listIterator(index);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class b<E> extends c<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @b1.d
        public static final long f5189b = 0;

        public b(List backingList) {
            super(backingList);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int index) {
            return this.f5190a.listIterator(index);
        }
    }

    public static class c<E> extends AbstractList<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<E> f5190a;

        public c(List<E> backingList) {
            backingList.getClass();
            this.f5190a = backingList;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int index, @m5 E element) {
            this.f5190a.add(index, element);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int index, Collection<? extends E> c10) {
            return this.f5190a.addAll(index, c10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object o10) {
            return this.f5190a.contains(o10);
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public E get(int index) {
            return this.f5190a.get(index);
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public E remove(int index) {
            return this.f5190a.remove(index);
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public E set(int index, @m5 E element) {
            return this.f5190a.set(index, element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f5190a.size();
        }
    }

    public static final class d extends AbstractList<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f5191a;

        public d(CharSequence sequence) {
            this.f5191a = sequence;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character get(int index) {
            c1.h0.C(index, this.f5191a.length());
            return Character.valueOf(this.f5191a.charAt(index));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f5191a.length();
        }
    }

    public static class e<E> extends AbstractList<E> implements Serializable, RandomAccess {

        @b1.d
        private static final long serialVersionUID = 0;

        @m5
        final E first;
        final E[] rest;

        public e(@m5 E first, E[] rest) {
            this.first = first;
            rest.getClass();
            this.rest = rest;
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public E get(int index) {
            c1.h0.C(index, size());
            return index == 0 ? this.first : this.rest[index - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return m1.f.t(this.rest.length, 1);
        }
    }

    public static class f<T> extends AbstractList<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f5192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5193b;

        public f(List<T> list, int size) {
            this.f5192a = list;
            this.f5193b = size;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> get(int index) {
            c1.h0.C(index, size());
            int i10 = this.f5193b;
            int i11 = index * i10;
            return this.f5192a.subList(i11, Math.min(i10 + i11, this.f5192a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f5192a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return m1.f.g(this.f5192a.size(), this.f5193b, RoundingMode.CEILING);
        }
    }

    public static class g<E> extends c<E> implements RandomAccess {
        public g(List<E> backingList) {
            super(backingList);
        }
    }

    public static class h<T> extends f<T> implements RandomAccess {
        public h(List<T> list, int size) {
            super(list, size);
        }
    }

    public static class i<T> extends j<T> implements RandomAccess {
        public i(List<T> forwardList) {
            super(forwardList);
        }
    }

    public static class j<T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f5194a;

        public class a implements ListIterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f5195a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ListIterator f5196b;

            public a(final ListIterator val$forwardIterator) {
                this.f5196b = val$forwardIterator;
            }

            @Override // java.util.ListIterator
            public void add(@m5 T e10) {
                this.f5196b.add(e10);
                this.f5196b.previous();
                this.f5195a = false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f5196b.hasPrevious();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f5196b.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            @m5
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f5195a = true;
                return (T) this.f5196b.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return j.this.e(this.f5196b.nextIndex());
            }

            @Override // java.util.ListIterator
            @m5
            public T previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.f5195a = true;
                return (T) this.f5196b.next();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return nextIndex() - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                b0.e(this.f5195a);
                this.f5196b.remove();
                this.f5195a = false;
            }

            @Override // java.util.ListIterator
            public void set(@m5 T e10) {
                c1.h0.g0(this.f5195a);
                this.f5196b.set(e10);
            }
        }

        public j(List<T> forwardList) {
            forwardList.getClass();
            this.f5194a = forwardList;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int index, @m5 T element) {
            this.f5194a.add(e(index), element);
        }

        public List<T> b() {
            return this.f5194a;
        }

        public final int c(int index) {
            int size = size();
            c1.h0.C(index, size);
            return (size - 1) - index;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f5194a.clear();
        }

        public final int e(int index) {
            int size = size();
            c1.h0.d0(index, size);
            return size - index;
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public T get(int index) {
            return this.f5194a.get(c(index));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int index) {
            return new a(this.f5194a.listIterator(e(index)));
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public T remove(int index) {
            return this.f5194a.remove(c(index));
        }

        @Override // java.util.AbstractList
        public void removeRange(int fromIndex, int toIndex) {
            subList(fromIndex, toIndex).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public T set(int index, @m5 T element) {
            return this.f5194a.set(c(index), element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f5194a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int fromIndex, int toIndex) {
            c1.h0.f0(fromIndex, toIndex, size());
            return p4.B(this.f5194a.subList(e(toIndex), e(fromIndex)));
        }
    }

    public static final class k extends i3<Character> {
        private final String string;

        public k(String string) {
            this.string = string;
        }

        @Override // f1.i3, java.util.List
        public int indexOf(@gm.a Object object) {
            if (object instanceof Character) {
                return this.string.indexOf(((Character) object).charValue());
            }
            return -1;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return false;
        }

        @Override // f1.i3, java.util.List
        public int lastIndexOf(@gm.a Object object) {
            if (object instanceof Character) {
                return this.string.lastIndexOf(((Character) object).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // java.util.List
        public Character get(int index) {
            c1.h0.C(index, size());
            return Character.valueOf(this.string.charAt(index));
        }

        @Override // f1.i3, java.util.List
        public i3<Character> subList(int fromIndex, int toIndex) {
            c1.h0.f0(fromIndex, toIndex, size());
            return p4.g(this.string.substring(fromIndex, toIndex));
        }
    }

    public static class l<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final c1.t<? super F, ? extends T> function;

        public class a extends p7<F, T> {
            public a(ListIterator backingIterator) {
                super((Iterator) backingIterator);
            }

            @Override // f1.o7
            public T a(F from) {
                return l.this.function.apply(from);
            }
        }

        public l(List<F> fromList, c1.t<? super F, ? extends T> function) {
            fromList.getClass();
            this.fromList = fromList;
            function.getClass();
            this.function = function;
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public T get(int i10) {
            return this.function.apply(this.fromList.get(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int index) {
            return new a(this.fromList.listIterator(index));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i10) {
            return this.function.apply(this.fromList.remove(i10));
        }

        @Override // java.util.AbstractList
        public void removeRange(int fromIndex, int toIndex) {
            this.fromList.subList(fromIndex, toIndex).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class m<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final c1.t<? super F, ? extends T> function;

        public class a extends p7<F, T> {
            public a(ListIterator backingIterator) {
                super((Iterator) backingIterator);
            }

            @Override // f1.o7
            @m5
            public T a(@m5 F from) {
                return m.this.function.apply(from);
            }
        }

        public m(List<F> fromList, c1.t<? super F, ? extends T> function) {
            fromList.getClass();
            this.fromList = fromList;
            function.getClass();
            this.function = function;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(final int index) {
            return new a(this.fromList.listIterator(index));
        }

        @Override // java.util.AbstractList
        public void removeRange(int fromIndex, int toIndex) {
            this.fromList.subList(fromIndex, toIndex).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class n<E> extends AbstractList<E> implements Serializable, RandomAccess {

        @b1.d
        private static final long serialVersionUID = 0;

        @m5
        final E first;
        final E[] rest;

        @m5
        final E second;

        public n(@m5 E first, @m5 E second, E[] rest) {
            this.first = first;
            this.second = second;
            rest.getClass();
            this.rest = rest;
        }

        @Override // java.util.AbstractList, java.util.List
        @m5
        public E get(int index) {
            if (index == 0) {
                return this.first;
            }
            if (index == 1) {
                return this.second;
            }
            c1.h0.C(index, size());
            return this.rest[index - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return m1.f.t(this.rest.length, 2);
        }
    }

    public static <T> List<List<T>> A(List<T> list, int size) {
        list.getClass();
        c1.h0.d(size > 0);
        return list instanceof RandomAccess ? new h(list, size) : new f(list, size);
    }

    public static <T> List<T> B(List<T> list) {
        if (list instanceof i3) {
            return ((i3) list).reverse();
        }
        if (list instanceof j) {
            return ((j) list).b();
        }
        return list instanceof RandomAccess ? new i(list) : new j(list);
    }

    public static <E> List<E> C(final List<E> list, int fromIndex, int toIndex) {
        return (list instanceof RandomAccess ? new a(list) : new b(list)).subList(fromIndex, toIndex);
    }

    public static <F, T> List<T> D(List<F> fromList, c1.t<? super F, ? extends T> function) {
        return fromList instanceof RandomAccess ? new l(fromList, function) : new m(fromList, function);
    }

    public static <E> boolean a(List<E> list, int index, Iterable<? extends E> elements) {
        ListIterator<E> listIterator = list.listIterator(index);
        Iterator<? extends E> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z10 = true;
        }
        return z10;
    }

    public static <E> List<E> b(@m5 E first, @m5 E second, E[] rest) {
        return new n(first, second, rest);
    }

    public static <E> List<E> c(@m5 E first, E[] rest) {
        return new e(first, rest);
    }

    public static <B> List<List<B>> d(List<? extends List<? extends B>> lists) {
        return z.c(lists);
    }

    @SafeVarargs
    public static <B> List<List<B>> e(List<? extends B>... lists) {
        return z.c(Arrays.asList(lists));
    }

    public static <T> List<T> f(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static i3<Character> g(String string) {
        string.getClass();
        return new k(string);
    }

    public static List<Character> h(CharSequence sequence) {
        sequence.getClass();
        return new d(sequence);
    }

    @b1.e
    public static int i(int arraySize) {
        b0.b(arraySize, "arraySize");
        return o1.l.z(((long) arraySize) + 5 + ((long) (arraySize / 10)));
    }

    public static boolean j(List<?> thisList, @gm.a Object other) {
        thisList.getClass();
        if (other == thisList) {
            return true;
        }
        if (!(other instanceof List)) {
            return false;
        }
        List list = (List) other;
        int size = thisList.size();
        if (size != list.size()) {
            return false;
        }
        if (!(thisList instanceof RandomAccess) || !(list instanceof RandomAccess)) {
            return h4.t(thisList.iterator(), list.iterator());
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!c1.b0.a(thisList.get(i10), list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int k(List<?> list) {
        Iterator<?> it = list.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~((i10 * 31) + (next == null ? 0 : next.hashCode())));
        }
        return i10;
    }

    public static int l(List<?> list, @gm.a Object element) {
        if (list instanceof RandomAccess) {
            return m(list, element);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (c1.b0.a(element, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int m(List<?> list, @gm.a Object element) {
        int size = list.size();
        int i10 = 0;
        if (element == null) {
            while (i10 < size) {
                if (list.get(i10) == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < size) {
            if (element.equals(list.get(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int n(List<?> list, @gm.a Object element) {
        if (list instanceof RandomAccess) {
            return o(list, element);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (c1.b0.a(element, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int o(List<?> list, @gm.a Object element) {
        if (element == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (element.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ListIterator<E> p(List<E> list, int index) {
        return new c(list).listIterator(index);
    }

    @b1.b(serializable = true)
    public static <E> ArrayList<E> q() {
        return new ArrayList<>();
    }

    @b1.b(serializable = true)
    public static <E> ArrayList<E> r(Iterable<? extends E> elements) {
        elements.getClass();
        return elements instanceof Collection ? new ArrayList<>((Collection) elements) : s(elements.iterator());
    }

    @b1.b(serializable = true)
    public static <E> ArrayList<E> s(Iterator<? extends E> elements) {
        ArrayList<E> arrayList = new ArrayList<>();
        h4.a(arrayList, elements);
        return arrayList;
    }

    @SafeVarargs
    @b1.b(serializable = true)
    public static <E> ArrayList<E> t(E... elements) {
        elements.getClass();
        ArrayList<E> arrayList = new ArrayList<>(i(elements.length));
        Collections.addAll(arrayList, elements);
        return arrayList;
    }

    @b1.b(serializable = true)
    public static <E> ArrayList<E> u(int initialArraySize) {
        b0.b(initialArraySize, "initialArraySize");
        return new ArrayList<>(initialArraySize);
    }

    @b1.b(serializable = true)
    public static <E> ArrayList<E> v(int estimatedSize) {
        return new ArrayList<>(i(estimatedSize));
    }

    @b1.c
    @b1.d
    public static <E> CopyOnWriteArrayList<E> w() {
        return new CopyOnWriteArrayList<>();
    }

    @b1.c
    @b1.d
    public static <E> CopyOnWriteArrayList<E> x(Iterable<? extends E> elements) {
        return new CopyOnWriteArrayList<>(elements instanceof Collection ? (Collection) elements : r(elements));
    }

    @b1.b(serializable = true)
    public static <E> LinkedList<E> y() {
        return new LinkedList<>();
    }

    @b1.b(serializable = true)
    public static <E> LinkedList<E> z(Iterable<? extends E> elements) {
        LinkedList<E> linkedList = new LinkedList<>();
        g4.a(linkedList, elements);
        return linkedList;
    }
}
