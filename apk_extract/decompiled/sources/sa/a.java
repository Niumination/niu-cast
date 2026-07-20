package sa;

import android.view.View;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import k3.rd;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimView f9576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VapResource f9577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f9578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Boolean f9579d;
    public final /* synthetic */ c e;

    public a(AnimView animView, VapResource vapResource, boolean z2, Boolean bool, c cVar) {
        this.f9576a = animView;
        this.f9577b = vapResource;
        this.f9578c = z2;
        this.f9579d = bool;
        this.e = cVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        view.removeOnLayoutChangeListener(this);
        boolean z2 = this.f9578c;
        Boolean bool = this.f9579d;
        AnimView animView = this.f9576a;
        rd.a(animView, this.f9577b, bool, z2);
        animView.postDelayed(this.e, 300L);
    }
}
