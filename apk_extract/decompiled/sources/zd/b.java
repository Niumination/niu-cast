package zd;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.widget.FootOperationBar;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ViewStub.OnInflateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FootOperationBar f11278a;

    public b(FootOperationBar footOperationBar) {
        this.f11278a = footOperationBar;
    }

    @Override // android.view.ViewStub.OnInflateListener
    public final void onInflate(ViewStub viewStub, View view) {
        int i8 = view.getLayoutParams().height;
        LinearLayout linearLayout = (LinearLayout) this.f11278a.findViewById(R$id.fob_root);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height += i8;
        int i9 = FootOperationBar.H;
        Log.d("FootOperationBar", "onInflate: params.height = " + layoutParams.height + " ,immersiveHeight = " + i8);
        linearLayout.setLayoutParams(layoutParams);
    }
}
