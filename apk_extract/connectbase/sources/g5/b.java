package g5;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f6411a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6412a = new b();
    }

    public static b b() {
        return a.f6412a;
    }

    public boolean c(final String str) {
        return (str == null || i6.b.c(this.f6411a, new i6.b.InterfaceC0215b() { // from class: g5.a
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return ((String) obj).equals(str);
            }
        }) == null) ? false : true;
    }

    public b() {
        this.f6411a = Arrays.asList(new String[0]);
    }
}
