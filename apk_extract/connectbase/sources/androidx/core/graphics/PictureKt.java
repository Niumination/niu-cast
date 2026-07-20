package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    @l
    public static final Picture record(@l Picture picture, int i10, int i11, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(picture, "<this>");
        l0.p(lVar, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i10, i11);
        l0.o(canvasBeginRecording, "beginRecording(width, height)");
        try {
            lVar.invoke(canvasBeginRecording);
            return picture;
        } finally {
            picture.endRecording();
        }
    }
}
