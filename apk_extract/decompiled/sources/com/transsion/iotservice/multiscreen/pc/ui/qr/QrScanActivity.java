package com.transsion.iotservice.multiscreen.pc.ui.qr;

import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.base.arch.mvvm.DataBindingActivity;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityQrScanBinding;
import d6.q;
import k3.pb;
import k3.sb;
import k3.wb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m4.l;
import wb.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/qr/QrScanActivity;", "Lcom/transsion/base/arch/mvvm/DataBindingActivity;", "<init>", "()V", "m3/n", "wb/d", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class QrScanActivity extends DataBindingActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f2804c = "shortcut_center";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public QrScanViewModel f2805b;

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        QrScanViewModel qrScanViewModel;
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_qr_scan);
        ActivityQrScanBinding activityQrScanBinding = (ActivityQrScanBinding) contentView;
        QrScanViewModel qrScanViewModel2 = this.f2805b;
        if (qrScanViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrScanViewModel");
            qrScanViewModel2 = null;
        }
        activityQrScanBinding.e(qrScanViewModel2);
        activityQrScanBinding.d(new d(this));
        QrScanViewModel qrScanViewModel3 = this.f2805b;
        if (qrScanViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrScanViewModel");
            qrScanViewModel = null;
        } else {
            qrScanViewModel = qrScanViewModel3;
        }
        Preview.SurfaceProvider surfaceProvider = activityQrScanBinding.f2498d.getSurfaceProvider();
        Intrinsics.checkNotNullExpressionValue(surfaceProvider, "getSurfaceProvider(...)");
        qrScanViewModel.getClass();
        Intrinsics.checkNotNullParameter(surfaceProvider, "surfaceProvider");
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        l processCameraProvider = ProcessCameraProvider.getInstance(pb.a());
        Intrinsics.checkNotNullExpressionValue(processCameraProvider, "getInstance(...)");
        processCameraProvider.addListener(new q(11, qrScanViewModel, processCameraProvider, this, surfaceProvider), ContextCompat.getMainExecutor(pb.a()));
        ImageView ivQrScanLine = activityQrScanBinding.f2497c;
        Intrinsics.checkNotNullExpressionValue(ivQrScanLine, "ivQrScanLine");
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, wb.a(240.0f));
        translateAnimation.setDuration(2500L);
        translateAnimation.setRepeatMode(1);
        translateAnimation.setRepeatCount(-1);
        ivQrScanLine.startAnimation(translateAnimation);
        Intrinsics.checkNotNullExpressionValue(contentView, "apply(...)");
        return contentView;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final void k() {
        QrScanViewModel qrScanViewModel = (QrScanViewModel) this.f2329a.A(this, QrScanViewModel.class);
        qrScanViewModel.f2811h = new ag.a(this, 20);
        this.f2805b = qrScanViewModel;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intrinsics.checkNotNullParameter(this, "<this>");
        setRequestedOrientation((!sb.b() || na.d.a()) ? -1 : 1);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView().getRootView()).setAppearanceLightStatusBars(false);
        getWindow().setStatusBarColor(33554432);
        ob.b bVar = ob.b.f8417b;
        String entry = f2804c;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(entry, "entry");
        ob.b.e = entry;
        String entry2 = f2804c;
        Intrinsics.checkNotNullParameter(entry2, "entry");
        bVar.f8437a.u(entry2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        QrScanViewModel qrScanViewModel = this.f2805b;
        if (qrScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrScanViewModel");
            qrScanViewModel = null;
        }
        ProcessCameraProvider processCameraProvider = qrScanViewModel.e;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        QrScanViewModel qrScanViewModel = this.f2805b;
        if (qrScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrScanViewModel");
            qrScanViewModel = null;
        }
        qrScanViewModel.a();
    }
}
