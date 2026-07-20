package androidx.camera.core.impl;

import a0.e;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CameraRepository {
    private static final String TAG = "CameraRepository";

    @GuardedBy("mCamerasLock")
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;

    @GuardedBy("mCamerasLock")
    private l mDeinitFuture;
    private final Object mCamerasLock = new Object();

    @GuardedBy("mCamerasLock")
    private final Map<String, CameraInternal> mCameras = new LinkedHashMap();

    @GuardedBy("mCamerasLock")
    private final Set<CameraInternal> mReleasingCameras = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deinit$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mCamerasLock) {
            this.mDeinitCompleter = completer;
        }
        return "CameraRepository-deinit";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deinit$1(CameraInternal cameraInternal) {
        synchronized (this.mCamerasLock) {
            try {
                this.mReleasingCameras.remove(cameraInternal);
                if (this.mReleasingCameras.isEmpty()) {
                    Preconditions.checkNotNull(this.mDeinitCompleter);
                    this.mDeinitCompleter.set(null);
                    this.mDeinitCompleter = null;
                    this.mDeinitFuture = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public l deinit() {
        synchronized (this.mCamerasLock) {
            try {
                if (this.mCameras.isEmpty()) {
                    l lVarImmediateFuture = this.mDeinitFuture;
                    if (lVarImmediateFuture == null) {
                        lVarImmediateFuture = Futures.immediateFuture(null);
                    }
                    return lVarImmediateFuture;
                }
                l future = this.mDeinitFuture;
                if (future == null) {
                    future = CallbackToFutureAdapter.getFuture(new a4.b(this, 14));
                    this.mDeinitFuture = future;
                }
                this.mReleasingCameras.addAll(this.mCameras.values());
                for (CameraInternal cameraInternal : this.mCameras.values()) {
                    cameraInternal.release().addListener(new e(29, this, cameraInternal), CameraXExecutors.directExecutor());
                }
                this.mCameras.clear();
                return future;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public CameraInternal getCamera(@NonNull String str) {
        CameraInternal cameraInternal;
        synchronized (this.mCamerasLock) {
            try {
                cameraInternal = this.mCameras.get(str);
                if (cameraInternal == null) {
                    throw new IllegalArgumentException("Invalid camera: " + str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cameraInternal;
    }

    @NonNull
    public Set<String> getCameraIds() {
        LinkedHashSet linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet(this.mCameras.keySet());
        }
        return linkedHashSet;
    }

    @NonNull
    public LinkedHashSet<CameraInternal> getCameras() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet<>(this.mCameras.values());
        }
        return linkedHashSet;
    }

    public void init(@NonNull CameraFactory cameraFactory) throws InitializationException {
        synchronized (this.mCamerasLock) {
            try {
                for (String str : cameraFactory.getAvailableCameraIds()) {
                    Logger.d(TAG, "Added camera: " + str);
                    this.mCameras.put(str, cameraFactory.getCamera(str));
                }
            } catch (CameraUnavailableException e) {
                throw new InitializationException(e);
            }
        }
    }
}
