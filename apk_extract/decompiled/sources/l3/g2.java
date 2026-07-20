package l3;

import com.google.protobuf.GeneratedMessage;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f7238a = GeneratedMessage.class;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p2 f7239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p2 f7240c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Class<?> cls;
        p2 p2Var = null;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                p2Var = (p2) cls.getConstructor(null).newInstance(null);
            } catch (Throwable unused2) {
            }
        }
        f7239b = p2Var;
        f7240c = new p2();
    }

    public static int A(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) + 4) * size;
    }

    public static int B(List list) {
        return list.size() * 4;
    }

    public static int C(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) + 8) * size;
    }

    public static int D(List list) {
        return list.size() * 8;
    }

    public static int E(int i8, List list, f2 f2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iN = 0;
        for (int i9 = 0; i9 < size; i9++) {
            iN += c0.n(i8, (q1) list.get(i9), f2Var);
        }
        return iN;
    }

    public static int F(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) * size) + G(list);
    }

    public static int G(List list) {
        int iO;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            iO = 0;
            while (i8 < size) {
                r0Var.h(i8);
                iO += c0.o(r0Var.f7288b[i8]);
                i8++;
            }
        } else {
            iO = 0;
            while (i8 < size) {
                iO += c0.o(((Integer) list.get(i8)).intValue());
                i8++;
            }
        }
        return iO;
    }

    public static int H(int i8, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) * list.size()) + I(list);
    }

    public static int I(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof j1) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iR = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iR += c0.r(((Long) list.get(i8)).longValue());
        }
        return iR;
    }

    public static int J(int i8, Object obj, f2 f2Var) {
        Logger logger = c0.e;
        int iB = ((q) ((q1) obj)).b(f2Var);
        return c0.q(i8 << 3) + c0.q(iB) + iB;
    }

    public static int K(int i8, List list, f2 f2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = c0.q(i8 << 3) * size;
        for (int i9 = 0; i9 < size; i9++) {
            int iB = ((q) ((q1) list.get(i9))).b(f2Var);
            iQ = h0.a.b(iB, iB, iQ);
        }
        return iQ;
    }

    public static int L(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) * size) + M(list);
    }

    public static int M(List list) {
        int iQ;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            iQ = 0;
            while (i8 < size) {
                r0Var.h(i8);
                int i9 = r0Var.f7288b[i8];
                iQ += c0.q((i9 >> 31) ^ (i9 + i9));
                i8++;
            }
        } else {
            iQ = 0;
            while (i8 < size) {
                int iIntValue = ((Integer) list.get(i8)).intValue();
                iQ += c0.q((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i8++;
            }
        }
        return iQ;
    }

    public static int N(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) * size) + O(list);
    }

    public static int O(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof j1) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iR = 0;
        for (int i8 = 0; i8 < size; i8++) {
            long jLongValue = ((Long) list.get(i8)).longValue();
            iR += c0.r((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iR;
    }

    public static int P(int i8, List list) {
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z2 = list instanceof e1;
        int iQ = c0.q(i8 << 3) * size;
        if (z2) {
            e1 e1Var = (e1) list;
            while (i9 < size) {
                Object objD = e1Var.d(i9);
                if (objD instanceof b0) {
                    int iZzd = ((b0) objD).zzd();
                    iQ = h0.a.b(iZzd, iZzd, iQ);
                } else {
                    iQ = c0.p((String) objD) + iQ;
                }
                i9++;
            }
        } else {
            while (i9 < size) {
                Object obj = list.get(i9);
                if (obj instanceof b0) {
                    int iZzd2 = ((b0) obj).zzd();
                    iQ = h0.a.b(iZzd2, iZzd2, iQ);
                } else {
                    iQ = c0.p((String) obj) + iQ;
                }
                i9++;
            }
        }
        return iQ;
    }

    public static int Q(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) * size) + R(list);
    }

    public static int R(List list) {
        int iQ;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            iQ = 0;
            while (i8 < size) {
                r0Var.h(i8);
                iQ += c0.q(r0Var.f7288b[i8]);
                i8++;
            }
        } else {
            iQ = 0;
            while (i8 < size) {
                iQ += c0.q(((Integer) list.get(i8)).intValue());
                i8++;
            }
        }
        return iQ;
    }

    public static int S(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) * size) + T(list);
    }

    public static int T(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof j1) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iR = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iR += c0.r(((Long) list.get(i8)).longValue());
        }
        return iR;
    }

    public static Object a(Object obj, int i8, int i9, Object obj2, p2 p2Var) {
        o2 o2Var;
        Object obj3 = obj2;
        if (obj2 == null) {
            p2Var.getClass();
            q0 q0Var = (q0) obj;
            o2Var = q0Var.zzc;
            if (o2Var == o2.f) {
                obj3 = o2Var;
                o2 o2VarB = o2.b();
                q0Var.zzc = o2VarB;
                obj3 = o2VarB;
            }
        }
        obj3 = o2Var;
        p2Var.getClass();
        ((o2) obj3).c(i8 << 3, Long.valueOf(i9));
        return obj3;
    }

    public static void b(g0 g0Var, Object obj, Object obj2) {
        h2 h2Var;
        g0Var.getClass();
        i0 i0Var = ((n0) obj2).zza;
        if (i0Var.f7250a.isEmpty()) {
            return;
        }
        i0 i0VarO = ((n0) obj).o();
        i0VarO.getClass();
        int i8 = 0;
        while (true) {
            h2Var = i0Var.f7250a;
            if (i8 >= h2Var.f7245b.size()) {
                break;
            }
            i0VarO.h(h2Var.d(i8));
            i8++;
        }
        Iterator it = h2Var.b().iterator();
        while (it.hasNext()) {
            i0VarO.h((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void c(p2 p2Var, Object obj, Object obj2) {
        p2Var.getClass();
        q0 q0Var = (q0) obj;
        o2 o2Var = q0Var.zzc;
        o2 o2Var2 = ((q0) obj2).zzc;
        o2 o2Var3 = o2.f;
        if (!o2Var3.equals(o2Var2)) {
            if (o2Var3.equals(o2Var)) {
                int i8 = o2Var.f7279a + o2Var2.f7279a;
                int[] iArrCopyOf = Arrays.copyOf(o2Var.f7280b, i8);
                System.arraycopy(o2Var2.f7280b, 0, iArrCopyOf, o2Var.f7279a, o2Var2.f7279a);
                Object[] objArrCopyOf = Arrays.copyOf(o2Var.f7281c, i8);
                System.arraycopy(o2Var2.f7281c, 0, objArrCopyOf, o2Var.f7279a, o2Var2.f7279a);
                o2Var = new o2(i8, iArrCopyOf, objArrCopyOf, true);
            } else {
                o2Var.getClass();
                if (!o2Var2.equals(o2Var3)) {
                    if (!o2Var.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i9 = o2Var.f7279a + o2Var2.f7279a;
                    o2Var.e(i9);
                    System.arraycopy(o2Var2.f7280b, 0, o2Var.f7280b, o2Var.f7279a, o2Var2.f7279a);
                    System.arraycopy(o2Var2.f7281c, 0, o2Var.f7281c, o2Var.f7279a, o2Var2.f7279a);
                    o2Var.f7279a = i9;
                }
            }
        }
        q0Var.zzc = o2Var;
    }

    public static void d(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i9)).booleanValue();
                c0Var.k(i8 << 3);
                c0Var.a(zBooleanValue ? (byte) 1 : (byte) 0);
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Boolean) list.get(i11)).getClass();
            i10++;
        }
        c0Var.k(i10);
        while (i9 < list.size()) {
            c0Var.a(((Boolean) list.get(i9)).booleanValue() ? (byte) 1 : (byte) 0);
            i9++;
        }
    }

    public static void e(int i8, List list, l1 l1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l1Var.getClass();
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((c0) l1Var.f7264a).c(i8, (b0) list.get(i9));
        }
    }

    public static void f(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.f(i8, Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Double) list.get(i11)).getClass();
            i10 += 8;
        }
        c0Var.k(i10);
        while (i9 < list.size()) {
            c0Var.g(Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
            i9++;
        }
    }

    public static void g(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                c0Var.k(i8 << 3);
                if (iIntValue >= 0) {
                    c0Var.k(iIntValue);
                } else {
                    c0Var.m(iIntValue);
                }
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int iO = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iO += c0.o(((Integer) list.get(i10)).intValue());
        }
        c0Var.k(iO);
        while (i9 < list.size()) {
            int iIntValue2 = ((Integer) list.get(i9)).intValue();
            if (iIntValue2 >= 0) {
                c0Var.k(iIntValue2);
            } else {
                c0Var.m(iIntValue2);
            }
            i9++;
        }
    }

    public static void h(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.d(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            i10 += 4;
        }
        c0Var.k(i10);
        while (i9 < list.size()) {
            c0Var.e(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void i(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.f(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            i10 += 8;
        }
        c0Var.k(i10);
        while (i9 < list.size()) {
            c0Var.g(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void j(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.d(i8, Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Float) list.get(i11)).getClass();
            i10 += 4;
        }
        c0Var.k(i10);
        while (i9 < list.size()) {
            c0Var.e(Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
            i9++;
        }
    }

    public static void k(int i8, List list, l1 l1Var, f2 f2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i9 = 0; i9 < list.size(); i9++) {
            l1Var.m(i8, list.get(i9), f2Var);
        }
    }

    public static void l(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                c0Var.k(i8 << 3);
                if (iIntValue >= 0) {
                    c0Var.k(iIntValue);
                } else {
                    c0Var.m(iIntValue);
                }
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int iO = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iO += c0.o(((Integer) list.get(i10)).intValue());
        }
        c0Var.k(iO);
        while (i9 < list.size()) {
            int iIntValue2 = ((Integer) list.get(i9)).intValue();
            if (iIntValue2 >= 0) {
                c0Var.k(iIntValue2);
            } else {
                c0Var.m(iIntValue2);
            }
            i9++;
        }
    }

    public static void m(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.l(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int iR = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iR += c0.r(((Long) list.get(i10)).longValue());
        }
        c0Var.k(iR);
        while (i9 < list.size()) {
            c0Var.m(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void n(int i8, List list, l1 l1Var, f2 f2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i9 = 0; i9 < list.size(); i9++) {
            l1Var.p(i8, list.get(i9), f2Var);
        }
    }

    public static void o(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.d(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            i10 += 4;
        }
        c0Var.k(i10);
        while (i9 < list.size()) {
            c0Var.e(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void p(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.f(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            i10 += 8;
        }
        c0Var.k(i10);
        while (i9 < list.size()) {
            c0Var.g(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void q(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                c0Var.j(i8, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int iQ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            int iIntValue2 = ((Integer) list.get(i10)).intValue();
            iQ += c0.q((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        c0Var.k(iQ);
        while (i9 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i9)).intValue();
            c0Var.k((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i9++;
        }
    }

    public static void r(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                long jLongValue = ((Long) list.get(i9)).longValue();
                c0Var.l(i8, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int iR = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            long jLongValue2 = ((Long) list.get(i10)).longValue();
            iR += c0.r((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        c0Var.k(iR);
        while (i9 < list.size()) {
            long jLongValue3 = ((Long) list.get(i9)).longValue();
            c0Var.m((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i9++;
        }
    }

    public static void s(int i8, List list, l1 l1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l1Var.getClass();
        boolean z2 = list instanceof e1;
        int i9 = 0;
        c0 c0Var = (c0) l1Var.f7264a;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.h(i8, (String) list.get(i9));
                i9++;
            }
            return;
        }
        e1 e1Var = (e1) list;
        while (i9 < list.size()) {
            Object objD = e1Var.d(i9);
            if (objD instanceof String) {
                c0Var.h(i8, (String) objD);
            } else {
                c0Var.c(i8, (b0) objD);
            }
            i9++;
        }
    }

    public static void t(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.j(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int iQ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iQ += c0.q(((Integer) list.get(i10)).intValue());
        }
        c0Var.k(iQ);
        while (i9 < list.size()) {
            c0Var.k(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void u(int i8, List list, l1 l1Var, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0 c0Var = (c0) l1Var.f7264a;
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                c0Var.l(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        c0Var.i(i8, 2);
        int iR = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iR += c0.r(((Long) list.get(i10)).longValue());
        }
        c0Var.k(iR);
        while (i9 < list.size()) {
            c0Var.m(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static boolean v(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int w(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) + 1) * size;
    }

    public static int x(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = c0.q(i8 << 3) * size;
        for (int i9 = 0; i9 < list.size(); i9++) {
            int iZzd = ((b0) list.get(i9)).zzd();
            iQ = h0.a.b(iZzd, iZzd, iQ);
        }
        return iQ;
    }

    public static int y(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (c0.q(i8 << 3) * size) + z(list);
    }

    public static int z(List list) {
        int iO;
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            iO = 0;
            while (i8 < size) {
                r0Var.h(i8);
                iO += c0.o(r0Var.f7288b[i8]);
                i8++;
            }
        } else {
            iO = 0;
            while (i8 < size) {
                iO += c0.o(((Integer) list.get(i8)).intValue());
                i8++;
            }
        }
        return iO;
    }
}
