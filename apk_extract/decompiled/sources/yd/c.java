package yd;

import android.graphics.Rect;
import android.view.MotionEvent;
import k3.z8;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11132d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i8, l lVar, int i9) {
        super(i8, lVar);
        this.f11132d = i9;
    }

    @Override // yd.a
    public final void a(k kVar, int i8, int i9) {
        switch (this.f11132d) {
            case 0:
                kVar.c(i8, -i8, i9);
                break;
            default:
                kVar.c(i8, -i8, i9);
                break;
        }
    }

    @Override // yd.a
    public final void b(k kVar, int i8, int i9, int i10) {
        switch (this.f11132d) {
            case 0:
                kVar.a(i8, i9, i10);
                break;
            default:
                kVar.a(i8, i9, i10);
                break;
        }
    }

    @Override // yd.a
    public final void c(k kVar, int i8, int i9) {
        switch (this.f11132d) {
            case 0:
                kVar.c(Math.abs(i8), getMenuView().getMenuTotalWidth() - Math.abs(i8), i9);
                break;
            default:
                kVar.c(i8, Math.abs(i8) + (-getMenuView().getMenuTotalWidth()), i9);
                break;
        }
    }

    @Override // yd.a
    public final void d(k kVar, int i8, int i9, int i10) {
        switch (this.f11132d) {
            case 0:
                kVar.a(i8, i9, i10);
                break;
            default:
                kVar.a(i8, i9, i10);
                break;
        }
    }

    @Override // yd.a
    public final Rect e(boolean z2) {
        switch (this.f11132d) {
            case 0:
                Rect rect = new Rect();
                int menuItemCount = getMenuItemCount();
                if (menuItemCount <= 0) {
                    z8.f("LeftHorizontal", "getClickMenuItemBound: menuItemCount = " + menuItemCount);
                } else {
                    int menuWidth = getMenuWidth();
                    if (menuWidth > 0) {
                        l menuView = getMenuView();
                        z8.f("LeftHorizontal", "getClickMenuItemBound: left");
                        if (z2 && menuView.f11161g) {
                            menuView.getMenuItems().get(0).getClass();
                            throw new ClassCastException();
                        }
                        menuView.getMenuItems().get(0).getClass();
                        throw new ClassCastException();
                    }
                    z8.f("LeftHorizontal", "getClickMenuItemBound: menuWidth = " + menuWidth);
                }
                return rect;
            default:
                Rect rect2 = new Rect();
                int menuItemCount2 = getMenuItemCount();
                if (menuItemCount2 <= 0) {
                    z8.f("RightHorizontal", "getClickMenuItemBound: menuItemCount = " + menuItemCount2);
                } else {
                    int menuWidth2 = getMenuWidth();
                    if (menuWidth2 > 0) {
                        z8.b("RightHorizontal", "getClickMenuItemBound: right");
                        if (z2 && getMenuView().f11161g) {
                            getMenuView().getMenuItems().get(0).getClass();
                            throw new ClassCastException();
                        }
                        getMenuView().getMenuItems().get(0).getClass();
                        throw new ClassCastException();
                    }
                    z8.f("RightHorizontal", "getClickMenuItemBound: menuWidth = " + menuWidth2);
                }
                return rect2;
        }
    }

    @Override // yd.a
    public final int f(int i8, MotionEvent motionEvent, boolean z2) {
        int menuWidth;
        int menuWidth2;
        switch (this.f11132d) {
            case 0:
                float x2 = motionEvent.getX();
                motionEvent.getY();
                int menuItemCount = getMenuItemCount();
                if (menuItemCount <= 0 || x2 < i8 - getMenuWidth() || (menuWidth = getMenuWidth()) <= 0) {
                    return -1;
                }
                if (!z2 || !getMenuView().f11161g) {
                    return ((int) (x2 - (i8 - menuWidth))) / (menuWidth / menuItemCount);
                }
                getMenuView().getMenuItems().get(0).getClass();
                throw new ClassCastException();
            default:
                float x8 = motionEvent.getX();
                motionEvent.getY();
                int menuItemCount2 = getMenuItemCount();
                if (menuItemCount2 <= 0 || x8 > getMenuWidth() || (menuWidth2 = getMenuWidth()) <= 0) {
                    return -1;
                }
                if (!z2 || !getMenuView().f11161g) {
                    return ((int) Math.abs(x8)) / (menuWidth2 / menuItemCount2);
                }
                getMenuView().getMenuItems().get(0).getClass();
                throw new ClassCastException();
        }
    }

    @Override // yd.a
    public final boolean g(int i8) {
        switch (this.f11132d) {
            case 0:
                int direction = getDirection() * getMenuView().getMenuTotalWidth();
                return Math.abs(i8 - direction) <= 8 && direction != 0;
            default:
                int direction2 = getDirection() * getMenuView().getMenuTotalWidth();
                return Math.abs(i8 - direction2) <= 8 && direction2 != 0;
        }
    }
}
