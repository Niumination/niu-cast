package androidx.camera.video;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_StreamInfo extends StreamInfo {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f997id;
    private final StreamInfo.StreamState streamState;

    public AutoValue_StreamInfo(int i8, StreamInfo.StreamState streamState) {
        this.f997id = i8;
        if (streamState == null) {
            throw new NullPointerException("Null streamState");
        }
        this.streamState = streamState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamInfo)) {
            return false;
        }
        StreamInfo streamInfo = (StreamInfo) obj;
        return this.f997id == streamInfo.getId() && this.streamState.equals(streamInfo.getStreamState());
    }

    @Override // androidx.camera.video.StreamInfo
    public int getId() {
        return this.f997id;
    }

    @Override // androidx.camera.video.StreamInfo
    @NonNull
    public StreamInfo.StreamState getStreamState() {
        return this.streamState;
    }

    public int hashCode() {
        return this.streamState.hashCode() ^ ((this.f997id ^ 1000003) * 1000003);
    }

    public String toString() {
        return "StreamInfo{id=" + this.f997id + ", streamState=" + this.streamState + "}";
    }
}
