package com.transsion.iotcardsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/transsion/iotcardsdk/bean/IotCardTemplatePublisherWrapper;", "Landroid/os/Parcelable;", "controlAction", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateActionWrapper;", "(Lcom/transsion/iotcardsdk/bean/IotCardTemplateActionWrapper;)V", "getControlAction", "()Lcom/transsion/iotcardsdk/bean/IotCardTemplateActionWrapper;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class IotCardTemplatePublisherWrapper implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IotCardTemplateActionWrapper controlAction;

    /* JADX INFO: renamed from: com.transsion.iotcardsdk.bean.IotCardTemplatePublisherWrapper$CREATOR, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/iotcardsdk/bean/IotCardTemplatePublisherWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/transsion/iotcardsdk/bean/IotCardTemplatePublisherWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/transsion/iotcardsdk/bean/IotCardTemplatePublisherWrapper;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion implements Parcelable.Creator<IotCardTemplatePublisherWrapper> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @RequiresApi(23)
        public IotCardTemplatePublisherWrapper createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            IotCardTemplateActionWrapper iotCardTemplateActionWrapperCreateIotCardTemplateActionWrapperFromBundle = IotCardTemplateActionWrapper.INSTANCE.createIotCardTemplateActionWrapperFromBundle(parcel.readBundle());
            Intrinsics.checkNotNull(iotCardTemplateActionWrapperCreateIotCardTemplateActionWrapperFromBundle);
            return new IotCardTemplatePublisherWrapper(iotCardTemplateActionWrapperCreateIotCardTemplateActionWrapperFromBundle);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IotCardTemplatePublisherWrapper[] newArray(int size) {
            return new IotCardTemplatePublisherWrapper[size];
        }
    }

    public IotCardTemplatePublisherWrapper(IotCardTemplateActionWrapper controlAction) {
        Intrinsics.checkNotNullParameter(controlAction, "controlAction");
        this.controlAction = controlAction;
    }

    public static /* synthetic */ IotCardTemplatePublisherWrapper copy$default(IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper, IotCardTemplateActionWrapper iotCardTemplateActionWrapper, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            iotCardTemplateActionWrapper = iotCardTemplatePublisherWrapper.controlAction;
        }
        return iotCardTemplatePublisherWrapper.copy(iotCardTemplateActionWrapper);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IotCardTemplateActionWrapper getControlAction() {
        return this.controlAction;
    }

    public final IotCardTemplatePublisherWrapper copy(IotCardTemplateActionWrapper controlAction) {
        Intrinsics.checkNotNullParameter(controlAction, "controlAction");
        return new IotCardTemplatePublisherWrapper(controlAction);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IotCardTemplatePublisherWrapper) && Intrinsics.areEqual(this.controlAction, ((IotCardTemplatePublisherWrapper) other).controlAction);
    }

    public final IotCardTemplateActionWrapper getControlAction() {
        return this.controlAction;
    }

    public int hashCode() {
        return this.controlAction.hashCode();
    }

    public String toString() {
        return "IotCardTemplatePublisherWrapper(controlAction=" + this.controlAction + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeBundle(this.controlAction.getDataBundle());
    }
}
