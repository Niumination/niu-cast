package zj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.net.URI;
import java.util.Map;
import java.util.regex.Pattern;
import k3.v1;
import k3.w1;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f11676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.d f11677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f11678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11679d;
    public final e e;

    public n(n0 n0Var, dj.d dVar, j jVar, e eVar, int i8) {
        this.f11679d = i8;
        this.f11676a = n0Var;
        this.f11677b = dVar;
        this.f11678c = jVar;
        this.e = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:387:0x08be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:388:0x08c0  */
    /* JADX WARN: Code duplicated, block: B:573:0x08d9 A[SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static n a(q0 q0Var, Method method) throws CloneNotSupportedException {
        Type genericReturnType;
        boolean z2;
        Annotation[][] annotationArr;
        int i8;
        int i9;
        String str;
        s[] sVarArr;
        boolean z3;
        s sVar;
        String str2;
        s[] sVarArr2;
        boolean z5;
        s i0Var;
        s zVar;
        y yVar;
        y yVar2;
        int i10 = -1;
        boolean z10 = false;
        boolean z11 = true;
        m0 m0Var = new m0(q0Var, method);
        Annotation[] annotationArr2 = m0Var.f11660c;
        int length = annotationArr2.length;
        int i11 = 0;
        while (true) {
            Method method2 = m0Var.f11659b;
            String str3 = "HEAD";
            if (i11 >= length) {
                if (m0Var.f11669n == null) {
                    throw s.k(method2, null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
                }
                if (!m0Var.f11670o) {
                    if (m0Var.q) {
                        throw s.k(method2, null, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                    if (m0Var.p) {
                        throw s.k(method2, null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                Annotation[][] annotationArr3 = m0Var.f11661d;
                int length2 = annotationArr3.length;
                m0Var.f11674v = new s[length2];
                int i12 = length2 - 1;
                int i13 = 0;
                while (i13 < length2) {
                    s[] sVarArr3 = m0Var.f11674v;
                    Type type = m0Var.e[i13];
                    Annotation[] annotationArr4 = annotationArr3[i13];
                    boolean z12 = i13 == i12 ? z11 : z10;
                    if (annotationArr4 != null) {
                        int length3 = annotationArr4.length;
                        int i14 = 0;
                        sVar = null;
                        while (true) {
                            annotationArr = annotationArr3;
                            if (i14 >= length3) {
                                i8 = length2;
                                i9 = i12;
                                str = str3;
                                sVarArr = sVarArr3;
                                z3 = z12;
                                break;
                            }
                            Annotation annotation = annotationArr4[i14];
                            int i15 = length3;
                            int i16 = length2;
                            int i17 = i12;
                            if (annotation instanceof bk.y) {
                                m0Var.c(i13, type);
                                if (m0Var.f11668m) {
                                    throw s.l(method2, i13, "Multiple @Url method annotations found.", new Object[0]);
                                }
                                if (m0Var.f11664i) {
                                    throw s.l(method2, i13, "@Path parameters may not be used with @Url.", new Object[0]);
                                }
                                if (m0Var.f11665j) {
                                    throw s.l(method2, i13, "A @Url parameter must not come after a @Query.", new Object[0]);
                                }
                                if (m0Var.f11666k) {
                                    throw s.l(method2, i13, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                                }
                                if (m0Var.f11667l) {
                                    throw s.l(method2, i13, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                                }
                                if (m0Var.f11671r != null) {
                                    throw s.l(method2, i13, "@Url cannot be used with @%s URL", m0Var.f11669n);
                                }
                                m0Var.f11668m = true;
                                if (type != dj.u.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                    throw s.l(method2, i13, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                }
                                i0Var = new d0(method2, i13, 2);
                            } else {
                                boolean z13 = annotation instanceof bk.s;
                                q0 q0Var2 = m0Var.f11658a;
                                if (z13) {
                                    m0Var.c(i13, type);
                                    if (m0Var.f11665j) {
                                        throw s.l(method2, i13, "A @Path parameter must not come after a @Query.", new Object[0]);
                                    }
                                    if (m0Var.f11666k) {
                                        throw s.l(method2, i13, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                                    }
                                    if (m0Var.f11667l) {
                                        throw s.l(method2, i13, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                                    }
                                    if (m0Var.f11668m) {
                                        throw s.l(method2, i13, "@Path parameters may not be used with @Url.", new Object[0]);
                                    }
                                    if (m0Var.f11671r == null) {
                                        throw s.l(method2, i13, "@Path can only be used with relative url on @%s", m0Var.f11669n);
                                    }
                                    m0Var.f11664i = true;
                                    bk.s sVar2 = (bk.s) annotation;
                                    String strValue = sVar2.value();
                                    if (!m0.f11657y.matcher(strValue).matches()) {
                                        throw s.l(method2, i13, "@Path parameter name must match %s. Found: %s", m0.f11656x.pattern(), strValue);
                                    }
                                    if (!m0Var.u.contains(strValue)) {
                                        throw s.l(method2, i13, "URL \"%s\" does not contain \"{%s}\".", m0Var.f11671r, strValue);
                                    }
                                    q0Var2.e(type, annotationArr4);
                                    i0Var = new f0(method2, i13, strValue, sVar2.encoded());
                                } else {
                                    str2 = str3;
                                    if (annotation instanceof bk.t) {
                                        m0Var.c(i13, type);
                                        bk.t tVar = (bk.t) annotation;
                                        String strValue2 = tVar.value();
                                        boolean zEncoded = tVar.encoded();
                                        Class clsG = s.g(type);
                                        sVarArr2 = sVarArr3;
                                        m0Var.f11665j = true;
                                        if (!Iterable.class.isAssignableFrom(clsG)) {
                                            if (clsG.isArray()) {
                                                q0Var2.e(m0.a(clsG.getComponentType()), annotationArr4);
                                                yVar2 = new y(new a0(1, strValue2, zEncoded), 1);
                                            } else {
                                                q0Var2.e(type, annotationArr4);
                                                i0Var = new a0(1, strValue2, zEncoded);
                                            }
                                            z5 = z12;
                                        } else {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw s.l(method2, i13, clsG.getSimpleName() + " must include generic type (e.g., " + clsG.getSimpleName() + "<String>)", new Object[0]);
                                            }
                                            q0Var2.e(s.f(0, (ParameterizedType) type), annotationArr4);
                                            yVar2 = new y(new a0(1, strValue2, zEncoded), 0);
                                        }
                                        i0Var = yVar2;
                                        z5 = z12;
                                    } else {
                                        sVarArr2 = sVarArr3;
                                        if (annotation instanceof bk.v) {
                                            m0Var.c(i13, type);
                                            boolean zEncoded2 = ((bk.v) annotation).encoded();
                                            Class clsG2 = s.g(type);
                                            m0Var.f11666k = true;
                                            if (!Iterable.class.isAssignableFrom(clsG2)) {
                                                if (clsG2.isArray()) {
                                                    q0Var2.e(m0.a(clsG2.getComponentType()), annotationArr4);
                                                    yVar2 = new y(new g0(zEncoded2), 1);
                                                } else {
                                                    q0Var2.e(type, annotationArr4);
                                                    i0Var = new g0(zEncoded2);
                                                }
                                                z5 = z12;
                                            } else {
                                                if (!(type instanceof ParameterizedType)) {
                                                    throw s.l(method2, i13, clsG2.getSimpleName() + " must include generic type (e.g., " + clsG2.getSimpleName() + "<String>)", new Object[0]);
                                                }
                                                q0Var2.e(s.f(0, (ParameterizedType) type), annotationArr4);
                                                yVar2 = new y(new g0(zEncoded2), 0);
                                            }
                                            i0Var = yVar2;
                                            z5 = z12;
                                        } else {
                                            z5 = z12;
                                            if (annotation instanceof bk.u) {
                                                m0Var.c(i13, type);
                                                Class clsG3 = s.g(type);
                                                m0Var.f11667l = true;
                                                if (!Map.class.isAssignableFrom(clsG3)) {
                                                    throw s.l(method2, i13, "@QueryMap parameter type must be Map.", new Object[0]);
                                                }
                                                Type typeH = s.h(type, clsG3);
                                                if (!(typeH instanceof ParameterizedType)) {
                                                    throw s.l(method2, i13, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                }
                                                ParameterizedType parameterizedType = (ParameterizedType) typeH;
                                                Type typeF = s.f(0, parameterizedType);
                                                if (String.class != typeF) {
                                                    throw s.l(method2, i13, "@QueryMap keys must be of type String: " + typeF, new Object[0]);
                                                }
                                                q0Var2.e(s.f(1, parameterizedType), annotationArr4);
                                                i0Var = new b0(method2, i13, ((bk.u) annotation).encoded(), 1);
                                            } else if (annotation instanceof bk.i) {
                                                m0Var.c(i13, type);
                                                String strValue3 = ((bk.i) annotation).value();
                                                Class clsG4 = s.g(type);
                                                if (Iterable.class.isAssignableFrom(clsG4)) {
                                                    if (!(type instanceof ParameterizedType)) {
                                                        throw s.l(method2, i13, clsG4.getSimpleName() + " must include generic type (e.g., " + clsG4.getSimpleName() + "<String>)", new Object[0]);
                                                    }
                                                    q0Var2.e(s.f(0, (ParameterizedType) type), annotationArr4);
                                                    yVar = new y(new c0(strValue3), 0);
                                                } else if (clsG4.isArray()) {
                                                    q0Var2.e(m0.a(clsG4.getComponentType()), annotationArr4);
                                                    yVar = new y(new c0(strValue3), 1);
                                                } else {
                                                    q0Var2.e(type, annotationArr4);
                                                    i0Var = new c0(strValue3);
                                                }
                                                i0Var = yVar;
                                            } else if (annotation instanceof bk.j) {
                                                if (type == dj.s.class) {
                                                    i0Var = new d0(method2, i13, 1);
                                                } else {
                                                    m0Var.c(i13, type);
                                                    Class clsG5 = s.g(type);
                                                    if (!Map.class.isAssignableFrom(clsG5)) {
                                                        throw s.l(method2, i13, "@HeaderMap parameter type must be Map.", new Object[0]);
                                                    }
                                                    Type typeH2 = s.h(type, clsG5);
                                                    if (!(typeH2 instanceof ParameterizedType)) {
                                                        throw s.l(method2, i13, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                    }
                                                    ParameterizedType parameterizedType2 = (ParameterizedType) typeH2;
                                                    Type typeF2 = s.f(0, parameterizedType2);
                                                    if (String.class != typeF2) {
                                                        throw s.l(method2, i13, "@HeaderMap keys must be of type String: " + typeF2, new Object[0]);
                                                    }
                                                    q0Var2.e(s.f(1, parameterizedType2), annotationArr4);
                                                    i0Var = new d0(method2, i13, 0);
                                                }
                                            } else if (annotation instanceof bk.c) {
                                                m0Var.c(i13, type);
                                                if (!m0Var.p) {
                                                    throw s.l(method2, i13, "@Field parameters can only be used with form encoding.", new Object[0]);
                                                }
                                                bk.c cVar = (bk.c) annotation;
                                                String strValue4 = cVar.value();
                                                boolean zEncoded3 = cVar.encoded();
                                                m0Var.f = true;
                                                Class clsG6 = s.g(type);
                                                if (Iterable.class.isAssignableFrom(clsG6)) {
                                                    if (!(type instanceof ParameterizedType)) {
                                                        throw s.l(method2, i13, clsG6.getSimpleName() + " must include generic type (e.g., " + clsG6.getSimpleName() + "<String>)", new Object[0]);
                                                    }
                                                    q0Var2.e(s.f(0, (ParameterizedType) type), annotationArr4);
                                                    yVar = new y(new a0(0, strValue4, zEncoded3), 0);
                                                } else if (clsG6.isArray()) {
                                                    q0Var2.e(m0.a(clsG6.getComponentType()), annotationArr4);
                                                    yVar = new y(new a0(0, strValue4, zEncoded3), 1);
                                                } else {
                                                    q0Var2.e(type, annotationArr4);
                                                    i0Var = new a0(0, strValue4, zEncoded3);
                                                }
                                                i0Var = yVar;
                                            } else if (annotation instanceof bk.d) {
                                                m0Var.c(i13, type);
                                                if (!m0Var.p) {
                                                    throw s.l(method2, i13, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                                                }
                                                Class clsG7 = s.g(type);
                                                if (!Map.class.isAssignableFrom(clsG7)) {
                                                    throw s.l(method2, i13, "@FieldMap parameter type must be Map.", new Object[0]);
                                                }
                                                Type typeH3 = s.h(type, clsG7);
                                                if (!(typeH3 instanceof ParameterizedType)) {
                                                    throw s.l(method2, i13, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                }
                                                ParameterizedType parameterizedType3 = (ParameterizedType) typeH3;
                                                Type typeF3 = s.f(0, parameterizedType3);
                                                if (String.class != typeF3) {
                                                    throw s.l(method2, i13, "@FieldMap keys must be of type String: " + typeF3, new Object[0]);
                                                }
                                                q0Var2.e(s.f(1, parameterizedType3), annotationArr4);
                                                m0Var.f = true;
                                                i0Var = new b0(method2, i13, ((bk.d) annotation).encoded(), 0);
                                            } else {
                                                i14 = i14;
                                                if (annotation instanceof bk.q) {
                                                    m0Var.c(i13, type);
                                                    if (!m0Var.q) {
                                                        throw s.l(method2, i13, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                                                    }
                                                    bk.q qVar = (bk.q) annotation;
                                                    m0Var.f11662g = true;
                                                    String strValue5 = qVar.value();
                                                    Class clsG8 = s.g(type);
                                                    if (strValue5.isEmpty()) {
                                                        boolean zIsAssignableFrom = Iterable.class.isAssignableFrom(clsG8);
                                                        zVar = h0.f11637b;
                                                        if (zIsAssignableFrom) {
                                                            if (!(type instanceof ParameterizedType)) {
                                                                throw s.l(method2, i13, clsG8.getSimpleName() + " must include generic type (e.g., " + clsG8.getSimpleName() + "<String>)", new Object[0]);
                                                            }
                                                            if (!dj.y.class.isAssignableFrom(s.g(s.f(0, (ParameterizedType) type)))) {
                                                                throw s.l(method2, i13, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                                            }
                                                            i0Var = new y(zVar, 0);
                                                        } else if (clsG8.isArray()) {
                                                            if (!dj.y.class.isAssignableFrom(clsG8.getComponentType())) {
                                                                throw s.l(method2, i13, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                                            }
                                                            i0Var = new y(zVar, 1);
                                                        } else if (!dj.y.class.isAssignableFrom(clsG8)) {
                                                            throw s.l(method2, i13, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                                        }
                                                    } else {
                                                        dj.s sVarC = v1.c("Content-Disposition", h0.a.j("form-data; name=\"", strValue5, "\""), "Content-Transfer-Encoding", qVar.encoding());
                                                        if (Iterable.class.isAssignableFrom(clsG8)) {
                                                            if (!(type instanceof ParameterizedType)) {
                                                                throw s.l(method2, i13, clsG8.getSimpleName() + " must include generic type (e.g., " + clsG8.getSimpleName() + "<String>)", new Object[0]);
                                                            }
                                                            Type typeF4 = s.f(0, (ParameterizedType) type);
                                                            if (dj.y.class.isAssignableFrom(s.g(typeF4))) {
                                                                throw s.l(method2, i13, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                                            }
                                                            i0Var = new y(new e0(method2, i13, sVarC, q0Var2.c(typeF4, annotationArr4, annotationArr2)), 0);
                                                        } else if (clsG8.isArray()) {
                                                            Class clsA = m0.a(clsG8.getComponentType());
                                                            if (dj.y.class.isAssignableFrom(clsA)) {
                                                                throw s.l(method2, i13, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                                            }
                                                            i0Var = new y(new e0(method2, i13, sVarC, q0Var2.c(clsA, annotationArr4, annotationArr2)), 1);
                                                        } else {
                                                            if (dj.y.class.isAssignableFrom(clsG8)) {
                                                                throw s.l(method2, i13, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                                            }
                                                            i0Var = new e0(method2, i13, sVarC, q0Var2.c(type, annotationArr4, annotationArr2));
                                                        }
                                                    }
                                                } else if (annotation instanceof bk.r) {
                                                    m0Var.c(i13, type);
                                                    if (!m0Var.q) {
                                                        throw s.l(method2, i13, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                                                    }
                                                    m0Var.f11662g = true;
                                                    Class clsG9 = s.g(type);
                                                    if (!Map.class.isAssignableFrom(clsG9)) {
                                                        throw s.l(method2, i13, "@PartMap parameter type must be Map.", new Object[0]);
                                                    }
                                                    Type typeH4 = s.h(type, clsG9);
                                                    if (!(typeH4 instanceof ParameterizedType)) {
                                                        throw s.l(method2, i13, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                    }
                                                    ParameterizedType parameterizedType4 = (ParameterizedType) typeH4;
                                                    Type typeF5 = s.f(0, parameterizedType4);
                                                    if (String.class != typeF5) {
                                                        throw s.l(method2, i13, "@PartMap keys must be of type String: " + typeF5, new Object[0]);
                                                    }
                                                    Type typeF6 = s.f(1, parameterizedType4);
                                                    if (dj.y.class.isAssignableFrom(s.g(typeF6))) {
                                                        throw s.l(method2, i13, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                                    }
                                                    zVar = new e0(method2, i13, q0Var2.c(typeF6, annotationArr4, annotationArr2), ((bk.r) annotation).encoding());
                                                } else if (annotation instanceof bk.a) {
                                                    m0Var.c(i13, type);
                                                    if (m0Var.p || m0Var.q) {
                                                        throw s.l(method2, i13, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                                                    }
                                                    if (m0Var.f11663h) {
                                                        throw s.l(method2, i13, "Multiple @Body method annotations found.", new Object[0]);
                                                    }
                                                    try {
                                                        j jVarC = q0Var2.c(type, annotationArr4, annotationArr2);
                                                        m0Var.f11663h = true;
                                                        zVar = new z(method2, i13, jVarC);
                                                    } catch (RuntimeException e) {
                                                        throw s.m(method2, e, i13, "Unable to create @Body converter for %s", type);
                                                    }
                                                } else if (annotation instanceof bk.x) {
                                                    m0Var.c(i13, type);
                                                    Class clsG10 = s.g(type);
                                                    for (int i18 = i13 - 1; i18 >= 0; i18--) {
                                                        s sVar3 = m0Var.f11674v[i18];
                                                        if ((sVar3 instanceof i0) && ((i0) sVar3).f11638b.equals(clsG10)) {
                                                            throw s.l(method2, i13, "@Tag type " + clsG10.getName() + " is duplicate of parameter #" + (i18 + 1) + " and would always overwrite its value.", new Object[0]);
                                                        }
                                                    }
                                                    i0Var = new i0(clsG10);
                                                } else {
                                                    i0Var = null;
                                                }
                                                i0Var = zVar;
                                            }
                                            i14 = i14;
                                        }
                                    }
                                }
                                if (i0Var != null) {
                                    if (sVar == null) {
                                        throw s.l(method2, i13, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                                    }
                                    sVar = i0Var;
                                }
                                i14++;
                                annotationArr3 = annotationArr;
                                length3 = i15;
                                length2 = i16;
                                i12 = i17;
                                str3 = str2;
                                sVarArr3 = sVarArr2;
                                z12 = z5;
                            }
                            str2 = str3;
                            sVarArr2 = sVarArr3;
                            z5 = z12;
                            if (i0Var != null) {
                                if (sVar == null) {
                                    throw s.l(method2, i13, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                                }
                                sVar = i0Var;
                            }
                            i14++;
                            annotationArr3 = annotationArr;
                            length3 = i15;
                            length2 = i16;
                            i12 = i17;
                            str3 = str2;
                            sVarArr3 = sVarArr2;
                            z12 = z5;
                        }
                    } else {
                        annotationArr = annotationArr3;
                        i8 = length2;
                        i9 = i12;
                        str = str3;
                        sVarArr = sVarArr3;
                        z3 = z12;
                        sVar = null;
                    }
                    if (sVar == null) {
                        if (z3) {
                            try {
                                if (s.g(type) == Continuation.class) {
                                    m0Var.f11675w = true;
                                    sVar = null;
                                }
                            } catch (NoClassDefFoundError unused) {
                            }
                        }
                        throw s.l(method2, i13, "No Retrofit annotation found.", new Object[0]);
                    }
                    sVarArr[i13] = sVar;
                    i13++;
                    z11 = true;
                    annotationArr3 = annotationArr;
                    length2 = i8;
                    i12 = i9;
                    str3 = str;
                    z10 = false;
                }
                String str4 = str3;
                if (m0Var.f11671r == null && !m0Var.f11668m) {
                    throw s.k(method2, null, "Missing either @%s URL or @Url parameter.", m0Var.f11669n);
                }
                boolean z14 = m0Var.p;
                if (!z14 && !m0Var.q && !m0Var.f11670o && m0Var.f11663h) {
                    throw s.k(method2, null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (z14 && !m0Var.f) {
                    throw s.k(method2, null, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (m0Var.q && !m0Var.f11662g) {
                    throw s.k(method2, null, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                n0 n0Var = new n0(m0Var);
                Type genericReturnType2 = method.getGenericReturnType();
                if (s.i(genericReturnType2)) {
                    throw s.k(method, null, "Method return type must not include a type variable or wildcard: %s", genericReturnType2);
                }
                if (genericReturnType2 == Void.TYPE) {
                    throw s.k(method, null, "Service methods cannot return void.", new Object[0]);
                }
                Annotation[] annotations = method.getAnnotations();
                boolean z15 = n0Var.f11688k;
                if (z15) {
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    Type typeF7 = ((ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]).getActualTypeArguments()[0];
                    if (typeF7 instanceof WildcardType) {
                        typeF7 = ((WildcardType) typeF7).getLowerBounds()[0];
                    }
                    if (s.g(typeF7) == o0.class && (typeF7 instanceof ParameterizedType)) {
                        typeF7 = s.f(0, (ParameterizedType) typeF7);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    genericReturnType = new u0(null, c.class, typeF7);
                    if (!s.j(annotations, r0.class)) {
                        Annotation[] annotationArr5 = new Annotation[annotations.length + 1];
                        annotationArr5[0] = s0.f11701a;
                        System.arraycopy(annotations, 0, annotationArr5, 1, annotations.length);
                        annotations = annotationArr5;
                    }
                } else {
                    genericReturnType = method.getGenericReturnType();
                    z2 = false;
                }
                try {
                    e eVarA = q0Var.a(genericReturnType, annotations);
                    Type typeC = eVarA.c();
                    if (typeC == dj.j0.class) {
                        throw s.k(method, null, "'" + s.g(typeC).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
                    }
                    if (typeC == o0.class) {
                        throw s.k(method, null, "Response must include generic type (e.g., Response<String>)", new Object[0]);
                    }
                    if (n0Var.f11682c.equals(str4) && !Void.class.equals(typeC)) {
                        throw s.k(method, null, "HEAD method must use Void as response type.", new Object[0]);
                    }
                    try {
                        j jVarD = q0Var.d(typeC, method.getAnnotations());
                        dj.d dVar = q0Var.f11697b;
                        if (z15) {
                            return z2 ? new n(n0Var, dVar, jVarD, eVarA, 2) : new n(n0Var, dVar, jVarD, eVarA, 1);
                        }
                        return new n(n0Var, dVar, jVarD, eVarA, 0);
                    } catch (RuntimeException e4) {
                        throw s.k(method, e4, "Unable to create converter for %s", typeC);
                    }
                } catch (RuntimeException e10) {
                    throw s.k(method, e10, "Unable to create call adapter for %s", genericReturnType);
                }
            }
            Annotation annotation2 = annotationArr2[i11];
            if (annotation2 instanceof bk.b) {
                m0Var.b("DELETE", ((bk.b) annotation2).value(), false);
            } else if (annotation2 instanceof bk.f) {
                m0Var.b("GET", ((bk.f) annotation2).value(), false);
            } else if (annotation2 instanceof bk.g) {
                m0Var.b("HEAD", ((bk.g) annotation2).value(), false);
            } else if (annotation2 instanceof bk.n) {
                m0Var.b("PATCH", ((bk.n) annotation2).value(), true);
            } else if (annotation2 instanceof bk.o) {
                m0Var.b("POST", ((bk.o) annotation2).value(), true);
            } else if (annotation2 instanceof bk.p) {
                m0Var.b("PUT", ((bk.p) annotation2).value(), true);
            } else if (annotation2 instanceof bk.m) {
                m0Var.b("OPTIONS", ((bk.m) annotation2).value(), false);
            } else if (annotation2 instanceof bk.h) {
                bk.h hVar = (bk.h) annotation2;
                m0Var.b(hVar.method(), hVar.path(), hVar.hasBody());
            } else if (annotation2 instanceof bk.k) {
                String[] strArrValue = ((bk.k) annotation2).value();
                if (strArrValue.length == 0) {
                    throw s.k(method2, null, "@Headers annotation is empty.", new Object[0]);
                }
                dj.r rVar = new dj.r(0);
                int length4 = strArrValue.length;
                int i19 = 0;
                while (i19 < length4) {
                    String str5 = strArrValue[i19];
                    int iIndexOf = str5.indexOf(58);
                    if (iIndexOf == i10 || iIndexOf == 0 || iIndexOf == str5.length() - 1) {
                        throw s.k(method2, null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str5);
                    }
                    String strSubstring = str5.substring(0, iIndexOf);
                    String strTrim = str5.substring(iIndexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                        try {
                            Pattern pattern = dj.x.f4641d;
                            m0Var.f11673t = w1.a(strTrim);
                        } catch (IllegalArgumentException e11) {
                            throw s.k(method2, e11, "Malformed content type: %s", strTrim);
                        }
                    } else {
                        rVar.a(strSubstring, strTrim);
                    }
                    i19++;
                    i10 = -1;
                }
                m0Var.f11672s = rVar.c();
            } else if (annotation2 instanceof bk.l) {
                if (m0Var.p) {
                    throw s.k(method2, null, "Only one encoding annotation is allowed.", new Object[0]);
                }
                m0Var.q = true;
            } else if (!(annotation2 instanceof bk.e)) {
                continue;
            } else {
                if (m0Var.q) {
                    throw s.k(method2, null, "Only one encoding annotation is allowed.", new Object[0]);
                }
                m0Var.p = true;
            }
            i11++;
            i10 = -1;
        }
    }
}
