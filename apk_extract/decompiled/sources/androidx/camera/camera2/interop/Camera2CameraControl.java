package androidx.camera.camera2.interop;

import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import l.a;
import l.b;
import l.c;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@ExperimentalCamera2Interop
public final class Camera2CameraControl {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_KEY = "Camera2CameraControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    CallbackToFutureAdapter.Completer<Void> mCompleter;
    final Executor mExecutor;
    private boolean mIsActive = false;
    private boolean mPendingUpdate = false;
    final Object mLock = new Object();

    @GuardedBy("mLock")
    private Camera2ImplConfig.Builder mBuilder = new Camera2ImplConfig.Builder();
    private final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: l.d
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
            return this.f7079a.lambda$new$0(totalCaptureResult);
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
    }

    private void addCaptureRequestOptionsInternal(@NonNull CaptureRequestOptions captureRequestOptions) {
        synchronized (this.mLock) {
            try {
                for (Config.Option<?> option : captureRequestOptions.listOptions()) {
                    this.mBuilder.getMutableConfig().insertOption(option, captureRequestOptions.retrieveOption(option));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void clearCaptureRequestOptionsInternal() {
        synchronized (this.mLock) {
            this.mBuilder = new Camera2ImplConfig.Builder();
        }
    }

    @NonNull
    public static Camera2CameraControl from(@NonNull CameraControl cameraControl) {
        Preconditions.checkArgument(cameraControl instanceof Camera2CameraControlImpl, "CameraControl doesn't contain Camera2 implementation.");
        return ((Camera2CameraControlImpl) cameraControl).getCamera2CameraControl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addCaptureRequestOptions$4(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new b(this, completer, 0));
        return "addCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$clearCaptureRequestOptions$6(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new b(this, completer, 2));
        return "clearCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    public /* synthetic */ boolean lambda$new$0(TotalCaptureResult totalCaptureResult) {
        CallbackToFutureAdapter.Completer<Void> completer;
        Integer num;
        if (this.mCompleter != null) {
            Object tag = totalCaptureResult.getRequest().getTag();
            if ((tag instanceof TagBundle) && (num = (Integer) ((TagBundle) tag).getTag(TAG_KEY)) != null && num.equals(Integer.valueOf(this.mCompleter.hashCode()))) {
                completer = this.mCompleter;
                this.mCompleter = null;
            } else {
                completer = null;
            }
        } else {
            completer = null;
        }
        if (completer == null) {
            return false;
        }
        completer.set(null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setCaptureRequestOptions$2(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new b(this, completer, 1));
        return "setCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setActiveInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$setActive$7(boolean z2) {
        if (this.mIsActive == z2) {
            return;
        }
        this.mIsActive = z2;
        if (z2) {
            if (this.mPendingUpdate) {
                updateSession();
            }
        } else {
            CallbackToFutureAdapter.Completer<Void> completer = this.mCompleter;
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("The camera control has became inactive."));
                this.mCompleter = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateConfig, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$setCaptureRequestOptions$1(CallbackToFutureAdapter.Completer<Void> completer) {
        this.mPendingUpdate = true;
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mCompleter;
        if (completer2 == null) {
            completer2 = null;
        }
        this.mCompleter = completer;
        if (this.mIsActive) {
            updateSession();
        }
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    private void updateSession() {
        this.mCamera2CameraControlImpl.updateSessionConfig();
        this.mPendingUpdate = false;
    }

    @NonNull
    public l addCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new a(this, 0)));
    }

    @NonNull
    public l clearCaptureRequestOptions() {
        clearCaptureRequestOptionsInternal();
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new a(this, 2)));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2ImplConfig getCamera2ImplConfig() {
        Camera2ImplConfig camera2ImplConfigBuild;
        synchronized (this.mLock) {
            try {
                if (this.mCompleter != null) {
                    this.mBuilder.getMutableConfig().insertOption(Camera2ImplConfig.CAPTURE_REQUEST_TAG_OPTION, Integer.valueOf(this.mCompleter.hashCode()));
                }
                camera2ImplConfigBuild = this.mBuilder.build();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return camera2ImplConfigBuild;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControlImpl.CaptureResultListener getCaptureRequestListener() {
        return this.mCaptureResultListener;
    }

    @NonNull
    public CaptureRequestOptions getCaptureRequestOptions() {
        CaptureRequestOptions captureRequestOptionsBuild;
        synchronized (this.mLock) {
            captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(this.mBuilder.build()).build();
        }
        return captureRequestOptionsBuild;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActive(boolean z2) {
        this.mExecutor.execute(new c(this, z2, 0));
    }

    @NonNull
    public l setCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        clearCaptureRequestOptionsInternal();
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new a(this, 1)));
    }
}
