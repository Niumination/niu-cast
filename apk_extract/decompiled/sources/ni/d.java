package ni;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8286c;

    public /* synthetic */ d(int i8, Object obj, Object obj2) {
        this.f8284a = i8;
        this.f8285b = obj;
        this.f8286c = obj2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f8284a) {
            case 0:
                qi.g.a((Function1) this.f8285b, this.f8286c, (CoroutineContext) obj3);
                break;
            default:
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = vi.c.f10595h;
                vi.b bVar = (vi.b) this.f8286c;
                Object obj4 = bVar.f10593b;
                vi.c cVar = (vi.c) this.f8285b;
                atomicReferenceFieldUpdater.set(cVar, obj4);
                cVar.e(bVar.f10593b);
                break;
        }
        return Unit.INSTANCE;
    }
}
