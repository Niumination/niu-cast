package com.transsion.iotservice.multiscreen.pc.bean;

import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;", "", "defaultText", "", "remotetext", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDefaultText", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRemotetext", "()Ljava/lang/String;", "setRemotetext", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;", "equals", "", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TextBean {

    @SerializedName("defaultText")
    private final Integer defaultText;

    @SerializedName("remotetext")
    private String remotetext;

    public TextBean(@StringRes Integer num, String str) {
        this.defaultText = num;
        this.remotetext = str;
    }

    public static /* synthetic */ TextBean copy$default(TextBean textBean, Integer num, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            num = textBean.defaultText;
        }
        if ((i8 & 2) != 0) {
            str = textBean.remotetext;
        }
        return textBean.copy(num, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getDefaultText() {
        return this.defaultText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRemotetext() {
        return this.remotetext;
    }

    public final TextBean copy(@StringRes Integer defaultText, String remotetext) {
        return new TextBean(defaultText, remotetext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextBean)) {
            return false;
        }
        TextBean textBean = (TextBean) other;
        return Intrinsics.areEqual(this.defaultText, textBean.defaultText) && Intrinsics.areEqual(this.remotetext, textBean.remotetext);
    }

    public final Integer getDefaultText() {
        return this.defaultText;
    }

    public final String getRemotetext() {
        return this.remotetext;
    }

    public int hashCode() {
        Integer num = this.defaultText;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.remotetext;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setRemotetext(String str) {
        this.remotetext = str;
    }

    public String toString() {
        return "TextBean(defaultText=" + this.defaultText + ", remotetext=" + this.remotetext + ")";
    }
}
