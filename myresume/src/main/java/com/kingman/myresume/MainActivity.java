package com.kingman.myresume;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final int CONTAINER = R.id.realtabcontent;

    public static final String TAB0_PROJECT = "ProjectFragment";
    public static final String TAB1_COMPANY = "CompanyFragment";
    public static final String TAB2_COMMENT = "CommentFragment";
    public static final String TAB3_KNOWLEDGE = "KnowledgeFragment";
    public static final String TAB4_ME = "MeFragment";

    public TabHost mTabHost;
    private ProjectFragment mProjectFragment;
    private CompanyFragment mCompanyFragment;
    private CommentFragment mCommentFragment;
    private KnowledgeFragment mKnowledgeFragment;
    private MeFragment mMeFragment;

    private int mCurrTab;

    private FragmentManager mFragmentManager;

    private Context mContext;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mFragmentManager = getFragmentManager();

        initTab();
    }

    private void initTab() {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mTabHost.setOnTabChangedListener(mTabChangeListener);

        TabHost.TabSpec spec0 = mTabHost.newTabSpec(TAB0_PROJECT);
        spec0.setIndicator(getTabIndicator("Project", R.drawable.btn_tab_project));
        spec0.setContent(new DummyTabContent(mContext));
        mTabHost.addTab(spec0);

        TabHost.TabSpec spec1 = mTabHost.newTabSpec(TAB1_COMPANY);
        spec1.setIndicator(getTabIndicator("Company", R.drawable.btn_tab_company));
        spec1.setContent(new DummyTabContent(mContext));
        mTabHost.addTab(spec1);

        TabHost.TabSpec spec2 = mTabHost.newTabSpec(TAB2_COMMENT);
        spec2.setIndicator(getTabIndicator("Comment", R.drawable.btn_tab_comment));
        spec2.setContent(new DummyTabContent(mContext));
        mTabHost.addTab(spec2);

        TabHost.TabSpec spec3 = mTabHost.newTabSpec(TAB3_KNOWLEDGE);
        spec3.setIndicator(getTabIndicator("Knowledge", R.drawable.btn_tab_knowledge));
        spec3.setContent(new DummyTabContent(mContext));
        mTabHost.addTab(spec3);

        TabHost.TabSpec spec4 = mTabHost.newTabSpec(TAB4_ME);
        spec4.setIndicator(getTabIndicator("Me", R.drawable.btn_tab_me));
        spec4.setContent(new DummyTabContent(mContext));
        mTabHost.addTab(spec4);
    }

    private View getTabIndicator(String name, int resId) {
        View v = getLayoutInflater().inflate(R.layout.item_tabhost, null);
        TextView tv = (TextView) v.findViewById(R.id.tv_item_tabhost_name);
        tv.setText("" + name);
        ImageView iv = (ImageView) v.findViewById(R.id.iv_item_tabhost_icon);
        iv.setImageResource(resId);
        return v;
    }

    public void startFragment(Fragment targetF) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(
                android.R.animator.fade_in,
                android.R.animator.fade_out
        );
        ft.replace(MainActivity.CONTAINER, targetF);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void finishFragment() {
        mFragmentManager.popBackStack();
    }

    private void transTab0(FragmentTransaction transaction) {
        if (mProjectFragment == null) {
            transaction.add(R.id.realtabcontent, new ProjectFragment(), TAB0_PROJECT);
        } else {
            transaction.attach(mProjectFragment);
        }
    }

    private void transTab1(FragmentTransaction transaction) {
        if (mCompanyFragment == null) {
            transaction.add(R.id.realtabcontent, new CompanyFragment(), TAB1_COMPANY);
        } else {
            transaction.attach(mCompanyFragment);
        }
    }

    private void transTab2(FragmentTransaction transaction) {
        if (mCommentFragment == null) {
            transaction.add(R.id.realtabcontent, new CommentFragment(), TAB2_COMMENT);
        } else {
            transaction.attach(mCommentFragment);
        }
    }

    private void transTab3(FragmentTransaction transaction) {
        if (mKnowledgeFragment == null) {
            transaction.add(R.id.realtabcontent, new KnowledgeFragment(), TAB3_KNOWLEDGE);
        } else {
            transaction.attach(mKnowledgeFragment);
        }
    }

    private void transTab4(FragmentTransaction transaction) {
        if (mMeFragment == null) {
            transaction.add(R.id.realtabcontent, new MeFragment(), TAB4_ME);
        } else {
            transaction.attach(mMeFragment);
        }
    }

    private TabHost.OnTabChangeListener mTabChangeListener = new TabHost.OnTabChangeListener() {

        @Override
        public void onTabChanged(String tabId) {
            mFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

            mProjectFragment = (ProjectFragment) mFragmentManager.findFragmentByTag(TAB0_PROJECT);
            mCompanyFragment = (CompanyFragment) mFragmentManager.findFragmentByTag(TAB1_COMPANY);
            mCommentFragment = (CommentFragment) mFragmentManager.findFragmentByTag(TAB2_COMMENT);
            mKnowledgeFragment = (KnowledgeFragment) mFragmentManager.findFragmentByTag(TAB3_KNOWLEDGE);
            mMeFragment = (MeFragment) mFragmentManager.findFragmentByTag(TAB4_ME);

            FragmentTransaction transaction = mFragmentManager.beginTransaction();

            if (mProjectFragment != null) {
                transaction.detach(mProjectFragment);
            }

            if (mCompanyFragment != null) {
                transaction.detach(mCompanyFragment);
            }

            if (mCommentFragment != null) {
                transaction.detach(mCommentFragment);
            }

            if (mKnowledgeFragment != null) {
                transaction.detach(mKnowledgeFragment);
            }

            if (mMeFragment != null) {
                transaction.detach(mMeFragment);
            }

            if (tabId.equals(TAB0_PROJECT)) {
                transTab0(transaction);
            } else if (tabId.equals(TAB1_COMPANY)) {
                transTab1(transaction);
            } else if (tabId.equals(TAB2_COMMENT)) {
                transTab2(transaction);
            } else if (tabId.equals(TAB3_KNOWLEDGE)) {
                transTab3(transaction);
            } else if (tabId.equals(TAB4_ME)) {
                transTab4(transaction);
            }
            transaction.commitAllowingStateLoss();
            mCurrTab = mTabHost.getCurrentTab();
        }
    };

    public static class DummyTabContent implements TabHost.TabContentFactory {
        private Context mContext;

        public DummyTabContent(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String s) {
            View v = new View(mContext);
            return v;
        }
    }
}

