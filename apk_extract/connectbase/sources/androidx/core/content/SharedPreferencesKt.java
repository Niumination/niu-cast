package androidx.core.content;

import android.content.SharedPreferences;
import k4.f;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesKt {
    @b.a({"ApplySharedPref"})
    public static final void edit(@l SharedPreferences sharedPreferences, boolean z10, @l jn.l<? super SharedPreferences.Editor, l2> lVar) {
        l0.p(sharedPreferences, "<this>");
        l0.p(lVar, f.f8937e);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        l0.o(editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z10) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z10, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        l0.p(sharedPreferences, "<this>");
        l0.p(lVar, f.f8937e);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        l0.o(editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z10) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
