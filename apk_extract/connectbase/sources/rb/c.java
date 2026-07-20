package rb;

import com.transsion.hubsdk.api.view.TranBrightnessInfo;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14373c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.b f14374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.a f14375b;

    public TranBrightnessInfo a() {
        return b(fc.b.a.f5986f).a();
    }

    public lh.a b(String str) {
        if (fc.b.b(str)) {
            re.b bVar = this.f14374a;
            if (bVar != null) {
                return bVar;
            }
            re.b bVar2 = new re.b();
            this.f14374a = bVar2;
            return bVar2;
        }
        b9.a aVar = this.f14375b;
        if (aVar != null) {
            return aVar;
        }
        b9.a aVar2 = new b9.a();
        this.f14375b = aVar2;
        return aVar2;
    }
}
