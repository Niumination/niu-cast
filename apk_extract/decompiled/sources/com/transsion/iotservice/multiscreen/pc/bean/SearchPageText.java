package com.transsion.iotservice.multiscreen.pc.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/SearchPageText;", "", "text", "Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;", "link", "isDefault", "", "<init>", "(Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;Z)V", "getText", "()Lcom/transsion/iotservice/multiscreen/pc/bean/TextBean;", "getLink", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SearchPageText {

    @SerializedName("isDefault")
    private final boolean isDefault;

    @SerializedName("link")
    private final TextBean link;

    @SerializedName("text")
    private final TextBean text;

    public SearchPageText(TextBean text, TextBean link, boolean z2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(link, "link");
        this.text = text;
        this.link = link;
        this.isDefault = z2;
    }

    public static /* synthetic */ SearchPageText copy$default(SearchPageText searchPageText, TextBean textBean, TextBean textBean2, boolean z2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            textBean = searchPageText.text;
        }
        if ((i8 & 2) != 0) {
            textBean2 = searchPageText.link;
        }
        if ((i8 & 4) != 0) {
            z2 = searchPageText.isDefault;
        }
        return searchPageText.copy(textBean, textBean2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextBean getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TextBean getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public final SearchPageText copy(TextBean text, TextBean link, boolean isDefault) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(link, "link");
        return new SearchPageText(text, link, isDefault);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchPageText)) {
            return false;
        }
        SearchPageText searchPageText = (SearchPageText) other;
        return Intrinsics.areEqual(this.text, searchPageText.text) && Intrinsics.areEqual(this.link, searchPageText.link) && this.isDefault == searchPageText.isDefault;
    }

    public final TextBean getLink() {
        return this.link;
    }

    public final TextBean getText() {
        return this.text;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isDefault) + ((this.link.hashCode() + (this.text.hashCode() * 31)) * 31);
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public String toString() {
        return "SearchPageText(text=" + this.text + ", link=" + this.link + ", isDefault=" + this.isDefault + ")";
    }

    public /* synthetic */ SearchPageText(TextBean textBean, TextBean textBean2, boolean z2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(textBean, textBean2, (i8 & 4) != 0 ? true : z2);
    }
}
