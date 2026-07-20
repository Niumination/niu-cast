package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xa.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lq7/c;", "", "", "", "urls", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "transferMode", "I", "c", "()I", "fileFromPackage", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "key", "b", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class c {

    @SerializedName("fileFromPackage")
    private final String fileFromPackage;

    @SerializedName("key")
    private final String key;

    @SerializedName("transferMode")
    private final int transferMode;

    @SerializedName("urls")
    private final List<String> urls;

    public c(List urls, String key) {
        String fileFromPackage = i.f10892b;
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(fileFromPackage, "fileFromPackage");
        Intrinsics.checkNotNullParameter(key, "key");
        this.urls = urls;
        this.transferMode = 0;
        this.fileFromPackage = fileFromPackage;
        this.key = key;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getFileFromPackage() {
        return this.fileFromPackage;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getTransferMode() {
        return this.transferMode;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final List getUrls() {
        return this.urls;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.urls, cVar.urls) && this.transferMode == cVar.transferMode && Intrinsics.areEqual(this.fileFromPackage, cVar.fileFromPackage) && Intrinsics.areEqual(this.key, cVar.key);
    }

    public final int hashCode() {
        return this.key.hashCode() + a1.a.e(a1.a.c(this.transferMode, this.urls.hashCode() * 31, 31), 31, this.fileFromPackage);
    }

    public final String toString() {
        return "ConfirmSendFileBean(urls=" + this.urls + ", transferMode=" + this.transferMode + ", fileFromPackage=" + this.fileFromPackage + ", key=" + this.key + ")";
    }
}
