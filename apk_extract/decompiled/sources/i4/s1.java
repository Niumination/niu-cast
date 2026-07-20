package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import k3.d9;
import k3.f9;
import k3.m9;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public abstract class s1 extends a0 implements Set {
    static final int MAX_TABLE_SIZE = 1073741824;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient h0 f5687b;

    public static boolean access$000(int i8, int i9) {
        return i8 < (i9 >> 1) + (i9 >> 2);
    }

    public static <E> q1 builder() {
        return new q1(4);
    }

    public static <E> q1 builderWithExpectedSize(int i8) {
        d9.b(i8, "expectedSize");
        q1 q1Var = new q1(i8);
        q1Var.f5682d = new Object[chooseTableSize(i8)];
        return q1Var;
    }

    public static int chooseTableSize(int i8) {
        int iMax = Math.max(i8, 2);
        if (iMax >= 751619276) {
            v8.c("collection too large", iMax < 1073741824);
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static <E> s1 copyOf(Collection<? extends E> collection) {
        if ((collection instanceof s1) && !(collection instanceof SortedSet)) {
            s1 s1Var = (s1) collection;
            if (!s1Var.isPartialView()) {
                return s1Var;
            }
        }
        Object[] array = collection.toArray();
        return e(array.length, array);
    }

    public static s1 e(int i8, Object... objArr) {
        if (i8 == 0) {
            return of();
        }
        if (i8 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int iChooseTableSize = chooseTableSize(i8);
        Object[] objArr2 = new Object[iChooseTableSize];
        int i9 = iChooseTableSize - 1;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i8; i12++) {
            Object obj2 = objArr[i12];
            if (obj2 == null) {
                throw new NullPointerException(a1.a.o(i12, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iA = f9.a(iHashCode);
            while (true) {
                int i13 = iA & i9;
                Object obj3 = objArr2[i13];
                if (obj3 == null) {
                    objArr[i11] = obj2;
                    objArr2[i13] = obj2;
                    i10 += iHashCode;
                    i11++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iA++;
            }
        }
        Arrays.fill(objArr, i11, i8, (Object) null);
        if (i11 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new d5(obj4);
        }
        if (chooseTableSize(i11) < iChooseTableSize / 2) {
            return e(i11, objArr);
        }
        int length = objArr.length;
        if (i11 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i11);
        }
        return new z4(objArr, i10, objArr2, i9, i11);
    }

    public static <E> s1 of() {
        return z4.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // i4.a0
    public h0 asList() {
        h0 h0Var = this.f5687b;
        if (h0Var != null) {
            return h0Var;
        }
        h0 h0VarCreateAsList = createAsList();
        this.f5687b = h0VarCreateAsList;
        return h0VarCreateAsList;
    }

    public h0 createAsList() {
        return h0.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof s1) && isHashCodeFast() && ((s1) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return m9.a(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract h5 iterator();

    @Override // i4.a0
    public Object writeReplace() {
        return new r1(toArray());
    }

    public static <E> s1 of(E e) {
        return new d5(e);
    }

    public static <E> s1 of(E e, E e4) {
        return e(2, e, e4);
    }

    public static <E> s1 of(E e, E e4, E e10) {
        return e(3, e, e4, e10);
    }

    public static <E> s1 of(E e, E e4, E e10, E e11) {
        return e(4, e, e4, e10, e11);
    }

    public static <E> s1 copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> s1 of(E e, E e4, E e10, E e11, E e12) {
        return e(5, e, e4, e10, e11, e12);
    }

    @SafeVarargs
    public static <E> s1 of(E e, E e4, E e10, E e11, E e12, E e13, E... eArr) {
        v8.c("the total number of elements must fit in an int", eArr.length <= 2147483641);
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e4;
        objArr[2] = e10;
        objArr[3] = e11;
        objArr[4] = e12;
        objArr[5] = e13;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return e(length, objArr);
    }

    public static <E> s1 copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        q1 q1Var = new q1(4);
        q1Var.d(next);
        while (it.hasNext()) {
            q1Var.d(it.next());
        }
        return q1Var.e();
    }

    public static <E> s1 copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return e(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
