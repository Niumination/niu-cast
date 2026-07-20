package y1;

import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v1.a0;
import v1.u;
import v1.w;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class k implements a0 {
    private final x1.c constructorConstructor;
    private final x1.d excluder;
    private final v1.d fieldNamingPolicy;
    private final y1.e jsonAdapterFactory;
    private final List<w> reflectionFilters;

    public class a extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f20629f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Method f20630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f20631h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ z f20632i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ v1.e f20633j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ c2.a f20634k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f20635l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f20636m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, z zVar, v1.e eVar, c2.a aVar, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f20629f = z12;
            this.f20630g = method;
            this.f20631h = z13;
            this.f20632i = zVar;
            this.f20633j = eVar;
            this.f20634k = aVar;
            this.f20635l = z14;
            this.f20636m = z15;
        }

        @Override // y1.k.c
        public void a(d2.a aVar, int i10, Object[] objArr) throws IOException, v1.o {
            Object obj = this.f20632i.read(aVar);
            if (obj != null || !this.f20635l) {
                objArr[i10] = obj;
                return;
            }
            throw new v1.o("null is not allowed as value for record component '" + this.f20641c + "' of primitive type; at path " + aVar.getPath());
        }

        @Override // y1.k.c
        public void b(d2.a aVar, Object obj) throws IllegalAccessException, IOException {
            Object obj2 = this.f20632i.read(aVar);
            if (obj2 == null && this.f20635l) {
                return;
            }
            if (this.f20629f) {
                k.checkAccessible(obj, this.f20640b);
            } else if (this.f20636m) {
                throw new v1.l(m.a.a("Cannot set value of 'static final' ", a2.a.getAccessibleObjectDescription(this.f20640b, false)));
            }
            this.f20640b.set(obj, obj2);
        }

        @Override // y1.k.c
        public void c(d2.d dVar, Object obj) throws IllegalAccessException, IOException {
            Object objInvoke;
            if (this.f20642d) {
                if (this.f20629f) {
                    Method method = this.f20630g;
                    if (method == null) {
                        k.checkAccessible(obj, this.f20640b);
                    } else {
                        k.checkAccessible(obj, method);
                    }
                }
                Method method2 = this.f20630g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, null);
                    } catch (InvocationTargetException e10) {
                        throw new v1.l(n.a.a("Accessor ", a2.a.getAccessibleObjectDescription(this.f20630g, false), " threw exception"), e10.getCause());
                    }
                } else {
                    objInvoke = this.f20640b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                dVar.name(this.f20639a);
                (this.f20631h ? this.f20632i : new n(this.f20633j, this.f20632i, this.f20634k.getType())).write(dVar, objInvoke);
            }
        }
    }

    public static abstract class b<T, A> extends z<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, c> f20638a;

        public b(Map<String, c> map) {
            this.f20638a = map;
        }

        public abstract A a();

        public abstract T b(A a10);

        public abstract void c(A a10, d2.a aVar, c cVar) throws IllegalAccessException, IOException;

        @Override // v1.z
        public T read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            A a10 = a();
            try {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    c cVar = this.f20638a.get(aVar.nextName());
                    if (cVar == null || !cVar.f20643e) {
                        aVar.skipValue();
                    } else {
                        c(a10, aVar, cVar);
                    }
                }
                aVar.endObject();
                return b(a10);
            } catch (IllegalAccessException e10) {
                throw a2.a.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (IllegalStateException e11) {
                throw new u(e11);
            }
        }

        @Override // v1.z
        public void write(d2.d dVar, T t10) throws IOException {
            if (t10 == null) {
                dVar.nullValue();
                return;
            }
            dVar.beginObject();
            try {
                Iterator<c> it = this.f20638a.values().iterator();
                while (it.hasNext()) {
                    it.next().c(dVar, t10);
                }
                dVar.endObject();
            } catch (IllegalAccessException e10) {
                throw a2.a.createExceptionForUnexpectedIllegalAccess(e10);
            }
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f20640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f20641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f20642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f20643e;

        public c(String str, Field field, boolean z10, boolean z11) {
            this.f20639a = str;
            this.f20640b = field;
            this.f20641c = field.getName();
            this.f20642d = z10;
            this.f20643e = z11;
        }

        public abstract void a(d2.a aVar, int i10, Object[] objArr) throws IOException, v1.o;

        public abstract void b(d2.a aVar, Object obj) throws IllegalAccessException, IOException;

        public abstract void c(d2.d dVar, Object obj) throws IllegalAccessException, IOException;
    }

    public static final class d<T> extends b<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x1.k<T> f20644b;

        public d(x1.k<T> kVar, Map<String, c> map) {
            super(map);
            this.f20644b = kVar;
        }

        @Override // y1.k.b
        public T a() {
            return this.f20644b.construct();
        }

        @Override // y1.k.b
        public T b(T t10) {
            return t10;
        }

        @Override // y1.k.b
        public void c(T t10, d2.a aVar, c cVar) throws IllegalAccessException, IOException {
            cVar.b(aVar, t10);
        }
    }

    public static final class e<T> extends b<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Map<Class<?>, Object> f20645e = f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor<T> f20646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[] f20647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f20648d;

        public e(Class<T> cls, Map<String, c> map, boolean z10) {
            super(map);
            this.f20648d = new HashMap();
            Constructor<T> canonicalRecordConstructor = a2.a.getCanonicalRecordConstructor(cls);
            this.f20646b = canonicalRecordConstructor;
            if (z10) {
                k.checkAccessible(null, canonicalRecordConstructor);
            } else {
                a2.a.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = a2.a.getRecordComponentNames(cls);
            for (int i10 = 0; i10 < recordComponentNames.length; i10++) {
                this.f20648d.put(recordComponentNames[i10], Integer.valueOf(i10));
            }
            Class<?>[] parameterTypes = this.f20646b.getParameterTypes();
            this.f20647c = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.f20647c[i11] = f20645e.get(parameterTypes[i11]);
            }
        }

        public static Map<Class<?>, Object> f() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        @Override // y1.k.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object[] a() {
            return (Object[]) this.f20647c.clone();
        }

        @Override // y1.k.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(Object[] objArr) {
            try {
                return this.f20646b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw a2.a.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (IllegalArgumentException | InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + a2.a.constructorToString(this.f20646b) + "' with args " + Arrays.toString(objArr), e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + a2.a.constructorToString(this.f20646b) + "' with args " + Arrays.toString(objArr), e12.getCause());
            }
        }

        @Override // y1.k.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void c(Object[] objArr, d2.a aVar, c cVar) throws IOException {
            Integer num = this.f20648d.get(cVar.f20641c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            StringBuilder sb2 = new StringBuilder("Could not find the index in the constructor '");
            sb2.append(a2.a.constructorToString(this.f20646b));
            sb2.append("' for field with name '");
            throw new IllegalStateException(j.c.a(sb2, cVar.f20641c, "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters."));
        }
    }

    public k(x1.c cVar, v1.d dVar, x1.d dVar2, y1.e eVar, List<w> list) {
        this.constructorConstructor = cVar;
        this.fieldNamingPolicy = dVar;
        this.excluder = dVar2;
        this.jsonAdapterFactory = eVar;
        this.reflectionFilters = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void checkAccessible(Object obj, M m10) {
        if (Modifier.isStatic(m10.getModifiers())) {
            obj = null;
        }
        if (!x1.n.canAccess(m10, obj)) {
            throw new v1.l(j.a.a(a2.a.getAccessibleObjectDescription(m10, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    private c createBoundField(v1.e eVar, Field field, Method method, String str, c2.a<?> aVar, boolean z10, boolean z11, boolean z12) {
        boolean zIsPrimitive = x1.m.isPrimitive(aVar.getRawType());
        int modifiers = field.getModifiers();
        boolean z13 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        w1.b bVar = (w1.b) field.getAnnotation(w1.b.class);
        z<?> zVarA = bVar != null ? this.jsonAdapterFactory.a(this.constructorConstructor, eVar, aVar, bVar) : null;
        boolean z14 = zVarA != null;
        if (zVarA == null) {
            zVarA = eVar.getAdapter(aVar);
        }
        return new a(str, field, z10, z11, z12, method, z14, zVarA, eVar, aVar, zIsPrimitive, z13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r22v0 */
    private Map<String, c> getBoundFields(v1.e eVar, c2.a<?> aVar, Class<?> cls, boolean z10, boolean z11) {
        boolean z12;
        Method method;
        int i10;
        int i11;
        boolean z13;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        c2.a<?> aVar2 = aVar;
        boolean z14 = z10;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            boolean z15 = true;
            boolean z16 = false;
            if (rawType != cls && declaredFields.length > 0) {
                w.e filterResult = x1.n.getFilterResult(this.reflectionFilters, rawType);
                if (filterResult == w.e.BLOCK_ALL) {
                    throw new v1.l("ReflectionAccessFilter does not permit using reflection for " + rawType + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z14 = filterResult == w.e.BLOCK_INACCESSIBLE;
            }
            boolean z17 = z14;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean zIncludeField = this.includeField(field, z15);
                boolean zIncludeField2 = this.includeField(field, z16);
                if (zIncludeField || zIncludeField2) {
                    c cVar = null;
                    if (!z11) {
                        z12 = zIncludeField2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z12 = z16;
                    } else {
                        Method accessor = a2.a.getAccessor(rawType, field);
                        if (!z17) {
                            a2.a.makeAccessible(accessor);
                        }
                        if (accessor.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                            throw new v1.l(n.a.a("@SerializedName on ", a2.a.getAccessibleObjectDescription(accessor, z16), " is not supported"));
                        }
                        z12 = zIncludeField2;
                        method = accessor;
                    }
                    if (!z17 && method == null) {
                        a2.a.makeAccessible(field);
                    }
                    Type typeResolve = x1.b.resolve(aVar2.getType(), rawType, field.getGenericType());
                    List<String> fieldNames = this.getFieldNames(field);
                    int size = fieldNames.size();
                    ?? r10 = z16;
                    while (r10 < size) {
                        String str = fieldNames.get(r10);
                        boolean z18 = r10 != 0 ? z16 : zIncludeField;
                        ?? r22 = r10;
                        c cVar2 = cVar;
                        int i13 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        int i14 = i12;
                        int i15 = length;
                        boolean z19 = z16;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, createBoundField(eVar, field, method, str, c2.a.get(typeResolve), z18, z12, z17)) : cVar2;
                        zIncludeField = z18;
                        i12 = i14;
                        size = i13;
                        fieldNames = list;
                        field = field2;
                        length = i15;
                        z16 = z19;
                        r10 = (r22 == true ? 1 : 0) + 1;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i10 = i12;
                    i11 = length;
                    z13 = z16;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.f20639a + "'; conflict is caused by fields " + a2.a.fieldToString(cVar3.f20640b) + " and " + a2.a.fieldToString(field3));
                    }
                } else {
                    i10 = i12;
                    i11 = length;
                    z13 = z16;
                }
                i12 = i10 + 1;
                z15 = true;
                this = this;
                length = i11;
                z16 = z13;
            }
            aVar2 = c2.a.get(x1.b.resolve(aVar2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = aVar2.getRawType();
            z14 = z17;
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String strValue = serializedName.value();
        String[] strArrAlternate = serializedName.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean includeField(Field field, boolean z10) {
        return (this.excluder.excludeClass(field.getType(), z10) || this.excluder.excludeField(field, z10)) ? false : true;
    }

    @Override // v1.a0
    public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        w.e filterResult = x1.n.getFilterResult(this.reflectionFilters, rawType);
        if (filterResult != w.e.BLOCK_ALL) {
            boolean z10 = filterResult == w.e.BLOCK_INACCESSIBLE;
            return a2.a.isRecord(rawType) ? new e(rawType, getBoundFields(eVar, aVar, rawType, z10, true), z10) : new d(this.constructorConstructor.get(aVar), getBoundFields(eVar, aVar, rawType, z10, false));
        }
        throw new v1.l("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
