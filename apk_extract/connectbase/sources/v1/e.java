package v1;

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

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final boolean A = false;
    public static final boolean B = false;
    public static final boolean C = true;
    public static final String D = null;
    public static final v1.d E = v1.c.IDENTITY;
    public static final y F = x.DOUBLE;
    public static final y G = x.LAZILY_PARSED_NUMBER;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f16467v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f16468w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f16469x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f16470y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final boolean f16471z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a0> f16472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1.d f16473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v1.d f16474c;
    private final x1.c constructorConstructor;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Type, g<?>> f16475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f16477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f16478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f16479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f16480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f16481j;
    private final y1.e jsonAdapterFactory;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f16482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f16483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f16484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f16485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f16486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final v f16487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<a0> f16488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<a0> f16489r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final y f16490s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final y f16491t;
    private final ThreadLocal<Map<c2.a<?>, z<?>>> threadLocalAdapterResults;
    private final ConcurrentMap<c2.a<?>, z<?>> typeTokenCache;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<w> f16492u;

    public class a extends z<Number> {
        public a() {
        }

        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return Double.valueOf(aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
                return;
            }
            double dDoubleValue = number.doubleValue();
            e.a(dDoubleValue);
            dVar.value(dDoubleValue);
        }
    }

    public class b extends z<Number> {
        public b() {
        }

        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return Float.valueOf((float) aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
                return;
            }
            float fFloatValue = number.floatValue();
            e.a(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            dVar.value(number);
        }
    }

    public class c extends z<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v1.z
        public Number read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return Long.valueOf(aVar.nextLong());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
            } else {
                dVar.value(number.toString());
            }
        }
    }

    public class d extends z<AtomicLong> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f16495a;

        public d(z zVar) {
            this.f16495a = zVar;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicLong read(d2.a aVar) throws IOException {
            return new AtomicLong(((Number) this.f16495a.read(aVar)).longValue());
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, AtomicLong atomicLong) throws IOException {
            this.f16495a.write(dVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: renamed from: v1.e$e, reason: collision with other inner class name */
    public class C0444e extends z<AtomicLongArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f16496a;

        public C0444e(z zVar) {
            this.f16496a = zVar;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray read(d2.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.beginArray();
            while (aVar.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f16496a.read(aVar)).longValue()));
            }
            aVar.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, AtomicLongArray atomicLongArray) throws IOException {
            dVar.beginArray();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f16496a.write(dVar, Long.valueOf(atomicLongArray.get(i10)));
            }
            dVar.endArray();
        }
    }

    public static class f<T> extends y1.l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z<T> f16497a = null;

        private z<T> delegate() {
            z<T> zVar = this.f16497a;
            if (zVar != null) {
                return zVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public void a(z<T> zVar) {
            if (this.f16497a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f16497a = zVar;
        }

        @Override // y1.l
        public z<T> getSerializationDelegate() {
            return delegate();
        }

        @Override // v1.z
        public T read(d2.a aVar) throws IOException {
            return delegate().read(aVar);
        }

        @Override // v1.z
        public void write(d2.d dVar, T t10) throws IOException {
            delegate().write(dVar, t10);
        }
    }

    public e() {
        this(x1.d.DEFAULT, E, Collections.emptyMap(), false, false, false, true, false, false, false, true, v.DEFAULT, D, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), F, G, Collections.emptyList());
    }

    public static void a(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void assertFullConsumption(Object obj, d2.a aVar) {
        if (obj != null) {
            try {
                if (aVar.peek() == d2.c.END_DOCUMENT) {
                } else {
                    throw new u("JSON document was not fully consumed.");
                }
            } catch (d2.e e10) {
                throw new u(e10);
            } catch (IOException e11) {
                throw new l(e11);
            }
        }
    }

    private static z<AtomicLong> atomicLongAdapter(z<Number> zVar) {
        return new d(zVar).nullSafe();
    }

    private static z<AtomicLongArray> atomicLongArrayAdapter(z<Number> zVar) {
        return new C0444e(zVar).nullSafe();
    }

    private z<Number> doubleAdapter(boolean z10) {
        return z10 ? y1.o.DOUBLE : new a();
    }

    private z<Number> floatAdapter(boolean z10) {
        return z10 ? y1.o.FLOAT : new b();
    }

    private static z<Number> longAdapter(v vVar) {
        return vVar == v.DEFAULT ? y1.o.LONG : new c();
    }

    @Deprecated
    public x1.d excluder() {
        return this.f16473b;
    }

    public v1.d fieldNamingStrategy() {
        return this.f16474c;
    }

    public <T> T fromJson(String str, Class<T> cls) throws u {
        return (T) x1.m.wrap(cls).cast(fromJson(str, c2.a.get((Class) cls)));
    }

    public <T> z<T> getAdapter(c2.a<T> aVar) {
        boolean z10;
        Objects.requireNonNull(aVar, "type must not be null");
        z<T> zVar = (z) this.typeTokenCache.get(aVar);
        if (zVar != null) {
            return zVar;
        }
        Map<? extends c2.a<?>, ? extends z<?>> map = this.threadLocalAdapterResults.get();
        if (map == null) {
            map = new HashMap<>();
            this.threadLocalAdapterResults.set((Map<c2.a<?>, z<?>>) map);
            z10 = true;
        } else {
            z<T> zVar2 = (z) map.get(aVar);
            if (zVar2 != null) {
                return zVar2;
            }
            z10 = false;
        }
        try {
            f fVar = new f();
            map.put(aVar, fVar);
            Iterator<a0> it = this.f16472a.iterator();
            z<T> zVarCreate = null;
            while (it.hasNext()) {
                zVarCreate = it.next().create(this, aVar);
                if (zVarCreate != null) {
                    fVar.a(zVarCreate);
                    map.put(aVar, zVarCreate);
                    break;
                }
            }
            if (z10) {
                this.threadLocalAdapterResults.remove();
            }
            if (zVarCreate != null) {
                if (z10) {
                    this.typeTokenCache.putAll(map);
                }
                return zVarCreate;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } catch (Throwable th2) {
            if (z10) {
                this.threadLocalAdapterResults.remove();
            }
            throw th2;
        }
    }

    public <T> z<T> getDelegateAdapter(a0 a0Var, c2.a<T> aVar) {
        if (!this.f16472a.contains(a0Var)) {
            a0Var = this.jsonAdapterFactory;
        }
        boolean z10 = false;
        for (a0 a0Var2 : this.f16472a) {
            if (z10) {
                z<T> zVarCreate = a0Var2.create(this, aVar);
                if (zVarCreate != null) {
                    return zVarCreate;
                }
            } else if (a0Var2 == a0Var) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public boolean htmlSafe() {
        return this.f16479h;
    }

    public v1.f newBuilder() {
        return new v1.f(this);
    }

    public d2.a newJsonReader(Reader reader) {
        d2.a aVar = new d2.a(reader);
        aVar.setLenient(this.f16481j);
        return aVar;
    }

    public d2.d newJsonWriter(Writer writer) throws IOException {
        if (this.f16478g) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        d2.d dVar = new d2.d(writer);
        if (this.f16480i) {
            dVar.setIndent("  ");
        }
        dVar.setHtmlSafe(this.f16479h);
        dVar.setLenient(this.f16481j);
        dVar.setSerializeNulls(this.f16476e);
        return dVar;
    }

    public boolean serializeNulls() {
        return this.f16476e;
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((k) m.INSTANCE) : toJson(obj, obj.getClass());
    }

    public k toJsonTree(Object obj) {
        return obj == null ? m.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.f16476e + ",factories:" + this.f16472a + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public <T> T fromJson(String str, Type type) throws u {
        return (T) fromJson(str, c2.a.get(type));
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public k toJsonTree(Object obj, Type type) {
        y1.g gVar = new y1.g();
        toJson(obj, type, gVar);
        return gVar.get();
    }

    public <T> T fromJson(String str, c2.a<T> aVar) throws u {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), aVar);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws u, l {
        return (T) x1.m.wrap(cls).cast(fromJson(reader, c2.a.get((Class) cls)));
    }

    public void toJson(Object obj, Appendable appendable) throws l {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((k) m.INSTANCE, appendable);
        }
    }

    public e(x1.d dVar, v1.d dVar2, Map<Type, g<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, v vVar, String str, int i10, int i11, List<a0> list, List<a0> list2, List<a0> list3, y yVar, y yVar2, List<w> list4) {
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.f16473b = dVar;
        this.f16474c = dVar2;
        this.f16475d = map;
        x1.c cVar = new x1.c(map, z17, list4);
        this.constructorConstructor = cVar;
        this.f16476e = z10;
        this.f16477f = z11;
        this.f16478g = z12;
        this.f16479h = z13;
        this.f16480i = z14;
        this.f16481j = z15;
        this.f16482k = z16;
        this.f16483l = z17;
        this.f16487p = vVar;
        this.f16484m = str;
        this.f16485n = i10;
        this.f16486o = i11;
        this.f16488q = list;
        this.f16489r = list2;
        this.f16490s = yVar;
        this.f16491t = yVar2;
        this.f16492u = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(y1.o.JSON_ELEMENT_FACTORY);
        arrayList.add(y1.j.getFactory(yVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(y1.o.STRING_FACTORY);
        arrayList.add(y1.o.INTEGER_FACTORY);
        arrayList.add(y1.o.BOOLEAN_FACTORY);
        arrayList.add(y1.o.BYTE_FACTORY);
        arrayList.add(y1.o.SHORT_FACTORY);
        z<Number> zVarLongAdapter = longAdapter(vVar);
        arrayList.add(y1.o.newFactory(Long.TYPE, Long.class, zVarLongAdapter));
        arrayList.add(y1.o.newFactory(Double.TYPE, Double.class, doubleAdapter(z16)));
        arrayList.add(y1.o.newFactory(Float.TYPE, Float.class, floatAdapter(z16)));
        arrayList.add(y1.i.getFactory(yVar2));
        arrayList.add(y1.o.ATOMIC_INTEGER_FACTORY);
        arrayList.add(y1.o.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(y1.o.newFactory(AtomicLong.class, atomicLongAdapter(zVarLongAdapter)));
        arrayList.add(y1.o.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(zVarLongAdapter)));
        arrayList.add(y1.o.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(y1.o.CHARACTER_FACTORY);
        arrayList.add(y1.o.STRING_BUILDER_FACTORY);
        arrayList.add(y1.o.STRING_BUFFER_FACTORY);
        arrayList.add(y1.o.newFactory(BigDecimal.class, y1.o.BIG_DECIMAL));
        arrayList.add(y1.o.newFactory(BigInteger.class, y1.o.BIG_INTEGER));
        arrayList.add(y1.o.newFactory(x1.h.class, y1.o.LAZILY_PARSED_NUMBER));
        arrayList.add(y1.o.URL_FACTORY);
        arrayList.add(y1.o.URI_FACTORY);
        arrayList.add(y1.o.UUID_FACTORY);
        arrayList.add(y1.o.CURRENCY_FACTORY);
        arrayList.add(y1.o.LOCALE_FACTORY);
        arrayList.add(y1.o.INET_ADDRESS_FACTORY);
        arrayList.add(y1.o.BIT_SET_FACTORY);
        arrayList.add(y1.c.FACTORY);
        arrayList.add(y1.o.CALENDAR_FACTORY);
        if (b2.d.SUPPORTS_SQL_TYPES) {
            arrayList.add(b2.d.TIME_FACTORY);
            arrayList.add(b2.d.DATE_FACTORY);
            arrayList.add(b2.d.TIMESTAMP_FACTORY);
        }
        arrayList.add(y1.a.FACTORY);
        arrayList.add(y1.o.CLASS_FACTORY);
        arrayList.add(new y1.b(cVar));
        arrayList.add(new y1.h(cVar, z11));
        y1.e eVar = new y1.e(cVar);
        this.jsonAdapterFactory = eVar;
        arrayList.add(eVar);
        arrayList.add(y1.o.ENUM_FACTORY);
        arrayList.add(new y1.k(cVar, dVar2, dVar, eVar, list4));
        this.f16472a = Collections.unmodifiableList(arrayList);
    }

    public <T> T fromJson(Reader reader, Type type) throws u, l {
        return (T) fromJson(reader, c2.a.get(type));
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws l {
        try {
            toJson(obj, type, newJsonWriter(x1.o.writerForAppendable(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public <T> T fromJson(Reader reader, c2.a<T> aVar) throws u, l {
        d2.a aVarNewJsonReader = newJsonReader(reader);
        T t10 = (T) fromJson(aVarNewJsonReader, aVar);
        assertFullConsumption(t10, aVarNewJsonReader);
        return t10;
    }

    public void toJson(Object obj, Type type, d2.d dVar) throws l {
        z adapter = getAdapter(c2.a.get(type));
        boolean zIsLenient = dVar.isLenient();
        dVar.setLenient(true);
        boolean zIsHtmlSafe = dVar.isHtmlSafe();
        dVar.setHtmlSafe(this.f16479h);
        boolean serializeNulls = dVar.getSerializeNulls();
        dVar.setSerializeNulls(this.f16476e);
        try {
            try {
                adapter.write(dVar, obj);
                dVar.setLenient(zIsLenient);
                dVar.setHtmlSafe(zIsHtmlSafe);
                dVar.setSerializeNulls(serializeNulls);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } catch (Throwable th2) {
            dVar.setLenient(zIsLenient);
            dVar.setHtmlSafe(zIsHtmlSafe);
            dVar.setSerializeNulls(serializeNulls);
            throw th2;
        }
    }

    public <T> T fromJson(d2.a aVar, Type type) throws u, l {
        return (T) fromJson(aVar, c2.a.get(type));
    }

    public <T> T fromJson(d2.a aVar, c2.a<T> aVar2) throws u, l {
        boolean zIsLenient = aVar.isLenient();
        boolean z10 = true;
        aVar.setLenient(true);
        try {
            try {
                try {
                    aVar.peek();
                    z10 = false;
                    T t10 = getAdapter(aVar2).read(aVar);
                    aVar.setLenient(zIsLenient);
                    return t10;
                } catch (EOFException e10) {
                    if (z10) {
                        aVar.setLenient(zIsLenient);
                        return null;
                    }
                    throw new u(e10);
                } catch (IllegalStateException e11) {
                    throw new u(e11);
                }
            } catch (IOException e12) {
                throw new u(e12);
            } catch (AssertionError e13) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e13.getMessage(), e13);
            }
        } catch (Throwable th2) {
            aVar.setLenient(zIsLenient);
            throw th2;
        }
    }

    public <T> z<T> getAdapter(Class<T> cls) {
        return getAdapter(c2.a.get((Class) cls));
    }

    public <T> T fromJson(k kVar, Class<T> cls) throws u {
        return (T) x1.m.wrap(cls).cast(fromJson(kVar, c2.a.get((Class) cls)));
    }

    public String toJson(k kVar) {
        StringWriter stringWriter = new StringWriter();
        toJson(kVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public <T> T fromJson(k kVar, Type type) throws u {
        return (T) fromJson(kVar, c2.a.get(type));
    }

    public <T> T fromJson(k kVar, c2.a<T> aVar) throws u {
        if (kVar == null) {
            return null;
        }
        return (T) fromJson(new y1.f(kVar), aVar);
    }

    public void toJson(k kVar, Appendable appendable) throws l {
        try {
            toJson(kVar, newJsonWriter(x1.o.writerForAppendable(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public void toJson(k kVar, d2.d dVar) throws l {
        boolean zIsLenient = dVar.isLenient();
        dVar.setLenient(true);
        boolean zIsHtmlSafe = dVar.isHtmlSafe();
        dVar.setHtmlSafe(this.f16479h);
        boolean serializeNulls = dVar.getSerializeNulls();
        dVar.setSerializeNulls(this.f16476e);
        try {
            try {
                x1.o.write(kVar, dVar);
                dVar.setLenient(zIsLenient);
                dVar.setHtmlSafe(zIsHtmlSafe);
                dVar.setSerializeNulls(serializeNulls);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } catch (Throwable th2) {
            dVar.setLenient(zIsLenient);
            dVar.setHtmlSafe(zIsHtmlSafe);
            dVar.setSerializeNulls(serializeNulls);
            throw th2;
        }
    }
}
