package sa;

import android.content.Context;
import android.nfc.NfcAdapter;
import dc.e;
import qd.k;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15032c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f15033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b8.a f15034b;

    public int a(NfcAdapter nfcAdapter) {
        if (nfcAdapter != null) {
            return c(fc.b.a.f6001u).b(nfcAdapter);
        }
        throw new IllegalArgumentException("nfcAdapter is null");
    }

    public NfcAdapter b(Context context) {
        if (context != null) {
            return c(fc.b.a.f6001u).a(context);
        }
        throw new IllegalArgumentException("context is null");
    }

    public mg.a c(String str) {
        if (fc.b.b(str)) {
            e.f(f15032c, "TranThubNfcAdapter");
            k kVar = this.f15033a;
            if (kVar != null) {
                return kVar;
            }
            k kVar2 = new k();
            this.f15033a = kVar2;
            return kVar2;
        }
        e.f(f15032c, "TranAospNfcAdapter");
        b8.a aVar = this.f15034b;
        if (aVar != null) {
            return aVar;
        }
        b8.a aVar2 = new b8.a();
        this.f15034b = aVar2;
        return aVar2;
    }
}
