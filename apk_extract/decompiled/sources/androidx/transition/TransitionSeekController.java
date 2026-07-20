package androidx.transition;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes.dex */
public interface TransitionSeekController {
    void addOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> consumer);

    void addOnReadyListener(@NonNull Consumer<TransitionSeekController> consumer);

    void animateToEnd();

    void animateToStart(@NonNull Runnable runnable);

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    float getCurrentFraction();

    @IntRange(from = 0)
    long getCurrentPlayTimeMillis();

    @IntRange(from = 0)
    long getDurationMillis();

    boolean isReady();

    void removeOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> consumer);

    void removeOnReadyListener(@NonNull Consumer<TransitionSeekController> consumer);

    void setCurrentFraction(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f);

    void setCurrentPlayTimeMillis(@IntRange(from = 0) long j8);
}
