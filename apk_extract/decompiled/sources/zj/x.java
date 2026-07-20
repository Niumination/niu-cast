package zj;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f11721a = new x();

    @Override // zj.i
    public final j b(Type type, Annotation[] annotationArr, q0 q0Var) {
        if (s.g(type) != Optional.class) {
            return null;
        }
        return new tj.w(q0Var.d(s.f(0, (ParameterizedType) type), annotationArr), 22);
    }
}
