package ko;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends t implements uo.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Method f9436a;

    public u(@os.l Method method) {
        l0.p(method, "member");
        this.f9436a = method;
    }

    @Override // uo.r
    public boolean K() {
        return uo.r.a.a(this);
    }

    @Override // ko.t
    public Member Q() {
        return this.f9436a;
    }

    @os.l
    public Method S() {
        return this.f9436a;
    }

    @Override // uo.r
    @os.l
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public z getReturnType() {
        z.a aVar = z.f9442a;
        Type genericReturnType = this.f9436a.getGenericReturnType();
        l0.o(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // uo.z
    @os.l
    public List<a0> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = this.f9436a.getTypeParameters();
        l0.o(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i10 = 0;
        while (i10 < length) {
            TypeVariable<Method> typeVariable = typeParameters[i10];
            i10++;
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // uo.r
    @os.l
    public List<uo.b0> h() {
        Type[] genericParameterTypes = this.f9436a.getGenericParameterTypes();
        l0.o(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = this.f9436a.getParameterAnnotations();
        l0.o(parameterAnnotations, "member.parameterAnnotations");
        return R(genericParameterTypes, parameterAnnotations, this.f9436a.isVarArgs());
    }

    @Override // uo.r
    @os.m
    public uo.b q() {
        Object defaultValue = this.f9436a.getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return f.f9420b.a(defaultValue, null);
    }
}
