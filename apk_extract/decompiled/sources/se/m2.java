package se;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f9868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9870d;
    public final byte[] e;
    public final Integer f;

    public m2(String vendorId, byte[] bArr, String str, int i8, byte[] bArr2, Integer num) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        this.f9867a = vendorId;
        this.f9868b = bArr;
        this.f9869c = str;
        this.f9870d = i8;
        this.e = bArr2;
        this.f = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(m2.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearLanManager.AdvertiseParams");
        m2 m2Var = (m2) obj;
        if (!Intrinsics.areEqual(this.f9867a, m2Var.f9867a)) {
            return false;
        }
        byte[] bArr = this.f9868b;
        if (bArr != null) {
            byte[] bArr2 = m2Var.f9868b;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (m2Var.f9868b != null) {
            return false;
        }
        if (!Intrinsics.areEqual(this.f9869c, m2Var.f9869c) || this.f9870d != m2Var.f9870d || !Intrinsics.areEqual(this.f, m2Var.f)) {
            return false;
        }
        byte[] bArr3 = this.e;
        if (bArr3 != null) {
            byte[] bArr4 = m2Var.e;
            if (bArr4 == null || !Arrays.equals(bArr3, bArr4)) {
                return false;
            }
        } else if (m2Var.e != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = this.f9867a.hashCode() * 31;
        byte[] bArr = this.f9868b;
        int iHashCode2 = (iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        String str = this.f9869c;
        int iHashCode3 = (((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f9870d) * 31;
        byte[] bArr2 = this.e;
        return iHashCode3 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0);
    }

    public final String toString() {
        String string = Arrays.toString(this.f9868b);
        String string2 = Arrays.toString(this.e);
        StringBuilder sb2 = new StringBuilder("AdvertiseParams(vendorId=");
        o.d.A(sb2, this.f9867a, ", deviceId=", string, ", deviceName=");
        sb2.append(this.f9869c);
        sb2.append(", serviceType=");
        sb2.append(this.f9870d);
        sb2.append(", serviceList=");
        sb2.append(string2);
        sb2.append(", subCapability=");
        sb2.append(this.f);
        sb2.append(")");
        return sb2.toString();
    }
}
