package com.transsion.widgetsliquid.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetslib.widget.OsPressSmoothCornerDrawable;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import com.transsion.widgetslistitemlayout.R$layout;
import ie.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import je.t;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pd.j;
import zd.c0;
import zd.n;

/* JADX INFO: loaded from: classes2.dex */
public class OsLiqBottomToolBar extends RelativeLayout {
    private static final int ANIM_TIME = 150;
    private static final int DEFAULT_MAX_VISIBLE_TAB_COUNT = 6;
    private static final int DEFAULT_MIN_VISIBLE_TAB_COUNT = 3;
    private static final String PRESS_TIME = "PRESS_TIME";
    private static final String TAG = "OsLiqBottomToolBar";
    private final int PRESS_ANIMATION_DURATION;
    private final int PRESS_RESPONSE_TIME;
    private SpringAnimation currentScaleAnimator;
    private boolean isDisableDefaultClick;
    private boolean isFootActionBar;
    private boolean isOnlyScreenPortrait;
    private boolean isSingGroup;
    int itemMargin;
    private boolean mAnim;
    private long mClickInterval;
    private LinearLayout mContainer;
    private Context mContext;
    private int mCurrentItemCount;
    private boolean mHaveTextColor;
    private boolean mImmersive;
    private boolean mInitShow;
    private OnFootOptBarClickListener mItemClickListener;
    private long mLastClickTime;
    private int mMaxVisibleTabCount;
    private MenuBuilder mMenuBuilder;
    private boolean[] mMenuEnables;
    private String mMoreIconRes;
    private View mMoreView;
    private final MyOnPreDrawListener mMyOnPreDrawListener;
    private int mOrientation;
    private FootPopupAdapter mPopAdapter;
    private n mPopup;
    private List<String> mPopupItems;
    private int mPopupMaxHeight;
    private OSLiquidContainerRootLayout mRoot;
    private int mSelectedIndex;
    private boolean mShow;
    private int mTextColor;
    private int mVisibleTabCount;
    private int realWidth;
    private int single_maxVisableCount;
    private int single_pad_maxVisableCount;
    private int single_pad_secondVisableCount;
    private int single_secondVisableCount;
    private SpringForce startSpring;
    private SpringForce stopSpring;

    public class FootPopupAdapter extends BaseAdapter {

        public class ViewHolder {
            private OSIconTextView title;

            public /* synthetic */ ViewHolder(FootPopupAdapter footPopupAdapter, int i8) {
                this();
            }

            private ViewHolder() {
            }
        }

        private FootPopupAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OsLiqBottomToolBar.this.mPopupItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i8) {
            return OsLiqBottomToolBar.this.mPopupItems.get(i8);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i8) {
            return i8;
        }

        @Override // android.widget.Adapter
        public View getView(int i8, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            int i9 = 0;
            if (view == null) {
                view = LayoutInflater.from(OsLiqBottomToolBar.this.getContext()).inflate(R.layout.os_liquid_foot_opt_bar_popup_item, viewGroup, false);
                viewHolder = new ViewHolder(this, i9);
                viewHolder.title = (OSIconTextView) view.findViewById(R$id.os_foot_opt_bar_popup_item_text);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.title.setText((CharSequence) OsLiqBottomToolBar.this.mPopupItems.get(i8));
            viewHolder.title.setGravity(16);
            viewHolder.title.setClickable(false);
            viewHolder.title.setTextColor(OsLiqBottomToolBar.this.mContext.getColor(R$color.os_foot_bar_item_text_color));
            OsLiqBottomToolBar osLiqBottomToolBar = OsLiqBottomToolBar.this;
            osLiqBottomToolBar.viewEnable(view, osLiqBottomToolBar.mMenuEnables[i8]);
            final int i10 = OsLiqBottomToolBar.this.mVisibleTabCount + i8;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.FootPopupAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (OsLiqBottomToolBar.this.mItemClickListener != null && !OsLiqBottomToolBar.this.isFastClick(i10)) {
                        OsLiqBottomToolBar.this.mItemClickListener.onItemClick(i10);
                    }
                    OsLiqBottomToolBar.this.mPopup.dismiss();
                }
            });
            return view;
        }
    }

    public static class MyOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        private final WeakReference<OsLiqBottomToolBar> mFootOperationBar;

        public MyOnPreDrawListener(OsLiqBottomToolBar osLiqBottomToolBar) {
            this.mFootOperationBar = new WeakReference<>(osLiqBottomToolBar);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            OsLiqBottomToolBar osLiqBottomToolBar = this.mFootOperationBar.get();
            if (osLiqBottomToolBar == null) {
                return true;
            }
            osLiqBottomToolBar.getViewTreeObserver().removeOnPreDrawListener(this);
            osLiqBottomToolBar.setVisibility(8);
            if (!osLiqBottomToolBar.mInitShow && !osLiqBottomToolBar.mShow) {
                return true;
            }
            osLiqBottomToolBar.setVisibility(0);
            osLiqBottomToolBar.openFootOperationBar();
            return true;
        }
    }

    public interface OnFootOptBarClickListener {
        void onItemClick(int i8);

        default void onMoreClick(View view) {
        }
    }

    public OsLiqBottomToolBar(Context context) {
        this(context, null);
    }

    private void adaptSafeInsets(View view) {
        if (!j.z(getContext()) || view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_safe_inset);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (this.mCurrentItemCount == 2) {
                dimensionPixelOffset <<= 1;
            }
            marginLayoutParams.setMarginStart(dimensionPixelOffset);
            marginLayoutParams.setMarginEnd(marginLayoutParams.getMarginStart());
        }
    }

    private void addItemView(MenuBuilder menuBuilder, int i8) {
        int i9 = 0;
        while (i9 < i8) {
            CharSequence title = menuBuilder.getItem(i9).getTitle();
            Objects.requireNonNull(title);
            addItemView(getMenuItem(title.toString(), i9 == 0, this.itemMargin), i9);
            i9++;
        }
    }

    private void closeAnimator() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(new a(0.33f, 0.66f));
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OsLiqBottomToolBar.this.setVisibility(8);
                OsLiqBottomToolBar.this.mAnim = false;
                if (OsLiqBottomToolBar.this.mMoreView != null) {
                    OsLiqBottomToolBar.this.mMoreView.setEnabled(true);
                }
                if (OsLiqBottomToolBar.this.mMyOnPreDrawListener != null) {
                    OsLiqBottomToolBar.this.getViewTreeObserver().removeOnPreDrawListener(OsLiqBottomToolBar.this.mMyOnPreDrawListener);
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    private View getMenuItem(String str, boolean z2, int i8) {
        Context context = this.mContext;
        int dimensionPixelOffset = j.f8768g ? context.getResources().getDimensionPixelOffset(R$dimen.os_pad_space050) : context.getResources().getDimensionPixelOffset(R$dimen.os_space050);
        this.mContainer.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        Context context2 = getContext();
        if (z2) {
            i8 = 0;
        }
        Intrinsics.checkNotNullParameter(context2, "context");
        FrameLayout frameLayout = new FrameLayout(context2);
        frameLayout.setId(R$id.os_fob_layout);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(frameLayout.getResources().getDimensionPixelOffset(R$dimen.os_liquid_toolbar_width), frameLayout.getResources().getDimensionPixelOffset(R$dimen.os_liquid_toolbar_height));
        layoutParams.setMarginStart(i8);
        frameLayout.setLayoutParams(layoutParams);
        OsPressSmoothCornerDrawable osPressSmoothCornerDrawable = new OsPressSmoothCornerDrawable(context2);
        osPressSmoothCornerDrawable.setClickable(false);
        osPressSmoothCornerDrawable.setId(R$id.os_fob_item_back);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(osPressSmoothCornerDrawable, layoutParams2);
        LinearLayout linearLayoutB = c0.b(context2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        frameLayout.addView(linearLayoutB, layoutParams3);
        adaptSafeInsets(frameLayout);
        TextView textView = (TextView) frameLayout.findViewById(R$id.os_foot_opt_bar_item_text);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        return frameLayout;
    }

    private View getMenuItemOne(String str) {
        this.mContainer.setPadding(0, 0, 0, 0);
        Context context = getContext();
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(R$id.os_fob_layout);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(frameLayout.getResources().getDimensionPixelOffset(R$dimen.os_liquid_toolbar_single_width), frameLayout.getResources().getDimensionPixelOffset(R$dimen.os_liquid_toolbar_height)));
        OsPressSmoothCornerDrawable osPressSmoothCornerDrawable = new OsPressSmoothCornerDrawable(context);
        osPressSmoothCornerDrawable.setClickable(false);
        osPressSmoothCornerDrawable.setId(R$id.os_fob_item_back);
        String[] strArr = j.f8764a;
        osPressSmoothCornerDrawable.setBackgroundLeftRightMargin(hd.a.a(context, 4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(osPressSmoothCornerDrawable, layoutParams);
        LinearLayout linearLayoutB = c0.b(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.addView(linearLayoutB, layoutParams2);
        adaptSafeInsets(frameLayout);
        TextView textView = (TextView) frameLayout.findViewById(R$id.os_foot_opt_bar_item_text);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        return frameLayout;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0032  */
    /* JADX WARN: Code duplicated, block: B:19:0x0034  */
    /* JADX WARN: Code duplicated, block: B:24:0x003f A[PHI: r3
      0x003f: PHI (r3v2 int) = (r3v0 int), (r3v3 int) binds: [B:26:0x0043, B:23:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    private int getPaddingValue(int i8) {
        int i9;
        int i10;
        int iA;
        if (this.isSingGroup) {
            Context context = this.mContext;
            if (j.f8768g) {
                i9 = this.itemMargin;
            } else {
                int i11 = this.mMaxVisibleTabCount;
                int i12 = this.single_maxVisableCount;
                if (i11 == i12) {
                    if (i8 == this.single_secondVisableCount) {
                        iA = hd.a.a(context, this.single_pad_secondVisableCount);
                    } else if (i8 >= i12) {
                        iA = hd.a.a(context, this.single_pad_maxVisableCount);
                    } else {
                        i9 = 0;
                    }
                    i9 = -iA;
                } else {
                    int i13 = this.single_secondVisableCount;
                    if (i11 != i13 || i8 < i13) {
                        i9 = 0;
                    } else {
                        iA = hd.a.a(context, this.single_pad_secondVisableCount);
                        i9 = -iA;
                    }
                }
            }
        } else {
            i9 = this.itemMargin;
        }
        Context context2 = this.mContext;
        boolean z2 = j.f8768g;
        if (z2) {
            i10 = 6;
            if (i8 > 6) {
                i8 = i10;
            }
        } else {
            i10 = this.mMaxVisibleTabCount;
            if (i8 > i10) {
                i8 = i10;
            }
        }
        if (i8 == 1) {
            this.realWidth = context2.getResources().getDimensionPixelOffset(R$dimen.os_liquid_toolbar_single_width);
        } else if (z2) {
            this.realWidth = ((i8 - 1) * i9) + (this.mContext.getResources().getDimensionPixelOffset(R$dimen.os_liquid_toolbar_width) * i8) + (context2.getResources().getDimensionPixelOffset(R$dimen.os_pad_space050) * 2);
        } else {
            this.realWidth = ((i8 - 1) * i9) + (this.mContext.getResources().getDimensionPixelOffset(R$dimen.os_liquid_toolbar_width) * i8) + (context2.getResources().getDimensionPixelOffset(R$dimen.os_space050) * 2);
        }
        return i9;
    }

    private int getPopupHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_popup_menu_bg_margin);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_popup_item_height);
        int i8 = dimensionPixelOffset * 2;
        boolean[] zArr = this.mMenuEnables;
        return zArr != null ? i8 + (zArr.length * dimensionPixelOffset2) : i8;
    }

    private void init() {
        this.startSpring.setDampingRatio(0.99f);
        this.startSpring.setStiffness(250.0f);
        this.startSpring.setFinalPosition(1.05f);
        this.stopSpring.setDampingRatio(0.4f);
        this.stopSpring.setStiffness(250.0f);
        this.stopSpring.setFinalPosition(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFastClick(int i8) {
        if (this.mClickInterval == 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mSelectedIndex == i8 && Math.abs(jCurrentTimeMillis - this.mLastClickTime) < this.mClickInterval) {
            return true;
        }
        this.mLastClickTime = jCurrentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showListPopupWindow$0(AdapterView adapterView, View view, int i8, long j8) {
        this.mPopup.dismiss();
        OnFootOptBarClickListener onFootOptBarClickListener = this.mItemClickListener;
        if (onFootOptBarClickListener != null) {
            onFootOptBarClickListener.onItemClick(this.mVisibleTabCount + i8);
        }
    }

    private void openAnimator() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new a(0.33f, 0.66f));
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                OsLiqBottomToolBar.this.mAnim = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                OsLiqBottomToolBar.this.setVisibility(0);
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void popupAdjustMaxHeight() {
        n nVar;
        int popupHeight = getPopupHeight();
        int i8 = this.mPopupMaxHeight;
        if (i8 <= 0 || popupHeight <= i8 || (nVar = this.mPopup) == null) {
            return;
        }
        nVar.setHeight(i8);
    }

    private void setFootPopupWindow() {
    }

    private void setMenu(MenuBuilder menuBuilder) {
        this.mContainer.removeAllViews();
        this.mPopupItems.clear();
        this.mPopup = null;
        this.mSelectedIndex = -1;
        int size = menuBuilder.size();
        this.itemMargin = getPaddingValue(size);
        if (!this.isFootActionBar) {
            addItemView(menuBuilder, size);
            return;
        }
        if (size <= Math.min(this.mMaxVisibleTabCount, 6)) {
            if (size == 1) {
                addItemView(getMenuItemOne(menuBuilder.getItem(0).getTitle().toString()), 0);
                return;
            } else {
                addItemView(menuBuilder, size);
                return;
            }
        }
        int i8 = this.mMaxVisibleTabCount;
        int i9 = i8 > 6 ? 5 : i8 - 1;
        this.mVisibleTabCount = i9;
        addItemView(menuBuilder, i9);
        View menuItem = getMenuItem(this.mMoreIconRes, false, this.itemMargin);
        View viewFindViewById = menuItem.findViewById(R$id.os_fob_layout);
        this.mMoreView = viewFindViewById;
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    ((OsPressSmoothCornerDrawable) OsLiqBottomToolBar.this.mMoreView.findViewById(R$id.os_fob_item_back)).b();
                    OsLiqBottomToolBar osLiqBottomToolBar = OsLiqBottomToolBar.this;
                    osLiqBottomToolBar.startPressAnimation(osLiqBottomToolBar.mRoot);
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    ((OsPressSmoothCornerDrawable) OsLiqBottomToolBar.this.mMoreView.findViewById(R$id.os_fob_item_back)).a();
                    OsLiqBottomToolBar osLiqBottomToolBar2 = OsLiqBottomToolBar.this;
                    osLiqBottomToolBar2.stopPressAnimation(osLiqBottomToolBar2.mRoot);
                    OsLiqBottomToolBar.this.mMoreView.setSelected(true);
                    if (!OsLiqBottomToolBar.this.isDisableDefaultClick) {
                        OsLiqBottomToolBar osLiqBottomToolBar3 = OsLiqBottomToolBar.this;
                        osLiqBottomToolBar3.showListPopupWindow(osLiqBottomToolBar3.mContext, OsLiqBottomToolBar.this.mMoreView, 0, (String[]) OsLiqBottomToolBar.this.mPopupItems.toArray(new String[0]));
                    } else if (OsLiqBottomToolBar.this.mItemClickListener != null) {
                        OsLiqBottomToolBar.this.mItemClickListener.onMoreClick(OsLiqBottomToolBar.this.mMoreView);
                    }
                }
                return true;
            }
        });
        this.mContainer.addView(menuItem);
        setPopupItems(menuBuilder, size);
    }

    private void setPopupItems(MenuBuilder menuBuilder, int i8) {
        int i9 = this.mVisibleTabCount;
        int i10 = i8 - i9;
        if (i10 > 0) {
            this.mMenuEnables = new boolean[i10];
            while (i9 < i8) {
                this.mMenuEnables[i9 - this.mVisibleTabCount] = true;
                i9++;
            }
        }
        int i11 = this.mMaxVisibleTabCount;
        int i12 = i11 > 6 ? 5 : i11 - 1;
        this.mVisibleTabCount = i12;
        while (i12 < i8) {
            this.mPopupItems.add(menuBuilder.getItem(i12).getTitle().toString());
            this.mMenuEnables[i12 - this.mVisibleTabCount] = true;
            i12++;
        }
        setFootPopupWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showListPopupWindow(Context context, View view, int i8, String[] strArr) {
        if (this.mPopup == null) {
            this.mPopup = new n(context, 0, R$style.OsLiquidPopupWindowStyle);
            this.mPopup.setContentView((ListView) View.inflate(context, R$layout.os_popup_window_layout, null));
        }
        ((ListView) this.mPopup.getList()).setOnItemClickListener(new t(this, 2));
        id.a aVar = new id.a(context, Arrays.asList(strArr));
        ((ListView) this.mPopup.getList()).setAdapter((ListAdapter) aVar);
        int i9 = 0;
        while (true) {
            boolean[] zArr = this.mMenuEnables;
            if (i9 >= zArr.length) {
                this.mPopup.setWidth(j.D(context, aVar));
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                view.getLocationOnScreen(new int[]{0, 0});
                this.mPopup.f(strArr.length, view);
                return;
            }
            boolean z2 = zArr[i9];
            if (i9 >= 0 && i9 < aVar.getCount()) {
                HashSet hashSet = aVar.f5743a;
                if (z2) {
                    hashSet.remove(Integer.valueOf(i9));
                } else {
                    hashSet.add(Integer.valueOf(i9));
                }
                aVar.notifyDataSetChanged();
            }
            i9++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPressAnimation(final View view) {
        this.currentScaleAnimator.cancel();
        this.currentScaleAnimator.setSpring(this.startSpring);
        this.currentScaleAnimator.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.6
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                view.setScaleY(f);
                view.setScaleX(f);
            }
        });
        this.currentScaleAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPressAnimation(final View view) {
        this.currentScaleAnimator.cancel();
        this.currentScaleAnimator.setSpring(this.stopSpring);
        this.currentScaleAnimator.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.7
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                view.setScaleY(f);
                view.setScaleX(f);
            }
        });
        this.currentScaleAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewEnable(View view, boolean z2) {
        if (view != null) {
            View viewFindViewById = view.findViewById(R$id.os_fob_layout);
            if (viewFindViewById == null) {
                view.setEnabled(z2);
                view.setAlpha(z2 ? 1.0f : 0.4f);
            } else {
                viewFindViewById.setEnabled(z2);
                viewFindViewById.setAlpha(z2 ? 1.0f : 0.4f);
            }
        }
    }

    public void changeFootItem(int i8, Drawable drawable, String str) {
        ImageView itemImageView = getItemImageView(i8);
        if (itemImageView != null && drawable != null) {
            itemImageView.setImageDrawable(null);
            itemImageView.setImageDrawable(drawable);
        }
        TextView itemTextView = getItemTextView(i8);
        if (itemTextView == null || str == null) {
            return;
        }
        itemTextView.setText(str);
    }

    public void changeItemEnable(int i8, boolean z2) {
        boolean[] zArr;
        if (this.mPopup != null) {
            int i9 = this.mVisibleTabCount;
            if (i8 < i9) {
                viewEnable(this.mContainer.getChildAt(i8), z2);
                return;
            } else {
                this.mMenuEnables[i8 - i9] = z2;
                return;
            }
        }
        viewEnable(this.mContainer.getChildAt(i8), z2);
        int i10 = this.mVisibleTabCount;
        if (i8 < i10 || (zArr = this.mMenuEnables) == null) {
            return;
        }
        zArr[i8 - i10] = z2;
    }

    public void changeItems(int[] iArr, int[] iArr2) {
        String[] strArr = new String[iArr2.length];
        for (int i8 = 0; i8 < iArr2.length; i8++) {
            strArr[i8] = this.mContext.getResources().getString(iArr2[i8]);
        }
        changeItems(iArr, strArr);
    }

    public void changeItemsEnable(boolean[] zArr) {
        n nVar = this.mPopup;
        if (nVar != null && nVar.isShowing()) {
            this.mPopup.dismiss();
        }
        int iMin = Math.min(zArr.length, getItemCount());
        for (int i8 = 0; i8 < iMin; i8++) {
            changeItemEnable(i8, zArr[i8]);
        }
    }

    public void changePopAdapter(int[] iArr, int[] iArr2) {
        String[] strArr = new String[iArr2.length];
        for (int i8 = 0; i8 < iArr2.length; i8++) {
            strArr[i8] = this.mContext.getResources().getString(iArr2[i8]);
        }
        changePopAdapter(iArr, strArr);
    }

    public void closeFootOperationBar() {
        if (this.mAnim || !this.mShow) {
            return;
        }
        n nVar = this.mPopup;
        if (nVar != null && nVar.isShowing()) {
            this.mPopup.dismiss();
        }
        View view = this.mMoreView;
        if (view != null) {
            view.setEnabled(false);
        }
        this.mAnim = true;
        this.mShow = false;
        closeAnimator();
    }

    public void enableMore(boolean z2) {
        n nVar;
        View view = this.mMoreView;
        if (view != null) {
            viewEnable(view, z2);
            if (z2 || (nVar = this.mPopup) == null || !nVar.isShowing()) {
                return;
            }
            this.mPopup.dismiss();
        }
    }

    public View getForceBCPlatformColorView() {
        return this.mRoot.getOsPressView();
    }

    public int getItemCount() {
        if (this.mPopupItems.size() <= 0) {
            return this.mContainer.getChildCount();
        }
        return (this.mPopupItems.size() + this.mContainer.getChildCount()) - 1;
    }

    public int getItemHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_popup_menu_bg_margin);
        getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_popup_item_height);
        return dimensionPixelOffset * 2;
    }

    @Nullable
    public ImageView getItemImageView(int i8) {
        View itemView = getItemView(i8);
        if (itemView == null) {
            return null;
        }
        return (ImageView) itemView.findViewById(R$id.os_foot_opt_bar_item_icon);
    }

    @Nullable
    public TextView getItemTextView(int i8) {
        View itemView = getItemView(i8);
        if (itemView == null) {
            return null;
        }
        return (TextView) itemView.findViewById(R$id.os_foot_opt_bar_item_text);
    }

    @Nullable
    public View getItemView(int i8) {
        return this.mContainer.getChildAt(i8);
    }

    public int getPopupMaxHeight() {
        return this.mPopupMaxHeight;
    }

    public n getPopupWindow() {
        if (this.mPopup == null) {
            this.mPopup = new n(this.mContext, 0, R$style.OsLiquidPopupWindowStyle);
            this.mPopup.setContentView((ListView) View.inflate(this.mContext, R$layout.os_popup_window_layout, null));
        }
        return this.mPopup;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void inflateMenu(int i8) {
        inflateMenu(i8, this.isSingGroup);
    }

    public void initForceBCPlatformColorView() {
        OSLiquidContainerRootLayout oSLiquidContainerRootLayout = this.mRoot;
        if (oSLiquidContainerRootLayout != null) {
            oSLiquidContainerRootLayout.enabledPressView(true);
            this.mRoot.getOsPressView().setAlpha(1.0f);
            this.mRoot.getOsPressView().setCornerRadius(this.mRoot.getCornerRadius());
        }
    }

    public void initShow(boolean z2) {
        this.mInitShow = z2;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateFootBarView();
        if (this.mShow) {
            int i8 = getResources().getConfiguration().orientation;
            if (this.mOrientation != i8) {
                getViewTreeObserver().addOnPreDrawListener(this.mMyOnPreDrawListener);
            }
            this.mOrientation = i8;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.realWidth, BasicMeasure.EXACTLY), i9);
    }

    public void openFootOperationBar() {
        if (this.mAnim || this.mShow) {
            return;
        }
        this.mAnim = true;
        this.mShow = true;
        openAnimator();
    }

    public void setAnim(boolean z2) {
        this.mAnim = z2;
    }

    public void setBCPlatformColor(int i8) {
        OSLiquidContainerRootLayout oSLiquidContainerRootLayout = this.mRoot;
        if (oSLiquidContainerRootLayout == null || oSLiquidContainerRootLayout.getOsPressView() == null) {
            return;
        }
        this.mRoot.getOsPressView().setFillColor(i8);
    }

    public void setClickInterval(long j8) {
        this.mClickInterval = j8;
    }

    public void setDisableDefaultClick(boolean z2) {
        this.isDisableDefaultClick = z2;
    }

    public void setLandscape(boolean z2) {
    }

    public void setMixLevel(int i8) {
        this.mRoot.setDialogMixLevel(i8);
    }

    @RequiresApi(api = 31)
    public void setNightMode(boolean z2) {
        this.mRoot.setNightMode(z2);
    }

    public void setOnFootOptBarClickListener(OnFootOptBarClickListener onFootOptBarClickListener) {
        this.mItemClickListener = onFootOptBarClickListener;
    }

    public void setPadding(int i8) {
        this.itemMargin = i8;
    }

    public void setPopList(int[] iArr) {
        n nVar = this.mPopup;
        if (nVar != null && nVar.isShowing()) {
            this.mPopup.dismiss();
        }
        this.mPopupItems.clear();
        String[] strArr = new String[iArr.length];
        for (int i8 = 0; i8 < iArr.length; i8++) {
            String string = this.mContext.getResources().getString(iArr[i8]);
            strArr[i8] = string;
            this.mPopupItems.add(string);
        }
    }

    public void setPopupFullScreenMaxHeight(int i8) {
        if (i8 > 0) {
            setPopupMaxHeight(i8 - getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_min_height));
            return;
        }
        this.mPopupMaxHeight = 0;
        if (this.mPopup != null) {
            setFootPopupWindow();
        }
    }

    public void setPopupMaxHeight(int i8) {
        this.mPopupMaxHeight = i8;
        if (this.mPopup != null) {
            setFootPopupWindow();
        }
    }

    public void setSingGroup(boolean z2) {
        this.isSingGroup = z2;
    }

    public void setTopLineVisible(int i8) {
        View viewFindViewById = findViewById(R$id.os_fob_top_line);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(i8);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        this.mRoot.setVisibility(i8);
    }

    public void toggleFootOperationBar() {
        if (this.mShow) {
            closeFootOperationBar();
        } else {
            openFootOperationBar();
        }
    }

    public void updateFootBarView() {
        n nVar = this.mPopup;
        if (nVar == null || !nVar.isShowing()) {
            return;
        }
        this.mPopup.dismiss();
    }

    public OsLiqBottomToolBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void inflateMenu(int i8, boolean z2) {
        this.isSingGroup = z2;
        MenuInflater menuInflater = new MenuInflater(getContext());
        MenuBuilder menuBuilder = new MenuBuilder(getContext());
        this.mMenuBuilder = menuBuilder;
        menuInflater.inflate(i8, menuBuilder);
        setMenu(this.mMenuBuilder);
    }

    public OsLiqBottomToolBar(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public OsLiqBottomToolBar(Context context, AttributeSet attributeSet, int i8, int i9) {
        int dimensionPixelOffset;
        super(context, attributeSet, i8, i9);
        this.mLastClickTime = 0L;
        this.mClickInterval = 0L;
        this.mShow = false;
        this.mAnim = false;
        this.mInitShow = false;
        this.mImmersive = false;
        this.isDisableDefaultClick = false;
        this.mSelectedIndex = -1;
        this.PRESS_RESPONSE_TIME = 100;
        this.PRESS_ANIMATION_DURATION = 100;
        this.realWidth = 0;
        this.single_maxVisableCount = 6;
        this.single_secondVisableCount = 5;
        this.single_pad_maxVisableCount = 14;
        this.single_pad_secondVisableCount = 2;
        this.isSingGroup = true;
        this.itemMargin = 0;
        this.startSpring = new SpringForce();
        this.stopSpring = new SpringForce();
        OSLiquidContainerRootLayout oSLiquidContainerRootLayout = new OSLiquidContainerRootLayout(context, attributeSet, i8);
        this.mRoot = oSLiquidContainerRootLayout;
        oSLiquidContainerRootLayout.setShadowCorner(hd.a.a(context, (int) context.getResources().getDimension(R$dimen.os_radius_xxl)));
        this.mRoot.setClickable(false);
        this.mRoot.setDialogMixLevel(3);
        addView(this.mRoot);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.os_liquid_foot_opt_bar_root, this.mRoot);
        this.currentScaleAnimator = new SpringAnimation(this, DynamicAnimation.SCALE_X);
        this.mContainer = (LinearLayout) findViewById(R$id.os_foot_opt_bar_container);
        if (j.f8768g) {
            dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R$dimen.os_pad_space050);
        } else {
            dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R$dimen.os_space050);
        }
        this.mContainer.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        this.mPopupItems = new ArrayList();
        this.mMoreIconRes = context.getString(R$string.os_more);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FootOperationBar);
        this.isFootActionBar = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_isFootActionBar, true);
        this.isOnlyScreenPortrait = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_isFootBarOnlyPortrait, false);
        this.isSingGroup = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_foot_single_group, true);
        this.itemMargin = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.FootOperationBar_foot_item_margin, 0.0f);
        if (this.isFootActionBar) {
            this.mTextColor = j.e(this.mContext, R$attr.os_text_primary, R$color.os_text_primary_hios);
        }
        int i10 = typedArrayObtainStyledAttributes.getInt(R$styleable.FootOperationBar_foot_max_visible_tab_count, 6);
        this.mMaxVisibleTabCount = i10;
        if (i10 < 3) {
            this.mMaxVisibleTabCount = 3;
        }
        this.mInitShow = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_foot_init_show, false);
        this.mImmersive = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_foot_immersive, false);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.FootOperationBar_foot_opt_menu)) {
            inflateMenu(typedArrayObtainStyledAttributes.getResourceId(R$styleable.FootOperationBar_foot_opt_menu, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        setBackground(null);
        boolean zQ = j.q(context);
        Log.d(TAG, "FootOperationBar: isGestureNavigationBarOn ==" + zQ + ", mImmersive==" + this.mImmersive);
        MyOnPreDrawListener myOnPreDrawListener = new MyOnPreDrawListener(this);
        this.mMyOnPreDrawListener = myOnPreDrawListener;
        if (!this.isOnlyScreenPortrait) {
            getViewTreeObserver().addOnPreDrawListener(myOnPreDrawListener);
        }
        setClickable(true);
        this.mOrientation = getResources().getConfiguration().orientation;
        init();
    }

    private void addItemView(int[] iArr, String[] strArr, int i8) {
        int i9 = 0;
        while (i9 < i8) {
            addItemView(getMenuItem(strArr[i9], i9 == 0, this.itemMargin), i9);
            i9++;
        }
    }

    public void changeItems(int[] iArr, String[] strArr) {
        n nVar = this.mPopup;
        if (nVar != null && nVar.isShowing()) {
            this.mPopup.dismiss();
        }
        this.mContainer.removeAllViews();
        this.mPopupItems.clear();
        this.mPopup = null;
        this.mSelectedIndex = -1;
        int length = iArr.length;
        this.itemMargin = getPaddingValue(length);
        if (length <= Math.min(this.mMaxVisibleTabCount, 6)) {
            if (length == 1) {
                addItemView(getMenuItemOne(strArr[0]), 0);
                return;
            } else {
                addItemView(iArr, strArr, length);
                return;
            }
        }
        int i8 = this.mMaxVisibleTabCount;
        int i9 = i8 > 6 ? 5 : i8 - 1;
        this.mVisibleTabCount = i9;
        addItemView(iArr, strArr, i9);
        View menuItem = getMenuItem(this.mMoreIconRes, false, this.itemMargin);
        View viewFindViewById = menuItem.findViewById(R$id.os_fob_layout);
        this.mMoreView = viewFindViewById;
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    ((OsPressSmoothCornerDrawable) OsLiqBottomToolBar.this.mMoreView.findViewById(R$id.os_fob_item_back)).b();
                    OsLiqBottomToolBar osLiqBottomToolBar = OsLiqBottomToolBar.this;
                    osLiqBottomToolBar.startPressAnimation(osLiqBottomToolBar.mRoot);
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    ((OsPressSmoothCornerDrawable) OsLiqBottomToolBar.this.mMoreView.findViewById(R$id.os_fob_item_back)).a();
                    OsLiqBottomToolBar osLiqBottomToolBar2 = OsLiqBottomToolBar.this;
                    osLiqBottomToolBar2.stopPressAnimation(osLiqBottomToolBar2.mRoot);
                    OsLiqBottomToolBar.this.mMoreView.setSelected(true);
                    if (!OsLiqBottomToolBar.this.isDisableDefaultClick) {
                        OsLiqBottomToolBar osLiqBottomToolBar3 = OsLiqBottomToolBar.this;
                        osLiqBottomToolBar3.showListPopupWindow(osLiqBottomToolBar3.mContext, OsLiqBottomToolBar.this.mMoreView, 0, (String[]) OsLiqBottomToolBar.this.mPopupItems.toArray(new String[0]));
                    } else if (OsLiqBottomToolBar.this.mItemClickListener != null) {
                        OsLiqBottomToolBar.this.mItemClickListener.onMoreClick(OsLiqBottomToolBar.this.mMoreView);
                    }
                }
                return true;
            }
        });
        this.mContainer.addView(menuItem);
        setPopupItems(strArr, length);
    }

    public void changePopAdapter(int[] iArr, String[] strArr) {
        n nVar = this.mPopup;
        if (nVar != null && nVar.isShowing()) {
            this.mPopup.dismiss();
        }
        this.mPopupItems.clear();
        this.mPopup = null;
        setPopupItems(strArr, iArr.length);
    }

    private void addItemView(View view, final int i8) {
        final View viewFindViewById = view.findViewById(R$id.os_fob_layout);
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.widgetsliquid.view.OsLiqBottomToolBar.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    ((OsPressSmoothCornerDrawable) viewFindViewById.findViewById(R$id.os_fob_item_back)).b();
                    OsLiqBottomToolBar osLiqBottomToolBar = OsLiqBottomToolBar.this;
                    osLiqBottomToolBar.startPressAnimation(osLiqBottomToolBar.mRoot);
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    ((OsPressSmoothCornerDrawable) viewFindViewById.findViewById(R$id.os_fob_item_back)).a();
                    OsLiqBottomToolBar osLiqBottomToolBar2 = OsLiqBottomToolBar.this;
                    osLiqBottomToolBar2.stopPressAnimation(osLiqBottomToolBar2.mRoot);
                    if (OsLiqBottomToolBar.this.mItemClickListener != null) {
                        OsLiqBottomToolBar.this.mItemClickListener.onItemClick(i8);
                    }
                }
                return true;
            }
        });
        this.mContainer.addView(view);
    }

    public void changeFootItem(int i8, int i9, String str) {
        changeFootItem(i8, ContextCompat.getDrawable(this.mContext, i9), str);
    }

    public void changeFootItem(int i8, int i9, int i10) {
        changeFootItem(i8, i9, getResources().getString(i10));
    }

    public void changeFootItem(int i8, String str) {
        changeFootItem(i8, (Drawable) null, str);
    }

    private void setPopupItems(String[] strArr, int i8) {
        int i9 = this.mVisibleTabCount;
        this.mMenuEnables = new boolean[i8 - i9];
        while (i9 < i8) {
            this.mPopupItems.add(strArr[i9]);
            this.mMenuEnables[i9 - this.mVisibleTabCount] = true;
            i9++;
        }
        setFootPopupWindow();
    }

    public void changeFootItem(int i8, Drawable drawable) {
        changeFootItem(i8, drawable, (String) null);
    }

    private View getMenuItem(boolean z2, String str) {
        return getMenuItem(str, z2, this.itemMargin);
    }
}
