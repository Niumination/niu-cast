package com.transsion.widgetslib.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ke.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;
import zd.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/transsion/widgetslib/widget/OSMaskImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "getMaskAnimator", "()Landroid/animation/ValueAnimator;", "", "getSourceImage", "()V", "Landroid/graphics/Paint;", "d", "Lkotlin/Lazy;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSMaskImageView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSMaskImageView.kt\ncom/transsion/widgetslib/widget/OSMaskImageView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
public final class OSMaskImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f3396h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f3397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f3398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f3399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Lazy mPaint;
    public zd.a e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMaskImageView(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paint getMPaint() {
        return (Paint) this.mPaint.getValue();
    }

    private final ValueAnimator getMaskAnimator() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(new float[0]);
        valueAnimatorOfFloat.addUpdateListener(new a4.a(this, 4));
        valueAnimatorOfFloat.addListener(new d(this, 7));
        return valueAnimatorOfFloat;
    }

    private final void getSourceImage() {
        Drawable drawable;
        if (getWidth() <= 0 || getHeight() <= 0 || (drawable = getDrawable()) == null) {
            return;
        }
        String[] strArr = j.f8764a;
        String[] strArr2 = hd.a.f5293a;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.f3399c = bitmapCreateBitmap;
        if (bitmapCreateBitmap == null) {
            return;
        }
        this.f3397a = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f3398b = new Path();
        ValueAnimator maskAnimator = getMaskAnimator();
        Intrinsics.checkNotNullExpressionValue(maskAnimator, "this.getMaskAnimator()");
        this.e = new zd.a(maskAnimator);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f3399c;
        if (bitmap != null) {
            if (bitmap.isRecycled()) {
                bitmap = null;
            }
            if (bitmap != null) {
                bitmap.recycle();
            }
            zd.a aVar = this.e;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskDelegate");
                aVar = null;
            }
            ValueAnimator animator = aVar.getAnimator();
            ValueAnimator valueAnimator = animator.isRunning() ? animator : null;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f3399c;
        if (bitmap != null) {
            zd.a aVar = this.e;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskDelegate");
                aVar = null;
            }
            if (!aVar.f11275a.isRunning()) {
                bitmap = null;
            }
            if (bitmap != null) {
                canvas.save();
                if (isSelected()) {
                    Path path = this.f3398b;
                    if (path == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPath");
                        path = null;
                    }
                    canvas.clipOutPath(path);
                } else {
                    Path path2 = this.f3398b;
                    if (path2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPath");
                        path2 = null;
                    }
                    canvas.clipPath(path2);
                }
                Bitmap bitmapExtractAlpha = bitmap.extractAlpha();
                RectF rectF = this.f3397a;
                if (rectF == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRectF");
                    rectF = null;
                }
                canvas.drawBitmap(bitmapExtractAlpha, (Rect) null, rectF, getMPaint());
                canvas.restore();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        if (this.f3399c != null) {
            zd.a aVar = this.e;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskDelegate");
                aVar = null;
            }
            ValueAnimator animator = aVar.getAnimator();
            if (z2) {
                animator = null;
            }
            if (animator != null) {
                ValueAnimator valueAnimator = animator.isRunning() ? animator : null;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMaskImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSMaskImageView(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMaskImageView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = LazyKt.lazy(k.INSTANCE);
    }
}
