package v4;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import y4.n1;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private x4.d excluder;
    private final List<q0> factories;
    private k fieldNamingPolicy;
    private l formattingStyle;
    private boolean generateNonExecutableJson;
    private final List<q0> hierarchyFactories;
    private final Map<Type, s> instanceCreators;
    private d0 longSerializationPolicy;
    private n0 numberToNumberStrategy;
    private n0 objectToNumberStrategy;
    private final ArrayDeque<g0> reflectionFilters;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private h0 strictness;
    private int timeStyle;
    private boolean useJdkUnsafe;

    public r() {
        this.excluder = x4.d.DEFAULT;
        this.longSerializationPolicy = d0.DEFAULT;
        this.fieldNamingPolicy = j.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        l lVar = q.f10477v;
        this.datePattern = null;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.formattingStyle = q.f10477v;
        this.generateNonExecutableJson = false;
        this.strictness = null;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = q.f10479x;
        this.numberToNumberStrategy = q.f10480y;
        this.reflectionFilters = new ArrayDeque<>();
    }

    private static void addTypeAdaptersForDate(String str, int i8, int i9, List<q0> list) {
        q0 q0VarCreateAdapterFactory;
        q0 q0VarCreateAdapterFactory2;
        boolean z2 = b5.h.SUPPORTS_SQL_TYPES;
        q0 q0VarCreateAdapterFactory3 = null;
        if (str != null && !str.trim().isEmpty()) {
            q0VarCreateAdapterFactory = y4.g.DATE.createAdapterFactory(str);
            if (z2) {
                q0VarCreateAdapterFactory3 = b5.h.TIMESTAMP_DATE_TYPE.createAdapterFactory(str);
                q0VarCreateAdapterFactory2 = b5.h.DATE_DATE_TYPE.createAdapterFactory(str);
            } else {
                q0VarCreateAdapterFactory2 = null;
            }
        } else {
            if (i8 == 2 && i9 == 2) {
                return;
            }
            q0 q0VarCreateAdapterFactory4 = y4.g.DATE.createAdapterFactory(i8, i9);
            if (z2) {
                q0VarCreateAdapterFactory3 = b5.h.TIMESTAMP_DATE_TYPE.createAdapterFactory(i8, i9);
                q0 q0VarCreateAdapterFactory5 = b5.h.DATE_DATE_TYPE.createAdapterFactory(i8, i9);
                q0VarCreateAdapterFactory = q0VarCreateAdapterFactory4;
                q0VarCreateAdapterFactory2 = q0VarCreateAdapterFactory5;
            } else {
                q0VarCreateAdapterFactory = q0VarCreateAdapterFactory4;
                q0VarCreateAdapterFactory2 = null;
            }
        }
        list.add(q0VarCreateAdapterFactory);
        if (z2) {
            list.add(q0VarCreateAdapterFactory3);
            list.add(q0VarCreateAdapterFactory2);
        }
    }

    private static int checkDateFormatStyle(int i8) {
        if (i8 < 0 || i8 > 3) {
            throw new IllegalArgumentException(a1.a.o(i8, "Invalid style: "));
        }
        return i8;
    }

    private static boolean hasNonOverridableAdapter(Type type) {
        return type == Object.class;
    }

    public r addDeserializationExclusionStrategy(a aVar) {
        Objects.requireNonNull(aVar);
        this.excluder = this.excluder.withExclusionStrategy(aVar, false, true);
        return this;
    }

    public r addReflectionAccessFilter(g0 g0Var) {
        Objects.requireNonNull(g0Var);
        this.reflectionFilters.addFirst(g0Var);
        return this;
    }

    public r addSerializationExclusionStrategy(a aVar) {
        Objects.requireNonNull(aVar);
        this.excluder = this.excluder.withExclusionStrategy(aVar, true, false);
        return this;
    }

    public q create() {
        ArrayList arrayList = new ArrayList(this.hierarchyFactories.size() + this.factories.size() + 3);
        arrayList.addAll(this.factories);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
        return new q(this.excluder, this.fieldNamingPolicy, new HashMap(this.instanceCreators), this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.formattingStyle, this.strictness, this.serializeSpecialFloatingPointValues, this.useJdkUnsafe, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, new ArrayList(this.factories), new ArrayList(this.hierarchyFactories), arrayList, this.objectToNumberStrategy, this.numberToNumberStrategy, new ArrayList(this.reflectionFilters));
    }

    public r disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public r disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public r disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    public r enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public r excludeFieldsWithModifiers(int... iArr) {
        Objects.requireNonNull(iArr);
        this.excluder = this.excluder.withModifiers(iArr);
        return this;
    }

    public r excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public r generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public r registerTypeAdapter(Type type, Object obj) {
        Objects.requireNonNull(type);
        x4.e.checkArgument(obj instanceof p0);
        if (hasNonOverridableAdapter(type)) {
            throw new IllegalArgumentException("Cannot override built-in adapter for " + type);
        }
        if (obj instanceof p0) {
            this.factories.add(n1.newFactory(c5.a.get(type), (p0) obj));
        }
        return this;
    }

    public r registerTypeAdapterFactory(q0 q0Var) {
        Objects.requireNonNull(q0Var);
        this.factories.add(q0Var);
        return this;
    }

    public r registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        Objects.requireNonNull(cls);
        x4.e.checkArgument(obj instanceof p0);
        if (obj instanceof p0) {
            this.factories.add(n1.newTypeHierarchyFactory(cls, (p0) obj));
        }
        return this;
    }

    public r serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public r serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public r setDateFormat(String str) {
        if (str != null) {
            try {
                new SimpleDateFormat(str);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(h0.a.j("The date pattern '", str, "' is not valid"), e);
            }
        }
        this.datePattern = str;
        return this;
    }

    public r setExclusionStrategies(a... aVarArr) {
        Objects.requireNonNull(aVarArr);
        for (a aVar : aVarArr) {
            this.excluder = this.excluder.withExclusionStrategy(null, true, true);
        }
        return this;
    }

    public r setFieldNamingPolicy(j jVar) {
        return setFieldNamingStrategy(jVar);
    }

    public r setFieldNamingStrategy(k kVar) {
        Objects.requireNonNull(kVar);
        this.fieldNamingPolicy = kVar;
        return this;
    }

    public r setFormattingStyle(l lVar) {
        Objects.requireNonNull(lVar);
        this.formattingStyle = lVar;
        return this;
    }

    @Deprecated
    public r setLenient() {
        return setStrictness(h0.LENIENT);
    }

    public r setLongSerializationPolicy(d0 d0Var) {
        Objects.requireNonNull(d0Var);
        this.longSerializationPolicy = d0Var;
        return this;
    }

    public r setNumberToNumberStrategy(n0 n0Var) {
        Objects.requireNonNull(n0Var);
        this.numberToNumberStrategy = n0Var;
        return this;
    }

    public r setObjectToNumberStrategy(n0 n0Var) {
        Objects.requireNonNull(n0Var);
        this.objectToNumberStrategy = n0Var;
        return this;
    }

    public r setPrettyPrinting() {
        return setFormattingStyle(l.PRETTY);
    }

    public r setStrictness(h0 h0Var) {
        Objects.requireNonNull(h0Var);
        this.strictness = h0Var;
        return this;
    }

    public r setVersion(double d7) {
        if (!Double.isNaN(d7) && d7 >= 0.0d) {
            this.excluder = this.excluder.withVersion(d7);
            return this;
        }
        throw new IllegalArgumentException("Invalid version: " + d7);
    }

    @Deprecated
    public r setDateFormat(int i8) {
        this.dateStyle = checkDateFormatStyle(i8);
        this.datePattern = null;
        return this;
    }

    public r setDateFormat(int i8, int i9) {
        this.dateStyle = checkDateFormatStyle(i8);
        this.timeStyle = checkDateFormatStyle(i9);
        this.datePattern = null;
        return this;
    }

    public r(q qVar) {
        this.excluder = x4.d.DEFAULT;
        this.longSerializationPolicy = d0.DEFAULT;
        this.fieldNamingPolicy = j.IDENTITY;
        HashMap map = new HashMap();
        this.instanceCreators = map;
        ArrayList arrayList = new ArrayList();
        this.factories = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.hierarchyFactories = arrayList2;
        this.serializeNulls = false;
        l lVar = q.f10477v;
        this.datePattern = null;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.formattingStyle = q.f10477v;
        this.generateNonExecutableJson = false;
        this.strictness = null;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = q.f10479x;
        this.numberToNumberStrategy = q.f10480y;
        ArrayDeque<g0> arrayDeque = new ArrayDeque<>();
        this.reflectionFilters = arrayDeque;
        this.excluder = qVar.f10482b;
        this.fieldNamingPolicy = qVar.f10483c;
        map.putAll(qVar.f10484d);
        this.serializeNulls = qVar.e;
        this.complexMapKeySerialization = qVar.f;
        this.generateNonExecutableJson = qVar.f10485g;
        this.escapeHtmlChars = qVar.f10486h;
        this.formattingStyle = qVar.f10487i;
        this.strictness = qVar.f10488j;
        this.serializeSpecialFloatingPointValues = qVar.f10489k;
        this.longSerializationPolicy = qVar.p;
        this.datePattern = qVar.f10491m;
        this.dateStyle = qVar.f10492n;
        this.timeStyle = qVar.f10493o;
        arrayList.addAll(qVar.q);
        arrayList2.addAll(qVar.f10494r);
        this.useJdkUnsafe = qVar.f10490l;
        this.objectToNumberStrategy = qVar.f10495s;
        this.numberToNumberStrategy = qVar.f10496t;
        arrayDeque.addAll(qVar.u);
    }
}
