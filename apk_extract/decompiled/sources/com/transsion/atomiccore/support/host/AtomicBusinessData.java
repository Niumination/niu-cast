package com.transsion.atomiccore.support.host;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import k3.k1;
import k3.kb;
import k7.b;
import k7.c;
import k7.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AtomicBusinessData {
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_DATA = "data";
    private static final String KEY_DEFAULT = "default";
    private static final String KEY_EXTRA = "extra";
    private final c data;

    public /* synthetic */ AtomicBusinessData(b bVar, int i8) {
        this(bVar);
    }

    private void setDefaultData(JSONObject jSONObject, JSONObject jSONObject2, AtomicDefaultSizeData atomicDefaultSizeData) throws JSONException {
        if (atomicDefaultSizeData != null) {
            setIslandDefault(jSONObject, jSONObject2, atomicDefaultSizeData);
            if (!jSONObject.has("live_update_title")) {
                jSONObject.put("live_update_title", atomicDefaultSizeData.getTitle());
            }
            if (jSONObject.has("live_update_subTitle")) {
                return;
            }
            jSONObject.put("live_update_subTitle", atomicDefaultSizeData.getSubtitle());
        }
    }

    private void setIconDataAction(JSONObject jSONObject, @NonNull String str, d dVar) throws JSONException {
        AtomicAction atomicAction;
        if (dVar == null || (atomicAction = dVar.f6787b) == null) {
            return;
        }
        jSONObject.put(str, atomicAction.toJSONObject());
    }

    private void setIslandDefault(JSONObject jSONObject, JSONObject jSONObject2, AtomicDefaultSizeData atomicDefaultSizeData) throws JSONException {
        if (atomicDefaultSizeData != null) {
            if (!jSONObject.has("island_small_title")) {
                jSONObject.put("island_small_title", atomicDefaultSizeData.getTitle());
            }
            if (!jSONObject.has("island_small_subTitle")) {
                jSONObject.put("island_small_subTitle", atomicDefaultSizeData.getSubtitle());
            }
            if (!jSONObject.has("island_large_title")) {
                jSONObject.put("island_large_title", atomicDefaultSizeData.getTitle());
            }
            if (!jSONObject.has("island_large_subTitle")) {
                jSONObject.put("island_large_subTitle", atomicDefaultSizeData.getSubtitle());
            }
            if (!jSONObject.has("live_update_title")) {
                jSONObject.put("live_update_title", atomicDefaultSizeData.getTitle());
            }
            if (!jSONObject.has("live_update_subTitle")) {
                jSONObject.put("live_update_subTitle", atomicDefaultSizeData.getSubtitle());
            }
            if (atomicDefaultSizeData.getImageIconStart() != null) {
                kb.a(jSONObject, "image_island_icon_start", atomicDefaultSizeData.getImageIconStart());
                kb.a(jSONObject, "image_island_small_start", atomicDefaultSizeData.getImageIconStart());
            }
            kb.a(jSONObject, "image_island_action_1", atomicDefaultSizeData.getImageIcon1());
            kb.a(jSONObject, "image_island_action_2", atomicDefaultSizeData.getImageIcon2());
            kb.a(jSONObject, "image_island_action_3", atomicDefaultSizeData.getImageIcon3());
            kb.a(jSONObject, "image_island_small_end", atomicDefaultSizeData.getImageIconEnd());
            kb.a(jSONObject, "image_island_large_icon", atomicDefaultSizeData.getImageIslandLargeIcon());
            kb.a(jSONObject, "image_island_translating", atomicDefaultSizeData.getImageIslandTranslating());
            kb.a(jSONObject, "image_island_error", atomicDefaultSizeData.getImageIslandError());
            int titleType = atomicDefaultSizeData.getTitleType();
            jSONObject.put("island_small_title_type", titleType);
            jSONObject.put("island_large_title_type", titleType);
            int subtitleType = atomicDefaultSizeData.getSubtitleType();
            jSONObject.put("island_small_subtitle_type", subtitleType);
            jSONObject.put("island_large_subtitle_type", subtitleType);
            if (atomicDefaultSizeData.getOriginalLanguage() != null) {
                jSONObject.put("original_language", atomicDefaultSizeData.getOriginalLanguage());
            }
            if (atomicDefaultSizeData.getOriginalContent() != null) {
                jSONObject.put("original_content", atomicDefaultSizeData.getOriginalContent());
            }
            if (atomicDefaultSizeData.getTargetLanguage() != null) {
                jSONObject.put("target_language", atomicDefaultSizeData.getTargetLanguage());
            }
            if (atomicDefaultSizeData.getTargetContent() != null) {
                jSONObject.put("target_content", atomicDefaultSizeData.getTargetContent());
            }
            if (atomicDefaultSizeData.getTranslateError() != null) {
                jSONObject.put("translate_error", atomicDefaultSizeData.getTranslateError());
            }
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, atomicDefaultSizeData.getStatus());
            jSONObject.put("island_s_end_frame_start_index", atomicDefaultSizeData.getEndFrameStartIndex());
            jSONObject.put("island_s_end_loop_times", atomicDefaultSizeData.getEndLoopTimes());
            jSONObject.put("island_s_start_frame_start_index", atomicDefaultSizeData.getStartFrameStartIndex());
            jSONObject.put("island_s_start_loop_times", atomicDefaultSizeData.getStartLoopTimes());
            jSONObject.put("res_package_name", atomicDefaultSizeData.getResPackageName());
            AtomicAction clickAction = atomicDefaultSizeData.getClickAction();
            if (clickAction != null) {
                jSONObject2.put("clickCard_island_large", clickAction.toJSONObject());
            }
            AtomicAction longClickAction = atomicDefaultSizeData.getLongClickAction();
            if (longClickAction != null) {
                jSONObject2.put("longClickCard_island_large", longClickAction.toJSONObject());
            }
        }
    }

    private void setIslandLarge(JSONObject jSONObject, JSONObject jSONObject2, AtomicDefaultSizeData atomicDefaultSizeData) throws JSONException {
        if (atomicDefaultSizeData != null) {
            jSONObject.put("island_large_title", atomicDefaultSizeData.getTitle());
            if ((atomicDefaultSizeData.getTitleType() == 0 || atomicDefaultSizeData.getTitleType() == 1) && !TextUtils.isEmpty(atomicDefaultSizeData.getTitleFormat())) {
                jSONObject.put("island_large_title_timer_text", atomicDefaultSizeData.getTitleFormat());
            }
            jSONObject.put("island_large_subTitle", atomicDefaultSizeData.getSubtitle());
            if ((atomicDefaultSizeData.getSubtitleType() == 0 || atomicDefaultSizeData.getSubtitleType() == 1) && !TextUtils.isEmpty(atomicDefaultSizeData.getSubtitleFormat())) {
                jSONObject.put("island_large_subtitle_timer_text", atomicDefaultSizeData.getSubtitleFormat());
            }
            jSONObject.put("live_update_title", atomicDefaultSizeData.getTitle());
            jSONObject.put("live_update_subTitle", atomicDefaultSizeData.getSubtitle());
            if (atomicDefaultSizeData.getImageIconStart() != null) {
                kb.a(jSONObject, "image_island_icon_start", atomicDefaultSizeData.getImageIconStart());
            }
            if (atomicDefaultSizeData.getImageIconEnd() != null) {
                kb.a(jSONObject, "image_island_icon_end", atomicDefaultSizeData.getImageIconEnd());
            }
            setIconDataAction(jSONObject2, "clickAction_island_large_action1", atomicDefaultSizeData.getImageIcon1());
            kb.a(jSONObject, "image_island_action_1", atomicDefaultSizeData.getImageIcon1());
            setIconDataAction(jSONObject2, "clickAction_island_large_action2", atomicDefaultSizeData.getImageIcon2());
            kb.a(jSONObject, "image_island_action_2", atomicDefaultSizeData.getImageIcon2());
            setIconDataAction(jSONObject2, "clickAction_island_large_action3", atomicDefaultSizeData.getImageIcon3());
            kb.a(jSONObject, "image_island_action_3", atomicDefaultSizeData.getImageIcon3());
            kb.a(jSONObject, "image_island_large_icon", atomicDefaultSizeData.getImageIslandLargeIcon());
            kb.a(jSONObject, "image_island_translating", atomicDefaultSizeData.getImageIslandTranslating());
            kb.a(jSONObject, "image_island_error", atomicDefaultSizeData.getImageIslandError());
            if (atomicDefaultSizeData.getOriginalLanguage() != null) {
                jSONObject.put("original_language", atomicDefaultSizeData.getOriginalLanguage());
            }
            if (atomicDefaultSizeData.getOriginalContent() != null) {
                jSONObject.put("original_content", atomicDefaultSizeData.getOriginalContent());
            }
            if (atomicDefaultSizeData.getTargetLanguage() != null) {
                jSONObject.put("target_language", atomicDefaultSizeData.getTargetLanguage());
            }
            if (atomicDefaultSizeData.getTargetContent() != null) {
                jSONObject.put("target_content", atomicDefaultSizeData.getTargetContent());
            }
            if (atomicDefaultSizeData.getTranslateError() != null) {
                jSONObject.put("translate_error", atomicDefaultSizeData.getTranslateError());
            }
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, atomicDefaultSizeData.getStatus());
            if (!TextUtils.isEmpty(atomicDefaultSizeData.getResPackageName())) {
                jSONObject.put("res_package_name", atomicDefaultSizeData.getResPackageName());
            }
            if (atomicDefaultSizeData.getStartFrameStartIndex() != -2) {
                jSONObject.put("island_m_start_frame_start_index", atomicDefaultSizeData.getStartFrameStartIndex());
            }
            if (atomicDefaultSizeData.getStartLoopTimes() != -2) {
                jSONObject.put("island_m_start_loop_times", atomicDefaultSizeData.getStartLoopTimes());
            }
            if (atomicDefaultSizeData.getStartStatus() != -2) {
                jSONObject.put("island_start_status", atomicDefaultSizeData.getStartStatus());
            }
            if (atomicDefaultSizeData.getEndFrameStartIndex() != -2) {
                jSONObject.put("island_m_end_frame_start_index", atomicDefaultSizeData.getEndFrameStartIndex());
            }
            if (atomicDefaultSizeData.getEndLoopTimes() != -2) {
                jSONObject.put("island_m_end_loop_times", atomicDefaultSizeData.getEndLoopTimes());
            }
            if (atomicDefaultSizeData.getEndStatus() != -2) {
                jSONObject.put("island_end_status", atomicDefaultSizeData.getEndStatus());
            }
            if (atomicDefaultSizeData.getProgress() != -2) {
                jSONObject.put("progress", atomicDefaultSizeData.getProgress());
            }
            if (atomicDefaultSizeData.getProgressMax() != -2) {
                jSONObject.put("progressMax", atomicDefaultSizeData.getProgressMax());
            }
            if (atomicDefaultSizeData.isSeekAvailable()) {
                jSONObject.put("seekAvailable", atomicDefaultSizeData.isSeekAvailable());
            }
            if (atomicDefaultSizeData.getStartActionTime() != -2) {
                jSONObject.put("startActionTime", atomicDefaultSizeData.getStartActionTime());
            }
            jSONObject.put("island_subTitle_extra", atomicDefaultSizeData.getSubTitleExtra());
            kb.a(jSONObject, "image_subtitle_icon", atomicDefaultSizeData.getSubTitleIcon());
            jSONObject.put("island_large_title_type", atomicDefaultSizeData.getTitleType());
            jSONObject.put("island_large_subtitle_type", atomicDefaultSizeData.getSubtitleType());
            if (atomicDefaultSizeData.getTitleLayoutData() != null) {
                jSONObject.put("title_layout", atomicDefaultSizeData.getTitleLayoutData().toJSONObject());
            }
            if (atomicDefaultSizeData.getSubtitleLayoutData() != null) {
                jSONObject.put("subtitle_layout", atomicDefaultSizeData.getSubtitleLayoutData().toJSONObject());
            }
            if (atomicDefaultSizeData.getStartIconLayoutData() != null) {
                jSONObject.put("start_icon_layout", atomicDefaultSizeData.getStartIconLayoutData().toJSONObject());
            }
            if (atomicDefaultSizeData.getContentLayoutData() != null) {
                jSONObject.put("content_layout", atomicDefaultSizeData.getContentLayoutData().toJSONObject());
            }
            AtomicAction clickAction = atomicDefaultSizeData.getClickAction();
            if (clickAction != null) {
                jSONObject2.put("clickCard_island_large", clickAction.toJSONObject());
            }
            AtomicAction longClickAction = atomicDefaultSizeData.getLongClickAction();
            if (longClickAction != null) {
                jSONObject2.put("longClickCard_island_large", longClickAction.toJSONObject());
            }
        }
    }

    private void setIslandSmall(JSONObject jSONObject, JSONObject jSONObject2, AtomicDefaultSizeData atomicDefaultSizeData) throws JSONException {
        if (atomicDefaultSizeData != null) {
            jSONObject.put("island_small_title", atomicDefaultSizeData.getTitle());
            if ((atomicDefaultSizeData.getTitleType() == 0 || atomicDefaultSizeData.getTitleType() == 1) && !TextUtils.isEmpty(atomicDefaultSizeData.getTitleFormat())) {
                jSONObject.put("island_small_title_timer_text", atomicDefaultSizeData.getTitleFormat());
            }
            jSONObject.put("island_small_subTitle", atomicDefaultSizeData.getSubtitle());
            kb.a(jSONObject, "image_island_small_start", atomicDefaultSizeData.getImageIconStart());
            jSONObject.put("island_small_title_type", atomicDefaultSizeData.getTitleType());
            jSONObject.put("island_small_subtitle_type", atomicDefaultSizeData.getSubtitleType());
            kb.a(jSONObject, "image_island_small_end", atomicDefaultSizeData.getImageIconEnd());
            if (atomicDefaultSizeData.getEndFrameStartIndex() != -2) {
                jSONObject.put("island_s_end_frame_start_index", atomicDefaultSizeData.getEndFrameStartIndex());
            }
            if (atomicDefaultSizeData.getEndLoopTimes() != -2) {
                jSONObject.put("island_s_end_loop_times", atomicDefaultSizeData.getEndLoopTimes());
            }
            if (atomicDefaultSizeData.getStartFrameStartIndex() != -2) {
                jSONObject.put("island_s_start_frame_start_index", atomicDefaultSizeData.getStartFrameStartIndex());
            }
            if (atomicDefaultSizeData.getStartLoopTimes() != -2) {
                jSONObject.put("island_s_start_loop_times", atomicDefaultSizeData.getStartLoopTimes());
            }
            if (atomicDefaultSizeData.getStartStatus() != -2) {
                jSONObject.put("island_start_status", atomicDefaultSizeData.getStartStatus());
            }
            if (atomicDefaultSizeData.getEndStatus() != -2) {
                jSONObject.put("island_end_status", atomicDefaultSizeData.getEndStatus());
            }
            if (!TextUtils.isEmpty(atomicDefaultSizeData.getResPackageName())) {
                jSONObject.put("res_package_name", atomicDefaultSizeData.getResPackageName());
            }
            AtomicAction clickAction = atomicDefaultSizeData.getClickAction();
            if (clickAction != null) {
                jSONObject2.put("clickCard_island_small", clickAction.toJSONObject());
            }
            AtomicAction longClickAction = atomicDefaultSizeData.getLongClickAction();
            if (longClickAction != null) {
                jSONObject2.put("longClickCard_island_small", longClickAction.toJSONObject());
            }
            int secondaryColorTime = atomicDefaultSizeData.getSecondaryColorTime();
            if (secondaryColorTime > 0) {
                jSONObject.put("island_s_secondary_color_time", secondaryColorTime);
            }
            int secondaryColor = atomicDefaultSizeData.getSecondaryColor();
            if (secondaryColor != 0) {
                jSONObject.put("island_s_secondary_color", secondaryColor);
            }
        }
    }

    public c getData() {
        return this.data;
    }

    @NonNull
    public JSONObject toJSONObject() {
        return toJSONObject(null);
    }

    @NonNull
    public String toString() {
        return toJSONObject().toString();
    }

    private AtomicBusinessData(b bVar) {
        this.data = bVar.f6784a;
    }

    @NonNull
    public JSONObject toJSONObject(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c cVar = this.data;
        if (cVar != null) {
            try {
                JSONObject jSONObjectA = cVar.a();
                JSONObject jSONObject2 = new JSONObject();
                ad.b bVar = this.data.f6785a;
                if (bVar != null) {
                    setIslandSmall(jSONObjectA, jSONObject2, (AtomicDefaultSizeData) bVar.f92a);
                    setIslandLarge(jSONObjectA, jSONObject2, (AtomicDefaultSizeData) this.data.f6785a.f93b);
                    this.data.f6785a.getClass();
                    setIslandDefault(jSONObjectA, jSONObject2, null);
                }
                this.data.getClass();
                setDefaultData(jSONObjectA, jSONObject2, null);
                jSONObject.put(KEY_DATA, jSONObjectA);
                jSONObject.put(KEY_ACTIONS, jSONObject2);
            } catch (Throwable th2) {
                k1.c("AtomicBusinessData", "", th2);
            }
        }
        return jSONObject;
    }
}
