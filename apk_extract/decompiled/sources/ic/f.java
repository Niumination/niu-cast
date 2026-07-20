package ic;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import li.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f5730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f5731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ li.l f5732c;

    public f(Ref.ObjectRef objectRef, g2 g2Var, li.l lVar) {
        this.f5730a = objectRef;
        this.f5731b = g2Var;
        this.f5732c = lVar;
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [T, hc.b] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        Intrinsics.checkNotNullParameter((NearDevice) obj, "<unused var>");
        ?? bVar = new hc.b(false, "reject", null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_CURVE_FIT);
        Ref.ObjectRef objectRef = this.f5730a;
        objectRef.element = bVar;
        this.f5731b.h(null);
        na.a.b(this.f5732c, objectRef.element);
        return Unit.INSTANCE;
    }
}
