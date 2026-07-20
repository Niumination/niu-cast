package ji;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Short, ji.a<Object>> f8710a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f8711a = new d();
    }

    public static /* synthetic */ ji.a a(ji.a aVar) {
        return aVar;
    }

    public static d c() {
        return a.f8711a;
    }

    public static /* synthetic */ ji.a d(ji.a aVar) {
        return aVar;
    }

    public void b(Short sh2, Object obj) {
        ji.a<Object> aVar = this.f8710a.get(sh2);
        if (aVar != null) {
            aVar.b(obj);
        }
    }

    public void e(List<ji.a<Object>> list) {
        this.f8710a = (Map) new ArrayList(list).stream().collect(Collectors.toMap(new b(), new c()));
    }
}
