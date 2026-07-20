package zj;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f11636a = new h();

    @Override // zj.d
    public final e a(Type type, Annotation[] annotationArr) {
        if (s.g(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeF = s.f(0, (ParameterizedType) type);
        if (s.g(typeF) != o0.class) {
            return new tj.w(typeF, 21);
        }
        if (typeF instanceof ParameterizedType) {
            return new a8.a(s.f(0, (ParameterizedType) typeF), 22);
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
