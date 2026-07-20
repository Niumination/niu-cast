package com.transsion.widgetslib.widget.editext;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedEditText extends EditText implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f3478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnFocusChangeListener f3479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnFocusChangeListener f3480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3481d;

    public ExtendedEditText(Context context) {
        super(context);
        this.f3478a = null;
        this.f3479b = null;
        this.f3480c = null;
    }

    @Override // android.widget.TextView
    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (this.f3478a == null) {
            this.f3478a = new ArrayList();
        }
        this.f3478a.add(textWatcher);
        super.addTextChangedListener(textWatcher);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        View.OnFocusChangeListener onFocusChangeListener = this.f3480c;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z2);
        }
        View.OnFocusChangeListener onFocusChangeListener2 = this.f3479b;
        if (onFocusChangeListener2 != null) {
            onFocusChangeListener2.onFocusChange(view, z2);
        }
    }

    @Override // android.widget.TextView
    public final void removeTextChangedListener(TextWatcher textWatcher) {
        int iIndexOf;
        ArrayList arrayList = this.f3478a;
        if (arrayList != null && (iIndexOf = arrayList.indexOf(textWatcher)) >= 0) {
            this.f3478a.remove(iIndexOf);
        }
        super.removeTextChangedListener(textWatcher);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        boolean z2 = this.f3481d;
        if (!z2 && onFocusChangeListener != null) {
            this.f3481d = true;
            super.setOnFocusChangeListener(this);
        } else if (onFocusChangeListener == null && this.f3480c == null && z2) {
            this.f3481d = false;
            super.setOnFocusChangeListener(null);
        }
        this.f3479b = onFocusChangeListener;
    }

    public void setSelfOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        boolean z2 = this.f3481d;
        if (!z2 && onFocusChangeListener != null) {
            this.f3481d = true;
            super.setOnFocusChangeListener(this);
        } else if (onFocusChangeListener == null && this.f3480c == null && z2) {
            this.f3481d = false;
            super.setOnFocusChangeListener(null);
        }
        this.f3480c = onFocusChangeListener;
    }

    public ExtendedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3478a = null;
        this.f3479b = null;
        this.f3480c = null;
    }

    public ExtendedEditText(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3478a = null;
        this.f3479b = null;
        this.f3480c = null;
    }
}
