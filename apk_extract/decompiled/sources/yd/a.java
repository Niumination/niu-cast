package yd;

import android.graphics.Rect;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f11130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11131c;

    public a(int i8, l lVar) {
        this.f11129a = i8;
        this.f11130b = lVar;
    }

    public abstract void a(k kVar, int i8, int i9);

    public abstract void b(k kVar, int i8, int i9, int i10);

    public abstract void c(k kVar, int i8, int i9);

    public abstract void d(k kVar, int i8, int i9, int i10);

    public abstract Rect e(boolean z2);

    public abstract int f(int i8, MotionEvent motionEvent, boolean z2);

    public abstract boolean g(int i8);

    public int getDirection() {
        return this.f11129a;
    }

    public int getMenuItemCount() {
        return this.f11130b.getMenuItems().size();
    }

    public l getMenuView() {
        return this.f11130b;
    }

    public int getMenuWidth() {
        return this.f11130b.getMenuTotalWidth();
    }

    public int getScreenWidth() {
        return this.f11131c;
    }

    public void setScreenWidth(int i8) {
        this.f11131c = i8;
    }
}
