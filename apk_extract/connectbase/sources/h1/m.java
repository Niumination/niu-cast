package h1;

import c1.h0;
import c1.t0;
import c1.z;
import com.google.j2objc.annotations.Weak;
import f1.h4;
import f1.i3;
import f1.p4;
import f1.t3;
import f1.v4;
import f1.w2;
import f1.x7;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import p1.q;
import q1.c3;

/* JADX INFO: loaded from: classes.dex */
@e
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e1.l<Class<?>, i3<Method>> f6955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e1.l<Class<?>, t3<Class<?>>> f6956d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, CopyOnWriteArraySet<j>> f6957a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Weak
    public final f f6958b;

    public class a extends e1.g<Class<?>, i3<Method>> {
        @Override // e1.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i3<Method> load(Class<?> concreteClass) throws Exception {
            return m.e(concreteClass);
        }
    }

    public class b extends e1.g<Class<?>, t3<Class<?>>> {
        @Override // e1.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t3<Class<?>> load(Class<?> concreteClass) {
            return t3.copyOf((Collection) q.of((Class) concreteClass).getTypes().rawTypes());
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Class<?>> f6960b;

        public c(Method method) {
            this.f6959a = method.getName();
            this.f6960b = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(@gm.a Object o10) {
            if (!(o10 instanceof c)) {
                return false;
            }
            c cVar = (c) o10;
            return this.f6959a.equals(cVar.f6959a) && this.f6960b.equals(cVar.f6960b);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f6959a, this.f6960b});
        }
    }

    static {
        e1.d<Object, Object> dVarD = e1.d.D();
        dVarD.getClass();
        e1.m.t tVar = e1.m.t.WEAK;
        f6955c = dVarD.H(tVar).b(new a());
        f6956d = new e1.d().H(tVar).b(new b());
    }

    public m(f bus) {
        bus.getClass();
        this.f6958b = bus;
    }

    @b1.e
    public static t3<Class<?>> c(Class<?> concreteClass) {
        try {
            return f6956d.getUnchecked(concreteClass);
        } catch (c3 e10) {
            throw t0.q(e10.getCause());
        }
    }

    public static i3<Method> d(Class<?> clazz) {
        try {
            return f6955c.getUnchecked(clazz);
        } catch (c3 e10) {
            t0.w(e10.getCause());
            throw e10;
        }
    }

    public static i3<Method> e(Class<?> clazz) {
        Set setRawTypes = q.of((Class) clazz).getTypes().rawTypes();
        HashMap map = new HashMap();
        Iterator it = setRawTypes.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(h.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    h0.w(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                    h0.z(!parameterTypes[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, parameterTypes[0].getName(), o1.q.f(parameterTypes[0]).getSimpleName());
                    c cVar = new c(method);
                    if (!map.containsKey(cVar)) {
                        map.put(cVar, method);
                    }
                }
            }
        }
        return i3.copyOf(map.values());
    }

    public final v4<Class<?>, j> b(Object listener) {
        w2 w2VarCreate = w2.create();
        x7<Method> it = d(listener.getClass()).iterator();
        while (it.hasNext()) {
            Method next = it.next();
            w2VarCreate.put(next.getParameterTypes()[0], j.c(this.f6958b, listener, next));
        }
        return w2VarCreate;
    }

    public Iterator<j> f(Object event) {
        t3<Class<?>> t3VarC = c(event.getClass());
        ArrayList arrayListU = p4.u(t3VarC.size());
        x7<Class<?>> it = t3VarC.iterator();
        while (it.hasNext()) {
            CopyOnWriteArraySet<j> copyOnWriteArraySet = this.f6957a.get(it.next());
            if (copyOnWriteArraySet != null) {
                arrayListU.add(copyOnWriteArraySet.iterator());
            }
        }
        return new h4.m(arrayListU.iterator());
    }

    @b1.e
    public Set<j> g(Class<?> eventType) {
        return (Set) z.a(this.f6957a.get(eventType), t3.of());
    }

    public void h(Object listener) {
        for (Map.Entry<Class<?>, Collection<j>> entry : b(listener).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<j> value = entry.getValue();
            CopyOnWriteArraySet<j> copyOnWriteArraySet = this.f6957a.get(key);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet<j> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
                copyOnWriteArraySet = (CopyOnWriteArraySet) z.a(this.f6957a.putIfAbsent(key, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(value);
        }
    }

    public void i(Object listener) {
        for (Map.Entry<Class<?>, Collection<j>> entry : b(listener).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<j> value = entry.getValue();
            CopyOnWriteArraySet<j> copyOnWriteArraySet = this.f6957a.get(key);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(value)) {
                throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + listener + " registered?");
            }
        }
    }
}
