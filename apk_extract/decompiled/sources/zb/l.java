package zb;

import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.ConnectingFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.FailOrRefuseFragment;
import java.util.ArrayList;
import k3.pb;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11274a;

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f11274a) {
            case 0:
                return new FailOrRefuseFragment();
            case 1:
                return new ConnectingFragment();
            case 2:
                String string = pb.a().getString(R$string.module_pc_search_bottom_hint1);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = pb.a().getString(R$string.module_pc_search_bottom_hint2);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return o.d.l(string, "\n", o.d.q(new Object[]{pb.a().getString(R$string.pc_module_qrscan_connect)}, 1, string2, "format(...)"));
            case 3:
                return new ArrayList();
            default:
                return new ArrayList();
        }
    }
}
