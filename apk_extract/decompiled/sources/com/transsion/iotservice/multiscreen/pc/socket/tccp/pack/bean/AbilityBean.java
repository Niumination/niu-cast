package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o7.b;
import o7.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/AbilityBean;", "", "", "serviceName", "", "abilityVersion", "Lo7/c;", "action", "<init>", "(Ljava/lang/String;ILo7/c;)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "()Lo7/c;", "copy", "(Ljava/lang/String;ILo7/c;)Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/AbilityBean;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getServiceName", "I", "getAbilityVersion", "Lo7/c;", "getAction", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class AbilityBean {

    @SerializedName("abilityVersion")
    private final int abilityVersion;
    private final transient c action;

    @SerializedName("servicename")
    private final String serviceName;

    public AbilityBean(String serviceName, int i8, c action) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(action, "action");
        this.serviceName = serviceName;
        this.abilityVersion = i8;
        this.action = action;
    }

    public static /* synthetic */ AbilityBean copy$default(AbilityBean abilityBean, String str, int i8, c cVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = abilityBean.serviceName;
        }
        if ((i9 & 2) != 0) {
            i8 = abilityBean.abilityVersion;
        }
        if ((i9 & 4) != 0) {
            cVar = abilityBean.action;
        }
        return abilityBean.copy(str, i8, cVar);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAbilityVersion() {
        return this.abilityVersion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final c getAction() {
        return this.action;
    }

    public final AbilityBean copy(String serviceName, int abilityVersion, c action) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(action, "action");
        return new AbilityBean(serviceName, abilityVersion, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityBean)) {
            return false;
        }
        AbilityBean abilityBean = (AbilityBean) other;
        return Intrinsics.areEqual(this.serviceName, abilityBean.serviceName) && this.abilityVersion == abilityBean.abilityVersion && Intrinsics.areEqual(this.action, abilityBean.action);
    }

    public final int getAbilityVersion() {
        return this.abilityVersion;
    }

    public final c getAction() {
        return this.action;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public int hashCode() {
        return this.action.hashCode() + a.c(this.abilityVersion, this.serviceName.hashCode() * 31, 31);
    }

    public String toString() {
        return "AbilityBean(serviceName=" + this.serviceName + ", abilityVersion=" + this.abilityVersion + ", action=" + this.action + ")";
    }

    public AbilityBean(String str, int i8, c cVar, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i9 & 2) != 0 ? 0 : i8, (i9 & 4) != 0 ? new b(0) : cVar);
    }
}
