package com.transsion.connectx.mirror.source.bean;

import android.app.Application;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.transsion.connectx.mirror.source.SourceApplication;
import k0.d;
import kn.l0;
import kn.w;
import nm.r;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class PadMotionEventBean implements Parcelable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final String f1931f = "PadMotionEventBean";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1932g = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1933i = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f1934n = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f1935p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public MotionEvent f1937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1941e;

    @l
    public static final a CREATOR = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public static PadMotionEventBean f1936v = new PadMotionEventBean(null, 1, 1, false, 0, 24, null);

    public static final class a implements Parcelable.Creator<PadMotionEventBean> {
        public a() {
        }

        public static /* synthetic */ PadMotionEventBean c(a aVar, MotionEvent motionEvent, int i10, int i11, boolean z10, int i12, int i13, Object obj) {
            if ((i13 & 8) != 0) {
                z10 = false;
            }
            boolean z11 = z10;
            if ((i13 & 16) != 0) {
                i12 = 1;
            }
            return aVar.b(motionEvent, i10, i11, z11, i12);
        }

        @l
        public final PadMotionEventBean a(@l byte[] bArr) {
            l0.p(bArr, "data");
            Parcel parcelObtain = Parcel.obtain();
            l0.o(parcelObtain, "obtain(...)");
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                return createFromParcel(parcelObtain);
            } finally {
                parcelObtain.recycle();
            }
        }

        @l
        public final PadMotionEventBean b(@l MotionEvent motionEvent, int i10, int i11, boolean z10, int i12) {
            l0.p(motionEvent, "motionEvent");
            PadMotionEventBean padMotionEventBean = PadMotionEventBean.f1936v;
            padMotionEventBean.f1937a = motionEvent;
            padMotionEventBean.f1938b = i10;
            padMotionEventBean.f1939c = i11;
            padMotionEventBean.f1940d = z10;
            padMotionEventBean.f1941e = i12;
            return padMotionEventBean;
        }

        @Override // android.os.Parcelable.Creator
        @l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public PadMotionEventBean createFromParcel(@l Parcel parcel) {
            l0.p(parcel, "parcel");
            return new PadMotionEventBean(parcel);
        }

        @l
        public PadMotionEventBean[] e(int i10) {
            return new PadMotionEventBean[i10];
        }

        @Override // android.os.Parcelable.Creator
        public PadMotionEventBean[] newArray(int i10) {
            return new PadMotionEventBean[i10];
        }

        public a(w wVar) {
        }
    }

    public PadMotionEventBean(@m MotionEvent motionEvent, int i10, int i11, boolean z10, int i12) {
        this.f1937a = motionEvent;
        this.f1938b = i10;
        this.f1939c = i11;
        this.f1940d = z10;
        this.f1941e = i12;
    }

    public static PadMotionEventBean h(PadMotionEventBean padMotionEventBean, MotionEvent motionEvent, int i10, int i11, boolean z10, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            motionEvent = padMotionEventBean.f1937a;
        }
        if ((i13 & 2) != 0) {
            i10 = padMotionEventBean.f1938b;
        }
        int i14 = i10;
        if ((i13 & 4) != 0) {
            i11 = padMotionEventBean.f1939c;
        }
        int i15 = i11;
        if ((i13 & 8) != 0) {
            z10 = padMotionEventBean.f1940d;
        }
        boolean z11 = z10;
        if ((i13 & 16) != 0) {
            i12 = padMotionEventBean.f1941e;
        }
        padMotionEventBean.getClass();
        return new PadMotionEventBean(motionEvent, i14, i15, z11, i12);
    }

    @m
    public final MotionEvent b() {
        return this.f1937a;
    }

    public final int c() {
        return this.f1938b;
    }

    public final int d() {
        return this.f1939c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.f1940d;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PadMotionEventBean)) {
            return false;
        }
        PadMotionEventBean padMotionEventBean = (PadMotionEventBean) obj;
        return l0.g(this.f1937a, padMotionEventBean.f1937a) && this.f1938b == padMotionEventBean.f1938b && this.f1939c == padMotionEventBean.f1939c && this.f1940d == padMotionEventBean.f1940d && this.f1941e == padMotionEventBean.f1941e;
    }

    public final int f() {
        return this.f1941e;
    }

    @l
    public final PadMotionEventBean g(@m MotionEvent motionEvent, int i10, int i11, boolean z10, int i12) {
        return new PadMotionEventBean(motionEvent, i10, i11, z10, i12);
    }

    public int hashCode() {
        MotionEvent motionEvent = this.f1937a;
        return Integer.hashCode(this.f1941e) + ((Boolean.hashCode(this.f1940d) + d.a(this.f1939c, d.a(this.f1938b, (motionEvent == null ? 0 : motionEvent.hashCode()) * 31, 31), 31)) * 31);
    }

    public final DisplayMetrics i(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        l0.n(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public final int j() {
        return this.f1941e;
    }

    public final boolean k() {
        return this.f1940d;
    }

    @m
    public final MotionEvent l() {
        return this.f1937a;
    }

    public final int m() {
        return this.f1939c;
    }

    public final int n() {
        return this.f1938b;
    }

    @l
    public final byte[] o() {
        Parcel parcelObtain = Parcel.obtain();
        l0.o(parcelObtain, "obtain(...)");
        try {
            writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            l0.o(bArrMarshall, "marshall(...)");
            return bArrMarshall;
        } finally {
            parcelObtain.recycle();
        }
    }

    @m
    public final MotionEvent p(@l VirtualDisplay virtualDisplay, boolean z10) {
        DisplayMetrics displayMetricsI;
        l0.p(virtualDisplay, "virtualDisplay");
        try {
            Application applicationB = SourceApplication.b();
            MotionEvent motionEvent = this.f1937a;
            if (motionEvent == null) {
                return null;
            }
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[motionEvent.getPointerCount()];
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[motionEvent.getPointerCount()];
            if (z10) {
                l0.m(applicationB);
                displayMetricsI = i(applicationB);
            } else {
                Display display = virtualDisplay.getDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                displayMetricsI = displayMetrics;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i10 = 0; i10 < pointerCount; i10++) {
                MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                motionEvent.getPointerProperties(i10, pointerProperties);
                pointerPropertiesArr[i10] = pointerProperties;
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                if (motionEvent.getAction() == 8) {
                    motionEvent.getPointerCoords(i10, pointerCoords);
                }
                if (this.f1940d) {
                    pointerCoords.x = ((this.f1939c - motionEvent.getY(i10)) / this.f1939c) * displayMetricsI.widthPixels;
                    pointerCoords.y = (motionEvent.getX(i10) / this.f1938b) * displayMetricsI.heightPixels;
                } else {
                    pointerCoords.x = (motionEvent.getX(i10) / this.f1938b) * displayMetricsI.widthPixels;
                    pointerCoords.y = (motionEvent.getY(i10) / this.f1939c) * displayMetricsI.heightPixels;
                }
                pointerCoordsArr[i10] = pointerCoords;
            }
            k4.m.b(f1931f, "surfaceWidth: " + this.f1938b + ",  displayMetrics.widthPixels: " + displayMetricsI.widthPixels + "\nsurfaceHeight: " + this.f1939c + ",  displayMetrics.heightPixels: " + displayMetricsI.heightPixels + "\nmIsWidthAndHeightSwap: " + this.f1940d + "\nmFlag: " + this.f1941e);
            if (motionEvent.getAction() == 0) {
                f1935p = SystemClock.uptimeMillis();
            }
            return m4.a.C0275a.f10375a.s(f1935p, SystemClock.uptimeMillis(), motionEvent.getAction(), motionEvent.getPointerCount(), (MotionEvent.PointerProperties[]) r.Pq(pointerPropertiesArr), (MotionEvent.PointerCoords[]) r.Pq(pointerCoordsArr), motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), z10 ? 0 : virtualDisplay.getDisplay().getDisplayId(), this.f1941e != 2 ? m4.a.C0275a.f10375a.q() : m4.a.C0275a.f10375a.x());
        } catch (Exception e10) {
            k4.m.c(f1931f, "resetMotionEvent: " + e10.getMessage());
            return null;
        }
    }

    public final void q(int i10) {
        this.f1941e = i10;
    }

    public final void r(boolean z10) {
        this.f1940d = z10;
    }

    public final void s(@m MotionEvent motionEvent) {
        this.f1937a = motionEvent;
    }

    public final void t(int i10) {
        this.f1939c = i10;
    }

    @l
    public String toString() {
        MotionEvent motionEvent = this.f1937a;
        int i10 = this.f1938b;
        int i11 = this.f1939c;
        boolean z10 = this.f1940d;
        int i12 = this.f1941e;
        StringBuilder sb2 = new StringBuilder("PadMotionEventBean(motionEvent=");
        sb2.append(motionEvent);
        sb2.append(", surfaceWidth=");
        sb2.append(i10);
        sb2.append(", surfaceHeight=");
        sb2.append(i11);
        sb2.append(", mIsWidthAndHeightSwap=");
        sb2.append(z10);
        sb2.append(", mFlag=");
        return c.a.a(sb2, i12, ")");
    }

    public final void u(int i10) {
        this.f1938b = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@l Parcel parcel, int i10) {
        l0.p(parcel, "parcel");
        parcel.writeParcelable(this.f1937a, i10);
        parcel.writeInt(this.f1938b);
        parcel.writeInt(this.f1939c);
        parcel.writeBoolean(this.f1940d);
        parcel.writeInt(this.f1941e);
    }

    public /* synthetic */ PadMotionEventBean(MotionEvent motionEvent, int i10, int i11, boolean z10, int i12, int i13, w wVar) {
        this(motionEvent, i10, i11, (i13 & 8) != 0 ? false : z10, (i13 & 16) != 0 ? 1 : i12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PadMotionEventBean(@l Parcel parcel) {
        this((MotionEvent) parcel.readParcelable(MotionEvent.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readBoolean(), parcel.readInt());
        l0.p(parcel, "parcel");
    }
}
