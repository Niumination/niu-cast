package androidx.camera.video;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Quality_ConstantQuality extends Quality.ConstantQuality {
    private final String name;
    private final int value;

    public AutoValue_Quality_ConstantQuality(int i8, String str) {
        this.value = i8;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Quality.ConstantQuality)) {
            return false;
        }
        Quality.ConstantQuality constantQuality = (Quality.ConstantQuality) obj;
        return this.value == constantQuality.getValue() && this.name.equals(constantQuality.getName());
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    @NonNull
    public String getName() {
        return this.name;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.name.hashCode() ^ ((this.value ^ 1000003) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ConstantQuality{value=");
        sb2.append(this.value);
        sb2.append(", name=");
        return h0.a.n(sb2, this.name, "}");
    }
}
