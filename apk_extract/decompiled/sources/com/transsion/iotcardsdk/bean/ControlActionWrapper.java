package com.transsion.iotcardsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\t\u0010\u0010\u001a\u00020\nHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/transsion/iotcardsdk/bean/ControlActionWrapper;", "Landroid/os/Parcelable;", "controlAction", "Lcom/transsion/iotcardsdk/bean/ControlAction;", "(Lcom/transsion/iotcardsdk/bean/ControlAction;)V", "getControlAction", "()Lcom/transsion/iotcardsdk/bean/ControlAction;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getWrappedAction", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class ControlActionWrapper implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ControlAction controlAction;

    /* JADX INFO: renamed from: com.transsion.iotcardsdk.bean.ControlActionWrapper$CREATOR, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/iotcardsdk/bean/ControlActionWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/transsion/iotcardsdk/bean/ControlActionWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/transsion/iotcardsdk/bean/ControlActionWrapper;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion implements Parcelable.Creator<ControlActionWrapper> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ControlActionWrapper createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ControlAction controlActionCreateActionFromBundle = ControlAction.INSTANCE.createActionFromBundle(parcel.readBundle());
            Intrinsics.checkNotNull(controlActionCreateActionFromBundle);
            return new ControlActionWrapper(controlActionCreateActionFromBundle);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ControlActionWrapper[] newArray(int size) {
            return new ControlActionWrapper[size];
        }
    }

    public ControlActionWrapper(ControlAction controlAction) {
        Intrinsics.checkNotNullParameter(controlAction, "controlAction");
        this.controlAction = controlAction;
    }

    public static /* synthetic */ ControlActionWrapper copy$default(ControlActionWrapper controlActionWrapper, ControlAction controlAction, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            controlAction = controlActionWrapper.controlAction;
        }
        return controlActionWrapper.copy(controlAction);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ControlAction getControlAction() {
        return this.controlAction;
    }

    public final ControlActionWrapper copy(ControlAction controlAction) {
        Intrinsics.checkNotNullParameter(controlAction, "controlAction");
        return new ControlActionWrapper(controlAction);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ControlActionWrapper) && Intrinsics.areEqual(this.controlAction, ((ControlActionWrapper) other).controlAction);
    }

    public final ControlAction getControlAction() {
        return this.controlAction;
    }

    public final ControlAction getWrappedAction() {
        return this.controlAction;
    }

    public int hashCode() {
        return this.controlAction.hashCode();
    }

    public String toString() {
        return "ControlActionWrapper(controlAction=" + this.controlAction + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeBundle(this.controlAction.getDataBundle());
    }
}
