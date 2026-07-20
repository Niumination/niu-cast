package qe;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f9028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f9030c;

    public i(byte b9, boolean z2, byte[] sendArray) {
        Intrinsics.checkNotNullParameter(sendArray, "sendArray");
        this.f9028a = b9;
        this.f9029b = z2;
        this.f9030c = sendArray;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f9028a == iVar.f9028a && this.f9029b == iVar.f9029b && Intrinsics.areEqual(this.f9030c, iVar.f9030c);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9030c) + a1.a.g(false, a1.a.g(this.f9029b, Byte.hashCode(this.f9028a) * 31, 31), 31);
    }

    public final String toString() {
        return "SendDataModel(funcCode=" + ((int) this.f9028a) + ", isResponseConfirmPacket=" + this.f9029b + ", isNeedResponseConfirm=false, sendArray=" + Arrays.toString(this.f9030c) + ")";
    }
}
