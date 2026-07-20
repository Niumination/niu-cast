package h5;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d5.e<g, String> {
    public b() {
        this.f3535b = "secure_list.json";
        this.f3536c = new h();
    }

    public static /* synthetic */ boolean h(String str, g gVar) {
        return gVar.b().equals(str);
    }

    @Override // d5.e, d5.g
    @Nullable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public g d(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (g) i6.b.c(this.f3534a, new i6.b.InterfaceC0215b() { // from class: h5.a
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return b.h(str, (g) obj);
            }
        });
    }
}
