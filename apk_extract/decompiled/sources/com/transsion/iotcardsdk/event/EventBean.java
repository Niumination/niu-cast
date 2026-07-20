package com.transsion.iotcardsdk.event;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotcardsdk.bean.IotCardTemplateBean;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/transsion/iotcardsdk/event/EventBean;", "Ljava/io/Serializable;", "eventTypeId", "", "deviceBean", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "(ILcom/transsion/iotcardsdk/bean/IotCardTemplateBean;)V", "getDeviceBean", "()Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "getEventTypeId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class EventBean implements Serializable {
    private final IotCardTemplateBean deviceBean;
    private final int eventTypeId;

    public EventBean(int i8, IotCardTemplateBean deviceBean) {
        Intrinsics.checkNotNullParameter(deviceBean, "deviceBean");
        this.eventTypeId = i8;
        this.deviceBean = deviceBean;
    }

    public static /* synthetic */ EventBean copy$default(EventBean eventBean, int i8, IotCardTemplateBean iotCardTemplateBean, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = eventBean.eventTypeId;
        }
        if ((i9 & 2) != 0) {
            iotCardTemplateBean = eventBean.deviceBean;
        }
        return eventBean.copy(i8, iotCardTemplateBean);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEventTypeId() {
        return this.eventTypeId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IotCardTemplateBean getDeviceBean() {
        return this.deviceBean;
    }

    public final EventBean copy(int eventTypeId, IotCardTemplateBean deviceBean) {
        Intrinsics.checkNotNullParameter(deviceBean, "deviceBean");
        return new EventBean(eventTypeId, deviceBean);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventBean)) {
            return false;
        }
        EventBean eventBean = (EventBean) other;
        return this.eventTypeId == eventBean.eventTypeId && Intrinsics.areEqual(this.deviceBean, eventBean.deviceBean);
    }

    public final IotCardTemplateBean getDeviceBean() {
        return this.deviceBean;
    }

    public final int getEventTypeId() {
        return this.eventTypeId;
    }

    public int hashCode() {
        return this.deviceBean.hashCode() + (Integer.hashCode(this.eventTypeId) * 31);
    }

    public String toString() {
        return "EventBean(eventTypeId=" + this.eventTypeId + ", deviceBean=" + this.deviceBean + ")";
    }

    public /* synthetic */ EventBean(int i8, IotCardTemplateBean iotCardTemplateBean, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 0 : i8, iotCardTemplateBean);
    }
}
