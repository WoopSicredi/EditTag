package me.originqiu.edittag;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setVariable(BR.viewModel, new MainViewModel());
    }
}