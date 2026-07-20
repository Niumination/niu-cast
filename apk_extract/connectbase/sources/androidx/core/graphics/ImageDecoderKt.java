package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import b.a;
import java.io.IOException;
import jn.q;
import k4.f;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@a({"ClassVerificationFailure"})
public final class ImageDecoderKt {
    @RequiresApi(28)
    @l
    public static final Bitmap decodeBitmap(@l ImageDecoder.Source source, @l final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, l2> qVar) throws IOException {
        l0.p(source, "<this>");
        l0.p(qVar, f.f8937e);
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeBitmap.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@l ImageDecoder imageDecoder, @l ImageDecoder.ImageInfo imageInfo, @l ImageDecoder.Source source2) {
                l0.p(imageDecoder, "decoder");
                l0.p(imageInfo, "info");
                l0.p(source2, "source");
                qVar.invoke(imageDecoder, imageInfo, source2);
            }
        });
        l0.o(bitmapDecodeBitmap, "crossinline action: Imag…ction(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    @l
    public static final Drawable decodeDrawable(@l ImageDecoder.Source source, @l final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, l2> qVar) throws IOException {
        l0.p(source, "<this>");
        l0.p(qVar, f.f8937e);
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeDrawable.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@l ImageDecoder imageDecoder, @l ImageDecoder.ImageInfo imageInfo, @l ImageDecoder.Source source2) {
                l0.p(imageDecoder, "decoder");
                l0.p(imageInfo, "info");
                l0.p(source2, "source");
                qVar.invoke(imageDecoder, imageInfo, source2);
            }
        });
        l0.o(drawableDecodeDrawable, "crossinline action: Imag…ction(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
