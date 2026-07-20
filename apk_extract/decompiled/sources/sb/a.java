package sb;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.iotservice.multiscreen.pc.ui.gesture.GestureActivity;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionDialog;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionGuideDialog;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import java.util.Map;
import k3.gc;
import k3.vb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import se.b4;
import se.o3;
import se.s4;
import se.u4;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9600b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f9599a = i8;
        this.f9600b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9599a) {
            case 0:
                Boolean bool = (Boolean) obj;
                int i8 = CastControlDialog.f2710n;
                int i9 = na.c.a() ? R$drawable.cast_button_background_xos : R$drawable.cast_button_background_hios;
                LinearLayout linearLayout = (LinearLayout) this.f9600b;
                linearLayout.setBackgroundResource(i9);
                linearLayout.setEnabled(bool.booleanValue());
                return Unit.INSTANCE;
            case 1:
                NearDevice it = (NearDevice) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it, (NearDevice) this.f9600b));
            case 2:
                return Boolean.valueOf(Intrinsics.areEqual(((Pair) obj).getSecond(), (u4) this.f9600b));
            case 3:
                return Boolean.valueOf(Intrinsics.areEqual(((Pair) obj).getSecond(), (b4) this.f9600b));
            case 4:
                com.welink.protocol.nfbd.y yVar = (com.welink.protocol.nfbd.y) this.f9600b;
                TranConnectionController$MessageInfo msgInfo = (TranConnectionController$MessageInfo) obj;
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                synchronized (yVar.f4200n) {
                    yVar.f(new s4(yVar, msgInfo));
                }
                return Unit.INSTANCE;
            case 5:
                int i10 = GestureActivity.f2766d;
                Intrinsics.checkNotNullParameter((View) obj, "it");
                ((GestureActivity) this.f9600b).getOnBackPressedDispatcher().onBackPressed();
                return Unit.INSTANCE;
            case 6:
                Function1 function1 = PermissionDialog.f2787d;
                if (((Boolean) obj).booleanValue()) {
                    PermissionDialog permissionDialog = (PermissionDialog) this.f9600b;
                    permissionDialog.setResult(10);
                    Function1 function2 = PermissionDialog.f2787d;
                    if (function2 != null) {
                        function2.invoke(10);
                    }
                    permissionDialog.finishAndRemoveTask();
                }
                return Unit.INSTANCE;
            case 7:
                Boolean bool2 = (Boolean) obj;
                int i11 = PermissionGuideDialog.f2790l;
                Intrinsics.checkNotNullParameter("UserPermissionNotifyIsShow", "key");
                SharedPreferences sharedPreferences = vb.f6684a;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences = null;
                }
                if (sharedPreferences.getBoolean("UserPermissionNotifyIsShow", true)) {
                    return Unit.INSTANCE;
                }
                if (bool2.booleanValue()) {
                    PermissionGuideDialog permissionGuideDialog = (PermissionGuideDialog) this.f9600b;
                    permissionGuideDialog.setResult(10);
                    permissionGuideDialog.finishAndRemoveTask();
                }
                return Unit.INSTANCE;
            case 8:
                xg.k route = (xg.k) obj;
                Intrinsics.checkNotNullParameter(route, "$this$route");
                ((xg.u) route).t((o3) this.f9600b);
                return Unit.INSTANCE;
            case 9:
                if (((Boolean) obj).booleanValue()) {
                    BaseSearchFragment baseSearchFragment = (BaseSearchFragment) this.f9600b;
                    DeviceViewModel deviceViewModelE = baseSearchFragment.e();
                    deviceViewModelE.getClass();
                    Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
                    Intrinsics.checkNotNullParameter("click scan qr", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("DeviceViewModel"), "click scan qr");
                    }
                    deviceViewModelE.f2839d = true;
                    FragmentActivity fragmentActivityA = baseSearchFragment.a();
                    if (fragmentActivityA != null) {
                        fragmentActivityA.finishAndRemoveTask();
                    }
                }
                return Unit.INSTANCE;
            case 10:
                Intrinsics.checkNotNullParameter((mg.d) obj, "it");
                yg.r.f11223a.trace("Shutdown WebSockets due to application stop");
                ((yg.q) this.f9600b).e.r0();
                return Unit.INSTANCE;
            case 11:
                ((StringBuilder) this.f9600b).append(zf.d.g(((Byte) obj).byteValue()));
                return Unit.INSTANCE;
            case 12:
                return AbstractCollection.toString$lambda$2((AbstractCollection) this.f9600b, obj);
            default:
                return AbstractMap.toString$lambda$2((AbstractMap) this.f9600b, (Map.Entry) obj);
        }
    }
}
