package zd;

import android.graphics.Paint;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Lambda implements Function0 {
    public static final k INSTANCE = new k();

    public k() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Paint invoke() {
        Paint paint = new Paint(1);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        return paint;
    }
}
