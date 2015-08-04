package com.android.pet.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.doepiccoding.navigationdrawer.R;

public class NavigationActivity extends FragmentActivity {

	private DrawerLayout mDrawerLayout;
	ImageView home;
	Fragment fragment = null;
	TextView appname;
	ExpandableListView expListView;
	HashMap<String, List<String>> listDataChild;
	ExpandableListAdapter listAdapter;
	List<String> listDataHeader;

	// HEADER ARRAY LIST CONTAINING NAME/IMAGE/CHILD ARRAYLIST
	ArrayList<HeaderBean> mHeaderList;

	// CHILD ARRAY LIST CONTAINING NAME/IMAGE
	ArrayList<ChildBean> mChildList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String fontPath = "fonts/Shadow Boxing.ttf";
		setContentView(R.layout.activity_navigation);
		home = (ImageView) findViewById(R.id.home);
		home.setOnClickListener(homeOnclickListener);
		appname = (TextView) findViewById(R.id.appname);
		Typeface tf = Typeface.createFromAsset(this.getAssets(), fontPath);
		appname.setTypeface(tf);
		setUpDrawer();
	}

	/**
	 * 
	 * Get the names and icons references to build the drawer menu...
	 */
	private void setUpDrawer() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.setScrimColor(getResources().getColor(
				android.R.color.transparent));
		mDrawerLayout.setDrawerListener(mDrawerListener);
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// HIDE THE INDICATOR ON THE LEFT SIDE
		expListView.setGroupIndicator(null);

		// prepareListData();
		prepareNewListData();

		listAdapter = new ExpandableListAdapter(this, mHeaderList, mChildList);

		// setting list adapter
		expListView.setAdapter(listAdapter);
		fragment = new MercuryFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		mDrawerLayout.closeDrawer(expListView);

		expListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				switch (groupPosition) {
				case 0:
					switch (childPosition) {
					case 0:
						fragment = new MercuryFragment();
						break;
					case 1:
						fragment = new VenusFragment();
						break;
					case 2:
						fragment = new EarthFragment();
						break;
					default:
						break;
					}
					break;

				case 1:
					switch (childPosition) {
					case 0:
						fragment = new MercuryFragment();
						break;
					case 1:
						fragment = new VenusFragment();
						break;
					case 2:
						fragment = new EarthFragment();
						break;
					default:
						break;
					}
					break;

				case 2:
					switch (childPosition) {
					case 0:
						fragment = new MercuryFragment();
						break;
					case 1:
						fragment = new VenusFragment();
						break;
					case 2:
						fragment = new EarthFragment();
						break;
					default:
						break;
					}
					break;

				default:
					break;
				}
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, fragment).commit();
				mDrawerLayout.closeDrawer(expListView);
				return false;
			}
		});
	}

	View.OnClickListener homeOnclickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mDrawerLayout.isDrawerOpen(expListView)) {
				mDrawerLayout.closeDrawer(expListView);
			} else {
				mDrawerLayout.openDrawer(expListView);
			}
		}
	};

	private OnItemClickListener mDrawerItemClickedListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {

			switch (position) {
			case 0:
				fragment = new MercuryFragment();
				break;
			case 1:
				fragment = new VenusFragment();
				break;
			case 2:
				fragment = new EarthFragment();
				break;
			default:
				return;
			}

			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();

			mDrawerLayout.closeDrawer(expListView);
		}
	};

	// Catch the events related to the drawer to arrange views according to this
	// action if necessary...
	private DrawerListener mDrawerListener = new DrawerListener() {

		@Override
		public void onDrawerStateChanged(int status) {

		}

		@Override
		public void onDrawerSlide(View view, float slideArg) {

		}

		@Override
		public void onDrawerOpened(View view) {
		}

		@Override
		public void onDrawerClosed(View view) {
		}
	};

	// TO PREPARE THE NEW LIST DATA
	private void prepareNewListData() {
		mHeaderList = new ArrayList<HeaderBean>();

		// Batsman
		ArrayList<ChildBean> mChildListBatsman = new ArrayList<ChildBean>();

		// FILLING THE CHILD ARRAY LIST FIRST
		mChildListBatsman
				.add(new ChildBean("V. Kohli", R.drawable.ic_launcher));
		mChildListBatsman.add(new ChildBean("G.J. Bailey",
				R.drawable.ic_launcher));
		mChildListBatsman
				.add(new ChildBean("H.M. Amla", R.drawable.ic_launcher));

		// ADDING THE CHILD ARRAYLIST, NAME AND IMAGE IN THE HEADER ARRAYLIST
		mHeaderList
				.add(new HeaderBean("Batsman",
						R.drawable.ic_keyboard_arrow_down_black_48dp,
						mChildListBatsman));

		// Bowler
		ArrayList<ChildBean> mChildListBowler = new ArrayList<ChildBean>();

		// FILLING THE CHILD ARRAY LIST FIRST
		mChildListBowler
				.add(new ChildBean("D.W. Steyn", R.drawable.ic_launcher));
		mChildListBowler.add(new ChildBean("J.M. Anderson",
				R.drawable.ic_launcher));
		mChildListBowler.add(new ChildBean("M.G. Johnson",
				R.drawable.ic_launcher));

		// ADDING THE CHILD ARRAYLIST, NAME AND IMAGE IN THE HEADER ARRAYLIST
		mHeaderList
				.add(new HeaderBean("Bowler",
						R.drawable.ic_keyboard_arrow_down_black_48dp,
						mChildListBowler));

		// All rounder
		ArrayList<ChildBean> mChildListAll = new ArrayList<ChildBean>();

		// FILLING THE CHILD ARRAY LIST FIRST
		mChildListAll
				.add(new ChildBean("ALL ROUNDER 1", R.drawable.ic_launcher));
		mChildListAll
				.add(new ChildBean("ALL ROUNDER 2", R.drawable.ic_launcher));
		mChildListAll
				.add(new ChildBean("ALL ROUNDER 3", R.drawable.ic_launcher));

		// ADDING THE CHILD ARRAYLIST, NAME AND IMAGE IN THE HEADER ARRAYLIST
		mHeaderList.add(new HeaderBean("ALL ROUNDER",
				R.drawable.ic_keyboard_arrow_down_black_48dp, mChildListAll));

		// Wicket Keeper
		ArrayList<ChildBean> mChildListWk = new ArrayList<ChildBean>();

		// FILLING THE CHILD ARRAY LIST FIRST
		mChildListWk.add(new ChildBean("WICKET KEEPER 1",
				R.drawable.ic_launcher));
		mChildListWk.add(new ChildBean("WICKET KEEPER 2",
				R.drawable.ic_launcher));
		mChildListWk.add(new ChildBean("WICKET KEEPER 3",
				R.drawable.ic_launcher));

		// ADDING THE CHILD ARRAYLIST, NAME AND IMAGE IN THE HEADER ARRAYLIST
		mHeaderList.add(new HeaderBean("WICKET KEEPER",
				R.drawable.ic_keyboard_arrow_down_black_48dp, mChildListWk));
	}

	public class ExpandableListAdapter extends BaseExpandableListAdapter {

		private Context _context;
		private List<String> _listDataHeader; // header titles
		// child data in format of header title, child title
		private HashMap<String, List<String>> _listDataChild;

		private ArrayList<HeaderBean> _HeaderList;
		private ArrayList<ChildBean> _ChildList;

		public ExpandableListAdapter(Context context,
				ArrayList<HeaderBean> _HeaderList,
				ArrayList<ChildBean> _ChildList) {
			this._context = context;
			this._HeaderList = _HeaderList;
			this._ChildList = _ChildList;
		}

		@Override
		public Object getChild(int groupPosition, int childPosititon) {

			// Return child object from each header item
			return this._HeaderList.get(groupPosition).getmChildBean()
					.get(childPosititon);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, final int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {

			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this._context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.list_item, null);
			}

			TextView txtListChild = (TextView) convertView
					.findViewById(R.id.lblListItem);
			ImageView mChildImage = (ImageView) convertView
					.findViewById(R.id.child_image);

			// INSTEAD WE DIRECTLY TAKE THE NAME AND IMAGE FROM THE ARRAY LIST
			txtListChild.setText(_HeaderList.get(groupPosition).getmChildBean()
					.get(childPosition).getmChildName());

			// SET IMAGE
			mChildImage.setImageResource(_HeaderList.get(groupPosition)
					.getmChildBean().get(childPosition).getmChildImage());
			return convertView;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return this._HeaderList.get(groupPosition).getmChildBean().size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			return this._HeaderList.get(groupPosition);

		}

		@Override
		public int getGroupCount() {
			return this._HeaderList.size();

		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, final boolean isExpanded,
				View convertView, ViewGroup parent) {

			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this._context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.list_group, null);
			}

			TextView lblListHeader = (TextView) convertView
					.findViewById(R.id.lblListHeader);

			final ImageView mHeaderImage = (ImageView) convertView
					.findViewById(R.id.group_image);

			lblListHeader.setTypeface(null, Typeface.BOLD);
			lblListHeader.setText(_HeaderList.get(groupPosition)
					.getmHeaderName());

			// TO SET IMAGE INITIAL(OPTIONAL)
			mHeaderImage.setImageResource(_HeaderList.get(groupPosition)
					.getmHeaderImage());

			if (isExpanded) {
				mHeaderImage
						.setImageResource(R.drawable.ic_keyboard_arrow_up_black_48dp);
			} else {
				mHeaderImage
						.setImageResource(R.drawable.ic_keyboard_arrow_down_black_48dp);
			}

			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}
}
