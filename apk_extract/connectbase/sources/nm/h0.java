package nm;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import lm.a2;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,3683:1\n288#1,2:3684\n518#1,7:3686\n533#1,6:3693\n857#1,2:3700\n788#1:3702\n1864#1,2:3703\n789#1,2:3705\n1866#1:3707\n791#1:3708\n1864#1,3:3709\n809#1,2:3712\n847#1,2:3714\n1253#1,4:3720\n1222#1,4:3724\n1238#1,4:3728\n1285#1,4:3732\n1446#1,5:3736\n1461#1,5:3741\n1502#1,3:3746\n1505#1,3:3756\n1520#1,3:3759\n1523#1,3:3769\n1620#1,3:3786\n1590#1,4:3789\n1579#1:3793\n1864#1,2:3794\n1866#1:3797\n1580#1:3798\n1864#1,3:3799\n1611#1:3802\n1855#1:3803\n1856#1:3805\n1612#1:3806\n1855#1,2:3807\n1864#1,3:3809\n2847#1,3:3812\n2850#1,6:3816\n2872#1,3:3822\n2875#1,7:3826\n857#1,2:3833\n819#1:3835\n847#1,2:3836\n819#1:3838\n847#1,2:3839\n819#1:3841\n847#1,2:3842\n3405#1,8:3848\n3433#1,7:3856\n3464#1,10:3863\n1#2:3699\n1#2:3796\n1#2:3804\n1#2:3815\n1#2:3825\n37#3,2:3716\n37#3,2:3718\n372#4,7:3749\n372#4,7:3762\n372#4,7:3772\n372#4,7:3779\n32#5,2:3844\n32#5,2:3846\n*S KotlinDebug\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n167#1:3684,2\n177#1:3686,7\n187#1:3693,6\n766#1:3700,2\n777#1:3702\n777#1:3703,2\n777#1:3705,2\n777#1:3707\n777#1:3708\n788#1:3709,3\n800#1:3712,2\n819#1:3714,2\n1180#1:3720,4\n1195#1:3724,4\n1209#1:3728,4\n1272#1:3732,4\n1360#1:3736,5\n1373#1:3741,5\n1477#1:3746,3\n1477#1:3756,3\n1490#1:3759,3\n1490#1:3769,3\n1549#1:3786,3\n1559#1:3789,4\n1569#1:3793\n1569#1:3794,2\n1569#1:3797\n1569#1:3798\n1579#1:3799,3\n1603#1:3802\n1603#1:3803\n1603#1:3805\n1603#1:3806\n1611#1:3807,2\n2645#1:3809,3\n2949#1:3812,3\n2949#1:3816,6\n2967#1:3822,3\n2967#1:3826,7\n3143#1:3833,2\n3151#1:3835\n3151#1:3836,2\n3161#1:3838\n3161#1:3839,2\n3171#1:3841\n3171#1:3842,2\n3394#1:3848,8\n3422#1:3856,7\n3451#1:3863,10\n1569#1:3796\n1603#1:3804\n2949#1:3815\n2967#1:3825\n1032#1:3716,2\n1075#1:3718,2\n1477#1:3749,7\n1490#1:3762,7\n1504#1:3772,7\n1522#1:3779,7\n3339#1:3844,2\n3381#1:3846,2\n*E\n"})
public class h0 extends g0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,680:1\n3524#2:681\n*E\n"})
    public static final class a<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f11630a;

        public a(Iterable iterable) {
            this.f11630a = iterable;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            return this.f11630a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    @kn.r1({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1\n*L\n1#1,3683:1\n*E\n"})
    public static final class c<K, T> implements o0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable<T> f11631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, K> f11632b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Iterable<? extends T> iterable, jn.l<? super T, ? extends K> lVar) {
            this.f11631a = iterable;
            this.f11632b = lVar;
        }

        @Override // nm.o0
        public K a(T t10) {
            return this.f11632b.invoke(t10);
        }

        @Override // nm.o0
        @os.l
        public Iterator<T> b() {
            return this.f11631a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends kn.n0 implements jn.a<Iterator<? extends T>> {
        final /* synthetic */ Iterable<T> $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Iterable<? extends T> iterable) {
            super(0);
            this.$this_withIndex = iterable;
        }

        @Override // jn.a
        @os.l
        public final Iterator<T> invoke() {
            return this.$this_withIndex.iterator();
        }
    }

    @os.l
    public static <T> gq.m<T> A1(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return new a(iterable);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    public static final <T> T A2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            ?? r10 = (Object) itA.next();
            if (lVar.invoke(r10).booleanValue()) {
                return r10;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C A3(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            R rInvoke = pVar.invoke(Integer.valueOf(i10), t10);
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
            i10 = i11;
        }
        return c10;
    }

    @os.l
    public static <T> List<T> A4(@os.l Iterable<? extends T> iterable, @os.l Iterable<? extends T> iterable2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(iterable2, "elements");
        if (iterable instanceof Collection) {
            return E4((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        d0.r0(arrayList, iterable);
        d0.r0(arrayList, iterable2);
        return arrayList;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final <T> double A5(Iterable<? extends T> iterable, jn.l<? super T, Double> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itA.hasNext()) {
            dDoubleValue += lVar.invoke((Object) itA.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final <T, K, V> Map<K, V> B1(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(z.b0(iterable, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(it.next());
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static <T> T B2(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C B3(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            c10.add(pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return c10;
    }

    @os.l
    public static <T> List<T> B4(@os.l Iterable<? extends T> iterable, T t10) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return F4((Collection) iterable, t10);
        }
        ArrayList arrayList = new ArrayList();
        d0.r0(arrayList, iterable);
        arrayList.add(t10);
        return arrayList;
    }

    @in.i(name = "sumOfFloat")
    public static final float B5(@os.l Iterable<Float> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    @os.l
    public static final <T, K> Map<K, T> C1(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(z.b0(iterable, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (T t10 : iterable) {
            linkedHashMap.put(lVar.invoke(t10), t10);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    @lm.f1(version = "1.5")
    @an.f
    public static final <T, R> R C2(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        R rInvoke;
        Iterator itA = f0.a(iterable, "<this>", lVar, "transform");
        while (itA.hasNext()) {
            rInvoke = lVar.invoke((Object) itA.next());
            if (rInvoke != null) {
                if (rInvoke != null) {
                    return rInvoke;
                }
                throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
            }
        }
        rInvoke = null;
        if (rInvoke != null) {
            return rInvoke;
        }
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    @os.l
    public static final <T, R> List<R> C3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    @os.l
    public static final <T> List<T> C4(@os.l Iterable<? extends T> iterable, @os.l T[] tArr) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(tArr, "elements");
        if (iterable instanceof Collection) {
            return G4((Collection) iterable, tArr);
        }
        ArrayList arrayList = new ArrayList();
        d0.r0(arrayList, iterable);
        d0.s0(arrayList, tArr);
        return arrayList;
    }

    @in.i(name = "sumOfInt")
    public static int C5(@os.l Iterable<Integer> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final <T, K, V> Map<K, V> D1(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(z.b0(iterable, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (T t10 : iterable) {
            linkedHashMap.put(lVar.invoke(t10), lVar2.invoke(t10));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.5")
    @an.f
    public static final <T, R> R D2(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "transform");
        while (itA.hasNext()) {
            R rInvoke = lVar.invoke((Object) itA.next());
            if (rInvoke != null) {
                return rInvoke;
            }
        }
        return null;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C D3(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
        }
        return c10;
    }

    @os.l
    public static final <T> List<T> D4(@os.l Collection<? extends T> collection, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(mVar, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        d0.q0(arrayList, mVar);
        return arrayList;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final <T> int D5(Iterable<? extends T> iterable, jn.l<? super T, Integer> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itA.hasNext()) {
            iIntValue += lVar.invoke((Object) itA.next()).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final <T, K, M extends Map<? super K, ? super T>> M E1(@os.l Iterable<? extends T> iterable, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (T t10 : iterable) {
            m10.put(lVar.invoke(t10), t10);
        }
        return m10;
    }

    @os.m
    public static <T> T E2(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C E3(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c10.add(lVar.invoke(it.next()));
        }
        return c10;
    }

    @os.l
    public static <T> List<T> E4(@os.l Collection<? extends T> collection, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            d0.r0(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    @in.i(name = "sumOfLong")
    public static final long E5(@os.l Iterable<Long> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, ? super V>> M F1(@os.l Iterable<? extends T> iterable, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (T t10 : iterable) {
            m10.put(lVar.invoke(t10), lVar2.invoke(t10));
        }
        return m10;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    @os.m
    public static final <T> T F2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            ?? r10 = (Object) itA.next();
            if (lVar.invoke(r10).booleanValue()) {
                return r10;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @os.m
    @lm.f1(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T F3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    @os.l
    public static <T> List<T> F4(@os.l Collection<? extends T> collection, T t10) {
        kn.l0.p(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final <T> long F5(Iterable<? extends T> iterable, jn.l<? super T, Long> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        long jLongValue = 0;
        while (itA.hasNext()) {
            jLongValue += lVar.invoke((Object) itA.next()).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, ? super V>> M G1(@os.l Iterable<? extends T> iterable, @os.l M m10, @os.l jn.l<? super T, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(it.next());
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @os.m
    public static <T> T G2(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T G3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    @os.l
    public static final <T> List<T> G4(@os.l Collection<? extends T> collection, @os.l T[] tArr) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(tArr, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + tArr.length);
        arrayList.addAll(collection);
        d0.s0(arrayList, tArr);
        return arrayList;
    }

    @in.i(name = "sumOfShort")
    public static final int G5(@os.l Iterable<Short> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    @lm.f1(version = "1.3")
    @os.l
    public static final <K, V> Map<K, V> H1(@os.l Iterable<? extends K> iterable, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(z.b0(iterable, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (K k10 : iterable) {
            linkedHashMap.put(k10, lVar.invoke(k10));
        }
        return linkedHashMap;
    }

    @os.l
    public static final <T, R> List<R> H2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.r0(arrayList, lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> double H3(Iterable<? extends T> iterable, jn.l<? super T, Double> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @an.f
    public static final <T> List<T> H4(Iterable<? extends T> iterable, T t10) {
        kn.l0.p(iterable, "<this>");
        return B4(iterable, t10);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final <T> int H5(Iterable<? extends T> iterable, jn.l<? super T, lm.w1> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            iM += lVar.invoke(it.next()).f10227a;
        }
        return iM;
    }

    @lm.f1(version = "1.3")
    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M I1(@os.l Iterable<? extends K> iterable, @os.l M m10, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (K k10 : iterable) {
            m10.put(k10, lVar.invoke(k10));
        }
        return m10;
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <T, R> List<R> I2(Iterable<? extends T> iterable, jn.p<? super Integer, ? super T, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> float I3(Iterable<? extends T> iterable, jn.l<? super T, Float> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return fFloatValue;
    }

    @an.f
    public static final <T> List<T> I4(Collection<? extends T> collection, T t10) {
        kn.l0.p(collection, "<this>");
        return F4(collection, t10);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final <T> long I5(Iterable<? extends T> iterable, jn.l<? super T, a2> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            jM += lVar.invoke(it.next()).f10177a;
        }
        return jM;
    }

    @in.i(name = "averageOfByte")
    public static final double J1(@os.l Iterable<Byte> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        double dByteValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i10++;
            if (i10 < 0) {
                y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i10);
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C J2(Iterable<? extends T> iterable, C c10, jn.p<? super Integer, ? super T, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            d0.r0(c10, pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R J3(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final <T> T J4(Collection<? extends T> collection) {
        kn.l0.p(collection, "<this>");
        return (T) K4(collection, rn.f.Default);
    }

    @os.l
    public static <T> List<T> J5(@os.l Iterable<? extends T> iterable, int i10) {
        kn.l0.p(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return V5(iterable);
            }
            if (i10 == 1) {
                return x.k(z2(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> it = iterable.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return y.T(arrayList);
    }

    @in.i(name = "averageOfDouble")
    public static final double K1(@os.l Iterable<Double> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i10++;
            if (i10 < 0) {
                y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i10);
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedSequence")
    @lm.f1(version = "1.4")
    public static final <T, R> List<R> K2(Iterable<? extends T> iterable, jn.p<? super Integer, ? super T, ? extends gq.m<? extends R>> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            d0.q0(arrayList, pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R K3(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.3")
    public static final <T> T K4(@os.l Collection<? extends T> collection, @os.l rn.f fVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(fVar, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) g2(collection, fVar.nextInt(collection.size()));
    }

    @os.l
    public static <T> List<T> K5(@os.l List<? extends T> list, int i10) {
        kn.l0.p(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int size = list.size();
        if (i10 >= size) {
            return V5(list);
        }
        if (i10 == 1) {
            return x.k(p3(list));
        }
        ArrayList arrayList = new ArrayList(i10);
        if (list instanceof RandomAccess) {
            for (int i11 = size - i10; i11 < size; i11++) {
                arrayList.add(list.get(i11));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    @in.i(name = "averageOfFloat")
    public static final double L1(@os.l Iterable<Float> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        double dFloatValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i10++;
            if (i10 < 0) {
                y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i10);
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedSequenceTo")
    @lm.f1(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C L2(Iterable<? extends T> iterable, C c10, jn.p<? super Integer, ? super T, ? extends gq.m<? extends R>> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            d0.q0(c10, pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Double L3(Iterable<? extends T> iterable, jn.l<? super T, Double> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <T> T L4(Collection<? extends T> collection) {
        kn.l0.p(collection, "<this>");
        return (T) M4(collection, rn.f.Default);
    }

    @os.l
    public static final <T> List<T> L5(@os.l List<? extends T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        if (list.isEmpty()) {
            return k0.INSTANCE;
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!lVar.invoke(listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return k0.INSTANCE;
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return V5(list);
    }

    @in.i(name = "averageOfInt")
    public static final double M1(@os.l Iterable<Integer> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double dIntValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i10++;
            if (i10 < 0) {
                y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i10);
    }

    @lm.s0
    @in.i(name = "flatMapSequence")
    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R> List<R> M2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends gq.m<? extends R>> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.q0(arrayList, lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Float M3(Iterable<? extends T> iterable, jn.l<? super T, Float> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <T> T M4(@os.l Collection<? extends T> collection, @os.l rn.f fVar) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(fVar, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) g2(collection, fVar.nextInt(collection.size()));
    }

    @os.l
    public static final <T> List<T> M5(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!lVar.invoke(t10).booleanValue()) {
                break;
            }
            arrayList.add(t10);
        }
        return arrayList;
    }

    @in.i(name = "averageOfLong")
    public static final double N1(@os.l Iterable<Long> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        double dLongValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i10++;
            if (i10 < 0) {
                y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i10);
    }

    @lm.s0
    @in.i(name = "flatMapSequenceTo")
    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R, C extends Collection<? super R>> C N2(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.l<? super T, ? extends gq.m<? extends R>> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.q0(c10, lVar.invoke(it.next()));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R N3(Iterable<? extends T> iterable, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final <S, T extends S> S N4(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    @os.l
    public static final boolean[] N5(@os.l Collection<Boolean> collection) {
        kn.l0.p(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            zArr[i10] = it.next().booleanValue();
            i10++;
        }
        return zArr;
    }

    @in.i(name = "averageOfShort")
    public static final double O1(@os.l Iterable<Short> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        double dShortValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i10++;
            if (i10 < 0) {
                y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i10);
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C O2(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.l<? super T, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.r0(c10, lVar.invoke(it.next()));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R O3(Iterable<? extends T> iterable, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final <S, T extends S> S O4(@os.l Iterable<? extends T> iterable, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(qVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        int i10 = 1;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            next = qVar.invoke(Integer.valueOf(i10), next, it.next());
            i10 = i11;
        }
        return next;
    }

    @os.l
    public static byte[] O5(@os.l Collection<Byte> collection) {
        kn.l0.p(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bArr[i10] = it.next().byteValue();
            i10++;
        }
        return bArr;
    }

    @lm.f1(version = "1.2")
    @os.l
    public static <T> List<List<T>> P1(@os.l Iterable<? extends T> iterable, int i10) {
        kn.l0.p(iterable, "<this>");
        return d6(iterable, i10, i10, true);
    }

    public static final <T, R> R P2(@os.l Iterable<? extends T> iterable, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r10 = pVar.invoke(r10, it.next());
        }
        return r10;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T extends Comparable<? super T>> T P3(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <S, T extends S> S P4(@os.l Iterable<? extends T> iterable, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(qVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i10 = 1;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            next = qVar.invoke(Integer.valueOf(i10), next, it.next());
            i10 = i11;
        }
        return next;
    }

    @os.l
    public static char[] P5(@os.l Collection<Character> collection) {
        kn.l0.p(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            cArr[i10] = it.next().charValue();
            i10++;
        }
        return cArr;
    }

    @lm.f1(version = "1.2")
    @os.l
    public static final <T, R> List<R> Q1(@os.l Iterable<? extends T> iterable, int i10, @os.l jn.l<? super List<? extends T>, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "transform");
        return e6(iterable, i10, i10, true, lVar);
    }

    public static final <T, R> R Q2(@os.l Iterable<? extends T> iterable, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(qVar, "operation");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            r10 = qVar.invoke(Integer.valueOf(i10), r10, t10);
            i10 = i11;
        }
        return r10;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double Q3(@os.l Iterable<Double> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <S, T extends S> S Q4(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C Q5(@os.l Iterable<? extends T> iterable, @os.l C c10) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c10.add(it.next());
        }
        return c10;
    }

    @an.f
    public static final <T> T R1(List<? extends T> list) {
        kn.l0.p(list, "<this>");
        return list.get(0);
    }

    public static final <T, R> R R2(@os.l List<? extends T> list, R r10, @os.l jn.p<? super T, ? super R, ? extends R> pVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(pVar, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r10 = pVar.invoke(listIterator.previous(), r10);
            }
        }
        return r10;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float R3(@os.l Iterable<Float> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <S, T extends S> S R4(@os.l List<? extends T> list, @os.l jn.p<? super T, ? super S, ? extends S> pVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(pVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = pVar.invoke(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @os.l
    public static final double[] R5(@os.l Collection<Double> collection) {
        kn.l0.p(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            dArr[i10] = it.next().doubleValue();
            i10++;
        }
        return dArr;
    }

    @an.f
    public static final <T> T S1(List<? extends T> list) {
        kn.l0.p(list, "<this>");
        return list.get(1);
    }

    public static final <T, R> R S2(@os.l List<? extends T> list, R r10, @os.l jn.q<? super Integer, ? super T, ? super R, ? extends R> qVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(qVar, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r10 = qVar.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r10);
            }
        }
        return r10;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final double S3(@os.l Iterable<Double> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static final <S, T extends S> S S4(@os.l List<? extends T> list, @os.l jn.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(qVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = qVar.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @os.l
    public static final float[] S5(@os.l Collection<Float> collection) {
        kn.l0.p(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            fArr[i10] = it.next().floatValue();
            i10++;
        }
        return fArr;
    }

    @an.f
    public static final <T> T T1(List<? extends T> list) {
        kn.l0.p(list, "<this>");
        return list.get(2);
    }

    @an.e
    public static final <T> void T2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, l2> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, k4.f.f8937e);
        while (itA.hasNext()) {
            lVar.invoke((Object) itA.next());
        }
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final float T3(@os.l Iterable<Float> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <S, T extends S> S T4(@os.l List<? extends T> list, @os.l jn.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(qVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = qVar.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @os.l
    public static final <T> HashSet<T> T5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return (HashSet) Q5(iterable, new HashSet(c1.j(z.b0(iterable, 12))));
    }

    @an.f
    public static final <T> T U1(List<? extends T> list) {
        kn.l0.p(list, "<this>");
        return list.get(3);
    }

    public static final <T> void U2(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super Integer, ? super T, l2> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            pVar.invoke(Integer.valueOf(i10), t10);
            i10 = i11;
        }
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    @os.l
    public static final <T extends Comparable<? super T>> T U3(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <S, T extends S> S U4(@os.l List<? extends T> list, @os.l jn.p<? super T, ? super S, ? extends S> pVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(pVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = pVar.invoke(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @os.l
    public static int[] U5(@os.l Collection<Integer> collection) {
        kn.l0.p(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    @an.f
    public static final <T> T V1(List<? extends T> list) {
        kn.l0.p(list, "<this>");
        return list.get(4);
    }

    @an.f
    public static final <T> T V2(List<? extends T> list, int i10, jn.l<? super Integer, ? extends T> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > y.J(list)) ? lVar.invoke(Integer.valueOf(i10)) : list.get(i10);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static <T> T V3(@os.l Iterable<? extends T> iterable, @os.l Comparator<? super T> comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> Iterable<T> V4(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + n1.e.f11183c);
            }
        }
        return iterable;
    }

    @os.l
    public static <T> List<T> V5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return y.T(X5(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return k0.INSTANCE;
        }
        if (size != 1) {
            return Y5(collection);
        }
        return x.k(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static <T> boolean W1(@os.l Iterable<? extends T> iterable, T t10) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t10);
        }
        return c3(iterable, t10) >= 0;
    }

    @os.m
    public static <T> T W2(@os.l List<? extends T> list, int i10) {
        kn.l0.p(list, "<this>");
        if (i10 < 0 || i10 > y.J(list)) {
            return null;
        }
        return list.get(i10);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final <T> T W3(@os.l Iterable<? extends T> iterable, @os.l Comparator<? super T> comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> List<T> W4(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + n1.e.f11183c);
            }
        }
        return list;
    }

    @os.l
    public static long[] W5(@os.l Collection<Long> collection) {
        kn.l0.p(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArr[i10] = it.next().longValue();
            i10++;
        }
        return jArr;
    }

    public static final <T> int X1(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                y.Y();
            }
        }
        return i10;
    }

    @os.l
    public static final <T, K> Map<K, List<T>> X2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : iterable) {
            K kInvoke = lVar.invoke(t10);
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(t10);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @os.m
    @lm.f1(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T X3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    @os.l
    public static final <T> List<T> X4(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return V5(iterable);
        }
        List<T> listX5 = X5(iterable);
        g0.r1(listX5);
        return listX5;
    }

    @os.l
    public static final <T> List<T> X5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? Y5((Collection) iterable) : (List) Q5(iterable, new ArrayList());
    }

    public static final <T> int Y1(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() && (i10 = i10 + 1) < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
                y.Y();
            }
        }
        return i10;
    }

    @os.l
    public static final <T, K, V> Map<K, List<V>> Y2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : iterable) {
            K kInvoke = lVar.invoke(t10);
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(t10));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T Y3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R> List<R> Y4(@os.l Iterable<? extends T> iterable, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "operation");
        int iB0 = z.b0(iterable, 9);
        if (iB0 == 0) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iB0 + 1);
        arrayList.add(r10);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r10 = pVar.invoke(r10, it.next());
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.l
    public static <T> List<T> Y5(@os.l Collection<? extends T> collection) {
        kn.l0.p(collection, "<this>");
        return new ArrayList(collection);
    }

    @an.f
    public static final <T> int Z1(Collection<? extends T> collection) {
        kn.l0.p(collection, "<this>");
        return collection.size();
    }

    @os.l
    public static final <T, K, M extends Map<? super K, List<T>>> M Z2(@os.l Iterable<? extends T> iterable, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (T t10 : iterable) {
            K kInvoke = lVar.invoke(t10);
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = q.a(m10, kInvoke);
            }
            ((List) objA).add(t10);
        }
        return m10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> double Z3(Iterable<? extends T> iterable, jn.l<? super T, Double> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R> List<R> Z4(@os.l Iterable<? extends T> iterable, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(qVar, "operation");
        int iB0 = z.b0(iterable, 9);
        if (iB0 == 0) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iB0 + 1);
        arrayList.add(r10);
        Iterator<? extends T> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, it.next());
            arrayList.add(r10);
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static <T> Set<T> Z5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) Q5(iterable, new LinkedHashSet());
    }

    @os.l
    public static <T> List<T> a2(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return V5(Z5(iterable));
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, List<V>>> M a3(@os.l Iterable<? extends T> iterable, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (T t10 : iterable) {
            K kInvoke = lVar.invoke(t10);
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(t10));
        }
        return m10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> float a4(Iterable<? extends T> iterable, jn.l<? super T, Float> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return fFloatValue;
    }

    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <S, T extends S> List<S> a5(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return k0.INSTANCE;
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(z.b0(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    @os.l
    public static <T> Set<T> a6(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return o1.r((Set) Q5(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m0.INSTANCE;
        }
        if (size != 1) {
            return (Set) Q5(iterable, new LinkedHashSet(c1.j(collection.size())));
        }
        return n1.f(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @os.l
    public static final <T, K> List<T> b2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (hashSet.add(lVar.invoke(t10))) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K> o0<T, K> b3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "keySelector");
        return new c(iterable, lVar);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R b4(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <S, T extends S> List<S> b5(@os.l Iterable<? extends T> iterable, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(qVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return k0.INSTANCE;
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(z.b0(iterable, 10));
        arrayList.add(next);
        int i10 = 1;
        while (it.hasNext()) {
            next = qVar.invoke(Integer.valueOf(i10), next, it.next());
            arrayList.add(next);
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final short[] b6(@os.l Collection<Short> collection) {
        kn.l0.p(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            sArr[i10] = it.next().shortValue();
            i10++;
        }
        return sArr;
    }

    @os.l
    public static <T> List<T> c2(@os.l Iterable<? extends T> iterable, int i10) {
        ArrayList arrayList;
        kn.l0.p(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return V5(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i10;
            if (size <= 0) {
                return k0.INSTANCE;
            }
            if (size == 1) {
                return x.k(n3(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i10 < size2) {
                        arrayList.add(((List) iterable).get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i11 = 0;
        for (T t10 : iterable) {
            if (i11 >= i10) {
                arrayList.add(t10);
            } else {
                i11++;
            }
        }
        return y.T(arrayList);
    }

    public static final <T> int c3(@os.l Iterable<? extends T> iterable, T t10) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                y.Z();
            }
            if (kn.l0.g(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R c4(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T, R> List<R> c5(@os.l Iterable<? extends T> iterable, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "operation");
        int iB0 = z.b0(iterable, 9);
        if (iB0 == 0) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iB0 + 1);
        arrayList.add(r10);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r10 = pVar.invoke(r10, it.next());
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.l
    public static <T> Set<T> c6(@os.l Iterable<? extends T> iterable, @os.l Iterable<? extends T> iterable2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(iterable2, "other");
        Set<T> setZ5 = Z5(iterable);
        d0.r0(setZ5, iterable2);
        return setZ5;
    }

    @os.l
    public static <T> List<T> d2(@os.l List<? extends T> list, int i10) {
        kn.l0.p(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        List<? extends T> list2 = list;
        int size = list.size() - i10;
        if (size < 0) {
            size = 0;
        }
        return J5(list2, size);
    }

    public static <T> int d3(@os.l List<? extends T> list, T t10) {
        kn.l0.p(list, "<this>");
        return list.indexOf(t10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Double d4(Iterable<? extends T> iterable, jn.l<? super T, Double> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T, R> List<R> d5(@os.l Iterable<? extends T> iterable, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(qVar, "operation");
        int iB0 = z.b0(iterable, 9);
        if (iB0 == 0) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iB0 + 1);
        arrayList.add(r10);
        Iterator<? extends T> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, it.next());
            arrayList.add(r10);
            i10++;
        }
        return arrayList;
    }

    @lm.f1(version = "1.2")
    @os.l
    public static final <T> List<List<T>> d6(@os.l Iterable<? extends T> iterable, int i10, int i11, boolean z10) {
        kn.l0.p(iterable, "<this>");
        r1.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = r1.b(iterable.iterator(), i10, i11, z10, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i11) + (size % i11 == 0 ? 0 : 1));
        int i12 = 0;
        while (i12 >= 0 && i12 < size) {
            int i13 = size - i12;
            if (i10 <= i13) {
                i13 = i10;
            }
            if (i13 < i10 && !z10) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(i13);
            for (int i14 = 0; i14 < i13; i14++) {
                arrayList3.add(list.get(i14 + i12));
            }
            arrayList2.add(arrayList3);
            i12 += i11;
        }
        return arrayList2;
    }

    @os.l
    public static final <T> List<T> e2(@os.l List<? extends T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!lVar.invoke(listIterator.previous()).booleanValue()) {
                    return J5(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return k0.INSTANCE;
    }

    public static final <T> int e3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        int i10 = 0;
        while (itA.hasNext()) {
            a1.e eVar = (Object) itA.next();
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            if (lVar.invoke(eVar).booleanValue()) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Float e4(Iterable<? extends T> iterable, jn.l<? super T, Float> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.3")
    public static final <T> void e5(@os.l List<T> list, @os.l rn.f fVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(fVar, "random");
        for (int iJ = y.J(list); iJ > 0; iJ--) {
            int iNextInt = fVar.nextInt(iJ + 1);
            list.set(iNextInt, list.set(iJ, list.get(iNextInt)));
        }
    }

    @lm.f1(version = "1.2")
    @os.l
    public static final <T, R> List<R> e6(@os.l Iterable<? extends T> iterable, int i10, int i11, boolean z10, @os.l jn.l<? super List<? extends T>, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "transform");
        r1.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = r1.b(iterable.iterator(), i10, i11, z10, true);
            while (itB.hasNext()) {
                arrayList.add(lVar.invoke((List) itB.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        int i12 = 0;
        ArrayList arrayList2 = new ArrayList((size / i11) + (size % i11 == 0 ? 0 : 1));
        g1 g1Var = new g1(list);
        while (i12 >= 0 && i12 < size) {
            int i13 = size - i12;
            if (i10 <= i13) {
                i13 = i10;
            }
            if (!z10 && i13 < i10) {
                break;
            }
            g1Var.a(i12, i13 + i12);
            arrayList2.add(lVar.invoke(g1Var));
            i12 += i11;
        }
        return arrayList2;
    }

    @os.l
    public static final <T> List<T> f2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (T t10 : iterable) {
            if (z10) {
                arrayList.add(t10);
            } else if (!lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
                z10 = true;
            }
        }
        return arrayList;
    }

    public static final <T> int f3(@os.l List<? extends T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R f4(Iterable<? extends T> iterable, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static <T> T f5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) h5((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static /* synthetic */ List f6(Iterable iterable, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return d6(iterable, i10, i11, z10);
    }

    public static final <T> T g2(@os.l Iterable<? extends T> iterable, int i10) {
        kn.l0.p(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i10) : (T) i2(iterable, i10, new b(i10));
    }

    public static final <T> int g3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        int i10 = -1;
        int i11 = 0;
        while (itA.hasNext()) {
            a1.e eVar = (Object) itA.next();
            if (i11 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            if (lVar.invoke(eVar).booleanValue()) {
                i10 = i11;
            }
            i11++;
        }
        return i10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R g4(Iterable<? extends T> iterable, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final <T> T g5(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        T t10 = null;
        boolean z10 = false;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z10 = true;
                t10 = (T) obj;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static /* synthetic */ List g6(Iterable iterable, int i10, int i11, boolean z10, jn.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return e6(iterable, i10, i11, z10, lVar);
    }

    @an.f
    public static final <T> T h2(List<? extends T> list, int i10) {
        kn.l0.p(list, "<this>");
        return list.get(i10);
    }

    public static final <T> int h3(@os.l List<? extends T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (lVar.invoke(listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static <T extends Comparable<? super T>> T h4(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> T h5(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @os.l
    public static <T> Iterable<s0<T>> h6(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return new t0(new d(iterable));
    }

    public static final <T> T i2(@os.l Iterable<? extends T> iterable, int i10, @os.l jn.l<? super Integer, ? extends T> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i10 < 0 || i10 > y.J(list)) ? lVar.invoke(Integer.valueOf(i10)) : (T) list.get(i10);
        }
        if (i10 < 0) {
            return lVar.invoke(Integer.valueOf(i10));
        }
        int i11 = 0;
        for (T t10 : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return lVar.invoke(Integer.valueOf(i10));
    }

    @os.l
    public static <T> Set<T> i3(@os.l Iterable<? extends T> iterable, @os.l Iterable<? extends T> iterable2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(iterable2, "other");
        Set<T> setZ5 = Z5(iterable);
        d0.S0(setZ5, iterable2);
        return setZ5;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double i4(@os.l Iterable<Double> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    public static <T> T i5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @os.l
    public static <T, R> List<lm.t0<T, R>> i6(@os.l Iterable<? extends T> iterable, @os.l Iterable<? extends R> iterable2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), z.b0(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new lm.t0(it.next(), it2.next()));
        }
        return arrayList;
    }

    @an.f
    public static final <T> T j2(List<? extends T> list, int i10, jn.l<? super Integer, ? extends T> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > y.J(list)) ? lVar.invoke(Integer.valueOf(i10)) : list.get(i10);
    }

    @os.l
    public static final <T, A extends Appendable> A j3(@os.l Iterable<? extends T> iterable, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : iterable) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            jq.w.b(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float j4(@os.l Iterable<Float> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    public static final <T> T j5(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        boolean z10 = false;
        T t10 = null;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                if (z10) {
                    return null;
                }
                z10 = true;
                t10 = (T) obj;
            }
        }
        if (z10) {
            return t10;
        }
        return null;
    }

    @os.l
    public static final <T, R, V> List<V> j6(@os.l Iterable<? extends T> iterable, @os.l Iterable<? extends R> iterable2, @os.l jn.p<? super T, ? super R, ? extends V> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(iterable2, "other");
        kn.l0.p(pVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), z.b0(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(pVar.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    @os.m
    public static final <T> T k2(@os.l Iterable<? extends T> iterable, int i10) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) W2((List) iterable, i10);
        }
        if (i10 < 0) {
            return null;
        }
        int i11 = 0;
        for (T t10 : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return null;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final double k4(@os.l Iterable<Double> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    @os.m
    public static <T> T k5(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @os.l
    public static final <T, R> List<lm.t0<T, R>> k6(@os.l Iterable<? extends T> iterable, @os.l R[] rArr) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(rArr, "other");
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (T t10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(t10, rArr[i10]));
            i10++;
        }
        return arrayList;
    }

    @an.f
    public static final <T> T l2(List<? extends T> list, int i10) {
        kn.l0.p(list, "<this>");
        return (T) W2(list, i10);
    }

    @os.l
    public static <T> String l3(@os.l Iterable<? extends T> iterable, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super T, ? extends CharSequence> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) j3(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final float l4(@os.l Iterable<Float> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @os.l
    public static final <T> List<T> l5(@os.l List<? extends T> list, @os.l Iterable<Integer> iterable) {
        kn.l0.p(list, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T, R, V> List<V> l6(@os.l Iterable<? extends T> iterable, @os.l R[] rArr, @os.l jn.p<? super T, ? super R, ? extends V> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (T t10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(t10, rArr[i10]));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static <T> List<T> m2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ String m3(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return l3(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    @os.l
    public static final <T extends Comparable<? super T>> T m4(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.l
    public static final <T> List<T> m5(@os.l List<? extends T> list, @os.l tn.l lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : V5(list.subList(lVar.f15911a, lVar.f15912b + 1));
    }

    @lm.f1(version = "1.2")
    @os.l
    public static final <T> List<lm.t0<T, T>> m6(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(new lm.t0(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @os.l
    public static final <T> List<T> n2(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super Integer, ? super T, Boolean> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            if (pVar.invoke(Integer.valueOf(i10), t10).booleanValue()) {
                arrayList.add(t10);
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static <T> T n3(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) p3((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T> T n4(@os.l Iterable<? extends T> iterable, @os.l Comparator<? super T> comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T, R extends Comparable<? super R>> void n5(@os.l List<T> list, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "selector");
        if (list.size() > 1) {
            c0.p0(list, new rm.g.a(lVar));
        }
    }

    @lm.f1(version = "1.2")
    @os.l
    public static final <T, R> List<R> n6(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super T, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        a1.e next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(pVar.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C o2(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.p<? super Integer, ? super T, Boolean> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            if (pVar.invoke(Integer.valueOf(i10), t10).booleanValue()) {
                c10.add(t10);
            }
            i10 = i11;
        }
        return c10;
    }

    public static final <T> T o3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        T t10 = null;
        boolean z10 = false;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                z10 = true;
                t10 = (T) obj;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final <T> T o4(@os.l Iterable<? extends T> iterable, @os.l Comparator<? super T> comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T, R extends Comparable<? super R>> void o5(@os.l List<T> list, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "selector");
        if (list.size() > 1) {
            c0.p0(list, new rm.g.c(lVar));
        }
    }

    public static final <R> List<R> p2(Iterable<?> iterable) {
        kn.l0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            kn.l0.P();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T p3(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(y.J(list));
    }

    @os.l
    public static final <T> List<T> p4(@os.l Iterable<? extends T> iterable, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(mVar, "elements");
        List listC3 = gq.v.c3(mVar);
        if (listC3.isEmpty()) {
            return V5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!listC3.contains(t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final <T extends Comparable<? super T>> void p5(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        c0.p0(list, rm.g.x());
    }

    public static final <R, C extends Collection<? super R>> C q2(Iterable<?> iterable, C c10) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (Object obj : iterable) {
            kn.l0.P();
            if (obj != null) {
                c10.add(obj);
            }
        }
        return c10;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T q3(@os.l List<? extends T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (lVar.invoke(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @os.l
    public static final <T> List<T> q4(@os.l Iterable<? extends T> iterable, @os.l Iterable<? extends T> iterable2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(iterable2, "elements");
        Collection collectionT0 = d0.t0(iterable2);
        if (collectionT0.isEmpty()) {
            return V5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!collectionT0.contains(t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @os.l
    public static <T extends Comparable<? super T>> List<T> q5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listX5 = X5(iterable);
            c0.m0(listX5);
            return listX5;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return V5(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        p.U3((Comparable[]) array);
        return p.t(array);
    }

    @os.l
    public static final <T> List<T> r2(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final <T> int r3(@os.l Iterable<? extends T> iterable, T t10) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t10);
        }
        int i10 = -1;
        int i11 = 0;
        for (T t11 : iterable) {
            if (i11 < 0) {
                y.Z();
            }
            if (kn.l0.g(t10, t11)) {
                i10 = i11;
            }
            i11++;
        }
        return i10;
    }

    @os.l
    public static <T> List<T> r4(@os.l Iterable<? extends T> iterable, T t10) {
        kn.l0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList(z.b0(iterable, 10));
        boolean z10 = false;
        for (T t11 : iterable) {
            boolean z11 = true;
            if (!z10 && kn.l0.g(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(t11);
            }
        }
        return arrayList;
    }

    @os.l
    public static final <T, R extends Comparable<? super R>> List<T> r5(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "selector");
        return u5(iterable, new rm.g.a(lVar));
    }

    @os.l
    public static final <T> List<T> s2(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return (List) t2(iterable, new ArrayList());
    }

    public static final <T> int s3(@os.l List<? extends T> list, T t10) {
        kn.l0.p(list, "<this>");
        return list.lastIndexOf(t10);
    }

    @os.l
    public static final <T> List<T> s4(@os.l Iterable<? extends T> iterable, @os.l T[] tArr) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(tArr, "elements");
        if (tArr.length == 0) {
            return V5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!r.s8(tArr, t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @os.l
    public static final <T, R extends Comparable<? super R>> List<T> s5(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "selector");
        return u5(iterable, new rm.g.c(lVar));
    }

    @os.l
    public static final <C extends Collection<? super T>, T> C t2(@os.l Iterable<? extends T> iterable, @os.l C c10) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (T t10 : iterable) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @os.m
    public static <T> T t3(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @an.f
    public static final <T> List<T> t4(Iterable<? extends T> iterable, T t10) {
        kn.l0.p(iterable, "<this>");
        return r4(iterable, t10);
    }

    @os.l
    public static final <T extends Comparable<? super T>> List<T> t5(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return u5(iterable, rm.g.x());
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C u2(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (T t10 : iterable) {
            if (!lVar.invoke(t10).booleanValue()) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @os.m
    public static final <T> T u3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        T t10 = null;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                t10 = (T) obj;
            }
        }
        return t10;
    }

    public static <T> boolean u4(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static <T> List<T> u5(@os.l Iterable<? extends T> iterable, @os.l Comparator<? super T> comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listX5 = X5(iterable);
            c0.p0(listX5, comparator);
            return listX5;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return V5(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        p.h4(array, comparator);
        return p.t(array);
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C v2(@os.l Iterable<? extends T> iterable, @os.l C c10, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (T t10 : iterable) {
            if (lVar.invoke(t10).booleanValue()) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @os.m
    public static <T> T v3(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T> boolean v4(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <T> Set<T> v5(@os.l Iterable<? extends T> iterable, @os.l Iterable<? extends T> iterable2) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(iterable2, "other");
        Set<T> setZ5 = Z5(iterable);
        d0.I0(setZ5, iterable2);
        return setZ5;
    }

    public static <T> boolean w1(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @an.f
    public static final <T> T w2(Iterable<? extends T> iterable, jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            ?? r10 = (Object) itA.next();
            if (lVar.invoke(r10).booleanValue()) {
                return r10;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @os.m
    public static final <T> T w3(@os.l List<? extends T> list, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (lVar.invoke(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <T, C extends Iterable<? extends T>> C w4(@os.l C c10, @os.l jn.l<? super T, l2> lVar) {
        Iterator itA = f0.a(c10, "<this>", lVar, k4.f.f8937e);
        while (itA.hasNext()) {
            lVar.invoke((Object) itA.next());
        }
        return c10;
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final <T> int w5(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Integer> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itA.hasNext()) {
            iIntValue += lVar.invoke((Object) itA.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> boolean x1(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    @an.f
    public static final <T> T x2(Iterable<? extends T> iterable, jn.l<? super T, Boolean> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "predicate");
        T t10 = null;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                t10 = (T) obj;
            }
        }
        return t10;
    }

    @os.l
    public static <T, R> List<R> x3(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(z.b0(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <T, C extends Iterable<? extends T>> C x4(@os.l C c10, @os.l jn.p<? super Integer, ? super T, l2> pVar) {
        kn.l0.p(c10, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int i10 = 0;
        for (T t10 : c10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                y.Z();
            }
            pVar.invoke(Integer.valueOf(i10), t10);
            i10 = i11;
        }
        return c10;
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final <T> double x5(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Double> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itA.hasNext()) {
            dDoubleValue += lVar.invoke((Object) itA.next()).doubleValue();
        }
        return dDoubleValue;
    }

    public static final <T> boolean y1(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    @an.f
    public static final <T> T y2(List<? extends T> list, jn.l<? super T, Boolean> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (lVar.invoke(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    @os.l
    public static final <T, R> List<R> y3(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(z.b0(iterable, 10));
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            arrayList.add(pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return arrayList;
    }

    @os.l
    public static final <T> lm.t0<List<T>, List<T>> y4(@os.l Iterable<? extends T> iterable, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t10 : iterable) {
            if (lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            } else {
                arrayList2.add(t10);
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    @in.i(name = "sumOfByte")
    public static final int y5(@os.l Iterable<Byte> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <T> Iterable<T> z1(Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return iterable;
    }

    public static <T> T z2(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) B2((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @os.l
    public static final <T, R> List<R> z3(@os.l Iterable<? extends T> iterable, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                y.Z();
            }
            R rInvoke = pVar.invoke(Integer.valueOf(i10), t10);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
            i10 = i11;
        }
        return arrayList;
    }

    @os.l
    public static final <T> List<T> z4(@os.l Iterable<? extends T> iterable, @os.l gq.m<? extends T> mVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(mVar, "elements");
        ArrayList arrayList = new ArrayList();
        d0.r0(arrayList, iterable);
        d0.q0(arrayList, mVar);
        return arrayList;
    }

    @in.i(name = "sumOfDouble")
    public static final double z5(@os.l Iterable<Double> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends kn.n0 implements jn.l<Integer, T> {
        final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10) {
            super(1);
            this.$index = i10;
        }

        public final T invoke(int i10) {
            throw new IndexOutOfBoundsException(u.a.a(new StringBuilder("Collection doesn't contain element at index "), this.$index, n1.e.f11183c));
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }
}
