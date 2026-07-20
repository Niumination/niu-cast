package com.transsion.widgetslib.view.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$styleable;
import java.util.ArrayList;
import k3.z8;
import o.d;
import pd.j;
import td.b;
import td.c;

/* JADX INFO: loaded from: classes2.dex */
public class OSWatchPageIndicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3260d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f3264k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3265l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3266m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3267n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f3268o;
    public float p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final double f3269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3270s;

    public static class SaveState extends View.BaseSavedState {
        public static final Parcelable.Creator<SaveState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3271a;

        public final String toString() {
            return h0.a.B("OSWatchPageIndicator.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " currentIndex=" + this.f3271a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f3271a);
        }
    }

    public OSWatchPageIndicator(Context context) {
        this(context, null);
    }

    private int getDynamicAlphaAc() {
        int i8 = this.f3261h >>> 24;
        return (int) ((((this.f3262i >>> 24) - i8) * this.p) + i8);
    }

    private int getDynamicAlphaDe() {
        int i8 = this.f3261h >>> 24;
        int i9 = this.f3262i >>> 24;
        return (int) (i9 - ((i9 - i8) * this.p));
    }

    public final void a(int i8) {
        StringBuilder sbU = a1.a.u(i8, "onPageScrollStateChanged state = ", " mFinalMarkerIndex = ");
        sbU.append(this.f3267n);
        z8.f(null, sbU.toString());
        if (this.f3270s == 0) {
            this.f3265l = this.f3267n;
            invalidate();
        }
    }

    public final void b(float f) {
        this.p = Math.abs(f);
        if (f > 0.0f) {
            int i8 = this.f3265l + 1 > this.f3264k.size() + (-1) ? this.f3265l : this.f3265l + 1;
            this.f3266m = i8;
            if (f > 0.5f) {
                this.f3267n = i8;
            } else {
                this.f3267n = this.f3265l;
            }
        } else if (f < 0.0f) {
            int i9 = this.f3265l;
            if (i9 - 1 >= 0) {
                i9--;
            }
            this.f3266m = i9;
            if (Math.abs(f) > 0.5f) {
                this.f3267n = this.f3266m;
            } else {
                this.f3267n = this.f3265l;
            }
        }
        z8.f(null, "mNextMarkerIndex = " + this.f3266m + " percent = " + f);
        postInvalidate();
    }

    public final void c(float f, int i8, int i9) {
        if ((i8 == 0 || i8 == this.f3264k.size() - 1) && i9 == 0 && this.f3270s != 0) {
            return;
        }
        StringBuilder sbU = a1.a.u(i8, "onPageScrolled position = ", " mCurrentMarkerIndex = ");
        sbU.append(this.f3265l);
        sbU.append(" positionOffset = ");
        sbU.append(f);
        sbU.append(" positionOffsetPixels = ");
        sbU.append(i9);
        sbU.append(" mViewPager2.getScrollState() = ");
        sbU.append(getScrollState());
        z8.f(null, sbU.toString());
        int i10 = this.f3265l;
        if (i8 >= i10 && i9 != 0) {
            if (i8 != i10) {
                this.f3265l = i8;
            }
            b(f);
        } else if (i8 < i10 && i9 != 0) {
            if (i10 - i8 > 1) {
                this.f3265l = i8 + 1;
            }
            b(f - 1.0f);
        } else if (f == 0.0f) {
            this.f3265l = this.f3267n;
            postInvalidate();
        }
    }

    public int getScrollState() {
        return this.f3270s;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        ArrayList arrayList = this.f3264k;
        if (arrayList.size() <= 1) {
            return;
        }
        canvas.save();
        Paint paint = this.f3268o;
        paint.setColor(this.f3261h);
        int size = arrayList.size();
        if (size <= 0) {
            canvas.restore();
            return;
        }
        if (arrayList.get(0) != null) {
            throw new ClassCastException();
        }
        boolean z2 = this.f3257a;
        int i8 = (z2 && this.f3263j == 0) ? (size - 1) - this.f3265l : this.f3265l;
        int i9 = (z2 && this.f3263j == 0) ? (size - 1) - this.f3266m : this.f3266m;
        z8.f(null, "mIsRtl = " + this.f3257a + " DIRECTION_HORIZONTAL = " + this.f3263j + " mCurrentMarkerIndexTemp = " + i8 + " mNextMarkerIndexTemp = " + i9 + " mViewPager2.getScrollState() = " + getScrollState());
        if (this.f3270s == 0) {
            if (i8 == 0) {
                paint.setColor(this.f3262i);
                throw null;
            }
            paint.setColor(this.f3261h);
            throw null;
        }
        if (i8 == 0 && i9 == i8) {
            paint.setColor(this.f3262i);
            throw null;
        }
        if (i8 == 0) {
            int i10 = this.f3262i;
            int dynamicAlphaDe = getDynamicAlphaDe();
            if (dynamicAlphaDe < 0 || dynamicAlphaDe > 255) {
                throw new IllegalArgumentException("alpha must be between 0 and 255.");
            }
            paint.setColor((dynamicAlphaDe << 24) | (i10 & ViewCompat.MEASURED_SIZE_MASK));
            throw null;
        }
        if (i9 != 0) {
            paint.setColor(this.f3261h);
            throw null;
        }
        int i11 = this.f3262i;
        int dynamicAlphaAc = getDynamicAlphaAc();
        if (dynamicAlphaAc < 0 || dynamicAlphaAc > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        paint.setColor((dynamicAlphaAc << 24) | (i11 & ViewCompat.MEASURED_SIZE_MASK));
        throw null;
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        int iSin;
        int iCos;
        Context context = getContext();
        if (this.f3263j != 0) {
            this.q = (context.getResources().getDisplayMetrics().widthPixels / 2) - ((ViewGroup.MarginLayoutParams) getLayoutParams()).getMarginEnd();
        } else {
            this.q = (context.getResources().getDisplayMetrics().widthPixels / 2) - ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin;
        }
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i9);
        double d7 = this.f3269r;
        ArrayList arrayList = this.f3264k;
        if (mode != 1073741824) {
            if (arrayList.isEmpty()) {
                size = 0;
            } else {
                float size3 = (arrayList.size() - 1) / 2.0f;
                if (this.f3263j != 1) {
                    iCos = (int) ((Math.sin(((double) size3) * d7) * ((double) this.q) * 2.0d) + ((double) ((this.f3260d * 2) + (this.f3259c * 2))));
                } else {
                    double d10 = this.q;
                    iCos = (int) ((d10 - (Math.cos(((double) size3) * d7) * d10)) + ((double) (this.f3260d * 2)) + ((double) (this.f3259c * 2)));
                }
                size = iCos;
            }
        }
        if (mode2 != 1073741824) {
            if (arrayList.isEmpty()) {
                size2 = 0;
            } else {
                float size4 = (arrayList.size() - 1) / 2.0f;
                if (this.f3263j != 1) {
                    double d11 = this.q;
                    iSin = (int) ((d11 - (Math.cos(d7 * ((double) size4)) * d11)) + ((double) (this.f3260d * 2)) + ((double) (this.f3258b * 2)));
                } else {
                    iSin = (int) ((Math.sin(d7 * ((double) size4)) * ((double) this.q) * 2.0d) + ((double) ((this.f3260d * 2) + (this.f3258b * 2))));
                }
                size2 = iSin;
            }
        }
        setMeasuredDimension(size, size2);
        arrayList.size();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        z8.f(null, "MotionEvent = " + MotionEvent.actionToString(motionEvent.getAction()));
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        motionEvent.getX();
        motionEvent.getY();
        ArrayList arrayList = this.f3264k;
        if (arrayList.size() <= 0) {
            return false;
        }
        d.y(arrayList.get(0));
        throw null;
    }

    public void setCurrent(int i8) {
        if (i8 == this.f3265l) {
            return;
        }
        if (i8 >= 0) {
            ArrayList arrayList = this.f3264k;
            if (i8 <= arrayList.size() - 1) {
                this.f3267n = i8;
                this.f3265l = i8;
                if (arrayList.size() <= 0) {
                    postInvalidate();
                    return;
                } else {
                    d.y(arrayList.get(0));
                    throw null;
                }
            }
        }
        throw new RuntimeException("OSWatchPageIndicator ArrayIndexOutOfBoundsException: index out of bounds.");
    }

    public void setDirection(int i8) {
        this.f3263j = i8;
        requestLayout();
    }

    public void setIsRtl(boolean z2) {
        this.f3257a = z2;
        requestLayout();
    }

    public void setNormalCircleRadius(int i8) {
        this.f3260d = i8;
        requestLayout();
    }

    public void setNormalColor(@ColorInt int i8) {
        this.f3261h = i8;
        invalidate();
    }

    public void setOnMarkerClickListener(c cVar) {
    }

    public void setSelectedCircleRadius(int i8) {
        this.e = i8;
        requestLayout();
    }

    public void setSelectedColor(@ColorInt int i8) {
        this.f3262i = i8;
        invalidate();
    }

    public OSWatchPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3265l = 0;
        this.f3266m = 0;
        this.f3267n = 0;
        this.q = 233;
        this.f3270s = 0;
        new td.a(this);
        new b(this);
        setLayerType(1, null);
        this.f3257a = j.v();
        Resources resources = context.getResources();
        this.f3260d = resources.getDimensionPixelOffset(R$dimen.os_watch_page_marker_normal_radius);
        this.e = resources.getDimensionPixelOffset(R$dimen.os_watch_page_marker_selected_radius);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSWatchPageIndicator);
        this.f3261h = typedArrayObtainStyledAttributes.getColor(R$styleable.OSWatchPageIndicator_osWatchPINormalColor, getResources().getColor(R$color.os_watch_indicator_normal_color));
        this.f3262i = typedArrayObtainStyledAttributes.getColor(R$styleable.OSWatchPageIndicator_osWatchPISelectedColor, getResources().getColor(R$color.os_watch_indicator_selected_color));
        this.e = typedArrayObtainStyledAttributes.getColor(R$styleable.OSWatchPageIndicator_osWatchPISelectedRadius, this.e);
        this.f3260d = typedArrayObtainStyledAttributes.getColor(R$styleable.OSWatchPageIndicator_osWatchPISelectedColor, this.f3260d);
        this.f3269r = ((double) (typedArrayObtainStyledAttributes.getInteger(R$styleable.OSWatchPageIndicator_osWatchPIAngle, 7) / 180.0f)) * 3.141592653589793d;
        this.f3263j = typedArrayObtainStyledAttributes.getInt(R$styleable.OSWatchPageIndicator_osWatchPINDirection, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f3264k = new ArrayList();
        Paint paint = new Paint();
        this.f3268o = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        int i8 = (this.e - this.f3260d) + 1;
        this.f3259c = i8;
        this.f3258b = i8;
    }
}
