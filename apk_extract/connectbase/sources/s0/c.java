package s0;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f14890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f14891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f14893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f14894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColorInt
    public final int f14895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColorInt
    public final int f14896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f14897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f14898k;

    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public c(String str, String str2, float f10, a aVar, int i10, float f11, float f12, @ColorInt int i11, @ColorInt int i12, float f13, boolean z10) {
        this.f14888a = str;
        this.f14889b = str2;
        this.f14890c = f10;
        this.f14891d = aVar;
        this.f14892e = i10;
        this.f14893f = f11;
        this.f14894g = f12;
        this.f14895h = i11;
        this.f14896i = i12;
        this.f14897j = f13;
        this.f14898k = z10;
    }

    public int hashCode() {
        int iOrdinal = ((this.f14891d.ordinal() + (((int) (b.a(this.f14889b, this.f14888a.hashCode() * 31, 31) + this.f14890c)) * 31)) * 31) + this.f14892e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f14893f);
        return (((iOrdinal * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f14895h;
    }
}
