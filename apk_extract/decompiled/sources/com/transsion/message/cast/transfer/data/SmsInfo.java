package com.transsion.message.cast.transfer.data;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/transsion/message/cast/transfer/data/SmsInfo;", "", "smsId", "", "contactName", "phoneNumber", "content", "timestamp", "", "deviceName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getSmsId", "()Ljava/lang/String;", "getContactName", "getPhoneNumber", "getContent", "getTimestamp", "()J", "getDeviceName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SmsInfo {
    private final String contactName;
    private final String content;
    private final String deviceName;
    private final String phoneNumber;
    private final String smsId;
    private final long timestamp;

    public SmsInfo(String smsId, String str, String phoneNumber, String content, long j8, String deviceName) {
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.smsId = smsId;
        this.contactName = str;
        this.phoneNumber = phoneNumber;
        this.content = content;
        this.timestamp = j8;
        this.deviceName = deviceName;
    }

    public static /* synthetic */ SmsInfo copy$default(SmsInfo smsInfo, String str, String str2, String str3, String str4, long j8, String str5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = smsInfo.smsId;
        }
        if ((i8 & 2) != 0) {
            str2 = smsInfo.contactName;
        }
        String str6 = str2;
        if ((i8 & 4) != 0) {
            str3 = smsInfo.phoneNumber;
        }
        String str7 = str3;
        if ((i8 & 8) != 0) {
            str4 = smsInfo.content;
        }
        String str8 = str4;
        if ((i8 & 16) != 0) {
            j8 = smsInfo.timestamp;
        }
        long j10 = j8;
        if ((i8 & 32) != 0) {
            str5 = smsInfo.deviceName;
        }
        return smsInfo.copy(str, str6, str7, str8, j10, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSmsId() {
        return this.smsId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContactName() {
        return this.contactName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    public final SmsInfo copy(String smsId, String contactName, String phoneNumber, String content, long timestamp, String deviceName) {
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        return new SmsInfo(smsId, contactName, phoneNumber, content, timestamp, deviceName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmsInfo)) {
            return false;
        }
        SmsInfo smsInfo = (SmsInfo) other;
        return Intrinsics.areEqual(this.smsId, smsInfo.smsId) && Intrinsics.areEqual(this.contactName, smsInfo.contactName) && Intrinsics.areEqual(this.phoneNumber, smsInfo.phoneNumber) && Intrinsics.areEqual(this.content, smsInfo.content) && this.timestamp == smsInfo.timestamp && Intrinsics.areEqual(this.deviceName, smsInfo.deviceName);
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getSmsId() {
        return this.smsId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = this.smsId.hashCode() * 31;
        String str = this.contactName;
        return this.deviceName.hashCode() + a.f(this.timestamp, a.e(a.e((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.phoneNumber), 31, this.content), 31);
    }

    public String toString() {
        String str = this.smsId;
        String str2 = this.contactName;
        String str3 = this.phoneNumber;
        String str4 = this.content;
        long j8 = this.timestamp;
        String str5 = this.deviceName;
        StringBuilder sbP = h0.a.p("SmsInfo(smsId=", str, ", contactName=", str2, ", phoneNumber=");
        d.A(sbP, str3, ", content=", str4, ", timestamp=");
        sbP.append(j8);
        sbP.append(", deviceName=");
        sbP.append(str5);
        sbP.append(")");
        return sbP.toString();
    }
}
