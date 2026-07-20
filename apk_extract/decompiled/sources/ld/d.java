package ld;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f7367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f7368b;

    public d(j jVar, DialogInterface.OnClickListener onClickListener) {
        this.f7368b = jVar;
        this.f7367a = onClickListener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
        DialogInterface.OnClickListener onClickListener = this.f7367a;
        if (onClickListener != null) {
            j jVar = this.f7368b;
            onClickListener.onClick(jVar.f7379b, i8);
            jVar.f7379b.dismiss();
        }
    }
}
