package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xa.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lq7/b;", "", "", "", "urls", "Ljava/util/List;", "d", "()Ljava/util/List;", "savePath", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "isReceive", "Z", "e", "()Z", "savePackage", "b", "id", "a", "setId", "(Ljava/lang/String;)V", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class b {

    @SerializedName("id")
    private String id;

    @SerializedName("isReceive")
    private final boolean isReceive;

    @SerializedName("savePackage")
    private final String savePackage;

    @SerializedName("savePath")
    private final String savePath;

    @SerializedName("urls")
    private final List<String> urls;

    public b(String savePath, String str, List urls) {
        String savePackage = i.f10892b;
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Intrinsics.checkNotNullParameter(savePackage, "savePackage");
        this.urls = urls;
        this.savePath = savePath;
        this.isReceive = true;
        this.savePackage = savePackage;
        this.id = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getSavePackage() {
        return this.savePackage;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getSavePath() {
        return this.savePath;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final List getUrls() {
        return this.urls;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getIsReceive() {
        return this.isReceive;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.urls, bVar.urls) && Intrinsics.areEqual(this.savePath, bVar.savePath) && this.isReceive == bVar.isReceive && Intrinsics.areEqual(this.savePackage, bVar.savePackage) && Intrinsics.areEqual(this.id, bVar.id);
    }

    public final int hashCode() {
        int iE = a1.a.e(a1.a.g(this.isReceive, a1.a.e(this.urls.hashCode() * 31, 31, this.savePath), 31), 31, this.savePackage);
        String str = this.id;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        List<String> list = this.urls;
        String str = this.savePath;
        boolean z2 = this.isReceive;
        String str2 = this.savePackage;
        String str3 = this.id;
        StringBuilder sb2 = new StringBuilder("ConfirmReceiveFileBean(urls=");
        sb2.append(list);
        sb2.append(", savePath=");
        sb2.append(str);
        sb2.append(", isReceive=");
        sb2.append(z2);
        sb2.append(", savePackage=");
        sb2.append(str2);
        sb2.append(", id=");
        return h0.a.n(sb2, str3, ")");
    }
}
