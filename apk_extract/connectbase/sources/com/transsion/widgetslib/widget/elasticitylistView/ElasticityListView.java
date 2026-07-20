package com.transsion.widgetslib.widget.elasticitylistView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import hj.d;

/* JADX INFO: loaded from: classes2.dex */
public class ElasticityListView extends ListView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f2873v = "ListView";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f2874w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f2875x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float f2876y = 1.1f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f2883g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AbsListView.OnScrollListener f2884i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2885n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f2886p;

    public class b implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2887a;

        public b() {
            this.f2887a = 0;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            ElasticityListView.this.f2879c = i10;
            ElasticityListView elasticityListView = ElasticityListView.this;
            elasticityListView.f2880d = i11;
            AbsListView.OnScrollListener onScrollListener = elasticityListView.f2884i;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i10, i11, i12);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 0 && this.f2887a == 2) {
                ElasticityListView.this.i();
            }
            this.f2887a = i10;
            if (ElasticityListView.this.f2884i != null) {
                ElasticityListView.this.f2884i.onScrollStateChanged(absListView, i10);
            }
        }
    }

    public ElasticityListView(Context context) {
        super(context);
        this.f2877a = 0.0f;
        this.f2878b = 1.0f;
        this.f2879c = 0;
        this.f2880d = 0;
        this.f2881e = 0.0f;
        this.f2882f = 0.0f;
        this.f2885n = 0;
        e();
    }

    public final void e() {
        this.f2886p = new d(getContext());
        b bVar = new b();
        this.f2883g = bVar;
        super.setOnScrollListener(bVar);
    }

    public boolean f() {
        View childAt;
        if (getFirstVisiblePosition() == 0 && this.f2879c == 0 && (childAt = getChildAt(0)) != null) {
            return getPaddingTop() + childAt.getTop() >= 0;
        }
        return false;
    }

    public boolean g() {
        View childAt;
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int count = getCount();
        if ((lastVisiblePosition == count - 1 || this.f2879c + this.f2880d == count) && (childAt = getChildAt(lastVisiblePosition - firstVisiblePosition)) != null) {
            return getHeight() >= getPaddingBottom() + childAt.getBottom();
        }
        return false;
    }

    public final boolean h(float f10) {
        if (f() && g()) {
            if (f10 > 0.0f) {
                this.f2877a = 0.0f;
                setPivotY(0.0f);
                float measuredHeight = ((f10 * 0.1f) / getMeasuredHeight()) + 1.0f;
                this.f2878b = measuredHeight;
                if (measuredHeight < 1.0f) {
                    this.f2878b = 1.0f;
                    return false;
                }
                if (measuredHeight > 1.1f) {
                    this.f2878b = 1.1f;
                }
                setScaleY(this.f2878b);
                return true;
            }
            float measuredHeight2 = getMeasuredHeight();
            this.f2877a = measuredHeight2;
            setPivotY(measuredHeight2);
            float measuredHeight3 = 1.0f - ((f10 * 0.1f) / getMeasuredHeight());
            this.f2878b = measuredHeight3;
            if (measuredHeight3 < 1.0f) {
                this.f2878b = 1.0f;
                return false;
            }
            if (measuredHeight3 > 1.1f) {
                this.f2878b = 1.1f;
            }
            setScaleY(this.f2878b);
            return true;
        }
        if (f()) {
            this.f2877a = 0.0f;
            setPivotY(0.0f);
            float measuredHeight4 = ((f10 * 0.1f) / getMeasuredHeight()) + 1.0f;
            this.f2878b = measuredHeight4;
            if (measuredHeight4 < 1.0f) {
                this.f2878b = 1.0f;
                return false;
            }
            if (measuredHeight4 > 1.1f) {
                this.f2878b = 1.1f;
            }
            setScaleY(this.f2878b);
            return true;
        }
        if (!g()) {
            return false;
        }
        float measuredHeight5 = getMeasuredHeight();
        this.f2877a = measuredHeight5;
        setPivotY(measuredHeight5);
        float measuredHeight6 = 1.0f - ((f10 * 0.1f) / getMeasuredHeight());
        this.f2878b = measuredHeight6;
        if (measuredHeight6 < 1.0f) {
            this.f2878b = 1.0f;
            return false;
        }
        if (measuredHeight6 > 1.1f) {
            this.f2878b = 1.1f;
        }
        setScaleY(this.f2878b);
        return true;
    }

    public final void i() {
        if (f()) {
            this.f2877a = 0.0f;
            this.f2878b = 1.02f;
        }
        if (g()) {
            this.f2877a = getMeasuredHeight();
            this.f2878b = 1.02f;
        }
        float f10 = this.f2878b;
        if (f10 != 1.0f) {
            this.f2886p.c(this, f10, this.f2877a);
            this.f2878b = 1.0f;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2886p.b() || !this.f2886p.g()) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.f2886p.b()) {
                this.f2886p.a();
            }
            this.f2881e = motionEvent.getY();
            this.f2885n = pointToPosition((int) motionEvent.getX(), (int) this.f2881e);
            this.f2878b = 1.0f;
            this.f2882f = 0.0f;
        } else if (action == 1) {
            if (getScaleY() != 1.0f) {
                this.f2886p.d(this, getScaleY(), this.f2877a);
                this.f2878b = 1.0f;
                this.f2881e = 0.0f;
                this.f2882f = 0.0f;
                invalidate();
            }
        } else if (action == 2) {
            if (this.f2881e == 0.0f) {
                this.f2881e = motionEvent.getY();
                this.f2878b = 1.0f;
            }
            this.f2882f = motionEvent.getY() - this.f2881e;
            if (getChildCount() > 0 && Math.abs(this.f2882f) > 10.0f && h(this.f2882f)) {
                setPressed(false);
                View childAt = getChildAt(this.f2885n - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setPressed(false);
                }
                onCancelPendingInputEvents();
            }
        } else if (action == 3) {
            if (getScaleY() != 1.0f) {
                this.f2886p.d(this, getScaleY(), this.f2877a);
                this.f2878b = 1.0f;
                this.f2881e = 0.0f;
                this.f2882f = 0.0f;
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
        this.f2884i = onScrollListener;
    }

    public ElasticityListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2877a = 0.0f;
        this.f2878b = 1.0f;
        this.f2879c = 0;
        this.f2880d = 0;
        this.f2881e = 0.0f;
        this.f2882f = 0.0f;
        this.f2885n = 0;
        e();
    }

    public ElasticityListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2877a = 0.0f;
        this.f2878b = 1.0f;
        this.f2879c = 0;
        this.f2880d = 0;
        this.f2881e = 0.0f;
        this.f2882f = 0.0f;
        this.f2885n = 0;
        e();
    }

    public ElasticityListView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f2877a = 0.0f;
        this.f2878b = 1.0f;
        this.f2879c = 0;
        this.f2880d = 0;
        this.f2881e = 0.0f;
        this.f2882f = 0.0f;
        this.f2885n = 0;
        e();
    }
}
