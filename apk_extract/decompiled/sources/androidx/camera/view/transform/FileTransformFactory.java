package androidx.camera.view.transform;

import android.content.ContentResolver;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.TransformExperimental;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@TransformExperimental
public final class FileTransformFactory {
    private boolean mUsingExifOrientation;

    @NonNull
    public OutputTransform getOutputTransform(@NonNull ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
        try {
            OutputTransform outputTransform = getOutputTransform(inputStreamOpenInputStream);
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            return outputTransform;
        } catch (Throwable th2) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public boolean isUsingExifOrientation() {
        return this.mUsingExifOrientation;
    }

    public void setUsingExifOrientation(boolean z2) {
        this.mUsingExifOrientation = z2;
    }

    @NonNull
    public OutputTransform getOutputTransform(@NonNull File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            OutputTransform outputTransform = getOutputTransform(fileInputStream);
            fileInputStream.close();
            return outputTransform;
        } catch (Throwable th2) {
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @NonNull
    public OutputTransform getOutputTransform(@NonNull InputStream inputStream) throws IOException {
        Exif exifCreateFromInputStream = Exif.createFromInputStream(inputStream);
        Rect rect = new Rect(0, 0, exifCreateFromInputStream.getWidth(), exifCreateFromInputStream.getHeight());
        Matrix normalizedToBuffer = TransformUtils.getNormalizedToBuffer(rect);
        if (this.mUsingExifOrientation) {
            normalizedToBuffer.postConcat(TransformUtils.getExifTransform(exifCreateFromInputStream.getOrientation(), exifCreateFromInputStream.getWidth(), exifCreateFromInputStream.getHeight()));
        }
        return new OutputTransform(normalizedToBuffer, TransformUtils.rectToSize(rect));
    }
}
