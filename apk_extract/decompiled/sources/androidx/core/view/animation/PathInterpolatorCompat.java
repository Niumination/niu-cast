package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        public static Interpolator createPathInterpolator(float f, float f4) {
            return new PathInterpolator(f, f4);
        }

        public static Interpolator createPathInterpolator(float f, float f4, float f10, float f11) {
            return new PathInterpolator(f, f4, f10, f11);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f, float f4) {
        return Api21Impl.createPathInterpolator(f, f4);
    }

    @NonNull
    public static Interpolator create(float f, float f4, float f10, float f11) {
        return Api21Impl.createPathInterpolator(f, f4, f10, f11);
    }
}
