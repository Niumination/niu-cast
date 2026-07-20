package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 extends tj.c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15606a = "empty config";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f1 f15607b = empty(g1.t(f15606a));
    private static final long serialVersionUID = 2;
    private final boolean ignoresFallbacks;
    private final boolean resolved;
    private final Map<String, d> value;

    public class a extends d.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p0 f15608b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p0 p0Var) {
            super();
            this.f15608b = p0Var;
        }

        @Override // tj.d.b
        public d b(String str, d dVar) {
            return dVar.relativized(this.f15608b);
        }
    }

    public static final class b implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 1;

        public b() {
        }

        public static boolean a(String str) {
            int length = str.length();
            if (length == 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isDigit(str.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        public b(a aVar) {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            boolean zA = a(str);
            boolean zA2 = a(str2);
            if (zA && zA2) {
                return new BigInteger(str).compareTo(new BigInteger(str2));
            }
            if (zA) {
                return -1;
            }
            if (zA2) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    public static final class c implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p0 f15610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public u0 f15611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final x0 f15612c;

        public c(u0 u0Var, x0 x0Var) {
            this.f15611b = u0Var;
            this.f15612c = x0Var;
            this.f15610a = u0Var.f15736c;
        }

        @Override // tj.d.a
        public d a(String str, d dVar) throws d.c {
            if (!this.f15611b.c()) {
                w0<? extends d> w0VarL = this.f15611b.m(null).l(dVar, this.f15612c);
                this.f15611b = w0VarL.f15744a.m(null).m(this.f15610a);
                return w0VarL.f15745b;
            }
            if (str.equals(this.f15611b.f15736c.f15726a)) {
                u0 u0Var = this.f15611b;
                p0 p0Var = u0Var.f15736c.f15727b;
                if (p0Var != null) {
                    w0<? extends d> w0VarL2 = u0Var.m(p0Var).l(dVar, this.f15612c);
                    this.f15611b = w0VarL2.f15744a.m(null).m(this.f15610a);
                    return w0VarL2.f15745b;
                }
            }
            return dVar;
        }
    }

    public f1(sj.o oVar, Map<String, d> map, y0 y0Var, boolean z10) {
        super(oVar);
        if (map == null) {
            throw new sj.c.d("creating config object with null map");
        }
        this.value = map;
        this.resolved = y0Var == y0.RESOLVED;
        this.ignoresFallbacks = z10;
        if (y0Var == y0.fromValues(map.values())) {
            return;
        }
        throw new sj.c.d("Wrong resolved status on " + this);
    }

    public static final f1 empty() {
        return f15607b;
    }

    public static final f1 emptyMissing(sj.o oVar) {
        return new f1(g1.t(oVar.description() + " (not found)"), Collections.emptyMap());
    }

    public static boolean i(Map<String, sj.x> map, Map<String, sj.x> map2) {
        if (map == map2) {
            return true;
        }
        Set<String> setKeySet = map.keySet();
        if (!setKeySet.equals(map2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!map.get(str).equals(map2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public static int j(Map<String, sj.x> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += map.get((String) it.next()).hashCode();
        }
        return ((arrayList.hashCode() + 41) * 41) + iHashCode;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new z0(this);
    }

    @Override // tj.c
    public d attemptPeekWithPartialResolve(String str) {
        return this.value.get(str);
    }

    @Override // tj.d
    public boolean canEqual(Object obj) {
        return obj instanceof sj.n;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.value.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.value.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, sj.x>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, d> entry : this.value.entrySet()) {
            hashSet.add(new AbstractMap.SimpleImmutableEntry(entry.getKey(), entry.getValue()));
        }
        return hashSet;
    }

    @Override // tj.d
    public boolean equals(Object obj) {
        return (obj instanceof sj.n) && canEqual(obj) && i(this, (sj.n) obj);
    }

    @Override // tj.h0
    public boolean hasDescendant(d dVar) {
        Iterator<d> it = this.value.values().iterator();
        while (it.hasNext()) {
            if (it.next() == dVar) {
                return true;
            }
        }
        for (sj.m mVar : this.value.values()) {
            if ((mVar instanceof h0) && ((h0) mVar).hasDescendant(dVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // tj.d
    public int hashCode() {
        return j(this);
    }

    @Override // tj.d
    public boolean ignoresFallbacks() {
        return this.ignoresFallbacks;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.value.keySet();
    }

    public final f1 l(d.b bVar) {
        try {
            return m(bVar);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new sj.c.d("unexpected checked exception", e11);
        }
    }

    public final f1 m(d.a aVar) throws Exception {
        HashMap map = null;
        for (String str : keySet()) {
            d dVar = this.value.get(str);
            d dVarA = aVar.a(str, dVar);
            if (dVarA != dVar) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, dVarA);
            }
        }
        if (map == null) {
            return this;
        }
        HashMap map2 = new HashMap();
        boolean z10 = false;
        for (String str2 : keySet()) {
            if (map.containsKey(str2)) {
                d dVar2 = (d) map.get(str2);
                if (dVar2 != null) {
                    map2.put(str2, dVar2);
                    if (dVar2.resolveStatus() == y0.UNRESOLVED) {
                        z10 = true;
                    }
                }
            } else {
                d dVar3 = this.value.get(str2);
                map2.put(str2, dVar3);
                if (dVar3.resolveStatus() == y0.UNRESOLVED) {
                    z10 = true;
                }
            }
        }
        return new f1(origin(), map2, z10 ? y0.UNRESOLVED : y0.RESOLVED, ignoresFallbacks());
    }

    public final f1 q(y0 y0Var, sj.o oVar, boolean z10) {
        return new f1(oVar, this.value, y0Var, z10);
    }

    @Override // tj.c, tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        int i11;
        if (isEmpty()) {
            sb2.append("{}");
        } else {
            boolean z11 = sVar.f15098d || !z10;
            if (z11) {
                int i12 = i10 + 1;
                sb2.append("{");
                if (sVar.f15097c) {
                    sb2.append('\n');
                }
                i11 = i12;
            } else {
                i11 = i10;
            }
            String[] strArr = (String[]) keySet().toArray(new String[size()]);
            Arrays.sort(strArr, new b(null));
            int length = strArr.length;
            int i13 = 0;
            int i14 = 0;
            while (i14 < length) {
                String str = strArr[i14];
                d dVar = this.value.get(str);
                if (sVar.f15095a) {
                    String[] strArrSplit = dVar.origin().description().split("\n");
                    int length2 = strArrSplit.length;
                    int i15 = 0;
                    while (i15 < length2) {
                        String str2 = strArrSplit[i15];
                        String[] strArr2 = strArrSplit;
                        d.indent(sb2, i10 + 1, sVar);
                        sb2.append('#');
                        if (!str2.isEmpty()) {
                            sb2.append(' ');
                        }
                        sb2.append(str2);
                        sb2.append("\n");
                        i15++;
                        strArrSplit = strArr2;
                    }
                }
                if (sVar.f15096b) {
                    for (String str3 : dVar.origin().comments()) {
                        d.indent(sb2, i11, sVar);
                        sb2.append("#");
                        if (!str3.startsWith(" ")) {
                            sb2.append(' ');
                        }
                        sb2.append(str3);
                        sb2.append("\n");
                    }
                }
                d.indent(sb2, i11, sVar);
                int i16 = i14;
                dVar.render(sb2, i11, false, str, sVar);
                if (sVar.f15097c) {
                    if (sVar.f15098d) {
                        sb2.append(ks.g.f9491d);
                        i13 = 2;
                    } else {
                        i13 = 1;
                    }
                    sb2.append('\n');
                } else {
                    sb2.append(ks.g.f9491d);
                    i13 = 1;
                }
                i14 = i16 + 1;
            }
            sb2.setLength(sb2.length() - i13);
            if (z11) {
                if (sVar.f15097c) {
                    sb2.append('\n');
                    if (z11) {
                        d.indent(sb2, i10, sVar);
                    }
                }
                sb2.append("}");
            }
        }
        if (z10 && sVar.f15097c) {
            sb2.append('\n');
        }
    }

    @Override // tj.d
    public y0 resolveStatus() {
        return y0.fromBoolean(this.resolved);
    }

    @Override // tj.c, tj.d
    public w0<? extends tj.c> resolveSubstitutions(u0 u0Var, x0 x0Var) throws d.c {
        if (resolveStatus() == y0.RESOLVED) {
            return new w0<>(u0Var, this);
        }
        try {
            c cVar = new c(u0Var, x0Var.e(this));
            return new w0(cVar.f15611b, m(cVar)).a();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (d.c e11) {
            throw e11;
        } catch (Exception e12) {
            throw new sj.c.d("unexpected checked exception", e12);
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.value.size();
    }

    @Override // java.util.Map
    public Collection<sj.x> values() {
        return new HashSet(this.value.values());
    }

    public static final f1 empty(sj.o oVar) {
        return oVar == null ? empty() : new f1(oVar, Collections.emptyMap());
    }

    @Override // tj.c
    public f1 newCopy(y0 y0Var, sj.o oVar) {
        return q(y0Var, oVar, this.ignoresFallbacks);
    }

    @Override // tj.h0
    public f1 replaceChild(d dVar, d dVar2) {
        HashMap map = new HashMap(this.value);
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == dVar) {
                if (dVar2 != null) {
                    entry.setValue(dVar2);
                } else {
                    map.remove(entry.getKey());
                }
                return new f1(origin(), map, y0.fromValues(map.values()), this.ignoresFallbacks);
            }
        }
        throw new sj.c.d("SimpleConfigObject.replaceChild did not find " + dVar + " in " + this);
    }

    @Override // sj.x
    public Map<String, Object> unwrapped() {
        HashMap map = new HashMap();
        for (Map.Entry<String, d> entry : this.value.entrySet()) {
            map.put(entry.getKey(), entry.getValue().unwrapped());
        }
        return map;
    }

    @Override // tj.d
    public f1 withFallbacksIgnored() {
        return this.ignoresFallbacks ? this : q(resolveStatus(), origin(), true);
    }

    @Override // tj.c
    public f1 withOnlyPath(p0 p0Var) {
        f1 f1VarWithOnlyPathOrNull = withOnlyPathOrNull(p0Var);
        return f1VarWithOnlyPathOrNull == null ? new f1(origin(), Collections.emptyMap(), y0.RESOLVED, this.ignoresFallbacks) : f1VarWithOnlyPathOrNull;
    }

    @Override // tj.c
    public f1 withOnlyPathOrNull(p0 p0Var) {
        String str = p0Var.f15726a;
        p0 p0Var2 = p0Var.f15727b;
        d dVarWithOnlyPathOrNull = this.value.get(str);
        if (p0Var2 != null) {
            dVarWithOnlyPathOrNull = (dVarWithOnlyPathOrNull == null || !(dVarWithOnlyPathOrNull instanceof tj.c)) ? null : ((tj.c) dVarWithOnlyPathOrNull).withOnlyPathOrNull(p0Var2);
        }
        if (dVarWithOnlyPathOrNull == null) {
            return null;
        }
        return new f1(origin(), Collections.singletonMap(str, dVarWithOnlyPathOrNull), dVarWithOnlyPathOrNull.resolveStatus(), this.ignoresFallbacks);
    }

    @Override // tj.c
    public f1 withoutPath(p0 p0Var) {
        String str = p0Var.f15726a;
        p0 p0Var2 = p0Var.f15727b;
        d dVar = this.value.get(str);
        if (dVar != null && p0Var2 != null && (dVar instanceof tj.c)) {
            tj.c cVarWithoutPath = ((tj.c) dVar).withoutPath(p0Var2);
            HashMap map = new HashMap(this.value);
            map.put(str, cVarWithoutPath);
            return new f1(origin(), map, y0.fromValues(map.values()), this.ignoresFallbacks);
        }
        if (p0Var2 != null || dVar == null) {
            return this;
        }
        HashMap map2 = new HashMap(this.value.size() - 1);
        for (Map.Entry<String, d> entry : this.value.entrySet()) {
            if (!entry.getKey().equals(str)) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return new f1(origin(), map2, y0.fromValues(map2.values()), this.ignoresFallbacks);
    }

    @Override // tj.c, sj.n, java.util.Map
    public sj.x get(Object obj) {
        return this.value.get(obj);
    }

    @Override // tj.c, tj.d
    public f1 mergedWithObject(tj.c cVar) {
        requireNotIgnoringFallbacks();
        if (cVar instanceof f1) {
            f1 f1Var = (f1) cVar;
            HashMap map = new HashMap();
            HashSet<String> hashSet = new HashSet();
            hashSet.addAll(keySet());
            hashSet.addAll(f1Var.keySet());
            boolean z10 = false;
            boolean z11 = true;
            for (String str : hashSet) {
                d dVar = this.value.get(str);
                d dVarWithFallback = f1Var.value.get(str);
                if (dVar != null) {
                    dVarWithFallback = dVarWithFallback == null ? dVar : dVar.withFallback((sj.m) dVarWithFallback);
                }
                map.put(str, dVarWithFallback);
                if (dVar != dVarWithFallback) {
                    z10 = true;
                }
                if (dVarWithFallback.resolveStatus() == y0.UNRESOLVED) {
                    z11 = false;
                }
            }
            y0 y0VarFromBoolean = y0.fromBoolean(z11);
            boolean zIgnoresFallbacks = f1Var.ignoresFallbacks();
            if (z10) {
                return new f1(tj.c.mergeOrigins(this, f1Var), map, y0VarFromBoolean, zIgnoresFallbacks);
            }
            return (y0VarFromBoolean == resolveStatus() && zIgnoresFallbacks == ignoresFallbacks()) ? this : q(y0VarFromBoolean, origin(), zIgnoresFallbacks);
        }
        throw new sj.c.d("should not be reached (merging non-SimpleConfigObject)");
    }

    @Override // tj.c, tj.d
    public f1 relativized(p0 p0Var) {
        return l(new a(p0Var));
    }

    @Override // tj.c, sj.n
    public f1 withOnlyKey(String str) {
        return withOnlyPath(p0.f(str));
    }

    @Override // tj.c, sj.n
    public f1 withoutKey(String str) {
        return withoutPath(p0.f(str));
    }

    @Override // tj.c
    public f1 withValue(p0 p0Var, sj.x xVar) {
        String str = p0Var.f15726a;
        p0 p0Var2 = p0Var.f15727b;
        if (p0Var2 == null) {
            return withValue(str, xVar);
        }
        d dVar = this.value.get(str);
        if (dVar != null && (dVar instanceof tj.c)) {
            return withValue(str, (sj.x) ((tj.c) dVar).withValue(p0Var2, xVar));
        }
        return withValue(str, (sj.x) ((d) xVar).atPath(g1.t("withValue(" + p0Var2.k() + ")"), p0Var2).root());
    }

    public f1(sj.o oVar, Map<String, d> map) {
        this(oVar, map, y0.fromValues(map.values()), false);
    }

    @Override // tj.c, sj.n
    public f1 withValue(String str, sj.x xVar) {
        Map mapSingletonMap;
        if (xVar != null) {
            if (this.value.isEmpty()) {
                mapSingletonMap = Collections.singletonMap(str, (d) xVar);
            } else {
                HashMap map = new HashMap(this.value);
                map.put(str, (d) xVar);
                mapSingletonMap = map;
            }
            return new f1(origin(), mapSingletonMap, y0.fromValues(mapSingletonMap.values()), this.ignoresFallbacks);
        }
        throw new sj.c.d("Trying to store null ConfigValue in a ConfigObject");
    }
}
