package qd;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.animation.LinearInterpolator;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.view.ViewPagerTabs;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f8988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPagerTabs f8990d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ViewPagerTabs viewPagerTabs, Context context) {
        super(context);
        this.f8990d = viewPagerTabs;
        this.f8989c = true;
        Paint paint = new Paint(1);
        this.f8988b = paint;
        paint.setColor(viewPagerTabs.f3200b.getColor(R$color.os_gray_tertiary_color));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(viewPagerTabs.f3203h);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setDither(true);
        new LinearInterpolator();
        new ArgbEvaluator();
        setWillNotDraw(false);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean z2 = this.f8989c;
        ViewPagerTabs viewPagerTabs = this.f8990d;
        if (z2 && viewPagerTabs.f3204i) {
            viewPagerTabs.fullScroll(66);
            this.f8989c = false;
        }
        if (getChildCount() > 0) {
            CheckedTextView checkedTextView = (CheckedTextView) getChildAt(this.f8987a);
            int iFloatValue = (int) ((Float) viewPagerTabs.f3205j.get(this.f8987a)).floatValue();
            int[] iArr = viewPagerTabs.f3206k;
            if (checkedTextView != null && iArr != null) {
                if (iArr.length != 2) {
                    throw new IllegalArgumentException("Wrong arguments, array's length must be 2!");
                }
                int width = (((checkedTextView.getWidth() - checkedTextView.getPaddingLeft()) - checkedTextView.getPaddingRight()) - iFloatValue) / 2;
                iArr[0] = checkedTextView.getPaddingLeft() + checkedTextView.getLeft() + width;
                iArr[1] = (checkedTextView.getRight() - checkedTextView.getPaddingRight()) - width;
            }
            checkedTextView.setChecked(true);
            checkedTextView.setTextAppearance(R$style.os_semibold_font);
            getBottom();
            canvas.drawLine(0.0f, getBottom(), viewPagerTabs.f3212s, getBottom(), this.f8988b);
        }
    }
}
