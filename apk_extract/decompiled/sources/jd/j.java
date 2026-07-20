package jd;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f6182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6184d;
    public float e = 0.2f;
    public float f = 0.125f;

    /* JADX WARN: Code duplicated, block: B:9:0x001d  */
    public final boolean a(float f) {
        if (this.f6183c) {
            float f4 = this.f6182b;
            float fSignum = this.f6181a;
            float f10 = this.e;
            float f11 = this.f6184d;
            float f12 = fSignum - f4;
            if (Math.abs(f12) > f11) {
                float f13 = (f10 * f12) + f4;
                if (f4 == f13) {
                    fSignum = f13;
                } else {
                    float fB = a1.a.b(f13, f4, f, f4);
                    if (Math.abs(fB - f4) >= 1.0E-4f && fB != f4 && ((f4 <= f13 || fB >= f13) && (f4 >= f13 || fB <= f13))) {
                        fSignum = fB;
                    } else {
                        fSignum = f13;
                    }
                }
                if (Math.abs(fSignum - f4) < f11) {
                    fSignum = (Math.signum(f12) * f11) + f4;
                }
            }
            this.f6182b = fSignum;
            this.f6183c = this.f6182b != this.f6181a;
        }
        return this.f6183c;
    }

    public final float getAnimatedValue() {
        return this.f6182b;
    }

    public final float getTargValue() {
        return this.f6181a;
    }

    public final void set(float f) {
        this.f6183c = false;
        this.f6182b = f;
        this.f6181a = f;
    }

    public final void setMaxSpeedFractor(float f) {
        this.e = f;
    }

    public final void setMinSpeedFractor(float f) {
        this.f = f;
    }

    public final void setTargValue(float f) {
        if (this.f6181a != f) {
            this.f6181a = f;
            float f4 = f - this.f6182b;
            if (f4 != 0.0f) {
                float fAbs = Math.abs(f4 * this.f);
                this.f6184d = fAbs;
                if (fAbs < 1.0E-4f) {
                    this.f6184d = 1.0E-4f;
                }
            }
            this.f6183c = true;
        }
    }
}
