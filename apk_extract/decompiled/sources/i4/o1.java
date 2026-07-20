package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import k3.j9;
import k3.m9;

/* JADX INFO: loaded from: classes.dex */
public abstract class o1 extends p1 implements c4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient h0 f5665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient s1 f5666c;

    public static <E> l1 builder() {
        return new l1(4);
    }

    public static <E> o1 copyFromEntries(Collection<? extends b4> collection) {
        int size = collection.size();
        k4 k4Var = new k4();
        k4Var.e(size);
        for (b4 b4Var : collection) {
            Object element = b4Var.getElement();
            int count = b4Var.getCount();
            if (count != 0) {
                element.getClass();
                k4Var.f(k4Var.b(element) + count, element);
            }
        }
        return k4Var.f5624c == 0 ? of() : new y4(k4Var);
    }

    public static <E> o1 copyOf(Iterator<? extends E> it) {
        k4 k4Var = new k4();
        k4Var.e(4);
        while (it.hasNext()) {
            E next = it.next();
            Objects.requireNonNull(k4Var);
            next.getClass();
            k4Var.f(k4Var.b(next) + 1, next);
        }
        Objects.requireNonNull(k4Var);
        return k4Var.f5624c == 0 ? of() : new y4(k4Var);
    }

    public static o1 e(Object... objArr) {
        k4 k4Var = new k4();
        k4Var.e(4);
        for (Object obj : objArr) {
            Objects.requireNonNull(k4Var);
            obj.getClass();
            k4Var.f(k4Var.b(obj) + 1, obj);
        }
        Objects.requireNonNull(k4Var);
        return k4Var.f5624c == 0 ? of() : new y4(k4Var);
    }

    public static <E> o1 of() {
        return y4.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // i4.c4
    @Deprecated
    public final int add(Object obj, int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // i4.a0
    public h0 asList() {
        h0 h0Var = this.f5665b;
        if (h0Var != null) {
            return h0Var;
        }
        h0 h0VarAsList = super.asList();
        this.f5665b = h0VarAsList;
        return h0VarAsList;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        h5 it = entrySet().iterator();
        while (it.hasNext()) {
            b4 b4Var = (b4) it.next();
            Arrays.fill(objArr, i8, b4Var.getCount() + i8, b4Var.getElement());
            i8 += b4Var.getCount();
        }
        return i8;
    }

    public abstract /* synthetic */ int count(Object obj);

    @Override // i4.c4
    public abstract s1 elementSet();

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return j9.a(this, obj);
    }

    public abstract b4 getEntry(int i8);

    @Override // java.util.Collection
    public int hashCode() {
        return m9.a(entrySet());
    }

    @Deprecated
    public final int remove(Object obj, int i8) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int setCount(Object obj, int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // i4.a0
    public abstract Object writeReplace();

    public static <E> o1 of(E e) {
        return e(e);
    }

    @Override // i4.c4
    public s1 entrySet() {
        s1 s1VarOf = this.f5666c;
        if (s1VarOf == null) {
            s1VarOf = isEmpty() ? s1.of() : new m1(this, null);
            this.f5666c = s1VarOf;
        }
        return s1VarOf;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return new k1(entrySet().iterator());
    }

    @Deprecated
    public final boolean setCount(Object obj, int i8, int i9) {
        throw new UnsupportedOperationException();
    }

    public static <E> o1 of(E e, E e4) {
        return e(e, e4);
    }

    public static <E> o1 of(E e, E e4, E e10) {
        return e(e, e4, e10);
    }

    public static <E> o1 of(E e, E e4, E e10, E e11) {
        return e(e, e4, e10, e11);
    }

    public static <E> o1 of(E e, E e4, E e10, E e11, E e12) {
        return e(e, e4, e10, e11, e12);
    }

    public static <E> o1 of(E e, E e4, E e10, E e11, E e12, E e13, E... eArr) {
        l1 l1Var = new l1(4);
        l1Var.b(1, e);
        l1Var.b(1, e4);
        l1Var.b(1, e10);
        l1Var.b(1, e11);
        l1Var.b(1, e12);
        l1Var.b(1, e13);
        for (E e14 : eArr) {
            l1Var.b(1, e14);
        }
        return l1Var.c();
    }

    public static <E> o1 copyOf(E[] eArr) {
        return e(eArr);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0070 -> B:23:0x0057). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:21:0x0045
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static <E> i4.o1 copyOf(java.lang.Iterable<? extends E> r5) {
        /*
            boolean r0 = r5 instanceof i4.o1
            if (r0 == 0) goto Le
            r0 = r5
            i4.o1 r0 = (i4.o1) r0
            boolean r1 = r0.isPartialView()
            if (r1 != 0) goto Le
            return r0
        Le:
            i4.l1 r0 = new i4.l1
            boolean r1 = r5 instanceof i4.c4
            if (r1 == 0) goto L20
            r2 = r5
            i4.c4 r2 = (i4.c4) r2
            java.util.Set r2 = r2.elementSet()
            int r2 = r2.size()
            goto L22
        L20:
            r2 = 11
        L22:
            r0.<init>(r2)
            i4.k4 r2 = r0.f5633a
            java.util.Objects.requireNonNull(r2)
            if (r1 == 0) goto La6
            i4.c4 r5 = (i4.c4) r5
            boolean r1 = r5 instanceof i4.y4
            if (r1 == 0) goto L38
            r1 = r5
            i4.y4 r1 = (i4.y4) r1
            i4.k4 r1 = r1.contents
            goto L43
        L38:
            boolean r1 = r5 instanceof i4.d
            if (r1 == 0) goto L42
            r1 = r5
            i4.d r1 = (i4.d) r1
            i4.k4 r1 = r1.backingMap
            goto L43
        L42:
            r1 = 0
        L43:
            if (r1 == 0) goto L73
            i4.k4 r5 = r0.f5633a
            int r2 = r5.f5624c
            int r3 = r1.f5624c
            int r2 = java.lang.Math.max(r2, r3)
            r5.a(r2)
            int r5 = r1.f5624c
            r2 = -1
            if (r5 != 0) goto L59
        L57:
            r5 = r2
            goto L5a
        L59:
            r5 = 0
        L5a:
            if (r5 < 0) goto Lb9
            int r3 = r1.f5624c
            k3.v8.h(r5, r3)
            java.lang.Object[] r3 = r1.f5622a
            r3 = r3[r5]
            int r4 = r1.c(r5)
            r0.b(r4, r3)
            int r5 = r5 + 1
            int r3 = r1.f5624c
            if (r5 >= r3) goto L57
            goto L5a
        L73:
            java.util.Set r1 = r5.entrySet()
            i4.k4 r2 = r0.f5633a
            int r3 = r2.f5624c
            int r1 = r1.size()
            int r1 = java.lang.Math.max(r3, r1)
            r2.a(r1)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L8e:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto Lb9
            java.lang.Object r1 = r5.next()
            i4.b4 r1 = (i4.b4) r1
            java.lang.Object r2 = r1.getElement()
            int r1 = r1.getCount()
            r0.b(r1, r2)
            goto L8e
        La6:
            java.util.Iterator r5 = r5.iterator()
        Laa:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto Lb9
            java.lang.Object r1 = r5.next()
            r2 = 1
            r0.b(r2, r1)
            goto Laa
        Lb9:
            i4.o1 r5 = r0.c()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.o1.copyOf(java.lang.Iterable):i4.o1");
    }
}
