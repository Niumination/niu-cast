package pj;

import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class e implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13154e = 9;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13155f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13156g = "EG_ar";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13157h = "IR_fa";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13161d;

    public e() {
        this(0, 9, null);
    }

    @Override // pj.i
    public int a() {
        return (this.f13159b - this.f13158a) + 1;
    }

    @Override // pj.i
    public int b() {
        int length = Integer.toString(Math.max(Math.abs(this.f13159b), Math.abs(this.f13158a))).length();
        return this.f13158a < 0 ? length + 1 : length;
    }

    public int c() {
        return this.f13159b;
    }

    public int d() {
        return this.f13158a;
    }

    public void e(int i10) {
        this.f13159b = i10;
    }

    public void f(int i10) {
        this.f13158a = i10;
    }

    @Override // pj.i
    public String getItem(int i10) {
        if (i10 < 0 || i10 >= a()) {
            return null;
        }
        int i11 = this.f13158a + i10;
        if (this.f13161d) {
            String str = this.f13160c;
            return str != null ? String.format(str, Integer.valueOf(i11)) : String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i11)).concat("");
        }
        String str2 = this.f13160c;
        return str2 != null ? String.format(str2, Integer.valueOf(i11)) : Integer.toString(i11);
    }

    public e(int i10, int i11) {
        this(i10, i11, null);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0056  */
    public e(int i10, int i11, String str) {
        boolean z10;
        this.f13158a = i10;
        this.f13159b = i11;
        this.f13160c = str;
        Locale locale = Locale.getDefault();
        if ((locale.getCountry() + "_" + locale.getLanguage()).equals(f13156g)) {
            z10 = true;
        } else {
            if ((locale.getCountry() + "_" + locale.getLanguage()).equals(f13157h)) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        this.f13161d = z10;
    }
}
