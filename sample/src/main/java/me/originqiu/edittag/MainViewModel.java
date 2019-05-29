package me.originqiu.edittag;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.originqiu.library.EditTag;

public class MainViewModel extends BaseObservable {

    @Bindable
    public HashTagsConfiguration configuration;

    public MainViewModel() {

        List list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        final List list2 = new ArrayList<String>();
        list2.add("e");
        list2.add("f");
        list2.add("g");
        list2.add("h");

        this.configuration = new HashTagsConfiguration();
        this.configuration.setHashTags(list);
        this.configuration.setTagTextWatcher(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("TAG", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                configuration.addHashTag("new HashTag");

                notifyPropertyChanged(BR.configuration);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                configuration.setHashTags(list2);

                notifyPropertyChanged(BR.configuration);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", configuration.getHashTags().toString());
            }
        }, 3000);
    }

    @BindingAdapter("hashTags")
    public static void hashTags(EditTag editTag, HashTagsConfiguration hashTagsConfiguration) {
        editTag.setTagList(hashTagsConfiguration.getHashTags());
        editTag.addTagTextWatcher(hashTagsConfiguration.getTagTextWatcher());
    }
}
