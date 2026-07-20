package f1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class c5 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class a<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b5 f4732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b5 f4733d;

        /* JADX INFO: renamed from: f1.c5$a$a, reason: collision with other inner class name */
        public class C0110a extends f1.c<b5.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f4734c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Iterator f4735d;

            public C0110a(final Iterator val$iterator1, final Iterator val$iterator2) {
                this.f4734c = val$iterator1;
                this.f4735d = val$iterator2;
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public b5.a<E> a() {
                if (this.f4734c.hasNext()) {
                    b5.a aVar = (b5.a) this.f4734c.next();
                    Object element = aVar.getElement();
                    return new k(element, Math.max(aVar.getCount(), a.this.f4733d.count(element)));
                }
                while (this.f4735d.hasNext()) {
                    b5.a aVar2 = (b5.a) this.f4735d.next();
                    Object element2 = aVar2.getElement();
                    if (!a.this.f4732c.contains(element2)) {
                        return new k(element2, aVar2.getCount());
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public a(final b5 val$multiset1, final b5 val$multiset2) {
            this.f4732c = val$multiset1;
            this.f4733d = val$multiset2;
        }

        @Override // f1.i, java.util.AbstractCollection, java.util.Collection, f1.b5
        public boolean contains(@gm.a Object element) {
            return this.f4732c.contains(element) || this.f4733d.contains(element);
        }

        @Override // f1.b5
        public int count(@gm.a Object element) {
            return Math.max(this.f4732c.count(element), this.f4733d.count(element));
        }

        @Override // f1.i
        public Set<E> createElementSet() {
            return k6.N(this.f4732c.elementSet(), this.f4733d.elementSet());
        }

        @Override // f1.i
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // f1.i
        public Iterator<b5.a<E>> entryIterator() {
            return new C0110a(this.f4732c.entrySet().iterator(), this.f4733d.entrySet().iterator());
        }

        @Override // f1.i, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f4732c.isEmpty() && this.f4733d.isEmpty();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class b<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b5 f4737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b5 f4738d;

        public class a extends f1.c<b5.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f4739c;

            public a(final Iterator val$iterator1) {
                this.f4739c = val$iterator1;
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public b5.a<E> a() {
                while (this.f4739c.hasNext()) {
                    b5.a aVar = (b5.a) this.f4739c.next();
                    Object element = aVar.getElement();
                    int iMin = Math.min(aVar.getCount(), b.this.f4738d.count(element));
                    if (iMin > 0) {
                        return new k(element, iMin);
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public b(final b5 val$multiset1, final b5 val$multiset2) {
            this.f4737c = val$multiset1;
            this.f4738d = val$multiset2;
        }

        @Override // f1.b5
        public int count(@gm.a Object element) {
            int iCount = this.f4737c.count(element);
            if (iCount == 0) {
                return 0;
            }
            return Math.min(iCount, this.f4738d.count(element));
        }

        @Override // f1.i
        public Set<E> createElementSet() {
            return k6.n(this.f4737c.elementSet(), this.f4738d.elementSet());
        }

        @Override // f1.i
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // f1.i
        public Iterator<b5.a<E>> entryIterator() {
            return new a(this.f4737c.entrySet().iterator());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class c<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b5 f4741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b5 f4742d;

        public class a extends f1.c<b5.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f4743c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Iterator f4744d;

            public a(final Iterator val$iterator1, final Iterator val$iterator2) {
                this.f4743c = val$iterator1;
                this.f4744d = val$iterator2;
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public b5.a<E> a() {
                if (this.f4743c.hasNext()) {
                    b5.a aVar = (b5.a) this.f4743c.next();
                    Object element = aVar.getElement();
                    return new k(element, c.this.f4742d.count(element) + aVar.getCount());
                }
                while (this.f4744d.hasNext()) {
                    b5.a aVar2 = (b5.a) this.f4744d.next();
                    Object element2 = aVar2.getElement();
                    if (!c.this.f4741c.contains(element2)) {
                        return new k(element2, aVar2.getCount());
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public c(final b5 val$multiset1, final b5 val$multiset2) {
            this.f4741c = val$multiset1;
            this.f4742d = val$multiset2;
        }

        @Override // f1.i, java.util.AbstractCollection, java.util.Collection, f1.b5
        public boolean contains(@gm.a Object element) {
            return this.f4741c.contains(element) || this.f4742d.contains(element);
        }

        @Override // f1.b5
        public int count(@gm.a Object element) {
            return this.f4742d.count(element) + this.f4741c.count(element);
        }

        @Override // f1.i
        public Set<E> createElementSet() {
            return k6.N(this.f4741c.elementSet(), this.f4742d.elementSet());
        }

        @Override // f1.i
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // f1.i
        public Iterator<b5.a<E>> entryIterator() {
            return new a(this.f4741c.entrySet().iterator(), this.f4742d.entrySet().iterator());
        }

        @Override // f1.i, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f4741c.isEmpty() && this.f4742d.isEmpty();
        }

        @Override // f1.c5.n, java.util.AbstractCollection, java.util.Collection, f1.b5
        public int size() {
            return m1.f.t(this.f4741c.size(), this.f4742d.size());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class d<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b5 f4746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b5 f4747d;

        public class a extends f1.c<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f4748c;

            public a(final Iterator val$iterator1) {
                this.f4748c = val$iterator1;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // f1.c
            @gm.a
            public E a() {
                while (this.f4748c.hasNext()) {
                    b5.a aVar = (b5.a) this.f4748c.next();
                    E e10 = (E) aVar.getElement();
                    if (aVar.getCount() > d.this.f4747d.count(e10)) {
                        return e10;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public class b extends f1.c<b5.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f4750c;

            public b(final Iterator val$iterator1) {
                this.f4750c = val$iterator1;
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public b5.a<E> a() {
                while (this.f4750c.hasNext()) {
                    b5.a aVar = (b5.a) this.f4750c.next();
                    Object element = aVar.getElement();
                    int count = aVar.getCount() - d.this.f4747d.count(element);
                    if (count > 0) {
                        return new k(element, count);
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public d(final b5 val$multiset1, final b5 val$multiset2) {
            this.f4746c = val$multiset1;
            this.f4747d = val$multiset2;
        }

        @Override // f1.c5.n, f1.i, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // f1.b5
        public int count(@gm.a Object element) {
            int iCount = this.f4746c.count(element);
            if (iCount == 0) {
                return 0;
            }
            return Math.max(0, iCount - this.f4747d.count(element));
        }

        @Override // f1.c5.n, f1.i
        public int distinctElements() {
            return h4.Z(entryIterator());
        }

        @Override // f1.i
        public Iterator<E> elementIterator() {
            return new a(this.f4746c.entrySet().iterator());
        }

        @Override // f1.i
        public Iterator<b5.a<E>> entryIterator() {
            return new b(this.f4746c.entrySet().iterator());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class e<E> extends o7<b5.a<E>, E> {
        public e(Iterator backingIterator) {
            super(backingIterator);
        }

        @Override // f1.o7
        @m5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(b5.a<E> entry) {
            return entry.getElement();
        }
    }

    public static abstract class f<E> implements b5.a<E> {
        @Override // f1.b5.a
        public boolean equals(@gm.a Object object) {
            if (!(object instanceof b5.a)) {
                return false;
            }
            b5.a aVar = (b5.a) object;
            return getCount() == aVar.getCount() && c1.b0.a(getElement(), aVar.getElement());
        }

        @Override // f1.b5.a
        public int hashCode() {
            E element = getElement();
            return getCount() ^ (element == null ? 0 : element.hashCode());
        }

        @Override // f1.b5.a
        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    public static final class g implements Comparator<b5.a<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f4752a = new g();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b5.a<?> entry1, b5.a<?> entry2) {
            return entry2.getCount() - entry1.getCount();
        }
    }

    public static abstract class h<E> extends k6.k<E> {
        public abstract b5<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            return a().contains(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c10) {
            return a().containsAll(c10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract Iterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            return a().remove(o10, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    public static abstract class i<E> extends k6.k<b5.a<E>> {
        public abstract b5<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof b5.a)) {
                return false;
            }
            b5.a aVar = (b5.a) o10;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object obj) {
            if (obj instanceof b5.a) {
                b5.a aVar = (b5.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    public static final class j<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b5<E> f4753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c1.i0<? super E> f4754d;

        public class a implements c1.i0<b5.a<E>> {
            public a() {
            }

            @Override // c1.i0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(b5.a<E> entry) {
                return j.this.f4754d.apply(entry.getElement());
            }
        }

        public j(b5<E> unfiltered, c1.i0<? super E> predicate) {
            unfiltered.getClass();
            this.f4753c = unfiltered;
            predicate.getClass();
            this.f4754d = predicate;
        }

        @Override // f1.c5.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, f1.b5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x7<E> iterator() {
            return h4.x(this.f4753c.iterator(), this.f4754d);
        }

        @Override // f1.i, f1.b5
        public int add(@m5 E element, int occurrences) {
            c1.h0.y(this.f4754d.apply(element), "Element %s does not match predicate %s", element, this.f4754d);
            return this.f4753c.add(element, occurrences);
        }

        @Override // f1.b5
        public int count(@gm.a Object element) {
            int iCount = this.f4753c.count(element);
            if (iCount <= 0 || !this.f4754d.apply(element)) {
                return 0;
            }
            return iCount;
        }

        @Override // f1.i
        public Set<E> createElementSet() {
            return k6.i(this.f4753c.elementSet(), this.f4754d);
        }

        @Override // f1.i
        public Set<b5.a<E>> createEntrySet() {
            return k6.i(this.f4753c.entrySet(), new a());
        }

        @Override // f1.i
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // f1.i
        public Iterator<b5.a<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // f1.i, f1.b5
        public int remove(@gm.a Object element, int occurrences) {
            b0.b(occurrences, "occurrences");
            if (occurrences == 0) {
                return count(element);
            }
            if (contains(element)) {
                return this.f4753c.remove(element, occurrences);
            }
            return 0;
        }
    }

    public static class k<E> extends f<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @m5
        private final E element;

        public k(@m5 E element, int count) {
            this.element = element;
            this.count = count;
            b0.b(count, "count");
        }

        @Override // f1.b5.a
        public final int getCount() {
            return this.count;
        }

        @Override // f1.b5.a
        @m5
        public final E getElement() {
            return this.element;
        }

        @gm.a
        public k<E> nextInBucket() {
            return null;
        }
    }

    public static final class l<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b5<E> f4756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<b5.a<E>> f4757b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public b5.a<E> f4758c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4759d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4760e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f4761f;

        public l(b5<E> multiset, Iterator<b5.a<E>> entryIterator) {
            this.f4756a = multiset;
            this.f4757b = entryIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4759d > 0 || this.f4757b.hasNext();
        }

        @Override // java.util.Iterator
        @m5
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f4759d == 0) {
                b5.a<E> next = this.f4757b.next();
                this.f4758c = next;
                int count = next.getCount();
                this.f4759d = count;
                this.f4760e = count;
            }
            this.f4759d--;
            this.f4761f = true;
            b5.a<E> aVar = this.f4758c;
            Objects.requireNonNull(aVar);
            return aVar.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            b0.e(this.f4761f);
            if (this.f4760e == 1) {
                this.f4757b.remove();
            } else {
                b5<E> b5Var = this.f4756a;
                b5.a<E> aVar = this.f4758c;
                Objects.requireNonNull(aVar);
                b5Var.remove(aVar.getElement());
            }
            this.f4760e--;
            this.f4761f = false;
        }
    }

    public static class m<E> extends g2<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final b5<? extends E> delegate;

        @u1.b
        @gm.a
        transient Set<E> elementSet;

        @u1.b
        @gm.a
        transient Set<b5.a<E>> entrySet;

        public m(b5<? extends E> delegate) {
            this.delegate = delegate;
        }

        @Override // f1.s1, java.util.Collection, f1.b5
        public boolean add(@m5 E element) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.s1, java.util.Collection
        public boolean addAll(Collection<? extends E> elementsToAdd) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // f1.g2, f1.b5, f1.r6, f1.s6
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            Set<E> setCreateElementSet = createElementSet();
            this.elementSet = setCreateElementSet;
            return setCreateElementSet;
        }

        @Override // f1.g2, f1.b5
        public Set<b5.a<E>> entrySet() {
            Set<b5.a<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<b5.a<E>> setUnmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return h4.f0(this.delegate.iterator());
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object element) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> elementsToRemove) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> elementsToRetain) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.g2, f1.b5
        public int setCount(@m5 E element, int count) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.g2, f1.b5
        public int add(@m5 E element, int occurrences) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.g2, f1.b5
        public int remove(@gm.a Object element, int occurrences) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.g2, f1.b5
        public boolean setCount(@m5 E element, int oldCount, int newCount) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.g2, f1.s1, f1.j2
        public b5<E> delegate() {
            return this.delegate;
        }
    }

    public static abstract class n<E> extends f1.i<E> {
        public n() {
        }

        @Override // f1.i, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // f1.i
        public int distinctElements() {
            return elementSet().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, f1.b5
        public Iterator<E> iterator() {
            return c5.n(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
        public int size() {
            return c5.o(this);
        }

        public n(a aVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> b5<E> A(b5<? extends E> multiset) {
        if ((multiset instanceof m) || (multiset instanceof p3)) {
            return multiset;
        }
        multiset.getClass();
        return new m(multiset);
    }

    public static <E> r6<E> B(r6<E> sortedMultiset) {
        sortedMultiset.getClass();
        return new z7(sortedMultiset);
    }

    public static <E> boolean a(b5<E> self, f1.f<? extends E> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        elements.addTo(self);
        return true;
    }

    public static <E> boolean b(b5<E> self, b5<? extends E> elements) {
        if (elements instanceof f1.f) {
            return a(self, (f1.f) elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        for (b5.a<? extends E> aVar : elements.entrySet()) {
            self.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    public static <E> boolean c(b5<E> self, Collection<? extends E> elements) {
        self.getClass();
        elements.getClass();
        if (elements instanceof b5) {
            return b(self, (b5) elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        return h4.a(self, elements.iterator());
    }

    public static <T> b5<T> d(Iterable<T> iterable) {
        return (b5) iterable;
    }

    @t1.a
    public static boolean e(b5<?> superMultiset, b5<?> subMultiset) {
        superMultiset.getClass();
        subMultiset.getClass();
        for (b5.a<?> aVar : subMultiset.entrySet()) {
            if (superMultiset.count(aVar.getElement()) < aVar.getCount()) {
                return false;
            }
        }
        return true;
    }

    public static <E> p3<E> f(b5<E> multiset) {
        b5.a[] aVarArr = (b5.a[]) multiset.entrySet().toArray(new b5.a[0]);
        Arrays.sort(aVarArr, g.f4752a);
        return p3.copyFromEntries(Arrays.asList(aVarArr));
    }

    public static <E> b5<E> g(final b5<E> multiset1, final b5<?> multiset2) {
        multiset1.getClass();
        multiset2.getClass();
        return new d(multiset1, multiset2);
    }

    public static <E> Iterator<E> h(Iterator<b5.a<E>> entryIterator) {
        return new e(entryIterator);
    }

    public static boolean i(b5<?> multiset, @gm.a Object object) {
        if (object == multiset) {
            return true;
        }
        if (object instanceof b5) {
            b5 b5Var = (b5) object;
            if (multiset.size() == b5Var.size() && multiset.entrySet().size() == b5Var.entrySet().size()) {
                for (b5.a aVar : b5Var.entrySet()) {
                    if (multiset.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> b5<E> j(b5<E> unfiltered, c1.i0<? super E> predicate) {
        if (!(unfiltered instanceof j)) {
            return new j(unfiltered, predicate);
        }
        j jVar = (j) unfiltered;
        return new j(jVar.f4753c, c1.j0.d(jVar.f4754d, predicate));
    }

    public static <E> b5.a<E> k(@m5 E e10, int n10) {
        return new k(e10, n10);
    }

    public static int l(Iterable<?> elements) {
        if (elements instanceof b5) {
            return ((b5) elements).elementSet().size();
        }
        return 11;
    }

    public static <E> b5<E> m(final b5<E> multiset1, final b5<?> multiset2) {
        multiset1.getClass();
        multiset2.getClass();
        return new b(multiset1, multiset2);
    }

    public static <E> Iterator<E> n(b5<E> multiset) {
        return new l(multiset, multiset.entrySet().iterator());
    }

    public static int o(b5<?> multiset) {
        Iterator<b5.a<?>> it = multiset.entrySet().iterator();
        long count = 0;
        while (it.hasNext()) {
            count += (long) it.next().getCount();
        }
        return o1.l.z(count);
    }

    public static boolean p(b5<?> self, Collection<?> elementsToRemove) {
        if (elementsToRemove instanceof b5) {
            elementsToRemove = ((b5) elementsToRemove).elementSet();
        }
        return self.elementSet().removeAll(elementsToRemove);
    }

    @t1.a
    public static boolean q(b5<?> multisetToModify, b5<?> occurrencesToRemove) {
        multisetToModify.getClass();
        occurrencesToRemove.getClass();
        Iterator<b5.a<?>> it = multisetToModify.entrySet().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            b5.a<?> next = it.next();
            int iCount = occurrencesToRemove.count(next.getElement());
            if (iCount >= next.getCount()) {
                it.remove();
            } else if (iCount > 0) {
                multisetToModify.remove(next.getElement(), iCount);
            }
            z10 = true;
        }
        return z10;
    }

    @t1.a
    public static boolean r(b5<?> multisetToModify, Iterable<?> occurrencesToRemove) {
        if (occurrencesToRemove instanceof b5) {
            return q(multisetToModify, (b5) occurrencesToRemove);
        }
        multisetToModify.getClass();
        occurrencesToRemove.getClass();
        Iterator<?> it = occurrencesToRemove.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= multisetToModify.remove(it.next());
        }
        return zRemove;
    }

    public static boolean s(b5<?> self, Collection<?> elementsToRetain) {
        elementsToRetain.getClass();
        if (elementsToRetain instanceof b5) {
            elementsToRetain = ((b5) elementsToRetain).elementSet();
        }
        return self.elementSet().retainAll(elementsToRetain);
    }

    @t1.a
    public static boolean t(b5<?> multisetToModify, b5<?> multisetToRetain) {
        return u(multisetToModify, multisetToRetain);
    }

    public static <E> boolean u(b5<E> multisetToModify, b5<?> occurrencesToRetain) {
        multisetToModify.getClass();
        occurrencesToRetain.getClass();
        Iterator<b5.a<E>> it = multisetToModify.entrySet().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            b5.a<E> next = it.next();
            int iCount = occurrencesToRetain.count(next.getElement());
            if (iCount == 0) {
                it.remove();
            } else if (iCount < next.getCount()) {
                multisetToModify.setCount(next.getElement(), iCount);
            }
            z10 = true;
        }
        return z10;
    }

    public static <E> int v(b5<E> self, @m5 E element, int count) {
        b0.b(count, "count");
        int iCount = self.count(element);
        int i10 = count - iCount;
        if (i10 > 0) {
            self.add(element, i10);
        } else if (i10 < 0) {
            self.remove(element, -i10);
        }
        return iCount;
    }

    public static <E> boolean w(b5<E> self, @m5 E element, int oldCount, int newCount) {
        b0.b(oldCount, "oldCount");
        b0.b(newCount, "newCount");
        if (self.count(element) != oldCount) {
            return false;
        }
        self.setCount(element, newCount);
        return true;
    }

    public static <E> b5<E> x(final b5<? extends E> multiset1, final b5<? extends E> multiset2) {
        multiset1.getClass();
        multiset2.getClass();
        return new c(multiset1, multiset2);
    }

    public static <E> b5<E> y(final b5<? extends E> multiset1, final b5<? extends E> multiset2) {
        multiset1.getClass();
        multiset2.getClass();
        return new a(multiset1, multiset2);
    }

    @Deprecated
    public static <E> b5<E> z(p3<E> multiset) {
        multiset.getClass();
        return multiset;
    }
}
