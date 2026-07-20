package ic;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ li.l f5737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f5738b;

    public j(li.l lVar, g2 g2Var) {
        this.f5737a = lVar;
        this.f5738b = g2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int iIntValue = ((Number) obj2).intValue();
        Intrinsics.checkNotNullParameter((NearDevice) obj, "<unused var>");
        na.a.b(this.f5737a, new hc.b(false, String.valueOf(iIntValue), null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_CURVE_FIT));
        this.f5738b.h(null);
        return Unit.INSTANCE;
    }
}
