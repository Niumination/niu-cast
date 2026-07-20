package nc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f8155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class f8156d;
    public final Field e;
    public Method f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Method f8157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f8158h = new HashMap();

    public b(String str, a aVar) {
        Field declaredField;
        this.f8154b = str;
        this.f8153a = str;
        this.f8155c = aVar;
        aVar.getClass();
        try {
            declaredField = aVar.f8150a.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            declaredField = null;
        }
        this.e = declaredField;
        if (declaredField == null || !declaredField.isAnnotationPresent(pc.a.class)) {
            return;
        }
        a((pc.a) declaredField.getAnnotation(pc.a.class));
    }

    public final void a(pc.a aVar) {
        this.f8154b = aVar.name().length() > 0 ? aVar.name() : this.f8153a;
        if (aVar.transformer() != qc.a.class) {
            aVar.transformer();
        }
        if (aVar.objectFactory() != oc.a.class) {
            aVar.objectFactory();
        }
        aVar.include();
    }

    public final void b(Method method) {
        if (this.f8156d == null) {
            this.f8156d = method.getReturnType();
            this.f = method;
            method.setAccessible(true);
        } else if (method.getReturnType().isAssignableFrom(this.f8156d)) {
            this.f = method;
            method.setAccessible(true);
        }
        Method method2 = this.f;
        if (method2 == null || !method2.isAnnotationPresent(pc.a.class)) {
            return;
        }
        a((pc.a) this.f.getAnnotation(pc.a.class));
    }

    public final Method c() {
        a aVar;
        a aVar2;
        b bVar;
        if (this.f == null && (aVar2 = (aVar = this.f8155c).f8151b) != null) {
            String str = this.f8153a;
            if (aVar2.c(str)) {
                a aVar3 = aVar.f8151b;
                aVar3.getClass();
                while (aVar3 != null) {
                    bVar = (b) aVar3.f8152c.get(str);
                    if (bVar != null) {
                        return bVar.c();
                    }
                    aVar3 = aVar3.f8151b;
                }
                bVar = null;
                return bVar.c();
            }
        }
        return this.f;
    }

    public final Method d() {
        a aVar;
        a aVar2;
        b bVar;
        if (this.f8157g == null) {
            Method method = (Method) this.f8158h.get(this.f8156d);
            this.f8157g = method;
            if (method == null && (aVar2 = (aVar = this.f8155c).f8151b) != null) {
                String str = this.f8153a;
                if (aVar2.c(str)) {
                    a aVar3 = aVar.f8151b;
                    aVar3.getClass();
                    while (aVar3 != null) {
                        bVar = (b) aVar3.f8152c.get(str);
                        if (bVar != null) {
                            return bVar.d();
                        }
                        aVar3 = aVar3.f8151b;
                    }
                    bVar = null;
                    return bVar.d();
                }
            }
        }
        return this.f8157g;
    }

    public b(Field field, a aVar) {
        String name = field.getName();
        this.f8154b = name;
        this.f8153a = name;
        this.f8155c = aVar;
        this.e = field;
        this.f8156d = field.getType();
        if (field.isAnnotationPresent(pc.a.class)) {
            a((pc.a) field.getAnnotation(pc.a.class));
        }
    }
}
