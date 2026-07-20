package hg;

import com.transsion.iotcardsdk.bean.DeviceType;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum v {
    DecryptionFailed_RESERVED(21),
    CloseNotify(0),
    UnexpectedMessage(10),
    BadRecordMac(20),
    RecordOverflow(22),
    DecompressionFailure(30),
    HandshakeFailure(40),
    NoCertificate_RESERVED(41),
    BadCertificate(42),
    UnsupportedCertificate(43),
    CertificateRevoked(44),
    CertificateExpired(45),
    CertificateUnknown(46),
    IllegalParameter(47),
    UnknownCa(48),
    AccessDenied(49),
    DecodeError(50),
    DecryptError(51),
    ExportRestriction_RESERVED(60),
    ProtocolVersion(70),
    InsufficientSecurity(71),
    InternalError(80),
    UserCanceled(90),
    NoRenegotiation(100),
    UnsupportedExtension(DeviceType.INFRARED_LIGHT);

    private static final v[] byCode;
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final u Companion = new u();

    static {
        v next;
        v[] vVarArr = new v[256];
        for (int i8 = 0; i8 < 256; i8++) {
            Iterator<v> it = getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.code != i8);
            vVarArr[i8] = next;
        }
        byCode = vVarArr;
    }

    v(int i8) {
        this.code = i8;
    }

    public static EnumEntries<v> getEntries() {
        return $ENTRIES;
    }

    public final int getCode() {
        return this.code;
    }
}
