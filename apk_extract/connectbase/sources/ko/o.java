package ko;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends t implements uo.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Constructor<?> f9432a;

    public o(@os.l Constructor<?> constructor) {
        l0.p(constructor, "member");
        this.f9432a = constructor;
    }

    @Override // ko.t
    public Member Q() {
        return this.f9432a;
    }

    @os.l
    public Constructor<?> S() {
        return this.f9432a;
    }

    @Override // uo.z
    @os.l
    public List<a0> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = this.f9432a.getTypeParameters();
        l0.o(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i10 = 0;
        while (i10 < length) {
            TypeVariable<Constructor<?>> typeVariable = typeParameters[i10];
            i10++;
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // uo.k
    @os.l
    public List<uo.b0> h() {
        Type[] genericParameterTypes = this.f9432a.getGenericParameterTypes();
        l0.o(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return k0.INSTANCE;
        }
        Class<?> declaringClass = this.f9432a.getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) nm.p.l1(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = this.f9432a.getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException(l0.C("Illegal generic signature: ", this.f9432a));
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            l0.o(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) nm.p.l1(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        l0.o(genericParameterTypes, "realTypes");
        l0.o(parameterAnnotations, "realAnnotations");
        return R(genericParameterTypes, parameterAnnotations, this.f9432a.isVarArgs());
    }
}
