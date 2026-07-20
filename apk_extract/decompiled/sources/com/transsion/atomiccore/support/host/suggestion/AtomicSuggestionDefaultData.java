package com.transsion.atomiccore.support.host.suggestion;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.transsion.atomiccore.support.host.AtomicAction;
import com.transsion.atomiccore.support.host.AtomicLayoutData;
import k3.kb;
import k7.d;
import l7.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AtomicSuggestionDefaultData {
    private final String bgColor;
    private final d bgImage;
    private final AtomicAction clickAction;
    private final d icon;
    private final AtomicAction iconAction;
    private final d iconBackground;
    private final AtomicAction longClickAction;
    private final AtomicLayoutData mSecondarySubtitleLayout;
    private final AtomicLayoutData mSecondaryTitleLayout;
    private final AtomicLayoutData mStatusLayout;
    private final AtomicLayoutData mSubTextLayout;
    private final AtomicLayoutData mSubtitleLayout;
    private final AtomicLayoutData mSuggestionIconLayout;
    private final AtomicLayoutData mTitleLayout;
    private final String mTitleTextAutoSize;
    private final String secondarySubTitle;
    private final d secondarySubTitleIcon;
    private final Integer secondarySubTitleIconSize;
    private final AtomicRichTextData secondarySubtitleRich;
    private final AtomicRichTextData secondaryTitleRich;
    private final String subTitle;
    private final d subTitleIcon;
    private final Integer subTitleIconSize;
    private final AtomicRichTextData subtitleRich;
    private final String title;
    private final AtomicRichTextData titleRich;

    private AtomicSuggestionDefaultData(b bVar) {
        throw null;
    }

    @NonNull
    public JSONObject actionJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            AtomicAction atomicAction = this.clickAction;
            if (atomicAction != null) {
                jSONObject.put("clickCard_suggestion", atomicAction.toJSONObject());
            }
            AtomicAction atomicAction2 = this.longClickAction;
            if (atomicAction2 != null) {
                jSONObject.put("longClickCard_suggestion", atomicAction2.toJSONObject());
            }
            AtomicAction atomicAction3 = this.iconAction;
            if (atomicAction3 != null) {
                jSONObject.put("suggestion_icon_click", atomicAction3.toJSONObject());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NonNull
    public JSONObject dataJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.subTitle;
            if (str != null) {
                jSONObject.put("suggestion_subTitle", str);
            }
            d dVar = this.subTitleIcon;
            if (dVar != null) {
                kb.a(jSONObject, "suggestion_subTitleIcon", dVar);
            }
            Integer num = this.subTitleIconSize;
            if (num != null) {
                jSONObject.put("suggestion_subTitleIcon_size", num);
            }
            String str2 = this.title;
            if (str2 != null) {
                jSONObject.put("suggestion_title", str2);
            }
            String str3 = this.secondarySubTitle;
            if (str3 != null) {
                jSONObject.put("suggestion_secondary_subTitle", str3);
            }
            d dVar2 = this.secondarySubTitleIcon;
            if (dVar2 != null) {
                kb.a(jSONObject, "sg_secondary_subTitleIcon", dVar2);
            }
            Integer num2 = this.secondarySubTitleIconSize;
            if (num2 != null) {
                jSONObject.put("sg_secondary_subTitleIcon_size", num2);
            }
            String str4 = this.bgColor;
            if (str4 != null) {
                jSONObject.put("suggestion_bgColor", str4);
            }
            d dVar3 = this.bgImage;
            if (dVar3 != null) {
                kb.a(jSONObject, "image_suggestion_bg", dVar3);
            }
            d dVar4 = this.icon;
            if (dVar4 != null) {
                kb.a(jSONObject, "image_suggestion_icon", dVar4);
            }
            d dVar5 = this.iconBackground;
            if (dVar5 != null) {
                kb.a(jSONObject, "image_button_bg", dVar5);
            }
            AtomicLayoutData atomicLayoutData = this.mTitleLayout;
            if (atomicLayoutData != null) {
                jSONObject.put("title_layout", atomicLayoutData.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData2 = this.mSubtitleLayout;
            if (atomicLayoutData2 != null) {
                jSONObject.put("subtitle_layout", atomicLayoutData2.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData3 = this.mSubTextLayout;
            if (atomicLayoutData3 != null) {
                jSONObject.put("sub_text_layout", atomicLayoutData3.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData4 = this.mStatusLayout;
            if (atomicLayoutData4 != null) {
                jSONObject.put("status_layout", atomicLayoutData4.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData5 = this.mSuggestionIconLayout;
            if (atomicLayoutData5 != null) {
                jSONObject.put("suggestion_icon_layout", atomicLayoutData5.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData6 = this.mSecondaryTitleLayout;
            if (atomicLayoutData6 != null) {
                jSONObject.put("secondary_title_layout", atomicLayoutData6.toJSONObject());
            }
            AtomicLayoutData atomicLayoutData7 = this.mSecondarySubtitleLayout;
            if (atomicLayoutData7 != null) {
                jSONObject.put("secondary_subTitle_layout", atomicLayoutData7.toJSONObject());
            }
            AtomicRichTextData atomicRichTextData = this.titleRich;
            if (atomicRichTextData != null) {
                jSONObject.put("suggestion_title_rich", atomicRichTextData.toJSONObject());
            }
            AtomicRichTextData atomicRichTextData2 = this.subtitleRich;
            if (atomicRichTextData2 != null) {
                jSONObject.put("suggestion_subTitle_rich", atomicRichTextData2.toJSONObject());
            }
            AtomicRichTextData atomicRichTextData3 = this.secondaryTitleRich;
            if (atomicRichTextData3 != null) {
                jSONObject.put("suggestion_secondary_title_rich", atomicRichTextData3.toJSONObject());
            }
            AtomicRichTextData atomicRichTextData4 = this.secondarySubtitleRich;
            if (atomicRichTextData4 != null) {
                jSONObject.put("suggestion_secondary_subTitle_rich", atomicRichTextData4.toJSONObject());
            }
            String str5 = this.mTitleTextAutoSize;
            if (str5 != null) {
                jSONObject.put("suggestion_title_auto_size", str5);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public d getBgImage() {
        return this.bgImage;
    }

    public AtomicAction getClickAction() {
        return this.clickAction;
    }

    public d getIcon() {
        return this.icon;
    }

    public AtomicAction getIconAction() {
        return this.iconAction;
    }

    public d getIconBackground() {
        return this.iconBackground;
    }

    public AtomicAction getLongClickAction() {
        return this.longClickAction;
    }

    public String getSecondarySubTitle() {
        return this.secondarySubTitle;
    }

    public d getSecondarySubTitleIcon() {
        return this.secondarySubTitleIcon;
    }

    public Integer getSecondarySubTitleIconSize() {
        return this.secondarySubTitleIconSize;
    }

    public AtomicLayoutData getSecondarySubtitleLayout() {
        return this.mSecondarySubtitleLayout;
    }

    public AtomicRichTextData getSecondarySubtitleRich() {
        return this.secondarySubtitleRich;
    }

    public AtomicLayoutData getSecondaryTitleLayout() {
        return this.mSecondaryTitleLayout;
    }

    public AtomicRichTextData getSecondaryTitleRich() {
        return this.secondaryTitleRich;
    }

    public AtomicLayoutData getStatusLayout() {
        return this.mStatusLayout;
    }

    public AtomicLayoutData getSubTextLayout() {
        return this.mSubTextLayout;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public d getSubTitleIcon() {
        return this.subTitleIcon;
    }

    public Integer getSubTitleIconSize() {
        return this.subTitleIconSize;
    }

    public AtomicRichTextData getSubtitleRich() {
        return this.subtitleRich;
    }

    public AtomicLayoutData getSuggestionIconLayout() {
        return this.mSuggestionIconLayout;
    }

    public String getTitle() {
        return this.title;
    }

    public AtomicRichTextData getTitleRich() {
        return this.titleRich;
    }

    public String getTitleTextAutoSize() {
        return this.mTitleTextAutoSize;
    }

    public AtomicLayoutData getmSubtitleLayout() {
        return this.mSubtitleLayout;
    }

    public AtomicLayoutData getmTitleLayout() {
        return this.mTitleLayout;
    }
}
