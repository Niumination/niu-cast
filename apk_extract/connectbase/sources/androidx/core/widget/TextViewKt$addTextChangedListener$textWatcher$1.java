package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import jn.l;
import jn.r;
import kn.r1;
import lm.l2;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ l<Editable, l2> $afterTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, l2> $beforeTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, l2> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(l<? super Editable, l2> lVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar2) {
        this.$afterTextChanged = lVar;
        this.$beforeTextChanged = rVar;
        this.$onTextChanged = rVar2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@m Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }
}
