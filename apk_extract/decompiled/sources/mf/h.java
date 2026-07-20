package mf;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li.a0;
import li.b0;
import li.f0;
import li.i2;
import li.o1;
import li.r1;
import li.s;
import li.v0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8034c = AtomicIntegerFieldUpdater.newUpdater(h.class, "closed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f8035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f8036b;
    private volatile /* synthetic */ int closed;

    public h() {
        Intrinsics.checkNotNullParameter("ktor-cio", "engineName");
        this.closed = 0;
        final int i8 = 0;
        this.f8035a = LazyKt.lazy(new Function0(this) { // from class: mf.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f8033b;

            {
                this.f8033b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                h hVar = this.f8033b;
                switch (i8) {
                    case 0:
                        ((nf.e) hVar).f8209d.getClass();
                        v0 v0Var = v0.f7498a;
                        return si.e.f10118a;
                    default:
                        return CoroutineContext.Element.DefaultImpls.plus(new i2(null), new zg.i(b0.f7433a)).plus((a0) hVar.f8035a.getValue()).plus(new f0("ktor-cio-context"));
                }
            }
        });
        final int i9 = 1;
        this.f8036b = LazyKt.lazy(new Function0(this) { // from class: mf.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f8033b;

            {
                this.f8033b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                h hVar = this.f8033b;
                switch (i9) {
                    case 0:
                        ((nf.e) hVar).f8209d.getClass();
                        v0 v0Var = v0.f7498a;
                        return si.e.f10118a;
                    default:
                        return CoroutineContext.Element.DefaultImpls.plus(new i2(null), new zg.i(b0.f7433a)).plus((a0) hVar.f8035a.getValue()).plus(new f0("ktor-cio-context"));
                }
            }
        });
    }

    @Override // mf.f
    public Set V() {
        return SetsKt.emptySet();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (f8034c.compareAndSet(this, 0, 1)) {
            CoroutineContext.Element element = getCoroutineContext().get(o1.f7483a);
            s sVar = element instanceof s ? (s) element : null;
            if (sVar == null) {
                return;
            }
            ((r1) sVar).r0();
        }
    }

    @Override // li.g0
    public CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.f8036b.getValue();
    }
}
