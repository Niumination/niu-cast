package com.transsion.iotservice.multiscreen.pc.ui.permission;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb.c;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionDialog;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionViewModel;
import java.util.ArrayList;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ld.k;
import ld.m;
import ld.n;
import sb.a;
import sb.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/permission/PermissionDialog;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PermissionDialog extends BaseActivityDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function1 f2787d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PermissionViewModel f2788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f2789c;

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        PermissionViewModel permissionViewModel = null;
        ArrayList permissions = intent != null ? intent.getParcelableArrayListExtra("permissionList", Permission.class) : null;
        if (permissions == null) {
            finish();
            return;
        }
        PermissionViewModel permissionViewModel2 = (PermissionViewModel) this.f2695a.A(this, PermissionViewModel.class);
        permissionViewModel2.f2795c.observe(this, new c(new a(this, 6)));
        this.f2788b = permissionViewModel2;
        String from = getIntent().getStringExtra("from");
        if (from == null) {
            from = "ENTRY_CONTROL_CENTER";
        }
        PermissionViewModel permissionViewModel3 = this.f2788b;
        if (permissionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
        } else {
            permissionViewModel = permissionViewModel3;
        }
        permissionViewModel.getClass();
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(permissions, "<set-?>");
        permissionViewModel.f2796d = permissions;
        k kVar = new k(this);
        kVar.d(R$string.module_pc_connect);
        int i8 = R$string.permission_agree_all_permission;
        n nVar = kVar.f7400b;
        nVar.f7405d = nVar.f7402a.getText(i8);
        nVar.f7410k = false;
        nVar.f7411l = new l(this, 3);
        final int i9 = 0;
        kVar.c(getString(R$string.permission_go_to_setting), new DialogInterface.OnClickListener(this) { // from class: vb.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PermissionDialog f10540b;

            {
                this.f10540b = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                switch (i9) {
                    case 0:
                        PermissionDialog permissionDialog = this.f10540b;
                        PermissionViewModel permissionViewModel4 = permissionDialog.f2788b;
                        if (permissionViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                            permissionViewModel4 = null;
                        }
                        permissionViewModel4.getClass();
                        Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + permissionDialog.getPackageName()));
                        intent2.setFlags(268435456);
                        intent2.setFlags(32768);
                        permissionDialog.startActivity(intent2);
                        break;
                    default:
                        PermissionDialog permissionDialog2 = this.f10540b;
                        PermissionViewModel permissionViewModel5 = permissionDialog2.f2788b;
                        PermissionViewModel permissionViewModel6 = null;
                        if (permissionViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                            permissionViewModel5 = null;
                        }
                        if (Intrinsics.areEqual((Boolean) permissionViewModel5.f2795c.getValue(), Boolean.TRUE)) {
                            Intrinsics.checkNotNullParameter("PermissionDialog", "tag");
                            Intrinsics.checkNotNullParameter("closeDialog: all permission granted", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("PermissionDialog"), "closeDialog: all permission granted");
                            }
                            permissionDialog2.setResult(10);
                            Function1 function1 = PermissionDialog.f2787d;
                            if (function1 != null) {
                                function1.invoke(10);
                            }
                        } else {
                            Intrinsics.checkNotNullParameter("PermissionDialog", "tag");
                            Intrinsics.checkNotNullParameter("closeDialog: some permission denied", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("PermissionDialog"), "closeDialog: some permission denied");
                            }
                            permissionDialog2.setResult(20);
                            Function1 function2 = PermissionDialog.f2787d;
                            if (function2 != null) {
                                function2.invoke(20);
                            }
                        }
                        permissionDialog2.finishAndRemoveTask();
                        PermissionViewModel permissionViewModel7 = permissionDialog2.f2788b;
                        if (permissionViewModel7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                        } else {
                            permissionViewModel6 = permissionViewModel7;
                        }
                        permissionViewModel6.getClass();
                        break;
                }
            }
        });
        final int i10 = 1;
        kVar.b(getString(R$string.pc_module_botton_cancel), new DialogInterface.OnClickListener(this) { // from class: vb.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PermissionDialog f10540b;

            {
                this.f10540b = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                switch (i10) {
                    case 0:
                        PermissionDialog permissionDialog = this.f10540b;
                        PermissionViewModel permissionViewModel4 = permissionDialog.f2788b;
                        if (permissionViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                            permissionViewModel4 = null;
                        }
                        permissionViewModel4.getClass();
                        Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + permissionDialog.getPackageName()));
                        intent2.setFlags(268435456);
                        intent2.setFlags(32768);
                        permissionDialog.startActivity(intent2);
                        break;
                    default:
                        PermissionDialog permissionDialog2 = this.f10540b;
                        PermissionViewModel permissionViewModel5 = permissionDialog2.f2788b;
                        PermissionViewModel permissionViewModel6 = null;
                        if (permissionViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                            permissionViewModel5 = null;
                        }
                        if (Intrinsics.areEqual((Boolean) permissionViewModel5.f2795c.getValue(), Boolean.TRUE)) {
                            Intrinsics.checkNotNullParameter("PermissionDialog", "tag");
                            Intrinsics.checkNotNullParameter("closeDialog: all permission granted", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("PermissionDialog"), "closeDialog: all permission granted");
                            }
                            permissionDialog2.setResult(10);
                            Function1 function1 = PermissionDialog.f2787d;
                            if (function1 != null) {
                                function1.invoke(10);
                            }
                        } else {
                            Intrinsics.checkNotNullParameter("PermissionDialog", "tag");
                            Intrinsics.checkNotNullParameter("closeDialog: some permission denied", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("PermissionDialog"), "closeDialog: some permission denied");
                            }
                            permissionDialog2.setResult(20);
                            Function1 function2 = PermissionDialog.f2787d;
                            if (function2 != null) {
                                function2.invoke(20);
                            }
                        }
                        permissionDialog2.finishAndRemoveTask();
                        PermissionViewModel permissionViewModel7 = permissionDialog2.f2788b;
                        if (permissionViewModel7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
                        } else {
                            permissionViewModel6 = permissionViewModel7;
                        }
                        permissionViewModel6.getClass();
                        break;
                }
            }
        });
        this.f2789c = kVar.e();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        m mVar = this.f2789c;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionDialog");
            mVar = null;
        }
        mVar.dismiss();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        PermissionViewModel permissionViewModel = this.f2788b;
        m mVar = null;
        if (permissionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionViewModel");
            permissionViewModel = null;
        }
        permissionViewModel.b();
        m mVar2 = this.f2789c;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionDialog");
        } else {
            mVar = mVar2;
        }
        mVar.show();
    }
}
