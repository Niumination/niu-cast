package dc;

import android.app.Application;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnected;
import eb.y;
import k3.gc;
import k3.pb;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f4405b;

    public /* synthetic */ d(int i8, Function1 function1) {
        this.f4404a = i8;
        this.f4405b = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f4404a) {
            case 0:
                if (((Boolean) obj).booleanValue()) {
                    Intrinsics.checkNotNullParameter("EnvironmentCheckUtil", "tag");
                    Intrinsics.checkNotNullParameter("Continuing to connect", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("EnvironmentCheckUtil"), "Continuing to connect");
                    }
                    Application context = pb.a();
                    Function1 action = this.f4405b;
                    Intrinsics.checkNotNullParameter(action, "action");
                    Intrinsics.checkNotNullParameter(context, "context");
                    if (y.f4804h.compareTo((BaseState) new PhysicalConnected()) < 0) {
                        action.invoke(context);
                    } else {
                        g2 g2Var = g.f4407b;
                        if (g2Var != null) {
                            g2Var.h(null);
                        }
                        g.f4407b = l0.p(g.f4408c, null, null, new f(action, context, null), 3);
                    }
                }
                return Unit.INSTANCE;
            default:
                wi.a buffer = (wi.a) obj;
                Intrinsics.checkNotNullParameter(buffer, "buffer");
                while (true) {
                    Intrinsics.checkNotNullParameter(buffer, "<this>");
                    if (buffer.T()) {
                        return Boolean.TRUE;
                    }
                    this.f4405b.invoke(Byte.valueOf(buffer.readByte()));
                }
                break;
        }
    }
}
