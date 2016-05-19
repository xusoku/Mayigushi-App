package com.tzf.libo.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tzf.libo.R;
import com.tzf.libo.fragment.IncomeEditFragment;

/**
 * @author tangzhifei on 15/11/29.
 */
public class IncomeEditActivity extends BaseActivity {

    private int id;

    private IncomeEditFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        id = getIntent().getIntExtra("id", 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(0 != id ? "编辑" : "添加");
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });

        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        fragment = IncomeEditFragment.newInstance();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.income_edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.done == item.getItemId()) {
            fragment.updateIncome();
        }
        return super.onOptionsItemSelected(item);
    }

}