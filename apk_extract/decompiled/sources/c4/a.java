package c4;

import android.view.View;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements AccessibilityViewCommand, CallbackToFutureAdapter.Resolver, SurfaceRequest.TransformationInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1428b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f1428b = obj;
        this.f1427a = i8;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((ExposureControl) this.f1428b).lambda$setExposureCompensationIndex$2(this.f1427a, completer);
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        SurfaceProcessorNode.lambda$setUpRotationUpdates$1((Collection) this.f1428b, this.f1427a, transformationInfo);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((SideSheetBehavior) this.f1428b).lambda$createAccessibilityViewCommandForState$2(this.f1427a, view, commandArguments);
    }
}
