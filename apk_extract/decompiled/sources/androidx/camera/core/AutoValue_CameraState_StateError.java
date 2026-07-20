package androidx.camera.core;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_CameraState_StateError extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    public AutoValue_CameraState_StateError(int i8, @Nullable Throwable th2) {
        this.code = i8;
        this.cause = th2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState.StateError)) {
            return false;
        }
        CameraState.StateError stateError = (CameraState.StateError) obj;
        if (this.code == stateError.getCode()) {
            Throwable th2 = this.cause;
            if (th2 == null) {
                if (stateError.getCause() == null) {
                    return true;
                }
            } else if (th2.equals(stateError.getCause())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.CameraState.StateError
    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public int getCode() {
        return this.code;
    }

    public int hashCode() {
        int i8 = (this.code ^ 1000003) * 1000003;
        Throwable th2 = this.cause;
        return (th2 == null ? 0 : th2.hashCode()) ^ i8;
    }

    public String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    }
}
