package qd;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.transsion.widgetslib.R$integer;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.view.ViewPagerTabs;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPager f8985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPagerTabs f8986b;

    public l(ViewPagerTabs viewPagerTabs, ViewPager viewPager) {
        this.f8986b = viewPagerTabs;
        this.f8985a = viewPager;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewPagerTabs viewPagerTabs = this.f8986b;
        viewPagerTabs.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (viewPagerTabs.p != null) {
            n nVar = new n(viewPagerTabs);
            ViewPager viewPager = this.f8985a;
            viewPager.setOnPageChangeListener(nVar);
            int count = viewPagerTabs.p.getAdapter().getCount();
            viewPagerTabs.f3209n = count;
            int[] iArr = viewPagerTabs.f3207l;
            if (iArr != null && iArr.length != count) {
                int[] iArr2 = new int[count];
                int i8 = 0;
                while (i8 < viewPagerTabs.f3209n) {
                    int[] iArr3 = viewPagerTabs.f3207l;
                    iArr2[i8] = i8 <= iArr3.length - 1 ? iArr3[i8] : -1;
                    i8++;
                }
                viewPagerTabs.f3207l = iArr2;
            }
            Context context = viewPagerTabs.f3200b;
            if (context != null) {
                viewPagerTabs.f3199a.removeAllViews();
                PagerAdapter adapter = viewPagerTabs.p.getAdapter();
                int count2 = adapter.getCount();
                if (count2 < 2 || count2 > 4) {
                    viewPagerTabs.f3208m = false;
                }
                ArrayList arrayList = viewPagerTabs.f3205j;
                if (arrayList != null) {
                    arrayList.clear();
                } else {
                    viewPagerTabs.f3205j = new ArrayList(count2);
                }
                int i9 = viewPagerTabs.f3213t / count2;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i9, -1);
                for (int i10 = 0; i10 < count2; i10++) {
                    CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(context).inflate(R$layout.tab_textview, (ViewGroup) null);
                    CharSequence pageTitle = adapter.getPageTitle(i10);
                    if (pageTitle == null) {
                        pageTitle = "";
                    }
                    checkedTextView.setText(pageTitle.toString().trim());
                    checkedTextView.setChecked(false);
                    checkedTextView.setTextAppearance(R$style.os_regular_fontweight);
                    checkedTextView.setSingleLine(true);
                    checkedTextView.setGravity(17);
                    if (viewPagerTabs.f3208m) {
                        ViewPagerTabs.a(checkedTextView, i9 - (viewPagerTabs.f3202d * 2));
                    }
                    float fMeasureText = checkedTextView.getPaint().measureText((String) checkedTextView.getText());
                    viewPagerTabs.f3205j.add(Float.valueOf(fMeasureText));
                    if (viewPagerTabs.f3208m) {
                        checkedTextView.setWidth(i9);
                    } else {
                        checkedTextView.setWidth((int) ((viewPagerTabs.f3201c * 2) + fMeasureText));
                        int i11 = viewPagerTabs.f3201c;
                        checkedTextView.setPadding(i11, 0, i11, 0);
                    }
                    checkedTextView.setTypeface(Typeface.create(Typeface.SANS_SERIF, viewPagerTabs.getResources().getInteger(R$integer.OSSemiBoldWeight), false));
                    checkedTextView.setOnClickListener(new k(i10, 1, viewPagerTabs));
                    if (i10 == viewPagerTabs.f3199a.f8987a) {
                        checkedTextView.setChecked(true);
                        checkedTextView.setTextAppearance(R$style.os_semibold_font);
                    }
                    viewPagerTabs.f3199a.addView(checkedTextView, layoutParams);
                }
            }
            viewPagerTabs.setHorizontalScrollBarEnabled(false);
            viewPager.setCurrentItem(viewPagerTabs.getDefaultViewPagerItemIndex(), false);
        }
    }
}
