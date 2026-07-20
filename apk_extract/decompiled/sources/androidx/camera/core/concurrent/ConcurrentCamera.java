package androidx.camera.core.concurrent;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.Camera;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConcurrentCamera {

    @NonNull
    private List<Camera> mCameras;

    public static class Builder {

        @NonNull
        private List<Camera> mCameras;

        @NonNull
        public ConcurrentCamera builder() {
            return new ConcurrentCamera(this.mCameras);
        }

        @NonNull
        public Builder setCameras(@NonNull List<Camera> list) {
            this.mCameras = list;
            return this;
        }
    }

    public ConcurrentCamera(@NonNull List<Camera> list) {
        this.mCameras = list;
    }

    @NonNull
    public List<Camera> getCameras() {
        return this.mCameras;
    }
}
