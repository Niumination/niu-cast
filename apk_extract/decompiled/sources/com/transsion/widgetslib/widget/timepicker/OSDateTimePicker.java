package com.transsion.widgetslib.widget.timepicker;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.annotation.RawRes;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.widget.timepicker.wheel.WheelView;
import he.a;
import he.b;
import he.c;
import ie.g;
import java.util.ArrayList;
import java.util.Calendar;
import pd.j;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public class OSDateTimePicker extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f3736l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f3737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Calendar f3740d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f3744k;

    public OSDateTimePicker(Context context) {
        super(context);
        this.f3737a = Calendar.getInstance();
        new ArrayList();
        new ArrayList();
        new w(this, 10);
        this.f3739c = 0;
        this.f3740d = Calendar.getInstance();
        this.e = false;
        this.f3741h = 0;
        this.f3742i = 0;
        new Handler();
        new a(this, 1);
        this.f3743j = true;
        this.f3744k = new a(this, 0);
        this.f3738b = context;
    }

    private int getSelectedHourOfDay() {
        Calendar calendar = this.f3737a;
        int i8 = calendar.get(10);
        return calendar.get(9) == 1 ? (i8 + 12) % 24 : i8;
    }

    public final void a(int i8) {
        if (i8 != 3) {
            if (i8 == 5) {
                b();
            } else if (i8 == 6) {
                b();
            } else {
                if (i8 != 7) {
                    return;
                }
                b();
            }
        }
    }

    public final void b() {
        Handler handler = getHandler();
        if (!j.f8780v || handler == null) {
            return;
        }
        a aVar = this.f3744k;
        if (handler.hasCallbacks(aVar)) {
            return;
        }
        handler.postDelayed(aVar, 50L);
    }

    public WheelView getDayWheel() {
        return null;
    }

    public int getEndYear() {
        return 2100;
    }

    public WheelView getFormatWheel() {
        return null;
    }

    public WheelView getHourWheel() {
        return null;
    }

    public WheelView getMinuteWheel() {
        return null;
    }

    public WheelView getMonthDayWheel() {
        return null;
    }

    public WheelView getMonthWheel() {
        return null;
    }

    public int getStartYear() {
        return 1900;
    }

    public WheelView getYearWheelView() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (this.f3743j) {
            throw null;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
    }

    public void setOnDateChangeListener(b bVar) {
    }

    public void setOnDialogDismissListener(g gVar) {
    }

    public void setOnWheelInvalidInputListener(c cVar) {
    }

    public void setRequireRelayout(boolean z2) {
        this.f3743j = z2;
    }

    public void setSoundEffect(boolean z2) {
    }

    public void setSoundEffectResource(@RawRes int i8) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0031  */
    public void setTimeLimitType(int i8) {
        Calendar calendar;
        boolean z2;
        if (this.f3739c == i8) {
            return;
        }
        this.f3739c = i8;
        Calendar calendar2 = this.f3737a;
        if (i8 == 3) {
            calendar = null;
            z2 = false;
        } else {
            Calendar calendar3 = this.f3740d;
            if (i8 == 1) {
                if (calendar2.before(calendar3)) {
                    calendar = (Calendar) calendar3.clone();
                    z2 = true;
                } else {
                    calendar = null;
                    z2 = false;
                }
            } else if (i8 == 2 && calendar2.after(calendar3)) {
                calendar = (Calendar) calendar3.clone();
                z2 = true;
            } else {
                calendar = null;
                z2 = false;
            }
        }
        if (!z2 || calendar == null) {
            return;
        }
        calendar2.set(1, calendar.get(1));
        calendar2.set(2, calendar.get(2));
        calendar2.set(5, calendar.get(5));
        calendar2.set(11, calendar.get(11));
        calendar2.set(12, calendar.get(12));
        calendar2.set(13, 0);
        calendar2.set(14, 0);
    }

    public void setWheelBackgroundColor(int i8) {
    }

    public void setWheelBackgroundColorRes(int i8) {
        Context context = this.f3738b;
        if (context != null) {
            setWheelBackgroundColor(ContextCompat.getColor(context, i8));
        }
    }

    public OSDateTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3737a = Calendar.getInstance();
        new ArrayList();
        new ArrayList();
        new w(this, 10);
        this.f3739c = 0;
        this.f3740d = Calendar.getInstance();
        this.e = false;
        this.f3741h = 0;
        this.f3742i = 0;
        new Handler();
        new a(this, 1);
        this.f3743j = true;
        this.f3744k = new a(this, 0);
        this.f3738b = context;
    }
}
