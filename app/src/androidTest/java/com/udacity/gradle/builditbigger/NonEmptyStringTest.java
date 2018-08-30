package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

@RunWith(AndroidJUnit4.class)
public class NonEmptyStringTest {

    @Test
    public void EndpointsAsyncTaskTest() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);

        new EndpointsAsyncTask(InstrumentationRegistry.getContext()){
            @Override
            protected void onPostExecute(String s) {
                Assert.assertNotEquals("", s);
                Assert.assertNotNull(s);
                signal.countDown();
            }
        }.execute();
        signal.await();
    }
}

