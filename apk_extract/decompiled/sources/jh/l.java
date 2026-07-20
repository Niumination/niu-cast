package jh;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f6294b;

    public /* synthetic */ l(k kVar, int i8) {
        this.f6293a = i8;
        this.f6294b = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable th2 = (Throwable) obj;
        switch (this.f6293a) {
            case 0:
                if (th2 != null) {
                    this.f6294b.b(th2);
                }
                break;
            case 1:
                if (th2 != null) {
                    k kVar = this.f6294b;
                    if (!kVar.f()) {
                        kVar.b(th2);
                    }
                }
                break;
            case 2:
                if (th2 != null) {
                    k kVar2 = this.f6294b;
                    if (!kVar2.l()) {
                        kVar2.b(th2);
                    }
                }
                break;
            default:
                o0.a(this.f6294b, th2);
                break;
        }
        return Unit.INSTANCE;
    }
}
