package androidx.camera.core.processing;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_SurfaceProcessorNode_OutConfig extends SurfaceProcessorNode.OutConfig {
    private final Rect cropRect;
    private final boolean mirroring;
    private final Size size;
    private final int targets;
    private final UUID uuid;

    public AutoValue_SurfaceProcessorNode_OutConfig(UUID uuid, int i8, Rect rect, Size size, boolean z2) {
        if (uuid == null) {
            throw new NullPointerException("Null uuid");
        }
        this.uuid = uuid;
        this.targets = i8;
        if (rect == null) {
            throw new NullPointerException("Null cropRect");
        }
        this.cropRect = rect;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        this.mirroring = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceProcessorNode.OutConfig)) {
            return false;
        }
        SurfaceProcessorNode.OutConfig outConfig = (SurfaceProcessorNode.OutConfig) obj;
        return this.uuid.equals(outConfig.getUuid()) && this.targets == outConfig.getTargets() && this.cropRect.equals(outConfig.getCropRect()) && this.size.equals(outConfig.getSize()) && this.mirroring == outConfig.getMirroring();
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    @NonNull
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    public boolean getMirroring() {
        return this.mirroring;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    @NonNull
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    public int getTargets() {
        return this.targets;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    @NonNull
    public UUID getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return (this.mirroring ? 1231 : 1237) ^ ((((((((this.uuid.hashCode() ^ 1000003) * 1000003) ^ this.targets) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.size.hashCode()) * 1000003);
    }

    public String toString() {
        return "OutConfig{uuid=" + this.uuid + ", targets=" + this.targets + ", cropRect=" + this.cropRect + ", size=" + this.size + ", mirroring=" + this.mirroring + "}";
    }
}
