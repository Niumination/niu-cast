package b4;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.search.SearchView;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1202a;

    public /* synthetic */ e(int i8) {
        this.f1202a = i8;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f1202a) {
            case 0:
                return SearchView.lambda$setUpRootView$0(view, motionEvent);
            case 1:
                int i8 = OSBaseBottomSheetDialog.f2985i;
                return true;
            default:
                return false;
        }
    }
}
