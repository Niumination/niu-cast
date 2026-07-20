package com.transsion.atomiccore.common.bean;

import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import b7.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\b\u0007\b\u0087\b\u0018\u0000 a2\u00020\u0001:\u0001bBÉ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001fJ\u0010\u0010$\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b$\u0010!J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001fJ\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u001fJ\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u001fJ\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b*\u0010)J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u001fJ\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001fJ\u0010\u0010-\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b-\u0010!J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u001fJ\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010\u001fJ\u0010\u00100\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b0\u0010!J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b1\u0010)J\u0010\u00102\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b2\u0010\u001fJ\u0010\u00103\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b5\u0010\u001fJ\u0010\u00106\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b6\u0010\u001fJ\u0010\u00107\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b7\u00104Jþ\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00042\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b:\u0010\u001fJ\u0010\u0010;\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b;\u00104J\u001a\u0010>\u001a\u00020=2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b>\u0010?R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010@\u001a\u0004\bA\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010B\u001a\u0004\bC\u0010!R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010@\u001a\u0004\bD\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010@\u001a\u0004\bE\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010B\u001a\u0004\bF\u0010!R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010@\u001a\u0004\bG\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010@\u001a\u0004\bH\u0010\u001fR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010@\u001a\u0004\bI\u0010\u001fR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010J\u001a\u0004\bK\u0010)R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010J\u001a\u0004\bL\u0010)R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010@\u001a\u0004\bM\u0010\u001fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010@\u001a\u0004\bN\u0010\u001fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010B\u001a\u0004\bO\u0010!R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010@\u001a\u0004\bP\u0010\u001fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010@\u001a\u0004\bQ\u0010\u001fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010B\u001a\u0004\bR\u0010!R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010J\u001a\u0004\bS\u0010)R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010@\u001a\u0004\bT\u0010\u001fR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010U\u001a\u0004\bV\u00104\"\u0004\bW\u0010XR\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010@\u001a\u0004\bY\u0010\u001fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010@\u001a\u0004\bZ\u0010\u001fR\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001b\u0010U\u001a\u0004\b[\u00104R*\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010J\u001a\u0004\b^\u0010)\"\u0004\b_\u0010`¨\u0006c"}, d2 = {"Lcom/transsion/atomiccore/common/bean/TpkConfig;", "", "", "serviceId", "", "dataVersion", "pkg", "version", "versionCode", "name", "description", "intentSubDomain", "", "intentIds", "supportEntry", "hostPackageName", "hostComponentName", "hostMinVersion", "entryConfig", "click", "minAtomicVersion", "multiPages", "extras", "", "enableStatus", "subGroupKey", "switchKey", "serviceCategory", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "component1", "()Ljava/lang/String;", "component2", "()J", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "()Ljava/util/List;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "()I", "component20", "component21", "component22", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Lcom/transsion/atomiccore/common/bean/TpkConfig;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getServiceId", "J", "getDataVersion", "getPkg", "getVersion", "getVersionCode", "getName", "getDescription", "getIntentSubDomain", "Ljava/util/List;", "getIntentIds", "getSupportEntry", "getHostPackageName", "getHostComponentName", "getHostMinVersion", "getEntryConfig", "getClick", "getMinAtomicVersion", "getMultiPages", "getExtras", "I", "getEnableStatus", "setEnableStatus", "(I)V", "getSubGroupKey", "getSwitchKey", "getServiceCategory", "", "supportActions", "getSupportActions", "setSupportActions", "(Ljava/util/List;)V", "Companion", "b7/a", "SharedCommon_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TpkConfig {
    public static final a Companion = new a();
    public static final int SERVICE_TYPE_STANDARD_WIDGET = 2;
    public static final int SERVICE_TYPE_TPK = 1;
    private final String click;
    private final long dataVersion;
    private final String description;
    private int enableStatus;
    private final String entryConfig;
    private final String extras;
    private final String hostComponentName;
    private final long hostMinVersion;
    private final String hostPackageName;
    private final List<String> intentIds;
    private final String intentSubDomain;
    private final long minAtomicVersion;
    private final List<String> multiPages;
    private final String name;
    private final String pkg;
    private final int serviceCategory;
    private final String serviceId;
    private final String subGroupKey;
    private List<Object> supportActions;
    private final List<String> supportEntry;
    private final String switchKey;
    private final String version;
    private final long versionCode;

    public TpkConfig(String serviceId, long j8, String pkg, String version, long j10, String name, String description, String intentSubDomain, List<String> intentIds, List<String> supportEntry, String hostPackageName, String hostComponentName, long j11, String entryConfig, String click, long j12, List<String> multiPages, String extras, int i8, String subGroupKey, String switchKey, int i9) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(intentSubDomain, "intentSubDomain");
        Intrinsics.checkNotNullParameter(intentIds, "intentIds");
        Intrinsics.checkNotNullParameter(supportEntry, "supportEntry");
        Intrinsics.checkNotNullParameter(hostPackageName, "hostPackageName");
        Intrinsics.checkNotNullParameter(hostComponentName, "hostComponentName");
        Intrinsics.checkNotNullParameter(entryConfig, "entryConfig");
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(multiPages, "multiPages");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(subGroupKey, "subGroupKey");
        Intrinsics.checkNotNullParameter(switchKey, "switchKey");
        this.serviceId = serviceId;
        this.dataVersion = j8;
        this.pkg = pkg;
        this.version = version;
        this.versionCode = j10;
        this.name = name;
        this.description = description;
        this.intentSubDomain = intentSubDomain;
        this.intentIds = intentIds;
        this.supportEntry = supportEntry;
        this.hostPackageName = hostPackageName;
        this.hostComponentName = hostComponentName;
        this.hostMinVersion = j11;
        this.entryConfig = entryConfig;
        this.click = click;
        this.minAtomicVersion = j12;
        this.multiPages = multiPages;
        this.extras = extras;
        this.enableStatus = i8;
        this.subGroupKey = subGroupKey;
        this.switchKey = switchKey;
        this.serviceCategory = i9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TpkConfig copy$default(TpkConfig tpkConfig, String str, long j8, String str2, String str3, long j10, String str4, String str5, String str6, List list, List list2, String str7, String str8, long j11, String str9, String str10, long j12, List list3, String str11, int i8, String str12, String str13, int i9, int i10, Object obj) {
        String str14 = (i10 & 1) != 0 ? tpkConfig.serviceId : str;
        long j13 = (i10 & 2) != 0 ? tpkConfig.dataVersion : j8;
        String str15 = (i10 & 4) != 0 ? tpkConfig.pkg : str2;
        String str16 = (i10 & 8) != 0 ? tpkConfig.version : str3;
        long j14 = (i10 & 16) != 0 ? tpkConfig.versionCode : j10;
        String str17 = (i10 & 32) != 0 ? tpkConfig.name : str4;
        String str18 = (i10 & 64) != 0 ? tpkConfig.description : str5;
        String str19 = (i10 & 128) != 0 ? tpkConfig.intentSubDomain : str6;
        List list4 = (i10 & 256) != 0 ? tpkConfig.intentIds : list;
        List list5 = (i10 & 512) != 0 ? tpkConfig.supportEntry : list2;
        String str20 = (i10 & 1024) != 0 ? tpkConfig.hostPackageName : str7;
        return tpkConfig.copy(str14, j13, str15, str16, j14, str17, str18, str19, list4, list5, str20, (i10 & 2048) != 0 ? tpkConfig.hostComponentName : str8, (i10 & 4096) != 0 ? tpkConfig.hostMinVersion : j11, (i10 & 8192) != 0 ? tpkConfig.entryConfig : str9, (i10 & 16384) != 0 ? tpkConfig.click : str10, (i10 & 32768) != 0 ? tpkConfig.minAtomicVersion : j12, (i10 & 65536) != 0 ? tpkConfig.multiPages : list3, (131072 & i10) != 0 ? tpkConfig.extras : str11, (i10 & 262144) != 0 ? tpkConfig.enableStatus : i8, (i10 & 524288) != 0 ? tpkConfig.subGroupKey : str12, (i10 & 1048576) != 0 ? tpkConfig.switchKey : str13, (i10 & 2097152) != 0 ? tpkConfig.serviceCategory : i9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    public final List<String> component10() {
        return this.supportEntry;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getHostPackageName() {
        return this.hostPackageName;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getHostComponentName() {
        return this.hostComponentName;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getHostMinVersion() {
        return this.hostMinVersion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getEntryConfig() {
        return this.entryConfig;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getClick() {
        return this.click;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getMinAtomicVersion() {
        return this.minAtomicVersion;
    }

    public final List<String> component17() {
        return this.multiPages;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getExtras() {
        return this.extras;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getEnableStatus() {
        return this.enableStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDataVersion() {
        return this.dataVersion;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getSubGroupKey() {
        return this.subGroupKey;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getSwitchKey() {
        return this.switchKey;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getServiceCategory() {
        return this.serviceCategory;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPkg() {
        return this.pkg;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIntentSubDomain() {
        return this.intentSubDomain;
    }

    public final List<String> component9() {
        return this.intentIds;
    }

    public final TpkConfig copy(String serviceId, long dataVersion, String pkg, String version, long versionCode, String name, String description, String intentSubDomain, List<String> intentIds, List<String> supportEntry, String hostPackageName, String hostComponentName, long hostMinVersion, String entryConfig, String click, long minAtomicVersion, List<String> multiPages, String extras, int enableStatus, String subGroupKey, String switchKey, int serviceCategory) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(intentSubDomain, "intentSubDomain");
        Intrinsics.checkNotNullParameter(intentIds, "intentIds");
        Intrinsics.checkNotNullParameter(supportEntry, "supportEntry");
        Intrinsics.checkNotNullParameter(hostPackageName, "hostPackageName");
        Intrinsics.checkNotNullParameter(hostComponentName, "hostComponentName");
        Intrinsics.checkNotNullParameter(entryConfig, "entryConfig");
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(multiPages, "multiPages");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(subGroupKey, "subGroupKey");
        Intrinsics.checkNotNullParameter(switchKey, "switchKey");
        return new TpkConfig(serviceId, dataVersion, pkg, version, versionCode, name, description, intentSubDomain, intentIds, supportEntry, hostPackageName, hostComponentName, hostMinVersion, entryConfig, click, minAtomicVersion, multiPages, extras, enableStatus, subGroupKey, switchKey, serviceCategory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TpkConfig)) {
            return false;
        }
        TpkConfig tpkConfig = (TpkConfig) other;
        return Intrinsics.areEqual(this.serviceId, tpkConfig.serviceId) && this.dataVersion == tpkConfig.dataVersion && Intrinsics.areEqual(this.pkg, tpkConfig.pkg) && Intrinsics.areEqual(this.version, tpkConfig.version) && this.versionCode == tpkConfig.versionCode && Intrinsics.areEqual(this.name, tpkConfig.name) && Intrinsics.areEqual(this.description, tpkConfig.description) && Intrinsics.areEqual(this.intentSubDomain, tpkConfig.intentSubDomain) && Intrinsics.areEqual(this.intentIds, tpkConfig.intentIds) && Intrinsics.areEqual(this.supportEntry, tpkConfig.supportEntry) && Intrinsics.areEqual(this.hostPackageName, tpkConfig.hostPackageName) && Intrinsics.areEqual(this.hostComponentName, tpkConfig.hostComponentName) && this.hostMinVersion == tpkConfig.hostMinVersion && Intrinsics.areEqual(this.entryConfig, tpkConfig.entryConfig) && Intrinsics.areEqual(this.click, tpkConfig.click) && this.minAtomicVersion == tpkConfig.minAtomicVersion && Intrinsics.areEqual(this.multiPages, tpkConfig.multiPages) && Intrinsics.areEqual(this.extras, tpkConfig.extras) && this.enableStatus == tpkConfig.enableStatus && Intrinsics.areEqual(this.subGroupKey, tpkConfig.subGroupKey) && Intrinsics.areEqual(this.switchKey, tpkConfig.switchKey) && this.serviceCategory == tpkConfig.serviceCategory;
    }

    public final String getClick() {
        return this.click;
    }

    public final long getDataVersion() {
        return this.dataVersion;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getEnableStatus() {
        return this.enableStatus;
    }

    public final String getEntryConfig() {
        return this.entryConfig;
    }

    public final String getExtras() {
        return this.extras;
    }

    public final String getHostComponentName() {
        return this.hostComponentName;
    }

    public final long getHostMinVersion() {
        return this.hostMinVersion;
    }

    public final String getHostPackageName() {
        return this.hostPackageName;
    }

    public final List<String> getIntentIds() {
        return this.intentIds;
    }

    public final String getIntentSubDomain() {
        return this.intentSubDomain;
    }

    public final long getMinAtomicVersion() {
        return this.minAtomicVersion;
    }

    public final List<String> getMultiPages() {
        return this.multiPages;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final int getServiceCategory() {
        return this.serviceCategory;
    }

    public final String getServiceId() {
        return this.serviceId;
    }

    public final String getSubGroupKey() {
        return this.subGroupKey;
    }

    public final List<Object> getSupportActions() {
        return this.supportActions;
    }

    public final List<String> getSupportEntry() {
        return this.supportEntry;
    }

    public final String getSwitchKey() {
        return this.switchKey;
    }

    public final String getVersion() {
        return this.version;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return Integer.hashCode(this.serviceCategory) + a1.a.e(a1.a.e(a1.a.c(this.enableStatus, a1.a.e((this.multiPages.hashCode() + a1.a.f(this.minAtomicVersion, a1.a.e(a1.a.e(a1.a.f(this.hostMinVersion, a1.a.e(a1.a.e((this.supportEntry.hashCode() + ((this.intentIds.hashCode() + a1.a.e(a1.a.e(a1.a.e(a1.a.f(this.versionCode, a1.a.e(a1.a.e(a1.a.f(this.dataVersion, this.serviceId.hashCode() * 31, 31), 31, this.pkg), 31, this.version), 31), 31, this.name), 31, this.description), 31, this.intentSubDomain)) * 31)) * 31, 31, this.hostPackageName), 31, this.hostComponentName), 31), 31, this.entryConfig), 31, this.click), 31)) * 31, 31, this.extras), 31), 31, this.subGroupKey), 31, this.switchKey);
    }

    public final void setEnableStatus(int i8) {
        this.enableStatus = i8;
    }

    public final void setSupportActions(List<Object> list) {
        this.supportActions = list;
    }

    public String toString() {
        String str = this.serviceId;
        long j8 = this.dataVersion;
        String str2 = this.pkg;
        String str3 = this.version;
        long j10 = this.versionCode;
        String str4 = this.name;
        String str5 = this.description;
        String str6 = this.intentSubDomain;
        List<String> list = this.intentIds;
        List<String> list2 = this.supportEntry;
        String str7 = this.hostPackageName;
        String str8 = this.hostComponentName;
        long j11 = this.hostMinVersion;
        String str9 = this.entryConfig;
        String str10 = this.click;
        long j12 = this.minAtomicVersion;
        List<String> list3 = this.multiPages;
        String str11 = this.extras;
        int i8 = this.enableStatus;
        String str12 = this.subGroupKey;
        String str13 = this.switchKey;
        int i9 = this.serviceCategory;
        StringBuilder sb2 = new StringBuilder("TpkConfig(serviceId=");
        sb2.append(str);
        sb2.append(", dataVersion=");
        sb2.append(j8);
        d.A(sb2, ", pkg=", str2, ", version=", str3);
        sb2.append(", versionCode=");
        sb2.append(j10);
        sb2.append(", name=");
        d.A(sb2, str4, ", description=", str5, ", intentSubDomain=");
        sb2.append(str6);
        sb2.append(", intentIds=");
        sb2.append(list);
        sb2.append(", supportEntry=");
        sb2.append(list2);
        sb2.append(", hostPackageName=");
        sb2.append(str7);
        sb2.append(", hostComponentName=");
        sb2.append(str8);
        sb2.append(", hostMinVersion=");
        sb2.append(j11);
        d.A(sb2, ", entryConfig=", str9, ", click=", str10);
        sb2.append(", minAtomicVersion=");
        sb2.append(j12);
        sb2.append(", multiPages=");
        sb2.append(list3);
        sb2.append(", extras=");
        sb2.append(str11);
        sb2.append(", enableStatus=");
        sb2.append(i8);
        sb2.append(", subGroupKey=");
        sb2.append(str12);
        sb2.append(", switchKey=");
        sb2.append(str13);
        sb2.append(", serviceCategory=");
        sb2.append(i9);
        sb2.append(")");
        return sb2.toString();
    }
}
