package androidx.camera.core;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class ImageReaderFormatRecommender {

    public static abstract class FormatCombo {
        public static FormatCombo create(int i8, int i9) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(i8, i9);
        }

        public abstract int imageAnalysisFormat();

        public abstract int imageCaptureFormat();
    }

    private ImageReaderFormatRecommender() {
    }

    public static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }
}
