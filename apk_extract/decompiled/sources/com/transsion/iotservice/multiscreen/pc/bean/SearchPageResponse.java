package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/SearchPageResponse;", "", "version", "", "info", "", "link", "lang", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVersion", "()I", "getInfo", "()Ljava/lang/String;", "getLink", "getLang", "setLang", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SearchPageResponse {

    @SerializedName("info")
    private final String info;

    @SerializedName("lang")
    private String lang;

    @SerializedName("link")
    private final String link;

    @SerializedName("version")
    private final int version;

    public SearchPageResponse(int i8, String info, String link, String lang) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(lang, "lang");
        this.version = i8;
        this.info = info;
        this.link = link;
        this.lang = lang;
    }

    public static /* synthetic */ SearchPageResponse copy$default(SearchPageResponse searchPageResponse, int i8, String str, String str2, String str3, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = searchPageResponse.version;
        }
        if ((i9 & 2) != 0) {
            str = searchPageResponse.info;
        }
        if ((i9 & 4) != 0) {
            str2 = searchPageResponse.link;
        }
        if ((i9 & 8) != 0) {
            str3 = searchPageResponse.lang;
        }
        return searchPageResponse.copy(i8, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    public final SearchPageResponse copy(int version, String info, String link, String lang) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(lang, "lang");
        return new SearchPageResponse(version, info, link, lang);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchPageResponse)) {
            return false;
        }
        SearchPageResponse searchPageResponse = (SearchPageResponse) other;
        return this.version == searchPageResponse.version && Intrinsics.areEqual(this.info, searchPageResponse.info) && Intrinsics.areEqual(this.link, searchPageResponse.link) && Intrinsics.areEqual(this.lang, searchPageResponse.lang);
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.lang.hashCode() + a.e(a.e(Integer.hashCode(this.version) * 31, 31, this.info), 31, this.link);
    }

    public final void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public String toString() {
        return "SearchPageResponse(version=" + this.version + ", info=" + this.info + ", link=" + this.link + ", lang=" + this.lang + ")";
    }

    public /* synthetic */ SearchPageResponse(int i8, String str, String str2, String str3, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8, str, str2, (i9 & 8) != 0 ? "zh" : str3);
    }
}
