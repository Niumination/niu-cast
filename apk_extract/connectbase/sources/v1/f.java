package v1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private x1.d excluder;
    private final List<a0> factories;
    private d fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final List<a0> hierarchyFactories;
    private final Map<Type, g<?>> instanceCreators;
    private boolean lenient;
    private v longSerializationPolicy;
    private y numberToNumberStrategy;
    private y objectToNumberStrategy;
    private boolean prettyPrinting;
    private final LinkedList<w> reflectionFilters;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;
    private boolean useJdkUnsafe;

    public f() {
        this.excluder = x1.d.DEFAULT;
        this.longSerializationPolicy = v.DEFAULT;
        this.fieldNamingPolicy = c.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.datePattern = e.D;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = e.F;
        this.numberToNumberStrategy = e.G;
        this.reflectionFilters = new LinkedList<>();
    }

    private void addTypeAdaptersForDate(String str, int i10, int i11, List<a0> list) {
        a0 a0VarCreateAdapterFactory;
        a0 a0VarCreateAdapterFactory2;
        boolean z10 = b2.d.SUPPORTS_SQL_TYPES;
        a0 a0VarCreateAdapterFactory3 = null;
        if (str != null && !str.trim().isEmpty()) {
            a0VarCreateAdapterFactory = y1.d.b.DATE.createAdapterFactory(str);
            if (z10) {
                a0VarCreateAdapterFactory3 = b2.d.TIMESTAMP_DATE_TYPE.createAdapterFactory(str);
                a0VarCreateAdapterFactory2 = b2.d.DATE_DATE_TYPE.createAdapterFactory(str);
            } else {
                a0VarCreateAdapterFactory2 = null;
            }
        } else {
            if (i10 == 2 || i11 == 2) {
                return;
            }
            a0 a0VarCreateAdapterFactory4 = y1.d.b.DATE.createAdapterFactory(i10, i11);
            if (z10) {
                a0VarCreateAdapterFactory3 = b2.d.TIMESTAMP_DATE_TYPE.createAdapterFactory(i10, i11);
                a0 a0VarCreateAdapterFactory5 = b2.d.DATE_DATE_TYPE.createAdapterFactory(i10, i11);
                a0VarCreateAdapterFactory = a0VarCreateAdapterFactory4;
                a0VarCreateAdapterFactory2 = a0VarCreateAdapterFactory5;
            } else {
                a0VarCreateAdapterFactory = a0VarCreateAdapterFactory4;
                a0VarCreateAdapterFactory2 = null;
            }
        }
        list.add(a0VarCreateAdapterFactory);
        if (z10) {
            list.add(a0VarCreateAdapterFactory3);
            list.add(a0VarCreateAdapterFactory2);
        }
    }

    public f addDeserializationExclusionStrategy(a aVar) {
        Objects.requireNonNull(aVar);
        this.excluder = this.excluder.withExclusionStrategy(aVar, false, true);
        return this;
    }

    public f addReflectionAccessFilter(w wVar) {
        Objects.requireNonNull(wVar);
        this.reflectionFilters.addFirst(wVar);
        return this;
    }

    public f addSerializationExclusionStrategy(a aVar) {
        Objects.requireNonNull(aVar);
        this.excluder = this.excluder.withExclusionStrategy(aVar, true, false);
        return this;
    }

    public e create() {
        ArrayList arrayList = new ArrayList(this.hierarchyFactories.size() + this.factories.size() + 3);
        arrayList.addAll(this.factories);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
        return new e(this.excluder, this.fieldNamingPolicy, new HashMap(this.instanceCreators), this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.useJdkUnsafe, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, new ArrayList(this.factories), new ArrayList(this.hierarchyFactories), arrayList, this.objectToNumberStrategy, this.numberToNumberStrategy, new ArrayList(this.reflectionFilters));
    }

    public f disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public f disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public f disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    public f enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public f excludeFieldsWithModifiers(int... iArr) {
        Objects.requireNonNull(iArr);
        this.excluder = this.excluder.withModifiers(iArr);
        return this;
    }

    public f excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public f generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public f registerTypeAdapter(Type type, Object obj) {
        Objects.requireNonNull(type);
        boolean z10 = obj instanceof s;
        x1.a.checkArgument(z10 || (obj instanceof j) || (obj instanceof g) || (obj instanceof z));
        if (obj instanceof g) {
            this.instanceCreators.put(type, (g) obj);
        }
        if (z10 || (obj instanceof j)) {
            this.factories.add(y1.m.newFactoryWithMatchRawType(c2.a.get(type), obj));
        }
        if (obj instanceof z) {
            this.factories.add(y1.o.newFactory(c2.a.get(type), (z) obj));
        }
        return this;
    }

    public f registerTypeAdapterFactory(a0 a0Var) {
        Objects.requireNonNull(a0Var);
        this.factories.add(a0Var);
        return this;
    }

    public f registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        Objects.requireNonNull(cls);
        boolean z10 = obj instanceof s;
        x1.a.checkArgument(z10 || (obj instanceof j) || (obj instanceof z));
        if ((obj instanceof j) || z10) {
            this.hierarchyFactories.add(y1.m.newTypeHierarchyFactory(cls, obj));
        }
        if (obj instanceof z) {
            this.factories.add(y1.o.newTypeHierarchyFactory(cls, (z) obj));
        }
        return this;
    }

    public f serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public f serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public f setDateFormat(String str) {
        this.datePattern = str;
        return this;
    }

    public f setExclusionStrategies(a... aVarArr) {
        Objects.requireNonNull(aVarArr);
        for (a aVar : aVarArr) {
            this.excluder = this.excluder.withExclusionStrategy(aVar, true, true);
        }
        return this;
    }

    public f setFieldNamingPolicy(c cVar) {
        return setFieldNamingStrategy(cVar);
    }

    public f setFieldNamingStrategy(d dVar) {
        Objects.requireNonNull(dVar);
        this.fieldNamingPolicy = dVar;
        return this;
    }

    public f setLenient() {
        this.lenient = true;
        return this;
    }

    public f setLongSerializationPolicy(v vVar) {
        Objects.requireNonNull(vVar);
        this.longSerializationPolicy = vVar;
        return this;
    }

    public f setNumberToNumberStrategy(y yVar) {
        Objects.requireNonNull(yVar);
        this.numberToNumberStrategy = yVar;
        return this;
    }

    public f setObjectToNumberStrategy(y yVar) {
        Objects.requireNonNull(yVar);
        this.objectToNumberStrategy = yVar;
        return this;
    }

    public f setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public f setVersion(double d10) {
        if (!Double.isNaN(d10) && d10 >= 0.0d) {
            this.excluder = this.excluder.withVersion(d10);
            return this;
        }
        throw new IllegalArgumentException("Invalid version: " + d10);
    }

    public f setDateFormat(int i10) {
        this.dateStyle = i10;
        this.datePattern = null;
        return this;
    }

    public f setDateFormat(int i10, int i11) {
        this.dateStyle = i10;
        this.timeStyle = i11;
        this.datePattern = null;
        return this;
    }

    public f(e eVar) {
        this.excluder = x1.d.DEFAULT;
        this.longSerializationPolicy = v.DEFAULT;
        this.fieldNamingPolicy = c.IDENTITY;
        HashMap map = new HashMap();
        this.instanceCreators = map;
        ArrayList arrayList = new ArrayList();
        this.factories = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.hierarchyFactories = arrayList2;
        this.serializeNulls = false;
        this.datePattern = e.D;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = e.F;
        this.numberToNumberStrategy = e.G;
        LinkedList<w> linkedList = new LinkedList<>();
        this.reflectionFilters = linkedList;
        this.excluder = eVar.f16473b;
        this.fieldNamingPolicy = eVar.f16474c;
        map.putAll(eVar.f16475d);
        this.serializeNulls = eVar.f16476e;
        this.complexMapKeySerialization = eVar.f16477f;
        this.generateNonExecutableJson = eVar.f16478g;
        this.escapeHtmlChars = eVar.f16479h;
        this.prettyPrinting = eVar.f16480i;
        this.lenient = eVar.f16481j;
        this.serializeSpecialFloatingPointValues = eVar.f16482k;
        this.longSerializationPolicy = eVar.f16487p;
        this.datePattern = eVar.f16484m;
        this.dateStyle = eVar.f16485n;
        this.timeStyle = eVar.f16486o;
        arrayList.addAll(eVar.f16488q);
        arrayList2.addAll(eVar.f16489r);
        this.useJdkUnsafe = eVar.f16483l;
        this.objectToNumberStrategy = eVar.f16490s;
        this.numberToNumberStrategy = eVar.f16491t;
        linkedList.addAll(eVar.f16492u);
    }
}
