package ud;

import com.transsion.hubsdk.oemunlockdata.TranOemUnlockDataManager;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements og.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16254b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranOemUnlockDataManager f16255a = new TranOemUnlockDataManager();

    @Override // og.a
    public String a() {
        TranOemUnlockDataManager tranOemUnlockDataManager = this.f16255a;
        if (tranOemUnlockDataManager == null) {
            return null;
        }
        try {
            return tranOemUnlockDataManager.getCpuId();
        } catch (RuntimeException e10) {
            e.c(f16254b, "getCpuId e=" + e10);
            return null;
        }
    }

    @Override // og.a
    public int b(int i10, byte[] bArr) {
        TranOemUnlockDataManager tranOemUnlockDataManager = this.f16255a;
        if (tranOemUnlockDataManager == null) {
            return 0;
        }
        try {
            return tranOemUnlockDataManager.writeOemUnlockData(i10, bArr);
        } catch (RuntimeException e10) {
            e.c(f16254b, "writeOemUnlockData e=" + e10);
            return 0;
        }
    }
}
