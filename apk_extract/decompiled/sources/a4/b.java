package a4;

import android.animation.Animator;
import android.graphics.Canvas;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Bundle;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.Recorder;
import androidx.camera.view.CameraController;
import androidx.camera.view.RotationProvider;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwnerKt;
import b8.f;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.search.SearchBar;
import com.transsion.iotcardsdk.DeviceProviderService;
import com.transsion.iotcardsdk.IControlsActionCallback;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import com.transsion.iotservice.multiscreen.pc.ue.NFCTouchSelectorActivity;
import com.transsion.iotservice.multiscreen.pc.ui.BlankActivity;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionGuideDialog;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrConnectActivity;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanActivity;
import com.transsion.widgetPerGuide.perguide.PerGuideDialog;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import k3.gc;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import m3.g0;
import m3.n;
import m4.l;
import o.d;
import qg.y0;
import u6.e;
import x4.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements CanvasCompat.CanvasOperation, RotationProvider.Listener, AccessibilityManagerCompat.TouchExplorationStateChangeListener, AnimatableView.Listener, ActivityResultCallback, f, CallbackToFutureAdapter.Resolver, CameraCharacteristicsProvider, sh.a, ImageAnalysis.Analyzer, InputConnectionCompat.OnCommitContentListener, AccessibilityViewCommand, FragmentResultListener, SurfaceRequest.TransformationInfoListener, t, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f32a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f33b;

    public /* synthetic */ b(IControlsActionCallback iControlsActionCallback, DeviceProviderService deviceProviderService, String str) {
        this.f32a = 11;
        this.f33b = iControlsActionCallback;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(ImageProxy imageProxy) {
        ((ImageAnalysis.Analyzer) this.f33b).analyze(imageProxy);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        int i8 = this.f32a;
        Object obj = this.f33b;
        switch (i8) {
            case 7:
                return ((Camera2CameraControlImpl) obj).lambda$updateSessionConfigAsync$7(completer);
            case 8:
            case 9:
            case 11:
            case 13:
            default:
                return Futures.lambda$nonCancellationPropagating$0((l) obj, completer);
            case 10:
                return ((WaitForRepeatingRequestStart) obj).lambda$new$0(completer);
            case 12:
                return ((CameraX) obj).lambda$shutdownInternal$4(completer);
            case 14:
                return ((CameraRepository) obj).lambda$deinit$0(completer);
            case 15:
                return ((DeferrableSurface) obj).lambda$new$0(completer);
            case 16:
                return ((LiveDataObservable) obj).lambda$fetchData$1(completer);
        }
    }

    @Override // x4.t
    public Object construct() {
        int i8 = this.f32a;
        Object obj = this.f33b;
        switch (i8) {
            case 27:
                return x4.b.lambda$newDefaultConstructor$9((Constructor) obj);
            default:
                return x4.b.lambda$newUnsafeAllocator$19((Class) obj);
        }
    }

    @Override // b8.f
    public void d(float f) {
        int i8 = PerGuideDialog.f2974x;
        PerGuideDialog this$0 = (PerGuideDialog) this.f33b;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object value = this$0.f2975r.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mOsDamp>(...)");
        ((OSScrollbarLayout) value).e(f);
    }

    @Override // u6.e
    public void e(Object obj) {
        LongSparseArray longSparseArray = (LongSparseArray) obj;
        z6.a.e("saveMemCacheToDb tidCountArray = " + longSparseArray);
        ((ArrayList) this.f33b).clear();
        for (int i8 = 0; i8 < longSparseArray.size(); i8++) {
            long jKeyAt = longSparseArray.keyAt(i8);
            s6.a aVarE = m6.a.f().e(jKeyAt);
            if (aVarE != null) {
                aVarE.f9515c.f9525k = ((Integer) longSparseArray.valueAt(i8)).intValue();
                if ("device".equals(aVarE.f9514b) && 9999 == z6.b.a(jKeyAt)) {
                    n6.a aVar = m6.a.f().f7948a;
                    s6.e eVar = (s6.e) ((i1.b) aVar.f8123c).f5527a;
                    eVar.f9566j = g0.q(e8.b.f4712i);
                    eVar.f9565i = true;
                    ((o6.a) aVar.f8122b).h(((i1.b) aVar.f8123c).d());
                }
            }
        }
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider
    public Object get(CameraCharacteristics.Key key) {
        return ((CameraCharacteristicsCompat) this.f33b).get(key);
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        Runnable runnable;
        ActivityResultLauncher activityResultLauncher = null;
        Object obj2 = this.f33b;
        ActivityResult it = (ActivityResult) obj;
        switch (this.f32a) {
            case 4:
                int i8 = BaseSettingActivity.f2662k;
                Intrinsics.checkNotNullParameter(it, "it");
                String strO = d.o("permissionDialogLauncher result: ", it.getResultCode() == 10, "BaseSettingActivity", "tag", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("BaseSettingActivity"), strO);
                }
                if (it.getResultCode() == 10) {
                    String str = QrScanActivity.f2804c;
                    BaseSettingActivity baseSettingActivity = (BaseSettingActivity) obj2;
                    ActivityResultLauncher activityResultLauncher2 = baseSettingActivity.f2667i;
                    if (activityResultLauncher2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mQrPermissionDialogLauncher");
                    } else {
                        activityResultLauncher = activityResultLauncher2;
                    }
                    n.a(baseSettingActivity, "settings", activityResultLauncher, new y0(14));
                }
                break;
            case 18:
                int i9 = NFCTouchSelectorActivity.f2680b;
                Intrinsics.checkNotNullParameter(it, "it");
                NFCTouchSelectorActivity nFCTouchSelectorActivity = (NFCTouchSelectorActivity) obj2;
                if (it.getResultCode() != 10) {
                    nFCTouchSelectorActivity.j();
                } else {
                    Intrinsics.checkNotNullParameter("NFCTouchSelectorActivity1", "tag");
                    Intrinsics.checkNotNullParameter("mPermissionDialogLauncher:granted", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("NFCTouchSelectorActivity1"), "mPermissionDialogLauncher:granted");
                    }
                    nFCTouchSelectorActivity.init();
                }
                break;
            case 20:
                Runnable runnable2 = BlankActivity.f2696b;
                Intrinsics.checkNotNullParameter(it, "it");
                String strO2 = d.o("permissionDialogLauncher result: ", it.getResultCode() == 10, "BlankActivity", "tag", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("BlankActivity"), strO2);
                }
                if (it.getResultCode() == 10 && (runnable = BlankActivity.f2696b) != null) {
                    runnable.run();
                }
                ((BlankActivity) obj2).j();
                break;
            case 24:
                int i10 = PermissionGuideDialog.f2790l;
                Intrinsics.checkNotNullParameter(it, "it");
                String strO3 = d.o("result: ", it.getResultCode() == 10, "PermissionDialog", "tag", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("PermissionDialog"), strO3);
                }
                PermissionGuideDialog permissionGuideDialog = (PermissionGuideDialog) obj2;
                permissionGuideDialog.setResult(it.getResultCode());
                permissionGuideDialog.finish();
                break;
            default:
                int i11 = QrConnectActivity.f2797d;
                Intrinsics.checkNotNullParameter(it, "it");
                String strO4 = d.o("permission check result: ", it.getResultCode() == 10, "QrConnectActivity", "tag", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("QrConnectActivity"), strO4);
                }
                QrConnectActivity qrConnectActivity = (QrConnectActivity) obj2;
                if (it.getResultCode() != 10) {
                    qrConnectActivity.finish();
                } else {
                    l0.p(LifecycleOwnerKt.getLifecycleScope(qrConnectActivity), null, null, new wb.c(qrConnectActivity, null), 3);
                }
                break;
        }
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.f33b).start();
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i8, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.f33b, inputContentInfoCompat, i8, bundle);
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public void onFragmentResult(String str, Bundle bundle) {
        FragmentKt.m36setFragmentResultListener$lambda0((Function2) this.f33b, str, bundle);
    }

    @Override // androidx.camera.view.RotationProvider.Listener
    public void onRotationChanged(int i8) {
        ((CameraController) this.f33b).lambda$new$1(i8);
    }

    @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean z2) {
        ((SearchBar) this.f33b).lambda$new$0(z2);
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((Recorder) this.f33b).lambda$configureInternal$6(transformationInfo);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((BottomSheetDragHandleView) this.f33b).lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas canvas) {
        int i8 = this.f32a;
        Object obj = this.f33b;
        switch (i8) {
            case 0:
                ((NavigationView) obj).lambda$dispatchDraw$0(canvas);
                break;
            default:
                ((MaskableFrameLayout) obj).lambda$dispatchDraw$1(canvas);
                break;
        }
    }

    public /* synthetic */ b(Object obj, int i8) {
        this.f32a = i8;
        this.f33b = obj;
    }
}
