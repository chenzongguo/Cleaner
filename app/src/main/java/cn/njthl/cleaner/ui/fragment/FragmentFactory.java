package cn.njthl.cleaner.ui.fragment;

/**
 * @创建者 CSDN_LQR
 * @描述 主界面4个Fragment工厂
 */
public class FragmentFactory {

    static FragmentFactory mInstance;

    private FragmentFactory() {
    }

    public static FragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (FragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new FragmentFactory();
                }
            }
        }
        return mInstance;
    }

    private HomePageFragment mHomePageFragment;
    private OrderAllocationFragment mOrderAllocationFragment;
    private OrderManageFragment mOrderManageFragment;
    private MeFragment mMeFragment;

    public HomePageFragment getHomePageFragment() {
        if (mHomePageFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mHomePageFragment == null) {
                    mHomePageFragment = new HomePageFragment();
                }
            }
        }
        return mHomePageFragment;
    }

    public OrderAllocationFragment getOrderAllocationFragment() {
        if (mOrderAllocationFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mOrderAllocationFragment == null) {
                    mOrderAllocationFragment = new OrderAllocationFragment();
                }
            }
        }
        return mOrderAllocationFragment;
    }

    public OrderManageFragment getOrderManageFragment() {
        if (mOrderManageFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mOrderManageFragment == null) {
                    mOrderManageFragment = new OrderManageFragment();
                }
            }
        }
        return mOrderManageFragment;
    }

    public MeFragment getMeFragment() {
        if (mMeFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                }
            }
        }
        return mMeFragment;
    }
}
