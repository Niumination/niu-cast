package nk;

import java.lang.reflect.Method;
import kn.l0;
import kn.n0;
import lm.d1;
import lm.f0;
import lm.l2;
import nq.k1;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final lm.d0 f11506a = f0.b(C0295a.INSTANCE);

    /* JADX INFO: renamed from: nk.a$a, reason: collision with other inner class name */
    public static final class C0295a extends n0 implements jn.a<Method> {
        public static final C0295a INSTANCE = new C0295a();

        public C0295a() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final Method invoke() {
            try {
                return Class.forName("yl.g").getMethod("isParkingAllowed", null);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @xm.f(c = "io.ktor.http.content.BlockingBridgeKt$withBlockingAndRedispatch$2", f = "BlockingBridge.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ jn.l<um.d<? super l2>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.l<? super um.d<? super l2>, ? extends Object> lVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$block = lVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new b(this.$block, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                jn.l<um.d<? super l2>, Object> lVar = this.$block;
                this.label = 1;
                if (lVar.invoke(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final Method b() {
        return (Method) f11506a.getValue();
    }

    public static final boolean c() {
        boolean zG;
        Method methodB = b();
        if (methodB == null) {
            return false;
        }
        try {
            zG = l0.g(methodB.invoke(null, null), Boolean.TRUE);
        } catch (Throwable unused) {
            zG = false;
        }
        return zG;
    }

    @os.m
    public static final Object d(@os.l jn.l<? super um.d<? super l2>, ? extends Object> lVar, @os.l um.d<? super l2> dVar) throws Throwable {
        if (c()) {
            Object objInvoke = lVar.invoke(dVar);
            return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : l2.f10208a;
        }
        Object objE = e(lVar, dVar);
        return objE == wm.a.COROUTINE_SUSPENDED ? objE : l2.f10208a;
    }

    public static final Object e(jn.l<? super um.d<? super l2>, ? extends Object> lVar, um.d<? super l2> dVar) throws Throwable {
        Object objG = nq.k.g(k1.c(), new b(lVar, null), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }
}
