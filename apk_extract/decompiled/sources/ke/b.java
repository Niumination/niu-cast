package ke;

import android.widget.RelativeLayout;
import com.transsion.widgetslistitemlayout.OSListItemView;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f6846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OSListItemView f6849d;

    public b(OSListItemView oSListItemView, RelativeLayout.LayoutParams layoutParams, int i8, int i9) {
        this.f6849d = oSListItemView;
        this.f6846a = layoutParams;
        this.f6847b = i8;
        this.f6848c = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OSListItemView oSListItemView = this.f6849d;
        int id2 = oSListItemView.O.getId();
        RelativeLayout.LayoutParams layoutParams = this.f6846a;
        layoutParams.addRule(19, id2);
        layoutParams.addRule(6, oSListItemView.O.getId());
        int height = ((oSListItemView.getHeight() - oSListItemView.O.getHeight()) / 2) - this.f6847b;
        int i8 = this.f6848c;
        layoutParams.setMargins(-i8, height, -i8, 0);
        oSListItemView.M.setLayoutParams(layoutParams);
    }
}
