package nm;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nGrouping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n1#1,291:1\n80#1,6:292\n53#1:298\n80#1,6:299\n80#1,6:305\n53#1:311\n80#1,6:312\n80#1,6:318\n53#1:324\n80#1,6:325\n80#1,6:331\n189#1:337\n80#1,6:338\n*S KotlinDebug\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n53#1:292,6\n112#1:298\n112#1:299,6\n143#1:305,6\n164#1:311\n164#1:312,6\n189#1:318,6\n211#1:324\n211#1:325,6\n239#1:331,6\n257#1:337\n257#1:338,6\n*E\n"})
public class r0 extends q0 {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K, R> Map<K, R> c(@os.l o0<T, ? extends K> o0Var, @os.l jn.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> rVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(rVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = o0Var.a(next);
            a1.d dVar = (Object) linkedHashMap.get(objA);
            linkedHashMap.put(objA, rVar.invoke(objA, dVar, next, Boolean.valueOf(dVar == null && !linkedHashMap.containsKey(objA))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K, R, M extends Map<? super K, R>> M d(@os.l o0<T, ? extends K> o0Var, @os.l M m10, @os.l jn.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> rVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(rVar, "operation");
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = o0Var.a(next);
            a1.d dVar = (Object) m10.get(objA);
            m10.put(objA, rVar.invoke(objA, dVar, next, Boolean.valueOf(dVar == null && !m10.containsKey(objA))));
        }
        return m10;
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K, M extends Map<? super K, Integer>> M e(@os.l o0<T, ? extends K> o0Var, @os.l M m10) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            K kA = o0Var.a(itB.next());
            Object obj = m10.get(kA);
            if (obj == null && !m10.containsKey(kA)) {
                obj = 0;
            }
            m10.put(kA, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m10;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K, R> Map<K, R> f(@os.l o0<T, ? extends K> o0Var, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(pVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            K kA = o0Var.a(next);
            a1.e eVar = (Object) linkedHashMap.get(kA);
            if (eVar == null && !linkedHashMap.containsKey(kA)) {
                eVar = (Object) r10;
            }
            linkedHashMap.put(kA, pVar.invoke(eVar, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K, R> Map<K, R> g(@os.l o0<T, ? extends K> o0Var, @os.l jn.p<? super K, ? super T, ? extends R> pVar, @os.l jn.q<? super K, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(pVar, "initialValueSelector");
        kn.l0.p(qVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = o0Var.a(next);
            R rInvoke = (Object) linkedHashMap.get(objA);
            if (rInvoke == null && !linkedHashMap.containsKey(objA)) {
                rInvoke = pVar.invoke(objA, next);
            }
            linkedHashMap.put(objA, qVar.invoke(objA, rInvoke, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K, R, M extends Map<? super K, R>> M h(@os.l o0<T, ? extends K> o0Var, @os.l M m10, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "operation");
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            K kA = o0Var.a(next);
            a1.e eVar = (Object) m10.get(kA);
            if (eVar == null && !m10.containsKey(kA)) {
                eVar = (Object) r10;
            }
            m10.put(kA, pVar.invoke(eVar, next));
        }
        return m10;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K, R, M extends Map<? super K, R>> M i(@os.l o0<T, ? extends K> o0Var, @os.l M m10, @os.l jn.p<? super K, ? super T, ? extends R> pVar, @os.l jn.q<? super K, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "initialValueSelector");
        kn.l0.p(qVar, "operation");
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = o0Var.a(next);
            R rInvoke = (Object) m10.get(objA);
            if (rInvoke == null && !m10.containsKey(objA)) {
                rInvoke = pVar.invoke(objA, next);
            }
            m10.put(objA, qVar.invoke(objA, rInvoke, next));
        }
        return m10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.f1(version = "1.1")
    @os.l
    public static final <S, T extends S, K> Map<K, S> j(@os.l o0<T, ? extends K> o0Var, @os.l jn.q<? super K, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(qVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = o0Var.b();
        while (itB.hasNext()) {
            S sInvoke = (Object) itB.next();
            Object objA = o0Var.a(sInvoke);
            a1.d dVar = (Object) linkedHashMap.get(objA);
            if (!(dVar == null && !linkedHashMap.containsKey(objA))) {
                sInvoke = qVar.invoke(objA, dVar, sInvoke);
            }
            linkedHashMap.put(objA, sInvoke);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.f1(version = "1.1")
    @os.l
    public static final <S, T extends S, K, M extends Map<? super K, S>> M k(@os.l o0<T, ? extends K> o0Var, @os.l M m10, @os.l jn.q<? super K, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(qVar, "operation");
        Iterator itB = o0Var.b();
        while (itB.hasNext()) {
            S sInvoke = (Object) itB.next();
            Object objA = o0Var.a(sInvoke);
            a1.d dVar = (Object) m10.get(objA);
            if (!(dVar == null && !m10.containsKey(objA))) {
                sInvoke = qVar.invoke(objA, dVar, sInvoke);
            }
            m10.put(objA, sInvoke);
        }
        return m10;
    }
}
