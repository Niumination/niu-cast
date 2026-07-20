package p1;

import f1.i3;
import f1.p1;
import f1.x7;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@d
public final class j implements AnnotatedElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<?, ?> f12714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q<?> f12716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i3<Annotation> f12717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f12718e;

    public j(g<?, ?> declaration, int position, q<?> type, Annotation[] annotations, Object annotatedType) {
        this.f12714a = declaration;
        this.f12715b = position;
        this.f12716c = type;
        this.f12717d = i3.copyOf(annotations);
        this.f12718e = annotatedType;
    }

    @e
    @b1.a
    @Deprecated
    @t1.e("fails under Android VMs; do not use from guava-android")
    public AnnotatedType a() {
        AnnotatedType annotatedType = (AnnotatedType) this.f12718e;
        Objects.requireNonNull(annotatedType);
        return annotatedType;
    }

    public g<?, ?> b() {
        return this.f12714a;
    }

    public q<?> c() {
        return this.f12716c;
    }

    public boolean equals(@gm.a Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f12715b == jVar.f12715b && this.f12714a.equals(jVar.f12714a);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @gm.a
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        annotationType.getClass();
        x7<Annotation> it = this.f12717d.iterator();
        while (it.hasNext()) {
            Annotation next = it.next();
            if (annotationType.isInstance(next)) {
                return annotationType.cast(next);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @gm.a
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationType) {
        annotationType.getClass();
        return (A) p1.u(this.f12717d).q(annotationType).r().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.f12717d.toArray(new Annotation[0]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) ((Annotation[]) p1.u(this.f12717d).q(cls).E(cls));
    }

    public int hashCode() {
        return this.f12715b;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        return getAnnotation(annotationType) != null;
    }

    public String toString() {
        return this.f12716c + " arg" + this.f12715b;
    }
}
