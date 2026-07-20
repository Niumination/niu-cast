package f5;

import android.text.TextUtils;
import d5.g;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d5.c<String, String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5846a = new b(new d(), new e());
    }

    public b(g<String, String> gVar, g<String, String> gVar2) {
        super(gVar, gVar2);
    }

    public static b e() {
        return a.f5846a;
    }

    public boolean f(String str) {
        return !TextUtils.isEmpty(d(str));
    }

    public b(g gVar, g gVar2, c cVar) {
        super(gVar, gVar2);
    }
}
