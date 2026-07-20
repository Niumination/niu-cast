package com.transsion.widgetthemes.widget.actionbar;

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
import com.transsion.widgetsThemes.R$dimen;
import com.transsion.widgetsThemes.R$style;
import com.transsion.widgetthemes.util.Point;
import com.transsion.widgetthemes.util.PointAnimUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class OverflowMenu extends View {
    private static final int MENU_FRAME_OFFSET_BOTTOM_DP = 30;
    private static final int PAINT_COLOR = -10461088;
    private static boolean mIsMultiWindow = false;
    private int fMenuId;
    private Activity mActivity;
    private Paint mCirclePaint;
    private Fragment mFg;
    private Handler mHandler;
    private boolean mIsShowing;
    private int mLayoutDir;
    private int mMenuColor;
    private int mMenuItemHeight;
    private View.OnClickListener mOutClickListener;
    private PopupMenu mOverflowMenu;
    private PointAnimUtil mPointAnimHelper;
    private ArrayList<Point> mPoints;
    public OnPopMenuListener mPopMenuListener;
    private final Resources mRes;
    private int mWidth;

    public interface OnPopMenuListener {
        void onCreated();
    }

    public OverflowMenu(Context context) {
        this(context, null);
    }

    private void createPopuMenu(int i8) {
        if (i8 == 1) {
            this.mOverflowMenu = new PopupMenu(getContext(), this, 0, 0, R$style.OsPopupMenuStyle);
        } else {
            this.mOverflowMenu = new PopupMenu(getContext(), this, 0, 0, R$style.OsPopupMenuStyle);
        }
        this.mOverflowMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.transsion.widgetthemes.widget.actionbar.OverflowMenu.2
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (OverflowMenu.this.mActivity != null) {
                    OverflowMenu.this.mActivity.onOptionsItemSelected(menuItem);
                }
                if (OverflowMenu.this.mFg == null) {
                    return false;
                }
                OverflowMenu.this.mFg.onOptionsItemSelected(menuItem);
                return false;
            }
        });
        this.mOverflowMenu.setOnDismissListener(new PopupMenu.OnDismissListener() { // from class: com.transsion.widgetthemes.widget.actionbar.OverflowMenu.3
            @Override // android.widget.PopupMenu.OnDismissListener
            public void onDismiss(PopupMenu popupMenu) {
                OverflowMenu.this.mIsShowing = false;
                OverflowMenu.this.setSelected(false);
            }
        });
        OnPopMenuListener onPopMenuListener = this.mPopMenuListener;
        if (onPopMenuListener != null) {
            onPopMenuListener.onCreated();
        }
    }

    private void initCirclePaint() {
        Paint paint = new Paint();
        this.mCirclePaint = paint;
        paint.setAntiAlias(true);
        this.mCirclePaint.setDither(true);
        this.mCirclePaint.setColor(this.mMenuColor);
    }

    private void initCirclePosition(int i8) {
        int i9 = i8 / 2;
        this.mPointAnimHelper.setCetnerPosition(i9, i9);
        int layoutDirection = getLayoutDirection();
        this.mLayoutDir = layoutDirection;
        this.mPointAnimHelper.setPointDir(layoutDirection, this.mPoints);
    }

    public void dismiss() {
        PopupMenu popupMenu = this.mOverflowMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    public PopupMenu getPopWindow() {
        return this.mOverflowMenu;
    }

    @Override // android.view.View
    public void getWindowVisibleDisplayFrame(Rect rect) {
        Resources resources;
        super.getWindowVisibleDisplayFrame(rect);
        if (this.mActivity == null || getDisplay() == null || (resources = this.mRes) == null) {
            return;
        }
        int dimensionPixelSize = rect.bottom - resources.getDimensionPixelSize(R$dimen.os_shadowbutton_width_height);
        rect.bottom = dimensionPixelSize;
        if (mIsMultiWindow && dimensionPixelSize - rect.top > 0) {
            rect.top = dimensionPixelSize - (this.mMenuItemHeight * 4);
        } else if (getDisplay().getRotation() % 2 != 0) {
            rect.top = rect.bottom - (this.mMenuItemHeight * 4);
        } else {
            rect.top = rect.bottom - (this.mMenuItemHeight * 6);
        }
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mLayoutDir != configuration.getLayoutDirection()) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mPointAnimHelper.abort();
        PopupMenu popupMenu = this.mOverflowMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
        this.mOverflowMenu = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<Point> it = this.mPoints.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas, this.mCirclePaint);
        }
        PointAnimUtil pointAnimUtil = this.mPointAnimHelper;
        if (pointAnimUtil.mState == 4) {
            pointAnimUtil.update();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        initCirclePosition(this.mWidth);
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (this.mWidth == 0) {
            this.mWidth = getMeasuredWidth();
        }
    }

    public void onMultiWindowModeChanged(boolean z2) {
        mIsMultiWindow = z2;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        setSelected(true);
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.mOutClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
        return true;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            setOverMenuColor(PAINT_COLOR);
        } else {
            setOverMenuColor(this.mMenuColor & Integer.MAX_VALUE);
        }
    }

    public void setFragment(Fragment fragment) {
        this.mFg = fragment;
    }

    public void setOnPopMenuListener(OnPopMenuListener onPopMenuListener) {
        this.mPopMenuListener = onPopMenuListener;
        createPopuMenu(this.mLayoutDir);
    }

    @Deprecated
    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.mOutClickListener = onClickListener;
    }

    public void setOverMenuColor(int i8) {
        this.mMenuColor = i8;
        this.mCirclePaint.setColor(i8);
    }

    @Override // android.view.View
    public void setSelected(boolean z2) {
        super.setSelected(z2);
        if (z2) {
            show();
        } else {
            this.mPointAnimHelper.start(false, this.mLayoutDir);
        }
    }

    public void setupOverflowMenuButton(int i8) {
        this.fMenuId = i8;
        this.mHandler.sendEmptyMessage(2);
    }

    public void show() {
        PopupMenu popupMenu;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (iArr[1] <= getResources().getDisplayMetrics().heightPixels / 3) {
            Log.w("os_menu", "Warnging, screen in a error point!");
            return;
        }
        if (this.mIsShowing || (popupMenu = this.mOverflowMenu) == null) {
            return;
        }
        Activity activity = this.mActivity;
        if (activity == null && this.mFg == null) {
            throw new RuntimeException("Must provide a activity or fragment!");
        }
        if (activity != null) {
            activity.onPrepareOptionsMenu(popupMenu.getMenu());
        }
        Fragment fragment = this.mFg;
        if (fragment != null) {
            fragment.onPrepareOptionsMenu(this.mOverflowMenu.getMenu());
        }
        this.mIsShowing = true;
        this.mOverflowMenu.show();
        this.mPointAnimHelper.start(true, this.mLayoutDir);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$style.OsPopupMenuStyle);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public OverflowMenu(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.mMenuColor = PAINT_COLOR;
        this.mIsShowing = false;
        this.mHandler = new Handler() { // from class: com.transsion.widgetthemes.widget.actionbar.OverflowMenu.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (OverflowMenu.this.mOverflowMenu != null) {
                    OverflowMenu.this.mOverflowMenu.getMenu().clear();
                    OverflowMenu.this.mOverflowMenu.inflate(OverflowMenu.this.fMenuId);
                }
            }
        };
        setClickable(true);
        setFocusable(true);
        Resources resources = context.getResources();
        this.mRes = resources;
        this.mMenuItemHeight = resources.getDimensionPixelSize(R$dimen.os_list_item_height_small);
        this.mPoints = new ArrayList<>(3);
        this.mPointAnimHelper = new PointAnimUtil(this);
        initCirclePaint();
    }
}
