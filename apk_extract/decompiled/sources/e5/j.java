package e5;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasCarrierSpecific;
    private boolean hasCountryCode;
    private boolean hasEmergency;
    private boolean hasFixedLine;
    private boolean hasGeneralDesc;
    private boolean hasId;
    private boolean hasInternationalPrefix;
    private boolean hasLeadingDigits;
    private boolean hasMainCountryForCode;
    private boolean hasMobile;
    private boolean hasMobileNumberPortableRegion;
    private boolean hasNationalPrefix;
    private boolean hasNationalPrefixForParsing;
    private boolean hasNationalPrefixTransformRule;
    private boolean hasNoInternationalDialling;
    private boolean hasPager;
    private boolean hasPersonalNumber;
    private boolean hasPreferredExtnPrefix;
    private boolean hasPreferredInternationalPrefix;
    private boolean hasPremiumRate;
    private boolean hasSameMobileAndFixedLinePattern;
    private boolean hasSharedCost;
    private boolean hasShortCode;
    private boolean hasSmsServices;
    private boolean hasStandardRate;
    private boolean hasTollFree;
    private boolean hasUan;
    private boolean hasVoicemail;
    private boolean hasVoip;
    private n generalDesc_ = null;
    private n fixedLine_ = null;
    private n mobile_ = null;
    private n tollFree_ = null;
    private n premiumRate_ = null;
    private n sharedCost_ = null;
    private n personalNumber_ = null;
    private n voip_ = null;
    private n pager_ = null;
    private n uan_ = null;
    private n emergency_ = null;
    private n voicemail_ = null;
    private n shortCode_ = null;
    private n standardRate_ = null;
    private n carrierSpecific_ = null;
    private n smsServices_ = null;
    private n noInternationalDialling_ = null;
    private String id_ = "";
    private int countryCode_ = 0;
    private String internationalPrefix_ = "";
    private String preferredInternationalPrefix_ = "";
    private String nationalPrefix_ = "";
    private String preferredExtnPrefix_ = "";
    private String nationalPrefixForParsing_ = "";
    private String nationalPrefixTransformRule_ = "";
    private boolean sameMobileAndFixedLinePattern_ = false;
    private List<h> numberFormat_ = new ArrayList();
    private List<h> intlNumberFormat_ = new ArrayList();
    private boolean mainCountryForCode_ = false;
    private String leadingDigits_ = "";
    private boolean mobileNumberPortableRegion_ = false;

    public static i newBuilder() {
        return new i();
    }

    public j addIntlNumberFormat(h hVar) {
        hVar.getClass();
        this.intlNumberFormat_.add(hVar);
        return this;
    }

    public j addNumberFormat(h hVar) {
        hVar.getClass();
        this.numberFormat_.add(hVar);
        return this;
    }

    public j clearIntlNumberFormat() {
        this.intlNumberFormat_.clear();
        return this;
    }

    public j clearMainCountryForCode() {
        this.hasMainCountryForCode = false;
        this.mainCountryForCode_ = false;
        return this;
    }

    public j clearMobileNumberPortableRegion() {
        this.hasMobileNumberPortableRegion = false;
        this.mobileNumberPortableRegion_ = false;
        return this;
    }

    public j clearNationalPrefix() {
        this.hasNationalPrefix = false;
        this.nationalPrefix_ = "";
        return this;
    }

    public j clearNationalPrefixTransformRule() {
        this.hasNationalPrefixTransformRule = false;
        this.nationalPrefixTransformRule_ = "";
        return this;
    }

    public j clearPreferredExtnPrefix() {
        this.hasPreferredExtnPrefix = false;
        this.preferredExtnPrefix_ = "";
        return this;
    }

    public j clearPreferredInternationalPrefix() {
        this.hasPreferredInternationalPrefix = false;
        this.preferredInternationalPrefix_ = "";
        return this;
    }

    public j clearSameMobileAndFixedLinePattern() {
        this.hasSameMobileAndFixedLinePattern = false;
        this.sameMobileAndFixedLinePattern_ = false;
        return this;
    }

    public n getCarrierSpecific() {
        return this.carrierSpecific_;
    }

    public int getCountryCode() {
        return this.countryCode_;
    }

    public n getEmergency() {
        return this.emergency_;
    }

    public n getFixedLine() {
        return this.fixedLine_;
    }

    public n getGeneralDesc() {
        return this.generalDesc_;
    }

    public n getGeneralDescBuilder() {
        if (this.generalDesc_ == null) {
            this.generalDesc_ = new n();
        }
        return this.generalDesc_;
    }

    public String getId() {
        return this.id_;
    }

    public String getInternationalPrefix() {
        return this.internationalPrefix_;
    }

    public h getIntlNumberFormat(int i8) {
        return this.intlNumberFormat_.get(i8);
    }

    public int getIntlNumberFormatCount() {
        return this.intlNumberFormat_.size();
    }

    public List<h> getIntlNumberFormatList() {
        return this.intlNumberFormat_;
    }

    public String getLeadingDigits() {
        return this.leadingDigits_;
    }

    public boolean getMainCountryForCode() {
        return this.mainCountryForCode_;
    }

    public n getMobile() {
        return this.mobile_;
    }

    public boolean getMobileNumberPortableRegion() {
        return this.mobileNumberPortableRegion_;
    }

    public String getNationalPrefix() {
        return this.nationalPrefix_;
    }

    public String getNationalPrefixForParsing() {
        return this.nationalPrefixForParsing_;
    }

    public String getNationalPrefixTransformRule() {
        return this.nationalPrefixTransformRule_;
    }

    public n getNoInternationalDialling() {
        return this.noInternationalDialling_;
    }

    public h getNumberFormat(int i8) {
        return this.numberFormat_.get(i8);
    }

    public int getNumberFormatCount() {
        return this.numberFormat_.size();
    }

    public List<h> getNumberFormatList() {
        return this.numberFormat_;
    }

    public n getPager() {
        return this.pager_;
    }

    public n getPersonalNumber() {
        return this.personalNumber_;
    }

    public String getPreferredExtnPrefix() {
        return this.preferredExtnPrefix_;
    }

    public String getPreferredInternationalPrefix() {
        return this.preferredInternationalPrefix_;
    }

    public n getPremiumRate() {
        return this.premiumRate_;
    }

    public boolean getSameMobileAndFixedLinePattern() {
        return this.sameMobileAndFixedLinePattern_;
    }

    public n getSharedCost() {
        return this.sharedCost_;
    }

    public n getShortCode() {
        return this.shortCode_;
    }

    public n getSmsServices() {
        return this.smsServices_;
    }

    public n getStandardRate() {
        return this.standardRate_;
    }

    public n getTollFree() {
        return this.tollFree_;
    }

    public n getUan() {
        return this.uan_;
    }

    public n getVoicemail() {
        return this.voicemail_;
    }

    public n getVoip() {
        return this.voip_;
    }

    public boolean hasCarrierSpecific() {
        return this.hasCarrierSpecific;
    }

    public boolean hasCountryCode() {
        return this.hasCountryCode;
    }

    public boolean hasEmergency() {
        return this.hasEmergency;
    }

    public boolean hasFixedLine() {
        return this.hasFixedLine;
    }

    public boolean hasGeneralDesc() {
        return this.hasGeneralDesc;
    }

    public boolean hasId() {
        return this.hasId;
    }

    public boolean hasInternationalPrefix() {
        return this.hasInternationalPrefix;
    }

    public boolean hasLeadingDigits() {
        return this.hasLeadingDigits;
    }

    public boolean hasMainCountryForCode() {
        return this.hasMainCountryForCode;
    }

    public boolean hasMobile() {
        return this.hasMobile;
    }

    public boolean hasMobileNumberPortableRegion() {
        return this.hasMobileNumberPortableRegion;
    }

    public boolean hasNationalPrefix() {
        return this.hasNationalPrefix;
    }

    public boolean hasNationalPrefixForParsing() {
        return this.hasNationalPrefixForParsing;
    }

    public boolean hasNationalPrefixTransformRule() {
        return this.hasNationalPrefixTransformRule;
    }

    public boolean hasNoInternationalDialling() {
        return this.hasNoInternationalDialling;
    }

    public boolean hasPager() {
        return this.hasPager;
    }

    public boolean hasPersonalNumber() {
        return this.hasPersonalNumber;
    }

    public boolean hasPreferredExtnPrefix() {
        return this.hasPreferredExtnPrefix;
    }

    public boolean hasPreferredInternationalPrefix() {
        return this.hasPreferredInternationalPrefix;
    }

    public boolean hasPremiumRate() {
        return this.hasPremiumRate;
    }

    public boolean hasSameMobileAndFixedLinePattern() {
        return this.hasSameMobileAndFixedLinePattern;
    }

    public boolean hasSharedCost() {
        return this.hasSharedCost;
    }

    public boolean hasShortCode() {
        return this.hasShortCode;
    }

    public boolean hasSmsServices() {
        return this.hasSmsServices;
    }

    public boolean hasStandardRate() {
        return this.hasStandardRate;
    }

    public boolean hasTollFree() {
        return this.hasTollFree;
    }

    public boolean hasUan() {
        return this.hasUan;
    }

    public boolean hasVoicemail() {
        return this.hasVoicemail;
    }

    public boolean hasVoip() {
        return this.hasVoip;
    }

    @Deprecated
    public int intlNumberFormatSize() {
        return getIntlNumberFormatCount();
    }

    @Deprecated
    public List<h> intlNumberFormats() {
        return getIntlNumberFormatList();
    }

    public boolean isMainCountryForCode() {
        return this.mainCountryForCode_;
    }

    @Deprecated
    public boolean isMobileNumberPortableRegion() {
        return getMobileNumberPortableRegion();
    }

    @Deprecated
    public int numberFormatSize() {
        return getNumberFormatCount();
    }

    @Deprecated
    public List<h> numberFormats() {
        return getNumberFormatList();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            n nVar = new n();
            nVar.readExternal(objectInput);
            setGeneralDesc(nVar);
        }
        if (objectInput.readBoolean()) {
            n nVar2 = new n();
            nVar2.readExternal(objectInput);
            setFixedLine(nVar2);
        }
        if (objectInput.readBoolean()) {
            n nVar3 = new n();
            nVar3.readExternal(objectInput);
            setMobile(nVar3);
        }
        if (objectInput.readBoolean()) {
            n nVar4 = new n();
            nVar4.readExternal(objectInput);
            setTollFree(nVar4);
        }
        if (objectInput.readBoolean()) {
            n nVar5 = new n();
            nVar5.readExternal(objectInput);
            setPremiumRate(nVar5);
        }
        if (objectInput.readBoolean()) {
            n nVar6 = new n();
            nVar6.readExternal(objectInput);
            setSharedCost(nVar6);
        }
        if (objectInput.readBoolean()) {
            n nVar7 = new n();
            nVar7.readExternal(objectInput);
            setPersonalNumber(nVar7);
        }
        if (objectInput.readBoolean()) {
            n nVar8 = new n();
            nVar8.readExternal(objectInput);
            setVoip(nVar8);
        }
        if (objectInput.readBoolean()) {
            n nVar9 = new n();
            nVar9.readExternal(objectInput);
            setPager(nVar9);
        }
        if (objectInput.readBoolean()) {
            n nVar10 = new n();
            nVar10.readExternal(objectInput);
            setUan(nVar10);
        }
        if (objectInput.readBoolean()) {
            n nVar11 = new n();
            nVar11.readExternal(objectInput);
            setEmergency(nVar11);
        }
        if (objectInput.readBoolean()) {
            n nVar12 = new n();
            nVar12.readExternal(objectInput);
            setVoicemail(nVar12);
        }
        if (objectInput.readBoolean()) {
            n nVar13 = new n();
            nVar13.readExternal(objectInput);
            setShortCode(nVar13);
        }
        if (objectInput.readBoolean()) {
            n nVar14 = new n();
            nVar14.readExternal(objectInput);
            setStandardRate(nVar14);
        }
        if (objectInput.readBoolean()) {
            n nVar15 = new n();
            nVar15.readExternal(objectInput);
            setCarrierSpecific(nVar15);
        }
        if (objectInput.readBoolean()) {
            n nVar16 = new n();
            nVar16.readExternal(objectInput);
            setSmsServices(nVar16);
        }
        if (objectInput.readBoolean()) {
            n nVar17 = new n();
            nVar17.readExternal(objectInput);
            setNoInternationalDialling(nVar17);
        }
        setId(objectInput.readUTF());
        setCountryCode(objectInput.readInt());
        setInternationalPrefix(objectInput.readUTF());
        if (objectInput.readBoolean()) {
            setPreferredInternationalPrefix(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefix(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setPreferredExtnPrefix(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefixForParsing(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefixTransformRule(objectInput.readUTF());
        }
        setSameMobileAndFixedLinePattern(objectInput.readBoolean());
        int i8 = objectInput.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            h hVar = new h();
            hVar.readExternal(objectInput);
            this.numberFormat_.add(hVar);
        }
        int i10 = objectInput.readInt();
        for (int i11 = 0; i11 < i10; i11++) {
            h hVar2 = new h();
            hVar2.readExternal(objectInput);
            this.intlNumberFormat_.add(hVar2);
        }
        setMainCountryForCode(objectInput.readBoolean());
        if (objectInput.readBoolean()) {
            setLeadingDigits(objectInput.readUTF());
        }
        setMobileNumberPortableRegion(objectInput.readBoolean());
    }

    public j setCarrierSpecific(n nVar) {
        nVar.getClass();
        this.hasCarrierSpecific = true;
        this.carrierSpecific_ = nVar;
        return this;
    }

    public j setCountryCode(int i8) {
        this.hasCountryCode = true;
        this.countryCode_ = i8;
        return this;
    }

    public j setEmergency(n nVar) {
        nVar.getClass();
        this.hasEmergency = true;
        this.emergency_ = nVar;
        return this;
    }

    public j setFixedLine(n nVar) {
        nVar.getClass();
        this.hasFixedLine = true;
        this.fixedLine_ = nVar;
        return this;
    }

    public j setGeneralDesc(n nVar) {
        nVar.getClass();
        this.hasGeneralDesc = true;
        this.generalDesc_ = nVar;
        return this;
    }

    public j setId(String str) {
        this.hasId = true;
        this.id_ = str;
        return this;
    }

    public j setInternationalPrefix(String str) {
        this.hasInternationalPrefix = true;
        this.internationalPrefix_ = str;
        return this;
    }

    public j setLeadingDigits(String str) {
        this.hasLeadingDigits = true;
        this.leadingDigits_ = str;
        return this;
    }

    public j setMainCountryForCode(boolean z2) {
        this.hasMainCountryForCode = true;
        this.mainCountryForCode_ = z2;
        return this;
    }

    public j setMobile(n nVar) {
        nVar.getClass();
        this.hasMobile = true;
        this.mobile_ = nVar;
        return this;
    }

    public j setMobileNumberPortableRegion(boolean z2) {
        this.hasMobileNumberPortableRegion = true;
        this.mobileNumberPortableRegion_ = z2;
        return this;
    }

    public j setNationalPrefix(String str) {
        this.hasNationalPrefix = true;
        this.nationalPrefix_ = str;
        return this;
    }

    public j setNationalPrefixForParsing(String str) {
        this.hasNationalPrefixForParsing = true;
        this.nationalPrefixForParsing_ = str;
        return this;
    }

    public j setNationalPrefixTransformRule(String str) {
        this.hasNationalPrefixTransformRule = true;
        this.nationalPrefixTransformRule_ = str;
        return this;
    }

    public j setNoInternationalDialling(n nVar) {
        nVar.getClass();
        this.hasNoInternationalDialling = true;
        this.noInternationalDialling_ = nVar;
        return this;
    }

    public j setPager(n nVar) {
        nVar.getClass();
        this.hasPager = true;
        this.pager_ = nVar;
        return this;
    }

    public j setPersonalNumber(n nVar) {
        nVar.getClass();
        this.hasPersonalNumber = true;
        this.personalNumber_ = nVar;
        return this;
    }

    public j setPreferredExtnPrefix(String str) {
        this.hasPreferredExtnPrefix = true;
        this.preferredExtnPrefix_ = str;
        return this;
    }

    public j setPreferredInternationalPrefix(String str) {
        this.hasPreferredInternationalPrefix = true;
        this.preferredInternationalPrefix_ = str;
        return this;
    }

    public j setPremiumRate(n nVar) {
        nVar.getClass();
        this.hasPremiumRate = true;
        this.premiumRate_ = nVar;
        return this;
    }

    public j setSameMobileAndFixedLinePattern(boolean z2) {
        this.hasSameMobileAndFixedLinePattern = true;
        this.sameMobileAndFixedLinePattern_ = z2;
        return this;
    }

    public j setSharedCost(n nVar) {
        nVar.getClass();
        this.hasSharedCost = true;
        this.sharedCost_ = nVar;
        return this;
    }

    public j setShortCode(n nVar) {
        nVar.getClass();
        this.hasShortCode = true;
        this.shortCode_ = nVar;
        return this;
    }

    public j setSmsServices(n nVar) {
        nVar.getClass();
        this.hasSmsServices = true;
        this.smsServices_ = nVar;
        return this;
    }

    public j setStandardRate(n nVar) {
        nVar.getClass();
        this.hasStandardRate = true;
        this.standardRate_ = nVar;
        return this;
    }

    public j setTollFree(n nVar) {
        nVar.getClass();
        this.hasTollFree = true;
        this.tollFree_ = nVar;
        return this;
    }

    public j setUan(n nVar) {
        nVar.getClass();
        this.hasUan = true;
        this.uan_ = nVar;
        return this;
    }

    public j setVoicemail(n nVar) {
        nVar.getClass();
        this.hasVoicemail = true;
        this.voicemail_ = nVar;
        return this;
    }

    public j setVoip(n nVar) {
        nVar.getClass();
        this.hasVoip = true;
        this.voip_ = nVar;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.hasGeneralDesc);
        if (this.hasGeneralDesc) {
            this.generalDesc_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasFixedLine);
        if (this.hasFixedLine) {
            this.fixedLine_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasMobile);
        if (this.hasMobile) {
            this.mobile_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasTollFree);
        if (this.hasTollFree) {
            this.tollFree_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPremiumRate);
        if (this.hasPremiumRate) {
            this.premiumRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSharedCost);
        if (this.hasSharedCost) {
            this.sharedCost_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPersonalNumber);
        if (this.hasPersonalNumber) {
            this.personalNumber_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoip);
        if (this.hasVoip) {
            this.voip_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPager);
        if (this.hasPager) {
            this.pager_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasUan);
        if (this.hasUan) {
            this.uan_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasEmergency);
        if (this.hasEmergency) {
            this.emergency_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoicemail);
        if (this.hasVoicemail) {
            this.voicemail_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasShortCode);
        if (this.hasShortCode) {
            this.shortCode_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasStandardRate);
        if (this.hasStandardRate) {
            this.standardRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasCarrierSpecific);
        if (this.hasCarrierSpecific) {
            this.carrierSpecific_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSmsServices);
        if (this.hasSmsServices) {
            this.smsServices_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasNoInternationalDialling);
        if (this.hasNoInternationalDialling) {
            this.noInternationalDialling_.writeExternal(objectOutput);
        }
        objectOutput.writeUTF(this.id_);
        objectOutput.writeInt(this.countryCode_);
        objectOutput.writeUTF(this.internationalPrefix_);
        objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
        if (this.hasPreferredInternationalPrefix) {
            objectOutput.writeUTF(this.preferredInternationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefix);
        if (this.hasNationalPrefix) {
            objectOutput.writeUTF(this.nationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
        if (this.hasPreferredExtnPrefix) {
            objectOutput.writeUTF(this.preferredExtnPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
        if (this.hasNationalPrefixForParsing) {
            objectOutput.writeUTF(this.nationalPrefixForParsing_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
        if (this.hasNationalPrefixTransformRule) {
            objectOutput.writeUTF(this.nationalPrefixTransformRule_);
        }
        objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
        int iNumberFormatSize = numberFormatSize();
        objectOutput.writeInt(iNumberFormatSize);
        for (int i8 = 0; i8 < iNumberFormatSize; i8++) {
            this.numberFormat_.get(i8).writeExternal(objectOutput);
        }
        int iIntlNumberFormatSize = intlNumberFormatSize();
        objectOutput.writeInt(iIntlNumberFormatSize);
        for (int i9 = 0; i9 < iIntlNumberFormatSize; i9++) {
            this.intlNumberFormat_.get(i9).writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.mainCountryForCode_);
        objectOutput.writeBoolean(this.hasLeadingDigits);
        if (this.hasLeadingDigits) {
            objectOutput.writeUTF(this.leadingDigits_);
        }
        objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
    }
}
