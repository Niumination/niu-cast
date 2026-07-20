package kd;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.view.OSLoadingButton;
import com.transsion.widgetslib.view.damping.OSSmartScrollbar;
import com.transsion.widgetslib.widget.InvertArrowSpinner;
import com.transsion.widgetslib.widget.SearchBar;
import java.lang.ref.WeakReference;
import k3.z8;
import pd.j;
import r2.w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6822b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f6821a = i8;
        this.f6822b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Object obj = this.f6822b;
        switch (this.f6821a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("viewTreeObserver, onGlobalLayout: ");
                d dVar = (d) obj;
                sb2.append(dVar.e);
                z8.b("d", sb2.toString());
                dVar.f();
                return;
            case 1:
                OSLoadingButton oSLoadingButton = (OSLoadingButton) obj;
                oSLoadingButton.f3160a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (oSLoadingButton.f3160a.getLayout() == null || oSLoadingButton.f3160a.getLayout().getEllipsisCount(0) <= 0) {
                    return;
                }
                oSLoadingButton.f3160a.setPaddingRelative(oSLoadingButton.getContext().getResources().getDimensionPixelSize(R$dimen.os_space150) + (oSLoadingButton.getContext().getResources().getDimensionPixelSize(R$dimen.os_space200) * 2), 0, oSLoadingButton.getContext().getResources().getDimensionPixelSize(R$dimen.os_space200), 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) oSLoadingButton.f3161b.getLayoutParams();
                marginLayoutParams.setMarginStart(oSLoadingButton.getContext().getResources().getDimensionPixelSize(R$dimen.os_space200));
                oSLoadingButton.f3161b.setLayoutParams(marginLayoutParams);
                return;
            case 2:
                OSSmartScrollbar oSSmartScrollbar = (OSSmartScrollbar) ((WeakReference) obj).get();
                if (oSSmartScrollbar == null) {
                    return;
                }
                oSSmartScrollbar.getScrollRange();
                oSSmartScrollbar.getScrollOffset();
                oSSmartScrollbar.getScrollExtent();
                throw null;
            case 3:
                InvertArrowSpinner invertArrowSpinner = (InvertArrowSpinner) obj;
                ViewTreeObserver viewTreeObserver = invertArrowSpinner.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
                invertArrowSpinner.postDelayed(new w(this, 6), 150L);
                return;
            default:
                SearchBar searchBar = (SearchBar) obj;
                if (!searchBar.getIsBackMode() || searchBar.E == searchBar.F.getMeasuredWidth()) {
                    return;
                }
                searchBar.E = searchBar.F.getMeasuredWidth();
                searchBar.e = searchBar.F.getMeasuredWidth() - (searchBar.f3432a * 2);
                int backViewStaticWidth = searchBar.getBackViewStaticWidth() - searchBar.f3432a;
                searchBar.f3437i = backViewStaticWidth;
                searchBar.f3436h = searchBar.e - backViewStaticWidth;
                searchBar.e();
                if (searchBar.q.getVisibility() == 0) {
                    if (searchBar.q.getLayoutParams().width != searchBar.f3436h) {
                        ViewGroup.LayoutParams layoutParams = searchBar.q.getLayoutParams();
                        layoutParams.width = searchBar.f3436h;
                        searchBar.q.setLayoutParams(layoutParams);
                    }
                    float f = j.v() ? -searchBar.f3437i : searchBar.f3437i;
                    searchBar.q.setTranslationX(f);
                    searchBar.f3443o.setTranslationX(f);
                }
                if (searchBar.p.getVisibility() == 0 && searchBar.p.getLayoutParams().width != searchBar.e) {
                    ViewGroup.LayoutParams layoutParams2 = searchBar.q.getLayoutParams();
                    layoutParams2.width = searchBar.e;
                    searchBar.p.setLayoutParams(layoutParams2);
                }
                searchBar.c();
                return;
        }
    }

    public a(OSSmartScrollbar oSSmartScrollbar) {
        this.f6821a = 2;
        this.f6822b = new WeakReference(oSSmartScrollbar);
    }
}
