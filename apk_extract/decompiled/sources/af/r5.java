package af;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.io.EOFException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.InetSocketAddress;
import java.security.SecureRandom;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.net.ssl.X509TrustManager;
import k3.r9;
import k3.v8;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r5 implements z5, f2.b, zf.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f559d;
    public Object e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f560h;

    public /* synthetic */ r5(int i8, boolean z2) {
        this.f556a = i8;
    }

    public static void h(r5 r5Var, Throwable th2) {
        r5Var.getClass();
        ((cf.b0) r5Var.e).x(ze.q2.f11404g.h("Application error processing RPC").g(th2), new ze.p1());
    }

    public Class a(Type type) {
        if (type == null) {
            return null;
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.class;
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable)) {
            return null;
        }
        throw new nc.c(((nc.f) this.f559d) + ":  Unknown type " + type);
    }

    public Object b(Object obj, Type type) {
        nc.f fVar = (nc.f) this.f559d;
        LinkedList linkedList = (LinkedList) this.f558c;
        linkedList.add(obj);
        if (obj == null) {
            linkedList.removeLast();
            return null;
        }
        try {
            Class clsS = s(a(type), obj);
            oc.a aVarE = (oc.a) ((HashMap) this.f560h).get(fVar);
            if (aVarE == null) {
                aVarE = (clsS == null || !clsS.isArray()) ? e(clsS) : (oc.a) ((HashMap) this.e).get(Array.class);
            }
            if (aVarE != null) {
                Object objA = aVarE.a(this, obj, type, clsS);
                linkedList.removeLast();
                return objA;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fVar);
            sb2.append(": + Could not find a suitable ObjectFactory for ");
            sb2.append(clsS);
            throw new nc.c(sb2.toString());
        } catch (Throwable th2) {
            linkedList.removeLast();
            throw th2;
        }
    }

    public Object c(Map map, Object obj, Type type) {
        nc.f fVar = (nc.f) this.f559d;
        LinkedList linkedList = (LinkedList) this.f557b;
        try {
            linkedList.add(obj);
            nc.a aVarB = nc.a.b(obj.getClass());
            for (nc.b bVar : aVarB != null ? aVarB.a() : null) {
                if (!map.containsKey(bVar.f8154b)) {
                    String str = bVar.f8154b;
                    if (!map.containsKey(Character.toUpperCase(str.charAt(0)) + str.substring(1))) {
                        continue;
                    }
                }
                Object obj2 = map.get(bVar.f8154b);
                if (obj2 == null) {
                    String str2 = bVar.f8154b;
                    obj2 = map.get(Character.toUpperCase(str2.charAt(0)) + str2.substring(1));
                }
                Method methodD = bVar.d();
                Field field = bVar.e;
                if (methodD != null || (field != null && Modifier.isPublic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()))) {
                    fVar.f8167a.add(bVar.f8153a);
                    Method methodD2 = bVar.d();
                    if (methodD2 != null) {
                        Type[] genericParameterTypes = methodD2.getGenericParameterTypes();
                        if (genericParameterTypes.length != 1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(fVar);
                            sb2.append(":  Expected a single parameter for method ");
                            sb2.append(obj.getClass().getName());
                            sb2.append(".");
                            sb2.append(methodD2.getName());
                            sb2.append(" but got ");
                            sb2.append(genericParameterTypes.length);
                            throw new nc.c(sb2.toString());
                        }
                        methodD2.invoke(linkedList.getLast(), b(obj2, d(genericParameterTypes[0], type)));
                    } else if (field != null) {
                        field.setAccessible(true);
                        field.set(obj, b(obj2, field.getGenericType()));
                    }
                    fVar.a();
                }
            }
            return linkedList.removeLast();
        } catch (IllegalAccessException e) {
            throw new nc.c(fVar + ":  Could not access the no-arg constructor for " + obj.getClass().getName(), e);
        } catch (InvocationTargetException e4) {
            throw new nc.c(fVar + ":  Exception while trying to invoke setter method.", e4);
        }
    }

    public Type d(Type type, Type type2) {
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            return type;
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return type2;
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        throw new nc.c(((nc.f) this.f559d) + ":  Unknown generic type " + type + ".");
    }

    public oc.a e(Class cls) {
        oc.a aVar = (oc.a) ((HashMap) this.e).get(cls);
        if (aVar != null || cls == null) {
            return aVar;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            oc.a aVarE = e(cls2);
            if (aVarE != null) {
                return aVarE;
            }
        }
        if (cls.getSuperclass() != null) {
            return e(cls.getSuperclass());
        }
        return null;
    }

    public void f(Collection collection, AbstractCollection abstractCollection, Type type) {
        Type type2 = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        LinkedList linkedList = (LinkedList) this.f558c;
        linkedList.add(collection);
        LinkedList linkedList2 = (LinkedList) this.f557b;
        linkedList2.add(abstractCollection);
        nc.f fVar = (nc.f) this.f559d;
        fVar.f8167a.add("values");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            abstractCollection.add(b(it.next(), type2));
        }
        fVar.a();
        linkedList2.removeLast();
        linkedList.removeLast();
    }

    public void g(Map map, HashMap map2, Type type, Type type2) {
        LinkedList linkedList = (LinkedList) this.f558c;
        linkedList.add(map);
        LinkedList linkedList2 = (LinkedList) this.f557b;
        linkedList2.add(map2);
        for (Object obj : map.keySet()) {
            nc.f fVar = (nc.f) this.f559d;
            fVar.f8167a.add("keys");
            Object objB = b(obj, type);
            fVar.a();
            fVar.f8167a.add("values");
            Object objB2 = b(map.get(obj), type2);
            fVar.a();
            map2.put(objB, objB2);
        }
        linkedList2.removeLast();
        linkedList.removeLast();
    }

    @Override // yh.a
    public Object get() {
        return new h2.a((Executor) ((yh.a) this.f557b).get(), (e2.f) ((yh.a) this.f558c).get(), (i2.d) ((u6.a) this.f559d).get(), (j2.c) ((yh.a) this.e).get(), (k2.c) ((yh.a) this.f560h).get());
    }

    @Override // af.j6
    public void j(a8.a aVar) {
        ph.b.d();
        try {
            ph.b.a();
            ph.b.c();
            ((Executor) this.f557b).execute(new w(this, aVar));
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public nc.c k(Class cls, Object obj) {
        return new nc.c(((nc.f) this.f559d) + ":  Can not convert " + obj.getClass().getName() + " into " + cls.getName());
    }

    public void m(String toHttpUrl) throws EOFException {
        Objects.requireNonNull(toHttpUrl, "baseUrl == null");
        Intrinsics.checkNotNullParameter(toHttpUrl, "$this$toHttpUrl");
        dj.t tVar = new dj.t();
        tVar.d(null, toHttpUrl);
        dj.u uVarA = tVar.a();
        ArrayList arrayList = uVarA.f4637g;
        if ("".equals(arrayList.get(arrayList.size() - 1))) {
            this.f559d = uVarA;
        } else {
            throw new IllegalArgumentException("baseUrl must end in /: " + uVarA);
        }
    }

    @Override // af.z5
    public void n() {
        ph.b.d();
        try {
            ph.b.a();
            ph.b.c();
            ((Executor) this.f557b).execute(new q5(this, 0));
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public dj.e0 o() {
        Map mapUnmodifiableMap;
        dj.u uVar = (dj.u) this.f557b;
        if (uVar == null) {
            throw new IllegalStateException("url == null");
        }
        String str = (String) this.f558c;
        dj.s sVarC = ((dj.r) this.f559d).c();
        dj.h0 h0Var = (dj.h0) this.e;
        Map toImmutableMap = (Map) this.f560h;
        byte[] bArr = ej.b.f4964a;
        Intrinsics.checkNotNullParameter(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            mapUnmodifiableMap = MapsKt.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
            Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        }
        return new dj.e0(uVar, str, sVarC, h0Var, mapUnmodifiableMap);
    }

    @Override // af.z5
    public void p(ze.q2 q2Var) {
        ph.b.d();
        try {
            ph.b.a();
            t(q2Var);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // af.j6
    public void q() {
        ph.b.d();
        try {
            ph.b.a();
            ph.b.c();
            ((Executor) this.f557b).execute(new q5(this, 1));
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public zj.q0 r() {
        if (((dj.u) this.f559d) == null) {
            throw new IllegalStateException("Base URL required.");
        }
        dj.b0 b0Var = (dj.b0) this.f558c;
        if (b0Var == null) {
            b0Var = new dj.b0(new dj.a0());
        }
        dj.b0 b0Var2 = b0Var;
        Executor executorA = ((zj.k0) this.f557b).a();
        ArrayList arrayList = new ArrayList((ArrayList) this.f560h);
        arrayList.addAll(Arrays.asList(zj.h.f11636a, new zj.l(executorA)));
        ArrayList arrayList2 = (ArrayList) this.e;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + 2);
        zj.b bVar = new zj.b();
        bVar.f11619a = true;
        arrayList3.add(bVar);
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(Collections.singletonList(zj.x.f11721a));
        return new zj.q0(b0Var2, (dj.u) this.f559d, Collections.unmodifiableList(arrayList3), Collections.unmodifiableList(arrayList), executorA);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0061  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, nc.f] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Class] */
    public Class s(Class cls, Object obj) {
        String str;
        ?? r7 = (HashMap) this.f560h;
        ?? LoadClass = (nc.f) this.f559d;
        if (r7.containsKey(LoadClass)) {
            return null;
        }
        if (!(obj instanceof Map) || (str = (String) ((Map) obj).get("class")) == null) {
            LoadClass = 0;
        } else {
            try {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                LoadClass = contextClassLoader != null ? contextClassLoader.loadClass(str) : Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new nc.c(LoadClass + ":  Could not load " + str, e);
            }
        }
        if (LoadClass == 0 || cls == 0) {
            if (cls == 0) {
                if (LoadClass != 0) {
                    cls = LoadClass;
                } else {
                    cls = 0;
                }
            }
        } else if (cls.isAssignableFrom(LoadClass)) {
            cls = LoadClass;
        }
        return cls == 0 ? obj.getClass() : cls;
    }

    public void t(ze.q2 q2Var) {
        if (!q2Var.e()) {
            Throwable s2Var = q2Var.f11415c;
            if (s2Var == null) {
                ze.q2 q2VarH = ze.q2.f.h("RPC cancelled");
                ze.n1 n1Var = ze.v0.f11451a;
                s2Var = new ze.s2(q2VarH, null, false);
            }
            ((Executor) this.f558c).execute(new e((ze.s) this.f559d, s2Var));
        }
        ph.b.c();
        ((Executor) this.f557b).execute(new w(this, q2Var));
    }

    public String toString() {
        switch (this.f556a) {
            case 8:
                StringBuilder sb2 = new StringBuilder("CIOConnectionPoint(uri=");
                sb2.append((String) this.e);
                sb2.append(", method=");
                sb2.append((zf.x) this.f560h);
                sb2.append(", version=");
                sb2.append((String) this.f559d);
                sb2.append(", localAddress=");
                InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f558c;
                Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
                String hostString = inetSocketAddress.getHostString();
                if (hostString == null) {
                    hostString = "";
                }
                sb2.append(hostString);
                sb2.append(", localPort=");
                Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
                sb2.append(inetSocketAddress.getPort());
                sb2.append(", remoteAddress=");
                sb2.append(u());
                sb2.append(", remotePort=");
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.f557b;
                Intrinsics.checkNotNullParameter(inetSocketAddress2, "<this>");
                sb2.append(inetSocketAddress2.getPort());
                sb2.append(')');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public String u() {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f557b;
        Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
        String hostString = inetSocketAddress.getHostString();
        return hostString == null ? "" : hostString;
    }

    public void v(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        dj.r rVar = (dj.r) this.f559d;
        rVar.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        k3.v1.a(name);
        k3.v1.b(value, name);
        rVar.e(name);
        rVar.b(name, value);
    }

    public void w(String method, dj.h0 h0Var) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (h0Var == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (Intrinsics.areEqual(method, "POST") || Intrinsics.areEqual(method, "PUT") || Intrinsics.areEqual(method, "PATCH") || Intrinsics.areEqual(method, "PROPPATCH") || Intrinsics.areEqual(method, "REPORT")) {
                throw new IllegalArgumentException(h0.a.j("method ", method, " must have a request body.").toString());
            }
        } else if (!r9.a(method)) {
            throw new IllegalArgumentException(h0.a.j("method ", method, " must not have a request body.").toString());
        }
        this.f558c = method;
        this.e = h0Var;
    }

    public void x(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ((dj.r) this.f559d).e(name);
    }

    public void y(z5 z5Var) {
        v8.i(z5Var, "listener must not be null");
        v8.n(((z5) this.f560h) == null, "Listener already set");
        this.f560h = z5Var;
    }

    public void z(Class type, Object obj) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (obj == null) {
            ((Map) this.f560h).remove(type);
            return;
        }
        if (((Map) this.f560h).isEmpty()) {
            this.f560h = new LinkedHashMap();
        }
        Map map = (Map) this.f560h;
        Object objCast = type.cast(obj);
        Intrinsics.checkNotNull(objCast);
        map.put(type, objCast);
    }

    public /* synthetic */ r5(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i8) {
        this.f556a = i8;
        this.f557b = obj;
        this.f558c = obj2;
        this.f559d = obj3;
        this.e = obj4;
        this.f560h = obj5;
    }

    public /* synthetic */ r5(boolean z2) {
        this.f556a = 1;
    }

    public r5(SecureRandom random, ArrayList certificates, X509TrustManager trustManager, ArrayList cipherSuites, String str) {
        this.f556a = 3;
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(certificates, "certificates");
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
        this.f557b = random;
        this.f558c = certificates;
        this.f559d = trustManager;
        this.e = cipherSuites;
        this.f560h = str;
    }

    public r5(Drawable.Callback callback) {
        this.f556a = 9;
        this.f557b = new p1.j();
        this.f558c = new HashMap();
        this.f559d = new HashMap();
        this.f560h = ".ttf";
        if (!(callback instanceof View)) {
            w1.b.b("LottieDrawable must be inside of a view for images to work.");
            this.e = null;
        } else {
            this.e = ((View) callback).getContext().getAssets();
        }
    }

    public r5(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String version, String uri, zf.x method) {
        this.f556a = 8;
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(method, "method");
        this.f557b = inetSocketAddress;
        this.f558c = inetSocketAddress2;
        this.f559d = version;
        this.e = uri;
        this.f560h = method;
        zf.n0 n0Var = zf.n0.f11524c;
        int i8 = m3.f6.a("http").f11527b;
    }

    public r5(int i8) {
        this.f556a = i8;
        switch (i8) {
            case 7:
                this.f557b = new LinkedList();
                this.f558c = new LinkedList();
                this.f559d = new nc.f();
                this.f560h = new HashMap();
                HashMap map = new HashMap();
                this.e = map;
                map.put(Object.class, new oc.a(1));
                map.put(Collection.class, new oc.a(10));
                map.put(List.class, new oc.a(10));
                map.put(Set.class, new oc.a(13));
                map.put(Map.class, new oc.a(12));
                map.put(Integer.class, new oc.a(8));
                map.put(Integer.TYPE, new oc.a(8));
                map.put(Float.class, new oc.a(7));
                map.put(Float.TYPE, new oc.a(7));
                map.put(Double.class, new oc.a(5));
                map.put(Double.TYPE, new oc.a(5));
                map.put(Long.class, new oc.a(11));
                map.put(Long.TYPE, new oc.a(11));
                map.put(Byte.class, new oc.a(3));
                map.put(Byte.TYPE, new oc.a(3));
                map.put(Boolean.class, new oc.a(2));
                map.put(Boolean.TYPE, new oc.a(2));
                map.put(Character.class, new oc.a(4));
                map.put(Character.TYPE, new oc.a(4));
                map.put(Enum.class, new oc.a(6));
                map.put(String.class, new oc.a(14));
                map.put(Array.class, new oc.a(0));
                map.put(nc.e.class, new oc.a(9));
                break;
            case 12:
                zj.k0 k0Var = zj.k0.f11641b;
                this.e = new ArrayList();
                this.f560h = new ArrayList();
                this.f557b = k0Var;
                break;
            default:
                this.f560h = new LinkedHashMap();
                this.f558c = "GET";
                this.f559d = new dj.r(0);
                break;
        }
    }

    public r5(Executor executor, Executor executor2, cf.b0 b0Var, ze.s sVar) {
        this.f556a = 0;
        this.f557b = executor;
        this.f558c = executor2;
        this.e = b0Var;
        this.f559d = sVar;
    }
}
