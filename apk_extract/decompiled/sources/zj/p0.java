package zj;

import com.transsion.iotservice.multiscreen.pc.http.CloudInterface;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f11693a = k0.f11641b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f11694b = new Object[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q0 f11695c;

    public p0(q0 q0Var) {
        this.f11695c = q0Var;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        n nVarA;
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f11694b;
        }
        k0 k0Var = this.f11693a;
        k0Var.getClass();
        if (method.isDefault()) {
            Constructor constructor = k0Var.f11642a;
            return (constructor != null ? (MethodHandles.Lookup) constructor.newInstance(CloudInterface.class, -1) : MethodHandles.lookup()).unreflectSpecial(method, CloudInterface.class).bindTo(obj).invokeWithArguments(objArr);
        }
        q0 q0Var = this.f11695c;
        n nVar = (n) q0Var.f11696a.get(method);
        if (nVar == null) {
            synchronized (q0Var.f11696a) {
                try {
                    nVarA = (n) q0Var.f11696a.get(method);
                    if (nVarA == null) {
                        nVarA = n.a(q0Var, method);
                        q0Var.f11696a.put(method, nVarA);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            nVar = nVarA;
        }
        w wVar = new w(nVar.f11676a, objArr, nVar.f11677b, nVar.f11678c);
        switch (nVar.f11679d) {
            case 0:
                return nVar.e.k(wVar);
            case 1:
                c cVar = (c) nVar.e.k(wVar);
                Continuation continuation = (Continuation) objArr[objArr.length - 1];
                try {
                    li.l lVar = new li.l(1, IntrinsicsKt.intercepted(continuation));
                    lVar.v(new p(cVar));
                    cVar.g(new o5.c(lVar));
                    Object objR = lVar.r();
                    if (objR != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objR;
                    }
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                    return objR;
                } catch (Exception e) {
                    return s.o(e, continuation);
                }
            default:
                c cVar2 = (c) nVar.e.k(wVar);
                Continuation continuation2 = (Continuation) objArr[objArr.length - 1];
                try {
                    li.l lVar2 = new li.l(1, IntrinsicsKt.intercepted(continuation2));
                    lVar2.v(new q(cVar2));
                    cVar2.g(new se.e(lVar2, 24));
                    Object objR2 = lVar2.r();
                    if (objR2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objR2;
                    }
                    DebugProbesKt.probeCoroutineSuspended(continuation2);
                    return objR2;
                } catch (Exception e4) {
                    return s.o(e4, continuation2);
                }
        }
    }
}
