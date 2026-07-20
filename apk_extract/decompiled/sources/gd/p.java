package gd;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.flipper.FlipperLayout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f5154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5155c;

    public /* synthetic */ p(View view, Object obj, int i8) {
        this.f5153a = i8;
        this.f5154b = view;
        this.f5155c = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f5153a) {
            case 0:
                TextView textView = (TextView) this.f5154b;
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                OSPageView.b((OSPageView) this.f5155c, textView);
                break;
            case 1:
                Button button = (Button) this.f5154b;
                button.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (button.getLayout() != null && button.getLayout().getEllipsisCount(0) > 0) {
                    button.setTextSize(0, ((ld.j) this.f5155c).f7378a.getResources().getDimensionPixelSize(R$dimen.os_fontsize_h3));
                    break;
                }
                break;
            default:
                FlipperLayout flipperLayout = (FlipperLayout) this.f5154b;
                TextView textView2 = flipperLayout.e;
                Intrinsics.checkNotNull(textView2);
                CharSequence text = textView2.getText();
                TextView textView3 = flipperLayout.e;
                Intrinsics.checkNotNull(textView3);
                textView3.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                List list = (List) this.f5155c;
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
                    float f = flipperLayout.f3067v;
                    float f4 = flipperLayout.u;
                    if (f < f4) {
                        flipperLayout.f3067v = f4;
                    }
                }
                TextView textView7 = flipperLayout.e;
                Intrinsics.checkNotNull(textView7);
                textView7.setText(text);
                LinearLayout linearLayout = flipperLayout.f3053b;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textParent");
                    linearLayout = null;
                }
                linearLayout.getLayoutParams().height = (int) flipperLayout.f3067v;
                break;
        }
    }

    public p(ld.j jVar, Button button) {
        this.f5153a = 1;
        this.f5155c = jVar;
        this.f5154b = button;
    }
}
