package ko;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends p implements uo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Annotation f9419a;

    public e(@os.l Annotation annotation) {
        l0.p(annotation, "annotation");
        this.f9419a = annotation;
    }

    @Override // uo.a
    public boolean E() {
        return uo.a.C0440a.a(this);
    }

    @os.l
    public final Annotation N() {
        return this.f9419a;
    }

    @Override // uo.a
    @os.l
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public l resolve() {
        return new l(in.b.e(in.b.a(this.f9419a)));
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof e) && l0.g(this.f9419a, ((e) obj).f9419a);
    }

    @Override // uo.a
    @os.l
    public dp.b f() {
        return d.a(in.b.e(in.b.a(this.f9419a)));
    }

    public int hashCode() {
        return this.f9419a.hashCode();
    }

    @Override // uo.a
    public boolean j() {
        return uo.a.C0440a.b(this);
    }

    @Override // uo.a
    @os.l
    public Collection<uo.b> n() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = in.b.e(in.b.a(this.f9419a)).getDeclaredMethods();
        l0.o(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        int length = declaredMethods.length;
        int i10 = 0;
        while (i10 < length) {
            Method method = declaredMethods[i10];
            i10++;
            f.a aVar = f.f9420b;
            Object objInvoke = method.invoke(this.f9419a, null);
            l0.o(objInvoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(objInvoke, dp.f.k(method.getName())));
        }
        return arrayList;
    }

    @os.l
    public String toString() {
        return e.class.getName() + ": " + this.f9419a;
    }
}
