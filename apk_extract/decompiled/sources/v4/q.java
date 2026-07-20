package v4;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import y4.n1;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final l f10477v = l.COMPACT;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f10478w = j.IDENTITY;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final m0 f10479x = m0.DOUBLE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final m0 f10480y = m0.LAZILY_PARSED_NUMBER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x4.d f10482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f10483c;
    private final x4.b constructorConstructor;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f10484d;
    public final boolean e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f10487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h0 f10488j;
    private final y4.l jsonAdapterFactory;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f10489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f10490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f10491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f10492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10493o;
    public final d0 p;
    public final List q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f10494r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final n0 f10495s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final n0 f10496t;
    private final ThreadLocal<Map<c5.a<?>, p0>> threadLocalAdapterResults;
    private final ConcurrentMap<c5.a<?>, p0> typeTokenCache;
    public final List u;

    public q() {
        this(x4.d.DEFAULT, f10478w, Collections.emptyMap(), false, false, false, true, f10477v, null, false, true, d0.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f10479x, f10480y, Collections.emptyList());
    }

    public static void a(double d7) {
        if (Double.isNaN(d7) || Double.isInfinite(d7)) {
            throw new IllegalArgumentException(d7 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void assertFullConsumption(Object obj, d5.b bVar) {
        if (obj != null) {
            try {
                if (bVar.peek() == d5.c.END_DOCUMENT) {
                } else {
                    throw new a0("JSON document was not fully consumed.");
                }
            } catch (d5.e e) {
                throw new a0(e);
            } catch (IOException e4) {
                throw new v(e4);
            }
        }
    }

    private static p0 atomicLongAdapter(p0 p0Var) {
        return new o(p0Var, 0).nullSafe();
    }

    private static p0 atomicLongArrayAdapter(p0 p0Var) {
        return new o(p0Var, 1).nullSafe();
    }

    private p0 doubleAdapter(boolean z2) {
        return z2 ? n1.DOUBLE : new m(0);
    }

    private p0 floatAdapter(boolean z2) {
        return z2 ? n1.FLOAT : new m(1);
    }

    private static p0 longAdapter(d0 d0Var) {
        return d0Var == d0.DEFAULT ? n1.LONG : new n();
    }

    @Deprecated
    public x4.d excluder() {
        return this.f10482b;
    }

    public k fieldNamingStrategy() {
        return this.f10483c;
    }

    public <T> T fromJson(String str, Class<T> cls) throws a0 {
        return (T) fromJson(str, c5.a.get((Class) cls));
    }

    public <T> p0 getAdapter(c5.a<T> aVar) {
        boolean z2;
        Objects.requireNonNull(aVar, "type must not be null");
        p0 p0Var = this.typeTokenCache.get(aVar);
        if (p0Var != null) {
            return p0Var;
        }
        Map<? extends c5.a<?>, ? extends p0> map = this.threadLocalAdapterResults.get();
        if (map == null) {
            map = new HashMap<>();
            this.threadLocalAdapterResults.set((Map<c5.a<?>, p0>) map);
            z2 = true;
        } else {
            p0 p0Var2 = (p0) map.get(aVar);
            if (p0Var2 != null) {
                return p0Var2;
            }
            z2 = false;
        }
        try {
            p pVar = new p();
            map.put(aVar, pVar);
            Iterator it = this.f10481a.iterator();
            p0 p0VarCreate = null;
            while (it.hasNext()) {
                p0VarCreate = ((q0) it.next()).create(this, aVar);
                if (p0VarCreate != null) {
                    if (pVar.f10476a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    pVar.f10476a = p0VarCreate;
                    map.put(aVar, p0VarCreate);
                    break;
                }
            }
            if (z2) {
                this.threadLocalAdapterResults.remove();
            }
            if (p0VarCreate != null) {
                if (z2) {
                    this.typeTokenCache.putAll(map);
                }
                return p0VarCreate;
            }
            throw new IllegalArgumentException("GSON (2.13.1) cannot handle " + aVar);
        } catch (Throwable th2) {
            if (z2) {
                this.threadLocalAdapterResults.remove();
            }
            throw th2;
        }
    }

    public <T> p0 getDelegateAdapter(q0 q0Var, c5.a<T> aVar) {
        Objects.requireNonNull(q0Var, "skipPast must not be null");
        Objects.requireNonNull(aVar, "type must not be null");
        if (this.jsonAdapterFactory.isClassJsonAdapterFactory(aVar, q0Var)) {
            q0Var = this.jsonAdapterFactory;
        }
        boolean z2 = false;
        for (q0 q0Var2 : this.f10481a) {
            if (z2) {
                p0 p0VarCreate = q0Var2.create(this, aVar);
                if (p0VarCreate != null) {
                    return p0VarCreate;
                }
            } else if (q0Var2 == q0Var) {
                z2 = true;
            }
        }
        if (!z2) {
            return getAdapter(aVar);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + aVar);
    }

    public boolean htmlSafe() {
        return this.f10486h;
    }

    public r newBuilder() {
        return new r(this);
    }

    public d5.b newJsonReader(Reader reader) {
        d5.b bVar = new d5.b(reader);
        h0 h0Var = this.f10488j;
        if (h0Var == null) {
            h0Var = h0.LEGACY_STRICT;
        }
        bVar.setStrictness(h0Var);
        return bVar;
    }

    public d5.d newJsonWriter(Writer writer) throws IOException {
        if (this.f10485g) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        d5.d dVar = new d5.d(writer);
        dVar.setFormattingStyle(this.f10487i);
        dVar.setHtmlSafe(this.f10486h);
        h0 h0Var = this.f10488j;
        if (h0Var == null) {
            h0Var = h0.LEGACY_STRICT;
        }
        dVar.setStrictness(h0Var);
        dVar.setSerializeNulls(this.e);
        return dVar;
    }

    public boolean serializeNulls() {
        return this.e;
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((u) w.INSTANCE) : toJson(obj, obj.getClass());
    }

    public u toJsonTree(Object obj) {
        return obj == null ? w.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.e + ",factories:" + this.f10481a + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public <T> T fromJson(String str, Type type) throws a0 {
        return (T) fromJson(str, c5.a.get(type));
    }

    public <T> T fromJson(String str, c5.a<T> aVar) throws a0 {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), aVar);
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public u toJsonTree(Object obj, Type type) {
        y4.s sVar = new y4.s();
        toJson(obj, type, sVar);
        return sVar.get();
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws v, a0 {
        return (T) fromJson(reader, c5.a.get((Class) cls));
    }

    public <T> T fromJson(Reader reader, Type type) throws v, a0 {
        return (T) fromJson(reader, c5.a.get(type));
    }

    public void toJson(Object obj, Appendable appendable) throws v {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((u) w.INSTANCE, appendable);
        }
    }

    public <T> T fromJson(Reader reader, c5.a<T> aVar) throws v, a0 {
        d5.b bVarNewJsonReader = newJsonReader(reader);
        T t3 = (T) fromJson(bVarNewJsonReader, aVar);
        assertFullConsumption(t3, bVarNewJsonReader);
        return t3;
    }

    public q(x4.d dVar, k kVar, Map map, boolean z2, boolean z3, boolean z5, boolean z10, l lVar, h0 h0Var, boolean z11, boolean z12, d0 d0Var, String str, int i8, int i9, List list, List list2, List list3, n0 n0Var, n0 n0Var2, List list4) {
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.f10482b = dVar;
        this.f10483c = kVar;
        this.f10484d = map;
        x4.b bVar = new x4.b(map, z12, list4);
        this.constructorConstructor = bVar;
        this.e = z2;
        this.f = z3;
        this.f10485g = z5;
        this.f10486h = z10;
        this.f10487i = lVar;
        this.f10488j = h0Var;
        this.f10489k = z11;
        this.f10490l = z12;
        this.p = d0Var;
        this.f10491m = str;
        this.f10492n = i8;
        this.f10493o = i9;
        this.q = list;
        this.f10494r = list2;
        this.f10495s = n0Var;
        this.f10496t = n0Var2;
        this.u = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(n1.JSON_ELEMENT_FACTORY);
        arrayList.add(y4.z.getFactory(n0Var));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(n1.STRING_FACTORY);
        arrayList.add(n1.INTEGER_FACTORY);
        arrayList.add(n1.BOOLEAN_FACTORY);
        arrayList.add(n1.BYTE_FACTORY);
        arrayList.add(n1.SHORT_FACTORY);
        p0 p0VarLongAdapter = longAdapter(d0Var);
        arrayList.add(n1.newFactory(Long.TYPE, Long.class, p0VarLongAdapter));
        arrayList.add(n1.newFactory(Double.TYPE, Double.class, doubleAdapter(z11)));
        arrayList.add(n1.newFactory(Float.TYPE, Float.class, floatAdapter(z11)));
        arrayList.add(y4.x.getFactory(n0Var2));
        arrayList.add(n1.ATOMIC_INTEGER_FACTORY);
        arrayList.add(n1.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(n1.newFactory(AtomicLong.class, atomicLongAdapter(p0VarLongAdapter)));
        arrayList.add(n1.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(p0VarLongAdapter)));
        arrayList.add(n1.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(n1.CHARACTER_FACTORY);
        arrayList.add(n1.STRING_BUILDER_FACTORY);
        arrayList.add(n1.STRING_BUFFER_FACTORY);
        arrayList.add(n1.newFactory(BigDecimal.class, n1.BIG_DECIMAL));
        arrayList.add(n1.newFactory(BigInteger.class, n1.BIG_INTEGER));
        arrayList.add(n1.newFactory(x4.l.class, n1.LAZILY_PARSED_NUMBER));
        arrayList.add(n1.URL_FACTORY);
        arrayList.add(n1.URI_FACTORY);
        arrayList.add(n1.UUID_FACTORY);
        arrayList.add(n1.CURRENCY_FACTORY);
        arrayList.add(n1.LOCALE_FACTORY);
        arrayList.add(n1.INET_ADDRESS_FACTORY);
        arrayList.add(n1.BIT_SET_FACTORY);
        arrayList.add(y4.h.DEFAULT_STYLE_FACTORY);
        arrayList.add(n1.CALENDAR_FACTORY);
        if (b5.h.SUPPORTS_SQL_TYPES) {
            arrayList.add(b5.h.TIME_FACTORY);
            arrayList.add(b5.h.DATE_FACTORY);
            arrayList.add(b5.h.TIMESTAMP_FACTORY);
        }
        arrayList.add(y4.b.FACTORY);
        arrayList.add(n1.CLASS_FACTORY);
        arrayList.add(new y4.d(bVar));
        arrayList.add(new y4.u(bVar, z3));
        y4.l lVar2 = new y4.l(bVar);
        this.jsonAdapterFactory = lVar2;
        arrayList.add(lVar2);
        arrayList.add(n1.ENUM_FACTORY);
        arrayList.add(new y4.g0(bVar, kVar, dVar, lVar2, list4));
        this.f10481a = Collections.unmodifiableList(arrayList);
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws v {
        try {
            toJson(obj, type, newJsonWriter(x4.c0.writerForAppendable(appendable)));
        } catch (IOException e) {
            throw new v(e);
        }
    }

    public <T> T fromJson(d5.b bVar, Type type) throws v, a0 {
        return (T) fromJson(bVar, c5.a.get(type));
    }

    public <T> T fromJson(d5.b bVar, c5.a<T> aVar) throws v, a0 {
        boolean z2;
        h0 strictness = bVar.getStrictness();
        h0 h0Var = this.f10488j;
        if (h0Var != null) {
            bVar.setStrictness(h0Var);
        } else if (bVar.getStrictness() == h0.LEGACY_STRICT) {
            bVar.setStrictness(h0.LENIENT);
        }
        try {
            try {
                try {
                    try {
                        bVar.peek();
                        z2 = false;
                        try {
                            p0 adapter = getAdapter(aVar);
                            T t3 = (T) adapter.read(bVar);
                            Class clsWrap = x4.v.wrap(aVar.getRawType());
                            if (t3 != null && !clsWrap.isInstance(t3)) {
                                throw new ClassCastException("Type adapter '" + adapter + "' returned wrong type; requested " + aVar.getRawType() + " but got instance of " + t3.getClass() + "\nVerify that the adapter was registered for the correct type.");
                            }
                            bVar.setStrictness(strictness);
                            return t3;
                        } catch (EOFException e) {
                            e = e;
                            if (z2) {
                                bVar.setStrictness(strictness);
                                return null;
                            }
                            throw new a0(e);
                        }
                    } catch (Throwable th2) {
                        bVar.setStrictness(strictness);
                        throw th2;
                    }
                } catch (EOFException e4) {
                    e = e4;
                    z2 = true;
                }
            } catch (IOException e10) {
                throw new a0(e10);
            }
        } catch (AssertionError e11) {
            throw new AssertionError("AssertionError (GSON 2.13.1): " + e11.getMessage(), e11);
        } catch (IllegalStateException e12) {
            throw new a0(e12);
        }
    }

    public void toJson(Object obj, Type type, d5.d dVar) throws v {
        p0 adapter = getAdapter(c5.a.get(type));
        h0 strictness = dVar.getStrictness();
        h0 h0Var = this.f10488j;
        if (h0Var != null) {
            dVar.setStrictness(h0Var);
        } else if (dVar.getStrictness() == h0.LEGACY_STRICT) {
            dVar.setStrictness(h0.LENIENT);
        }
        boolean zIsHtmlSafe = dVar.isHtmlSafe();
        boolean serializeNulls = dVar.getSerializeNulls();
        dVar.setHtmlSafe(this.f10486h);
        dVar.setSerializeNulls(this.e);
        try {
            try {
                try {
                    adapter.write(dVar, obj);
                    dVar.setStrictness(strictness);
                    dVar.setHtmlSafe(zIsHtmlSafe);
                    dVar.setSerializeNulls(serializeNulls);
                } catch (IOException e) {
                    throw new v(e);
                }
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.13.1): " + e4.getMessage(), e4);
            }
        } catch (Throwable th2) {
            dVar.setStrictness(strictness);
            dVar.setHtmlSafe(zIsHtmlSafe);
            dVar.setSerializeNulls(serializeNulls);
            throw th2;
        }
    }

    public <T> p0 getAdapter(Class<T> cls) {
        return getAdapter(c5.a.get((Class) cls));
    }

    public String toJson(u uVar) {
        StringWriter stringWriter = new StringWriter();
        toJson(uVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public <T> T fromJson(u uVar, Class<T> cls) throws a0 {
        return (T) fromJson(uVar, c5.a.get((Class) cls));
    }

    public <T> T fromJson(u uVar, Type type) throws a0 {
        return (T) fromJson(uVar, c5.a.get(type));
    }

    public void toJson(u uVar, Appendable appendable) throws v {
        try {
            toJson(uVar, newJsonWriter(x4.c0.writerForAppendable(appendable)));
        } catch (IOException e) {
            throw new v(e);
        }
    }

    public <T> T fromJson(u uVar, c5.a<T> aVar) throws a0 {
        if (uVar == null) {
            return null;
        }
        return (T) fromJson(new y4.q(uVar), aVar);
    }

    public void toJson(u uVar, d5.d dVar) throws v {
        h0 strictness = dVar.getStrictness();
        boolean zIsHtmlSafe = dVar.isHtmlSafe();
        boolean serializeNulls = dVar.getSerializeNulls();
        dVar.setHtmlSafe(this.f10486h);
        dVar.setSerializeNulls(this.e);
        h0 h0Var = this.f10488j;
        if (h0Var != null) {
            dVar.setStrictness(h0Var);
        } else if (dVar.getStrictness() == h0.LEGACY_STRICT) {
            dVar.setStrictness(h0.LENIENT);
        }
        try {
            try {
                x4.c0.write(uVar, dVar);
                dVar.setStrictness(strictness);
                dVar.setHtmlSafe(zIsHtmlSafe);
                dVar.setSerializeNulls(serializeNulls);
            } catch (IOException e) {
                throw new v(e);
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.13.1): " + e4.getMessage(), e4);
            }
        } catch (Throwable th2) {
            dVar.setStrictness(strictness);
            dVar.setHtmlSafe(zIsHtmlSafe);
            dVar.setSerializeNulls(serializeNulls);
            throw th2;
        }
    }
}
