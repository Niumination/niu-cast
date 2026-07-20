package y4;

import com.google.gson.annotations.SerializedName;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 implements v4.q0 {
    private final x4.b constructorConstructor;
    private final x4.d excluder;
    private final v4.k fieldNamingPolicy;
    private final l jsonAdapterFactory;
    private final List<v4.g0> reflectionFilters;

    public g0(x4.b bVar, v4.k kVar, x4.d dVar, l lVar, List<v4.g0> list) {
        this.constructorConstructor = bVar;
        this.fieldNamingPolicy = kVar;
        this.excluder = dVar;
        this.jsonAdapterFactory = lVar;
        this.reflectionFilters = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void checkAccessible(Object obj, M m7) {
        if (Modifier.isStatic(m7.getModifiers())) {
            obj = null;
        }
        if (!x4.z.canAccess(m7, obj)) {
            throw new v4.v(h0.a.B(a5.d.getAccessibleObjectDescription(m7, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    private c0 createBoundField(v4.q qVar, Field field, Method method, String str, c5.a<?> aVar, boolean z2, boolean z3) {
        v4.p0 i0Var;
        boolean zIsPrimitive = x4.v.isPrimitive(aVar.getRawType());
        int modifiers = field.getModifiers();
        boolean z5 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        w4.b bVar = (w4.b) field.getAnnotation(w4.b.class);
        v4.p0 p0VarA = bVar != null ? this.jsonAdapterFactory.a(this.constructorConstructor, qVar, aVar, bVar, false) : null;
        boolean z10 = p0VarA != null;
        if (p0VarA == null) {
            p0VarA = qVar.getAdapter(aVar);
        }
        v4.p0 p0Var = p0VarA;
        if (z2) {
            i0Var = z10 ? p0Var : new i0(qVar, p0Var, aVar.getType());
        } else {
            i0Var = p0Var;
        }
        return new a0(str, field, z3, method, i0Var, p0Var, zIsPrimitive, z5);
    }

    private static IllegalArgumentException createDuplicateFieldException(Class<?> cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + a5.d.fieldToString(field) + " and " + a5.d.fieldToString(field2) + "\nSee " + x4.d0.createUrl("duplicate-fields"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r23v0, types: [y4.g0] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v3 */
    private e0 getBoundFields(v4.q qVar, c5.a<?> aVar, Class<?> cls, boolean z2, boolean z3) {
        ?? r18;
        Method method;
        int i8;
        int i9;
        ?? r22;
        c0 c0Var;
        if (cls.isInterface()) {
            return e0.f11044c;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        c5.a<?> aVar2 = aVar;
        boolean z5 = z2;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            boolean z10 = true;
            ?? r7 = 0;
            if (rawType != cls && declaredFields.length > 0) {
                v4.f0 filterResult = x4.z.getFilterResult(this.reflectionFilters, rawType);
                if (filterResult == v4.f0.BLOCK_ALL) {
                    throw new v4.v("ReflectionAccessFilter does not permit using reflection for " + rawType + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z5 = filterResult == v4.f0.BLOCK_INACCESSIBLE;
            }
            boolean z11 = z5;
            int length = declaredFields.length;
            int i10 = 0;
            while (i10 < length) {
                Field field = declaredFields[i10];
                boolean zIncludeField = includeField(field, z10);
                boolean zIncludeField2 = includeField(field, r7);
                if (zIncludeField || zIncludeField2) {
                    Method accessor = null;
                    if (!z3) {
                        r18 = zIncludeField2;
                        method = accessor;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        r18 = r7;
                    } else {
                        accessor = a5.d.getAccessor(rawType, field);
                        if (!z11) {
                            a5.d.makeAccessible(accessor);
                        }
                        if (accessor.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                            throw new v4.v(h0.a.j("@SerializedName on ", a5.d.getAccessibleObjectDescription(accessor, r7), " is not supported"));
                        }
                        r18 = zIncludeField2;
                        method = accessor;
                    }
                    if (!z11 && method == null) {
                        a5.d.makeAccessible(field);
                    }
                    Type typeResolve = x4.i.resolve(aVar2.getType(), rawType, field.getGenericType());
                    List<String> fieldNames = getFieldNames(field);
                    String str = fieldNames.get(r7);
                    i8 = i10;
                    i9 = length;
                    r22 = r7;
                    c0 c0VarCreateBoundField = createBoundField(qVar, field, method, str, c5.a.get(typeResolve), zIncludeField, z11);
                    if (r18 != 0) {
                        for (String str2 : fieldNames) {
                            c0 c0Var2 = (c0) linkedHashMap.put(str2, c0VarCreateBoundField);
                            if (c0Var2 != null) {
                                throw createDuplicateFieldException(cls, str2, c0Var2.f11038b, field);
                            }
                        }
                    }
                    if (zIncludeField && (c0Var = (c0) linkedHashMap2.put(str, c0VarCreateBoundField)) != null) {
                        throw createDuplicateFieldException(cls, str, c0Var.f11038b, field);
                    }
                } else {
                    i8 = i10;
                    i9 = length;
                    r22 = r7;
                }
                i10 = i8 + 1;
                length = i9;
                r7 = r22;
                z10 = true;
            }
            aVar2 = c5.a.get(x4.i.resolve(aVar2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = aVar2.getRawType();
            z5 = z11;
        }
        return new e0(new ArrayList(linkedHashMap2.values()), linkedHashMap);
    }

    private List<String> getFieldNames(Field field) {
        String strTranslateName;
        List<String> listAlternateNames;
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            strTranslateName = this.fieldNamingPolicy.translateName(field);
            listAlternateNames = this.fieldNamingPolicy.alternateNames(field);
        } else {
            String strValue = serializedName.value();
            List<String> listAsList = Arrays.asList(serializedName.alternate());
            strTranslateName = strValue;
            listAlternateNames = listAsList;
        }
        if (listAlternateNames.isEmpty()) {
            return Collections.singletonList(strTranslateName);
        }
        ArrayList arrayList = new ArrayList(listAlternateNames.size() + 1);
        arrayList.add(strTranslateName);
        arrayList.addAll(listAlternateNames);
        return arrayList;
    }

    private boolean includeField(Field field, boolean z2) {
        return !this.excluder.excludeField(field, z2);
    }

    @Override // v4.q0
    public <T> v4.p0 create(v4.q qVar, c5.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        if (a5.d.isAnonymousOrNonStaticLocal(rawType)) {
            return new v4.m(2);
        }
        v4.f0 filterResult = x4.z.getFilterResult(this.reflectionFilters, rawType);
        if (filterResult != v4.f0.BLOCK_ALL) {
            boolean z2 = filterResult == v4.f0.BLOCK_INACCESSIBLE;
            return a5.d.isRecord(rawType) ? new f0(rawType, getBoundFields(qVar, aVar, rawType, z2, true), z2) : new d0(this.constructorConstructor.get(aVar, true), getBoundFields(qVar, aVar, rawType, z2, false));
        }
        throw new v4.v("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
