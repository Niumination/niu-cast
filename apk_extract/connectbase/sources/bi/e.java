package bi;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class f847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Field f848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Method f849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Method f850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Class<?>, Method> f851h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i<? extends ei.n> f852i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i<? extends q> f853j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f854k = null;

    public e(String str, d dVar) {
        this.f845b = str;
        this.f844a = str;
        this.f846c = dVar;
        Field fieldB = dVar.b(str);
        this.f848e = fieldB;
        if (fieldB == null || !fieldB.isAnnotationPresent(di.a.class)) {
            return;
        }
        c((di.a) fieldB.getAnnotation(di.a.class));
    }

    public Object a(Object obj) {
        try {
            Method methodI = i();
            if (methodI != null) {
                return methodI.invoke(obj, null);
            }
            Field field = this.f848e;
            if (field != null) {
                return field.get(obj);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new l("Error while reading property " + this.f847d.getName() + "." + this.f844a, e10);
        }
    }

    public String b() {
        return this.f845b;
    }

    public final void c(di.a aVar) {
        this.f845b = aVar.name().length() > 0 ? aVar.name() : this.f844a;
        this.f852i = aVar.transformer() == ei.n.class ? null : new i<>(aVar.transformer());
        this.f853j = aVar.objectFactory() != q.class ? new i<>(aVar.objectFactory()) : null;
        this.f854k = Boolean.valueOf(aVar.include());
    }

    public void d(Method method) {
        Class<?> cls = method.getParameterTypes()[0];
        if (this.f847d == null) {
            this.f847d = cls;
        }
        this.f851h.put(cls, method);
        method.setAccessible(true);
    }

    public String e() {
        return this.f844a;
    }

    public void f(Method method) {
        if (this.f847d == null) {
            this.f847d = method.getReturnType();
            this.f849f = method;
            method.setAccessible(true);
        } else if (method.getReturnType().isAssignableFrom(this.f847d)) {
            this.f849f = method;
            method.setAccessible(true);
        }
        Method method2 = this.f849f;
        if (method2 == null || !method2.isAnnotationPresent(di.a.class)) {
            return;
        }
        c((di.a) this.f849f.getAnnotation(di.a.class));
    }

    public Field g() {
        return this.f848e;
    }

    public Class h() {
        return this.f847d;
    }

    public Method i() {
        return (this.f849f == null && this.f846c.e() != null && this.f846c.e().h(this.f844a)) ? this.f846c.e().f(this.f844a).i() : this.f849f;
    }

    public ei.n j() throws IllegalAccessException, InstantiationException {
        i<? extends ei.n> iVar = this.f852i;
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    public Method k() {
        if (this.f850g == null) {
            Method method = this.f851h.get(this.f847d);
            this.f850g = method;
            if (method == null && this.f846c.e() != null && this.f846c.e().h(this.f844a)) {
                return this.f846c.e().f(this.f844a).k();
            }
        }
        return this.f850g;
    }

    public Boolean l() {
        return this.f854k;
    }

    public boolean m() {
        return i() == null && k() == null && !Modifier.isPublic(this.f848e.getModifiers());
    }

    public Boolean n() {
        Field field;
        Method methodI = i();
        return Boolean.valueOf(((methodI == null || Modifier.isStatic(methodI.getModifiers())) && ((field = this.f848e) == null || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(this.f848e.getModifiers()))) ? false : true);
    }

    public Boolean o() {
        Field field = this.f848e;
        return Boolean.valueOf(field != null && Modifier.isTransient(field.getModifiers()));
    }

    public Boolean p() {
        Field field;
        return Boolean.valueOf((k() == null && ((field = this.f848e) == null || !Modifier.isPublic(field.getModifiers()) || Modifier.isTransient(this.f848e.getModifiers()))) ? false : true);
    }

    public e(Field field, d dVar) {
        String name = field.getName();
        this.f845b = name;
        this.f844a = name;
        this.f846c = dVar;
        this.f848e = field;
        this.f847d = field.getType();
        if (field.isAnnotationPresent(di.a.class)) {
            c((di.a) field.getAnnotation(di.a.class));
        }
    }
}
