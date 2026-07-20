package a;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static boolean a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
