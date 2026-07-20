package xm;

import java.lang.reflect.Method;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final i f20294a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f20295b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public static a f20296c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        @in.f
        public final Method f20297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        @in.f
        public final Method f20298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        @in.f
        public final Method f20299c;

        public a(@os.m Method method, @os.m Method method2, @os.m Method method3) {
            this.f20297a = method;
            this.f20298b = method2;
            this.f20299c = method3;
        }
    }

    public final a a(xm.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", null), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f20296c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f20295b;
            f20296c = aVar3;
            return aVar3;
        }
    }

    @os.m
    public final String b(@os.l xm.a aVar) {
        l0.p(aVar, "continuation");
        a aVarA = f20296c;
        if (aVarA == null) {
            aVarA = a(aVar);
        }
        if (aVarA == f20295b) {
            return null;
        }
        Method method = aVarA.f20297a;
        Object objInvoke = method != null ? method.invoke(aVar.getClass(), null) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarA.f20298b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarA.f20299c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
