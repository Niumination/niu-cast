package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.transsion.widgetsliquid.R;
import hd.a;
import java.util.LinkedHashMap;
import java.util.Map;
import je.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 L2\u00020\u0001:\u0001LB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0015H\u0002J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0015J\u0016\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0015J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0002J\u000e\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u0015J\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020 J\b\u0010:\u001a\u00020+H\u0014J\u0016\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0015J\u0016\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020 J\u000e\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u0007J\u001f\u0010E\u001a\u00020+2\u0006\u0010?\u001a\u00020\u00072\n\b\u0002\u0010F\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u00020\u0007J\u0017\u0010J\u001a\u00020+2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010KR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b$\u0010\u0011R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidFobItemContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "backgroundPaint", "Landroid/graphics/Paint;", "backgroundRect", "Landroid/graphics/RectF;", "badgePaint", "getBadgePaint", "()Landroid/graphics/Paint;", "badgePaint$delegate", "Lkotlin/Lazy;", "badgeRadius", "", "currentBackgroundLeft", "getCurrentBackgroundLeft$widgetsliquid_release", "()F", "setCurrentBackgroundLeft$widgetsliquid_release", "(F)V", "currentBackgroundWidth", "getCurrentBackgroundWidth$widgetsliquid_release", "setCurrentBackgroundWidth$widgetsliquid_release", "itemBadgeMap", "", "", "mBadgeOffset", "mSelectColor", "mXfModePaint", "getMXfModePaint", "mXfModePaint$delegate", "selectedBackgroundColor", "selectedPosition", "targetBackgroundLeft", "targetBackgroundWidth", "animateBackgroundToTarget", "", "targetPosition", "currentLeft", "animateToFinalPosition", "finalPositionAppend", "animateToFinalPositionInternal", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawBadgeView", "drawSelectedBackground", "eventInIndicator", "x", "getSelectedPosition", "isAnimRunning", "onDetachedFromWindow", "setIndicatorWidth", "width", "left", "setItemShowBadge", "position", "show", "setSelectColor", "selectColor", "setSelectedBackgroundColor", TypedValues.Custom.S_COLOR, "setSelectedPosition", "animated", "(ILjava/lang/Boolean;)V", "updFinalPosition", "eventPosition", "updateBackgroundPosition", "(Ljava/lang/Boolean;)V", "Companion", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSLiquidFobItemContainer extends LinearLayout {
    private static final float ANIMATION_INDICATOR_DAMPING_RATIO = 0.8f;
    private static final float ANIMATION_INDICATOR_STIFFNESS = 400.0f;
    public static final int BACKGROUND_EXPAND_DP = 8;
    private static final int BACKGROUND_MARGIN_VERTICAL_DP = 4;
    private static final int BADGE_VIEW_OFFSET = 2;
    private static final String TAG = "OSLiquidFobItemContainer";
    private SpringAnimation backgroundAnimator;
    private final Paint backgroundPaint;
    private final RectF backgroundRect;

    /* JADX INFO: renamed from: badgePaint$delegate, reason: from kotlin metadata */
    private final Lazy badgePaint;
    private float badgeRadius;
    private float currentBackgroundLeft;
    private float currentBackgroundWidth;
    private final Map<Integer, Boolean> itemBadgeMap;
    private float mBadgeOffset;
    private int mSelectColor;

    /* JADX INFO: renamed from: mXfModePaint$delegate, reason: from kotlin metadata */
    private final Lazy mXfModePaint;
    private int selectedBackgroundColor;
    private int selectedPosition;
    private float targetBackgroundLeft;
    private float targetBackgroundWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidFobItemContainer(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void animateBackgroundToTarget(float targetPosition, float currentLeft) {
        if (this.backgroundAnimator == null) {
            SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
            SpringForce springForce = new SpringForce();
            springForce.setStiffness(ANIMATION_INDICATOR_STIFFNESS);
            springForce.setDampingRatio(ANIMATION_INDICATOR_DAMPING_RATIO);
            springAnimation.setSpring(springForce);
            springAnimation.setStartValue(currentLeft);
            springAnimation.addUpdateListener(new b(this, 1));
            this.backgroundAnimator = springAnimation;
        }
        animateToFinalPosition(targetPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateBackgroundToTarget$lambda$3$lambda$2(OSLiquidFobItemContainer this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentBackgroundLeft = f;
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateToFinalPositionInternal$lambda$6$lambda$5(OSLiquidFobItemContainer this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentBackgroundLeft = f;
        this$0.invalidate();
    }

    private final void drawBadgeView(Canvas canvas) {
        View childAt;
        ViewGroup viewGroup;
        View childAt2;
        float top;
        float f;
        for (Map.Entry<Integer, Boolean> entry : this.itemBadgeMap.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if (entry.getValue().booleanValue() && iIntValue >= 0 && iIntValue < getChildCount() && (childAt = getChildAt(iIntValue)) != null && (childAt2 = (viewGroup = (ViewGroup) childAt).getChildAt(0)) != null) {
                getContext();
                boolean z2 = j.f8768g;
                float width = ((childAt2.getWidth() / 2) + this.badgeRadius) - this.mBadgeOffset;
                int width2 = z2 ? (childAt2.getWidth() / 2) + childAt2.getLeft() + viewGroup.getLeft() : viewGroup.getLeft() + (viewGroup.getWidth() / 2);
                float f4 = j.v() ? width2 - width : width2 + width;
                if (z2) {
                    top = childAt2.getTop() + viewGroup.getTop() + this.badgeRadius;
                    f = this.mBadgeOffset;
                } else {
                    top = viewGroup.getTop() + this.badgeRadius;
                    f = this.mBadgeOffset;
                }
                canvas.drawCircle(f4, top - f, this.badgeRadius, getBadgePaint());
            }
        }
    }

    private final void drawSelectedBackground(Canvas canvas) {
        if (this.selectedPosition < 0 || this.currentBackgroundWidth <= 0.0f) {
            return;
        }
        float height = getHeight();
        Context context = getContext();
        String[] strArr = j.f8764a;
        float fA = height - a.a(context, 8);
        int iA = a.a(getContext(), 4);
        float f = fA - (iA << 1);
        RectF rectF = this.backgroundRect;
        float f4 = this.currentBackgroundLeft;
        float f10 = iA;
        rectF.set(f4, f10, this.currentBackgroundWidth + f4, fA + f10);
        canvas.drawRoundRect(this.backgroundRect, f, f, this.backgroundPaint);
    }

    private final Paint getBadgePaint() {
        return (Paint) this.badgePaint.getValue();
    }

    private final Paint getMXfModePaint() {
        return (Paint) this.mXfModePaint.getValue();
    }

    public static /* synthetic */ void setSelectedPosition$default(OSLiquidFobItemContainer oSLiquidFobItemContainer, int i8, Boolean bool, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            bool = Boolean.TRUE;
        }
        oSLiquidFobItemContainer.setSelectedPosition(i8, bool);
    }

    public static /* synthetic */ void updateBackgroundPosition$default(OSLiquidFobItemContainer oSLiquidFobItemContainer, Boolean bool, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            bool = Boolean.TRUE;
        }
        oSLiquidFobItemContainer.updateBackgroundPosition(bool);
    }

    public final void animateToFinalPosition(float finalPositionAppend) {
        View childAt = getChildAt(this.selectedPosition);
        if (childAt == null) {
            return;
        }
        float left = childAt.getLeft();
        Context context = getContext();
        String[] strArr = j.f8764a;
        animateToFinalPositionInternal(finalPositionAppend, left - a.a(context, 8));
    }

    public final void animateToFinalPositionInternal(float finalPositionAppend, float currentLeft) {
        if (this.backgroundAnimator == null) {
            SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
            SpringForce springForce = new SpringForce();
            springForce.setStiffness(ANIMATION_INDICATOR_STIFFNESS);
            springForce.setDampingRatio(ANIMATION_INDICATOR_DAMPING_RATIO);
            springAnimation.setSpring(springForce);
            springAnimation.setStartValue(currentLeft);
            springAnimation.addUpdateListener(new b(this, 0));
            this.backgroundAnimator = springAnimation;
        }
        SpringAnimation springAnimation2 = this.backgroundAnimator;
        if (springAnimation2 != null) {
            springAnimation2.animateToFinalPosition(finalPositionAppend);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawSelectedBackground(canvas);
        int iSaveLayer = canvas.saveLayer(null, null, 31);
        super.dispatchDraw(canvas);
        float height = getHeight();
        Context context = getContext();
        String[] strArr = j.f8764a;
        float fA = (height - a.a(context, 8)) - (a.a(getContext(), 4) << 1);
        canvas.drawRoundRect(this.backgroundRect, fA, fA, getMXfModePaint());
        canvas.restoreToCount(iSaveLayer);
        drawBadgeView(canvas);
    }

    public final boolean eventInIndicator(float x2) {
        float f = this.currentBackgroundLeft;
        return x2 >= f && x2 <= f + this.currentBackgroundWidth;
    }

    /* JADX INFO: renamed from: getCurrentBackgroundLeft$widgetsliquid_release, reason: from getter */
    public final float getCurrentBackgroundLeft() {
        return this.currentBackgroundLeft;
    }

    /* JADX INFO: renamed from: getCurrentBackgroundWidth$widgetsliquid_release, reason: from getter */
    public final float getCurrentBackgroundWidth() {
        return this.currentBackgroundWidth;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final boolean isAnimRunning() {
        SpringAnimation springAnimation = this.backgroundAnimator;
        return springAnimation != null && springAnimation.isRunning();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpringAnimation springAnimation = this.backgroundAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.backgroundAnimator = null;
    }

    public final void setCurrentBackgroundLeft$widgetsliquid_release(float f) {
        this.currentBackgroundLeft = f;
    }

    public final void setCurrentBackgroundWidth$widgetsliquid_release(float f) {
        this.currentBackgroundWidth = f;
    }

    public final void setIndicatorWidth(int width, float left) {
        this.currentBackgroundLeft = left;
        invalidate();
    }

    public final void setItemShowBadge(int position, boolean show) {
        this.itemBadgeMap.put(Integer.valueOf(position), Boolean.valueOf(show));
        invalidate();
    }

    public final void setSelectColor(int selectColor) {
        this.mSelectColor = selectColor;
        getMXfModePaint().setColor(selectColor);
        invalidate();
    }

    public final void setSelectedBackgroundColor(int color) {
        this.selectedBackgroundColor = color;
        this.backgroundPaint.setColor(color);
        invalidate();
    }

    public final void setSelectedPosition(int position, Boolean animated) {
        if (position < 0 || position >= getChildCount()) {
            return;
        }
        this.selectedPosition = position;
        updateBackgroundPosition(animated);
    }

    public final void updFinalPosition(int eventPosition) {
        this.selectedPosition = eventPosition;
    }

    public final void updateBackgroundPosition(Boolean animated) {
        View childAt;
        int i8 = this.selectedPosition;
        if (i8 < 0 || i8 >= getChildCount() || (childAt = getChildAt(this.selectedPosition)) == null) {
            return;
        }
        float width = childAt.getWidth();
        float left = childAt.getLeft();
        Context context = getContext();
        String[] strArr = j.f8764a;
        int iA = a.a(context, 8);
        this.currentBackgroundWidth = width + (iA * 2);
        this.targetBackgroundLeft = left - iA;
        if (!Intrinsics.areEqual(animated, Boolean.FALSE) && this.currentBackgroundWidth != 0.0f) {
            animateBackgroundToTarget(this.targetBackgroundLeft, this.currentBackgroundLeft);
            return;
        }
        float f = this.targetBackgroundLeft;
        this.currentBackgroundLeft = f;
        SpringAnimation springAnimation = this.backgroundAnimator;
        if (springAnimation != null) {
            springAnimation.animateToFinalPosition(f);
            springAnimation.skipToEnd();
        }
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidFobItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSLiquidFobItemContainer(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidFobItemContainer(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        this.backgroundRect = new RectF();
        this.selectedPosition = -1;
        this.mXfModePaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.transsion.widgetsliquid.view.OSLiquidFobItemContainer$mXfModePaint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Paint invoke() {
                Paint paint2 = new Paint();
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                return paint2;
            }
        });
        this.itemBadgeMap = new LinkedHashMap();
        this.badgePaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.transsion.widgetsliquid.view.OSLiquidFobItemContainer$badgePaint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Paint invoke() {
                Paint paint2 = new Paint(1);
                paint2.setColor(this.this$0.getContext().getColor(R.color.os_warning_primary_hios));
                return paint2;
            }
        });
        setWillNotDraw(false);
        this.selectedBackgroundColor = 855638016;
        paint.setColor(855638016);
        String[] strArr = j.f8764a;
        this.badgeRadius = a.a(context, 6) / 2.0f;
        this.mBadgeOffset = a.a(context, 2);
    }
}
