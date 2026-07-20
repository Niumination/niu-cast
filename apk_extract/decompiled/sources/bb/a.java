package bb;

import android.content.Context;
import com.transsion.iotservice.multiscreen.pc.helper.BaseIconService;
import com.transsion.iotservice.multiscreen.pc.ui.BlankActivity;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import java.util.ArrayList;
import k3.gc;
import k3.o1;
import k3.oc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseIconService f1228b;

    public /* synthetic */ a(BaseIconService baseIconService, int i8) {
        this.f1227a = i8;
        this.f1228b = baseIconService;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        BaseIconService baseIconService = this.f1228b;
        switch (this.f1227a) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i8 = BaseIconService.f2659c;
                baseIconService.b(zBooleanValue);
                break;
            default:
                Context it = (Context) obj;
                int i9 = BaseIconService.f2659c;
                Intrinsics.checkNotNullParameter(it, "it");
                baseIconService.getClass();
                gc.c("BaseIconService", "executeCheckEnvironment");
                if (jb.f.f6135a.b()) {
                    int i10 = FunctionGuideActivity.f2774o;
                    se.d.c(it, 1);
                } else {
                    gc.c("BaseIconService", "openWithPermissionsCheck");
                    ArrayList arrayListA = o1.a(baseIconService, baseIconService.a());
                    gc.c("BaseIconService", "notGrantedPermission:" + arrayListA);
                    Runnable runnable = BlankActivity.f2696b;
                    oc.a(it, arrayListA, 0, new a4.c(baseIconService, 8));
                    ob.b.f8417b.getClass();
                    ob.b.F = "shortcut_open_click";
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
