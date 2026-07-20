package zd;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends PopupWindow {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f11295m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f11297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11299d;
    public View e;
    public FrameLayout f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public id.a f11300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f11301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11305l;

    public n(Context context, int i8, int i9) {
        super(context, (AttributeSet) null, i8, i9);
        this.f11301h = context;
    }

    public final int b(int i8, View view) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        Resources resources;
        ListView listView;
        ListAdapter adapter2;
        int marginEnd;
        int marginStart;
        View view2 = this.e;
        if (view2 == null) {
            view2 = null;
        }
        boolean z2 = view2 instanceof ListView;
        Context context = this.f11301h;
        if (!z2 || (adapter2 = (listView = (ListView) view2).getAdapter()) == null) {
            if (!(view2 instanceof RecyclerView) || (adapter = (recyclerView = (RecyclerView) view2).getAdapter()) == null) {
                if (view2 != null) {
                    view2.measure(0, 0);
                    return view2.getMeasuredHeight() * i8;
                }
                int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
                Intrinsics.checkNotNull(context);
                return (context.getResources().getDimensionPixelSize(R$dimen.os_popup_menu_bg_margin_bottom) * 2) + paddingBottom;
            }
            int dimensionPixelSize = (((context == null || (resources = context.getResources()) == null) ? 0 : resources.getDimensionPixelSize(R$dimen.os_popup_menu_bg_margin_bottom)) * 2) + recyclerView.getPaddingBottom() + recyclerView.getPaddingTop() + view.getPaddingBottom() + view.getPaddingTop();
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth() > 0 ? getWidth() : recyclerView.getWidth(), Integer.MIN_VALUE);
            FrameLayout frameLayout = new FrameLayout(recyclerView.getContext());
            int itemCount = adapter.getItemCount();
            for (int i9 = 0; i9 < itemCount; i9++) {
                RecyclerView.ViewHolder viewHolderOnCreateViewHolder = adapter.onCreateViewHolder(frameLayout, adapter.getItemViewType(i9));
                Intrinsics.checkNotNullExpressionValue(viewHolderOnCreateViewHolder, "adapter.onCreateViewHolder(parent, vt)");
                adapter.onBindViewHolder(viewHolderOnCreateViewHolder, i9);
                View view3 = viewHolderOnCreateViewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "vh.itemView");
                view3.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                dimensionPixelSize += view3.getMeasuredHeight();
            }
            return dimensionPixelSize;
        }
        Intrinsics.checkNotNull(context);
        int dimensionPixelSize2 = (context.getResources().getDimensionPixelSize(R$dimen.os_popup_menu_bg_margin_bottom) * 2) + listView.getPaddingBottom() + listView.getPaddingTop() + view.getPaddingBottom() + view.getPaddingTop();
        int iMax = Math.max(0, ((getWidth() > 0 ? getWidth() : view.getMeasuredWidth()) - view.getPaddingLeft()) - view.getPaddingRight());
        ViewGroup viewGroup = (ViewGroup) view2;
        View sample = adapter2.getView(0, null, viewGroup);
        Intrinsics.checkNotNullExpressionValue(sample, "sample");
        int dimensionPixelSize3 = sample.getResources().getDimensionPixelSize(R$dimen.os_popup_menu_size);
        View viewFindViewById = sample.findViewById(R$id.os_list_popup_left_text_icon);
        if (viewFindViewById == null || viewFindViewById.getVisibility() != 0) {
            marginEnd = 0;
        } else {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            marginEnd = (marginLayoutParams != null ? marginLayoutParams.getMarginEnd() : 0) + dimensionPixelSize3;
        }
        View viewFindViewById2 = sample.findViewById(R$id.os_list_popup_right_text_icon);
        if (viewFindViewById2 == null || viewFindViewById2.getVisibility() != 0) {
            marginStart = 0;
        } else {
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            marginStart = dimensionPixelSize3 + (marginLayoutParams2 != null ? marginLayoutParams2.getMarginStart() : 0);
        }
        int paddingRight = ((iMax - (sample.getPaddingRight() + sample.getPaddingLeft())) - marginEnd) - marginStart;
        if (paddingRight <= 0) {
            paddingRight = 0;
        }
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax, Integer.MIN_VALUE);
        int count = adapter2.getCount();
        for (int i10 = 0; i10 < count; i10++) {
            View view4 = adapter2.getView(i10, null, viewGroup);
            TextView textView = (TextView) view4.findViewById(R.id.text1);
            if (textView != null) {
                textView.setMaxWidth(paddingRight);
            }
            TextView textView2 = (TextView) view4.findViewById(R$id.os_list_popup_sub_text);
            if (textView2 != null) {
                textView2.setMaxWidth(paddingRight);
            }
            view4.measure(iMakeMeasureSpec2, View.MeasureSpec.makeMeasureSpec(0, 0));
            dimensionPixelSize2 += view4.getMeasuredHeight();
        }
        return dimensionPixelSize2;
    }

    public final void c(View view) {
        View contentView;
        RecyclerView.Adapter adapter;
        int iB;
        Resources resources;
        Resources resources2;
        if (this.f11303j || (contentView = getContentView()) == null || view == null) {
            return;
        }
        Context context = this.f11301h;
        if (context != null && (resources2 = context.getResources()) != null) {
            resources2.getDimensionPixelSize(R$dimen.os_popup_menu_inset_left);
        }
        int dimensionPixelSize = (context == null || (resources = context.getResources()) == null) ? 0 : resources.getDimensionPixelSize(R$dimen.os_popup_menu_bg_margin_bottom);
        this.f11297b = view;
        contentView.measure(0, 0);
        View view2 = this.e;
        int itemCount = 1;
        if (view2 instanceof ListView) {
            ListAdapter adapter2 = ((ListView) view2).getAdapter();
            if (adapter2 != null) {
                itemCount = adapter2.getCount();
            }
        } else if ((view2 instanceof RecyclerView) && (adapter = ((RecyclerView) view2).getAdapter()) != null) {
            itemCount = adapter.getItemCount();
        }
        getHeight();
        View view3 = this.e;
        if ((view3 instanceof ListView) || (view3 instanceof RecyclerView)) {
            View viewFindViewById = contentView.findViewById(R$id.liquid_popview);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "content.findViewById(R.id.liquid_popview)");
            iB = b(itemCount, viewFindViewById);
        } else {
            iB = (dimensionPixelSize * 2) + contentView.getMeasuredHeight();
        }
        d(view, contentView.getMeasuredWidth(), iB);
    }

    public final void d(View view, int i8, int i9) {
        View contentView;
        Resources resources;
        if (this.f11303j || this.f11304k || (contentView = getContentView()) == null || view == null) {
            return;
        }
        Context context = this.f11301h;
        boolean z2 = false;
        int dimensionPixelSize = (context == null || (resources = context.getResources()) == null) ? 0 : resources.getDimensionPixelSize(R$dimen.os_popup_menu_inset_left);
        this.f11297b = view;
        int iK = pd.j.k(contentView.getContext());
        int i10 = pd.j.i(contentView.getContext());
        int width = getWidth() > 0 ? getWidth() : i8 + (dimensionPixelSize * 2);
        int[] iArr = new int[2];
        View view2 = this.f11297b;
        if (view2 != null) {
            view2.getLocationOnScreen(iArr);
        }
        this.f11298c = view.getHeight() + (iArr[1] + i9) > i10;
        int i11 = iArr[0];
        if (i11 + width > iK) {
            View view3 = this.f11297b;
            Intrinsics.checkNotNull(view3);
            if ((view3.getWidth() + i11) - width > 0) {
                z2 = true;
            }
        }
        this.f11299d = z2;
        this.f11304k = true;
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        int i8 = 0;
        if (this.f11296a) {
            return;
        }
        View contentView = getContentView();
        if (contentView == null) {
            super.dismiss();
            return;
        }
        int width = contentView.getWidth();
        int height = contentView.getHeight();
        contentView.setPivotX(!this.f11299d ? 0.0f : width / 1.0f);
        contentView.setPivotY(this.f11298c ? height / 1.0f : 0.0f);
        a8.f fVar = new a8.f(contentView, a8.f.f57n);
        a8.g gVar = new a8.g();
        gVar.b(300.0f);
        gVar.a(0.75f);
        double d7 = 0.0f;
        gVar.f78i = d7;
        fVar.f70l = gVar;
        fVar.f62b = 1.0f;
        fVar.f63c = true;
        fVar.f66h = 0.002f;
        fVar.c();
        a8.f fVar2 = new a8.f(contentView, a8.f.f58o);
        a8.g gVar2 = new a8.g();
        gVar2.b(200.0f);
        gVar2.a(0.75f);
        gVar2.f78i = d7;
        fVar2.f70l = gVar2;
        fVar2.f62b = 1.0f;
        fVar2.f63c = true;
        fVar2.f66h = 0.002f;
        fVar2.c();
        ObjectAnimator animator = ObjectAnimator.ofFloat(contentView, (Property<View, Float>) View.ALPHA, contentView.getAlpha(), 0.0f);
        animator.setDuration(100L);
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        this.f11296a = true;
        animator.addListener(new m(this, i8));
        animator.start();
    }

    public final void e() {
        View view = this.e;
        if (view instanceof ListView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.ListView");
            ((ListView) view).setSelector(new ColorDrawable(0));
            View view2 = this.e;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.ListView");
            ((ListView) view2).setChoiceMode(0);
        }
        View contentView = getContentView();
        ViewParent parent = contentView != null ? contentView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    public final void f(int i8, View anchor) {
        Resources resources;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getContentView() == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        View contentView = getContentView();
        if (contentView == null) {
            return;
        }
        this.f11297b = anchor;
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        contentView.measure(0, 0);
        int iJ = pd.j.j(contentView.getContext());
        int width = getWidth() > 0 ? getWidth() : contentView.getMeasuredWidth();
        int dimensionPixelSize = contentView.getResources().getDimensionPixelSize(R$dimen.os_popup_menu_inset_left);
        Context context = this.f11301h;
        int dimensionPixelSize2 = (context == null || (resources = context.getResources()) == null) ? 0 : resources.getDimensionPixelSize(R$dimen.os_popup_menu_bg_margin_bottom);
        View viewFindViewById = contentView.findViewById(R$id.liquid_popview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "content.findViewById(R.id.liquid_popview)");
        int iB = b(i8, viewFindViewById);
        int i9 = iArr[0];
        int width2 = i9 - dimensionPixelSize;
        if (width2 + width > iJ) {
            width2 = (anchor.getWidth() + i9) - width > dimensionPixelSize ? ((anchor.getWidth() + iArr[0]) - width) + dimensionPixelSize : iJ - width;
        }
        if (width2 < 0) {
            width2 = 0;
        }
        int height = anchor.getHeight() + (iArr[1] - iB) + dimensionPixelSize2;
        d(this.f11297b, contentView.getMeasuredWidth(), iB);
        if (this.f11298c) {
            showAtLocation(anchor, 0, width2, height);
        } else {
            showAsDropDown(anchor, 0, 0);
        }
    }

    public final void g() {
        View contentView = getContentView();
        if (contentView == null) {
            return;
        }
        if (this.f11305l) {
            contentView.setAlpha(1.0f);
            contentView.setScaleX(1.0f);
            contentView.setScaleY(1.0f);
        } else {
            if (this.f11302i) {
                return;
            }
            this.f11302i = true;
            contentView.setAlpha(0.0f);
            contentView.setScaleX(0.0f);
            contentView.setScaleY(0.0f);
            contentView.post(new o.e(29, this, contentView));
        }
    }

    public final id.a getAdpater() {
        return this.f11300g;
    }

    public final FrameLayout getContainer() {
        return this.f;
    }

    public final View getList() {
        return this.e;
    }

    public final void setAdapter(id.a aVar) {
        this.f11300g = aVar;
    }

    @Override // android.widget.PopupWindow
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @RequiresApi(31)
    public final void setBlackMode(boolean z2) {
        View contentView = getContentView();
        Intrinsics.checkNotNull(contentView, "null cannot be cast to non-null type com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner");
        ((OSLiquidContainerRootLayoutInner) contentView).setNightMode(z2);
        Context context = this.f11301h;
        if (z2) {
            View contentView2 = getContentView();
            Intrinsics.checkNotNull(contentView2, "null cannot be cast to non-null type com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner");
            Intrinsics.checkNotNull(context);
            ((OSLiquidContainerRootLayoutInner) contentView2).setDefaultBgColor(context.getColor(R$color.os_color_gray90));
            return;
        }
        View contentView3 = getContentView();
        Intrinsics.checkNotNull(contentView3, "null cannot be cast to non-null type com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner");
        Intrinsics.checkNotNull(context);
        ((OSLiquidContainerRootLayoutInner) contentView3).setDefaultBgColor(context.getColor(R$color.os_color_white100));
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        this.e = view;
        super.setContentView(p2.d.c(view));
        View contentView = getContentView();
        FrameLayout frameLayout = contentView != null ? (FrameLayout) contentView.findViewById(R$id.liquid_popview) : null;
        this.f = frameLayout != null ? frameLayout : null;
    }

    public final void setData(ArrayList<CharSequence> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Context context = this.f11301h;
        Intrinsics.checkNotNull(context);
        id.a aVar = new id.a(context, data);
        Intrinsics.checkNotNull(context);
        ListView listView = new ListView(context);
        listView.setDivider(null);
        listView.setSelector(new ColorDrawable(0));
        listView.setChoiceMode(0);
        this.e = listView;
        this.f11300g = aVar;
        listView.setAdapter((ListAdapter) aVar);
        super.setContentView(p2.d.c(listView));
        View contentView = getContentView();
        FrameLayout frameLayout = contentView != null ? (FrameLayout) contentView.findViewById(R$id.liquid_popview) : null;
        this.f = frameLayout != null ? frameLayout : null;
    }

    public final void setDisableAnimation(boolean z2) {
        this.f11305l = z2;
    }

    public final void setIcons(ArrayList<CharSequence> icons) {
        Intrinsics.checkNotNullParameter(icons, "icons");
        id.a aVar = this.f11300g;
        if (aVar == null) {
            return;
        }
        Intrinsics.checkNotNull(aVar);
        aVar.setLeftTextIcon(icons);
    }

    public final void setList(View view) {
        this.e = view;
        setContentView(view);
    }

    @RequiresApi(26)
    public final void setMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Context context = this.f11301h;
        Intrinsics.checkNotNull(context);
        int size = menu.size();
        ArrayList arrayList = new ArrayList(size);
        int i8 = 0;
        while (true) {
            CharSequence charSequence = "";
            if (i8 >= size) {
                break;
            }
            CharSequence title = menu.getItem(i8).getTitle();
            if (title != null) {
                charSequence = title;
            }
            arrayList.add(charSequence);
            i8++;
        }
        int size2 = menu.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i9 = 0; i9 < size2; i9++) {
            if (menu.getItem(i9).getContentDescription() == null) {
                arrayList2.add("");
            } else {
                CharSequence contentDescription = menu.getItem(i9).getContentDescription();
                if (contentDescription == null) {
                    contentDescription = "";
                }
                arrayList2.add(contentDescription);
            }
        }
        ListView listView = new ListView(context);
        listView.setDivider(null);
        listView.setSelector(new ColorDrawable(0));
        listView.setChoiceMode(0);
        this.e = listView;
        id.a aVar = new id.a(context, arrayList);
        aVar.setLeftTextIcon(arrayList2);
        this.f11300g = aVar;
        listView.setAdapter((ListAdapter) aVar);
        super.setContentView(p2.d.c(listView));
        View contentView = getContentView();
        FrameLayout frameLayout = contentView != null ? (FrameLayout) contentView.findViewById(R$id.liquid_popview) : null;
        this.f = frameLayout != null ? frameLayout : null;
    }

    @Override // android.widget.PopupWindow
    public void setWidth(int i8) {
        Context context = this.f11301h;
        Intrinsics.checkNotNull(context);
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int iApplyDimension = (int) (pd.j.f8768g ? TypedValue.applyDimension(1, 310.0f, displayMetrics) : (pd.j.s() ? pd.j.g(context, R$dimen.os_ultra_small_popup_window_width_max_weight) : pd.j.g(context, R$dimen.os_popup_window_width_max_weight)) * displayMetrics.widthPixels);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 160.0f, displayMetrics);
        if (i8 > iApplyDimension) {
            i8 = iApplyDimension;
        } else if (i8 < iApplyDimension2) {
            i8 = iApplyDimension2;
        }
        super.setWidth(i8);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view) {
        this.f11297b = view;
        super.showAsDropDown(view);
        e();
        View contentView = getContentView();
        if (contentView != null) {
            contentView.post(new l(this, 2));
        }
        g();
        this.f11304k = false;
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View view, int i8, int i9, int i10) {
        this.f11297b = view;
        super.showAtLocation(view, i8, i9, i10);
        e();
        View contentView = getContentView();
        if (contentView != null) {
            contentView.post(new l(this, 1));
        }
        g();
        this.f11304k = false;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i8, int i9) {
        this.f11297b = view;
        super.showAsDropDown(view, i8, i9);
        e();
        View contentView = getContentView();
        if (contentView != null) {
            contentView.post(new l(this, 3));
        }
        g();
        this.f11304k = false;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i8, int i9, int i10) {
        this.f11297b = view;
        super.showAsDropDown(view, i8, i9, i10);
        e();
        View contentView = getContentView();
        if (contentView != null) {
            contentView.post(new l(this, 0));
        }
        g();
        this.f11304k = false;
    }
}
