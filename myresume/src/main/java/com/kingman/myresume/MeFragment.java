package com.kingman.myresume;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingman.myresume.models.EducationInfo;
import com.kingman.myresume.models.PersonBaseInfo;
import com.kingman.myresume.views.AutoExpansionListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-lijinwei.a on 2016/5/24.
 */
public class MeFragment extends Fragment {
    TextView accountName;
    AutoExpansionListView listview1;
    AutoExpansionListView listview2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_me, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViewById();

        initView();
    }

    private void findViewById() {
        accountName = (TextView) getActivity().findViewById(R.id.textview_home_setttings_header_accountname);
        listview1 = (AutoExpansionListView) getActivity().findViewById(R.id.listview_home_settings_list1);
        listview2 = (AutoExpansionListView) getActivity().findViewById(R.id.listview_home_settings_list2);
    }

    private void initView() {
        this.accountName.setText(Utils.getGreeting(getActivity()) + ", Kingman");
        List<PersonBaseInfo> data1 = new ArrayList<>();
        data1.add(new PersonBaseInfo(R.drawable.btn_tab_comment, "姓名", "李金伟"));
        data1.add(new PersonBaseInfo(R.drawable.btn_tab_comment, "性别", "男"));
        data1.add(new PersonBaseInfo(R.drawable.btn_tab_comment, "籍贯", "中国河南"));
        data1.add(new PersonBaseInfo(R.drawable.btn_tab_comment, "学历", "硕士"));
        final PersonInfoAdatper adatper1 = new PersonInfoAdatper(getActivity(),data1);
        this.listview1.setAdapter(adatper1);


        List<EducationInfo> data2 = new ArrayList<>();
        data2.add(new EducationInfo("2008/9", "2012/7", "清华大学", "心理学", "硕士"));
        data2.add(new EducationInfo("2004/9", "2008/7", "南京大学", "计算机科学与计算", "本科"));
        final EducationAdatper adatper2 = new EducationAdatper(getActivity(), data2);
        listview2.setAdapter(adatper2);
    }

    private class PersonInfoAdatper extends BaseAdapter {
        LayoutInflater inflater;
        private List<PersonBaseInfo> list;

        public PersonInfoAdatper(Context context, List<PersonBaseInfo> list) {
            inflater =  ((Activity) context).getLayoutInflater();
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            TextView textView;
            TextView value;
            if (null == convertView){
                convertView = inflater.inflate(R.layout.listitem_personinfo, parent, false);
            }
            imageView = (ImageView) convertView.findViewById(R.id.imageview_home_settings_settinglist_icon);
            textView = (TextView) convertView.findViewById(R.id.textview_home_setttings_settinglist_title);
            value = (TextView) convertView.findViewById(R.id.textview_home_setttings_settinglist_value);

            imageView.setImageResource(list.get(position).getImgID());
            textView.setText(list.get(position).getTitle());
            value.setText(list.get(position).getValue());
            return convertView;
        }
    }

    private class EducationAdatper extends BaseAdapter {
        LayoutInflater inflater;
        private List<EducationInfo> list;

        public EducationAdatper(Context context, List<EducationInfo> list) {
            inflater =  ((Activity) context).getLayoutInflater();
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView fromTo;
            TextView school;
            TextView profession;
            TextView education;

            if (null == convertView){
                convertView = inflater.inflate(R.layout.listitem_education, parent, false);
            }
            fromTo = (TextView) convertView.findViewById(R.id.textview_from_to);
            school = (TextView) convertView.findViewById(R.id.textview_school);
            profession = (TextView) convertView.findViewById(R.id.textview_profession);
            education = (TextView) convertView.findViewById(R.id.textview_education);

            fromTo.setText(list.get(position).getStartYear() + " - " + list.get(position).getEndYear() );
            school.setText(list.get(position).getSchool());
            profession.setText(list.get(position).getProfession());
            education.setText(list.get(position).getEducation());
            return convertView;
        }
    }
}
