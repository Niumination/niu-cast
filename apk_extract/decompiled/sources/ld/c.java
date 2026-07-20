package ld;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f7365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f7366b;

    public c(j jVar, DialogInterface.OnClickListener onClickListener) {
        this.f7366b = jVar;
        this.f7365a = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j jVar = this.f7366b;
        CheckedTextView checkedTextView = jVar.f7389n;
        checkedTextView.setChecked(!checkedTextView.isChecked());
        DialogInterface.OnClickListener onClickListener = this.f7365a;
        if (onClickListener != null) {
            onClickListener.onClick(jVar.f7379b, 0);
        }
    }
}
