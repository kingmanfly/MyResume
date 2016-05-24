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
import android.widget.ListView;
import android.widget.TextView;

import com.kingman.myresume.models.EducationInfo;
import com.kingman.myresume.models.PersonBaseInfo;
import com.kingman.myresume.views.AutoExpansionListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-lijinwei.a on 2016/5/24.
 */
public class KnowledgeFragment extends Fragment {
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_knowledge, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViewById();
        initView();

    }

    private void initView() {
        List<String> data1 = new ArrayList<>();
        data1.add("20160523_阻止Back键关闭Dialog");
        data1.add("20160518_android studio 修改包名");
        data1.add("20160517_SharedPreference.Editor的apply和commit方法异同");
        data1.add("20160513_Android属性动画的基本用法");
        data1.add("20160511_创业技术入股三步曲：入股估值、签订合同、工商变更");
        data1.add("20160510_上海国际商品拍卖有限公司劲标网");
        data1.add("20160510_上海车牌拍卖规则");
        data1.add("20160504_如何获取Android手机的wifi热点的加密类型");
        data1.add("20160504_WiFi加密方式");
        data1.add("20160503_Android中Video的三种播放方式的实现");
        data1.add("20160426_Android中的RectF类和PointF类");
        data1.add("20160426_Activity引入从上滑入和往上滑出的动画");
        data1.add("20160426_ android - anim translate中 fromXDelta、toXDelta、fromYDelta、toXDelta属性");
        data1.add("20160421_在代码中修改TextView的DrawableRight图片");
        data1.add("20160418_java自带线程池和队列");
        data1.add("20160418_Java 实例 - 队列（Queue）用法");
        data1.add("20160418_Android消息队列模型——Thread,Handler,Looper,Massage Queue");
        data1.add("20160415_Android禁止自动锁屏");

        final KnowledgeAdatper adatper1 = new KnowledgeAdatper(getActivity(),data1);
        this.listView.setAdapter(adatper1);
    }
    private void findViewById() {
        listView = (ListView) getActivity().findViewById(R.id.listview_knowledge);
    }

    private class KnowledgeAdatper extends BaseAdapter {
        LayoutInflater inflater;
        private List<String> list;

        public KnowledgeAdatper(Context context, List<String> list) {
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
            TextView textView;
            if (null == convertView){
                convertView = inflater.inflate(R.layout.listitem_knowledge, parent, false);
            }
            textView = (TextView) convertView.findViewById(R.id.textview_title);

            textView.setText(list.get(position));
            return convertView;
        }
    }
}
