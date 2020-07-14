package com.lucine.toread;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.lucine.toread.model.ToReads;
import com.lucine.toread.utils.Utils;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.lucine.toread", appContext.getPackageName());
    }

    @Test
    public void loadToReads() throws IOException, JSONException {
        String content = "[{\"title\":\"计算广告\",\"douban\": 9.0},{\"title\":\"智能商业\",\"douban\": 7.9}]";

        ToReads reads = new ToReads(content);

        assertEquals(2, reads.GetItems().size());
        assertEquals("计算广告", reads.GetItems().get(0).GetTitle());
        assertEquals(9, reads.GetItems().get(0).GetDoubanStar(), 1e-9);
    }
}