package com.transsion.widgetslib.widget.actionbar;

import ad.e;
import ae.b;
import ae.c;
import ae.d;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.PopupMenu;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$style;
import java.util.ArrayList;
import pd.f;
import pd.g;

/* JADX INFO: loaded from: classes2.dex */
public class OverflowMenu extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f3456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f3457d;
    public final Paint e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Resources f3460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupMenu f3461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View.OnClickListener f3462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Fragment f3463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Activity f3464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3465o;
    public boolean p;
    public final e q;

    public OverflowMenu(Context context) {
        this(context, null);
    }

    public PopupMenu getPopWindow() {
        return this.f3461k;
    }

    @Override // android.view.View
    public final void getWindowVisibleDisplayFrame(Rect rect) {
        Resources resources;
        super.getWindowVisibleDisplayFrame(rect);
        if (this.f3464n == null || getDisplay() == null || (resources = this.f3460j) == null) {
            return;
        }
        rect.bottom -= resources.getDimensionPixelSize(R$dimen.os_shadowbutton_width_height);
        int rotation = getDisplay().getRotation() % 2;
        int i8 = this.f3459i;
        if (rotation != 0) {
            rect.top = rect.bottom - (i8 * 4);
        } else {
            rect.top = rect.bottom - (i8 * 6);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3458h != configuration.getLayoutDirection()) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f3457d;
        if (gVar.f == 4) {
            if (gVar.f8753g) {
                gVar.f = 2;
            } else {
                gVar.f = 1;
            }
            gVar.a((f) gVar.e.get(1), (f) gVar.e.get(2));
        }
        PopupMenu popupMenu = this.f3461k;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
        this.f3461k = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (f fVar : this.f3456c) {
            canvas.drawCircle(fVar.f8743a, fVar.f8744b, fVar.e, this.e);
        }
        g gVar = this.f3457d;
        if (gVar.f == 4) {
            gVar.c();
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        int i12 = this.f3454a / 2;
        g gVar = this.f3457d;
        gVar.f8758l = i12;
        gVar.f8759m = i12;
        int layoutDirection = getLayoutDirection();
        this.f3458h = layoutDirection;
        ArrayList arrayList = this.f3456c;
        if (gVar.f8754h != layoutDirection) {
            arrayList.clear();
            if (layoutDirection == 0) {
                int i13 = gVar.f8758l - g.f8748o;
                gVar.f8755i.a(i13, i13, g.f8747n);
                int i14 = gVar.f8759m;
                gVar.f8756j.a(i13, i14, g.f8747n);
                int i15 = gVar.f8759m + g.f8748o;
                gVar.f8757k.a(i13, i15, g.f8747n);
                f fVar = gVar.f8756j;
                fVar.f8745c = i15;
                fVar.f8746d = i13;
                f fVar2 = gVar.f8757k;
                fVar2.f8745c = i14;
                fVar2.f8746d = i14;
                arrayList.add(0, gVar.f8755i);
                arrayList.add(1, gVar.f8756j);
                arrayList.add(2, gVar.f8757k);
            } else {
                int i16 = gVar.f8758l;
                int i17 = g.f8748o;
                int i18 = i16 + i17;
                int i19 = gVar.f8759m - i17;
                gVar.f8755i.a(i18, i19, g.f8747n);
                int i20 = gVar.f8759m;
                gVar.f8756j.a(i18, i20, g.f8747n);
                gVar.f8757k.a(i18, gVar.f8759m + g.f8748o, g.f8747n);
                f fVar3 = gVar.f8756j;
                fVar3.f8745c = i19;
                fVar3.f8746d = i19;
                f fVar4 = gVar.f8757k;
                fVar4.f8745c = i20;
                fVar4.f8746d = i20;
                arrayList.add(0, gVar.f8755i);
                arrayList.add(1, gVar.f8756j);
                arrayList.add(2, gVar.f8757k);
            }
        }
        gVar.e = arrayList;
        gVar.f8754h = layoutDirection;
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (this.f3454a == 0) {
            this.f3454a = getMeasuredWidth();
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        setSelected(true);
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f3462l;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
        return true;
    }

    public void setActivity(Activity activity) {
        this.f3464n = activity;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            setOverMenuColor(-10461088);
        } else {
            setOverMenuColor(this.f3455b & Integer.MAX_VALUE);
        }
    }

    public void setFragment(Fragment fragment) {
        this.f3463m = fragment;
    }

    public void setOnPopMenuListener(d dVar) {
        if (this.f3458h == 1) {
            this.f3461k = new PopupMenu(getContext(), this, 0, 0, R$style.OsPopupMenuStyle);
        } else {
            this.f3461k = new PopupMenu(getContext(), this, 0, 0, R$style.OsPopupMenuStyle);
        }
        this.f3461k.setOnMenuItemClickListener(new b(this));
        this.f3461k.setOnDismissListener(new c(this));
    }

    @Deprecated
    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.f3462l = onClickListener;
    }

    public void setOverMenuColor(int i8) {
        this.f3455b = i8;
        this.e.setColor(i8);
    }

    @Override // android.view.View
    public void setSelected(boolean z2) {
        PopupMenu popupMenu;
        super.setSelected(z2);
        g gVar = this.f3457d;
        if (!z2) {
            gVar.b(false);
            return;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (iArr[1] <= getResources().getDisplayMetrics().heightPixels / 3) {
            Log.w("os_menu", "Warnging, screen in a error point!");
            return;
        }
        if (this.p || (popupMenu = this.f3461k) == null) {
            return;
        }
        Activity activity = this.f3464n;
        if (activity == null && this.f3463m == null) {
            throw new RuntimeException("Must provide a activity or fragment!");
        }
        if (activity != null) {
            activity.onPrepareOptionsMenu(popupMenu.getMenu());
        }
        Fragment fragment = this.f3463m;
        if (fragment != null) {
            fragment.onPrepareOptionsMenu(this.f3461k.getMenu());
        }
        this.p = true;
        this.f3461k.show();
        gVar.b(true);
    }

    public void setupOverflowMenuButton(int i8) {
        this.f3465o = i8;
        this.q.sendEmptyMessage(2);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$style.OsPopupMenuStyle);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8, 0);
        this.f3455b = -10461088;
        this.p = false;
        this.q = new e(this, 1);
        setClickable(true);
        setFocusable(true);
        Resources resources = context.getResources();
        this.f3460j = resources;
        this.f3459i = resources.getDimensionPixelSize(R$dimen.os_list_item_height_small);
        this.f3456c = new ArrayList(3);
        this.f3457d = new g(this);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setColor(this.f3455b);
    }
}
