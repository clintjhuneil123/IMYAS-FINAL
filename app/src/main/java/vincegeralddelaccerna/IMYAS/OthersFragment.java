package vincegeralddelaccerna.IMYAS;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import vincegeralddelaccerna.ezwheels.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OthersFragment extends Fragment {


    public OthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_others, container, false);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) v.findViewById(R.id.bottomnav1);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        final FavoriteFragment favoriteFragment = new FavoriteFragment();
        final TradeinFragment tradeinFragment = new TradeinFragment();
        final DashboardFragment dashboardFragment = new DashboardFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.favorites){
                    setFragment(favoriteFragment);
                    return true;
                }

                if(id == R.id.tradein){
                    setFragment(tradeinFragment);
                    return  true;
                }

                if(id == R.id.home){
                    Intent intent = new Intent(getActivity(), DashBoard.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.favorites);
        return v;
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.screen_area1, fragment);
        fragmentTransaction.commit();
    }

}
