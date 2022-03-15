package org.edx.mobile.test.feature;

import android.app.Application;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.edx.mobile.base.MainApplication;
import org.edx.mobile.core.EdxDefaultModule;
import org.edx.mobile.core.IEdxEnvironment;
import org.junit.Before;
import org.junit.runner.RunWith;

import dagger.hilt.android.EntryPointAccessors;

@RunWith(AndroidJUnit4.class)
public abstract class FeatureTest {
    protected IEdxEnvironment environment;

    @Before
    public void setup() {
        // Ensure we are not logged in
        final Application application = MainApplication.instance();
        environment = EntryPointAccessors
                .fromApplication(application.getApplicationContext(), EdxDefaultModule.ProviderEntryPoint.class).getEnvironment();
        environment.getLoginPrefs().clear();
        environment.getAnalyticsRegistry().resetIdentifyUser();
    }
}
