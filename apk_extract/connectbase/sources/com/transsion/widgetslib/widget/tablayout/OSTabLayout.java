package com.transsion.widgetslib.widget.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OSTabLayout extends LinearLayout implements View.OnClickListener, View.OnScrollChangeListener {
    public static final String H = "OSTabLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TabLayout f3107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f3108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f3109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f3110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ListPopupWindow f3111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f3112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f3113g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f3114i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3115n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3116p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f3117v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f3118w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f3119x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f3120y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3121z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSTabLayout.this.g();
        }
    }

    public interface b {
        void a(int i10);
    }

    public class c extends BaseAdapter {

        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f3124a;

            public a(int i10) {
                this.f3124a = i10;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OSTabLayout.this.f3112f != null) {
                    OSTabLayout.this.f3112f.a(this.f3124a);
                }
                OSTabLayout.this.f3111e.dismiss();
            }
        }

        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f3126a;

            public b() {
            }

            public /* synthetic */ b(c cVar, a aVar) {
                this();
            }
        }

        public c() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OSTabLayout.this.f3110d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return OSTabLayout.this.f3110d.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                View viewInflate = LayoutInflater.from(OSTabLayout.this.getContext()).inflate(R.layout.os_tab_overflow_popup_item, viewGroup, false);
                bVar2.f3126a = (TextView) viewInflate.findViewById(R.id.os_tab_overflow_popup_item_text);
                viewInflate.setTag(bVar2);
                bVar = bVar2;
                view = viewInflate;
            } else {
                bVar = (b) view.getTag();
            }
            view.setBackgroundResource(R.drawable.os_press_primary_bg);
            bVar.f3126a.setText((CharSequence) OSTabLayout.this.f3110d.get(i10));
            OSTabLayout oSTabLayout = OSTabLayout.this;
            oSTabLayout.m(view, oSTabLayout.f3114i[i10]);
            view.setOnClickListener(new a(i10));
            return view;
        }

        public /* synthetic */ c(OSTabLayout oSTabLayout, a aVar) {
            this();
        }
    }

    public OSTabLayout(Context context) {
        this(context, null);
    }

    public final void g() {
        if (!j()) {
            this.f3117v.setVisibility(8);
            this.f3118w.setVisibility(8);
            return;
        }
        int scrollX = this.f3107a.getScrollX();
        boolean z10 = this.f3107a.getMeasuredWidth() + scrollX >= this.f3107a.getChildAt(0).getMeasuredWidth();
        if (scrollX > 0 && z10) {
            this.f3117v.setVisibility(0);
            this.f3118w.setVisibility(8);
        } else if (scrollX > 0) {
            this.f3117v.setVisibility(0);
            this.f3118w.setVisibility(0);
        } else {
            this.f3117v.setVisibility(8);
            this.f3118w.setVisibility(0);
        }
    }

    public TabLayout getTabLayout() {
        return this.f3107a;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0096  */
    /* JADX WARN: Code duplicated, block: B:25:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    public void h() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3119x.getLayoutParams();
        if (j()) {
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(0);
        } else {
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.os_tab_second_underline_margin_start);
            int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.os_tab_second_underline_margin_end);
            layoutParams.setMarginStart(dimensionPixelSize3);
            layoutParams.setMarginEnd(dimensionPixelSize4);
        }
        this.f3119x.setLayoutParams(layoutParams);
        if (this.f3107a.getTabCount() <= 2 && this.f3107a.getTabMode() == 1) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_tab_padding_for_two);
        } else {
            if (this.f3107a.getTabCount() != 3 || this.f3107a.getTabMode() != 1) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_tab_padding);
                if (this.f3107a.getTabMode() == 0) {
                    dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.os_tab_padding_start_scrollable) - this.f3121z;
                }
                if (this.f3108b.getVisibility() == 0) {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_tab_overflow_image_edge_distance) - getResources().getDimensionPixelSize(R.dimen.os_tab_overflow_image_margin_end);
                }
                View view = this.f3120y;
                view.setPaddingRelative(0, view.getPaddingTop(), dimensionPixelSize, this.f3120y.getPaddingBottom());
                if (this.f3107a.getChildAt(0) != null) {
                    this.f3107a.getChildAt(0).setPaddingRelative(dimensionPixelSize2, this.f3107a.getPaddingTop(), 0, this.f3107a.getPaddingBottom());
                }
            }
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_tab_padding_for_three);
        }
        dimensionPixelSize2 = dimensionPixelSize;
        if (this.f3108b.getVisibility() == 0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_tab_overflow_image_edge_distance) - getResources().getDimensionPixelSize(R.dimen.os_tab_overflow_image_margin_end);
        }
        View view2 = this.f3120y;
        view2.setPaddingRelative(0, view2.getPaddingTop(), dimensionPixelSize, this.f3120y.getPaddingBottom());
        if (this.f3107a.getChildAt(0) != null) {
            this.f3107a.getChildAt(0).setPaddingRelative(dimensionPixelSize2, this.f3107a.getPaddingTop(), 0, this.f3107a.getPaddingBottom());
        }
    }

    public final void i(List<String> list) {
        if (list != null) {
            this.f3114i = new boolean[this.f3110d.size()];
            for (int i10 = 0; i10 < list.size(); i10++) {
                this.f3114i[i10] = true;
            }
        }
    }

    public final boolean j() {
        return this.f3107a.getMeasuredWidth() != this.f3107a.getChildAt(0).getMeasuredWidth();
    }

    public final int k(ListAdapter listAdapter, int i10) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i11 = 0;
        int i12 = 0;
        View view = null;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = listAdapter.getView(i13, view, null);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    public void l(int i10, boolean z10) {
        boolean[] zArr = this.f3114i;
        if (zArr != null) {
            zArr[i10] = z10;
        }
    }

    public final void m(View view, boolean z10) {
        view.setEnabled(z10);
        view.setAlpha(z10 ? 1.0f : 0.3f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f3108b) {
            ListPopupWindow listPopupWindow = this.f3111e;
            if (listPopupWindow != null) {
                listPopupWindow.setVerticalOffset((getHeight() - this.f3108b.getHeight()) / 2);
                this.f3111e.show();
            }
            View.OnClickListener onClickListener = this.f3113g;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        g();
        h();
    }

    @Override // android.view.View.OnScrollChangeListener
    public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
        g();
    }

    public void setBackground(int i10) {
        setBackgroundResource(i10);
    }

    public void setCustomMenuView(View view) {
        LinearLayout linearLayout = this.f3109c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.f3109c.addView(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    public void setOnItemClickListener(b bVar) {
        this.f3112f = bVar;
    }

    public void setOverFlowMenuItem(@ArrayRes int i10) {
        this.f3108b.setVisibility(0);
        List<String> listAsList = Arrays.asList(getResources().getStringArray(i10));
        this.f3110d = listAsList;
        i(listAsList);
        c cVar = new c();
        ListPopupWindow listPopupWindow = new ListPopupWindow(getContext(), null, 0, R.style.OSTabOverflow);
        this.f3111e = listPopupWindow;
        listPopupWindow.setAnchorView(this.f3108b);
        this.f3111e.setAdapter(cVar);
        this.f3111e.setModal(true);
        this.f3111e.setContentWidth(k(cVar, getResources().getDisplayMetrics().widthPixels / 2));
    }

    public void setOverflowButtonVisible(boolean z10) {
        ImageView imageView = this.f3108b;
        if (imageView != null) {
            if (z10) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setOverflowImage(@DrawableRes int i10) {
        ImageView imageView = this.f3108b;
        if (imageView != null) {
            imageView.setBackground(getResources().getDrawable(i10));
        }
    }

    public void setShowBottomLine(boolean z10) {
        if (z10) {
            this.f3119x.setVisibility(0);
        } else {
            this.f3119x.setVisibility(4);
        }
    }

    public OSTabLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setLayoutParams(layoutParams);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.os_tab_layout, (ViewGroup) null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSTabLayout);
        this.f3115n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSTabLayout_osShowBottomLine, false);
        this.f3116p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSTabLayout_osIsFirstLevelTab, false);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{R.attr.OsBgPrimary});
        int color = typedArrayObtainStyledAttributes2.getColor(0, ContextCompat.getColor(context, R.color.os_bg_primary_color));
        typedArrayObtainStyledAttributes2.recycle();
        viewInflate.setBackgroundColor(typedArrayObtainStyledAttributes.getColor(R.styleable.OSTabLayout_osTabLayoutBackground, color));
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(R.style.OSTablayout, new int[]{R.attr.tabPaddingStart});
        this.f3121z = typedArrayObtainStyledAttributes3.getDimensionPixelSize(0, context.getResources().getDimensionPixelSize(R.dimen.os_tab_item_padding_start));
        typedArrayObtainStyledAttributes3.recycle();
        View viewFindViewById = viewInflate.findViewById(R.id.tablayout_underline);
        this.f3119x = viewFindViewById;
        if (this.f3115n) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(4);
        }
        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(R.id.tablayout);
        this.f3107a = tabLayout;
        tabLayout.setOnScrollChangeListener(this);
        this.f3107a.p(this);
        this.f3108b = (ImageView) viewInflate.findViewById(R.id.overFlowButton);
        this.f3109c = (LinearLayout) viewInflate.findViewById(R.id.ll_icon_container);
        this.f3108b.setOnClickListener(this);
        this.f3117v = (TextView) viewInflate.findViewById(R.id.tv_left_mask);
        this.f3118w = (TextView) viewInflate.findViewById(R.id.tv_right_mask);
        this.f3107a.D(this.f3116p);
        this.f3120y = viewInflate.findViewById(R.id.ll_tab_icon_container);
        addView(viewInflate, layoutParams);
        post(new a());
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f3113g = onClickListener;
    }
}
