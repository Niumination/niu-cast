package hf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;
import ze.p1;
import ze.q2;
import ze.r1;
import ze.r2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5317a = Logger.getLogger(n.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f5318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ze.e f5319c;

    static {
        f5318b = !h4.q.a(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f5319c = new ze.e("internal-stub-type");
    }

    public static void a(ze.j jVar, GeneratedMessageLite generatedMessageLite, v vVar) {
        v8.i(vVar, "responseObserver");
        b(jVar, generatedMessageLite, new k(vVar, new h(jVar, false)));
    }

    public static void b(ze.j jVar, GeneratedMessageLite generatedMessageLite, j jVar2) {
        jVar.f(jVar2, new p1());
        jVar2.n();
        try {
            jVar.e(generatedMessageLite);
            jVar.b();
        } catch (Error e) {
            d(jVar, e);
            throw null;
        } catch (RuntimeException e4) {
            d(jVar, e4);
            throw null;
        }
    }

    public static Object c(ze.g gVar, r1 r1Var, ze.f fVar, GeneratedMessageLite generatedMessageLite) throws Throwable {
        m mVar = new m();
        ze.d dVarB = ze.f.b(fVar.e(f5319c, l.BLOCKING));
        dVarB.f11336b = mVar;
        ze.j jVarE = gVar.e(r1Var, new ze.f(dVarB));
        boolean z2 = false;
        try {
            try {
                i iVarE = e(jVarE, generatedMessageLite);
                while (!iVarE.isDone()) {
                    try {
                        mVar.waitAndDrain();
                    } catch (InterruptedException e) {
                        try {
                            jVarE.a("Thread interrupted", e);
                            z2 = true;
                        } catch (Error e4) {
                            e = e4;
                            d(jVarE, e);
                            throw null;
                        } catch (RuntimeException e10) {
                            e = e10;
                            d(jVarE, e);
                            throw null;
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = true;
                            if (z2) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                mVar.shutdown();
                Object objF = f(iVarE);
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                return objF;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Error e11) {
            e = e11;
        } catch (RuntimeException e12) {
            e = e12;
        }
    }

    public static void d(ze.j jVar, Throwable th2) {
        try {
            jVar.a(null, th2);
        } catch (Throwable th3) {
            f5317a.log(Level.SEVERE, "RuntimeException encountered while closing call", th3);
        }
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (!(th2 instanceof Error)) {
            throw new AssertionError(th2);
        }
        throw ((Error) th2);
    }

    public static i e(ze.j jVar, GeneratedMessageLite generatedMessageLite) {
        i iVar = new i(jVar);
        b(jVar, generatedMessageLite, new k(iVar));
        return iVar;
    }

    public static Object f(i iVar) {
        try {
            return iVar.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new s2(q2.f.h("Thread interrupted").g(e));
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            v8.i(cause, "t");
            for (Throwable cause2 = cause; cause2 != null; cause2 = cause2.getCause()) {
                if (cause2 instanceof r2) {
                    r2 r2Var = (r2) cause2;
                    throw new s2(r2Var.getStatus(), r2Var.getTrailers());
                }
                if (cause2 instanceof s2) {
                    s2 s2Var = (s2) cause2;
                    throw new s2(s2Var.getStatus(), s2Var.getTrailers());
                }
            }
            throw new s2(q2.f11404g.h("unexpected exception").g(cause));
        }
    }
}
