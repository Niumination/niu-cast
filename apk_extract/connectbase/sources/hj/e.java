package hj;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7182e;

    public e() {
    }

    public void a(Canvas canvas, Paint paint) {
        canvas.drawCircle(this.f7178a, this.f7179b, this.f7182e, paint);
    }

    public void b(int i10, int i11) {
        this.f7180c = i10;
        this.f7181d = i11;
    }

    public void c(int i10, int i11, float f10) {
        this.f7178a = i10;
        this.f7179b = i11;
        this.f7182e = f10;
    }

    public String toString() {
        return "Point::x=" + this.f7178a + ", y=" + this.f7179b + ", x1=" + this.f7180c + ", y1=" + this.f7181d + ", radius=" + this.f7182e;
    }

    public e(int i10, int i11, float f10) {
        this.f7180c = i10;
        this.f7178a = i10;
        this.f7181d = i11;
        this.f7179b = i11;
        this.f7182e = f10;
    }
}
