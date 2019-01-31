package vincegeralddelaccerna.IMYAS;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import vincegeralddelaccerna.ezwheels.R;

public class ShopDashboard extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopdashboard);

        //firebase
        mAuth = FirebaseAuth.getInstance();

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        final ShopDashBoardFragment shopDashboard = new ShopDashBoardFragment();
        final ShopAddListing shopAddListing = new ShopAddListing();
        final ReservationFragment reservationFragment = new ReservationFragment();
        final SearchFragment searchFragment = new SearchFragment();
        final ShopothersFragment shopothersFragment = new ShopothersFragment();
        final ShopmyListings shopmyListings = new ShopmyListings();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.dashboard){
                    setFragment(shopDashboard);
                    return true;
                }

                if(id == R.id.listing){
                    setFragment(shopAddListing);
                    return  true;
                }
//
                if(id == R.id.mylisting){
                    setFragment(shopmyListings);
                    return  true;
                }

                if(id == R.id.others){
                    setFragment(shopothersFragment);
                    bottomNavigationView.setVisibility(View.GONE);
                    return  true;
                }
//
                if(id == R.id.profile){
                    //setFragment(profileFragment);
                    return  true;
                }



                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.dashboard);
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.screen_area, fragment);
        fragmentTransaction.commit();
    }
}
