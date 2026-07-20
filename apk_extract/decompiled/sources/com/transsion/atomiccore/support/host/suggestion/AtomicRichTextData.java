package com.transsion.atomiccore.support.host.suggestion;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AtomicRichTextData {
    private final List<TextColorConfig> textColorConfigs;
    private final List<TextSizeConfig> textSizeConfigs;

    @Keep
    public static class TextColorConfig {
        private final String color;
        private final int endIndex;
        private final int startIndex;

        public TextColorConfig(int i8, int i9, String str) {
            this.startIndex = i8;
            this.endIndex = i9;
            this.color = str;
        }

        public String getColor() {
            return this.color;
        }

        public int getEndIndex() {
            return this.endIndex;
        }

        public int getStartIndex() {
            return this.startIndex;
        }

        @NonNull
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("startIndex", this.startIndex);
                jSONObject.put("endIndex", this.endIndex);
                jSONObject.put(TypedValues.Custom.S_COLOR, this.color);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    @Keep
    public static class TextSizeConfig {
        private final int endIndex;
        private final int size;
        private final int startIndex;

        public TextSizeConfig(int i8, int i9, int i10) {
            this.startIndex = i8;
            this.endIndex = i9;
            this.size = i10;
        }

        public int getEndIndex() {
            return this.endIndex;
        }

        public int getSize() {
            return this.size;
        }

        public int getStartIndex() {
            return this.startIndex;
        }

        @NonNull
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("startIndex", this.startIndex);
                jSONObject.put("endIndex", this.endIndex);
                jSONObject.put("size", this.size);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public AtomicRichTextData(List<TextSizeConfig> list, List<TextColorConfig> list2) {
        this.textSizeConfigs = list;
        this.textColorConfigs = list2;
    }

    public List<TextColorConfig> getTextColorConfigs() {
        return this.textColorConfigs;
    }

    public List<TextSizeConfig> getTextSizeConfigs() {
        return this.textSizeConfigs;
    }

    @NonNull
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<TextSizeConfig> list = this.textSizeConfigs;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<TextSizeConfig> it = this.textSizeConfigs.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSONObject());
                }
                jSONObject.put("textSize", jSONArray);
            }
            List<TextColorConfig> list2 = this.textColorConfigs;
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<TextColorConfig> it2 = this.textColorConfigs.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next().toJSONObject());
                }
                jSONObject.put("textColor", jSONArray2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
