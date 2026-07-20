package androidx.window.core;

import android.app.Activity;
import androidx.annotation.CheckResult;
import b.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kn.l0;
import lm.l2;
import os.l;
import os.m;
import un.d;
import un.e;

/* JADX INFO: loaded from: classes.dex */
@a({"BanUncheckedReflection"})
public final class ConsumerAdapter {

    @l
    private final ClassLoader loader;

    public static final class ConsumerHandler<T> implements InvocationHandler {

        @l
        private final d<T> clazz;

        @l
        private final jn.l<T, l2> consumer;

        /* JADX WARN: Multi-variable type inference failed */
        public ConsumerHandler(@l d<T> dVar, @l jn.l<? super T, l2> lVar) {
            l0.p(dVar, "clazz");
            l0.p(lVar, "consumer");
            this.clazz = dVar;
            this.consumer = lVar;
        }

        private final boolean isAccept(Method method, Object[] objArr) {
            return l0.g(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        private final boolean isEquals(Method method, Object[] objArr) {
            return l0.g(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        private final boolean isHashCode(Method method, Object[] objArr) {
            return l0.g(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        private final boolean isToString(Method method, Object[] objArr) {
            return l0.g(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        @l
        public Object invoke(@l Object obj, @l Method method, @m Object[] objArr) {
            l0.p(obj, "obj");
            l0.p(method, "method");
            if (isAccept(method, objArr)) {
                invokeAccept(e.a(this.clazz, objArr != null ? objArr[0] : null));
                return l2.f10208a;
            }
            if (isEquals(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (isHashCode(method, objArr)) {
                return Integer.valueOf(this.consumer.hashCode());
            }
            if (isToString(method, objArr)) {
                return this.consumer.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }

        public final void invokeAccept(@l T t10) {
            l0.p(t10, "parameter");
            this.consumer.invoke(t10);
        }
    }

    public interface Subscription {
        void dispose();
    }

    public ConsumerAdapter(@l ClassLoader classLoader) {
        l0.p(classLoader, "loader");
        this.loader = classLoader;
    }

    private final <T> Object buildConsumer(d<T> dVar, jn.l<? super T, l2> lVar) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.loader, new Class[]{unsafeConsumerClass()}, new ConsumerHandler(dVar, lVar));
        l0.o(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return objNewProxyInstance;
    }

    private final Class<?> unsafeConsumerClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("java.util.function.Consumer");
        l0.o(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }

    public final <T> void addConsumer(@l Object obj, @l d<T> dVar, @l String str, @l jn.l<? super T, l2> lVar) throws IllegalAccessException, InvocationTargetException {
        l0.p(obj, "obj");
        l0.p(dVar, "clazz");
        l0.p(str, "methodName");
        l0.p(lVar, "consumer");
        obj.getClass().getMethod(str, unsafeConsumerClass()).invoke(obj, buildConsumer(dVar, lVar));
    }

    @m
    public final Class<?> consumerClassOrNull$window_release() {
        try {
            return unsafeConsumerClass();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @CheckResult
    @l
    public final <T> Subscription createSubscription(@l final Object obj, @l d<T> dVar, @l String str, @l String str2, @l Activity activity, @l jn.l<? super T, l2> lVar) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        l0.p(obj, "obj");
        l0.p(dVar, "clazz");
        l0.p(str, "addMethodName");
        l0.p(str2, "removeMethodName");
        l0.p(activity, "activity");
        l0.p(lVar, "consumer");
        final Object objBuildConsumer = buildConsumer(dVar, lVar);
        obj.getClass().getMethod(str, Activity.class, unsafeConsumerClass()).invoke(obj, activity, objBuildConsumer);
        final Method method = obj.getClass().getMethod(str2, unsafeConsumerClass());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter.createSubscription.1
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void dispose() throws IllegalAccessException, InvocationTargetException {
                method.invoke(obj, objBuildConsumer);
            }
        };
    }
}
