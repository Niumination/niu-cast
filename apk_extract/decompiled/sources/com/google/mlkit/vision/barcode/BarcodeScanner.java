package com.google.mlkit.vision.barcode;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.mlkit.vision.interfaces.Detector;
import java.util.List;
import q2.j;
import t5.a;

/* JADX INFO: loaded from: classes2.dex */
public interface BarcodeScanner extends Detector<List<a>>, j {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();
}
