/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.notes.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.common.base.Preconditions.checkNotNull;

public class ActivityUtils {

    private ActivityUtils() {
        // no instance
    }

    public static void showFragment(@NonNull FragmentManager fragmentManager, int containerResId,
                                    @NonNull Fragment fragment, String fragmentTag) {
        showFragment(fragmentManager, containerResId, fragment, fragmentTag, false);
    }

    public static void showFragment(@NonNull FragmentManager fragmentManager, int containerResId,
                                    @NonNull Fragment fragment, String fragmentTag,
                                    boolean addToBackStack) {
        showFragment(fragmentManager, containerResId, fragment, fragmentTag, addToBackStack, null);
    }

    public static void showFragment(@NonNull FragmentManager fragmentManager, int containerResId,
                                    @NonNull Fragment fragment, String fragmentTag,
                                    boolean addToBackStack, String nameOnBackstack) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerResId, fragment, fragmentTag);
        if (addToBackStack) {
            transaction.addToBackStack(nameOnBackstack);
        }
        transaction.commit();
    }

    public static <A extends Activity> A cast(Activity activity) {
        return (A) activity;
    }
}