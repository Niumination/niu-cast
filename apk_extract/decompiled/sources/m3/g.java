package m3;

import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements q4.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ g f7676b = new g(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ g f7677c = new g(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7678a;

    public /* synthetic */ g(int i8) {
        this.f7678a = i8;
    }

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        switch (this.f7678a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                q4.e eVar = (q4.e) obj2;
                Charset charset = h.f;
                eVar.a(h.f7686g, entry.getKey());
                eVar.a(h.f7687h, entry.getValue());
                return;
            default:
                throw new q4.b("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    }
}
