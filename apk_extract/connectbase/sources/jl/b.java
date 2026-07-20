package jl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import kn.l0;
import kn.l1;
import kn.m1;
import nm.x;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final Object a(String str, un.d<?> dVar) {
        Object bigInteger;
        if (l0.g(dVar, l1.d(Integer.class))) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        m1 m1Var = l1.f9319a;
        if (l0.g(dVar, m1Var.d(Float.class))) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (l0.g(dVar, m1Var.d(Double.class))) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (l0.g(dVar, m1Var.d(Long.class))) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (l0.g(dVar, m1Var.d(Short.class))) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (l0.g(dVar, m1Var.d(Boolean.class))) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (l0.g(dVar, m1Var.d(String.class))) {
            return str;
        }
        if (l0.g(dVar, m1Var.d(Character.class))) {
            return Character.valueOf(str.charAt(0));
        }
        if (l0.g(dVar, m1Var.d(BigDecimal.class))) {
            bigInteger = new BigDecimal(str);
        } else {
            if (!l0.g(dVar, m1Var.d(BigInteger.class))) {
                return null;
            }
            bigInteger = new BigInteger(str);
        }
        return bigInteger;
    }

    @m
    public static final Object b(@l String str, @l un.d<?> dVar) throws d {
        l0.p(str, "value");
        l0.p(dVar, "klass");
        Object objA = a(str, dVar);
        if (objA != null) {
            return objA;
        }
        Object obj = null;
        if (!in.b.e(dVar).isEnum()) {
            return null;
        }
        Object[] enumConstants = in.b.e(dVar).getEnumConstants();
        if (enumConstants != null) {
            int length = enumConstants.length;
            int i10 = 0;
            while (i10 < length) {
                Object obj2 = enumConstants[i10];
                i10++;
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                }
                if (l0.g(((Enum) obj2).name(), str)) {
                    obj = obj2;
                    break;
                }
            }
        }
        if (obj != null) {
            return obj;
        }
        throw new d("Value " + str + " is not a enum member name of " + dVar);
    }

    @m
    public static final List<String> c(@l Object obj) {
        l0.p(obj, "value");
        if (obj instanceof Enum) {
            return x.k(((Enum) obj).name());
        }
        if ((obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Short) || (obj instanceof String) || (obj instanceof Character) || (obj instanceof BigDecimal) || (obj instanceof BigInteger)) {
            return x.k(obj.toString());
        }
        return null;
    }
}
