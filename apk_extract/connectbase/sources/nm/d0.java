package nm;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public class d0 extends c0 {
    @an.f
    public static final <T> void A0(Collection<? super T> collection, gq.m<? extends T> mVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(mVar, "elements");
        q0(collection, mVar);
    }

    @an.f
    public static final <T> void B0(Collection<? super T> collection, Iterable<? extends T> iterable) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(iterable, "elements");
        r0(collection, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <T> void C0(Collection<? super T> collection, T t10) {
        kn.l0.p(collection, "<this>");
        collection.add(t10);
    }

    @an.f
    public static final <T> void D0(Collection<? super T> collection, T[] tArr) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(tArr, "elements");
        s0(collection, tArr);
    }

    @an.f
    @lm.k(level = lm.m.ERROR, message = "Use removeAt(index) instead.", replaceWith = @lm.a1(expression = "removeAt(index)", imports = {}))
    public static final <T> T E0(List<T> list, int i10) {
        kn.l0.p(list, "<this>");
        return list.remove(i10);
    }

    @an.f
    public static final <T> boolean F0(Collection<? extends T> collection, T t10) {
        kn.l0.p(collection, "<this>");
        return kn.u1.a(collection).remove(t10);
    }

    public static final <T> boolean G0(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        return u0(iterable, lVar, true);
    }

    public static final <T> boolean H0(@os.l Collection<? super T> collection, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(mVar, "elements");
        List listC3 = gq.v.c3(mVar);
        return !listC3.isEmpty() && collection.removeAll(listC3);
    }

    public static final <T> boolean I0(@os.l Collection<? super T> collection, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(iterable, "elements");
        return collection.removeAll(t0(iterable));
    }

    @an.f
    public static final <T> boolean J0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(collection2, "elements");
        return kn.u1.a(collection).removeAll(collection2);
    }

    public static final <T> boolean K0(@os.l Collection<? super T> collection, @os.l T[] tArr) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(tArr, "elements");
        return !(tArr.length == 0) && collection.removeAll(p.t(tArr));
    }

    public static final <T> boolean L0(@os.l List<T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        return v0(list, lVar, true);
    }

    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <T> T M0(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <T> T N0(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static <T> T O0(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(y.J(list));
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static <T> T P0(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(y.J(list));
    }

    public static <T> boolean Q0(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        return u0(iterable, lVar, false);
    }

    public static final <T> boolean R0(@os.l Collection<? super T> collection, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(mVar, "elements");
        List listC3 = gq.v.c3(mVar);
        return !listC3.isEmpty() ? collection.retainAll(listC3) : W0(collection);
    }

    public static final <T> boolean S0(@os.l Collection<? super T> collection, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(iterable, "elements");
        return collection.retainAll(t0(iterable));
    }

    @an.f
    public static final <T> boolean T0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(collection2, "elements");
        return kn.u1.a(collection).retainAll(collection2);
    }

    public static final <T> boolean U0(@os.l Collection<? super T> collection, @os.l T[] tArr) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(tArr, "elements");
        return !(tArr.length == 0) ? collection.retainAll(p.t(tArr)) : W0(collection);
    }

    public static final <T> boolean V0(@os.l List<T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        return v0(list, lVar, false);
    }

    public static final boolean W0(Collection<?> collection) {
        boolean z10 = !collection.isEmpty();
        collection.clear();
        return z10;
    }

    public static <T> boolean q0(@os.l Collection<? super T> collection, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(mVar, "elements");
        Iterator<? extends T> it = mVar.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean r0(@os.l Collection<? super T> collection, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean s0(@os.l Collection<? super T> collection, @os.l T[] tArr) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(tArr, "elements");
        return collection.addAll(p.t(tArr));
    }

    @os.l
    public static <T> Collection<T> t0(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = h0.V5(iterable);
        }
        return (Collection) iterable;
    }

    public static final <T> boolean u0(Iterable<? extends T> iterable, jn.l<? super T, Boolean> lVar, boolean z10) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static final <T> boolean v0(List<T> list, jn.l<? super T, Boolean> lVar, boolean z10) {
        if (!(list instanceof RandomAccess)) {
            kn.l0.n(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return u0(kn.u1.c(list), lVar, z10);
        }
        v0 v0VarI = new tn.l(0, y.J(list), 1).iterator();
        int i10 = 0;
        while (v0VarI.hasNext()) {
            int iNextInt = v0VarI.nextInt();
            T t10 = list.get(iNextInt);
            if (lVar.invoke(t10).booleanValue() != z10) {
                if (i10 != iNextInt) {
                    list.set(i10, t10);
                }
                i10++;
            }
        }
        if (i10 >= list.size()) {
            return false;
        }
        int iJ = y.J(list);
        if (i10 <= iJ) {
            while (true) {
                list.remove(iJ);
                if (iJ == i10) {
                    break;
                }
                iJ--;
            }
        }
        return true;
    }

    @an.f
    public static final <T> void w0(Collection<? super T> collection, gq.m<? extends T> mVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(mVar, "elements");
        H0(collection, mVar);
    }

    @an.f
    public static final <T> void x0(Collection<? super T> collection, Iterable<? extends T> iterable) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(iterable, "elements");
        I0(collection, iterable);
    }

    @an.f
    public static final <T> void y0(Collection<? super T> collection, T t10) {
        kn.l0.p(collection, "<this>");
        collection.remove(t10);
    }

    @an.f
    public static final <T> void z0(Collection<? super T> collection, T[] tArr) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(tArr, "elements");
        K0(collection, tArr);
    }
}
