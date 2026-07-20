package qj;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f13999e;

    public a() {
    }

    public void a(Canvas canvas, Paint paint) {
        canvas.drawCircle(this.f13995a, this.f13996b, this.f13999e, paint);
    }

    public void b(int i10, int i11) {
        this.f13997c = i10;
        this.f13998d = i11;
    }

    public void c(int i10, int i11, float f10) {
        this.f13995a = i10;
        this.f13996b = i11;
        this.f13999e = f10;
    }

    public String toString() {
        return "Point::x=" + this.f13995a + ", y=" + this.f13996b + ", x1=" + this.f13997c + ", y1=" + this.f13998d + ", radius=" + this.f13999e;
    }

    public a(int i10, int i11, float f10) {
        this.f13997c = i10;
        this.f13995a = i10;
        this.f13998d = i11;
        this.f13996b = i11;
        this.f13999e = f10;
    }
}
