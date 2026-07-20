package k1;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import w1.f;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Paint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6345a;

    private final void a(LocaleList localeList) {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i8) {
        switch (this.f6345a) {
            case 0:
                PointF pointF = f.f10646a;
                super.setAlpha(Math.max(0, Math.min(255, i8)));
                break;
            default:
                super.setAlpha(i8);
                break;
        }
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
        switch (this.f6345a) {
            case 0:
                break;
            default:
                super.setTextLocales(localeList);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i8, int i9) {
        super(i8);
        this.f6345a = i9;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PorterDuff.Mode mode) {
        super(1);
        this.f6345a = 0;
        setXfermode(new PorterDuffXfermode(mode));
    }
}
