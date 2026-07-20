package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideRecord;", "", "path", "", "name", "title", "desc", "order", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getPath", "()Ljava/lang/String;", "getName", "getTitle", "getDesc", "getOrder", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class FunctionGuideRecord {

    @SerializedName("desc")
    private final String desc;

    @SerializedName("name")
    private final String name;

    @SerializedName("order")
    private final int order;

    @SerializedName("path")
    private final String path;

    @SerializedName("title")
    private final String title;

    public FunctionGuideRecord(String path, String name, String title, String desc, int i8) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.path = path;
        this.name = name;
        this.title = title;
        this.desc = desc;
        this.order = i8;
    }

    public static /* synthetic */ FunctionGuideRecord copy$default(FunctionGuideRecord functionGuideRecord, String str, String str2, String str3, String str4, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = functionGuideRecord.path;
        }
        if ((i9 & 2) != 0) {
            str2 = functionGuideRecord.name;
        }
        String str5 = str2;
        if ((i9 & 4) != 0) {
            str3 = functionGuideRecord.title;
        }
        String str6 = str3;
        if ((i9 & 8) != 0) {
            str4 = functionGuideRecord.desc;
        }
        String str7 = str4;
        if ((i9 & 16) != 0) {
            i8 = functionGuideRecord.order;
        }
        return functionGuideRecord.copy(str, str5, str6, str7, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    public final FunctionGuideRecord copy(String path, String name, String title, String desc, int order) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new FunctionGuideRecord(path, name, title, desc, order);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionGuideRecord)) {
            return false;
        }
        FunctionGuideRecord functionGuideRecord = (FunctionGuideRecord) other;
        return Intrinsics.areEqual(this.path, functionGuideRecord.path) && Intrinsics.areEqual(this.name, functionGuideRecord.name) && Intrinsics.areEqual(this.title, functionGuideRecord.title) && Intrinsics.areEqual(this.desc, functionGuideRecord.desc) && this.order == functionGuideRecord.order;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Integer.hashCode(this.order) + a.e(a.e(a.e(this.path.hashCode() * 31, 31, this.name), 31, this.title), 31, this.desc);
    }

    public String toString() {
        String str = this.path;
        String str2 = this.name;
        String str3 = this.title;
        String str4 = this.desc;
        int i8 = this.order;
        StringBuilder sbP = h0.a.p("FunctionGuideRecord(path=", str, ", name=", str2, ", title=");
        d.A(sbP, str3, ", desc=", str4, ", order=");
        return h0.a.m(sbP, ")", i8);
    }
}
