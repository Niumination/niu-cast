package rd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f9401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f9402c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i8) {
        super(context);
        this.f9400a = i8;
        switch (i8) {
            case 1:
                super(context);
                this.f9401b = new Path();
                this.f9402c = new RectF();
                break;
            default:
                this.f9401b = new Path();
                this.f9402c = new RectF();
                break;
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        switch (this.f9400a) {
            case 0:
                Path path = this.f9401b;
                path.reset();
                RectF rectF = this.f9402c;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.addRoundRect(rectF, getWidth() / 2.0f, getWidth() / 2.0f, Path.Direction.CCW);
                canvas.clipPath(path);
                super.draw(canvas);
                break;
            default:
                Path path2 = this.f9401b;
                path2.reset();
                int width = getWidth();
                int height = getHeight();
                RectF rectF2 = this.f9402c;
                float f = width;
                rectF2.set(0.0f, 0.0f, f, height);
                float f4 = f / 2.0f;
                path2.addRoundRect(rectF2, f4, f4, Path.Direction.CCW);
                canvas.clipPath(path2);
                super.draw(canvas);
                break;
        }
    }
}
