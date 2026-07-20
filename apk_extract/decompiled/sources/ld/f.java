package ld;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnMultiChoiceClickListener f7371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f7372b;

    public f(j jVar, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.f7372b = jVar;
        this.f7371a = onMultiChoiceClickListener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
        h hVar;
        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = this.f7371a;
        if (onMultiChoiceClickListener != null) {
            j jVar = this.f7372b;
            if (jVar.f7387l == null || (hVar = jVar.f7390o) == null) {
                return;
            }
            if (jVar.q != null) {
                hVar.setSelectedPst(i8);
            }
            j.a(jVar);
            m mVar = jVar.f7379b;
            h hVar2 = jVar.f7390o;
            WeakReference weakReference = hVar2.f7374c;
            boolean z2 = false;
            if (weakReference != null && weakReference.get() != null && ((j) hVar2.f7374c.get()).q != null) {
                boolean[] zArr = ((j) hVar2.f7374c.get()).q;
                if (i8 >= 0 && i8 < zArr.length && zArr[i8]) {
                    z2 = true;
                }
            }
            onMultiChoiceClickListener.onClick(mVar, i8, z2);
        }
    }
}
