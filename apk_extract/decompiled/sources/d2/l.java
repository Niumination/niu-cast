package d2;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static volatile e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2.a f4285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l2.a f4286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h2.b f4287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i2.i f4288d;

    public l(l2.a aVar, l2.a aVar2, h2.b bVar, i2.i iVar, i2.j jVar) {
        this.f4285a = aVar;
        this.f4286b = aVar2;
        this.f4287c = bVar;
        this.f4288d = iVar;
        jVar.getClass();
        jVar.f5554a.execute(new af.f(jVar, 23));
    }

    public static l a() {
        e eVar = e;
        if (eVar != null) {
            return (l) eVar.e.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (l.class) {
                try {
                    if (e == null) {
                        e8.g gVar = new e8.g();
                        context.getClass();
                        gVar.f4736a = context;
                        e = gVar.b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final qf.c c(b2.a aVar) {
        byte[] bytes;
        Set setUnmodifiableSet = aVar != null ? Collections.unmodifiableSet(b2.a.f1180d) : Collections.singleton(new a2.b("proto"));
        c cVarA = j.a();
        aVar.getClass();
        cVarA.f4266a = "cct";
        String str = aVar.f1181a;
        String str2 = aVar.f1182b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = h0.a.k("1$", str, "\\", str2).getBytes(Charset.forName("UTF-8"));
        }
        cVarA.f4267b = bytes;
        return new qf.c(setUnmodifiableSet, 4, cVarA.a(), this);
    }
}
