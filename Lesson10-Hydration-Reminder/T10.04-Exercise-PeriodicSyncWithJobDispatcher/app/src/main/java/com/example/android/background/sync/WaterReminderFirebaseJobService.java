/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.background.sync;

import android.os.AsyncTask;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class WaterReminderFirebaseJobService extends JobService {

    AsyncTask mBackgroundTask;

    @Override
    public boolean onStartJob(final JobParameters job) {
        // TODO (3) WaterReminderFirebaseJobService should extend from firebase JobService

        // TODO (4) Override onStartJob
        // TODO (5) By default, jobs are executed on the main thread, so make an anonymous class extending
        //  AsyncTask called mBackgroundTask.

        mBackgroundTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                // TODO (6) Override doInBackground
                // TODO (7) Use ReminderTasks to execute the new charging reminder task you made, use
                // this service as the context (WaterReminderFirebaseJobService.this) and return null
                // when finished.

                // This task is not really that intensive but this is about learning.
                ReminderTasks.executeTask(
                        WaterReminderFirebaseJobService.this, ReminderTasks.ACTION_INCREMENT_CHARGE_REMINDER);

                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                // TODO (8) Override onPostExecute and called jobFinished. Pass the job parameters
                // and false to jobFinished. This will inform the JobManager that your job is done
                // and that you do not want to reschedule the job.

                super.onPostExecute(o);

                jobFinished(job,  false);
            }
        };

        // TODO (9) Execute the AsyncTask
        mBackgroundTask.execute();

        // TODO (10) Return true
        return true;  // Means that there is still stuff executing

    }

    @Override
    public boolean onStopJob(JobParameters job) {
    // TODO (11) Override onStopJob
        // TODO (12) If mBackgroundTask is valid, cancel it
        if (mBackgroundTask != null) {
            boolean interruptIfRunning = true;

            mBackgroundTask.cancel(interruptIfRunning);
        }

        // TODO (13) Return true to signify the job should be retried
        return true;
    }
}
