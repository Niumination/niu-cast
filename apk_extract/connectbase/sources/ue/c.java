package ue;

import android.content.Context;
import android.view.View;
import com.transsion.hubsdk.widget.TranToastPresenter;

/* JADX INFO: loaded from: classes2.dex */
public class c implements oh.c {
    @Override // oh.c
    public View a(Context context, CharSequence charSequence) {
        return TranToastPresenter.getTextToastView(context, charSequence);
    }
}
