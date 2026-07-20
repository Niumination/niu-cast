package se;

import android.os.ParcelUuid;
import java.util.UUID;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10085a = ((UByte.m177constructorimpl((byte) 9) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl((byte) 66) & UByte.MAX_VALUE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10086b = ((UByte.m177constructorimpl((byte) 253) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl((byte) 53) & UByte.MAX_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ParcelUuid f10087c = ParcelUuid.fromString("0000FD35-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UUID f10088d;
    public static final UUID e;
    public static final UUID f;

    static {
        UUID.fromString("00000001-0000-1000-8000-00805F9B34FB");
        f10088d = UUID.fromString("00000002-0000-1000-8000-00805F9B34FB");
        e = UUID.fromString("00000003-0000-1000-8000-00805F9B34FB");
        f = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }
}
