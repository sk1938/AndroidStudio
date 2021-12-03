package com.example.mydiary;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DiaryAdapter extends BaseAdapter{
    ImageView imageDiary,imageView;

    List<DiaryVO> data;
    public DiaryAdapter(){};
    public DiaryAdapter(List<DiaryVO> data){
        this.data =data;
    }

    @Override
    public int getCount() {
        return data.size();
    }
    @Override
    public Object getItem(int i) {
        return data.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtContext = view.findViewById(R.id.txtContent);
        imageDiary = view.findViewById(R.id.imageDiary);
        ImageView imageView = view.findViewById(R.id.imageView);
        txtTitle.setText(data.get(i).getTitle());
        txtContext.setText(data.get(i).getContent());
        Uri photoURI = Uri.parse("");
        imageDiary.setImageURI(photoURI);
        return view;
    }
}
