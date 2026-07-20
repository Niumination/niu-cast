package nf;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import li.g2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f8233b;

    public /* synthetic */ q(g2 g2Var, int i8) {
        this.f8232a = i8;
        this.f8233b = g2Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f8232a) {
            case 0:
                this.f8233b.h(null);
                break;
            default:
                this.f8233b.h(null);
                break;
        }
        return Unit.INSTANCE;
    }
}
