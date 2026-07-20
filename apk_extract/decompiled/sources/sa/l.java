package sa;

import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.transsion.iotservice.multiscreen.pc.adapter.TrustDevicesAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.TrustDeviceBean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9598c;

    public /* synthetic */ l(int i8, Object obj, Object obj2) {
        this.f9596a = i8;
        this.f9597b = obj;
        this.f9598c = obj2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Object obj = this.f9597b;
        Object obj2 = this.f9598c;
        switch (this.f9596a) {
            case 0:
                int i8 = TrustDevicesAdapter.TrustDeviceViewHolder.f2398b;
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.setAlpha(0.2f);
                } else if (action == 1) {
                    view.setAlpha(1.0f);
                    ((bc.d) obj).a((TrustDeviceBean) obj2);
                } else if (action == 3) {
                    view.setAlpha(1.0f);
                }
                return true;
            default:
                int action2 = motionEvent.getAction();
                va.c cVar = (va.c) obj2;
                TextView textView = (TextView) obj;
                if (action2 == 0) {
                    Intrinsics.checkNotNull(motionEvent);
                    int x2 = (int) motionEvent.getX();
                    int scrollY = textView.getScrollY() + ((int) motionEvent.getY());
                    Layout layout = textView.getLayout();
                    if (layout != null) {
                        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), x2);
                        String string = textView.getText().toString();
                        String str = cVar.f10532a;
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, str, 0, false, 6, (Object) null);
                        int length = str.length() + iIndexOf$default;
                        if (iIndexOf$default > -1 && offsetForHorizontal >= iIndexOf$default && offsetForHorizontal <= length) {
                            cVar.f10535d = true;
                        }
                    }
                } else if (action2 == 1 || action2 == 3) {
                    textView.performClick();
                    cVar.f10535d = false;
                }
                textView.invalidate();
                return false;
        }
    }
}
