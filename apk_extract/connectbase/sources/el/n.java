package el;

import fl.o1;
import fl.r1;
import ik.b1;
import ik.h1;
import ik.t0;
import ik.y0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jq.j0;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import kn.u1;
import nm.c1;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(message = "Don't refer to the implementation class directly. Use interface type if possible or use defaultSessionSerializer function to create.")
public final class n<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.s f4538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final un.d<T> f4539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final lm.d0 f4540c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4541a;

        static {
            int[] iArr = new int[un.n.b.values().length];
            iArr[un.n.b.INSTANCE.ordinal()] = 1;
            iArr[un.n.b.EXTENSION_RECEIVER.ordinal()] = 2;
            iArr[un.n.b.VALUE.ordinal()] = 3;
            f4541a = iArr;
        }
    }

    public static final class b extends n0 implements jn.p<String, String, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l String str, @os.l String str2) {
            l0.p(str, cb.b.c.f1408o);
            l0.p(str2, "$noName_1");
            return Boolean.valueOf(!l0.g(str, o.f4542a));
        }
    }

    public static final class d extends n0 implements jn.a<List<? extends un.q<T, ?>>> {
        final /* synthetic */ n<T> this$0;

        public static final class a<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return rm.g.l(((un.q) t10).getName(), ((un.q) t11).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(n<T> nVar) {
            super(0);
            this.this$0 = nVar;
        }

        @Override // jn.a
        @os.l
        public final List<un.q<T, ?>> invoke() {
            return nm.h0.u5(vn.f.G(this.this$0.f4539b), new a());
        }
    }

    public static final class e<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(((un.q) t10).getName(), ((un.q) t11).getName());
        }
    }

    public static final class f extends n0 implements jn.l<Object, CharSequence> {
        final /* synthetic */ n<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(n<T> nVar) {
            super(1);
            this.this$0 = nVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.m Object obj) {
            return ik.e.r(this.this$0.A(obj), false, false, null, 7, null);
        }
    }

    public n(@os.l un.s sVar) {
        l0.p(sVar, "typeInfo");
        this.f4538a = sVar;
        this.f4539b = (un.d<T>) wn.d.b(sVar);
        this.f4540c = lm.f0.b(new d(this));
    }

    public static /* synthetic */ void q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String A(Object obj) {
        if (obj == 0) {
            return "#n";
        }
        if (obj instanceof Integer) {
            return l0.C("#i", obj);
        }
        if (obj instanceof Long) {
            return l0.C("#l", obj);
        }
        if (!(obj instanceof Float) && !(obj instanceof Double)) {
            if (obj instanceof Boolean) {
                return l0.C("#bo", Character.valueOf(j0.S6(String.valueOf(((Boolean) obj).booleanValue()))));
            }
            if (obj instanceof Character) {
                return l0.C("#ch", obj);
            }
            if (obj instanceof BigDecimal) {
                return l0.C("#bd", obj);
            }
            if (obj instanceof BigInteger) {
                return l0.C("#bi", obj);
            }
            if (obj instanceof Optional) {
                Optional optional = (Optional) obj;
                return optional.isPresent() ? l0.C("#op", A(optional.get())) : "#om";
            }
            if (obj instanceof String) {
                return l0.C("#s", obj);
            }
            if (obj instanceof List) {
                return l0.C("#cl", y((Collection) obj));
            }
            if (obj instanceof Set) {
                return l0.C("#cs", y((Collection) obj));
            }
            if (obj instanceof Map) {
                return l0.C("#m", z((Map) obj));
            }
            if (obj instanceof Enum) {
                return l0.C("#s", ((Enum) obj).name());
            }
            return obj instanceof UUID ? l0.C("#s", obj) : l0.C("##", x(obj));
        }
        return l0.C("#f", obj);
    }

    public final Class<?> B(Type type) {
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            l0.o(rawType, "this.rawType");
            return B(rawType);
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        throw new IllegalArgumentException(l0.C("Bad type ", type));
    }

    public final Class<?> C(un.s sVar) {
        return B(wn.e.g(sVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> List<un.d<T>> D(List<? extends un.d<?>> list) {
        return list;
    }

    public final <R> R E(List<?> list, jn.l<? super List<Object>, ? extends R> lVar) {
        return lVar.invoke(u1.g(list));
    }

    public final <R> R F(Map<?, ?> map, jn.l<? super Map<Object, Object>, ? extends R> lVar) {
        return lVar.invoke(u1.k(map));
    }

    public final <R> R G(Set<?> set, jn.l<? super Set<Object>, ? extends R> lVar) {
        return lVar.invoke(u1.o(set));
    }

    @Override // el.m
    @os.l
    public T a(@os.l String str) {
        l0.p(str, "text");
        return l0.g(this.f4539b, l1.d(b1.class)) ? (T) h1.d(str, 0, 0, 6, null) : (T) h(this.f4539b, str);
    }

    public final <X> void c(X x10, un.q<X, ?> qVar, Object obj) {
        Object obj2 = qVar.get(x10);
        if (t(qVar.getReturnType())) {
            if (!(obj instanceof List)) {
                c(x10, qVar, e(qVar.getReturnType(), obj));
                return;
            }
            if (qVar instanceof un.l) {
                ((un.l) qVar).getSetter().call(x10, e(qVar.getReturnType(), obj));
                return;
            }
            if (u1.F(obj2)) {
                List listG = u1.g((List) obj2);
                listG.clear();
                listG.addAll((Collection) obj);
                return;
            } else {
                throw new IllegalStateException("Couldn't inject property " + qVar.getName() + " from value " + obj);
            }
        }
        if (v(qVar.getReturnType())) {
            if (!(obj instanceof Set)) {
                c(x10, qVar, e(qVar.getReturnType(), obj));
                return;
            }
            if (qVar instanceof un.l) {
                ((un.l) qVar).getSetter().call(x10, e(qVar.getReturnType(), obj));
                return;
            }
            if (u1.J(obj2)) {
                Set setO = u1.o((Set) obj2);
                setO.clear();
                setO.addAll((Collection) obj);
                return;
            } else {
                throw new IllegalStateException("Couldn't inject property " + qVar.getName() + " from value " + obj);
            }
        }
        if (!u(qVar.getReturnType())) {
            if (qVar instanceof un.l) {
                if (obj == null && !qVar.getReturnType().o()) {
                    throw new IllegalArgumentException(l0.C("Couldn't inject null to property ", qVar.getName()));
                }
                ((un.l) qVar).getSetter().call(x10, e(qVar.getReturnType(), obj));
                return;
            }
            return;
        }
        if (!(obj instanceof Map)) {
            c(x10, qVar, e(qVar.getReturnType(), obj));
            return;
        }
        if (qVar instanceof un.l) {
            ((un.l) qVar).getSetter().call(x10, e(qVar.getReturnType(), obj));
            return;
        }
        if (u1.H(obj2)) {
            Map mapK = u1.k((Map) obj2);
            mapK.clear();
            mapK.putAll((Map) obj);
        } else {
            throw new IllegalStateException("Couldn't inject property " + qVar.getName() + " from value " + obj);
        }
    }

    public final <T> T d(un.d<T> dVar) {
        Iterator<T> it = dVar.g().iterator();
        while (it.hasNext()) {
            un.i iVar = (un.i) it.next();
            if (iVar.getParameters().isEmpty()) {
                return (T) iVar.call(new Object[0]);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final Object e(un.s sVar, Object obj) {
        Map map;
        Object obj2;
        Set set;
        List list;
        int i10 = 0;
        if (obj == null) {
            return null;
        }
        if (t(sVar)) {
            boolean z10 = obj instanceof List;
            if (!z10 && (obj instanceof Iterable)) {
                return e(sVar, nm.h0.V5((Iterable) obj));
            }
            if (!z10) {
                throw new IllegalArgumentException("Couldn't coerce type " + obj.getClass() + " to " + sVar);
            }
            un.s sVar2 = ((un.u) nm.h0.h5(sVar.n())).f16349b;
            if (sVar2 == null) {
                throw new IllegalArgumentException(l0.C("Star projections are not supported for list element: ", sVar.n().get(0)));
            }
            un.d<T> dVarM = m(j(nm.y.O(in.b.i(C(sVar)), l1.d(ArrayList.class)), sVar));
            if (dVarM == null || (list = (List) d(dVarM)) == null) {
                obj2 = null;
            } else {
                List listG = u1.g(list);
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(nm.z.b0(iterable, 10));
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(e(sVar2, it.next()));
                }
                listG.addAll(arrayList);
                obj2 = listG;
            }
            if (obj2 == null) {
                throw new IllegalArgumentException("Couldn't coerce type " + obj.getClass() + " to " + sVar);
            }
        } else if (v(sVar)) {
            boolean z11 = obj instanceof Set;
            if (!z11 && (obj instanceof Iterable)) {
                return e(sVar, nm.h0.a6((Iterable) obj));
            }
            if (!z11) {
                throw new IllegalArgumentException("Couldn't coerce type " + obj.getClass() + " to " + sVar);
            }
            un.s sVar3 = ((un.u) nm.h0.h5(sVar.n())).f16349b;
            if (sVar3 == null) {
                throw new IllegalArgumentException(l0.C("Star projections are not supported for set element: ", sVar.n().get(0)));
            }
            un.d dVarI = in.b.i(C(sVar));
            un.d dVarD = l1.d(LinkedHashSet.class);
            m1 m1Var = l1.f9319a;
            un.d<T> dVarM2 = m(j(nm.y.O(dVarI, dVarD, m1Var.d(HashSet.class), m1Var.d(TreeSet.class)), sVar));
            if (dVarM2 == null || (set = (Set) d(dVarM2)) == null) {
                obj2 = null;
            } else {
                Set setO = u1.o(set);
                Iterable iterable2 = (Iterable) obj;
                ArrayList arrayList2 = new ArrayList(nm.z.b0(iterable2, 10));
                Iterator<T> it2 = iterable2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(e(sVar3, it2.next()));
                }
                setO.addAll(arrayList2);
                obj2 = setO;
            }
            if (obj2 == null) {
                throw new IllegalArgumentException("Couldn't coerce type " + obj.getClass() + " to " + sVar);
            }
        } else {
            if (!u(sVar)) {
                if (!s(sVar)) {
                    if (l0.g(C(sVar), Float.TYPE) && (obj instanceof Number)) {
                        return Float.valueOf(((Number) obj).floatValue());
                    }
                    return (l0.g(C(sVar), UUID.class) && (obj instanceof String)) ? UUID.fromString((String) obj) : obj;
                }
                Object[] enumConstants = B(wn.e.g(sVar)).getEnumConstants();
                l0.o(enumConstants, "type.javaType.toJavaClass().enumConstants");
                int length = enumConstants.length;
                while (i10 < length) {
                    Object obj3 = enumConstants[i10];
                    i10++;
                    Enum r10 = obj3 instanceof Enum ? (Enum) obj3 : null;
                    if (l0.g(r10 == null ? null : r10.name(), obj)) {
                        return obj3;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
            if (!(obj instanceof Map)) {
                throw new IllegalArgumentException("Couldn't coerce type " + obj.getClass() + " to " + sVar);
            }
            un.s sVar4 = sVar.n().get(0).f16349b;
            if (sVar4 == null) {
                throw new IllegalArgumentException(l0.C("Star projections are not supported for map key: ", sVar.n().get(0)));
            }
            un.s sVar5 = sVar.n().get(1).f16349b;
            if (sVar5 == null) {
                throw new IllegalArgumentException(l0.C("Star projections are not supported for map value ", sVar.n().get(1)));
            }
            un.d dVarI2 = in.b.i(C(sVar));
            un.d dVarD2 = l1.d(LinkedHashMap.class);
            m1 m1Var2 = l1.f9319a;
            un.d<T> dVarM3 = m(j(nm.y.O(dVarI2, dVarD2, m1Var2.d(HashMap.class), m1Var2.d(TreeMap.class), m1Var2.d(ConcurrentHashMap.class)), sVar));
            if (dVarM3 == null || (map = (Map) d(dVarM3)) == null) {
                obj2 = null;
            } else {
                Map mapK = u1.k(map);
                Map map2 = (Map) obj;
                LinkedHashMap linkedHashMap = new LinkedHashMap(c1.j(map2.size()));
                for (Map.Entry entry : map2.entrySet()) {
                    linkedHashMap.put(e(sVar4, entry.getKey()), entry.getValue());
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(c1.j(linkedHashMap.size()));
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    linkedHashMap2.put(entry2.getKey(), e(sVar5, entry2.getValue()));
                }
                mapK.putAll(linkedHashMap2);
                obj2 = mapK;
            }
            if (obj2 == null) {
                throw new IllegalArgumentException("Couldn't coerce type " + obj.getClass() + " to " + sVar);
            }
        }
        return obj2;
    }

    public final List<?> f(String str) {
        List listR4 = jq.h0.R4(ik.e.k(str, 0, 0, false, null, 15, null), new String[]{"&"}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        for (T t10 : listR4) {
            if (((String) t10).length() > 0) {
                arrayList.add(t10);
            }
        }
        ArrayList arrayList2 = new ArrayList(nm.z.b0(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(i(l1.d(Object.class), ik.e.k((String) it.next(), 0, 0, false, null, 15, null)));
        }
        return arrayList2;
    }

    public final Map<?, ?> g(String str) {
        List listR4 = jq.h0.R4(ik.e.k(str, 0, 0, false, null, 15, null), new String[]{"&"}, false, 0, 6, null);
        ArrayList<String> arrayList = new ArrayList();
        for (T t10 : listR4) {
            if (((String) t10).length() > 0) {
                arrayList.add(t10);
            }
        }
        int iJ = c1.j(nm.z.b0(arrayList, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (String str2 : arrayList) {
            linkedHashMap.put(i(l1.d(Object.class), ik.e.k(jq.h0.u5(str2, fl.h.f6043c, null, 2, null), 0, 0, false, null, 15, null)), i(l1.f9319a.d(Object.class), ik.e.k(jq.h0.m5(str2, fl.h.f6043c, null, 2, null), 0, 0, false, null, 15, null)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Y> Y h(un.d<Y> dVar, String str) {
        b1 b1VarD = h1.d(str, 0, 0, 6, null);
        T tW = w(dVar, b1VarD);
        for (un.q<X, ?> qVar : vn.f.G(dVar)) {
            String str2 = b1VarD.get(qVar.getName());
            if (str2 != null) {
                c(tW, qVar, e(qVar.getReturnType(), i(wn.d.b(qVar.getReturnType()), str2)));
            }
        }
        return tW;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object i(un.d<?> dVar, String str) {
        boolean z10 = false;
        if (!jq.e0.s2(str, "#", false, 2, null)) {
            throw new IllegalArgumentException("Bad serialized value");
        }
        Character chJ7 = j0.j7(str, 1);
        if (chJ7 == null || chJ7.charValue() == 'n') {
            return null;
        }
        if (chJ7 != null && chJ7.charValue() == 'i') {
            return Integer.valueOf(Integer.parseInt(j0.y6(str, 2)));
        }
        if (chJ7 != null && chJ7.charValue() == 'l') {
            return Long.valueOf(Long.parseLong(j0.y6(str, 2)));
        }
        if (chJ7 != null && chJ7.charValue() == 'f') {
            return Double.valueOf(Double.parseDouble(j0.y6(str, 2)));
        }
        if (chJ7 != null && chJ7.charValue() == 'b') {
            Character chJ8 = j0.j7(str, 2);
            if (chJ8 == null || chJ8.charValue() != 'o') {
                if (chJ8 != null && chJ8.charValue() == 'd') {
                    return new BigDecimal(j0.y6(str, 3));
                }
                if (chJ8 == null || chJ8.charValue() != 'i') {
                    throw new IllegalArgumentException(l0.C("Unsupported b-type ", j0.V8(str, 3)));
                }
                return new BigInteger(j0.y6(str, 3));
            }
            Character chJ9 = j0.j7(str, 3);
            if (chJ9 != null && chJ9.charValue() == 't') {
                z10 = true;
            } else if (chJ9 == null || chJ9.charValue() != 'f') {
                throw new IllegalArgumentException(l0.C("Unsupported bo-value ", j0.V8(str, 4)));
            }
            return Boolean.valueOf(z10);
        }
        if (chJ7 != null && chJ7.charValue() == 'o') {
            Character chJ10 = j0.j7(str, 2);
            if (chJ10 != null && chJ10.charValue() == 'm') {
                return Optional.empty();
            }
            if (chJ10 == null || chJ10.charValue() != 'p') {
                throw new IllegalArgumentException(l0.C("Unsupported o-value ", j0.V8(str, 3)));
            }
            return Optional.ofNullable(i(dVar, j0.y6(str, 3)));
        }
        if (chJ7 != null && chJ7.charValue() == 's') {
            return j0.y6(str, 2);
        }
        if (chJ7 == null || chJ7.charValue() != 'c') {
            if (chJ7 != null && chJ7.charValue() == 'm') {
                return g(j0.y6(str, 2));
            }
            if (chJ7 == null || chJ7.charValue() != '#') {
                throw new IllegalArgumentException(l0.C("Unsupported type ", j0.V8(str, 2)));
            }
            return h(dVar, j0.y6(str, 2));
        }
        Character chJ11 = j0.j7(str, 2);
        if (chJ11 != null && chJ11.charValue() == 'l') {
            return f(j0.y6(str, 3));
        }
        if (chJ11 != null && chJ11.charValue() == 's') {
            return nm.h0.a6(f(j0.y6(str, 3)));
        }
        if (chJ11 == null || chJ11.charValue() != 'h') {
            throw new IllegalArgumentException(l0.C("Unsupported c-type ", j0.V8(str, 3)));
        }
        return Character.valueOf(j0.S6(j0.y6(str, 3)));
    }

    public final <T> List<un.d<T>> j(List<? extends un.d<T>> list, un.s sVar) {
        ArrayList arrayList = new ArrayList();
        for (T t10 : list) {
            if (C(sVar).isAssignableFrom(in.b.e((un.d) t10))) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public final <T> un.i<T> k(un.d<T> dVar, o1 o1Var) {
        String name;
        T next = null;
        if (dVar.c()) {
            return k(l(dVar, o1Var), r1.i(o1Var, false, b.INSTANCE, 1, null));
        }
        if (dVar.isAbstract()) {
            throw new IllegalStateException(l0.C("Abstract types are not supported: ", dVar).toString());
        }
        String str = o1Var.get(o.f4542a);
        if (str != null && !l0.g(dVar.w(), str)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (dVar.h() != null) {
            return new g1() { // from class: el.n.c
                @Override // kn.g1, un.q
                @os.m
                public Object get(@os.m Object obj) {
                    return ((un.d) obj).h();
                }
            }.getGetter();
        }
        Collection<un.i<T>> collectionG = dVar.g();
        ArrayList arrayList = new ArrayList();
        for (T t10 : collectionG) {
            List<un.n> parameters = ((un.i) t10).getParameters();
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                Iterator<T> it = parameters.iterator();
                do {
                    if (it.hasNext()) {
                        un.n nVar = (un.n) it.next();
                        if (nVar.getName() == null) {
                            break;
                        }
                        name = nVar.getName();
                        l0.m(name);
                    }
                } while (o1Var.contains(name));
            }
            arrayList.add(t10);
        }
        Iterator<T> it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int size = ((un.i) next).getParameters().size();
                do {
                    T next2 = it2.next();
                    int size2 = ((un.i) next2).getParameters().size();
                    if (size < size2) {
                        next = next2;
                        size = size2;
                    }
                } while (it2.hasNext());
            }
        }
        un.i<T> iVar = (un.i) next;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalArgumentException("Couldn't instantiate " + dVar + " for parameters " + o1Var.names());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> un.d<? extends T> l(un.d<T> dVar, o1 o1Var) {
        T next;
        if (!dVar.c()) {
            if (dVar.isAbstract()) {
                throw new IllegalStateException(l0.C("Abstract types are not supported: ", dVar).toString());
            }
            return dVar;
        }
        String str = o1Var.get(o.f4542a);
        if (str == null) {
            throw new IllegalStateException(l0.C("No typeToken found for sealed ", dVar).toString());
        }
        Iterator<T> it = dVar.k().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!l0.g(((un.d) next).w(), str));
        un.d<? extends T> dVar2 = (un.d) next;
        if (dVar2 != null) {
            return dVar2;
        }
        throw new IllegalStateException(("No sealed subclass " + str + " found in " + dVar).toString());
    }

    public final <T> un.d<T> m(List<? extends un.d<T>> list) {
        T next;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            Collection<un.i<T>> collectionG = ((un.d) next).g();
            if (!(collectionG instanceof Collection) || !collectionG.isEmpty()) {
                Iterator<T> it2 = collectionG.iterator();
                while (it2.hasNext()) {
                    if (((un.i) it2.next()).getParameters().isEmpty()) {
                        return (un.d) next;
                    }
                }
            }
        }
        next = null;
        return (un.d) next;
    }

    public final List<un.q<T, ?>> n() {
        return (List) this.f4540c.getValue();
    }

    public final Class<?> o(un.s sVar) {
        Type typeG = wn.e.g(sVar);
        if (!(typeG instanceof ParameterizedType)) {
            if (typeG instanceof Class) {
                return (Class) typeG;
            }
            return null;
        }
        Type rawType = ((ParameterizedType) typeG).getRawType();
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        return null;
    }

    @os.l
    public final un.d<T> p() {
        return this.f4539b;
    }

    @os.l
    public final un.s r() {
        return this.f4538a;
    }

    public final boolean s(un.s sVar) {
        Class<?> clsO = o(sVar);
        if (clsO == null) {
            return false;
        }
        return Enum.class.isAssignableFrom(clsO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // el.m
    @os.l
    public String serialize(@os.l T t10) {
        l0.p(t10, "session");
        return l0.g(this.f4539b, l1.d(b1.class)) ? t0.a((b1) t10) : x(o.d(t10, this.f4539b));
    }

    public final boolean t(un.s sVar) {
        Class<?> clsO = o(sVar);
        if (clsO == null) {
            return false;
        }
        return List.class.isAssignableFrom(clsO);
    }

    public final boolean u(un.s sVar) {
        Class<?> clsO = o(sVar);
        if (clsO == null) {
            return false;
        }
        return Map.class.isAssignableFrom(clsO);
    }

    public final boolean v(un.s sVar) {
        Class<?> clsO = o(sVar);
        if (clsO == null) {
            return false;
        }
        return Set.class.isAssignableFrom(clsO);
    }

    public final <T> T w(un.d<T> dVar, o1 o1Var) {
        un.d<? extends T> dVarL;
        T tH = dVar.h();
        if (tH != null) {
            return tH;
        }
        un.i<T> iVarK = k(dVar, o1Var);
        List<un.n> parameters = iVarK.getParameters();
        int iJ = c1.j(nm.z.b0(parameters, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (un.n nVar : parameters) {
            int i10 = a.f4541a[nVar.getKind().ordinal()];
            if (i10 == 1 || i10 == 2) {
                dVarL = l(dVar, o1Var);
            } else {
                if (i10 != 3) {
                    throw new lm.i0();
                }
                un.s type = nVar.getType();
                un.d<?> dVarB = wn.d.b(nVar.getType());
                String name = nVar.getName();
                l0.m(name);
                String str = o1Var.get(name);
                l0.m(str);
                dVarL = (un.d<? extends T>) e(type, i(dVarB, str));
            }
            linkedHashMap.put(nVar, dVarL);
        }
        return iVarK.callBy(linkedHashMap);
    }

    public final <T> String x(T t10) {
        un.d dVarD = l1.d(t10.getClass());
        List<un.q> listU5 = nm.h0.u5(vn.f.G(dVarD), new e());
        List arrayList = new ArrayList(nm.z.b0(listU5, 10));
        for (un.q qVar : listU5) {
            arrayList.add(new lm.t0(qVar.getName(), A(qVar.get(t10))));
        }
        if (dVarD.w() != null) {
            List<un.d<?>> listO = vn.f.O(dVarD);
            if (!(listO instanceof Collection) || !listO.isEmpty()) {
                Iterator<T> it = listO.iterator();
                while (it.hasNext()) {
                    if (((un.d) it.next()).c()) {
                        String strW = dVarD.w();
                        l0.m(strW);
                        arrayList = nm.h0.F4(arrayList, new lm.t0(o.f4542a, strW));
                        break;
                    }
                }
            }
        }
        return t0.d(arrayList, null, 1, null);
    }

    public final String y(Collection<?> collection) {
        return ik.e.r(nm.h0.m3(collection, "&", null, null, 0, null, new f(this), 30, null), false, false, null, 7, null);
    }

    public final String z(Map<?, ?> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            arrayList.add(ik.e.r(A(entry.getKey()), false, false, null, 7, null) + fl.h.f6043c + ik.e.r(A(entry.getValue()), false, false, null, 7, null));
        }
        return ik.e.r(nm.h0.m3(arrayList, "&", null, null, 0, null, null, 62, null), false, false, null, 7, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(message = "Use defaultSessionSerializer() function instead")
    public n(@os.l un.d<T> dVar) {
        this(vn.g.d(dVar));
        l0.p(dVar, y0.a.f8215h);
    }
}
