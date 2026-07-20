package f1;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class k6 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class a<E> extends m<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f5047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f5048b;

        /* JADX INFO: renamed from: f1.k6$a$a, reason: collision with other inner class name */
        public class C0116a extends f1.c<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<? extends E> f5049c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Iterator<? extends E> f5050d;

            public C0116a() {
                this.f5049c = a.this.f5047a.iterator();
                this.f5050d = a.this.f5048b.iterator();
            }

            @Override // f1.c
            @gm.a
            public E a() {
                if (this.f5049c.hasNext()) {
                    return this.f5049c.next();
                }
                while (this.f5050d.hasNext()) {
                    E next = this.f5050d.next();
                    if (!a.this.f5047a.contains(next)) {
                        return next;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public a(final Set val$set1, final Set val$set2) {
            this.f5047a = val$set1;
            this.f5048b = val$set2;
        }

        @Override // f1.k6.m
        public <S extends Set<E>> S a(S set) {
            set.addAll(this.f5047a);
            set.addAll(this.f5048b);
            return set;
        }

        @Override // f1.k6.m
        public t3<E> b() {
            return new t3.a(4).c(this.f5047a).c(this.f5048b).e();
        }

        @Override // f1.k6.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public x7<E> iterator() {
            return new C0116a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return this.f5047a.contains(object) || this.f5048b.contains(object);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f5047a.isEmpty() && this.f5048b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f5047a.size();
            Iterator<E> it = this.f5048b.iterator();
            while (it.hasNext()) {
                if (!this.f5047a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class b<E> extends m<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f5052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f5053b;

        public class a extends f1.c<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<E> f5054c;

            public a() {
                this.f5054c = b.this.f5052a.iterator();
            }

            @Override // f1.c
            @gm.a
            public E a() {
                while (this.f5054c.hasNext()) {
                    E next = this.f5054c.next();
                    if (b.this.f5053b.contains(next)) {
                        return next;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public b(final Set val$set1, final Set val$set2) {
            this.f5052a = val$set1;
            this.f5053b = val$set2;
        }

        @Override // f1.k6.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public x7<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return this.f5052a.contains(object) && this.f5053b.contains(object);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f5052a.containsAll(collection) && this.f5053b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f5053b, this.f5052a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f5052a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (this.f5053b.contains(it.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class c<E> extends m<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f5056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f5057b;

        public class a extends f1.c<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<E> f5058c;

            public a() {
                this.f5058c = c.this.f5056a.iterator();
            }

            @Override // f1.c
            @gm.a
            public E a() {
                while (this.f5058c.hasNext()) {
                    E next = this.f5058c.next();
                    if (!c.this.f5057b.contains(next)) {
                        return next;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public c(final Set val$set1, final Set val$set2) {
            this.f5056a = val$set1;
            this.f5057b = val$set2;
        }

        @Override // f1.k6.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public x7<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object element) {
            return this.f5056a.contains(element) && !this.f5057b.contains(element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f5057b.containsAll(this.f5056a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f5056a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (!this.f5057b.contains(it.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class d<E> extends m<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f5060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f5061b;

        public class a extends f1.c<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f5062c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Iterator f5063d;

            public a(final Iterator val$itr1, final Iterator val$itr2) {
                this.f5062c = val$itr1;
                this.f5063d = val$itr2;
            }

            @Override // f1.c
            @gm.a
            public E a() {
                while (this.f5062c.hasNext()) {
                    E e10 = (E) this.f5062c.next();
                    if (!d.this.f5061b.contains(e10)) {
                        return e10;
                    }
                }
                while (this.f5063d.hasNext()) {
                    E e11 = (E) this.f5063d.next();
                    if (!d.this.f5060a.contains(e11)) {
                        return e11;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public d(final Set val$set1, final Set val$set2) {
            this.f5060a = val$set1;
            this.f5061b = val$set2;
        }

        @Override // f1.k6.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public x7<E> iterator() {
            return new a(this.f5060a.iterator(), this.f5061b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object element) {
            return this.f5061b.contains(element) ^ this.f5060a.contains(element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f5060a.equals(this.f5061b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f5060a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (!this.f5061b.contains(it.next())) {
                    i10++;
                }
            }
            Iterator<E> it2 = this.f5061b.iterator();
            while (it2.hasNext()) {
                if (!this.f5060a.contains(it2.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class e<E> extends AbstractSet<Set<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k3 f5066b;

        public class a extends f1.c<Set<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final BitSet f5067c;

            /* JADX INFO: renamed from: f1.k6$e$a$a, reason: collision with other inner class name */
            public class C0117a extends AbstractSet<E> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ BitSet f5069a;

                /* JADX INFO: renamed from: f1.k6$e$a$a$a, reason: collision with other inner class name */
                public class C0118a extends f1.c<E> {

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    public int f5071c = -1;

                    public C0118a() {
                    }

                    @Override // f1.c
                    @gm.a
                    public E a() {
                        int iNextSetBit = C0117a.this.f5069a.nextSetBit(this.f5071c + 1);
                        this.f5071c = iNextSetBit;
                        return iNextSetBit == -1 ? b() : e.this.f5066b.keySet().asList().get(this.f5071c);
                    }
                }

                public C0117a(final BitSet val$copy) {
                    this.f5069a = val$copy;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(@gm.a Object o10) {
                    Integer num = (Integer) e.this.f5066b.get(o10);
                    return num != null && this.f5069a.get(num.intValue());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<E> iterator() {
                    return new C0118a();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return e.this.f5065a;
                }
            }

            public a() {
                this.f5067c = new BitSet(e.this.f5066b.size());
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Set<E> a() {
                if (this.f5067c.isEmpty()) {
                    this.f5067c.set(0, e.this.f5065a);
                } else {
                    int iNextSetBit = this.f5067c.nextSetBit(0);
                    int iNextClearBit = this.f5067c.nextClearBit(iNextSetBit);
                    if (iNextClearBit == e.this.f5066b.size()) {
                        this.f4711a = f1.c.b.DONE;
                        return null;
                    }
                    int i10 = (iNextClearBit - iNextSetBit) - 1;
                    this.f5067c.set(0, i10);
                    this.f5067c.clear(i10, iNextClearBit);
                    this.f5067c.set(iNextClearBit);
                }
                return new C0117a((BitSet) this.f5067c.clone());
            }
        }

        public e(final int val$size, final k3 val$index) {
            this.f5065a = val$size;
            this.f5066b = val$index;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof Set)) {
                return false;
            }
            Set set = (Set) o10;
            return set.size() == this.f5065a && this.f5066b.keySet().containsAll(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m1.f.a(this.f5066b.size(), this.f5065a);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder("Sets.combinations(");
            sb2.append(this.f5066b.keySet());
            sb2.append(", ");
            return c.a.a(sb2, this.f5065a, ")");
        }
    }

    public static final class f<E> extends s1<List<E>> implements Set<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient i3<t3<E>> f5073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient z<E> f5074b;

        public class a extends i3<List<E>> {
            final /* synthetic */ i3 val$axes;

            public a(final i3 val$axes) {
                this.val$axes = val$axes;
            }

            @Override // f1.e3
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.val$axes.size();
            }

            @Override // java.util.List
            public List<E> get(int i10) {
                return ((t3) this.val$axes.get(i10)).asList();
            }
        }

        public f(i3<t3<E>> axes, z<E> delegate) {
            this.f5073a = axes;
            this.f5074b = delegate;
        }

        public static <E> Set<List<E>> l(List<? extends Set<? extends E>> sets) {
            i3.a aVar = new i3.a(sets.size());
            Iterator<? extends Set<? extends E>> it = sets.iterator();
            while (it.hasNext()) {
                t3 t3VarCopyOf = t3.copyOf((Collection) it.next());
                if (t3VarCopyOf.isEmpty()) {
                    return t3.of();
                }
                aVar.j(t3VarCopyOf);
            }
            i3<E> i3VarE = aVar.e();
            return new f(i3VarE, new z(new a(i3VarE)));
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            if (!(object instanceof List)) {
                return false;
            }
            List list = (List) object;
            if (list.size() != this.f5073a.size()) {
                return false;
            }
            Iterator<E> it = list.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (!this.f5073a.get(i10).contains(it.next())) {
                    return false;
                }
                i10++;
            }
            return true;
        }

        @Override // f1.s1, f1.j2
        public Object delegate() {
            return this.f5074b;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object object) {
            return object instanceof f ? this.f5073a.equals(((f) object).f5073a) : super.equals(object);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int i10 = 1;
            int size = size() - 1;
            for (int i11 = 0; i11 < this.f5073a.size(); i11++) {
                size = ~(~(size * 31));
            }
            x7<t3<E>> it = this.f5073a.iterator();
            while (it.hasNext()) {
                t3<E> next = it.next();
                i10 = ~(~((next.hashCode() * (size() / next.size())) + (i10 * 31)));
            }
            return ~(~(i10 + size));
        }

        @Override // f1.s1, f1.j2
        public Collection<List<E>> delegate() {
            return this.f5074b;
        }
    }

    @b1.c
    public static class g<E> extends i2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableSet<E> f5075a;

        public g(NavigableSet<E> forward) {
            this.f5075a = forward;
        }

        public static <T> l5<T> A(Comparator<T> forward) {
            return l5.from(forward).reverse();
        }

        @Override // f1.i2, java.util.NavigableSet
        @gm.a
        public E ceiling(@m5 E e10) {
            return this.f5075a.floor(e10);
        }

        @Override // f1.p2, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.f5075a.comparator();
            return comparator == null ? l5.natural().reverse() : A(comparator);
        }

        @Override // f1.i2, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.f5075a.iterator();
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.f5075a;
        }

        @Override // f1.p2, java.util.SortedSet
        @m5
        public E first() {
            return this.f5075a.last();
        }

        @Override // f1.i2, java.util.NavigableSet
        @gm.a
        public E floor(@m5 E e10) {
            return this.f5075a.ceiling(e10);
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> headSet(@m5 E toElement, boolean inclusive) {
            return this.f5075a.tailSet(toElement, inclusive).descendingSet();
        }

        @Override // f1.i2, java.util.NavigableSet
        @gm.a
        public E higher(@m5 E e10) {
            return this.f5075a.lower(e10);
        }

        @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.f5075a.descendingIterator();
        }

        @Override // f1.i2, f1.p2, f1.l2, f1.s1, f1.j2
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableSet<E> delegate() {
            return this.f5075a;
        }

        @Override // f1.p2, java.util.SortedSet
        @m5
        public E last() {
            return this.f5075a.first();
        }

        @Override // f1.i2, java.util.NavigableSet
        @gm.a
        public E lower(@m5 E e10) {
            return this.f5075a.higher(e10);
        }

        @Override // f1.i2, java.util.NavigableSet
        @gm.a
        public E pollFirst() {
            return this.f5075a.pollLast();
        }

        @Override // f1.i2, java.util.NavigableSet
        @gm.a
        public E pollLast() {
            return this.f5075a.pollFirst();
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> subSet(@m5 E fromElement, boolean fromInclusive, @m5 E toElement, boolean toInclusive) {
            return this.f5075a.subSet(toElement, toInclusive, fromElement, fromInclusive).descendingSet();
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> tailSet(@m5 E fromElement, boolean inclusive) {
            return this.f5075a.headSet(fromElement, inclusive).descendingSet();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // f1.j2
        public String toString() {
            return standardToString();
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(@m5 E toElement) {
            return s(toElement);
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(@m5 E fromElement, @m5 E toElement) {
            return standardSubSet(fromElement, toElement);
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(@m5 E fromElement) {
            return z(fromElement);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    @b1.c
    public static class h<E> extends j<E> implements NavigableSet<E> {
        public h(NavigableSet<E> unfiltered, c1.i0<? super E> predicate) {
            super((Collection) unfiltered, (c1.i0) predicate);
        }

        public NavigableSet<E> b() {
            return (NavigableSet) this.f4715a;
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E ceiling(@m5 E e10) {
            return (E) g4.r(b().tailSet(e10, true), this.f4716b, null);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return h4.x(b().descendingIterator(), this.f4716b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return k6.h(b().descendingSet(), this.f4716b);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E floor(@m5 E e10) {
            return (E) h4.A(b().headSet(e10, true).descendingIterator(), this.f4716b, null);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@m5 E toElement, boolean inclusive) {
            return k6.h(b().headSet(toElement, inclusive), this.f4716b);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E higher(@m5 E e10) {
            return (E) g4.r(b().tailSet(e10, false), this.f4716b, null);
        }

        @Override // f1.k6.j, java.util.SortedSet
        @m5
        public E last() {
            return (E) h4.z(b().descendingIterator(), this.f4716b);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E lower(@m5 E e10) {
            return (E) h4.A(b().headSet(e10, false).descendingIterator(), this.f4716b, null);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollFirst() {
            return (E) g4.I(b(), this.f4716b);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollLast() {
            return (E) g4.I(b().descendingSet(), this.f4716b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@m5 E fromElement, boolean fromInclusive, @m5 E toElement, boolean toInclusive) {
            return k6.h(b().subSet(fromElement, fromInclusive, toElement, toInclusive), this.f4716b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@m5 E fromElement, boolean inclusive) {
            return k6.h(b().tailSet(fromElement, inclusive), this.f4716b);
        }
    }

    public static class i<E> extends c0.a<E> implements Set<E> {
        public i(Set<E> unfiltered, c1.i0<? super E> predicate) {
            super(unfiltered, predicate);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object object) {
            return k6.g(this, object);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return k6.k(this);
        }
    }

    public static class j<E> extends i<E> implements SortedSet<E> {
        public j(SortedSet<E> unfiltered, c1.i0<? super E> predicate) {
            super((Collection) unfiltered, (c1.i0) predicate);
        }

        @Override // java.util.SortedSet
        @gm.a
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f4715a).comparator();
        }

        @Override // java.util.SortedSet
        @m5
        public E first() {
            return (E) h4.z(this.f4715a.iterator(), this.f4716b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(@m5 E toElement) {
            return new j((Collection) ((SortedSet) this.f4715a).headSet(toElement), (c1.i0) this.f4716b);
        }

        @m5
        public E last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f4715a;
            while (true) {
                E e10 = (Object) sortedSetHeadSet.last();
                if (this.f4716b.apply(e10)) {
                    return e10;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(e10);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(@m5 E fromElement, @m5 E toElement) {
            return new j((Collection) ((SortedSet) this.f4715a).subSet(fromElement, toElement), (c1.i0) this.f4716b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(@m5 E fromElement) {
            return new j((Collection) ((SortedSet) this.f4715a).tailSet(fromElement), (c1.i0) this.f4716b);
        }
    }

    public static abstract class k<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c10) {
            return k6.I(this, c10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c10) {
            c10.getClass();
            return super.retainAll(c10);
        }
    }

    public static final class l<E> extends AbstractSet<Set<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k3<E, Integer> f5076a;

        public class a extends f1.b<Set<E>> {
            public a(int size) {
                super(size, 0);
            }

            @Override // f1.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Set<E> a(final int setBits) {
                return new n(l.this.f5076a, setBits);
            }
        }

        public l(Set<E> input) {
            c1.h0.k(input.size() <= 30, "Too many elements to create power set: %s > 30", input.size());
            this.f5076a = t4.Q(input);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.f5076a.keySet().containsAll((Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object obj) {
            return obj instanceof l ? this.f5076a.keySet().equals(((l) obj).f5076a.keySet()) : super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f5076a.keySet().hashCode() << (this.f5076a.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a(size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.f5076a.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "powerSet(" + this.f5076a + ")";
        }
    }

    public static abstract class m<E> extends AbstractSet<E> {
        public m() {
        }

        @t1.a
        public <S extends Set<E>> S a(S set) {
            set.addAll(this);
            return set;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.a
        @Deprecated
        @t1.e("Always throws UnsupportedOperationException")
        public final boolean add(@m5 E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.a
        @Deprecated
        @t1.e("Always throws UnsupportedOperationException")
        public final boolean addAll(Collection<? extends E> newElements) {
            throw new UnsupportedOperationException();
        }

        public t3<E> b() {
            return t3.copyOf((Collection) this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public abstract x7<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.e("Always throws UnsupportedOperationException")
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.a
        @t1.e("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean remove(@gm.a Object object) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.a
        @Deprecated
        @t1.e("Always throws UnsupportedOperationException")
        public final boolean removeAll(Collection<?> oldElements) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.a
        @Deprecated
        @t1.e("Always throws UnsupportedOperationException")
        public final boolean retainAll(Collection<?> elementsToKeep) {
            throw new UnsupportedOperationException();
        }

        public m(a aVar) {
        }
    }

    public static final class n<E> extends AbstractSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k3<E, Integer> f5078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5079b;

        public class a extends x7<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final i3<E> f5080a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f5081b;

            public a() {
                this.f5080a = n.this.f5078a.keySet().asList();
                this.f5081b = n.this.f5079b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f5081b != 0;
            }

            @Override // java.util.Iterator
            public E next() {
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(this.f5081b);
                if (iNumberOfTrailingZeros == 32) {
                    throw new NoSuchElementException();
                }
                this.f5081b &= ~(1 << iNumberOfTrailingZeros);
                return this.f5080a.get(iNumberOfTrailingZeros);
            }
        }

        public n(k3<E, Integer> inputSet, int mask) {
            this.f5078a = inputSet;
            this.f5079b = mask;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            Integer num = this.f5078a.get(o10);
            return (num == null || (this.f5079b & (1 << num.intValue())) == 0) ? false : true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.f5079b);
        }
    }

    public static <E> LinkedHashSet<E> A() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> B(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new LinkedHashSet<>((Collection) elements);
        }
        LinkedHashSet<E> linkedHashSet = new LinkedHashSet<>();
        g4.a(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static <E> LinkedHashSet<E> C(int expectedSize) {
        return new LinkedHashSet<>(t4.o(expectedSize));
    }

    @Deprecated
    public static <E> Set<E> D(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> E() {
        return new TreeSet<>();
    }

    public static <E extends Comparable> TreeSet<E> F(Iterable<? extends E> elements) {
        TreeSet<E> treeSet = new TreeSet<>();
        g4.a(treeSet, elements);
        return treeSet;
    }

    public static <E> TreeSet<E> G(Comparator<? super E> comparator) {
        comparator.getClass();
        return new TreeSet<>(comparator);
    }

    @b1.b(serializable = false)
    public static <E> Set<Set<E>> H(Set<E> set) {
        return new l(set);
    }

    public static boolean I(Set<?> set, Collection<?> collection) {
        collection.getClass();
        if (collection instanceof b5) {
            collection = ((b5) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? J(set, collection.iterator()) : h4.V(set.iterator(), collection);
    }

    public static boolean J(Set<?> set, Iterator<?> iterator) {
        boolean zRemove = false;
        while (iterator.hasNext()) {
            zRemove |= set.remove(iterator.next());
        }
        return zRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    public static <K extends Comparable<? super K>> NavigableSet<K> K(NavigableSet<K> set, q5<K> range) {
        if (set.comparator() != null && set.comparator() != l5.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            c1.h0.e(set.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            Comparable comparableLowerEndpoint = range.lowerEndpoint();
            x xVarLowerBoundType = range.lowerBoundType();
            x xVar = x.CLOSED;
            return set.subSet(comparableLowerEndpoint, xVarLowerBoundType == xVar, range.upperEndpoint(), range.upperBoundType() == xVar);
        }
        if (range.hasLowerBound()) {
            return set.tailSet(range.lowerEndpoint(), range.lowerBoundType() == x.CLOSED);
        }
        if (range.hasUpperBound()) {
            return set.headSet(range.upperEndpoint(), range.upperBoundType() == x.CLOSED);
        }
        return set;
    }

    public static <E> m<E> L(final Set<? extends E> set1, final Set<? extends E> set2) {
        c1.h0.F(set1, "set1");
        c1.h0.F(set2, "set2");
        return new d(set1, set2);
    }

    @b1.c
    public static <E> NavigableSet<E> M(NavigableSet<E> navigableSet) {
        return y6.q(navigableSet);
    }

    public static <E> m<E> N(final Set<? extends E> set1, final Set<? extends E> set2) {
        c1.h0.F(set1, "set1");
        c1.h0.F(set2, "set2");
        return new a(set1, set2);
    }

    public static <E> NavigableSet<E> O(NavigableSet<E> set) {
        return ((set instanceof e3) || (set instanceof o)) ? set : new o(set);
    }

    public static <B> Set<List<B>> a(List<? extends Set<? extends B>> sets) {
        return f.l(sets);
    }

    @SafeVarargs
    public static <B> Set<List<B>> b(Set<? extends B>... sets) {
        return f.l(Arrays.asList(sets));
    }

    public static <E> Set<Set<E>> c(Set<E> set, final int size) {
        k3 k3VarQ = t4.Q(set);
        b0.b(size, ik.f.b.f7973h);
        c1.h0.m(size <= k3VarQ.size(), "size (%s) must be <= set.size() (%s)", size, k3VarQ.size());
        if (size == 0) {
            return t3.of(t3.of());
        }
        return size == k3VarQ.size() ? t3.of(k3VarQ.keySet()) : new e(size, k3VarQ);
    }

    @b1.c
    @b1.d
    public static <E extends Enum<E>> EnumSet<E> d(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        c1.h0.e(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return o(collection, collection.iterator().next().getDeclaringClass());
    }

    @b1.c
    public static <E extends Enum<E>> EnumSet<E> e(Collection<E> collection, Class<E> type) {
        collection.getClass();
        return collection instanceof EnumSet ? EnumSet.complementOf((EnumSet) collection) : o(collection, type);
    }

    public static <E> m<E> f(final Set<E> set1, final Set<?> set2) {
        c1.h0.F(set1, "set1");
        c1.h0.F(set2, "set2");
        return new c(set1, set2);
    }

    public static boolean g(Set<?> s10, @gm.a Object object) {
        if (s10 == object) {
            return true;
        }
        if (object instanceof Set) {
            Set set = (Set) object;
            try {
                return s10.size() == set.size() && s10.containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    public static <E> NavigableSet<E> h(NavigableSet<E> unfiltered, c1.i0<? super E> predicate) {
        if (unfiltered instanceof i) {
            i iVar = (i) unfiltered;
            return new h(iVar.f4715a, c1.j0.d(iVar.f4716b, predicate));
        }
        unfiltered.getClass();
        predicate.getClass();
        return new h((Collection) unfiltered, (c1.i0) predicate);
    }

    public static <E> Set<E> i(Set<E> unfiltered, c1.i0<? super E> predicate) {
        if (unfiltered instanceof SortedSet) {
            return j((SortedSet) unfiltered, predicate);
        }
        if (unfiltered instanceof i) {
            i iVar = (i) unfiltered;
            return new i(iVar.f4715a, c1.j0.d(iVar.f4716b, predicate));
        }
        unfiltered.getClass();
        predicate.getClass();
        return new i((Collection) unfiltered, (c1.i0) predicate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> j(SortedSet<E> unfiltered, c1.i0<? super E> predicate) {
        if (unfiltered instanceof i) {
            i iVar = (i) unfiltered;
            return new j(iVar.f4715a, c1.j0.d(iVar.f4716b, predicate));
        }
        unfiltered.getClass();
        predicate.getClass();
        return new j((Collection) unfiltered, (c1.i0) predicate);
    }

    public static int k(Set<?> s10) {
        Iterator<?> it = s10.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    @b1.b(serializable = true)
    public static <E extends Enum<E>> t3<E> l(E anElement, E... otherElements) {
        return h3.asImmutable(EnumSet.of((Enum) anElement, (Enum[]) otherElements));
    }

    @b1.b(serializable = true)
    public static <E extends Enum<E>> t3<E> m(Iterable<E> elements) {
        if (elements instanceof h3) {
            return (h3) elements;
        }
        if (elements instanceof Collection) {
            Collection collection = (Collection) elements;
            return collection.isEmpty() ? t3.of() : h3.asImmutable(EnumSet.copyOf(collection));
        }
        Iterator<E> it = elements.iterator();
        if (!it.hasNext()) {
            return t3.of();
        }
        EnumSet enumSetOf = EnumSet.of((Enum) it.next());
        h4.a(enumSetOf, it);
        return h3.asImmutable(enumSetOf);
    }

    public static <E> m<E> n(final Set<E> set1, final Set<?> set2) {
        c1.h0.F(set1, "set1");
        c1.h0.F(set2, "set2");
        return new b(set1, set2);
    }

    @b1.c
    public static <E extends Enum<E>> EnumSet<E> o(Collection<E> collection, Class<E> type) {
        EnumSet<E> enumSetAllOf = EnumSet.allOf(type);
        enumSetAllOf.removeAll(collection);
        return enumSetAllOf;
    }

    public static <E> Set<E> p() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> q(Iterable<? extends E> elements) {
        Set<E> setP = p();
        g4.a(setP, elements);
        return setP;
    }

    @b1.c
    @b1.d
    public static <E> CopyOnWriteArraySet<E> r() {
        return new CopyOnWriteArraySet<>();
    }

    @b1.c
    @b1.d
    public static <E> CopyOnWriteArraySet<E> s(Iterable<? extends E> elements) {
        return new CopyOnWriteArraySet<>(elements instanceof Collection ? (Collection) elements : p4.r(elements));
    }

    public static <E extends Enum<E>> EnumSet<E> t(Iterable<E> iterable, Class<E> elementType) {
        EnumSet<E> enumSetNoneOf = EnumSet.noneOf(elementType);
        g4.a(enumSetNoneOf, iterable);
        return enumSetNoneOf;
    }

    public static <E> HashSet<E> u() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> v(Iterable<? extends E> elements) {
        return elements instanceof Collection ? new HashSet<>((Collection) elements) : w(elements.iterator());
    }

    public static <E> HashSet<E> w(Iterator<? extends E> elements) {
        HashSet<E> hashSet = new HashSet<>();
        h4.a(hashSet, elements);
        return hashSet;
    }

    public static <E> HashSet<E> x(E... elements) {
        HashSet<E> hashSetY = y(elements.length);
        Collections.addAll(hashSetY, elements);
        return hashSetY;
    }

    public static <E> HashSet<E> y(int expectedSize) {
        return new HashSet<>(t4.o(expectedSize));
    }

    public static <E> Set<E> z() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static final class o<E> extends p2<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient o<E> f5083a;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        public o(NavigableSet<E> delegate) {
            delegate.getClass();
            this.delegate = delegate;
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(delegate);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E ceiling(@m5 E e10) {
            return this.delegate.ceiling(e10);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return h4.f0(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            o<E> oVar = this.f5083a;
            if (oVar != null) {
                return oVar;
            }
            o<E> oVar2 = new o<>(this.delegate.descendingSet());
            this.f5083a = oVar2;
            oVar2.f5083a = this;
            return oVar2;
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E floor(@m5 E e10) {
            return this.delegate.floor(e10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@m5 E toElement, boolean inclusive) {
            return k6.O(this.delegate.headSet(toElement, inclusive));
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E higher(@m5 E e10) {
            return this.delegate.higher(e10);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E lower(@m5 E e10) {
            return this.delegate.lower(e10);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@m5 E fromElement, boolean fromInclusive, @m5 E toElement, boolean toInclusive) {
            return k6.O(this.delegate.subSet(fromElement, fromInclusive, toElement, toInclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@m5 E fromElement, boolean inclusive) {
            return k6.O(this.delegate.tailSet(fromElement, inclusive));
        }

        @Override // f1.p2, f1.l2, f1.s1, f1.j2
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }
    }
}
