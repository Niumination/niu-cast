package ko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c f9408a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public static a f9409b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final Method f9410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final Method f9411b;

        public a(@os.m Method method, @os.m Method method2) {
            this.f9410a = method;
            this.f9411b = method2;
        }

        @os.m
        public final Method a() {
            return this.f9411b;
        }

        @os.m
        public final Method b() {
            return this.f9410a;
        }
    }

    @os.l
    public final a a(@os.l Member member) {
        l0.p(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), d.f(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    @os.m
    public final a b() {
        return f9409b;
    }

    @os.m
    public final List<String> c(@os.l Member member) throws IllegalAccessException, InvocationTargetException {
        Method method;
        l0.p(member, "member");
        a aVar = f9409b;
        if (aVar == null) {
            synchronized (this) {
                c cVar = f9408a;
                cVar.getClass();
                a aVarA = f9409b;
                if (aVarA == null) {
                    aVarA = cVar.a(member);
                    cVar.getClass();
                    f9409b = aVarA;
                }
                aVar = aVarA;
            }
        }
        Method method2 = aVar.f9410a;
        if (method2 == null || (method = aVar.f9411b) == null) {
            return null;
        }
        Object objInvoke = method2.invoke(member, null);
        if (objInvoke == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
        }
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            i10++;
            Object objInvoke2 = method.invoke(obj, null);
            if (objInvoke2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }

    public final void d(@os.m a aVar) {
        f9409b = aVar;
    }
}
