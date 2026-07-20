package k3;

import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y0 implements q4.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ y0 f6717b = new y0(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ y0 f6718c = new y0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6719a;

    public /* synthetic */ y0(int i8) {
        this.f6719a = i8;
    }

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        switch (this.f6719a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                q4.e eVar = (q4.e) obj2;
                Charset charset = z0.f;
                eVar.a(z0.f6732g, entry.getKey());
                eVar.a(z0.f6733h, entry.getValue());
                return;
            default:
                throw new q4.b("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    }
}
