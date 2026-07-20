package zd;

import android.view.View;
import com.transsion.widgetslib.widget.FootOperationBar;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11280a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FootOperationBar f11281b;

    public c(FootOperationBar footOperationBar) {
        this.f11281b = footOperationBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FootOperationBar footOperationBar = this.f11281b;
        switch (this.f11280a) {
            case 0:
                footOperationBar.f3372d.setSelected(true);
                footOperationBar.f3371c.show();
                footOperationBar.getClass();
                break;
            default:
                int i8 = FootOperationBar.H;
                footOperationBar.getClass();
                break;
        }
    }

    public c(FootOperationBar footOperationBar, int i8) {
        this.f11281b = footOperationBar;
    }
}
