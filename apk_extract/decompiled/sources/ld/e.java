package ld;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f7369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f7370b;

    public e(j jVar, DialogInterface.OnClickListener onClickListener) {
        this.f7370b = jVar;
        this.f7369a = onClickListener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
        j jVar = this.f7370b;
        DialogInterface.OnClickListener onClickListener = this.f7369a;
        if (onClickListener != null) {
            onClickListener.onClick(jVar.f7379b, i8);
        }
        h hVar = jVar.f7390o;
        if (hVar != null) {
            hVar.setSelectedPst(i8);
        }
        j.a(jVar);
    }
}
