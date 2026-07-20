package fl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(message = "This was moved to another package.", replaceWith = @lm.a1(expression = "DefaultConversionService", imports = {"io.ktor.util.converters.DefaultConversionService"}))
public final class e0 implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final e0 f6029a = new e0();

    @Override // fl.v
    @os.l
    public List<String> a(@os.m Object obj) throws c0 {
        String strName;
        if (obj == null) {
            return nm.k0.INSTANCE;
        }
        if (obj instanceof Iterable) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                nm.d0.r0(arrayList, f6029a.a(it.next()));
            }
            return arrayList;
        }
        Class<?> cls = obj.getClass();
        if (kn.l0.g(cls, Integer.TYPE) ? true : kn.l0.g(cls, Integer.class) ? true : kn.l0.g(cls, Float.TYPE) ? true : kn.l0.g(cls, Float.class) ? true : kn.l0.g(cls, Double.TYPE) ? true : kn.l0.g(cls, Double.class) ? true : kn.l0.g(cls, Long.TYPE) ? true : kn.l0.g(cls, Long.class) ? true : kn.l0.g(cls, Boolean.TYPE) ? true : kn.l0.g(cls, Boolean.class) ? true : kn.l0.g(cls, String.class) ? true : kn.l0.g(cls, String.class) ? true : kn.l0.g(cls, BigInteger.class) ? true : kn.l0.g(cls, BigDecimal.class)) {
            strName = obj.toString();
        } else {
            if (!cls.isEnum()) {
                throw new c0("Type " + cls + " is not supported in default data conversion service");
            }
            strName = ((Enum) obj).name();
        }
        return nm.x.k(strName);
    }

    @Override // fl.v
    @os.l
    public Object b(@os.l List<String> list, @os.l Type type) throws c0 {
        kn.l0.p(list, "values");
        kn.l0.p(type, ik.y0.a.f8215h);
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (rawType == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            }
            if (((Class) rawType).isAssignableFrom(List.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kn.l0.o(actualTypeArguments, "type.actualTypeArguments");
                Type type2 = (Type) nm.r.gt(actualTypeArguments);
                List<String> list2 = list;
                ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
                for (String str : list2) {
                    e0 e0Var = f6029a;
                    kn.l0.o(type2, "itemType");
                    arrayList.add(e0Var.c(str, type2));
                }
                return arrayList;
            }
        }
        if (list.isEmpty()) {
            throw new c0(kn.l0.C("There are no values when trying to construct single value ", type));
        }
        if (list.size() <= 1) {
            return c((String) nm.h0.h5(list), type);
        }
        throw new c0(kn.l0.C("There are multiple values when trying to construct single value ", type));
    }

    public final Object c(String str, Type type) throws c0 {
        Object bigInteger;
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            kn.l0.o(upperBounds, "type.upperBounds");
            Object objGt = nm.r.gt(upperBounds);
            kn.l0.o(objGt, "type.upperBounds.single()");
            return c(str, (Type) objGt);
        }
        if (kn.l0.g(type, Integer.TYPE) ? true : kn.l0.g(type, Integer.class)) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (kn.l0.g(type, Float.TYPE) ? true : kn.l0.g(type, Float.class)) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (kn.l0.g(type, Double.TYPE) ? true : kn.l0.g(type, Double.class)) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (kn.l0.g(type, Long.TYPE) ? true : kn.l0.g(type, Long.class)) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (kn.l0.g(type, Boolean.TYPE) ? true : kn.l0.g(type, Boolean.class)) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (kn.l0.g(type, String.class) ? true : kn.l0.g(type, String.class)) {
            return str;
        }
        if (kn.l0.g(type, BigDecimal.class)) {
            bigInteger = new BigDecimal(str);
        } else {
            if (!kn.l0.g(type, BigInteger.class)) {
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    if (cls.isEnum()) {
                        Object[] enumConstants = cls.getEnumConstants();
                        Object obj = null;
                        if (enumConstants != null) {
                            int length = enumConstants.length;
                            int i10 = 0;
                            while (i10 < length) {
                                Object obj2 = enumConstants[i10];
                                i10++;
                                if (obj2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                                }
                                if (kn.l0.g(((Enum) obj2).name(), str)) {
                                    obj = obj2;
                                    break;
                                }
                            }
                        }
                        if (obj != null) {
                            return obj;
                        }
                        throw new c0("Value " + str + " is not a enum member name of " + type);
                    }
                }
                throw new c0("Type " + type + " is not supported in default data conversion service");
            }
            bigInteger = new BigInteger(str);
        }
        return bigInteger;
    }
}
