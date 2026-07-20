package com.transsion.iotservice.multiscreen.pc.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import h0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideResource;", ExifInterface.GPS_DIRECTION_TRUE, "", "countryCode", "", "resource", "", "version", "", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "getCountryCode", "()Ljava/lang/String;", "getResource", "()Ljava/util/List;", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class FunctionGuideResource<T> {

    @SerializedName("countryCode")
    private final String countryCode;

    @SerializedName("resource")
    private final List<T> resource;

    @SerializedName("version")
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionGuideResource(String countryCode, List<? extends T> resource, int i8) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.countryCode = countryCode;
        this.resource = resource;
        this.version = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FunctionGuideResource copy$default(FunctionGuideResource functionGuideResource, String str, List list, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = functionGuideResource.countryCode;
        }
        if ((i9 & 2) != 0) {
            list = functionGuideResource.resource;
        }
        if ((i9 & 4) != 0) {
            i8 = functionGuideResource.version;
        }
        return functionGuideResource.copy(str, list, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final List<T> component2() {
        return this.resource;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final FunctionGuideResource<T> copy(String countryCode, List<? extends T> resource, int version) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new FunctionGuideResource<>(countryCode, resource, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionGuideResource)) {
            return false;
        }
        FunctionGuideResource functionGuideResource = (FunctionGuideResource) other;
        return Intrinsics.areEqual(this.countryCode, functionGuideResource.countryCode) && Intrinsics.areEqual(this.resource, functionGuideResource.resource) && this.version == functionGuideResource.version;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final List<T> getResource() {
        return this.resource;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Integer.hashCode(this.version) + ((this.resource.hashCode() + (this.countryCode.hashCode() * 31)) * 31);
    }

    public String toString() {
        String str = this.countryCode;
        List<T> list = this.resource;
        int i8 = this.version;
        StringBuilder sb2 = new StringBuilder("FunctionGuideResource(countryCode=");
        sb2.append(str);
        sb2.append(", resource=");
        sb2.append(list);
        sb2.append(", version=");
        return a.m(sb2, ")", i8);
    }
}
