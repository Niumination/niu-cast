package com.transsion.atomiccore.common.bean;

import a1.a;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/transsion/atomiccore/common/bean/EntryConfig;", "", "entry", "", "shownWhenLocked", "", "removeAfterReboot", "exposureDuration", "", "sizeList", "", "(Ljava/lang/String;IIJLjava/util/List;)V", "getEntry", "()Ljava/lang/String;", "getExposureDuration", "()J", "getRemoveAfterReboot", "()I", "getShownWhenLocked", "getSizeList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "SharedCommon_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class EntryConfig {
    private final String entry;
    private final long exposureDuration;
    private final int removeAfterReboot;
    private final int shownWhenLocked;
    private final List<String> sizeList;

    public EntryConfig(String entry, int i8, int i9, long j8, List<String> sizeList) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(sizeList, "sizeList");
        this.entry = entry;
        this.shownWhenLocked = i8;
        this.removeAfterReboot = i9;
        this.exposureDuration = j8;
        this.sizeList = sizeList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntryConfig copy$default(EntryConfig entryConfig, String str, int i8, int i9, long j8, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = entryConfig.entry;
        }
        if ((i10 & 2) != 0) {
            i8 = entryConfig.shownWhenLocked;
        }
        int i11 = i8;
        if ((i10 & 4) != 0) {
            i9 = entryConfig.removeAfterReboot;
        }
        int i12 = i9;
        if ((i10 & 8) != 0) {
            j8 = entryConfig.exposureDuration;
        }
        long j10 = j8;
        if ((i10 & 16) != 0) {
            list = entryConfig.sizeList;
        }
        return entryConfig.copy(str, i11, i12, j10, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEntry() {
        return this.entry;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getShownWhenLocked() {
        return this.shownWhenLocked;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRemoveAfterReboot() {
        return this.removeAfterReboot;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getExposureDuration() {
        return this.exposureDuration;
    }

    public final List<String> component5() {
        return this.sizeList;
    }

    public final EntryConfig copy(String entry, int shownWhenLocked, int removeAfterReboot, long exposureDuration, List<String> sizeList) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(sizeList, "sizeList");
        return new EntryConfig(entry, shownWhenLocked, removeAfterReboot, exposureDuration, sizeList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntryConfig)) {
            return false;
        }
        EntryConfig entryConfig = (EntryConfig) other;
        return Intrinsics.areEqual(this.entry, entryConfig.entry) && this.shownWhenLocked == entryConfig.shownWhenLocked && this.removeAfterReboot == entryConfig.removeAfterReboot && this.exposureDuration == entryConfig.exposureDuration && Intrinsics.areEqual(this.sizeList, entryConfig.sizeList);
    }

    public final String getEntry() {
        return this.entry;
    }

    public final long getExposureDuration() {
        return this.exposureDuration;
    }

    public final int getRemoveAfterReboot() {
        return this.removeAfterReboot;
    }

    public final int getShownWhenLocked() {
        return this.shownWhenLocked;
    }

    public final List<String> getSizeList() {
        return this.sizeList;
    }

    public int hashCode() {
        return this.sizeList.hashCode() + a.f(this.exposureDuration, a.c(this.removeAfterReboot, a.c(this.shownWhenLocked, this.entry.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        return "EntryConfig(entry=" + this.entry + ", shownWhenLocked=" + this.shownWhenLocked + ", removeAfterReboot=" + this.removeAfterReboot + ", exposureDuration=" + this.exposureDuration + ", sizeList=" + this.sizeList + ")";
    }

    public /* synthetic */ EntryConfig(String str, int i8, int i9, long j8, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? -1 : i8, (i10 & 4) != 0 ? 0 : i9, j8, list);
    }
}
