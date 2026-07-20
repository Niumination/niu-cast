package i9;

import android.os.Bundle;
import dc.e;
import e8.m;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import jc.c;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7751c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f7752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q6.b f7753b;

    public interface a {
        void a(Bundle bundle);
    }

    public static /* synthetic */ void h(a aVar, Bundle bundle) {
        if (aVar != null) {
            aVar.a(bundle);
        }
    }

    @yb.a(level = 1)
    public void b(String str, String str2, int i10, int i11) {
        f(fc.b.a.f5982b).f(str, str2, i10, i11);
    }

    public void c(String str, String str2, int i10, int i11, final a aVar) {
        f(fc.b.a.f5989i).e(str, str2, i10, i11, new m.a() { // from class: i9.a
            @Override // e8.m.a
            public final void a(Bundle bundle) {
                b.h(aVar, bundle);
            }
        });
    }

    public boolean d(String str, String str2) {
        return f(fc.b.a.f5986f).c(str, str2);
    }

    public List<String> e(String str) {
        return f(fc.b.a.f5989i).a(str);
    }

    public cf.a f(String str) {
        if (fc.b.b(str)) {
            e.f(f7751c, "TranThubRoleManager");
            c cVar = this.f7752a;
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            this.f7752a = cVar2;
            return cVar2;
        }
        e.f(f7751c, "TranAospRoleManager");
        q6.b bVar = this.f7753b;
        if (bVar != null) {
            return bVar;
        }
        q6.b bVar2 = new q6.b();
        this.f7753b = bVar2;
        return bVar2;
    }

    public void g(String str, String str2, Executor executor, Consumer<Boolean> consumer) {
        f(fc.b.a.f5989i).d(str, str2, executor, consumer);
    }

    public boolean i(String str, String str2) {
        return f(fc.b.a.f5986f).b(str, str2);
    }
}
