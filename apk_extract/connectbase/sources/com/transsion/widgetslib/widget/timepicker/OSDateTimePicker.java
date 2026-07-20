package com.transsion.widgetslib.widget.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.widget.timepicker.wheel.WheelView;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class OSDateTimePicker extends LinearLayout {
    public static int R = 1900;
    public static int S = 2100;
    public static final String T = "yyyy-MM-dd HH:mm";
    public static final String U = "yyyy-MM-dd";
    public static final String V = "MM-dd";
    public static final String W = "MM-dd HH:mm";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f3224a0 = "HH:mm";
    public WheelView.g H;
    public WheelView.g I;
    public WheelView.g J;
    public boolean K;
    public String L;
    public Context M;
    public final int N;
    public String O;
    public Vibrator P;
    public Runnable Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Calendar f3225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WheelView f3226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WheelView f3227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f3228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WheelView f3229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WheelView f3230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WheelView f3231g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WheelView f3232i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<String> f3233n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<String> f3234p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public i f3235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WheelView.g f3236w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WheelView.g f3237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public WheelView.g f3238y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public WheelView.g f3239z;

    public class a implements WheelView.g {
        public a() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void a(int i10, int i11) {
            OSDateTimePicker.this.B(OSDateTimePicker.R + i11);
            OSDateTimePicker.this.A();
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void b(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void c(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void d(int i10) {
        }
    }

    public class b implements WheelView.g {
        public b() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void a(int i10, int i11) {
            OSDateTimePicker.this.z(i11);
            OSDateTimePicker.this.A();
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void b(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void c(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void d(int i10) {
        }
    }

    public class c implements WheelView.g {
        public c() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void a(int i10, int i11) {
            OSDateTimePicker.this.y(i11 + 1);
            OSDateTimePicker.this.A();
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void b(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void c(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void d(int i10) {
        }
    }

    public class d implements WheelView.g {
        public d() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void a(int i10, int i11) {
            if (i11 > i10) {
                if (i11 - i10 > 10) {
                    OSDateTimePicker oSDateTimePicker = OSDateTimePicker.this;
                    oSDateTimePicker.S(oSDateTimePicker.f3225a.get(1) - 1, true);
                } else {
                    OSDateTimePicker.this.f3225a.set(6, i11 + 1);
                }
            } else if (i11 < i10) {
                if (i10 - i11 > 10) {
                    OSDateTimePicker oSDateTimePicker2 = OSDateTimePicker.this;
                    oSDateTimePicker2.S(oSDateTimePicker2.f3225a.get(1) + 1, false);
                } else {
                    OSDateTimePicker.this.f3225a.set(6, i11 + 1);
                }
            }
            OSDateTimePicker.this.k();
            OSDateTimePicker.this.A();
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void b(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void c(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void d(int i10) {
        }
    }

    public class e implements WheelView.g {
        public e() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void a(int i10, int i11) {
            OSDateTimePicker.this.f3225a.set(9, i11);
            OSDateTimePicker.this.k();
            OSDateTimePicker.this.A();
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void b(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void c(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void d(int i10) {
        }
    }

    public class f implements WheelView.g {
        public f() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void a(int i10, int i11) {
            if (!OSDateTimePicker.this.K) {
                i11 = (i11 + 1) % 12;
            }
            OSDateTimePicker oSDateTimePicker = OSDateTimePicker.this;
            oSDateTimePicker.f3225a.set(oSDateTimePicker.K ? 11 : 10, i11);
            OSDateTimePicker.this.k();
            OSDateTimePicker.this.A();
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void b(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void c(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void d(int i10) {
        }
    }

    public class g implements WheelView.g {
        public g() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void a(int i10, int i11) {
            OSDateTimePicker.this.f3225a.set(12, i11);
            OSDateTimePicker.this.k();
            OSDateTimePicker.this.A();
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void b(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void c(int i10) {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.wheel.WheelView.g
        public void d(int i10) {
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSDateTimePicker.this.x();
        }
    }

    public interface i {
        void a(OSDateTimePicker oSDateTimePicker, Calendar calendar);
    }

    public OSDateTimePicker(Context context) {
        super(context);
        this.f3225a = Calendar.getInstance();
        this.f3233n = new ArrayList<>();
        this.f3234p = new ArrayList<>();
        this.N = 5;
        this.O = getClass().getSimpleName();
        this.Q = new h();
        this.M = context;
    }

    public final void A() {
        Handler handler = getHandler();
        if (!hj.h.D || handler == null || handler.hasCallbacks(this.Q)) {
            return;
        }
        handler.postDelayed(this.Q, 50L);
    }

    public final void B(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, this.f3225a.get(2));
        calendar.set(5, 1);
        int actualMaximum = calendar.getActualMaximum(5);
        if (actualMaximum < this.f3228d.getSelectedItemPosition() + 1) {
            this.f3225a.set(5, actualMaximum);
        }
        this.f3225a.set(1, i10);
        Q();
        k();
    }

    public final void C() {
        o();
        if (this.f3235v != null) {
            k();
        }
    }

    public void D() {
        K();
        J();
        E();
        I();
        G();
        H();
        F();
    }

    public final void E() {
        WheelView wheelView = this.f3228d;
        if (wheelView != null) {
            wheelView.setOnWheelChangedListener(this.f3238y);
            this.f3238y = null;
            this.f3228d = null;
        }
    }

    public final void F() {
        if (this.f3230f != null) {
            this.f3234p.clear();
            this.f3230f.setOnWheelChangedListener(this.J);
            this.J = null;
            this.f3230f = null;
        }
    }

    public final void G() {
        WheelView wheelView = this.f3231g;
        if (wheelView != null) {
            wheelView.setOnWheelChangedListener(this.H);
            this.H = null;
            this.f3231g = null;
        }
    }

    public final void H() {
        WheelView wheelView = this.f3232i;
        if (wheelView != null) {
            wheelView.setOnWheelChangedListener(this.I);
            this.I = null;
            this.f3232i = null;
        }
    }

    public final void I() {
        WheelView wheelView = this.f3229e;
        if (wheelView != null) {
            wheelView.setOnWheelChangedListener(this.f3239z);
            this.f3239z = null;
            this.f3229e = null;
        }
    }

    public final void J() {
        WheelView wheelView = this.f3227c;
        if (wheelView != null) {
            wheelView.setOnWheelChangedListener(this.f3237x);
            this.f3237x = null;
            this.f3233n.clear();
            this.f3227c = null;
        }
    }

    public final void K() {
        WheelView wheelView = this.f3226b;
        if (wheelView != null) {
            wheelView.setOnWheelChangedListener(this.f3236w);
            this.f3236w = null;
            this.f3226b = null;
        }
    }

    public final void L(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        WheelView wheelView = this.f3227c;
        if (wheelView != null && i11 != 0) {
            ((LinearLayout.LayoutParams) wheelView.getLayoutParams()).setMarginStart(i11);
        }
        WheelView wheelView2 = this.f3228d;
        if (wheelView2 != null && i12 != 0) {
            ((LinearLayout.LayoutParams) wheelView2.getLayoutParams()).setMarginStart(i12);
        }
        WheelView wheelView3 = this.f3229e;
        if (wheelView3 != null && i13 != 0) {
            ((LinearLayout.LayoutParams) wheelView3.getLayoutParams()).setMarginStart(i13);
        }
        WheelView wheelView4 = this.f3226b;
        if (wheelView4 != null && i10 != 0) {
            ((LinearLayout.LayoutParams) wheelView4.getLayoutParams()).setMarginStart(i10);
        }
        WheelView wheelView5 = this.f3231g;
        if (wheelView5 != null && i14 != 0) {
            ((LinearLayout.LayoutParams) wheelView5.getLayoutParams()).setMarginStart(i14);
        }
        WheelView wheelView6 = this.f3232i;
        if (wheelView6 != null && i15 != 0) {
            ((LinearLayout.LayoutParams) wheelView6.getLayoutParams()).setMarginStart(i15);
        }
        WheelView wheelView7 = this.f3230f;
        if (wheelView7 == null || i16 == 0) {
            return;
        }
        ((LinearLayout.LayoutParams) wheelView7.getLayoutParams()).setMarginStart(i16);
    }

    public final void M(WheelView wheelView, int i10) {
        if (wheelView != null) {
            wheelView.setWheelBackgroundColor(i10);
        }
    }

    public void N(int i10, int i11) {
        if (i11 < i10) {
            return;
        }
        R = i10;
        S = i11;
    }

    public void O(int i10, int i11, int i12) {
        Calendar calendar = this.f3225a;
        if (calendar != null) {
            calendar.set(1, i10);
            this.f3225a.set(2, i11);
            this.f3225a.set(5, i12);
            D();
            C();
        }
    }

    public void P(int i10, int i11, int i12, int i13, int i14) {
        Calendar calendar = this.f3225a;
        if (calendar != null) {
            calendar.set(1, i10);
            this.f3225a.set(2, i11);
            this.f3225a.set(5, i12);
            this.f3225a.set(11, i13);
            this.f3225a.set(12, i14);
            D();
            C();
        }
    }

    public final void Q() {
        WheelView wheelView = this.f3228d;
        if (wheelView != null) {
            int selectedItemPosition = wheelView.getSelectedItemPosition();
            int i10 = selectedItemPosition + 1;
            int actualMaximum = this.f3225a.getActualMaximum(5);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 1; i11 < actualMaximum + 1; i11++) {
                arrayList.add(Integer.valueOf(i11));
            }
            this.f3228d.setData(arrayList);
            if (i10 < actualMaximum) {
                this.f3228d.setSelectedItemPosition(selectedItemPosition);
            } else {
                this.f3228d.setSelectedItemPosition(actualMaximum - 1);
            }
        }
    }

    public void R() {
        int iL;
        int i10;
        int i11;
        int i12;
        int iL2;
        int iL3;
        int iL4;
        int i13;
        int i14;
        int i15;
        int i16;
        int iL5;
        int iL6;
        int iL7;
        int iL8;
        int iL9;
        int iL10;
        int iL11;
        int iL12;
        String str = this.L;
        str.getClass();
        switch (str) {
            case "MM-dd HH:mm":
                if (hj.h.I()) {
                    if (!this.K) {
                        int iL13 = l(0);
                        int iL14 = l(12);
                        int iL15 = l(12);
                        iL = l(0);
                        this.f3230f.setVisibility(0);
                        i10 = iL13;
                        i12 = iL15;
                        i11 = iL14;
                        i13 = iL;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                    } else {
                        iL2 = l(16);
                        iL3 = l(36);
                        iL4 = l(46);
                        this.f3230f.setVisibility(8);
                        i10 = iL2;
                        i11 = iL3;
                        i12 = iL4;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i13 = 0;
                    }
                    break;
                } else {
                    if (!this.K) {
                        int iL16 = l(6);
                        int iL17 = l(8);
                        int iL18 = l(17);
                        iL = l(0);
                        this.f3230f.setVisibility(0);
                        i10 = iL16;
                        i11 = iL17;
                        i12 = iL18;
                        i13 = iL;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                    } else {
                        iL2 = l(20);
                        iL3 = l(26);
                        iL4 = l(36);
                        this.f3230f.setVisibility(8);
                        i10 = iL2;
                        i11 = iL3;
                        i12 = iL4;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i13 = 0;
                    }
                    break;
                }
                break;
            case "yyyy-MM-dd":
                if (hj.h.I()) {
                    iL5 = l(28);
                    iL6 = l(8);
                    iL7 = l(30);
                } else {
                    iL5 = l(36);
                    iL6 = l(16);
                    iL7 = l(10);
                }
                i14 = iL5;
                i15 = iL6;
                i16 = iL7;
                i10 = 0;
                i11 = i10;
                i12 = i11;
                i13 = i12;
                break;
            case "HH:mm":
                if (hj.h.I()) {
                    if (!this.K) {
                        iL8 = l(56);
                        iL9 = l(40);
                        iL10 = l(40);
                        this.f3230f.setVisibility(0);
                        i11 = iL8;
                        i12 = iL9;
                        i13 = iL10;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i10 = 0;
                    } else {
                        iL11 = l(72);
                        iL12 = l(88);
                        this.f3230f.setVisibility(8);
                        i11 = iL11;
                        i12 = iL12;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i10 = 0;
                        i13 = 0;
                    }
                    break;
                } else {
                    if (!this.K) {
                        iL8 = l(40);
                        iL9 = l(56);
                        iL10 = l(40);
                        this.f3230f.setVisibility(0);
                        i11 = iL8;
                        i12 = iL9;
                        i13 = iL10;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i10 = 0;
                    } else {
                        iL11 = l(88);
                        iL12 = l(72);
                        this.f3230f.setVisibility(8);
                        i11 = iL11;
                        i12 = iL12;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i10 = 0;
                        i13 = 0;
                    }
                    break;
                }
                break;
            default:
                i14 = 0;
                i15 = 0;
                i16 = 0;
                i10 = 0;
                i11 = i10;
                i12 = i11;
                i13 = i12;
                break;
        }
        L(i14, i15, i16, i10, i11, i12, i13);
    }

    public final void S(int i10, boolean z10) {
        Calendar calendar = this.f3225a;
        calendar.set(6, calendar.getMinimum(6));
        this.f3225a.set(1, i10);
        Calendar calendar2 = this.f3225a;
        calendar2.set(6, z10 ? calendar2.getActualMaximum(6) : calendar2.getMinimum(6));
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 < this.f3225a.getActualMaximum(6) + 1; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        this.f3229e.setData(arrayList);
        int i12 = this.f3225a.get(6);
        this.f3229e.setOnWheelChangedListener(null);
        this.f3229e.setSelectedItemPosition(i12 - 1);
        this.f3229e.setOnWheelChangedListener(this.f3239z);
    }

    public void T(int i10, int i11) {
        Calendar calendar = this.f3225a;
        if (calendar != null) {
            calendar.set(11, i10);
            this.f3225a.set(12, i11);
            D();
            C();
        }
    }

    public final void k() {
        i iVar = this.f3235v;
        if (iVar != null) {
            iVar.a(this, this.f3225a);
        }
    }

    public final int l(int i10) {
        return (int) TypedValue.applyDimension(1, i10, this.M.getResources().getDisplayMetrics());
    }

    public void m(String str) {
        this.L = str;
        if (hj.h.I()) {
            LayoutInflater.from(this.M).inflate(R.layout.os_picker_date_layout_rtl, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(this.M).inflate(R.layout.os_picker_date_layout, (ViewGroup) this, true);
        }
        o();
        this.P = (Vibrator) this.M.getSystemService("vibrator");
    }

    public void n(Calendar calendar, String str) {
        this.f3225a = calendar;
        m(str);
    }

    public final void o() {
        String str = this.L;
        str.getClass();
        switch (str) {
            case "yyyy-MM-dd HH:mm":
                v();
                u();
                p();
                q();
                r();
                break;
            case "MM-dd HH:mm":
                s();
                q();
                r();
                break;
            case "yyyy-MM-dd":
                v();
                u();
                p();
                break;
            case "HH:mm":
                q();
                r();
                break;
            case "MM-dd":
                u();
                p();
                break;
        }
        R();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public final void p() {
        int i10 = this.f3225a.get(5);
        WheelView wheelView = (WheelView) findViewById(R.id.dayWheel);
        this.f3228d = wheelView;
        wheelView.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 < this.f3225a.getActualMaximum(5) + 1; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        this.f3228d.setData(arrayList);
        this.f3228d.setVisibleItems(5);
        this.f3228d.setCyclic(true);
        this.f3228d.setSelectedItemPosition(i10 - 1);
        c cVar = new c();
        this.f3238y = cVar;
        this.f3228d.setOnWheelChangedListener(cVar);
    }

    public final void q() {
        WheelView wheelView = (WheelView) findViewById(R.id.hourWheel);
        this.f3231g = wheelView;
        wheelView.setVisibility(0);
        this.f3230f = (WheelView) findViewById(R.id.formatWheel);
        this.K = hj.h.w(this.M);
        this.f3231g.setHourWheel(true);
        this.f3231g.set24HoursFormat(this.K);
        int i10 = this.K ? this.f3225a.get(11) : this.f3225a.get(10);
        if (this.K) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < 24; i11++) {
                arrayList.add(Integer.valueOf(i11));
            }
            this.f3231g.setData(arrayList);
            this.f3231g.setSelectedItemPosition(i10);
        } else {
            this.f3234p.clear();
            this.f3234p.add(this.M.getString(R.string.f2305am));
            this.f3234p.add(this.M.getString(R.string.f2306pm));
            ArrayList arrayList2 = new ArrayList();
            for (int i12 = 1; i12 < 13; i12++) {
                arrayList2.add(Integer.valueOf(i12));
            }
            this.f3231g.setData(arrayList2);
            this.f3231g.setSelectedItemPosition((i10 + 11) % 12);
            int i13 = this.f3225a.get(9);
            this.f3230f.setData(this.f3234p);
            this.f3230f.setVisibleItems(3);
            this.f3230f.setCyclic(false);
            this.f3230f.setSelectedItemPosition(i13);
            this.f3230f.setAmPmWheel(true);
            e eVar = new e();
            this.J = eVar;
            this.f3230f.setOnWheelChangedListener(eVar);
        }
        this.f3231g.setVisibleItems(5);
        this.f3231g.setCyclic(true);
        f fVar = new f();
        this.H = fVar;
        this.f3231g.setOnWheelChangedListener(fVar);
    }

    public final void r() {
        int i10 = this.f3225a.get(12);
        WheelView wheelView = (WheelView) findViewById(R.id.minWheel);
        this.f3232i = wheelView;
        wheelView.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 60; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        this.f3232i.setMinuteWheel(true);
        this.f3232i.setData(arrayList);
        this.f3232i.setSelectedItemPosition(i10);
        this.f3232i.setVisibleItems(5);
        this.f3232i.setCyclic(true);
        g gVar = new g();
        this.I = gVar;
        this.f3232i.setOnWheelChangedListener(gVar);
    }

    public final void s() {
        t();
        int i10 = this.f3225a.get(6);
        WheelView wheelView = (WheelView) findViewById(R.id.monthDayWheel);
        this.f3229e = wheelView;
        wheelView.setVisibility(0);
        this.f3229e.l0(this.f3225a, true);
        this.f3229e.setMonthList(this.f3233n);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 < this.f3225a.getActualMaximum(6) + 1; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        this.f3229e.setData(arrayList);
        this.f3229e.setVisibleItems(5);
        this.f3229e.setCyclic(true);
        this.f3229e.setSelectedItemPosition(i10 - 1);
        d dVar = new d();
        this.f3239z = dVar;
        this.f3229e.setOnWheelChangedListener(dVar);
    }

    public void setOnDateChangeListener(i iVar) {
        this.f3235v = iVar;
        k();
    }

    public void setWheelBackgroundColor(int i10) {
        M(this.f3226b, i10);
        M(this.f3227c, i10);
        M(this.f3228d, i10);
        M(this.f3229e, i10);
        M(this.f3230f, i10);
        M(this.f3231g, i10);
        M(this.f3232i, i10);
    }

    public void setWheelBackgroundColorRes(int i10) {
        Context context = this.M;
        if (context != null) {
            setWheelBackgroundColor(ContextCompat.getColor(context, i10));
        }
    }

    public final void t() {
        Resources resources = this.M.getResources();
        this.f3233n.add(resources.getString(R.string.jan));
        this.f3233n.add(resources.getString(R.string.feb));
        this.f3233n.add(resources.getString(R.string.mar));
        this.f3233n.add(resources.getString(R.string.apr));
        this.f3233n.add(resources.getString(R.string.may));
        this.f3233n.add(resources.getString(R.string.jun));
        this.f3233n.add(resources.getString(R.string.jul));
        this.f3233n.add(resources.getString(R.string.aug));
        this.f3233n.add(resources.getString(R.string.sep));
        this.f3233n.add(resources.getString(R.string.oct));
        this.f3233n.add(resources.getString(R.string.nov));
        this.f3233n.add(resources.getString(R.string.dec));
    }

    public final void u() {
        int i10 = this.f3225a.get(2);
        WheelView wheelView = (WheelView) findViewById(R.id.monthWheel);
        this.f3227c = wheelView;
        wheelView.setVisibility(0);
        t();
        this.f3227c.setData(this.f3233n);
        this.f3227c.setVisibleItems(5);
        this.f3227c.setCyclic(true);
        this.f3227c.setSelectedItemPosition(i10);
        b bVar = new b();
        this.f3237x = bVar;
        this.f3227c.setOnWheelChangedListener(bVar);
    }

    public final void v() {
        int i10 = this.f3225a.get(1);
        WheelView wheelView = (WheelView) findViewById(R.id.yearWheel);
        this.f3226b = wheelView;
        wheelView.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (int i11 = R; i11 < Math.max(i10, S) + 1; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        this.f3226b.setData(arrayList);
        this.f3226b.setVisibleItems(5);
        this.f3226b.setCyclic(true);
        WheelView wheelView2 = this.f3226b;
        int i12 = R;
        wheelView2.setSelectedItemPosition(i10 > i12 ? i10 - i12 : 0);
        a aVar = new a();
        this.f3236w = aVar;
        this.f3226b.setOnWheelChangedListener(aVar);
    }

    public boolean w() {
        return this.K;
    }

    public final void x() {
        Vibrator vibrator;
        if (Settings.System.getInt(getContext().getContentResolver(), "haptic_feedback_enabled", 0) != 0 && (vibrator = this.P) != null && vibrator.hasVibrator() && hasWindowFocus()) {
            this.P.cancel();
            this.P.vibrate(new long[]{0, 40}, -1);
        }
    }

    public final void y(int i10) {
        this.f3225a.set(5, i10);
        k();
    }

    public final void z(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f3225a.get(1));
        calendar.set(2, i10);
        int actualMaximum = calendar.getActualMaximum(5);
        if (actualMaximum < this.f3225a.get(5)) {
            this.f3225a.set(5, actualMaximum);
        }
        this.f3225a.set(2, i10);
        Q();
        k();
    }

    public OSDateTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3225a = Calendar.getInstance();
        this.f3233n = new ArrayList<>();
        this.f3234p = new ArrayList<>();
        this.N = 5;
        this.O = getClass().getSimpleName();
        this.Q = new h();
        this.M = context;
    }
}
