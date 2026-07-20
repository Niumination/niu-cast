package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_StreamSpec extends StreamSpec {
    private final Range<Integer> expectedFrameRateRange;
    private final Size resolution;

    public static final class Builder extends StreamSpec.Builder {
        private Range<Integer> expectedFrameRateRange;
        private Size resolution;

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec build() {
            String strB = this.resolution == null ? " resolution" : "";
            if (this.expectedFrameRateRange == null) {
                strB = h0.a.B(strB, " expectedFrameRateRange");
            }
            if (strB.isEmpty()) {
                return new AutoValue_StreamSpec(this.resolution, this.expectedFrameRateRange);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setExpectedFrameRateRange(Range<Integer> range) {
            if (range == null) {
                throw new NullPointerException("Null expectedFrameRateRange");
            }
            this.expectedFrameRateRange = range;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setResolution(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.resolution = size;
            return this;
        }

        public Builder() {
        }

        private Builder(StreamSpec streamSpec) {
            this.resolution = streamSpec.getResolution();
            this.expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamSpec)) {
            return false;
        }
        StreamSpec streamSpec = (StreamSpec) obj;
        return this.resolution.equals(streamSpec.getResolution()) && this.expectedFrameRateRange.equals(streamSpec.getExpectedFrameRateRange());
    }

    @Override // androidx.camera.core.impl.StreamSpec
    @NonNull
    public Range<Integer> getExpectedFrameRateRange() {
        return this.expectedFrameRateRange;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    @NonNull
    public Size getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        return this.expectedFrameRateRange.hashCode() ^ ((this.resolution.hashCode() ^ 1000003) * 1000003);
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public StreamSpec.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.resolution + ", expectedFrameRateRange=" + this.expectedFrameRateRange + "}";
    }

    private AutoValue_StreamSpec(Size size, Range<Integer> range) {
        this.resolution = size;
        this.expectedFrameRateRange = range;
    }
}
