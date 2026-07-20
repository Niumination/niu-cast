package com.transsion.iotservice.multiscreen.pc.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/SearchPageRequest;", "", "lang", "", MessageBank.KEY_TYPE, "", "<init>", "(Ljava/lang/String;I)V", "getLang", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SearchPageRequest {

    @SerializedName("lang")
    private final String lang;

    @SerializedName(MessageBank.KEY_TYPE)
    private final int type;

    public SearchPageRequest(String lang, int i8) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        this.lang = lang;
        this.type = i8;
    }

    public static /* synthetic */ SearchPageRequest copy$default(SearchPageRequest searchPageRequest, String str, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = searchPageRequest.lang;
        }
        if ((i9 & 2) != 0) {
            i8 = searchPageRequest.type;
        }
        return searchPageRequest.copy(str, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final SearchPageRequest copy(String lang, int type) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        return new SearchPageRequest(lang, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchPageRequest)) {
            return false;
        }
        SearchPageRequest searchPageRequest = (SearchPageRequest) other;
        return Intrinsics.areEqual(this.lang, searchPageRequest.lang) && this.type == searchPageRequest.type;
    }

    public final String getLang() {
        return this.lang;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.type) + (this.lang.hashCode() * 31);
    }

    public String toString() {
        return "SearchPageRequest(lang=" + this.lang + ", type=" + this.type + ")";
    }
}
