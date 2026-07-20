package mg;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u extends FunctionReferenceImpl implements Function2 {
    public static final u INSTANCE = new u();

    public u() {
        super(2, q.class, "<init>", "<init>(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelineContext;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final q invoke(Object pluginConfig, hh.f context) {
        Intrinsics.checkNotNullParameter(pluginConfig, "p0");
        Intrinsics.checkNotNullParameter(context, "p1");
        Intrinsics.checkNotNullParameter(pluginConfig, "pluginConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        return new q(pluginConfig, context);
    }
}
