package zj;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f11643a;

    public l(Executor executor) {
        this.f11643a = executor;
    }

    @Override // zj.d
    public final e a(Type type, Annotation[] annotationArr) {
        if (s.g(type) != c.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new y6.g(s.f(0, (ParameterizedType) type), s.j(annotationArr, r0.class) ? null : this.f11643a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
