package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.internal.compat.workaround.ExcludedSupportedSizesContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.Logger;
import androidx.camera.core.ResolutionSelector;
import androidx.camera.core.impl.SizeCoordinate;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class SupportedOutputSizesCollector {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final Size mActiveArraySize;
    private final String mCameraId;

    @NonNull
    private final CameraCharacteristicsCompat mCharacteristics;

    @NonNull
    private final DisplayInfoManager mDisplayInfoManager;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final ResolutionCorrector mResolutionCorrector = new ResolutionCorrector();
    private final Map<Integer, Size[]> mOutputSizesCache = new HashMap();
    private final Map<Integer, Size[]> mHighResolutionOutputSizesCache = new HashMap();
    private final Map<Integer, Size> mMaxSizeCache = new HashMap();
    private final Map<Integer, List<Size>> mExcludedSizeListCache = new HashMap();
    private final boolean mIsBurstCaptureSupported = isBurstCaptureSupported();

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Size[] getHighResolutionOutputSizes(StreamConfigurationMap streamConfigurationMap, int i8) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i8);
        }
    }

    public SupportedOutputSizesCollector(@NonNull String str, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull DisplayInfoManager displayInfoManager) {
        this.mCameraId = str;
        this.mCharacteristics = cameraCharacteristicsCompat;
        this.mDisplayInfoManager = displayInfoManager;
        this.mExcludedSupportedSizesContainer = new ExcludedSupportedSizesContainer(str);
        this.mIsSensorLandscapeResolution = isSensorLandscapeResolution(cameraCharacteristicsCompat);
        Rect rect = (Rect) cameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        this.mActiveArraySize = rect != null ? new Size(rect.width(), rect.height()) : null;
        this.mSensorOrientation = ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        this.mLensFacing = ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue();
    }

    private boolean canResolutionBeMovedToHead(@NonNull Size size) {
        int i8 = new TargetAspectRatio().get(this.mCameraId, this.mCharacteristics);
        if (i8 == 0) {
            return AspectRatioUtil.hasMatchingAspectRatio(size, AspectRatioUtil.ASPECT_RATIO_4_3);
        }
        if (i8 == 1) {
            return AspectRatioUtil.hasMatchingAspectRatio(size, AspectRatioUtil.ASPECT_RATIO_16_9);
        }
        if (i8 != 2) {
            return true;
        }
        Size sizeFetchMaxNormalOutputSize = fetchMaxNormalOutputSize(256);
        return AspectRatioUtil.hasMatchingAspectRatio(size, new Rational(sizeFetchMaxNormalOutputSize.getWidth(), sizeFetchMaxNormalOutputSize.getHeight()));
    }

    @NonNull
    private List<Size> collectResolutionCandidateList(@NonNull ResolutionSelector resolutionSelector, int i8, boolean z2, @Nullable Size[] sizeArr) {
        if (sizeArr == null) {
            sizeArr = getAllOutputSizesByFormat(i8, !z2 && resolutionSelector.isHighResolutionEnabled());
        }
        Arrays.sort(sizeArr, new CompareSizesByArea(true));
        List<Size> listAsList = Arrays.asList(sizeArr);
        if (listAsList.isEmpty()) {
            throw new IllegalArgumentException("Resolution candidate list is empty when collecting by the settings!");
        }
        return listAsList;
    }

    @Nullable
    private Size[] doGetHighResolutionOutputSizesByFormat(int i8) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            return Api23Impl.getHighResolutionOutputSizes(streamConfigurationMap, i8);
        }
        throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
    }

    @NonNull
    private Size[] doGetOutputSizesByFormat(int i8) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
        }
        Size[] outputSizes = StreamConfigurationMapCompat.toStreamConfigurationMapCompat(streamConfigurationMap).getOutputSizes(i8);
        if (outputSizes != null) {
            return outputSizes;
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Can not get supported output size for the format: "));
    }

    @NonNull
    private List<Size> excludeProblematicSizes(@NonNull List<Size> list, int i8) {
        list.removeAll(fetchExcludedSizes(i8));
        return list;
    }

    @NonNull
    private List<Size> fetchExcludedSizes(int i8) {
        List<Size> list = this.mExcludedSizeListCache.get(Integer.valueOf(i8));
        if (list != null) {
            return list;
        }
        List<Size> list2 = this.mExcludedSupportedSizesContainer.get(i8);
        this.mExcludedSizeListCache.put(Integer.valueOf(i8), list2);
        return list2;
    }

    private Size fetchMaxNormalOutputSize(int i8) {
        Size size = this.mMaxSizeCache.get(Integer.valueOf(i8));
        if (size != null) {
            return size;
        }
        Size maxNormalOutputSizeByFormat = getMaxNormalOutputSizeByFormat(i8);
        this.mMaxSizeCache.put(Integer.valueOf(i8), maxNormalOutputSizeByFormat);
        return maxNormalOutputSizeByFormat;
    }

    private List<Size> filterOutResolutionCandidateListBySettings(@NonNull List<Size> list, @NonNull ResolutionSelector resolutionSelector, int i8) {
        List<Size> arrayList;
        Size maxResolution = resolutionSelector.getMaxResolution();
        if (maxResolution == null) {
            arrayList = new ArrayList<>(list);
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Size size : list) {
                if (!SizeUtil.isLongerInAnyEdge(size, maxResolution)) {
                    arrayList2.add(size);
                }
            }
            arrayList = arrayList2;
        }
        List<Size> listExcludeProblematicSizes = excludeProblematicSizes(arrayList, i8);
        if (listExcludeProblematicSizes.isEmpty()) {
            throw new IllegalArgumentException("Resolution candidate list is empty after filtering out by the settings!");
        }
        return listExcludeProblematicSizes;
    }

    @Nullable
    public static Size flipSizeByRotation(@Nullable Size size, int i8, int i9, int i10) {
        return (size == null || !isRotationNeeded(i8, i9, i10)) ? size : new Size(size.getHeight(), size.getWidth());
    }

    @NonNull
    private Size[] getAllOutputSizesByFormat(int i8, boolean z2) {
        Size[] sizeArrDoGetHighResolutionOutputSizesByFormat;
        Size[] sizeArrDoGetOutputSizesByFormat = this.mOutputSizesCache.get(Integer.valueOf(i8));
        if (sizeArrDoGetOutputSizesByFormat == null) {
            sizeArrDoGetOutputSizesByFormat = doGetOutputSizesByFormat(i8);
            this.mOutputSizesCache.put(Integer.valueOf(i8), sizeArrDoGetOutputSizesByFormat);
        }
        if (z2 && this.mIsBurstCaptureSupported) {
            sizeArrDoGetHighResolutionOutputSizesByFormat = this.mHighResolutionOutputSizesCache.get(Integer.valueOf(i8));
            if (sizeArrDoGetHighResolutionOutputSizesByFormat == null && !this.mHighResolutionOutputSizesCache.containsKey(Integer.valueOf(i8))) {
                sizeArrDoGetHighResolutionOutputSizesByFormat = doGetHighResolutionOutputSizesByFormat(i8);
                this.mHighResolutionOutputSizesCache.put(Integer.valueOf(i8), sizeArrDoGetHighResolutionOutputSizesByFormat);
            }
        } else {
            sizeArrDoGetHighResolutionOutputSizesByFormat = null;
        }
        if (sizeArrDoGetHighResolutionOutputSizesByFormat == null) {
            return sizeArrDoGetOutputSizesByFormat;
        }
        Size[] sizeArr = (Size[]) Arrays.copyOf(sizeArrDoGetHighResolutionOutputSizesByFormat, sizeArrDoGetHighResolutionOutputSizesByFormat.length + sizeArrDoGetOutputSizesByFormat.length);
        System.arraycopy(sizeArrDoGetOutputSizesByFormat, 0, sizeArr, sizeArrDoGetHighResolutionOutputSizesByFormat.length, sizeArrDoGetOutputSizesByFormat.length);
        return sizeArr;
    }

    private Size getMaxNormalOutputSizeByFormat(int i8) {
        return SizeUtil.getMaxSize(Arrays.asList(getAllOutputSizesByFormat(i8, false)));
    }

    @NonNull
    public static List<Rational> getResolutionListGroupingAspectRatioKeys(@NonNull List<Size> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        for (Size size : list) {
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList.contains(rational)) {
                Iterator it = arrayList.iterator();
                do {
                    if (!it.hasNext()) {
                        arrayList.add(rational);
                        break;
                    }
                } while (!AspectRatioUtil.hasMatchingAspectRatio(size, (Rational) it.next()));
            }
        }
        return arrayList;
    }

    @Nullable
    private Rational getTargetAspectRatioByResolutionSelector(@NonNull ResolutionSelector resolutionSelector) {
        int preferredAspectRatio;
        Rational rational;
        Rational targetAspectRatioFromQuirk = getTargetAspectRatioFromQuirk();
        if (targetAspectRatioFromQuirk != null || (preferredAspectRatio = resolutionSelector.getPreferredAspectRatio()) == -1) {
            return targetAspectRatioFromQuirk;
        }
        if (preferredAspectRatio == 0) {
            rational = this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_4_3 : AspectRatioUtil.ASPECT_RATIO_3_4;
        } else {
            if (preferredAspectRatio != 1) {
                Logger.e(TAG, "Undefined target aspect ratio: " + preferredAspectRatio);
                return targetAspectRatioFromQuirk;
            }
            rational = this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_16_9 : AspectRatioUtil.ASPECT_RATIO_9_16;
        }
        return rational;
    }

    @Nullable
    private Rational getTargetAspectRatioFromQuirk() {
        int i8 = new TargetAspectRatio().get(this.mCameraId, this.mCharacteristics);
        if (i8 == 0) {
            return this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_4_3 : AspectRatioUtil.ASPECT_RATIO_3_4;
        }
        if (i8 == 1) {
            return this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_16_9 : AspectRatioUtil.ASPECT_RATIO_9_16;
        }
        if (i8 != 2) {
            return null;
        }
        Size sizeFetchMaxNormalOutputSize = fetchMaxNormalOutputSize(256);
        return new Rational(sizeFetchMaxNormalOutputSize.getWidth(), sizeFetchMaxNormalOutputSize.getHeight());
    }

    @Nullable
    public static Size getTargetSizeByResolutionSelector(@NonNull ResolutionSelector resolutionSelector, int i8, int i9, int i10) {
        Size preferredResolution = resolutionSelector.getPreferredResolution();
        return resolutionSelector.getSizeCoordinate() == SizeCoordinate.ANDROID_VIEW ? flipSizeByRotation(preferredResolution, i8, i10, i9) : preferredResolution;
    }

    public static Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> list) {
        HashMap map = new HashMap();
        Iterator<Rational> it = getResolutionListGroupingAspectRatioKeys(list).iterator();
        while (it.hasNext()) {
            map.put(it.next(), new ArrayList());
        }
        for (Size size : list) {
            for (Rational rational : map.keySet()) {
                if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                    ((List) map.get(rational)).add(size);
                }
            }
        }
        return map;
    }

    private boolean isBurstCaptureSupported() {
        int[] iArr = (int[]) this.mCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i8 : iArr) {
                if (i8 == 6) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRotationNeeded(int i8, int i9, int i10) {
        int relativeImageRotation = CameraOrientationUtil.getRelativeImageRotation(CameraOrientationUtil.surfaceRotationToDegrees(i8), i10, 1 == i9);
        return relativeImageRotation == 90 || relativeImageRotation == 270;
    }

    public static boolean isSensorLandscapeResolution(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Size size = (Size) cameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        return size == null || size.getWidth() >= size.getHeight();
    }

    public static void removeSupportedSizesByMiniBoundingSize(List<Size> list, Size size) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i8 = -1;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            int i11 = i8;
            i8 = i10;
            if (i8 >= list.size()) {
                break;
            }
            Size size2 = list.get(i8);
            if (size2.getWidth() < size.getWidth() || size2.getHeight() < size.getHeight()) {
                if (i11 < 0) {
                    break;
                }
                arrayList.remove(list.get(i11));
                break;
            } else {
                if (i11 >= 0) {
                    arrayList.add(list.get(i11));
                }
                i9 = i8 + 1;
            }
        }
        list.removeAll(arrayList);
    }

    @NonNull
    private List<Size> sortResolutionCandidateListByResolutionSelector(@NonNull List<Size> list, @NonNull ResolutionSelector resolutionSelector, int i8, @Nullable Size size) {
        Rational targetAspectRatioByResolutionSelector = getTargetAspectRatioByResolutionSelector(resolutionSelector);
        Preconditions.checkNotNull(targetAspectRatioByResolutionSelector, "ResolutionSelector should also have aspect ratio value.");
        Size targetSizeByResolutionSelector = getTargetSizeByResolutionSelector(resolutionSelector, i8, this.mSensorOrientation, this.mLensFacing);
        List<Size> listSortResolutionCandidateListByTargetAspectRatioAndSize = sortResolutionCandidateListByTargetAspectRatioAndSize(list, targetAspectRatioByResolutionSelector, size);
        if (listSortResolutionCandidateListByTargetAspectRatioAndSize.contains(targetSizeByResolutionSelector) && canResolutionBeMovedToHead(targetSizeByResolutionSelector)) {
            listSortResolutionCandidateListByTargetAspectRatioAndSize.remove(targetSizeByResolutionSelector);
            listSortResolutionCandidateListByTargetAspectRatioAndSize.add(0, targetSizeByResolutionSelector);
        }
        return listSortResolutionCandidateListByTargetAspectRatioAndSize;
    }

    @NonNull
    private List<Size> sortResolutionCandidateListByTargetAspectRatioAndSize(@NonNull List<Size> list, @NonNull Rational rational, @Nullable Size size) {
        Map<Rational, List<Size>> mapGroupSizesByAspectRatio = groupSizesByAspectRatio(list);
        if (size != null) {
            Iterator<Rational> it = mapGroupSizesByAspectRatio.keySet().iterator();
            while (it.hasNext()) {
                removeSupportedSizesByMiniBoundingSize(mapGroupSizesByAspectRatio.get(it.next()), size);
            }
        }
        ArrayList arrayList = new ArrayList(mapGroupSizesByAspectRatio.keySet());
        Collections.sort(arrayList, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(rational, this.mActiveArraySize != null ? new Rational(this.mActiveArraySize.getWidth(), this.mActiveArraySize.getHeight()) : null));
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            for (Size size2 : mapGroupSizesByAspectRatio.get((Rational) it2.next())) {
                if (!arrayList2.contains(size2)) {
                    arrayList2.add(size2);
                }
            }
        }
        return arrayList2;
    }

    @NonNull
    public List<Size> getSupportedOutputSizes(@NonNull ResolutionSelector resolutionSelector, int i8, @Nullable Size size, boolean z2, @Nullable Size[] sizeArr) {
        return this.mResolutionCorrector.insertOrPrioritize(SurfaceConfig.getConfigType(i8), sortResolutionCandidateListByResolutionSelector(filterOutResolutionCandidateListBySettings(collectResolutionCandidateList(resolutionSelector, i8, z2, sizeArr), resolutionSelector, i8), resolutionSelector, this.mDisplayInfoManager.getMaxSizeDisplay().getRotation(), size));
    }
}
