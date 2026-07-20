package w5;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import o5.c;
import u2.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Bitmap f10661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c f10662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10664d;
    public final int e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f10665g;

    public a(Bitmap bitmap) {
        l.e(bitmap);
        this.f10661a = bitmap;
        this.f10663c = bitmap.getWidth();
        this.f10664d = bitmap.getHeight();
        b(0);
        this.e = 0;
        this.f = -1;
        this.f10665g = null;
    }

    public static void b(int i8) {
        boolean z2 = true;
        if (i8 != 0 && i8 != 90 && i8 != 180 && i8 != 270) {
            z2 = false;
        }
        l.a("Invalid rotation. Only 0, 90, 180, 270 are supported currently.", z2);
    }

    public final Image.Plane[] a() {
        if (this.f10662b == null) {
            return null;
        }
        return ((Image) this.f10662b.f8405a).getPlanes();
    }

    public a(Image image, int i8, int i9, int i10, Matrix matrix) {
        this.f10662b = new c(image);
        this.f10663c = i8;
        this.f10664d = i9;
        b(i10);
        this.e = i10;
        this.f = 35;
        this.f10665g = matrix;
    }
}
