package com.transsion.message.cast.transfer.data;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/transsion/message/cast/transfer/data/CallState;", "", "callId", "", "state", "Lcom/transsion/message/cast/transfer/data/CallState$State;", "videoState", "capabilities", "timestamp", "", "<init>", "(Ljava/lang/String;Lcom/transsion/message/cast/transfer/data/CallState$State;Ljava/lang/String;Ljava/lang/String;J)V", "getCallId", "()Ljava/lang/String;", "getState", "()Lcom/transsion/message/cast/transfer/data/CallState$State;", "getVideoState", "getCapabilities", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "State", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class CallState {
    private final String callId;
    private final String capabilities;
    private final State state;
    private final long timestamp;
    private final String videoState;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/transsion/message/cast/transfer/data/CallState$State;", "", "<init>", "(Ljava/lang/String;I)V", "NEW", "CONNECTING", "SELECT_PHONE_ACCOUNT", "DIALING", "RINGING", "ACTIVE", "ON_HOLD", "DISCONNECTED", "ABORTED", "DISCONNECTING", "PULLING", "ANSWERED", "AUDIO_PROCESSING", "SIMULATED_RINGING", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum State {
        NEW,
        CONNECTING,
        SELECT_PHONE_ACCOUNT,
        DIALING,
        RINGING,
        ACTIVE,
        ON_HOLD,
        DISCONNECTED,
        ABORTED,
        DISCONNECTING,
        PULLING,
        ANSWERED,
        AUDIO_PROCESSING,
        SIMULATED_RINGING;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/message/cast/transfer/data/CallState$State$Companion;", "", "<init>", "()V", "fromString", "Lcom/transsion/message/cast/transfer/data/CallState$State;", "state", "", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            public final State fromString(String state) {
                Intrinsics.checkNotNullParameter(state, "state");
                String upperCase = state.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                switch (upperCase.hashCode()) {
                    case -1921965486:
                        if (upperCase.equals("DIALING")) {
                            return State.DIALING;
                        }
                        break;
                    case -1052098138:
                        if (upperCase.equals("DISCONNECTING")) {
                            return State.DISCONNECTING;
                        }
                        break;
                    case -578621665:
                        if (upperCase.equals("ON_HOLD")) {
                            return State.ON_HOLD;
                        }
                        break;
                    case -476794961:
                        if (upperCase.equals("ABORTED")) {
                            return State.ABORTED;
                        }
                        break;
                    case -290559304:
                        if (upperCase.equals("CONNECTING")) {
                            return State.CONNECTING;
                        }
                        break;
                    case -185696452:
                        if (upperCase.equals("AUDIO_PROCESSING")) {
                            return State.AUDIO_PROCESSING;
                        }
                        break;
                    case 77184:
                        if (upperCase.equals("NEW")) {
                            return State.NEW;
                        }
                        break;
                    case 283067613:
                        if (upperCase.equals("ANSWERED")) {
                            return State.ANSWERED;
                        }
                        break;
                    case 491852637:
                        if (upperCase.equals("PULLING")) {
                            return State.PULLING;
                        }
                        break;
                    case 935892539:
                        if (upperCase.equals("DISCONNECTED")) {
                            return State.DISCONNECTED;
                        }
                        break;
                    case 1453303027:
                        if (upperCase.equals("SIMULATED_RINGING")) {
                            return State.SIMULATED_RINGING;
                        }
                        break;
                    case 1925008274:
                        if (upperCase.equals("RINGING")) {
                            return State.RINGING;
                        }
                        break;
                    case 1925346054:
                        if (upperCase.equals("ACTIVE")) {
                            return State.ACTIVE;
                        }
                        break;
                    case 1936942617:
                        if (upperCase.equals("SELECT_PHONE_ACCOUNT")) {
                            return State.SELECT_PHONE_ACCOUNT;
                        }
                        break;
                }
                return State.RINGING;
            }

            private Companion() {
            }
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    public CallState(String callId, State state, String videoState, String capabilities, long j8) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(videoState, "videoState");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        this.callId = callId;
        this.state = state;
        this.videoState = videoState;
        this.capabilities = capabilities;
        this.timestamp = j8;
    }

    public static /* synthetic */ CallState copy$default(CallState callState, String str, State state, String str2, String str3, long j8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = callState.callId;
        }
        if ((i8 & 2) != 0) {
            state = callState.state;
        }
        State state2 = state;
        if ((i8 & 4) != 0) {
            str2 = callState.videoState;
        }
        String str4 = str2;
        if ((i8 & 8) != 0) {
            str3 = callState.capabilities;
        }
        String str5 = str3;
        if ((i8 & 16) != 0) {
            j8 = callState.timestamp;
        }
        return callState.copy(str, state2, str4, str5, j8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVideoState() {
        return this.videoState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCapabilities() {
        return this.capabilities;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final CallState copy(String callId, State state, String videoState, String capabilities, long timestamp) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(videoState, "videoState");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        return new CallState(callId, state, videoState, capabilities, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallState)) {
            return false;
        }
        CallState callState = (CallState) other;
        return Intrinsics.areEqual(this.callId, callState.callId) && this.state == callState.state && Intrinsics.areEqual(this.videoState, callState.videoState) && Intrinsics.areEqual(this.capabilities, callState.capabilities) && this.timestamp == callState.timestamp;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final String getCapabilities() {
        return this.capabilities;
    }

    public final State getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getVideoState() {
        return this.videoState;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + a.e(a.e((this.state.hashCode() + (this.callId.hashCode() * 31)) * 31, 31, this.videoState), 31, this.capabilities);
    }

    public String toString() {
        String str = this.callId;
        State state = this.state;
        String str2 = this.videoState;
        String str3 = this.capabilities;
        long j8 = this.timestamp;
        StringBuilder sb2 = new StringBuilder("CallState(callId=");
        sb2.append(str);
        sb2.append(", state=");
        sb2.append(state);
        sb2.append(", videoState=");
        d.A(sb2, str2, ", capabilities=", str3, ", timestamp=");
        return d.p(sb2, j8, ")");
    }
}
