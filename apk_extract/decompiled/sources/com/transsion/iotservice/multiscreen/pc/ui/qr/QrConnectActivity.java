package com.transsion.iotservice.multiscreen.pc.ui.qr;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.base.arch.mvvm.DataBindingActivity;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import k3.gc;
import k3.o1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/qr/QrConnectActivity;", "Lcom/transsion/base/arch/mvvm/DataBindingActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class QrConnectActivity extends DataBindingActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2797d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public QrConnectViewModel f2798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActivityResultLauncher f2799c;

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_qr_connect);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        return contentView;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final void k() {
        QrConnectViewModel qrConnectViewModel = (QrConnectViewModel) this.f2329a.A(this, QrConnectViewModel.class);
        qrConnectViewModel.f2802b = new wb.a(this, 1);
        qrConnectViewModel.d(getIntent());
        this.f2798b = qrConnectViewModel;
    }

    public final void l() {
        gc.c("QrConnectActivity", "connectWithPermissionCheck");
        QrConnectViewModel qrConnectViewModel = this.f2798b;
        ActivityResultLauncher activityResultLauncher = null;
        if (qrConnectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrConnectVM");
            qrConnectViewModel = null;
        }
        int i8 = qrConnectViewModel.f2803c;
        ActivityResultLauncher activityResultLauncher2 = this.f2799c;
        if (activityResultLauncher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionDialogLauncher");
            activityResultLauncher2 = null;
        }
        if (h.m(this, activityResultLauncher2, i8)) {
            gc.c("QrConnectActivity", "connectWithPermissionCheck: PermissionGuideDialog isShowPermissionGuide");
            return;
        }
        ActivityResultLauncher activityResultLauncher3 = this.f2799c;
        if (activityResultLauncher3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionDialogLauncher");
        } else {
            activityResultLauncher = activityResultLauncher3;
        }
        o1.d(this, activityResultLauncher, new wb.a(this, 0));
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2799c = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a4.b(this, 25));
        getWindow().setStatusBarColor(0);
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().addFlags(512);
        l();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        QrConnectViewModel qrConnectViewModel = this.f2798b;
        if (qrConnectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrConnectVM");
            qrConnectViewModel = null;
        }
        qrConnectViewModel.d(intent);
        l();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (getIntent() == null) {
            finish();
        }
    }
}
