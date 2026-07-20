package com.transsion.widgetslib.widget.tablayout;

import af.f;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.R$styleable;
import java.util.Arrays;
import java.util.List;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSTabLayout extends LinearLayout implements View.OnClickListener, View.OnScrollChangeListener {
    public static final /* synthetic */ int p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TabLayout f3667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f3668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f3669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f3670d;
    public ListPopupWindow e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f3671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f3672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f3673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f3674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f3675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewGroup f3676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f3678o;

    public OSTabLayout(Context context) {
        this(context, null);
    }

    public final boolean a() {
        int i8;
        TabLayout tabLayout = this.f3667a;
        boolean z2 = false;
        boolean z3 = tabLayout.getMeasuredWidth() != tabLayout.getChildAt(0).getMeasuredWidth();
        TextView textView = this.f3674k;
        TextView textView2 = this.f3673j;
        int i9 = 8;
        if (!z3) {
            if (textView2.getVisibility() != 8) {
                textView2.setVisibility(8);
                z2 = true;
            }
            if (textView.getVisibility() == 8) {
                return z2;
            }
            textView.setVisibility(8);
            return true;
        }
        TabLayout tabLayout2 = this.f3667a;
        int scrollX = tabLayout2.getScrollX();
        boolean z5 = tabLayout2.getMeasuredWidth() + scrollX >= tabLayout2.getChildAt(0).getMeasuredWidth();
        if (scrollX > 0 && z5) {
            i8 = 8;
            i9 = 0;
        } else if (scrollX > 0) {
            i8 = 0;
            i9 = 0;
        } else {
            i8 = 0;
        }
        if (i9 != textView2.getVisibility()) {
            textView2.setVisibility(i9);
            z2 = true;
        }
        if (i8 == textView.getVisibility()) {
            return z2;
        }
        textView.setVisibility(i8);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0225  */
    /* JADX WARN: Code duplicated, block: B:67:0x018e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0192  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:79:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:86:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:90:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:93:0x0201  */
    /* JADX WARN: Code duplicated, block: B:95:0x0204  */
    /* JADX WARN: Code duplicated, block: B:96:0x0206  */
    /* JADX WARN: Code duplicated, block: B:99:0x020f  */
    public final boolean b() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        boolean z2;
        int dimensionPixelSize3;
        int dimensionPixelSize4;
        boolean z3;
        int i8;
        int i9;
        ViewGroup viewGroup;
        View childAt;
        View view = this.f3675l;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        TabLayout tabLayout = this.f3667a;
        if (tabLayout.getMeasuredWidth() != tabLayout.getChildAt(0).getMeasuredWidth()) {
            dimensionPixelSize = 0;
            dimensionPixelSize2 = 0;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.os_tab_second_underline_margin_start);
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.os_tab_second_underline_margin_end);
            layoutParams.setMarginStart(dimensionPixelSize);
            layoutParams.setMarginEnd(dimensionPixelSize2);
        }
        if (dimensionPixelSize == layoutParams.getMarginStart() && dimensionPixelSize2 == layoutParams.getMarginEnd()) {
            z2 = false;
        } else {
            view.setLayoutParams(layoutParams);
            z2 = true;
        }
        TabLayout tabLayout2 = this.f3667a;
        int dimensionPixelSize5 = tabLayout2.getTabMode() == 0 ? getResources().getDimensionPixelSize(R$dimen.os_space300) : getResources().getDimensionPixelSize(R$dimen.os_space250);
        getContext();
        if (j.f8768g) {
            dimensionPixelSize5 = getResources().getDimensionPixelSize(R$dimen.os_pad_space250);
        }
        for (int i10 = 0; i10 < tabLayout2.getTabCount(); i10++) {
            if (i10 < tabLayout2.getTabCount() - 1) {
                TabLayout.TabView tabView = tabLayout2.h(i10).f3733g;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tabView.getLayoutParams();
                marginLayoutParams.setMarginEnd(dimensionPixelSize5);
                tabView.setLayoutParams(marginLayoutParams);
            }
        }
        if (tabLayout2.getTabCount() <= 2 && tabLayout2.getTabMode() == 1) {
            dimensionPixelSize3 = getMeasuredWidth() > hd.a.a(getContext(), 600) ? getResources().getDimensionPixelSize(R$dimen.os_tab_padding_for_two_large) : getResources().getDimensionPixelSize(R$dimen.os_tab_padding_for_two);
        } else {
            if (tabLayout2.getTabCount() != 3 || tabLayout2.getTabMode() != 1) {
                dimensionPixelSize3 = getMeasuredWidth() > hd.a.a(getContext(), 600) ? getResources().getDimensionPixelSize(R$dimen.os_tab_padding_large) : getResources().getDimensionPixelSize(R$dimen.os_tab_padding);
                if (tabLayout2.getTabMode() == 0) {
                    dimensionPixelSize4 = (getMeasuredWidth() > hd.a.a(getContext(), 600) ? getResources().getDimensionPixelSize(R$dimen.os_tab_padding_start_scrollable_large) : getResources().getDimensionPixelSize(R$dimen.os_tab_padding_start_scrollable)) - this.f3677n;
                    dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_space250);
                }
                if (getMeasuredWidth() > hd.a.a(getContext(), 600) || tabLayout2.getTabCount() > 3.0f || tabLayout2.getTabMode() != 1) {
                    if (this.f3678o) {
                        dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_tab_padding_sh);
                    }
                    if (this.f3668b.getVisibility() == 0) {
                        dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_tab_overflow_image_edge_distance) - getResources().getDimensionPixelSize(R$dimen.os_tab_overflow_image_margin_end);
                    }
                    getContext();
                    if (j.f8768g && tabLayout2.getTabMode() == 1) {
                        if (tabLayout2.getTabCount() != 2 || tabLayout2.getTabCount() == 3) {
                            dimensionPixelSize4 = getResources().getDimensionPixelSize(R$dimen.os_pad_space900);
                        } else if (tabLayout2.getTabCount() == 4) {
                            dimensionPixelSize4 = getResources().getDimensionPixelSize(R$dimen.os_pad_space600);
                        }
                        dimensionPixelSize3 = dimensionPixelSize4;
                    }
                    if (this.f3669c.getMeasuredWidth() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        i8 = dimensionPixelSize3;
                    } else {
                        i8 = 0;
                    }
                    if (z3) {
                        i9 = 0;
                    } else {
                        i9 = dimensionPixelSize3;
                    }
                    viewGroup = this.f3676m;
                    if (i8 != viewGroup.getPaddingEnd()) {
                        viewGroup.setPaddingRelative(0, viewGroup.getPaddingTop(), i8, viewGroup.getPaddingBottom());
                        z2 = true;
                    }
                    childAt = tabLayout2.getChildAt(0);
                    if (dimensionPixelSize4 != childAt.getPaddingStart() && dimensionPixelSize3 == childAt.getPaddingEnd()) {
                        return z2;
                    }
                    childAt.setPaddingRelative(dimensionPixelSize4, viewGroup.getPaddingTop(), i9, viewGroup.getPaddingBottom());
                    return true;
                }
                dimensionPixelSize3 = (int) (getMeasuredWidth() * 0.14f);
                dimensionPixelSize4 = dimensionPixelSize3;
                if (this.f3668b.getVisibility() == 0) {
                    dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_tab_overflow_image_edge_distance) - getResources().getDimensionPixelSize(R$dimen.os_tab_overflow_image_margin_end);
                }
                getContext();
                if (j.f8768g) {
                    if (tabLayout2.getTabCount() != 2) {
                        dimensionPixelSize4 = getResources().getDimensionPixelSize(R$dimen.os_pad_space900);
                        dimensionPixelSize3 = dimensionPixelSize4;
                    } else {
                        dimensionPixelSize4 = getResources().getDimensionPixelSize(R$dimen.os_pad_space900);
                        dimensionPixelSize3 = dimensionPixelSize4;
                    }
                }
                if (this.f3669c.getMeasuredWidth() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    i8 = dimensionPixelSize3;
                } else {
                    i8 = 0;
                }
                if (z3) {
                    i9 = 0;
                } else {
                    i9 = dimensionPixelSize3;
                }
                viewGroup = this.f3676m;
                if (i8 != viewGroup.getPaddingEnd()) {
                    viewGroup.setPaddingRelative(0, viewGroup.getPaddingTop(), i8, viewGroup.getPaddingBottom());
                    z2 = true;
                }
                childAt = tabLayout2.getChildAt(0);
                if (dimensionPixelSize4 != childAt.getPaddingStart()) {
                }
                childAt.setPaddingRelative(dimensionPixelSize4, viewGroup.getPaddingTop(), i9, viewGroup.getPaddingBottom());
                return true;
            }
            dimensionPixelSize3 = getMeasuredWidth() > hd.a.a(getContext(), 600) ? getResources().getDimensionPixelSize(R$dimen.os_tab_padding_for_three_large) : getResources().getDimensionPixelSize(R$dimen.os_tab_padding_for_two);
        }
        dimensionPixelSize4 = dimensionPixelSize3;
        if (getMeasuredWidth() > hd.a.a(getContext(), 600)) {
            if (this.f3678o) {
                dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_tab_padding_sh);
                dimensionPixelSize4 = dimensionPixelSize3;
            }
        } else if (this.f3678o) {
            dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_tab_padding_sh);
            dimensionPixelSize4 = dimensionPixelSize3;
        }
        if (this.f3668b.getVisibility() == 0) {
            dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_tab_overflow_image_edge_distance) - getResources().getDimensionPixelSize(R$dimen.os_tab_overflow_image_margin_end);
        }
        getContext();
        if (j.f8768g) {
            if (tabLayout2.getTabCount() != 2) {
                dimensionPixelSize4 = getResources().getDimensionPixelSize(R$dimen.os_pad_space900);
                dimensionPixelSize3 = dimensionPixelSize4;
            } else {
                dimensionPixelSize4 = getResources().getDimensionPixelSize(R$dimen.os_pad_space900);
                dimensionPixelSize3 = dimensionPixelSize4;
            }
        }
        if (this.f3669c.getMeasuredWidth() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i8 = dimensionPixelSize3;
        } else {
            i8 = 0;
        }
        if (z3) {
            i9 = 0;
        } else {
            i9 = dimensionPixelSize3;
        }
        viewGroup = this.f3676m;
        if (i8 != viewGroup.getPaddingEnd()) {
            viewGroup.setPaddingRelative(0, viewGroup.getPaddingTop(), i8, viewGroup.getPaddingBottom());
            z2 = true;
        }
        childAt = tabLayout2.getChildAt(0);
        if (dimensionPixelSize4 != childAt.getPaddingStart()) {
        }
        childAt.setPaddingRelative(dimensionPixelSize4, viewGroup.getPaddingTop(), i9, viewGroup.getPaddingBottom());
        return true;
    }

    public View getLeftMaskView() {
        return this.f3673j;
    }

    public View getRightMaskView() {
        return this.f3674k;
    }

    public TabLayout getTabLayout() {
        return this.f3667a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView = this.f3668b;
        if (view == imageView) {
            ListPopupWindow listPopupWindow = this.e;
            if (listPopupWindow != null) {
                listPopupWindow.setVerticalOffset((getHeight() - imageView.getHeight()) / 2);
                this.e.show();
            }
            View.OnClickListener onClickListener = this.f3671h;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (this.f3678o) {
            TabLayout tabLayout = this.f3667a;
            if (tabLayout.getTabCount() > 2.0f && tabLayout.getTabMode() != 0) {
                tabLayout.setTabMode(0);
            }
        }
        a();
        if (b()) {
            super.onMeasure(i8, i9);
        }
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View view, int i8, int i9, int i10, int i11) {
        a();
    }

    public void setBackground(int i8) {
        setBackgroundResource(i8);
    }

    public void setCustomMenuView(View view) {
        LinearLayout linearLayout = this.f3669c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            linearLayout.addView(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    public void setOnItemClickListener(ge.a aVar) {
    }

    public void setOverFlowMenuItem(@ArrayRes int i8) {
        ImageView imageView = this.f3668b;
        imageView.setVisibility(0);
        List listAsList = Arrays.asList(getResources().getStringArray(i8));
        this.f3670d = listAsList;
        if (listAsList != null) {
            this.f3672i = new boolean[listAsList.size()];
            for (int i9 = 0; i9 < listAsList.size(); i9++) {
                this.f3672i[i9] = true;
            }
        }
        ge.c cVar = new ge.c(this);
        ListPopupWindow listPopupWindow = new ListPopupWindow(getContext(), null, 0, R$style.OSTabOverflow);
        this.e = listPopupWindow;
        listPopupWindow.setAnchorView(imageView);
        this.e.setAdapter(cVar);
        this.e.setModal(true);
        this.e.setContentWidth(j.C(getContext(), cVar));
    }

    public void setOverflowButtonVisible(boolean z2) {
        ImageView imageView = this.f3668b;
        if (imageView != null) {
            if (z2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setOverflowImage(@DrawableRes int i8) {
        ImageView imageView = this.f3668b;
        if (imageView != null) {
            imageView.setBackground(getResources().getDrawable(i8));
        }
    }

    public void setShowBottomLine(boolean z2) {
        View view = this.f3675l;
        if (z2) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public OSTabLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearLayout.inflate(context, R$layout.os_tab_layout, this);
        setOrientation(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSTabLayout);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSTabLayout_osShowBottomLine, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSTabLayout_osIsFirstLevelTab, false);
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSTabLayout_osTabLayoutTextSize, -1);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{R$attr.OsBgPrimary});
        int color = typedArrayObtainStyledAttributes2.getColor(0, ContextCompat.getColor(context, R$color.os_bg_primary_color));
        typedArrayObtainStyledAttributes2.recycle();
        setBackgroundColor(typedArrayObtainStyledAttributes.getColor(R$styleable.OSTabLayout_osTabLayoutBackground, color));
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(R$style.OSTablayout, new int[]{R$attr.tabPaddingStart});
        typedArrayObtainStyledAttributes3.getDimensionPixelSize(0, context.getResources().getDimensionPixelSize(R$dimen.os_tab_item_padding_start));
        typedArrayObtainStyledAttributes3.recycle();
        this.f3677n = context.getResources().getDimensionPixelSize(R$dimen.os_tab_item_scroll_padding_start);
        View viewFindViewById = findViewById(R$id.tablayout_underline);
        this.f3675l = viewFindViewById;
        if (z2) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(4);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R$id.tablayout);
        this.f3667a = tabLayout;
        tabLayout.setOnScrollChangeListener(this);
        tabLayout.f3683b = this;
        ImageView imageView = (ImageView) findViewById(R$id.overFlowButton);
        this.f3668b = imageView;
        this.f3669c = (LinearLayout) findViewById(R$id.ll_icon_container);
        imageView.setOnClickListener(this);
        this.f3673j = (TextView) findViewById(R$id.tv_left_mask);
        this.f3674k = (TextView) findViewById(R$id.tv_right_mask);
        tabLayout.k(z3);
        if (dimensionPixelSize != -1.0f) {
            tabLayout.setTabTextSize(dimensionPixelSize);
        }
        this.f3676m = (ViewGroup) findViewById(R$id.ll_tab_icon_container);
        post(new f(this, 20));
        this.f3678o = j.z(getContext());
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f3671h = onClickListener;
    }
}
