package com.google.mlkit.vision.interfaces;

import android.graphics.Matrix;
import android.media.Image;
import androidx.lifecycle.LifecycleObserver;
import java.io.Closeable;
import q3.k;

/* JADX INFO: loaded from: classes2.dex */
public interface Detector<DetectionResultT> extends Closeable, LifecycleObserver {
    k P(Image image, int i8, Matrix matrix);
}
