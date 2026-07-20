package qe;

import com.transsion.hubsdk.util.TranMemInfoReader;

/* JADX INFO: loaded from: classes2.dex */
public class d implements kh.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13990b = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranMemInfoReader f13991a = new TranMemInfoReader();

    @Override // kh.d
    public void a() {
        try {
            TranMemInfoReader tranMemInfoReader = this.f13991a;
            if (tranMemInfoReader != null) {
                tranMemInfoReader.readMemInfo();
            }
        } catch (Exception e10) {
            p6.b.a("readMemInfo:", e10, f13990b);
        }
    }

    @Override // kh.d
    public long b() {
        try {
            TranMemInfoReader tranMemInfoReader = this.f13991a;
            if (tranMemInfoReader != null) {
                return tranMemInfoReader.getFreeSize();
            }
            return 0L;
        } catch (Exception e10) {
            p6.b.a("getFreeSize:", e10, f13990b);
            return 0L;
        }
    }

    @Override // kh.d
    public long c() {
        try {
            TranMemInfoReader tranMemInfoReader = this.f13991a;
            if (tranMemInfoReader != null) {
                return tranMemInfoReader.getCachedSize();
            }
            return 0L;
        } catch (Exception e10) {
            p6.b.a("getCachedSize:", e10, f13990b);
            return 0L;
        }
    }
}
