package af;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;
import k3.x8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d6 implements i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ze.a f221a = new ze.a("io.grpc.internal.GrpcAttributes.securityLevel");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ze.a f222b = new ze.a("io.grpc.internal.GrpcAttributes.clientEagAttrs");

    public static s2 n() {
        return n4.e == null ? new n4() : new tj.w(1);
    }

    public static Set p(String str, Map map) {
        ze.o2 o2VarValueOf;
        List listC = j2.c(str, map);
        if (listC == null) {
            return null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(ze.o2.class);
        for (Object obj : listC) {
            if (obj instanceof Double) {
                Double d7 = (Double) obj;
                int iIntValue = d7.intValue();
                x8.a("Status code %s is not integral", ((double) iIntValue) == d7.doubleValue(), obj);
                o2VarValueOf = ze.q2.c(iIntValue).f11413a;
                x8.a("Status code %s is not valid", o2VarValueOf.value() == d7.intValue(), obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new h4.w("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    o2VarValueOf = ze.o2.valueOf((String) obj);
                } catch (IllegalArgumentException e) {
                    throw new h4.w("Status code " + obj + " is not valid", e);
                }
            }
            enumSetNoneOf.add(o2VarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static List q(Map map) {
        String strH;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            List listC = j2.c("loadBalancingConfig", map);
            if (listC == null) {
                listC = null;
            } else {
                j2.a(listC);
            }
            arrayList.addAll(listC);
        }
        if (arrayList.isEmpty() && (strH = j2.h("loadBalancingPolicy", map)) != null) {
            arrayList.add(Collections.singletonMap(strH.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static ze.s1 u(List list, ze.d1 d1Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b6 b6Var = (b6) it.next();
            String str = b6Var.f192a;
            ze.c1 c1VarB = d1Var.b(str);
            if (c1VarB != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(d6.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                ze.s1 s1VarE = c1VarB.e(b6Var.f193b);
                return s1VarE.f11433a != null ? s1VarE : new ze.s1(new c6(c1VarB, s1VarE.f11434b));
            }
            arrayList.add(str);
        }
        return new ze.s1(ze.q2.f11404g.h("None of " + arrayList + " specified by Service Config are available."));
    }

    public static List w(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (map.size() != 1) {
                throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
            }
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            arrayList.add(new b6(str, j2.g(str, map)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // af.i6
    public void a(ze.o oVar) {
        i1 i1VarO = o();
        v8.i(oVar, "compressor");
        i1VarO.a(oVar);
    }

    @Override // af.i6
    public void e(int i8) {
        h hVarV = v();
        hVarV.getClass();
        ph.b.c();
        hVarV.o(new g(i8, 0, hVarV));
    }

    @Override // af.i6
    public void flush() {
        if (o().isClosed()) {
            return;
        }
        o().flush();
    }

    @Override // af.i6
    public void g() {
        h hVarV = v();
        w3 w3Var = hVarV.f304d;
        w3Var.f646a = hVarV;
        hVarV.f301a = w3Var;
    }

    @Override // af.i6
    public void i(gf.a aVar) {
        try {
            if (!o().isClosed()) {
                o().d(aVar);
            }
        } finally {
            l1.b(aVar);
        }
    }

    public abstract i1 o();

    public abstract int r();

    public abstract boolean s(o5 o5Var);

    public abstract void t(o5 o5Var);

    public abstract h v();
}
