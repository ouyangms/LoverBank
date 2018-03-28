package com.tpv.lovetinylazpig;

import android.support.v4.app.Fragment;

import com.tpv.lovetinylazpig.chat.ui.ChatFragment;
import com.tpv.lovetinylazpig.lovingtime.ui.LovingTimeFragment;
import com.tpv.lovetinylazpig.home.ui.HomeFragment;

/**get fragment by id
 * Created by loyouyang on 3/22/18.
 */

public class FragmentFactory {
    public static Fragment newFragmentInstance(int id){
        Fragment newFragment;
        switch (id){
            case R.id.main_activity_navigation_menu_home:
                newFragment = new HomeFragment();
                break;

            case R.id.main_activity_navigation_menu_chat:
                newFragment = new ChatFragment();
                break;

            case R.id.main_activity_navigation_menu_time:
                newFragment = new LovingTimeFragment();
                break;

            default:
                newFragment = new Fragment();

        }
        return newFragment;
    }
}
