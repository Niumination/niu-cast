package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.capability.bean.FileInfo;
import com.transsion.message.bank.MessageBank;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lq7/h;", "", "Ljava/util/ArrayList;", "Lcom/transsion/capability/bean/FileInfo;", "Lkotlin/collections/ArrayList;", "fileInfoList", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "", "packageName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", MessageBank.KEY_TYPE, "I", "d", "()I", "taskId", "c", "setTaskId", "(Ljava/lang/String;)V", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class h {

    @SerializedName("fileInfoList")
    private final ArrayList<FileInfo> fileInfoList;

    @SerializedName("packageName")
    private final String packageName;

    @SerializedName("taskId")
    private String taskId;

    @SerializedName(MessageBank.KEY_TYPE)
    private final int type;

    public h(ArrayList fileInfoList, String packageName, int i8, String str) {
        Intrinsics.checkNotNullParameter(fileInfoList, "fileInfoList");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.fileInfoList = fileInfoList;
        this.packageName = packageName;
        this.type = i8;
        this.taskId = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final ArrayList getFileInfoList() {
        return this.fileInfoList;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.fileInfoList, hVar.fileInfoList) && Intrinsics.areEqual(this.packageName, hVar.packageName) && this.type == hVar.type && Intrinsics.areEqual(this.taskId, hVar.taskId);
    }

    public final int hashCode() {
        int iC = a1.a.c(this.type, a1.a.e(this.fileInfoList.hashCode() * 31, 31, this.packageName), 31);
        String str = this.taskId;
        return iC + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "FileInfoBean(fileInfoList=" + this.fileInfoList + ", packageName=" + this.packageName + ", type=" + this.type + ", taskId=" + this.taskId + ")";
    }
}
