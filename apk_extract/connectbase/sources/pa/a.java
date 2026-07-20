package pa;

import android.content.Intent;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pd.a f13068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y7.a f13069b;

    public Intent a(int i10, String str, int i11, boolean z10) {
        return b(b.a.f5985e).a(i10, str, i11, z10);
    }

    public jg.a b(String str) {
        if (b.b(str)) {
            pd.a aVar = this.f13068a;
            if (aVar != null) {
                return aVar;
            }
            pd.a aVar2 = new pd.a();
            this.f13068a = aVar2;
            return aVar2;
        }
        y7.a aVar3 = this.f13069b;
        if (aVar3 != null) {
            return aVar3;
        }
        y7.a aVar4 = new y7.a();
        this.f13069b = aVar4;
        return aVar4;
    }
}
