package com.gnoemes.bullhorn.ui.Main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gnoemes.bullhorn.Common.BaseActivity;
import com.gnoemes.bullhorn.R;
import com.gnoemes.bullhorn.di.Components.AppComponent;
import com.gnoemes.bullhorn.di.Components.DaggerMainComponent;
import com.gnoemes.bullhorn.di.Components.MainComponent;
import com.gnoemes.bullhorn.di.Modules.ActivityModule.MainModule;
import com.gnoemes.bullhorn.ui.NewsFragments.SourceFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, IMainView{

    @Inject
    IMainPresenter presenter;

    private MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void setupComponent(AppComponent upComponent) {
        mainComponent = DaggerMainComponent.builder()
                .appComponent(upComponent)
                .mainModule(new MainModule(this))
                .build();
        mainComponent.inject(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_general:
                loadFragment("general");
                break;
            case R.id.nav_politics:
                loadFragment("politics");
                break;
            case R.id.nav_sport:
                loadFragment("sport");
                break;
            case R.id.nav_entertainment:
                loadFragment("entertainment");
                break;
            case R.id.nav_gaming:
                loadFragment("gaming");
                break;
            case R.id.nav_science:
                loadFragment("science-and-nature");
                break;
            case R.id.nav_technologies:
                loadFragment("technology");
                break;
            case R.id.nav_business:
                loadFragment("business");
                break;
            case R.id.nav_music:
                loadFragment("music");
                break;


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(String category) {

        SourceFragment fragment = new SourceFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.source_container, fragment,category).commit();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

}
