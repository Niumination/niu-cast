package h5;

import android.text.TextUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d5.c<g, String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6974c = "*";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6975a = new e(new b(), new c());
    }

    public e(d5.g<g, String> gVar, d5.g<g, String> gVar2) {
        super(gVar, gVar2);
    }

    public static e e() {
        return a.f6975a;
    }

    public boolean f(String str, final String str2) {
        g gVarD;
        List<String> listA;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (gVarD = d(str)) == null || (listA = gVarD.a()) == null || listA.isEmpty()) {
            return false;
        }
        Objects.requireNonNull(str2);
        if (i6.b.c(listA, new i6.b.InterfaceC0215b() { // from class: h5.d
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return str2.equals((String) obj);
            }
        }) == null) {
            final String str3 = "*";
            if (i6.b.c(listA, new i6.b.InterfaceC0215b() { // from class: h5.d
                @Override // i6.b.InterfaceC0215b
                public final boolean a(Object obj) {
                    return str3.equals((String) obj);
                }
            }) == null) {
                return false;
            }
        }
        return true;
    }

    public e(d5.g gVar, d5.g gVar2, f fVar) {
        super(gVar, gVar2);
    }
}
