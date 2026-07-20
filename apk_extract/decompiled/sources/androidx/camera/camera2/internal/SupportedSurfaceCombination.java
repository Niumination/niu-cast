package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.internal.compat.workaround.ExcludedSupportedSizesContainer;
import androidx.camera.camera2.internal.compat.workaround.ExtraSupportedSurfaceCombinationsContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.ResolutionSelector;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
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
final class SupportedSurfaceCombination {
    private static final String TAG = "SupportedSurfaceCombination";
    private final Size mActiveArraySize;
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final String mCameraId;
    private final CameraCharacteristicsCompat mCharacteristics;

    @NonNull
    private final DisplayInfoManager mDisplayInfoManager;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final ExtraSupportedSurfaceCombinationsContainer mExtraSupportedSurfaceCombinationsContainer;
    private final int mHardwareLevel;
    private boolean mIsBurstCaptureSupported;
    private boolean mIsRawSupported;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final SupportedOutputSizesCollector mSupportedOutputSizesCollector;

    @VisibleForTesting
    SurfaceSizeDefinition mSurfaceSizeDefinition;
    private final List<SurfaceCombination> mSurfaceCombinations = new ArrayList();
    private final Map<Integer, Size> mMaxSizeCache = new HashMap();
    private final Map<Integer, List<Size>> mExcludedSizeListCache = new HashMap();
    private final Map<Integer, Size[]> mOutputSizesCache = new HashMap();
    private final ResolutionCorrector mResolutionCorrector = new ResolutionCorrector();

    public SupportedSurfaceCombination(@NonNull Context context, @NonNull String str, @NonNull CameraManagerCompat cameraManagerCompat, @NonNull CamcorderProfileHelper camcorderProfileHelper) throws CameraUnavailableException {
        this.mIsRawSupported = false;
        this.mIsBurstCaptureSupported = false;
        String str2 = (String) Preconditions.checkNotNull(str);
        this.mCameraId = str2;
        this.mCamcorderProfileHelper = (CamcorderProfileHelper) Preconditions.checkNotNull(camcorderProfileHelper);
        this.mExcludedSupportedSizesContainer = new ExcludedSupportedSizesContainer(str);
        this.mExtraSupportedSurfaceCombinationsContainer = new ExtraSupportedSurfaceCombinationsContainer();
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(context);
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str2);
            this.mCharacteristics = cameraCharacteristicsCompat;
            Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.mHardwareLevel = num != null ? num.intValue() : 2;
            this.mIsSensorLandscapeResolution = SupportedOutputSizesCollector.isSensorLandscapeResolution(cameraCharacteristicsCompat);
            int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i8 : iArr) {
                    if (i8 == 3) {
                        this.mIsRawSupported = true;
                    } else if (i8 == 6) {
                        this.mIsBurstCaptureSupported = true;
                    }
                }
            }
            Rect rect = (Rect) this.mCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.mActiveArraySize = rect != null ? new Size(rect.width(), rect.height()) : null;
            this.mSensorOrientation = ((Integer) this.mCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            this.mLensFacing = ((Integer) this.mCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
            generateSupportedCombinationList();
            generateSurfaceSizeDefinition();
            checkCustomization();
            this.mSupportedOutputSizesCollector = new SupportedOutputSizesCollector(this.mCameraId, this.mCharacteristics, this.mDisplayInfoManager);
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    private void checkCustomization() {
    }

    @NonNull
    private Size[] doGetAllOutputSizesByFormat(int i8) {
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
    private Size[] excludeProblematicSizesAndSort(@NonNull Size[] sizeArr, int i8) {
        List<Size> listFetchExcludedSizes = fetchExcludedSizes(i8);
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        arrayList.removeAll(listFetchExcludedSizes);
        Size[] sizeArr2 = (Size[]) arrayList.toArray(new Size[0]);
        Arrays.sort(sizeArr2, new CompareSizesByArea(true));
        return sizeArr2;
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

    private Size fetchMaxSize(int i8) {
        Size size = this.mMaxSizeCache.get(Integer.valueOf(i8));
        if (size != null) {
            return size;
        }
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(i8);
        this.mMaxSizeCache.put(Integer.valueOf(i8), maxOutputSizeByFormat);
        return maxOutputSizeByFormat;
    }

    private void generateSupportedCombinationList() {
        this.mSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.generateSupportedCombinationList(this.mHardwareLevel, this.mIsRawSupported, this.mIsBurstCaptureSupported));
        this.mSurfaceCombinations.addAll(this.mExtraSupportedSurfaceCombinationsContainer.get(this.mCameraId, this.mHardwareLevel));
    }

    private void generateSurfaceSizeDefinition() {
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(new Size(640, 480), this.mDisplayInfoManager.getPreviewSize(), getRecordSize());
    }

    @NonNull
    private Size[] getAllOutputSizesByFormat(int i8) {
        Size[] sizeArr = this.mOutputSizesCache.get(Integer.valueOf(i8));
        if (sizeArr != null) {
            return sizeArr;
        }
        Size[] sizeArrDoGetAllOutputSizesByFormat = doGetAllOutputSizesByFormat(i8);
        this.mOutputSizesCache.put(Integer.valueOf(i8), sizeArrDoGetAllOutputSizesByFormat);
        return sizeArrDoGetAllOutputSizesByFormat;
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> list) {
        Iterator<List<Size>> it = list.iterator();
        int size = 1;
        while (it.hasNext()) {
            size *= it.next().size();
        }
        if (size == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < size; i8++) {
            arrayList.add(new ArrayList());
        }
        int size2 = size / list.get(0).size();
        int i9 = size;
        for (int i10 = 0; i10 < list.size(); i10++) {
            List<Size> list2 = list.get(i10);
            for (int i11 = 0; i11 < size; i11++) {
                ((List) arrayList.get(i11)).add(list2.get((i11 % i9) / size2));
            }
            if (i10 < list.size() - 1) {
                i9 = size2;
                size2 /= list.get(i10 + 1).size();
            }
        }
        return arrayList;
    }

    @Nullable
    private Rational getAspectRatioGroupKeyOfTargetSize(@Nullable Size size, @NonNull List<Size> list) {
        if (size == null) {
            return null;
        }
        for (Rational rational : SupportedOutputSizesCollector.getResolutionListGroupingAspectRatioKeys(list)) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                return rational;
            }
        }
        return new Rational(size.getWidth(), size.getHeight());
    }

    @Nullable
    private Size[] getCustomizedSupportSizesFromConfig(int i8, @NonNull ImageOutputConfig imageOutputConfig) {
        List<Pair<Integer, Size[]>> supportedResolutions = imageOutputConfig.getSupportedResolutions(null);
        if (supportedResolutions == null) {
            return null;
        }
        for (Pair<Integer, Size[]> pair : supportedResolutions) {
            if (((Integer) pair.first).intValue() == i8) {
                return (Size[]) pair.second;
            }
        }
        return null;
    }

    public static int getMaxFramerate(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i8, Size size) {
        try {
            return (int) (1.0E9d / ((StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(i8, size));
        } catch (Exception unused) {
            return 0;
        }
    }

    @NonNull
    private Size getRecordSize() {
        try {
            int i8 = Integer.parseInt(this.mCameraId);
            CamcorderProfile camcorderProfile = this.mCamcorderProfileHelper.hasProfile(i8, 1) ? this.mCamcorderProfileHelper.get(i8, 1) : null;
            return camcorderProfile != null ? new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) : getRecordSizeByHasProfile(i8);
        } catch (NumberFormatException unused) {
            return getRecordSizeFromStreamConfigurationMap();
        }
    }

    @NonNull
    private Size getRecordSizeByHasProfile(int i8) {
        CamcorderProfile camcorderProfile;
        Size size = SizeUtil.RESOLUTION_480P;
        if (this.mCamcorderProfileHelper.hasProfile(i8, 10)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i8, 10);
        } else if (this.mCamcorderProfileHelper.hasProfile(i8, 8)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i8, 8);
        } else if (this.mCamcorderProfileHelper.hasProfile(i8, 12)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i8, 12);
        } else if (this.mCamcorderProfileHelper.hasProfile(i8, 6)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i8, 6);
        } else if (this.mCamcorderProfileHelper.hasProfile(i8, 5)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i8, 5);
        } else {
            camcorderProfile = this.mCamcorderProfileHelper.hasProfile(i8, 4) ? this.mCamcorderProfileHelper.get(i8, 4) : null;
        }
        return camcorderProfile != null ? new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) : size;
    }

    @NonNull
    private Size getRecordSizeFromStreamConfigurationMap() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
        }
        Size[] outputSizes = StreamConfigurationMapCompat.toStreamConfigurationMapCompat(streamConfigurationMap).getOutputSizes(MediaRecorder.class);
        if (outputSizes == null) {
            return SizeUtil.RESOLUTION_480P;
        }
        Arrays.sort(outputSizes, new CompareSizesByArea(true));
        for (Size size : outputSizes) {
            int width = size.getWidth();
            Size size2 = SizeUtil.RESOLUTION_1080P;
            if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                return size;
            }
        }
        return SizeUtil.RESOLUTION_480P;
    }

    private Rational getTargetAspectRatio(@NonNull ImageOutputConfig imageOutputConfig, @NonNull List<Size> list) {
        Rational rational;
        int i8 = new TargetAspectRatio().get(this.mCameraId, this.mCharacteristics);
        if (i8 == 0) {
            rational = this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_4_3 : AspectRatioUtil.ASPECT_RATIO_3_4;
        } else if (i8 == 1) {
            rational = this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_16_9 : AspectRatioUtil.ASPECT_RATIO_9_16;
        } else {
            if (i8 == 2) {
                Size sizeFetchMaxSize = fetchMaxSize(256);
                return new Rational(sizeFetchMaxSize.getWidth(), sizeFetchMaxSize.getHeight());
            }
            if (i8 != 3) {
                return null;
            }
            if (!imageOutputConfig.hasTargetAspectRatio()) {
                Size targetSize = getTargetSize(imageOutputConfig);
                if (targetSize != null) {
                    return getAspectRatioGroupKeyOfTargetSize(targetSize, list);
                }
                return null;
            }
            int targetAspectRatio = imageOutputConfig.getTargetAspectRatio();
            if (targetAspectRatio == -1) {
                return null;
            }
            if (targetAspectRatio == 0) {
                rational = this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_4_3 : AspectRatioUtil.ASPECT_RATIO_3_4;
            } else {
                if (targetAspectRatio != 1) {
                    Logger.e(TAG, "Undefined target aspect ratio: " + targetAspectRatio);
                    return null;
                }
                rational = this.mIsSensorLandscapeResolution ? AspectRatioUtil.ASPECT_RATIO_16_9 : AspectRatioUtil.ASPECT_RATIO_9_16;
            }
        }
        return rational;
    }

    @Nullable
    private Size getTargetSize(@NonNull ImageOutputConfig imageOutputConfig) {
        return SupportedOutputSizesCollector.flipSizeByRotation(imageOutputConfig.getTargetResolution(null), imageOutputConfig.getTargetRotation(0), this.mLensFacing, this.mSensorOrientation);
    }

    private int getUpdatedMaximumFps(int i8, int i9, Size size) {
        return Math.min(i8, getMaxFramerate(this.mCharacteristics, i9, size));
    }

    private Range<Integer> getUpdatedTargetFramerate(Range<Integer> range, Range<Integer> range2) {
        if (range2 == null) {
            return range;
        }
        if (range != null) {
            try {
                return range2.intersect(range);
            } catch (IllegalArgumentException unused) {
            }
        }
        return range2;
    }

    private List<Integer> getUseCasesPriorityOrder(List<UseCaseConfig<?>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<UseCaseConfig<?>> it = list.iterator();
        while (it.hasNext()) {
            int surfaceOccupancyPriority = it.next().getSurfaceOccupancyPriority(0);
            if (!arrayList2.contains(Integer.valueOf(surfaceOccupancyPriority))) {
                arrayList2.add(Integer.valueOf(surfaceOccupancyPriority));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            for (UseCaseConfig<?> useCaseConfig : list) {
                if (iIntValue == useCaseConfig.getSurfaceOccupancyPriority(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(useCaseConfig)));
                }
            }
        }
        return arrayList;
    }

    private void refreshPreviewSize() {
        this.mDisplayInfoManager.refresh();
        if (this.mSurfaceSizeDefinition == null) {
            generateSurfaceSizeDefinition();
        } else {
            this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(this.mSurfaceSizeDefinition.getAnalysisSize(), this.mDisplayInfoManager.getPreviewSize(), this.mSurfaceSizeDefinition.getRecordSize());
        }
    }

    public boolean checkSupported(List<SurfaceConfig> list) {
        Iterator<SurfaceCombination> it = this.mSurfaceCombinations.iterator();
        boolean zIsSupported = false;
        while (it.hasNext() && !(zIsSupported = it.next().isSupported(list))) {
        }
        return zIsSupported;
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public Size getMaxOutputSizeByFormat(int i8) {
        return (Size) Collections.max(Arrays.asList(getAllOutputSizesByFormat(i8)), new CompareSizesByArea());
    }

    @NonNull
    public Map<UseCaseConfig<?>, StreamSpec> getSuggestedStreamSpecifications(@NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2) {
        refreshPreviewSize();
        ArrayList arrayList = new ArrayList();
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSurfaceConfig());
        }
        Iterator<UseCaseConfig<?>> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(SurfaceConfig.transformSurfaceConfig(it2.next().getInputFormat(), new Size(640, 480), this.mSurfaceSizeDefinition));
        }
        if (!checkSupported(arrayList)) {
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.mCameraId + ".  May be attempting to bind too many use cases. Existing surfaces: " + list + " New configs: " + list2);
        }
        List<Size> list3 = null;
        Range<Integer> updatedTargetFramerate = null;
        int updatedMaximumFps = Integer.MAX_VALUE;
        for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
            updatedTargetFramerate = getUpdatedTargetFramerate(attachedSurfaceInfo.getTargetFrameRate(), updatedTargetFramerate);
            updatedMaximumFps = getUpdatedMaximumFps(updatedMaximumFps, attachedSurfaceInfo.getImageFormat(), attachedSurfaceInfo.getSize());
        }
        List<Integer> useCasesPriorityOrder = getUseCasesPriorityOrder(list2);
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it3 = useCasesPriorityOrder.iterator();
        while (it3.hasNext()) {
            arrayList2.add(getSupportedOutputSizes(list2.get(it3.next().intValue())));
        }
        List<List<Size>> allPossibleSizeArrangements = getAllPossibleSizeArrangements(arrayList2);
        Iterator<Integer> it4 = useCasesPriorityOrder.iterator();
        while (it4.hasNext()) {
            updatedTargetFramerate = getUpdatedTargetFramerate(list2.get(it4.next().intValue()).getTargetFramerate(null), updatedTargetFramerate);
        }
        Iterator<List<Size>> it5 = allPossibleSizeArrangements.iterator();
        int i8 = Integer.MAX_VALUE;
        while (it5.hasNext()) {
            List<Size> next = it5.next();
            ArrayList arrayList3 = new ArrayList();
            Iterator<AttachedSurfaceInfo> it6 = list.iterator();
            while (it6.hasNext()) {
                arrayList3.add(it6.next().getSurfaceConfig());
            }
            int updatedMaximumFps2 = updatedMaximumFps;
            int i9 = 0;
            while (i9 < next.size()) {
                Size size = next.get(i9);
                List<Size> list4 = list3;
                UseCaseConfig<?> useCaseConfig = list2.get(useCasesPriorityOrder.get(i9).intValue());
                arrayList3.add(SurfaceConfig.transformSurfaceConfig(useCaseConfig.getInputFormat(), size, this.mSurfaceSizeDefinition));
                updatedMaximumFps2 = getUpdatedMaximumFps(updatedMaximumFps2, useCaseConfig.getInputFormat(), size);
                i9++;
                it5 = it5;
                list3 = list4;
                next = next;
            }
            List<Size> list5 = list3;
            Iterator<List<Size>> it7 = it5;
            List<Size> list6 = next;
            boolean z2 = updatedTargetFramerate == null || updatedMaximumFps <= updatedMaximumFps2 || updatedMaximumFps2 >= ((Integer) updatedTargetFramerate.getLower()).intValue();
            if (checkSupported(arrayList3)) {
                if (i8 != Integer.MAX_VALUE && i8 >= updatedMaximumFps2) {
                    list3 = list5;
                } else {
                    i8 = updatedMaximumFps2;
                    list3 = list6;
                }
                if (z2) {
                    list3 = list6;
                    break;
                }
            } else {
                list3 = list5;
            }
            it5 = it7;
        }
        if (list3 != null) {
            HashMap map = new HashMap();
            for (UseCaseConfig<?> useCaseConfig2 : list2) {
                map.put(useCaseConfig2, StreamSpec.builder(list3.get(useCasesPriorityOrder.indexOf(Integer.valueOf(list2.indexOf(useCaseConfig2))))).build());
            }
            return map;
        }
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.mCameraId + " and Hardware level: " + this.mHardwareLevel + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list + " New configs: " + list2);
    }

    @NonNull
    @VisibleForTesting
    public List<Size> getSupportedOutputSizes(@NonNull UseCaseConfig<?> useCaseConfig) {
        int inputFormat = useCaseConfig.getInputFormat();
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        List<Size> customOrderedResolutions = imageOutputConfig.getCustomOrderedResolutions(null);
        if (customOrderedResolutions != null) {
            return customOrderedResolutions;
        }
        ResolutionSelector resolutionSelector = imageOutputConfig.getResolutionSelector(null);
        if (resolutionSelector != null) {
            Size defaultResolution = imageOutputConfig.getDefaultResolution(null);
            if (resolutionSelector.getPreferredResolution() != null) {
                defaultResolution = SupportedOutputSizesCollector.getTargetSizeByResolutionSelector(resolutionSelector, this.mDisplayInfoManager.getMaxSizeDisplay().getRotation(), this.mSensorOrientation, this.mLensFacing);
            }
            return this.mSupportedOutputSizesCollector.getSupportedOutputSizes(resolutionSelector, inputFormat, defaultResolution, useCaseConfig.isHigResolutionDisabled(false), getCustomizedSupportSizesFromConfig(inputFormat, imageOutputConfig));
        }
        Size[] customizedSupportSizesFromConfig = getCustomizedSupportSizesFromConfig(inputFormat, imageOutputConfig);
        if (customizedSupportSizesFromConfig == null) {
            customizedSupportSizesFromConfig = getAllOutputSizesByFormat(inputFormat);
        }
        Size[] sizeArrExcludeProblematicSizesAndSort = excludeProblematicSizesAndSort(customizedSupportSizesFromConfig, inputFormat);
        ArrayList arrayList = new ArrayList();
        Size maxResolution = imageOutputConfig.getMaxResolution(null);
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(inputFormat);
        if (maxResolution == null || SizeUtil.getArea(maxOutputSizeByFormat) < SizeUtil.getArea(maxResolution)) {
            maxResolution = maxOutputSizeByFormat;
        }
        Arrays.sort(sizeArrExcludeProblematicSizesAndSort, new CompareSizesByArea(true));
        Size targetSize = getTargetSize(imageOutputConfig);
        Size size = SizeUtil.RESOLUTION_VGA;
        int area = SizeUtil.getArea(size);
        if (SizeUtil.getArea(maxResolution) < area) {
            size = SizeUtil.RESOLUTION_ZERO;
        } else if (targetSize != null && SizeUtil.getArea(targetSize) < area) {
            size = targetSize;
        }
        for (Size size2 : sizeArrExcludeProblematicSizesAndSort) {
            if (SizeUtil.getArea(size2) <= SizeUtil.getArea(maxResolution) && SizeUtil.getArea(size2) >= SizeUtil.getArea(size) && !arrayList.contains(size2)) {
                arrayList.add(size2);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException(a1.a.o(inputFormat, "Can not get supported output size under supported maximum for the format: "));
        }
        Rational targetAspectRatio = getTargetAspectRatio(imageOutputConfig, arrayList);
        if (targetSize == null) {
            targetSize = imageOutputConfig.getDefaultResolution(null);
        }
        ArrayList arrayList2 = new ArrayList();
        new HashMap();
        if (targetAspectRatio == null) {
            arrayList2.addAll(arrayList);
            if (targetSize != null) {
                SupportedOutputSizesCollector.removeSupportedSizesByMiniBoundingSize(arrayList2, targetSize);
            }
        } else {
            Map<Rational, List<Size>> mapGroupSizesByAspectRatio = SupportedOutputSizesCollector.groupSizesByAspectRatio(arrayList);
            if (targetSize != null) {
                Iterator<Rational> it = mapGroupSizesByAspectRatio.keySet().iterator();
                while (it.hasNext()) {
                    SupportedOutputSizesCollector.removeSupportedSizesByMiniBoundingSize(mapGroupSizesByAspectRatio.get(it.next()), targetSize);
                }
            }
            ArrayList arrayList3 = new ArrayList(mapGroupSizesByAspectRatio.keySet());
            Collections.sort(arrayList3, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(targetAspectRatio, this.mActiveArraySize != null ? new Rational(this.mActiveArraySize.getWidth(), this.mActiveArraySize.getHeight()) : null));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                for (Size size3 : mapGroupSizesByAspectRatio.get((Rational) it2.next())) {
                    if (!arrayList2.contains(size3)) {
                        arrayList2.add(size3);
                    }
                }
            }
        }
        return this.mResolutionCorrector.insertOrPrioritize(SurfaceConfig.getConfigType(useCaseConfig.getInputFormat()), arrayList2);
    }

    public boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    public boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    public SurfaceConfig transformSurfaceConfig(int i8, Size size) {
        return SurfaceConfig.transformSurfaceConfig(i8, size, this.mSurfaceSizeDefinition);
    }
}
