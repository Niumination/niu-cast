package androidx.camera.video;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_QualityRatioToResolutionsTable_QualityRatio extends QualityRatioToResolutionsTable.QualityRatio {
    private final int aspectRatio;
    private final Quality quality;

    public AutoValue_QualityRatioToResolutionsTable_QualityRatio(Quality quality, int i8) {
        if (quality == null) {
            throw new NullPointerException("Null quality");
        }
        this.quality = quality;
        this.aspectRatio = i8;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QualityRatioToResolutionsTable.QualityRatio)) {
            return false;
        }
        QualityRatioToResolutionsTable.QualityRatio qualityRatio = (QualityRatioToResolutionsTable.QualityRatio) obj;
        return this.quality.equals(qualityRatio.getQuality()) && this.aspectRatio == qualityRatio.getAspectRatio();
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    public int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    @NonNull
    public Quality getQuality() {
        return this.quality;
    }

    public int hashCode() {
        return this.aspectRatio ^ ((this.quality.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("QualityRatio{quality=");
        sb2.append(this.quality);
        sb2.append(", aspectRatio=");
        return h0.a.m(sb2, "}", this.aspectRatio);
    }
}
