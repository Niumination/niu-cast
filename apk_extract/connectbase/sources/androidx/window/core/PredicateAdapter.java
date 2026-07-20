package androidx.window.core;

import android.util.Pair;
import b.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import jn.p;
import kn.l0;
import kn.l1;
import os.l;
import os.m;
import un.d;
import un.e;

/* JADX INFO: loaded from: classes.dex */
@a({"BanUncheckedReflection"})
public final class PredicateAdapter {

    @l
    private final ClassLoader loader;

    public static abstract class BaseHandler<T> implements InvocationHandler {

        @l
        private final d<T> clazz;

        public BaseHandler(@l d<T> dVar) {
            l0.p(dVar, "clazz");
            this.clazz = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        @l
        public Object invoke(@l Object obj, @l Method method, @m Object[] objArr) {
            l0.p(obj, "obj");
            l0.p(method, "method");
            if (isTest(method, objArr)) {
                return Boolean.valueOf(invokeTest(obj, e.a(this.clazz, objArr != null ? objArr[0] : null)));
            }
            if (isEquals(method, objArr)) {
                Object obj2 = objArr != null ? objArr[0] : null;
                l0.m(obj2);
                return Boolean.valueOf(obj == obj2);
            }
            if (isHashCode(method, objArr)) {
                return Integer.valueOf(hashCode());
            }
            if (isToString(method, objArr)) {
                return toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }

        public abstract boolean invokeTest(@l Object obj, @l T t10);

        public final boolean isEquals(@l Method method, @m Object[] objArr) {
            l0.p(method, "<this>");
            return l0.g(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean isHashCode(@l Method method, @m Object[] objArr) {
            l0.p(method, "<this>");
            return l0.g(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        public final boolean isTest(@l Method method, @m Object[] objArr) {
            l0.p(method, "<this>");
            return l0.g(method.getName(), "test") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean isToString(@l Method method, @m Object[] objArr) {
            l0.p(method, "<this>");
            return l0.g(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }
    }

    public static final class PairPredicateStubHandler<T, U> extends BaseHandler<Pair<?, ?>> {

        @l
        private final d<T> clazzT;

        @l
        private final d<U> clazzU;

        @l
        private final p<T, U, Boolean> predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PairPredicateStubHandler(@l d<T> dVar, @l d<U> dVar2, @l p<? super T, ? super U, Boolean> pVar) {
            super(l1.d(Pair.class));
            l0.p(dVar, "clazzT");
            l0.p(dVar2, "clazzU");
            l0.p(pVar, "predicate");
            this.clazzT = dVar;
            this.clazzU = dVar2;
            this.predicate = pVar;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        @l
        public String toString() {
            return this.predicate.toString();
        }

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean invokeTest(@l Object obj, @l Pair<?, ?> pair) {
            l0.p(obj, "obj");
            l0.p(pair, "parameter");
            return this.predicate.invoke((T) e.a(this.clazzT, pair.first), (U) e.a(this.clazzU, pair.second)).booleanValue();
        }
    }

    public static final class PredicateStubHandler<T> extends BaseHandler<T> {

        @l
        private final jn.l<T, Boolean> predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PredicateStubHandler(@l d<T> dVar, @l jn.l<? super T, Boolean> lVar) {
            super(dVar);
            l0.p(dVar, "clazzT");
            l0.p(lVar, "predicate");
            this.predicate = lVar;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean invokeTest(@l Object obj, @l T t10) {
            l0.p(obj, "obj");
            l0.p(t10, "parameter");
            return this.predicate.invoke(t10).booleanValue();
        }

        @l
        public String toString() {
            return this.predicate.toString();
        }
    }

    public PredicateAdapter(@l ClassLoader classLoader) {
        l0.p(classLoader, "loader");
        this.loader = classLoader;
    }

    private final Class<?> predicateClassOrThrow() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("java.util.function.Predicate");
        l0.o(clsLoadClass, "loader.loadClass(\"java.util.function.Predicate\")");
        return clsLoadClass;
    }

    @l
    public final <T, U> Object buildPairPredicate(@l d<T> dVar, @l d<U> dVar2, @l p<? super T, ? super U, Boolean> pVar) {
        l0.p(dVar, "firstClazz");
        l0.p(dVar2, "secondClazz");
        l0.p(pVar, "predicate");
        Object objNewProxyInstance = Proxy.newProxyInstance(this.loader, new Class[]{predicateClassOrThrow()}, new PairPredicateStubHandler(dVar, dVar2, pVar));
        l0.o(objNewProxyInstance, "newProxyInstance(loader,…row()), predicateHandler)");
        return objNewProxyInstance;
    }

    @l
    public final <T> Object buildPredicate(@l d<T> dVar, @l jn.l<? super T, Boolean> lVar) {
        l0.p(dVar, "clazz");
        l0.p(lVar, "predicate");
        Object objNewProxyInstance = Proxy.newProxyInstance(this.loader, new Class[]{predicateClassOrThrow()}, new PredicateStubHandler(dVar, lVar));
        l0.o(objNewProxyInstance, "newProxyInstance(loader,…row()), predicateHandler)");
        return objNewProxyInstance;
    }

    @m
    public final Class<?> predicateClassOrNull$window_release() {
        try {
            return predicateClassOrThrow();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
