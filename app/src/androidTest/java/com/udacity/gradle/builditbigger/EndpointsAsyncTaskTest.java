package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by dejan on 19/03/16.
 */

public class EndpointsAsyncTaskTest extends AndroidTestCase {

    public void testJokeDownload() {

        try {
            EndpointsAsyncTask task = new EndpointsAsyncTask();
            //noinspection unchecked
            task.execute();

            String joke = task.get(10, TimeUnit.SECONDS);

            assertNotNull("Returned joke string should not be null.", joke);

            assertTrue("Returned joke string should not be empty string.", ! joke.equals(""));

        } catch (Exception e) {
            fail("AsyncTask timeout. Stopping functional tests...");
        }
    }

}
