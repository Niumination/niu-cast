package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class t7<E> extends o<E> implements Serializable {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient g<f<E>> f5353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient s2<E> f5354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient f<E> f5355f;

    public class a extends c5.f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f5356a;

        public a(final f val$baseEntry) {
            this.f5356a = val$baseEntry;
        }

        @Override // f1.b5.a
        public int getCount() {
            int i10 = this.f5356a.f5367b;
            return i10 == 0 ? t7.this.count(getElement()) : i10;
        }

        @Override // f1.b5.a
        @m5
        public E getElement() {
            return this.f5356a.f5366a;
        }
    }

    public class b implements Iterator<b5.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public f<E> f5358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public b5.a<E> f5359b;

        public b() {
            this.f5358a = t7.this.e();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b5.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            t7 t7Var = t7.this;
            f<E> fVar = this.f5358a;
            Objects.requireNonNull(fVar);
            b5.a<E> aVarAccess$1500 = t7.access$1500(t7Var, fVar);
            this.f5359b = aVarAccess$1500;
            f<E> fVar2 = this.f5358a.f5374i;
            Objects.requireNonNull(fVar2);
            if (fVar2 == t7.this.f5355f) {
                this.f5358a = null;
            } else {
                f<E> fVar3 = this.f5358a.f5374i;
                Objects.requireNonNull(fVar3);
                this.f5358a = fVar3;
            }
            return aVarAccess$1500;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5358a == null) {
                return false;
            }
            if (!t7.this.f5354e.tooHigh(this.f5358a.f5366a)) {
                return true;
            }
            this.f5358a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            c1.h0.h0(this.f5359b != null, "no calls to next() since the last call to remove()");
            t7.this.setCount(this.f5359b.getElement(), 0);
            this.f5359b = null;
        }
    }

    public class c implements Iterator<b5.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public f<E> f5361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public b5.a<E> f5362b = null;

        public c() {
            this.f5361a = t7.this.f();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b5.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.f5361a);
            b5.a<E> aVarAccess$1500 = t7.access$1500(t7.this, this.f5361a);
            this.f5362b = aVarAccess$1500;
            f<E> fVar = this.f5361a.f5373h;
            Objects.requireNonNull(fVar);
            if (fVar == t7.this.f5355f) {
                this.f5361a = null;
            } else {
                f<E> fVar2 = this.f5361a.f5373h;
                Objects.requireNonNull(fVar2);
                this.f5361a = fVar2;
            }
            return aVarAccess$1500;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5361a == null) {
                return false;
            }
            if (!t7.this.f5354e.tooLow(this.f5361a.f5366a)) {
                return true;
            }
            this.f5361a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            c1.h0.h0(this.f5362b != null, "no calls to next() since the last call to remove()");
            t7.this.setCount(this.f5362b.getElement(), 0);
            this.f5362b = null;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5364a;

        static {
            int[] iArr = new int[x.values().length];
            f5364a = iArr;
            try {
                iArr[x.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5364a[x.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class e {
        public static final e SIZE = new a("SIZE", 0);
        public static final e DISTINCT = new b("DISTINCT", 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ e[] f5365a = a();

        public final enum a extends e {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.t7.e
            public int nodeAggregate(f<?> node) {
                return node.f5367b;
            }

            @Override // f1.t7.e
            public long treeAggregate(@gm.a f<?> root) {
                if (root == null) {
                    return 0L;
                }
                return root.f5369d;
            }
        }

        public final enum b extends e {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.t7.e
            public int nodeAggregate(f<?> node) {
                return 1;
            }

            @Override // f1.t7.e
            public long treeAggregate(@gm.a f<?> root) {
                if (root == null) {
                    return 0L;
                }
                return root.f5368c;
            }
        }

        public e(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ e[] a() {
            return new e[]{SIZE, DISTINCT};
        }

        public static e valueOf(String name) {
            return (e) Enum.valueOf(e.class, name);
        }

        public static e[] values() {
            return (e[]) f5365a.clone();
        }

        public abstract int nodeAggregate(f<?> node);

        public abstract long treeAggregate(@gm.a f<?> root);

        public e(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public T f5375a;

        public g() {
        }

        public void a(@gm.a T expected, @gm.a T newValue) {
            if (this.f5375a != expected) {
                throw new ConcurrentModificationException();
            }
            this.f5375a = newValue;
        }

        public void b() {
            this.f5375a = null;
        }

        @gm.a
        public T c() {
            return this.f5375a;
        }

        public g(a aVar) {
        }
    }

    public t7(g<f<E>> rootReference, s2<E> range, f<E> endLink) {
        super(range.comparator());
        this.f5353d = rootReference;
        this.f5354e = range;
        this.f5355f = endLink;
    }

    public static b5.a access$1500(t7 t7Var, f fVar) {
        t7Var.getClass();
        return new a(fVar);
    }

    public static void access$1900(f fVar, f fVar2) {
        fVar.f5374i = fVar2;
        fVar2.f5373h = fVar;
    }

    public static <E extends Comparable> t7<E> create() {
        return new t7<>(l5.natural());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void g(f<T> a10, f<T> b10) {
        a10.f5374i = b10;
        b10.f5373h = a10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void i(f<T> a10, f<T> b10, f<T> c10) {
        a10.f5374i = b10;
        b10.f5373h = a10;
        b10.f5374i = c10;
        c10.f5373h = b10;
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        Object object = stream.readObject();
        Objects.requireNonNull(object);
        Comparator comparator = (Comparator) object;
        i6.a(o.class, "comparator").b(this, comparator);
        i6.a(t7.class, "range").b(this, s2.all(comparator));
        i6.a(t7.class, "rootReference").b(this, new g());
        f<E> fVar = new f<>();
        i6.a(t7.class, "header").b(this, fVar);
        fVar.f5374i = fVar;
        fVar.f5373h = fVar;
        i6.f(this, stream);
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(elementSet().comparator());
        i6.k(this, stream);
    }

    public final long a(e aggr, @gm.a f<E> node) {
        long jTreeAggregate;
        long jA;
        if (node == null) {
            return 0L;
        }
        int iCompare = comparator().compare(this.f5354e.getUpperEndpoint(), node.f5366a);
        if (iCompare > 0) {
            return a(aggr, node.f5372g);
        }
        if (iCompare == 0) {
            int i10 = d.f5364a[this.f5354e.getUpperBoundType().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return aggr.treeAggregate(node.f5372g);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggr.nodeAggregate(node);
            jA = aggr.treeAggregate(node.f5372g);
        } else {
            jTreeAggregate = aggr.treeAggregate(node.f5372g) + ((long) aggr.nodeAggregate(node));
            jA = a(aggr, node.f5371f);
        }
        return jA + jTreeAggregate;
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int add(@m5 E element, int occurrences) {
        b0.b(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        c1.h0.d(this.f5354e.contains(element));
        f<E> fVar = this.f5353d.f5375a;
        if (fVar != null) {
            int[] iArr = new int[1];
            this.f5353d.a(fVar, fVar.o(comparator(), element, occurrences, iArr));
            return iArr[0];
        }
        comparator().compare(element, element);
        f<E> fVar2 = new f<>(element, occurrences);
        f<E> fVar3 = this.f5355f;
        i(fVar3, fVar2, fVar3);
        this.f5353d.a(fVar, fVar2);
        return 0;
    }

    public final long b(e aggr, @gm.a f<E> node) {
        long jTreeAggregate;
        long jB;
        if (node == null) {
            return 0L;
        }
        int iCompare = comparator().compare(this.f5354e.getLowerEndpoint(), node.f5366a);
        if (iCompare < 0) {
            return b(aggr, node.f5371f);
        }
        if (iCompare == 0) {
            int i10 = d.f5364a[this.f5354e.getLowerBoundType().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return aggr.treeAggregate(node.f5371f);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggr.nodeAggregate(node);
            jB = aggr.treeAggregate(node.f5371f);
        } else {
            jTreeAggregate = aggr.treeAggregate(node.f5371f) + ((long) aggr.nodeAggregate(node));
            jB = b(aggr, node.f5372g);
        }
        return jB + jTreeAggregate;
    }

    public final long c(e aggr) {
        f<E> fVar = this.f5353d.f5375a;
        long jTreeAggregate = aggr.treeAggregate(fVar);
        if (this.f5354e.hasLowerBound()) {
            jTreeAggregate -= b(aggr, fVar);
        }
        return this.f5354e.hasUpperBound() ? jTreeAggregate - a(aggr, fVar) : jTreeAggregate;
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.f5354e.hasLowerBound() || this.f5354e.hasUpperBound()) {
            h4.h(entryIterator());
            return;
        }
        f<E> fVar = this.f5355f.f5374i;
        Objects.requireNonNull(fVar);
        while (true) {
            f<E> fVar2 = this.f5355f;
            if (fVar == fVar2) {
                fVar2.f5374i = fVar2;
                fVar2.f5373h = fVar2;
                this.f5353d.f5375a = null;
                return;
            }
            f<E> fVar3 = fVar.f5374i;
            Objects.requireNonNull(fVar3);
            fVar.f5367b = 0;
            fVar.f5371f = null;
            fVar.f5372g = null;
            fVar.f5373h = null;
            fVar.f5374i = null;
            fVar = fVar3;
        }
    }

    @Override // f1.o, f1.r6, f1.n6
    public Comparator comparator() {
        return this.comparator;
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection, f1.b5
    public /* bridge */ /* synthetic */ boolean contains(@gm.a Object element) {
        return super.contains(element);
    }

    @Override // f1.b5
    public int count(@gm.a Object element) {
        try {
            f<E> fVar = this.f5353d.f5375a;
            if (this.f5354e.contains(element) && fVar != null) {
                return fVar.t(comparator(), element);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // f1.o
    public Iterator<b5.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // f1.o, f1.r6
    public /* bridge */ /* synthetic */ r6 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // f1.i
    public int distinctElements() {
        return o1.l.z(c(e.DISTINCT));
    }

    @gm.a
    public final f<E> e() {
        f<E> fVarS;
        f<E> fVar = this.f5353d.f5375a;
        if (fVar == null) {
            return null;
        }
        if (this.f5354e.hasLowerBound()) {
            E lowerEndpoint = this.f5354e.getLowerEndpoint();
            fVarS = fVar.s(comparator(), lowerEndpoint);
            if (fVarS == null) {
                return null;
            }
            if (this.f5354e.getLowerBoundType() == x.OPEN && comparator().compare(lowerEndpoint, fVarS.f5366a) == 0) {
                fVarS = fVarS.f5374i;
                Objects.requireNonNull(fVarS);
            }
        } else {
            fVarS = this.f5355f.f5374i;
            Objects.requireNonNull(fVarS);
        }
        if (fVarS == this.f5355f || !this.f5354e.contains(fVarS.f5366a)) {
            return null;
        }
        return fVarS;
    }

    @Override // f1.i
    public Iterator<E> elementIterator() {
        return new c5.e(entryIterator());
    }

    @Override // f1.o, f1.i, f1.b5, f1.r6, f1.s6
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // f1.i
    public Iterator<b5.a<E>> entryIterator() {
        return new b();
    }

    @Override // f1.i, f1.b5
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @gm.a
    public final f<E> f() {
        f<E> fVarV;
        f<E> fVar = this.f5353d.f5375a;
        if (fVar == null) {
            return null;
        }
        if (this.f5354e.hasUpperBound()) {
            E upperEndpoint = this.f5354e.getUpperEndpoint();
            fVarV = fVar.v(comparator(), upperEndpoint);
            if (fVarV == null) {
                return null;
            }
            if (this.f5354e.getUpperBoundType() == x.OPEN && comparator().compare(upperEndpoint, fVarV.f5366a) == 0) {
                fVarV = fVarV.f5373h;
                Objects.requireNonNull(fVarV);
            }
        } else {
            fVarV = this.f5355f.f5373h;
            Objects.requireNonNull(fVarV);
        }
        if (fVarV == this.f5355f || !this.f5354e.contains(fVarV.f5366a)) {
            return null;
        }
        return fVarV;
    }

    @Override // f1.o, f1.r6
    @gm.a
    public /* bridge */ /* synthetic */ b5.a firstEntry() {
        return super.firstEntry();
    }

    @Override // f1.r6
    public r6<E> headMultiset(@m5 E upperBound, x boundType) {
        return new t7(this.f5353d, this.f5354e.intersect(s2.upTo(comparator(), upperBound, boundType)), this.f5355f);
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, f1.b5
    public Iterator<E> iterator() {
        return c5.n(this);
    }

    public final b5.a<E> j(final f<E> baseEntry) {
        return new a(baseEntry);
    }

    @Override // f1.o, f1.r6
    @gm.a
    public /* bridge */ /* synthetic */ b5.a lastEntry() {
        return super.lastEntry();
    }

    @Override // f1.o, f1.r6
    @gm.a
    public /* bridge */ /* synthetic */ b5.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // f1.o, f1.r6
    @gm.a
    public /* bridge */ /* synthetic */ b5.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int remove(@gm.a Object element, int occurrences) {
        b0.b(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        f<E> fVar = this.f5353d.f5375a;
        int[] iArr = new int[1];
        try {
            if (this.f5354e.contains(element) && fVar != null) {
                this.f5353d.a(fVar, fVar.E(comparator(), element, occurrences, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int setCount(@m5 E element, int count) {
        b0.b(count, "count");
        if (!this.f5354e.contains(element)) {
            c1.h0.d(count == 0);
            return 0;
        }
        f<E> fVar = this.f5353d.f5375a;
        if (fVar == null) {
            if (count > 0) {
                add(element, count);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.f5353d.a(fVar, fVar.K(comparator(), element, count, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public int size() {
        return o1.l.z(c(e.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.o, f1.r6
    public /* bridge */ /* synthetic */ r6 subMultiset(@m5 Object fromElement, x fromBoundType, @m5 Object toElement, x toBoundType) {
        return super.subMultiset(fromElement, fromBoundType, toElement, toBoundType);
    }

    @Override // f1.r6
    public r6<E> tailMultiset(@m5 E lowerBound, x boundType) {
        return new t7(this.f5353d, this.f5354e.intersect(s2.downTo(comparator(), lowerBound, boundType)), this.f5355f);
    }

    public static <E> t7<E> create(@gm.a Comparator<? super E> comparator) {
        return comparator == null ? new t7<>(l5.natural()) : new t7<>(comparator);
    }

    public static int distinctElements(@gm.a f<?> node) {
        if (node == null) {
            return 0;
        }
        return node.f5368c;
    }

    public static <E extends Comparable> t7<E> create(Iterable<? extends E> elements) {
        t7<E> t7VarCreate = create();
        g4.a(t7VarCreate, elements);
        return t7VarCreate;
    }

    public t7(Comparator<? super E> comparator) {
        super(comparator);
        this.f5354e = s2.all(comparator);
        f<E> fVar = new f<>();
        this.f5355f = fVar;
        fVar.f5374i = fVar;
        fVar.f5373h = fVar;
        this.f5353d = new g<>();
    }

    public static final class f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public final E f5366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5369d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5370e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.a
        public f<E> f5371f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @gm.a
        public f<E> f5372g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @gm.a
        public f<E> f5373h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @gm.a
        public f<E> f5374i;

        public f(@m5 E elem, int elemCount) {
            c1.h0.d(elemCount > 0);
            this.f5366a = elem;
            this.f5367b = elemCount;
            this.f5369d = elemCount;
            this.f5368c = 1;
            this.f5370e = 1;
            this.f5371f = null;
            this.f5372g = null;
        }

        public static long M(@gm.a f<?> node) {
            if (node == null) {
                return 0L;
            }
            return node.f5369d;
        }

        public static f c(f fVar) {
            f<E> fVar2 = fVar.f5373h;
            Objects.requireNonNull(fVar2);
            return fVar2;
        }

        public static f l(f fVar) {
            f<E> fVar2 = fVar.f5374i;
            Objects.requireNonNull(fVar2);
            return fVar2;
        }

        public static int y(@gm.a f<?> node) {
            if (node == null) {
                return 0;
            }
            return node.f5370e;
        }

        public final f<E> A() {
            int iR = r();
            if (iR == -2) {
                Objects.requireNonNull(this.f5372g);
                if (this.f5372g.r() > 0) {
                    this.f5372g = this.f5372g.I();
                }
                return H();
            }
            if (iR != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f5371f);
            if (this.f5371f.r() < 0) {
                this.f5371f = this.f5371f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f5370e = Math.max(y(this.f5371f), y(this.f5372g)) + 1;
        }

        public final void D() {
            this.f5368c = t7.distinctElements(this.f5372g) + t7.distinctElements(this.f5371f) + 1;
            this.f5369d = M(this.f5372g) + M(this.f5371f) + ((long) this.f5367b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @gm.a
        public f<E> E(Comparator<? super E> comparator, @m5 E e10, int i10, int[] iArr) {
            int iCompare = comparator.compare(e10, this.f5366a);
            if (iCompare < 0) {
                f<E> fVar = this.f5371f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f5371f = fVar.E(comparator, e10, i10, iArr);
                int i11 = iArr[0];
                if (i11 > 0) {
                    if (i10 >= i11) {
                        this.f5368c--;
                        this.f5369d -= (long) i11;
                    } else {
                        this.f5369d -= (long) i10;
                    }
                }
                return i11 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i12 = this.f5367b;
                iArr[0] = i12;
                if (i10 >= i12) {
                    return u();
                }
                this.f5367b = i12 - i10;
                this.f5369d -= (long) i10;
                return this;
            }
            f<E> fVar2 = this.f5372g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f5372g = fVar2.E(comparator, e10, i10, iArr);
            int i13 = iArr[0];
            if (i13 > 0) {
                if (i10 >= i13) {
                    this.f5368c--;
                    this.f5369d -= (long) i13;
                } else {
                    this.f5369d -= (long) i10;
                }
            }
            return A();
        }

        @gm.a
        public final f<E> F(f<E> node) {
            f<E> fVar = this.f5372g;
            if (fVar == null) {
                return this.f5371f;
            }
            this.f5372g = fVar.F(node);
            this.f5368c--;
            this.f5369d -= (long) node.f5367b;
            return A();
        }

        @gm.a
        public final f<E> G(f<E> node) {
            f<E> fVar = this.f5371f;
            if (fVar == null) {
                return this.f5372g;
            }
            this.f5371f = fVar.G(node);
            this.f5368c--;
            this.f5369d -= (long) node.f5367b;
            return A();
        }

        public final f<E> H() {
            c1.h0.g0(this.f5372g != null);
            f<E> fVar = this.f5372g;
            this.f5372g = fVar.f5371f;
            fVar.f5371f = this;
            fVar.f5369d = this.f5369d;
            fVar.f5368c = this.f5368c;
            B();
            fVar.C();
            return fVar;
        }

        public final f<E> I() {
            c1.h0.g0(this.f5371f != null);
            f<E> fVar = this.f5371f;
            this.f5371f = fVar.f5372g;
            fVar.f5372g = this;
            fVar.f5369d = this.f5369d;
            fVar.f5368c = this.f5368c;
            B();
            fVar.C();
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @gm.a
        public f<E> J(Comparator<? super E> comparator, @m5 E e10, int i10, int i11, int[] iArr) {
            int iCompare = comparator.compare(e10, this.f5366a);
            if (iCompare < 0) {
                f<E> fVar = this.f5371f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return (i10 != 0 || i11 <= 0) ? this : p(e10, i11);
                }
                this.f5371f = fVar.J(comparator, e10, i10, i11, iArr);
                int i12 = iArr[0];
                if (i12 == i10) {
                    if (i11 == 0 && i12 != 0) {
                        this.f5368c--;
                    } else if (i11 > 0 && i12 == 0) {
                        this.f5368c++;
                    }
                    this.f5369d += (long) (i11 - i12);
                }
                return A();
            }
            if (iCompare <= 0) {
                int i13 = this.f5367b;
                iArr[0] = i13;
                if (i10 == i13) {
                    if (i11 == 0) {
                        return u();
                    }
                    this.f5369d += (long) (i11 - i13);
                    this.f5367b = i11;
                }
                return this;
            }
            f<E> fVar2 = this.f5372g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return (i10 != 0 || i11 <= 0) ? this : q(e10, i11);
            }
            this.f5372g = fVar2.J(comparator, e10, i10, i11, iArr);
            int i14 = iArr[0];
            if (i14 == i10) {
                if (i11 == 0 && i14 != 0) {
                    this.f5368c--;
                } else if (i11 > 0 && i14 == 0) {
                    this.f5368c++;
                }
                this.f5369d += (long) (i11 - i14);
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @gm.a
        public f<E> K(Comparator<? super E> comparator, @m5 E e10, int i10, int[] iArr) {
            int iCompare = comparator.compare(e10, this.f5366a);
            if (iCompare < 0) {
                f<E> fVar = this.f5371f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return i10 > 0 ? p(e10, i10) : this;
                }
                this.f5371f = fVar.K(comparator, e10, i10, iArr);
                if (i10 == 0 && iArr[0] != 0) {
                    this.f5368c--;
                } else if (i10 > 0 && iArr[0] == 0) {
                    this.f5368c++;
                }
                this.f5369d += (long) (i10 - iArr[0]);
                return A();
            }
            if (iCompare <= 0) {
                int i11 = this.f5367b;
                iArr[0] = i11;
                if (i10 == 0) {
                    return u();
                }
                this.f5369d += (long) (i10 - i11);
                this.f5367b = i10;
                return this;
            }
            f<E> fVar2 = this.f5372g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return i10 > 0 ? q(e10, i10) : this;
            }
            this.f5372g = fVar2.K(comparator, e10, i10, iArr);
            if (i10 == 0 && iArr[0] != 0) {
                this.f5368c--;
            } else if (i10 > 0 && iArr[0] == 0) {
                this.f5368c++;
            }
            this.f5369d += (long) (i10 - iArr[0]);
            return A();
        }

        public final f<E> L() {
            f<E> fVar = this.f5374i;
            Objects.requireNonNull(fVar);
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f<E> o(Comparator<? super E> comparator, @m5 E e10, int i10, int[] iArr) {
            int iCompare = comparator.compare(e10, this.f5366a);
            if (iCompare < 0) {
                f<E> fVar = this.f5371f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return p(e10, i10);
                }
                int i11 = fVar.f5370e;
                f<E> fVarO = fVar.o(comparator, e10, i10, iArr);
                this.f5371f = fVarO;
                if (iArr[0] == 0) {
                    this.f5368c++;
                }
                this.f5369d += (long) i10;
                return fVarO.f5370e == i11 ? this : A();
            }
            if (iCompare <= 0) {
                int i12 = this.f5367b;
                iArr[0] = i12;
                long j10 = i10;
                c1.h0.d(((long) i12) + j10 <= 2147483647L);
                this.f5367b += i10;
                this.f5369d += j10;
                return this;
            }
            f<E> fVar2 = this.f5372g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return q(e10, i10);
            }
            int i13 = fVar2.f5370e;
            f<E> fVarO2 = fVar2.o(comparator, e10, i10, iArr);
            this.f5372g = fVarO2;
            if (iArr[0] == 0) {
                this.f5368c++;
            }
            this.f5369d += (long) i10;
            return fVarO2.f5370e == i13 ? this : A();
        }

        public final f<E> p(@m5 E e10, int count) {
            this.f5371f = new f<>(e10, count);
            f<E> fVar = this.f5373h;
            Objects.requireNonNull(fVar);
            t7.i(fVar, this.f5371f, this);
            this.f5370e = Math.max(2, this.f5370e);
            this.f5368c++;
            this.f5369d += (long) count;
            return this;
        }

        public final f<E> q(@m5 E e10, int count) {
            f<E> fVar = new f<>(e10, count);
            this.f5372g = fVar;
            f<E> fVar2 = this.f5374i;
            Objects.requireNonNull(fVar2);
            t7.i(this, fVar, fVar2);
            this.f5370e = Math.max(2, this.f5370e);
            this.f5368c++;
            this.f5369d += (long) count;
            return this;
        }

        public final int r() {
            return y(this.f5371f) - y(this.f5372g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @gm.a
        public final f<E> s(Comparator<? super E> comparator, @m5 E e10) {
            int iCompare = comparator.compare(e10, this.f5366a);
            if (iCompare < 0) {
                f<E> fVar = this.f5371f;
                return fVar == null ? this : (f) c1.z.a(fVar.s(comparator, e10), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f<E> fVar2 = this.f5372g;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.s(comparator, e10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int t(Comparator<? super E> comparator, @m5 E e10) {
            int iCompare = comparator.compare(e10, this.f5366a);
            if (iCompare < 0) {
                f<E> fVar = this.f5371f;
                if (fVar == null) {
                    return 0;
                }
                return fVar.t(comparator, e10);
            }
            if (iCompare <= 0) {
                return this.f5367b;
            }
            f<E> fVar2 = this.f5372g;
            if (fVar2 == null) {
                return 0;
            }
            return fVar2.t(comparator, e10);
        }

        public String toString() {
            return new c5.k(this.f5366a, this.f5367b).toString();
        }

        @gm.a
        public final f<E> u() {
            int i10 = this.f5367b;
            this.f5367b = 0;
            f<E> fVar = this.f5373h;
            Objects.requireNonNull(fVar);
            f<E> fVar2 = this.f5374i;
            Objects.requireNonNull(fVar2);
            t7.access$1900(fVar, fVar2);
            f<E> fVar3 = this.f5371f;
            if (fVar3 == null) {
                return this.f5372g;
            }
            f<E> fVar4 = this.f5372g;
            if (fVar4 == null) {
                return fVar3;
            }
            if (fVar3.f5370e >= fVar4.f5370e) {
                f<E> fVar5 = this.f5373h;
                Objects.requireNonNull(fVar5);
                fVar5.f5371f = this.f5371f.F(fVar5);
                fVar5.f5372g = this.f5372g;
                fVar5.f5368c = this.f5368c - 1;
                fVar5.f5369d = this.f5369d - ((long) i10);
                return fVar5.A();
            }
            f<E> fVar6 = this.f5374i;
            Objects.requireNonNull(fVar6);
            fVar6.f5372g = this.f5372g.G(fVar6);
            fVar6.f5371f = this.f5371f;
            fVar6.f5368c = this.f5368c - 1;
            fVar6.f5369d = this.f5369d - ((long) i10);
            return fVar6.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @gm.a
        public final f<E> v(Comparator<? super E> comparator, @m5 E e10) {
            int iCompare = comparator.compare(e10, this.f5366a);
            if (iCompare > 0) {
                f<E> fVar = this.f5372g;
                return fVar == null ? this : (f) c1.z.a(fVar.v(comparator, e10), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f<E> fVar2 = this.f5371f;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.v(comparator, e10);
        }

        public int w() {
            return this.f5367b;
        }

        @m5
        public E x() {
            return this.f5366a;
        }

        public final f<E> z() {
            f<E> fVar = this.f5373h;
            Objects.requireNonNull(fVar);
            return fVar;
        }

        public f() {
            this.f5366a = null;
            this.f5367b = 1;
        }
    }

    @Override // f1.i, f1.b5
    @t1.a
    public boolean setCount(@m5 E element, int oldCount, int newCount) {
        b0.b(newCount, "newCount");
        b0.b(oldCount, "oldCount");
        c1.h0.d(this.f5354e.contains(element));
        f<E> fVar = this.f5353d.f5375a;
        if (fVar != null) {
            int[] iArr = new int[1];
            this.f5353d.a(fVar, fVar.J(comparator(), element, oldCount, newCount, iArr));
            return iArr[0] == oldCount;
        }
        if (oldCount != 0) {
            return false;
        }
        if (newCount > 0) {
            add(element, newCount);
        }
        return true;
    }
}
