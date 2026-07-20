package yn;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kn.l0;
import kn.w;
import nm.k0;
import nm.p;
import nm.x;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements d<Method> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Method f21497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final List<Type> f21498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final Type f21499c;

    public static final class a extends i implements c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m
        public final Object f21500d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@l Method method, @m Object obj) {
            super(method, k0.INSTANCE);
            l0.p(method, "unboxMethod");
            this.f21500d = obj;
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            d.a.a(this, objArr);
            return c(this.f21500d, objArr);
        }
    }

    public static final class b extends i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@l Method method) {
            super(method, x.k(method.getDeclaringClass()));
            l0.p(method, "unboxMethod");
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            d.a.a(this, objArr);
            Object obj = objArr[0];
            e.d dVar = e.f21478e;
            return c(obj, objArr.length <= 1 ? new Object[0] : p.l1(objArr, 1, objArr.length));
        }
    }

    public /* synthetic */ i(Method method, List list, w wVar) {
        this(method, list);
    }

    @Override // yn.d
    @l
    public final List<Type> a() {
        return this.f21498b;
    }

    @Override // yn.d
    public Member b() {
        return null;
    }

    @m
    public final Object c(@m Object obj, @l Object[] objArr) {
        l0.p(objArr, d6.a.F);
        return this.f21497a.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void d(@l Object[] objArr) {
        d.a.a(this, objArr);
    }

    @m
    public final Method e() {
        return null;
    }

    @Override // yn.d
    @l
    public final Type getReturnType() {
        return this.f21499c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Method method, List<? extends Type> list) {
        this.f21497a = method;
        this.f21498b = list;
        Class<?> returnType = method.getReturnType();
        l0.o(returnType, "unboxMethod.returnType");
        this.f21499c = returnType;
    }
}
