package androidx.camera.mlkit.vision;

import android.graphics.Matrix;
import android.media.Image;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.view.TransformExperimental;
import androidx.camera.view.transform.CoordinateTransform;
import androidx.camera.view.transform.ImageProxyTransformFactory;
import androidx.camera.view.transform.OutputTransform;
import androidx.core.util.Consumer;
import com.google.mlkit.vision.interfaces.Detector;
import d6.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import q3.b;
import q3.f;
import q3.i;
import q3.k;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MlKitAnalyzer implements ImageAnalysis.Analyzer {
    private static final Size DEFAULT_SIZE = new Size(480, 360);
    private static final String TAG = "MlKitAnalyzer";

    @NonNull
    final Consumer<Result> mConsumer;

    @NonNull
    private final List<Detector<?>> mDetectors;

    @NonNull
    private final Executor mExecutor;
    final ImageProxyTransformFactory mImageAnalysisTransformFactory;

    @Nullable
    private Matrix mSensorToTarget;
    private final int mTargetCoordinateSystem;

    public static final class Result {

        @NonNull
        private final Map<Detector<?>, Throwable> mThrowables;
        private final long mTimestamp;

        @NonNull
        private final Map<Detector<?>, Object> mValues;

        public Result(@NonNull Map<Detector<?>, Object> map, long j8, @NonNull Map<Detector<?>, Throwable> map2) {
            this.mValues = map;
            this.mThrowables = map2;
            this.mTimestamp = j8;
        }

        private void checkDetectorExists(@NonNull Detector<?> detector) {
            l.a("The detector does not exist", this.mValues.containsKey(detector) || this.mThrowables.containsKey(detector));
        }

        @Nullable
        public Throwable getThrowable(@NonNull Detector<?> detector) {
            checkDetectorExists(detector);
            return this.mThrowables.get(detector);
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        @Nullable
        public <T> T getValue(@NonNull Detector<T> detector) {
            checkDetectorExists(detector);
            return (T) this.mValues.get(detector);
        }
    }

    @OptIn(markerClass = {TransformExperimental.class})
    public MlKitAnalyzer(@NonNull List<Detector<?>> list, int i8, @NonNull Executor executor, @NonNull Consumer<Result> consumer) {
        if (i8 != 0) {
            Iterator<Detector<?>> it = list.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
        }
        this.mDetectors = new ArrayList(list);
        this.mTargetCoordinateSystem = i8;
        this.mConsumer = consumer;
        this.mExecutor = executor;
        ImageProxyTransformFactory imageProxyTransformFactory = new ImageProxyTransformFactory();
        this.mImageAnalysisTransformFactory = imageProxyTransformFactory;
        imageProxyTransformFactory.setUsingRotationDegrees(true);
    }

    @OptIn(markerClass = {ExperimentalGetImage.class})
    private void detectRecursively(@NonNull final ImageProxy imageProxy, final int i8, @NonNull final Matrix matrix, final Map<Detector<?>, Object> map, @NonNull final Map<Detector<?>, Throwable> map2) {
        Image image = imageProxy.getImage();
        if (image == null) {
            Logger.e(TAG, "Image is null.");
            imageProxy.close();
            return;
        }
        if (i8 > this.mDetectors.size() - 1) {
            imageProxy.close();
            this.mExecutor.execute(new q(10, this, map, imageProxy, map2));
            return;
        }
        final Detector<?> detector = this.mDetectors.get(i8);
        try {
            k kVarP = detector.P(image, imageProxy.getImageInfo().getRotationDegrees(), matrix);
            Executor executor = this.mExecutor;
            b bVar = new b() { // from class: w.a
                @Override // q3.b
                public final void a(f fVar) {
                    this.f10619a.lambda$detectRecursively$1(map2, detector, map, imageProxy, i8, matrix, fVar);
                }
            };
            kVarP.getClass();
            kVarP.f8958b.k(new i(executor, bVar));
            kVarP.j();
        } catch (Exception e) {
            map2.put(detector, new RuntimeException("Failed to process the image.", e));
            detectRecursively(imageProxy, i8 + 1, matrix, map, map2);
        }
    }

    @NonNull
    private Size getTargetResolution(int i8) {
        return (i8 == 1 || i8 == 4) ? new Size(1280, 720) : DEFAULT_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectRecursively$0(Map map, ImageProxy imageProxy, Map map2) {
        this.mConsumer.accept(new Result(map, imageProxy.getImageInfo().getTimestamp(), map2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$detectRecursively$1(Map map, Detector detector, Map map2, ImageProxy imageProxy, int i8, Matrix matrix, f fVar) {
        if (((k) fVar).f8960d) {
            map.put(detector, new CancellationException("The task is canceled."));
        } else if (fVar.d()) {
            map2.put(detector, fVar.b());
        } else {
            map.put(detector, fVar.a());
        }
        detectRecursively(imageProxy, i8 + 1, matrix, map2, map);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    @OptIn(markerClass = {TransformExperimental.class})
    public final void analyze(@NonNull ImageProxy imageProxy) {
        Matrix matrix = new Matrix();
        if (this.mTargetCoordinateSystem != 0) {
            Matrix matrix2 = this.mSensorToTarget;
            if (matrix2 == null) {
                Logger.d(TAG, "Transform is null.");
                imageProxy.close();
                return;
            }
            new CoordinateTransform(this.mImageAnalysisTransformFactory.getOutputTransform(imageProxy), new OutputTransform(matrix2, new Size(imageProxy.getCropRect().width(), imageProxy.getCropRect().height()))).transform(matrix);
        }
        detectRecursively(imageProxy, 0, matrix, new HashMap(), new HashMap());
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    @NonNull
    public final Size getDefaultTargetResolution() {
        Size size = DEFAULT_SIZE;
        Iterator<Detector<?>> it = this.mDetectors.iterator();
        while (it.hasNext()) {
            it.next().getClass();
            Size targetResolution = getTargetResolution(1);
            if (targetResolution.getWidth() * targetResolution.getHeight() > size.getHeight() * size.getWidth()) {
                size = targetResolution;
            }
        }
        return size;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public final int getTargetCoordinateSystem() {
        return this.mTargetCoordinateSystem;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public final void updateTransform(@Nullable Matrix matrix) {
        if (matrix == null) {
            this.mSensorToTarget = null;
        } else {
            this.mSensorToTarget = new Matrix(matrix);
        }
    }
}
