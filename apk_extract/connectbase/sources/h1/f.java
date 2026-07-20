package h1;

import c1.z;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import q1.n0;

/* JADX INFO: loaded from: classes.dex */
@e
public class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f6938f = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f6940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f6941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f6942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f6943e;

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6944a = new a();

        public static Logger b(k context) {
            return Logger.getLogger(f.class.getName() + "." + context.b().f6939a);
        }

        public static String c(k context) {
            Method methodD = context.d();
            return "Exception thrown by subscriber method " + methodD.getName() + '(' + methodD.getParameterTypes()[0].getName() + ") on subscriber " + context.c() + " when dispatching event: " + context.a();
        }

        @Override // h1.l
        public void a(Throwable exception, k context) {
            Logger loggerB = b(context);
            Level level = Level.SEVERE;
            if (loggerB.isLoggable(level)) {
                loggerB.log(level, c(context), exception);
            }
        }
    }

    public f() {
        this(ks.c.f9460f);
    }

    public final Executor a() {
        return this.f6940b;
    }

    public void b(Throwable e10, k context) {
        e10.getClass();
        context.getClass();
        try {
            this.f6941c.a(e10, context);
        } catch (Throwable th2) {
            f6938f.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th2, e10), th2);
        }
    }

    public final String c() {
        return this.f6939a;
    }

    public void d(Object event) {
        Iterator<j> itF = this.f6942d.f(event);
        if (itF.hasNext()) {
            this.f6943e.a(event, itF);
        } else {
            if (event instanceof c) {
                return;
            }
            d(new c(this, event));
        }
    }

    public void e(Object object) {
        this.f6942d.h(object);
    }

    public void f(Object object) {
        this.f6942d.i(object);
    }

    public String toString() {
        z.b bVarC = z.c(this);
        bVarC.h().f1270b = this.f6939a;
        return bVarC.toString();
    }

    public f(String identifier, Executor executor, d dispatcher, l exceptionHandler) {
        this.f6942d = new m(this);
        identifier.getClass();
        this.f6939a = identifier;
        executor.getClass();
        this.f6940b = executor;
        dispatcher.getClass();
        this.f6943e = dispatcher;
        exceptionHandler.getClass();
        this.f6941c = exceptionHandler;
    }

    public f(l exceptionHandler) {
        this(ks.c.f9460f, n0.INSTANCE, new d.C0188d(), exceptionHandler);
    }

    public f(String identifier) {
        this(identifier, n0.INSTANCE, new d.C0188d(), a.f6944a);
    }
}
