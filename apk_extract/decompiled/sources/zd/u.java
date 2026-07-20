package zd;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetslib.widget.SearchBar;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchBar f11310b;

    public /* synthetic */ u(SearchBar searchBar, int i8) {
        this.f11309a = i8;
        this.f11310b = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SearchBar searchBar = this.f11310b;
        switch (this.f11309a) {
            case 0:
                if (!searchBar.f3440l) {
                    searchBar.p.setVisibility(8);
                    searchBar.q.setVisibility(0);
                    searchBar.q.setHint(searchBar.C);
                    searchBar.e();
                    boolean z2 = searchBar.getLayoutDirection() == 1;
                    int backViewStaticWidth = searchBar.getBackViewStaticWidth();
                    if (!z2) {
                        backViewStaticWidth = -backViewStaticWidth;
                    }
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(searchBar.f3442n, "translationX", backViewStaticWidth, 0.0f);
                    ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(searchBar.f3451z, "width", searchBar.e, (int) (searchBar.f() * searchBar.f3436h));
                    float f = z2 ? -searchBar.f3437i : searchBar.f3437i;
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(searchBar.p, "translationX", 0.0f, f);
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(searchBar.q, "translationX", 0.0f, f);
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(searchBar.f3443o, "translationX", 0.0f, f);
                    ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(searchBar.f3442n, "alpha", 0.0f, 1.0f);
                    objectAnimatorOfFloat5.setStartDelay(150L);
                    objectAnimatorOfFloat5.setDuration(250L);
                    PathInterpolator pathInterpolator = z.f11316a;
                    objectAnimatorOfFloat5.setInterpolator(pathInterpolator);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(400L);
                    animatorSet.setInterpolator(pathInterpolator);
                    animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat3);
                    OSIconTextView oSIconTextView = searchBar.f3442n;
                    TextView textView = searchBar.p;
                    AutoCompleteTextView autoCompleteTextView = searchBar.q;
                    w wVar = new w(0);
                    wVar.f11313b = new WeakReference(oSIconTextView);
                    wVar.f11314c = new WeakReference(textView);
                    wVar.f11315d = new WeakReference(autoCompleteTextView);
                    animatorSet.addListener(wVar);
                    animatorSet.start();
                    AutoCompleteTextView autoCompleteTextView2 = searchBar.q;
                    if (autoCompleteTextView2 != null) {
                        autoCompleteTextView2.requestFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) searchBar.getContext().getSystemService(InputMethodManager.class);
                        if (inputMethodManager != null) {
                            inputMethodManager.showSoftInput(searchBar.q, 0);
                        }
                    }
                    searchBar.c();
                    searchBar.d();
                } else {
                    View.OnClickListener onClickListener = searchBar.f3449x;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
                break;
            case 1:
                AutoCompleteTextView autoCompleteTextView3 = searchBar.q;
                if (autoCompleteTextView3 != null) {
                    autoCompleteTextView3.requestFocus();
                }
                break;
            case 2:
                if (!TextUtils.isEmpty(searchBar.q.getText()) || searchBar.q.length() > 0) {
                    searchBar.q.setText((CharSequence) null);
                }
                break;
            case 3:
                searchBar.getClass();
                break;
            case 4:
                View.OnClickListener onClickListener2 = searchBar.f3450y;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                break;
            default:
                searchBar.c();
                searchBar.d();
                searchBar.q.setText((CharSequence) null);
                searchBar.f3442n.setClickable(false);
                boolean z3 = searchBar.getLayoutDirection() == 1;
                int backViewStaticWidth2 = searchBar.getBackViewStaticWidth();
                if (!z3) {
                    backViewStaticWidth2 = -backViewStaticWidth2;
                }
                ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(searchBar.f3442n, "translationX", 0.0f, backViewStaticWidth2);
                objectAnimatorOfFloat6.setDuration(350L);
                ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(searchBar.f3451z, "width", (int) (searchBar.f3436h * searchBar.f()), searchBar.e);
                objectAnimatorOfInt2.setDuration(350L);
                float f4 = z3 ? -searchBar.f3437i : searchBar.f3437i;
                ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(searchBar.p, "translationX", f4, 0.0f);
                objectAnimatorOfFloat7.setDuration(350L);
                ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(searchBar.f3443o, "translationX", f4, 0.0f);
                objectAnimatorOfFloat8.setDuration(350L);
                ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(searchBar.q, "translationX", f4, 0.0f);
                objectAnimatorOfFloat9.setDuration(350L);
                ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(searchBar.f3442n, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat10.setDuration(100L);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setInterpolator(z.f11317b);
                animatorSet2.playTogether(objectAnimatorOfFloat6, objectAnimatorOfInt2, objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat10, objectAnimatorOfFloat9);
                OSIconTextView oSIconTextView2 = searchBar.f3442n;
                TextView textView2 = searchBar.p;
                AutoCompleteTextView autoCompleteTextView4 = searchBar.q;
                w wVar2 = new w(1);
                wVar2.f11313b = new WeakReference(oSIconTextView2);
                wVar2.f11314c = new WeakReference(textView2);
                wVar2.f11315d = new WeakReference(autoCompleteTextView4);
                animatorSet2.addListener(wVar2);
                animatorSet2.start();
                break;
        }
    }
}
