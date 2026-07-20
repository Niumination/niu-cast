package com.transsion.widgetslib.widget.actionbar;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.transsion.widgetslib.R;
import hj.e;
import hj.f;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class OverflowMenu extends View {
    public static final int I = 30;
    public static final int J = -10461088;
    public static boolean K = false;
    public Handler H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<e> f2795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f2796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f2797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2799g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Resources f2800i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PopupMenu f2801n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f2802p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View.OnClickListener f2803v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Fragment f2804w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Activity f2805x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2806y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2807z;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (OverflowMenu.this.f2801n != null) {
                OverflowMenu.this.f2801n.getMenu().clear();
                OverflowMenu overflowMenu = OverflowMenu.this;
                overflowMenu.f2801n.inflate(overflowMenu.f2806y);
            }
        }
    }

    public class b implements PopupMenu.OnMenuItemClickListener {
        public b() {
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (OverflowMenu.this.f2805x != null) {
                OverflowMenu.this.f2805x.onOptionsItemSelected(menuItem);
            }
            Fragment fragment = OverflowMenu.this.f2804w;
            if (fragment == null) {
                return false;
            }
            fragment.onOptionsItemSelected(menuItem);
            return false;
        }
    }

    public class c implements PopupMenu.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupMenu.OnDismissListener
        public void onDismiss(PopupMenu popupMenu) {
            OverflowMenu.this.f2807z = false;
            OverflowMenu.this.setSelected(false);
        }
    }

    public interface d {
        void a();
    }

    public OverflowMenu(Context context) {
        this(context, null);
    }

    public final void f(int i10) {
        if (i10 == 1) {
            this.f2801n = new PopupMenu(getContext(), this, 0, 0, R.style.OsPopupMenuStyle);
        } else {
            this.f2801n = new PopupMenu(getContext(), this, 0, 0, R.style.OsPopupMenuStyle);
        }
        this.f2801n.setOnMenuItemClickListener(new b());
        this.f2801n.setOnDismissListener(new c());
        d dVar = this.f2802p;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void g() {
        PopupMenu popupMenu = this.f2801n;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    public PopupMenu getPopWindow() {
        return this.f2801n;
    }

    @Override // android.view.View
    @b.a({"WrongConstant"})
    public void getWindowVisibleDisplayFrame(Rect rect) {
        Resources resources;
        super.getWindowVisibleDisplayFrame(rect);
        if (this.f2805x == null || getDisplay() == null || (resources = this.f2800i) == null) {
            return;
        }
        int dimensionPixelSize = rect.bottom - resources.getDimensionPixelSize(R.dimen.os_shadowbutton_width_height);
        rect.bottom = dimensionPixelSize;
        if (K && dimensionPixelSize - rect.top > 0) {
            rect.top = dimensionPixelSize - (this.f2799g * 4);
        } else if (getDisplay().getRotation() % 2 != 0) {
            rect.top = rect.bottom - (this.f2799g * 4);
        } else {
            rect.top = rect.bottom - (this.f2799g * 6);
        }
    }

    public final void h() {
        Paint paint = new Paint();
        this.f2797e = paint;
        paint.setAntiAlias(true);
        this.f2797e.setDither(true);
        this.f2797e.setColor(this.f2794b);
    }

    public final void i(int i10) {
        int i11 = i10 / 2;
        this.f2796d.f(i11, i11);
        int layoutDirection = getLayoutDirection();
        this.f2798f = layoutDirection;
        this.f2796d.h(layoutDirection, this.f2795c);
    }

    public boolean j() {
        return this.f2807z;
    }

    public void k(boolean z10) {
        K = z10;
    }

    public void l() {
        PopupMenu popupMenu;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (iArr[1] <= getResources().getDisplayMetrics().heightPixels / 3) {
            Log.w("os_menu", "Warnging, screen in a error point!");
            return;
        }
        if (this.f2807z || (popupMenu = this.f2801n) == null) {
            return;
        }
        Activity activity = this.f2805x;
        if (activity == null && this.f2804w == null) {
            throw new RuntimeException("Must provide a activity or fragment!");
        }
        if (activity != null) {
            activity.onPrepareOptionsMenu(popupMenu.getMenu());
        }
        Fragment fragment = this.f2804w;
        if (fragment != null) {
            fragment.onPrepareOptionsMenu(this.f2801n.getMenu());
        }
        this.f2807z = true;
        this.f2801n.show();
        this.f2796d.i(true, this.f2798f);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2798f != configuration.getLayoutDirection()) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2796d.a();
        PopupMenu popupMenu = this.f2801n;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
        this.f2801n = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<e> it = this.f2795c.iterator();
        while (it.hasNext()) {
            it.next().a(canvas, this.f2797e);
        }
        f fVar = this.f2796d;
        if (fVar.f7194f == 4) {
            fVar.j();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        i(this.f2793a);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f2793a == 0) {
            this.f2793a = getMeasuredWidth();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        setSelected(true);
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f2803v;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
        return true;
    }

    public void setActivity(Activity activity) {
        this.f2805x = activity;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            setOverMenuColor(-10461088);
        } else {
            setOverMenuColor(this.f2794b & Integer.MAX_VALUE);
        }
    }

    public void setFragment(Fragment fragment) {
        this.f2804w = fragment;
    }

    public void setOnPopMenuListener(d dVar) {
        this.f2802p = dVar;
        f(this.f2798f);
    }

    @Deprecated
    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.f2803v = onClickListener;
    }

    public void setOverMenuColor(int i10) {
        this.f2794b = i10;
        this.f2797e.setColor(i10);
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        if (z10) {
            l();
        } else {
            this.f2796d.i(false, this.f2798f);
        }
    }

    public void setupOverflowMenuButton(int i10) {
        this.f2806y = i10;
        this.H.sendEmptyMessage(2);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.OsPopupMenuStyle, 0);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f2794b = -10461088;
        this.f2807z = false;
        this.H = new a();
        setClickable(true);
        setFocusable(true);
        Resources resources = context.getResources();
        this.f2800i = resources;
        this.f2799g = resources.getDimensionPixelSize(R.dimen.os_list_item_height_small);
        this.f2795c = new ArrayList<>(3);
        this.f2796d = new f(this);
        h();
    }
}
