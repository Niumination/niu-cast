package nq;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,110:1\n75#2:111\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n38#1:111\n*E\n"})
public final class p0 {

    @kn.r1({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class a extends um.a implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p<um.g, Throwable, lm.l2> f11891a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.p<? super um.g, ? super Throwable, lm.l2> pVar, o0.b bVar) {
            super(bVar);
            this.f11891a = pVar;
        }

        @Override // nq.o0
        public void g0(@os.l um.g gVar, @os.l Throwable th2) {
            this.f11891a.invoke(gVar, th2);
        }
    }

    @os.l
    public static final o0 a(@os.l jn.p<? super um.g, ? super Throwable, lm.l2> pVar) {
        return new a(pVar, o0.f11887j);
    }

    @g2
    public static final void b(@os.l um.g gVar, @os.l Throwable th2) {
        try {
            o0 o0Var = (o0) gVar.get(o0.f11887j);
            if (o0Var != null) {
                o0Var.g0(gVar, th2);
            } else {
                vq.j.a(gVar, th2);
            }
        } catch (Throwable th3) {
            vq.j.a(gVar, c(th2, th3));
        }
    }

    @os.l
    public static final Throwable c(@os.l Throwable th2, @os.l Throwable th3) throws IllegalAccessException, InvocationTargetException {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        lm.p.a(runtimeException, th2);
        return runtimeException;
    }
}
