package ao;

import java.util.ServiceLoader;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import lm.h0;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final C0016a f516a = C0016a.f517a;

    /* JADX INFO: renamed from: ao.a$a, reason: collision with other inner class name */
    public static final class C0016a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0016a f517a = new C0016a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final d0<a> f518b = f0.c(h0.PUBLICATION, C0017a.INSTANCE);

        /* JADX INFO: renamed from: ao.a$a$a, reason: collision with other inner class name */
        public static final class C0017a extends n0 implements jn.a<a> {
            public static final C0017a INSTANCE = new C0017a();

            public C0017a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final a invoke() {
                ServiceLoader serviceLoaderLoad = ServiceLoader.load(a.class, a.class.getClassLoader());
                l0.o(serviceLoaderLoad, "implementations");
                a aVar = (a) nm.h0.E2(serviceLoaderLoad);
                if (aVar != null) {
                    return aVar;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        @os.l
        public final a a() {
            return f518b.getValue();
        }
    }

    @os.l
    eo.l0 a(@os.l up.n nVar, @os.l eo.h0 h0Var, @os.l Iterable<? extends go.b> iterable, @os.l go.c cVar, @os.l go.a aVar, boolean z10);
}
