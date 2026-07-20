package e5;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasDomesticCarrierCodeFormattingRule;
    private boolean hasFormat;
    private boolean hasNationalPrefixFormattingRule;
    private boolean hasNationalPrefixOptionalWhenFormatting;
    private boolean hasPattern;
    private String pattern_ = "";
    private String format_ = "";
    private List<String> leadingDigitsPattern_ = new ArrayList();
    private String nationalPrefixFormattingRule_ = "";
    private boolean nationalPrefixOptionalWhenFormatting_ = false;
    private String domesticCarrierCodeFormattingRule_ = "";

    public static g newBuilder() {
        return new g();
    }

    public h addLeadingDigitsPattern(String str) {
        str.getClass();
        this.leadingDigitsPattern_.add(str);
        return this;
    }

    public h clearNationalPrefixFormattingRule() {
        this.hasNationalPrefixFormattingRule = false;
        this.nationalPrefixFormattingRule_ = "";
        return this;
    }

    public String getDomesticCarrierCodeFormattingRule() {
        return this.domesticCarrierCodeFormattingRule_;
    }

    public String getFormat() {
        return this.format_;
    }

    public String getLeadingDigitsPattern(int i8) {
        return this.leadingDigitsPattern_.get(i8);
    }

    public int getLeadingDigitsPatternCount() {
        return this.leadingDigitsPattern_.size();
    }

    public String getNationalPrefixFormattingRule() {
        return this.nationalPrefixFormattingRule_;
    }

    public boolean getNationalPrefixOptionalWhenFormatting() {
        return this.nationalPrefixOptionalWhenFormatting_;
    }

    public String getPattern() {
        return this.pattern_;
    }

    public boolean hasDomesticCarrierCodeFormattingRule() {
        return this.hasDomesticCarrierCodeFormattingRule;
    }

    public boolean hasFormat() {
        return this.hasFormat;
    }

    public boolean hasNationalPrefixFormattingRule() {
        return this.hasNationalPrefixFormattingRule;
    }

    public boolean hasNationalPrefixOptionalWhenFormatting() {
        return this.hasNationalPrefixOptionalWhenFormatting;
    }

    public boolean hasPattern() {
        return this.hasPattern;
    }

    public List<String> leadingDigitPatterns() {
        return this.leadingDigitsPattern_;
    }

    @Deprecated
    public int leadingDigitsPatternSize() {
        return getLeadingDigitsPatternCount();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        setPattern(objectInput.readUTF());
        setFormat(objectInput.readUTF());
        int i8 = objectInput.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            this.leadingDigitsPattern_.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefixFormattingRule(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
        }
        setNationalPrefixOptionalWhenFormatting(objectInput.readBoolean());
    }

    public h setDomesticCarrierCodeFormattingRule(String str) {
        this.hasDomesticCarrierCodeFormattingRule = true;
        this.domesticCarrierCodeFormattingRule_ = str;
        return this;
    }

    public h setFormat(String str) {
        this.hasFormat = true;
        this.format_ = str;
        return this;
    }

    public h setNationalPrefixFormattingRule(String str) {
        this.hasNationalPrefixFormattingRule = true;
        this.nationalPrefixFormattingRule_ = str;
        return this;
    }

    public h setNationalPrefixOptionalWhenFormatting(boolean z2) {
        this.hasNationalPrefixOptionalWhenFormatting = true;
        this.nationalPrefixOptionalWhenFormatting_ = z2;
        return this;
    }

    public h setPattern(String str) {
        this.hasPattern = true;
        this.pattern_ = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.pattern_);
        objectOutput.writeUTF(this.format_);
        int iLeadingDigitsPatternSize = leadingDigitsPatternSize();
        objectOutput.writeInt(iLeadingDigitsPatternSize);
        for (int i8 = 0; i8 < iLeadingDigitsPatternSize; i8++) {
            objectOutput.writeUTF(this.leadingDigitsPattern_.get(i8));
        }
        objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
        if (this.hasNationalPrefixFormattingRule) {
            objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
        }
        objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
        if (this.hasDomesticCarrierCodeFormattingRule) {
            objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
        }
        objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
    }
}
