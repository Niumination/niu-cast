package pj;

import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13120g;

    public b(int i10, int i11, int i12) {
        this.f13114a = i10;
        int actualMaximum = Calendar.getInstance().getActualMaximum(5);
        if (i12 > actualMaximum) {
            this.f13114a = i11 + 1;
            this.f13116c = i12 % actualMaximum;
        } else {
            this.f13115b = i11;
            this.f13116c = i12;
        }
        this.f13120g = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i11)) + "月" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(this.f13116c)) + "日";
    }

    public int a() {
        return this.f13116c;
    }

    public int b() {
        return this.f13118e;
    }

    public String c() {
        return this.f13120g;
    }

    public int d() {
        return this.f13119f;
    }

    public int e() {
        return this.f13115b;
    }

    public int f() {
        return this.f13117d;
    }

    public int g() {
        return this.f13114a;
    }

    public void h(int i10) {
        this.f13116c = i10;
    }

    public void i(int i10) {
        this.f13118e = i10;
    }

    public void j(String str) {
        this.f13120g = str;
    }

    public void k(int i10) {
        this.f13119f = i10;
    }

    public void l(int i10) {
        this.f13115b = i10;
    }

    public void m(int i10) {
        this.f13117d = i10;
    }

    public void n(int i10) {
        this.f13114a = i10;
    }

    public b(int i10, int i11, boolean z10) {
        if (z10 && i10 != -1) {
            if (i10 > 24) {
                this.f13118e = i10 % 24;
            } else {
                this.f13118e = i10;
            }
            this.f13120g = c.a.a(new StringBuilder(), this.f13118e, "");
            return;
        }
        if (z10 || i11 == -1) {
            return;
        }
        if (i11 > 60) {
            this.f13119f = i11 % 60;
        } else {
            this.f13119f = i11;
        }
        this.f13120g = c.a.a(new StringBuilder(), this.f13119f, "");
    }
}
