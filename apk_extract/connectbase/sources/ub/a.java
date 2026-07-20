package ub;

import android.widget.EditText;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16244c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ue.a f16245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e9.a f16246b;

    public oh.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f16244c, "TranThubEditText");
            ue.a aVar = this.f16245a;
            if (aVar != null) {
                return aVar;
            }
            ue.a aVar2 = new ue.a();
            this.f16245a = aVar2;
            return aVar2;
        }
        e.f(f16244c, "TranThubEditText");
        e9.a aVar3 = this.f16246b;
        if (aVar3 != null) {
            return aVar3;
        }
        e9.a aVar4 = new e9.a();
        this.f16246b = aVar4;
        return aVar4;
    }

    public void b(EditText editText, boolean z10) {
        if (editText == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        a(fc.b.a.f5987g).a(editText, z10);
    }
}
