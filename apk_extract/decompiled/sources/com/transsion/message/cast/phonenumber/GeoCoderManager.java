package com.transsion.message.cast.phonenumber;

import android.content.Context;
import android.location.Geocoder;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.os.UserManagerCompat;
import e5.c;
import e5.j;
import e5.p;
import f5.a;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import k5.f;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public class GeoCoderManager {
    public static final String DEFAULT_COUNTRY_ISO = "US";
    static final String KEY_PREFERENCE_CURRENT_COUNTRY = "preference_current_country";
    private final Context appContext;
    private final Locale locale;
    private final TelephonyManager telephonyManager;

    public interface LocaleProvider {
        Locale getLocale();
    }

    public GeoCoderManager(TelephonyManager telephonyManager, Context context, Locale locale) {
        this.telephonyManager = telephonyManager;
        this.appContext = context;
        this.locale = locale;
    }

    private String getLocaleBasedCountryIso() {
        Locale locale = this.locale;
        if (locale != null) {
            return locale.getCountry();
        }
        return null;
    }

    @Nullable
    private String getLocationBasedCountryIso() {
        if (Geocoder.isPresent() && hasLocationPermissions(this.appContext) && UserManagerCompat.isUserUnlocked(this.appContext)) {
            return PreferenceManager.getDefaultSharedPreferences(this.appContext).getString(KEY_PREFERENCE_CURRENT_COUNTRY, null);
        }
        return null;
    }

    private String getNetworkBasedCountryIso() {
        return this.telephonyManager.getNetworkCountryIso();
    }

    private String getSimBasedCountryIso() {
        return this.telephonyManager.getSimCountryIso();
    }

    private static boolean hasLocationPermissions(Context context) {
        return context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private boolean isNetworkCountryCodeAvailable() {
        return this.telephonyManager.getPhoneType() == 1;
    }

    public String getCurrentCountryIso() {
        String localeBasedCountryIso;
        if (isNetworkCountryCodeAvailable()) {
            localeBasedCountryIso = getNetworkBasedCountryIso();
            d.B("result: ", localeBasedCountryIso, "getNetworkBasedCountryIso");
        } else {
            localeBasedCountryIso = null;
        }
        if (TextUtils.isEmpty(localeBasedCountryIso)) {
            localeBasedCountryIso = getLocationBasedCountryIso();
            d.B("result: ", localeBasedCountryIso, "getLocationBasedCountryIso");
        }
        if (TextUtils.isEmpty(localeBasedCountryIso)) {
            localeBasedCountryIso = getSimBasedCountryIso();
            d.B("result: ", localeBasedCountryIso, "getSimBasedCountryIso");
        }
        if (TextUtils.isEmpty(localeBasedCountryIso)) {
            localeBasedCountryIso = getLocaleBasedCountryIso();
            d.B("result: ", localeBasedCountryIso, "getLocaleBasedCountryIso");
        }
        if (TextUtils.isEmpty(localeBasedCountryIso)) {
            Log.d("getDefaultCountryIso", "result: US");
            localeBasedCountryIso = DEFAULT_COUNTRY_ISO;
        }
        Log.v("getCurrentCountryIso", "result: " + localeBasedCountryIso);
        return localeBasedCountryIso.toUpperCase(Locale.US);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x011b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0133  */
    /* JADX WARN: Code duplicated, block: B:61:0x013e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0181  */
    /* JADX WARN: Code duplicated, block: B:78:0x018d  */
    public String getGeoDescription(String str, String str2) {
        a aVar;
        p pVarN;
        String language;
        String country;
        int countryCode;
        Integer numValueOf;
        Map map;
        String str3;
        boolean zEquals;
        f fVar;
        String strB;
        p pVarN2;
        String strC = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e5.f fVarC = e5.f.c();
        synchronized (a.class) {
            try {
                if (a.f4983c == null) {
                    h5.a.f5260d.getClass();
                    a.f4983c = new a(0);
                }
                aVar = a.f4983c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Locale locale = Locale.getDefault();
        try {
            pVarN = fVarC.n(str, str2);
            try {
                Log.v("PhoneNumberGeoUtilImpl.getGeoDescription", "- parsed number: '" + pVarN + "'");
            } catch (c e) {
                e = e;
                Log.e("PhoneNumberGeoUtilImpl.getGeoDescription", "Error parsing number: " + e.toString());
            }
        } catch (c e4) {
            e = e4;
            pVarN = null;
        }
        if (pVarN != null) {
            e5.f fVar2 = (e5.f) aVar.f4985b;
            fVar2.getClass();
            int countryCode2 = pVarN.getCountryCode();
            List<String> list = (List) fVar2.f4690b.get(Integer.valueOf(countryCode2));
            if (list != null) {
                if (list.size() != 1) {
                    String strF = e5.f.f(pVarN);
                    for (String str4 : list) {
                        j jVarD = fVar2.d(str4);
                        if (!jVarD.hasLeadingDigits()) {
                            if (fVar2.h(strF, jVarD) != e5.d.UNKNOWN) {
                                strC = str4;
                                break;
                            }
                        } else {
                            if (fVar2.e.E(jVarD.getLeadingDigits()).matcher(strF).lookingAt()) {
                                strC = str4;
                                break;
                            }
                        }
                    }
                } else {
                    strC = (String) list.get(0);
                }
            } else {
                e5.f.f4674h.log(Level.INFO, h0.a.h(countryCode2, "Missing/invalid country_code (", ")"));
            }
            j jVarE = fVar2.e(pVarN.getCountryCode(), strC);
            e5.d dVarH = jVarE == null ? e5.d.UNKNOWN : fVar2.h(e5.f.f(pVarN), jVarE);
            strC = "";
            if (dVarH != e5.d.UNKNOWN) {
                int countryCode3 = pVarN.getCountryCode();
                if (dVarH == e5.d.FIXED_LINE || dVarH == e5.d.FIXED_LINE_OR_MOBILE) {
                    language = locale.getLanguage();
                    country = locale.getCountry();
                    countryCode = pVarN.getCountryCode();
                    numValueOf = Integer.valueOf(countryCode);
                    map = e5.f.f4675i;
                    if (map.containsKey(numValueOf)) {
                        str3 = (String) map.get(Integer.valueOf(countryCode));
                    } else {
                        str3 = "";
                    }
                    String strF2 = e5.f.f(pVarN);
                    zEquals = str3.equals("");
                    fVar = (f) aVar.f4984a;
                    if (zEquals && strF2.startsWith(str3)) {
                        String strSubstring = strF2.substring(str3.length());
                        List list2 = (List) fVar2.f4690b.get(Integer.valueOf(pVarN.getCountryCode()));
                        try {
                            pVarN2 = fVar2.n(strSubstring, list2 == null ? "ZZ" : (String) list2.get(0));
                        } catch (c unused) {
                            pVarN2 = pVarN;
                        }
                        strB = fVar.b(pVarN2, language, country);
                    } else {
                        strB = fVar.b(pVarN, language, country);
                    }
                    if (strB.length() <= 0) {
                        strB = aVar.c(pVarN, locale);
                    }
                    strC = strB;
                } else if (e5.f.f4676j.contains(Integer.valueOf(countryCode3)) && dVarH == e5.d.MOBILE) {
                    language = locale.getLanguage();
                    country = locale.getCountry();
                    countryCode = pVarN.getCountryCode();
                    numValueOf = Integer.valueOf(countryCode);
                    map = e5.f.f4675i;
                    if (map.containsKey(numValueOf)) {
                        str3 = (String) map.get(Integer.valueOf(countryCode));
                    } else {
                        str3 = "";
                    }
                    String strF3 = e5.f.f(pVarN);
                    zEquals = str3.equals("");
                    fVar = (f) aVar.f4984a;
                    if (zEquals) {
                        strB = fVar.b(pVarN, language, country);
                    } else {
                        strB = fVar.b(pVarN, language, country);
                    }
                    if (strB.length() <= 0) {
                        strB = aVar.c(pVarN, locale);
                    }
                    strC = strB;
                } else {
                    strC = aVar.c(pVarN, locale);
                }
            }
            Log.v("PhoneNumberGeoUtilImpl.getGeoDescription", "- got description: '" + strC + "'");
        }
        return strC;
    }
}
