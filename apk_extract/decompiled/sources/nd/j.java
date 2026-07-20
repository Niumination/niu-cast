package nd;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.transsion.widgetslib.flipper.FlipperLayout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlipperLayout f8180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f8181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f8182c;

    public j(FlipperLayout flipperLayout, List list, List list2) {
        this.f8180a = flipperLayout;
        this.f8181b = list;
        this.f8182c = list2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        FlipperLayout flipperLayout = this.f8180a;
        TextView textView = flipperLayout.e;
        Intrinsics.checkNotNull(textView);
        textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        TextView textView2 = flipperLayout.e;
        Intrinsics.checkNotNull(textView2);
        CharSequence text = textView2.getText();
        TextView textView3 = flipperLayout.f3055d;
        Intrinsics.checkNotNull(textView3);
        CharSequence text2 = textView3.getText();
        List list = this.f8181b;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            TextView textView4 = flipperLayout.e;
            Intrinsics.checkNotNull(textView4);
            textView4.setText((CharSequence) list.get(i8));
            TextView textView5 = flipperLayout.e;
            Intrinsics.checkNotNull(textView5);
            textView5.measure(View.MeasureSpec.makeMeasureSpec(flipperLayout.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, 0));
            TextView textView6 = flipperLayout.e;
            Intrinsics.checkNotNull(textView6);
            flipperLayout.u = textView6.getMeasuredHeight();
            TextView textView7 = flipperLayout.f3055d;
            Intrinsics.checkNotNull(textView7);
            textView7.setText((CharSequence) this.f8182c.get(i8));
            TextView textView8 = flipperLayout.f3055d;
            Intrinsics.checkNotNull(textView8);
            textView8.measure(View.MeasureSpec.makeMeasureSpec(flipperLayout.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, 0));
            TextView textView9 = flipperLayout.f3055d;
            Intrinsics.checkNotNull(textView9);
            flipperLayout.f3066t = textView9.getMeasuredHeight();
            float f = flipperLayout.f3067v;
            float f4 = flipperLayout.f3066t;
            float f10 = flipperLayout.u;
            if (f < f4 + f10) {
                flipperLayout.f3067v = f4 + f10;
            }
        }
        TextView textView10 = flipperLayout.e;
        Intrinsics.checkNotNull(textView10);
        textView10.setText(text);
        TextView textView11 = flipperLayout.f3055d;
        Intrinsics.checkNotNull(textView11);
        textView11.setText(text2);
        LinearLayout linearLayout = flipperLayout.f3053b;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textParent");
            linearLayout = null;
        }
        linearLayout.getLayoutParams().height = (int) flipperLayout.f3067v;
    }
}
