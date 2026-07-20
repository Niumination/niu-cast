package com.transsion.sdk.oneid.data;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UniqueIdInfo extends OneBaseInfo implements Serializable {
    public String oaid;
    public String opid;
    public String tsid;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.os.Handler$Callback] */
    /* JADX WARN: Type inference failed for: r15v35, types: [android.os.Handler$Callback] */
    /* JADX WARN: Type inference failed for: r15v9, types: [boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a9 -> B:114:0x00b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ab -> B:114:0x00b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:36:0x00af
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @b.a({"HardwareIds"})
    public UniqueIdInfo(android.content.Context r14, android.os.Handler.Callback r15) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.sdk.oneid.data.UniqueIdInfo.<init>(android.content.Context, android.os.Handler$Callback):void");
    }
}
