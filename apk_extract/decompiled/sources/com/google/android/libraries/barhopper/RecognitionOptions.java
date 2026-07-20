package com.google.android.libraries.barhopper;

import com.google.android.apps.common.proguard.UsedByNative;

/* JADX INFO: loaded from: classes.dex */
@UsedByNative("jni_common.cc")
public class RecognitionOptions {

    @UsedByNative("jni_common.cc")
    private int barcodeFormats = 0;

    @UsedByNative("jni_common.cc")
    private boolean outputUnrecognizedBarcodes = false;

    @UsedByNative("jni_common.cc")
    private boolean useQrMobilenetV3 = false;

    @UsedByNative("jni_common.cc")
    private boolean enableQrAlignmentGrid = false;

    @UsedByNative("jni_common.cc")
    private boolean enableUseKeypointAsFinderPattern = false;

    @UsedByNative("jni_common.cc")
    private int binarizerOptions = 3;

    @UsedByNative("jni_common.cc")
    private OnedRecognitionOptions onedRecognitionOptions = new OnedRecognitionOptions();

    public final void a(int i8) {
        this.barcodeFormats = i8;
    }

    public final void b(boolean z2) {
        this.outputUnrecognizedBarcodes = z2;
    }
}
