package com.transsion.iotservice.multiscreen.pc.iotcard;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotcardsdk.DeviceProviderService;
import com.transsion.iotcardsdk.SdkInit;
import com.transsion.iotcardsdk.bean.ControlAction;
import com.transsion.iotcardsdk.bean.DisplayTemplateBean;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import db.b;
import db.f;
import eb.k1;
import h0.a;
import java.util.ArrayList;
import java.util.List;
import k3.gc;
import k3.pb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.h0;
import li.l0;
import li.v0;
import qi.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/iotcard/PCConnectionProviderService;", "Lcom/transsion/iotcardsdk/DeviceProviderService;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PCConnectionProviderService extends DeviceProviderService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2670b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2671a = h0.a(v0.f7499b);

    public static void b() {
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        String str = cVar != null ? cVar.f5287b : null;
        String str2 = cVar != null ? cVar.f5288c : null;
        Integer numValueOf = cVar != null ? Integer.valueOf(cVar.f) : null;
        StringBuilder sbP = a.p("bean: ", str, ", ", str2, ", ");
        sbP.append(numValueOf);
        gc.c("PCConnectionProviderService", sbP.toString());
        DisplayTemplateBean displayTemplateBeanA = f.a(cVar);
        gc.c("PCConnectionProviderService", "iotCardTemplateBean: " + displayTemplateBeanA.getDataBundle());
        SdkInit.INSTANCE.registerDevice(pb.a(), displayTemplateBeanA);
    }

    public static void c() {
        DisplayTemplateBean displayTemplateBean = f.f4396b;
        if (displayTemplateBean != null) {
            String log = "<unRegisterDevice> " + displayTemplateBean;
            Intrinsics.checkNotNullParameter("PCConnectionProviderService", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCConnectionProviderService"), log);
            }
            SdkInit.INSTANCE.unregisterDevice(pb.a(), displayTemplateBean);
        }
    }

    @Override // com.transsion.iotcardsdk.DeviceProviderService
    public final List getRegisterDevices() {
        l0.p(this.f2671a, null, null, new b(this, null), 3);
        if (DeviceConnectState.INSTANCE.isConnected()) {
            b();
        } else {
            c();
        }
        return new ArrayList();
    }

    @Override // com.transsion.iotcardsdk.DeviceProviderService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        Intrinsics.checkNotNullParameter("PCConnectionProviderService", "tag");
        Intrinsics.checkNotNullParameter("onCreate", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCConnectionProviderService"), "onCreate");
        }
    }

    @Override // com.transsion.iotcardsdk.DeviceProviderService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        Intrinsics.checkNotNullParameter("PCConnectionProviderService", "tag");
        Intrinsics.checkNotNullParameter("<onDestroy>", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCConnectionProviderService"), "<onDestroy>");
        }
        h0.b(this.f2671a, null);
        c();
    }

    @Override // com.transsion.iotcardsdk.DeviceProviderService
    public final void performControlAction(String controlId, ControlAction action, sh.a consumer) {
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
    }
}
