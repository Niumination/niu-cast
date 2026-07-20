package e5;

import android.text.TextUtils;
import d5.g;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d5.c<String, String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g<String, String> f4067c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4068a = new b(new d(), new f(), new e());
    }

    public static b e() {
        return a.f4068a;
    }

    @Override // d5.c, d5.g
    public void a() {
        super.a();
        i6.a aVar = i6.a.b.f7724a;
        g<String, String> gVar = this.f4067c;
        Objects.requireNonNull(gVar);
        aVar.b(new d5.b(gVar));
    }

    @Override // d5.c, d5.g
    public void c() {
        super.c();
        i6.a aVar = i6.a.b.f7724a;
        g<String, String> gVar = this.f4067c;
        Objects.requireNonNull(gVar);
        aVar.b(new d5.a(gVar));
    }

    public boolean f(String str) {
        return TextUtils.isEmpty(this.f4067c.d(str));
    }

    public boolean g(String str) {
        return TextUtils.isEmpty(d(str));
    }

    public b(g<String, String> gVar, g<String, String> gVar2, g<String, String> gVar3) {
        super(gVar, gVar2);
        this.f4067c = gVar3;
    }
}
