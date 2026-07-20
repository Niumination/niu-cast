package k3;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public abstract class kc {
    public static boolean a(Context context, CharSequence charSequence, float f, float f4, int i8, int i9) {
        String str;
        if (i9 <= 0 || context == null) {
            return false;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        textPaint.setLetterSpacing(f4);
        if (charSequence != null) {
            str = ((Object) charSequence) + "a";
        } else {
            str = null;
        }
        return new StaticLayout(str, textPaint, i9, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= i8;
    }

    public static boolean b(Context context, CharSequence charSequence, float f, float f4, int i8) {
        StringBuilder sb2 = new StringBuilder();
        int i9 = 2;
        while (i9 > 0) {
            sb2.append('a');
            i9--;
        }
        if (i9 < 0) {
            int i10 = -i9;
            charSequence = charSequence.toString().substring(0, charSequence.length() > i10 ? charSequence.length() - i10 : 1);
        }
        if (sb2.length() > 0) {
            charSequence = ((Object) charSequence) + sb2.toString();
        }
        return a(context, charSequence, f, f4, 1, i8);
    }
}
