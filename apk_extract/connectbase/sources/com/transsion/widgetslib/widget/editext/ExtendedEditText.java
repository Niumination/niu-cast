package com.transsion.widgetslib.widget.editext;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedEditText extends EditText implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<TextWatcher> f2823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnFocusChangeListener f2824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnFocusChangeListener f2825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2826d;

    public ExtendedEditText(Context context) {
        super(context);
        this.f2823a = null;
        this.f2824b = null;
        this.f2825c = null;
    }

    public void a() {
        ArrayList<TextWatcher> arrayList = this.f2823a;
        if (arrayList != null) {
            Iterator<TextWatcher> it = arrayList.iterator();
            while (it.hasNext()) {
                super.removeTextChangedListener(it.next());
            }
            this.f2823a.clear();
            this.f2823a = null;
        }
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.f2823a == null) {
            this.f2823a = new ArrayList<>();
        }
        this.f2823a.add(textWatcher);
        super.addTextChangedListener(textWatcher);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        View.OnFocusChangeListener onFocusChangeListener = this.f2825c;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z10);
        }
        View.OnFocusChangeListener onFocusChangeListener2 = this.f2824b;
        if (onFocusChangeListener2 != null) {
            onFocusChangeListener2.onFocusChange(view, z10);
        }
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        int iIndexOf;
        ArrayList<TextWatcher> arrayList = this.f2823a;
        if (arrayList != null && (iIndexOf = arrayList.indexOf(textWatcher)) >= 0) {
            this.f2823a.remove(iIndexOf);
        }
        super.removeTextChangedListener(textWatcher);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        boolean z10 = this.f2826d;
        if (!z10 && onFocusChangeListener != null) {
            this.f2826d = true;
            super.setOnFocusChangeListener(this);
        } else if (onFocusChangeListener == null && this.f2825c == null && z10) {
            this.f2826d = false;
            super.setOnFocusChangeListener(null);
        }
        this.f2824b = onFocusChangeListener;
    }

    public void setSelfOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        boolean z10 = this.f2826d;
        if (!z10 && onFocusChangeListener != null) {
            this.f2826d = true;
            super.setOnFocusChangeListener(this);
        } else if (onFocusChangeListener == null && this.f2825c == null && z10) {
            this.f2826d = false;
            super.setOnFocusChangeListener(null);
        }
        this.f2825c = onFocusChangeListener;
    }

    public ExtendedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2823a = null;
        this.f2824b = null;
        this.f2825c = null;
    }

    public ExtendedEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2823a = null;
        this.f2824b = null;
        this.f2825c = null;
    }
}
