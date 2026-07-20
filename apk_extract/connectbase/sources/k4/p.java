package k4;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f8971a = new p();
    }

    public p() {
    }

    public static p a() {
        return a.f8971a;
    }

    public String b(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str2, str3);
    }

    public void c(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }

    public p(q qVar) {
    }
}
