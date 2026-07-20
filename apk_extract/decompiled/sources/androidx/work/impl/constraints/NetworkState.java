package androidx.work.impl.constraints;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class NetworkState {
    private boolean mIsConnected;
    private boolean mIsMetered;
    private boolean mIsNotRoaming;
    private boolean mIsValidated;

    public NetworkState(boolean z2, boolean z3, boolean z5, boolean z10) {
        this.mIsConnected = z2;
        this.mIsValidated = z3;
        this.mIsMetered = z5;
        this.mIsNotRoaming = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.mIsConnected == networkState.mIsConnected && this.mIsValidated == networkState.mIsValidated && this.mIsMetered == networkState.mIsMetered && this.mIsNotRoaming == networkState.mIsNotRoaming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r7 = this.mIsConnected;
        int i8 = r7;
        if (this.mIsValidated) {
            i8 = r7 + 16;
        }
        int i9 = i8;
        if (this.mIsMetered) {
            i9 = i8 + 256;
        }
        return this.mIsNotRoaming ? i9 + 4096 : i9;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isMetered() {
        return this.mIsMetered;
    }

    public boolean isNotRoaming() {
        return this.mIsNotRoaming;
    }

    public boolean isValidated() {
        return this.mIsValidated;
    }

    @NonNull
    public String toString() {
        return "[ Connected=" + this.mIsConnected + " Validated=" + this.mIsValidated + " Metered=" + this.mIsMetered + " NotRoaming=" + this.mIsNotRoaming + " ]";
    }
}
