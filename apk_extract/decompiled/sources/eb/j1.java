package eb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.CapabilitySocketConnected;
import com.transsion.iotservice.multiscreen.pc.state.MainSocketInit;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 implements Function1 {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            jc.a.b(this);
            y yVar = y.f4799a;
            BaseState baseState = y.f4804h;
            if (baseState.compareTo((BaseState) new MainSocketInit()) >= 0 && baseState.compareTo((BaseState) new CapabilitySocketConnected()) < 0 && Intrinsics.areEqual(k1.f4766b, "cable")) {
                Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
                Intrinsics.checkNotNullParameter("usb plug out when connected", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PhysicalConnectManager"), "usb plug out when connected");
                }
                y.m();
            }
        }
        return Unit.INSTANCE;
    }
}
