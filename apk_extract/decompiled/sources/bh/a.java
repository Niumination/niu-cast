package bh;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f1327b;

    public /* synthetic */ a(int i8, Function0 function0) {
        this.f1326a = i8;
        this.f1327b = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f1326a) {
            case 0:
                return this.f1327b.invoke();
            case 1:
                this.f1327b.invoke();
                return Unit.INSTANCE;
            default:
                mg.c ApplicationPluginImpl = (mg.c) obj;
                Intrinsics.checkNotNullParameter(ApplicationPluginImpl, "$this$ApplicationPluginImpl");
                return this.f1327b.invoke();
        }
    }
}
