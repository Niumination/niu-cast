package tj;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {

    public static class a implements Comparator<p0> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(p0 p0Var, p0 p0Var2) {
            return p0Var2.e() - p0Var.e();
        }
    }

    public static String a(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static <K, V> c b(sj.o oVar, Set<Map.Entry<K, V>> set) {
        return d(oVar, g(set), true);
    }

    public static c c(sj.o oVar, Map<?, ?> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!(key instanceof String)) {
                throw new sj.c.d("Map has a non-string as a key, expecting a path expression as a String");
            }
            map2.put(r0.d((String) key), entry.getValue());
        }
        return d(oVar, map2, false);
    }

    public static c d(sj.o oVar, Map<p0, Object> map, boolean z10) {
        HashSet hashSet = new HashSet();
        HashSet<p0> hashSet2 = new HashSet();
        for (p0 p0Var : map.keySet()) {
            hashSet2.add(p0Var);
            for (p0 p0VarH = p0Var.h(); p0VarH != null; p0VarH = p0VarH.h()) {
                hashSet.add(p0VarH);
            }
        }
        if (z10) {
            hashSet2.removeAll(hashSet);
        } else {
            for (p0 p0Var2 : hashSet2) {
                if (hashSet.contains(p0Var2)) {
                    throw new sj.c.d("In the map, path '" + p0Var2.k() + "' occurs as both the parent object of a value and as a value. Because Map has no defined ordering, this is a broken situation.");
                }
            }
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            map3.put((p0) it.next(), new HashMap());
        }
        for (p0 p0Var3 : hashSet2) {
            p0 p0VarH2 = p0Var3.h();
            Map map4 = p0VarH2 != null ? (Map) map3.get(p0VarH2) : map2;
            String strD = p0Var3.d();
            Object obj = map.get(p0Var3);
            sj.m aVar = z10 ? obj instanceof String ? new g0.a(oVar, (String) obj) : null : m.s(map.get(p0Var3), oVar, j0.KEYS_ARE_PATHS);
            if (aVar != null) {
                map4.put(strD, aVar);
            }
        }
        ArrayList<p0> arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        Collections.sort(arrayList, new a());
        for (p0 p0Var4 : arrayList) {
            Map map5 = (Map) map3.get(p0Var4);
            p0 p0VarH3 = p0Var4.h();
            (p0VarH3 != null ? (Map) map3.get(p0VarH3) : map2).put(p0Var4.d(), new f1(oVar, map5, y0.RESOLVED, false));
        }
        return new f1(oVar, map2, y0.RESOLVED, false);
    }

    public static c e(sj.o oVar, Properties properties) {
        return b(oVar, properties.entrySet());
    }

    public static c f(sj.o oVar, Map<String, String> map) {
        return b(oVar, map.entrySet());
    }

    public static <K, V> Map<p0, Object> g(Set<Map.Entry<K, V>> set) {
        HashMap map = new HashMap();
        for (Map.Entry<K, V> entry : set) {
            K key = entry.getKey();
            if (key instanceof String) {
                map.put(j((String) key), entry.getValue());
            }
        }
        return map;
    }

    public static String h(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf < 0 ? str : str.substring(iLastIndexOf + 1);
    }

    public static c i(Reader reader, sj.o oVar) throws IOException {
        Properties properties = new Properties();
        properties.load(reader);
        return e(oVar, properties);
    }

    public static p0 j(String str) {
        String strH = h(str);
        String strA = a(str);
        p0 p0Var = new p0(strH, null);
        while (strA != null) {
            String strH2 = h(strA);
            strA = a(strA);
            p0Var = new p0(strH2, p0Var);
        }
        return p0Var;
    }
}
