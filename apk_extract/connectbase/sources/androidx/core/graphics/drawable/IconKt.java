package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import b.a;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@a({"ClassVerificationFailure"})
public final class IconKt {
    @RequiresApi(26)
    @l
    public static final Icon toAdaptiveIcon(@l Bitmap bitmap) {
        l0.p(bitmap, "<this>");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        l0.o(iconCreateWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @l
    public static final Icon toIcon(@l Bitmap bitmap) {
        l0.p(bitmap, "<this>");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        l0.o(iconCreateWithBitmap, "createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    @l
    public static final Icon toIcon(@l Uri uri) {
        l0.p(uri, "<this>");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        l0.o(iconCreateWithContentUri, "createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    @l
    public static final Icon toIcon(@l byte[] bArr) {
        l0.p(bArr, "<this>");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        l0.o(iconCreateWithData, "createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
