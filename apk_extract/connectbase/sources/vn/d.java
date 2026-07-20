package vn;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.l1;
import lm.f1;
import lm.p2;
import lm.r;
import nm.g0;
import nm.k0;
import nm.p;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "KAnnotatedElements")
public final class d {
    @f1(version = "1.1")
    public static final <T extends Annotation> T a(un.b bVar) {
        l0.p(bVar, "<this>");
        for (Object obj : bVar.getAnnotations()) {
            Annotation annotation = (Annotation) obj;
            l0.P();
            if (annotation != null) {
                l0.P();
                return (T) obj;
            }
        }
        obj = null;
        l0.P();
        return (T) obj;
    }

    @f1(version = "1.5")
    @r
    public static final <T extends Annotation> List<T> b(un.b bVar) {
        l0.p(bVar, "<this>");
        l0.P();
        return c(bVar, l1.d(Annotation.class));
    }

    @f1(version = "1.5")
    @r
    @l
    public static final <T extends Annotation> List<T> c(@l un.b bVar, @l un.d<T> dVar) throws IllegalAccessException, InvocationTargetException {
        Object next;
        l0.p(bVar, "<this>");
        l0.p(dVar, "klass");
        List<T> listF1 = g0.f1(bVar.getAnnotations(), in.b.e(dVar));
        if (!listF1.isEmpty()) {
            return listF1;
        }
        Class<? extends Annotation> clsC = c.f17596a.c(in.b.e(dVar));
        if (clsC != null) {
            Iterator<T> it = bVar.getAnnotations().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!l0.g(in.b.e(in.b.a((Annotation) next)), clsC));
            Annotation annotation = (Annotation) next;
            if (annotation != null) {
                Object objInvoke = annotation.getClass().getMethod("value", null).invoke(annotation, null);
                if (objInvoke != null) {
                    return p.t((Annotation[]) objInvoke);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
            }
        }
        return k0.INSTANCE;
    }

    @f1(version = "1.4")
    @p2(markerClass = {r.class})
    public static final <T extends Annotation> boolean d(un.b bVar) {
        Object next;
        Annotation annotation;
        l0.p(bVar, "<this>");
        Iterator<T> it = bVar.getAnnotations().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            annotation = (Annotation) next;
            l0.P();
        } while (annotation == null);
        l0.P();
        return ((Annotation) next) != null;
    }
}
