package p1;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f8621d;
    public int e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f8625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PointF f8627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PointF f8628m;

    public final int hashCode() {
        int iOrdinal = ((this.f8621d.ordinal() + (((int) (a1.a.e(this.f8618a.hashCode() * 31, 31, this.f8619b) + this.f8620c)) * 31)) * 31) + this.e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f);
        return (((iOrdinal * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f8623h;
    }
}
