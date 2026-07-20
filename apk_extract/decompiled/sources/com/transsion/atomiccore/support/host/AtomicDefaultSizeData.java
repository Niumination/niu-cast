package com.transsion.atomiccore.support.host;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import k7.d;
import k7.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AtomicDefaultSizeData {
    private final AtomicAction clickAction;
    private final int endFrameStartIndex;
    private final int endLoopTimes;
    private final int endStatus;
    private final d imageIcon1;
    private final d imageIcon2;
    private final d imageIcon3;
    private final d imageIconEnd;
    private final d imageIconStart;
    private final d imageIslandError;
    private final d imageIslandLargeIcon;
    private final d imageIslandTranslating;
    private final AtomicAction longClickAction;
    private final AtomicLayoutData mContentLayoutData;
    private final int mProgress;
    private final int mProgressMax;
    private final boolean mSeekAvailable;
    private final long mStartActionTime;
    private final AtomicLayoutData mStartIconLayoutData;
    private final AtomicLayoutData mSubtitleLayoutData;
    private final AtomicLayoutData mTitleLayoutData;
    private final String originalContent;
    private final String originalLanguage;
    private final String resPackageName;
    private final int secondaryColor;
    private final int secondaryColorTime;
    private final int startFrameStartIndex;
    private final int startLoopTimes;
    private final int startStatus;
    private final int status;
    private final String subTitleExtra;
    private final d subTitleIcon;
    private final String subtitle;
    private final String subtitleFormat;
    private final int subtitleType;
    private final String targetContent;
    private final String targetLanguage;
    private final String title;
    private final String titleFormat;
    private final int titleType;
    private final String translateError;

    public /* synthetic */ AtomicDefaultSizeData(e eVar, int i8) {
        this(eVar);
    }

    @Nullable
    public AtomicAction getClickAction() {
        return this.clickAction;
    }

    public AtomicLayoutData getContentLayoutData() {
        return this.mContentLayoutData;
    }

    public int getEndFrameStartIndex() {
        return this.endFrameStartIndex;
    }

    public int getEndLoopTimes() {
        return this.endLoopTimes;
    }

    public int getEndStatus() {
        return this.endStatus;
    }

    @Nullable
    public d getImageIcon1() {
        return this.imageIcon1;
    }

    @Nullable
    public d getImageIcon2() {
        return this.imageIcon2;
    }

    @Nullable
    public d getImageIcon3() {
        return this.imageIcon3;
    }

    @Nullable
    public d getImageIconEnd() {
        return this.imageIconEnd;
    }

    @Nullable
    public d getImageIconStart() {
        return this.imageIconStart;
    }

    @Nullable
    public d getImageIslandError() {
        return this.imageIslandError;
    }

    @Nullable
    public d getImageIslandLargeIcon() {
        return this.imageIslandLargeIcon;
    }

    @Nullable
    public d getImageIslandTranslating() {
        return this.imageIslandTranslating;
    }

    @Nullable
    public AtomicAction getLongClickAction() {
        return this.longClickAction;
    }

    @Nullable
    public String getOriginalContent() {
        return this.originalContent;
    }

    @Nullable
    public String getOriginalLanguage() {
        return this.originalLanguage;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getProgressMax() {
        return this.mProgressMax;
    }

    public String getResPackageName() {
        return this.resPackageName;
    }

    public int getSecondaryColor() {
        return this.secondaryColor;
    }

    public int getSecondaryColorTime() {
        return this.secondaryColorTime;
    }

    public long getStartActionTime() {
        return this.mStartActionTime;
    }

    public int getStartFrameStartIndex() {
        return this.startFrameStartIndex;
    }

    public AtomicLayoutData getStartIconLayoutData() {
        return this.mStartIconLayoutData;
    }

    public int getStartLoopTimes() {
        return this.startLoopTimes;
    }

    public int getStartStatus() {
        return this.startStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSubTitleExtra() {
        return this.subTitleExtra;
    }

    public d getSubTitleIcon() {
        return this.subTitleIcon;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getSubtitleFormat() {
        return this.subtitleFormat;
    }

    public AtomicLayoutData getSubtitleLayoutData() {
        return this.mSubtitleLayoutData;
    }

    public int getSubtitleType() {
        return this.subtitleType;
    }

    @Nullable
    public String getTargetContent() {
        return this.targetContent;
    }

    @Nullable
    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleFormat() {
        return this.titleFormat;
    }

    public AtomicLayoutData getTitleLayoutData() {
        return this.mTitleLayoutData;
    }

    public int getTitleType() {
        return this.titleType;
    }

    @Nullable
    public String getTranslateError() {
        return this.translateError;
    }

    public boolean isSeekAvailable() {
        return this.mSeekAvailable;
    }

    @NonNull
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("titleType", this.titleType);
            jSONObject.put("subtitle", this.subtitle);
            jSONObject.put("subtitleType", this.subtitleType);
            String str = this.titleFormat;
            if (str != null) {
                jSONObject.put("titleFormat", str);
            }
            String str2 = this.subtitleFormat;
            if (str2 != null) {
                jSONObject.put("subtitleFormat", str2);
            }
            d dVar = this.imageIcon1;
            if (dVar != null) {
                jSONObject.put("imageIcon1", dVar.a());
            }
            d dVar2 = this.imageIcon2;
            if (dVar2 != null) {
                jSONObject.put("imageIcon2", dVar2.a());
            }
            d dVar3 = this.imageIcon3;
            if (dVar3 != null) {
                jSONObject.put("imageIcon3", dVar3.a());
            }
            d dVar4 = this.imageIconStart;
            if (dVar4 != null) {
                jSONObject.put("imageIconStart", dVar4.a());
            }
            d dVar5 = this.imageIconEnd;
            if (dVar5 != null) {
                jSONObject.put("imageIconEnd", dVar5.a());
            }
            d dVar6 = this.imageIslandLargeIcon;
            if (dVar6 != null) {
                jSONObject.put("image_island_large_icon", dVar6.a());
            }
            d dVar7 = this.imageIslandTranslating;
            if (dVar7 != null) {
                jSONObject.put("image_island_translating", dVar7.a());
            }
            d dVar8 = this.imageIslandError;
            if (dVar8 != null) {
                jSONObject.put("image_island_error", dVar8.a());
            }
            String str3 = this.originalLanguage;
            if (str3 != null) {
                jSONObject.put("original_language", str3);
            }
            String str4 = this.originalContent;
            if (str4 != null) {
                jSONObject.put("original_content", str4);
            }
            String str5 = this.targetLanguage;
            if (str5 != null) {
                jSONObject.put("target_language", str5);
            }
            String str6 = this.targetContent;
            if (str6 != null) {
                jSONObject.put("target_content", str6);
            }
            String str7 = this.translateError;
            if (str7 != null) {
                jSONObject.put("translate_error", str7);
            }
            int i8 = this.status;
            if (i8 != 0) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, i8);
            }
            int i9 = this.endFrameStartIndex;
            if (i9 != 0) {
                jSONObject.put("end_frame_start_index", i9);
            }
            int i10 = this.endLoopTimes;
            if (i10 != 0) {
                jSONObject.put("end_loop_times", i10);
            }
            int i11 = this.startFrameStartIndex;
            if (i11 != 0) {
                jSONObject.put("start_frame_start_index", i11);
            }
            int i12 = this.startLoopTimes;
            if (i12 != 0) {
                jSONObject.put("start_loop_times", i12);
            }
            int i13 = this.secondaryColorTime;
            if (i13 > 0) {
                jSONObject.put("secondary_color_time", i13);
            }
            int i14 = this.secondaryColor;
            if (i14 != 0) {
                jSONObject.put("secondary_color", i14);
            }
            AtomicAction atomicAction = this.clickAction;
            if (atomicAction != null) {
                jSONObject.put("click_action", atomicAction.toJSONObject());
            }
            AtomicAction atomicAction2 = this.longClickAction;
            if (atomicAction2 != null) {
                jSONObject.put("long_click_action", atomicAction2.toJSONObject());
            }
            String str8 = this.resPackageName;
            if (str8 != null) {
                jSONObject.put("res_package_name", str8);
            }
            int i15 = this.startStatus;
            if (i15 != 0) {
                jSONObject.put("start_status", i15);
            }
            int i16 = this.endStatus;
            if (i16 != 0) {
                jSONObject.put("end_status", i16);
            }
            int i17 = this.mProgress;
            if (i17 != 0) {
                jSONObject.put("progress", i17);
            }
            int i18 = this.mProgressMax;
            if (i18 != 0) {
                jSONObject.put("progress_max", i18);
            }
            boolean z2 = this.mSeekAvailable;
            if (z2) {
                jSONObject.put("seek_available", z2);
            }
            long j8 = this.mStartActionTime;
            if (j8 != 0) {
                jSONObject.put("start_action_time", j8);
            }
            AtomicLayoutData atomicLayoutData = this.mTitleLayoutData;
            if (atomicLayoutData != null) {
                jSONObject.put("title_layout", atomicLayoutData.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData2 = this.mSubtitleLayoutData;
            if (atomicLayoutData2 != null) {
                jSONObject.put("subtitle_layout", atomicLayoutData2.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData3 = this.mStartIconLayoutData;
            if (atomicLayoutData3 != null) {
                jSONObject.put("start_icon_layout", atomicLayoutData3.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData4 = this.mContentLayoutData;
            if (atomicLayoutData4 != null) {
                jSONObject.put("content_layout", atomicLayoutData4.toJSONObject());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return toJSONObject().toString();
    }

    private AtomicDefaultSizeData(e eVar) {
        this.title = eVar.f6788a;
        this.titleFormat = null;
        this.subtitle = eVar.f6789b;
        this.subtitleFormat = null;
        this.imageIcon1 = eVar.f6790c;
        this.imageIcon2 = null;
        this.imageIcon3 = null;
        this.imageIconStart = eVar.f6791d;
        this.titleType = -1;
        this.subtitleType = -1;
        this.clickAction = null;
        this.longClickAction = null;
        this.imageIconEnd = eVar.e;
        this.imageIslandLargeIcon = null;
        this.imageIslandTranslating = null;
        this.imageIslandError = null;
        this.originalLanguage = null;
        this.originalContent = null;
        this.targetLanguage = null;
        this.targetContent = null;
        this.translateError = null;
        this.status = -2;
        this.endFrameStartIndex = -2;
        this.endLoopTimes = -2;
        this.startFrameStartIndex = -2;
        this.startLoopTimes = -2;
        this.resPackageName = null;
        this.secondaryColorTime = 0;
        this.secondaryColor = 0;
        this.startStatus = -2;
        this.endStatus = -2;
        this.subTitleExtra = null;
        this.subTitleIcon = null;
        this.mProgress = -2;
        this.mProgressMax = -2;
        this.mSeekAvailable = false;
        this.mStartActionTime = -2L;
        this.mTitleLayoutData = null;
        this.mSubtitleLayoutData = null;
        this.mStartIconLayoutData = null;
        this.mContentLayoutData = null;
    }
}
