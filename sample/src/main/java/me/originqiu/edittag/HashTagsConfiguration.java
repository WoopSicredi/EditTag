package me.originqiu.edittag;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.List;

public class HashTagsConfiguration extends BaseObservable {

    private List<String> hashTags = new ArrayList<>();

    private TextWatcher tagTextWatcher;

    @Bindable
    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<String> hashTags) {
        this.hashTags = hashTags;
        notifyPropertyChanged(BR.hashTags);
    }

    public void addHashTag(String hashTag){
        this.hashTags.add(hashTag);
    }

    public void addAllHashTags(List<String> hashTags){
        this.hashTags.addAll(hashTags);
    }

    @Bindable
    public TextWatcher getTagTextWatcher() {
        return tagTextWatcher;
    }

    public void setTagTextWatcher(TextWatcher tagTextWatcher) {
        this.tagTextWatcher = tagTextWatcher;
        notifyPropertyChanged(BR.tagTextWatcher);
    }
}
