package o1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f8358d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8361c;

    public a(Drawable.Callback callback, String str, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f8360b = str;
        } else {
            this.f8360b = str.concat("/");
        }
        this.f8361c = map;
        if (callback instanceof View) {
            this.f8359a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.f8359a = null;
        }
    }
}
