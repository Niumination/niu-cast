package i4;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import k3.d9;
import k3.h9;
import k3.ta;

/* JADX INFO: loaded from: classes.dex */
public abstract class o4 implements Comparator {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    public static o4 allEqual() {
        return h.INSTANCE;
    }

    public static o4 arbitrary() {
        return m4.f5647a;
    }

    public static <T> o4 explicit(List<T> list) {
        return new v(list);
    }

    public static <T> o4 from(Comparator<T> comparator) {
        return comparator instanceof o4 ? (o4) comparator : new r(comparator);
    }

    public static <C extends Comparable> o4 natural() {
        return g4.INSTANCE;
    }

    public static o4 usingToString() {
        return j5.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<Object> list, Object obj) {
        return Collections.binarySearch(list, obj, this);
    }

    public <U> o4 compound(Comparator<? super U> comparator) {
        comparator.getClass();
        return new s(this, comparator);
    }

    public <E> List<E> greatestOf(Iterable<E> iterable, int i8) {
        return reverse().leastOf(iterable, i8);
    }

    public <E> h0 immutableSortedCopy(Iterable<E> iterable) {
        return h0.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E> List<E> leastOf(Iterable<E> iterable, int i8) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= ((long) i8) * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i8) {
                    array = Arrays.copyOf(array, i8);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i8);
    }

    public <S> o4 lexicographical() {
        return new f2(this);
    }

    public <E> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    public <S> o4 nullsFirst() {
        return new h4(this);
    }

    public <S> o4 nullsLast() {
        return new i4(this);
    }

    public <T2> o4 onKeys() {
        return onResultOf(z3.KEY);
    }

    public <F> o4 onResultOf(h4.m mVar) {
        return new j(mVar, this);
    }

    public <S> o4 reverse() {
        return new c5(this);
    }

    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h9.a(arrayList, it);
            collection = arrayList;
        }
        Object[] array = collection.toArray();
        Arrays.sort(array, this);
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        if (listAsList instanceof Collection) {
            return new ArrayList(listAsList);
        }
        Iterator it2 = listAsList.iterator();
        ArrayList arrayList2 = new ArrayList();
        h9.a(arrayList2, it2);
        return arrayList2;
    }

    public static <T> o4 explicit(T t3, T... tArr) {
        return explicit(new g2(t3, tArr));
    }

    public <E> List<E> greatestOf(Iterator<E> it, int i8) {
        return reverse().leastOf(it, i8);
    }

    public static <T> o4 compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new s(iterable);
    }

    @Deprecated
    public static <T> o4 from(o4 o4Var) {
        o4Var.getClass();
        return o4Var;
    }

    public <E> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    public <E> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    public <E> E max(E e, E e4) {
        return compare(e, e4) >= 0 ? e : e4;
    }

    public <E> E min(E e, E e4) {
        return compare(e, e4) <= 0 ? e : e4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E max(E e, E e4, E e10, E... eArr) {
        E e11 = (E) max(max(e, e4), e10);
        for (E e12 : eArr) {
            e11 = (E) max(e11, e12);
        }
        return e11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E min(E e, E e4, E e10, E... eArr) {
        E e11 = (E) min(min(e, e4), e10);
        for (E e12 : eArr) {
            e11 = (E) min(e11, e12);
        }
        return e11;
    }

    public <E> List<E> leastOf(Iterator<E> it, int i8) {
        o4 o4Var;
        Object[] objArr;
        int i9;
        it.getClass();
        d9.b(i8, "k");
        if (i8 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i8 >= 1073741823) {
            ArrayList arrayList = new ArrayList();
            h9.a(arrayList, it);
            Collections.sort(arrayList, this);
            if (arrayList.size() > i8) {
                arrayList.subList(i8, arrayList.size()).clear();
            }
            arrayList.trimToSize();
            return Collections.unmodifiableList(arrayList);
        }
        f5 f5Var = new f5(this, i8);
        while (true) {
            boolean zHasNext = it.hasNext();
            int iMax = 0;
            o4Var = f5Var.f5593b;
            objArr = f5Var.f5594c;
            i9 = f5Var.f5592a;
            if (!zHasNext) {
                break;
            }
            E next = it.next();
            if (i9 != 0) {
                int i10 = f5Var.f5595d;
                if (i10 == 0) {
                    objArr[0] = next;
                    f5Var.e = next;
                    f5Var.f5595d = 1;
                } else if (i10 < i9) {
                    f5Var.f5595d = i10 + 1;
                    objArr[i10] = next;
                    if (o4Var.compare(next, f5Var.e) > 0) {
                        f5Var.e = next;
                    }
                } else if (o4Var.compare(next, f5Var.e) < 0) {
                    int i11 = f5Var.f5595d;
                    int i12 = i11 + 1;
                    f5Var.f5595d = i12;
                    objArr[i11] = next;
                    int i13 = i9 * 2;
                    if (i12 == i13) {
                        int i14 = i13 - 1;
                        int iB = ta.b(i14, RoundingMode.CEILING) * 3;
                        int i15 = 0;
                        int i16 = 0;
                        while (iMax < i14) {
                            int i17 = ((iMax + i14) + 1) >>> 1;
                            Object obj = objArr[i17];
                            objArr[i17] = objArr[i14];
                            int i18 = iMax;
                            int i19 = i18;
                            while (i18 < i14) {
                                if (o4Var.compare(objArr[i18], obj) < 0) {
                                    Object obj2 = objArr[i19];
                                    objArr[i19] = objArr[i18];
                                    objArr[i18] = obj2;
                                    i19++;
                                }
                                i18++;
                            }
                            objArr[i14] = objArr[i19];
                            objArr[i19] = obj;
                            if (i19 <= i9) {
                                if (i19 >= i9) {
                                    break;
                                }
                                iMax = Math.max(i19, iMax + 1);
                                i16 = i19;
                            } else {
                                i14 = i19 - 1;
                            }
                            i15++;
                            if (i15 >= iB) {
                                Arrays.sort(objArr, iMax, i14 + 1, o4Var);
                                break;
                            }
                        }
                        f5Var.f5595d = i9;
                        f5Var.e = objArr[i16];
                        while (true) {
                            i16++;
                            if (i16 < i9) {
                                if (o4Var.compare(objArr[i16], f5Var.e) > 0) {
                                    f5Var.e = objArr[i16];
                                }
                            }
                        }
                    }
                }
            }
        }
        Arrays.sort(objArr, 0, f5Var.f5595d, o4Var);
        if (f5Var.f5595d > i9) {
            Arrays.fill(objArr, i9, objArr.length, (Object) null);
            f5Var.f5595d = i9;
            f5Var.e = objArr[i9 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, f5Var.f5595d)));
    }
}
