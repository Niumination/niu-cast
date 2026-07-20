package ld;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$id;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f7360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f7362c;

    public a(j jVar, ViewGroup viewGroup, boolean z2) {
        this.f7362c = jVar;
        this.f7360a = viewGroup;
        this.f7361b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f7362c;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) jVar.f7386k.getLayoutParams();
        layoutParams.bottomToBottom = 0;
        jVar.f7386k.setLayoutParams(layoutParams);
        ViewGroup viewGroup = this.f7360a;
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) viewGroup.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
        layoutParams2.matchConstraintDefaultHeight = 1;
        if (this.f7361b) {
            layoutParams2.topToBottom = R$id.os_module_dialog_damping_layout_title;
        } else {
            layoutParams2.topToTop = 0;
        }
        layoutParams2.bottomToTop = R$id.os_module_dialog_custom_view;
        layoutParams2.verticalBias = 0.0f;
        viewGroup.setLayoutParams(layoutParams2);
    }
}
