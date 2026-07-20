package ej;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.transsion.widgetslib.R;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(Context context, int i10) {
        b(context, context.getText(i10));
    }

    public static void b(Context context, CharSequence charSequence) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.os_indeterminate_progress_dialog_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.text_message)).setText(charSequence);
        new h.b(context, 0).U(viewInflate).V();
    }
}
