package com.natanek.test;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Marcin Natanek on 10.06.2016.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
@SmallTest
public class UITest {
    public static String TAG = "NATAN";

    private static final int LAUNCH_TIMEOUT = 5000;
    private UiDevice mDevice;
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.xxmassdeveloper.mpchartexample";


    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assert (launcherPackage != null);
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }

    @Test
    public void testListChart() {
        UiObject appItem = new UiObject(new UiSelector().textContains("Line"));
        assert (appItem != null);
        try {
            appItem.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            assert (false);
        }

    }

    @Test
    public void testBarChart() {
        UiObject appItem = new UiObject(new UiSelector().textContains("Bar"));
        assert (appItem != null);
        try {
            appItem.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            assert (false);
        }

    }

    @Test
    public void testCombinedChart() {
        UiObject appItem = new UiObject(new UiSelector().textContains("Combined"));
        assert (appItem != null);
        try {
            appItem.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            assert (false);
        }

    }

    @Test
    public void testPieChart() {
        UiObject appItem = new UiObject(new UiSelector().textContains("Pie"));
        assert (appItem != null);
        try {
            appItem.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            assert (false);
        }

    }

    @Test
    public void testScatterChart() {
        UiObject appItem = new UiObject(new UiSelector().textContains("Scatter"));
        assert (appItem != null);
        try {
            appItem.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            assert (false);
        }

    }

}
