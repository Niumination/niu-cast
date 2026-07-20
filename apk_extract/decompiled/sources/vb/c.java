package vb;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionGuideDialog;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionViewModel;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetContainer;
import java.util.ArrayList;
import k3.gc;
import k3.o1;
import k3.vb;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionGuideDialog f10543a;

    public c(PermissionGuideDialog permissionGuideDialog) {
        this.f10543a = permissionGuideDialog;
    }

    public final void a() {
        final int i8 = 0;
        ob.b.f8417b.f8437a.getClass();
        w.X("iot_multi_con_permissionpage_next_cl", w.D());
        Intrinsics.checkNotNullParameter("UserPermissionNotifyIsShow", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        ArrayList arrayList = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("UserPermissionNotifyIsShow", false);
        editorEdit.apply();
        final PermissionGuideDialog permissionGuideDialog = this.f10543a;
        PermissionViewModel permissionViewModel = permissionGuideDialog.f2792k;
        if (permissionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
            permissionViewModel = null;
        }
        if (Intrinsics.areEqual(permissionViewModel.f2795c.getValue(), Boolean.TRUE)) {
            permissionGuideDialog.setResult(10);
            int i9 = PermissionGuideDialog.f2790l;
            permissionGuideDialog.finish();
            return;
        }
        OSBottomSheetContainer oSBottomSheetContainer = permissionGuideDialog.o().f3024a;
        Intrinsics.checkNotNullExpressionValue(oSBottomSheetContainer, "mContainerViewBinding.root");
        oSBottomSheetContainer.setVisibility(4);
        PermissionViewModel permissionViewModel2 = permissionGuideDialog.f2792k;
        if (permissionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
            permissionViewModel2 = null;
        }
        ArrayList arrayList2 = permissionViewModel2.f2796d;
        if (arrayList2 != null) {
            arrayList = arrayList2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
        }
        final int i10 = 1;
        o1.c(permissionGuideDialog, arrayList, "scanPermissions", new Function0() { // from class: vb.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PermissionGuideDialog permissionGuideDialog2 = permissionGuideDialog;
                switch (i8) {
                    case 0:
                        permissionGuideDialog2.setResult(10);
                        int i11 = PermissionGuideDialog.f2790l;
                        permissionGuideDialog2.finishAndRemoveTask();
                        break;
                    default:
                        Intrinsics.checkNotNullParameter("PermissionDialog", "tag");
                        Intrinsics.checkNotNullParameter("Permission not granted", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("PermissionDialog"), "Permission not granted");
                        }
                        PermissionViewModel permissionViewModel3 = permissionGuideDialog2.f2792k;
                        if (permissionViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                            permissionViewModel3 = null;
                        }
                        ArrayList arrayList3 = permissionViewModel3.f2796d;
                        if (arrayList3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
                            arrayList3 = null;
                        }
                        ActivityResultLauncher activityResultLauncher = permissionGuideDialog2.f2791j;
                        if (activityResultLauncher == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionDialogLauncher");
                            activityResultLauncher = null;
                        }
                        o1.b(permissionGuideDialog2, arrayList3, activityResultLauncher, null, "PermissionDialog");
                        break;
                }
                return Unit.INSTANCE;
            }
        }, new Function0() { // from class: vb.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PermissionGuideDialog permissionGuideDialog2 = permissionGuideDialog;
                switch (i10) {
                    case 0:
                        permissionGuideDialog2.setResult(10);
                        int i11 = PermissionGuideDialog.f2790l;
                        permissionGuideDialog2.finishAndRemoveTask();
                        break;
                    default:
                        Intrinsics.checkNotNullParameter("PermissionDialog", "tag");
                        Intrinsics.checkNotNullParameter("Permission not granted", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("PermissionDialog"), "Permission not granted");
                        }
                        PermissionViewModel permissionViewModel3 = permissionGuideDialog2.f2792k;
                        if (permissionViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                            permissionViewModel3 = null;
                        }
                        ArrayList arrayList3 = permissionViewModel3.f2796d;
                        if (arrayList3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
                            arrayList3 = null;
                        }
                        ActivityResultLauncher activityResultLauncher = permissionGuideDialog2.f2791j;
                        if (activityResultLauncher == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionDialogLauncher");
                            activityResultLauncher = null;
                        }
                        o1.b(permissionGuideDialog2, arrayList3, activityResultLauncher, null, "PermissionDialog");
                        break;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void b() {
        int i8 = PermissionGuideDialog.f2790l;
        PermissionGuideDialog permissionGuideDialog = this.f10543a;
        permissionGuideDialog.getClass();
        Intrinsics.checkNotNullParameter("PermissionDialog", "tag");
        Intrinsics.checkNotNullParameter("show permission guide close", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PermissionDialog"), "show permission guide close");
        }
        permissionGuideDialog.setResult(20);
        permissionGuideDialog.finish();
        PermissionViewModel permissionViewModel = permissionGuideDialog.f2792k;
        if (permissionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
            permissionViewModel = null;
        }
        permissionViewModel.getClass();
    }
}
