package e2;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u6.c f4669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f4671c;

    public f(Context context, e eVar) {
        u6.c cVar = new u6.c(context, 1);
        this.f4671c = new HashMap();
        this.f4669a = cVar;
        this.f4670b = eVar;
    }

    public final synchronized g a(String str) {
        if (this.f4671c.containsKey(str)) {
            return (g) this.f4671c.get(str);
        }
        CctBackendFactory cctBackendFactoryU = this.f4669a.u(str);
        if (cctBackendFactoryU == null) {
            return null;
        }
        e eVar = this.f4670b;
        g gVarCreate = cctBackendFactoryU.create(new b(eVar.f4666a, eVar.f4667b, eVar.f4668c, str));
        this.f4671c.put(str, gVarCreate);
        return gVarCreate;
    }
}
