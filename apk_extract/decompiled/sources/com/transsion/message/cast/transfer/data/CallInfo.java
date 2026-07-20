package com.transsion.message.cast.transfer.data;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/transsion/message/cast/transfer/data/CallInfo;", "", "callId", "", "phoneNumber", "contactName", "location", "deviceName", "audioOutput", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/message/cast/transfer/e/EAudioOutput;)V", "getCallId", "()Ljava/lang/String;", "getPhoneNumber", "getContactName", "getLocation", "getDeviceName", "getAudioOutput", "()Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class CallInfo {
    private final EAudioOutput audioOutput;
    private final String callId;
    private final String contactName;
    private final String deviceName;
    private final String location;
    private final String phoneNumber;

    public CallInfo(String callId, String phoneNumber, String str, String str2, String deviceName, EAudioOutput audioOutput) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
        this.callId = callId;
        this.phoneNumber = phoneNumber;
        this.contactName = str;
        this.location = str2;
        this.deviceName = deviceName;
        this.audioOutput = audioOutput;
    }

    public static /* synthetic */ CallInfo copy$default(CallInfo callInfo, String str, String str2, String str3, String str4, String str5, EAudioOutput eAudioOutput, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = callInfo.callId;
        }
        if ((i8 & 2) != 0) {
            str2 = callInfo.phoneNumber;
        }
        String str6 = str2;
        if ((i8 & 4) != 0) {
            str3 = callInfo.contactName;
        }
        String str7 = str3;
        if ((i8 & 8) != 0) {
            str4 = callInfo.location;
        }
        String str8 = str4;
        if ((i8 & 16) != 0) {
            str5 = callInfo.deviceName;
        }
        String str9 = str5;
        if ((i8 & 32) != 0) {
            eAudioOutput = callInfo.audioOutput;
        }
        return callInfo.copy(str, str6, str7, str8, str9, eAudioOutput);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContactName() {
        return this.contactName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final EAudioOutput getAudioOutput() {
        return this.audioOutput;
    }

    public final CallInfo copy(String callId, String phoneNumber, String contactName, String location, String deviceName, EAudioOutput audioOutput) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
        return new CallInfo(callId, phoneNumber, contactName, location, deviceName, audioOutput);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallInfo)) {
            return false;
        }
        CallInfo callInfo = (CallInfo) other;
        return Intrinsics.areEqual(this.callId, callInfo.callId) && Intrinsics.areEqual(this.phoneNumber, callInfo.phoneNumber) && Intrinsics.areEqual(this.contactName, callInfo.contactName) && Intrinsics.areEqual(this.location, callInfo.location) && Intrinsics.areEqual(this.deviceName, callInfo.deviceName) && this.audioOutput == callInfo.audioOutput;
    }

    public final EAudioOutput getAudioOutput() {
        return this.audioOutput;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        int iE = a.e(this.callId.hashCode() * 31, 31, this.phoneNumber);
        String str = this.contactName;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.location;
        return this.audioOutput.hashCode() + a.e((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31, this.deviceName);
    }

    public String toString() {
        String str = this.callId;
        String str2 = this.phoneNumber;
        String str3 = this.contactName;
        String str4 = this.location;
        String str5 = this.deviceName;
        EAudioOutput eAudioOutput = this.audioOutput;
        StringBuilder sbP = h0.a.p("CallInfo(callId=", str, ", phoneNumber=", str2, ", contactName=");
        d.A(sbP, str3, ", location=", str4, ", deviceName=");
        sbP.append(str5);
        sbP.append(", audioOutput=");
        sbP.append(eAudioOutput);
        sbP.append(")");
        return sbP.toString();
    }
}
