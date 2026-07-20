package com.transsion.iotservice.multiscreen.pc.iotcard;

import android.app.Application;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.trassion.iotservice.startappserversdk.AbstractStartAppService;
import eb.y;
import k3.gc;
import k3.pb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import si.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/iotcard/PCConnectionStartService;", "Lcom/trassion/iotservice/startappserversdk/AbstractStartAppService;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PCConnectionStartService extends AbstractStartAppService {
    @Override // com.trassion.iotservice.startappserversdk.AbstractStartAppService
    public final void a() {
        Intrinsics.checkNotNullParameter("PCConnectionStartService", "tag");
        Intrinsics.checkNotNullParameter(" AppStartIotCardService connected", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PCConnectionStartService"), " AppStartIotCardService connected");
        }
    }

    @Override // com.trassion.iotservice.startappserversdk.AbstractStartAppService, android.app.Service
    public final void onCreate() {
        Intrinsics.checkNotNullParameter("PCConnectionStartService", "tag");
        Intrinsics.checkNotNullParameter("AppStartIotCardService onCreate", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PCConnectionStartService"), "AppStartIotCardService onCreate");
        }
        Application application = pb.a();
        Intrinsics.checkNotNullParameter(application, "application");
        l0.p(y.f4800b, e.f10118a, null, new db.e(application, null), 2);
    }
}
