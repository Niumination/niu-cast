package y4;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 {
    public static final v4.p0 ATOMIC_BOOLEAN;
    public static final v4.q0 ATOMIC_BOOLEAN_FACTORY;
    public static final v4.p0 ATOMIC_INTEGER;
    public static final v4.p0 ATOMIC_INTEGER_ARRAY;
    public static final v4.q0 ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final v4.q0 ATOMIC_INTEGER_FACTORY;
    public static final v4.p0 BIG_DECIMAL;
    public static final v4.p0 BIG_INTEGER;
    public static final v4.p0 BIT_SET;
    public static final v4.q0 BIT_SET_FACTORY;
    public static final v4.p0 BOOLEAN;
    public static final v4.p0 BOOLEAN_AS_STRING;
    public static final v4.q0 BOOLEAN_FACTORY;
    public static final v4.p0 BYTE;
    public static final v4.q0 BYTE_FACTORY;
    public static final v4.p0 CALENDAR;
    public static final v4.q0 CALENDAR_FACTORY;
    public static final v4.p0 CHARACTER;
    public static final v4.q0 CHARACTER_FACTORY;
    public static final v4.p0 CLASS;
    public static final v4.q0 CLASS_FACTORY;
    public static final v4.p0 CURRENCY;
    public static final v4.q0 CURRENCY_FACTORY;
    public static final v4.p0 DOUBLE;
    public static final v4.q0 ENUM_FACTORY;
    public static final v4.p0 FLOAT;
    public static final v4.p0 INET_ADDRESS;
    public static final v4.q0 INET_ADDRESS_FACTORY;
    public static final v4.p0 INTEGER;
    public static final v4.q0 INTEGER_FACTORY;
    public static final v4.p0 JSON_ELEMENT;
    public static final v4.q0 JSON_ELEMENT_FACTORY;
    public static final v4.p0 LAZILY_PARSED_NUMBER;
    public static final v4.p0 LOCALE;
    public static final v4.q0 LOCALE_FACTORY;
    public static final v4.p0 LONG;
    public static final v4.p0 SHORT;
    public static final v4.q0 SHORT_FACTORY;
    public static final v4.p0 STRING;
    public static final v4.p0 STRING_BUFFER;
    public static final v4.q0 STRING_BUFFER_FACTORY;
    public static final v4.p0 STRING_BUILDER;
    public static final v4.q0 STRING_BUILDER_FACTORY;
    public static final v4.q0 STRING_FACTORY;
    public static final v4.p0 URI;
    public static final v4.q0 URI_FACTORY;
    public static final v4.p0 URL;
    public static final v4.q0 URL_FACTORY;
    public static final v4.p0 UUID;
    public static final v4.q0 UUID_FACTORY;

    static {
        v4.p0 p0VarNullSafe = new t0().nullSafe();
        CLASS = p0VarNullSafe;
        CLASS_FACTORY = newFactory(Class.class, p0VarNullSafe);
        v4.p0 p0VarNullSafe2 = new d1().nullSafe();
        BIT_SET = p0VarNullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, p0VarNullSafe2);
        g1 g1Var = new g1();
        BOOLEAN = g1Var;
        BOOLEAN_AS_STRING = new h1();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, g1Var);
        i1 i1Var = new i1();
        BYTE = i1Var;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, i1Var);
        j1 j1Var = new j1();
        SHORT = j1Var;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, j1Var);
        k1 k1Var = new k1();
        INTEGER = k1Var;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, k1Var);
        v4.p0 p0VarNullSafe3 = new l1().nullSafe();
        ATOMIC_INTEGER = p0VarNullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, p0VarNullSafe3);
        v4.p0 p0VarNullSafe4 = new m1().nullSafe();
        ATOMIC_BOOLEAN = p0VarNullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, p0VarNullSafe4);
        v4.p0 p0VarNullSafe5 = new j0().nullSafe();
        ATOMIC_INTEGER_ARRAY = p0VarNullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, p0VarNullSafe5);
        LONG = new k0();
        FLOAT = new l0();
        DOUBLE = new m0();
        n0 n0Var = new n0();
        CHARACTER = n0Var;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, n0Var);
        o0 o0Var = new o0();
        STRING = o0Var;
        BIG_DECIMAL = new p0();
        BIG_INTEGER = new q0();
        LAZILY_PARSED_NUMBER = new r0();
        STRING_FACTORY = newFactory(String.class, o0Var);
        s0 s0Var = new s0();
        STRING_BUILDER = s0Var;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, s0Var);
        u0 u0Var = new u0();
        STRING_BUFFER = u0Var;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, u0Var);
        v0 v0Var = new v0();
        URL = v0Var;
        URL_FACTORY = newFactory(URL.class, v0Var);
        w0 w0Var = new w0();
        URI = w0Var;
        URI_FACTORY = newFactory(URI.class, w0Var);
        x0 x0Var = new x0();
        INET_ADDRESS = x0Var;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, x0Var);
        y0 y0Var = new y0();
        UUID = y0Var;
        UUID_FACTORY = newFactory(UUID.class, y0Var);
        v4.p0 p0VarNullSafe6 = new z0().nullSafe();
        CURRENCY = p0VarNullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, p0VarNullSafe6);
        a1 a1Var = new a1();
        CALENDAR = a1Var;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, a1Var);
        b1 b1Var = new b1();
        LOCALE = b1Var;
        LOCALE_FACTORY = newFactory(Locale.class, b1Var);
        n nVar = n.f11064a;
        JSON_ELEMENT = nVar;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(v4.u.class, nVar);
        ENUM_FACTORY = j.f11059d;
    }

    private n1() {
        throw new UnsupportedOperationException();
    }

    public static <TT> v4.q0 newFactory(c5.a<TT> aVar, v4.p0 p0Var) {
        return new c1(aVar, p0Var, 2);
    }

    public static <TT> v4.q0 newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, v4.p0 p0Var) {
        return new e1(cls, cls2, p0Var, 1);
    }

    public static <T1> v4.q0 newTypeHierarchyFactory(Class<T1> cls, v4.p0 p0Var) {
        return new c1(cls, p0Var, 1);
    }

    public static <TT> v4.q0 newFactory(Class<TT> cls, v4.p0 p0Var) {
        return new c1(cls, p0Var, 0);
    }

    public static <TT> v4.q0 newFactory(Class<TT> cls, Class<TT> cls2, v4.p0 p0Var) {
        return new e1(cls, cls2, p0Var, 0);
    }
}
