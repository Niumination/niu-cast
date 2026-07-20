package qq;

import in.n;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kn.l0;
import lm.c1;
import lm.d1;
import os.l;
import os.m;
import rq.g;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/* JADX INFO: loaded from: classes3.dex */
@b.a({"all"})
@is.a
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final b f14113a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f14114b;

    public static final class a implements ClassFileTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final a f14115a = new a();

        @m
        public byte[] a(@m ClassLoader classLoader, @l String str, @m Class<?> cls, @l ProtectionDomain protectionDomain, @m byte[] bArr) {
            if (classLoader == null || !l0.g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            rq.a.f14788a.getClass();
            rq.a.f14789b = true;
            return dn.b.p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    static {
        Object objM59constructorimpl;
        boolean zBooleanValue;
        try {
            c1.a aVar = c1.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            objM59constructorimpl = c1.m59constructorimpl(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
        }
        Boolean bool = (Boolean) (c1.m64isFailureimpl(objM59constructorimpl) ? null : objM59constructorimpl);
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            g.f14829a.getClass();
            zBooleanValue = g.f14835g;
        }
        f14114b = zBooleanValue;
    }

    public static final void c(Signal signal) {
        g gVar = g.f14829a;
        if (gVar.A()) {
            gVar.f(System.out);
        } else {
            System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @n
    public static final void d(@m String str, @l Instrumentation instrumentation) {
        rq.a.f14788a.b(true);
        instrumentation.addTransformer(a.f14115a);
        g gVar = g.f14829a;
        gVar.L(f14114b);
        gVar.y();
        f14113a.b();
    }

    public final void b() {
        try {
            Signal.handle(new Signal("TRAP"), new SignalHandler() { // from class: qq.a
                public final void a(Signal signal) {
                    b.c(signal);
                }
            });
        } catch (Throwable unused) {
        }
    }
}
