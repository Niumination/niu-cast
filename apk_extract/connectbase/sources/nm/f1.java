package nm;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\n_Maps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,594:1\n96#1,5:595\n111#1,5:600\n152#1,3:605\n143#1:608\n215#1:609\n216#1:611\n144#1:612\n215#1:613\n216#1:615\n1#2:610\n1#2:614\n1940#3,14:616\n1963#3,14:630\n2310#3,14:644\n2333#3,14:658\n1864#3,3:672\n*S KotlinDebug\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n76#1:595,5\n89#1:600,5\n125#1:605,3\n135#1:608\n135#1:609\n135#1:611\n135#1:612\n143#1:613\n143#1:615\n135#1:610\n230#1:616,14\n241#1:630,14\n390#1:644,14\n401#1:658,14\n574#1:672,3\n*E\n"})
public class f1 extends e1 {
    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> Float A1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = lVar.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R> R B1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R> R C1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = (Object) rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> Map.Entry<K, V> D1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        return (Map.Entry) h0.n4(map.entrySet(), comparator);
    }

    @lm.f1(version = "1.7")
    @an.f
    @in.i(name = "minWithOrThrow")
    public static final <K, V> Map.Entry<K, V> E1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        return (Map.Entry) h0.o4(map.entrySet(), comparator);
    }

    public static <K, V> boolean F1(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean G1(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <K, V, M extends Map<? extends K, ? extends V>> M H1(@os.l M m10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, l2> lVar) {
        kn.l0.p(m10, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        Iterator<Map.Entry<K, V>> it = m10.entrySet().iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
        return m10;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <K, V, M extends Map<? extends K, ? extends V>> M I1(@os.l M m10, @os.l jn.p<? super Integer, ? super Map.Entry<? extends K, ? extends V>, l2> pVar) {
        kn.l0.p(m10, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        Iterator<T> it = m10.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            a1.e eVar = (Object) it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                y.Z();
            }
            pVar.invoke(Integer.valueOf(i10), eVar);
            i10 = i11;
        }
        return m10;
    }

    @os.l
    public static final <K, V> List<lm.t0<K, V>> J1(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        if (map.size() == 0) {
            return k0.INSTANCE;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return k0.INSTANCE;
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return x.k(new lm.t0(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new lm.t0(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new lm.t0(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static final <K, V> boolean P0(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean Q0(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean R0(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @an.f
    public static final <K, V> Iterable<Map.Entry<K, V>> S0(Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return map.entrySet();
    }

    @os.l
    public static final <K, V> gq.m<Map.Entry<K, V>> T0(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return h0.A1(map.entrySet());
    }

    @an.f
    public static final <K, V> int U0(Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return map.size();
    }

    public static final <K, V> int V0(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    @lm.f1(version = "1.5")
    @an.f
    public static final <K, V, R> R W0(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        R rInvoke;
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                if (rInvoke != null) {
                    return rInvoke;
                }
                throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
            }
        }
        rInvoke = null;
        if (rInvoke != null) {
            return rInvoke;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @lm.f1(version = "1.5")
    @an.f
    public static final <K, V, R> R X0(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                return rInvoke;
            }
        }
        return null;
    }

    @os.l
    public static final <K, V, R> List<R> Y0(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.r0(arrayList, lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @lm.s0
    @in.i(name = "flatMapSequence")
    @lm.f1(version = "1.4")
    @os.l
    public static final <K, V, R> List<R> Z0(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends gq.m<? extends R>> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.q0(arrayList, lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @lm.s0
    @in.i(name = "flatMapSequenceTo")
    @lm.f1(version = "1.4")
    @os.l
    public static final <K, V, R, C extends Collection<? super R>> C a1(@os.l Map<? extends K, ? extends V> map, @os.l C c10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends gq.m<? extends R>> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.q0(c10, lVar.invoke(it.next()));
        }
        return c10;
    }

    @os.l
    public static final <K, V, R, C extends Collection<? super R>> C b1(@os.l Map<? extends K, ? extends V> map, @os.l C c10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.r0(c10, lVar.invoke(it.next()));
        }
        return c10;
    }

    @an.e
    public static final <K, V> void c1(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, l2> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    @os.l
    public static final <K, V, R> List<R> d1(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @os.l
    public static final <K, V, R> List<R> e1(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    @os.l
    public static final <K, V, R, C extends Collection<? super R>> C f1(@os.l Map<? extends K, ? extends V> map, @os.l C c10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
        }
        return c10;
    }

    @os.l
    public static final <K, V, R, C extends Collection<? super R>> C g1(@os.l Map<? extends K, ? extends V> map, @os.l C c10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            c10.add(lVar.invoke(it.next()));
        }
        return c10;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> h1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry3);
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        entry2 = entry3;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @lm.f1(version = "1.7")
    @an.f
    @in.i(name = "maxByOrThrow")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> i1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it.next();
        if (it.hasNext()) {
            R rInvoke = lVar.invoke(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it.next();
                R rInvoke2 = lVar.invoke(entry2);
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    entry = entry2;
                    rInvoke = rInvoke2;
                }
            } while (it.hasNext());
        }
        return entry;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> double j1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke((Object) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> float k1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke((Object) it.next()).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R extends Comparable<? super R>> R l1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R extends Comparable<? super R>> R m1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> Double n1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = lVar.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> Float o1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = lVar.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R> R p1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R> R q1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = (Object) rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> Map.Entry<K, V> r1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        return (Map.Entry) h0.V3(map.entrySet(), comparator);
    }

    @lm.f1(version = "1.7")
    @an.f
    @in.i(name = "maxWithOrThrow")
    public static final <K, V> Map.Entry<K, V> s1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        return (Map.Entry) h0.W3(map.entrySet(), comparator);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> t1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry3);
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        entry2 = entry3;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @lm.f1(version = "1.7")
    @an.f
    @in.i(name = "minByOrThrow")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> u1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it.next();
        if (it.hasNext()) {
            R rInvoke = lVar.invoke(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it.next();
                R rInvoke2 = lVar.invoke(entry2);
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    entry = entry2;
                    rInvoke = rInvoke2;
                }
            } while (it.hasNext());
        }
        return entry;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> double v1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke((Object) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> float w1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke((Object) it.next()).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R extends Comparable<? super R>> R x1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V, R extends Comparable<? super R>> R y1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <K, V> Double z1(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = lVar.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }
}
