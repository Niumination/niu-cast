package hg;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum s0 {
    HelloRequest(0),
    ClientHello(1),
    ServerHello(2),
    Certificate(11),
    ServerKeyExchange(12),
    CertificateRequest(13),
    ServerDone(14),
    CertificateVerify(15),
    ClientKeyExchange(16),
    Finished(20);

    private static final s0[] byCode;
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final r0 Companion = new r0();

    static {
        s0 next;
        s0[] s0VarArr = new s0[256];
        for (int i8 = 0; i8 < 256; i8++) {
            Iterator<s0> it = getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.code != i8);
            s0VarArr[i8] = next;
        }
        byCode = s0VarArr;
    }

    s0(int i8) {
        this.code = i8;
    }

    public static EnumEntries<s0> getEntries() {
        return $ENTRIES;
    }

    public final int getCode() {
        return this.code;
    }
}
