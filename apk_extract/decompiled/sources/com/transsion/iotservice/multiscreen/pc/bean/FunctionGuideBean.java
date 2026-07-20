package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideBean;", "", "vapResource", "Lcom/transsion/iotservice/multiscreen/pc/bean/VapResource;", "functionTitleBean", "Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;", "functionDescBean", "isDefault", "", "id", "", "<init>", "(Lcom/transsion/iotservice/multiscreen/pc/bean/VapResource;Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;ZLjava/lang/String;)V", "getVapResource", "()Lcom/transsion/iotservice/multiscreen/pc/bean/VapResource;", "getFunctionTitleBean", "()Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;", "getFunctionDescBean", "()Z", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class FunctionGuideBean {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("functionDescBean")
    private final TextBean functionDescBean;

    @SerializedName("functionTitleBean")
    private final TextBean functionTitleBean;

    @SerializedName("id")
    private final String id;

    @SerializedName("isDefault")
    private final boolean isDefault;

    @SerializedName("vapResource")
    private final VapResource vapResource;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideBean$Companion;", "", "<init>", "()V", "createDefaultGuide", "Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideBean;", "vapResource", "Lcom/transsion/iotservice/multiscreen/pc/bean/VapResource;", "functionTitle", "", "functionDesc", "createRemoteGuide", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FunctionGuideBean createDefaultGuide(VapResource vapResource, int functionTitle, int functionDesc) {
            Intrinsics.checkNotNullParameter(vapResource, "vapResource");
            return new FunctionGuideBean(vapResource, new TextBean(Integer.valueOf(functionTitle), null), new TextBean(Integer.valueOf(functionDesc), null), false, null, 24, null);
        }

        public final FunctionGuideBean createRemoteGuide(VapResource vapResource, String functionTitle, String functionDesc) {
            Intrinsics.checkNotNullParameter(vapResource, "vapResource");
            Intrinsics.checkNotNullParameter(functionTitle, "functionTitle");
            Intrinsics.checkNotNullParameter(functionDesc, "functionDesc");
            return new FunctionGuideBean(vapResource, new TextBean(null, functionTitle), new TextBean(null, functionDesc), false, null, 16, null);
        }

        private Companion() {
        }
    }

    public FunctionGuideBean(VapResource vapResource, TextBean functionTitleBean, TextBean functionDescBean, boolean z2, String id2) {
        Intrinsics.checkNotNullParameter(vapResource, "vapResource");
        Intrinsics.checkNotNullParameter(functionTitleBean, "functionTitleBean");
        Intrinsics.checkNotNullParameter(functionDescBean, "functionDescBean");
        Intrinsics.checkNotNullParameter(id2, "id");
        this.vapResource = vapResource;
        this.functionTitleBean = functionTitleBean;
        this.functionDescBean = functionDescBean;
        this.isDefault = z2;
        this.id = id2;
    }

    public static /* synthetic */ FunctionGuideBean copy$default(FunctionGuideBean functionGuideBean, VapResource vapResource, TextBean textBean, TextBean textBean2, boolean z2, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            vapResource = functionGuideBean.vapResource;
        }
        if ((i8 & 2) != 0) {
            textBean = functionGuideBean.functionTitleBean;
        }
        TextBean textBean3 = textBean;
        if ((i8 & 4) != 0) {
            textBean2 = functionGuideBean.functionDescBean;
        }
        TextBean textBean4 = textBean2;
        if ((i8 & 8) != 0) {
            z2 = functionGuideBean.isDefault;
        }
        boolean z3 = z2;
        if ((i8 & 16) != 0) {
            str = functionGuideBean.id;
        }
        return functionGuideBean.copy(vapResource, textBean3, textBean4, z3, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VapResource getVapResource() {
        return this.vapResource;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TextBean getFunctionTitleBean() {
        return this.functionTitleBean;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TextBean getFunctionDescBean() {
        return this.functionDescBean;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final FunctionGuideBean copy(VapResource vapResource, TextBean functionTitleBean, TextBean functionDescBean, boolean isDefault, String id2) {
        Intrinsics.checkNotNullParameter(vapResource, "vapResource");
        Intrinsics.checkNotNullParameter(functionTitleBean, "functionTitleBean");
        Intrinsics.checkNotNullParameter(functionDescBean, "functionDescBean");
        Intrinsics.checkNotNullParameter(id2, "id");
        return new FunctionGuideBean(vapResource, functionTitleBean, functionDescBean, isDefault, id2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionGuideBean)) {
            return false;
        }
        FunctionGuideBean functionGuideBean = (FunctionGuideBean) other;
        return Intrinsics.areEqual(this.vapResource, functionGuideBean.vapResource) && Intrinsics.areEqual(this.functionTitleBean, functionGuideBean.functionTitleBean) && Intrinsics.areEqual(this.functionDescBean, functionGuideBean.functionDescBean) && this.isDefault == functionGuideBean.isDefault && Intrinsics.areEqual(this.id, functionGuideBean.id);
    }

    public final TextBean getFunctionDescBean() {
        return this.functionDescBean;
    }

    public final TextBean getFunctionTitleBean() {
        return this.functionTitleBean;
    }

    public final String getId() {
        return this.id;
    }

    public final VapResource getVapResource() {
        return this.vapResource;
    }

    public int hashCode() {
        return this.id.hashCode() + a.g(this.isDefault, (this.functionDescBean.hashCode() + ((this.functionTitleBean.hashCode() + (this.vapResource.hashCode() * 31)) * 31)) * 31, 31);
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public String toString() {
        VapResource vapResource = this.vapResource;
        TextBean textBean = this.functionTitleBean;
        TextBean textBean2 = this.functionDescBean;
        boolean z2 = this.isDefault;
        String str = this.id;
        StringBuilder sb2 = new StringBuilder("FunctionGuideBean(vapResource=");
        sb2.append(vapResource);
        sb2.append(", functionTitleBean=");
        sb2.append(textBean);
        sb2.append(", functionDescBean=");
        sb2.append(textBean2);
        sb2.append(", isDefault=");
        sb2.append(z2);
        sb2.append(", id=");
        return h0.a.n(sb2, str, ")");
    }

    public /* synthetic */ FunctionGuideBean(VapResource vapResource, TextBean textBean, TextBean textBean2, boolean z2, String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(vapResource, textBean, textBean2, (i8 & 8) != 0 ? true : z2, (i8 & 16) != 0 ? UUID.randomUUID().toString() : str);
    }
}
