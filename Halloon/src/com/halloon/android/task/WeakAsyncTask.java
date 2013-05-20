package com.halloon.android.task;

import java.lang.ref.WeakReference;

import android.os.AsyncTask;
import android.os.Build;

public abstract class WeakAsyncTask<Params, Progress, Result, WeakTarget> extends AsyncTask<Params, Progress, Result> {

	protected WeakReference<WeakTarget> mTarget;

	public WeakAsyncTask(WeakTarget target) {
		mTarget = new WeakReference<WeakTarget>(target);
	}

	@Override
	protected final void onPreExecute() {
		final WeakTarget target = mTarget.get();
		if (target != null) {
			this.onPreExecute(target);
		}
	}

	@Override
	protected final Result doInBackground(Params... params) {
		final WeakTarget target = mTarget.get();
		if (target != null) {
			return this.doInBackground(target, params);
		} else {
			return null;
		}
	}

	@Override
	protected void onPostExecute(Result result) {
		final WeakTarget target = mTarget.get();
		if (target != null) {
			this.onPostExecute(target, result);
		}
	}

	protected void onPreExecute(WeakTarget target) {

	}

	protected abstract Result doInBackground(WeakTarget target, Params... params);

	protected void onPostExecute(WeakTarget target, Result result) {

	}
	
	public void taskExecute(Params... params){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
			super.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
		}else{
			super.execute(params);
		}
	}

}
