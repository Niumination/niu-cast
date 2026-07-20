package nm;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,569:1\n467#1,51:572\n467#1,51:623\n37#2,2:570\n26#3:674\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n462#1:572,51\n464#1:623,51\n47#1:570,2\n559#1:674\n*E\n"})
@p2(markerClass = {lm.r.class})
@lm.f1(version = "1.4")
public final class k<E> extends f<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f11642d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final Object[] f11643e = new Object[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11644f = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public Object[] f11646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11647c;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public k(int i10) {
        Object[] objArr;
        if (i10 == 0) {
            objArr = f11643e;
        } else {
            if (i10 <= 0) {
                throw new IllegalArgumentException(h.a.a("Illegal Capacity: ", i10));
            }
            objArr = new Object[i10];
        }
        this.f11646b = objArr;
    }

    public final void a(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f11646b.length;
        while (i10 < length && it.hasNext()) {
            this.f11646b[i10] = it.next();
            i10++;
        }
        int i11 = this.f11645a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f11646b[i12] = it.next();
        }
        this.f11647c = collection.size() + size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@os.l Collection<? extends E> collection) {
        kn.l0.p(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        f(collection.size() + size());
        a(r(size() + this.f11645a), collection);
        return true;
    }

    public final void addFirst(E e10) {
        f(size() + 1);
        int iE = e(this.f11645a);
        this.f11645a = iE;
        this.f11646b[iE] = e10;
        this.f11647c = size() + 1;
    }

    public final void addLast(E e10) {
        f(size() + 1);
        this.f11646b[r(size() + this.f11645a)] = e10;
        this.f11647c = size() + 1;
    }

    public final void c(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f11646b;
        p.B0(objArr2, objArr, 0, this.f11645a, objArr2.length);
        Object[] objArr3 = this.f11646b;
        int length = objArr3.length;
        int i11 = this.f11645a;
        p.B0(objArr3, objArr, length - i11, 0, i11);
        this.f11645a = 0;
        this.f11646b = objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iR = r(size() + this.f11645a);
        int i10 = this.f11645a;
        if (i10 < iR) {
            p.M1(this.f11646b, null, i10, iR);
        } else if (!isEmpty()) {
            Object[] objArr = this.f11646b;
            p.M1(objArr, null, this.f11645a, objArr.length);
            p.M1(this.f11646b, null, 0, iR);
        }
        this.f11645a = 0;
        this.f11647c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int e(int i10) {
        return i10 == 0 ? r.we(this.f11646b) : i10 - 1;
    }

    public final void f(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f11646b;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr != f11643e) {
            c(c.Companion.e(objArr.length, i10));
            return;
        }
        if (i10 < 10) {
            i10 = 10;
        }
        this.f11646b = new Object[i10];
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f11646b[this.f11645a];
    }

    public final boolean g(jn.l<? super E, Boolean> lVar) {
        int iR;
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f11646b.length != 0) {
            int iR2 = r(size() + this.f11645a);
            int i10 = this.f11645a;
            if (i10 < iR2) {
                iR = i10;
                while (i10 < iR2) {
                    Object obj = this.f11646b[i10];
                    if (lVar.invoke(obj).booleanValue()) {
                        this.f11646b[iR] = obj;
                        iR++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                p.M1(this.f11646b, null, iR, iR2);
            } else {
                int length = this.f11646b.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f11646b;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (lVar.invoke(obj2).booleanValue()) {
                        this.f11646b[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                iR = r(i11);
                for (int i12 = 0; i12 < iR2; i12++) {
                    Object[] objArr2 = this.f11646b;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (lVar.invoke(obj3).booleanValue()) {
                        this.f11646b[iR] = obj3;
                        iR = j(iR);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                this.f11647c = q(iR - this.f11645a);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        c.Companion.b(i10, size());
        return (E) this.f11646b[r(this.f11645a + i10)];
    }

    @Override // nm.f
    public int getSize() {
        return this.f11647c;
    }

    @os.m
    public final E i() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f11646b[this.f11645a];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int iR = r(size() + this.f11645a);
        int length = this.f11645a;
        if (length < iR) {
            while (length < iR) {
                if (kn.l0.g(obj, this.f11646b[length])) {
                    i10 = this.f11645a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iR) {
            return -1;
        }
        int length2 = this.f11646b.length;
        while (length < length2) {
            if (kn.l0.g(obj, this.f11646b[length])) {
                i10 = this.f11645a;
            } else {
                length++;
            }
        }
        for (int i11 = 0; i11 < iR; i11++) {
            if (kn.l0.g(obj, this.f11646b[i11])) {
                length = i11 + this.f11646b.length;
                i10 = this.f11645a;
            }
        }
        return -1;
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i10) {
        if (i10 == r.we(this.f11646b)) {
            return 0;
        }
        return i10 + 1;
    }

    @an.f
    public final E l(int i10) {
        return (E) this.f11646b[i10];
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f11646b[r(y.J(this) + this.f11645a)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iWe;
        int i10;
        int iR = r(size() + this.f11645a);
        int i11 = this.f11645a;
        if (i11 < iR) {
            iWe = iR - 1;
            if (i11 <= iWe) {
                while (!kn.l0.g(obj, this.f11646b[iWe])) {
                    if (iWe != i11) {
                        iWe--;
                    }
                }
                i10 = this.f11645a;
                return iWe - i10;
            }
            return -1;
        }
        if (i11 > iR) {
            for (int i12 = iR - 1; -1 < i12; i12--) {
                if (kn.l0.g(obj, this.f11646b[i12])) {
                    iWe = i12 + this.f11646b.length;
                    i10 = this.f11645a;
                    return iWe - i10;
                }
            }
            iWe = r.we(this.f11646b);
            int i13 = this.f11645a;
            if (i13 <= iWe) {
                while (!kn.l0.g(obj, this.f11646b[iWe])) {
                    if (iWe != i13) {
                        iWe--;
                    }
                }
                i10 = this.f11645a;
                return iWe - i10;
            }
        }
        return -1;
    }

    @an.f
    public final int m(int i10) {
        return r(this.f11645a + i10);
    }

    public final void n(@os.l jn.p<? super Integer, ? super Object[], l2> pVar) {
        int i10;
        kn.l0.p(pVar, "structure");
        pVar.invoke(Integer.valueOf((isEmpty() || (i10 = this.f11645a) < r(size() + this.f11645a)) ? this.f11645a : i10 - this.f11646b.length), toArray());
    }

    @os.m
    public final E o() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f11646b[r(y.J(this) + this.f11645a)];
    }

    public final int q(int i10) {
        return i10 < 0 ? i10 + this.f11646b.length : i10;
    }

    public final int r(int i10) {
        Object[] objArr = this.f11646b;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@os.l Collection<? extends Object> collection) {
        int iR;
        kn.l0.p(collection, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f11646b.length != 0) {
            int iR2 = r(size() + this.f11645a);
            int i10 = this.f11645a;
            if (i10 < iR2) {
                iR = i10;
                while (i10 < iR2) {
                    Object obj = this.f11646b[i10];
                    if (collection.contains(obj)) {
                        z10 = true;
                    } else {
                        this.f11646b[iR] = obj;
                        iR++;
                    }
                    i10++;
                }
                p.M1(this.f11646b, null, iR, iR2);
            } else {
                int length = this.f11646b.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f11646b;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (collection.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.f11646b[i11] = obj2;
                        i11++;
                    }
                    i10++;
                }
                iR = r(i11);
                for (int i12 = 0; i12 < iR2; i12++) {
                    Object[] objArr2 = this.f11646b;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (collection.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.f11646b[iR] = obj3;
                        iR = j(iR);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                this.f11647c = q(iR - this.f11645a);
            }
        }
        return z10;
    }

    @Override // nm.f
    public E removeAt(int i10) {
        c.Companion.b(i10, size());
        if (i10 == y.J(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        int iR = r(this.f11645a + i10);
        E e10 = (E) this.f11646b[iR];
        if (i10 < (size() >> 1)) {
            int i11 = this.f11645a;
            if (iR >= i11) {
                Object[] objArr = this.f11646b;
                p.B0(objArr, objArr, i11 + 1, i11, iR);
            } else {
                Object[] objArr2 = this.f11646b;
                p.B0(objArr2, objArr2, 1, 0, iR);
                Object[] objArr3 = this.f11646b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i12 = this.f11645a;
                p.B0(objArr3, objArr3, i12 + 1, i12, objArr3.length - 1);
            }
            Object[] objArr4 = this.f11646b;
            int i13 = this.f11645a;
            objArr4[i13] = null;
            this.f11645a = j(i13);
        } else {
            int iR2 = r(y.J(this) + this.f11645a);
            if (iR <= iR2) {
                Object[] objArr5 = this.f11646b;
                p.B0(objArr5, objArr5, iR, iR + 1, iR2 + 1);
            } else {
                Object[] objArr6 = this.f11646b;
                p.B0(objArr6, objArr6, iR, iR + 1, objArr6.length);
                Object[] objArr7 = this.f11646b;
                objArr7[objArr7.length - 1] = objArr7[0];
                p.B0(objArr7, objArr7, 0, 1, iR2 + 1);
            }
            this.f11646b[iR2] = null;
        }
        this.f11647c = size() - 1;
        return e10;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f11646b;
        int i10 = this.f11645a;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f11645a = j(i10);
        this.f11647c = size() - 1;
        return e10;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iR = r(y.J(this) + this.f11645a);
        Object[] objArr = this.f11646b;
        E e10 = (E) objArr[iR];
        objArr[iR] = null;
        this.f11647c = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@os.l Collection<? extends Object> collection) {
        int iR;
        kn.l0.p(collection, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f11646b.length != 0) {
            int iR2 = r(size() + this.f11645a);
            int i10 = this.f11645a;
            if (i10 < iR2) {
                iR = i10;
                while (i10 < iR2) {
                    Object obj = this.f11646b[i10];
                    if (collection.contains(obj)) {
                        this.f11646b[iR] = obj;
                        iR++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                p.M1(this.f11646b, null, iR, iR2);
            } else {
                int length = this.f11646b.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f11646b;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (collection.contains(obj2)) {
                        this.f11646b[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                iR = r(i11);
                for (int i12 = 0; i12 < iR2; i12++) {
                    Object[] objArr2 = this.f11646b;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (collection.contains(obj3)) {
                        this.f11646b[iR] = obj3;
                        iR = j(iR);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                this.f11647c = q(iR - this.f11645a);
            }
        }
        return z10;
    }

    @os.m
    public final E s() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        c.Companion.b(i10, size());
        int iR = r(this.f11645a + i10);
        Object[] objArr = this.f11646b;
        E e11 = (E) objArr[iR];
        objArr[iR] = e10;
        return e11;
    }

    @os.m
    public final E t() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @os.l
    public <T> T[] toArray(@os.l T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        if (tArr.length < size()) {
            tArr = (T[]) m.a(tArr, size());
        }
        int iR = r(size() + this.f11645a);
        int i10 = this.f11645a;
        if (i10 < iR) {
            p.K0(this.f11646b, tArr, 0, i10, iR, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f11646b;
            p.B0(objArr, tArr, 0, this.f11645a, objArr.length);
            Object[] objArr2 = this.f11646b;
            p.B0(objArr2, tArr, objArr2.length - this.f11645a, 0, iR);
        }
        return (T[]) x.n(size(), tArr);
    }

    @os.l
    public final Object[] u() {
        return toArray();
    }

    @os.l
    public final <T> T[] v(@os.l T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) toArray(tArr);
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        c.Companion.c(i10, size());
        if (i10 == size()) {
            addLast(e10);
            return;
        }
        if (i10 == 0) {
            addFirst(e10);
            return;
        }
        f(size() + 1);
        int iR = r(this.f11645a + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int iE = e(iR);
            int iE2 = e(this.f11645a);
            int i11 = this.f11645a;
            if (iE >= i11) {
                Object[] objArr = this.f11646b;
                objArr[iE2] = objArr[i11];
                p.B0(objArr, objArr, i11, i11 + 1, iE + 1);
            } else {
                Object[] objArr2 = this.f11646b;
                p.B0(objArr2, objArr2, i11 - 1, i11, objArr2.length);
                Object[] objArr3 = this.f11646b;
                objArr3[objArr3.length - 1] = objArr3[0];
                p.B0(objArr3, objArr3, 0, 1, iE + 1);
            }
            this.f11646b[iE] = e10;
            this.f11645a = iE2;
        } else {
            int iR2 = r(size() + this.f11645a);
            if (iR < iR2) {
                Object[] objArr4 = this.f11646b;
                p.B0(objArr4, objArr4, iR + 1, iR, iR2);
            } else {
                Object[] objArr5 = this.f11646b;
                p.B0(objArr5, objArr5, 1, 0, iR2);
                Object[] objArr6 = this.f11646b;
                objArr6[0] = objArr6[objArr6.length - 1];
                p.B0(objArr6, objArr6, iR + 1, iR, objArr6.length - 1);
            }
            this.f11646b[iR] = e10;
        }
        this.f11647c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @os.l Collection<? extends E> collection) {
        kn.l0.p(collection, "elements");
        c.Companion.c(i10, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(collection);
        }
        f(collection.size() + size());
        int iR = r(size() + this.f11645a);
        int iR2 = r(this.f11645a + i10);
        int size = collection.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f11645a;
            int length = i11 - size;
            if (iR2 < i11) {
                Object[] objArr = this.f11646b;
                p.B0(objArr, objArr, length, i11, objArr.length);
                if (size >= iR2) {
                    Object[] objArr2 = this.f11646b;
                    p.B0(objArr2, objArr2, objArr2.length - size, 0, iR2);
                } else {
                    Object[] objArr3 = this.f11646b;
                    p.B0(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f11646b;
                    p.B0(objArr4, objArr4, 0, size, iR2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f11646b;
                p.B0(objArr5, objArr5, length, i11, iR2);
            } else {
                Object[] objArr6 = this.f11646b;
                length += objArr6.length;
                int i12 = iR2 - i11;
                int length2 = objArr6.length - length;
                if (length2 >= i12) {
                    p.B0(objArr6, objArr6, length, i11, iR2);
                } else {
                    p.B0(objArr6, objArr6, length, i11, i11 + length2);
                    Object[] objArr7 = this.f11646b;
                    p.B0(objArr7, objArr7, 0, this.f11645a + length2, iR2);
                }
            }
            this.f11645a = length;
            a(q(iR2 - size), collection);
        } else {
            int i13 = iR2 + size;
            if (iR2 < iR) {
                int i14 = size + iR;
                Object[] objArr8 = this.f11646b;
                if (i14 <= objArr8.length) {
                    p.B0(objArr8, objArr8, i13, iR2, iR);
                } else if (i13 >= objArr8.length) {
                    p.B0(objArr8, objArr8, i13 - objArr8.length, iR2, iR);
                } else {
                    int length3 = iR - (i14 - objArr8.length);
                    p.B0(objArr8, objArr8, 0, length3, iR);
                    Object[] objArr9 = this.f11646b;
                    p.B0(objArr9, objArr9, i13, iR2, length3);
                }
            } else {
                Object[] objArr10 = this.f11646b;
                p.B0(objArr10, objArr10, size, 0, iR);
                Object[] objArr11 = this.f11646b;
                if (i13 >= objArr11.length) {
                    p.B0(objArr11, objArr11, i13 - objArr11.length, iR2, objArr11.length);
                } else {
                    p.B0(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f11646b;
                    p.B0(objArr12, objArr12, i13, iR2, objArr12.length - size);
                }
            }
            a(iR2, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @os.l
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public k() {
        this.f11646b = f11643e;
    }

    public k(@os.l Collection<? extends E> collection) {
        kn.l0.p(collection, "elements");
        Object[] array = collection.toArray(new Object[0]);
        this.f11646b = array;
        this.f11647c = array.length;
        if (array.length == 0) {
            this.f11646b = f11643e;
        }
    }
}
