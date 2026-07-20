package com.transsion.iotservice.multiscreen.pc.ui.permission;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import bb.c;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogPermissionGuideBinding;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetContainer;
import java.util.ArrayList;
import k3.gc;
import k3.vb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sb.a;
import va.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/permission/PermissionGuideDialog;", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog;", "<init>", "()V", "se/h", "vb/c", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PermissionGuideDialog extends OSBaseBottomSheetDialog {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f2790l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ActivityResultLauncher f2791j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PermissionViewModel f2792k;

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean m() {
        return false;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        b.g(this);
        super.onCreate(bundle);
        Intrinsics.checkNotNullParameter(this, "activity");
        Intrinsics.checkNotNullParameter(PermissionViewModel.class, "modelClass");
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        Intrinsics.checkNotNull(viewModelProvider);
        PermissionViewModel permissionViewModel = (PermissionViewModel) viewModelProvider.get(PermissionViewModel.class);
        permissionViewModel.f2795c.observe(this, new c(new a(this, 7), (byte) 0));
        this.f2792k = permissionViewModel;
        Intent intent = getIntent();
        PermissionViewModel permissionViewModel2 = null;
        ArrayList permissions = intent != null ? intent.getParcelableArrayListExtra("permissionList", Permission.class) : null;
        f2790l = getIntent().getIntExtra("businessType", 0);
        if (permissions == null) {
            finish();
            return;
        }
        LayoutInflater layoutInflater = getLayoutInflater();
        int i8 = DialogPermissionGuideBinding.f2537k;
        DialogPermissionGuideBinding dialogPermissionGuideBinding = (DialogPermissionGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.dialog_permission_guide, null, false, DataBindingUtil.getDefaultComponent());
        dialogPermissionGuideBinding.setLifecycleOwner(this);
        PermissionViewModel permissionViewModel3 = this.f2792k;
        if (permissionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
            permissionViewModel3 = null;
        }
        dialogPermissionGuideBinding.e(permissionViewModel3);
        dialogPermissionGuideBinding.d(new vb.c(this));
        int i9 = R$string.md_multi_connect;
        View root = dialogPermissionGuideBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        j(root).e(i9);
        Intrinsics.checkNotNullParameter("UserPermissionNotifyIsShow", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        if (!sharedPreferences.getBoolean("UserPermissionNotifyIsShow", true)) {
            OSBottomSheetContainer oSBottomSheetContainer = o().f3024a;
            Intrinsics.checkNotNullExpressionValue(oSBottomSheetContainer, "mContainerViewBinding.root");
            oSBottomSheetContainer.setVisibility(4);
        }
        s(false);
        t(false);
        String from = getIntent().getStringExtra("from");
        if (from == null) {
            from = "ENTRY_CONTROL_CENTER";
        }
        PermissionViewModel permissionViewModel4 = this.f2792k;
        if (permissionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
            permissionViewModel4 = null;
        }
        int i10 = f2790l;
        permissionViewModel4.getClass();
        String log = "setBusinessType: " + i10;
        Intrinsics.checkNotNullParameter("PermissionViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PermissionViewModel"), log);
        }
        permissionViewModel4.f.setValue(Integer.valueOf(i10));
        PermissionViewModel permissionViewModel5 = this.f2792k;
        if (permissionViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
        } else {
            permissionViewModel2 = permissionViewModel5;
        }
        permissionViewModel2.getClass();
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(permissions, "<set-?>");
        permissionViewModel2.f2796d = permissions;
        this.f2791j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a4.b(this, 24));
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        String triggerScene = ob.b.F;
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        bVar.f8437a.R(triggerScene);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        PermissionViewModel permissionViewModel = this.f2792k;
        if (permissionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
            permissionViewModel = null;
        }
        permissionViewModel.b();
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean p() {
        return false;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final void q() {
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean u() {
        return false;
    }
}
