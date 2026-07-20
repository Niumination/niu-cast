package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import ag.a;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.databinding.DataBindingUtil;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogPcRequestConnectBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchActivity;
import eb.y0;
import java.util.List;
import k3.pb;
import k3.ub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld.m;
import ld.n;
import na.k;
import sb.l;
import sb.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/PcRequestConnectDialog;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PcRequestConnectDialog extends BaseActivityDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f2742h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PcRequestConnectViewModel f2743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogPcRequestConnectBinding f2744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f2745d;
    public final q e = new q(this, 0);

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        Intrinsics.checkNotNullParameter(window, "window");
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(window.getDecorView());
        if (windowInsetsController != null) {
            windowInsetsController.setAppearanceLightStatusBars(false);
        }
        if (windowInsetsController != null) {
            windowInsetsController.setAppearanceLightNavigationBars(false);
        }
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setDecorFitsSystemWindows(false);
        super.onCreate(bundle);
        PcRequestConnectViewModel pcRequestConnectViewModel = (PcRequestConnectViewModel) this.f2695a.A(this, PcRequestConnectViewModel.class);
        pcRequestConnectViewModel.getClass();
        if (ub.b()) {
            k kVar = k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getResources().getString(R$string.module_pc_close_hotspot_conn_toast);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.d(applicationA, string);
            y0.b("PcRequestConnectViewModel:isEnvOk");
            finishAndRemoveTask();
        } else {
            if (y0.e) {
                y0.f4816d.observeForever(this.e);
            }
            pcRequestConnectViewModel.f = new a(this, 15);
            pcRequestConnectViewModel.a(getIntent());
            this.f2743b = pcRequestConnectViewModel;
        }
        DialogPcRequestConnectBinding dialogPcRequestConnectBinding = null;
        DialogPcRequestConnectBinding dialogPcRequestConnectBinding2 = (DialogPcRequestConnectBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R$layout.dialog_pc_request_connect, null, false);
        PcRequestConnectViewModel pcRequestConnectViewModel2 = this.f2743b;
        if (pcRequestConnectViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
            pcRequestConnectViewModel2 = null;
        }
        dialogPcRequestConnectBinding2.d(pcRequestConnectViewModel2);
        dialogPcRequestConnectBinding2.setLifecycleOwner(this);
        PcRequestConnectViewModel pcRequestConnectViewModel3 = this.f2743b;
        if (pcRequestConnectViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
            pcRequestConnectViewModel3 = null;
        }
        pcRequestConnectViewModel3.getClass();
        Object systemService = pb.a().getSystemService(AtomicIntentType.ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
        Intrinsics.checkNotNullExpressionValue(appTasks, "getAppTasks(...)");
        for (ActivityManager.AppTask appTask : appTasks) {
            ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
            ComponentName componentName = taskInfo.topActivity;
            if (Intrinsics.areEqual(componentName != null ? componentName.getClassName() : null, SearchActivity.class.getName()) || (!taskInfo.isRunning && taskInfo.numActivities == 0)) {
                appTask.finishAndRemoveTask();
            }
        }
        this.f2744c = dialogPcRequestConnectBinding2;
        ld.k kVar2 = new ld.k(this);
        DialogPcRequestConnectBinding dialogPcRequestConnectBinding3 = this.f2744c;
        if (dialogPcRequestConnectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogPcRequestConnectBinding = dialogPcRequestConnectBinding3;
        }
        View root = dialogPcRequestConnectBinding.getRoot();
        n nVar = kVar2.f7400b;
        nVar.f7413n = root;
        nVar.f7410k = false;
        nVar.f7411l = new l(this, 1);
        final int i8 = 0;
        kVar2.c(getString(com.transsion.widgetslib.R$string.os_preference_dialog_positive_string), new DialogInterface.OnClickListener(this) { // from class: sb.r

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PcRequestConnectDialog f9624b;

            {
                this.f9624b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                switch (i8) {
                    case 0:
                        PcRequestConnectDialog pcRequestConnectDialog = this.f9624b;
                        PcRequestConnectViewModel pcRequestConnectViewModel4 = pcRequestConnectDialog.f2743b;
                        if (pcRequestConnectViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
                            pcRequestConnectViewModel4 = null;
                        }
                        pcRequestConnectViewModel4.b(1);
                        pcRequestConnectDialog.finishAndRemoveTask();
                        break;
                    default:
                        PcRequestConnectViewModel pcRequestConnectViewModel5 = this.f9624b.f2743b;
                        if (pcRequestConnectViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
                            pcRequestConnectViewModel5 = null;
                        }
                        pcRequestConnectViewModel5.b(2);
                        break;
                }
            }
        });
        final int i9 = 1;
        kVar2.b(getString(com.transsion.widgetslib.R$string.os_preference_dialog_negative_string), new DialogInterface.OnClickListener(this) { // from class: sb.r

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PcRequestConnectDialog f9624b;

            {
                this.f9624b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                switch (i9) {
                    case 0:
                        PcRequestConnectDialog pcRequestConnectDialog = this.f9624b;
                        PcRequestConnectViewModel pcRequestConnectViewModel4 = pcRequestConnectDialog.f2743b;
                        if (pcRequestConnectViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
                            pcRequestConnectViewModel4 = null;
                        }
                        pcRequestConnectViewModel4.b(1);
                        pcRequestConnectDialog.finishAndRemoveTask();
                        break;
                    default:
                        PcRequestConnectViewModel pcRequestConnectViewModel5 = this.f9624b.f2743b;
                        if (pcRequestConnectViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
                            pcRequestConnectViewModel5 = null;
                        }
                        pcRequestConnectViewModel5.b(2);
                        break;
                }
            }
        });
        this.f2745d = kVar2.e();
        if (this.f2744c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        m mVar = this.f2745d;
        if (mVar != null) {
            mVar.dismiss();
        }
        y0.f4816d.removeObserver(this.e);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        PcRequestConnectViewModel pcRequestConnectViewModel = this.f2743b;
        if (pcRequestConnectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
            pcRequestConnectViewModel = null;
        }
        pcRequestConnectViewModel.a(intent);
    }
}
