package md;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f8025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f8027d;
    public float e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f8030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f8031j;

    public float getRadius() {
        return this.f8025b;
    }

    public float getSmoothness() {
        return this.f8031j;
    }

    public void setRadius(float f) {
        this.f8025b = Math.min(f, this.f8024a / 2.0f);
    }

    public void setSmoothness(float f) {
        float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        this.f8031j = fMax;
        float f4 = this.f8024a;
        this.f8030i = Math.min(f4 / 2.0f, (fMax + 1.0f) * this.f8025b);
        float f10 = this.f8025b;
        if (f10 > f4 / 4.0f) {
            float f11 = 1.0f - ((f10 - (f4 / 4.0f)) / (f4 / 4.0f));
            this.f8027d = (1.0f - (fMax * f11)) * 90.0f;
            this.f8026c = fMax * 45.0f * f11;
        } else {
            this.f8027d = (1.0f - fMax) * 90.0f;
            this.f8026c = fMax * 45.0f;
        }
        double dTan = Math.tan(Math.toRadians(this.f8026c));
        double dTan2 = Math.tan(Math.toRadians(this.f8026c) / 2.0d) * ((double) this.f8025b);
        double dPow = Math.pow(2.0d, 0.5d) * Math.sin(Math.toRadians(this.f8027d) / 2.0d) * ((double) this.f8025b);
        float fCos = (float) (Math.cos(Math.toRadians(this.f8026c)) * dTan2);
        this.f8028g = fCos;
        this.f8029h = (float) (((double) fCos) * dTan);
        float f12 = (float) (((((double) this.f8030i) - dPow) - ((dTan + 1.0d) * ((double) fCos))) / 3.0d);
        this.f = f12;
        this.e = f12 * 2.0f;
    }
}
