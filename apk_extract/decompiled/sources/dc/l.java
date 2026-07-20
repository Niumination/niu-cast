package dc;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.GestureHandleActivity;
import k3.gc;
import k3.pb;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4423b;

    public /* synthetic */ l(Object obj, int i8) {
        this.f4422a = i8;
        this.f4423b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0070  */
    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean z2;
        TCircleConfirmViewModel tCircleConfirmViewModel = null;
        Object obj = this.f4423b;
        switch (this.f4422a) {
            case 0:
                Function0 function0 = (Function0) obj;
                if (function0 != null) {
                    function0.invoke();
                }
                break;
            case 1:
                n.f4427a = null;
                ((bb.e) obj).invoke();
                break;
            default:
                ob.c cVar = TCircleConfirmDialog.f2756d;
                gc.c("TCircleConfirmDialog", "TCircle confirm dialog dismissed");
                TCircleConfirmDialog tCircleConfirmDialog = (TCircleConfirmDialog) obj;
                tCircleConfirmDialog.finishAndRemoveTask();
                if (GestureHandleActivity.f2816a) {
                    gc.a("TCircleConfirmDialog", "jumpToTCircle");
                    GestureHandleActivity.f2816a = false;
                    Settings.Global.putInt(pb.a().getContentResolver(), "multi_transfer_connection_way", 1);
                    try {
                        Intent intent = new Intent("com.transsion.iotcard.tCircle");
                        intent.setFlags(268435456);
                        intent.setPackage("com.transsion.iotcard");
                        TCircleConfirmViewModel tCircleConfirmViewModel2 = tCircleConfirmDialog.f2757b;
                        if (tCircleConfirmViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                            tCircleConfirmViewModel2 = null;
                        }
                        if (tCircleConfirmViewModel2.f2760b != 2) {
                            TCircleConfirmViewModel tCircleConfirmViewModel3 = tCircleConfirmDialog.f2757b;
                            if (tCircleConfirmViewModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                                tCircleConfirmViewModel3 = null;
                            }
                            if (tCircleConfirmViewModel3.f2760b != 3) {
                                TCircleConfirmViewModel tCircleConfirmViewModel4 = tCircleConfirmDialog.f2757b;
                                if (tCircleConfirmViewModel4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                                } else {
                                    tCircleConfirmViewModel = tCircleConfirmViewModel4;
                                }
                                z2 = tCircleConfirmViewModel.f2760b == 4;
                            }
                        }
                        gc.c("TCircleConfirmDialog", "jumpToTCircle: isGestureTransfer=" + z2);
                        intent.putExtra("extra_is_gesture_transfer", z2);
                        sj.a aVar = za.a.f11267b;
                        Application applicationA = pb.a();
                        UserHandle CURRENT = z8.a.f11265a;
                        Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
                        pb.d(aVar, applicationA, intent);
                    } catch (Exception e) {
                        String log = "jumpToTCircle: " + e;
                        Intrinsics.checkNotNullParameter("TCircleConfirmDialog", "tag");
                        Intrinsics.checkNotNullParameter(log, "log");
                        if (gc.f6462a <= 6) {
                            Log.e(gc.f6463b.concat("TCircleConfirmDialog"), log);
                        }
                        return;
                    }
                }
                break;
        }
    }
}
