package ko;

import eo.m1;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.h0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t extends p implements h, v, uo.q {
    @Override // uo.d
    public boolean C() {
        return h.a.c(this);
    }

    @Override // uo.d
    @os.m
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public e d(@os.l dp.c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // uo.d
    @os.l
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public List<e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // uo.q
    @os.l
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public l M() {
        Class<?> declaringClass = Q().getDeclaringClass();
        l0.o(declaringClass, "member.declaringClass");
        return new l(declaringClass);
    }

    @os.l
    public abstract Member Q();

    @os.l
    public final List<uo.b0> R(@os.l Type[] typeArr, @os.l Annotation[][] annotationArr, boolean z10) throws IllegalAccessException, InvocationTargetException {
        String str;
        l0.p(typeArr, "parameterTypes");
        l0.p(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> listC = c.f9408a.c(Q());
        int size = listC == null ? 0 : listC.size() - typeArr.length;
        int length = typeArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            z zVarA = z.f9442a.a(typeArr[i10]);
            if (listC == null) {
                str = null;
            } else {
                str = (String) h0.W2(listC, i10 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i10 + '+' + size + " (name=" + getName() + " type=" + zVarA + ") in " + this).toString());
                }
            }
            arrayList.add(new b0(zVarA, annotationArr[i10], str, z10 && i10 == nm.r.we(typeArr)));
            i10 = i11;
        }
        return arrayList;
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof t) && l0.g(Q(), ((t) obj).Q());
    }

    @Override // ko.h
    @os.l
    public AnnotatedElement getElement() {
        return (AnnotatedElement) Q();
    }

    @Override // ko.v
    public int getModifiers() {
        return Q().getModifiers();
    }

    @Override // uo.t
    @os.l
    public dp.f getName() {
        String name = Q().getName();
        if (name == null) {
            return dp.h.f3825b;
        }
        dp.f fVarK = dp.f.k(name);
        l0.o(fVarK, "member.name?.let { Name.…ialNames.NO_NAME_PROVIDED");
        return fVarK;
    }

    @Override // uo.s
    @os.l
    public m1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return Q().hashCode();
    }

    @Override // uo.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // uo.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // uo.s
    public boolean k() {
        return v.a.d(this);
    }

    @os.l
    public String toString() {
        return getClass().getName() + ": " + Q();
    }
}
