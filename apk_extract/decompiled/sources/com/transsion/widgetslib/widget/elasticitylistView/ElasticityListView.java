package com.transsion.widgetslib.widget.elasticitylistView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import de.a;
import pd.b;

/* JADX INFO: loaded from: classes2.dex */
public class ElasticityListView extends ListView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f3519l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3523d;
    public float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AbsListView.OnScrollListener f3525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f3527k;

    public ElasticityListView(Context context) {
        super(context);
        this.f3520a = 0.0f;
        this.f3521b = 1.0f;
        this.f3522c = 0;
        this.f3523d = 0;
        this.e = 0.0f;
        this.f3524h = 0.0f;
        this.f3526j = 0;
        a();
    }

    public final void a() {
        getContext();
        b bVar = new b();
        bVar.f8718a = 0;
        bVar.f8723h = new DecelerateInterpolator();
        this.f3527k = bVar;
        super.setOnScrollListener(new a(this));
    }

    public final boolean b() {
        View childAt;
        if (getFirstVisiblePosition() == 0 && this.f3522c == 0 && (childAt = getChildAt(0)) != null) {
            return getPaddingTop() + childAt.getTop() >= 0;
        }
        return false;
    }

    public final boolean c() {
        View childAt;
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int count = getCount();
        if ((lastVisiblePosition == count - 1 || this.f3522c + this.f3523d == count) && (childAt = getChildAt(lastVisiblePosition - firstVisiblePosition)) != null) {
            return getHeight() >= getPaddingBottom() + childAt.getBottom();
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.f3527k;
        if (bVar.f8718a == 0) {
            return;
        }
        bVar.getClass();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float interpolation = bVar.f8723h.getInterpolation(Math.min((jCurrentAnimationTimeMillis - bVar.f8720c) / bVar.f8721d, 1.0f));
        float f = bVar.e;
        float fB = a1.a.b(bVar.f, f, interpolation, f);
        int i8 = bVar.f8718a;
        if (i8 == 1) {
            bVar.f8719b.setPivotY(bVar.f8722g);
            bVar.f8719b.setScaleY(fB);
            if (jCurrentAnimationTimeMillis - bVar.f8720c > bVar.f8721d) {
                bVar.f8718a = 0;
            }
        } else if (i8 == 2) {
            bVar.f8719b.setPivotY(bVar.f8722g);
            bVar.f8719b.setScaleY(fB);
            if (jCurrentAnimationTimeMillis - bVar.f8720c > bVar.f8721d) {
                bVar.f8718a = 1;
                bVar.e = fB;
                bVar.f = 1.0f;
                bVar.f8720c = AnimationUtils.currentAnimationTimeMillis();
                bVar.f8721d = 150.0f;
            }
        }
        if (bVar.f8718a != 0) {
            invalidate();
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0109  */
    /* JADX WARN: Code duplicated, block: B:59:0x0110  */
    /* JADX WARN: Code duplicated, block: B:61:0x0118  */
    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        int action = motionEvent.getAction();
        if (action == 0) {
            b bVar = this.f3527k;
            if (bVar.f8718a != 0) {
                bVar.f8718a = 0;
            }
            this.e = motionEvent.getY();
            this.f3526j = pointToPosition((int) motionEvent.getX(), (int) this.e);
            this.f3521b = 1.0f;
            this.f3524h = 0.0f;
        } else if (action == 1) {
            if (getScaleY() != 1.0f) {
                b bVar2 = this.f3527k;
                float scaleY = getScaleY();
                float f = this.f3520a;
                bVar2.f8719b = this;
                bVar2.e = scaleY;
                bVar2.f = 1.0f;
                bVar2.f8722g = f;
                long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                bVar2.f8718a = 1;
                bVar2.f8720c = jCurrentAnimationTimeMillis;
                bVar2.f8721d = 150.0f;
                this.f3521b = 1.0f;
                this.e = 0.0f;
                this.f3524h = 0.0f;
                invalidate();
            }
        } else if (action == 2) {
            if (this.e == 0.0f) {
                this.e = motionEvent.getY();
                this.f3521b = 1.0f;
            }
            this.f3524h = motionEvent.getY() - this.e;
            if (getChildCount() > 0 && Math.abs(this.f3524h) > 10.0f) {
                float f4 = this.f3524h;
                if (b() && c()) {
                    if (f4 > 0.0f) {
                        this.f3520a = 0.0f;
                        setPivotY(0.0f);
                        float measuredHeight = ((f4 * 0.1f) / getMeasuredHeight()) + 1.0f;
                        this.f3521b = measuredHeight;
                        if (measuredHeight < 1.0f) {
                            this.f3521b = 1.0f;
                        } else {
                            if (measuredHeight > 1.1f) {
                                this.f3521b = 1.1f;
                            }
                            setScaleY(this.f3521b);
                            setPressed(false);
                            childAt = getChildAt(this.f3526j - getFirstVisiblePosition());
                            if (childAt != null) {
                                childAt.setPressed(false);
                            }
                            onCancelPendingInputEvents();
                        }
                    } else {
                        float measuredHeight2 = getMeasuredHeight();
                        this.f3520a = measuredHeight2;
                        setPivotY(measuredHeight2);
                        float measuredHeight3 = 1.0f - ((f4 * 0.1f) / getMeasuredHeight());
                        this.f3521b = measuredHeight3;
                        if (measuredHeight3 < 1.0f) {
                            this.f3521b = 1.0f;
                        } else {
                            if (measuredHeight3 > 1.1f) {
                                this.f3521b = 1.1f;
                            }
                            setScaleY(this.f3521b);
                            setPressed(false);
                            childAt = getChildAt(this.f3526j - getFirstVisiblePosition());
                            if (childAt != null) {
                                childAt.setPressed(false);
                            }
                            onCancelPendingInputEvents();
                        }
                    }
                } else if (b()) {
                    this.f3520a = 0.0f;
                    setPivotY(0.0f);
                    float measuredHeight4 = ((f4 * 0.1f) / getMeasuredHeight()) + 1.0f;
                    this.f3521b = measuredHeight4;
                    if (measuredHeight4 < 1.0f) {
                        this.f3521b = 1.0f;
                    } else {
                        if (measuredHeight4 > 1.1f) {
                            this.f3521b = 1.1f;
                        }
                        setScaleY(this.f3521b);
                        setPressed(false);
                        childAt = getChildAt(this.f3526j - getFirstVisiblePosition());
                        if (childAt != null) {
                            childAt.setPressed(false);
                        }
                        onCancelPendingInputEvents();
                    }
                } else if (c()) {
                    float measuredHeight5 = getMeasuredHeight();
                    this.f3520a = measuredHeight5;
                    setPivotY(measuredHeight5);
                    float measuredHeight6 = 1.0f - ((f4 * 0.1f) / getMeasuredHeight());
                    this.f3521b = measuredHeight6;
                    if (measuredHeight6 < 1.0f) {
                        this.f3521b = 1.0f;
                    } else {
                        if (measuredHeight6 > 1.1f) {
                            this.f3521b = 1.1f;
                        }
                        setScaleY(this.f3521b);
                        setPressed(false);
                        childAt = getChildAt(this.f3526j - getFirstVisiblePosition());
                        if (childAt != null) {
                            childAt.setPressed(false);
                        }
                        onCancelPendingInputEvents();
                    }
                }
            }
        } else if (action == 3) {
            if (getScaleY() != 1.0f) {
                b bVar3 = this.f3527k;
                float scaleY2 = getScaleY();
                float f10 = this.f3520a;
                bVar3.f8719b = this;
                bVar3.e = scaleY2;
                bVar3.f = 1.0f;
                bVar3.f8722g = f10;
                long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                bVar3.f8718a = 1;
                bVar3.f8720c = jCurrentAnimationTimeMillis2;
                bVar3.f8721d = 150.0f;
                this.f3521b = 1.0f;
                this.e = 0.0f;
                this.f3524h = 0.0f;
                invalidate();
            }
        }
        if (Math.abs(getScaleY() - 1.0f) > 0.01f) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f3525i = onScrollListener;
    }

    public ElasticityListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3520a = 0.0f;
        this.f3521b = 1.0f;
        this.f3522c = 0;
        this.f3523d = 0;
        this.e = 0.0f;
        this.f3524h = 0.0f;
        this.f3526j = 0;
        a();
    }

    public ElasticityListView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3520a = 0.0f;
        this.f3521b = 1.0f;
        this.f3522c = 0;
        this.f3523d = 0;
        this.e = 0.0f;
        this.f3524h = 0.0f;
        this.f3526j = 0;
        a();
    }
}
