package xj;

import androidx.core.app.NotificationCompat;
import ik.y0;
import kn.l0;
import kn.r1;
import os.l;
import vj.k2;
import vj.m2;
import vj.o2;
import vj.v1;
import vj.w;
import vj.y2;
import vj.z2;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nCoroutineContextServerInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextServerInterceptor.kt\nio/grpc/kotlin/CoroutineContextServerInterceptor\n*L\n1#1,67:1\n44#1,6:68\n*S KotlinDebug\n*F\n+ 1 CoroutineContextServerInterceptor.kt\nio/grpc/kotlin/CoroutineContextServerInterceptor\n*L\n63#1:68,6\n*E\n"})
public abstract class d implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f20252a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final w.k<um.g> f20253b;

    public static final class a {
        public a() {
        }

        public final w b(w wVar, um.g gVar) {
            Object objB = d.f20253b.b(wVar);
            l0.o(objB, "COROUTINE_CONTEXT_KEY[this]");
            w wVarV0 = wVar.v0(d.f20253b, ((um.g) objB).plus(gVar));
            l0.o(wVarV0, "withValue(COROUTINE_CONT…KEY, newCoroutineContext)");
            return wVarV0;
        }

        @l
        public final w.k<um.g> c() {
            return d.f20253b;
        }

        public a(kn.w wVar) {
        }
    }

    static {
        w.k<um.g> kVarE0 = w.e0("grpc-kotlin-coroutine-context", um.i.INSTANCE);
        l0.o(kVarE0, "keyWithDefault(\"grpc-kot…\", EmptyCoroutineContext)");
        f20253b = kVarE0;
    }

    @Override // vj.o2
    @l
    public final <ReqT, RespT> k2.a<ReqT> a(@l k2<ReqT, RespT> k2Var, @l v1 v1Var, @l m2<ReqT, RespT> m2Var) throws z2 {
        l0.p(k2Var, NotificationCompat.CATEGORY_CALL);
        l0.p(v1Var, "headers");
        l0.p(m2Var, y0.b.f8223h);
        try {
            um.g gVarC = c(k2Var, v1Var);
            a aVar = f20252a;
            w wVarO = w.o();
            l0.o(wVarO, "current()");
            w wVarB = aVar.b(wVarO, gVarC);
            w wVarC = wVarB.c();
            l0.o(wVarC, "context.attach()");
            try {
                k2.a<ReqT> aVarA = m2Var.a(k2Var, v1Var);
                wVarB.q(wVarC);
                l0.o(aVarA, "withGrpcContext(GrpcCont…Call(call, headers)\n    }");
                return aVarA;
            } catch (Throwable th2) {
                wVarB.q(wVarC);
                throw th2;
            }
        } catch (z2 e10) {
            y2 status = e10.getStatus();
            v1 trailers = e10.getTrailers();
            if (trailers == null) {
                trailers = new v1();
            }
            k2Var.a(status, trailers);
            throw e10;
        }
    }

    @l
    public abstract um.g c(@l k2<?, ?> k2Var, @l v1 v1Var);

    public final <R> R d(w wVar, jn.a<? extends R> aVar) {
        w wVarC = wVar.c();
        l0.o(wVarC, "context.attach()");
        try {
            return aVar.invoke();
        } finally {
            wVar.q(wVarC);
        }
    }
}
