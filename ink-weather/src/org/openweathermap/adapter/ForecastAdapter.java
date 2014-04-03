package org.openweathermap.adapter;

import java.util.ArrayList;
import java.util.List;

import org.openweathermap.dto.DayDTO;
import org.openweathermap.dto.ResultDTO;
import org.openweathermap.fragment.ForecastFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ForecastAdapter extends FragmentPagerAdapter {
	private List<Fragment> mFragments;
	
	public ForecastAdapter(FragmentManager fragmentManager, ResultDTO resultDTO) {
		super(fragmentManager);
		
		mFragments = new ArrayList<Fragment>();
		
		DayDTO[] dayDTOArray = resultDTO.getDay();
		for (int i = 0; i < dayDTOArray.length; i++) {
			Bundle args = new Bundle();
			args.putInt(ForecastFragment.ARG_DATA_POSITION, i);
			ForecastFragment forecastFragment = new ForecastFragment();
			forecastFragment.setArguments(args);
			mFragments.add(forecastFragment);
		}
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}
}
