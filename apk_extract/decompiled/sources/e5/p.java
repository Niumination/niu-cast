package e5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean hasCountryCode;
    private boolean hasCountryCodeSource;
    private boolean hasExtension;
    private boolean hasItalianLeadingZero;
    private boolean hasNationalNumber;
    private boolean hasNumberOfLeadingZeros;
    private boolean hasPreferredDomesticCarrierCode;
    private boolean hasRawInput;
    private int countryCode_ = 0;
    private long nationalNumber_ = 0;
    private String extension_ = "";
    private boolean italianLeadingZero_ = false;
    private int numberOfLeadingZeros_ = 1;
    private String rawInput_ = "";
    private String preferredDomesticCarrierCode_ = "";
    private o countryCodeSource_ = o.UNSPECIFIED;

    public final p clear() {
        clearCountryCode();
        clearNationalNumber();
        clearExtension();
        clearItalianLeadingZero();
        clearNumberOfLeadingZeros();
        clearRawInput();
        clearCountryCodeSource();
        clearPreferredDomesticCarrierCode();
        return this;
    }

    public p clearCountryCode() {
        this.hasCountryCode = false;
        this.countryCode_ = 0;
        return this;
    }

    public p clearCountryCodeSource() {
        this.hasCountryCodeSource = false;
        this.countryCodeSource_ = o.UNSPECIFIED;
        return this;
    }

    public p clearExtension() {
        this.hasExtension = false;
        this.extension_ = "";
        return this;
    }

    public p clearItalianLeadingZero() {
        this.hasItalianLeadingZero = false;
        this.italianLeadingZero_ = false;
        return this;
    }

    public p clearNationalNumber() {
        this.hasNationalNumber = false;
        this.nationalNumber_ = 0L;
        return this;
    }

    public p clearNumberOfLeadingZeros() {
        this.hasNumberOfLeadingZeros = false;
        this.numberOfLeadingZeros_ = 1;
        return this;
    }

    public p clearPreferredDomesticCarrierCode() {
        this.hasPreferredDomesticCarrierCode = false;
        this.preferredDomesticCarrierCode_ = "";
        return this;
    }

    public p clearRawInput() {
        this.hasRawInput = false;
        this.rawInput_ = "";
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && exactlySameAs((p) obj);
    }

    public boolean exactlySameAs(p pVar) {
        if (pVar == null) {
            return false;
        }
        if (this == pVar) {
            return true;
        }
        return this.countryCode_ == pVar.countryCode_ && this.nationalNumber_ == pVar.nationalNumber_ && this.extension_.equals(pVar.extension_) && this.italianLeadingZero_ == pVar.italianLeadingZero_ && this.numberOfLeadingZeros_ == pVar.numberOfLeadingZeros_ && this.rawInput_.equals(pVar.rawInput_) && this.countryCodeSource_ == pVar.countryCodeSource_ && this.preferredDomesticCarrierCode_.equals(pVar.preferredDomesticCarrierCode_) && hasPreferredDomesticCarrierCode() == pVar.hasPreferredDomesticCarrierCode();
    }

    public int getCountryCode() {
        return this.countryCode_;
    }

    public o getCountryCodeSource() {
        return this.countryCodeSource_;
    }

    public String getExtension() {
        return this.extension_;
    }

    public long getNationalNumber() {
        return this.nationalNumber_;
    }

    public int getNumberOfLeadingZeros() {
        return this.numberOfLeadingZeros_;
    }

    public String getPreferredDomesticCarrierCode() {
        return this.preferredDomesticCarrierCode_;
    }

    public String getRawInput() {
        return this.rawInput_;
    }

    public boolean hasCountryCode() {
        return this.hasCountryCode;
    }

    public boolean hasCountryCodeSource() {
        return this.hasCountryCodeSource;
    }

    public boolean hasExtension() {
        return this.hasExtension;
    }

    public boolean hasItalianLeadingZero() {
        return this.hasItalianLeadingZero;
    }

    public boolean hasNationalNumber() {
        return this.hasNationalNumber;
    }

    public boolean hasNumberOfLeadingZeros() {
        return this.hasNumberOfLeadingZeros;
    }

    public boolean hasPreferredDomesticCarrierCode() {
        return this.hasPreferredDomesticCarrierCode;
    }

    public boolean hasRawInput() {
        return this.hasRawInput;
    }

    public int hashCode() {
        return ((getPreferredDomesticCarrierCode().hashCode() + ((getCountryCodeSource().hashCode() + ((getRawInput().hashCode() + ((getNumberOfLeadingZeros() + ((((getExtension().hashCode() + ((Long.valueOf(getNationalNumber()).hashCode() + ((getCountryCode() + 2173) * 53)) * 53)) * 53) + (isItalianLeadingZero() ? 1231 : 1237)) * 53)) * 53)) * 53)) * 53)) * 53) + (hasPreferredDomesticCarrierCode() ? 1231 : 1237);
    }

    public boolean isItalianLeadingZero() {
        return this.italianLeadingZero_;
    }

    public p mergeFrom(p pVar) {
        if (pVar.hasCountryCode()) {
            setCountryCode(pVar.getCountryCode());
        }
        if (pVar.hasNationalNumber()) {
            setNationalNumber(pVar.getNationalNumber());
        }
        if (pVar.hasExtension()) {
            setExtension(pVar.getExtension());
        }
        if (pVar.hasItalianLeadingZero()) {
            setItalianLeadingZero(pVar.isItalianLeadingZero());
        }
        if (pVar.hasNumberOfLeadingZeros()) {
            setNumberOfLeadingZeros(pVar.getNumberOfLeadingZeros());
        }
        if (pVar.hasRawInput()) {
            setRawInput(pVar.getRawInput());
        }
        if (pVar.hasCountryCodeSource()) {
            setCountryCodeSource(pVar.getCountryCodeSource());
        }
        if (pVar.hasPreferredDomesticCarrierCode()) {
            setPreferredDomesticCarrierCode(pVar.getPreferredDomesticCarrierCode());
        }
        return this;
    }

    public p setCountryCode(int i8) {
        this.hasCountryCode = true;
        this.countryCode_ = i8;
        return this;
    }

    public p setCountryCodeSource(o oVar) {
        oVar.getClass();
        this.hasCountryCodeSource = true;
        this.countryCodeSource_ = oVar;
        return this;
    }

    public p setExtension(String str) {
        str.getClass();
        this.hasExtension = true;
        this.extension_ = str;
        return this;
    }

    public p setItalianLeadingZero(boolean z2) {
        this.hasItalianLeadingZero = true;
        this.italianLeadingZero_ = z2;
        return this;
    }

    public p setNationalNumber(long j8) {
        this.hasNationalNumber = true;
        this.nationalNumber_ = j8;
        return this;
    }

    public p setNumberOfLeadingZeros(int i8) {
        this.hasNumberOfLeadingZeros = true;
        this.numberOfLeadingZeros_ = i8;
        return this;
    }

    public p setPreferredDomesticCarrierCode(String str) {
        str.getClass();
        this.hasPreferredDomesticCarrierCode = true;
        this.preferredDomesticCarrierCode_ = str;
        return this;
    }

    public p setRawInput(String str) {
        str.getClass();
        this.hasRawInput = true;
        this.rawInput_ = str;
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Country Code: ");
        sb2.append(this.countryCode_);
        sb2.append(" National Number: ");
        sb2.append(this.nationalNumber_);
        if (hasItalianLeadingZero() && isItalianLeadingZero()) {
            sb2.append(" Leading Zero(s): true");
        }
        if (hasNumberOfLeadingZeros()) {
            sb2.append(" Number of leading zeros: ");
            sb2.append(this.numberOfLeadingZeros_);
        }
        if (hasExtension()) {
            sb2.append(" Extension: ");
            sb2.append(this.extension_);
        }
        if (hasCountryCodeSource()) {
            sb2.append(" Country Code Source: ");
            sb2.append(this.countryCodeSource_);
        }
        if (hasPreferredDomesticCarrierCode()) {
            sb2.append(" Preferred Domestic Carrier Code: ");
            sb2.append(this.preferredDomesticCarrierCode_);
        }
        return sb2.toString();
    }
}
