package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class PathUtils {

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float[] approximate(Path path, float f) {
            return path.approximate(f);
        }
    }

    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f) {
        float[] fArrApproximate = Api26Impl.approximate(path, f);
        int length = fArrApproximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i8 = 1; i8 < length; i8++) {
            int i9 = i8 * 3;
            int i10 = (i8 - 1) * 3;
            float f4 = fArrApproximate[i9];
            float f10 = fArrApproximate[i9 + 1];
            float f11 = fArrApproximate[i9 + 2];
            float f12 = fArrApproximate[i10];
            float f13 = fArrApproximate[i10 + 1];
            float f14 = fArrApproximate[i10 + 2];
            if (f4 != f12 && (f10 != f13 || f11 != f14)) {
                arrayList.add(new PathSegment(new PointF(f13, f14), f12, new PointF(f10, f11), f4));
            }
        }
        return arrayList;
    }
}
